package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzfva implements zzfvq {
    protected zzfva() {
    }

    public static zzfva zzc(char c) {
        return new zzfux(c);
    }

    @Override // com.google.android.gms.internal.ads.zzfvq
    @Deprecated
    public final /* synthetic */ boolean zza(Object obj) {
        return zzb(((Character) obj).charValue());
    }

    public abstract boolean zzb(char c);
}
