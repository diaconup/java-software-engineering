package isp.lab3;
import isp.lab3.exercise1.Tree;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class TreeTest {
    @Test
    public void testGrowMethod() {
        Tree tree1 = new Tree();
        tree1.growth(5);
        assertEquals("height:10",tree1.toString());
    }
    @Test
    public void testToStringMethod() {
        Tree tree2 = new Tree();
        assertEquals("height:5",tree2.toString());
    }
}