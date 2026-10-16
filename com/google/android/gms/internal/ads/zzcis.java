package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcis implements zzexa {
    private final zzcio zza;
    private Context zzb;
    private String zzc;

    /* synthetic */ zzcis(zzcio zzcioVar, zzcjs zzcjsVar) {
        this.zza = zzcioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzexa
    public final zzexb zzc() {
        zzhgz.zzc(this.zzb, Context.class);
        zzhgz.zzc(this.zzc, String.class);
        return new zzcit(this.zza, this.zzb, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzexa
    public final /* bridge */ /* synthetic */ zzexa zza(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzexa
    public final /* bridge */ /* synthetic */ zzexa zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }
}
