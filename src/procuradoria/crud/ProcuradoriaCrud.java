/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procuradoria.crud;

import com.dao.DAOServices;
import com.dao.QueryParameter;
import com.logger.L;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.NUMBER;
import org.hibernate.HibernateException;
import org.hibernate.jdbc.ReturningWork;
import procuradoria.map.*;
import procuradoria.util.ProcuraduriaHibernateUtil;

/**
 *
 * @author Ivan
 */
public class ProcuradoriaCrud {

    public final static L log = new L(ProcuradoriaCrud.class);

    public static ArrayList<Uzattrol> listTipoRol() {
        ArrayList<Uzattrol> listTipoRol = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        List parameList = new ArrayList();
        List<Uzattrol> list = ds.customQuery(parameList, Uzattrol.class);
        try {
            if (!list.isEmpty()) {
                listTipoRol = (ArrayList<Uzattrol>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR  LISTTIPOROL : " + ex.toString());
        }
        return listTipoRol;
    }
//flag en 1 rol en funcionamiento en el trnascurso del tiempo para un los funcioanrios

    public static ArrayList<Uzatrol> findRolByIdFuncionario(BigDecimal uztfuncionarioId, BigDecimal uztrolFlag) {
        ArrayList<Uzatrol> listRol = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_1.setColumnName("id.uztfuncionarioId");
        query_1.setWhereClause("=");
        query_1.setValue(uztfuncionarioId);
        //uztrolFlag
        QueryParameter query_2 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_2.setColumnName("uztrolFlag");
        query_2.setWhereClause("=");
        query_2.setValue(uztrolFlag);
        List parameList = new ArrayList();
        parameList.add(query_1);
        parameList.add(query_2);
        List<Uzatrol> list = ds.customQuery(parameList, Uzatrol.class);
        try {
            if (!list.isEmpty()) {
                listRol = (ArrayList<Uzatrol>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR  LISTROL : " + ex.toString());
        }
        return listRol;
    }

    public static Uzatrol findByIdFunciByCedFunci(final String uzatfuncionarioIdbanner, final String uzatfuncionarioCedula,
            final BigDecimal uzatfuncionarioFlag, final BigDecimal uzatrolFlag) {

        ArrayList<Uzatrol> listDzts = null;
        Uzatrol fun = null;
        try {
            listDzts = ProcuraduriaHibernateUtil.getSessionFactory().getCurrentSession().doReturningWork(new ReturningWork<ArrayList<Uzatrol>>() {

                @Override
                public ArrayList<Uzatrol> execute(Connection cnctn) throws SQLException {
                    CallableStatement f1 = cnctn.prepareCall(" { ? = call UZAFGFRTR(?,?,?,?) } ");
                    f1.registerOutParameter(1, OracleTypes.CURSOR);
                    f1.setString(2, uzatfuncionarioIdbanner);
                    f1.setString(3, uzatfuncionarioCedula);
                    f1.setBigDecimal(4, uzatfuncionarioFlag);
                    f1.setBigDecimal(5, uzatrolFlag);
                    f1.execute();
                    ResultSet rs = ((OracleCallableStatement) f1).getCursor(1);
                    ArrayList<Uzatrol> list = new ArrayList<>();
                    while (rs.next()) {
                        Uzatrol rol = new Uzatrol();
                        rol.getUzatfunci().setUzatfuncionarioId(rs.getBigDecimal(1));
                        rol.getUzatfunci().setUzatfuncionarioNombres(rs.getString(2));
                        rol.getUzatfunci().setUzatfuncionarioApellidos(rs.getString(3));
                        rol.getUzatfunci().setUzatfuncionarioCedula(rs.getString(4));
                        rol.getUzatfunci().setUzatfuncionarioIdbanner(rs.getString(5));
                        rol.getUzatfunci().setUzatfuncionarioEmail(rs.getString(6));
                        rol.getUzatfunci().setUzatfuncionarioFlag(rs.getBigDecimal(7));
                        rol.setUzatrolFechaIn(rs.getString(8));
                        rol.setUzatrolFechaOut(rs.getString(9));
                        rol.setUzatrolFlag(rs.getBigDecimal(10));
                        rol.getUzattrol().setUzattiporolId(rs.getBigDecimal(11));
                        rol.getUzattrol().setUzattiporolDescripcion(rs.getString(12));
                        list.add(rol);
                    }
                    rs.close();
                    rs = null;

                    return list;
                }
            });

        } catch (Exception ex) {
            log.level.info(">>> " + ex.toString());
        }
        if (!listDzts.isEmpty()) {
            fun = listDzts.get(0);
        }
        return fun;
    }

    public static ArrayList<Uzatrol> getAsigFunciRol(final BigDecimal uzatflag) {
        ArrayList<Uzatrol> listDzts = null;
        try {
            listDzts = ProcuraduriaHibernateUtil.getSessionFactory().getCurrentSession().doReturningWork(new ReturningWork<ArrayList<Uzatrol>>() {

                @Override
                public ArrayList<Uzatrol> execute(Connection cnctn) throws SQLException {
                    CallableStatement f1 = cnctn.prepareCall(" { ? = call uzafasgfr(?) } ");
                    f1.registerOutParameter(1, OracleTypes.CURSOR);
                    f1.setBigDecimal(2, uzatflag);
                    f1.execute();
                    ResultSet rs = ((OracleCallableStatement) f1).getCursor(1);
                    ArrayList<Uzatrol> list = new ArrayList<>();
                    while (rs.next()) {
                        Uzatrol rol = new Uzatrol();
                        rol.getId().setUzatfuncionarioId(rs.getBigDecimal(1));
                        rol.getId().setUzatrolId(rs.getBigDecimal(2));
                        rol.getId().setUzattiporolId(rs.getBigDecimal(3));
                        rol.getUzatfunci().setUzatfuncionarioNombres(rs.getString(4));
                        rol.getUzatfunci().setUzatfuncionarioApellidos(rs.getString(5));
                        rol.getUzatfunci().setUzatfuncionarioIdbanner(rs.getString(6));
                        rol.getUzatfunci().setUzatfuncionarioCedula(rs.getString(7));
                        rol.getUzatfunci().setUzatfuncionarioEmail(rs.getString(8));
                        rol.setUzatrolFechaIn(rs.getString(9));
                        rol.getUzattrol().setUzattiporolDescripcion(rs.getString(10));
                        list.add(rol);
                    }
                    rs.close();
                    rs = null;

                    return list;
                }
            });

        } catch (Exception ex) {
            log.level.info(">>> " + ex.toString());
        }

        return listDzts;
    }

    public static ArrayList<Uzatasign> getCasosAsigFunciByIdAsig(final BigDecimal uzatasignarId) {
        ArrayList<Uzatasign> listDzts = null;
        try {
            listDzts = ProcuraduriaHibernateUtil.getSessionFactory().getCurrentSession().doReturningWork(new ReturningWork<ArrayList<Uzatasign>>() {

                @Override
                public ArrayList<Uzatasign> execute(Connection cnctn) throws SQLException {
                    CallableStatement f1 = cnctn.prepareCall(" { ? = call UZAFGCASG(?) } ");
                    f1.registerOutParameter(1, OracleTypes.CURSOR);
                    f1.setBigDecimal(2, uzatasignarId);
                    f1.execute();
                    ResultSet rs = ((OracleCallableStatement) f1).getCursor(1);
                    ArrayList<Uzatasign> list = new ArrayList<>();
                    while (rs.next()) {
                        Uzatasign asg = new Uzatasign();
                        asg.setUzatasignarId(rs.getBigDecimal(1));
                        asg.getUzatfunci().setUzatfuncionarioNombres(rs.getString(2));
                        asg.getUzatfunci().setUzatfuncionarioApellidos(rs.getString(3));
                        asg.getUzatcaso().setUzatcasoNumcausa(rs.getString(4));
                        asg.setUzatasignarFechaIn(rs.getString(5));
                        list.add(asg);
                    }
                    rs.close();
                    rs = null;

                    return list;
                }
            });

        } catch (Exception ex) {
            log.level.info(">>> " + ex.toString());
        }

        return listDzts;
    }

    public static ArrayList<Uzatfunci> listFuncionarios(BigDecimal uztfuncionarioFlag) {
        ArrayList<Uzatfunci> listFuncionario = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_1.setColumnName("uztfuncionarioFlag");
        query_1.setWhereClause("=");
        query_1.setValue(uztfuncionarioFlag);
        List parameList = new ArrayList();
        parameList.add(query_1);
        List<Uzatfunci> list = ds.customQuery(parameList, Uzatfunci.class);
        try {
            if (!list.isEmpty()) {
                listFuncionario = (ArrayList<Uzatfunci>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR LISTAFUNCIONARIO : " + ex.toString());
        }
        return listFuncionario;
    }

    public static ArrayList<Uzatfunci> listActiveAbogados() {
        ArrayList<Uzatfunci> listFuncionario = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
//        query_1.setColumnName("uztfuncionarioFlag");
//        query_1.setWhereClause("=");
//        query_1.setValue(uztfuncionarioFlag);
        List parameList = new ArrayList();
        parameList.add(query_1);
        List<Uzatfunci> list = ds.customQuery(parameList, Uzatfunci.class);
        try {
            if (!list.isEmpty()) {
                listFuncionario = (ArrayList<Uzatfunci>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR PROCESO ACTIVEABOGADOS : " + ex.toString());
        }
        return listFuncionario;
    }

    public static ArrayList<Uzatmateri> listMaterias() {
        ArrayList<Uzatmateri> listMaterias = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        List parameList = new ArrayList();
        List<Uzatmateri> list = ds.customQuery(parameList, Uzatmateri.class);
        try {
            if (!list.isEmpty()) {
                listMaterias = (ArrayList<Uzatmateri>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR LISTAMATERIAS : " + ex.toString());
        }
        return listMaterias;
    }

    public static ArrayList<Uzatfase> listFasesByIdCaso(BigDecimal uztcasoId) {
        ArrayList<Uzatfase> listFases = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_1.setColumnName("id.uzatcasoId");
        query_1.setWhereClause("=");
        query_1.setValue(uztcasoId);

        List parameList = new ArrayList();
        parameList.add(query_1);
        List<Uzatfase> list = ds.customQuery(parameList, Uzatfase.class);
        try {
            if (!list.isEmpty()) {
                listFases = (ArrayList<Uzatfase>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR LISTAFASESBYID : " + ex.toString());
        }

        return listFases;
    }

    public static ArrayList<Uzatjudi> listJudicaturas(BigDecimal uztmateriaId) {
        ArrayList<Uzatjudi> listJudicaturas = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_1.setColumnName("id.uztmateriaId");
        query_1.setWhereClause("=");
        query_1.setValue(uztmateriaId);
        List parameList = new ArrayList();
        parameList.add(query_1);
        List<Uzatjudi> list = ds.customQuery(parameList, Uzatjudi.class);
        try {
            if (!list.isEmpty()) {
                listJudicaturas = (ArrayList<Uzatjudi>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR LISTAJUDICATURAS : " + ex.toString());
        }
        return listJudicaturas;
    }

    public static Uzatcaso casoByIdCaso(BigDecimal uztcasoId) {
        Uzatcaso listCasos = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_1.setColumnName("uzatcasoId");
        query_1.setWhereClause("=");
        query_1.setValue(uztcasoId);
        List parameList = new ArrayList();
        parameList.add(query_1);
        List<Uzatcaso> list = ds.customQuery(parameList, Uzatcaso.class);
        try {
            if (!list.isEmpty()) {
                listCasos = (Uzatcaso) list.get(0);
            }
        } catch (Exception ex) {
            log.level.info("ERROR LISTAJUDICATURAS : " + ex.toString());
        }
        return listCasos;
    }

    public static ArrayList<Uzatcaso> listCasosByFlag(BigDecimal uztcasoFlag) {
        ArrayList<Uzatcaso> listCasos = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_1.setColumnName("uzatcasoFlag");
        query_1.setWhereClause("=");
        query_1.setValue(uztcasoFlag);
        List parameList = new ArrayList();
        parameList.add(query_1);
        List<Uzatcaso> list = ds.customQuery(parameList, Uzatcaso.class);
        try {
            if (!list.isEmpty()) {
                listCasos = (ArrayList<Uzatcaso>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR LISTAJUDICATURAS : " + ex.toString());
        }
        return listCasos;
    }

    public static Boolean insertDocs(Uzatdocs docs) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (docs != null) {
            ds.save(docs);
            exito = true;
        }
        return exito;
    }

    public static ArrayList<Uzatcita> findCitasByCaso_Fase(BigDecimal uztcasoId, BigDecimal uztfaseId) {
        //Modificado por Dennis Santamaria
        ArrayList<Uzatcita> listCitas = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_1.setColumnName("id.uzatcasoId");
        query_1.setWhereClause("=");
        query_1.setValue(uztcasoId);
        //uztrolFlag
        QueryParameter query_2 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_2.setColumnName("id.uzatfaseId");
        query_2.setWhereClause("=");
        query_2.setValue(uztfaseId);
        List parameList = new ArrayList();
        parameList.add(query_1);
        parameList.add(query_2);
        List<Uzatcita> list = ds.customQuery(parameList, Uzatcita.class);
        try {
            if (!list.isEmpty()) {
                listCitas = (ArrayList<Uzatcita>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR  LISTDOCS : " + ex.toString());
        }
        return listCitas;
    }

    public static ArrayList<Uzatdocs> findDocsByCaso_Fase(BigDecimal uztcasoId, BigDecimal uztfaseId) {
        //Modificado por Dennis Santamaria
        ArrayList<Uzatdocs> listDoc = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_1.setColumnName("id.uzatcasoId");
        query_1.setWhereClause("=");
        query_1.setValue(uztcasoId);
        //uztrolFlag
        QueryParameter query_2 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_2.setColumnName("id.uzatfaseId");
        query_2.setWhereClause("=");
        query_2.setValue(uztfaseId);
        List parameList = new ArrayList();
        parameList.add(query_1);
        parameList.add(query_2);
        List<Uzatdocs> list = ds.customQuery(parameList, Uzatdocs.class);
        try {
            if (!list.isEmpty()) {
                listDoc = (ArrayList<Uzatdocs>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR  LISTDOCS : " + ex.toString());
        }
        return listDoc;
    }

    /*
     BEGIN UZAPGFUNTR(?,?,?,?,?); END;
     */
    public static ArrayList<Uzatcomt> getFasesComentByIdCasoAndIdFase(final BigDecimal UztIdCaso, final BigDecimal UztIdFase) {
        ArrayList<Uzatcomt> listR = null;
        try {
            listR = ProcuraduriaHibernateUtil.getSessionFactory().getCurrentSession().doReturningWork(new ReturningWork<ArrayList<Uzatcomt>>() {

                @Override
                public ArrayList<Uzatcomt> execute(Connection cnctn) throws SQLException {
                    CallableStatement f1 = cnctn.prepareCall("BEGIN UZAPGCOMBI(?,?,?); END;");
                    f1.setBigDecimal(1, UztIdCaso);
                    f1.setBigDecimal(2, UztIdFase);
                    f1.registerOutParameter(3, OracleTypes.CURSOR);
                    f1.execute();
                    ResultSet rs = ((OracleCallableStatement) f1).getCursor(3);
                    ArrayList<Uzatcomt> list = new ArrayList<>();
                    while (rs.next()) {
                        Uzatcomt ComtFase = new Uzatcomt();
                        ComtFase.getId().setUzatcasoId(rs.getBigDecimal(1));
                        ComtFase.getId().setUzatfaseId(rs.getBigDecimal(2));
                        ComtFase.getId().setUzatcomtId(rs.getBigDecimal(3));
                        ComtFase.setUzatcomtDescripcion(rs.getString(4));
                        ComtFase.setUzatcomtFecha(rs.getString(5));
                        list.add(ComtFase);
                    }
                    rs.close();
                    return list;
                }

            });
        } catch (Exception ex) {
            log.level.info(">>> " + ex.toString());
        }
        return listR;
    }

    public static ArrayList<Uzatcomt> getFasesComentByIdCaso(final BigDecimal UztIdCaso) {
        ArrayList<Uzatcomt> listR = null;
        try {
            listR = ProcuraduriaHibernateUtil.getSessionFactory().getCurrentSession().doReturningWork(new ReturningWork<ArrayList<Uzatcomt>>() {

                @Override
                public ArrayList<Uzatcomt> execute(Connection cnctn) throws SQLException {
                    CallableStatement f1 = cnctn.prepareCall("BEGIN UZAPGFACBI(?,?); END;");
                    f1.setBigDecimal(1, UztIdCaso);
                    f1.registerOutParameter(2, OracleTypes.CURSOR);
                    f1.execute();
                    ResultSet rs = ((OracleCallableStatement) f1).getCursor(2);
                    ArrayList<Uzatcomt> list = new ArrayList<>();
                    while (rs.next()) {
                        Uzatcomt ComtFase = new Uzatcomt();
                        ComtFase.getId().setUzatfaseId(rs.getBigDecimal(1));
                        ComtFase.getUzatfase().getId().setUzatfaseId(rs.getBigDecimal(1));
                        ComtFase.getUzatfase().setUzatfaseFlag(rs.getBigDecimal(2));
                        ComtFase.getUzatfase().setUzatfaseNumfase(rs.getBigDecimal(3));
                        ComtFase.getUzatfase().setUzatfaseNombre(rs.getString(4));
                        ComtFase.getUzatfase().setUzatfaseFechaIn(rs.getString(5));

                        if (rs.getBigDecimal(2) == BigDecimal.ZERO) {
                            ComtFase.getUzatfase().setUzatfaseFechaOut(rs.getString(6));
                        } else {
                            ComtFase.getUzatfase().setUzatfaseFechaOut("-");
                        }

                        ComtFase.getId().setUzatcomtId(rs.getBigDecimal(7));
                        ComtFase.setUzatcomtDescripcion(rs.getString(8));
                        ComtFase.setUzatcomtFecha(rs.getString(9));
                        list.add(ComtFase);
                    }
                    rs.close();
                    return list;
                }

            });
        } catch (Exception ex) {
            log.level.info(">>> " + ex.toString());
        }
        return listR;
    }

    public static ArrayList<Uzatcita> getCitasCalendar(final String FechaActual) {
        ArrayList<Uzatcita> listR = null;
        try {
            listR = ProcuraduriaHibernateUtil.getSessionFactory().getCurrentSession().doReturningWork(new ReturningWork<ArrayList<Uzatcita>>() {

                @Override
                public ArrayList<Uzatcita> execute(Connection cnctn) throws SQLException {
                    CallableStatement f1 = cnctn.prepareCall("BEGIN UZAPCITGEN(?,?); END;");
                    f1.setString(1, FechaActual);
                    f1.registerOutParameter(2, OracleTypes.CURSOR);
                    f1.execute();
                    ResultSet rs = ((OracleCallableStatement) f1).getCursor(2);
                    ArrayList<Uzatcita> list = new ArrayList<>();
                    while (rs.next()) {
                        Uzatcita Cita = new Uzatcita();
                        Cita.getId().setUzatcitaId(rs.getBigDecimal(1));
                        Cita.getId().setUzatfaseId(rs.getBigDecimal(2));
                        Cita.getUzatfase().getId().setUzatfaseId(rs.getBigDecimal(2));
                        Cita.getId().setUzatcasoId(rs.getBigDecimal(3));
                        Cita.getUzatfase().getId().setUzatcasoId(rs.getBigDecimal(3));
                        Cita.getUzatfase().getUzatcaso().setUzatcasoId(rs.getBigDecimal(3));
                        Cita.getUzatfase().getUzatcaso().setUzatcasoNumcausa(rs.getString(4));
                        Cita.setUzatcitaFecha(rs.getString(5));
                        Cita.setUzatcitaSala(rs.getString(6));
                        Cita.getUzatfase().getUzatcaso().getUzatjudi().getId().setUzatjudiId(rs.getBigDecimal(7));
                        Cita.getUzatfase().getUzatcaso().getUzatjudi().setUzatjudiDescripcion(rs.getString(8));
                        Cita.getUzatfase().getUzatcaso().getUzatjudi().getId().setUzatmateriaId(rs.getBigDecimal(9));
                        Cita.getUzatfase().getUzatcaso().getUzatjudi().getUzatmateri().setUzatmateriaId(rs.getBigDecimal(9));
                        Cita.getUzatfase().getUzatcaso().getUzatjudi().getUzatmateri().setUzatmateriaDescripcion(rs.getString(10));

                        list.add(Cita);
                    }
                    rs.close();
                    return list;
                }

            });
        } catch (Exception ex) {
            log.level.info(">>> " + ex.toString());
        }
        return listR;
    }

    public static Uzatasign getActiveAbogadosByIdCaso(final BigDecimal UztIdCaso) {
        Uzatasign listR = null;
        try {
            listR = ProcuraduriaHibernateUtil.getSessionFactory().getCurrentSession().doReturningWork(new ReturningWork<Uzatasign>() {

                @Override
                public Uzatasign execute(Connection cnctn) throws SQLException {
                    CallableStatement f1 = cnctn.prepareCall("BEGIN UZAPGACTCA(?,?); END;");
                    f1.setBigDecimal(1, UztIdCaso);
                    f1.registerOutParameter(2, OracleTypes.CURSOR);
                    f1.execute();
                    ResultSet rs = ((OracleCallableStatement) f1).getCursor(2);
                    Uzatasign list = new Uzatasign();
                    while (rs.next()) {
                        list.getUzatfunci().setUzatfuncionarioId(rs.getBigDecimal(1));
                        list.getUzatfunci().setUzatfuncionarioIdbanner(rs.getString(2));
                        list.getUzatfunci().setUzatfuncionarioCedula(rs.getString(3));
                        list.getUzatfunci().setUzatfuncionarioNombres(rs.getString(4));
                        list.getUzatfunci().setUzatfuncionarioApellidos(rs.getString(5));
                        list.getUzatfunci().setUzatfuncionarioEmail(rs.getString(6));
                        list.getUzatfunci().setUzatfuncionarioMovil(rs.getString(7));
                        list.setUzatasignarFechaIn(rs.getString(8));
                        list.setUzatasignarMotivo(rs.getString(9));
                    }
                    rs.close();
                    return list;
                }
            });
        } catch (Exception ex) {
            log.level.info(">>> " + ex.toString());
        }
        return listR;
    }

    public static ArrayList<Uzatrol> getFuncionariosTipoRolByFlag(final BigDecimal UztFlag) {
        ArrayList<Uzatrol> listR = null;
        try {
            listR = ProcuraduriaHibernateUtil.getSessionFactory().getCurrentSession().doReturningWork(new ReturningWork<ArrayList<Uzatrol>>() {

                @Override
                public ArrayList<Uzatrol> execute(Connection cnctn) throws SQLException {
                    CallableStatement f1 = cnctn.prepareCall("BEGIN UZAPGFUNTR(?,?); END;");
                    f1.setBigDecimal(1, UztFlag);
                    f1.registerOutParameter(2, OracleTypes.CURSOR);
                    f1.execute();
                    ResultSet rs = ((OracleCallableStatement) f1).getCursor(2);
                    ArrayList<Uzatrol> list = new ArrayList<>();
                    while (rs.next()) {
                        Uzatrol rol = new Uzatrol();
                        rol.getUzatfunci().setUzatfuncionarioCedula(rs.getString(1));
                        rol.getUzatfunci().setUzatfuncionarioApellidos(rs.getString(2));
                        rol.getUzatfunci().setUzatfuncionarioNombres(rs.getString(3));
                        rol.getUzattrol().setUzattiporolDescripcion(rs.getString(4));
                        //rol.setUzatrolFechaIn(rs.getString(5));
                        rol.setUzatrolFlag(rs.getBigDecimal(6));
                        rol.getUzatfunci().setUzatfuncionarioFlag(rs.getBigDecimal(7));
                        rol.getUzatfunci().setUzatfuncionarioId(rs.getBigDecimal(8));
                        rol.getUzattrol().setUzattiporolId(rs.getBigDecimal(9));
                        rol.setId(new UzatrolId(rs.getBigDecimal(8), rs.getBigDecimal(9), rs.getBigDecimal(10)));
                        list.add(rol);
                    }
                    rs.close();
                    return list;
                }
            });
        } catch (Exception ex) {
            log.level.info(">>> " + ex.toString());
        }
        return listR;
    }

    public static ArrayList<Uzatcaso> getActiveCasos() {
        ArrayList<Uzatcaso> listR = null;
        try {
            listR = ProcuraduriaHibernateUtil.getSessionFactory().getCurrentSession().doReturningWork(new ReturningWork<ArrayList<Uzatcaso>>() {

                @Override
                public ArrayList<Uzatcaso> execute(Connection cnctn) throws SQLException {
                    CallableStatement f1 = cnctn.prepareCall("BEGIN UZAPGACTC(?); END;");
                    f1.registerOutParameter(1, OracleTypes.CURSOR);
                    f1.execute();
                    ResultSet rs = ((OracleCallableStatement) f1).getCursor(1);
                    ArrayList<Uzatcaso> list = new ArrayList<>();
                    while (rs.next()) {
                        Uzatcaso caso = new Uzatcaso();
                        caso.setUzatcasoId(rs.getBigDecimal(1));
                        //caso.getUzatfunci().setUzatfuncionarioApellidos(rs.getString(2));
                        caso.setUzatcasoNumcausa(rs.getString(3));
                        caso.setUzatcasoMotivo(rs.getString(4));
                        caso.setUzatcasoDetalle(rs.getString(5));
                        caso.setUzatcasoTipo(rs.getString(6));
                        caso.setUzatcasoFechaIn(rs.getString(7));
                        list.add(caso);
                    }

                    rs.close();
                    return list;
                }
            });
        } catch (Exception ex) {
            log.level.info(">>> " + ex.toString());
        }
        return listR;
    }

    public static Boolean insertRol(Uzatrol rol) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (rol != null) {
            ds.save(rol);
            exito = true;
        }
        return exito;
    }

    public static Boolean updateRol(Uzatrol rol) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (rol != null) {
            ds.update(rol);
            exito = true;
        }
        return exito;
    }

    public static Boolean insertFuncionario(Uzatfunci fun) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (fun != null) {
            ds.save(fun);
            exito = true;
        }
        return exito;
    }

    public static Boolean insertCita(Uzatcita cita) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (cita != null) {
            ds.save(cita);
            exito = true;
        }
        return exito;
    }

    public static Boolean insertComentario(Uzatcomt comt) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (comt != null) {
            ds.save(comt);
            exito = true;
        }
        return exito;
    }

    public static Boolean insertFase(Uzatfase fase) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (fase != null) {
            ds.save(fase);
            exito = true;
        }
        return exito;
    }

    public static Boolean insertCaso(Uzatcaso caso) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (caso != null) {
            ds.save(caso);
            exito = true;
        }
        return exito;
    }

    //Modificado por Dennis Santamaria
    public static Uzatfunci findFuncionarioByCedulaOrIdBanner(String claveFuncionario) {
        Uzatfunci findFun = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());

        QueryParameter query_5 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_5.setColumnName("uzatfuncionarioCedula");
        query_5.setWhereClause("=");
        query_5.setValue(claveFuncionario);
        QueryParameter query_6 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_6.setColumnName("uzatfuncionarioIdbanner");
        query_6.setWhereClause("=");
        query_6.setValue(claveFuncionario);

        List<QueryParameter> Custadios_ = new ArrayList();
        Custadios_.add(query_5);
        Custadios_.add(query_6);

        QueryParameter orFun_ = new QueryParameter(QueryParameter.$TYPE_OR);
        orFun_.setDetachedParameters(Custadios_);

        List paramList = new ArrayList();
        paramList.add(orFun_);

        List<Uzatfunci> listfun = ds.customQuery(paramList, Uzatfunci.class);
        try {
            if (!listfun.isEmpty()) {
                findFun = listfun.get(0);
            }
        } catch (Exception ex) {
            log.level.info("No se pudo buscar equipo by Id");
        }

        return findFun;
    }

    public static ArrayList<Uzatjudi> findjudibyMateriId(BigDecimal uzatmateriaid) {
        ArrayList<Uzatjudi> listJudi = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_1.setColumnName("id.uzatmateriaId");
        query_1.setWhereClause("=");
        query_1.setValue(uzatmateriaid);

        List parameList = new ArrayList();
        parameList.add(query_1);
        List<Uzatjudi> list = ds.customQuery(parameList, Uzatjudi.class);
        try {
            if (!list.isEmpty()) {
                listJudi = (ArrayList<Uzatjudi>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR  LISTJUDI : " + ex.toString());
        }
        return listJudi;
    }

    public static Uzatjudi findJudi(BigDecimal uzatmateriaid, BigDecimal uzatjudiid) {
        ArrayList<Uzatjudi> listJudi = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_1.setColumnName("id.uzatmateriaId");
        query_1.setWhereClause("=");
        query_1.setValue(uzatmateriaid);

        QueryParameter query_2 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_2.setColumnName("id.uzatjudiId");
        query_2.setWhereClause("=");
        query_2.setValue(uzatjudiid);

        List parameList = new ArrayList();
        parameList.add(query_1);
        parameList.add(query_2);
        List<Uzatjudi> list = ds.customQuery(parameList, Uzatjudi.class);
        try {
            if (!list.isEmpty()) {
                listJudi = (ArrayList<Uzatjudi>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR  LISTJUDI : " + ex.toString());
        }
        return listJudi.get(0);
    }

    public static Uzatfunci findFuncionarioByCedula(String cedula) {
        Uzatfunci findFun = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());

        QueryParameter query_5 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_5.setColumnName("uzatfuncionarioCedula");
        query_5.setWhereClause("=");
        query_5.setValue(cedula);

        List<QueryParameter> Custadios_ = new ArrayList();
        Custadios_.add(query_5);

        QueryParameter orFun_ = new QueryParameter(QueryParameter.$TYPE_OR);
        orFun_.setDetachedParameters(Custadios_);

        List paramList = new ArrayList();
        paramList.add(orFun_);

        List<Uzatfunci> listfun = ds.customQuery(paramList, Uzatfunci.class);
        try {
            if (!listfun.isEmpty()) {
                findFun = listfun.get(0);
            }
        } catch (Exception ex) {
            log.level.info("No se pudo buscar equipo by Id");
        }

        return findFun;
    }

    public static BigDecimal getCountCasosByFlag(final BigDecimal uzatflag) {
        BigDecimal countNum = null;
        try {
            countNum = ProcuraduriaHibernateUtil.getSessionFactory().getCurrentSession().doReturningWork(new ReturningWork<BigDecimal>() {

                @Override
                public BigDecimal execute(Connection cnctn) throws SQLException {
                    CallableStatement f1 = cnctn.prepareCall(" { ? = call UZAFCOUNCA(?) } ");
                    f1.registerOutParameter(1, OracleTypes.NUMBER);
                    f1.setBigDecimal(2, uzatflag);
                    f1.execute();
                    NUMBER count = ((OracleCallableStatement) f1).getNUMBER(1);
                    return count.bigDecimalValue();
                }
            });

        } catch (HibernateException ex) {
            log.level.info(">>> " + ex.toString());
        }

        return countNum;
    }
    
    public static BigDecimal getCountCasosByFlagByIdFunci(final BigDecimal uzatflag, final BigDecimal uzatfuncionarioId) {
        BigDecimal countNum = null;
        try {
            countNum = ProcuraduriaHibernateUtil.getSessionFactory().getCurrentSession().doReturningWork(new ReturningWork<BigDecimal>() {

                @Override
                public BigDecimal execute(Connection cnctn) throws SQLException {
                    CallableStatement f1 = cnctn.prepareCall(" { ? = call UZAFCOUNCA(?) } ");
                    f1.registerOutParameter(1, OracleTypes.NUMBER);
                    f1.setBigDecimal(2, uzatflag);
                    f1.execute();
                    NUMBER count = ((OracleCallableStatement) f1).getNUMBER(1);
                    return count.bigDecimalValue();
                }
            });

        } catch (HibernateException ex) {
            log.level.info(">>> " + ex.toString());
        }

        return countNum;
    }

    public static ArrayList<Uzatcaso> findCasosLazy(BigDecimal Flag, int first, int pageSize) {
        ArrayList<Uzatcaso> findCaso = new ArrayList<>();
        BigDecimal contador = getCountCasosByFlag(Flag);

        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());

        QueryParameter query_5 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_5.setColumnName("uzatcasoFlag");
        query_5.setWhereClause("=");
        query_5.setValue(Flag);

        List paramList = new ArrayList();
        paramList.add(query_5);

        List<Uzatcaso> listfun = ds.customQueryLazy(paramList, Uzatcaso.class, first, pageSize);

        try {
            if (!listfun.isEmpty()) {

                Uzatcaso objCaso = new Uzatcaso();
                for (int i = 0; i < contador.intValue(); i++) {
                    findCaso.add(objCaso);
                }

                for (int y = first, z = 0; y < first + listfun.size(); y++, z++) {
                    findCaso.set(y, listfun.get(z));
                }
            }
        } catch (Exception ex) {
            log.level.info("No se pudo encontrar casos disponibles.");
        }

        return findCaso;
    }

    public static ArrayList<Uzatcaso> findCasosLazy(BigDecimal uzatfuncionarioId, BigDecimal Flag, int first, int pageSize) {
        ArrayList<Uzatcaso> findCaso = new ArrayList<>();
        BigDecimal contador = getCountCasosByFlag(Flag);

        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());

        QueryParameter joincaso = new QueryParameter(QueryParameter.$TYPE_JOIN);
        joincaso.setJoinAlias("uzatcaso");
        joincaso.setJoinOrderNumber(1);
        joincaso.setColumnName("uzatcaso");

        QueryParameter query_5 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_5.setColumnName("uzatcaso.uzatcasoFlag");
        query_5.setWhereClause("=");
        query_5.setValue(Flag);

        QueryParameter query_4 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_4.setColumnName("id.uzatfuncionarioId");
        query_4.setWhereClause("=");
        query_4.setValue(uzatfuncionarioId);

        List paramList = new ArrayList();
        paramList.add(joincaso);
        paramList.add(query_4);
        paramList.add(query_5);

        List<Uzatasign> listcaso = ds.customQueryLazy(paramList, Uzatasign.class,first, pageSize);

        try {
            if (!listcaso.isEmpty()) {

                Uzatcaso objCaso = new Uzatcaso();
                for (int i = 0; i < contador.intValue(); i++) {
                    findCaso.add(objCaso);
                }

                for (int y = first, z = 0; y < first + listcaso.size(); y++, z++) {
                    findCaso.set(y, listcaso.get(z).getUzatcaso());
                }
            }
        } catch (Exception ex) {
            log.level.info("No se pudo encontrar casos disponibles.");
        }

        return findCaso;
    }

    public static ArrayList<Uzatasign> findCasosAdminLazy(final BigDecimal uzatfuncionarioId,
            final BigDecimal uzatcasoFlag,
            final BigDecimal uzatasignarFlag) {
        ArrayList<Uzatasign> findCaso = new ArrayList<>();

        try {
            findCaso = ProcuraduriaHibernateUtil.getSessionFactory().getCurrentSession().doReturningWork(new ReturningWork<ArrayList<Uzatasign>>() {

                @Override
                public ArrayList<Uzatasign> execute(Connection cnctn) throws SQLException {
                    CallableStatement f1 = cnctn.prepareCall(" { ? = call UZAFGCAFFL(?,?,?) } ");
                    f1.registerOutParameter(1, OracleTypes.CURSOR);
                    f1.setBigDecimal(2, uzatasignarFlag);
                    f1.setBigDecimal(3, uzatcasoFlag);
                    f1.setBigDecimal(4, uzatfuncionarioId);
                    f1.execute();
                    ResultSet rs = ((OracleCallableStatement) f1).getCursor(1);
                    ArrayList<Uzatasign> list = new ArrayList<>();
                    while (rs.next()) {
                        Uzatasign asg = new Uzatasign();
                        asg.getId().setUzatfuncionarioId(rs.getBigDecimal(1));
                        asg.setUzatasignarId(rs.getBigDecimal(2));
                        asg.getId().setUzatcasoId(rs.getBigDecimal(3));
                        asg.setUzatasignarFlag(rs.getBigDecimal(4));
                        asg.setUzatasignarFechaIn(rs.getString(5));
                        asg.setUzatasignarFechaOut(rs.getString(6));
                        asg.setUzatasignarMotivo(rs.getString(7));
                        asg.getUzatcaso().setUzatcasoNumcausa(rs.getString(8));
                        asg.getUzatcaso().getUzatjudi().getUzatmateri().setUzatmateriaDescripcion(rs.getString(9));
                        asg.getUzatcaso().getUzatjudi().setUzatjudiDescripcion(rs.getString(10));
                        asg.getUzatcaso().setUzatcasoMotivo(rs.getString(11));
                        asg.getUzatcaso().setUzatcasoDetalle(rs.getString(12));
                        asg.getUzatcaso().setUzatcasoTipo(rs.getString(13));
                        asg.getUzatcaso().setUzatcasoFechaIn(rs.getString(14));
                        asg.getUzatcaso().setUzatcasoFechaOut(rs.getString(15));
                        asg.getUzatcaso().setUzatcasoFlag(rs.getBigDecimal(16));
                        asg.getUltimaFaseActual().setUzatfaseNumfase(rs.getBigDecimal(17));
                        asg.getUltimaFaseActual().setUzatfaseNombre(rs.getString(18));
                        asg.getUltimaFaseActual().setUzatfaseFlag(rs.getBigDecimal(19));
                        list.add(asg);
                    }
                    rs.close();
                    rs = null;

                    return list;
                }
            });

        } catch (Exception ex) {
            log.level.info(">>> " + ex.toString());
        }

        return findCaso;
    }

    public static Uzatcaso findCasobyNumCausa(String NumCausa) {
        Uzatcaso findCaso = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());

        QueryParameter query_5 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_5.setColumnName("uzatcasoNumcausa");
        query_5.setWhereClause("=");
        query_5.setValue(NumCausa);

        List<QueryParameter> Custadios_ = new ArrayList();
        Custadios_.add(query_5);

        QueryParameter orFun_ = new QueryParameter(QueryParameter.$TYPE_OR);
        orFun_.setDetachedParameters(Custadios_);

        List paramList = new ArrayList();
        paramList.add(orFun_);

        List<Uzatcaso> listfun = ds.customQuery(paramList, Uzatcaso.class);
        try {
            if (!listfun.isEmpty()) {
                findCaso = listfun.get(0);
            }
        } catch (Exception ex) {
            log.level.info("No se pudo buscar caso por numero de causa");
        }

        return findCaso;
    }

    public static Boolean insertNuevaAsignacion(Uzatasign asign) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (asign != null) {
            ds.save(asign);
            exito = true;
        }
        return exito;
    }

    public static Boolean updateFuncionario(Uzatfunci funci) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (funci != null) {
            ds.update(funci);
            exito = true;
        }
        return exito;
    }

    public static Uzatcaso findCasobyId(BigDecimal id) {
        Uzatcaso findCaso = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());

        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_1.setColumnName("uzatcasoId");
        query_1.setWhereClause("=");
        query_1.setValue(id);

        List parameList = new ArrayList();
        parameList.add(query_1);
        List<Uzatcaso> list = ds.customQuery(parameList, Uzatcaso.class);
        try {
            if (!list.isEmpty()) {
                findCaso = list.get(0);
            }
        } catch (Exception ex) {
            log.level.info("ERROR  findCasobyId : " + ex.toString());
        }
        return findCaso;

    }

    public static Uzatactor findActorbyCedula(String cedula) {
        Uzatactor findActor = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());

        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_1.setColumnName("uzatactorCedula");
        query_1.setWhereClause("=");
        query_1.setValue(cedula);

        List parameList = new ArrayList();
        parameList.add(query_1);
        List<Uzatactor> list = ds.customQuery(parameList, Uzatactor.class);
        try {
            if (!list.isEmpty()) {
                findActor = list.get(0);
            }
        } catch (Exception ex) {
            log.level.info("ERROR  findActorbyCedula : " + ex.toString());
        }
        return findActor;

    }

    public static Boolean updateActor(Uzatactor actor) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (actor != null) {
            ds.update(actor);
            exito = true;
        }
        return exito;
    }

    public static Boolean updateCaso(Uzatcaso caso) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (caso != null) {
            ds.update(caso);
            exito = true;
        }
        return exito;
    }

    public static Boolean insertInvolCa(UzatinvCa involca) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        if (involca != null) {
            ds.save(involca);
            exito = true;
        }
        return exito;
    }

    public static Boolean insertAsign(Uzatasign asign) {
        Boolean exito = false;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());

        if (asign != null) {
            ds.save(asign);
            exito = true;
        }

        return exito;
    }
}
