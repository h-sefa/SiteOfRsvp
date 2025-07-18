package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.dto.OrderDto;
import com.example.SiteOfRsvp.dto.OrderResponseDto;
import com.example.SiteOfRsvp.entity.Order;
import com.example.SiteOfRsvp.mappers.OrderMapper;
import com.example.SiteOfRsvp.mappers.OrderResponseMapper;
import com.example.SiteOfRsvp.mappers.UserMapper;
import com.example.SiteOfRsvp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderMapper orderMapper;
    private OrderResponseMapper orderResponseMapper;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, OrderResponseMapper orderResponseMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.orderResponseMapper = orderResponseMapper;
    }

    @Override
    public OrderResponseDto save(OrderDto orderDto) {
        Order newOrder = orderMapper.toEntity(orderDto);
        Order savedOrder = orderRepository.save(newOrder);
        return orderResponseMapper.toDto(savedOrder);


    }

    @Override
    public List<OrderResponseDto> getOrders() {


       List<Order> orders = orderRepository.findAll();

        return orders.stream().map(order -> orderResponseMapper.toDto(order)).collect(Collectors.toList());
    }

    @Override
    public OrderResponseDto getOrderById(Long id) {

        Optional<Order> foundedOrder =  orderRepository.findById(id);
        if(foundedOrder.isPresent()){
            return orderResponseMapper.toDto(foundedOrder.get());
        }

        // Hata mekanizması eklenecek.
        throw new RuntimeException("Order not found");

    }

    @Override
    public OrderResponseDto deleteById(Long id) {

        Order deletedEntity = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found Entity with id: " + id));
        OrderResponseDto deletedEntityDto = orderResponseMapper.toDto(deletedEntity);
        orderRepository.deleteById(id);
        return deletedEntityDto;
    }


}
