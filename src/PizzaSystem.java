import java.util.Scanner;

public class PizzaSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrdreList ordreList = new OrdreList();

        // Opret en instans af Menu og vis pizza-menuen
        Menu menu = new Menu(ordreList);
        menu.pizzaMenu(scanner);


    }
}