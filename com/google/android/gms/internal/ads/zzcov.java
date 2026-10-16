package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcov extends zzcos {
    private final Context zzc;
    private final View zzd;
    private final zzcfg zze;
    private final zzfcb zzf;
    private final zzcqy zzg;
    private final zzdje zzh;
    private final zzdef zzi;
    private final zzhgl zzj;
    private final Executor zzk;
    private com.google.android.gms.ads.internal.client.zzr zzl;

    zzcov(zzcqz zzcqzVar, Context context, zzfcb zzfcbVar, View view, zzcfg zzcfgVar, zzcqy zzcqyVar, zzdje zzdjeVar, zzdef zzdefVar, zzhgl zzhglVar, Executor executor) {
        super(zzcqzVar);
        this.zzc = context;
        this.zzd = view;
        this.zze = zzcfgVar;
        this.zzf = zzfcbVar;
        this.zzg = zzcqyVar;
        this.zzh = zzdjeVar;
        this.zzi = zzdefVar;
        this.zzj = zzhglVar;
        this.zzk = executor;
    }

    public static /* synthetic */ void zzj(zzcov zzcovVar) {
        zzbia zze = zzcovVar.zzh.zze();
        if (zze == null) {
            return;
        }
        try {
            zze.zze((com.google.android.gms.ads.internal.client.zzbx) zzcovVar.zzj.zzb(), ObjectWrapper.wrap(zzcovVar.zzc));
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("RemoteException when notifyAdLoad is called", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcos
    public final int zza() {
        return this.zza.zzb.zzb.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcos
    public final int zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzij)).booleanValue() && this.zzb.zzag) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzik)).booleanValue()) {
                return 0;
            }
        }
        return this.zza.zzb.zzb.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcos
    public final View zzd() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcos
    public final com.google.android.gms.ads.internal.client.zzed zze() {
        try {
            return this.zzg.zza();
        } catch (zzfdd unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcos
    public final zzfcb zzf() {
        com.google.android.gms.ads.internal.client.zzr zzrVar = this.zzl;
        if (zzrVar != null) {
            return zzfdc.zzb(zzrVar);
        }
        zzfca zzfcaVar = this.zzb;
        if (zzfcaVar.zzac) {
            for (String str : zzfcaVar.zza) {
                if (str == null || !str.contains("FirstParty")) {
                }
            }
            View view = this.zzd;
            return new zzfcb(view.getWidth(), view.getHeight(), false);
        }
        return (zzfcb) zzfcaVar.zzr.get(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcos
    public final zzfcb zzg() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzcos
    public final void zzh() {
        this.zzi.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcos
    public final void zzi(ViewGroup viewGroup, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        zzcfg zzcfgVar;
        if (viewGroup == null || (zzcfgVar = this.zze) == null) {
            return;
        }
        zzcfgVar.zzaj(zzchd.zzc(zzrVar));
        viewGroup.setMinimumHeight(zzrVar.zzc);
        viewGroup.setMinimumWidth(zzrVar.zzf);
        this.zzl = zzrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcra
    public final void zzk() {
        this.zzk.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcou
            @Override // java.lang.Runnable
            public final void run() {
                zzcov.zzj(zzcov.this);
            }
        });
        super.zzk();
    }
}
