/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procuradoria.test;

import java.util.Date;
import java.util.Calendar;
import java.util.Timer;
import procuradoria.crud.ProcuradoriaMethods;

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
//////        DocumentsPdf  pdf = new DocumentsPdf();
//////        
//////        Uzatdocs doc = new Uzatdocs();
//////        doc.getId().setUzatcasoId(BigDecimal.valueOf(100));
//////        doc.getId().setUzatfaseId(BigDecimal.valueOf(133));
//////        doc.setUzatdocsCasilla("Ninguna");
//////        doc.setUzatdocsCompromiso("Asistir a la sesión");
//////        doc.setUzatdocsFecha("04/04/2016 00:00:00");
//////        doc.setUzatfuncionarioId(BigDecimal.valueOf(113));
//////        Boolean CovertPdfToByteArray = pdf.CovertPdfToByteArray(doc,"D:\\Listado_Estudiantes_NRC.pdf"); //CARGA
//        ArrayList<Uzatdocs> listDocs = ProcuradoriaMethods.FindDocsbyCaso_Fase(BigDecimal.valueOf(100), BigDecimal.valueOf(100));
//        pdf.byteArrayToFile(listDocs.get(0)); //DESCARGA
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        
//        ArrayList<Uztrol> rols = ProcuradoriaMethods.GetFuncionariosTipoRolByFlag(BigDecimal.ONE);
//        System.out.println(">> "+rols.size());
//        ArrayList<Uzatasign> listcasos = ProcuradoriaMethods.FindCasosAdminLazy(new BigDecimal(112), BigDecimal.ONE, BigDecimal.ONE);
//        
//        System.out.println(">> "+listcasos.size());
        ///dsantamariadiaz@gmail.com
        // Boolean successMAIL1 = ProcuradoriaMethods.SendMail(Email, filePath, Nombre);
        Boolean successMAIL2 = ProcuradoriaMethods.SendMail("dsantamariadiaz@gmail.com", "C:\\requerimientos.txt", "PRUEBA", "11111111111", "# 3", "2do Jusgado de lo Penal", "11/11/2016");
        if (successMAIL2) {
            System.out.println("EXITO");
        } else {
            System.out.println("NO SE HA PODIDO ENVIAR CORREO");
        }
//        Uzatfunci usuario  = ProcuradoriaMethods.FindByIdFunciByCedFunci("L00000181","1804110474", BigDecimal.ONE);
//        System.out.println(">> "+usuario.getUzatfuncionarioId());
        Date horaDespertar = new Date(System.currentTimeMillis());

        Calendar c = Calendar.getInstance();
        c.setTime(horaDespertar);
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        // Si la hora es posterior a las 8am se programa la alarma para el dia siguiente
        if (c.get(Calendar.HOUR_OF_DAY) >= 22) {
            c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + 1);
        }

        c.set(Calendar.HOUR_OF_DAY, 17);
        c.set(Calendar.MINUTE, 20);
        c.set(Calendar.SECOND, 0);

        horaDespertar = c.getTime();
        System.out.println(horaDespertar);
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        // El despertador suena cada 24h (una vez al dia)
        int tiempoRepeticion = 86400000;

        // Programamos el despertador para que "suene" a las 8am todos los dias 
        Timer temporizador = new Timer();
        temporizador.schedule(new Temporizador(), horaDespertar, tiempoRepeticion);

    }

}
