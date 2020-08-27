package com.flexicore.sendgrid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.FieldInfo;
import com.flexicore.model.Baseclass;
import com.flexicore.model.FilteringInformationHolder;
import com.flexicore.model.dynamic.ExecutionParametersHolder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class EmailRef {

    @Id
    private String filterId;

    @FieldInfo(displayName = "string",description = "string filter",mandatory = true)
    private String id;
    @ManyToOne(targetEntity = ExecutionParametersHolder.class)
    @JsonIgnore
    private ExecutionParametersHolder executionParameterHolder;

    public EmailRef() {
    }

    public String getId() {
        return id;
    }


    public EmailRef setId(String id) {
        this.id = id;
        return this;
    }

    public EmailRef(String id) {
        this.id = id;
    }

    @Id
    public String getFilterId() {
        return filterId;
    }

    public EmailRef setFilterId(String filterId) {
        this.filterId = filterId;
        return this;
    }

    @ManyToOne(targetEntity = ExecutionParametersHolder.class)
    @JsonIgnore
    public ExecutionParametersHolder getExecutionParameterHolder() {
        return executionParameterHolder;
    }

    public EmailRef setExecutionParameterHolder(ExecutionParametersHolder executionParametersHolder) {
        this.executionParameterHolder = executionParametersHolder;
        return this;
    }

    public void prepareForSave(ExecutionParametersHolder executionParametersHolder) {
        filterId = Baseclass.getBase64ID();
        this.executionParameterHolder = executionParametersHolder;

    }
}
