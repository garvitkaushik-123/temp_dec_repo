package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbyk implements zzazd {
    private final Context zza;
    private final Object zzb;
    private final String zzc;
    private boolean zzd;

    public zzbyk(Context context, String str) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = str;
        this.zzd = false;
        this.zzb = new Object();
    }

    public final String zza() {
        return this.zzc;
    }

    public final void zzb(boolean z) {
        zzbyo zzo = com.google.android.gms.ads.internal.zzv.zzo();
        Context context = this.zza;
        if (zzo.zzp(context)) {
            synchronized (this.zzb) {
                if (this.zzd == z) {
                    return;
                }
                this.zzd = z;
                String str = this.zzc;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (this.zzd) {
                    com.google.android.gms.ads.internal.zzv.zzo().zzf(context, str);
                } else {
                    com.google.android.gms.ads.internal.zzv.zzo().zzg(context, str);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final void zzdr(zzazc zzazcVar) {
        zzb(zzazcVar.zzj);
    }
}
