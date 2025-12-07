package com.example.SiteOfRsvp.repository;

import com.example.SiteOfRsvp.entity.EventRsvpFieldMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EventRsvpFieldMappingRepository extends JpaRepository<EventRsvpFieldMapping, UUID> {

}
