import java.util.Random;

public class Cube{
    static enigma.console.Console cn;
    Random rnd = new Random();
    private int up , right, down, left;
    public Cube c_up = null, c_right = null, c_down = null, c_left = null;
    int cube_x, cube_y;

    Cube(enigma.console.Console cn){
        this.cn = cn;
    }



    Cube (int x, int y){
        // Coordinates in Piece
        this.cube_x = x;
        this.cube_y = y;

        // Values
        this.up = rnd.nextInt(10,100);
        this.right = rnd.nextInt(10,100);
        this.down = rnd.nextInt(10,100);
        this.left = rnd.nextInt(10,100);


    }

    public void rotateRight() {
        int temp;
        temp = up;
        up = left;
        left = down;
        down = right;
        right = temp;
    }
    public void rotateLeft() {
        int temp;
        temp = up;
        up = right;
        right = down;
        down = left;
        left = temp;
    }
    public void reverse() {
        int temp = left;
        left = right;
        right = temp;
    }
}