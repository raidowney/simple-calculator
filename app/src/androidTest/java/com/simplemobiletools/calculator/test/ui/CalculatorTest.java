package com.simplemobiletools.calculator.test.ui;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.nitorcreations.junit.runners.NestedRunner;

import com.simplemobiletools.calculator.test.pages.CalculatorPage;
import android.support.test.rule.ActivityTestRule;
import com.simplemobiletools.calculator.activities.SplashActivity;

@RunWith(NestedRunner.class)
public class CalculatorTest {
    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);
    private CalculatorPage calculatorPage = new CalculatorPage();

    public class AdditionTests extends CalculatorTest{
        @Test
        // 2 + 2 = 4
        public void addingTwoPositiveIntegers() {
            calculatorPage.addition("2","2", "4");
        }

        @Test
        // -3 + -1 = -4
        public void addingTwoNegativeIntegers() {
            calculatorPage.addition("-3","-1", "-4");
        }

        @Test
        // -3 + 1 = -2
        public void addingOneNegativeInteger() {
            calculatorPage.addition("-3", "1","-2");
        }
    }

    public class SubtractionTests extends CalculatorTest {
        @Test
        // 5 - 1 = 4
        public void subtractingPositiveInteger() {
            calculatorPage.subtraction("5", "1", "4");
        }

        @Ignore
        @Test
    /*
        Expected: -3 - -1 = -2
        Actual: = -4
        Reason: no design for negative number button, and subtraction doesn't switch a number to negative.
        Current work around please use: -3 + 1 = -2
        https://github.com/SimpleMobileTools/Simple-Calculator/issues/104
    */
        public void subtractingWithTwoNegativeIntegers() {
            calculatorPage.subtraction("-3", "-1", "-2");
        }

        @Test
        // -3 - 1 = -4
        public void subtractingFromNegativeInteger() {
            calculatorPage.subtraction("-3", "1", "-4");
        }
    }

    public class MultiplicationTests extends CalculatorTest {
        @Test
        // 2 x 3 = 6
        public void multiplyingTwoPositiveIntegers() {
            calculatorPage.multiplication("2", "3", "6");
        }

        @Test
        // -4 x 7 = -28
        public void multiplyingOnePositiveInteger() {
            calculatorPage.multiplication("-4", "7", "-28");
        }

        @Ignore
        @Test
    /*
        Expected: -4 x -5 = 20
        Actual: = -9
        Reason: Reason: no design for negative number button, and subtraction doesn't switch a number to negative
        https://github.com/SimpleMobileTools/Simple-Calculator/issues/104
    */
        public void multiplyingTwoNegativeIntegers() throws Exception {
            calculatorPage.multiplication("-4", "-5", "20");
        }
    }

    public class DivisionTests extends CalculatorTest {
        @Test
        // 6 / 3 = 2
        public void dividingByPositiveInteger() {
            calculatorPage.division("6","3","2");
        }

        @Ignore
        @Test
    /*
        Expected: 8 / -4 = -2
        Actual: = 4
        Reason: no design for negative number button, and subtraction doesn't switch a number to negative
        https://github.com/SimpleMobileTools/Simple-Calculator/issues/104
    */
        public void dividingPositiveIntegerByNegativeInteger() {
            calculatorPage.division("8","-4","-2");
        }

        @Ignore
        @Test
    /*
        Expected: -9 / -3 = 3
        Actual: = 12
        Reason: no design for negative number button, and subtraction doesn't switch a number to negative
        https://github.com/SimpleMobileTools/Simple-Calculator/issues/104
    */
        public void dividingNegativeIntegersByNegativeInteger() {
            calculatorPage.division("-9","-3","3");
        }

        @Ignore
        @Test
    /*
        Expected: 7 / 0 = Error/NaN
        Actual: = 0
        https://github.com/SimpleMobileTools/Simple-Calculator/issues/68
    */
        public void dividingByZero() throws Exception {
            calculatorPage.division("7","0","NaN");
        }

        @Test
        // 0 / 6 = 0
        public void dividingZeroByInteger() {
            calculatorPage.division("0","6","0");
        }
    }

    public class PercentTests extends CalculatorTest {
        @Test
        // 25% 8 = 2
        public void percentOfInteger() {
            calculatorPage.percentage("25","8", "2");
        }

        @Ignore
        @Test
    /*
        Expected:8 X 25% = 2
        Actual: 200
        Order of operations isn't preserved
        https://github.com/SimpleMobileTools/Simple-Calculator/issues/20
     */
        public void integerPercentage() {
            calculatorPage.orderOfOperations("8","25","2");
        }
    }

    public class ExponentTests extends CalculatorTest {
        @Test
        // 7 ^ 2 = 49
        public void exponentWithTwoPositiveIntegers() {
            calculatorPage.exponentiation("7", "2", "49");
        }

        @Test
        // 9 ^ .5 = 3
        public void exponentWithPositiveFloat() {
            calculatorPage.exponentiation("9", ".5", "3");
        }

        @Test
        // 2 ^ 0 = 1
        public void exponentWithZero() {
            calculatorPage.exponentiation("2", "0", "1");
        }

        @Ignore
        @Test
    /*
        Expected: 9 ^ 999 = Error/Infinity/1.94E953
        Actual: 0
        Calculator does not handle extremely large values.
        https://github.com/SimpleMobileTools/Simple-Calculator/issues/87
    */
        public void largeExponent() {
            calculatorPage.exponentiation("9", "999", "NaN");
        }
    }

    public class SquareRootTests extends CalculatorTest {
        @Test
        // sqrt(9) = 3
        public void squareRootWithPositiveInteger() {
            calculatorPage.squareRoot("9","3");
        }

        @Test
        // sqrt(-2) = NaN
        public void squareRootWithNegativeIntegers() {
            calculatorPage.squareRoot("2-","NaN");
        }

        @Test
        // sqrt(.25) = .5
        public void squareRootWithPositiveFloat() {
            calculatorPage.squareRoot(".25","0.5");
        }

        @Ignore
        @Test
    /*
        Expected: sqrt(NaN) = Error/Nan
        Actual: causes the app to crash
        Any button after NaN (except for clear) causes app to crash
        https://github.com/SimpleMobileTools/Simple-Calculator/issues/127
    */
        public void squareRootNan() {
            calculatorPage.squareRootNaN("-2", "NaN");
        }
    }

    public class ClearTests extends CalculatorTest {
        @Test
        //click a couple of digits, press clear once, should remove last digit
        public void clearLastDigit() {
            calculatorPage.clearLast("278", "27");
        }

        @Test
        // click a couple of digits, long press on clear should remove all
        public void clearAll() {
            calculatorPage.clearAll("567");
        }
    }
}
