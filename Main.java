/**
 * author:gholamreza maleki
 * biagram messenger
 * 4/20.2024
 */


import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        control(scanner);
    }

    //this methode control the code
    public static void control(Scanner scanner) {
        boolean end = false;
        boolean exit = false;
        Biagram biagram = new Biagram();
        cls();
        System.out.println("\u001B[38;2;255;255;0m Wellcome to biagram\u001B[0m");
        while (end == false) {
            while (exit == false) {
                biagram.shapeOfEntering();
                char enetering = scanner.next().charAt(0);
                if (enetering > '3' || enetering < '1') {
                    cls();
                    continue;
                }
                cls();
                exit = biagram.manageEntering(enetering, scanner);

            }
            biagram.shapeOfMainPage();
            char mainpage = scanner.next().charAt(0);
            if (mainpage < '1' || mainpage > '3') {
                cls();
                continue;
            }
            cls();
            exit = biagram.mainManage(mainpage, scanner);

        }
    }

    //this methode cls the screen
    public static void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }

            // Now your console is cleared
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}