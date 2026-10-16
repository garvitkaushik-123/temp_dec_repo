package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbmc implements zzapw {
    private volatile zzblp zza;
    private final Context zzb;

    public zzbmc(Context context) {
        this.zzb = context;
    }

    static /* bridge */ /* synthetic */ void zzc(zzbmc zzbmcVar) {
        if (zzbmcVar.zza == null) {
            return;
        }
        zzbmcVar.zza.disconnect();
        Binder.flushPendingCommands();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzapw
    public final zzapz zza(zzaqd zzaqdVar) throws zzaqm {
        Parcelable.Creator<zzblq> creator = zzblq.CREATOR;
        Map zzl = zzaqdVar.zzl();
        int size = zzl.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Map.Entry entry : zzl.entrySet()) {
            strArr[i] = (String) entry.getKey();
            strArr2[i] = (String) entry.getValue();
            i++;
        }
        zzblq zzblqVar = new zzblq(zzaqdVar.zzk(), strArr, strArr2);
        long elapsedRealtime = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime();
        try {
            zzcak zzcakVar = new zzcak();
            this.zza = new zzblp(this.zzb, com.google.android.gms.ads.internal.zzv.zzv().zzb(), new zzbma(this, zzcakVar), new zzbmb(this, zzcakVar));
            this.zza.checkAvailabilityAndConnect();
            zzbly zzblyVar = new zzbly(this, zzblqVar);
            zzgdy zzgdyVar = zzcaf.zza;
            ListenableFuture zzo = zzgdn.zzo(zzgdn.zzn(zzcakVar, zzblyVar, zzgdyVar), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeL)).intValue(), TimeUnit.MILLISECONDS, zzcaf.zzd);
            zzo.addListener(new zzblz(this), zzgdyVar);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzo.get();
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - elapsedRealtime) + "ms");
            zzbls zzblsVar = (zzbls) new zzbvo(parcelFileDescriptor).zza(zzbls.CREATOR);
            if (zzblsVar == null) {
                return null;
            }
            if (zzblsVar.zza) {
                throw new zzaqm(zzblsVar.zzb);
            }
            String[] strArr3 = zzblsVar.zze;
            String[] strArr4 = zzblsVar.zzf;
            if (strArr3.length != strArr4.length) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < strArr3.length; i2++) {
                hashMap.put(strArr3[i2], strArr4[i2]);
            }
            return new zzapz(zzblsVar.zzc, zzblsVar.zzd, hashMap, zzblsVar.zzg, zzblsVar.zzh);
        } catch (InterruptedException | ExecutionException unused) {
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - elapsedRealtime) + "ms");
            return null;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - elapsedRealtime) + "ms");
            throw th;
        }
    }
}
