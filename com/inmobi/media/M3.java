package com.inmobi.media;

import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class M3 implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S3 f2359a;

    public M3(S3 s3) {
        this.f2359a = s3;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        synchronized (this.f2359a) {
            S3 s3 = this.f2359a;
            if (s3.j == null) {
                return null;
            }
            while (s3.i > s3.f) {
                s3.d((String) ((Map.Entry) s3.k.entrySet().iterator().next()).getKey());
            }
            if (this.f2359a.a()) {
                this.f2359a.d();
                this.f2359a.l = 0;
            }
            return null;
        }
    }
}
