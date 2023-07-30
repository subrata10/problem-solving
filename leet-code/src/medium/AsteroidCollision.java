package medium;

import java.util.Arrays;

public class AsteroidCollision {

    public static void main(String[] args) {
        int[] asteroids = {-2, 2, -3, -2};
        AsteroidCollision obj = new AsteroidCollision();

        for (int i : obj.asteroidCollision(asteroids)) {
            System.out.print(i + " ");
        }
    }

    public int[] asteroidCollision(int[] asteroids) {
        int top = -1;

        for (int x : asteroids) {

            boolean stillAlive = true;


            // if still alive is true AND each asteroid value is less than 0 AND top index
            // value is greater than equal to 0 AND asteroid value is greater than 0

            while (stillAlive && x < 0 && top >= 0 && asteroids[top] > 0) {

                stillAlive = asteroids[top] + x < 0;

                if (asteroids[top] + x <= 0) {
                    top--;
                }
            }

            if (stillAlive) {
                asteroids[++top] = x;
            }
        }
        return Arrays.copyOf(asteroids, top + 1);

    }
}
