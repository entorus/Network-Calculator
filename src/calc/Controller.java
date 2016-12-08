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
        choiceBox.getItems().addAll(netmasks());
        choiceBox.getSelectionModel().selectFirst();
    }

    private void validate(TextField textField) {
        //TODO add validation
    }
    private String[] netmasks() {
        String m = "1111111111111111111111111111111100000000000000000000000000000000";
        String[] array = new String[32];
        for (int i = 0; i < 32; i++) {
            int s = 32-i;
            String string = m.substring(i,i+32);
            String first=string.substring(0,7);
            String second=string.substring(8,15);
            String third=string.substring(16,23);
            String fourth=string.substring(24,31);
            array[i] = string + " /" + s;
        }
        return array;
    }
}
