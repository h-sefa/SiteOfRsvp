package com.example.SiteOfRsvp.mappers;


import com.example.SiteOfRsvp.dto.DashboardDataDto;
import com.example.SiteOfRsvp.dto.EventDto;
import com.example.SiteOfRsvp.dto.EventResponseDto;
import com.example.SiteOfRsvp.dto.RsvpDto;
import com.example.SiteOfRsvp.entity.Event;
import com.example.SiteOfRsvp.entity.Rsvp;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface EventResponseMapper {

    @Mapping(source = "title", target ="title")
    @Mapping(source = "expiresAt", target  ="expiresAt")
    @Mapping(source = "isPublished", target  ="isPublished")
    @Mapping(source = "fieldMappings", target  ="fieldMappings")
    EventResponseDto toDto(Event event);

    @Mapping(source = "title", target = "eventTitle")
    @Mapping(source ="isPublished", target ="published")
    @Mapping(source = "expiresAt", target = "rsvpExpirationDate")
    @Mapping(source = "rsvpList", target = "rsvpList", qualifiedByName = "mapRsvpList")
    @Mapping(target = "platformOrderId", expression = "java(event.getOrder() != null ? event.getOrder().getPlatformOrderId() : null)")
    DashboardDataDto toDashboardDataDto(Event event);

    @Named("mapRsvpList")
    public static List<RsvpDto> mapRsvpList(List<Rsvp> rsvps) {
        if (rsvps == null) return null;
        return rsvps.stream()
                .map(r -> new RsvpDto(
                        r.getId(),
                        r.getGuestName(),
                        r.getEvent().getTitle() // sadece title veriyoruz, Event değil
                ))
                .collect(Collectors.toList());
    }
}



