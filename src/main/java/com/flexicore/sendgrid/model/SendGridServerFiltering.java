package com.flexicore.sendgrid.model;

import com.flexicore.interfaces.dynamic.ListFieldInfo;
import com.flexicore.product.containers.request.ExternalServerFiltering;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class SendGridServerFiltering extends ExternalServerFiltering {

    @ListFieldInfo(listType = ApiKeyRef.class)
    @OneToMany(targetEntity =ApiKeyRef.class,mappedBy = "filteringInformationHolder")
    private Set<ApiKeyRef> apiKeys=new HashSet<>();

    @OneToMany(targetEntity =ApiKeyRef.class,mappedBy = "filteringInformationHolder")
    public Set<ApiKeyRef> getApiKeys() {
        return apiKeys;
    }

    public <T extends SendGridServerFiltering> T setApiKeys(Set<ApiKeyRef> apiKeys) {
        this.apiKeys = apiKeys;
        return (T) this;
    }
}
