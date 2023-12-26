package isp.lab3.exercise1;

public class Tree {
    private int height;

    public Tree(){
        height = 5;
    }

    public void growth(int meters){
        if (meters > 1){
            height += meters;
        }
    }

    public String toString(){
        return "height:"+height;
    }

    public static void main(String[] args) {
        Tree tree2 = new Tree();
        System.out.println(tree2.toString());
        tree2.growth(3);
        System.out.println(tree2.toString());
    }
}
