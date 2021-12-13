package ru.vsu.cs.avdeeva_p_a;

import util.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

public class Tests {

    @Test
    public void firstTest() {
        int[][] testingArray = ArrayUtils.readIntArray2FromFile("testsCases/input01.txt");
        FindingQuantity.findQuantityOfElem(testingArray);
        int[][] correctArray = ArrayUtils.readIntArray2FromFile("testsAnswers/answerForFirstTest.txt");

        Assert.assertArrayEquals(correctArray, testingArray);

    }

    @Test
    public void secondTest() {
        int[][] testingArray = ArrayUtils.readIntArray2FromFile("testsCases/input02.txt");
        FindingQuantity.findQuantityOfElem(testingArray);
        int[][] correctArray = ArrayUtils.readIntArray2FromFile("testsAnswers/answerForSecondTest.txt");

        Assert.assertArrayEquals(correctArray, testingArray);

    }

    @Test
    public void thirdTest() {
        int[][] testingArray = ArrayUtils.readIntArray2FromFile("testsCases/input03.txt");
        FindingQuantity.findQuantityOfElem(testingArray);
        int[][] correctArray = ArrayUtils.readIntArray2FromFile("testsAnswers/answerForThirdTest.txt");

        Assert.assertArrayEquals(correctArray, testingArray);

    }

    @Test
    public void fourthTest() {
        int[][] testingArray = ArrayUtils.readIntArray2FromFile("testsCases/input04.txt");
        FindingQuantity.findQuantityOfElem(testingArray);
        int[][] correctArray = ArrayUtils.readIntArray2FromFile("testsAnswers/answerForFourthTest.txt");

        Assert.assertArrayEquals(correctArray, testingArray);

    }

    @Test
    public void fifthTest() {
        int[][] testingArray = ArrayUtils.readIntArray2FromFile("testsCases/input05.txt");
        FindingQuantity.findQuantityOfElem(testingArray);
        int[][] correctArray = ArrayUtils.readIntArray2FromFile("testsAnswers/answerForFifthTest.txt");

        Assert.assertArrayEquals(correctArray, testingArray);

    }
}
