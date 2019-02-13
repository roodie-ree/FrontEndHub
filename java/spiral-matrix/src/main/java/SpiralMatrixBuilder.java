class SpiralMatrixBuilder {
  private int[][] spiral;
  private int min;
  private int max;

  public int[][] buildMatrixOfSize(int i) {
    spiral = new int[i][i];
    min = 0;
    max = i - 1;
    // x, y, direction
    int[] step = {0, 0, 0};
    for (int count = 1; count <= i * i; count += 1) {
      spiral[step[0]][step[1]] = count;
      nextStep(step);
    }
    return spiral;
  }

  private void nextStep(int[] step) {
    int x = step[0];
    int y = step[1];
    // 0 = left, 1 = down, 2 = right, 3 = up
    int direction = step[2];
    // turn if necessary, then step forward
    switch (direction) {
      case 0:
        if (y == max ) {
          direction = 1;
          x += 1;
        } else {
          y += 1;
        }
        break;
      case 1:
        if (x == max) {
          direction = 2;
          y -= 1;
        } else {
          x += 1;
        }
        break;
      case 2:
        if (y == min) {
          max -= 1;
          min += 1;
          direction = 3;
          x -= 1;
        } else {
          y -= 1;
        }
        break;
      case 3:
        if (x == min) {
          direction = 0;
          y += 1;
        } else {
          x -= 1;
        }
        break;
    }
    step[0] = x;
    step[1] = y;
    step[2] = direction;
  }
}
