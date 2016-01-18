/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procuradoria.crud;

import com.logger.L;
import java.util.ArrayList;
import procuradoria.map.Uzttiporol;
import procuradoria.util.ProcuradoriaHibernateSessionHandler;
import procuradoria.util.ProcuraduriaHibernateUtil;

/**
 *
 * @author Ivan
 */
public class ProcuradoriaMethods {

    private final static L log = new L(ProcuradoriaMethods.class);

    static {
        ProcuraduriaHibernateUtil.init();
    }

    public static ArrayList<Uzttiporol> ListTipoRol() {
        ArrayList<Uzttiporol> listTipoRol = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            listTipoRol = ProcuradoriaCrud.listTipoRol();
        } catch (Exception ex) {
            log.level.error("ERROR EN LISTTIPOROL : ");
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return listTipoRol;
    }
    
    public static ArrayList<Uzttiporol> ListTipoRol_1() {
        ArrayList<Uzttiporol> listTipoRol = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {

        } catch (Exception ex) {
            log.level.error("ERROR EN LISTTIPOROL : ");
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return listTipoRol;
    }
    
    public static ArrayList<Uzttiporol> ListTipoRol_2() {
        ArrayList<Uzttiporol> listTipoRol = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {

        } catch (Exception ex) {
            log.level.error("ERROR EN LISTTIPOROL : ");
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return listTipoRol;
    }
    
    public static ArrayList<Uzttiporol> ListTipoRol_3() {
        ArrayList<Uzttiporol> listTipoRol = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {

        } catch (Exception ex) {
            log.level.error("ERROR EN LISTTIPOROL : ");
            delegateException = ex;
        } finally {
            hss.close();
            if (delegateException != null) {
                try {
                    throw delegateException;
                } catch (Exception ex) {
                    log.level.info("delageException " + ex.toString());
                }
            }
        }
        return listTipoRol;
    }

}
