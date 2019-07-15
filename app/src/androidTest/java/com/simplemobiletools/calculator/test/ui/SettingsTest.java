package com.simplemobiletools.calculator.test.ui;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;

import com.nitorcreations.junit.runners.NestedRunner;
import com.simplemobiletools.calculator.activities.SplashActivity;
import com.simplemobiletools.calculator.test.pages.CalculatorPage;
import com.simplemobiletools.calculator.test.pages.SettingsPage;


@RunWith(NestedRunner.class)
public class SettingsTest {
    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);

    private SettingsPage settingsPage = new SettingsPage();
    private CalculatorPage calculatorPage = new CalculatorPage();

    public class CustomizeColors extends SettingsTest{
        @Test
        /*
            Change app theme color
            Expected: Change the app theme by switching between options
            Actual: Dark Red Theme causes app to crash. Light/Dark themes work as expected
            Steps to Reproduce:  Change theme to "Dark Red"
            Go back to calculator, and press a few digits.  Observe that the app crashes and cannot load
            the splash view anymore.
        */
        public void changeAppTheme() {
            settingsPage.changeTheme("Light");

            // ensure that the theme change doesn't crash the app
            calculatorPage.addition("789", "999", "1,788");

            settingsPage.changeTheme("Dark");
        }

        @Test
        // Change app text color
        public void changeTextColor() {
            settingsPage.changeTextColor("EEEEEE");
        }

        @Test
        // Change app background color/opacity
        public void changeBackgroundColor(){
            settingsPage.changeBackgroundColor("424242");
        }


        @Test
        // Change app header/title (primary) color
        public void changeHeaderColor(){
            settingsPage.changePrimaryColor("#F57C00");
        }

        @Test
        //Change app icon color
        public void changeIconColor(){
            settingsPage.changeAppIconColor("#F57C00");
        }

    }

    public class CustomizeWidget extends SettingsTest{
        @Test
        // Customize widget colors
        public void customizeWidgetColors(){
            settingsPage.changeWidgetColor();
        }
    }

    public class SettingsToggle extends SettingsTest {
        @Test
        //Avoid What's New toggle
        public void newInfoToggle(){
            settingsPage.whatsNew();
        }

        @Test
        //Haptic Feedback toggle
        public void feedbackToggle(){
            settingsPage.hapticFeedback();
        }

        @Test
        //Prevent Phone Sleep toggle
        public void preventSleep(){
            settingsPage.preventSleepToggle();
        }
    }
}
