package com.example.vindecoder


import android.support.test.espresso.ViewInteraction
import android.util.Log
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.test.espresso.Espresso
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Rule
import org.junit.Test
import  androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText


class MainActivityTest {


    @get:Rule
  var activityScenarioRule = activityScenarioRule<MainActivity>()
    @Test
    fun testButton()

    {
        val str="VIN: JNKCA21A4XT770979\nVehicle Type: PASSENGER CAR\nPlant City: YOKOSUKA CITY\nPlant Company Name: Oppama Plant\nPlant Country: JAPAN\nPlant State: KANAGAWA\nMake: INFINITI\n"
        onView(withId(R.id.vinEditText)).perform(typeText("JNKCA21A4XT770979"))
        onView(withId(R.id.submitBtn)).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.vinDetailsTextView)).check(matches(withText(str)))

    }

}