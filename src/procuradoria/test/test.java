/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package procuradoria.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import procuradoria.crud.ProcuradoriaMethods;
import procuradoria.map.*;
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
        
        DocumentsPdf  pdf = new DocumentsPdf();
        pdf.CovertPdfToByteArray("prueba_archivo", "prueba_archivo");
        
    }
    
}
