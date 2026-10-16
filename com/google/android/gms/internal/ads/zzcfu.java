package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final /* synthetic */ class zzcfu implements Runnable {
    public final /* synthetic */ zzcfg zza;

    public /* synthetic */ zzcfu(zzcfg zzcfgVar) {
        this.zza = zzcfgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.destroy();
    }
}
