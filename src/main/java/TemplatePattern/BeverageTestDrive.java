package TemplatePattern;

public class BeverageTestDrive {
    public static void main(String[] args) {
        Tea myTea = new Tea();
        myTea.prepareRecipe();

        CoffeeWithHock coffeeWithHock = new CoffeeWithHock();

        System.out.println("\nMaking coffee...");
        coffeeWithHock.prepareRecipe();

    }
}
