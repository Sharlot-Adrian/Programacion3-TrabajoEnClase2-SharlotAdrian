import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerDos {

    @FXML
    private Label lblCarrera;

    @FXML
    private Label lblMatricula;

    @FXML
    private Label lblNombre;

    @FXML
    private Text txtCarrera;

    @FXML
    private Text txtMatricula;

    @FXML
    private Text txtNombre;

    @FXML
    private Label txtTitulo;

    @FXML
    private Button bttnCerrar;

    @FXML
    void Cerrar(ActionEvent event) {
        Stage stage = (Stage) lblNombre.getScene().getWindow();
        stage.close();
    }


    @FXML
    public void recibirEstudiante(Estudiante est){

        txtNombre.setText(est.getNombre());
        txtMatricula.setText(est.getMatricula());
        txtCarrera.setText(est.getCarrera());


    }

}

