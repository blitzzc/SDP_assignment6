public interface MenuVisitor {
    void visitPizza(Pizza pizza);
    void visitDrink(Drink drink);
    void visitDessert(Dessert dessert);
}
