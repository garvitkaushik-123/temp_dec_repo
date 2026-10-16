package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzccv implements zzgj {
    private final Context zza;
    private final zzgj zzb;
    private final String zzc;
    private final int zzd;
    private final boolean zze;
    private InputStream zzf;
    private boolean zzg;
    private Uri zzh;
    private volatile zzbbo zzi;
    private boolean zzj = false;
    private boolean zzk = false;
    private zzgo zzl;

    public zzccv(Context context, zzgj zzgjVar, String str, int i, zzhj zzhjVar, zzccu zzccuVar) {
        this.zza = context;
        this.zzb = zzgjVar;
        this.zzc = str;
        this.zzd = i;
        new AtomicLong(-1L);
        this.zze = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcc)).booleanValue();
    }

    private final boolean zzg() {
        if (!this.zze) {
            return false;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeG)).booleanValue() || this.zzj) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeH)).booleanValue() && !this.zzk;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzl
    public final int zza(byte[] bArr, int i, int i2) throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to read closed CacheDataSource.");
        }
        InputStream inputStream = this.zzf;
        return inputStream != null ? inputStream.read(bArr, i, i2) : this.zzb.zza(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final long zzb(zzgo zzgoVar) throws IOException {
        Long l;
        if (this.zzg) {
            throw new IOException("Attempt to open an already open CacheDataSource.");
        }
        this.zzg = true;
        Uri uri = zzgoVar.zza;
        this.zzh = uri;
        this.zzl = zzgoVar;
        this.zzi = zzbbo.zza(uri);
        zzbbl zzbblVar = null;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeD)).booleanValue()) {
            if (this.zzi != null) {
                this.zzi.zzh = zzgoVar.zze;
                this.zzi.zzi = zzfwg.zzc(this.zzc);
                this.zzi.zzj = this.zzd;
                zzbblVar = com.google.android.gms.ads.internal.zzv.zzc().zzb(this.zzi);
            }
            if (zzbblVar != null && zzbblVar.zze()) {
                this.zzj = zzbblVar.zzg();
                this.zzk = zzbblVar.zzf();
                if (!zzg()) {
                    this.zzf = zzbblVar.zzc();
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
            com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime();
            com.google.android.gms.ads.internal.zzv.zzd();
            Future zza = zzbbz.zza(this.zza, this.zzi);
            try {
                try {
                    zzbca zzbcaVar = (zzbca) zza.get(longValue, TimeUnit.MILLISECONDS);
                    zzbcaVar.zzd();
                    this.zzj = zzbcaVar.zzf();
                    this.zzk = zzbcaVar.zze();
                    zzbcaVar.zza();
                    if (!zzg()) {
                        this.zzf = zzbcaVar.zzc();
                    }
                } catch (InterruptedException unused) {
                    zza.cancel(false);
                    Thread.currentThread().interrupt();
                } catch (ExecutionException | TimeoutException unused2) {
                    zza.cancel(false);
                }
            } catch (Throwable unused3) {
            }
            com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime();
            throw null;
        }
        if (this.zzi != null) {
            zzgm zza2 = zzgoVar.zza();
            zza2.zzd(Uri.parse(this.zzi.zza));
            this.zzl = zza2.zze();
        }
        return this.zzb.zzb(this.zzl);
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final Uri zzc() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzd() throws IOException {
        if (!this.zzg) {
            throw new IOException("Attempt to close an already closed CacheDataSource.");
        }
        this.zzg = false;
        this.zzh = null;
        InputStream inputStream = this.zzf;
        if (inputStream == null) {
            this.zzb.zzd();
        } else {
            IOUtils.closeQuietly(inputStream);
            this.zzf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    @Override // com.google.android.gms.internal.ads.zzgj
    public final void zzf(zzhj zzhjVar) {
    }
}
