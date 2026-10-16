package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcys implements Runnable {
    private final WeakReference zza;

    @Override // java.lang.Runnable
    public final void run() {
        zzcyv zzcyvVar = (zzcyv) this.zza.get();
        if (zzcyvVar != null) {
            zzcyvVar.zzq(new zzdbs() { // from class: com.google.android.gms.internal.ads.zzcyq
                @Override // com.google.android.gms.internal.ads.zzdbs
                public final void zza(Object obj) {
                    ((zzcyp) obj).zza();
                }
            });
        }
    }
}
