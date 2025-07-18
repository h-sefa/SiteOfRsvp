package com.example.SiteOfRsvp.controller;

import com.example.SiteOfRsvp.dto.OrderDto;
import com.example.SiteOfRsvp.dto.OrderResponseDto;
import com.example.SiteOfRsvp.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getOrders(){

        List<OrderResponseDto> listOfOrders = orderService.getOrders();

        return ResponseEntity.status(HttpStatus.OK).body(listOfOrders);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> findOrderById(@PathVariable Long id) {



        OrderResponseDto foundedOrder = orderService.getOrderById(id);
        return ResponseEntity.status(HttpStatus.OK).body(foundedOrder);
    }

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderDto orderDto){

        OrderResponseDto savedOrderDto = orderService.save(orderDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrderDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderResponseDto> deleteOrderById(@PathVariable Long id){

        OrderResponseDto deletedOrder = orderService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(deletedOrder);

    }




}