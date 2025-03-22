import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pizza pizza = new Pizza();
        boolean ordering = true;

        // Vis menuen
        pizza.showMenu();


        Ordre.showMenu();
        while (ordering) {
            Pizza selectedPizza = null;


            // Bliv ved med at spørge, indtil brugeren vælger en gyldig pizza
            while (selectedPizza == null) {
                System.out.print("Vælg en pizza (1-30): ");

                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    selectedPizza = Ordre.getPizza(choice);

                    if (selectedPizza != null) {
                        System.out.println("Du har valgt: " + selectedPizza.getDescription());

                        System.out.print("Hvor mange vil du bestille? ");
                        int quantity = scanner.nextInt();

                        // Tilføj pizzaen til ordren
                        Ordre.addPizzaToOrder(selectedPizza, quantity);

                        // Spørg om brugeren vil bestille flere pizzaer
                        System.out.print("Vil du bestille flere pizzaer? (Ja/Nej): ");
                        String response = scanner.next();
                        if (response.equalsIgnoreCase("Nej")) {
                            ordering = false;  // Stop bestilling
                        }
                    } else {
                        System.out.println("Ugyldigt valg. Prøv igen.");
                    }
                }


            }
            Ordre.finalizeOrder();
            scanner.close();
        }
    }
}




