import java.time.LocalDate;

public abstract class Drinks {
    protected String name;
    protected double cost;
    protected LocalDate production_date;
    protected int shelf_life;

    public Drinks(){ }

    public Drinks(String name, double cost, LocalDate production_date, int shelf_life){
        this.name = name;
        this.cost = cost;
        this.production_date = production_date;
        this.shelf_life = shelf_life;
    }


    public boolean isOut() {
        return production_date.plusDays(shelf_life).isAfter(LocalDate.now());
    }

    public abstract String toString();

}