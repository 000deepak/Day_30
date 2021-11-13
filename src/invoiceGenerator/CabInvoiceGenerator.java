package invoiceGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CabInvoiceGenerator {
    private static final int KM_RATE = 10;
    private static final int TIME_RATE = 1;
    private static final int MIN_RATE = 5;
    static double fare;
    static Scanner sc = new Scanner(System.in);

    static HashMap<Integer,ArrayList<Ride>> service = new HashMap<>();

    public static void main(String[] args) {

        boolean flag=true;

        while(flag){
            System.out.println(
                    "1.add new user \n" +
                    "2.add ride \n" +
                    "3.calculate Fare\n" +
                    "4.calculate Monthly Fare\n" +
                    "5.get Enhanced invoice\n" +
                    "6.exit");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    addUser();
                    break;
                case 2:
                    addRide();
                    break;
                case 3:
                    totalFare();
                    break;
                case 4:
                    multipleRides(service);
                    break;
                case 5:
                    enhancedInvoice(service);
                    break;
                case 6:
                    flag= false;
            }
        }
    }
    static void addUser(){
        System.out.println("enter user id");
        int id = sc.nextInt();

        service.put(id ,null);
    }

    static void addRide(){
        System.out.println("enter user id");
        int id = sc.nextInt();

        for (Map.Entry<Integer, ArrayList<Ride>> ride : service.entrySet()){
            if(ride.getKey().equals(id)){
                System.out.println("enter distance in km");
                int dis = sc.nextInt();

                System.out.println("enter time in min");
                double tim = Double.parseDouble(sc.next());

                try {
                    ArrayList<Ride> rl = ride.getValue();
                    Ride r = new Ride(dis, tim);
                    rl.add(r);
                    service.put(id,rl);
                }catch (Exception e){
                    ArrayList<Ride> rl = new ArrayList<>();
                    Ride r = new Ride(dis, tim);
                    rl.add(r);
                    service.put(id,rl);

                }
            }
        }
    }

    static double totalFare() {
        System.out.println("enter distance in km");
        int dis = sc.nextInt();

        System.out.println("enter time in min");
        double tim = Double.parseDouble(sc.next());

        if (KM_RATE == 0 && TIME_RATE == 0) {
            fare = dis * KM_RATE + tim * TIME_RATE;
            return fare;
        }
        else
            return MIN_RATE;
    }

    static void multipleRides(HashMap<Integer,ArrayList<Ride>> service) {
        System.out.println("enter user id");
        int id = sc.nextInt();
        double sum = 0;

        for (Map.Entry<Integer, ArrayList<Ride>> ride : service.entrySet()){
            if(ride.getKey().equals(id)){


                for (Ride r : ride.getValue()) {
                    sum = sum + r.getDistance()*KM_RATE + r.getTime()*TIME_RATE;
                }
            }
        }System.out.println(sum);
    }

    static void enhancedInvoice(HashMap<Integer,ArrayList<Ride>> service){

        System.out.println("enter user id");
        int id = sc.nextInt();
        double sum = 0;
        int size=0;
        double averageFare=0;

        for (Map.Entry<Integer, ArrayList<Ride>> ride : service.entrySet()){
            if(ride.getKey().equals(id)){

                for (Ride r : ride.getValue()) {
                    sum = sum + r.getDistance()*KM_RATE + r.getTime()*TIME_RATE;
                }
                 size = ride.getValue().size();
                averageFare = sum/size;
            }
        }
        System.out.println("Total fare sum "+sum+"\nTotal Number of rides "+size+"\nAverage Fare per ride "+averageFare);
    }
}
