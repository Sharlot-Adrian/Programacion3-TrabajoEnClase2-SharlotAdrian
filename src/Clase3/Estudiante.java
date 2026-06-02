public class Estudiante {

    private String nombre;
    private double indiceAcademico;
    private int edad;

    public Estudiante(String nombre, int edad, double indiceAcademico){
        setNombre(nombre);
        setEdad(edad);
        setIndiceAcademico(indiceAcademico);

    }

    public String getNombre(){
        return nombre;
    }

    public double getEdad(){
        return edad;
    }

    public double getIndiceAcademico(){
        return indiceAcademico;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }    

    public void setIndiceAcademico(double indiceAcademico) {
        this.indiceAcademico = indiceAcademico;
    }

}
