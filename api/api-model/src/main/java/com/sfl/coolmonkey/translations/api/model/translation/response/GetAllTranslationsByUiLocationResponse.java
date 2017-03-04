package com.sfl.coolmonkey.translations.api.model.translation.response;

import com.sfl.coolmonkey.commons.api.model.response.AbstractGridAwareResponseModel;
import com.sfl.coolmonkey.translations.api.model.translation.TranslationModel;

import java.util.List;

/**
 * User: Ruben Vardanyan
 * Company: SFL LLC
 * Date: 4/8/16
 * Time: 4:22 PM
 */
public class GetAllTranslationsByUiLocationResponse extends AbstractGridAwareResponseModel<TranslationModel> {
    private static final long serialVersionUID = -994168689810718870L;

    //region Properties
    //endregion

    //region Constructors
    public GetAllTranslationsByUiLocationResponse() {
    }

    public GetAllTranslationsByUiLocationResponse(final List<TranslationModel> grid) {
        super(grid);
    }
    //endregion

    //region Equals, HashCode and ToString
    //endregion

    //region Properties getters and setters
    //endregion
}
