public class LifeSimulator {
    protected int sizeX;
    protected int sizeY;
    protected boolean[][] original;
    public LifeSimulator(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.original = new boolean[sizeX][sizeY];
    }

    public int getSizeX() {

        return this.sizeX;
    }
    public int getSizeY() {
        return this.sizeY;
    }
    public boolean getCell(int x, int y) {
        return original[x][y];
    }

    public void insertPattern(Pattern pattern, int startX, int startY) {
        for(int i = 0; i < pattern.getSizeX(); i++) {
            for(int j = 0; j < pattern.getSizeY(); j++) {
                if(pattern.getCell(i, j)) {
                    if(i + startX < getSizeX() && j + startY < getSizeY()) {
                        original[i + startX][j + startY] = true;
                    }
                }
            }
        }
    }
    public int neighbourCount(int i, int j) {
        int aliveNeighbours = 0;
        for (int a = -1; a <= 1; a++) {
            for (int b = -1; b <= 1; b++) {
                if ((i + a >= 0 && i + a < sizeX) && (j + b >= 0 && j + b < sizeY)) { // If cell is in the grid
                    if (getCell(i + a, j + b)) { // Cell is alive
                        aliveNeighbours += 1;
                    }
                }
            }
        }
        // Cell is not its own neighbour
        if (getCell(i, j)) { // Cell is alive
            aliveNeighbours -= 1;
        }
        return aliveNeighbours;
    }

    public void update() {
        boolean[][] updated = new boolean[sizeX][sizeY];
        // Looping through each cell in the grid
        for(int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                int aliveNeighbours = neighbourCount(i, j);
                // Rules for the Game of Life

                // Any dead cell with 3 alive neighbors becomes a live cell
                if (!getCell(i, j) && (aliveNeighbours == 3)) {
                    updated[i][j] = true;
                }
                // Any live cell with 2 or 3 alive neighbors survives
                else if (getCell(i, j) && 2 <= aliveNeighbours && aliveNeighbours <= 3) {
                    updated[i][j] = true;
                }
                // All other live cells die and dead cells stay dead (2 rules in 1 statement)
                else updated[i][j] = false;
            }
        }
        this.original = updated;
    }
}
