import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите пять карт(пример: 2s, qd и т.д.) через enter: ");
        String[] cards = {
                in.nextLine(),
                in.nextLine(),
                in.nextLine(),
                in.nextLine(),
                in.nextLine()};

        System.out.println(Checker.checkHand(cards));
    }
}
