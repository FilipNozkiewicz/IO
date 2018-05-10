public class OurMap {
    Integer key;
    String value;
    OurMap( Integer key, String value){
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
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
    public void printMap(){
        System.out.println("Koszt: " + key + " Droga: " + value);
    }
}
