package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcda extends zzarm {
    static final zzcda zzb = new zzcda();

    zzcda() {
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final zzarq zza(String str, byte[] bArr, String str2) {
        return "moov".equals(str) ? new zzars() : "mvhd".equals(str) ? new zzart() : new zzaru(str);
    }
}
