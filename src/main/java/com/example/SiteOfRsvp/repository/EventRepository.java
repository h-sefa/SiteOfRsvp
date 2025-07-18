package com.example.SiteOfRsvp.repository;

import com.example.SiteOfRsvp.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

     Optional<Event> findEventByTitle(String title);

}
