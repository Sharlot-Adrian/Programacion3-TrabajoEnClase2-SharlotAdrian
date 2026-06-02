public class Paciente {

    private String nombre;
    private String apellido;
    private String tipoSeguro;
    private double peso;
    private double altura;

    private double imc;
    private String estado;

    public Paciente(String nombre, String apellido, String tipoSeguro, double peso, double altura){
        setNombre(nombre);
        setApellido(apellido);
        setTipoSeguro(tipoSeguro);
        setPeso(peso);
        setAltura(altura);

        setImc(calcularImc(peso, altura));
        setEstado(determinarEstado(getImc()));
  
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

    private double calcularImc(double peso, double altura){
        double resultado = peso / (altura * altura);
        return resultado;
    }

    private String determinarEstado(double imc){

        if (imc < 18.5)
            return "Peso Bajo";
        else if (imc >= 18.5 && imc <= 24.9)
            return "Normal";
        else if (imc >= 25.00 && imc <= 29.90)
            return "SobrePeso";
        else if (imc >= 30)
            return "Obesidad";
        else
            return "indeterminado";
        

    }

    public void MostrarInfoPersonal(){
        System.out.println("\n[INFORMACION DEL PACIENTE: " + getNombre());
        System.out.println("*-------------------------------------------*");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Tipo de Seguro medico: " + getTipoSeguro());
        System.out.printf("IMC: %.4f kg/m2", getImc() );
        System.out.println();
        System.out.println("Estado: " + getEstado());
        System.out.println("*-------------------------------------------*");

    }



}
