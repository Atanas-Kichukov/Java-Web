package softUniExam.coffeeShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softUniExam.coffeeShop.model.entity.OrderEntity;

import java.util.List;

@Repository
public interface OrderRepository  extends JpaRepository<OrderEntity,Long> {


    List<OrderEntity> findAllByOrderByPriceDesc();
}
