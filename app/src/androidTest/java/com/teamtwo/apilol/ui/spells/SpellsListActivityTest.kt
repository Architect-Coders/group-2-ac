package com.teamtwo.apilol.ui.spells

import android.app.Application
import android.content.Intent
import android.os.SystemClock
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.jakewharton.espresso.OkHttp3IdlingResource
import com.teamtwo.apilol.DaggerSpellsUiTestComponent
import com.teamtwo.apilol.R
import com.teamtwo.apilol.spellsListMock
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.time.ExperimentalTime

@RunWith(AndroidJUnit4::class)
class SpellsListActivityTest {

    @ExperimentalTime
    @get:Rule
    val activityTestRule = ActivityTestRule(SpellsLsitActivity::class.java, false, false)

    private lateinit var mockWebServer: MockWebServer
    private lateinit var idlingResource: IdlingResource


    @ExperimentalTime
    @Before
    fun setUp() {

        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as Application

        val component = DaggerSpellsUiTestComponent.factory().create(app)
        mockWebServer = component.mockWebServer
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(spellsListMock)
        )
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(spellsListMock)
        )

        idlingResource = OkHttp3IdlingResource.create("OkHttp", component.lolServiceManager.okHttpClient)
        IdlingRegistry.getInstance().register(idlingResource)

        val intent = Intent(instrumentation.targetContext, SpellsLsitActivity::class.java)
        activityTestRule.launchActivity(intent)
    }

    @ExperimentalTime
    @Test
    fun checkSpellList(){

        SystemClock.sleep(3000)

        Espresso.onView(ViewMatchers.withId(R.id.rvSpells))
            .check(
                ViewAssertions.matches(
                    atPosition(
                        0,
                        ViewMatchers.hasDescendant(ViewMatchers.withText("Barrier"))
                    )
                )
            );
    }

    @ExperimentalTime
    @Test
    fun clickOnMatchNavigatesToSpellDetail(){

        SystemClock.sleep(3000)

        Espresso.onView(ViewMatchers.withId(R.id.rvSpells))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0, ViewActions.click()
                ));

        Espresso.onView(ViewMatchers.withId(R.id.tvNameSpelL))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

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