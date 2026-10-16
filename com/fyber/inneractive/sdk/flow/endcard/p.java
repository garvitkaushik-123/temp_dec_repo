package com.fyber.inneractive.sdk.flow.endcard;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class p extends u {
    public final String j;
    public String k;
    public boolean l;

    public p(o oVar) {
        super(oVar);
        com.fyber.inneractive.sdk.model.vast.o oVar2 = oVar.c.e.f;
        this.j = oVar2 != null ? oVar2.f1291a : null;
    }

    public final void b(com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a aVar) {
        if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(this.k)) {
            return;
        }
        if (this.f || !this.h.compareAndSet(false, true)) {
            IAlog.a("%sisWebLoaded: %s, mFmpEndCardPrepareInProgress: %s", this.f1183a, Boolean.valueOf(this.f), Boolean.valueOf(this.h.get()));
        } else {
            a(aVar);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.u
    public final q d() {
        b bVar = this.b;
        return new q(bVar.c.e, (o) bVar);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.u
    public final boolean f() {
        return false;
    }
}
