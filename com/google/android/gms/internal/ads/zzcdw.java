package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcdw extends zzcdn implements zzcbr {
    public static final /* synthetic */ int zzd = 0;
    private zzcbs zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzcdf zzi;
    private long zzj;
    private long zzk;

    public zzcdw(zzccb zzccbVar, zzcca zzccaVar) {
        super(zzccbVar);
        zzceo zzceoVar = new zzceo(zzccbVar.getContext(), zzccaVar, (zzccb) this.zzc.get(), null);
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("ExoPlayerAdapter initialized.");
        this.zze = zzceoVar;
        zzceoVar.zzL(this);
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [boolean] */
    public static /* synthetic */ void zzb(zzcdw zzcdwVar) {
        long longValue;
        long intValue;
        ?? booleanValue;
        long j;
        long j2;
        long j3;
        String zzc = zzc(zzcdwVar.zzf);
        String str = "error";
        try {
            longValue = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzP)).longValue() * 1000;
            intValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzu)).intValue();
            booleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcc)).booleanValue();
        } catch (Exception e) {
            String str2 = str;
            String str3 = "Failed to preload url " + zzcdwVar.zzf + " Exception: " + e.getMessage();
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(str3);
            com.google.android.gms.ads.internal.zzv.zzp().zzv(e, "VideoStreamExoPlayerCache.preload");
            zzcdwVar.release();
            zzcdwVar.zzg(zzcdwVar.zzf, zzc, str2, zzd(str2, e));
        }
        synchronized (zzcdwVar) {
            try {
                try {
                    if (com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() - zzcdwVar.zzj > longValue) {
                        throw new IOException("Timeout reached. Limit: " + longValue + " ms");
                    }
                    if (zzcdwVar.zzg) {
                        throw new IOException("Abort requested before buffering finished. ");
                    }
                    if (!zzcdwVar.zzh) {
                        if (!zzcdwVar.zze.zzV()) {
                            throw new IOException("ExoPlayer was released during preloading.");
                        }
                        long zzz = zzcdwVar.zze.zzz();
                        if (zzz > 0) {
                            long zzv = zzcdwVar.zze.zzv();
                            if (zzv != zzcdwVar.zzk) {
                                j2 = zzz;
                                j3 = zzv;
                                j = intValue;
                                zzcdwVar.zzo(zzcdwVar.zzf, zzc, j3, j2, zzv > 0, booleanValue != 0 ? zzcdwVar.zze.zzA() : -1L, booleanValue != 0 ? zzcdwVar.zze.zzx() : -1L, booleanValue != 0 ? zzcdwVar.zze.zzB() : -1L, zzcbs.zzs(), zzcbs.zzu());
                                zzcdwVar.zzk = j3;
                            } else {
                                j = intValue;
                                j2 = zzz;
                                j3 = zzv;
                            }
                            if (j3 >= j2) {
                                zzcdwVar.zzj(zzcdwVar.zzf, zzc, j2);
                            } else if (zzcdwVar.zze.zzw() >= j && j3 > 0) {
                            }
                        }
                        zzcdwVar.zzx(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzQ)).longValue());
                        return;
                    }
                    com.google.android.gms.ads.internal.zzv.zzA().zzc(zzcdwVar.zzi);
                } catch (Throwable th) {
                    th = th;
                    str = booleanValue;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    protected static final String zzc(String str) {
        return "cache:".concat(String.valueOf(com.google.android.gms.ads.internal.util.client.zzf.zzk(str)));
    }

    private static String zzd(String str, Exception exc) {
        return str + RemoteSettings.FORWARD_SLASH_STRING + exc.getClass().getCanonicalName() + ":" + exc.getMessage();
    }

    private final void zzx(long j) {
        com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdv
            @Override // java.lang.Runnable
            public final void run() {
                zzcdw.zzb(zzcdw.this);
            }
        }, j);
    }

    @Override // com.google.android.gms.internal.ads.zzcdn, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzcbs zzcbsVar = this.zze;
        if (zzcbsVar != null) {
            zzcbsVar.zzL(null);
            this.zze.zzH();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzD(int i, int i2) {
    }

    public final zzcbs zza() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzL(null);
        zzcbs zzcbsVar = this.zze;
        this.zze = null;
        return zzcbsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzf() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzg(this.zzf, zzc(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzi(final boolean z, final long j) {
        final zzccb zzccbVar = (zzccb) this.zzc.get();
        if (zzccbVar != null) {
            zzcaf.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdu
                @Override // java.lang.Runnable
                public final void run() {
                    int i = zzcdw.zzd;
                    zzccb.this.zzv(z, j);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzk(String str, Exception exc) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzk("Precache error", exc);
        com.google.android.gms.ads.internal.zzv.zzp().zzv(exc, "VideoStreamExoPlayerCache.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzl(String str, Exception exc) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzk("Precache exception", exc);
        com.google.android.gms.ads.internal.zzv.zzp().zzv(exc, "VideoStreamExoPlayerCache.onException");
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzm(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzp(int i) {
        this.zze.zzJ(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzq(int i) {
        this.zze.zzK(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzr(int i) {
        this.zze.zzM(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzs(int i) {
        this.zze.zzN(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final boolean zzt(String str) {
        return zzu(str, new String[]{str});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11, types: [long] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v20 */
    @Override // com.google.android.gms.internal.ads.zzcdn
    public final boolean zzu(String str, String[] strArr) {
        long j;
        long j2;
        ?? r4;
        long j3;
        long j4;
        long j5;
        long j6;
        boolean z;
        this.zzf = str;
        String str2 = "error";
        String zzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            this.zze.zzF(uriArr, this.zzb);
            zzccb zzccbVar = (zzccb) this.zzc.get();
            if (zzccbVar != null) {
                zzccbVar.zzt(zzc, this);
            }
            Clock zzD = com.google.android.gms.ads.internal.zzv.zzD();
            long currentTimeMillis = zzD.currentTimeMillis();
            long longValue = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzQ)).longValue();
            long longValue2 = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzP)).longValue() * 1000;
            long intValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzu)).intValue();
            boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcc)).booleanValue();
            long j7 = -1;
            long j8 = longValue;
            while (true) {
                synchronized (this) {
                    try {
                        if (zzD.currentTimeMillis() - currentTimeMillis > longValue2) {
                            throw new IOException("Timeout reached. Limit: " + longValue2 + " ms");
                        }
                        if (this.zzg) {
                            throw new IOException("Abort requested before buffering finished. ");
                        }
                        if (!this.zzh) {
                            if (!this.zze.zzV()) {
                                throw new IOException("ExoPlayer was released during preloading.");
                            }
                            long zzz = this.zze.zzz();
                            if (zzz > 0) {
                                long zzv = this.zze.zzv();
                                if (zzv != j7) {
                                    if (zzv > 0) {
                                        j6 = intValue;
                                        z = true;
                                    } else {
                                        j6 = intValue;
                                        z = false;
                                    }
                                    long j9 = j8;
                                    j5 = zzv;
                                    long zzA = booleanValue ? this.zze.zzA() : -1L;
                                    j2 = j6;
                                    j = longValue2;
                                    j4 = zzz;
                                    j3 = j9;
                                    zzo(str, zzc, j5, j4, z, zzA, booleanValue ? this.zze.zzx() : -1L, booleanValue ? this.zze.zzB() : -1L, zzcbs.zzs(), zzcbs.zzu());
                                    j7 = j5;
                                } else {
                                    j3 = j8;
                                    j = longValue2;
                                    j2 = intValue;
                                    j4 = zzz;
                                    j5 = zzv;
                                }
                                if (j5 >= j4) {
                                    zzj(str, zzc, j4);
                                } else if (this.zze.zzw() < j2 || j5 <= 0) {
                                    r4 = j3;
                                }
                            } else {
                                j = longValue2;
                                j2 = intValue;
                                r4 = j8;
                            }
                            try {
                                try {
                                    wait(r4);
                                } catch (InterruptedException unused) {
                                    throw new IOException("Wait interrupted.");
                                }
                            } catch (Throwable th) {
                                th = th;
                                str2 = r4;
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                intValue = j2;
                longValue2 = j;
                j8 = r4;
            }
            return true;
        } catch (Exception e) {
            String str3 = str2;
            String str4 = "Failed to preload url " + str + " Exception: " + e.getMessage();
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(str4);
            com.google.android.gms.ads.internal.zzv.zzp().zzv(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzg(str, zzc, str3, zzd(str3, e));
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbr
    public final void zzv() {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache onRenderedFirstFrame");
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final boolean zzw(String str, String[] strArr, zzcdf zzcdfVar) {
        this.zzf = str;
        this.zzi = zzcdfVar;
        String zzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            this.zze.zzF(uriArr, this.zzb);
            zzccb zzccbVar = (zzccb) this.zzc.get();
            if (zzccbVar != null) {
                zzccbVar.zzt(zzc, this);
            }
            this.zzj = com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis();
            this.zzk = -1L;
            zzx(0L);
            return true;
        } catch (Exception e) {
            String str2 = "Failed to preload url " + str + " Exception: " + e.getMessage();
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(str2);
            com.google.android.gms.ads.internal.zzv.zzp().zzv(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzg(str, zzc, "error", zzd("error", e));
            return false;
        }
    }
}
