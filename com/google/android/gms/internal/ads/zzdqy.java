package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbcj;
import io.bidmachine.protobuf.EventTypeExtended;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdqy implements zzcza, zzcxm, zzcwb, zzcws, com.google.android.gms.ads.internal.client.zza, zzdbm {
    private final zzbcc zza;
    private boolean zzb = false;

    public zzdqy(zzbcc zzbccVar, @Nullable zzezv zzezvVar) {
        this.zza = zzbccVar;
        zzbccVar.zzc(2);
        if (zzezvVar != null) {
            zzbccVar.zzc(EventTypeExtended.EVENT_TYPE_CLICK_BY_SOURCE_VALUE);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final synchronized void onAdClicked() {
        if (this.zzb) {
            this.zza.zzc(8);
        } else {
            this.zza.zzc(7);
            this.zzb = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzdD(com.google.android.gms.ads.internal.client.zze zzeVar) {
        switch (zzeVar.zza) {
            case 1:
                this.zza.zzc(101);
                break;
            case 2:
                this.zza.zzc(102);
                break;
            case 3:
                this.zza.zzc(5);
                break;
            case 4:
                this.zza.zzc(103);
                break;
            case 5:
                this.zza.zzc(104);
                break;
            case 6:
                this.zza.zzc(105);
                break;
            case 7:
                this.zza.zzc(106);
                break;
            default:
                this.zza.zzc(4);
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdn(zzbvq zzbvqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdo(final zzfcn zzfcnVar) {
        this.zza.zzb(new zzbcb() { // from class: com.google.android.gms.internal.ads.zzdqu
            @Override // com.google.android.gms.internal.ads.zzbcb
            public final void zza(zzbcj.zzt.zza zzaVar) {
                zzbcj.zza.zzb zzbM = zzaVar.zze().zzbM();
                zzbcj.zzi.zza zzbM2 = zzaVar.zze().zzad().zzbM();
                zzbM2.zzo(zzfcn.this.zzb.zzb.zzb);
                zzbM.zzT(zzbM2);
                zzaVar.zzG(zzbM);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzh() {
        this.zza.zzc(1109);
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzi(final zzbcj.zzb zzbVar) {
        zzbcb zzbcbVar = new zzbcb() { // from class: com.google.android.gms.internal.ads.zzdqx
            @Override // com.google.android.gms.internal.ads.zzbcb
            public final void zza(zzbcj.zzt.zza zzaVar) {
                zzaVar.zzJ(zzbcj.zzb.this);
            }
        };
        zzbcc zzbccVar = this.zza;
        zzbccVar.zzb(zzbcbVar);
        zzbccVar.zzc(1103);
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzj(final zzbcj.zzb zzbVar) {
        zzbcb zzbcbVar = new zzbcb() { // from class: com.google.android.gms.internal.ads.zzdqv
            @Override // com.google.android.gms.internal.ads.zzbcb
            public final void zza(zzbcj.zzt.zza zzaVar) {
                zzaVar.zzJ(zzbcj.zzb.this);
            }
        };
        zzbcc zzbccVar = this.zza;
        zzbccVar.zzb(zzbcbVar);
        zzbccVar.zzc(1102);
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzl(boolean z) {
        this.zza.zzc(true != z ? 1108 : 1107);
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzm(final zzbcj.zzb zzbVar) {
        zzbcb zzbcbVar = new zzbcb() { // from class: com.google.android.gms.internal.ads.zzdqw
            @Override // com.google.android.gms.internal.ads.zzbcb
            public final void zza(zzbcj.zzt.zza zzaVar) {
                zzaVar.zzJ(zzbcj.zzb.this);
            }
        };
        zzbcc zzbccVar = this.zza;
        zzbccVar.zzb(zzbcbVar);
        zzbccVar.zzc(1104);
    }

    @Override // com.google.android.gms.internal.ads.zzdbm
    public final void zzn(boolean z) {
        this.zza.zzc(true != z ? 1106 : 1105);
    }

    @Override // com.google.android.gms.internal.ads.zzcws
    public final synchronized void zzt() {
        this.zza.zzc(6);
    }

    @Override // com.google.android.gms.internal.ads.zzcxm
    public final void zzu() {
        this.zza.zzc(3);
    }
}
