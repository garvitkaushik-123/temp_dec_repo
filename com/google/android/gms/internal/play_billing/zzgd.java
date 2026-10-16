package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes5.dex */
final class zzgd implements zzgw {
    private static final zzgj zza = new zzgb();
    private final zzgj zzb;

    public zzgd() {
        zzgj zzgjVar = zza;
        int i = zzgs.zza;
        zzgc zzgcVar = new zzgc(zzfd.zza(), zzgjVar);
        byte[] bArr = zzfo.zzb;
        this.zzb = zzgcVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgw
    public final zzgv zza(Class cls) {
        int i = zzgx.zza;
        if (!zzfi.class.isAssignableFrom(cls)) {
            int i2 = zzgs.zza;
        }
        zzgi zzb = this.zzb.zzb(cls);
        if (zzb.zzb()) {
            int i3 = zzgs.zza;
            return zzgp.zzc(zzgx.zzm(), zzex.zza(), zzb.zza());
        }
        int i4 = zzgs.zza;
        return zzgo.zzl(cls, zzb, zzgr.zza(), zzfz.zza(), zzgx.zzm(), zzb.zzc() + (-1) != 1 ? zzex.zza() : null, zzgh.zza());
    }
}
