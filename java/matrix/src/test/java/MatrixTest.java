import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MatrixTest {

    @Test
    public void extractRowFromOneNumberMatrixTest() {
        String matrixAsString = "1";
        int rowIndex = 0;
        int[] expectedRow = {1};

        Matrix matrix = new Matrix(matrixAsString);

        assertArrayEquals(expectedRow, matrix.getRow(rowIndex));
    }

    @Test
    public void extractRowFromMatrixTest() {
        String matrixAsString = "1 2\n3 4";
        int rowIndex = 1;
        int[] expectedRow = {3, 4};

        Matrix matrix = new Matrix(matrixAsString);

        assertArrayEquals(expectedRow, matrix.getRow(rowIndex));
    }

    @Test
    public void extractRowFromDiffWidthsMatrixTest() {
        String matrixAsString = "1 2\n10 20";
        int rowIndex = 1;
        int[] expectedRow = {10, 20};

        Matrix matrix = new Matrix(matrixAsString);

        assertArrayEquals(expectedRow, matrix.getRow(rowIndex));
    }

    @Test
    public void extractRowFromNonSquareMatrixTest() {
        String matrixAsString = "1 2 3\n4 5 6\n7 8 9\n8 7 6";
        int rowIndex = 2;
        int[] expectedRow = {7, 8, 9};

        Matrix matrix = new Matrix(matrixAsString);

        assertArrayEquals(expectedRow, matrix.getRow(rowIndex));
    }

    @Test
    public void extractColumnFromOneNumberMatrixTest() {
        String matrixAsString = "1";
        int columnIndex = 0;
        int[] expectedColumn = {1};

        Matrix matrix = new Matrix(matrixAsString);

        assertArrayEquals(expectedColumn, matrix.getColumn(columnIndex));
    }

    @Test
    public void extractColumnMatrixTest() {
        String matrixAsString = "1 2 3\n4 5 6\n7 8 9";
        int columnIndex = 2;
        int[] expectedColumn = {3, 6, 9};

        Matrix matrix = new Matrix(matrixAsString);

        assertArrayEquals(expectedColumn, matrix.getColumn(columnIndex));
    }

    @Test
    public void extractColumnFromNonSquareMatrixTest() {
        String matrixAsString = "1 2 3\n4 5 6\n7 8 9\n8 7 6";
        int columnIndex = 2;
        int[] expectedColumn = {3, 6, 9, 6};

        Matrix matrix = new Matrix(matrixAsString);

        assertArrayEquals(expectedColumn, matrix.getColumn(columnIndex));
    }

    @Test
    public void extractColumnFromDiffWidthsMatrixTest() {
        String matrixAsString = "89 1903 3\n18 3 1\n9 4 800";
        int columnIndex = 1;
        int[] expectedColumn = {1903, 3, 4};

        Matrix matrix = new Matrix(matrixAsString);

        assertArrayEquals(expectedColumn, matrix.getColumn(columnIndex));
    }
}
