import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Object structure: the order the client traverses
        List<MenuItem> order = List.of(
                new Pizza("Margherita", 9.50, 800, 8),
                new Drink("Cola", 2.00, 1, 330),
                new Dessert("Tiramisu", 4.50, 450)
        );

        PriceCalculator priceCalculator = new PriceCalculator();
        CalorieCounter calorieCounter = new CalorieCounter();

        for (MenuItem item : order) {
            item.accept(priceCalculator);
            item.accept(calorieCounter);
        }

        System.out.printf("Total price (with 10%% service fee): $%.2f%n",
                priceCalculator.getTotalWithServiceFee());
        System.out.println("Total calories: " + calorieCounter.getTotalCalories());
    }
}
