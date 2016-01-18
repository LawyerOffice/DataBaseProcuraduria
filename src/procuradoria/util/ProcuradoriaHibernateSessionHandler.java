/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package procuradoria.util;

import com.logger.L;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ivan
 */
public class ProcuradoriaHibernateSessionHandler {
    
    private SessionFactory RapidLoansSession;
    private final static L log = new L(ProcuradoriaHibernateSessionHandler.class);

    public ProcuradoriaHibernateSessionHandler() {

        RapidLoansSession = ProcuraduriaHibernateUtil.getSessionFactory();

        try {
            RapidLoansSession.getCurrentSession().beginTransaction();

        } catch (Exception e) {
            log.level.error("Error en la sesion de Hibernate", e);
        }
    }

    public void close() {
        try {
            RapidLoansSession.getCurrentSession().getTransaction().commit();
        } catch (Exception e) {
            if (RapidLoansSession.getCurrentSession().getTransaction().isActive()) {
                log.level.error("Trying to rollback database transaction after exception. Módulo RapidLoans_Users.", e);
                RapidLoansSession.getCurrentSession().getTransaction().rollback();
            }
            log.level.error("Error al cerrar la sesion de Hibernate", e);
        } finally {
            RapidLoansSession.getCurrentSession().close();
        }

    }
    
    
}
