package BattleShips.softUni.service.Impl;

import BattleShips.softUni.model.entity.ShipEntity;
import BattleShips.softUni.model.entity.UserEntity;
import BattleShips.softUni.model.service.UserServiceModel;
import BattleShips.softUni.repository.UserRepository;
import BattleShips.softUni.sec.CurrentUser;
import BattleShips.softUni.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password)
                .map(userEntity -> modelMapper.map(userEntity, UserServiceModel.class))
                .orElse(null);


    }

    @Override
    public void login(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public UserEntity getLoggedInUser() {
        return userRepository.findById(currentUser.getId()).orElse(null);
    }

    @Override
    public List<String> getAllLoggedInUserShips() {

        UserEntity userEntity = getLoggedInUser();
        return userEntity.getShips()
                .stream()
                .map(ShipEntity::getName)
                .collect(Collectors.toList());
    }
}
