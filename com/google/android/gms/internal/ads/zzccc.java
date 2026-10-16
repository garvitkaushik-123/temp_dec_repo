package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.vungle.ads.internal.ui.AdActivity;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzccc {
    private static final boolean zza;
    private final Context zzb;
    private final String zzc;
    private final VersionInfoParcel zzd;
    private final zzbdq zze;
    private final zzbdt zzf;
    private final com.google.android.gms.ads.internal.util.zzbh zzg;
    private final long[] zzh;
    private final String[] zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private zzcbh zzo;
    private boolean zzp;
    private boolean zzq;
    private long zzr;

    static {
        zza = com.google.android.gms.ads.internal.client.zzbb.zze().nextInt(100) < ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznd)).intValue();
    }

    public zzccc(Context context, VersionInfoParcel versionInfoParcel, String str, zzbdt zzbdtVar, zzbdq zzbdqVar) {
        com.google.android.gms.ads.internal.util.zzbf zzbfVar = new com.google.android.gms.ads.internal.util.zzbf();
        zzbfVar.zza("min_1", Double.MIN_VALUE, 1.0d);
        zzbfVar.zza("1_5", 1.0d, 5.0d);
        zzbfVar.zza("5_10", 5.0d, 10.0d);
        zzbfVar.zza("10_20", 10.0d, 20.0d);
        zzbfVar.zza("20_30", 20.0d, 30.0d);
        zzbfVar.zza("30_max", 30.0d, Double.MAX_VALUE);
        this.zzg = zzbfVar.zzb();
        this.zzj = false;
        this.zzk = false;
        this.zzl = false;
        this.zzm = false;
        this.zzr = -1L;
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zzc = str;
        this.zzf = zzbdtVar;
        this.zze = zzbdqVar;
        String str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzS);
        if (str2 == null) {
            this.zzi = new String[0];
            this.zzh = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        int length = split.length;
        this.zzi = new String[length];
        this.zzh = new long[length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzh[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzk("Unable to parse frame hash target time number.", e);
                this.zzh[i] = -1;
            }
        }
    }

    public final void zza(zzcbh zzcbhVar) {
        zzbdt zzbdtVar = this.zzf;
        zzbdl.zza(zzbdtVar, this.zze, "vpc2");
        this.zzj = true;
        zzbdtVar.zzd("vpn", zzcbhVar.zzj());
        this.zzo = zzcbhVar;
    }

    public final void zzb() {
        if (!this.zzj || this.zzk) {
            return;
        }
        zzbdl.zza(this.zzf, this.zze, "vfr2");
        this.zzk = true;
    }

    public final void zzc() {
        this.zzn = true;
        if (!this.zzk || this.zzl) {
            return;
        }
        zzbdl.zza(this.zzf, this.zze, "vfp2");
        this.zzl = true;
    }

    public final void zzd() {
        if (!zza || this.zzp) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "native-player-metrics");
        bundle.putString(AdActivity.REQUEST_KEY_EXTRA, this.zzc);
        bundle.putString("player", this.zzo.zzj());
        for (com.google.android.gms.ads.internal.util.zzbe zzbeVar : this.zzg.zza()) {
            String str = zzbeVar.zza;
            String valueOf = String.valueOf(str);
            bundle.putString("fps_c_".concat(valueOf), Integer.toString(zzbeVar.zze));
            String valueOf2 = String.valueOf(str);
            bundle.putString("fps_p_".concat(valueOf2), Double.toString(zzbeVar.zzd));
        }
        int i = 0;
        while (true) {
            long[] jArr = this.zzh;
            if (i >= jArr.length) {
                com.google.android.gms.ads.internal.zzv.zzr().zzi(this.zzb, this.zzd.afmaVersion, "gmob-apps", bundle, true);
                this.zzp = true;
                return;
            }
            String str2 = this.zzi[i];
            if (str2 != null) {
                Long valueOf3 = Long.valueOf(jArr[i]);
                new StringBuilder("fh_").append(valueOf3);
                bundle.putString("fh_".concat(valueOf3.toString()), str2);
            }
            i++;
        }
    }

    public final void zze() {
        this.zzn = false;
    }

    public final void zzf(zzcbh zzcbhVar) {
        int i = 0;
        if (this.zzl && !this.zzm) {
            if (com.google.android.gms.ads.internal.util.zze.zzc() && !this.zzm) {
                com.google.android.gms.ads.internal.util.zze.zza("VideoMetricsMixin first frame");
            }
            zzbdl.zza(this.zzf, this.zze, "vff2");
            this.zzm = true;
        }
        long nanoTime = com.google.android.gms.ads.internal.zzv.zzD().nanoTime();
        if (this.zzn && this.zzq && this.zzr != -1) {
            this.zzg.zzb(TimeUnit.SECONDS.toNanos(1L) / (nanoTime - this.zzr));
        }
        this.zzq = this.zzn;
        this.zzr = nanoTime;
        long longValue = ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzT)).longValue();
        long zza2 = zzcbhVar.zza();
        int i2 = 0;
        while (true) {
            String[] strArr = this.zzi;
            if (i2 >= strArr.length) {
                return;
            }
            if (strArr[i2] == null && longValue > Math.abs(zza2 - this.zzh[i2])) {
                int i3 = 8;
                Bitmap bitmap = zzcbhVar.getBitmap(8, 8);
                long j = 63;
                int i4 = i;
                long j2 = 0;
                while (i4 < i3) {
                    while (i < i3) {
                        int pixel = bitmap.getPixel(i, i4);
                        j2 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1L : 0L) << ((int) j);
                        j--;
                        i++;
                        i3 = 8;
                    }
                    i4++;
                    i = 0;
                    i3 = 8;
                }
                strArr[i2] = String.format("%016X", Long.valueOf(j2));
                return;
            }
            i2++;
            i = 0;
        }
    }
}
