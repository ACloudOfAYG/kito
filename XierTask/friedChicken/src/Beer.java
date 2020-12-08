import java.time.LocalDate;

public class Beer extends Drinks{
    float alcohol;

    public Beer(){ }

    public Beer(String name, double cost, LocalDate production_date, float alcohol) {
        super(name, cost, production_date, 30);
        this.alcohol = alcohol;
    }



    @Override
    public String toString() {
        return "Name: "+this.name;
    }

}
