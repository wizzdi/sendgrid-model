package com.flexicore.sendgrid.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexicore.interfaces.dynamic.IdRefFieldInfo;
import com.flexicore.interfaces.dynamic.ListFieldInfo;
import com.flexicore.model.FilteringInformationHolder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class SendGridTemplateFiltering extends FilteringInformationHolder {

    @ListFieldInfo(listType = ExternalTemplateIdRef.class)
    @OneToMany(targetEntity = ExternalTemplateIdRef.class,mappedBy = "filteringInformationHolder")
    private Set<ExternalTemplateIdRef> externalTemplateIds=new HashSet<>();

    @IdRefFieldInfo(refType = SendGridServerIdRef.class)
    @OneToMany(targetEntity = SendGridServerIdRef.class,mappedBy = "filteringInformationHolder")
    private Set<SendGridServerIdRef> sendGridServerIds =new HashSet<>();

    @JsonIgnore
    @Transient
    private List<SendGridServer> sendGridServers;

    @OneToMany(targetEntity = ExternalTemplateIdRef.class,mappedBy = "filteringInformationHolder")
    public Set<ExternalTemplateIdRef> getExternalTemplateIds() {
        return externalTemplateIds;
    }



    public <T extends SendGridTemplateFiltering> T setExternalTemplateIds(Set<ExternalTemplateIdRef> externalTemplateIds) {
        this.externalTemplateIds = externalTemplateIds;
        return (T) this;
    }

    @OneToMany(targetEntity = SendGridServerIdRef.class,mappedBy = "filteringInformationHolder")
    public Set<SendGridServerIdRef> getSendGridServerIds() {
        return sendGridServerIds;
    }

    public <T extends SendGridTemplateFiltering> T setSendGridServerIds(Set<SendGridServerIdRef> sendGridIds) {
        this.sendGridServerIds = sendGridIds;
        return (T) this;
    }

    @JsonIgnore
    @Transient
    public List<SendGridServer> getSendGridServers() {
        return sendGridServers;
    }

    public <T extends SendGridTemplateFiltering> T setSendGridServers(List<SendGridServer> sendGridServers) {
        this.sendGridServers = sendGridServers;
        return (T) this;
    }

    @Override
    public void prepareForSave() {
        super.prepareForSave();
        if(externalTemplateIds!=null){
            for (ExternalTemplateIdRef externalTemplateId : externalTemplateIds) {
                externalTemplateId.prepareForSave(this);
            }
        }
        if(sendGridServerIds!=null){
            for (SendGridServerIdRef sendGridServerId : sendGridServerIds) {
                sendGridServerId.prepareForSave(this);
            }
        }
    }
}
