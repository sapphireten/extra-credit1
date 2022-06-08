package edu.ecu.cs.pirateplaces

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PiratePlacesListActivityTest {
    @get:Rule
    var activityRule = ActivityScenarioRule(PiratePlacesListActivity::class.java)

    @Test
    fun prevButtonDisable() {
        //maybe out a while loop here
        Espresso.onView(withId(R.id.prev_button))
            .check(matches(isNotEnabled()))
    }

    @Test
    fun nextButtonEnable() {
        Espresso.onView(withId(R.id.next_button))
            .check(matches(isEnabled()))

        Espresso.onView(withText("Next"))
            .perform(click())
    }

    @Test
    fun prevButtonEnable() {
        Espresso.onView(withId(R.id.next_button))
            .perform(click())

        Espresso.onView(withId(R.id.prev_button))
            .check(matches(isEnabled()))
    }

    @Test
    fun nextButtonDisable() {
        var x = 0
        while (x < 10){
            Espresso.onView(withText("Next"))
                .perform(click())
            x++
        }
            Espresso.onView(withId(R.id.next_button))
                .check(matches(isNotEnabled()))
    }
}