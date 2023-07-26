package com.example.tic_tacgame;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import lk.kasun.tictac.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class AllViewsTest {
    @Rule
    public ActivityTestRule<Splash_Screen> splashScreen = new ActivityTestRule<>(Splash_Screen.class);
    public ActivityTestRule<AboutUs> aboutUS = new ActivityTestRule<>(AboutUs.class);
    public ActivityTestRule<Help> helpScreen = new ActivityTestRule<>(Help.class);
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<>(MainActivity.class);
    public ActivityTestRule<ContactUs> contactUs = new ActivityTestRule<>(ContactUs.class);

    @Before
    public void setup() {
        // Add any setup actions if needed before each test
        Intents.init(); // Initialize Intents for handling Activity intents
    }

    @After
    public void tearDown() {
        // Add any cleanup actions if needed after each test
        Intents.release(); // Release Intents resources
    }

    @Test
    public void testOpenSecondActivity() {
        // Perform an action that should open SecondActivity, for example, clicking a button
        Espresso.onView(ViewMatchers.withId(R.id.repeat)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.buttonContact)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.about_us)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.contactus)).perform(ViewActions.click());
        // Check if SecondActivity is opened successfully
        Intents.intended(IntentMatchers.hasComponent(MainActivity.class.getName()));
    }
}
