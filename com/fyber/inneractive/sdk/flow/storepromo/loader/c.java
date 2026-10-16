package com.fyber.inneractive.sdk.flow.storepromo.loader;

/* loaded from: classes4.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1220a;
    public final /* synthetic */ d b;

    public c(d dVar, String str) {
        this.b = dVar;
        this.f1220a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar = this.b.f1221a;
        String str = this.f1220a;
        com.fyber.inneractive.sdk.flow.storepromo.controller.webview.a aVar = fVar.f1223a;
        if (aVar != null) {
            try {
                aVar.loadDataWithBaseURL(null, str, "text/html", "UTF-8", null);
            } catch (Throwable th) {
                if (fVar.e != null) {
                    fVar.e.a(com.fyber.inneractive.sdk.network.events.b.WEB_VIEW_CRASH_ERROR, "Unable to load data: " + th.getMessage(), "");
                }
            }
        }
    }
}
