public class Paciente {

    private String nombre;
    private String apellido;
    private String tipoSeguro;
    private double peso;
    private double altura;
    private double imc;
    private String estado;

    public Paciente(){

    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getTipoSeguro(){
        return tipoSeguro;
    }

    public double getPeso(){
        return peso;
    }

    public double getAltura(){
        return altura;
    }

    public double getImc(){
        return imc;
    }

    public String getEstado(){
        return estado;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setTipoSeguro(String tipoSeguro){
        this.tipoSeguro = tipoSeguro;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }

    public void setImc(double imc){
        this.imc = imc;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }



}
