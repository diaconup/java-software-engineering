package isp.lab7.safehome;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoorLockController implements ControllerInterface{
    private Map<String, AccessKey> validAccess;
    private AccessKey key;
    private AccessKey masterKey;
    private Door door;
    private int retries;
    private List<AccessLog> accessLogs = new ArrayList<>();

    public DoorLockController(Map<String, AccessKey> validAccess, AccessKey masterKey) {
        this.validAccess = validAccess;
        this.door = new Door();
        this.retries = 0;
        this.masterKey = masterKey;
    }
    public DoorLockController(){
        this.validAccess = new HashMap<String, AccessKey>();
        this.door = new Door();
        this.retries = 0;
        this.masterKey = new AccessKey(ControllerInterface.MASTER_KEY);
    }
    public AccessKey getMasterKey() {
        return masterKey;
    }
    public DoorStatus enterPin(String enteredPin) throws InvalidPinException, TooManyAttemptsException {
        AccessLog log;
        AccessKey key = null;
        String name = null;

        for (Map.Entry<String, AccessKey> k : validAccess.entrySet()){
            if(k.getValue().getPin().equals(enteredPin)){
                key = k.getValue();
                name = k.getKey();
            }
        }

        if (key != null && key.getPin().equals(enteredPin)) {
            door.setStatus(door.getStatus() == DoorStatus.OPEN ? DoorStatus.CLOSE : DoorStatus.OPEN);
            log = new AccessLog(name,LocalDateTime.now(),"enter pin",door.getStatus(),"no error");
            accessLogs.add(log);
            retries++;
            if(retries >= 3) {
                throw new TooManyAttemptsException("Too many attempts. Door is locked");
            }
            retries = 0;
            return door.getStatus();
        } else if (masterKey != null && masterKey.getPin().equals(enteredPin)) {
            retries = 0;
            door.unlockDoor();
            door.setStatus(DoorStatus.OPEN);
            log = new AccessLog(name,LocalDateTime.now(),"enter pin",door.getStatus(),"no error");
            accessLogs.add(log);
            return door.getStatus();
        } else {
            retries++;
            if (retries >= 3) {
                door.lockDoor();
                log = new AccessLog(name,LocalDateTime.now(),"enter pin",door.getStatus(),"Too many attempts.");
                accessLogs.add(log);
                throw new TooManyAttemptsException("Too many attempts. Door is locked");
            } else{
                door.lockDoor();
                log = new AccessLog(name,LocalDateTime.now(),"enter pin",door.getStatus(),"Invalid Pin.");
                accessLogs.add(log);
                throw new InvalidPinException("Invalid Pin Entered.");
            }
        }
    }

    public void addTenant(String accessKey, String tenantName) throws TenantAlreadyExistsException {
        if(validAccess.containsKey(tenantName)) {
            throw new TenantAlreadyExistsException("Tenant already exists!");
        }
        validAccess.put(tenantName, new AccessKey(accessKey));
    }

    public void removeTenant(String tenantName) throws TenantNotFoundException {
        if(!validAccess.containsKey(tenantName)) {
            throw new TenantNotFoundException("Tenant not found!");
        }
        validAccess.remove(tenantName);
    }

    public void getAccessLogs(){
        for(AccessLog log : accessLogs)
            System.out.println(log);
    }
}
