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
    
    public static ArrayList<Uzatrol> findRolsAndFuciByFlag(BigDecimal uztrolFlag) {
        ArrayList<Uzatrol> listRol = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        
        QueryParameter joinfunci = new QueryParameter(QueryParameter.$TYPE_JOIN);
        joinfunci.setJoinAlias("uzatfunci");
        joinfunci.setJoinOrderNumber(1);
        joinfunci.setColumnName("uzatfunci");
//        joinfunci.setj
        
        QueryParameter jointrol = new QueryParameter(QueryParameter.$TYPE_JOIN);
        jointrol.setJoinAlias("uzattrol");
        jointrol.setJoinOrderNumber(2);
        jointrol.setColumnName("uzattrol");
          
        //uztrolFlag
        QueryParameter query_2 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_2.setColumnName("uzatrolFlag");
        query_2.setWhereClause("=");
        query_2.setValue(uztrolFlag);
        
        List parameList = new ArrayList();
        parameList.add(joinfunci);
        //parameList.add(jointrol);
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

//Modificado por Dennis Santamaria
    public static ArrayList<Uzatdocs> findDocsByCaso_Fase(BigDecimal uztcasoId, BigDecimal uztfaseId) {
        ArrayList<Uzatdocs> listDoc = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_1.setColumnName("id.uztcasoId");
        query_1.setWhereClause("=");
        query_1.setValue(uztcasoId);
        //uztrolFlag
        QueryParameter query_2 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_2.setColumnName("id.uztfaseId");
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
                        
                        if(rs.getBigDecimal(2)==BigDecimal.ZERO) ComtFase.getUzatfase().setUzatfaseFechaOut(rs.getString(6));
                        else ComtFase.getUzatfase().setUzatfaseFechaOut("-");
                        
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

}
