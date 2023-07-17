package com.example.x.trading.jpa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Embeddable
@EqualsAndHashCode(of = {"uri"})
public class Uri implements Serializable {

    private final String uri;

    protected Uri() {
        this.uri = null;
    }

    public Uri(String tenantId, String email) {
        this.uri = tenantId+"/"+email;
    }

    public Uri(UUID tenantId, Email email) {
        this(tenantId.toString(), email.getAddress());
    }

    public Uri(String uri) {
        this.uri = uri;
    }

    public static Uri from(String tenantId, String email) {
        return new Uri(tenantId,email);
    }

    public static Uri from(String uri) {
        return new Uri(uri);
    }

    @JsonIgnore
    public Email getEmail(){
        String[] parts = this.uri.split("/");
        if(parts[1] == null || parts[1].isEmpty()){
            return null;
        }
        else {
            return Email.from(parts[1]);
        }
    }

    @JsonIgnore
    public UUID getTenantId(){
        String[] parts = this.uri.split("/");
        UUID tenantId;
        try {
            return UUID.fromString(parts[0]);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}
