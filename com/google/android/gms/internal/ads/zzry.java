package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzry extends zzco {
    private int zzd;
    private int zze;
    private boolean zzf;
    private int zzg;
    private byte[] zzh = zzex.zzb;
    private int zzi;
    private long zzj;

    @Override // com.google.android.gms.internal.ads.zzco, com.google.android.gms.internal.ads.zzcn
    public final ByteBuffer zzb() {
        int i;
        if (super.zzh() && (i = this.zzi) > 0) {
            zzj(i).put(this.zzh, 0, this.zzi).flip();
            this.zzi = 0;
        }
        return super.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcn
    public final void zze(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        if (i == 0) {
            return;
        }
        int min = Math.min(i, this.zzg);
        this.zzj += min / this.zzb.zze;
        this.zzg -= min;
        byteBuffer.position(position + min);
        if (this.zzg <= 0) {
            int i2 = i - min;
            int length = (this.zzi + i2) - this.zzh.length;
            ByteBuffer zzj = zzj(length);
            int i3 = this.zzi;
            String str = zzex.zza;
            int max = Math.max(0, Math.min(length, i3));
            zzj.put(this.zzh, 0, max);
            int max2 = Math.max(0, Math.min(length - max, i2));
            byteBuffer.limit(byteBuffer.position() + max2);
            zzj.put(byteBuffer);
            byteBuffer.limit(limit);
            int i4 = i2 - max2;
            int i5 = this.zzi - max;
            this.zzi = i5;
            byte[] bArr = this.zzh;
            System.arraycopy(bArr, max, bArr, 0, i5);
            byteBuffer.get(this.zzh, this.zzi, i4);
            this.zzi += i4;
            zzj.flip();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzco, com.google.android.gms.internal.ads.zzcn
    public final boolean zzh() {
        return super.zzh() && this.zzi == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final zzcl zzi(zzcl zzclVar) throws zzcm {
        if (!zzex.zzK(zzclVar.zzd)) {
            throw new zzcm("Unhandled input format:", zzclVar);
        }
        this.zzf = true;
        return (this.zzd == 0 && this.zze == 0) ? zzcl.zza : zzclVar;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    protected final void zzk() {
        if (this.zzf) {
            this.zzf = false;
            int i = this.zze;
            int i2 = this.zzb.zze;
            this.zzh = new byte[i * i2];
            this.zzg = this.zzd * i2;
        }
        this.zzi = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    protected final void zzl() {
        if (this.zzf) {
            if (this.zzi > 0) {
                this.zzj += r0 / this.zzb.zze;
            }
            this.zzi = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzco
    protected final void zzm() {
        this.zzh = zzex.zzb;
    }

    public final long zzo() {
        return this.zzj;
    }

    public final void zzp() {
        this.zzj = 0L;
    }

    public final void zzq(int i, int i2) {
        this.zzd = i;
        this.zze = i2;
    }
}
