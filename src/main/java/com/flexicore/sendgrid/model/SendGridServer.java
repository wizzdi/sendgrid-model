package com.flexicore.sendgrid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.model.SecuredBasic;

import javax.persistence.Entity;

@Entity
public class SendGridServer extends SecuredBasic {

    @JsonIgnore
    private String apiKey;
    @JsonIgnore
    private String apiKeySalt;



    public SendGridServer() {
    }

    @JsonIgnore
    public String getApiKey() {
        return apiKey;
    }

    public <T extends SendGridServer> T setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return (T) this;
    }

    @JsonIgnore
    public String getApiKeySalt() {
        return apiKeySalt;
    }

    public <T extends SendGridServer> T setApiKeySalt(String apiKeySalt) {
        this.apiKeySalt = apiKeySalt;
        return (T) this;
    }
}
