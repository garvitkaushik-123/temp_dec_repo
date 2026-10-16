package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcdt extends zzcdn implements zzhj {
    private static final AtomicInteger zzd = new AtomicInteger(0);
    private String zze;
    private final zzcca zzf;
    private boolean zzg;
    private final zzcds zzh;
    private final zzccx zzi;
    private ByteBuffer zzj;
    private boolean zzk;
    private final Object zzl;
    private final String zzm;
    private final int zzn;
    private boolean zzo;

    public zzcdt(zzccb zzccbVar, zzcca zzccaVar) {
        super(zzccbVar);
        this.zzf = zzccaVar;
        this.zzh = new zzcds();
        this.zzi = new zzccx();
        this.zzl = new Object();
        this.zzm = (String) zzfvn.zzd(zzccbVar != null ? zzccbVar.zzr() : null).zzb("");
        this.zzn = zzccbVar != null ? zzccbVar.zzf() : 0;
        zzd.incrementAndGet();
    }

    public static int zzi() {
        return zzd.get();
    }

    protected static final String zzv(String str) {
        return "cache:".concat(String.valueOf(com.google.android.gms.ads.internal.util.client.zzf.zzk(str)));
    }

    private final void zzx() {
        int zza = (int) this.zzh.zza();
        int zza2 = (int) this.zzi.zza(this.zzj);
        int position = this.zzj.position();
        int round = Math.round(zza2 * (position / zza));
        int zzs = zzcbs.zzs();
        int zzu = zzcbs.zzu();
        String str = this.zze;
        zzn(str, zzv(str), position, zza, round, zza2, round > 0, zzs, zzu);
    }

    @Override // com.google.android.gms.internal.ads.zzcdn, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzd.decrementAndGet();
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public final void zza(zzgj zzgjVar, zzgo zzgoVar, boolean z, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public final void zzb(zzgj zzgjVar, zzgo zzgoVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public final void zzc(zzgj zzgjVar, zzgo zzgoVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public final void zzd(zzgj zzgjVar, zzgo zzgoVar, boolean z) {
        if (zzgjVar instanceof zzgw) {
            this.zzh.zzb((zzgw) zzgjVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcdn
    public final void zzf() {
        this.zzg = true;
    }

    public final String zzk() {
        return this.zze;
    }

    public final ByteBuffer zzl() {
        synchronized (this.zzl) {
            ByteBuffer byteBuffer = this.zzj;
            if (byteBuffer != null && !this.zzk) {
                byteBuffer.flip();
                this.zzk = true;
            }
            this.zzg = true;
        }
        return this.zzj;
    }

    public final boolean zzm() {
        return this.zzo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d8, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a6, code lost:
    
        r23.zzo = true;
        zzj(r24, r4, (int) r23.zzi.zza(r23.zzj));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v7, types: [boolean] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:? -> B:51:0x0143). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzcdn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzt(String str) {
        String str2;
        String str3;
        this.zze = str;
        String str4 = "error";
        String zzv = zzv(str);
        int i = 0;
        try {
            zzgr zzgrVar = new zzgr();
            zzgrVar.zzf(this.zzb);
            zzcca zzccaVar = this.zzf;
            zzgrVar.zzc(zzccaVar.zzd);
            zzgrVar.zzd(zzccaVar.zze);
            zzgrVar.zzb(true);
            zzgrVar.zze(this);
            zzgj zza = zzgrVar.zza();
            if (zzccaVar.zzi) {
                zza = new zzccv(this.zza, zza, this.zzm, this.zzn, null, null);
            }
            zza.zzb(new zzgo(Uri.parse(str), 0L, -1L, null));
            zzccb zzccbVar = (zzccb) this.zzc.get();
            if (zzccbVar != null) {
                zzccbVar.zzt(zzv, this);
            }
            Clock zzD = com.google.android.gms.ads.internal.zzv.zzD();
            long currentTimeMillis = zzD.currentTimeMillis();
            long longValue = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzQ)).longValue();
            long longValue2 = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzP)).longValue();
            this.zzj = ByteBuffer.allocate(zzccaVar.zzc);
            int i2 = 8192;
            byte[] bArr = new byte[8192];
            long j = currentTimeMillis;
            while (true) {
                int zza2 = zza.zza(bArr, i, Math.min(this.zzj.remaining(), i2));
                if (zza2 == -1) {
                    break;
                }
                synchronized (this.zzl) {
                    try {
                        if (this.zzg) {
                            str2 = str4;
                        } else {
                            str2 = str4;
                            try {
                                this.zzj.put(bArr, 0, zza2);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        try {
                            if (this.zzj.remaining() <= 0) {
                                zzx();
                                break;
                            }
                            str3 = this.zzg;
                            try {
                                if (str3 != 0) {
                                    throw new IOException("Precache abort at " + this.zzj.limit() + " bytes");
                                }
                                long currentTimeMillis2 = zzD.currentTimeMillis();
                                if (currentTimeMillis2 - j >= longValue) {
                                    zzx();
                                    j = currentTimeMillis2;
                                }
                                if (currentTimeMillis2 - currentTimeMillis > 1000 * longValue2) {
                                    throw new IOException("Timeout exceeded. Limit: " + longValue2 + " sec");
                                }
                                str4 = str2;
                                i = 0;
                                i2 = 8192;
                            } catch (Exception e) {
                                e = e;
                                String str5 = e.getClass().getCanonicalName() + ":" + e.getMessage();
                                int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to preload url " + str + " Exception: " + str5);
                                zzg(str, zzv, str3, str5);
                                return false;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str3 = str2;
                            String str52 = e.getClass().getCanonicalName() + ":" + e.getMessage();
                            int i32 = com.google.android.gms.ads.internal.util.zze.zza;
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to preload url " + str + " Exception: " + str52);
                            zzg(str, zzv, str3, str52);
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            str2 = str4;
        }
    }
}
