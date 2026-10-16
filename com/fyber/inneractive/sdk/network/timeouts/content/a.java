package com.fyber.inneractive.sdk.network.timeouts.content;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.global.features.j;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class a extends com.fyber.inneractive.sdk.network.timeouts.a {
    public final int h;

    public a(String str, String str2, int i, boolean z, String str3, r rVar) {
        int intValue;
        j jVar = (j) rVar.a(j.class);
        this.h = 0;
        Boolean c = jVar.c("reverse_retries");
        this.g = c != null ? c.booleanValue() : true;
        if (z) {
            intValue = jVar.b(str, str3);
        } else if (TextUtils.isEmpty(str3)) {
            String str4 = str + "_global_timeout";
            int i2 = j.d(str) ? 30000 : 10000;
            Integer a2 = jVar.a(str4);
            intValue = a2 != null ? a2.intValue() : i2;
        } else {
            intValue = jVar.c(str, str3);
        }
        if (intValue > i) {
            if (TextUtils.isEmpty(str3)) {
                Integer a3 = jVar.a(j.a(str, str2, "retry_interval"));
                this.e = a3 != null ? a3.intValue() : 100;
                Integer a4 = jVar.a(j.a("timeout", "threshold"));
                this.f = a4 != null ? a4.intValue() : 300;
                String a5 = j.a(str, str2, "ilat");
                int i3 = j.d(str) ? 20000 : 10000;
                Integer a6 = jVar.a(a5);
                this.d = a6 != null ? a6.intValue() : i3;
            } else {
                String a7 = j.a(str, str2, "retry_interval", j.e(str3));
                Integer a8 = jVar.a(j.a("retry_interval", "all_mediators"));
                int intValue2 = a8 != null ? a8.intValue() : 100;
                Integer a9 = jVar.a(a7);
                this.e = a9 != null ? a9.intValue() : intValue2;
                String a10 = j.a("timeout", "threshold", j.e(str3));
                Integer a11 = jVar.a(j.a("timeout", "threshold", "all_mediators"));
                int intValue3 = a11 != null ? a11.intValue() : 300;
                Integer a12 = jVar.a(a10);
                this.f = a12 != null ? a12.intValue() : intValue3;
                String a13 = j.a(str, str2, "ilat", j.e(str3));
                String a14 = j.a(str, str2, "ilat", "all_mediators");
                int i4 = j.d(str) ? 20000 : 10000;
                Integer a15 = jVar.a(a14);
                i4 = a15 != null ? a15.intValue() : i4;
                Integer a16 = jVar.a(a13);
                this.d = a16 != null ? a16.intValue() : i4;
            }
        }
        int i5 = intValue - (this.f + i);
        IAlog.a("%s : LoadAdContentTimeout resolveLoadAdTimeout : usedTime: %d, global timeout: %d, timeout: %d", IAlog.a(a.class), Integer.valueOf(i), Integer.valueOf(intValue), Integer.valueOf(i5));
        this.c = Math.max(i5, 0);
        int a17 = a();
        this.f1338a = a17;
        if (a17 == 0) {
            this.d = this.c;
        }
        IAlog.a("%s : LoadAdContentTimeout onFixedLoadAdTimeoutUpdated : Calculated: %d attempts with LeftoverTime: %d", IAlog.a(this), Integer.valueOf(this.f1338a), 0);
        int i6 = this.f1338a;
        if (i6 > 0) {
            int i7 = this.c;
            int i8 = this.f;
            int i9 = this.e;
            for (int i10 = 0; i10 <= i6; i10++) {
                i7 -= (this.b * i10) + this.d;
            }
            this.h = Math.max(0, i7 - ((i9 * i6) + (i8 * i6)));
        }
    }
}
