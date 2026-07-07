import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller{

    private Stage mainWindow;

    public void setMainWindow(Stage stage){
        this.mainWindow = stage;
    }

    @FXML
    private Button bttnBuscarInformacion;

    @FXML
    private Label lblRegistroEst;

    @FXML
    private Label lblCarrera;

    @FXML
    private Label lblMatricula;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblResultado;

    @FXML
    private TextField tfCarrera;

    @FXML
    private TextField tfEstudiante;

    @FXML
    private TextField tfMatricula;

    @FXML
    private Text txtResultado;

    @FXML
    void EnviarInfo(ActionEvent event) {

        Estudiante est = new Estudiante(tfEstudiante.getText(), tfMatricula.getText(), tfCarrera.getText());

        ControllerDos controller = Navegacion.abrirVentana("escenaSecundaria.fxml", "Detalle estudiante");
        controller.recibirEstudiante(est);
    }
}