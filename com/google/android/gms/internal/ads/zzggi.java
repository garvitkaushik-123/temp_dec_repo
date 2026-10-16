package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzggi extends zzgfz {
    private final zzggr zza;
    private final zzgxf zzb;
    private final zzgxf zzc;
    private final zzgxe zzd;

    @Nullable
    private final Integer zze;

    /* synthetic */ zzggi(zzggr zzggrVar, zzgxf zzgxfVar, zzgxf zzgxfVar2, zzgxe zzgxeVar, Integer num, zzggh zzgghVar) {
        this.zza = zzggrVar;
        this.zzb = zzgxfVar;
        this.zzc = zzgxfVar2;
        this.zzd = zzgxeVar;
        this.zze = num;
    }

    public static zzggg zzc() {
        return new zzggg(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgfz, com.google.android.gms.internal.ads.zzgez
    public final /* synthetic */ zzgfm zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final zzgxe zzb() {
        return this.zzd;
    }

    public final zzggr zzd() {
        return this.zza;
    }

    public final zzgxf zze() {
        return this.zzb;
    }

    public final zzgxf zzf() {
        return this.zzc;
    }

    @Nullable
    public final Integer zzg() {
        return this.zze;
    }
}
