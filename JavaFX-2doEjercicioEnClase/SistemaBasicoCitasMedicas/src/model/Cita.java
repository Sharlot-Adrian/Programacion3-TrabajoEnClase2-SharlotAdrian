package model;

public class Cita {

    private String codigo;
    private String nombrePaciente;
    private String cedula;
    private String telefono;
    private String medico;
    private String especialidad;
    private String fecha;
    private String hora;
    private String motivoConsulta;
    private String estado;

    public Cita(String codigo, String nombrePaciente, String cedula,String telefono, String medico, 
     String especialidad, String fecha, String hora, String motivoConsulta, String estado){
        setCodigo(codigo);
        setCedula(cedula);
        setNombrePaciente(nombrePaciente);
        setCedula(cedula);
        setTelefono(telefono);
        setMedico(medico);
        setEspecialidad(especialidad);
        setFecha(fecha);
        setHora(hora);
        setMotivoConsulta(motivoConsulta);
        setEstado(estado);

    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getMedico() {
        return medico;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public String getEstado() {
        return estado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
