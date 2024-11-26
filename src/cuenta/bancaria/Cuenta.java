
package cuenta.bancaria;
import java.util.*;

public class Cuenta {
    //Atributos
    protected int numeroCuenta;
    protected Titular titular; //Pongo como atributo a un objeto de la clase Titular, asi asocio al titular con la cuenta
    protected String tipoCuenta;
    protected double saldo;
    protected double comision;
    protected boolean estado; //Con el booleano puedo controlar si la cuenta etsá activa o inactiva
    protected ArrayList<String> historialOperaciones; //Me permite generar una lista modificable con todas las ops realizadas
    
     public Cuenta(int numeroCuenta, Titular titular, String tipoCuenta, double saldoInicial, double comision) { //inicializo los atributos
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldoInicial;
        this.comision = comision;
        this.estado = true; //La cuenta por defecto está activa
        this.historialOperaciones = new ArrayList<>();   //Me genera la lista de ops para la cuenta nueva
    }
     //Getters para los datos de la cuenta
    public int getNumeroCuenta() {
        return numeroCuenta;
    }
    public Titular getTitular() {
        return titular;
    }
    public String getTipoCuenta() {
        return tipoCuenta;
    }
    public double getSaldo() {
        return saldo;
    }
    public boolean isActiva() {
        return estado;
    }
    public ArrayList<String> getHistorialOperaciones() {
        return historialOperaciones;
    }
    //Metodo desactivador de la cuenta
    public void desactivarCuenta() { //Cuando se active este metodo desactivará la cuenta impidiendo que se ejecuten transacciones en general
        estado = false;
        System.out.println("La cuenta ha sido desactivada."); //Confirmacion de la op
    }    
//Metodo consignar
    public void consignar(double monto1) {
        if (!estado) { //Uso ! para que detecte cuando la cuenta se desactive ya que el metodo para ello cambia el bool a false
            System.out.println("Error: La cuenta está inactiva.");
            return; //return sin nada para que acabe ahi el if
        }
        saldo += monto1; //Al valor del saldo se le suma y establece como nuevo saldo el resultado
        historialOperaciones.add("Consignación de: $" + monto1 + " Nuevo saldo: $" + saldo); //Se añade a la lista de ops una nueva entrada
        System.out.println("Consignación exitosa. Nuevo saldo: $" + saldo); //Confirma que se completó la consignación
    }
    //Metodo retirar
    public void retirar(double monto2) {
        if (!estado) { //Uso ! para que detecte cuando la cuenta se desactive ya que el metodo para ello cambia el bool a false
            System.out.println("Error: La cuenta está inactiva.");
            return; //return sin nada para que acabe ahi el if
        }
        saldo -= monto2; //Al valor del saldo se le resta y establece como nuevo saldo el resultado
        historialOperaciones.add("Retiro de: $" + monto2 + " Nuevo saldo: $" + saldo); 
        System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo); 
    }
    //Metodo transferir
    
    public boolean transferir(Cuenta cuenta2, double monto3){
        if (!estado) { 
            System.out.println("Error: La cuenta está inactiva.");
            return false; //return sin nada para que acabe ahi el if
        }
        if (saldo < monto3){
            System.out.println("El saldo actual es insuficiente para la transferencia");
            return false;
        }
        boolean completo = cuenta2.transfRecib(monto3);
        if (completo){
        saldo -= monto3;
        historialOperaciones.add("Transferencia de: $" + monto3 + " a cuenta " + cuenta2.getNumeroCuenta());
        System.out.println("Transferencia exitosa. Nuevo saldo: $" + saldo);       
        return true;  
        }else{
            System.out.println("La transferencia no pudo completarse");
            return false;
        }          
    }
    public boolean transfRecib(double monto3){
        
        if (!estado) {
        System.out.println("La cuenta destino se encuentra desactivada");
        return false;
    }
        saldo += monto3;
        historialOperaciones.add("Recibida transferencia de: $" + monto3);
        //System.out.println("Transferencia recibida exitosamente.");
        return true; 
    }
    //Mostrar datos de la cuenta
    public void mostrarMenuCuenta(){
        int opcion2 = -1;
        try{
            Scanner s2 = new Scanner(System.in);
            System.out.println("Informacion de la cuenta: ");
            System.out.println("0. Numero de cuenta");
            System.out.println("1. Titular");
            System.out.println("2. Tipo de cuenta");
            System.out.println("3. Saldo actual");
            System.out.println("4. Estado de la cuenta");
            System.out.println("5. Historial de operaciones");
            System.out.println("Elige una opcion: ");
            opcion2 = s2.nextInt();
        }catch(InputMismatchException e){
            System.out.println("El valor ingresado no es valido, reintentar");
        }
        switch(opcion2){
            case 0:
                System.out.println("Numero de la cuenta: " + numeroCuenta);
                break;
            case 1:
                System.out.println("Titular de la cuenta: " + titular);
                break;
            case 2:
                System.out.println("Tipo de cuenta: " + tipoCuenta);
                break;    
            case 3:
                System.out.println("El saldo actual es de: " + saldo);
                break;    
            case 4:
                System.out.println("El estado de la cuenta es: " + estado);
                break;    
            case 5:
                System.out.println("Historial de operaciones: " + historialOperaciones);
                break;
            
            default:
                System.out.println("No existe opcion con ese numero");
                break;
        }
    }

   


}

