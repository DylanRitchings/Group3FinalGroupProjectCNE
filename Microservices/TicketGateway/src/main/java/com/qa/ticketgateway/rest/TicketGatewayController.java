package com.qa.ticketgateway.rest;

import com.qa.ticketgateway.service.TicketGatewayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/tickets")
@RestController
@CrossOrigin
public class TicketGatewayController <T> {

    private final TicketGatewayService service;

    public TicketGatewayController(TicketGatewayService service) {
        super();
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody T newT) {
        return new ResponseEntity<>(this.service.create(newT), HttpStatus.CREATED);
    }

    @GetMapping("/readAll")

    public ResponseEntity<Object[]> readAll(){
        return ResponseEntity.ok(this.service.readAll());
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Object> readById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(this.service.readById(id));
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        if (this.service.deleteById(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateById(@PathVariable Long id, @RequestBody T t) {
        Object updatedObject = this.service.updateById(id, t);
        return new ResponseEntity<>(updatedObject, HttpStatus.ACCEPTED);
    }
}
