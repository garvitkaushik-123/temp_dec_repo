package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.core.model.ev;

/* loaded from: classes3.dex */
public class Os extends nlS {
    public Os(Context context) {
        super(context);
        this.DbA = false;
    }

    @Override // com.bytedance.sdk.openadsdk.common.nlS
    public void eli() {
        post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.Os.1
            @Override // java.lang.Runnable
            public void run() {
                if (Os.this.eli != null) {
                    Os.this.setVisibility(0);
                }
            }
        });
    }

    public void eli(ev evVar, String str, int i, String str2, long j, boolean z, int i2, long j2) {
        if (getVisibility() != 8) {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(evVar, str, i, str2, SystemClock.elapsedRealtime() - j, z, i2, j2);
            super.DbA();
        }
    }
}
