package calc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextField firstOctet;
    @FXML
    TextField secondOctet;
    @FXML
    TextField thirdOctet;
    @FXML
    TextField fourthOctet;
    @FXML
    Label resultLabel;
    @FXML
    ChoiceBox<String> choiceBox;

    public void onClick() {
        int first = Integer.parseInt(firstOctet.getText());
        int second = Integer.parseInt(secondOctet.getText());
        int third = Integer.parseInt(thirdOctet.getText());
        int fourth = Integer.parseInt(fourthOctet.getText());
        Calculator calc = new Calculator(first,second,third,fourth);
        resultLabel.setText(calc.result());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().addAll("First", "Second", "Third");
        choiceBox.getSelectionModel().selectFirst();
    }

    private void validate(TextField textField) {

    }
}
