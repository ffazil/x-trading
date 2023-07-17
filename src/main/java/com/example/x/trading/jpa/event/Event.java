package com.example.x.trading.jpa.event;

import java.time.LocalDateTime;

public interface Event {

    LocalDateTime getPublicationDate();

    Class<?> getAggregateType();
}
