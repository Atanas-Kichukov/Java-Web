package softUniExam.coffeeShop.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softUniExam.coffeeShop.model.entity.UserEntity;
import softUniExam.coffeeShop.model.service.UserServiceModel;
import softUniExam.coffeeShop.model.view.UserViewModel;
import softUniExam.coffeeShop.repository.UserRepository;
import softUniExam.coffeeShop.sec.CurrentUser;
import softUniExam.coffeeShop.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
    UserEntity user = modelMapper.map(userServiceModel,UserEntity.class);


    return modelMapper.map(userRepository.save(user), UserServiceModel.class);




    }

    @Override
    public UserServiceModel findUsernameAndPassword(String username, String password) {

        return userRepository
                .findByUsernameAndPassword(username,password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public UserEntity findById(Long id) {

        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserViewModel> findAllUserAndCountOfOrdersByCountDescending() {
        return userRepository.findAllByOrdersCountDescending()
                .stream()
                .map(userEntity -> {
                    UserViewModel userViewModel = new UserViewModel();
                    userViewModel.setUsername(userEntity.getUsername());
                    userViewModel.setOrderCount(userEntity.getOrders().size());
                    return userViewModel;
                }).collect(Collectors.toList());

    }
}
