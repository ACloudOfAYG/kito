import java.time.LocalDate;
import java.util.ArrayList;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
    double balance;//余额
    static ArrayList<Beer> beers = new ArrayList<Beer>();
    static ArrayList<Juice> juices =  new ArrayList<Juice>();
    final static ArrayList <SetMeal> setMeals = null;
    boolean isfound = false;

    static {
        beers.add(new Beer("雪津",6,LocalDate.now(),3));
        beers.add(new Beer("青岛",6,LocalDate.now(),3.5f));
        juices.add(new Juice("西瓜汁",3,LocalDate.now()));
        juices.add(new Juice("梨汁",3,LocalDate.now()));
        setMeals.add(new SetMeal("套餐1", "辣翅", beers.get(1), 20));
        setMeals.add(new SetMeal("套餐2", "烤翅", beers.get(2), 20));
        setMeals.add(new SetMeal("套餐3", "辣翅", juices.get(1), 18));
        setMeals.add(new SetMeal("套餐4", "烤翅", juices.get(2), 18));
    }

    public void use(Beer beer){
        try {
            if(beers != null){
                for (Beer b : beers) {
                    if (b.isOut()) {
                        beers.remove(b);
                    }
                }
                //寻找是否拥有此饮料
                for(Beer b:beers){
                    if(b.name.equals(beer.name)){
                        beers.remove(b);
                        isfound = true;
                        break;
                    }else {
                        throw new IngredientSortOutException(beer.name+" is sold out");
                    }
                }
            }else {
                throw new IngredientSortOutException("Beer is null");
            }
        }catch (IngredientSortOutException ing){
            System.out.println(ing.getMessage());
        }

    }

    public void use(Juice juice){
        try {
            if(juices != null){
                for (Juice j : juices) {
                    if (j.isOut()) {
                        juices.remove(j);
                    }
                }
                //寻找是否有此饮料
                for(Juice j:juices){
                    if(j.name.equals(juice.name)){
                        juices.remove(j);
                        isfound = true;
                        break;
                    }else {
                        throw new IngredientSortOutException(juice.name+" is sold out");
                    }
                }
            }else {
                throw new IngredientSortOutException("Juice is null");
            }
        }catch (IngredientSortOutException ing){
            System.out.println(ing.getMessage());
        }

    }
    //检查是否有该套餐
    @Override
    public void sellMeal(SetMeal meal) {
        boolean check = false;
        for(SetMeal m:setMeals){
            if(m == meal){
                check = true;
            }
        }
        if(!check){
            System.out.println("No this setMeal.Sorry.");
        }else{
            if(meal.drink instanceof Beer){
                use((Beer) meal.drink);
            }else if(meal.drink instanceof Juice){
                use((Juice) meal.drink);
            }

            if(isfound){
                System.out.println("Thanks for your ordering. There is your set meal.");
                balance += meal.mealPrice;
            }
        }
    }


    //如果在寻找该饮料过程发现未找到且余额大于成本价，则进货
    @Override
    public void purchase(Drinks drink) {
        if(drink instanceof Beer){
            use((Beer) drink);
            if(!isfound && balance>drink.cost){
                beers.add((Beer) drink);
                balance -= drink.cost;
            }
        }else if(drink instanceof Juice){
            use((Beer) drink);
            if(!isfound&& balance>drink.cost){
                juices.add((Juice) drink);
                balance -= drink.cost;
            }
        }

    }

}
