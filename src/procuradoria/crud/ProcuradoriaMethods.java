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
            if (uztfuncionarioId != null && uztrolFlag != null) {
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

    public static ArrayList<Uztfuncionario> ListActiveAbogados() {
        ArrayList<Uztfuncionario> listActiveAbogados = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            listActiveAbogados = ProcuradoriaCrud.listActiveAbogados();
        } catch (Exception ex) {
            log.level.error("ERROR EN PROCESO ACTIVEABOGADOS : ");
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
        return listActiveAbogados;
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

    public static Boolean InsertDocs(Uztdocs docs) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (docs != null) {
                exito = ProcuradoriaCrud.insertDocs(docs);
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
        return exito;
    }
    
    
//Modificado por Dennis Santamaria
    
    public static ArrayList<Uztdocs> FindDocsbyCaso_Fase(BigDecimal uztcasoId, BigDecimal uzfaseId) {
        ArrayList<Uztdocs> listDocs = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (uztcasoId != null && uzfaseId != null) {
                listDocs = ProcuradoriaCrud.findDocsByCaso_Fase(uztcasoId, uzfaseId);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN FindDocsbyCaso_Fase : ");
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
        return listDocs;
    }
    
    
    public static ArrayList<Uztrol> GetFuncionariosTipoRolByFlag(BigDecimal UztFlag) {
        ArrayList<Uztrol> listRol = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (UztFlag != null) {
                listRol = ProcuradoriaCrud.getFuncionariosTipoRolByFlag(UztFlag);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN FindDocsbyCaso_Fase : ");
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
    
    public static Boolean InsertRol(Uztrol rol) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (rol != null) {
                exito = ProcuradoriaCrud.insertRol(rol);
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
        return exito;
    }
    
    public static Boolean UpdateRol(Uztrol rol) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (rol != null) {
                exito = ProcuradoriaCrud.updateRol(rol);
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
        return exito;
    }
    
    public static Boolean InserFuncionario(Uztfuncionario fun) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (fun != null) {
                exito = ProcuradoriaCrud.insertFuncionario(fun);
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
        return exito;
    }
}
