package softUniExam.coffeeShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softUniExam.coffeeShop.model.entity.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByUsernameAndPassword(String username,String password);
    @Query("Select u From UserEntity u Order By size(u.orders) DESC")
    List<UserEntity>findAllByOrdersCountDescending();
}
