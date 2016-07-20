package com.example.vharari.smsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if(bundle != null){
            Object[] pdus = (Object[])bundle.get("pdu");

            for (int i=0; i<pdus.length; i++){
                SmsMessage sms = SmsMessage.createFromPdu((byte[]) pdus[i]);
                String senderNumber = sms.getOriginatingAddress();
                String message = sms.getDisplayMessageBody();
                Toast.makeText(context, "From : "+senderNumber+" Message : "+message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
