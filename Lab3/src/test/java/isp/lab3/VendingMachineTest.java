package isp.lab3;
import isp.lab3.exercise5.VendingMachine;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineTest {
    @Test
    public void testDisplayProducts(){
        VendingMachine machine1 = new VendingMachine();
        assertEquals("Cola", machine1.displayProducts());

    }

    @Test
    public void testInsertCoin(){
        VendingMachine machine1 = new VendingMachine();
        assertEquals(200, machine1.insertCoin(200));
    }

    @Test
    public void testSelectProduct(){
        VendingMachine machine1 = new VendingMachine();
        assertEquals("Insufficient credit. Please insert more coins.", machine1.selectProduct(2));

    }

}

