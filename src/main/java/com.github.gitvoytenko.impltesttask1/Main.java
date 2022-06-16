package src.main.java.com.github.gitvoytenko.impltesttask1;

import java.util.HashSet;
import java.util.Set;

import static javax.swing.JOptionPane.showInputDialog;

public class Main {
    public static String insertInside(String str, int index) {
        String left = str.substring(0, index + 1);
        String right = str.substring(index + 1);
        return left + "()" + right;
    }

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
            inputInfo = Integer.parseInt(showInputDialog("Введите число:"));
        } catch (NumberFormatException e) {
            System.out.println("Введено текстовое или не целочисленное значение");
            System.exit(0);
        }

        if (inputInfo < 0){
            System.out.println("Отрицательные значения не принимаюся");
            System.exit(0);
        } else if (inputInfo == 0) {
            System.out.println("Нечего отображать");
            System.exit(0);
        }

        Set<String> list = generateParenthesis(inputInfo);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.size());
    }
}
