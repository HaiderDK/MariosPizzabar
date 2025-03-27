import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


    public class OrderList {
        private ArrayList<Order> activeOrders;
        private CompletedOrder completedOrder; // Reference til færdige ordrer

        public OrderList() {
            this.activeOrders = new ArrayList<>();
            this.completedOrder = new CompletedOrder();
        }

        public CompletedOrder getCompletedOrder() {
            return this.completedOrder;
        }

        // Tilføjer en ordre og opdaterer listen efter automatisk
        public void addOrder(Order order) {
            activeOrders.add(order);
            sortOrdersByTime();
            System.out.println("Ny ordre tilføjet: " + order);
        }


        // Flytter en færdig ordre til CompletedOrdre
        public void completeOrder(int ordreId) {
            Order found = null;
            for (Order order : activeOrders) {
                if (order.getOrderId() == ordreId) {
                    found = order;
                    break;
                }
            }
            if (found != null) {
                activeOrders.remove(found);
                completedOrder.addCompletedOrdre(found);
                System.out.println("Ordre #" + ordreId + " er afsluttet.");
            } else {
                System.out.println("Ordre #" + ordreId + " blev ikke fundet.");
            }
        }


        // Ordre sorteres efter bestillingstid
        public void sortOrdersByTime() {
            Collections.sort(activeOrders, Comparator.comparing(Order::getOrderTime));
        }



        // Viser alle aktive ordrer
        public void displayOrders() {
            System.out.println("\nAktive Ordrer:");
            if (activeOrders.isEmpty()) {
                System.out.println("Ingen aktive ordrer.");
            } else {
                for (Order order : activeOrders) {
                    System.out.println(order);
                }
            }
        }
    }