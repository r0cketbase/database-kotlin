package com.rotor.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.rotor.core.Rotor
import com.rotor.core.interfaces.StatusListener
import com.rotor.database.Database
import com.rotor.database.abstr.Reference
import com.rotor.sample.model.Chat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Rotor.initialize(applicationContext, BuildConfig.database_url, BuildConfig.redis_url, object: StatusListener {
            override fun connected() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun reconnecting() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })

        Database.initialize()

        Database.listener("chat", object: Reference<Chat>() {

            override fun onCreate() {

            }

            override fun onUpdate(): Chat {
                return Chat("jj", HashMap())
            }

            override fun onChanged(ref: Chat) {

            }

            override fun progress(value: Int) {

            }

        })
    }

    override fun onResume() {
        super.onResume()
        Rotor.onResume()
    }

    override fun onPause() {
        Rotor.onPause()
        super.onPause()
    }
}