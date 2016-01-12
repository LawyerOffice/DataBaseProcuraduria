package procuradoria.map;
// Generated Jan 7, 2016 1:07:49 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;

/**
 * Uztrol generated by hbm2java
 */
public class Uztrol  implements java.io.Serializable {


     private UztrolId id;
     private Uzttiporol uzttiporol;
     private Uztfuncionario uztfuncionario;
     private String uztrolCod;
     private String uztrolFechaIn;
     private String uztrolFechaOut;
     private BigDecimal uztrolFlag;

    public Uztrol() {
    }

	
    public Uztrol(UztrolId id, Uzttiporol uzttiporol, Uztfuncionario uztfuncionario) {
        this.id = id;
        this.uzttiporol = uzttiporol;
        this.uztfuncionario = uztfuncionario;
    }
    public Uztrol(UztrolId id, Uzttiporol uzttiporol, Uztfuncionario uztfuncionario, String uztrolCod, String uztrolFechaIn, String uztrolFechaOut, BigDecimal uztrolFlag) {
       this.id = id;
       this.uzttiporol = uzttiporol;
       this.uztfuncionario = uztfuncionario;
       this.uztrolCod = uztrolCod;
       this.uztrolFechaIn = uztrolFechaIn;
       this.uztrolFechaOut = uztrolFechaOut;
       this.uztrolFlag = uztrolFlag;
    }
   
    public UztrolId getId() {
        return this.id;
    }
    
    public void setId(UztrolId id) {
        this.id = id;
    }
    public Uzttiporol getUzttiporol() {
        return this.uzttiporol;
    }
    
    public void setUzttiporol(Uzttiporol uzttiporol) {
        this.uzttiporol = uzttiporol;
    }
    public Uztfuncionario getUztfuncionario() {
        return this.uztfuncionario;
    }
    
    public void setUztfuncionario(Uztfuncionario uztfuncionario) {
        this.uztfuncionario = uztfuncionario;
    }
    public String getUztrolCod() {
        return this.uztrolCod;
    }
    
    public void setUztrolCod(String uztrolCod) {
        this.uztrolCod = uztrolCod;
    }
    public String getUztrolFechaIn() {
        return this.uztrolFechaIn;
    }
    
    public void setUztrolFechaIn(String uztrolFechaIn) {
        this.uztrolFechaIn = uztrolFechaIn;
    }
    public String getUztrolFechaOut() {
        return this.uztrolFechaOut;
    }
    
    public void setUztrolFechaOut(String uztrolFechaOut) {
        this.uztrolFechaOut = uztrolFechaOut;
    }
    public BigDecimal getUztrolFlag() {
        return this.uztrolFlag;
    }
    
    public void setUztrolFlag(BigDecimal uztrolFlag) {
        this.uztrolFlag = uztrolFlag;
    }




}


