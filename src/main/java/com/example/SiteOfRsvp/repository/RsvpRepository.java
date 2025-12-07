package com.example.SiteOfRsvp.repository;

import com.example.SiteOfRsvp.entity.Rsvp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RsvpRepository extends JpaRepository<Rsvp, UUID> {
}
