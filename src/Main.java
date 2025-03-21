import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pizza pizza = new Pizza();

        // Vis menuen
        pizza.showMenu();

        Pizza selectedPizza = null;

        // Bliv ved med at spørge, indtil brugeren vælger en gyldig pizza
        while (selectedPizza == null) {
            System.out.print("Vælg en pizza (1-30): ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                selectedPizza = pizza.selectPizza(choice);

                if (selectedPizza != null) {
                    System.out.println("Du har valgt: " + selectedPizza.getDescription());
                } else {
                    System.out.println("");
                }
            }
        }

        scanner.close();
    }
}