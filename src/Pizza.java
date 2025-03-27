public class Pizza {
        private int price;
        private String description;

        public static final Pizza[] pizzas = {
                new Pizza(" Deniz: tomatsauce, ost, Kylling og løg", 65),
                new Pizza(" Haider: tomatsauce, ost, Shawarma og løg", 65),
                new Pizza(" Zak: tomatsauce, ost, kebab og løg", 85),
                new Pizza(" Erkam: tomatsauce, ost, kødsauce og bearnaisesovs", 95),
                new Pizza(" Mo: tomatsauce, ost, kødstrimler, løg, champignon og oliven",65),
                new Pizza(" Bertil: tomatsauce, ost, bacon og oregano", 75),
                new Pizza(" Silvia: tomatsauce, ost pepperoni, rød peber, løg, oliven og oregano", 85),
                new Pizza(" Victoria: tomatsauce, ost skinke, ananas, champignon, løg og oregano", 85),
                new Pizza(" Toronofo: tomatsauce, ost, skinke, champignon, løg og oregano", 75),
                new Pizza(" Capricciosa: tomatsauce, ost, skinke, champignon og oregano", 65),
                new Pizza(" Hawai: tomatsauce ost, skinke, ananas og oregano", 100),
                new Pizza(" Le Blissola: tomatsauce, ost, skinke, rejer og oregano", 90),
                new Pizza(" Venezia: tomatsauce, ost skinke, bacon og oregano", 85),
                new Pizza(" Mafia: tomatsauce, ost, pepperoni, bacon, løg og oregano", 65),
                new Pizza(" John: tomatsauce, ost, skinke og oregano", 85),
                new Pizza(" Martin: tomatsauce, ost, oksefars og oregano", 90),
                new Pizza(" Cay: tomatsauce, ost, pepperoni og oregano", 85),
                new Pizza(" Dorte: tomatsauce, ost, kødsauce og oregano", 80),
                new Pizza(" Lone: tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano", 85),
                new Pizza(" Paris: tomatsauce, ost, bacon og oregano", 60),
                new Pizza(" Italia: tomatsauce, ost pepperoni, rød peber, løg, oliven og oregano", 90),
                new Pizza(" Jacob: tomatsauce, ost skinke, ananas, champignon, løg og oregano", 65),
                new Pizza(" Tommy: tomatsauce, ost, skinke, champignon, løg og oregano", 60),
                new Pizza(" Lone: tomatsauce, ost, skinke, champignon og oregano", 75),
                new Pizza(" Susanne: tomatsauce ost, skinke, ananas og oregano", 70),
                new Pizza(" Le mama: tomatsauce, ost, skinke, rejer og oregano", 80),
                new Pizza(" La dada: tomatsauce, ost skinke, bacon og oregano", 85),
                new Pizza(" Padre: tomatsauce, ost, pepperoni, bacon, løg og oregano", 75),
                new Pizza(" Hanne: tomatsauce, ost, skinke, champignon, løg og oregano", 70),
                new Pizza(" Lanne: tomatsauce, ost, skinke, champignon og oregano", 65),
        };

        public Pizza(String description, int price) {
            this.description = description;
            this.price = price;
    }

        // Shows the pizzaMenu
        public void showPizzaMenu(){
        System.out.println(" ");
        for(int i = 0; i < pizzas.length; i++){
            System.out.println((i + 1) + ". " + pizzas[i]);
        }
    }

        // Konstruktor uden argumenter. Læser inpput og printer det ud
        public Pizza(){}

        // Getter for beskrivelsen
        public String getDescription() {
            return description + " (" + price + " kr.)";
        }

        public int getPrice() {
            return price;
    }

        // toString-metoden til at returnere pizzaens beskrivelse
        @Override
        public String toString() {
            return description;
        }

}
