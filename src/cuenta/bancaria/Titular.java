
package cuenta.bancaria;
import java.util.*;

public class Titular {
    
    private String nombre;
    private String identificacion;
    private int edad;
    private String direccion;
    private double ingresos; //Para crear una cuent se requiere una cant. de ingresos minimos
    
public Titular (String nombre, String identificacion, int edad, String direccion, double ingresos) { //Inicializo atributos
        this.nombre = nombre; //This me permite usar el nombre del metodo como su valor y que no se confunda java
        this.identificacion = identificacion; //Así puedo saber directamente que dato del titular estoy trabajando
        this.edad = edad;
        this.direccion = direccion;
        this.ingresos = ingresos;
}    
//Getters (Me dejan ver los valores que tienen los atributos)
    public String getNombre() {
        return nombre;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public int getEdad() {
        return edad;
    }
    public String getDireccion() {
        return direccion;
    }
    public double getIngresos() {
        return ingresos;
    }
//Ver datos del titular
    Scanner s1 = new Scanner(System.in);
    public void mostrarMenuTitular(){
        int opcion1 = -1;
        try{
            
            System.out.println("Informacion del Titular: ");
            System.out.println("0. Nombre");
            System.out.println("1. Identificacion");
            System.out.println("2. Edad");
            System.out.println("3. Direccion");
            System.out.println("Elige una opcion: ");
            opcion1 = s1.nextInt();
        }catch(InputMismatchException e){
            System.out.println("El valor ingresado no es valido, reintentar");
            
        }
        switch(opcion1){
            case 0:
                System.out.println("Nombre: " + nombre);
                break;
            case 1:
                System.out.println("Identificacion: " + identificacion);
                break;
            case 2:
                System.out.println("Edad: " + edad);
                break;    
            case 3:
                System.out.println("Direccion: " + direccion);
                break;    
            
            default:
                System.out.println("No existe opcion con ese numero");
                break;
        }
    }
}

