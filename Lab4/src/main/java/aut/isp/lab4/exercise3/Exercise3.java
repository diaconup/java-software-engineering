package aut.isp.lab4.exercise3;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {

        FishFeeder feeder1 = new FishFeeder("Rosa","New");
        AquariumController aquarium1 = new AquariumController(feeder1, "Steins","XM2");

        feeder1.fillUp();
        aquarium1.setFeedingTime(2.30f);

        while(true){
            System.out.println("What's the time?");

            Scanner sc=new Scanner(System.in);
            float time = sc.nextFloat();
            aquarium1.setCurrentTime(time);

            if(aquarium1.getCurrentTime() == aquarium1.getFeedingTime()){
                feeder1.feed();
            }
        }
    }
}
