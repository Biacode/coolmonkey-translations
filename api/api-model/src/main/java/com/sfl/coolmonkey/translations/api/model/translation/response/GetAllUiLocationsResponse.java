package com.sfl.coolmonkey.translations.api.model.translation.response;

import com.sfl.coolmonkey.commons.api.model.response.AbstractGridAwareResponseModel;
import com.sfl.coolmonkey.translations.api.model.translation.TranslationUiLocationModel;

import java.util.List;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 12/23/15
 * Time: 12:24 PM
 */
public class GetAllUiLocationsResponse extends AbstractGridAwareResponseModel<TranslationUiLocationModel> {
    private static final long serialVersionUID = 4167918947316794300L;

    //region Properties
    //endregion

    //region Constructors
    public GetAllUiLocationsResponse() {
    }

    public GetAllUiLocationsResponse(final List<TranslationUiLocationModel> grid) {
        super(grid);
    }
    //endregion

    //region Equals, HashCode and ToString
    //endregion

    //region Properties getters and setters
    //endregion
}
