package softUniExam.coffeeShop.web;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softUniExam.coffeeShop.model.binding.OrderAddBindingModel;
import softUniExam.coffeeShop.model.service.OrderServiceModel;
import softUniExam.coffeeShop.service.OrderService;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final ModelMapper modelMapper;

    public OrderController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(){
        return "order-add";
    }
    @PostMapping("/add")
    public String addConfirm(@Valid OrderAddBindingModel orderAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("orderAddBindingModel",orderAddBindingModel);
            redirectAttributes.addFlashAttribute("orderAddBindingModel",bindingResult);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel", bindingResult);

            return "redirect:add";
        }
        orderService.addOrder(modelMapper.map(orderAddBindingModel, OrderServiceModel.class));



        return "redirect:/";
    }
    @GetMapping("/ready{id}")
    public String ready(@PathVariable Long id){
        orderService.readyOrder(id);
        return "redirect:/";
    }
    @ModelAttribute
    public OrderAddBindingModel orderAddBindingModel(){
        return new OrderAddBindingModel();
    }

}
