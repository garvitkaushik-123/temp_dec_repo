package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgpi extends RuntimeException {
    public zzgpi(String str) {
        super(str);
    }

    public static Object zza(zzgph zzgphVar) {
        try {
            return zzgphVar.zza();
        } catch (Exception e) {
            throw new zzgpi(e);
        }
    }

    public zzgpi(String str, Throwable th) {
        super(str, th);
    }

    public zzgpi(Throwable th) {
        super(th);
    }
}
