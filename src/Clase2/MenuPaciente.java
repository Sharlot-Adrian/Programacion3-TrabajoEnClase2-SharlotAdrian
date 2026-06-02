import java.util.LinkedList;

public class MenuPaciente {
    
    LinkedList<Paciente> registroMedico = new LinkedList<Paciente>();

    //Atributos de persona  String nombre, apellido, 
    // tipoSeguro, double peso, altura

    public void agregarPaciente(String nombre, String apellido, String tipoSeguro, double peso, double altura){
        registroMedico.add(new Paciente(nombre, apellido, tipoSeguro, peso, altura));
    }

    public void mostrarPacientes(){
        for(int i = 0; i < registroMedico.size(); i++){
            System.out.println("\nPaciente #" + (i + 1) + ":" + registroMedico.get(i).getNombre());

        }
    }

    public void mostrarPacientesInfo(){
        for(int i = 0; i < registroMedico.size(); i++){
            registroMedico.get(i).MostrarInfoPersonal();
        }
    }

}
