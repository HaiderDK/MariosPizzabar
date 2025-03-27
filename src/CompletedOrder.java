import java.util.ArrayList;

    public class CompletedOrder {
        private ArrayList<Order> completedOrders;

        public CompletedOrder() {
            this.completedOrders = new ArrayList<>();
        }

        // Add completed order to the list
        public void addCompletedOrdre(Order order) {
            completedOrders.add(order);
        }

        // Display completed orders
        public void displayCompletedOrders() {
            System.out.println("\nAfsluttede Ordrer:");
            if (completedOrders.isEmpty()) {
                System.out.println("Ingen Afsluttede ordrer.");
            } else {
                for (Order order : completedOrders) {
                    System.out.println(order);
                }
            }
        }
    }