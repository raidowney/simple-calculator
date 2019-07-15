package com.simplemobiletools.calculator.test.pages;

import com.simplemobiletools.calculator.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.longClick;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import java.text.*;

public class CalculatorPage {
    private Integer[] digitButtons = {
        R.id.btn_0,
        R.id.btn_1,
        R.id.btn_2,
        R.id.btn_3,
        R.id.btn_4,
        R.id.btn_5,
        R.id.btn_6,
        R.id.btn_7,
        R.id.btn_8,
        R.id.btn_9
    };

    private void enterValue(String value){
        final CharacterIterator it = new StringCharacterIterator(value);
        for(char c = it.first(); c != CharacterIterator.DONE; c = it.next()) {
            if (c == '-'){
                onView(withId(R.id.btn_minus)).perform(click());
            } else if(c == '.'){
                onView(withId(R.id.btn_decimal)).perform(click());
            }
            else {
                onView(withId(digitButtons[Character.getNumericValue(c)])).perform(click());
            }
        }
    }

    public void addition(String first, String second, String sum) {
        enterValue(first);
        onView(withId(R.id.btn_plus)).perform(click());
        enterValue(second);
        onView(withId(R.id.btn_equals)).perform(click());
        onView(withId(R.id.result)).check(matches(withText(sum)));
    }

    public void subtraction(String first, String second, String difference) {
        enterValue(first);
        onView(withId(R.id.btn_minus)).perform(click());
        enterValue(second);
        onView(withId(R.id.btn_equals)).perform(click());
        onView(withId(R.id.result)).check(matches(withText(difference)));
    }

    public void multiplication(String first, String second, String product) {
        enterValue(first);
        onView(withId(R.id.btn_multiply)).perform(click());
        enterValue(second);
        onView(withId(R.id.btn_equals)).perform(click());
        onView(withId(R.id.result)).check(matches(withText(product)));
    }

    public void division(String dividend, String divisor, String quotient) {
        enterValue(dividend);
        onView(withId(R.id.btn_divide)).perform(click());
        enterValue(divisor);
        onView(withId(R.id.btn_equals)).perform(click());
        onView(withId(R.id.result)).check(matches(withText(quotient)));
    }

    public void percentage(String first, String second, String result) {
        enterValue(first);
        onView(withId(R.id.btn_percent)).perform(click());
        enterValue(second);
        onView(withId(R.id.btn_equals)).perform(click());
        onView(withId(R.id.result)).check(matches(withText(result)));
    }

    public void orderOfOperations(String first, String second, String result){
        enterValue(first);
        onView(withId(R.id.btn_multiply)).perform(click());
        enterValue(second);
        onView(withId(R.id.btn_percent)).perform(click());
        onView(withId(R.id.btn_equals)).perform(click());
        onView(withId(R.id.result)).check(matches(withText(result)));
    }

    public void exponentiation(String base, String index, String power) {
        enterValue(base);
        onView(withId(R.id.btn_power)).perform(click());
        enterValue(index);
        onView(withId(R.id.btn_equals)).perform(click());
        onView(withId(R.id.result)).check(matches(withText(power)));
    }

    public void squareRoot(String radicand, String root){
        onView(withId(R.id.btn_minus)).perform(click());
        enterValue(radicand);
        onView(withId(R.id.btn_root)).perform(click());
        onView(withId(R.id.result)).check(matches(withText(root)));
    }

    public void squareRootNaN(String radicand, String root){
        squareRoot(radicand, root);
        onView(withId(R.id.btn_root)).perform(click());
        onView(withId(R.id.result)).check(matches(withText(root)));
    }

    public void clearLast(String num, String result) {
        enterValue(num);
        onView(withId(R.id.btn_clear)).perform(click());
        onView(withId(R.id.result)).check(matches(withText(result)));
    }

    public void clearAll(String num) {
        enterValue(num);
        onView(withId(R.id.btn_clear)).perform(longClick());
        onView(withId(R.id.result)).check(matches(withText("0")));
    }
}
