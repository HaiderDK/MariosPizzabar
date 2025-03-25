import java.util.Scanner;

public class Menu {

    Pizza pizza = new Pizza();

    public void pizzaMenu (Scanner scanner) {

        //Loop until return is called (Afslut/Exit)
        while (true) {
            System.out.println("\n━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("🍕 Mario’s Pizzabar 🍕");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("1. 📜 Se menukortet");
            System.out.println("2. 🆕 Opret ny ordre");
            System.out.println("3. ❌ Afslut aktiv ordre");
            System.out.println("4. 📦 Aktive bestillinger");
            System.out.println("5. ✅ Afsluttede bestillinger");
            System.out.println("6. 📊 Generer rapport/statistik");
            System.out.println("7. 🔴 Afslut program");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━");
            System.out.print("🎯 Vælg mulighed: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine()); //Reads input as String and parse (change) to int

                switch (choice) {
                    case 1:
                        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━");
                        System.out.println("📜 MENUKORT");
                        System.out.println("━━━━━━━━━━━━━━━━━━━━━");
                        pizza.showMenu();
                        break;
                    case 2:
                        System.out.println("\n✅ Opretter en ny ordre...");
                        break;
                    case 3:
                        System.out.println("\n❌ Afslutter aktive ordrer...");
                        break;
                    case 4:
                        System.out.println("\n📦 Viser aktive bestillinger...");
                        break;
                    case 5:
                        System.out.println("\n✅ Viser afsluttede bestillinger...");
                        break;
                    case 6:
                        System.out.println("\n📊 Genererer rapport og statistik...");
                        break;
                    case 7:
                        System.out.println("\n🔴 Afslutter programmet...");
                        return; // Exit method
                    default:
                        System.out.println("\n⚠ Ugyldigt valg! Indtast et tal mellem 1 og 7.");
                }
            } catch (NumberFormatException e) { //Catches anything other than int inputs
                System.out.println("\n⚠ Fejl: Indtast et gyldigt tal mellem 1 og 7.");
            }
        }
    }
}
