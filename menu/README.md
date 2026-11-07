# Assignment 6 - Visitor Pattern (Restaurant Menu)

Java implementation of the Visitor pattern. A restaurant order (Pizza, Drink, Dessert) gets two unrelated operations
(price calculation and calorie counting) without changing the menu item classes.

## Structure
| Component | Class |
|---|---|
| Element Interface | `MenuItem` - declares `accept(MenuVisitor)` |
| Concrete Elements | `Pizza`, `Drink`, `Dessert` - each calls its own `visitX(this)` |
| Visitor Interface | `MenuVisitor` - `visitPizza`, `visitDrink`, `visitDessert` |
| Concrete Visitors | `PriceCalculator`, `CalorieCounter` |
| Object Structure | `List<MenuItem> order` in `Main` |

## Run
```
cd src
javac *.java
java Main
```
Expected output:
```
Total price (with 10% service fee): $17.60
Total calories: 1580
```

## Double dispatch
`item.accept(visitor)` -> 1st dispatch: Java picks `Pizza.accept` (depends on the element's real type).
Inside it, `visitor.visitPizza(this)` -> 2nd dispatch: Java picks `PriceCalculator.visitPizza` (depends on the visitor's real type).
So the exact method is chosen by BOTH types, with no `instanceof`.

## Clean Code principles
1. **Meaningful names** - elements are nouns (`Pizza`), visitors describe an operation (`CalorieCounter`); `accept` / `visitX` show the roles clearly.
2. **No instanceof / type checks** - double dispatch replaces them completely.
3. **Single Responsibility** - each visitor does exactly one operation; each element only holds its own data.
4. **Open/Closed** - a new operation (e.g. `AllergenChecker`) is a new class implementing `MenuVisitor`; no element class changes.
5. **Small methods / no magic numbers** - every method does one thing; the service fee is the named constant `SERVICE_FEE_RATE`.
6. **Encapsulation trade-off** - fields are `private final` (immutable); visitors read data only through public getters, so internals are not exposed.

## Extensibility
Adding a third visitor requires no change to `Pizza`, `Drink`, `Dessert` or `MenuItem`.
(Trade-off: adding a new *element* type would require a new `visitX` method in `MenuVisitor` and all visitors.)
