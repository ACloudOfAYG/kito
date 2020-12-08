public class SetMeal {
    protected String mealName;
    protected double mealPrice;
    protected String chickenName;
    protected Drinks drink;

    public SetMeal(){ }
    //构造方法
    public SetMeal(String mealName,String chickenName,Drinks drink,double mealPrice){
        this.mealName = mealName;
        this.chickenName = chickenName;
        this.drink = drink;
        this.mealPrice = mealPrice;
    }

    @Override
    public String toString() {
        return "SetMeal Name: "+this.mealName+"\nPrice: "+this.mealPrice;
    }
}
