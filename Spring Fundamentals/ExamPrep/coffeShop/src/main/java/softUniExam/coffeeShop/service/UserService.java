package softUniExam.coffeeShop.service;

import softUniExam.coffeeShop.model.entity.UserEntity;
import softUniExam.coffeeShop.model.service.UserServiceModel;
import softUniExam.coffeeShop.model.view.UserViewModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    UserEntity findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrdersByCountDescending();
}
