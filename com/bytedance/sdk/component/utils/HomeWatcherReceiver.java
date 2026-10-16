package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: classes3.dex */
public class HomeWatcherReceiver extends BroadcastReceiver {
    private eli eli;

    public interface eli {
        void DbA();

        void eli();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            Log.i("HomeReceiver", "onReceive: action: ".concat(String.valueOf(action)));
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                String stringExtra = intent.getStringExtra("reason");
                Log.i("HomeReceiver", "reason: ".concat(String.valueOf(stringExtra)));
                if ("homekey".equals(stringExtra)) {
                    Log.i("HomeReceiver", "homekey");
                    eli eliVar = this.eli;
                    if (eliVar != null) {
                        eliVar.eli();
                        return;
                    }
                    return;
                }
                if ("recentapps".equals(stringExtra)) {
                    Log.i("HomeReceiver", "long press home key or activity switch");
                    eli eliVar2 = this.eli;
                    if (eliVar2 != null) {
                        eliVar2.DbA();
                        return;
                    }
                    return;
                }
                if ("assist".equals(stringExtra)) {
                    Log.i("HomeReceiver", "assist");
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void eli(eli eliVar) {
        this.eli = eliVar;
    }
}
