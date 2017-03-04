package com.sfl.coolmonkey.translations.api.client.rest.common;

import com.sfl.coolmonkey.commons.api.model.request.AbstractRequestModel;
import org.springframework.util.Assert;

import javax.ws.rs.client.Client;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 1/25/16
 * Time: 6:24 PM
 */
public class AbstractResourceClient {

    //region Properties
    private String apiPath;

    private Client client;
    //endregion

    //region Constructors
    public AbstractResourceClient() {
    }

    public AbstractResourceClient(final Client client, final String apiPath) {
        this.apiPath = apiPath;
        this.client = client;
    }
    //endregion

    //region Public methods
    public void assertRequestNotNull(final AbstractRequestModel request) {
        Assert.notNull(request, "The request should not be null");
    }
    //endregion

    //region Properties getters and setters
    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(final String apiPath) {
        this.apiPath = apiPath;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(final Client client) {
        this.client = client;
    }
    //endregion
}
