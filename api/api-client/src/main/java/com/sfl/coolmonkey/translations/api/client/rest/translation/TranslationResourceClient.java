package com.sfl.coolmonkey.translations.api.client.rest.translation;

import com.sfl.coolmonkey.commons.api.model.response.ResultResponseModel;
import com.sfl.coolmonkey.translations.api.model.translation.request.*;
import com.sfl.coolmonkey.translations.api.model.translation.response.*;

import javax.annotation.Nonnull;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 12/22/15
 * Time: 8:46 PM
 */
public interface TranslationResourceClient {

    @Nonnull
    ResultResponseModel<GetAllTranslationsResponse> getAll(@Nonnull final GetAllTranslationsRequest request);

    @Nonnull
    ResultResponseModel<GetTranslationGridResponse> getReallyAll(@Nonnull final GetAllTranslationsRequest request);

    @Nonnull
    ResultResponseModel<GetTranslationResponse> get(@Nonnull final GetTranslationRequest request);

    @Nonnull
    ResultResponseModel<GetAllUiLocationsResponse> getAllUiLocations(@Nonnull final GetAllUiLocationsRequest request);

    @Nonnull
    ResultResponseModel<GetTranslationGridResponse> getTranslationGrid(@Nonnull final GetTranslationGridRequest request);

    @Nonnull
    ResultResponseModel<UpdateTranslationMessageResponse> updateTranslationMessage(@Nonnull final UpdateTranslationMessageRequest request);

    @Nonnull
    ResultResponseModel<GetAllTranslationsByUiLocationResponse> getAllByUiLocation(@Nonnull final GetAllTranslationsByUiLocationRequest request);

    @Nonnull
    ResultResponseModel<GetTranslationsForIndexationResponse> getForIndexation(@Nonnull final GetTranslationsForIndexationRequest request);
}
