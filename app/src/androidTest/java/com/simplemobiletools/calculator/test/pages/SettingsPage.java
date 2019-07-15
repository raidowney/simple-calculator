package com.simplemobiletools.calculator.test.pages;

import com.simplemobiletools.calculator.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;

public class SettingsPage {
    public void navigate(){
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Settings")).perform(click());
    }

    public void saveSelection(){
        onView(withText("OK")).perform(click());
        onView(withContentDescription("Navigate up")).perform(click());
        onView(withContentDescription("Navigate up")).perform(click());

        // assert that calculator is visible
        onView(withId(R.id.result)).check(matches(withText("0")));
    }

    public void changeTheme(String newTheme){
        navigate();
        onView(withId(R.id.settings_customize_colors_holder)).perform(click());
        onView(withId(R.id.customization_theme_holder)).perform(click());
        onView(withText(newTheme)).perform(click());
        onView(withId(R.id.save)).perform(click());
        onView(withContentDescription("Navigate up")).perform(click());
    }

    public void changeTextColor(String hexColor) {
        navigate();
        onView(withId(R.id.settings_customize_colors_holder)).perform(click());
        onView(withId(R.id.customization_text_color_holder)).perform(click());
        onView(withId(R.id.color_picker_new_hex)).check(matches(withText(hexColor)));

        saveSelection();
    }

    public void changeBackgroundColor(String hexColor){
        navigate();
        onView(withId(R.id.settings_customize_colors_holder)).perform(click());
        onView(withId(R.id.customization_background_color_holder)).perform(click());
        onView(withId(R.id.color_picker_new_hex)).check(matches(withText(hexColor)));
        saveSelection();
    }

    public void changePrimaryColor(String hexColor){
        navigate();
        onView(withId(R.id.settings_customize_colors_holder)).perform(click());
        onView(withId(R.id.customization_primary_color_holder)).perform(click());
        onView(withId(R.id.hex_code)).check(matches(withText(hexColor)));
        saveSelection();
    }

    public void changeAppIconColor(String hexColor){
        navigate();
        onView(withId(R.id.settings_customize_colors_holder)).perform(click());
        onView(withId(R.id.customization_app_icon_color_holder)).perform(click());
        onView(withId(R.id.hex_code)).check(matches(withText(hexColor)));
        saveSelection();
    }

    public void changeWidgetColor(){
        navigate();
        onView(withId(R.id.settings_customize_widget_colors_holder)).perform(click());
        onView(withId(R.id.config_bg_seekbar)).check(matches(isDisplayed()));
        onView(withId(R.id.config_save)).perform(click());
        onView(withContentDescription("Navigate up")).perform(click());
    }

    public void whatsNew(){
        navigate();
        onView(withId(R.id.settings_avoid_whats_new_holder)).perform(click());
        onView(withId(R.id.settings_avoid_whats_new_holder)).check(matches(isEnabled()));
    }

    public void hapticFeedback(){
        navigate();
        onView(withId(R.id.settings_vibrate_holder)).perform(click());
        onView(withId(R.id.settings_vibrate_holder)).check(matches(isEnabled()));
    }

    public void preventSleepToggle(){
        navigate();

        onView(withId(R.id.settings_prevent_phone_from_sleeping_holder)).perform(click()); // off
        onView(withId(R.id.settings_prevent_phone_from_sleeping_holder)).perform(click()); // on
        onView(withId(R.id.settings_vibrate_holder)).check(matches(isEnabled()));
    }
}
