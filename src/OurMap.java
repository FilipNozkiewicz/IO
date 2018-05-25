public class OurMap {
    Integer key;
    String value;
    Integer extraKey;

    OurMap(Integer key, String value) {
        this.key = key;
        this.value = value;
        this.extraKey = 0;
    }

    OurMap(Integer key, Integer extraKey, String value) {
        this.extraKey = extraKey;
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public Integer getExtraKey() {
        return extraKey;
    }

    public void setExtraKey(Integer extraKey) {
        this.extraKey = extraKey;
    }

    public String getValue() {
        return value;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void printMap() {
        System.out.println("Koszt: " + key + " Ilość Hopów: " + extraKey + " Droga: " + value);
    }
}
