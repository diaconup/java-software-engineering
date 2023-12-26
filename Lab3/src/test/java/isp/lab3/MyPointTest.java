package isp.lab3;
import isp.lab3.exercise4.MyPoint;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class MyPointTest {
    @Test
    public void testDistance(){
        MyPoint point1 = new MyPoint(1,2,3);
        MyPoint point2 = new MyPoint(2,3,4);

        assertEquals(1.7320508075688772, point1.distance(point2), 1.7320508075688772);
    }

}
