package com.fyber.inneractive.sdk.config;

/* loaded from: classes4.dex */
public final class p implements com.fyber.inneractive.sdk.network.e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f1110a;

    public p(s sVar) {
        this.f1110a = sVar;
    }

    @Override // com.fyber.inneractive.sdk.network.e0
    public final void a(Object obj, Exception exc, boolean z) {
        o oVar = (o) obj;
        if (oVar != null) {
            s sVar = this.f1110a;
            if (oVar.equals(sVar.b)) {
                return;
            }
            sVar.d = true;
            sVar.b = oVar;
            com.fyber.inneractive.sdk.util.r.f1777a.execute(new q(sVar));
        }
    }
}
