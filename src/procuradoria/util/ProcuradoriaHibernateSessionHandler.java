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
    
    private SessionFactory ProcuraduriaSession;
    private final static L log = new L(ProcuradoriaHibernateSessionHandler.class);

    public ProcuradoriaHibernateSessionHandler() {

        ProcuraduriaSession = ProcuraduriaHibernateUtil.getSessionFactory();

        try {
            ProcuraduriaSession.getCurrentSession().beginTransaction();

        } catch (Exception e) {
            log.level.error("Error en la sesion de Hibernate", e);
        }
    }

    public void close() {
        try {
            ProcuraduriaSession.getCurrentSession().getTransaction().commit();
        } catch (Exception e) {
            if (ProcuraduriaSession.getCurrentSession().getTransaction().isActive()) {
                log.level.error("Trying to rollback database transaction after exception. Módulo RapidLoans_Users.", e);
                ProcuraduriaSession.getCurrentSession().getTransaction().rollback();
            }
            log.level.error("Error al cerrar la sesion de Hibernate", e);
        } finally {
            ProcuraduriaSession.getCurrentSession().close();
        }

    }
    
    
}
