package org.aicc.lms.cmi5.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "attemptHistory")
@XmlAccessorType(XmlAccessType.FIELD)
public class AttemptHistory {
    @XmlElement
    private String historyId;

    public String getHistoryId() {
        return historyId;
    }

    public void setHistoryId(String historyId) {
        this.historyId = historyId;
    }

    /*
     * Entitlement Entitlement.LearnerIdentifier
     * Entitlement.EntitlementIdentifier Attempts Attempts.Attempt
     * Attempts.Attempt.SequenceNumber Attempts.Attempt.Core
     * Attempts.Attempt.Core.LaunchParameters Attempts.Attempt.Core.ContentState
     * Attempts.Attempt.Core.Completion Attempts.Attempt.Core.Mastery
     * Attempts.Attempt.Core.Score Attempts.Attempt.Core.Time
     * Attempts.Attempt.ContentDefined Attempts.Attempt.ContentDefined.Item
     * Attempts.Attempt.ContentDefined.Item.Label
     * Attempts.Attempt.ContentDefined.Item.Value
     * Attempts.Attempt.ContentDefined.Item.ContentType
     * Attempts.Attempt.ContentDefined.Item.NameSpace
     * Attempts.Attempt.ContentDefined.Item.NameSpace.Scope
     * Attempts.Attempt.ContentDefined.Item.NameSpace.Name
     * Attempts.Attempt.ContentDefined.Item.Printable
     * Attempts.Attempt.ContentDefined.Item.Public Errors
     */

}
