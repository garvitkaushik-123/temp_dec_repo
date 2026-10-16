package com.mbridge.msdk.videocommon.download;

import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.n0;
import java.io.File;

/* compiled from: HTMLResourceManager.java */
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private String f5273a;

    /* compiled from: HTMLResourceManager.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public static f f5274a = new f(null);
    }

    /* synthetic */ f(e eVar) {
        this();
    }

    public static f a() {
        return a.f5274a;
    }

    public void b() {
        this.f5273a = com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_HTML);
    }

    private f() {
        b();
    }

    public String a(String str) {
        try {
            File file = new File(this.f5273a + RemoteSettings.FORWARD_SLASH_STRING + SameMD5.getMD5(b1.b(str)) + ".html");
            if (file.exists()) {
                return n0.e(file);
            }
            return null;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public String b(String str) {
        try {
            String str2 = this.f5273a + RemoteSettings.FORWARD_SLASH_STRING + SameMD5.getMD5(b1.b(str)) + ".html";
            File file = new File(str2);
            if (!file.exists()) {
                return null;
            }
            com.mbridge.msdk.setting.g d = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d != null && !TextUtils.isEmpty(d.T())) {
                com.mbridge.msdk.foundation.same.d.a(str, file);
            }
            return "file:////" + str2;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
