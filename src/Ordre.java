/*import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

    public class Ordre {

        private Map<Pizza, Integer> pizzaOrdre;  // Holder styr på pizzaer og deres antal

        // Konstruktør
        public Ordre() {
            pizzaOrdre = new HashMap<>();  // Initialiser pizzaOrdre som en HashMap
        }

    public void showMenu(){
        System.out.println("🍕 Pizzaria Menu 🍕");
        for(int i = 0; i < pizzas.length; i++){
            System.out.println((i + 1) + ". " + pizzas[i]);
        }
    }
    public Pizza selectPizza(int choice) {
        if (choice >= 1 && choice <= pizzas.length) {
            return pizzas[choice - 1];
        } else {
            System.out.println("Ugyldigt valg. Prøv igen.");

        }
        return null;
    }


    // Konstruktor her tager ikke nogle argumenter, men istedet læser den vores inpput
    // på scanneren og printer det ud
    public Pizza(){}

    // Getter for beskrivelsen
    public String getDescription() {
        return description + " (" + price + " kr.)";

    }

    // toString-metoden til at returnere pizzaens beskrivelse
    @Override
    public String toString() {
        return description;
    }
}
*/