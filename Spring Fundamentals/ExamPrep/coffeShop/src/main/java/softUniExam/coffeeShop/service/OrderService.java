package softUniExam.coffeeShop.service;

import softUniExam.coffeeShop.model.service.OrderServiceModel;
import softUniExam.coffeeShop.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findOrderByPriceDesc();

    void readyOrder(Long id);
}
