package controller;

import java.time.LocalDate;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Cita;
import model.CodigoDuplicadoException;
import util.ArchivoUtil;

public class ControllerPrincipal {

    @FXML
    private Label lblmensaje;

    @FXML
    private Button bttCancelar;

    @FXML
    private Button bttCargar;

    @FXML
    private Button bttGuardar;

    @FXML
    private Button bttLimpiar;

    @FXML
    private Button bttRegistrar;

    @FXML
    private ComboBox<String> cmbxEspecialidad;

    @FXML
    private ComboBox<String> cmbxEstado;

    @FXML
    private ComboBox<String> cmbxMedico;

    @FXML
    private TableColumn<Cita, String> columnaCodigo;

    @FXML
    private TableColumn<Cita, String> columnaEspecialidad;

    @FXML
    private TableColumn<Cita, String> columnaEstado;

    @FXML
    private TableColumn<Cita, String> columnaHora;

    @FXML
    private TableColumn<Cita, String> columnaMedico;

    @FXML
    private TableColumn<Cita, String> columnaNombrePaciente;

    @FXML
    private TableColumn<Cita, String> columnafecha;

    @FXML
    private Label lblCedula;

    @FXML
    private Label lblCodigo;

    @FXML
    private Label lblEspecialidad;

    @FXML
    private Label lblEstado;

    @FXML
    private Label lblHora;

    @FXML
    private Label lblMedico;

    @FXML
    private Label lblMotivo;

    @FXML
    private Label lblPaciente;

    @FXML
    private Label lblPreviamenteRegistradas;

    @FXML
    private Label lblTelefono;

    @FXML
    private TableView<Cita> tbvwCitas;

    @FXML
    private TextField tfCedula;

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfHora;

    @FXML
    private TextField tfPaciente;

    @FXML
    private TextField tfTelefono;

    @FXML
    private TextArea txtAreaMotivo;

    @FXML
    private Text txtTitulo;

    @FXML
    private Label lblFecha;

    @FXML
    private DatePicker dtpckrFecha;

    @FXML
    private ObservableList<Cita> listaCitas;

    @FXML
    public void initialize(){

        ObservableList<String> estados = cmbxEstado.getItems();
        estados.addAll("Programada", "Atendida", "Cancelada");

        listaCitas = FXCollections.observableArrayList(ArchivoUtil.leerCita());
        tbvwCitas.setItems(listaCitas);

        ObservableList<String> medicos = cmbxMedico.getItems();
        cmbxMedico.setItems(medicos);
        medicos.addAll("Doctor Mario bro", "Doctor Maria Lopez", "Doctor House");

        ObservableList<String> especialidades = cmbxEspecialidad.getItems();
        cmbxEspecialidad.setItems(especialidades);
        especialidades.addAll("Cardiologia", "Neumologia", "Pediatria");
 

        columnaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        columnaNombrePaciente.setCellValueFactory(new PropertyValueFactory<>("nombrePaciente"));
        columnaMedico.setCellValueFactory(new PropertyValueFactory<>("medico"));
        columnaEspecialidad.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        columnafecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        columnaHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        columnaEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
    
    }

    @FXML
    void Cancelar(MouseEvent event){
        
        Cita citaSeleccionada = tbvwCitas.getSelectionModel().getSelectedItem();
        citaSeleccionada.setEstado("Cancelada");
        ArchivoUtil.guardarCita(citaSeleccionada);
        
        tbvwCitas.refresh(); 

    }

    @FXML
    void Cargar(ActionEvent event) {
        
        listaCitas.setAll(ArchivoUtil.leerCita());       
    }

    @FXML
    void Guardar(ActionEvent event){

        try{
            Cita cita = crearCita();

            if(cita == null){
             return;
            }

            ArchivoUtil.guardarCita(cita);
            lblmensaje.setText("Cita guardada exitosamente");
        }catch(CodigoDuplicadoException e){

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Detalle en el codigo");
            alerta.setContentText("El codigo ya ha sido registrado");
            alerta.showAndWait();
            return;
        }

    }

