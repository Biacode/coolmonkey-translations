package com.sfl.coolmonkey.translations.api.rest.resources.translation;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.annotation.JacksonFeatures;
import com.sfl.coolmonkey.translations.api.model.translation.request.*;
import com.sfl.coolmonkey.translations.facade.translation.TranslationServiceFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 12/22/15
 * Time: 8:44 PM
 */
@Component
@Path("translation")
@Produces("application/json")
@Consumes("application/json")
public class TranslationResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(TranslationResource.class);

    //region Dependencies
    @Autowired
    private TranslationServiceFacade translationServiceFacade;
    //endregion

    //region Constructors
    public TranslationResource() {
        LOGGER.debug("Initializing translation resource");
    }
    //endregion

    //region Public methods
    @GET
    @Path("all")
    public Response getAll(@BeanParam final GetAllTranslationsRequest request) {
        return Response.ok(translationServiceFacade.getAll(request)).build();
    }

    @GET
    @Path("all-all")
    public Response getReallyAll(@BeanParam final GetAllTranslationsRequest request) {
        return Response.ok(translationServiceFacade.getAll()).build();
    }


    @GET
    public Response get(@BeanParam final GetTranslationRequest request) {
        return Response.ok(translationServiceFacade.get(request)).build();
    }

    @GET
    @Path("all-ui-locations")
    public Response getAllUiLocations(@BeanParam final GetAllUiLocationsRequest request) {
        return Response.ok(translationServiceFacade.getAllUiLocations(request)).build();
    }

    @GET
    @Path("translation-grid")
    public Response getTranslationGrid(@BeanParam final GetTranslationGridRequest request) {
        return Response.ok(translationServiceFacade.getTranslationGrid(request)).build();
    }

    @GET
    @Path("by-ui-location")
    public Response getAllByUiLocation(@BeanParam final GetAllTranslationsByUiLocationRequest request) {
        return Response.ok(translationServiceFacade.getAllByUiLocation(request)).build();
    }

    @POST
    @Path("message")
    @JacksonFeatures(serializationDisable = SerializationFeature.FAIL_ON_EMPTY_BEANS)
    public Response updateTranslationMessage(final UpdateTranslationMessageRequest request) {
        return Response.ok(translationServiceFacade.updateTranslationMessage(request)).build();
    }

    @GET
    @Path("for-indexation")
    public Response getForIndexation(@BeanParam final GetTranslationsForIndexationRequest request) {
        return Response.ok(translationServiceFacade.getForIndexation(request)).build();
    }

    @GET
    @Path("heartbeat")
    public Response getHeartBeat() {
        return Response.ok("OK").build();
    }
    //endregion
}
