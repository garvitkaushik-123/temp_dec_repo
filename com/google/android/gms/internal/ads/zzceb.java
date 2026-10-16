package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzceb extends zzgc {
    private final Context zza;
    private final zzgj zzb;
    private final String zzc;
    private final int zzd;
    private final boolean zze;
    private InputStream zzf;
    private boolean zzg;
    private Uri zzh;
    private volatile zzbbo zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private long zzn;
    private ListenableFuture zzo;
    private final AtomicLong zzp;
    private final zzcel zzq;

    public zzceb(Context context, zzgj zzgjVar, String str, int i, zzhj zzhjVar, zzcel zzcelVar) {
        super(false);
        this.zza = context;
        this.zzb = zzgjVar;
        this.zzq = zzcelVar;
        this.zzc = str;
        this.zzd = i;
        this.zzj = false;
        this.zzk = false;
        this.zzl = false;
        this.zzm = false;
        this.zzn = 0L;
        this.zzp = new AtomicLong(-1L);
        this.zzo = null;
        this.zze = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcc)).booleanValue();
        zzf(zzhjVar);
    }

    private final boolean zzr() {
        if (!this.zze) {
            return false;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeG)).booleanValue() || this.zzl) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeH)).booleanValue() && !this.zzm;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to read closed GcacheDataSource.");
        }
        InputStream inputStream = this.zzf;
        int read = inputStream != null ? inputStream.read(bArr, i, i2) : this.zzb.zza(bArr, i, i2);
        if (this.zze && this.zzf == null) {
            return read;
        }
        zzg(read);
        return read;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01d8  */
    /* JADX WARN: Type inference failed for: r4v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.StringBuilder] */
    @Override // com.google.android.gms.internal.ads.zzgj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long zzb(zzgo zzgoVar) throws IOException {
        zzbbl zzbblVar;
        Long l;
        boolean z;
        boolean z2;
        long elapsedRealtime;
        zzbca zzbcaVar;
        String str = "ms";
        if (this.zzg) {
            throw new IOException("Attempt to open an already open GcacheDataSource.");
        }
        boolean z3 = true;
        this.zzg = true;
        Uri uri = zzgoVar.zza;
        this.zzh = uri;
        ?? r4 = this.zze;
        if (r4 == 0) {
            zzj(zzgoVar);
        }
        this.zzi = zzbbo.zza(uri);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeD)).booleanValue()) {
            if (this.zzi != null) {
                this.zzi.zzh = zzgoVar.zze;
                this.zzi.zzi = zzfwg.zzc(this.zzc);
                this.zzi.zzj = this.zzd;
                zzbblVar = com.google.android.gms.ads.internal.zzv.zzc().zzb(this.zzi);
            } else {
                zzbblVar = null;
            }
            if (zzbblVar != null && zzbblVar.zze()) {
                this.zzj = zzbblVar.zzd();
                this.zzl = zzbblVar.zzg();
                this.zzm = zzbblVar.zzf();
                this.zzn = zzbblVar.zza();
                this.zzk = true;
                if (!zzr()) {
                    this.zzf = zzbblVar.zzc();
                    if (this.zze) {
                        zzj(zzgoVar);
                    }
                    return -1L;
                }
            }
        } else if (this.zzi != null) {
            this.zzi.zzh = zzgoVar.zze;
            this.zzi.zzi = zzfwg.zzc(this.zzc);
            this.zzi.zzj = this.zzd;
            if (this.zzi.zzg) {
                l = (Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeF);
            } else {
                l = (Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeE);
            }
            long longValue = l.longValue();
            long elapsedRealtime2 = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime();
            com.google.android.gms.ads.internal.zzv.zzd();
            Future zza = zzbbz.zza(this.zza, this.zzi);
            try {
                try {
                    zzbcaVar = (zzbca) zza.get(longValue, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th = th;
                    z3 = r4;
                }
                try {
                    this.zzj = zzbcaVar.zzd();
                    this.zzl = zzbcaVar.zzf();
                    this.zzm = zzbcaVar.zze();
                    this.zzn = zzbcaVar.zza();
                } catch (InterruptedException unused) {
                    z2 = true;
                    zza.cancel(true);
                    Thread.currentThread().interrupt();
                    elapsedRealtime = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - elapsedRealtime2;
                    zzceo.zzab(this.zzq.zza, z2, elapsedRealtime);
                    this.zzk = z2;
                    r4 = new StringBuilder("Cache connection took ");
                    r4.append(elapsedRealtime);
                    r4.append("ms");
                    str = r4.toString();
                    com.google.android.gms.ads.internal.util.zze.zza(str);
                    this.zzk = false;
                    if (this.zzi != null) {
                    }
                    return this.zzb.zzb(zzgoVar);
                } catch (ExecutionException | TimeoutException unused2) {
                    z = true;
                    zza.cancel(true);
                    elapsedRealtime = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - elapsedRealtime2;
                    zzceo.zzab(this.zzq.zza, z, elapsedRealtime);
                    this.zzk = z;
                    r4 = new StringBuilder("Cache connection took ");
                    r4.append(elapsedRealtime);
                    r4.append("ms");
                    str = r4.toString();
                    com.google.android.gms.ads.internal.util.zze.zza(str);
                    this.zzk = false;
                    if (this.zzi != null) {
                    }
                    return this.zzb.zzb(zzgoVar);
                } catch (Throwable th2) {
                    th = th2;
                    long elapsedRealtime3 = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - elapsedRealtime2;
                    zzceo.zzab(this.zzq.zza, z3, elapsedRealtime3);
                    this.zzk = z3;
                    com.google.android.gms.ads.internal.util.zze.zza("Cache connection took " + elapsedRealtime3 + str);
                    throw th;
                }
            } catch (InterruptedException unused3) {
                z2 = false;
            } catch (ExecutionException | TimeoutException unused4) {
                z = false;
            } catch (Throwable th3) {
                th = th3;
                z3 = false;
            }
            if (!zzr()) {
                this.zzf = zzbcaVar.zzc();
                if (r4 != 0) {
                    zzj(zzgoVar);
                }
                long elapsedRealtime4 = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - elapsedRealtime2;
                zzceo.zzab(this.zzq.zza, true, elapsedRealtime4);
                this.zzk = true;
                com.google.android.gms.ads.internal.util.zze.zza("Cache connection took " + elapsedRealtime4 + "ms");
                return -1L;
            }
            long elapsedRealtime5 = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - elapsedRealtime2;
            zzceo.zzab(this.zzq.zza, true, elapsedRealtime5);
            this.zzk = true;
            str = "Cache connection took " + elapsedRealtime5 + "ms";
            com.google.android.gms.ads.internal.util.zze.zza(str);
        }
        this.zzk = false;
        if (this.zzi != null) {
            zzgm zza2 = zzgoVar.zza();
            zza2.zzd(Uri.parse(this.zzi.zza));
            zzgoVar = zza2.zze();
        }
        return this.zzb.zzb(zzgoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Uri zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzd() throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to close an already closed GcacheDataSource.");
        }
        this.zzg = false;
        this.zzh = null;
        boolean z = (this.zze && this.zzf == null) ? false : true;
        InputStream inputStream = this.zzf;
        if (inputStream != null) {
            IOUtils.closeQuietly(inputStream);
            this.zzf = null;
        } else {
            this.zzb.zzd();
        }
        if (z) {
            zzh();
        }
    }

    public final long zzk() {
        return this.zzn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long zzl() {
        if (this.zzi != null) {
            AtomicLong atomicLong = this.zzp;
            if (atomicLong.get() != -1) {
                return atomicLong.get();
            }
            synchronized (this) {
                if (this.zzo == null) {
                    this.zzo = zzcaf.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzcea
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            Long valueOf;
                            valueOf = Long.valueOf(com.google.android.gms.ads.internal.zzv.zzc().zza(zzceb.this.zzi));
                            return valueOf;
                        }
                    });
                }
            }
            if (this.zzo.isDone()) {
                try {
                    this.zzp.compareAndSet(-1L, ((Long) this.zzo.get()).longValue());
                    return this.zzp.get();
                } catch (InterruptedException | ExecutionException unused) {
                }
            }
        }
        return -1L;
    }

    public final boolean zzn() {
        return this.zzj;
    }

    public final boolean zzo() {
        return this.zzm;
    }

    public final boolean zzp() {
        return this.zzl;
    }

    public final boolean zzq() {
        return this.zzk;
    }
}
