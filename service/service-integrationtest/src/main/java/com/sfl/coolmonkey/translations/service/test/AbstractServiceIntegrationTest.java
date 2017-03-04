package com.sfl.coolmonkey.translations.service.test;

import com.sfl.coolmonkey.translations.service.helper.ServiceIntegrationTestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 7/3/15
 * Time: 3:49 PM
 */
@Service
@ContextConfiguration("classpath:applicationContext-service-integrationtest.xml")
public abstract class AbstractServiceIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    /* Properties */
    @Autowired
    private ServiceIntegrationTestHelper helper;

    @PersistenceContext
    private EntityManager entityManager;

    /* Constructors */
    public AbstractServiceIntegrationTest() {
    }

    /* Utility methods */
    protected void flush() {
        entityManager.flush();
    }

    protected void clear() {
        entityManager.clear();
    }

    protected void flushAndClear() {
        flush();
        clear();
    }

    /* Properties getters and setters */
    public ServiceIntegrationTestHelper getHelper() {
        return helper;
    }
}
