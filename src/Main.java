import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pizza pizza = new Pizza();
        OrdreList ordreList = new OrdreList();
        boolean ordering = true;
        ordreList.displayOrdrer();
        ordreList.removeOrdre();
        ordreList.addOrdre();

        //******** MANGLER AT TILFØJE KODEN TIL MENUEN **********
        Menu menu = new Menu(); //Create Menu object
        menu.pizzaMenu(scanner); //Calls the pizzaMenu method inside Menu class
        //scanner.close(); //idk finder ud af det...

        // Loop for at tillade flere bestillinger
        while (ordering) {
            // Opretter en ny ordre
            Ordre ordre = new Ordre(); // Ny ordre hver gang

            //Tag ordre
            Ordre.showMenu();
            Ordre.bestilling();

            Ordre.finalizeOrder();

            scanner.close();
        }
    }
}