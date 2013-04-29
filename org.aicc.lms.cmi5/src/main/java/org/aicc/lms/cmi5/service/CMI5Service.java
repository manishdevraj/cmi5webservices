package org.aicc.lms.cmi5.service;

import org.aicc.lms.cmi5.model.AttemptData;
import org.aicc.lms.cmi5.model.AttemptDataFilter;
import org.aicc.lms.cmi5.model.AttemptHistory;
import org.aicc.lms.cmi5.model.ExitResponse;
import org.aicc.lms.cmi5.model.SetResponse;

public interface CMI5Service {
    SetResponse set(String CMISessionID, AttemptData attemptData);

    AttemptHistory get(String CMISessionID, AttemptDataFilter attemptDataFilter);

    AttemptHistory getHistory(String CMISessionID, AttemptDataFilter attemptDataFilter);

    ExitResponse exit(String CMISessionID);
}
