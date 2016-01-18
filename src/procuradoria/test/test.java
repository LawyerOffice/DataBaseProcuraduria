/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package procuradoria.test;

import java.util.ArrayList;
import procuradoria.crud.ProcuradoriaMethods;
import procuradoria.map.Uzttiporol;

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
        ArrayList<Uzttiporol>  list1 = ProcuradoriaMethods.ListTipoRol();
        System.out.println(">> "+list1.size());
    }
    
}
