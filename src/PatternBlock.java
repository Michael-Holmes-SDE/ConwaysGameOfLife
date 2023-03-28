public class PatternBlock extends Pattern{
    int [][] patternArray = {{1, 1}, {1, 1}};
    public int getSizeX() {
        return patternArray[0].length; //Should be 2
    }
    public int getSizeY() {
        return patternArray.length; //Should be 2
    }
    public boolean getCell(int x, int y) {
        return patternArray[y][x] == 1; // Cell is alive
    }
}
