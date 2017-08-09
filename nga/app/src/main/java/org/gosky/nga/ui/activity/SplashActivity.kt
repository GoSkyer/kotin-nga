package org.gosky.nga.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import jonathanfinerty.once.Once

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!Once.beenDone(Once.THIS_APP_INSTALL, "introductory")) {
            Once.markDone("introductory")
            val intent = Intent()
            intent.setClass(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            val lIntent = Intent(this, MainActivity::class.java)
            startActivity(lIntent)
            finish()
        }
    }
}