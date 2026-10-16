package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public class zzhfz extends zzhgc implements zzarq {
    protected final String zza = "moov";

    public zzhfz(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzarq
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzarq
    public final void zzb(zzhgd zzhgdVar, ByteBuffer byteBuffer, long j, zzarn zzarnVar) throws IOException {
        zzhgdVar.zzb();
        byteBuffer.remaining();
        byteBuffer.remaining();
        this.zzc = zzhgdVar;
        this.zze = zzhgdVar.zzb();
        zzhgdVar.zze(zzhgdVar.zzb() + j);
        this.zzf = zzhgdVar.zzb();
        this.zzb = zzarnVar;
    }
}
