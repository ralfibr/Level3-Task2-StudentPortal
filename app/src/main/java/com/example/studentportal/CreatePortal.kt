package com.example.studentportal
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_create_portal.*


/**
 * Create Portal page
 */
const val EXTRA_PORTAL = "EXTRA_PORTAL"
class CreatePortal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_portal)
        initView()
    }
   private  fun initView () {
       addPortalbtn.setOnClickListener { onAddPortal() }
   }
    // On add Portal send Intent extra to main
    private fun onAddPortal() {
        if (!editTextTitle.text.isNullOrBlank() && !editTextUrl.text.isNullOrBlank()) {
            val portal = Portal(
                editTextTitle.text.toString(),
                editTextUrl.text.toString()
            )
            val intent = Intent()
            intent.putExtra(EXTRA_PORTAL, portal)
            setResult(Activity.RESULT_OK, intent)
            finish()
        } else {
            Toast.makeText(this,"The portal cannot be empty"
                , Toast.LENGTH_SHORT).show()
        }

    }

}
