package com.gorillamo.ui.detailview

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
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

        TestActivity.layout = R.layout.list_detail
    }
    @Test
    fun checkViewsAreVisible() {

        activityRule.launchActivity(null)

        Thread.sleep(2000)

        onView(withId(R.id.detail_list)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.addButton)).check(matches(isCompletelyDisplayed()))

    }
}
