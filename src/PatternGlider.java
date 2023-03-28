public class PatternGlider extends Pattern {
    int[][] patternArray = {{1, 0, 0}, {0, 1, 1}, {1, 1, 0}};
    public int getSizeX() {
        return patternArray[0].length; //Should be 3
    }
    public int getSizeY() {
        return patternArray.length; //Should be 3
    }
    public boolean getCell(int x, int y) {
        return patternArray[y][x] == 1; // Cell is alive
    }
}
