package invoiceGenerator;

public class Ride {

    public static double time ;
    public static int distance;
    
    Ride(int distance,double time){
        this.distance = distance;
        this.time=time;
    }
    
    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
    
    @Override
    public String toString() {
        return "invoiceGenerator.Ride{" +
                "distance=" + distance +
                ", time=" + time +
                '}';
    }
}
