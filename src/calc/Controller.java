package calc;


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
    @FXML
    Label maskResultLabel;


    public void onClick() {
        int first = validate(firstOctet);
        int second = validate(secondOctet);
        int third = validate(thirdOctet);
        int fourth = validate(fourthOctet);
        Calculator calc = new Calculator(first,second,third,fourth);
        resultLabel.setText(calc.result());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().addAll(netmasks());
        choiceBox.getSelectionModel().selectFirst();
        maskResultLabel.textProperty().bind(choiceBox.getSelectionModel().selectedItemProperty());
    }

    private int validate(TextField textField) {
        int value = Integer.parseInt(textField.getText());
        if (value>255 || value<0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Some text");
            alert.showAndWait();
            return 0; //change this
        }
        return value;
    }
    private String[] netmasks() {
        String m = "1111111111111111111111111111111100000000000000000000000000000000";
        String[] array = new String[32];
        for (int i = 0; i < 32; i++) {
            int s = 32-i;
            String string = m.substring(i,i+32);
            int first=Integer.parseInt(string.substring(0,8),2);
            //String first=string.substring(0,8);
            int second=Integer.parseInt(string.substring(8,16),2);
            int third=Integer.parseInt(string.substring(16,24),2);
            int fourth=Integer.parseInt(string.substring(24),2);
            //String fourth=string.substring(24);
            array[i] = first + "." + second + "." + third + "." + fourth + "/" + s;
            //array[i]=fourth;
        }
        return array;
    }
}
