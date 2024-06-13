package General;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Coordinate{
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private static Coordinate[] combine(Coordinate[] left, Coordinate[] right, int size) {
        Coordinate[] arr = new Coordinate[size];
        int index = 0;
        for (int i = 0; i < left.length; i++) {
            arr[index++] = left[i];
        }
        for (int i = 0; i < right.length; i++) {
            arr[index++] = right[i];
        }

        return arr;
    }

    // 1. X좌표 올림 차순
    // 2. Y좌표 올림 차순
    public static BufferedWriter sort(Coordinate[] comp) throws IOException {

        Coordinate[] tempX = new Coordinate[comp.length];

        //X좌표 정렬
        int size = 0;
        for (Coordinate coord : comp) {
            // 처음은 그냥 삽입
            if (size == 0) {
                tempX[size] = coord;
                size++;
                continue;
            }

            for (int i = 0; i < size; i++) {
                //temp 각 요소 한번씩 대입
                Coordinate tempC = tempX[i];

                if (coord.x > tempC.x) {
                    if (i+1 >= size) {
                        tempX[size] = coord;
                        size++;
                        break;
                    }
                    continue;

                } else {
                    //인덱스 i ~ 끝까지 복사
                    // i 인덱스 coord 삽입
                    // 그 뒤로 복사한 부분 붙여넣기
                    Coordinate[] left = Arrays.copyOfRange(tempX, 0, i+1);
                    Coordinate[] right = Arrays.copyOfRange(tempX, i, size);
                    left[i] = coord;

                    tempX = combine(left, right, comp.length);
                    size++;
                    break;
                }
            }
        }

        Coordinate[] tempY = new Coordinate[comp.length];
        size = 0;
        //Y좌표 정렬 // X좌표가 같은 경우에만 올림차순 정렬
        for (Coordinate coord : tempX) {

            if (size == 0) {
                tempY[size] = coord;
                size++;
                continue;
            }

            for (int i = 0; i < size; i++) {
                Coordinate tempC = tempY[i];

                //X좌표가 같은 경우
                if (coord.x == tempC.x) {
                    //크다면
                    if (coord.y > tempC.y) {
                        if (i+1 >= size) {
                            tempY[size] = coord;
                            size++;
                            break;
                        }
                        //다음 비교군으로 이동
                        continue;
                    //작다면
                    } else {

                        Coordinate[] left = Arrays.copyOfRange(tempY, 0, i+1);
                        Coordinate[] right = Arrays.copyOfRange(tempY, i, size);
                        left[i] = coord;

                        tempY = combine(left, right, comp.length);
                        size++;
                        break;
                    }
                } else {
                    tempY[size] = coord;
                    size++;
                    break;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Coordinate c : tempY) {
            bw.write(c.x + " " + c.y + "\n");
        }
        return bw;


    }

    @Override
    public String toString() {
        return "{" + this.x + ", " + this.y + "}";
    }
}
