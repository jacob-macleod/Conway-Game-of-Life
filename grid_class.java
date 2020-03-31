public class grid_class {
  int[][] grid_data = {
            {3, 3, 3, 3, 3, 3},
            {3, 1, 0, 0, 0, 3}, 
            {3, 0, 1, 0, 0, 3}, 
            {3, 0, 0, 0, 0, 3}, 
            {3, 3, 3, 3, 3, 3}
  };

  //Used to calculate where live cells are in function<insert function name>
  int[] i_values = {1, -1, 0, 0, 1, -1, 1, -1};
  int [] j_values = {0, 0, 1, -1, 1, -1, -1, 1};
  int x;
  int y;
  int a;
  int live_cell_count = 0;
  
  //'kill' cell in a given co-ordinate
  public void kill_cell (int i, int j) {
    System.out.println(grid_data[i][j]);
    grid_data[i][j] = 0;
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
