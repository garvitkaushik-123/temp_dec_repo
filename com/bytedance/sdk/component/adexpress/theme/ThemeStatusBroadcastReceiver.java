package com.bytedance.sdk.component.adexpress.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {
    private WeakReference<eli> eli;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("theme_status_change", 0);
        WeakReference<eli> weakReference = this.eli;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.eli.get().onThemeChanged(intExtra);
    }

    public void eli(eli eliVar) {
        this.eli = new WeakReference<>(eliVar);
    }
}
