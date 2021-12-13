package ru.vsu.cs.avdeeva_p_a;

public class FindingQuantity {

    public static void findQuantityOfElem(int[][] arr) {
        int[][] resultArray = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int quantityElem = countQuantity(arr, i, j);
                resultArray[i][j] = quantityElem;
            }
        }

        moveToArray(arr, resultArray);
    }

    private static int countQuantity(int[][] arr, int i, int j) {
        int quantity = 0;
        int trialArray = arr[i][j];

        for (int elemRow : arr[i]) {
            if (elemRow == trialArray) {
                quantity++;
            }
        }

        for (int q = 0; q < arr.length; q++) {
            if (trialArray == arr[q][j]) {
                quantity++;
            }
        }
        return quantity - 1;
    }

    private static int[][] moveToArray(int[][] arr, int[][] resultArray) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = resultArray[i][j];
            }
        }
        return arr;
    }
}
