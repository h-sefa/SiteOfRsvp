package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.dto.OrderDto;
import com.example.SiteOfRsvp.dto.OrderResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderService {

    OrderResponseDto save(OrderDto orderDto);


    List<OrderResponseDto> getOrders();

    OrderResponseDto getOrderById(Long id);

    OrderResponseDto deleteById(Long id);

//    OrderResponseDto updateByOrderId(OrderDto orderDto,Long id);
}
