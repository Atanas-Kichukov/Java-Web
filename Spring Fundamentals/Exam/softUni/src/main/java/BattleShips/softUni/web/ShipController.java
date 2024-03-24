package BattleShips.softUni.web;

import BattleShips.softUni.model.binding.ShipAddBindingModel;
import BattleShips.softUni.model.binding.ShipFireBindingModel;
import BattleShips.softUni.model.service.ShipAddServiceModel;
import BattleShips.softUni.service.ShipService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShipController {
    private final ShipService shipService;
    private final ModelMapper modelMapper;

    public ShipController(ShipService shipService, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("ships/add")
    public String addShip(){
        return "ship-add";
    }
    @PostMapping("/ships/add")
    public String addConfirm(@Valid ShipAddBindingModel shipAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("shipAddBindingModel",shipAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel", bindingResult);
            return "redirect:/ships/add";
        }

        shipService.addShip(modelMapper.map(shipAddBindingModel, ShipAddServiceModel.class));

            return "redirect:/";
    }
    @PostMapping("ships/fire")
    public String fire(ShipFireBindingModel shipFireBindingModel){
        shipService.fire(shipFireBindingModel);

        return "redirect:/";
    }
    @ModelAttribute
    public ShipAddBindingModel shipAddBindingModel(){
        return new ShipAddBindingModel();
    }
}
