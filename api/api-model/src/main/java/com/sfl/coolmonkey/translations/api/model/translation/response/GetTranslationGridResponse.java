package com.sfl.coolmonkey.translations.api.model.translation.response;

import com.sfl.coolmonkey.commons.api.model.response.AbstractGridAwareResponseModel;
import com.sfl.coolmonkey.translations.api.model.translation.TranslationModel;

import java.util.List;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 12/23/15
 * Time: 2:34 PM
 */
public class GetTranslationGridResponse extends AbstractGridAwareResponseModel<TranslationModel> {
    private static final long serialVersionUID = 2511554081911823125L;

    //region Properties
    //endregion

    //region Constructors
    public GetTranslationGridResponse() {
    }

    public GetTranslationGridResponse(final List<TranslationModel> grid) {
        super(grid);
    }
    //endregion

    //region Equals, HashCode and ToString
    //endregion

    //region Properties getters and setters
    //endregion
}
