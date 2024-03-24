package BattleShips.softUni.service;

import BattleShips.softUni.model.entity.UserEntity;
import BattleShips.softUni.model.service.UserServiceModel;

import java.util.List;

public interface UserService {
    UserServiceModel findByUsernameAndPassword(String username, String password);

    void login(Long id, String username);

    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserEntity getLoggedInUser();

    List<String> getAllLoggedInUserShips();
}
