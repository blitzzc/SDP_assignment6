public class Pizza implements MenuItem {
    private final String name;
    private final double price;
    private final int calories;
    private final int slices;

    public Pizza(String name, double price, int calories, int slices) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.slices = slices;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getCalories() { return calories; }
    public int getSlices() { return slices; }

    @Override
    public void accept(MenuVisitor visitor) {
        visitor.visitPizza(this);
    }
}
