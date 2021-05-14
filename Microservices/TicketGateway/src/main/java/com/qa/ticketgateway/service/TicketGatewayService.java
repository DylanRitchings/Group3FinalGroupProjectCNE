package com.qa.ticketgateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Service
public class TicketGatewayService <T> {

    private final RestTemplate rest;

    @Autowired
    public TicketGatewayService(RestTemplate rest) {
        super();
        this.rest = rest;
    }


    public Object[] readAll(){
        return this.rest.getForObject("https://read-all-tickets-api/", Object[].class);

    }

    public Object readById(Long id) {
        return this.rest.getForObject("https://read-ticket-api/"+id, Object.class);

    }

    public Object create(T t) {
        Object newT = rest.postForObject("https://create-ticket-api/", t, Object.class);

        return newT;
    }

    public Boolean deleteById(Long id) {
        String url = "https://delete-ticket-api/"+id;
        try {
            this.rest.delete(url);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public Object updateById(Long id, T t) {
        HttpEntity<T> request = new HttpEntity<>(t);
        ResponseEntity<Object> response = this.rest.exchange("https://update-ticket-api/"+id, HttpMethod.PUT, request, Object.class);
        Object updatedT = response.getBody();
        return(updatedT);
    }

}
