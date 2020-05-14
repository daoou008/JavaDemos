package calculator;

import annotation.Check;

import java.util.Scanner;

public class SimpleCalculator {
    @Check
    public int add(int a, int b){
        return a+b;
    }

    @Check
    public int subtract(int a, int b){
        return a-b;
    }

    @Check
    public int multiply(int a, int b){
        return a*b;
    }

    @Check
    public int divide(int a, int b){
        return a/b;
    }

    public void calculate(){
        //提示输入第一个数字
        System.out.println("请输入第一个数字");
        Scanner input = new Scanner(System.in);
        double a = Double.parseDouble(input.nextLine());

        //从符号开始，包括后面的第二个数字，系统会进入一个循环，一直提示用户输入符号了后面的数，用于计算结果
        //直到用户终止
        //符号包括[+ - * / =], =号用于终止计算
        while (true){
            //输入运算符
            System.out.println("请输入符号");
            String symbol = input.nextLine();
            if (symbol.equals("=")){
                System.out.println("程序结束，感谢您的使用");
                break;
            }
            //如果运算符不是+ - * /，提示输入正确运算符，并重新开始循环
            if (!(symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/"))){
                System.out.println("输入的符号有误，您只能输入[+ - * / =]其中的符号，注意，=表示结束程序c ");
                continue;
            }
            //输入第二个数字（用于计算的后面那个数字)
            System.out.println("请输入第二个数字");
            double b = Double.parseDouble(input.nextLine());
            /*switch (symbol){
                case "+":
                    a = this.add(a, b);
                    break;
                case "-":
                    a = this.subtract(a, b);
                    break;
                case "*":
                    a = this.multiply(a, b);
                    break;
                case "/":
                    a = this.divide(a, b);
                    break;
            }*/
            System.out.println("结果是" + a);
        }
    }
}
