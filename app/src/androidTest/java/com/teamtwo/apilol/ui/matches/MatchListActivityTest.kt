package com.teamtwo.apilol.ui.matches

import android.app.Application
import android.content.Intent
import android.os.SystemClock
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.jakewharton.espresso.OkHttp3IdlingResource
import com.teamtwo.apilol.*
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.BaseMatcher
import org.hamcrest.Description
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.time.ExperimentalTime


@RunWith(AndroidJUnit4::class)
class MatchListActivityTest {

    @ExperimentalTime
    @get:Rule
    val activityTestRule = ActivityTestRule(MatchListActivity::class.java, false, false)

    private lateinit var mockWebServer: MockWebServer


    @ExperimentalTime
    @Before
    fun setUp() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as Application

        val component = DaggerMatchesUiTestComponent.factory().create(app)
        mockWebServer = component.mockWebServer

        val resource = OkHttp3IdlingResource.create("OkHttp", component.lolServiceManager.okHttpClient)
        IdlingRegistry.getInstance().register(resource)

        component.database.clearAllTables()

        val intent = Intent(instrumentation.targetContext, MatchListActivity::class.java)
        activityTestRule.launchActivity(intent)
    }

    @ExperimentalTime
    @Test
    fun checkMatchListIsDisplayed(){
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(matchesListMock)
        )

        SystemClock.sleep(1000)

        Espresso.onView(ViewMatchers.withId(R.id.recyclerView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

    @ExperimentalTime
    @Test
    fun clickOnMatchNavigatesToMatchDetail(){
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(matchesListMock)
        )

        SystemClock.sleep(1000)

        Espresso.onView(ViewMatchers.withId(R.id.recyclerView))
            .perform(RecyclerViewActions.actionOnHolderItem (object: BaseMatcher<MatchListAdapter.RowViewHolder>() {
                override fun describeTo(description: Description?) {

                }

                override fun matches(item: Any?): Boolean {
                    return item is MatchListAdapter.RowViewHolder
                }
            }, ViewActions.click()))

        Espresso.onView(ViewMatchers.withId(R.id.gameIdText)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

    @After
    fun tearDown(){
        mockWebServer.close()
    }
}