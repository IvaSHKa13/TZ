import java.io.IOException;
import java.util.Scanner;

public class TZ {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println(Main.calc(sc.nextLine()));
    }
}

class Main{
    public static String calc(String input) throws IOException {
            String str;
            String output;
            str = input;

            String [] mas = str.split(" ");
            String operation = mas[1];

            if (mas.length != 3){
                throw new ArrayIndexOutOfBoundsException();
            }

            int a = 0, b = 0, result;
            int cel, ost;
            String ost1 = "",cel1 = "";
            boolean a1 = true, b1 = true;

            try{
                a = Integer.parseInt(mas[0]);
                b = Integer.parseInt(mas[2]);
            }catch (NumberFormatException s ){
                for (Rimskie element : Rimskie.values()) {
                    if (element.name().equals(mas[0])) {
                        a = Rimskie.valueOf(mas[0]).getI();
                        a1 = false;
                    }
                }
                for (Rimskie element : Rimskie.values()) {
                    if (element.name().equals(mas[2])) {
                        b = Rimskie.valueOf(mas[2]).getI();
                        b1 = false;
                    }
                }
            }

            if(a1 != b1){
                throw new IOException();
            }

            if((a < 1 || a > 10) || (b < 1 || b > 10) ){
                throw new IOException();
            }

            switch (operation) {
                case "+" -> result = a + b;
                case "-" -> result = a - b;
                case "*" -> result = a * b;
                case "/" -> result = a / b;
                default -> throw new IOException();
            }

            ost = result%10;
            cel = result - (result%10);

            for (Rimskie element : Rimskie.values()) {
                if(Rimskie.valueOf(element.name()).getI() == cel){
                    cel1 = element.name();

                }
            }
            for (Rimskie element : Rimskie.values()) {
                if(Rimskie.valueOf(element.name()).getI() == ost){
                    ost1 = element.name();
                }
            }

            if(a1){
                output =  String.valueOf(result);
            }else if(result < 1) {
                throw new IOException();
            }else{
                output =  cel1 + ost1;
            }
            return output;
        }
    }


enum Rimskie {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10), XX(20), XXX(30), XL(40), L(50),
    LX(60), LXX(70), LXXX(80), XC(90), C(100);

    private final int i;


    Rimskie(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}

