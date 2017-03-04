package com.sfl.coolmonkey.translations.api.client.rest.translation.impl;

import com.sfl.coolmonkey.commons.api.model.response.ResultResponseModel;
import com.sfl.coolmonkey.translations.api.client.rest.common.AbstractResourceClient;
import com.sfl.coolmonkey.translations.api.client.rest.translation.TranslationResourceClient;
import com.sfl.coolmonkey.translations.api.model.translation.request.*;
import com.sfl.coolmonkey.translations.api.model.translation.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 12/22/15
 * Time: 8:47 PM
 */
public class TranslationResourceClientImpl extends AbstractResourceClient implements TranslationResourceClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(TranslationResourceClientImpl.class);

    //region Constants
    private static final String RESOURCE_BASE_PATH = "translation";
    //endregion

    //region Constructors
    public TranslationResourceClientImpl(final Client client, final String apiPath) {
        super(client, apiPath);
        LOGGER.debug("Initializing translation resource client");
    }
    //endregion

    //region Public methods
    @Nonnull
    @Override
    public ResultResponseModel<GetAllTranslationsResponse> getAll(@Nonnull final GetAllTranslationsRequest request) {
        assertRequestNotNull(request);
        return getClient()
                .target(getApiPath())
                .path(RESOURCE_BASE_PATH)
                .path("all")
                .queryParam("locale", request.getLocale())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<ResultResponseModel<GetAllTranslationsResponse>>() {
                });
    }

    @Nonnull
    @Override
    public ResultResponseModel<GetTranslationGridResponse> getReallyAll(@Nonnull final GetAllTranslationsRequest request) {
        assertRequestNotNull(request);
        return getClient()
                .target(getApiPath())
                .path(RESOURCE_BASE_PATH)
                .path("all-all")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<ResultResponseModel<GetTranslationGridResponse>>() {
                });
    }

    @Nonnull
    @Override
    public ResultResponseModel<GetTranslationResponse> get(@Nonnull final GetTranslationRequest request) {
        assertRequestNotNull(request);
        return getClient()
                .target(getApiPath())
                .path(RESOURCE_BASE_PATH)
                .queryParam("locale", request.getLocale())
                .queryParam("key", request.getKey())
                .queryParam("uiLocation", request.getUiLocation())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<ResultResponseModel<GetTranslationResponse>>() {
                });
    }

    @Nonnull
    @Override
    public ResultResponseModel<GetAllUiLocationsResponse> getAllUiLocations(@Nonnull final GetAllUiLocationsRequest request) {
        assertRequestNotNull(request);
        return getClient()
                .target(getApiPath())
                .path(RESOURCE_BASE_PATH)
                .path("all-ui-locations")
                .queryParam("companyUuid", request.getCompanyUuid())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<ResultResponseModel<GetAllUiLocationsResponse>>() {
                });
    }

    @Nonnull
    @Override
    public ResultResponseModel<GetTranslationGridResponse> getTranslationGrid(@Nonnull final GetTranslationGridRequest request) {
        assertRequestNotNull(request);
        return getClient()
                .target(getApiPath())
                .path(RESOURCE_BASE_PATH)
                .path("translation-grid")
                .queryParam("companyUuid", request.getCompanyUuid())
                .queryParam("locale", request.getLocale())
                .queryParam("uiLocation", request.getUiLocation())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<ResultResponseModel<GetTranslationGridResponse>>() {
                });
    }

    @Nonnull
    @Override
    public ResultResponseModel<UpdateTranslationMessageResponse> updateTranslationMessage(@Nonnull final UpdateTranslationMessageRequest request) {
        assertRequestNotNull(request);
        return getClient()
                .target(getApiPath())
                .path(RESOURCE_BASE_PATH)
                .path("message")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE), new GenericType<ResultResponseModel<UpdateTranslationMessageResponse>>() {
                });
    }

    @Nonnull
    @Override
    public ResultResponseModel<GetAllTranslationsByUiLocationResponse> getAllByUiLocation(@Nonnull final GetAllTranslationsByUiLocationRequest request) {
        assertRequestNotNull(request);
        return getClient()
                .target(getApiPath())
                .path(RESOURCE_BASE_PATH)
                .path("by-ui-location")
                .queryParam("uiLocation", request.getUiLocation())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<ResultResponseModel<GetAllTranslationsByUiLocationResponse>>() {
                });
    }

    @Nonnull
    @Override
    public ResultResponseModel<GetTranslationsForIndexationResponse> getForIndexation(@Nonnull final GetTranslationsForIndexationRequest request) {
        assertRequestNotNull(request);
        return getClient()
                .target(getApiPath())
                .path(RESOURCE_BASE_PATH)
                .path("for-indexation")
                .queryParam("page", request.getPage())
                .queryParam("size", request.getSize())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<ResultResponseModel<GetTranslationsForIndexationResponse>>() {
                });
    }
    //endregion
}
