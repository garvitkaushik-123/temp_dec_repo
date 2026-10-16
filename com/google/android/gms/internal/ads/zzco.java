package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzco implements zzcn {
    protected zzcl zzb;
    protected zzcl zzc;
    private zzcl zzd;
    private zzcl zze;
    private ByteBuffer zzf;
    private ByteBuffer zzg;
    private boolean zzh;

    public zzco() {
        ByteBuffer byteBuffer = zza;
        this.zzf = byteBuffer;
        this.zzg = byteBuffer;
        zzcl zzclVar = zzcl.zza;
        this.zzd = zzclVar;
        this.zze = zzclVar;
        this.zzb = zzclVar;
        this.zzc = zzclVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final zzcl zza(zzcl zzclVar) throws zzcm {
        this.zzd = zzclVar;
        this.zze = zzi(zzclVar);
        return zzg() ? this.zze : zzcl.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public ByteBuffer zzb() {
        ByteBuffer byteBuffer = this.zzg;
        this.zzg = zza;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final void zzc() {
        this.zzg = zza;
        this.zzh = false;
        this.zzb = this.zzd;
        this.zzc = this.zze;
        zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final void zzd() {
        this.zzh = true;
        zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final void zzf() {
        ByteBuffer byteBuffer = zza;
        this.zzg = byteBuffer;
        this.zzh = false;
        this.zzf = byteBuffer;
        zzcl zzclVar = zzcl.zza;
        this.zzd = zzclVar;
        this.zze = zzclVar;
        this.zzb = zzclVar;
        this.zzc = zzclVar;
        zzm();
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public boolean zzg() {
        return this.zze != zzcl.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public boolean zzh() {
        return this.zzh && this.zzg == zza;
    }

    protected zzcl zzi(zzcl zzclVar) throws zzcm {
        throw null;
    }

    protected final ByteBuffer zzj(int i) {
        if (this.zzf.capacity() < i) {
            this.zzf = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.zzf.clear();
        }
        ByteBuffer byteBuffer = this.zzf;
        this.zzg = byteBuffer;
        return byteBuffer;
    }

    protected void zzk() {
    }

    protected void zzl() {
    }

    protected void zzm() {
    }

    protected final boolean zzn() {
        return this.zzg.hasRemaining();
    }
}
