public class FieldProcessor {

    private LineProcessor lineProcessor = new LineProcessor();



    public boolean checkField(Cell[][] field) {
        boolean isFound = false;

        if ( checkVerticalRaws(field) ) isFound = true;
        if ( checkHorizontalRaws(field) ) isFound = true;
        if ( checkDiagonals(field) ) isFound = true;

        return isFound;
    }



    private boolean checkHorizontalRaws(Cell[][] field) {
        boolean isFound = false;
        Cell[] horizontalLine = new Cell[field.length];
        for (int i = 0; i < field[0].length; i++) {

            for (int j = 0; j < field.length; j++) {
                horizontalLine[j] = field[j][i];
            }

            if ( lineProcessor.checkLine(horizontalLine) ) isFound = true;
        }
        return isFound;
    }

    private boolean checkVerticalRaws(Cell[][] field) {
        boolean isFound = false;
        Cell[] verticalLine = new Cell[field[0].length];
        for (int i = 0; i < field.length; i++) {

            for (int j = 0; j < field[0].length; j++) {
                verticalLine[j] = field[i][j];
            }

            if (lineProcessor.checkLine(verticalLine) ) isFound = true;
        }
        return isFound;
    }


    public boolean checkDiagonals(Cell[][] field) {

        boolean isFound = false;

        int m = field.length;
        int n = field[0].length;

        int maxLine = n;
        int k = m - n;

        Cell [] mainDiagonal = new Cell[maxLine];

        for (int q = 0; q <= k; q++) {
            for (int i = 0; i < maxLine; i++) {
                mainDiagonal[i] = field[i+q][i];
            }
            if ( lineProcessor.checkLine(mainDiagonal) ) isFound = true;

            for (int i = 0; i < maxLine; i++) {
                mainDiagonal[i] = field[(m-1)-i-q][i];
            }
            if ( lineProcessor.checkLine(mainDiagonal) ) isFound = true;
        }

        for (int q = 1; q <= n-5; q++) {
            maxLine = n - q;
            Cell [] secondaryDiagonal = new Cell[maxLine];

            for (int i = 0; i < maxLine; i++) {
                secondaryDiagonal[i] = field[i][i+q];
            }
            if ( lineProcessor.checkLine(secondaryDiagonal) ) isFound = true;

            for (int i = 0; i < maxLine; i++) {
                secondaryDiagonal[i] = field[i+k+q][i];
            }
            if ( lineProcessor.checkLine(secondaryDiagonal) ) isFound = true;

            for (int i = 0; i < maxLine; i++) {
                secondaryDiagonal[i] = field[(m-1)-k-q-i][i];
            }
            if ( lineProcessor.checkLine(secondaryDiagonal) ) isFound = true;

            for (int i = 0; i < maxLine; i++) {
                secondaryDiagonal[i] = field[(m-1)-i][i+q];
            }
            if ( lineProcessor.checkLine(secondaryDiagonal) ) isFound = true;

        }

        return isFound;
    }



}
