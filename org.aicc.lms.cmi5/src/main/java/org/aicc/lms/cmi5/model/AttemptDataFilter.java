package org.aicc.lms.cmi5.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "attemptDataFilter")
@XmlAccessorType(XmlAccessType.FIELD)
public class AttemptDataFilter {
    @XmlElement
    private String attemptDataFilterId;

    public String getAttemptDataFilterId() {
        return attemptDataFilterId;
    }

    public void setAttemptDataFilterId(String attemptDataFilterId) {
        this.attemptDataFilterId = attemptDataFilterId;
    }

}
