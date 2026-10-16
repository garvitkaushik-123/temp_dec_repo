package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.internal.ads.zzbze;
import com.google.android.gms.internal.ads.zzfhj;
import com.google.android.gms.internal.ads.zzfhu;
import com.google.android.gms.internal.ads.zzgdj;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
final class zzaq implements zzgdj {
    final /* synthetic */ ListenableFuture zza;
    final /* synthetic */ zzbze zzb;
    final /* synthetic */ zzbyx zzc;
    final /* synthetic */ zzfhj zzd;
    final /* synthetic */ zzau zze;

    zzaq(zzau zzauVar, ListenableFuture listenableFuture, zzbze zzbzeVar, zzbyx zzbyxVar, zzfhj zzfhjVar) {
        this.zza = listenableFuture;
        this.zzb = zzbzeVar;
        this.zzc = zzbyxVar;
        this.zzd = zzfhjVar;
        Objects.requireNonNull(zzauVar);
        this.zze = zzauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        String message = th.getMessage();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzia)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zzp().zzv(th, "SignalGeneratorImpl.generateSignals");
        } else {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "SignalGeneratorImpl.generateSignals");
        }
        zzfhu zzs = zzau.zzs(this.zza, this.zzb);
        if (((Boolean) zzbex.zze.zze()).booleanValue() && zzs != null) {
            zzfhj zzfhjVar = this.zzd;
            zzfhjVar.zzh(th);
            zzfhjVar.zzg(false);
            zzs.zza(zzfhjVar);
            zzs.zzh();
        }
        zzbyx zzbyxVar = this.zzc;
        if (zzbyxVar == null) {
            return;
        }
        try {
            if (!"Unknown format is no longer supported.".equals(message)) {
                message = "Internal error. " + message;
            }
            zzbyxVar.zzb(message);
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        AtomicBoolean atomicBoolean;
        boolean z;
        boolean z2;
        String str;
        String str2;
        String str3;
        String str4;
        Context context;
        VersionInfoParcel versionInfoParcel;
        String str5;
        String str6;
        AtomicInteger atomicInteger;
        zzbk zzbkVar = (zzbk) obj;
        zzfhu zzs = zzau.zzs(this.zza, this.zzb);
        atomicBoolean = this.zze.zzG;
        atomicBoolean.set(true);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhU)).booleanValue()) {
            try {
                zzbyx zzbyxVar = this.zzc;
                if (zzbyxVar != null) {
                    zzbyxVar.zzb("QueryInfo generation has been disabled.");
                }
            } catch (RemoteException e) {
                String concat = "QueryInfo generation has been disabled.".concat(e.toString());
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg(concat);
            }
            if (!((Boolean) zzbex.zze.zze()).booleanValue() || zzs == null) {
                return;
            }
            zzfhj zzfhjVar = this.zzd;
            zzfhjVar.zzc("QueryInfo generation has been disabled.");
            zzfhjVar.zzg(false);
            zzs.zza(zzfhjVar);
            zzs.zzh();
            return;
        }
        try {
            try {
                if (zzbkVar == null) {
                    zzbyx zzbyxVar2 = this.zzc;
                    if (zzbyxVar2 != null) {
                        zzbyxVar2.zzc(null, null, null);
                    }
                    zzfhj zzfhjVar2 = this.zzd;
                    zzfhjVar2.zzg(true);
                    if (!((Boolean) zzbex.zze.zze()).booleanValue() || zzs == null) {
                        return;
                    }
                    zzs.zza(zzfhjVar2);
                    zzs.zzh();
                    return;
                }
                try {
                    if (TextUtils.isEmpty((!TextUtils.isEmpty(zzbkVar.zzc) ? new JSONObject(zzbkVar.zzc) : new JSONObject(zzbkVar.zzb)).optString("request_id", ""))) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("The request ID is empty in request JSON.");
                        zzbyx zzbyxVar3 = this.zzc;
                        if (zzbyxVar3 != null) {
                            zzbyxVar3.zzb("Internal error: request ID is empty in request JSON.");
                        }
                        zzfhj zzfhjVar3 = this.zzd;
                        zzfhjVar3.zzc("Request ID empty");
                        zzfhjVar3.zzg(false);
                        if (!((Boolean) zzbex.zze.zze()).booleanValue() || zzs == null) {
                            return;
                        }
                        zzs.zza(zzfhjVar3);
                        zzs.zzh();
                        return;
                    }
                    Bundle bundle = zzbkVar.zzf;
                    zzau zzauVar = this.zze;
                    z = zzauVar.zzu;
                    if (z && bundle != null) {
                        str5 = zzauVar.zzw;
                        if (bundle.getInt(str5, -1) == -1) {
                            str6 = zzauVar.zzw;
                            atomicInteger = zzauVar.zzx;
                            bundle.putInt(str6, atomicInteger.get());
                        }
                    }
                    z2 = zzauVar.zzt;
                    if (z2 && bundle != null) {
                        str = zzauVar.zzv;
                        if (TextUtils.isEmpty(bundle.getString(str))) {
                            str2 = zzauVar.zzz;
                            if (TextUtils.isEmpty(str2)) {
                                com.google.android.gms.ads.internal.util.zzs zzr = com.google.android.gms.ads.internal.zzv.zzr();
                                context = zzauVar.zzg;
                                versionInfoParcel = zzauVar.zzy;
                                zzauVar.zzz = zzr.zzc(context, versionInfoParcel.afmaVersion);
                            }
                            str3 = zzauVar.zzv;
                            str4 = zzauVar.zzz;
                            bundle.putString(str3, str4);
                        }
                    }
                    zzbyx zzbyxVar4 = this.zzc;
                    if (zzbyxVar4 != null) {
                        if (TextUtils.isEmpty(zzbkVar.zzc)) {
                            zzbyxVar4.zzc(zzbkVar.zza, zzbkVar.zzb, bundle);
                        } else {
                            zzbyxVar4.zzc(zzbkVar.zza, zzbkVar.zzc, bundle);
                        }
                    }
                    this.zzd.zzg(true);
                    if (!((Boolean) zzbex.zze.zze()).booleanValue() || zzs == null) {
                        return;
                    }
                    zzs.zza(this.zzd);
                    zzs.zzh();
                } catch (JSONException e2) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to create JSON object from the request string.");
                    zzbyx zzbyxVar5 = this.zzc;
                    if (zzbyxVar5 != null) {
                        zzbyxVar5.zzb("Internal error for request JSON: " + e2.toString());
                    }
                    zzfhj zzfhjVar4 = this.zzd;
                    zzfhjVar4.zzh(e2);
                    zzfhjVar4.zzg(false);
                    com.google.android.gms.ads.internal.zzv.zzp().zzw(e2, "SignalGeneratorImpl.generateSignals.onSuccess");
                    if (!((Boolean) zzbex.zze.zze()).booleanValue() || zzs == null) {
                        return;
                    }
                    zzs.zza(zzfhjVar4);
                    zzs.zzh();
                }
            } catch (RemoteException e3) {
                zzfhj zzfhjVar5 = this.zzd;
                zzfhjVar5.zzh(e3);
                zzfhjVar5.zzg(false);
                int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", e3);
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e3, "SignalGeneratorImpl.generateSignals.onSuccess");
                if (!((Boolean) zzbex.zze.zze()).booleanValue() || zzs == null) {
                    return;
                }
                zzs.zza(this.zzd);
                zzs.zzh();
            }
        } catch (Throwable th) {
            if (((Boolean) zzbex.zze.zze()).booleanValue() && zzs != null) {
                zzs.zza(this.zzd);
                zzs.zzh();
            }
            throw th;
        }
    }
}
