
package cuenta.bancaria;
import java.util.*;


/*
Autor: Juan Esteban Sarmiento Benitez
 */
public class CuentaBancaria {

    public static void main(String[] args) { //Metodo Main
        Titular titular1 = new Titular("Juanes","1013259863",19,"Bogota, Colombia",3000000); //Crear una cuenta de titular
        Titular titular2 = new Titular("Paco","1063275893",26,"Bucaramanga, Colombia",6000000); // Se creo un nuevo titular para la cuenta 2
        Cuenta cuenta1 = new Cuenta(34567821,titular1,"ahorros",890,8976); //Crear cuenta bancaria
        Cuenta cuenta2 = new Cuenta(67898752,titular2,"ahorros",233,7893);//Se creo una segunda cuenta para hacer la transferencia
        
    //Menu para seleccionar operacion
        Scanner s = new Scanner(System.in);
        int opcion0 = -1;
        int subOpcion = -1;
        do {
            try{
                System.out.println("=== Menu Principal ===");
                System.out.println("1. Consultar informacion");
                System.out.println("2. Consignar dinero");
                System.out.println("3. Retirar dinero");
                System.out.println("4. Transferir dinero");
                System.out.println("5. Salir");
                System.out.print("Elige una opcion: ");
                opcion0 = s.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Error el valor ingresado no es valido, reintentar");
                break;
            }
            switch(opcion0){
                case 1: // Opcion de consultar info
                    try{
                        System.out.println("Deseas consultar datos de la cuenta o del titular?");
                        System.out.println("1. Datos de la cuenta");
                        System.out.println("2. Datos del titular");
                        System.out.print("Elige una opcion: ");
                        subOpcion = s.nextInt();
                    }catch(InputMismatchException e){
                        System.out.println("Error el valor ingresado no es valido, reintentar");
                        break;
                    }
                    if (subOpcion == 1) {
                        cuenta1.mostrarMenuCuenta();
                    } else if (subOpcion == 2) {
                        titular1.mostrarMenuTitular();
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;
                case 2: //Opcion de consignar
                    try{
                        System.out.println("Cuanto deseas consignar?: ");
                        double monto1 = s.nextDouble();
                        cuenta1.consignar(monto1);
                    }catch(InputMismatchException e){
                        System.out.println("Error el valor ingresado no es valido, reintentar");
                        break;
                    }
                    
                    break;
                        
                case 3: //Opcion de retirar
                     try{
                        System.out.println("Cuanto deseas retirar?: ");
                        double monto2 = s.nextDouble();
                        cuenta1.retirar(monto2);
                    }catch(InputMismatchException e){
                        System.out.println("Error el valor ingresado no es valido, reintentar");
                    }   
                    break;
                case 4: //Opcion de Transferir
                     try{
                        System.out.println("Cuanto deseas transferir?: ");
                        double monto3 = s.nextDouble();
                        cuenta1.transferir(cuenta2, monto3);
                    }catch(InputMismatchException e){
                        System.out.println("Error el valor ingresado no es valido, reintentar");
                        break;
                    }  
                    break;
                case 5: //Salir
                    System.out.println("Saliendo del menu");
                    break;
            }
        }while(opcion0 != 5);
    }
    
}
