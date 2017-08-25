package org.gosky.nga.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_test.*
import org.gosky.nga.R


class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_test)
        val originalStr5 = "[del]alsdkjfalksjdf[/del]"
        frtv.setText(originalStr5)
    }
}
