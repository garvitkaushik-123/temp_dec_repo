package com.fyber.inneractive.sdk.click;

/* loaded from: classes4.dex */
public final class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f1066a;
    public final /* synthetic */ r b;

    public n(r rVar, b bVar) {
        this.b = rVar;
        this.f1066a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o oVar = this.b.d;
        if (oVar != null) {
            oVar.a(this.f1066a);
        }
    }
}
