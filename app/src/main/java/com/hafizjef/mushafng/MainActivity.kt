package com.hafizjef.mushafng

import android.graphics.Color
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.hafizjef.mushafng.ui.base.controller.withFadeTransaction
import com.hafizjef.mushafng.ui.report.ReportController
import com.hafizjef.mushafng.ui.verify.VerifyController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val container by lazy { controller_container as ViewGroup }
    lateinit private var router: Router

    private var drawerArrow: DrawerArrowDrawable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        drawerArrow = DrawerArrowDrawable(this)
        drawerArrow?.color = Color.WHITE
        toolbar.navigationIcon = drawerArrow

        nav_view.setNavigationItemSelectedListener { item ->
            val id = item.itemId

            val currentRoot = router.backstack.firstOrNull()
            if (currentRoot?.tag()?.toIntOrNull() != id) {
                when (id) {
                    R.id.nav_drawer_verify -> {
                        setRoot(VerifyController(), id)
                        supportActionBar?.title = getString(R.string.view_verify)
                    }
                    R.id.nav_drawer_report -> {
                        setRoot(ReportController(), id)
                        supportActionBar?.title = getString(R.string.view_report)
                    }
                    R.id.nav_drawer_settings -> {
                        //router.pushController(SettingsMainController().withFadeTransaction())
                    }
                }
            }
            drawer.closeDrawer(GravityCompat.START)
            true
        }

        toolbar.setNavigationOnClickListener {
            if (router.backstackSize == 1) {
                drawer.openDrawer(GravityCompat.START)
            } else {
                onBackPressed()
            }
        }

        router = Conductor.attachRouter(this, container, savedInstanceState)

        if (!router.hasRootController()) {
            setRoot(VerifyController(), R.id.nav_drawer_verify)
            supportActionBar?.title = getString(R.string.view_verify)
        }
    }

    override fun onBackPressed() {
        if (!router.handleBack()) {
            super.onBackPressed()
        }
    }

    private fun setSelectedDrawerItem(itemId: Int) {
        if (!isFinishing) {
            nav_view.setCheckedItem(itemId)
            nav_view.menu.performIdentifierAction(itemId, 0)
        }
    }

    private fun setRoot(controller: Controller, id: Int) {
        router.setRoot(controller.withFadeTransaction().tag(id.toString()))
    }
}
