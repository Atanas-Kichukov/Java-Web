package BattleShips.softUni.repository;

import BattleShips.softUni.model.entity.UserEntity;
import BattleShips.softUni.model.service.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {


    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

}
