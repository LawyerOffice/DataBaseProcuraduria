/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procuradoria.crud;

import com.logger.L;
import java.math.BigDecimal;
import java.util.ArrayList;
import procuradoria.map.*;
import procuradoria.util.*;

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
    
    public static ArrayList<Uztrol> FindRolByIdFuncionario(BigDecimal uztfuncionarioId, BigDecimal uztrolFlag) {
        ArrayList<Uztrol> listRol = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if(uztfuncionarioId != null && uztrolFlag != null){
                listRol = ProcuradoriaCrud.findRolByIdFuncionario(uztfuncionarioId, uztrolFlag);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN FINDROLBYFUNCIONARIO : ");
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
        return listRol;
    }

    public static ArrayList<Uztfuncionario> ListFuncionarios(BigDecimal uztfuncionarioFlag) {
        ArrayList<Uztfuncionario> listFuncionarios = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (uztfuncionarioFlag != null) {
                listFuncionarios = ProcuradoriaCrud.listFuncionarios(uztfuncionarioFlag);
            }
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
        return listFuncionarios;
    }

    

    public static ArrayList<Uztmateria> ListMaterias() {
        ArrayList<Uztmateria> listMaterias = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            listMaterias = ProcuradoriaCrud.listMaterias();
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
        return listMaterias;
    }
    
    
    public static ArrayList<Uztjudi> listJudicaturas(BigDecimal uztmateriaId) {
        ArrayList<Uztjudi> listJudicaturas = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            listJudicaturas = ProcuradoriaCrud.listJudicaturas(uztmateriaId);
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
        return listJudicaturas;
    }
    
    public static ArrayList<Uztcaso> ListCasosByFlag(BigDecimal uztcasoFlag) {
        ArrayList<Uztcaso> listCasos = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            listCasos = ProcuradoriaCrud.listCasosByFlag(uztcasoFlag);
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
        return listCasos;
    }

}
