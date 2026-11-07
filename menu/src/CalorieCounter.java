public class CalorieCounter implements MenuVisitor {
    private int totalCalories = 0;

    @Override
    public void visitPizza(Pizza pizza) {
        totalCalories += pizza.getCalories();
    }

    @Override
    public void visitDrink(Drink drink) {
        totalCalories += drink.getCaloriesPerMl() * drink.getVolumeMl();
    }

    @Override
    public void visitDessert(Dessert dessert) {
        totalCalories += dessert.getCalories();
    }

    public int getTotalCalories() {
        return totalCalories;
    }
}
