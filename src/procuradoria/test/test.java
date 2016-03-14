/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package procuradoria.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import procuradoria.crud.ProcuradoriaMethods;
import procuradoria.map.Uzatasign;
import procuradoria.map.Uzatdocs;
import procuradoria.map.Uzatfunci;
import procuradoria.pdf.util.DocumentsPdf;




/**
 *
 * @author Ivan
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
//        ArrayList<Uzttiporol>  list1 = ProcuradoriaMethods.ListTipoRol();
//        System.out.println(">> "+list1.size());
//        
//        ArrayList<Uztfuncionario> list2 = ProcuradoriaMethods.ListFuncionarios(BigDecimal.ONE);
//        System.out.println(">> "+list2.size());
//        
//        ArrayList<Uztrol> list3 = ProcuradoriaMethods.FindRolByIdFuncionario(new BigDecimal(100), BigDecimal.ONE);
//        System.out.println(">> "+list3.size());
//        
//        ArrayList<Uztmateria> lis4 = ProcuradoriaMethods.ListMaterias();
//        System.out.println(">> "+lis4.size());
//        
//        ArrayList<Uztjudi> list5 = ProcuradoriaMethods.listJudicaturas(new BigDecimal(101));
//        System.out.println(">> "+list5.size());
//        
//        ArrayList<Uztcaso> list6 = ProcuradoriaMethods.ListCasosByFlag(BigDecimal.ZERO);
//        System.out.println(">> "+list6);    
//        
//        DocumentsPdf  pdf = new DocumentsPdf();
//        pdf.CovertPdfToByteArray("prueba_archivo", "prueba_archivo");
//        
//        ArrayList<Uztrol> rols = ProcuradoriaMethods.GetFuncionariosTipoRolByFlag(BigDecimal.ONE);
//        System.out.println(">> "+rols.size());
        

        // TODO code application logic here
//        ArrayList<Uzttiporol>  list1 = ProcuradoriaMethods.ListTipoRol();
//        System.out.println(">> "+list1.size());
//        
//        ArrayList<Uztfuncionario> list2 = ProcuradoriaMethods.ListFuncionarios(BigDecimal.ONE);
//        System.out.println(">> "+list2.size());
//        
//        ArrayList<Uztrol> list3 = ProcuradoriaMethods.FindRolByIdFuncionario(new BigDecimal(100), BigDecimal.ONE);
//        System.out.println(">> "+list3.size());
//        
//        ArrayList<Uztmateria> lis4 = ProcuradoriaMethods.ListMaterias();
//        System.out.println(">> "+lis4.size());
//        
//        Uzatjudi list5 = ProcuradoriaMethods.findjudi(new BigDecimal(100), new BigDecimal(100));
//        System.out.println(">> "+list5.getUzatjudiDescripcion());
//        
//        ArrayList<Uztcaso> list6 = ProcuradoriaMethods.ListCasosByFlag(BigDecimal.ZERO);
//        System.out.println(">> "+list6);    
//        
        
        //PRUEBAS DEL PDF///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        DocumentsPdf  pdf = new DocumentsPdf();
////        
////        Uzatdocs doc = new Uzatdocs();
////        doc.getId().setUzatcasoId(BigDecimal.valueOf(100));
////        doc.getId().setUzatfaseId(BigDecimal.valueOf(133));
////        doc.setUzatdocsCasilla("Ninguna");
////        doc.setUzatdocsCompromiso("Asistir a la sesión");
////        doc.setUzatdocsFecha("12/03/2016 00:00:00");
////        doc.setUzatfuncionarioId(BigDecimal.valueOf(114));
////        pdf.CovertPdfToByteArray(doc,"C:\\Users\\FANNY\\Desktop\\Daniel Galarza\\EDO\\GalarzaDaniel_DeberesTercerParcial.pdf", "Deberes"); //CARGA
////        
//        ArrayList<Uzatdocs> listDocs = ProcuradoriaMethods.FindDocsbyCaso_Fase(BigDecimal.valueOf(100), BigDecimal.valueOf(100));
//        pdf.byteArrayToFile(listDocs.get(0)); //DESCARGA
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        
//        ArrayList<Uztrol> rols = ProcuradoriaMethods.GetFuncionariosTipoRolByFlag(BigDecimal.ONE);
//        System.out.println(">> "+rols.size());

//        ArrayList<Uzatasign> listcasos = ProcuradoriaMethods.FindCasosAdminLazy(new BigDecimal(112), BigDecimal.ONE, BigDecimal.ONE);
//        
//        System.out.println(">> "+listcasos.size());
        

//        Boolean successMAIL = ProcuradoriaMethods.SendMail(Email, filePath, Nombre);


//        Boolean successMAIL = ProcuradoriaMethods.SendMail("dsantamariadiaz@gmail.com", "C:\\requerimientos.txt", "PRUEBA", "11111111111", "# 3", "2do Jusgado de lo Penal", "11/11/2016");
//          if(successMAIL)
//          {
//              System.out.println("EXITO");
//          }else
//          {
//              System.out.println("NO SE HA PODIDO ENVIAR CORREO");
//          }
        
//        Uzatfunci usuario  = ProcuradoriaMethods.FindByIdFunciByCedFunci("L00000181","1804110474", BigDecimal.ONE);
//        System.out.println(">> "+usuario.getUzatfuncionarioId());
        
    }
    
}
