package com.example.x.trading.jpa.init;

import org.springframework.transaction.annotation.Transactional;

public interface DataInitializer {

    @Transactional
    void initialize();

}
