package com.example.x.trading.alert;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RequiredArgsConstructor
@RepositoryRestController
public class AlertController {

    private final AlertService alertService;


    @PostMapping(path = "/alerts")
    public ResponseEntity<?> newAlert(@RequestBody Alert alert){
        alert = alertService.newAlert(alert);
        return ResponseEntity.ok(alert);
    }
}
