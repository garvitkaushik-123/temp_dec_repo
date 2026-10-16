package com.mbridge.msdk.videocommon.download;

import android.net.Uri;
import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.n0;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.util.List;

/* compiled from: ResourceManager.java */
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private String f5275a;

    /* compiled from: ResourceManager.java */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        public static i f5276a = new i(null);
    }

    /* synthetic */ i(h hVar) {
        this();
    }

    public static i a() {
        return a.f5276a;
    }

    public void b() {
        this.f5275a = com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_RES);
    }

    private i() {
        b();
    }

    public String a(String str) {
        String str2;
        try {
            String str3 = this.f5275a + RemoteSettings.FORWARD_SLASH_STRING + SameMD5.getMD5(b1.b(str));
            List<String> queryParameters = Uri.parse(str).getQueryParameters(ResourceManager.KEY_INDEX_HTML);
            if (queryParameters == null || queryParameters.size() <= 0) {
                return null;
            }
            String str4 = queryParameters.get(0);
            if (TextUtils.isEmpty(str4)) {
                return null;
            }
            String str5 = str3 + RemoteSettings.FORWARD_SLASH_STRING + str4 + RemoteSettings.FORWARD_SLASH_STRING + str4 + ".html";
            if (!n0.e(str5)) {
                return null;
            }
            try {
                com.mbridge.msdk.setting.g d = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                if (d != null && !TextUtils.isEmpty(d.T())) {
                    com.mbridge.msdk.foundation.same.d.a(str, new File(str5));
                }
                str2 = str.substring(str.indexOf("?") + 1);
            } catch (Exception unused) {
                str2 = "";
            }
            return AdPayload.FILE_SCHEME + str5 + (TextUtils.isEmpty(str2) ? "" : "?" + str2);
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }
}
