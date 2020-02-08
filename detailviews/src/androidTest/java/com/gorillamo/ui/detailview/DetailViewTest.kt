package com.gorillamo.ui.detailview

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class DetailViewTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule<TestActivity>(TestActivity::class.java, true, false)

    @Before
    fun setup(){

        TestActivity.layout = com.gorillamo.ui.detailview.test.R.layout.xml_with_container
        TestActivity.containerId = com.gorillamo.ui.detailview.test.R.id.container
        TestActivity.testInput = arrayOf("One","Two","Three")
    }

    @Test
    fun checkViewsAreVisible() {

        activityRule.launchActivity(null)

        Thread.sleep(2000)

        onView(withText("One")).check(matches(isDisplayed()))
        onView(withText("Two")).check(matches(isDisplayed()))
        onView(withText("Three")).check(matches(isDisplayed()))
        onView(withId(R.id.addButton)).check(matches(isDisplayed()))

    }

    @Test
    fun showsDialogWhenAddPressed(){

        activityRule.launchActivity(null)

        val viewInteraction = onView(withId(R.id.addButton))
        viewInteraction.check(matches(isDisplayed()))
        viewInteraction.perform(click())

        Thread.sleep(2000)

        onView(withText(R.string.history_hint)).check(matches(isDisplayed()))
        onView(withText(R.string.add_button_detail)).check(matches(isDisplayed()))

    }

}
