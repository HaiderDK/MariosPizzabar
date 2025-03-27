import java.util.*;

public class Statistics {

    // Method thats show top 3 pizzas sold, total revenue and total pizza sold
    public static void displayStatistics(CompletedOrder completedOrder) {

        // Collects amount of pizza sold
        Map<Pizza, Integer> pizzaCounts = new HashMap<>();

        // loop that goes through the completed order list
        for (Order order : completedOrder.getCompletedOrders()) {
            //collects the total amount of pizzas sold
            for (Map.Entry<Pizza, Integer> entry : order.getPizzaOrdre().entrySet()) {
                Pizza pizza = entry.getKey(); // Gets pizza
                int quantity = entry.getValue(); // Gets amount
                pizzaCounts.put(pizza, pizzaCounts.getOrDefault(pizza, 0) + quantity);
            }
        }

        // Sort the list by amount descending order
        List<Map.Entry<Pizza, Integer>> sortedList = new ArrayList<>(pizzaCounts.entrySet());
        sortedList.sort((a, b) -> b.getValue() - a.getValue());

        // Top 3 most sold pizzas
        System.out.println("\n--- Top 3 Mest Solgte Pizzaer ---");
        for (int i = 0; i < 3 && i < sortedList.size(); i++) {
            Pizza pizza = sortedList.get(i).getKey();
            int amountSold = sortedList.get(i).getValue();
            System.out.println((i + 1) + ". " + pizza.getDescription() + " - Antal solgt: " + amountSold);
        }

        // Calc total pizzas sold and total revenue
        int totalPizzas = 0;
        double totalRevenue = 0.0;
        for (Map.Entry<Pizza, Integer> entry : pizzaCounts.entrySet()) {
            Pizza pizza = entry.getKey();
            int pizzaAmount = entry.getValue();
            totalPizzas += pizzaAmount;
            totalRevenue += (pizza.getPrice() * pizzaAmount);
        }

        System.out.println("\nSamlet antal solgte pizzaer: " + totalPizzas);
        System.out.println("Samlet omsætning: " + totalRevenue + " kr.");
    }
}