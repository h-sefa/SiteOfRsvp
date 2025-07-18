package com.example.SiteOfRsvp.repository;

import com.example.SiteOfRsvp.entity.EventRsvpField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRsvpFieldRepository extends JpaRepository<EventRsvpField, Long> {
    Optional<EventRsvpField> findByLabel(String label);

}
