import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


    public class OrdreList {
        Scanner scanner = new Scanner(System.in);
        private ArrayList<Ordre> activeOrders;
        private CompletedOrdre completedOrdre; // Reference til færdige ordrer

        public OrdreList() {
            this.activeOrders = new ArrayList<>();
            this.completedOrdre = new CompletedOrdre();
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
            for (Ordre ordre : activeOrders) {
                if (ordre.getOrderId() == ordreId) {
                    activeOrders.remove(ordre); // Fjern fra aktiv liste
                    completedOrdre.addCompletedOrdre(ordre); // Tilføj til færdige ordrer
                    return;
                }
            }
            System.out.println("Ordre #" + ordreId + " blev ikke fundet.");
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


        // Viser færdige ordrer
        public void displayCompletedOrders() {
            completedOrdre.displayCompletedOrders();
        }



        public void ReturnToMenu() {
            String returnToMenu = "";
            while (!returnToMenu.equalsIgnoreCase("ja") && !returnToMenu.equalsIgnoreCase("nej")) {
                System.out.print("Vil du tilbage til menuen? (Ja/Nej): ");
                returnToMenu = scanner.nextLine().trim();
                if (!returnToMenu.equalsIgnoreCase("ja") && !returnToMenu.equalsIgnoreCase("nej")) {
                    System.out.println("Ugyldigt svar! Skriv 'Ja' eller 'Nej'.");
                }
            }

            if (returnToMenu.equalsIgnoreCase("ja")) {
                // Kald menuen, afhængig af hvordan du har struktureret din menu.
                Menu menu = new Menu();
                menu.pizzaMenu(scanner);  // Går tilbage til menuen
            }
        }
    }


