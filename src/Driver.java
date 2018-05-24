import java.sql.Timestamp;

public class Driver {
    String name;
    Integer howManyHops;
    Integer whatCost;
    Timestamp timestamp;
    Integer howManyTimesThereIs;

    public Driver(String name, Integer howManyTimesThereIs){
        this.howManyTimesThereIs = howManyTimesThereIs;
        this.name = name;
    }

    public Integer getHowManyTimesThereIs() {
        return howManyTimesThereIs;
    }

    public Integer getHowManyHops() {
        return howManyHops;
    }

    public Integer getWhatCost() {
        return whatCost;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }


    public String getName() {
        return name;
    }


    public void setHowManyHops(Integer howMany) {
        this.howManyHops = howMany;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWhatCost(Integer whatCost) {
        this.whatCost = whatCost;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setHowManyTimesThereIs(Integer howManyTimesThereIs) {
        this.howManyTimesThereIs = howManyTimesThereIs;
    }
}
