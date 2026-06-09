import java.util.Scanner;
import java.io.*;
public class RegistroEstudiantes {
    
    Scanner scanner = new Scanner(System.in);
    File registro = new File("estudiante.txt");
    
    public void mostrarMenu(){

        int opcion = 0;
        do{
            System.out.println("\n=======================");
            System.out.println("          MENU         ");
            System.out.println("=======================");
            System.out.println("1. Agregar estudiante  ");
            System.out.println("2. Mostrar estudiantes  ");
            System.out.println("3. Salir               ");
            System.out.println("=======================");
            System.out.println("\nIngrese la opcion que desea seleccionar: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){
                case 1:{

                    try{
                        FileWriter fw = new FileWriter("estudiante.txt", true);
                        BufferedWriter bufferedWriter = new BufferedWriter(fw);

                        System.out.println("Ingrese el nombre del estudiante:");
                        String nombre = scanner.nextLine();
                        bufferedWriter.write(nombre);
                        bufferedWriter.newLine();
                        bufferedWriter.close();

                    }catch (IOException e){
                        System.out.println("Algo salio mal. ");
                    }
                    
                    break;
                }
                case 2:{
                    try{

                        FileReader fr = new FileReader("estudiante.txt");
                        String linea;
                        BufferedReader bufferedReader = new BufferedReader(fr);

                        while((linea = bufferedReader.readLine())!=null){
                            System.out.println(linea);
                        }

                        bufferedReader.close();

                    }catch(IOException e){
                        System.out.println("Algo salio mal. ");
                    }

                    break;
                }
                case 3:{
                    System.out.println("Saliendo...");
                    break;
                }
                default: {
                    System.out.println("Esa opcion no es valida. ");
                    break;
                }

            }

        }while(opcion != 3);


    }
}
