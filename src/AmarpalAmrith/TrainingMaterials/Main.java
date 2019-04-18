package AmarpalAmrith.TrainingMaterials;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Utilities.welcomeMsg("Hi, Welcome to the Caesar shift...");
        String input = Utilities.requestString("please enter a string to encode!");
        int shift = Utilities.requestInt("Please enter a shift key");

        System.out.println(getShiftedString(input, shift));
    }

    private static String getShiftedString(String string, int shiftKey) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length() - 1; i++) {
            String s = string.substring(i, i + 1);
            int charNumber = 0;
            if (s.equalsIgnoreCase(" ")) {
                sb.append(" ");
            } else if (Utilities.isInteger(s)) {
                sb.append(s);
            }else {
                charNumber = getNumberForChar(s.charAt(0));
            }
            int shiftedCharNumber = charNumber + shiftKey > 26 ? charNumber + shiftKey - 26 : charNumber + shiftKey;
            sb.append(getCharForNumber(shiftedCharNumber));
        }

        return sb.toString();
    }

    private static String getCharForNumber(int i) {
        return i > 0 && i < 27 ? String.valueOf((char) (i + 65)) : null;
    }

    private static int getNumberForChar(char letter) {
        int counter = 0;
        for (char a = 'A'; a <= 'Z'; a++) {

            if (letter == a) {
                return counter;
            }
            counter++;
        }
        return 0;
    }
//    private static List<String> createShiftedAlphabet(int shiftKey) {
//        List<String> list = new ArrayList<>();
//
//        for (int i = shiftKey + 26; i < shiftKey; i++) {
//            list.add(getCharForNumber(Math.abs(i)));
//        }
//        return list;
//    }
}
