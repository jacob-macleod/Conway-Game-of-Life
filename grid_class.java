public class grid_class {
  int[][] grid_data = {
            {0, 1, 0, 0}, 
            {0, 0, 0, 0}, 
            {1, 0, 2, 1}, 
  };


  public void print_array () {
    System.out.println("Function is running");
    for (int i = 0; i < 3; i++) { 
      for (int j = 0; j < 4; j++) { 
        System.out.print(grid_data[i][j] + " "); 
      } 
      System.out.println(); 
    } 
  }


}
