public class grid_class {
  //Create the array to hold the game's data. In the future, I'll create a function to handle this
  int[][] grid_data = {
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
            {3, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3}, 
            {3, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3}, 
            {3, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3}, 
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3}, 
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3}, 
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}
  };
  
  //Is this working?
  //Just testing this with eclipse ide!
  //Used to calculate where live cells are in function<insert function name>
  int[] i_values = {1, -1, 0, 0, 1, -1, 1, -1};
  int [] j_values = {0, 0, 1, -1, 1, -1, -1, 1};
  int x;
  int y;
  int a;
  int b;
  int count;
  int x_loc;
  int y_loc;
  int live_cell_count = 0;
  

  //Prints the game grid
  public void print_grid() {
    int count = 0;           
    for (int[] innerArray: grid_data) {
      for(int data: innerArray) {
        System.out.print(data);
        count++;
        if (count > 21) {
          System.out.println();
          count = 0;
        }
      }
    }
  } 
  


  //The logic for the game
  public void game_logic () {
     x_loc = -1;
    //For each cell in the grid, 'ressurect it' if it has 3  or 2 neighbours, otherwise kill it
    //!We need all the changes to the array to happen at the end of the function, not the middle!
    for (int[] innerArray: grid_data) {
      x_loc = x_loc + 1;
      y_loc = -1;
      for (int data: innerArray){
        y_loc = y_loc + 1;
        System.out.println ("Testing " + x_loc + " and " + y_loc);
        if (grid_data[x_loc][y_loc] != 3) {
          System.out.println ("Running on " + x_loc + " and " + y_loc);
          if (check_neighbours(x_loc, y_loc) < 2 || check_neighbours(x_loc, y_loc) > 3) {
            kill_cell(x_loc, y_loc);
            System.out.println("Killing cell");
          } else if (check_neighbours(x_loc, y_loc) == 3 || check_neighbours(x_loc, y_loc) == 2) {
            resurrect_cell(x_loc, y_loc);
            System.out.println("ressurecting cell");
          }
       }
    }
   }
 }

  //'kill' cell in a given co-ordinate
  public void kill_cell (int i, int j) {
    grid_data[i][j] = 0;
  }


  //'resurrect' cell in a given co-ordinate
  public void resurrect_cell (int i, int j) {
    grid_data[i][j] = 1;
  }

  //Check the number of adjacent live cells in a given coordinate
  public int check_neighbours (int i, int j) {
    live_cell_count = 0;
      for(int a=0; a< i_values.length; a++){
        if (grid_data[i+i_values[a]][j + j_values[a]] == 1) {
          live_cell_count = live_cell_count + 1;
        }
      } 
    return live_cell_count;
  }
}