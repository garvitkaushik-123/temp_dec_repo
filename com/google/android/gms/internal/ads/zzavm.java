package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzavm implements zzavp {
    private static zzavm zzb;
    private final Context zzc;
    private final zzfpv zzd;
    private final zzfqc zze;
    private final zzfqe zzf;
    private final zzawr zzg;
    private final zzfoi zzh;
    private final Executor zzi;
    private final zzfqb zzj;
    private final zzaxg zzl;
    private final zzawy zzm;
    private final zzawp zzn;
    private volatile boolean zzp;
    private volatile boolean zzq;
    private final int zzr;
    volatile long zza = 0;
    private final Object zzo = new Object();
    private final CountDownLatch zzk = new CountDownLatch(1);

    zzavm(Context context, zzfoi zzfoiVar, zzfpv zzfpvVar, zzfqc zzfqcVar, zzfqe zzfqeVar, zzawr zzawrVar, Executor executor, zzfod zzfodVar, int i, zzaxg zzaxgVar, zzawy zzawyVar, zzawp zzawpVar) {
        this.zzq = false;
        this.zzc = context;
        this.zzh = zzfoiVar;
        this.zzd = zzfpvVar;
        this.zze = zzfqcVar;
        this.zzf = zzfqeVar;
        this.zzg = zzawrVar;
        this.zzi = executor;
        this.zzr = i;
        this.zzl = zzaxgVar;
        this.zzm = zzawyVar;
        this.zzn = zzawpVar;
        this.zzq = false;
        this.zzj = new zzavk(this, zzfodVar);
    }

    public static synchronized zzavm zza(Context context, zzarx zzarxVar, boolean z) {
        zzavm zzs;
        synchronized (zzavm.class) {
            zzfoj zzc = zzfok.zzc();
            zzc.zza(zzarxVar.zzf());
            zzc.zzg(zzarxVar.zzi());
            zzs = zzs(context, Executors.newCachedThreadPool(), zzc.zzh(), z);
        }
        return zzs;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x009a, code lost:
    
        if (r4.zzc().zzj().equals(r5.zzj()) != false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* bridge */ /* synthetic */ void zzj(zzavm zzavmVar) {
        String str;
        String str2;
        int length;
        boolean zza;
        long currentTimeMillis = System.currentTimeMillis();
        zzfpu zzu = zzavmVar.zzu(1);
        if (zzu != null) {
            String zzk = zzu.zza().zzk();
            str2 = zzu.zza().zzj();
            str = zzk;
        } else {
            str = null;
            str2 = null;
        }
        try {
            try {
                Context context = zzavmVar.zzc;
                int i = zzavmVar.zzr;
                zzfoi zzfoiVar = zzavmVar.zzh;
                zzfpz zza2 = zzfos.zza(context, 1, i, str, str2, "1", zzfoiVar);
                byte[] bArr = zza2.zzb;
                if (bArr == null || (length = bArr.length) == 0) {
                    zzfoiVar.zzd(IronSourceConstants.errorCode_adClosed, System.currentTimeMillis() - currentTimeMillis);
                } else {
                    try {
                        zzayp zzb2 = zzayp.zzb(zzgxz.zzv(bArr, 0, length), zzgyr.zza());
                        if (!zzb2.zzc().zzk().isEmpty() && !zzb2.zzc().zzj().isEmpty() && zzb2.zzd().zzA().length != 0) {
                            zzfpu zzu2 = zzavmVar.zzu(1);
                            if (zzu2 != null) {
                                zzays zza3 = zzu2.zza();
                                if (zzb2.zzc().zzk().equals(zza3.zzk())) {
                                }
                            }
                            zzfqb zzfqbVar = zzavmVar.zzj;
                            int i2 = zza2.zzc;
                            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcD)).booleanValue()) {
                                zza = zzavmVar.zzd.zza(zzb2, zzfqbVar);
                            } else if (i2 == 3) {
                                zza = zzavmVar.zze.zza(zzb2);
                            } else {
                                if (i2 == 4) {
                                    zza = zzavmVar.zze.zzb(zzb2, zzfqbVar);
                                }
                                zzavmVar.zzh.zzd(4009, System.currentTimeMillis() - currentTimeMillis);
                            }
                            if (zza) {
                                zzfpu zzu3 = zzavmVar.zzu(1);
                                if (zzu3 != null) {
                                    if (zzavmVar.zzf.zzc(zzu3)) {
                                        zzavmVar.zzq = true;
                                    }
                                    zzavmVar.zza = System.currentTimeMillis() / 1000;
                                }
                            }
                            zzavmVar.zzh.zzd(4009, System.currentTimeMillis() - currentTimeMillis);
                        }
                        zzavmVar.zzh.zzd(IronSourceConstants.errorCode_destroy, System.currentTimeMillis() - currentTimeMillis);
                    } catch (NullPointerException unused) {
                        zzavmVar.zzh.zzd(IronSourceError.ERROR_OLD_API_INIT_IN_PROGRESS, System.currentTimeMillis() - currentTimeMillis);
                    }
                }
            } catch (zzgzw e) {
                zzavmVar.zzh.zzc(4002, System.currentTimeMillis() - currentTimeMillis, e);
            }
        } finally {
            zzavmVar.zzk.countDown();
        }
    }

    private static synchronized zzavm zzs(Context context, Executor executor, zzfok zzfokVar, boolean z) {
        zzavm zzavmVar;
        synchronized (zzavm.class) {
            if (zzb == null) {
                zzfoi zza = zzfoi.zza(context, executor, z);
                zzawa zzc = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdG)).booleanValue() ? zzawa.zzc(context) : null;
                zzaxg zzd = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdH)).booleanValue() ? zzaxg.zzd(context, executor) : null;
                zzawy zzawyVar = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcV)).booleanValue() ? new zzawy() : null;
                zzawp zzawpVar = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdd)).booleanValue() ? new zzawp() : null;
                zzfoz zzc2 = zzfoz.zzc(context, executor, zza, zzfokVar);
                zzawq zzawqVar = new zzawq(context);
                zzawr zzawrVar = new zzawr(zzfokVar, zzc2, new zzaxe(context, zzawqVar), zzawqVar, zzc, zzd, zzawyVar, zzawpVar);
                int zzb2 = zzfpi.zzb(context, zza);
                zzfod zzfodVar = new zzfod();
                zzavm zzavmVar2 = new zzavm(context, zza, new zzfpv(context, zzb2), new zzfqc(context, zzb2, new zzavj(zza), ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcF)).booleanValue()), new zzfqe(context, zzawrVar, zza, zzfodVar, false), zzawrVar, executor, zzfodVar, zzb2, zzd, zzawyVar, zzawpVar);
                zzb = zzavmVar2;
                zzavmVar2.zzm();
                zzb.zzp();
            }
            zzavmVar = zzb;
        }
        return zzavmVar;
    }

    private final void zzt() {
        zzaxg zzaxgVar = this.zzl;
        if (zzaxgVar != null) {
            zzaxgVar.zzh();
        }
    }

    private final zzfpu zzu(int i) {
        if (zzfpi.zza(this.zzr)) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcD)).booleanValue() ? this.zze.zzc(1) : this.zzd.zzc(1);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzd(Context context, String str, View view) {
        return zze(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zze(Context context, String str, View view, Activity activity) {
        zzt();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcV)).booleanValue()) {
            this.zzm.zzi();
        }
        zzp();
        zzfol zza = this.zzf.zza();
        if (zza == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zza2 = zza.zza(context, null, str, view, activity);
        this.zzh.zzf(5000, System.currentTimeMillis() - currentTimeMillis, zza2, null);
        return zza2;
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzf(Context context) {
        zzt();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcV)).booleanValue()) {
            this.zzm.zzj();
        }
        zzp();
        zzfol zza = this.zzf.zza();
        if (zza == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzc = zza.zzc(context, null);
        this.zzh.zzf(5001, System.currentTimeMillis() - currentTimeMillis, zzc, null);
        return zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzg(Context context) {
        return "19";
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzh(Context context, View view, Activity activity) {
        zzt();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcV)).booleanValue()) {
            this.zzm.zzk(context, view);
        }
        zzp();
        zzfol zza = this.zzf.zza();
        if (zza == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzb2 = zza.zzb(context, null, view, activity);
        this.zzh.zzf(5002, System.currentTimeMillis() - currentTimeMillis, zzb2, null);
        return zzb2;
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void zzk(MotionEvent motionEvent) {
        zzfol zza = this.zzf.zza();
        if (zza != null) {
            try {
                zza.zzd(null, motionEvent);
            } catch (zzfqd e) {
                this.zzh.zzc(e.zza(), -1L, e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void zzl(int i, int i2, int i3) {
        DisplayMetrics displayMetrics;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmt)).booleanValue() || (displayMetrics = this.zzc.getResources().getDisplayMetrics()) == null) {
            return;
        }
        float f = i;
        float f2 = i2;
        MotionEvent obtain = MotionEvent.obtain(0L, 0L, 0, f * displayMetrics.density, f2 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(obtain);
        obtain.recycle();
        MotionEvent obtain2 = MotionEvent.obtain(0L, 0L, 2, f * displayMetrics.density, f2 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(obtain2);
        obtain2.recycle();
        MotionEvent obtain3 = MotionEvent.obtain(0L, i3, 1, f * displayMetrics.density, f2 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(obtain3);
        obtain3.recycle();
    }

    final synchronized void zzm() {
        long currentTimeMillis = System.currentTimeMillis();
        zzfpu zzu = zzu(1);
        if (zzu == null) {
            this.zzh.zzd(4013, System.currentTimeMillis() - currentTimeMillis);
        } else if (this.zzf.zzc(zzu)) {
            this.zzq = true;
            this.zzk.countDown();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzawp zzawpVar = this.zzn;
        if (zzawpVar != null) {
            zzawpVar.zzb(Arrays.asList(stackTraceElementArr));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void zzo(View view) {
        this.zzg.zzd(view);
    }

    public final void zzp() {
        if (this.zzp) {
            return;
        }
        synchronized (this.zzo) {
            if (!this.zzp) {
                if ((System.currentTimeMillis() / 1000) - this.zza < 3600) {
                    return;
                }
                zzfpu zzb2 = this.zzf.zzb();
                if ((zzb2 == null || zzb2.zzd(3600L)) && zzfpi.zza(this.zzr)) {
                    this.zzi.execute(new zzavl(this));
                }
            }
        }
    }

    public final synchronized boolean zzr() {
        return this.zzq;
    }
}
