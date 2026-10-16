package com.google.android.gms.internal.ads;

import io.bidmachine.media3.exoplayer.dash.DashMediaSource;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.Inflater;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzama implements zzakt {
    private final zzen zza = new zzen();
    private final zzen zzb = new zzen();
    private final zzalz zzc;
    private Inflater zzd;

    public zzama(List list) {
        zzalz zzalzVar = new zzalz();
        this.zzc = zzalzVar;
        zzalzVar.zzb(new String((byte[]) list.get(0), StandardCharsets.UTF_8));
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final void zza(byte[] bArr, int i, int i2, zzaks zzaksVar, zzdn zzdnVar) {
        zzen zzenVar = this.zza;
        zzenVar.zzJ(bArr, i2 + i);
        zzenVar.zzL(i);
        if (this.zzd == null) {
            this.zzd = new Inflater();
        }
        zzen zzenVar2 = this.zzb;
        if (zzex.zzO(zzenVar, zzenVar2, this.zzd)) {
            zzenVar.zzJ(zzenVar2.zzN(), zzenVar2.zzd());
        }
        zzalz zzalzVar = this.zzc;
        zzalzVar.zzd();
        int zza = zzenVar.zza();
        zzcu zzcuVar = null;
        if (zza >= 2 && zzenVar.zzq() == zza) {
            zzalzVar.zzc(zzenVar);
            zzcuVar = zzalzVar.zza(zzenVar);
        }
        zzdnVar.zza(new zzakl(zzcuVar != null ? zzfyq.zzo(zzcuVar) : zzfyq.zzn(), -9223372036854775807L, DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US));
    }
}
