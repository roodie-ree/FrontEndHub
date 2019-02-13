import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Matrix {
  private List<int[]> cells;

  Matrix(String matrixAsString) {
    List<String> rowsStrings = Arrays.asList(matrixAsString.split("\\n"));
    cells = new ArrayList<int[]>();
    for (String row : rowsStrings) {
      String[] columns = row.split(" ");
      int[] intRow = Arrays.stream(columns)
        .mapToInt(col -> Integer.parseInt(col))
        .toArray();
      cells.add(intRow);
    }
  }

  int[] getRow(int rowNumber) {
    return cells.get(rowNumber);
  }

  int[] getColumn(int columnNumber) {
    return cells.stream()
      .mapToInt(row -> row[columnNumber])
      .toArray();
  }
}