    @FXML
    void Limpiar(ActionEvent event) {

        Platform.runLater(()->{

            tfCodigo.clear();
            tfPaciente.clear();
            tfCedula.clear();
            tfTelefono.clear();
            tfHora.clear();

            cmbxMedico.setValue(null);
            cmbxEspecialidad.setValue(null);
            cmbxEstado.setValue(null);
            
            dtpckrFecha.setValue(null);
            txtAreaMotivo.clear();
        });

    }

    @FXML
    void Registrar(ActionEvent event){
        
        try{
            Cita cita = crearCita();

            if(cita == null){
                return;
            }

            ArchivoUtil.guardarCita(cita);
            listaCitas.setAll(ArchivoUtil.leerCita());
            lblmensaje.setText("Cita guardada exitosamente");
        }catch(CodigoDuplicadoException e){

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Detalle en el codigo");
            alerta.setContentText("El codigo ya ha sido registrado");
            alerta.showAndWait();
            return;
        }

    }

    private Cita crearCita() throws CodigoDuplicadoException {
        
        String codigo = tfCodigo.getText();
   
        if(ArchivoUtil.existeCodigo(codigo)){
            throw new CodigoDuplicadoException("El codigo: " + codigo + " ya esta registrado");
        }
        
        String nombrePaciente = tfPaciente.getText();
        String cedula = tfCedula.getText();
        String telefono = tfTelefono.getText();
        String medico = cmbxMedico.getValue();
        String especialidad = cmbxEspecialidad.getValue();

        if (dtpckrFecha.getValue() == null){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Detalle en el campo de fecha");
            alerta.setContentText("La fecha no puede estar vacia");
            alerta.showAndWait();
            return null;
        }

        if(cedula.contains("-")){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Detalle en el campo de cedula");
            alerta.setContentText("El campo de cedula solo debe contener numeros.");
            alerta.showAndWait();
            return null;
        }

        if(telefono.contains("-")){

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Detalle en el campo de telefono");
            alerta.setContentText("El telefono solo debe contener numeros.");
            alerta.showAndWait();
            return null;
        }

        LocalDate citaFecha = dtpckrFecha.getValue();
        LocalDate fechaActual = LocalDate.now();

        if(citaFecha.isBefore(fechaActual)){

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Fecha anterior a la actual");
            alerta.setContentText("La fecha no puede ser anterior a la fecha actual.");
            alerta.showAndWait();
            return null;

        }

        String fecha = dtpckrFecha.getValue().toString();
        String hora = tfHora.getText();
        String motivo = txtAreaMotivo.getText();
        String estado = cmbxEstado.getValue();

        if(codigo.isEmpty() || nombrePaciente.isEmpty()|| cedula.isEmpty()|| telefono.isEmpty()){
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Omnision de algunos campos");
            alerta.setContentText("Una de las siguientes casillas ha quedado vacia: codigo, nombre de paciente, cedula, telefono. Favor intentar nuevamente.");
            alerta.showAndWait();
            return null;

        }else if(medico == null || especialidad == null || estado == null){

            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Omnision de algunos campos");
            alerta.setContentText("No ha seleccionado algun valor en los espacios de: medico, especialidad o estado. Favor intentar nuevamente.");
            alerta.showAndWait();
            return null;

        }else if(motivo.isEmpty() || hora.isEmpty()){
            
            Alert alerta = new Alert(Alert.AlertType.WARNING);
            alerta.setTitle("Omnision de algunos campos");
            alerta.setContentText("No ha seleccionado algun valor en los espacios de: motivo o hora. Favor intentar nuevamente.");
            alerta.showAndWait();
            return null;
        }

        Cita cita = new Cita(codigo, nombrePaciente,cedula,telefono, medico,
        especialidad,fecha,hora,motivo,estado);
        return cita;

    }
}

    



