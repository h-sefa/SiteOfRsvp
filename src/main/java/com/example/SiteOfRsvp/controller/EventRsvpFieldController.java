package com.example.SiteOfRsvp.controller;

import com.example.SiteOfRsvp.dto.EventRsvpFieldDto;
import com.example.SiteOfRsvp.dto.EventRsvpFieldResponseDto;
import com.example.SiteOfRsvp.entity.EventRsvpField;
import com.example.SiteOfRsvp.service.EventRsvpFieldService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//SADECE ADMIN ICIN OLACAK

@RestController
@RequestMapping("/event-fields")
public class EventRsvpFieldController {

    private final EventRsvpFieldService eventRsvpFieldService;

    public EventRsvpFieldController(EventRsvpFieldService eventRsvpFieldService) {
        this.eventRsvpFieldService = eventRsvpFieldService;
    }

    @GetMapping
    public ResponseEntity<List<EventRsvpFieldResponseDto>> getRsvpFields(){

        List<EventRsvpFieldResponseDto> rsvpFields = eventRsvpFieldService.getRsvpFields();


        return ResponseEntity.status(HttpStatus.OK).body(rsvpFields);

        /*
        throw exception
         */

    }

    @GetMapping("/{id}")
    public ResponseEntity<EventRsvpFieldResponseDto> getRsvpFieldById(@PathVariable Long id){

        EventRsvpFieldResponseDto rsvpFieldById = eventRsvpFieldService.getRsvpFieldById(id);


        return ResponseEntity.status(HttpStatus.OK).body(rsvpFieldById);
    }

    @PostMapping("/add")
    public ResponseEntity<EventRsvpFieldResponseDto> saveRsvpField(@RequestBody EventRsvpFieldDto eventRsvpFieldDto){

        EventRsvpFieldResponseDto eventRsvpFieldResponseDto = eventRsvpFieldService.saveRsvpField(eventRsvpFieldDto);
//        EventRsvpFieldResponseDto eventRsvpFieldResponseDto = new EventRsvpFieldResponseDto();

        return ResponseEntity.status(HttpStatus.CREATED).body(eventRsvpFieldResponseDto);
    }

    @PostMapping("/multiadd")
    public ResponseEntity<List<EventRsvpFieldResponseDto>> saveMultiFields(@RequestBody List<EventRsvpFieldDto> fields){


        List<EventRsvpFieldResponseDto> addedFields =eventRsvpFieldService.saveRsvpField(fields);
        return ResponseEntity.status(HttpStatus.OK).body(addedFields);
    }


    @PutMapping("/{id}")
    public ResponseEntity<EventRsvpFieldResponseDto> updateRsvpField(@RequestBody EventRsvpFieldDto eventRsvpFieldDto, @PathVariable Long id){


        return ResponseEntity.status(HttpStatus.CREATED).body(eventRsvpFieldService.updateRsvpField(eventRsvpFieldDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventRsvpFieldResponseDto> deleteRsvpField(@PathVariable Long id){

        EventRsvpFieldResponseDto eventRsvpFieldResponseDto = eventRsvpFieldService.deleteRsvpField(id);


        return ResponseEntity.status(HttpStatus.CREATED).body(eventRsvpFieldResponseDto);
    }
}
