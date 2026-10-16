package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbiv;
import com.google.android.gms.internal.ads.zzbix;
import com.google.android.gms.internal.ads.zzbtj;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcfg;
import com.google.android.gms.internal.ads.zzcwl;
import com.google.android.gms.internal.ads.zzded;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzo();
    private static final AtomicLong zzy = new AtomicLong(0);
    private static final ConcurrentHashMap zzz = new ConcurrentHashMap();
    public final zzc zza;
    public final com.google.android.gms.ads.internal.client.zza zzb;
    public final zzr zzc;
    public final zzcfg zzd;
    public final zzbix zze;
    public final String zzf;
    public final boolean zzg;
    public final String zzh;
    public final zzad zzi;
    public final int zzj;
    public final int zzk;
    public final String zzl;
    public final VersionInfoParcel zzm;
    public final String zzn;
    public final com.google.android.gms.ads.internal.zzl zzo;
    public final zzbiv zzp;
    public final String zzq;
    public final String zzr;
    public final String zzs;
    public final zzcwl zzt;
    public final zzded zzu;
    public final zzbtj zzv;
    public final boolean zzw;
    public final long zzx;

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzr zzrVar, zzbiv zzbivVar, zzbix zzbixVar, zzad zzadVar, zzcfg zzcfgVar, boolean z, int i, String str, VersionInfoParcel versionInfoParcel, zzded zzdedVar, zzbtj zzbtjVar, boolean z2) {
        this.zza = null;
        this.zzb = zzaVar;
        this.zzc = zzrVar;
        this.zzd = zzcfgVar;
        this.zzp = zzbivVar;
        this.zze = zzbixVar;
        this.zzf = null;
        this.zzg = z;
        this.zzh = null;
        this.zzi = zzadVar;
        this.zzj = i;
        this.zzk = 3;
        this.zzl = str;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = zzdedVar;
        this.zzv = zzbtjVar;
        this.zzw = z2;
        this.zzx = zzy.getAndIncrement();
    }

    public static AdOverlayInfoParcel zza(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception e) {
            if (!((Boolean) zzbd.zzc().zzb(zzbde.zzno)).booleanValue()) {
                return null;
            }
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AdOverlayInfoParcel.getFromIntent");
            return null;
        }
    }

    private static final IBinder zzc(Object obj) {
        if (((Boolean) zzbd.zzc().zzb(zzbde.zzno)).booleanValue()) {
            return null;
        }
        return ObjectWrapper.wrap(obj).asBinder();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i, false);
        com.google.android.gms.ads.internal.client.zza zzaVar = this.zzb;
        SafeParcelWriter.writeIBinder(parcel, 3, zzc(zzaVar), false);
        zzr zzrVar = this.zzc;
        SafeParcelWriter.writeIBinder(parcel, 4, zzc(zzrVar), false);
        zzcfg zzcfgVar = this.zzd;
        SafeParcelWriter.writeIBinder(parcel, 5, zzc(zzcfgVar), false);
        zzbix zzbixVar = this.zze;
        SafeParcelWriter.writeIBinder(parcel, 6, zzc(zzbixVar), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzg);
        SafeParcelWriter.writeString(parcel, 9, this.zzh, false);
        zzad zzadVar = this.zzi;
        SafeParcelWriter.writeIBinder(parcel, 10, zzc(zzadVar), false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzj);
        SafeParcelWriter.writeInt(parcel, 12, this.zzk);
        SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzm, i, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzn, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzo, i, false);
        zzbiv zzbivVar = this.zzp;
        SafeParcelWriter.writeIBinder(parcel, 18, zzc(zzbivVar), false);
        SafeParcelWriter.writeString(parcel, 19, this.zzq, false);
        SafeParcelWriter.writeString(parcel, 24, this.zzr, false);
        SafeParcelWriter.writeString(parcel, 25, this.zzs, false);
        zzcwl zzcwlVar = this.zzt;
        SafeParcelWriter.writeIBinder(parcel, 26, zzc(zzcwlVar), false);
        zzded zzdedVar = this.zzu;
        SafeParcelWriter.writeIBinder(parcel, 27, zzc(zzdedVar), false);
        zzbtj zzbtjVar = this.zzv;
        SafeParcelWriter.writeIBinder(parcel, 28, zzc(zzbtjVar), false);
        SafeParcelWriter.writeBoolean(parcel, 29, this.zzw);
        long j = this.zzx;
        SafeParcelWriter.writeLong(parcel, 30, j);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if (((Boolean) zzbd.zzc().zzb(zzbde.zzno)).booleanValue()) {
            zzz.put(Long.valueOf(j), new zzp(zzaVar, zzrVar, zzcfgVar, zzbivVar, zzbixVar, zzadVar, zzcwlVar, zzdedVar, zzbtjVar, zzcaf.zzd.schedule(new zzq(j), ((Integer) zzbd.zzc().zzb(zzbde.zznq)).intValue(), TimeUnit.SECONDS)));
        }
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzr zzrVar, zzbiv zzbivVar, zzbix zzbixVar, zzad zzadVar, zzcfg zzcfgVar, boolean z, int i, String str, String str2, VersionInfoParcel versionInfoParcel, zzded zzdedVar, zzbtj zzbtjVar) {
        this.zza = null;
        this.zzb = zzaVar;
        this.zzc = zzrVar;
        this.zzd = zzcfgVar;
        this.zzp = zzbivVar;
        this.zze = zzbixVar;
        this.zzf = str2;
        this.zzg = z;
        this.zzh = str;
        this.zzi = zzadVar;
        this.zzj = i;
        this.zzk = 3;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = zzdedVar;
        this.zzv = zzbtjVar;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzr zzrVar, zzad zzadVar, zzcfg zzcfgVar, int i, VersionInfoParcel versionInfoParcel, String str, com.google.android.gms.ads.internal.zzl zzlVar, String str2, String str3, String str4, zzcwl zzcwlVar, zzbtj zzbtjVar, String str5) {
        this.zza = null;
        this.zzb = null;
        this.zzc = zzrVar;
        this.zzd = zzcfgVar;
        this.zzp = null;
        this.zze = null;
        this.zzg = false;
        if (((Boolean) zzbd.zzc().zzb(zzbde.zzaX)).booleanValue()) {
            this.zzf = null;
            this.zzh = null;
        } else {
            this.zzf = str2;
            this.zzh = str3;
        }
        this.zzi = null;
        this.zzj = i;
        this.zzk = 1;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = str;
        this.zzo = zzlVar;
        this.zzq = str5;
        this.zzr = null;
        this.zzs = str4;
        this.zzt = zzcwlVar;
        this.zzu = null;
        this.zzv = zzbtjVar;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }

    public AdOverlayInfoParcel(com.google.android.gms.ads.internal.client.zza zzaVar, zzr zzrVar, zzad zzadVar, zzcfg zzcfgVar, boolean z, int i, VersionInfoParcel versionInfoParcel, zzded zzdedVar, zzbtj zzbtjVar) {
        this.zza = null;
        this.zzb = zzaVar;
        this.zzc = zzrVar;
        this.zzd = zzcfgVar;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = z;
        this.zzh = null;
        this.zzi = zzadVar;
        this.zzj = i;
        this.zzk = 2;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = zzdedVar;
        this.zzv = zzbtjVar;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }

    AdOverlayInfoParcel(zzc zzcVar, IBinder iBinder, IBinder iBinder2, IBinder iBinder3, IBinder iBinder4, String str, boolean z, String str2, IBinder iBinder5, int i, int i2, String str3, VersionInfoParcel versionInfoParcel, String str4, com.google.android.gms.ads.internal.zzl zzlVar, IBinder iBinder6, String str5, String str6, String str7, IBinder iBinder7, IBinder iBinder8, IBinder iBinder9, boolean z2, long j) {
        com.google.android.gms.ads.internal.client.zza zzaVar;
        zzr zzrVar;
        zzcfg zzcfgVar;
        zzbiv zzbivVar;
        zzbix zzbixVar;
        zzcwl zzcwlVar;
        zzded zzdedVar;
        zzbtj zzbtjVar;
        zzad zzadVar;
        ScheduledFuture scheduledFuture;
        this.zza = zzcVar;
        this.zzf = str;
        this.zzg = z;
        this.zzh = str2;
        this.zzj = i;
        this.zzk = i2;
        this.zzl = str3;
        this.zzm = versionInfoParcel;
        this.zzn = str4;
        this.zzo = zzlVar;
        this.zzq = str5;
        this.zzr = str6;
        this.zzs = str7;
        this.zzw = z2;
        this.zzx = j;
        if (((Boolean) zzbd.zzc().zzb(zzbde.zzno)).booleanValue()) {
            zzp zzpVar = (zzp) zzz.remove(Long.valueOf(j));
            if (zzpVar != null) {
                zzaVar = zzpVar.zza;
                this.zzb = zzaVar;
                zzrVar = zzpVar.zzb;
                this.zzc = zzrVar;
                zzcfgVar = zzpVar.zzc;
                this.zzd = zzcfgVar;
                zzbivVar = zzpVar.zzd;
                this.zzp = zzbivVar;
                zzbixVar = zzpVar.zze;
                this.zze = zzbixVar;
                zzcwlVar = zzpVar.zzg;
                this.zzt = zzcwlVar;
                zzdedVar = zzpVar.zzh;
                this.zzu = zzdedVar;
                zzbtjVar = zzpVar.zzi;
                this.zzv = zzbtjVar;
                zzadVar = zzpVar.zzf;
                this.zzi = zzadVar;
                scheduledFuture = zzpVar.zzj;
                scheduledFuture.cancel(false);
                return;
            }
            throw new NullPointerException("AdOverlayObjects is null");
        }
        this.zzb = (com.google.android.gms.ads.internal.client.zza) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzc = (zzr) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
        this.zzd = (zzcfg) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder3));
        this.zzp = (zzbiv) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder6));
        this.zze = (zzbix) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder4));
        this.zzi = (zzad) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder5));
        this.zzt = (zzcwl) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder7));
        this.zzu = (zzded) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder8));
        this.zzv = (zzbtj) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder9));
    }

    public AdOverlayInfoParcel(zzc zzcVar, com.google.android.gms.ads.internal.client.zza zzaVar, zzr zzrVar, zzad zzadVar, VersionInfoParcel versionInfoParcel, zzcfg zzcfgVar, zzded zzdedVar, String str) {
        this.zza = zzcVar;
        this.zzb = zzaVar;
        this.zzc = zzrVar;
        this.zzd = zzcfgVar;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = zzadVar;
        this.zzj = -1;
        this.zzk = 4;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = str;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = zzdedVar;
        this.zzv = null;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }

    public AdOverlayInfoParcel(zzr zzrVar, zzcfg zzcfgVar, int i, VersionInfoParcel versionInfoParcel) {
        this.zzc = zzrVar;
        this.zzd = zzcfgVar;
        this.zzj = 1;
        this.zzm = versionInfoParcel;
        this.zza = null;
        this.zzb = null;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzk = 1;
        this.zzl = null;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = null;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }

    public AdOverlayInfoParcel(zzcfg zzcfgVar, VersionInfoParcel versionInfoParcel, String str, String str2, int i, zzbtj zzbtjVar) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzcfgVar;
        this.zzp = null;
        this.zze = null;
        this.zzf = null;
        this.zzg = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = 14;
        this.zzk = 5;
        this.zzl = null;
        this.zzm = versionInfoParcel;
        this.zzn = null;
        this.zzo = null;
        this.zzq = str;
        this.zzr = str2;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
        this.zzv = zzbtjVar;
        this.zzw = false;
        this.zzx = zzy.getAndIncrement();
    }
}
