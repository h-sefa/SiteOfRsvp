package com.example.SiteOfRsvp.repository;

import com.example.SiteOfRsvp.entity.Rsvp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RsvpRepository extends JpaRepository<Rsvp, Long> {
}
