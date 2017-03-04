package com.sfl.coolmonkey.translations.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * User: Babken Vardanyan
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/28/15
 * Time: 11:15 AM
 */
@Aspect
@Component
@SuppressWarnings({
        "checkstyle:com.puppycrawl.tools.checkstyle.checks.coding.IllegalThrowsCheck",
        "squid:S00112",
})
public class ServiceMethodLoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceMethodLoggingAspect.class);

    //region Constructors
    public ServiceMethodLoggingAspect() {
    }
    //endregion

    //region Public methods
    @Around("execution(public * com.sfl.coolmonkey.translations.service..* (..))" +
            " && !execution(* com.sfl.coolmonkey.translations.service.helper..* (..))" +
            " && !execution(* com.sfl.coolmonkey.translations.service.translation.TranslationService.getAllByLocale (..))" +
            " && !execution(* com.sfl.coolmonkey.translations.service.translation.TranslationService.getAllByLocaleAndUiLocation (..))")
    public Object around(final ProceedingJoinPoint point) throws Throwable {
        final long start = System.currentTimeMillis();
        final Object result = point.proceed();
        LOGGER.info(
                "#{}.{}({}): {} in {}ms",
                point.getSignature().getDeclaringType().getSimpleName(),
                point.getSignature().getName(),
                point.getArgs(),
                result,
                System.currentTimeMillis() - start
        );
        return result;
    }
    //endregion
}
