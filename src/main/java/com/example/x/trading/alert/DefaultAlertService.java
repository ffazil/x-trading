package com.example.x.trading.alert;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DefaultAlertService implements AlertService{

    private final AlertRepository alertRepository;

    @Override
    @Transactional
    public Alert newAlert(Alert alert) {
        alert = alertRepository.save(alert);
        return alert;
    }
}
