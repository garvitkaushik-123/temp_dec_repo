package com.fyber.inneractive.sdk.click;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.network.f1;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.f0;
import com.fyber.inneractive.sdk.util.t;
import com.fyber.inneractive.sdk.web.v0;
import com.ironsource.D5;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public Context f1067a;
    public String b;
    public final boolean c;
    public o d;
    public f1 h;
    public v0 j;
    public boolean k;
    public com.fyber.inneractive.sdk.ignite.m l;
    public volatile boolean e = false;
    public long g = 0;
    public final ArrayList i = new ArrayList();
    public final ArrayList f = new ArrayList();
    public final boolean m = IAConfigManager.O.u.b.a(false, "should_decode_url");

    public r(boolean z) {
        this.c = true;
        this.c = z;
    }

    public final void a(Context context, String str, o oVar, v0 v0Var, boolean z, com.fyber.inneractive.sdk.ignite.m mVar, String str2) {
        Uri uri;
        this.f1067a = context;
        this.b = str;
        this.d = oVar;
        this.k = z;
        this.g = System.currentTimeMillis();
        this.j = v0Var;
        this.l = mVar;
        b a2 = a(this.b);
        IAlog.d("%s EVENT_CLICK %s %s", "VAST_EVENT", a2, str);
        if (a2 == null) {
            String str3 = this.b;
            try {
                try {
                    uri = this.m ? !f0.c(str3) ? Uri.parse(URLDecoder.decode(str3, D5.N)) : Uri.parse(str3) : f0.c(str3) ? Uri.parse(URLDecoder.decode(str3, D5.N)) : Uri.parse(str3);
                } catch (Exception unused) {
                    IAlog.a("%sgetDecodedUri: Failed parsing Uri!", "SuperClickHandler");
                    uri = null;
                }
                if (a(uri)) {
                    IAlog.a("%sfollowRedirects: Fetching uri: %s", IAlog.a(this), uri.toString());
                    String uri2 = uri.toString();
                    f1 f1Var = new f1(new m(this, uri2, str2), uri2);
                    this.h = f1Var;
                    IAConfigManager.O.s.b(f1Var);
                }
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    return;
                }
                IAlog.b("%sfailed followRedirects %s", IAlog.a(this), e);
                this.f.add(new j(str3, false, q.INTERNAL_REDIRECT, null));
                a(new b(str3, q.FAILED, "followRedirects", e));
            }
        }
    }

    public final boolean a(Uri uri) {
        if (uri == null) {
            IAlog.a("%s followRedirects: Got a url which is not valid: null", IAlog.a(this));
            this.f.add(new j(null, false, null, "Invalid url"));
            a(a(uri.toString(), "followRedirects", "Invalid url"));
            return false;
        }
        String scheme = uri.getScheme();
        if (scheme != null && (scheme.equalsIgnoreCase("http") || scheme.equalsIgnoreCase("https"))) {
            return true;
        }
        IAlog.a("%scould not follow redirects for scheme: %s", IAlog.a(this), uri.getScheme());
        IAlog.a("%sfull url: %s", IAlog.a(this), uri.toString());
        this.f.add(new j(uri.toString(), false, null, "Invalid scheme: " + uri.getScheme()));
        a(a(uri.toString(), "followRedirects", "Invalid scheme: " + uri.getScheme()));
        return false;
    }

    public final b a(String str) {
        Uri uri;
        try {
            uri = Uri.parse(str);
        } catch (Exception unused) {
            IAlog.a("IAJavaUtil: getValidUri: Invalid url %s", str);
            uri = null;
        }
        if (uri == null) {
            this.f.add(new j(str, false, null, "illegal uri"));
            return a(a(str, null, "illegal uri"));
        }
        if (this.i.isEmpty()) {
            this.f.add(new j(str, false, null, "no click handlers found"));
            return a(a(str, null, "no click handlers found"));
        }
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.a(uri, this)) {
                Context context = this.f1067a;
                b a2 = context != null ? aVar.a(context, uri, this.f) : null;
                if (a2 != null) {
                    return a(a2);
                }
            }
        }
        return null;
    }

    public static void a(r rVar, String str, String str2, String str3, Exception exc) {
        if (rVar.c) {
            Intent intent = new Intent(rVar.f1067a, (Class<?>) InneractiveInternalBrowserActivity.class);
            if (!TextUtils.isEmpty(str)) {
                InneractiveInternalBrowserActivity.setHtmlExtra(str);
            }
            intent.putExtra(InneractiveInternalBrowserActivity.URL_EXTRA, str2);
            intent.putExtra("spotId", str3);
            if (!(rVar.f1067a instanceof Activity)) {
                intent.setFlags(268435456);
            }
            try {
                Context context = rVar.f1067a;
                if (context != null) {
                    context.startActivity(intent);
                }
                ArrayList arrayList = rVar.f;
                boolean z = exc == null;
                q qVar = q.OPENED_IN_INTERNAL_BROWSER;
                arrayList.add(new j(str2, z, qVar, t.a(exc)));
                rVar.a(new b(str2, qVar, "followRedirects", null));
                return;
            } catch (ActivityNotFoundException unused) {
                rVar.f.add(new j(str2, false, q.OPENED_IN_INTERNAL_BROWSER, "internal browser not registered"));
                rVar.a(a(str2, "followRedirects", "internal browser not registered"));
                return;
            }
        }
        rVar.f.add(new j(str2, false, q.OPENED_IN_INTERNAL_BROWSER, "internal browser not usable"));
        rVar.a(a(str2, "followRedirects", "internal browser not usable"));
    }

    public static b a(String str, String str2, String str3) {
        return new b(str, q.FAILED, str2, new p(str3));
    }

    public final b a(b bVar) {
        ArrayList arrayList = this.f;
        bVar.f.clear();
        bVar.f.addAll(arrayList);
        bVar.e = System.currentTimeMillis() - this.g;
        IAlog.a("%s reporting result: %s", IAlog.a(this), bVar);
        com.fyber.inneractive.sdk.util.r.b.post(new n(this, bVar));
        return bVar;
    }
}
