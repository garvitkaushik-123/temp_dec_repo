package com.fyber.inneractive.sdk.network;

import android.os.Build;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final String f1343a;
    public final HashMap b;
    public String c;

    public y(String str, String str2, String str3, Long l, String str4, String str5, String str6, String str7) {
        int i = com.fyber.inneractive.sdk.config.k.f1102a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
        String str8 = TextUtils.isEmpty(property) ? "https://" + IAConfigManager.O.i.f : Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$").matcher(property).matches() ? "https://" + property + "/simpleM2M/Event" : "https://" + property + ".inner-active.mobi/simpleM2M/Event";
        this.c = null;
        if (TextUtils.isEmpty(str8)) {
            throw new InvalidParameterException();
        }
        this.b = new HashMap();
        this.f1343a = str8;
        a(str7 == null ? "8.3.8" : str7, N6.V);
        a(com.fyber.inneractive.sdk.util.o.f1770a.getPackageName(), "pkgn");
        if (IAConfigManager.d()) {
            return;
        }
        a(C3040d4.d, "osn");
        a(Build.VERSION.RELEASE, "osv");
        a(com.fyber.inneractive.sdk.util.k.j(), N6.B);
        a(com.fyber.inneractive.sdk.util.k.l(), "pkgv");
        a(str, "appid");
        a(str2, "session");
        a(str3, "adnt");
        a(l, "adnt_id");
        a(str4, CampaignEx.JSON_KEY_CREATIVE_ID);
        a(str5, "adomain");
        a(str6, FirebaseAnalytics.Param.CAMPAIGN_ID);
    }

    public final void a(Object obj, String str) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.b.put(str, obj);
    }
}
