package com.simplemobiletools.calculator.test.pages;

import com.simplemobiletools.calculator.R;
import android.support.test.espresso.Espresso;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.openLinkWithText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static org.hamcrest.Matchers.allOf;
import android.support.test.espresso.intent.Intents;
import android.content.Intent;
import org.hamcrest.Matcher;

public class AboutPage {
    public void navigate(){
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("About")).perform(click());
    }

    public void clickSourceCodeLink(){
        navigate();
        Intents.init();
        Matcher expectedIntent = allOf(hasAction(Intent.ACTION_VIEW), hasData("https://simplemobiletools.com"));
        onView(withId(R.id.about_website)).perform(openLinkWithText("https://simplemobiletools.com"));
        intended(expectedIntent);
        Intents.release();
        Espresso.pressBack();
    }

    public void clickFeedbackLink(){
        navigate();
        onView(withId(R.id.about_email)).perform(openLinkWithText("hello@simplemobiletools.com"));
        Espresso.pressBack();
    }

    public void clickFaqLink(){
        navigate();
        onView(withId(R.id.about_faq)).perform(click());
        onView(withId((R.id.faq_holder))).check(matches(isDisplayed()));
        onView(withContentDescription("Navigate up")).perform(click());
    }
    public void clickMoreApps(){
        navigate();
        Intents.init();
        Matcher expectedIntent = allOf(hasAction(Intent.ACTION_VIEW), hasData("https://play.google.com/store/apps/details?id=com.simplemobiletools.calculator"));
        onView(withId(R.id.about_more_apps)).perform(click());
        intended(expectedIntent);
        Intents.release();
        Espresso.pressBack();
    }
    public void clickInviteLink() {
        navigate();
        Intents.init();
        Matcher expectedIntent = allOf(hasAction(Intent.ACTION_VIEW), hasData("https://simplemobiletools.com"));
        onView(withId(R.id.about_website)).perform(openLinkWithText("Invite friends"));
        intended(expectedIntent);
        Intents.release();
        Espresso.pressBack();
    }
    public void clickRateUsLink(){
        navigate();
        Intents.init();
        Matcher expectedIntent = allOf(hasAction(Intent.ACTION_VIEW), hasData("https://play.google.com/store/apps/details?id=com.simplemobiletools.calculator"));
        onView(withId(R.id.about_website)).perform(openLinkWithText("Rate us"));
        intended(expectedIntent);
        Intents.release();
        Espresso.pressBack();
    }

    public void clickThirdPartyLink(){
        navigate();
        onView(withId(R.id.about_license)).perform(click());
        onView(withId(R.id.license_notice)).check(matches(isDisplayed()));
        onView(withContentDescription("Navigate up")).perform(click());
    }

    public void clickDonateLink(){
        navigate();
        Intents.init();
        Matcher expectedIntent = allOf(hasAction(Intent.ACTION_VIEW), hasData("https://simplemobiletools.com/donate"));
        onView(withId(R.id.about_donate)).perform(openLinkWithText("Donate"));
        intended(expectedIntent);
        Intents.release();
        Espresso.pressBack();
    }
}
