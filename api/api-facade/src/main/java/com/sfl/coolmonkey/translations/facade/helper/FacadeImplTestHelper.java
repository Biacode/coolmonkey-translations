package com.sfl.coolmonkey.translations.facade.helper;

import com.sfl.coolmonkey.commons.api.model.CommonErrorType;
import com.sfl.coolmonkey.commons.api.model.response.AbstractResponseModel;
import com.sfl.coolmonkey.commons.api.model.response.ResultResponseModel;
import com.sfl.coolmonkey.translations.api.model.translation.TranslationModel;
import com.sfl.coolmonkey.translations.service.helper.CommonTestHelper;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 7/3/15
 * Time: 3:18 PM
 */
@SuppressWarnings({"checkstyle:com.puppycrawl.tools.checkstyle.checks.coding.MagicNumberCheck"})
public class FacadeImplTestHelper extends CommonTestHelper {

    //region Common
    public void assertValidationErrors(final ResultResponseModel<? extends AbstractResponseModel> result,
                                       final Set<CommonErrorType> expectedErrors) {
        assertNotNull(result);
        assertEquals(expectedErrors.size(), result.getErrors().size());
        result.getErrors().forEach((key, value) -> assertTrue(expectedErrors.contains(key)));
    }

    public void assertValidationErrors(final List<CommonErrorType> errors,
                                       final Set<CommonErrorType> expectedErrors) {
        assertNotNull(errors);
        assertEquals(expectedErrors.size(), errors.size());
        errors.forEach(error -> assertTrue(expectedErrors.contains(error)));
    }
    //endregion

    //region Translation
    public TranslationModel createTranslationModel() {
        return new TranslationModel(
                UUID.randomUUID().toString(),
                "uiLocation",
                "key",
                "locale",
                "message"
        );
    }
    //endregion
}
