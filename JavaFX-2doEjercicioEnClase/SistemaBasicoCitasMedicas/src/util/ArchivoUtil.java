package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Cita;

public class ArchivoUtil {

    public static void guardarCita(Cita cita){

        try{
            FileWriter fw = new FileWriter("citas.txt", true);
            fw.write(cita.getCodigo() + ";" + cita.getNombrePaciente() + ";" + cita.getCedula() 
            + ";" + cita.getTelefono() + ";" + cita.getMedico() + ";" + cita.getEspecialidad() + ";" + cita.getFecha() + 
            ";" + cita.getHora() + ";" + cita.getMotivoConsulta() + ";" + cita.getEstado() + "\n");

            fw.close();

        }catch(Exception e){
            System.out.println("Error al abrir el archivo " + e.getMessage());
        }

    }

    public static ArrayList<Cita> leerCita(){

        ArrayList<Cita> citas = new ArrayList<>();

        try{

            
            FileReader fr = new FileReader("citas.txt");
            BufferedReader bf = new BufferedReader(fr);

            String linea;

            while((linea = bf.readLine())!=null){

                String[] partes = linea.split(";");

                if(partes.length == 10){

                    Cita cita = new Cita(partes[0],partes[1],partes[2], partes[3], partes[4], 
                    partes[5], partes[6], partes[7], partes[8], partes[9]);

                    citas.add(cita);
                }
            }

            fr.close();
            bf.close();

        }catch(IOException e){
            System.out.println("Error al leer el archivo " + e.getMessage());
        }

        return citas;
    
    } 

    public static boolean existeCodigo(String codigo){

        try{

            FileReader fr = new FileReader("citas.txt");
            BufferedReader bf = new BufferedReader(fr);

            String linea;

            while((linea = bf.readLine())!=null){

                String[] partes = linea.split(";");

                if(partes.length > 0  && partes[0].equals(codigo)){
                    return true;
                }
            }

            fr.close();
            bf.close();

        }catch(IOException e){
            System.out.println("Error al comprobar si el codigo existe " + e.getMessage());
        }
        
        return false;


    } 


    


}


