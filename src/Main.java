import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        // Vis menuen
        menu.showMenu();

        // Spørg brugeren om at vælge en pizza
        System.out.print("Vælg en pizza (1-30): ");
        int choice = scanner.nextInt();

        // Hent den valgte pizza
        Pizza selectedPizza = menu.selectPizza(choice);
        if (selectedPizza != null) {
            System.out.println("Du har valgt: " + selectedPizza.getDescription());
        }

        scanner.close();
    }
}