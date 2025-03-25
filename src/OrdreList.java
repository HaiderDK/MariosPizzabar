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
        activeOrders.removeIf(ordre -> ordre.getOrdreId() == ordreId);
        System.out.println("Ordre #" + ordreId + " er fjernet.");
    }

    // ordre sorteres efter bestillingstid
    public void sortOrdrerByTime() {
        Collections.sort(activeOrders, Comparator.comparing(Ordre::getOrdreTime));
    }

    // her vises alle de aktive order der er
    public void displayOrdrer() {
        System.out.println("\nAktive Ordrer:");
        for (Ordre ordre : activeOrders) {
            System.out.println(ordre);
        }
    }











    public static class Ordre {
        private int ordreId;
        private String customerName;
        private LocalDateTime ordreTime;

        public Ordre(int ordreId, String customerName) {
            this.ordreId = ordreId;
            this.customerName = customerName;
            this.ordreTime = LocalDateTime.now(); // Gemmer bestillingstidspunktet automatisk
        }

        public int getOrdreId() {
            return ordreId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public LocalDateTime getOrdreTime() {
            return ordreTime;
        }

        @Override
        public String toString() {
            return "Ordre #" + ordreId + " - " + customerName + " - " + ordreTime;
        }
    }
}
