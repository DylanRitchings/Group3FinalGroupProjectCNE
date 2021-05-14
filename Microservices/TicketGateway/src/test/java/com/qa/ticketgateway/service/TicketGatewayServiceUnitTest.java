package com.qa.ticketgateway.service;


import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import org.springframework.web.client.RestTemplate;


import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;



@WebMvcTest(TicketGatewayService.class)
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
public class TicketGatewayServiceUnitTest {
//
//    @Autowired
//    private TicketGatewayService service;
//
//    @MockBean
//    private RestTemplate rest;
//
//    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);
//    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false, "This is a new solution", "Medium", "Cohort2");
//    private final Ticket TICKET2 = new Ticket(2L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd", false, "This is a new solution", "Medium", "Cohort2" );
//    private final Ticket TICKET1_CHANGE = new Ticket(1L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd", true, "This is a new solution", "Medium", "Cohort2");
//
//    private final Ticket[] TICKETS_LIST = {TICKET1,TICKET2};
//
//    @BeforeEach
//    void setup() {
//        service = new TicketGatewayService(rest);
//        System.setProperty("service.read-all", "https://read-all-tickets-api/");
//    }
//
//    @Test
//    void testReadById(){
//        System.setProperty("service.read-all", "https://read-all-tickets-api/");
//        System.out.println("https://read-ticket-api/"+TICKET1.getId());
//        when(this.rest.getForObject("https://read-ticket-api/"+TICKET1.getId(),Ticket.class))
//                .thenReturn(TICKET1);
//        assertThat(this.service.readById(TICKET1.getId())).isEqualTo(TICKET1);
//        verify(this.rest, times(1)).getForObject("https://read-ticket-api/"+TICKET1.getId(),Ticket.class);
//    }
//
//    @Test
//    void testReadAll(){
//        when(this.rest.getForObject("https://read-all-tickets-api/",Ticket[].class))
//                .thenReturn(TICKETS_LIST);
//        assertThat(this.service.readAll()).isEqualTo(TICKETS_LIST);
//        verify(this.rest, times(1)).getForObject("https://read-all-tickets-api/",Ticket[].class);
//    }
//
//    @Test
//    void testCreateById(){
//        when(this.rest.postForObject("https://create-ticket-api/", TICKET1,Ticket.class))
//                .thenReturn(TICKET1);
//        assertThat(this.service.create(TICKET1)).isEqualTo(TICKET1);
//        verify(this.rest, times(1)).postForObject("https://create-ticket-api/",TICKET1,Ticket.class);
//    }
//
//    @Test
//    void testDeleteById(){
//        assertThat(this.service.deleteById(TICKET1.getId())).isEqualTo(true);
//        verify(this.rest, times(1)).delete("https://delete-ticket-api/"+TICKET1.getId());
//    }
//
//    @Test
//    void testUpdateById(){
//        HttpEntity<Ticket> request = new HttpEntity<>(TICKET1_CHANGE);
//        when(this.rest.exchange("https://update-ticket-api/"+TICKET1.getId(), HttpMethod.PUT, request, Ticket.class))
//                .thenReturn(new ResponseEntity<>(TICKET1_CHANGE, HttpStatus.ACCEPTED));
//        assertThat(this.service.updateById(TICKET1.getId(), TICKET1_CHANGE)).isEqualTo(TICKET1_CHANGE);
//        verify(this.rest, times(1)).exchange("https://update-ticket-api/"+TICKET1.getId(), HttpMethod.PUT, request, Ticket.class);
//    }
}
