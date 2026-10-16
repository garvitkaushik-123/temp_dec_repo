package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzhbw extends RuntimeException {
    public zzhbw(zzhas zzhasVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzgzw zza() {
        return new zzgzw(getMessage());
    }
}
