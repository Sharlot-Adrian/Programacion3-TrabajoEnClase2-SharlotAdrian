import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MenuPaciente menuPaciente = new MenuPaciente();
        
        int opcion = 0;
        
        do{

            System.out.println("---------------------------------------------");
            System.out.println("|                     MENU                  |");
            System.out.println("---------------------------------------------");
            System.out.println("| 1.Registrar paciente                      |");
            System.out.println("| 2.Mostrar informacion de pacientes        |");
            System.out.println("| 3.Mostrar todos los pacientes registrados |");
            System.out.println("| 4.Salir                                   |");
            System.out.println("--------------------------------------------");
            System.out.println("\nIngrese la opcion que desea seleccionar: ");
            
            try{
                opcion = scanner.nextInt();
                scanner.nextLine();
            }
            catch(Exception e){
                System.out.println("ERROR! Ingrese un numero del menu!");
                scanner.nextLine();
                opcion = 0;
            }

            switch(opcion){
                case 1:{
                    System.out.println("\n[AGREGAR PACIENTE]");
                    System.out.println("*-------------------------------------------*");
                    System.out.println("Ingrese el nombre del paciente: ");
                    String nombre = scanner.nextLine();

                    System.out.println("Ingrese el apellido del paciente: ");
                    String apellido = scanner.nextLine();

                    System.out.println("Ingrese el tipo de seguro medico del paciente: ");
                    String tipoSeguro = scanner.nextLine();

                    System.out.println("Ingrese el peso del paciente (Kg): ");
                    double peso = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Ingrese la altura del paciente (m): ");
                    double altura = scanner.nextDouble();
                    scanner.nextLine();

                    menuPaciente.agregarPaciente(nombre, apellido, tipoSeguro, peso, altura);
                    break;

                }
                case 2:{
                    System.out.println("\n[ MOSTRAR INFORMACION DE PACIENTES ]");
                    System.out.println("*-------------------------------------------*");
                    menuPaciente.mostrarPacientesInfo();
                    System.out.println("*-------------------------------------------*");
                    break;

                }
                case 3:{
                    System.out.println("\n[ MOSTRAR TODOS LOS PACIENTES ]");
                    System.out.println("*-------------------------------------------*");
                    menuPaciente.mostrarPacientes();
                    System.out.println("*-------------------------------------------*");
                    break;

                }
                case 4:{
                    System.out.println("Saliendo...");
                    break;

                }
         
                default:{
                    System.out.println("Opcion invalida.");
                    break;
                }
            }

        }while(opcion !=4);

        scanner.close();
    }
}