import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

    public class Ordre {
        static Random random = new Random();
        static Scanner scanner = new Scanner(System.in);
        private static Map<Pizza, Integer> pizzaOrdre = new HashMap<>();// Holder styr på pizzaer og deres antal
        private LocalDateTime orderTime;
        static boolean ordering = true;

        // Konstruktør
        public Ordre() {
            pizzaOrdre = new HashMap<>();  // Initialiser pizzaOrdre som en HashMap
            this.orderTime = LocalDateTime.now();
        }

        public LocalDateTime getOrderTime(){
            return orderTime;
        }

        public static void showMenu() {
            System.out.println("🍕 Pizzaria Menu 🍕");
            for (int i = 0; i < Pizza.pizzas.length; i++) {
                System.out.println((i + 1) + ". " + Pizza.pizzas[i]);
            }
        }

        public static Pizza getPizza(int choice) {
            if (choice >= 1 && choice <= Pizza.pizzas.length) {
                return Pizza.pizzas[choice - 1]; // Returnerer den valgte pizza (brugeren vælger fra 1, men array starter ved 0)
            } else {
                return null;
            }
        }

        //Her får vi kundens navn og nummer hvis vi
        // har behov for for at kunne få kontakt til dem
        public static String CustomersInfo(){

            System.out.println("Navn: ");
            String name = scanner.nextLine();


            System.out.println("Telefon nummer:");
            String number = scanner.nextLine();
            scanner.nextLine();

            return "\nName: " + name + "\nTelefon nummer: +45" + number;


        }

            public static void finalizeOrder() {

                // Generer et tilfældigt ordre-ID (5-cifret nummer)

                int orderId = 10000 + random.nextInt(90000);

                //
                String customerInfomation = CustomersInfo();

                // Registrer den aktuelle tid
                LocalDateTime orderTime = LocalDateTime.now();

                // Beregn færdiggørelsestid (15 min senere)
                LocalDateTime readyTime = orderTime.plusMinutes(15);

                // Formatér tidspunkt
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");


                System.out.println("\n Ordrebekræftelse 🍕 ");
                System.out.println("Ordre ID: " + orderId);
                System.out.println("kundeoplysninger: " + customerInfomation);
                System.out.println("Bestillingstidspunkt: " + orderTime.format(formatter));
                System.out.println("Forventet færdig: " + readyTime.format(formatter));
                System.out.println("Bestilling:");
                for (Map.Entry<Pizza, Integer> entry : pizzaOrdre.entrySet()) {
                    System.out.println("- " + entry.getKey().getDescription() + " x" + entry.getValue());
                }


                System.out.println("Tak for din bestilling! 🍕");
            }
        public static void addPizzaToOrder(Pizza pizza, int quantity) {
            pizzaOrdre.put(pizza, pizzaOrdre.getOrDefault(pizza, 0) + quantity);
        }

        public static void bestilling(){

            Ordre ordre = new Ordre(); // Ny ordre hver gang

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
        }

    }


