package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.mbridge.msdk.foundation.entity.b;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdwl extends zzfrz {
    private final Context zza;

    @Nullable
    private SensorManager zzb;
    private Sensor zzc;
    private long zzd;
    private int zze;
    private zzdwk zzf;
    private boolean zzg;

    zzdwl(Context context) {
        super("ShakeDetector", b.JSON_KEY_ADS);
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzfrz
    public final void zza(SensorEvent sensorEvent) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjt)).booleanValue()) {
            float f = sensorEvent.values[0] / 9.80665f;
            float f2 = sensorEvent.values[1] / 9.80665f;
            float f3 = sensorEvent.values[2] / 9.80665f;
            if (((float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3))) >= ((Float) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzju)).floatValue()) {
                long currentTimeMillis = com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis();
                if (this.zzd + ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjv)).intValue() <= currentTimeMillis) {
                    if (this.zzd + ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjw)).intValue() < currentTimeMillis) {
                        this.zze = 0;
                    }
                    com.google.android.gms.ads.internal.util.zze.zza("Shake detected.");
                    this.zzd = currentTimeMillis;
                    int i = this.zze + 1;
                    this.zze = i;
                    zzdwk zzdwkVar = this.zzf;
                    if (zzdwkVar != null) {
                        if (i == ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjx)).intValue()) {
                            zzdvi zzdviVar = (zzdvi) zzdwkVar;
                            zzdviVar.zzh(new zzdvf(zzdviVar), zzdvh.GESTURE);
                        }
                    }
                }
            }
        }
    }

    public final void zzb() {
        synchronized (this) {
            if (this.zzg) {
                SensorManager sensorManager = this.zzb;
                if (sensorManager != null) {
                    sensorManager.unregisterListener(this, this.zzc);
                    com.google.android.gms.ads.internal.util.zze.zza("Stopped listening for shake gestures.");
                }
                this.zzg = false;
            }
        }
    }

    public final void zzc() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjt)).booleanValue()) {
                if (this.zzb == null) {
                    SensorManager sensorManager2 = (SensorManager) this.zza.getSystemService("sensor");
                    this.zzb = sensorManager2;
                    if (sensorManager2 == null) {
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Shake detection failed to initialize. Failed to obtain accelerometer.");
                        return;
                    }
                    this.zzc = sensorManager2.getDefaultSensor(1);
                }
                if (!this.zzg && (sensorManager = this.zzb) != null && (sensor = this.zzc) != null) {
                    sensorManager.registerListener(this, sensor, 2);
                    this.zzd = com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis() - ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjv)).intValue();
                    this.zzg = true;
                    com.google.android.gms.ads.internal.util.zze.zza("Listening for shake gestures.");
                }
            }
        }
    }

    public final void zzd(zzdwk zzdwkVar) {
        this.zzf = zzdwkVar;
    }
}
