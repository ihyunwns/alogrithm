package ComparableImpl;

import org.jetbrains.annotations.NotNull;

class Coordinate implements Comparable<Coordinate>{
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public int compareTo(@NotNull Coordinate o) {
        // 비교할 대상보다 크면 1 리턴
        if (this.x > o.x) {
            return 1;
        // 비교할 대상보다 작으면 -1 리턴
        } else if (this.x < o.x) {
            return -1;
        // X좌표가 같을 때
        } else {
            // 비교할 대상 보다 크면 1 리턴
            if (this.y > o.y) {
                return 1;
            // 비교할 대상 보다 작으면 -1 리턴
            } else if (this.y < o.y) {
                return -1;
            }
        }
        // Y 좌표도 같은 경우 // 그러나 이러한 경우의 입력은 없을 것으로 가정함
        return 0;
    }

    @Override
    public String toString() {
        return  x + " " + y ;
    }
}
