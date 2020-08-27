package com.flexicore.sendgrid.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.converters.JsonConverter;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.interfaces.dynamic.ListFieldInfo;
import com.flexicore.model.dynamic.ExecutionParametersHolder;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Entity
public class ImportTemplatesRequest extends ExecutionParametersHolder {

    @Transient
    @JsonIgnore
    private SendGridServer sendGridServer;


    @IdRefFieldInfo(refType = SendGridServer.class,list = false,mandatory = true)
    private String sendGridServerId;

    public String getSendGridServerId() {
        return sendGridServerId;
    }

    public <T extends ImportTemplatesRequest> T setSendGridServerId(String externalServerId) {
        this.sendGridServerId = externalServerId;
        return (T) this;
    }

    @Transient
    @JsonIgnore
    public SendGridServer getSendGridServer() {
        return sendGridServer;
    }

    public <T extends ImportTemplatesRequest> T setSendGridServer(SendGridServer sendGridServer) {
        this.sendGridServer = sendGridServer;
        return (T) this;
    }



    @Override
    public void prepareForSave() {
        super.prepareForSave();
    }
}
