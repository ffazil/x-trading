package com.example.x.trading.alert;

import com.example.x.trading.jpa.core.AggregateRoot;
import com.example.x.trading.jpa.event.DomainEvent;
import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(force = true)
public class Alert extends AggregateRoot<Alert> {

    private String type;
    private String ticker;
    private Double price;
    private LocalDateTime now;

    @JsonCreator
    public Alert(String type, String ticker, Double price) {
        this.type = type;
        this.ticker = ticker;
        this.price = price;

        this.now = LocalDateTime.now();

        this.registerEvent(Alerted.of(this));
    }

    @Value
    @ToString(callSuper = true)
    @EqualsAndHashCode(callSuper = true)
    public static class Alerted extends DomainEvent<Alert> {

        protected Alerted(Alert alert){
            super(alert);
        }

        public static Alerted of(Alert alert){
            return new Alerted(alert);
        }

        public Alert getAlert(){
            return this.getData();
        }

    }
}
