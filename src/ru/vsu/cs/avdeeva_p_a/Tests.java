package ru.vsu.cs.avdeeva_p_a;

import utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Tests {

    @Test
    public void testingSameNumsRepeats() {
        List<Integer> testingInputList = ArrayUtils.readListFromFile("testsCases/input01.txt");
        List<Integer> actualList = sortRepeatedNumsAscending.createNewList(testingInputList);
        List<Integer> correctOutputLlist = ArrayUtils.readListFromFile("testsAnswers/answerForFirstTest.txt");

        Assert.assertEquals(correctOutputLlist, actualList);

    }

    @Test
    public void testingRepetitionOfOneNum() {
        List<Integer> testingInputList = ArrayUtils.readListFromFile("testsCases/input02.txt");
        List<Integer> actualList = sortRepeatedNumsAscending.createNewList(testingInputList);
        List<Integer> correctOutputLlist = ArrayUtils.readListFromFile("testsAnswers/answerForSecondTest.txt");

        Assert.assertEquals(correctOutputLlist, actualList);

    }

    @Test
    public void testingNumWithoutRepetitions() {
        List<Integer> testingInputList = ArrayUtils.readListFromFile("testsCases/input03.txt");
        List<Integer> actualList = sortRepeatedNumsAscending.createNewList(testingInputList);
        List<Integer> correctOutputLlist = ArrayUtils.readListFromFile("testsAnswers/answerForThirdTest.txt");

        Assert.assertEquals(correctOutputLlist, actualList);

    }

    @Test
    public void testingOnlyTwoNumsRepeated() {
        List<Integer> testingInputList = ArrayUtils.readListFromFile("testsCases/input04.txt");
        List<Integer> actualList = sortRepeatedNumsAscending.createNewList(testingInputList);
        List<Integer> correctOutputLlist = ArrayUtils.readListFromFile("testsAnswers/answerForFourthTest.txt");

        Assert.assertEquals(correctOutputLlist, actualList);

    }

    @Test
    public void testingOnlyFirstLastNumsInSeqRepeated() {
        List<Integer> testingInputList = ArrayUtils.readListFromFile("testsCases/input05.txt");
        List<Integer> actualList = sortRepeatedNumsAscending.createNewList(testingInputList);
        List<Integer> correctOutputLlist = ArrayUtils.readListFromFile("testsAnswers/answerForFifthTest.txt");

        Assert.assertEquals(correctOutputLlist, actualList);

    }
}
