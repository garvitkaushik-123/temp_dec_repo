package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcq implements zzcn {
    private int zzb;
    private float zzc = 1.0f;
    private float zzd = 1.0f;
    private zzcl zze;
    private zzcl zzf;
    private zzcl zzg;
    private zzcl zzh;
    private boolean zzi;
    private zzcp zzj;
    private ByteBuffer zzk;
    private ShortBuffer zzl;
    private ByteBuffer zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;

    public zzcq() {
        zzcl zzclVar = zzcl.zza;
        this.zze = zzclVar;
        this.zzf = zzclVar;
        this.zzg = zzclVar;
        this.zzh = zzclVar;
        ByteBuffer byteBuffer = zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = byteBuffer;
        this.zzb = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final zzcl zza(zzcl zzclVar) throws zzcm {
        if (zzclVar.zzd != 2) {
            throw new zzcm("Unhandled input format:", zzclVar);
        }
        int i = this.zzb;
        if (i == -1) {
            i = zzclVar.zzb;
        }
        this.zze = zzclVar;
        zzcl zzclVar2 = new zzcl(i, zzclVar.zzc, 2);
        this.zzf = zzclVar2;
        this.zzi = true;
        return zzclVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final ByteBuffer zzb() {
        int zza;
        zzcp zzcpVar = this.zzj;
        if (zzcpVar != null && (zza = zzcpVar.zza()) > 0) {
            if (this.zzk.capacity() < zza) {
                ByteBuffer order = ByteBuffer.allocateDirect(zza).order(ByteOrder.nativeOrder());
                this.zzk = order;
                this.zzl = order.asShortBuffer();
            } else {
                this.zzk.clear();
                this.zzl.clear();
            }
            zzcpVar.zzd(this.zzl);
            this.zzo += zza;
            this.zzk.limit(zza);
            this.zzm = this.zzk;
        }
        ByteBuffer byteBuffer = this.zzm;
        this.zzm = zza;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final void zzc() {
        if (zzg()) {
            this.zzg = this.zze;
            this.zzh = this.zzf;
            if (this.zzi) {
                zzcl zzclVar = this.zzg;
                this.zzj = new zzcp(zzclVar.zzb, zzclVar.zzc, this.zzc, this.zzd, this.zzh.zzb);
            } else {
                zzcp zzcpVar = this.zzj;
                if (zzcpVar != null) {
                    zzcpVar.zzc();
                }
            }
        }
        this.zzm = zza;
        this.zzn = 0L;
        this.zzo = 0L;
        this.zzp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final void zzd() {
        zzcp zzcpVar = this.zzj;
        if (zzcpVar != null) {
            zzcpVar.zze();
        }
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final void zze(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            zzcp zzcpVar = this.zzj;
            zzcpVar.getClass();
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzn += remaining;
            zzcpVar.zzf(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final void zzf() {
        this.zzc = 1.0f;
        this.zzd = 1.0f;
        zzcl zzclVar = zzcl.zza;
        this.zze = zzclVar;
        this.zzf = zzclVar;
        this.zzg = zzclVar;
        this.zzh = zzclVar;
        ByteBuffer byteBuffer = zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = byteBuffer;
        this.zzb = -1;
        this.zzi = false;
        this.zzj = null;
        this.zzn = 0L;
        this.zzo = 0L;
        this.zzp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final boolean zzg() {
        if (this.zzf.zzb != -1) {
            return Math.abs(this.zzc + (-1.0f)) >= 1.0E-4f || Math.abs(this.zzd + (-1.0f)) >= 1.0E-4f || this.zzf.zzb != this.zze.zzb;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final boolean zzh() {
        if (!this.zzp) {
            return false;
        }
        zzcp zzcpVar = this.zzj;
        return zzcpVar == null || zzcpVar.zza() == 0;
    }

    public final long zzi(long j) {
        long j2 = this.zzo;
        if (j2 < 1024) {
            return (long) (this.zzc * j);
        }
        long j3 = this.zzn;
        this.zzj.getClass();
        long zzb = j3 - r2.zzb();
        int i = this.zzh.zzb;
        int i2 = this.zzg.zzb;
        return i == i2 ? zzex.zzu(j, zzb, j2, RoundingMode.DOWN) : zzex.zzu(j, zzb * i, j2 * i2, RoundingMode.DOWN);
    }

    public final void zzj(float f) {
        zzdd.zzd(f > 0.0f);
        if (this.zzd != f) {
            this.zzd = f;
            this.zzi = true;
        }
    }

    public final void zzk(float f) {
        zzdd.zzd(f > 0.0f);
        if (this.zzc != f) {
            this.zzc = f;
            this.zzi = true;
        }
    }
}
