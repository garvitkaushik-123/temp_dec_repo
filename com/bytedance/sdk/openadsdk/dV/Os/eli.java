package com.bytedance.sdk.openadsdk.dV.Os;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public class eli {
    private final SharedPreferences eli;

    public eli(Context context) {
        this.eli = context.getSharedPreferences("pag_monitor_record", 0);
    }

    public long eli() {
        return this.eli.getLong("last_upload_time", 0L);
    }

    public void eli(long j) {
        SharedPreferences.Editor edit = this.eli.edit();
        edit.putLong("last_upload_time", j);
        edit.apply();
    }
}
