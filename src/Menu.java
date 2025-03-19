public class Menu {
    private Pizza[] pizzas;

    public Menu(){
        this.pizzas = new Pizza[]{
             new Pizza(" Vesuvio: tomatsauce, ost, skinke og oregano"),
                new Pizza(" Amerkaner: tomatsauce, ost, oksefars og oregano"),
                new Pizza(" Cacciatore: tomatsauce, ost, pepperoni og oregano"),
                new Pizza(" Carbona: tomatsauce, ost, kødsauce og oregano"),
                new Pizza(" Dennis: tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano"),
                new Pizza(" Bertil: tomatsauce, ost, bacon og oregano"),
                new Pizza(" Silvia: tomatsauce, ost pepperoni, rød peber, løg, oliven og oregano"),
                new Pizza(" Victoria: tomatsauce, ost skinke, ananas, champignon, løg og oregano"),
                new Pizza(" Toronofo: tomatsauce, ost, skinke, champignon, løg og oregano"),
                new Pizza(" Capricciosa: tomatsauce, ost, skinke, champignon og oregano"),
                new Pizza(" Hawai: tomatsauce ost, skinke, ananas og oregano"),
                new Pizza(" Le Blissola: tomatsauce, ost, skinke, rejer og oregano"),
                new Pizza(" Venezia: tomatsauce, ost skinke, bacon og oregano"),
                new Pizza(" Mafia: tomatsauce, ost, pepperoni, bacon, løg og oregano"),
                new Pizza(" John: tomatsauce, ost, skinke og oregano"),
                new Pizza(" Martin: tomatsauce, ost, oksefars og oregano"),
                new Pizza(" Cay: tomatsauce, ost, pepperoni og oregano"),
                new Pizza(" Dorte: tomatsauce, ost, kødsauce og oregano"),
                new Pizza(" Lone: tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano"),
                new Pizza(" Paris: tomatsauce, ost, bacon og oregano"),
                new Pizza(" Italia: tomatsauce, ost pepperoni, rød peber, løg, oliven og oregano"),
                new Pizza(" Jacob: tomatsauce, ost skinke, ananas, champignon, løg og oregano"),
                new Pizza(" Tommy: tomatsauce, ost, skinke, champignon, løg og oregano"),
                new Pizza(" Lone: tomatsauce, ost, skinke, champignon og oregano"),
                new Pizza(" Susanne: tomatsauce ost, skinke, ananas og oregano"),
                new Pizza(" Le mama: tomatsauce, ost, skinke, rejer og oregano"),
                new Pizza(" La dada: tomatsauce, ost skinke, bacon og oregano"),
                new Pizza(" Padre: tomatsauce, ost, pepperoni, bacon, løg og oregano"),
                new Pizza(" Hanne: tomatsauce, ost, skinke, champignon, løg og oregano"),
                new Pizza(" Lanne: tomatsauce, ost, skinke, champignon og oregano"),
        };
    }

    public void showMenu(){
        System.out.println("🍕 Pizzaria Menu 🍕");
        for(int i = 0; i < pizzas.length; i++){
            System.out.println((i + 1) + ". " + pizzas[i]);
        }
    }
    public Pizza selectPizza(int choice) {
        if (choice >= 1 && choice <= pizzas.length) {
            return pizzas[choice - 1];
        } else {
            System.out.println("Ugyldigt valg. Prøv igen.");
            return null;
        }
    }

}
