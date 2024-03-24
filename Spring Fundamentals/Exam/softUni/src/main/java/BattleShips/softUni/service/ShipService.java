package BattleShips.softUni.service;

import BattleShips.softUni.model.binding.ShipFireBindingModel;
import BattleShips.softUni.model.entity.ShipEntity;
import BattleShips.softUni.model.service.ShipAddServiceModel;

import java.util.List;

public interface ShipService {
    void addShip(ShipAddServiceModel shipAddServiceModel);

    void fire(ShipFireBindingModel shipFireBindingModel);

    List<String> getAllOtherUsersShips(Long id);

    List<ShipEntity> findAllShipsOrderedById();
}
