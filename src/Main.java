import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pizza pizza = new Pizza();
        OrdreList ordreList = new OrdreList();
        boolean ordering = true;

        //******** MANGLER AT TILFØJE KODEN TIL MENUEN **********
        Menu menu = new Menu(); //Create Menu object
        menu.pizzaMenu(scanner); //Calls the pizzaMenu method inside Menu class
        //scanner.close(); //idk finder ud af det...

        // Loop for at tillade flere bestillinger
        while (ordering) {
            // Opretter en ny ordre
            Ordre ordre = new Ordre(); // Ny ordre hver gang

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
                        scanner.nextLine(); // Ryd buffer efter nextInt()
                        selectedPizza = Ordre.getPizza(choice);

                        if (selectedPizza == null) {  // Hvis choice ikke er en gyldig pizza
                            System.out.println("Ugyldigt valg. Prøv igen.");
                        }
                    } else {
                        System.out.println("Indtast venligst et tal.");
                        scanner.nextLine();  // Ryd buffer for ugyldigt input
                    }
                }

                // Når en gyldig pizza er valgt:
                System.out.println("Du har valgt: " + selectedPizza.getDescription());

                int quantity = 0;
                while (quantity <= 0) { // Sørg for, at brugeren vælger et positivt antal
                    System.out.print("Hvor mange vil du bestille? ");
                    if (scanner.hasNextInt()) {
                        quantity = scanner.nextInt();
                        scanner.nextLine(); // Ryd buffer
                        if (quantity <= 0) {
                            System.out.println("Antallet skal være større end 0. Prøv igen.");
                        }
                    } else {
                        System.out.println("Ugyldigt antal. Indtast et heltal.");
                        scanner.nextLine(); // Ryd buffer
                    }
                }

                // Tilføj pizza til ordren
                Ordre.addPizzaToOrder(selectedPizza, quantity);

                // Spørg om brugeren vil bestille flere
                String response = "";
                while (!response.equalsIgnoreCase("ja") && !response.equalsIgnoreCase("nej")) {
                    System.out.print("Vil du bestille flere pizzaer? (Ja/Nej): ");
                    response = scanner.nextLine().trim();
                    if (!response.equalsIgnoreCase("ja") && !response.equalsIgnoreCase("nej")) {
                        System.out.println("Ugyldigt svar! Skriv 'Ja' eller 'Nej'.");
                    }
                }

                if (response.equalsIgnoreCase("nej")) {
                    ordering = false;  // Stop bestilling
                }
            }

            Ordre.finalizeOrder();

            scanner.close();
        }
    }
}




