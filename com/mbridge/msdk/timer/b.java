package com.mbridge.msdk.timer;

import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;

/* compiled from: TimerController.java */
/* loaded from: classes6.dex */
public class b {

    /* compiled from: TimerController.java */
    /* renamed from: com.mbridge.msdk.timer.b$b, reason: collision with other inner class name */
    static class C0402b {

        /* renamed from: a, reason: collision with root package name */
        static b f4920a = new b();
    }

    public static b getInstance() {
        return C0402b.f4920a;
    }

    public void addInterstitialList(String str, String str2) {
        try {
            com.mbridge.msdk.timer.a.a().a(str, str2);
        } catch (Exception e) {
            p0.b("TimerController", "addInterstitialList error:" + e.getMessage());
        }
    }

    public void addRewardList(String str, String str2) {
        try {
            com.mbridge.msdk.timer.a.a().b(str, str2);
        } catch (Exception e) {
            p0.b("TimerController", "addRewardList error:" + e.getMessage());
        }
    }

    public void start() {
        g d = h.b().d(c.m().b());
        if (d == null) {
            d = h.b().a();
        }
        if (d.h() > 0) {
            com.mbridge.msdk.timer.a.a().b(r0 * 1000);
        }
    }

    private b() {
    }
}
