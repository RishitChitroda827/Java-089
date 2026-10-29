@FunctionalInterface
interface DiscountRule {
    double apply(double price);
}