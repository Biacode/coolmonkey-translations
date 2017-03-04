package com.sfl.coolmonkey.translations.facade.helper.conversion;

import com.sfl.coolmonkey.translations.api.model.translation.TranslationIndexationModel;
import com.sfl.coolmonkey.translations.service.translation.model.Translation;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 10/1/15
 * Time: 6:48 PM
 */
@Primary
@Component
@SuppressWarnings("unused")
public class MapperFacadeFactory extends AbstractFactoryBean<MapperFacade> {

    //region Constructors
    public MapperFacadeFactory() {
    }
    //endregion

    //region Public methods
    @Override
    public Class<?> getObjectType() {
        return MapperFacade.class;
    }

    @Override
    public MapperFacade createInstance() {
        final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Translation.class, TranslationIndexationModel.class).byDefault().register();
        return mapperFactory.getMapperFacade();
    }
    //endregion
}
