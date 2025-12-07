package com.example.SiteOfRsvp.repository;

import com.example.SiteOfRsvp.entity.RsvpAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RsvpAnswerRepository extends JpaRepository<RsvpAnswer, UUID> {
}
