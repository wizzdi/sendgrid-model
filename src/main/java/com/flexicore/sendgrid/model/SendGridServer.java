package com.flexicore.sendgrid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.iot.ExternalServer;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;

@Entity
public class SendGridServer extends ExternalServer {

    @JsonIgnore
    private String apiKey;

    public SendGridServer() {
    }

    public SendGridServer(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    @JsonIgnore
    public String getApiKey() {
        return apiKey;
    }

    public <T extends SendGridServer> T setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return (T) this;
    }
}
