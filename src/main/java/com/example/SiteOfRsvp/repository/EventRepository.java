package com.example.SiteOfRsvp.repository;

import com.example.SiteOfRsvp.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {
     @Query(
             """
             SELECT DISTINCT e FROM Event e
             LEFT JOIN FETCH e.order o
             LEFT JOIN FETCH e.rsvpList r
             WHERE e.title = :title
             """)
     Optional<Event> findEventWithOrderAndRsvpByTitle(@Param("title") String title);

     Optional<Event> findEventByTitle(String title);

     @Query("Select e From Event e where e.isPublished = true")
     List<Event> findActiveEvents();

     @Query("Select e From Event e where e.isPublished = false")
     List<Event> findInactiveEvents();

     @Query("SELECT e FROM Event e LEFT JOIN FETCH e.order WHERE e.title = :title")
     Optional<Event> findEventWithOrderByTitle(@Param("title") String title);

     @Query("SELECT e FROM Event e LEFT JOIN FETCH e.rsvpList WHERE e.title = :title")
     Optional<Event> findEventWithRsvpListByTitle(@Param("title") String title);


}

//Order -> platformOrderId
//Event -> (title) rsvpList ilişki rsvp ile
//
