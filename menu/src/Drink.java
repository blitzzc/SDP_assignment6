public class Drink implements MenuItem {
    private final String name;
    private final double price;
    private final int caloriesPerMl;
    private final int volumeMl;

    public Drink(String name, double price, int caloriesPerMl, int volumeMl) {
        this.name = name;
        this.price = price;
        this.caloriesPerMl = caloriesPerMl;
        this.volumeMl = volumeMl;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getCaloriesPerMl() { return caloriesPerMl; }
    public int getVolumeMl() { return volumeMl; }

    @Override
    public void accept(MenuVisitor visitor) {
        visitor.visitDrink(this);
    }
}
