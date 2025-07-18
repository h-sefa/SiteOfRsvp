package com.example.SiteOfRsvp.repository;

import com.example.SiteOfRsvp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
