package com.example.example_sms_app.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val message = Telephony.Sms.Intents.getMessagesFromIntent(intent).first()
        Log.d("SmsReceiver", "onReceive: ${message.displayMessageBody}")
    }
}
