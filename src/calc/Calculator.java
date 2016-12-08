package calc;

/**
 * Created by Administrator on 08.12.2016.
 */
class Calculator {
    private int firstOctet;
    private int secondOctet;
    private int thirdOctet;
    private int fourthOctet;

    Calculator(int firstOctet, int secondOctet, int thirdOctet, int fourthOctet) {
        this.firstOctet = firstOctet;
        this.secondOctet = secondOctet;
        this.thirdOctet = thirdOctet;
        this.fourthOctet = fourthOctet;
    }

    String response() {
        return "Lalala";
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
}
