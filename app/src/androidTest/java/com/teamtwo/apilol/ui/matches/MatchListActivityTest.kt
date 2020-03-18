package com.teamtwo.apilol.ui.matches

import android.app.Application
import android.content.Intent
import android.os.SystemClock
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.jakewharton.espresso.OkHttp3IdlingResource
import com.teamtwo.apilol.DaggerMatchesUiTestComponent
import com.teamtwo.apilol.R
import com.teamtwo.apilol.matchesListMock
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.*
import org.junit.runner.RunWith
import kotlin.time.ExperimentalTime


@RunWith(AndroidJUnit4::class)
class MatchListActivityTest {

    @ExperimentalTime
    @get:Rule
    val activityTestRule = ActivityTestRule(MatchListActivity::class.java, false, false)

    private lateinit var mockWebServer: MockWebServer
    private lateinit var idlingResource: IdlingResource


    @ExperimentalTime
    @Before
    fun setUp() {

        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as Application

        val component = DaggerMatchesUiTestComponent.factory().create(app)
        mockWebServer = component.mockWebServer
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(matchesListMock)
        )
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(matchesListMock)
        )

        idlingResource = OkHttp3IdlingResource.create("OkHttp", component.lolServiceManager.okHttpClient)
        IdlingRegistry.getInstance().register(idlingResource)

        val intent = Intent(instrumentation.targetContext, MatchListActivity::class.java)
        activityTestRule.launchActivity(intent)
    }

    @ExperimentalTime
    @Test
    fun checkMatchListIsDisplayed(){

        SystemClock.sleep(3000)

        onView(withId(R.id.recyclerView))
            .check(matches(atPosition(1, hasDescendant(withText("ARAM - MATCHED_GAME")))));
    }

    @ExperimentalTime
    @Test
    fun clickOnMatchNavigatesToMatchDetail(){

        SystemClock.sleep(3000)

        onView(withId(R.id.recyclerView))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1, click()));

        onView(withId(R.id.gameIdText)).check(matches(isDisplayed()))

    }

    @After
    fun tearDown() {
        mockWebServer.close()
        mockWebServer.shutdown()
        IdlingRegistry.getInstance().unregister(idlingResource)
    }


    private fun atPosition(position: Int, itemMatcher: Matcher<View?>): Matcher<View?>? {
        return object : BoundedMatcher<View?, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("has item at position $position: ")
                itemMatcher.describeTo(description)
            }

            override fun matchesSafely(view: RecyclerView): Boolean {
                val viewHolder =
                    view.findViewHolderForAdapterPosition(position)
                        ?: // has no item on such position
                        return false
                return itemMatcher.matches(viewHolder.itemView)
            }
        }
    }
}