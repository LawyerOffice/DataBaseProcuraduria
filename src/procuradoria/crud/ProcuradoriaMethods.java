/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procuradoria.crud;

import com.logger.L;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import procuradoria.crud.tools.UpdateInvolFF;
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

    public static BigDecimal GetUltimaFaseIdByCaso(BigDecimal uzatcaso, BigDecimal uzatfaseFlag) {
        BigDecimal uzatfaseid = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (uzatcaso != null && uzatfaseFlag != null) {
                uzatfaseid = ProcuradoriaCrud.getUltimaFaseIdByCaso(uzatcaso, uzatfaseFlag);
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
        return uzatfaseid;
    }

    public static BigDecimal GetNumberFacesOpenCloseByNumCausa(BigDecimal uzatcasoid, BigDecimal uzatfaseFlag) {
        BigDecimal uzatfaseid = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (uzatcasoid != null && uzatfaseFlag != null) {
                uzatfaseid = ProcuradoriaCrud.getNumberFacesOpenCloseByNumCausa(uzatcasoid, uzatfaseFlag);
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
        return uzatfaseid;
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

    public static Uzatcaso CasoByNumCausaFlagVisible(String uztnumCausa, BigDecimal uztflagVisible) {
        Uzatcaso listCasos = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            listCasos = ProcuradoriaCrud.casoByNumCausaFlagVisible(uztnumCausa, uztflagVisible);
        } catch (Exception ex) {
            log.level.error("ERROR EN LISTCASOBYNUMCAUSAFLAGVISIBLE : ");
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

    public static Boolean InsertDocs(Uzatdocs docs, InputStream pdfBytes, long pdfSize) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (docs != null) {
                exito = ProcuradoriaCrud.insertDocs(docs, pdfBytes, pdfSize);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN LISTTIPOROL : " + ex.getMessage());
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

    public static Boolean InsertDocs(Uzatdocs docs) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (docs != null) {
                exito = ProcuradoriaCrud.insertDocs(docs);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN LISTTIPOROL : " + ex.getMessage());
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

    public static Boolean InsertDocumemts(Uzatdocs docs, String urlpdf) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (docs != null && urlpdf != null) {
                exito = ProcuradoriaCrud.insertDocument(docs, urlpdf);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN LISTTIPOROL : " + ex.getMessage());
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

    public static Boolean InsertDocumemts(Uzatdocs docs, String urlpdf, int type) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (docs != null && urlpdf != null) {
                exito = ProcuradoriaCrud.insertDocument(docs, urlpdf, type);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN LISTTIPOROL : " + ex.getMessage());
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

    public static Boolean UpdateFase(Uzatfase fase) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (fase != null) {
                exito = ProcuradoriaCrud.updateFase(fase);
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

    public static Boolean UpdateUzatInvolfff(UpdateInvolFF Ids, UzatinvFf involff) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (involff != null) {
                exito = ProcuradoriaCrud.updateUzatInvolff(Ids, involff);
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

    public static Boolean UpdateCita(Uzatcita cita) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (cita != null) {
                exito = ProcuradoriaCrud.updateCita(cita);
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

    public static Uzatfunci FindFuncionarioByIdFunci(BigDecimal IdFunci) {
        Uzatfunci findFun = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (IdFunci != null) {
                findFun = ProcuradoriaCrud.findFuncionarioByIdFunci(IdFunci);
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

    public static ArrayList<Uzatcaso> FindCasosLazy(BigDecimal uzatfuncionarioId, BigDecimal Flag, int first, int pageSize) {
        ArrayList<Uzatcaso> findCaso = new ArrayList<>();
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            findCaso = ProcuradoriaCrud.findCasosLazy(uzatfuncionarioId, Flag, first, pageSize);
        } catch (Exception ex) {
            log.level.error("ERROR EN FindCasosLazy : " + ex.getMessage());
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

    public static ArrayList<Uzatasign> FindCasosAdminLazyByNumCausa(BigDecimal uzatfuncionarioId, BigDecimal uzatcasoFlag, BigDecimal uzatasignarFlag, String numCausa) {
        ArrayList<Uzatasign> findCaso = new ArrayList<>();
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            findCaso = ProcuradoriaCrud.findCasosAdminLazyByNumCausa(uzatfuncionarioId, uzatcasoFlag, uzatasignarFlag, numCausa);
        } catch (Exception ex) {
            log.level.error("ERROR EN FindCasosAdminLazyByNumCausa : ");
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

    public static ArrayList<Uzatasign> FindCasosAdminLazyByNumCausaGen(BigDecimal uzatasignarFlag, String numCausa) {
        ArrayList<Uzatasign> findCaso = new ArrayList<>();
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            findCaso = ProcuradoriaCrud.findCasosAdminLazyByNumCausaGen(uzatasignarFlag, numCausa);
        } catch (Exception ex) {
            log.level.error("ERROR EN FindCasosAdminLazyByNumCausaGen : ");
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

    public static ArrayList<Uzatasign> FindCasosAdminLazyByNumCausaMateria(BigDecimal uzatasignarFlag, String numCausa, BigDecimal idMateria) {
        ArrayList<Uzatasign> findCaso = new ArrayList<>();
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            findCaso = ProcuradoriaCrud.findCasosAdminLazyByNumCausaMateria(uzatasignarFlag, numCausa, idMateria);
        } catch (Exception ex) {
            log.level.error("ERROR EN FindCasosAdminLazyByNumCausaMateria : ");
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

    public static ArrayList<Uzatasign> FindCasosAdminLazyByVinculacion(String cedula, String numCausa) {
        ArrayList<Uzatasign> findCaso = new ArrayList<>();
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            findCaso = ProcuradoriaCrud.findCasosAdminLazyByVinculacion(cedula, numCausa);
        } catch (Exception ex) {
            log.level.error("ERROR EN FindCasosAdminLazyByVinculacion : ");
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

    public static ArrayList<Uzatasign> FindCasosReasignar(String uzatfuncionarioId) {
        ArrayList<Uzatasign> findCaso = new ArrayList<>();
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            findCaso = ProcuradoriaCrud.findCasosReasignar(uzatfuncionarioId);
        } catch (Exception ex) {
            log.level.error("ERROR EN FindCasosReasignar : ");
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

    public static Uzatcaso FindCasobyNumCausa2(String numcausa) {
        //Coje el caso con un join a judi para tener la descripcion de la judicatura
        Uzatcaso findCaso = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (numcausa != null) {
                findCaso = ProcuradoriaCrud.findCasobyNumCausa2(numcausa);
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

    public static Boolean insertActor(Uzatactor actor) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (actor != null) {
                exito = ProcuradoriaCrud.insertActor(actor);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN insertActor : ");
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

    public static Boolean insertInvFf(UzatinvFf involff) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (involff != null) {
                exito = ProcuradoriaCrud.insertinvff(involff);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN insertActor : ");
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

    public static Uzatactor findActorbyIDBanner(String id) {
        Uzatactor findActor = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (id != null) {
                findActor = ProcuradoriaCrud.findActorbyIDBanner(id);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN findActorbyIDBanner : ");
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

    public static int findNumerosdeCasosbyMateri(String materi) {
        int temp = 0;

        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;

        try {
            if (materi != null) {
                temp = ProcuradoriaCrud.findNumerosdeCasosbyMateri(materi);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN findNumerosdeCasosbyMateri : ");
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
        return temp;
    }

    public static int findNumerosdeCasosbyJudi(String judi) {
        int temp = 0;

        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;

        try {
            if (judi != null) {
                temp = ProcuradoriaCrud.findNumerosdeCasosbyJudi(judi);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN findNumerosdeCasosbyJudi : ");
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
        return temp;
    }

    public static Boolean insertMateria(Uzatmateri materia) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (materia != null) {
                exito = ProcuradoriaCrud.insertMateria(materia);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN insertMateria : ");
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

    public static Boolean insertJudicatura(Uzatjudi judicatura) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (judicatura != null) {
                exito = ProcuradoriaCrud.insertJudicatura(judicatura);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN insertJudicatura : ");
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

    public static Boolean UpdateMateria(Uzatmateri materia) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (materia != null) {
                exito = ProcuradoriaCrud.updateMateria(materia);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN UpdateMateria : ");
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

    public static Boolean UpdateJudicatura(Uzatjudi judicatura) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (judicatura != null) {
                exito = ProcuradoriaCrud.updateJudicatura(judicatura);
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN UpdateJudicatura : ");
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

    public static boolean DeleteMateriabyId(BigDecimal id) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (id != null) {
                if (ProcuradoriaCrud.deleteMateriabyId(id)) {
                    exito = true;
                }
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN deleteMateriabyId : ");
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

    public static Uzatmateri FindMateriabyId(BigDecimal id) {
        Uzatmateri materi = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (id != null) {
                materi = ProcuradoriaCrud.findMateriabyId(id);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN FindMateriabyId : ");
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
        return materi;
    }

    public static Uzatfunci FindFuncionarioByIDBanner(String idbanner) {
        Uzatfunci findFun = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (idbanner != null) {
                findFun = ProcuradoriaCrud.findFuncionarioByIDBanner(idbanner);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN FindFuncionarioByIDBanner : ");
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

    public static Uzatmateri findMateribyJudiId(BigDecimal judiID) {
        Uzatmateri findMateri = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (judiID != null) {
                findMateri = ProcuradoriaCrud.findMateribyJudiId(judiID);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN findMateribyJudiId : ");
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
        return findMateri;
    }

    public static Uzatmateri findmateribynombre(String nombre) {
        Uzatmateri materi = null;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;
        try {
            if (nombre != null) {
                materi = ProcuradoriaCrud.findmateribynombre(nombre);
            }

        } catch (Exception ex) {
            log.level.error("ERROR EN findmateribynombre : ");
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
        return materi;
    }

    public static Boolean DeleteJudi(BigDecimal materiID, BigDecimal judiID) {
        Boolean exito = false;
        ProcuradoriaHibernateSessionHandler hss = new ProcuradoriaHibernateSessionHandler();
        Exception delegateException = null;

        try {
            if (materiID != null && judiID != null) {
                if (ProcuradoriaCrud.deleteJudi(materiID, judiID)) {
                    exito = true;
                }
            }
        } catch (Exception ex) {
            log.level.error("ERROR EN DeleteJudi : ");
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
