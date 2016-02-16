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

    public static ArrayList<Uzattrol> ListTipoRol() {
        ArrayList<Uzattrol> listTipoRol = null;
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

        public static ArrayList<Uzatcomt> GetFasesComentByIdCaso(BigDecimal uzatcasoId) {
        ArrayList<Uzatcomt> objFasesComent = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (uzatcasoId != null) {
                objFasesComent = ProcuradoriaCrud.getFasesComentByIdCaso(uzatcasoId);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN FINDFASESANDCOMTBYIDCASO : ");
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
        return objFasesComent;
    }
    
    public static Uzatasign GetActiveAbogadosByIdCaso(BigDecimal uzatcasoId) {
        Uzatasign objAsign = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (uzatcasoId != null) {
                objAsign = ProcuradoriaCrud.getActiveAbogadosByIdCaso(uzatcasoId);
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
        return objAsign;
    }

    public static ArrayList<Uzatrol> FindRolByIdFuncionario(BigDecimal uztfuncionarioId, BigDecimal uztrolFlag) {
        ArrayList<Uzatrol> listRol = null;
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
    
    public static ArrayList<Uzatrol> FindRolsAndFuciByFlag(BigDecimal uztrolFlag) {
        ArrayList<Uzatrol> listRol = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (uztrolFlag != null) {
                listRol = ProcuradoriaCrud.findRolsAndFuciByFlag(uztrolFlag);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN >>> : "+ex.getMessage());
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

    public static ArrayList<Uzatfunci> ListFuncionarios(BigDecimal uztfuncionarioFlag) {
        ArrayList<Uzatfunci> listFuncionarios = null;
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

    public static ArrayList<Uzatfunci> ListActiveAbogados() {
        ArrayList<Uzatfunci> listActiveAbogados = null;
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

    public static ArrayList<Uzatmateri> ListMaterias() {
        ArrayList<Uzatmateri> listMaterias = null;
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

    public static ArrayList<Uzatjudi> listJudicaturas(BigDecimal uztmateriaId) {
        ArrayList<Uzatjudi> listJudicaturas = null;
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

    public static ArrayList<Uzatcaso> ListCasosByFlag(BigDecimal uztcasoFlag) {
        ArrayList<Uzatcaso> listCasos = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            listCasos = ProcuradoriaCrud.listCasosByFlag(uztcasoFlag);
        } catch (Exception ex) {
            log.level.error("ERROR EN LISTCASOBYFLAG : ");
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

    public static Boolean InsertDocs(Uzatdocs docs) {
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
    public static ArrayList<Uzatdocs> FindDocsbyCaso_Fase(BigDecimal uztcasoId, BigDecimal uzfaseId) {
        ArrayList<Uzatdocs> listDocs = null;
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

    public static ArrayList<Uzatcaso> GetActiveCasos() {
        ArrayList<Uzatcaso> listCasos = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {

            listCasos = ProcuradoriaCrud.getActiveCasos();

        } catch (Exception ex) {
            log.level.error("ERROR EN GetActiveCasos : ");
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

    public static ArrayList<Uzatrol> GetFuncionariosTipoRolByFlag(BigDecimal UztFlag) {
        ArrayList<Uzatrol> listRol = null;
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

    public static Boolean InsertRol(Uzatrol rol) {
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

    public static Boolean UpdateRol(Uzatrol rol) {
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

    public static Boolean InserFuncionario(Uzatfunci fun) {
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

    public static Uzatfunci FindFuncionarioByCedulaOrIdBanner(String claveFuncionario) {
        Uzatfunci findFun = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (claveFuncionario != null) {
                findFun = ProcuradoriaCrud.findFuncionarioByCedulaOrIdBanner(claveFuncionario);
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
        return findFun;
    }
}
