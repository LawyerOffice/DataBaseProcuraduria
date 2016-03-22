/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procuradoria.crud;

import com.logger.L;
import java.math.BigDecimal;
import java.util.ArrayList;
import procuradoria.mail.util.MailTool;
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

    public static ArrayList<Uzatcita> GetCitasCalendar(String FechaActual) {
        ArrayList<Uzatcita> listCitas = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            listCitas = ProcuradoriaCrud.getCitasCalendar(FechaActual);
        } catch (Exception ex) {
            log.level.error("ERROR EN GETCITASCALENDAR : ");
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
        return listCitas;
    }

    public static ArrayList<Uzatcomt> GetFasesComentByIdCasoAndIdFase(BigDecimal uzatcasoId, BigDecimal uzatfaseId) {
        ArrayList<Uzatcomt> objFasesComent = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (uzatcasoId != null) {
                objFasesComent = ProcuradoriaCrud.getFasesComentByIdCasoAndIdFase(uzatcasoId, uzatfaseId);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN FINDFASESANDCOMTBYIDCASOANDIDFASE : ");
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

    public static Boolean SendMail(String Email, String filePath, String Nombre, String numCausa, String numFase, String lugar, String fecha) {
        MailTool mailTo = new MailTool();
        Boolean exito = true;
        if (!mailTo.sendEmailFile(Email, filePath, Nombre, numCausa, numFase, lugar, fecha)) {
            exito = false;
            log.level.info("Su notificación no pudo ser enviada, revise la direccion de correo.");
        }
        return exito;
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

    public static Uzatrol FindByIdFunciByCedFunci(String uzatfuncionarioIdbanner, String uzatfuncionarioCedula, BigDecimal uzatfuncionarioFlag, BigDecimal uzatrolFlag) {
        Uzatrol listFunci = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (uzatfuncionarioCedula != null && uzatfuncionarioIdbanner != null) {
                listFunci = ProcuradoriaCrud.findByIdFunciByCedFunci(uzatfuncionarioIdbanner, uzatfuncionarioCedula, uzatfuncionarioFlag, uzatrolFlag);
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
        return listFunci;
    }

    public static ArrayList<Uzatrol> GetAsigFunciRol(BigDecimal uztrolFlag) {
        ArrayList<Uzatrol> listRol = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (uztrolFlag != null) {
                listRol = ProcuradoriaCrud.getAsigFunciRol(uztrolFlag);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN >>> : " + ex.getMessage());
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

    public static ArrayList<Uzatasign> GetCasosAsigFunciByIdAsig(BigDecimal uzatasignarId) {
        ArrayList<Uzatasign> listRol = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (uzatasignarId != null) {
                listRol = ProcuradoriaCrud.getCasosAsigFunciByIdAsig(uzatasignarId);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN >>> : " + ex.getMessage());
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

    public static ArrayList<Uzatfase> listFasesByIdCaso(BigDecimal uztmateriaId) {
        ArrayList<Uzatfase> listfases = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            listfases = ProcuradoriaCrud.listFasesByIdCaso(uztmateriaId);
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
        return listfases;
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

        public static Uzatcaso CasoByIdCaso(BigDecimal uztcasoId) {
        Uzatcaso listCasos = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            listCasos = ProcuradoriaCrud.casoByIdCaso(uztcasoId);
        } catch (Exception ex) {
            log.level.error("ERROR EN LISTCASOBYIDCASO : ");
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

        public static Boolean InsertCita(Uzatcita cita) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (cita != null) {
                exito = ProcuradoriaCrud.insertCita(cita);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN Insert CITA : ");
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
    
    public static Boolean InsertComentario(Uzatcomt comt) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (comt != null) {
                exito = ProcuradoriaCrud.insertComentario(comt);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN Insert COMENTARIO : ");
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
    
        public static Boolean InsertFase(Uzatfase fase) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (fase != null) {
                exito = ProcuradoriaCrud.insertFase(fase);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN Insert FASE : ");
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
    
    public static Boolean InsertCaso(Uzatcaso caso) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (caso != null) {
                exito = ProcuradoriaCrud.insertCaso(caso);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN Insert CASO : ");
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

    public static ArrayList<Uzatcita> FindCitasbyCaso_Fase(BigDecimal uztcasoId, BigDecimal uzfaseId) {
        ArrayList<Uzatcita> listCitas = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (uztcasoId != null && uzfaseId != null) {
                listCitas = ProcuradoriaCrud.findCitasByCaso_Fase(uztcasoId, uzfaseId);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN FindCitabyCaso_Fase : ");
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
        return listCitas;
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

    public static ArrayList<Uzatjudi> findjudibyMateriId(BigDecimal uzatmateriaId) {
        ArrayList<Uzatjudi> listJudi = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (uzatmateriaId != null) {
                listJudi = ProcuradoriaCrud.findjudibyMateriId(uzatmateriaId);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN findjudibyMateriId : ");
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
        return listJudi;
    }

    public static Uzatjudi findjudi(BigDecimal uzatmateriaId, BigDecimal uzatjudiId) {
        Uzatjudi listJudi = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (uzatmateriaId != null) {
                listJudi = ProcuradoriaCrud.findJudi(uzatmateriaId, uzatjudiId);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN findjudi : ");
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
        return listJudi;
    }

    public static Uzatfunci FindFuncionarioByCedula(String cedula) {
        Uzatfunci findFun = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (cedula != null) {
                findFun = ProcuradoriaCrud.findFuncionarioByCedula(cedula);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN FindFuncionarioByCedula : ");
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

    public static ArrayList<Uzatcaso> FindCasosLazy(BigDecimal Flag, int first, int pageSize) {
        ArrayList<Uzatcaso> findCaso = new ArrayList<>();
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            findCaso = ProcuradoriaCrud.findCasosLazy(Flag, first, pageSize);
        } catch (Exception ex) {
            log.level.error("ERROR EN FindCasosLazy : ");
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
        return findCaso;
    }
    
    public static ArrayList<Uzatcaso> FindCasosLazy(BigDecimal uzatfuncionarioId,BigDecimal Flag, int first, int pageSize) {
        ArrayList<Uzatcaso> findCaso = new ArrayList<>();
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            findCaso = ProcuradoriaCrud.findCasosLazy(uzatfuncionarioId, Flag, first, pageSize);
        } catch (Exception ex) {
            log.level.error("ERROR EN FindCasosLazy : "+ex.getMessage());
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
        return findCaso;
    }

    public static ArrayList<Uzatasign> FindCasosAdminLazy(BigDecimal uzatfuncionarioId, BigDecimal uzatcasoFlag, BigDecimal uzatasignarFlag) {
        ArrayList<Uzatasign> findCaso = new ArrayList<>();
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            findCaso = ProcuradoriaCrud.findCasosAdminLazy(uzatfuncionarioId, uzatcasoFlag, uzatasignarFlag);
        } catch (Exception ex) {
            log.level.error("ERROR EN FindCasosAdminLazy : ");
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
        return findCaso;
    }

    public static Uzatcaso FindCasobyNumCausa(String numcausa) {
        Uzatcaso findCaso = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (numcausa != null) {
                findCaso = ProcuradoriaCrud.findCasobyNumCausa(numcausa);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN getCasobyNumCausa : ");
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
        return findCaso;
    }

    
    public static Boolean InsertNuevaAsignacion(Uzatasign asign) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (asign != null) {
                exito = ProcuradoriaCrud.insertNuevaAsignacion(asign);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN InsertNuevaAsignacion : ");
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

    public static Boolean UpdateFunci(Uzatfunci funci) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (funci != null) {
                exito = ProcuradoriaCrud.updateFuncionario(funci);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN UpdateFunci : ");
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
    
    
    public static Uzatcaso findCasobyId(BigDecimal id) {
        Uzatcaso findCaso = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (id != null) {
                findCaso = ProcuradoriaCrud.findCasobyId(id);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN FindCasobyId : ");
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
        return findCaso;
    }
        
    public static Uzatactor findActorbyCedula(String cedula) {
        Uzatactor findActor = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (cedula != null) {
                findActor = ProcuradoriaCrud.findActorbyCedula(cedula);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN findActorbyCedula : ");
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
        return findActor;
    }          
    
    public static Boolean UpdateActor(Uzatactor actor) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (actor != null) {
                exito = ProcuradoriaCrud.updateActor(actor);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN UpdateActor : ");
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
    
    public static Boolean UpdateCaso(Uzatcaso caso) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (caso != null) {
                exito = ProcuradoriaCrud.updateCaso(caso);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN UpdateCaso : ");
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
    
    public static Boolean InsertInvolCa(UzatinvCa involca) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (involca != null) {
                exito = ProcuradoriaCrud.insertInvolCa(involca);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN InsertInvolCa : ");
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
    
    public static Boolean insertAsign(Uzatasign asign) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (asign != null) {
                exito = ProcuradoriaCrud.insertAsign(asign);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN insertAsign : ");
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
