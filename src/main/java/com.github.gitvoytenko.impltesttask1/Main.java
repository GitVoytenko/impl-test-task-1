package src.main.java.com.github.gitvoytenko.impltesttask1;

import java.util.HashSet;
import java.util.Set;

import static javax.swing.JOptionPane.showInputDialog;

public class Main {

    /**
     * Method for concatenating brackets to existing ones
     *
     * @param str a string of generated brackets
     * @param index index to trim the passed bracket string
     * @return the created value by appending the values on the left and right
     */
    public static String insertInside(String str, int index) {
        String left = str.substring(0, index + 1);
        String right = str.substring(index + 1);
        return left + "()" + right;
    }

    /**
     * Recursive method for generating parentheses
     *
     * @param quantity the number of correctly spaced brackets that need to be generated
     * @return returns a set with unique values already filled in
     */
    public static Set<String> generateParenthesis(int quantity) {
        Set<String> set = new HashSet<>();
        if (quantity == 0) {
            set.add("");
        } else {
            Set<String> prev = generateParenthesis(quantity - 1);
            for (String str : prev) {
                for (int i = 0; i < str.length(); i++) {
                    String s = insertInside(str, i);
                    set.add(s);
                }
                set.add("()" + str);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        int inputInfo = 0;
        try {
            // dialog window for entering a value
            inputInfo = Integer.parseInt(showInputDialog("Введите число:"));
        } catch (NumberFormatException e) {
            System.out.println("Введено текстовое или не целочисленное значение");
            System.exit(0);
        }

        // conditions for entering a suitable value
        if (inputInfo < 0){
            System.out.println("Отрицательные значения не принимаюся");
            System.exit(0);
        } else if (inputInfo == 0) {
            System.out.println("Нечего отображать");
            System.exit(0);
        }

        // creating a list and assign to a variable a reference to the result returned by the method
        Set<String> list = generateParenthesis(inputInfo);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.size());
    }
}
