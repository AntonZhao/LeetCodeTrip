public class LC733_floodFill {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int startColor;
    int newColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.startColor = image[sr][sc];
        this.newColor = newColor;
        if (startColor != newColor)
            dfs(image, sr, sc);
        return image;
    }

    private void dfs(int[][] image, int row, int col) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length) return;

        if (image[row][col] == startColor) {
            image[row][col] = newColor;
            for (int i = 0; i < 4; i++) {
                dfs(image, row + dx[i], col + dy[i]);
            }

        }
    }

    public static void main(String[] args) {
        LC733_floodFill ll = new LC733_floodFill();

//        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        int[][] ints = ll.floodFill(image, 1, 1, 1);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
