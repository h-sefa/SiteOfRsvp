package com.example.SiteOfRsvp.controller;

import com.example.SiteOfRsvp.dto.DashboardDataDto;
import com.example.SiteOfRsvp.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/me")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }


    //Dönüş tipi değişecek
    @GetMapping("/{title}")
    public DashboardDataDto getDashboardData(@PathVariable("title") String title ){


        return dashboardService.getDashboardData(title);
    }
}
