package kz.astonline.ehospital.jpa.hibernate;

import kz.astonline.ehospital.jpa.hibernate.usertypes.LocalDateTimeUserType;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

import java.io.Serializable;

public class LocalDateTimeUserTypesIntegrator implements Integrator, Serializable {

    public void integrate(Configuration configuration,
                          SessionFactoryImplementor sessionFactory,
                          SessionFactoryServiceRegistry serviceRegistry) {
        // Register the custom user type mapping(s) with Hibernate.
        LocalDateTimeUserType customUserType = new LocalDateTimeUserType();
        configuration.registerTypeOverride(customUserType,
                new String[] { customUserType.returnedClass().getName() });
    }

    public void integrate(MetadataImplementor metadata,
                          SessionFactoryImplementor sessionFactory,
                          SessionFactoryServiceRegistry serviceRegistry) {
        // Nothing to do here.
    }

    public void disintegrate(SessionFactoryImplementor sessionFactory,
                             SessionFactoryServiceRegistry serviceRegistry) {
        // Nothing to do here.
    }
}
