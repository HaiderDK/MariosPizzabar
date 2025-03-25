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
                        if (scanner.hasNextInt()) {
                            int quantity = scanner.nextInt();
                            scanner.nextLine();


                            // Tilføj pizzaen til ordren
                            Ordre.addPizzaToOrder(selectedPizza, quantity);

                            // Spørg om brugeren vil bestille flere pizzaer
                            System.out.print("Vil du bestille flere pizzaer? (Ja/Nej): ");
                            String response = scanner.nextLine();  // Brug nextLine() til at læse hele svaret

                            if (response.equalsIgnoreCase("Nej")) {
                                ordering = false;  // Stop bestilling
                            }
                        } else {
                            System.out.println("Ugyldigt antal. Prøv igen.");
                            scanner.nextLine();  // Ryd buffer, hvis input ikke er et tal
                        }
                    } else {
                        System.out.println("Ugyldigt valg. Prøv igen.");
                    }
                } else {
                    System.out.println("Indtast venligst et tal.");
                    scanner.nextLine();  // Ryd buffer for ugyldigt input
                }
            }
        }

        Ordre.finalizeOrder();
        scanner.close();

        //  at oprette en liste til ny ordre
        OrdreList ordreList = new OrdreList();

        // her bliver ordre oprettet
        OrdreList.Ordre ordre1 = new OrdreList.Ordre(101, "egon olsen");
        OrdreList.Ordre ordre2 = new OrdreList.Ordre(102, "mo basel");

        //her bliver ordre tilføjet til listen
        ordreList.addOrdre(ordre1);
        ordreList.addOrdre(ordre2);

        // Viser ordrerne (Skal ikke være rød længere!)
        ordreList.displayOrdrer();
    }
}




