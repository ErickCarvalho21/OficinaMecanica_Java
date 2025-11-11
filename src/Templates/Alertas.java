package Templates;

import javafx.scene.control.Alert;

public class Alertas {

    public void mostrarConfirmacao(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informação");
        alert.setHeaderText("Operação realizado com sucesso!" );
        alert.setContentText("Login realizado com sucesso");
        alert.showAndWait();
    }
}
