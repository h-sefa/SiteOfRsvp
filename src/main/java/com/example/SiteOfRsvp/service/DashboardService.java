package com.example.SiteOfRsvp.service;

import com.example.SiteOfRsvp.dto.DashboardDataDto;

public interface DashboardService {

    //Dönüş tipi değişecek
    DashboardDataDto getDashboardData(String title);
}
