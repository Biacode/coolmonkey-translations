package com.sfl.coolmonkey.translations.api.model.translation.response;

import com.sfl.coolmonkey.commons.api.model.response.AbstractGridAwareResponseModel;
import com.sfl.coolmonkey.translations.api.model.translation.TranslationIndexationModel;

import java.util.List;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 19/04/16
 * Time: 11:31
 */
public class GetTranslationsForIndexationResponse extends AbstractGridAwareResponseModel<TranslationIndexationModel> {
    private static final long serialVersionUID = 8586400485469297512L;

    //region Properties
    //endregion

    //region Constructors
    public GetTranslationsForIndexationResponse() {
    }

    public GetTranslationsForIndexationResponse(final List<TranslationIndexationModel> grid) {
        super(grid);
    }
    //endregion

    //region Equals, HashCode and ToString
    //endregion

    //region Properties getters and setters
    //endregion
}
