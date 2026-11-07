public class PriceCalculator implements MenuVisitor {
    private static final double SERVICE_FEE_RATE = 0.10;
    private double total = 0;

    @Override
    public void visitPizza(Pizza pizza) {
        total += pizza.getPrice();
    }

    @Override
    public void visitDrink(Drink drink) {
        total += drink.getPrice();
    }

    @Override
    public void visitDessert(Dessert dessert) {
        total += dessert.getPrice();
    }

    public double getTotalWithServiceFee() {
        return total * (1 + SERVICE_FEE_RATE);
    }
}
