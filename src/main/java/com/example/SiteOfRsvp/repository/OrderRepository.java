package com.example.SiteOfRsvp.repository;

import com.example.SiteOfRsvp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    boolean existsByPlatformOrderId(String id);
}
