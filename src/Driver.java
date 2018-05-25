import java.sql.Timestamp;

public class Driver {
    private String name;
    private Integer howManyHops;
    private Integer whatCost;
    private Timestamp timestamp;
    private Integer howManyTimesThereIs;

    public Driver(String name, Integer howManyTimesThereIs) {
        this.howManyTimesThereIs = howManyTimesThereIs;
        this.name = name;
    }

    public Integer getHowManyTimesThereIs() {
        return howManyTimesThereIs;
    }

    public String getName() {
        return name;
    }

    public void setHowManyTimesThereIs(Integer howManyTimesThereIs) {
        this.howManyTimesThereIs = howManyTimesThereIs;
    }
}
