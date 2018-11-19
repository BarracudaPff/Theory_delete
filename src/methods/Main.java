package methods;

public class Main {


    //javac
    public static void main(String[] args) {
        Main main = new Main();

        String[] data = {"\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2510",
                "\u2502Hello\u2502",
                "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2518"};
        for (String s : data) {
            System.out.println(s);
        }

        main.doKnapsack();
        main.doOneMachine();
        main.doTwoMachine();
    }

    /**
     * @see <a href="https://neerc.ifmo.ru/wiki/index.php?title=%D0%97%D0%B0%D0%B4%D0%B0%D1%87%D0%B0_%D0%BE_%D1%80%D1%8E%D0%BA%D0%B7%D0%B0%D0%BA%D0%B5">Задача о рюкзаке</a>
     */
    private void doKnapsack() {
        int[] weights = new int[]{1, 2, 4, 2, 1};
        int[] costs = new int[]{600, 5000, 1500, 40000, 500};
        int needed = 8;

        Knapsack knapsack = new Knapsack(weights, costs, needed);
        knapsack.calculate();

        System.out.println(knapsack);
    }

    /**
     * @see <a href="http://koi.tspu.ru/koi_books/gorchakov/stanok.htm">One machine task</a>
     * @see <a href="http://e-maxx.ru/algo/johnson_problem_1">Задача Джонсона с одним станком</a>
     */
    private void doOneMachine() {
        int[] times = new int[]{5, 10, 5, 1, 3, 5};
        int[] priorities = new int[]{10, 6, 5, 4, 2, 8};

        OneMachine machine = new OneMachine(times, priorities);

        machine.calculate();

        System.out.println(machine);
    }

    /**
     * @see <a href="http://e-maxx.ru/algo/johnson_problem_2">Задача Джонсона с двумя станками</a>
     */
    private void doTwoMachine() {
        int[] times = new int[]{4, 1, 5, 2, 5};
        int[] priorities = new int[]{3, 2, 4, 3, 6};

        TwoMachine machine = new TwoMachine(times,priorities);

        machine.calculate();

        System.out.println(machine);
    }

}
