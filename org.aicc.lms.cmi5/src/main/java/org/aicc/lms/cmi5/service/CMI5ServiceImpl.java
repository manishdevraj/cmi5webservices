package org.aicc.lms.cmi5.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.aicc.lms.cmi5.model.AttemptData;
import org.aicc.lms.cmi5.model.AttemptDataFilter;
import org.aicc.lms.cmi5.model.AttemptHistory;
import org.aicc.lms.cmi5.model.ExitResponse;
import org.aicc.lms.cmi5.model.SetResponse;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.stereotype.Service;

/**
 * Service that exposes CMI5 AICC APIs
 * 
 * @author manish
 */
@Service("cmi5ServiceImpl")
@Path("/cmi5service/")
public class CMI5ServiceImpl implements CMI5Service {
    static Map<String, String> sessionMap = new HashMap<String, String>();

    public static void main(String[] args) {
        Response response = null;
        try {
            // response = callExit(response);
            response = callGet(response);
            InputStream is = (InputStream) response.getEntity();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Response " + response.getStatus());
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Response " + response.getStatus());

        }
    }

    /**
     * @param response
     * @return
     */
    public static Response callExit(Response response) {
        WebClient client = WebClient.create("http://localhost:8080/lmscmi5/cmi5service/exit/1");
        client.accept(MediaType.APPLICATION_JSON);
        client.type(MediaType.APPLICATION_XML);
        response = client.get();
        return response;

    }

    /**
     * @param response
     * @return
     */
    public static Response callGet(Response response) {
        WebClient client = WebClient.create("http://localhost:8080/lmscmi5/cmi5service/get/1");
        client.accept(MediaType.APPLICATION_JSON);
        client.type(MediaType.APPLICATION_JSON);
        AttemptDataFilter attemptDataFilter = new AttemptDataFilter();
        attemptDataFilter.setAttemptDataFilterId("java dummpy filter id");
        response = client.post(attemptDataFilter);
        return response;
    }

    /*
     * (non-Javadoc)
     * @see org.aicc.lms.cmi5.service.CMI5Service#set(java.lang.String,
     * org.aicc.lms.cmi5.model.AttemptData)
     */
    @Override
    @POST
    @Path("/set/{cmisessionid}/")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public SetResponse set(@PathParam("cmisessionid") String CMISessionID, @WebParam(name = "attemptdata") AttemptData attemptData) {
        if (attemptData != null) {
            CMISessionID = CMISessionID + "&&&" + attemptData.getSequenceNumber();
        }
        SetResponse setResponse = new SetResponse();
        setResponse.setSetResponseId("dumpy set response id " + CMISessionID);
        return setResponse;
    }

    /*
     * (non-Javadoc)
     * @see org.aicc.lms.cmi5.service.CMI5Service#get(java.lang.String,
     * org.aicc.lms.cmi5.model.AttemptDataFilter)
     */
    @Override
    @POST
    @Path("/get/{cmisessionid}/")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public AttemptHistory get(@PathParam("cmisessionid") String CMISessionID, @WebParam(name = "attemptdatafilter") AttemptDataFilter attemptDataFilter) {
        if (attemptDataFilter != null) {
            CMISessionID = CMISessionID + "&&&" + attemptDataFilter.getAttemptDataFilterId();
        }
        AttemptHistory attemptHistory = new AttemptHistory();
        attemptHistory.setHistoryId("dumpy history id " + CMISessionID);
        return attemptHistory;
    }

    /*
     * (non-Javadoc)
     * @see org.aicc.lms.cmi5.service.CMI5Service#getHistory(java.lang.String,
     * org.aicc.lms.cmi5.model.AttemptDataFilter)
     */
    @Override
    @POST
    @Path("/gethistory/{cmisessionid}/")
    @Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public AttemptHistory getHistory(@PathParam("cmisessionid") String CMISessionID, @WebParam(name = "attemptdatafilter") AttemptDataFilter attemptDataFilter) {
        if (attemptDataFilter != null) {
            CMISessionID = CMISessionID + "&&&" + attemptDataFilter.getAttemptDataFilterId();
        }
        AttemptHistory attemptHistory = new AttemptHistory();
        attemptHistory.setHistoryId("dumpy get history id " + CMISessionID);
        return attemptHistory;
    }

    /*
     * (non-Javadoc)
     * @see org.aicc.lms.cmi5.service.CMI5Service#exit(java.lang.String)
     */
    @Override
    @GET
    @Path("/exit/{cmisessionid}/")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public ExitResponse exit(@PathParam("cmisessionid") String CMISessionID) {
        ExitResponse exitRes = new ExitResponse();
        if (sessionMap.containsKey(CMISessionID)) {
            exitRes.setExitResponseId(sessionMap.get(CMISessionID));
        } else {
            exitRes.setExitResponseId("NO session found");
        }

        return exitRes;
    }

    static {
        sessionMap.put("1", "session1");
        sessionMap.put("2", "session2");
        sessionMap.put("3", "session3");
    }

}
