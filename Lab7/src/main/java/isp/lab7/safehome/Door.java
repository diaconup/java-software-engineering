package isp.lab7.safehome;

public class Door {
    private DoorStatus doorStatus;

    public DoorStatus getStatus() {
        return doorStatus;
    }

    public void setStatus(DoorStatus doorStatus) {
        this.doorStatus = doorStatus;
    }

    public void lockDoor(){
        doorStatus = DoorStatus.CLOSE;
        System.out.println("The door is closed!");
    }

    public void unlockDoor(){
        doorStatus = DoorStatus.OPEN;
        System.out.println("The door is unlocked");
    }
}
