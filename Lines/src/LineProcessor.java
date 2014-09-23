public class LineProcessor {

    public static final int UNDEFINED_COLOR = -1;

    public boolean checkLine(Cell[] lineArr) {
        boolean isFound = false;

        int refColor = (lineArr[0].isCellContainsBall()) ? lineArr[0].getColor() : UNDEFINED_COLOR;
        int counter = 1;

        for (int i = 1; i < lineArr.length; i++) {
            Cell cell = lineArr[i];

            if ( !cell.isCellContainsBall() ){
                refColor= UNDEFINED_COLOR;
                continue;
            }

            if ( cell.getColor() != refColor ) {
                refColor = cell.getColor();
                counter = 1;
                continue;
            }

            counter++;
            if (counter == 5) {
                isFound = true;
                markForRemoveFiveBallsBefore(lineArr, i);
            }
            if (counter > 5) {
                markCellToRemoveBall(cell);
            }
        }

        return isFound;
    }

    public void markForRemoveFiveBallsBefore(Cell[] arr, int endPos) {
        for (int i = endPos - 4; i <= endPos; i++) {
            markCellToRemoveBall(arr[i]);
        }
    }

    public void markCellToRemoveBall(Cell cell) {
        cell.setBallState(Ball.MARKED_FOR_REMOVE);
    }

}
