package edu.ntudp.fit.muzychuk;
 import java.util.Random;
 import java.util.Scanner;

public class Laba1 {
    public static final int MATRIX_WIDTH = 20;
    public static final int MATRIX_HEIGHT = 20;
    public static final int MATRIX_MAX_RANDOM_VALUE = 100;

    public static int[][] RANDOM_MATRIX(){
        Random myRandom2 = new Random();
        int random_matrix_width = myRandom2.nextInt(MATRIX_WIDTH) + 1;
        int random_matrix_height = myRandom2.nextInt(MATRIX_HEIGHT) + 1;

        int[][] randomMatrix = new int[random_matrix_height][random_matrix_width];
        myRandom2 = new Random();

        for (int i = 0; i < random_matrix_height; i++) {
            for (int j = 0; j < random_matrix_width; j++) {
                randomMatrix[i][j] = myRandom2.nextInt(MATRIX_MAX_RANDOM_VALUE);
            }
        }

        System.out.println("Випадкова матриця:");
        for (int i = 0; i < random_matrix_height; i++) {
            for (int j = 0; j < random_matrix_width; j++) {
                System.out.print(randomMatrix[i][j] + " ");
            }
            System.out.println();
        }
        return randomMatrix;
    }
    public static void GREETING_MENU(){
        System.out.println("Программа для створення матриці цілих чисел типу int!");
        System.out.println("Введіть: ");
        System.out.println("1-щоб ввести ширину та висоту вручну; ");
        System.out.println("2-щоб створити випадкову матрицю. ");
        System.out.print("Введіть свій вибір сюди:");
    }

    public static void processMatrix(int[][] matrix) {
        int min = matrix[0][0];
        int max = matrix[0][0];
        double sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
                sum += matrix[i][j];
            }
        }

        double average = sum / (matrix.length * matrix[0].length);

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Середнє арифметичне: " + average);
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        outerLoop: do {
            GREETING_MENU();
        int choice = scanner.nextInt();
            switch ( choice ) {
                case 1:
                    int choice_matrix_width, choice_matrix_height;

                    do {
                        System.out.print("Введіть ширину матриці (не більше 20): ");
                        choice_matrix_width = scanner.nextInt();
                        if (choice_matrix_width > 20) {
                            System.out.println("Максимальна ширина матриці 20");
                        }
                    } while (choice_matrix_width > 20);

                    do {
                        System.out.print("Введіть висоту матриці (не більше 20): ");
                        choice_matrix_height = scanner.nextInt();
                        if (choice_matrix_height > 20) {
                            System.out.println("Максимальна висота матриці 20");
                        }
                    } while (choice_matrix_height > 20);

                    int[][] inputMatrix = new int[choice_matrix_height][choice_matrix_width];
                    Random myRandom = new Random();

                    for (int i = 0; i < choice_matrix_height; i++) {
                        for (int j = 0; j < choice_matrix_width; j++) {
                            inputMatrix[i][j] = myRandom.nextInt(MATRIX_MAX_RANDOM_VALUE);
                        }
                    }

                    System.out.println("Введена матриця:");
                    for (int i = 0; i < choice_matrix_height; i++) {
                        for (int j = 0; j < choice_matrix_width; j++) {
                            System.out.print(inputMatrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                    processMatrix(inputMatrix);
                    break;

                case 2:
                    int [][] rand_matrix=RANDOM_MATRIX();
                    processMatrix(rand_matrix);
                    break;

                default:
                    System.out.println("Невірний вибір. Будь ласка, виберіть ще раз.");
                    continue outerLoop;
            }

            System.out.print("Хочете виконати ще одну операцію? (так/ні): ");
        } while (scanner.next().equalsIgnoreCase("так"));
    }
}