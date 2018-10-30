import javafx.util.Pair;
import methods.Algorithm;
import methods.Knapsack;
import methods.OneMachine;
import methods.TwoMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

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

    public void doKnapsack() {
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
    public void doOneMachine() {
        int[] times = new int[]{5, 10, 5, 1, 3, 5};
        int[] priorities = new int[]{10, 6, 5, 4, 2, 8};

        OneMachine machine = new OneMachine(times, priorities);

        machine.calculate();

        System.out.println(machine);
    }

    /**
     * @see <a href="http://e-maxx.ru/algo/johnson_problem_2">Задача Джонсона с двумя станками</a>
     */
    public void doTwoMachine() {
        int[] times = new int[]{4, 1, 5, 2, 5};
        int[] priorities = new int[]{3, 2, 4, 3, 6};

        TwoMachine machine = new TwoMachine(times,priorities);

        machine.calculate();

        System.out.println(machine);
    }

}
