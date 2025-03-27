import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


    public class OrdreList {
        private ArrayList<Ordre> activeOrders;
        private CompletedOrdre completedOrdre; // Reference til færdige ordrer

        public OrdreList() {
            this.activeOrders = new ArrayList<>();
            this.completedOrdre = new CompletedOrdre();
        }

        public CompletedOrdre getCompletedOrdre() {
            return this.completedOrdre;
        }

        // Tilføjer en ordre og opdaterer listen efter automatisk
        public void addOrdre(Ordre ordre) {
            activeOrders.add(ordre);
            sortOrdrerByTime();
            System.out.println("Ny ordre tilføjet: " + ordre);
        }

        // Fjerner en ordre
        public void removeOrdre(int ordreId) {
            boolean removed = activeOrders.removeIf(ordre -> ordre.getOrderId() == ordreId);
            if (removed) {
                System.out.println("Ordre #" + ordreId + " er fjernet.");
            } else {
                System.out.println("Ordre #" + ordreId + " blev ikke fundet.");
            }
        }


        // Flytter en færdig ordre til CompletedOrdre
        public void completeOrdre(int ordreId) {
            Ordre found = null;
            for (Ordre ordre : activeOrders) {
                if (ordre.getOrderId() == ordreId) {
                    found = ordre;
                    break;  // Break out of the loop so we can remove safely
                }
            }
            if (found != null) {
                activeOrders.remove(found);
                completedOrdre.addCompletedOrdre(found);
                System.out.println("Ordre #" + ordreId + " er afsluttet.");
            } else {
                System.out.println("Ordre #" + ordreId + " blev ikke fundet.");
            }
        }


        // ordre sorteres efter bestillingstid
        public void sortOrdrerByTime() {
            Collections.sort(activeOrders, Comparator.comparing(Ordre::getOrderTime));
        }



        // Viser alle aktive ordrer
        public void displayOrdrer() {
            System.out.println("\nAktive Ordrer:");
            if (activeOrders.isEmpty()) {
                System.out.println("Ingen aktive ordrer.");
            } else {
                for (Ordre ordre : activeOrders) {
                    System.out.println(ordre);
                }
            }
        }

        // Viser færdige ordrer
        public void displayCompletedOrders() {
            completedOrdre.displayCompletedOrders();
        }
    }