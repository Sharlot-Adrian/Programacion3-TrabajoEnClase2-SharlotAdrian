public class Estudiante {

    private String nombre;
    private String matricula;
    private String carrera;

    public Estudiante(String nombre, String matricula, String carrera){
        setNombre(nombre);
        setMatricula(matricula);
        setCarrera(carrera);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    

}
