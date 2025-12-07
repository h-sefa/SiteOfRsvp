package com.example.SiteOfRsvp.controller;

import com.example.SiteOfRsvp.dto.EventRsvpFieldDto;
import com.example.SiteOfRsvp.dto.EventRsvpFieldResponseDto;
import com.example.SiteOfRsvp.dto.RsvpFormFieldsDto;
import com.example.SiteOfRsvp.dto.RsvpRequestDto;
import com.example.SiteOfRsvp.response.ApiResponse;
import com.example.SiteOfRsvp.service.EventService;
import com.example.SiteOfRsvp.service.EventServiceImpl;
import com.example.SiteOfRsvp.service.RsvpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rsvp")
public class RsvpController {

    private RsvpService rsvpService;

    public RsvpController(RsvpService rsvpService) {
        this.rsvpService = rsvpService;
    }


    //Davetlilerin rsvp ye cevap vermek için istek attığı(girdiği) endpoint
    @GetMapping("/{title}")
    public List<EventRsvpFieldResponseDto> getAllFieldsForThatRsvp(@PathVariable String title){

        return rsvpService.getAllFieldsThatRsvp(title);
    }



    @PostMapping("/{eventTitle}")
  public ResponseEntity<ApiResponse> saveResponse(@PathVariable String eventTitle, @RequestBody RsvpRequestDto rsvpRequestDto){

        rsvpService.saveRsvp(eventTitle, rsvpRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(true, "Kayıt başarılı bir şekilde ouşturuldu."));


    }


}
