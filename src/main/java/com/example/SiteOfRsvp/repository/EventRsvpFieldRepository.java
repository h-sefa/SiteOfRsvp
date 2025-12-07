package com.example.SiteOfRsvp.repository;

import com.example.SiteOfRsvp.entity.EventRsvpField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EventRsvpFieldRepository extends JpaRepository<EventRsvpField, UUID> {
    Optional<EventRsvpField> findByLabel(String label);

}
