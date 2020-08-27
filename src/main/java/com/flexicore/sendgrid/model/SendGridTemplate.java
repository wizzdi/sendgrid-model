package com.flexicore.sendgrid.model;

import com.flexicore.model.Baseclass;
import com.flexicore.security.SecurityContext;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class SendGridTemplate extends Baseclass {

    private String externalId;

    @ManyToOne(targetEntity = SendGridServer.class)
    private SendGridServer sendGridServer;

    public SendGridTemplate() {
    }

    public SendGridTemplate(String name, SecurityContext securityContext) {
        super(name, securityContext);
    }

    @ManyToOne(targetEntity = SendGridServer.class)
    public SendGridServer getSendGridServer() {
        return sendGridServer;
    }

    public <T extends SendGridTemplate> T setSendGridServer(SendGridServer sendGridServer) {
        this.sendGridServer = sendGridServer;
        return (T) this;
    }

    public String getExternalId() {
        return externalId;
    }

    public <T extends SendGridTemplate> T setExternalId(String externalId) {
        this.externalId = externalId;
        return (T) this;
    }
}
