/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package procuradoria.crud;

import com.dao.DAOServices;
import com.logger.L;
import java.util.ArrayList;
import java.util.List;
import procuradoria.map.Uzttiporol;
import procuradoria.util.ProcuraduriaHibernateUtil;

/**
 *
 * @author Ivan
 */
public class ProcuradoriaCrud {
    
    public final static L log = new L(ProcuradoriaCrud.class);
    
    public static ArrayList<Uzttiporol> listTipoRol(){
        ArrayList<Uzttiporol> listTipoRol = null;
        DAOServices ds = new DAOServices(ProcuraduriaHibernateUtil.
                getSessionFactory().getCurrentSession());
        List parameList = new ArrayList();
        List<Uzttiporol> list = ds.customQuery(parameList, Uzttiporol.class);
        try {
            if(!list.isEmpty()){
                listTipoRol = (ArrayList<Uzttiporol>) list;
            }
        } catch (Exception ex) {
            log.level.info("No se pudo buscar cliente:" + ex.toString());
        }
        return listTipoRol;
    }
    
}
