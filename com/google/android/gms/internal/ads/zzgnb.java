package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzgnb extends zzgfm {
    private final String zza;
    private final zzgvf zzb;

    /* synthetic */ zzgnb(String str, zzgvf zzgvfVar, zzgnc zzgncVar) {
        this.zza = str;
        this.zzb = zzgvfVar;
    }

    public final String toString() {
        String str = this.zza;
        int ordinal = this.zzb.ordinal();
        return String.format("(typeUrl=%s, outputPrefixType=%s)", str, ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK");
    }

    @Override // com.google.android.gms.internal.ads.zzgfm
    public final boolean zza() {
        return this.zzb != zzgvf.RAW;
    }
}
