public class grid_class {
  //Create the array to hold the game's data. In the future, I'll create a function to handle this
  int[][] grid_data = {
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
            {3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3}, 
            {3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3}, 
            {3, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3}, 
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3}, 
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3}, 
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}
  };

  //Used to calculate where live cells are in function<insert function name>
  int[] i_values = {1, -1, 0, 0, 1, -1, 1, -1};
  int [] j_values = {0, 0, 1, -1, 1, -1, -1, 1};
  int x;
  int y;
  int a;
  int b;
  int count;
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
    //For each cell in the grid, 'ressurect it' if it has 3 neighbours, otherwise kill it
    for (int b=0;b<grid_data.length;b++) { 
      if (grid_data[b][b] != 3) {
        if (check_neighbours(b, b) < 2 || check_neighbours(b, b) > 3) {
          kill_cell(b, b);
        } else if (check_neighbours(b, b) == 3) {
          resurrect_cell(b, b);
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