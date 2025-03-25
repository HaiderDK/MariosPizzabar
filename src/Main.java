import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pizza pizza = new Pizza();

        OrdreList ordreList = new OrdreList();
        // Opret en instans af Ordre
        Ordre ordre = new Ordre();



        //******** MANGLER AT TILFØJE KODEN TIL MENUEN **********
        Menu menu = new Menu(); //Create Menu object
        menu.pizzaMenu(scanner); //Calls the pizzaMenu method inside Menu class
        //scanner.close(); //idk finder ud af det...





            //Tag ordre
            Ordre.showMenu();
            Ordre nyOrdre = Ordre.bestilling();
            Ordre.bestilling();

            //Afslutte ordre
            ordre.finalizeOrder();

            //Administrer ordrer
            ordreList.displayOrdrer();
            ordreList.addOrdre(ordre);
            ordreList.removeOrdre(nyOrdre.getOrderId());


            scanner.close();
        }
    }
