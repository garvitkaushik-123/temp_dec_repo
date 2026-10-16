package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzabo implements zzcb {
    private final Context zza;
    private final zzca zzb;
    private final SparseArray zzc;
    private final boolean zzd;
    private final zzaco zze;
    private final zzdj zzf;
    private final CopyOnWriteArraySet zzg;
    private zzet zzh;
    private final zzz zzi;
    private final zzbv zzj;
    private final zzfyq zzk;
    private zzdt zzl;
    private Pair zzm;
    private int zzn;
    private int zzo;
    private long zzp;
    private long zzq;
    private int zzr;

    /* synthetic */ zzabo(zzabh zzabhVar, zzabn zzabnVar) {
        Context context;
        zzca zzcaVar;
        boolean z;
        zzdj zzdjVar;
        zzabs zzabsVar;
        context = zzabhVar.zza;
        this.zza = context;
        this.zzh = new zzet(10);
        zzcaVar = zzabhVar.zzc;
        zzdd.zzb(zzcaVar);
        this.zzb = zzcaVar;
        this.zzc = new SparseArray();
        this.zzk = zzfyq.zzn();
        this.zzj = zzbv.zza;
        z = zzabhVar.zzd;
        this.zzd = z;
        zzdjVar = zzabhVar.zze;
        this.zzf = zzdjVar;
        zzabsVar = zzabhVar.zzb;
        this.zze = new zzaar(zzabsVar, zzdjVar);
        new zzabg(this);
        this.zzg = new CopyOnWriteArraySet();
        this.zzi = new zzx().zzan();
        this.zzp = -9223372036854775807L;
        this.zzq = -9223372036854775807L;
        this.zzr = -1;
        this.zzo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final zzk zzA(zzk zzkVar) {
        return (zzkVar == null || !zzkVar.zzf()) ? zzk.zza : zzkVar;
    }

    public static /* synthetic */ void zzf(zzabo zzaboVar) {
        zzaboVar.zzn--;
    }

    static /* bridge */ /* synthetic */ void zzj(final zzabo zzaboVar, boolean z) {
        if (zzaboVar.zzo == 1) {
            zzaboVar.zzn++;
            zzaco zzacoVar = zzaboVar.zze;
            zzacoVar.zzj(z);
            while (zzaboVar.zzh.zza() > 1) {
                zzaboVar.zzh.zzb();
            }
            if (zzaboVar.zzh.zza() == 1) {
                zzabm zzabmVar = (zzabm) zzaboVar.zzh.zzb();
                zzabmVar.getClass();
                zzacoVar.zzl(1, zzaboVar.zzi, zzabmVar.zza, zzabmVar.zzb, zzfyq.zzn());
            }
            zzaboVar.zzp = -9223372036854775807L;
            zzaboVar.zzq = -9223372036854775807L;
            zzdt zzdtVar = zzaboVar.zzl;
            zzdd.zzb(zzdtVar);
            zzdtVar.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzabe
                @Override // java.lang.Runnable
                public final void run() {
                    zzabo.zzf(zzabo.this);
                }
            });
        }
    }

    static /* bridge */ /* synthetic */ boolean zzy(zzabo zzaboVar, zzz zzzVar, int i) {
        zzdd.zzf(zzaboVar.zzo == 0);
        zzk zzA = zzA(zzzVar.zzE);
        int i2 = zzA.zzd;
        try {
            if (i2 == 7) {
                if (Build.VERSION.SDK_INT < 34 && zzdr.zzb()) {
                    zzi zzc = zzA.zzc();
                    zzc.zzd(6);
                    zzA = zzc.zzg();
                    zzk zzkVar = zzA;
                    zzdj zzdjVar = zzaboVar.zzf;
                    Looper myLooper = Looper.myLooper();
                    zzdd.zzb(myLooper);
                    zzaboVar.zzl = zzdjVar.zzd(myLooper, null);
                    zzca zzcaVar = zzaboVar.zzb;
                    Context context = zzaboVar.zza;
                    zzn zznVar = zzn.zza;
                    final zzdt zzdtVar = zzaboVar.zzl;
                    Objects.requireNonNull(zzdtVar);
                    zzcaVar.zza(context, zzkVar, zznVar, zzaboVar, new Executor() { // from class: com.google.android.gms.internal.ads.zzabf
                        @Override // java.util.concurrent.Executor
                        public final void execute(Runnable runnable) {
                            zzdt.this.zzi(runnable);
                        }
                    }, zzaboVar.zzj, zzaboVar.zzk, 0L, false);
                    throw null;
                }
                i2 = 7;
            }
            zzca zzcaVar2 = zzaboVar.zzb;
            Context context2 = zzaboVar.zza;
            zzn zznVar2 = zzn.zza;
            final zzdt zzdtVar2 = zzaboVar.zzl;
            Objects.requireNonNull(zzdtVar2);
            zzcaVar2.zza(context2, zzkVar, zznVar2, zzaboVar, new Executor() { // from class: com.google.android.gms.internal.ads.zzabf
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    zzdt.this.zzi(runnable);
                }
            }, zzaboVar.zzj, zzaboVar.zzk, 0L, false);
            throw null;
        } catch (zzbw e) {
            throw new zzacn(e, zzzVar);
        }
        if (!zzdr.zzc(i2) && Build.VERSION.SDK_INT >= 29) {
            Object[] objArr = {Integer.valueOf(i2)};
            String str = zzex.zza;
            zzea.zzf("PlaybackVidGraphWrapper", String.format(Locale.US, "Color transfer %d is not supported. Falling back to OpenGl tone mapping.", objArr));
            zzA = zzk.zza;
        }
        zzk zzkVar2 = zzA;
        zzdj zzdjVar2 = zzaboVar.zzf;
        Looper myLooper2 = Looper.myLooper();
        zzdd.zzb(myLooper2);
        zzaboVar.zzl = zzdjVar2.zzd(myLooper2, null);
    }

    static /* bridge */ /* synthetic */ boolean zzz(zzabo zzaboVar) {
        int i = zzaboVar.zzr;
        return i != -1 && i == 0;
    }

    public final zzaco zze(int i) {
        SparseArray sparseArray = this.zzc;
        if (zzex.zzH(sparseArray, 0)) {
            return (zzaco) sparseArray.get(0);
        }
        zzabi zzabiVar = new zzabi(this, this.zza, 0);
        this.zzg.add(zzabiVar);
        sparseArray.put(0, zzabiVar);
        return zzabiVar;
    }

    public final void zzq() {
        zzeo zzeoVar = zzeo.zza;
        zzeoVar.zzb();
        zzeoVar.zza();
        this.zzm = null;
    }

    public final void zzr() {
        if (this.zzo == 2) {
            return;
        }
        zzdt zzdtVar = this.zzl;
        if (zzdtVar != null) {
            zzdtVar.zzf(null);
        }
        this.zzm = null;
        this.zzo = 2;
    }

    public final void zzs(Surface surface, zzeo zzeoVar) {
        Pair pair = this.zzm;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((zzeo) this.zzm.second).equals(zzeoVar)) {
            return;
        }
        this.zzm = Pair.create(surface, zzeoVar);
        zzeoVar.zzb();
        zzeoVar.zza();
    }

    public final void zzt(int i) {
        this.zzr = 1;
    }

    public final void zzu() {
        this.zze.zzx();
    }

    public final void zzv() {
        this.zze.zzy();
    }
}
