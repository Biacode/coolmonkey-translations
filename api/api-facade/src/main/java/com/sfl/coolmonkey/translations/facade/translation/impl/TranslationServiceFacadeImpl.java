package com.sfl.coolmonkey.translations.facade.translation.impl;

import com.sfl.coolmonkey.commons.api.model.response.ResultResponseModel;
import com.sfl.coolmonkey.translations.api.model.translation.TranslationIndexationModel;
import com.sfl.coolmonkey.translations.api.model.translation.TranslationModel;
import com.sfl.coolmonkey.translations.api.model.translation.TranslationUiLocationModel;
import com.sfl.coolmonkey.translations.api.model.translation.request.*;
import com.sfl.coolmonkey.translations.api.model.translation.response.*;
import com.sfl.coolmonkey.translations.facade.translation.TranslationServiceFacade;
import com.sfl.coolmonkey.translations.service.translation.TranslationService;
import com.sfl.coolmonkey.translations.service.translation.event.TranslationModifiedEvent;
import com.sfl.coolmonkey.translations.service.translation.model.Translation;
import ma.glasnost.orika.MapperFacade;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 12/22/15
 * Time: 7:22 PM
 */
@Component
public class TranslationServiceFacadeImpl implements TranslationServiceFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(TranslationServiceFacadeImpl.class);

    //region Dependencies
    @Autowired
    private TranslationService translationService;

    @Autowired
    private MapperFacade mapperFacade;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    //endregion

    //region Constructors
    public TranslationServiceFacadeImpl() {
        LOGGER.debug("Initializing translation service facade");
    }
    //endregion

    //region Public methods
    @Nonnull
    @Override
    public ResultResponseModel<GetAllTranslationsResponse> getAll(@Nonnull final GetAllTranslationsRequest request) {
        assertGetAllTranslationsRequest(request);
        final String locale = request.getLocale();
        final List<Translation> translations = translationService.getAllByLocale(locale);
        final Map<String, Map<String, String>> map = translations.stream()
                .collect(Collectors.groupingBy(Translation::getUiLocation, Collectors.toMap(Translation::getKey, Translation::getMessage)));
        return new ResultResponseModel<>(new GetAllTranslationsResponse(map));
    }

    @Nonnull
    @Override
    public ResultResponseModel<GetTranslationGridResponse> getAll() {
        final List<Translation> translations = translationService.getAll();
        final List<TranslationModel> grid = mapperFacade.mapAsList(translations, TranslationModel.class);
        return new ResultResponseModel<>(new GetTranslationGridResponse(grid));
    }

    @Nonnull
    @Override
    public ResultResponseModel<GetTranslationResponse> get(@Nonnull final GetTranslationRequest request) {
        assertGetTranslationRequest(request);
        final String uiLocation = request.getUiLocation();
        final String key = request.getKey();
        final String locale = request.getLocale();
        final Translation translation = translationService.getByUiLocationKeyLocale(uiLocation, key, locale);
        final String message = translation.getMessage();
        return new ResultResponseModel<>(new GetTranslationResponse(message));
    }

    @Nonnull
    @Override
    public ResultResponseModel<GetAllUiLocationsResponse> getAllUiLocations(@Nonnull final GetAllUiLocationsRequest request) {
        assertGetAllUiLocationsRequest(request);
        final List<String> uiLocations = translationService.getAllUiLocations();
        final List<TranslationUiLocationModel> grid = uiLocations.stream()
                .map(TranslationUiLocationModel::new)
                .collect(Collectors.toList());
        return new ResultResponseModel<>(new GetAllUiLocationsResponse(grid));
    }

    @Nonnull
    @Override
    public ResultResponseModel<GetTranslationGridResponse> getTranslationGrid(@Nonnull final GetTranslationGridRequest request) {
        assertGetTranslationGridRequest(request);
        final String uiLocation = request.getUiLocation();
        final String locale = request.getLocale();
        if (StringUtils.isBlank(uiLocation)) {
            final List<Translation> translations = translationService.getAllByLocale(locale);
            final List<TranslationModel> grid = mapperFacade.mapAsList(translations, TranslationModel.class);
            return new ResultResponseModel<>(new GetTranslationGridResponse(grid));
        } else {
            final List<Translation> translations = translationService.getAllByLocaleAndUiLocation(locale, uiLocation);
            final List<TranslationModel> grid = mapperFacade.mapAsList(translations, TranslationModel.class);
            return new ResultResponseModel<>(new GetTranslationGridResponse(grid));
        }
    }

    @Nonnull
    @Override
    public ResultResponseModel<UpdateTranslationMessageResponse> updateTranslationMessage(@Nonnull final UpdateTranslationMessageRequest request) {
        assertUpdateTranslationMessageRequest(request);
        final String uuid = request.getUuid();
        final String message = request.getMessage();
        translationService.updateMessage(uuid, message);
        applicationEventPublisher.publishEvent(new TranslationModifiedEvent(this, uuid));
        return new ResultResponseModel<>(new UpdateTranslationMessageResponse());
    }

    @Nonnull
    @Override
    public ResultResponseModel<GetAllTranslationsByUiLocationResponse> getAllByUiLocation(@Nonnull final GetAllTranslationsByUiLocationRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getUiLocation());
        final List<Translation> translations = translationService.getAllByUiLocation(request.getUiLocation());
        return new ResultResponseModel<>(new GetAllTranslationsByUiLocationResponse(mapperFacade.mapAsList(translations, TranslationModel.class)));
    }

    @Nonnull
    @Override
    public ResultResponseModel<GetTranslationsForIndexationResponse> getForIndexation(@Nonnull final GetTranslationsForIndexationRequest request) {
        assertGetTranslationsForIndexationRequest(request);
        final List<Translation> translations = translationService.getAllForIndexation(request.getPage(), request.getSize());
        final List<TranslationIndexationModel> translationIndexationModels = mapperFacade.mapAsList(translations, TranslationIndexationModel.class);
        return new ResultResponseModel<>(new GetTranslationsForIndexationResponse(translationIndexationModels));
    }
    //endregion

    //region Utility methods
    private void assertUpdateTranslationMessageRequest(final UpdateTranslationMessageRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getUuid());
        Assert.notNull(request.getMessage());
    }

    private void assertGetTranslationGridRequest(final GetTranslationGridRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getCompanyUuid());
        Assert.notNull(request.getLocale());
    }

    private void assertGetAllUiLocationsRequest(final GetAllUiLocationsRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getCompanyUuid());
    }

    private void assertGetAllTranslationsRequest(final GetAllTranslationsRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getLocale());
    }

    private void assertGetTranslationRequest(final GetTranslationRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getLocale());
        Assert.notNull(request.getKey());
        Assert.notNull(request.getUiLocation());
    }

    private void assertGetTranslationsForIndexationRequest(final GetTranslationsForIndexationRequest request) {
        Assert.notNull(request);
        Assert.isTrue(request.getPage() >= 0);
        Assert.isTrue(request.getSize() > 0);
    }
    //endregion
}
