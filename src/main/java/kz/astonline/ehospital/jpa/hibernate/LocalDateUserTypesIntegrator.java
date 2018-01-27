package kz.astonline.ehospital.jpa.hibernate;


import kz.astonline.ehospital.jpa.hibernate.usertypes.LocalDateUserType;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.metamodel.source.MetadataImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;

import java.io.Serializable;

public class LocalDateUserTypesIntegrator implements Integrator, Serializable {

    public void integrate(Configuration configuration,
                          SessionFactoryImplementor sessionFactory,
                          SessionFactoryServiceRegistry serviceRegistry) {
        // Register the custom user type mapping(s) with Hibernate.
        LocalDateUserType customUserType = new LocalDateUserType();
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
