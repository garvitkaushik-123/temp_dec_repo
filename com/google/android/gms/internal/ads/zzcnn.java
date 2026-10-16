package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcnn implements zzazd, zzcwt, com.google.android.gms.ads.internal.overlay.zzr, zzcws {
    private final zzcni zza;
    private final zzcnj zzb;
    private final zzbpi zzd;
    private final Executor zze;
    private final Clock zzf;
    private final Set zzc = new HashSet();
    private final AtomicBoolean zzg = new AtomicBoolean(false);
    private final zzcnm zzh = new zzcnm();
    private boolean zzi = false;
    private WeakReference zzj = new WeakReference(this);

    public zzcnn(zzbpf zzbpfVar, zzcnj zzcnjVar, Executor executor, zzcni zzcniVar, Clock clock) {
        this.zza = zzcniVar;
        zzboq zzboqVar = zzbot.zza;
        this.zzd = zzbpfVar.zza("google.afma.activeView.handleUpdate", zzboqVar, zzboqVar);
        this.zzb = zzcnjVar;
        this.zze = executor;
        this.zzf = clock;
    }

    private final void zzk() {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            this.zza.zzf((zzcfg) it.next());
        }
        this.zza.zze();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzd() {
        this.zzh.zzb = false;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final synchronized void zzdj(Context context) {
        this.zzh.zze = "u";
        zzg();
        zzk();
        this.zzi = true;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzdk() {
        this.zzh.zzb = true;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final synchronized void zzdl(Context context) {
        this.zzh.zzb = true;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final synchronized void zzdm(Context context) {
        this.zzh.zzb = false;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final synchronized void zzdr(zzazc zzazcVar) {
        zzcnm zzcnmVar = this.zzh;
        zzcnmVar.zza = zzazcVar.zzj;
        zzcnmVar.zzf = zzazcVar;
        zzg();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzds() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdt() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdv() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void zzdw(int i) {
    }

    public final synchronized void zzg() {
        if (this.zzj.get() == null) {
            zzj();
            return;
        }
        if (this.zzi || !this.zzg.get()) {
            return;
        }
        try {
            zzcnm zzcnmVar = this.zzh;
            zzcnmVar.zzd = this.zzf.elapsedRealtime();
            final JSONObject zzb = this.zzb.zzb(zzcnmVar);
            for (final zzcfg zzcfgVar : this.zzc) {
                this.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcnl
                    @Override // java.lang.Runnable
                    public final void run() {
                        JSONObject jSONObject = zzb;
                        String str = "Calling AFMA_updateActiveView(" + jSONObject.toString() + ")";
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zze(str);
                        zzcfgVar.zzp("AFMA_updateActiveView", jSONObject);
                    }
                });
            }
            zzcai.zzb(this.zzd.zzc(zzb), "ActiveViewListener.callActiveViewJs");
        } catch (Exception e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Failed to call ActiveViewJS", e);
        }
    }

    public final synchronized void zzh(zzcfg zzcfgVar) {
        this.zzc.add(zzcfgVar);
        this.zza.zzd(zzcfgVar);
    }

    public final void zzi(Object obj) {
        this.zzj = new WeakReference(obj);
    }

    public final synchronized void zzj() {
        zzk();
        this.zzi = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcws
    public final synchronized void zzt() {
        if (this.zzg.compareAndSet(false, true)) {
            this.zza.zzc(this);
            zzg();
        }
    }
}
