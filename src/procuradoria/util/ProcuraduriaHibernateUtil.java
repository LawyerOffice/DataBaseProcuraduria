/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package procuradoria.util;

import com.logger.L;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Ivan
 */
public class ProcuraduriaHibernateUtil {

    private final static L log = new L(ProcuraduriaHibernateUtil.class);
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry sessionServiceRegistry;
    
    
    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("/procuradoria_hibernate.cfg.xml");
            sessionServiceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(sessionServiceRegistry);
        } catch (Throwable ex) {
            log.level.info("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void init() {
        if (sessionFactory == null) {
            throw new NullPointerException("No se inicializo el tipo de producto previamente. No se creo la conexion.");
        } else {
            log.level.info("Se ha iniciado la sesion de Hiberate");
        }
    }
}
