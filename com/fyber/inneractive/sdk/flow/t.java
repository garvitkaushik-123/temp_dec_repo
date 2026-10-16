package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class t implements com.fyber.inneractive.sdk.network.e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f1239a;

    public t(u uVar) {
        this.f1239a = uVar;
    }

    @Override // com.fyber.inneractive.sdk.network.e0
    public final void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        IAlog.a("IAVideoContentLoader : Remote ui template callback onNetworkResult from cache: %s", Boolean.valueOf(z));
        if (exc instanceof com.fyber.inneractive.sdk.network.g) {
            return;
        }
        u uVar = this.f1239a;
        uVar.getClass();
        if (TextUtils.isEmpty(str) && z) {
            uVar.a(exc, "Fetched cached template is ".concat(str == null ? "null" : "empty"), true);
            return;
        }
        com.fyber.inneractive.sdk.player.ui.remote.g i = uVar.i();
        if (i == null) {
            uVar.a(null, "Flow Manager is null", z);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            boolean z2 = i.f1653a.i;
            uVar.a(exc, "Unknown error while receiving template: templateContent is: " + (TextUtils.isEmpty(str) ? "null or empty" : "not null and not empty") + " isFromCache: " + z2, z2);
            return;
        }
        com.fyber.inneractive.sdk.player.ui.remote.d dVar = i.f1653a;
        dVar.i = z;
        IAlog.a("%s : schedule UI load timeout task with delay: %d", "RemoteUIWebviewController", 10000);
        com.fyber.inneractive.sdk.util.r.b.postDelayed(dVar.k, 10000);
        try {
            dVar.b.loadData(str, "text/html", "UTF-8");
        } catch (Throwable th) {
            IAlog.a("%s : cancel UI load timeout task", "RemoteUIWebviewController");
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(dVar.k);
            dVar.a(com.fyber.inneractive.sdk.network.events.b.WEB_VIEW_CRASH_ERROR, "Unable load data: " + th.getMessage(), true, null);
        }
    }
}
