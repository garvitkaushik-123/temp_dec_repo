package com.inmobi.media;

/* renamed from: com.inmobi.media.i0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2689i0 implements Va {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2786o0 f2592a;
    public final /* synthetic */ boolean b;

    public C2689i0(C2786o0 c2786o0, boolean z) {
        this.f2592a = c2786o0;
        this.b = z;
    }

    @Override // com.inmobi.media.Va
    public final void a(Object obj) {
        ((Boolean) obj).getClass();
        this.f2592a.a("result pushed to queue");
        if (this.b) {
            C2786o0 c2786o0 = this.f2592a;
            c2786o0.a("session end - cleanup");
            c2786o0.g = null;
            c2786o0.f.clear();
            c2786o0.c.set(false);
            c2786o0.d.set(false);
        }
    }

    @Override // com.inmobi.media.Va
    public final void onError(Exception exc) {
        this.f2592a.a(exc, "error in pushing to queue");
    }
}
