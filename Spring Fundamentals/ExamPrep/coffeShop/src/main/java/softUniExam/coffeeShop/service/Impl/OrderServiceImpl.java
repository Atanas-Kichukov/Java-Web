package softUniExam.coffeeShop.service.Impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softUniExam.coffeeShop.model.entity.OrderEntity;
import softUniExam.coffeeShop.model.service.OrderServiceModel;
import softUniExam.coffeeShop.model.view.OrderViewModel;
import softUniExam.coffeeShop.repository.OrderRepository;
import softUniExam.coffeeShop.sec.CurrentUser;
import softUniExam.coffeeShop.service.CategoryService;
import softUniExam.coffeeShop.service.OrderService;
import softUniExam.coffeeShop.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        OrderEntity order = modelMapper.map(orderServiceModel, OrderEntity.class);
        order.setEmployee(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByCategoryEnum(orderServiceModel.getCategory()));

        orderRepository.save(order);
    }

    @Override
    public List<OrderViewModel> findOrderByPriceDesc() {

        return orderRepository.findAllByOrderByPriceDesc()
                .stream()
                .map(orderEntity -> modelMapper.map(orderEntity, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
