package map;

public class QItem {

        int row;
        int col;
        int dist;

        QItem prevQItem;

        public QItem(int row, int col,QItem prevQItem, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.prevQItem = prevQItem;
        }

    @Override
    public String toString() {
        return "QItem{" +
                " col=" + col +
                ",row=" + row +
                '}';
    }
}
