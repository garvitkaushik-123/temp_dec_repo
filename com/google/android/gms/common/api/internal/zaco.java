package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
final class zaco implements Runnable {
    final /* synthetic */ com.google.android.gms.signin.internal.zak zaa;
    final /* synthetic */ zacq zab;

    zaco(zacq zacqVar, com.google.android.gms.signin.internal.zak zakVar) {
        this.zaa = zakVar;
        this.zab = zacqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zacq.zad(this.zab, this.zaa);
    }
}
