import java.util.Scanner;

public class PizzaSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderList orderList = new OrderList();
        Menu menu = new Menu(orderList);
        menu.pizzaMenu(scanner);
    }
}