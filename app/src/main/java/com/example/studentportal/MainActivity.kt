package com.example.studentportal
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

/**
 * @author Raeef Ibrahim
 * Student Nr 500766393
 */

class MainActivity : AppCompatActivity() {
    val ADD_PORTAL_REQUEST_CODE = 100
    private val portals = arrayListOf<Portal>()
    private  val portalAdapter = PortalAdapter(portals)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
       initView()
        addPortals()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun onStartCreatePortal() {
        val intent = Intent(this, CreatePortal::class.java)
        startActivityForResult(intent, ADD_PORTAL_REQUEST_CODE)

    }
    // add portals list
    private fun addPortals() {
        portals.add(Portal("HvA Roosters", "https://rooster.hva.nl/"))
        portals.add(Portal("SIS" , "https://sis.hva.nl/"))
        portals.add(Portal("HvA","https://hva.nl/"))
    }
    private fun initView() {
        rvPortals.adapter = portalAdapter
        rvPortals.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        fab.setOnClickListener { view ->
            onStartCreatePortal()
        }
        portalAdapter.notifyDataSetChanged()
    }
    // get the added portal
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                ADD_PORTAL_REQUEST_CODE -> {
                    val portal = data?.getParcelableExtra<Portal>(EXTRA_PORTAL)
                    portals.add(portal!!)
                    portalAdapter.notifyDataSetChanged()
                }
            }
        }
    }
}
