public class PatternAcorn extends Pattern {
    int [][] patternArray = {{0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0}, {1, 1, 0, 0, 1, 1, 1}};
    public int getSizeX() {
        return patternArray[0].length; //Should be 7
    }
    public int getSizeY() {
        return patternArray.length; //Should be 3
    }
    public boolean getCell(int x, int y) {
        return patternArray[y][x] == 1; // true if == 1
    }
}
