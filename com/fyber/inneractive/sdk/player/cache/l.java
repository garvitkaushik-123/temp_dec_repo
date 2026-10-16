package com.fyber.inneractive.sdk.player.cache;

import com.fyber.inneractive.sdk.network.z;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.File;

/* loaded from: classes4.dex */
public final class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f1354a;

    public l(m mVar) {
        this.f1354a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j;
        File a2 = m.a(this.f1354a.f1355a, "fyb.vamp.vid.cache");
        if (a2 != null) {
            try {
                IAlog.a("VideoCache opening the cache in directory - %s", a2);
                this.f1354a.b = f.b(a2);
                f fVar = this.f1354a.b;
                fVar.getClass();
                IAlog.e("DiskLruCache delete cache", new Object[0]);
                fVar.close();
                k.a(fVar.f1349a);
                this.f1354a.b = f.b(a2);
                f fVar2 = this.f1354a.b;
                synchronized (fVar2) {
                    j = fVar2.h;
                }
                IAlog.a("VideoCache opened the cache in directory - %s current size is %d", a2, Long.valueOf(j));
                m mVar = this.f1354a;
                mVar.b.l = mVar;
                mVar.c = true;
            } catch (Throwable th) {
                z.a("Failed to open cache directory", th.getMessage(), null, null);
                IAlog.a("Failed to open cache directory", th, new Object[0]);
            }
        }
    }
}
