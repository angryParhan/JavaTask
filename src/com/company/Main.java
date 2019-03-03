package com.company;
import java.util.Scanner;
import static java.lang.Math.abs;

public class Main {

    private void Roman(String operator1, char operation, String operator2) {
        int result;
        int num1 = 0;
        int num2 = 0;
        String[] romanArr = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        switch (operator1){
            case "I"    : num1 = 1;     break;
            case "II"   : num1 = 2;     break;
            case "III"  : num1 = 3;     break;
            case "IV"   : num1 = 4;     break;
            case "V"    : num1 = 5;     break;
            case "VI"   : num1 = 6;     break;
            case "VII"  : num1 = 7;     break;
            case "VIII" : num1 = 8;     break;
            case "IX"   : num1 = 9;     break;
            case "X"    : num1 = 10;    break;
        }

        switch(operator2){
            case "I"    : num2 = 1;     break;
            case "II"   : num2 = 2;     break;
            case "III"  : num2 = 3;     break;
            case "IV"   : num2 = 4;     break;
            case "V"    : num2 = 5;     break;
            case "VI"   : num2 = 6;     break;
            case "VII"  : num2 = 7;     break;
            case "VIII" : num2 = 8;     break;
            case "IX"   : num2 = 9;     break;
            case "X"    : num2 = 10;    break;
        }
        switch(operation){
            case '+'    : result = num1 + num2; System.out.println(romanArr[result - 1]); break;
            case '-'    : result = num1 - num2; System.out.println(romanArr[abs(result) - 1]); break;
            case '*'    : result = num1 * num2; System.out.println(romanArr[abs(result) - 1]); break;
            case '/'    : result = num1 / num2; System.out.println(romanArr[result - 1]); break;
        }
    }

    private void Arabic(int a, char operation, int b){
        double result;
        switch(operation){
            case '+'    : result = a + b; System.out.println(result); break;
            case '-'    : result = a - b; System.out.println(result); break;
            case '*'    : result = a * b; System.out.println(result); break;
        }
        if(operation == '/'){
            if(b == 0){
                System.out.print("You can't devide by 0!!!");
            }else{
                result = (double)a / b;
                System.out.println(result);
            }
        }

    }

    public static void main(String[] args) {
        int way;

        Scanner scan = new Scanner(System.in);
        Main calculating = new Main();
        int ind = 1;
        while (ind == 1) {
            System.out.println("Here we Go! Choose a system of number Romen - 1, Arabic - 2");
            do {
                way = scan.nextInt();
            } while (way != 1 && way != 2);
            scan.nextLine();
            if (way == 1) {
                boolean check1 = true;
                boolean check2 = true;
                String proc;
                String x = "";
                String y = "";
                int i;
                char operation = ' ';
                System.out.println("You can start remember inerval (I - X) ");
                proc = scan.nextLine();
                proc = proc.toUpperCase();
                proc = proc.replaceAll("\\s+","");
                char[] romanCalc = proc.toCharArray();

                for(i = 0; i < romanCalc.length && check1; i++){
                    if(Character.isLetter(romanCalc[i])){
                        x += romanCalc[i];
                    } else {
                        check1 = false;
                        operation = romanCalc[i];
                        if(!Character.isLetter(romanCalc[i + 1])){
                            check2 = false;
                        }
                    }
                }

                if(!check2 || operation ==' '){
                    System.out.println("Incorrect!");
                } else {
                    for(int j = i; j < romanCalc.length && Character.isLetter(romanCalc[j]); j++){
                        y += romanCalc[j];
                    }
                    calculating.Roman(x, operation, y);
                }
            } else {
                String calcVar;
                String temple1 = "";
                String temple2 = "";
                char operationArabic = ' ';
                int num1;
                int num2;
                boolean buf = true;
                boolean check = true;
                int i;
                System.out.println("You can start");
                calcVar = scan.nextLine();
                calcVar = calcVar.replaceAll("\\s+","");
                char[] calcArr = calcVar.toCharArray();

                for(i = 0; i < calcArr.length && check; i++){
                    if(Character.isDigit(calcArr[i])){
                        temple1 += calcArr[i];
                    } else {
                        check = false;
                        operationArabic = calcArr[i];
                        if(!Character.isDigit(calcArr[i + 1])){
                            buf = false;
                        }
                    }
                }

                if(!buf || operationArabic == ' ') {
                    System.out.println("Incorrect!");
                } else {
                    for(int j = i; j < calcArr.length && Character.isDigit(calcArr[j]); j++){
                        temple2 += calcArr[j];
                    }
                    num1 = Integer.parseInt(temple1);
                    num2 = Integer.parseInt(temple2);
                    calculating.Arabic(num1, operationArabic, num2);
                }

            }
            System.out.println("Do you want to continue? 1 - yes 2 - no");
            ind = scan.nextInt();
        }
    }
}