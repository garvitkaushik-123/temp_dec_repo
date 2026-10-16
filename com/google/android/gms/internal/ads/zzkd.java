package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzkd implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, zzacj, zzqh, zzxn, zzuf, zzhw {
    public static final /* synthetic */ int zzb = 0;
    final /* synthetic */ zzkh zza;

    /* synthetic */ zzkd(zzkh zzkhVar, zzkg zzkgVar) {
        Objects.requireNonNull(zzkhVar);
        this.zza = zzkhVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzkh zzkhVar = this.zza;
        zzkh.zzP(zzkhVar, surfaceTexture);
        zzkhVar.zzac(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzkh zzkhVar = this.zza;
        zzkhVar.zzae(null);
        zzkhVar.zzac(0, 0);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        this.zza.zzac(i, i2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.zza.zzac(i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.zza.zzac(0, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zza(Exception exc) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzw(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzb(String str, long j, long j2) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzx(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzc(String str) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzy(str);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzd(zzid zzidVar) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzz(zzidVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zze(zzid zzidVar) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzA(zzidVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzf(zzz zzzVar, zzie zzieVar) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzB(zzzVar, zzieVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzg(long j) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzC(j);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzh(final int i) {
        zzdi zzdiVar;
        zzdiVar = this.zza.zzA;
        zzdiVar.zzf(new zzfve() { // from class: com.google.android.gms.internal.ads.zzjz
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                int i2 = zzkd.zzb;
                return Integer.valueOf(i);
            }
        }, new zzfve() { // from class: com.google.android.gms.internal.ads.zzka
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                int i2 = zzkd.zzb;
                return Integer.valueOf(i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzi(Exception exc) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzD(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzj(zzqi zzqiVar) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzE(zzqiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzk(zzqi zzqiVar) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzF(zzqiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzl(int i, long j, long j2) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzG(i, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final void zzm(int i, long j) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzH(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final void zzn(Object obj, long j) {
        zzmo zzmoVar;
        Object obj2;
        zzdz zzdzVar;
        zzkh zzkhVar = this.zza;
        zzmoVar = zzkhVar.zzr;
        zzmoVar.zzI(obj, j);
        obj2 = zzkhVar.zzJ;
        if (obj2 == obj) {
            zzdzVar = zzkhVar.zzm;
            zzdzVar.zzd(26, new zzdw() { // from class: com.google.android.gms.internal.ads.zzjy
                @Override // com.google.android.gms.internal.ads.zzdw
                public final void zza(Object obj3) {
                }
            });
            zzdzVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzo(final boolean z) {
        boolean z2;
        zzdz zzdzVar;
        zzkh zzkhVar = this.zza;
        z2 = zzkhVar.zzP;
        if (z2 == z) {
            return;
        }
        zzkhVar.zzP = z;
        zzdzVar = zzkhVar.zzm;
        zzdzVar.zzd(23, new zzdw() { // from class: com.google.android.gms.internal.ads.zzkb
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                int i = zzkd.zzb;
                ((zzbe) obj).zzo(z);
            }
        });
        zzdzVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final void zzp(Exception exc) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzK(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final void zzq(String str, long j, long j2) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzL(str, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final void zzr(String str) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzM(str);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final void zzs(zzid zzidVar) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzN(zzidVar);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final void zzt(zzid zzidVar) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzO(zzidVar);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final void zzu(long j, int i) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzP(j, i);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final void zzv(zzz zzzVar, zzie zzieVar) {
        zzmo zzmoVar;
        zzmoVar = this.zza.zzr;
        zzmoVar.zzQ(zzzVar, zzieVar);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final void zzw(final zzcd zzcdVar) {
        zzdz zzdzVar;
        zzdzVar = this.zza.zzm;
        zzdzVar.zzd(25, new zzdw() { // from class: com.google.android.gms.internal.ads.zzkc
            @Override // com.google.android.gms.internal.ads.zzdw
            public final void zza(Object obj) {
                int i = zzkd.zzb;
                ((zzbe) obj).zzs(zzcd.this);
            }
        });
        zzdzVar.zzc();
    }
}
