package com.fyber.inneractive.sdk.util;

/* loaded from: classes4.dex */
public final class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.fyber.inneractive.sdk.cache.a f1764a;

    public l(com.fyber.inneractive.sdk.cache.a aVar) {
        this.f1764a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.fyber.inneractive.sdk.cache.a aVar;
        try {
            if (o.f1770a == null || (aVar = this.f1764a) == null) {
                return;
            }
            o.f1770a.getSharedPreferences("IAConfigurationPreferences", 0).edit().remove(aVar.b()).apply();
        } catch (Throwable unused) {
        }
    }
}
