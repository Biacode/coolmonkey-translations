package com.sfl.coolmonkey.translations.api.model.translation.request;

import com.sfl.coolmonkey.commons.api.model.request.AbstractCompanyUuidAwareRequestModel;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 12/23/15
 * Time: 12:24 PM
 */
public class GetAllUiLocationsRequest extends AbstractCompanyUuidAwareRequestModel {
    private static final long serialVersionUID = 1133998720589092941L;

    //region Properties
    //endregion

    //region Constructors
    public GetAllUiLocationsRequest() {
    }

    public GetAllUiLocationsRequest(final String companyUuid) {
        super(companyUuid);
    }
    //endregion

    //region Equals, HashCode and ToString
    //endregion

    //region Properties getters and setters
    //endregion
}
