package com.example.x.trading.alert;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoggingEventListener {

    @EventListener
    public void on(Alert.Alerted event){
        log.info("Alert: {}", event);
    }
}
