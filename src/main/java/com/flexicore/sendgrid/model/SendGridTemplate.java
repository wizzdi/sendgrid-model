package com.flexicore.sendgrid.model;

import com.flexicore.model.SecuredBasic;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class SendGridTemplate extends SecuredBasic {

    private String externalId;

    @ManyToOne(targetEntity = SendGridServer.class)
    private SendGridServer sendGridServer;

    public SendGridTemplate() {
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
