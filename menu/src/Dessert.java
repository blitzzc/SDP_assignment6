public class Dessert implements MenuItem {
    private final String name;
    private final double price;
    private final int calories;

    public Dessert(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getCalories() { return calories; }

    @Override
    public void accept(MenuVisitor visitor) {
        visitor.visitDessert(this);
    }
}
