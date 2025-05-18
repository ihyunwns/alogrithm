import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static class Hamburger {

        private final List<Ingredient> ingredients = new ArrayList<>();

        public Hamburger() {}

        public Hamburger(List<Ingredient> ingredients){
            this.ingredients.addAll(ingredients);
        }

        public void addIngredient(Ingredient ingredient){
            ingredients.add(ingredient);
        }

        public int getCalorie(){
            int calorie = 0;
            for (Ingredient i : ingredients) {
                calorie += i.calorie;
            }

            return calorie;
        }

        public int getTaste(){
            int taste = 0;
            for (Ingredient i : ingredients) {
                taste += i.taste;
            }
            return taste;
        }

        public List<Ingredient> getIngredients(){
            return ingredients;
        }

    }


    static class Ingredient {

        final int taste;
        final int calorie;

        public Ingredient(int taste, int calorie) {
            this.taste = taste;
            this.calorie = calorie;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int L = Integer.parseInt(input[1]);

            Ingredient[] ingredients = new Ingredient[N];
            for(int i = 0; i < N; i++){
                String s = br.readLine();
                ingredients[i] = new Ingredient(Integer.parseInt(s.split(" ")[0]), Integer.parseInt(s.split(" ")[1]));
            }

            // 햄버거 재료를 조합해서 가장 맛있는 햄버거를 만드는게 목표, 즉 taste 점수가 높아야 함 그러나 calorie가 L을 넘기면 안됨

            // 만들 햄버거 스택에 기본 재료 하나씩 넣은 햄버거 넣음
            Stack<Hamburger> makeHamburger = new Stack<>();
            List<List<Ingredient>> visited_recipe = new ArrayList<>();
            for(int i = 0; i < N; i++){
                Hamburger h = new Hamburger();
                h.addIngredient(ingredients[i]);

                makeHamburger.push(h);
                visited_recipe.add(h.getIngredients());
            }

            List<Hamburger> goodHamburgers = new ArrayList<>();
            while(!makeHamburger.isEmpty()){

                Hamburger hamburger = makeHamburger.pop(); // 현재 햄버거
                goodHamburgers.add(hamburger);

                if (hamburger.getCalorie() > L) {
                    goodHamburgers.remove(hamburger);
                    continue;
                }

                // 햄버거에 들어가 있는 재료를 제외한 재료들을 한개씩 넣은 햄버거 추가
                for(Ingredient i : ingredients){

                    List<Ingredient> ingredients_in = hamburger.getIngredients();
                    // 내가 가지고 있는 재료는 무시
                    if(ingredients_in.contains(i)){
                        continue;
                    }

                    // 없는 재료라면 햄버거에 넣는데 넣은 재료가 만든 레시피에 있다면 무시
                    Hamburger h = new Hamburger(ingredients_in);
                    h.addIngredient(i);
                    if(visited_recipe.contains(h.getIngredients())){
                        continue;
                    }

                    makeHamburger.push(h);
                    visited_recipe.add(h.getIngredients());

                }

            }

            goodHamburgers.sort(new Comparator<Hamburger>() {
                @Override
                public int compare(Hamburger o1, Hamburger o2) {
                    return o2.getTaste() - o1.getTaste();
                }
            });

            System.out.println("#" + tc + " " + goodHamburgers.get(0).getTaste());


        }
    }
}
