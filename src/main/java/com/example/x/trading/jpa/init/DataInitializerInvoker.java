package com.example.x.trading.jpa.init;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class DataInitializerInvoker implements ApplicationRunner {

    private final @NonNull List<DataInitializer> initializers;

    @Override
    public void run(ApplicationArguments args) {
        initializers.forEach(DataInitializer::initialize);
    }

    @Component
    static class NoOpDataInitializer implements DataInitializer {
        @Override
        public void initialize() {}
    }

}
