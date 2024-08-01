/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package herencia;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


/**
 *
 * @author Administrator
 */
public class Empresa {
    
    static Scanner lea = new Scanner(System.in);
    static ArrayList<Empleado> empleados = new ArrayList<>();
            
    public static void main(String[] args) {
       
        int op;
        
        do{
            System.out.println("1- Agregar Empleado");
            System.out.println("2- Pagar Empleado");
            System.out.println("3- Lista de Empleados");
            System.out.println("4- Sub Menu especifico");
            System.out.println("5- Salir");
            System.out.print("Escoja Opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    hire();
                    break;
                case 2:
                    pay();
                    break;
                case 3:
                    list();
                    break;
                case 4:
                    submenu();
                    break;
            }
        }while(op!=5);
        
    }
    
    /**
     * Recorre la lista de Empleados. Si encuentra un
     * empleado con ese codigo, se retorna, sino, retorna null
     * @param cod Codigo del Empleado
     * @return El obj Empleado si se encuentra, null si no
     */
    private static Empleado search(int cod){
       for (Empleado empleado : empleados) {
            if (empleado != null && empleado.getCodigo() == cod) {
                return empleado;
            }
        }
        return null;
    }

    /**
     * Contrata un nuevo empleado
     * 1- Se pide del teclado el tipo: COMUN, HORA, VENTA o TEMPORAL
     * 2- Se instancia un objeto segun el tipo y se guarda en el arreglo
     * 3- pero siempre y cuando el Codigo NO este repetido
     * 4- LOS DATOS requeridos se ingresan del teclado
     */
    private static void hire() {
    System.out.print("Ingrese tipo de empleado (COMUN, HORA, VENTA, TEMPORAL): ");
        String tipo = lea.next().toUpperCase();
        System.out.print("Ingrese codigo: ");
        int codigo = lea.nextInt();
        
        if (search(codigo) != null) {
            System.out.println("Codigo ya existente.");
            return;
        }
        
        System.out.print("Ingrese nombre: ");
        String nombre = lea.next();
        
        switch (tipo) {
            case "COMUN":
                System.out.print("Ingrese salario: ");
                double salario = lea.nextDouble();
                empleados.add(new EmpleadoComun(codigo, nombre, salario));
                break;
            case "HORA":
                empleados.add(new EmpleadoPorHora(codigo, nombre));
                break;
            case "VENTA":
                System.out.print("Ingrese salario base: ");
                salario = lea.nextDouble();
                empleados.add(new EmpleadoPorVenta(codigo, nombre, salario));
                break;
            case "TEMPORAL":
                empleados.add(new EmpleadoTemporal(codigo, nombre));
                break;
            default:
                System.out.println("Tipo de empleado no valido.");
                break;
        }
    }

    /**
     * Le paga a un empleado
     * 1- Pide del teclado el codigo
     * 2- Buscamos ese empleado
     * 3- Si existe, mostramos en pantalla su pago
     */
    private static void pay() {
    System.out.print("Ingrese codigo del empleado: ");
        int codigo = lea.nextInt();
        Empleado empleado = search(codigo);
        if (empleado != null) {
            System.out.println("Pago: " + empleado.pagar());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    /**
     * Imprimir la lista de empleados
     */
    private static void list() {
         for (Empleado empleado : empleados) {
            if (empleado != null) {
                System.out.println(empleado);
            }
        }
    } 
    

    
    private static void submenu() {
        int op;
        do{
            System.out.println("1-Fecha Fin Contrato a Temporales");
            System.out.println("2-Ingresar Venta");
            System.out.println("3-Ingresar Horas de Trabajo");
            System.out.println("4-Regresar al Menu Principal");
            System.out.print("Escoja Opcion: ");
            op = lea.nextInt();
            
            switch(op){
                case 1:
                    setFin();
                    break;
                case 2:
                    ventas();
                    break;
                case 3:
                    horas();
            }
            
        }while(op!=4);
    }
    
    /**
     * 1- Leer un codigo
     * 2- Buscar el empleado, que existe y q sea Temporal
     * 3- Si concuerda, set fecha fin contrato
     * 4- Leer del teclado los datos
     */
    private static void setFin() {
     System.out.print("Ingrese codigo del empleado: ");
        int codigo = lea.nextInt();
        Empleado emp = search(codigo);
        if (emp != null && emp instanceof EmpleadoTemporal) {
           Calendar fin = Calendar.getInstance();
            ((EmpleadoTemporal) emp).setFinContrato(fin);
            System.out.println("Fecha de fin de contrato actualizada.");
        } else {
            System.out.println("Empleado no encontrado o no es temporal.");
        }
    }

    /**
     * 1- Leer un codigo
     * 2- Buscar empleado, que exista y que sea PorVentas
     * 3- Si concuerda, agregar una venta
     * 4- Leer del teclado los datos
     */
    private static void ventas() {
        System.out.print("Ingrese codigo del empleado: ");
        int codigo = lea.nextInt();
        Empleado emp = search(codigo);
        if (emp != null && emp instanceof EmpleadoPorHora) {
            System.out.print("Ingrese horas trabajadas: ");
            int horas = lea.nextInt();
            ((EmpleadoPorHora) emp).setHorasT(horas);
            System.out.println("Horas agregadas.");
        } else {
            System.out.println("Empleado no encontrado o no es por horas.");
        }
    
    }

    /**
     * 1- Leer un codigo
     * 2- Buscar empleado, que exista y que sea PorHoras
     * 3- Si concuerda, agregar las horas trabajadas
     * 4- Leer del teclado los datos
     */
    private static void horas() {
        System.out.print("Ingrese codigo del empleado: ");
        int codigo = lea.nextInt();
        Empleado emp = search(codigo);
        if (emp != null) {
            try {
                EmpleadoPorHora empPorHora = (EmpleadoPorHora) emp;
                System.out.print("Ingrese horas trabajadas: ");
                int horas = lea.nextInt();
                empPorHora.setHorasT(horas);
                System.out.println("Horas agregadas.");
            } catch (ClassCastException e) {
                System.out.println("Empleado no es por horas.");
            }
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }
}
