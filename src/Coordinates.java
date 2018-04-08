public class Coordinates {
    int x; int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() { // zwraca X
        try {
            return x;
        }catch (Exception e){
            System.out.println("Bład z współrzędnymi - zwracam X = 0");
            return 0;
        }
    }
    public int getY() { //zwraca Y
        try {
            return y;
        }catch (Exception e){
            System.out.println("Bład z współrzędnymi - zwracam Y = 0");
            return 0;
        }
    }
}
