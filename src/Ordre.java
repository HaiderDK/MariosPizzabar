import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

    public class Ordre {
        static Random random;
        private static Map<Pizza, Integer> pizzaOrdre;  // Holder styr på pizzaer og deres antal


        // Konstruktør
        public Ordre() {
            pizzaOrdre = new HashMap<>();  // Initialiser pizzaOrdre som en HashMap
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

            public static void finalizeOrder() {

                // Generer et tilfældigt ordre-ID (5-cifret nummer)

                int orderId = 10000 + random.nextInt(90000);

                // Registrer den aktuelle tid
                LocalDateTime orderTime = LocalDateTime.now();

                // Beregn færdiggørelsestid (15 min senere)
                LocalDateTime readyTime = orderTime.plusMinutes(15);

                // Formatér tidspunkt
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

                System.out.println("\n Ordrebekræftelse 🍕 ");
                System.out.println("Ordre ID: " + orderId);
                System.out.println("Bestillingstidspunkt: " + orderTime.format(formatter));
                System.out.println("Forventet færdig: " + readyTime.format(formatter));
                System.out.println("Indhold:");
                for (Map.Entry<Pizza, Integer> entry : pizzaOrdre.entrySet()) {
                    System.out.println("- " + entry.getKey().getDescription() + " x" + entry.getValue());
                }
                System.out.println("Tak for din bestilling! 🍕");
            }
        public static void addPizzaToOrder(Pizza pizza, int quantity) {
            pizzaOrdre.put(pizza, pizzaOrdre.getOrDefault(pizza, 0) + quantity);
        }

    }

