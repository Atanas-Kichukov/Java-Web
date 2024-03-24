package BattleShips.softUni.service.Impl;

import BattleShips.softUni.model.binding.ShipFireBindingModel;
import BattleShips.softUni.model.entity.ShipEntity;
import BattleShips.softUni.model.service.ShipAddServiceModel;
import BattleShips.softUni.repository.ShipRepository;
import BattleShips.softUni.service.CategoryService;
import BattleShips.softUni.service.ShipService;
import BattleShips.softUni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CategoryService categoryService;
    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, UserService userService, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addShip(ShipAddServiceModel shipAddServiceModel) {
        ShipEntity shipEntity = modelMapper.map(shipAddServiceModel,ShipEntity.class);
        shipEntity.setUser(userService.getLoggedInUser());
        shipEntity.setCategory(categoryService.findByCategoryNameEnum(shipAddServiceModel.getCategory()));
        shipRepository.save(shipEntity);
    }

    @Override
    public void fire(ShipFireBindingModel shipFireBindingModel) {
         ShipEntity attacker = shipRepository.findByName(shipFireBindingModel.getAttacker()).orElse(null);
         ShipEntity defender = shipRepository.findByName(shipFireBindingModel.getDefender()).orElse(null);

        if(attacker == null || defender == null){
            return;
        }
        defender.setHealth(defender.getHealth() - attacker.getPower());
        if (defender.getHealth()<= 0){
            shipRepository.delete(defender);
        }
        else{
            shipRepository.save(defender);
        }

    }

    @Override
    public List<String> getAllOtherUsersShips(Long id) {
        return shipRepository.findAllShipNamesWithIdDifferentFrom(id);
    }

    @Override
    public List<ShipEntity> findAllShipsOrderedById() {
        return shipRepository.findAllShipsOrderedById();
    }
}
