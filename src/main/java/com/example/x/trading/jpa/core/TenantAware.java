package com.example.x.trading.jpa.core;

import java.util.UUID;

public interface TenantAware {
    static final UUID rootTenantId = UUID.fromString("11111111-aaaa-bbbb-cccc-ffffffffffff");

    default UUID rootTenantId(){
        return rootTenantId;
    }

}
