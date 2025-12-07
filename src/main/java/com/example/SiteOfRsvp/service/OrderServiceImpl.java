package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.dto.OrderDto;
import com.example.SiteOfRsvp.dto.OrderResponseDto;
import com.example.SiteOfRsvp.entity.Order;
import com.example.SiteOfRsvp.entity.User;
import com.example.SiteOfRsvp.exception.ExistEmailException;
import com.example.SiteOfRsvp.exception.ExistPlatformOrderId;
import com.example.SiteOfRsvp.exception.ResourceNotFoundException;
import com.example.SiteOfRsvp.mappers.OrderMapper;
import com.example.SiteOfRsvp.mappers.OrderResponseMapper;
import com.example.SiteOfRsvp.mappers.UserMapper;
import com.example.SiteOfRsvp.repository.OrderRepository;
import com.example.SiteOfRsvp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderMapper orderMapper;
    private OrderResponseMapper orderResponseMapper;
    private UserRepository userRepository;
    private UserService userService;
    private UserMapper userMapper;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, OrderResponseMapper orderResponseMapper, UserRepository userRepository, UserService userService, UserMapper userMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.orderResponseMapper = orderResponseMapper;
        this.userRepository = userRepository;
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public OrderResponseDto save(OrderDto orderDto) {

            //Burada kayıt edilen  order bilgilerinin kotrolunun yapılması lazım.
            //Sonradan (en son) platform id kontrolu yapılacak
            // User var mı kontrolu yapılması lazım. Varsa
            //Entity yapısı örnek
            /*

                    private Long id;
                    private String platforderId;mOr
                    private String  details;
                    private User user;
                    private Event event;

             */

       User user = userService.registerUserforOrderService(orderDto.getUser());


            Order newOrder = orderMapper.toEntity(orderDto);
            newOrder.getUser().setPassword(user.getPassword());
            newOrder.getUser().setRole(user.getRole());

            if(orderRepository.existsByPlatformOrderId(newOrder.getPlatformOrderId())){
                throw new ExistPlatformOrderId("Platform Order Id " + newOrder.getPlatformOrderId() + " already exists. Please use valid platform order ID.");
            }

            if(userRepository.existsByEmail(newOrder.getUser().getEmail())){
                throw new ExistEmailException("Email already exists " + newOrder.getUser().getEmail());
            }
            Order savedOrder = orderRepository.save(newOrder);
            return orderResponseMapper.toDto(savedOrder);

    }

    @Override
    public List<OrderResponseDto> getOrders() {


        try {
            List<Order> orders = orderRepository.findAll();

            return orders.stream().map(order -> orderResponseMapper.toDto(order)).collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }

    }

    @Override
    public OrderResponseDto getOrderById(UUID id) {

        Order foundedOrder = orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not found order with orderId " + id));

        return orderResponseMapper.toDto(foundedOrder);


    }

    @Override
    public OrderResponseDto deleteById(UUID id) {

        Order deletedEntity = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Deletion failed: No entity found with ID : " + id));
        OrderResponseDto deletedEntityDto = orderResponseMapper.toDto(deletedEntity);
        orderRepository.deleteById(id);
        return deletedEntityDto;
    }


}
