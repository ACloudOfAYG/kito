import java.time.LocalDate;

public class Juice extends Drinks {

    public Juice(){ }

    public Juice(String name, double cost, LocalDate production_date) {
        super(name, cost, production_date, 2);
    }



    @Override
    public String toString() {
        return "Name: "+this.name;
    }
}
