import java.util.Random;

public class Piece {

    Cube pointer;

    Piece(int p_no, int grid_size) {
        int[][] pos_arr = new int[p_no][2];
        Random random = new Random();
        boolean is_first_cube = true;
        boolean cube_place_valid;


        int new_x = 0, new_y = 0;
        int l_max, r_max, u_max, d_max;
        int piece_x, piece_y;
        int path;
        char dir = ' ';
        Cube curr_cube;

        for (int i = 0; i < p_no; i++) {

            if (is_first_cube) {
                new_x = random.nextInt(0, grid_size);
                new_y = random.nextInt(0, grid_size);
                pointer = new Cube(new_x, new_y);
                is_first_cube = false;
                pos_arr[i] = new int[]{new_x, new_y};
            } else {
                path = random.nextInt(0, i);
                curr_cube = pointer;
                while (path > 0) {
                    //TODO Move between cubes before adding a new one
                }

                cube_place_valid = false;
                while (!cube_place_valid) {
                    // Choose a random direction
                    switch (random.nextInt(0, 4)) {
                        // Up
                        case 0:
                            new_x = curr_cube.cube_x;
                            new_y = curr_cube.cube_y - 1;
                            dir = 'U';
                            break;
                        // Down
                        case 1:
                            new_x = curr_cube.cube_x;
                            new_y = curr_cube.cube_y + 1;
                            dir = 'D';
                            break;
                        // Left
                        case 2:
                            new_x = curr_cube.cube_x - 1;
                            new_y = curr_cube.cube_y;
                            dir = 'L';
                            break;
                        // Right
                        case 3:
                            new_x = curr_cube.cube_x + 1;
                            new_y = curr_cube.cube_y;
                            dir = 'R';
                            break;
                    }
                    // Check for Borders
                    if (((new_x >= 0) && (new_x < grid_size)) && ((new_y >= 0) && (new_y < grid_size))) {
                        // Check for Emptiness
                        switch (dir) {
                            case 'U':
                                cube_place_valid = curr_cube.c_up == null;
                                break;
                            case 'D':
                                cube_place_valid = curr_cube.c_down == null;
                                break;
                            case 'L':
                                cube_place_valid = curr_cube.c_right == null;
                                break;
                            case 'R':
                                cube_place_valid = curr_cube.c_left == null;
                                break;
                        }
                    }
                }

                switch (dir) {
                    case 'U':
                        curr_cube.c_up = new Cube(new_x, new_y).c_down = curr_cube;
                    case 'D':
                        curr_cube.c_down = new Cube(new_x, new_y).c_up = curr_cube;
                    case 'L':
                        curr_cube.c_left = new Cube(new_x, new_y).c_right = curr_cube;
                    case 'R':
                        curr_cube.c_right = new Cube(new_x, new_y).c_left = curr_cube;
                }
            }
        }
    }
    //TODO  ShiftOperations()
}
