package softUniExam.coffeeShop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softUniExam.coffeeShop.model.view.OrderViewModel;
import softUniExam.coffeeShop.sec.CurrentUser;
import softUniExam.coffeeShop.service.OrderService;
import softUniExam.coffeeShop.service.UserService;

import java.util.List;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final OrderService orderService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (currentUser.getId() == null) {
            return "index";

        }
        List<OrderViewModel> orders = orderService.findOrderByPriceDesc();
        model.addAttribute("orders", orders);
        model.addAttribute("totalTime", orders.stream()
                .map(orderViewModel -> orderViewModel.getCategory().getNeededTime())
                .reduce(Integer::sum)
                .orElse(null));

        model.addAttribute("users",userService.findAllUserAndCountOfOrdersByCountDescending());


        return "home";


    }


}
