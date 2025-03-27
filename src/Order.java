import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Order {
    private static final Random random = new Random();
    private  Map<Pizza, Integer> pizzaOrdre; // Holder styr på pizzaer og deres antal
    private LocalDateTime orderTime;
    private final int ordreId;  // Instansvariabel for ordreId
    static OrderList orderList = new OrderList();

    // Konstruktør
    public Order() {
        this.ordreId = 1000 + random.nextInt(90000);  // Tildeler et unikt ordreID
        pizzaOrdre = new HashMap<>();  // Initialiser pizzaOrdre som en HashMap
        this.orderTime = LocalDateTime.now();  // Tildeler bestillingstidspunktet
    }

    // getOrderId() skal ikke være statisk, da det refererer til instansvariablen ordreId
    public int getOrderId() {
        return this.ordreId;  // Returner instansvariablen ordreId
    }

    public LocalDateTime getOrderTime() {
        return orderTime;  // Returner bestillingstidspunktet
    }



    // Metode til at få pizza baseret på valg
    public static Pizza getPizza(int choice) {
        if (choice >= 1 && choice <= Pizza.pizzas.length) {
            return Pizza.pizzas[choice - 1]; // Returnerer den valgte pizza (brugeren vælger fra 1, men array starter ved 0)
        } else {
            return null;
        }
    }




    // Metode til at tilføje pizza til ordren
    public void addPizzaToOrder(Pizza pizza, int quantity) {
        pizzaOrdre.put(pizza, pizzaOrdre.getOrDefault(pizza, 0) + quantity);
    }



    // Metode til at hente kundens info
    public static String CustomersInfo(Scanner scanner) {
        System.out.println("Navn: ");
        String name = scanner.nextLine();

        System.out.println("Telefon nummer:");
        String number = scanner.nextLine();

        return "\nName: " + name + "\nTelefon nummer: +45" + number;
    }




    // Afslut ordre og print ordrebekræftelse
    public void finalizeOrder(OrderList orderList, Scanner scanner) {

        // Registrer tid og forventet færdig tid
        LocalDateTime orderTime = LocalDateTime.now();
        LocalDateTime readyTime = orderTime.plusMinutes(15);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("\nOrdrebekræftelse 🍕");
        System.out.println("Ordre ID: " + ordreId);
        System.out.println("Kundeoplysninger: " + CustomersInfo(scanner));
        System.out.println("Bestillingstidspunkt: " + orderTime.format(formatter));
        System.out.println("Forventet færdig: " + readyTime.format(formatter));
        System.out.println("Bestilling:");

        // Udskriv ordren
        for (Map.Entry<Pizza, Integer> entry : pizzaOrdre.entrySet()) {
            System.out.println("- " + entry.getKey().getDescription() + " x" + entry.getValue());
        }

        System.out.println("Tak for din bestilling! 🍕");

        // Tilføj ordren til OrdreList
        orderList.addOrder(this);  // Kald addOrdre med den aktuelle ordre (this)

        }


        @Override
        public String toString() {
            return "Ordre #" + ordreId + " - Bestilt: " + orderTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        }




        // Bestilling af pizza
        public static Order createOrder(Scanner scanner) {
            Order order = new Order();
            boolean ordering = true;

            while (ordering) {
                Pizza selectedPizza = null;

                // Bliv ved med at spørge, indtil brugeren vælger en gyldig pizza
                while (selectedPizza == null) {
                    System.out.print("Vælg en pizza (1-30): ");

                    if (scanner.hasNextInt()) {
                        int choice = scanner.nextInt();
                        scanner.nextLine(); // Ryd buffer efter nextInt()
                        selectedPizza = Order.getPizza(choice);

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
                    } else {
                        System.out.println("Indtast venligst et gyldigt antal."); // Fejlmeddelelse for ikke-tal input
                        scanner.nextLine(); // Ryd buffer for ugyldigt input
                    }
                }

                // Tilføj pizza til ordren
                order.addPizzaToOrder(selectedPizza, quantity);

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
            order.finalizeOrder(orderList, scanner);

            return order; // Kalder finalizeOrder på den aktuelle ordre
        }

    }