package calc;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * Created by Administrator on 08.12.2016.
 */
class Calculator {
    private int firstOctet;
    private int secondOctet;
    private int thirdOctet;
    private int fourthOctet;

    Calculator(TextField firstOctet, TextField secondOctet, TextField thirdOctet, TextField fourthOctet) {
        int[] array = validate(firstOctet,secondOctet,thirdOctet,fourthOctet);
        this.firstOctet = array[0];
        this.secondOctet = array[1];
        this.thirdOctet = array[2];
        this.fourthOctet = array[3];
    }

    String result() {
        return toBinary(firstOctet) + "." + toBinary(secondOctet)+ "." + toBinary(thirdOctet)+ "." + toBinary(fourthOctet);
    }
    private String toBinary(int decimal) {
        String binary = Integer.toBinaryString(decimal);
        String result;
        if (binary.length()<8) {
            result = ("00000000" + binary).substring(binary.length());
        }
        else {
            result = binary;
        }
        return result;
    }
    private int[] validate(TextField textField1,TextField textField2,TextField textField3,TextField textField4) {
        int[] arr = {Integer.parseInt(textField1.getText()),Integer.parseInt(textField2.getText()),Integer.parseInt(textField3.getText()),Integer.parseInt(textField4.getText())};
        for (int value : arr) {
            if (value>255 || value<0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Some text");
                alert.showAndWait();
                break;
            }
        }
        return arr;
    }
}
