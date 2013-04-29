package org.aicc.lms.cmi5.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "exitResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExitResponse {

    @XmlElement
    private String exitResponseId;

    public String getExitResponseId() {
        return exitResponseId;
    }

    public void setExitResponseId(String exitResponseId) {
        this.exitResponseId = exitResponseId;
    }

}
