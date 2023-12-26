import aut.isp.lab4.exercise2.FishFeeder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Ex2 {

    @Test
    public void testToString(){
        FishFeeder feeder1 = new FishFeeder("Rosa","Model nou");
        feeder1.fillUp();
        feeder1.feed();
        assertEquals("FishFeeder{model = Model nou, manufacturer Rosa, meals 13}", feeder1.toString());
    }

    @Test
    public void testFillUp(){
        FishFeeder feeder1 = new FishFeeder("Rosa","Model nou");
        feeder1.fillUp();
        assertEquals(14, feeder1.getMeals());
    }

    @Test
    public void testFeed(){
        FishFeeder feeder1 = new FishFeeder("Rosa","Model nou");
        feeder1.fillUp();
        feeder1.feed();
        assertEquals(13, feeder1.getMeals());
    }
}
