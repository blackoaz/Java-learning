
public class Bicycle {
    int speed;
    String type;
    
    public Bicycle(int speed, String type) {
        this.speed = speed;
        this.type = type;
    }
    

    public int getSpeed() {
        return speed;
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Bicycle [speed=" + speed + ", type=" + type + "]";
    }


    public static void main(String[] args) {

        Bicycle bike1 = new Bicycle(20, "mountain");
        System.out.println(bike1);
        
    }


}