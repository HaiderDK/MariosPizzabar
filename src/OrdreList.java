import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.time.LocalDateTime;

    public class OrdreList {

        private ArrayList<Ordre> activeOrders;

        public OrdreList() {
            this.activeOrders = new ArrayList<>();
        }

        // Tilføjer en ordre og opdaterer listen efter automatisk
        public void addOrdre(Ordre ordre) {
            activeOrders.add(ordre);
            sortOrdrerByTime();
            System.out.println("Ny ordre tilføjet: " + ordre);
        }

        // Fjerner en ordre
            public void removeOrdre(int ordreId) {
                boolean removed = activeOrders.removeIf(ordre -> ordre.getOrdreId() == ordreId);
                if (removed) {
                    System.out.println("Ordre #" + ordreId + " er fjernet.");
                } else {
                    System.out.println("Ingen ordre med ID #" + ordreId + " fundet.");
                }
            }

        // ordre sorteres efter bestillingstid
        public void sortOrdrerByTime() {
            Collections.sort(activeOrders, Comparator.comparing(Ordre::getOrderTime));
        }

        // her vises alle de aktive order der er
        public void displayOrdrer() {
            System.out.println("\nAktive Ordrer:");
            for (Ordre ordre : activeOrders) {
                System.out.println(ordre);
            }
        }
    }



