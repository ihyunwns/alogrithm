import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

class SugarDevide {
    private final int sugar;
    private final int ones_digit;
    private int bag;

    private final Map<Integer, Integer> sugarMap = Map.of(
            0, 0,
            1, 3,
            2, 4,
            3, 1,
            4, 4,
            5, 0,
            6, 2,
            7, 5,
            8, 2,
            9, 3
    );

    public SugarDevide(int sugar) {
        this.sugar = sugar;
        ones_digit = sugar % 10;
        this.bag = sugarMap.get(ones_digit);
    }

    public void sugarDevide() {
        int x = 0;
        if (ones_digit == 0 || ones_digit == 5) {
            x = sugar;
        }
        else if (ones_digit == 1) {
            x = sugar - 11;
        }
        else if (ones_digit == 2) {
            x = sugar - 12;
        }
        else if (ones_digit == 3) {
            x = sugar - 3;
        }
        else if (ones_digit == 4) {
            x = sugar - 14;
        }
        else if (ones_digit == 6) {
            x = sugar - 6;
        }
        else if (ones_digit == 7) {
            x = sugar - 17;
        }
        else if (ones_digit == 8) {
            x = sugar - 8;
        }
        else if (ones_digit == 9) {
            x = sugar - 9;
        }

        if (x < 0) {
            bag = -1;
        } else {
            bag += x / 5;
        }

    }

    public int getBag() {
        return bag;
    }

}

public class SugarDelivery {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugar = Integer.parseInt(br.readLine());

        SugarDevide sd = new SugarDevide(sugar);
        sd.sugarDevide();
        System.out.println(sd.getBag());

    }
}

