/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencia;

/**
 *
 * @author Administrator
 */
public class EmpleadoComun extends Empleado implements Aumentable,Deductible{
    
protected double salario;


 public EmpleadoComun(int code, String name, double salary){
    super (code,name);
    salario= salary;
 
 }
    public double bono(){
        return 0;   
    }
    
    public void setSalario (double salario){
    this.salario=salario;
    }
    
    public double deduct(){
    return salario*Deductible.TASA_DEDUCCION;   
    }
    
    public double pagar(){
    return salario-deduct();
    }
    
    public boolean validForIncrease(){
    return true;
    }
    
    public void increaseIncome(){
    if (validForIncrease())
        salario+=salario*0.1;
    }

    @Override
    public String toString() {
        return super.toString()+"EmpleadoComun{" + "salario=" + salario + '}';
    }
    
}
