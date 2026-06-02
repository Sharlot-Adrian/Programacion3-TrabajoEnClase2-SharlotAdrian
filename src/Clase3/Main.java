
import java.util.Scanner;

public class Main {

    public static void main (String [] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese una edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese un indice: ");
        double indice = scanner.nextDouble();
        scanner.nextLine();

        try{
            EstudianteInvalidoException.validarEstudiante(nombre,edad,indice);

        }catch(Exception e){

            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Proceso finalizado.");
        }

    }

    
}