package isp.lab10.racedemo;

import java.awt.*;

import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class CarRace extends Thread{
    private static boolean raceFinished = false;
    private static Map<Car, Long> raceDurations = new HashMap<>();
    public static void main(String[] args){

        JFrame frame = new JFrame("Car Race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CarPanel carPanel = new CarPanel();

        frame.getContentPane().add(carPanel);
        frame.pack();
        frame.setSize(500,300);
        frame.setVisible(true);

        Timer timer = new Timer();
        SemaphorePanel semaphorePanel = new SemaphorePanel();
        JFrame semaphoreFrame = new JFrame("Semaphore");
        semaphoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        semaphoreFrame.getContentPane().add(semaphorePanel);
        semaphoreFrame.pack();
        semaphoreFrame.setVisible(true);

        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);
        semaphoreThread.start();

        try {
            semaphoreThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Car car1 = new Car("Red car", carPanel, semaphoreThread);
        Car car2 = new Car("Blue car", carPanel, semaphoreThread);
        Car car3 = new Car("Green car", carPanel, semaphoreThread);
        Car car4 = new Car("Yellow car", carPanel, semaphoreThread);
        timer.start();
        car1.start();
        car2.start();
        car3.start();
        car4.start();

        try {
            car1.join();
            car2.join();
            car3.join();
            car4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        raceFinished = true;
        timer.stopTimer();
        carPanel.displayStandings(raceDurations);
    }
    static void setRaceDuration(Car car, long duration) {
        raceDurations.put(car, duration);
    }
    static boolean isRaceFinished() {
        return raceFinished;
    }
}
class Timer extends Thread {
    private boolean running = true;
    private long timer = 0;

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(10);
                timer += 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Race time: " + timer + " milliseconds");
    }

    public void stopTimer() {
        running = false;
    }
}
class Car extends Thread {
    private String name;
    private int distance = 0;
    private CarPanel carPanel;
    private long startTime;
    private long endTime;
    private SemaphoreThread semaphoreThread;

    public Car(String name, CarPanel carPanel, SemaphoreThread semaphoreThread) {
        //set thread name;
        setName(name);
        this.name = name;
        this.carPanel = carPanel;
        this.semaphoreThread = semaphoreThread;
    }
    public void run() {
        if (semaphoreThread != null) {
            try {
                semaphoreThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        PlaySound sound = new PlaySound();
        sound.playSound();

        startTime = System.currentTimeMillis();

        while (distance < 400) {
            // simulate the car moving at a random speed
            int speed = (int) (Math.random() * 10) + 1;
            distance += speed;

            carPanel.updateCarPosition(name, distance);

            try {
                // pause for a moment to simulate the passage of time
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        endTime = System.currentTimeMillis();

        carPanel.carFinished(name);

        sound.stopSound();

        long raceDuration = endTime - startTime;
        CarRace.setRaceDuration(this, raceDuration);
    }
}
class CarPanel extends JPanel {
    private int[] carPositions;
    private String[] carNames;
    private Color[] carColors;

    public void displayStandings(Map<Car, Long> raceDurations) {
        System.out.println("Race Standings:");

        raceDurations.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> {
                    Car car = entry.getKey();
                    long duration = entry.getValue();
                    System.out.println(car.getName() + " - Duration: " + duration + "ms");
                });
    }
    public CarPanel() {
        carPositions = new int[4];
        carNames = new String[]{"Red car", "Blue car", "Green car", "Yellow car"};
        carColors = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 4; i++) {
            int yPos = 50 + i * 50; // Vertical position of the car
            int xPos = carPositions[i]; // Horizontal position of the car
            int carSize = 30; // Size of the car

            g.setColor(carColors[i]);
            g.fillOval(xPos, yPos, carSize, carSize);
            g.setColor(Color.BLACK);
            g.drawString(carNames[i], xPos, yPos - 5);
        }
    }


    public void updateCarPosition(String carName, int distance) {
        int carIndex = getCarIndex(carName);
        if (carIndex != -1) {
            carPositions[carIndex] = distance;
            repaint();
        }
    }

    public void carFinished(String carName) {
        System.out.println("Car finished race.");
    }

    private int getCarIndex(String carName) {
        for (int i = 0; i < 4; i++) {
            if (carNames[i].equals(carName)) {
                return i;
            }
        }
        return -1;
    }
}
