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
import java.util.ArrayList;
import java.util.List;
import procuradoria.map.*;
import procuradoria.util.ProcuraduriaHibernateUtil;

/**
 *
 * @author Ivan
 */
public class ProcuradoriaCrud {

    public final static L log = new L(ProcuradoriaCrud.class);

    public static ArrayList<Uzttiporol> listTipoRol() {
        ArrayList<Uzttiporol> listTipoRol = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        List parameList = new ArrayList();
        List<Uzttiporol> list = ds.customQuery(parameList, Uzttiporol.class);
        try {
            if (!list.isEmpty()) {
                listTipoRol = (ArrayList<Uzttiporol>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR  LISTTIPOROL : " + ex.toString());
        }
        return listTipoRol;
    }
//flag en 1 rol en funcionamiento en el trnascurso del tiempo para un los funcioanrios

    public static ArrayList<Uztrol> findRolByIdFuncionario(BigDecimal uztfuncionarioId, BigDecimal uztrolFlag) {
        ArrayList<Uztrol> listRol = null;
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
        List<Uztrol> list = ds.customQuery(parameList, Uztrol.class);
        try {
            if (!list.isEmpty()) {
                listRol = (ArrayList<Uztrol>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR  LISTROL : " + ex.toString());
        }
        return listRol;
    }

    public static ArrayList<Uztfuncionario> listFuncionarios(BigDecimal uztfuncionarioFlag) {
        ArrayList<Uztfuncionario> listFuncionario = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_1.setColumnName("uztfuncionarioFlag");
        query_1.setWhereClause("=");
        query_1.setValue(uztfuncionarioFlag);
        List parameList = new ArrayList();
        parameList.add(query_1);
        List<Uztfuncionario> list = ds.customQuery(parameList, Uztfuncionario.class);
        try {
            if (!list.isEmpty()) {
                listFuncionario = (ArrayList<Uztfuncionario>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR LISTAFUNCIONARIO : " + ex.toString());
        }
        return listFuncionario;
    }
    
    public static ArrayList<Uztfuncionario> listActiveAbogados() {
        ArrayList<Uztfuncionario> listFuncionario = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
//        query_1.setColumnName("uztfuncionarioFlag");
//        query_1.setWhereClause("=");
//        query_1.setValue(uztfuncionarioFlag);
        List parameList = new ArrayList();
        parameList.add(query_1);
        List<Uztfuncionario> list = ds.customQuery(parameList, Uztfuncionario.class);
        try {
            if (!list.isEmpty()) {
                listFuncionario = (ArrayList<Uztfuncionario>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR PROCESO ACTIVEABOGADOS : " + ex.toString());
        }
        return listFuncionario;
    }
    
    public static ArrayList<Uztmateria> listMaterias() {
        ArrayList<Uztmateria> listMaterias = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        List parameList = new ArrayList();
        List<Uztmateria> list = ds.customQuery(parameList, Uztmateria.class);
        try {
            if (!list.isEmpty()) {
                listMaterias = (ArrayList<Uztmateria>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR LISTAMATERIAS : " + ex.toString());
        }
        return listMaterias;
    }
    
    public static ArrayList<Uztjudi> listJudicaturas(BigDecimal uztmateriaId) {
        ArrayList<Uztjudi> listJudicaturas = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_1.setColumnName("id.uztmateriaId");
        query_1.setWhereClause("=");
        query_1.setValue(uztmateriaId);
        List parameList = new ArrayList();
        parameList.add(query_1);
        List<Uztjudi> list = ds.customQuery(parameList, Uztjudi.class);
        try {
            if (!list.isEmpty()) {
                listJudicaturas = (ArrayList<Uztjudi>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR LISTAJUDICATURAS : " + ex.toString());
        }
        return listJudicaturas;
    }
    
    public static ArrayList<Uztcaso> listCasosByFlag(BigDecimal uztcasoFlag) {
        ArrayList<Uztcaso> listCasos = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        QueryParameter query_1 = new QueryParameter(QueryParameter.$TYPE_WHERE);
        query_1.setColumnName("uztcasoFlag");
        query_1.setWhereClause("=");
        query_1.setValue(uztcasoFlag);
        List parameList = new ArrayList();
        parameList.add(query_1);
        List<Uztcaso> list = ds.customQuery(parameList, Uztcaso.class);
        try {
            if (!list.isEmpty()) {
                listCasos= (ArrayList<Uztcaso>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR LISTAJUDICATURAS : " + ex.toString());
        }
        return listCasos;
    }
    
    public static Boolean insertDocs(Uztdocs docs) {
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
    
    public static ArrayList<Uztdocs> findDocsByCaso_Fase(BigDecimal uztcasoId, BigDecimal uztfaseId) {
        ArrayList<Uztdocs> listDoc = null;
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
        List<Uztdocs> list = ds.customQuery(parameList, Uztdocs.class);
        try {
            if (!list.isEmpty()) {
                listDoc = (ArrayList<Uztdocs>) list;
            }
        } catch (Exception ex) {
            log.level.info("ERROR  LISTDOCS : " + ex.toString());
        }
        return listDoc;
    }
    
}
