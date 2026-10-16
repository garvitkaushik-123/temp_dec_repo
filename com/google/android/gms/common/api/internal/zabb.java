package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
final class zabb extends zabu {
    private final WeakReference zaa;

    zabb(zabc zabcVar) {
        this.zaa = new WeakReference(zabcVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabu
    public final void zaa() {
        zabc zabcVar = (zabc) this.zaa.get();
        if (zabcVar == null) {
            return;
        }
        zabc.zai(zabcVar);
    }
}
