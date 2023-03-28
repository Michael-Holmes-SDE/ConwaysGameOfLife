public class PatternBlinker extends Pattern {
    int [][] patternArray = {{1}, {1}, {1}}; // 1's in a 3 long column
    public int getSizeX() {
        return patternArray[0].length; //Should be 1
    }
    public int getSizeY() {
        return patternArray.length; //Should be 3
    }
    public boolean getCell(int x, int y) {
        return patternArray[y][x] == 1; // Cell is alive
    }
}
