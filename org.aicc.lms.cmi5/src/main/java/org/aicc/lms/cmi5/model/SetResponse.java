package org.aicc.lms.cmi5.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "setResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class SetResponse {

    @XmlElement
    private String setResponseId;

    public String getSetResponseId() {
        return setResponseId;
    }

    public void setSetResponseId(String setResponseId) {
        this.setResponseId = setResponseId;
    }

}
