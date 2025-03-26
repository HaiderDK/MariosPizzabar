import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CompletedOrdre completedOrdre = new CompletedOrdre();
        OrdreList ordreList = new OrdreList();

        // Opret en instans af Menu og vis pizza-menuen
        Menu menu = new Menu();
        menu.pizzaMenu(scanner);

        // Tag ordre
        Ordre nyOrdre = Ordre.bestilling();
        ordreList.addOrdre(nyOrdre);  // Tilføjer ordren til aktiv liste

        // Administrer ordrer
        ordreList.displayOrdrer();  // Viser alle aktive ordrer

        // Afslut ordre (flytter den fra aktiv til færdig liste)
        ordreList.removeOrdre(nyOrdre.getOrderId());
        completedOrdre.handleUserInteraction();  // Håndterer færdige ordrer

        // Tilbage til menuen
        ordreList.ReturnToMenu();

                scanner.close();
            }
    }
