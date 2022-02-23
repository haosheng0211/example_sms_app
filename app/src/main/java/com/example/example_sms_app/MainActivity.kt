package com.example.example_sms_app

import android.app.role.RoleManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Telephony
import android.provider.Telephony.Sms.Intents
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Telephony.Sms.getDefaultSmsPackage(this) != packageName) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
                val manager = getSystemService(RoleManager::class.java)
                val intent = manager.createRequestRoleIntent(RoleManager.ROLE_SMS)
                startActivityForResult(intent, 100)
            } else {
                val intent = Intent(Intents.ACTION_CHANGE_DEFAULT)
                intent.putExtra(Telephony.Sms.Intents.EXTRA_PACKAGE_NAME, packageName)
                startActivity(intent)
            }
        }
    }
}
