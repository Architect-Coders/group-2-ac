package com.teamtwo.apilol

import android.app.Application
import android.content.Intent
import android.os.SystemClock
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.jakewharton.espresso.OkHttp3IdlingResource
import com.teamtwo.apilol.model.LOLServiceManager
import com.teamtwo.apilol.ui.MainActivity
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import kotlin.time.ExperimentalTime

@RunWith(AndroidJUnit4::class)
class UiTest {

    @ExperimentalTime
    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, false, false)

    private lateinit var mockWebServer: MockWebServer

    @ExperimentalTime
    @Before
    fun setUp(){
        val instrumentation= InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as Application
        val component = DaggerUiTestComponent.factory().create(app)

        mockWebServer = component.mockWebServer

        val resource = OkHttp3IdlingResource.create("OkHttp", component.lolServiceManager.okHttpClient)
        IdlingRegistry.getInstance().register(resource)

        val intent = Intent(instrumentation.targetContext, MainActivity::class.java)

        activityTestRule.launchActivity(intent)
    }

    @ExperimentalTime
    @Test
    fun clickChampionsNavigateToChampionList_showsLoading(){
        onView(withId(R.id.btnCarlos)).perform(ViewActions.click())
        onView(withId(R.id.loading)).check(matches(isDisplayed()))
    }

    @ExperimentalTime
    @Test
    fun clickChampionsNavigateToChampionList(){
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(championListMock)
        )

        onView(withId(R.id.btnCarlos)).perform(ViewActions.click())

        SystemClock.sleep(1000)

        onView(withId(R.id.rvChampions)).check(matches(isDisplayed()))

    }


    @ExperimentalTime
    @Test
    fun clickSumonnersNavigateToSummonerActivity(){
        onView(withId(R.id.btnDaniel)).perform(ViewActions.click())
    }

    @ExperimentalTime
    @Test
    fun clickSummonerNavigateToChampionList(){
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(summonerListMock)
        )

        onView(withId(R.id.btnDaniel)).perform(ViewActions.click())

        SystemClock.sleep(1000)

        onView(withId(R.id.etSummoner)).check(matches(isDisplayed()))

    }

    @After
    fun tearDown(){
        mockWebServer.close()
    }

}