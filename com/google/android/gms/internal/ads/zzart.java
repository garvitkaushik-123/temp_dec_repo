package com.google.android.gms.internal.ads;

import com.ironsource.C3040d4;
import java.nio.ByteBuffer;
import java.util.Date;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzart extends zzhga {
    private Date zzg;
    private Date zzh;
    private long zzi;
    private long zzj;
    private double zzk;
    private float zzl;
    private zzhgk zzm;
    private long zzn;

    public zzart() {
        super("mvhd");
        this.zzk = 1.0d;
        this.zzl = 1.0f;
        this.zzm = zzhgk.zza;
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.zzg + ";modificationTime=" + this.zzh + ";timescale=" + this.zzi + ";duration=" + this.zzj + ";rate=" + this.zzk + ";volume=" + this.zzl + ";matrix=" + this.zzm + ";nextTrackId=" + this.zzn + C3040d4.i.e;
    }

    public final long zzc() {
        return this.zzj;
    }

    public final long zzd() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzhfy
    public final void zze(ByteBuffer byteBuffer) {
        zzh(byteBuffer);
        if (zzg() == 1) {
            this.zzg = zzhgf.zza(zzarp.zzf(byteBuffer));
            this.zzh = zzhgf.zza(zzarp.zzf(byteBuffer));
            this.zzi = zzarp.zze(byteBuffer);
            this.zzj = zzarp.zzf(byteBuffer);
        } else {
            this.zzg = zzhgf.zza(zzarp.zze(byteBuffer));
            this.zzh = zzhgf.zza(zzarp.zze(byteBuffer));
            this.zzi = zzarp.zze(byteBuffer);
            this.zzj = zzarp.zze(byteBuffer);
        }
        this.zzk = zzarp.zzb(byteBuffer);
        byteBuffer.get(new byte[2]);
        this.zzl = ((short) ((r1[1] & 255) | ((short) (65280 & (r1[0] << 8))))) / 256.0f;
        zzarp.zzd(byteBuffer);
        zzarp.zze(byteBuffer);
        zzarp.zze(byteBuffer);
        this.zzm = new zzhgk(zzarp.zzb(byteBuffer), zzarp.zzb(byteBuffer), zzarp.zzb(byteBuffer), zzarp.zzb(byteBuffer), zzarp.zza(byteBuffer), zzarp.zza(byteBuffer), zzarp.zza(byteBuffer), zzarp.zzb(byteBuffer), zzarp.zzb(byteBuffer));
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.zzn = zzarp.zze(byteBuffer);
    }
}
