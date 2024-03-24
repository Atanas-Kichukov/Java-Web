package BattleShips.softUni.web;

import BattleShips.softUni.model.binding.ShipFireBindingModel;
import BattleShips.softUni.sec.CurrentUser;
import BattleShips.softUni.service.ShipService;
import BattleShips.softUni.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ShipService shipService;

    public HomeController(CurrentUser currentUser, UserService userService, ShipService shipService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.shipService = shipService;
    }

    @GetMapping()
    public String index(Model model){
        if(currentUser.getId() != null){
            model.addAttribute("attackerShips", userService.getAllLoggedInUserShips());
            model.addAttribute("defenderShips",shipService.getAllOtherUsersShips(currentUser.getId()));
            model.addAttribute("allShips", this.shipService.findAllShipsOrderedById());
            return "home";
        }
        return "index";
    }
    @ModelAttribute
    public ShipFireBindingModel shipFireBindingModel(){
        return new ShipFireBindingModel();
    }
}
