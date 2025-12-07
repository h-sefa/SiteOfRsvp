package com.example.SiteOfRsvp.service;


import com.example.SiteOfRsvp.dto.DashboardDataDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DashboardServiceImpl implements DashboardService{

    private final EventService eventService;

    public DashboardServiceImpl(EventService eventService) {
        this.eventService = eventService;
    }

    //Dönüş tipi değişecek
    @Override
    public DashboardDataDto getDashboardData(String title) {



        return eventService.forDashboardData(title);
    }
}
