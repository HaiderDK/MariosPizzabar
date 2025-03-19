public class Pizza {
        private String description;

        // Konstruktor til at initialisere beskrivelsen
        public Pizza(String description) {
            this.description = description;
        }

        // Getter for beskrivelsen
        public String getDescription() {
            return description;
        }

        // toString-metoden til at returnere pizzaens beskrivelse
        @Override
        public String toString() {
            return description;
        }
}
