package com.simplemobiletools.calculator.test.ui;

import org.junit.Rule;
import org.junit.Test;

import android.support.test.rule.ActivityTestRule;

import com.simplemobiletools.calculator.activities.SplashActivity;
import com.simplemobiletools.calculator.test.pages.CalculatorPage;
import com.simplemobiletools.calculator.test.pages.AboutPage;

import org.junit.Rule;

public class AboutTest {
    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);

    private AboutPage aboutPage = new AboutPage();
    private CalculatorPage calculatorPage = new CalculatorPage();

    @Test
    public void sourceCodeLink(){
        aboutPage.clickSourceCodeLink();
    }

    @Test
    public void feedbackLink(){
        aboutPage.clickFeedbackLink();
    }

    @Test
    public void faqLink(){
        aboutPage.clickFaqLink();
    }

    @Test
    public void moreApps(){
        aboutPage.clickMoreApps();
    }

    @Test
    public void inviteFriends(){
        aboutPage.clickInviteLink();
    }

    @Test
    public void thirdPartyLink(){
        aboutPage.clickThirdPartyLink();
    }

    @Test
    public void donateLink(){
        aboutPage.clickDonateLink();
    }
//
//    //FollowUS
//        //FB
//        //Google+
}
