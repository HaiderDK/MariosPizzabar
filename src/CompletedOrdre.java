import java.util.ArrayList;
import java.util.Scanner;

    public class CompletedOrdre {
        private ArrayList<Ordre> completedOrders;

        public CompletedOrdre() {
            this.completedOrders = new ArrayList<>();
        }

        // Add completed order to the list
        public void addCompletedOrdre(Ordre ordre) {
            completedOrders.add(ordre);
        }

        // Display completed orders
        public void displayCompletedOrders() {
            System.out.println("\nFærdige Ordrer:");
            for (Ordre ordre : completedOrders) {
                System.out.println(ordre);
            }
        }
    }





