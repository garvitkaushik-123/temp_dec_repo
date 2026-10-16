package com.apm.insight;

import android.text.TextUtils;
import com.ironsource.C3114ha;
import org.json.JSONArray;

/* compiled from: CrashCallbackWrapper.java */
/* loaded from: classes2.dex */
public final class b implements ICrashCallback, IOOMCallback {

    /* renamed from: a, reason: collision with root package name */
    private IOOMCallback f208a;
    private ICrashCallback b;
    private String c;

    @Override // com.apm.insight.ICrashCallback
    public final void onCrash(CrashType crashType, String str, Thread thread) {
    }

    @Override // com.apm.insight.IOOMCallback
    public final void onCrash(CrashType crashType, Throwable th, Thread thread, long j) {
    }

    public b(String str, ICrashCallback iCrashCallback) {
        this.c = str;
        this.b = iCrashCallback;
    }

    public b(String str, IOOMCallback iOOMCallback) {
        this.c = str;
        this.f208a = iOOMCallback;
    }

    public final void a(CrashType crashType, Throwable th, Thread thread, long j, JSONArray jSONArray) {
        CrashType crashType2;
        Throwable th2;
        Thread thread2;
        long j2;
        if (this.f208a == null || jSONArray == null) {
            return;
        }
        int i = 0;
        while (i < jSONArray.length()) {
            if (TextUtils.equals(a.a(jSONArray.optJSONObject(i), "header", C3114ha.b), this.c)) {
                crashType2 = crashType;
                th2 = th;
                thread2 = thread;
                j2 = j;
                this.f208a.onCrash(crashType2, th2, thread2, j2);
            } else {
                crashType2 = crashType;
                th2 = th;
                thread2 = thread;
                j2 = j;
            }
            i++;
            crashType = crashType2;
            th = th2;
            thread = thread2;
            j = j2;
        }
    }

    public final void a(CrashType crashType, String str, Thread thread, JSONArray jSONArray) {
        if (this.b == null || jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            if (TextUtils.equals(a.a(jSONArray.optJSONObject(i), "header", C3114ha.b), this.c)) {
                this.b.onCrash(crashType, str, thread);
            }
        }
    }

    public final void a(CrashType crashType, String str, String str2, String str3) {
        d a2;
        if (this.b == null || (a2 = d.a(this.c)) == null || !a2.a(str3, str2)) {
            return;
        }
        this.b.onCrash(crashType, str, null);
    }
}
