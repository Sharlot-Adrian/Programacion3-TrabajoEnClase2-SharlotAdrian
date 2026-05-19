import java.util.Scanner;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LinkedList<Paciente> registroMedico = new LinkedList<Paciente>();

        int opcion = 0;
        
        do{

            System.out.println("--------------------------------------------");
            System.out.println("|                     MENU                 |");
            System.out.println("--------------------------------------------");
            System.out.println("| 1.Registrar paciente                     |");
            System.out.println("| 2.Mostrar informacion de pacientes       |");
            System.out.println("| 3.Mostrar los pacientes registrados      |");
            System.out.println("| 4.Salir                                  |");
            System.out.println("--------------------------------------------");
            System.out.println("\nIngrese la opcion que desea seleccionar: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){
                case 1:{
                    break;

                }
                case 2:{
                    break;

                }
                case 3:{
                    break;

                }
                case 4:{
                    break;

                }
         
                default:{
                    break;
                }
            }



        }while(opcion !=6);
    }
}