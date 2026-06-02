public class EstudianteInvalidoException extends Exception {
    
    public EstudianteInvalidoException(String mensaje){
        super(mensaje);
    }

    public static void validarEstudiante(String nombre, int edad, double indiceAcademico) throws EstudianteInvalidoException{

        if (nombre.isEmpty()){
            throw new EstudianteInvalidoException("El nombre no puede estar vacio");
        }

        if (edad < 18 || edad > 100){
            throw new EstudianteInvalidoException("La edad debe ser mayor o igual a 18 años.");
        }

        if (indiceAcademico < 0 || indiceAcademico > 4){
            throw new EstudianteInvalidoException("El usuario debe tener un indice valido.");
        }
        
    }
}
