package com.qa.ticketgateway.rest;

import com.qa.ticketgateway.service.TicketGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles(profiles = "test")
public class TicketGatewayControllerUnitTest {
//    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);
//
//    @Autowired
//    private TicketGatewayController controller;
//    @MockBean
//    private TicketGatewayService service;
//
//    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false, "This is a new solution", "Medium", "Cohort2");
//    private final Ticket TICKET1_CHANGE = new Ticket(1L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd", true, "This is a new solution", "Medium", "Cohort2");
//    private final Ticket TICKET2 = new Ticket(2L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd", false, "This is a new solution", "Medium", "Cohort2" );
//
//    private final Ticket[] TICKETS_LIST = {TICKET1,TICKET2};
//
//    @Test
//    void testReadById(){
//        when(this.service.readById(TICKET1.getId())).thenReturn(TICKET1);
//        assertThat(this.controller.readById(TICKET1.getId())).isEqualTo(new ResponseEntity<>(TICKET1, HttpStatus.OK));
//        verify(this.service, times(1)).readById(TICKET1.getId());
//    }
//
//    @Test
//    void testUpdateById(){
//        when(this.service.updateById( TICKET1.getId(), TICKET1_CHANGE)).thenReturn(TICKET1_CHANGE);
//        assertThat(this.controller.updateById( TICKET1.getId(), TICKET1_CHANGE)).isEqualTo(new ResponseEntity<>(TICKET1_CHANGE, HttpStatus.ACCEPTED));
//        verify(this.service, times(1)).updateById(TICKET1.getId(),TICKET1_CHANGE);
//    }
//
//    @Test
//    void testReadAll(){
//        when(this.service.readAll()).thenReturn(TICKETS_LIST);
//        Ticket[] array = this.controller.readAll().getBody();
//        assertThat(array == null || array.length == 0).isFalse();
//        verify(this.service, times(1)).readAll();
//    }
//
//    @Test
//    void testDeleteById(){
//        when(this.service.deleteById(TICKET1.getId())).thenReturn(false);
//        assertThat(this.controller.deleteById(TICKET1.getId())).isEqualTo(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//        verify(this.service, times(1)).deleteById(TICKET1.getId());
//
//        when(this.service.deleteById(TICKET1.getId())).thenReturn(true);
//        assertThat(this.controller.deleteById(TICKET1.getId())).isEqualTo(new ResponseEntity<>(HttpStatus.NO_CONTENT));
//        verify(this.service, times(2)).deleteById(TICKET1.getId());
//    }
//
//    @Test
//    void testCreate() {
//        when(this.service.create(TICKET1)).thenReturn(TICKET1);
//        assertThat(this.controller.create(TICKET1)).isEqualTo(new ResponseEntity<>(TICKET1, HttpStatus.CREATED));
//        verify(this.service, times(1)).create(TICKET1);
//    }
}
