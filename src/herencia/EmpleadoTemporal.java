/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencia;

import java.util.Calendar;

/**
 *
 * @author Administrator
 */
public class EmpleadoTemporal extends EmpleadoComun {

    
    private Calendar finContrato;

    public EmpleadoTemporal(int code, String name) {
        super(code, name, 15000);
        this.finContrato = Calendar.getInstance();
        finContrato.add(Calendar.MONTH, 6);
    }
    
    @Override
    public double pagar(){
    Calendar hoy = Calendar.getInstance();
    if(hoy.before(finContrato))
        return super.pagar();
    return 0 ;
        }
    
    public String toString(){
        return super.toString()+"Fin Contrato"+finContrato.getTime();
    
    
    
    }
    public Calendar getFinContrato() {
        return finContrato;
    }

    public void setFinContrato(Calendar finContrato) {
        this.finContrato = finContrato;
    }
    
    
    
}
