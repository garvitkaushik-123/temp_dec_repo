package com.fyber.inneractive.sdk.cache;

import android.app.Application;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.s;
import com.fyber.inneractive.sdk.network.t0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.o;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public long f1043a;
    public String b;
    public String c;
    public String d;
    public String e;

    public final void a() {
        if (TimeUnit.MILLISECONDS.toMinutes(System.currentTimeMillis() - this.f1043a) >= 60) {
            IAConfigManager iAConfigManager = IAConfigManager.O;
            if (iAConfigManager.u.b.a(false, "use_js_inline")) {
                Application application = o.f1770a;
                if (application == null) {
                    IAlog.f("fetchJS() failed context null", new Object[0]);
                    return;
                }
                this.f1043a = System.currentTimeMillis();
                t0 t0Var = new t0(new f(this), application, new e("https://cdn2.inner-active.mobi/client/ia-js-tags/dt-mraid-video-controller.js", "dt-mraid-video-controller.js"));
                IAlog.d("%s- Loading URL: %s", IAlog.a(this), "https://cdn2.inner-active.mobi/client/ia-js-tags/dt-mraid-video-controller.js");
                iAConfigManager.s.b(t0Var);
                iAConfigManager.s.b(new t0(new g(this), application, new e("https://cdn2.inner-active.mobi/IA-JSTag/Production/centering_v1.css", "centering_v1.css")));
                iAConfigManager.s.b(new t0(new h(this), application, new e("https://cdn2.inner-active.mobi/IA-JSTag/Production/centering_v1.js", "centering_v1.js")));
                s sVar = iAConfigManager.u;
                if (sVar == null || !sVar.b.a(false, "dt_plbl")) {
                    return;
                }
                iAConfigManager.s.b(new t0(new i(this), application, new e("https://cdn2.inner-active.mobi/client/ia-js-tags/playable_detect.js", "playable_detect.js")));
            }
        }
    }
}
