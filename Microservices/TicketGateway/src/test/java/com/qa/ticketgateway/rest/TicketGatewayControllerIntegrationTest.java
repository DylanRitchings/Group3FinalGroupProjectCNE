package com.qa.ticketgateway.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.qa.ticketgateway.service.TicketGatewayService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.*;

import java.time.LocalDateTime;


@WebMvcTest(TicketGatewayController.class)
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class TicketGatewayControllerIntegrationTest {

    @Autowired
    private MockMvc mockMVC;

    @MockBean
    private TicketGatewayService service;

    @MockBean
    private RestTemplate rest;

    private ObjectMapper mapper = new ObjectMapper();

//    private final static LocalDateTime DATE_TIME = LocalDateTime.of(2010, 2, 11,11,30);
//    private final Ticket TICKET1 = new Ticket(1L,"Name Naming", DATE_TIME, "Description of ticket","Title of ticket", false, "This is a new solution", "Medium", "Cohort2");
//    private final Ticket TICKET2 = new Ticket(2L,"Name2", DATE_TIME, "Name description","hjsdfklgjsdlfkjsd", false, "This is a new solution", "Medium", "Cohort2");

//    @BeforeEach
//    void setup() {
//        service = new TicketGatewayService(rest);
//    }
//

//    @Test
//    void testReadById() throws Exception {
//        mockMVC.perform(get("/read/"+TICKET1.getId()).contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(TICKET1)).accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
}
