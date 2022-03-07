package TemplatePattern;

/**
 * 咖啡因饮料
 */
public abstract class CaffeineBeverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }

    /**
     * 判断顾客是否需要添加调味品
     * 钩子方法，子类可以选择实现或是不
     * @return
     */
    boolean customerWantsCondiments() {
        return true;
    }
}
