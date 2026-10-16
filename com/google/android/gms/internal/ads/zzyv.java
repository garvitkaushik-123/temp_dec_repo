package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzyv {
    public final zzbm zza;
    public final int[] zzb;

    public zzyv(zzbm zzbmVar, int[] iArr, int i) {
        if (iArr.length == 0) {
            zzea.zzd("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.zza = zzbmVar;
        this.zzb = iArr;
    }
}
