package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzdsj;
import com.google.firebase.sessions.settings.RemoteSettings;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zza {
    public static final boolean zza(Context context, Intent intent, zzad zzadVar, zzaa zzaaVar, boolean z, zzdsj zzdsjVar, String str) {
        if (z) {
            return zzc(context, intent.getData(), zzadVar, zzaaVar);
        }
        try {
            com.google.android.gms.ads.internal.util.zze.zza("Launching an intent: " + intent.toURI());
            if (((Boolean) zzbd.zzc().zzb(zzbde.zznx)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zzr();
                com.google.android.gms.ads.internal.util.zzs.zzY(context, intent, zzdsjVar, str);
            } else {
                com.google.android.gms.ads.internal.zzv.zzr();
                com.google.android.gms.ads.internal.util.zzs.zzU(context, intent);
            }
            if (zzadVar != null) {
                zzadVar.zzg();
            }
            if (zzaaVar != null) {
                zzaaVar.zza(true);
            }
            return true;
        } catch (ActivityNotFoundException e) {
            String message = e.getMessage();
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(message);
            if (zzaaVar != null) {
                zzaaVar.zza(false);
            }
            return false;
        }
    }

    public static final boolean zzb(Context context, zzc zzcVar, zzad zzadVar, zzaa zzaaVar, zzdsj zzdsjVar, String str) {
        int i = 0;
        if (zzcVar == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("No intent data for launcher overlay.");
            return false;
        }
        zzbde.zza(context);
        Intent intent = zzcVar.zzh;
        if (intent != null) {
            return zza(context, intent, zzadVar, zzaaVar, zzcVar.zzj, zzdsjVar, str);
        }
        Intent intent2 = new Intent();
        String str2 = zzcVar.zzb;
        if (TextUtils.isEmpty(str2)) {
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Open GMSG did not contain a URL.");
            return false;
        }
        String str3 = zzcVar.zzc;
        if (TextUtils.isEmpty(str3)) {
            intent2.setData(Uri.parse(str2));
        } else {
            intent2.setDataAndType(Uri.parse(str2), str3);
        }
        intent2.setAction("android.intent.action.VIEW");
        String str4 = zzcVar.zzd;
        if (!TextUtils.isEmpty(str4)) {
            intent2.setPackage(str4);
        }
        String str5 = zzcVar.zze;
        if (!TextUtils.isEmpty(str5)) {
            String[] split = str5.split(RemoteSettings.FORWARD_SLASH_STRING, 2);
            if (split.length < 2) {
                String valueOf = String.valueOf(str5);
                int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not parse component name from open GMSG: ".concat(valueOf));
                return false;
            }
            intent2.setClassName(split[0], split[1]);
        }
        String str6 = zzcVar.zzf;
        if (!TextUtils.isEmpty(str6)) {
            try {
                i = Integer.parseInt(str6);
            } catch (NumberFormatException unused) {
                int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not parse intent flags.");
            }
            intent2.addFlags(i);
        }
        if (((Boolean) zzbd.zzc().zzb(zzbde.zzeQ)).booleanValue()) {
            intent2.addFlags(268435456);
            intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzbd.zzc().zzb(zzbde.zzeP)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zzr();
                com.google.android.gms.ads.internal.util.zzs.zzp(context, intent2);
            }
        }
        return zza(context, intent2, zzadVar, zzaaVar, zzcVar.zzj, zzdsjVar, str);
    }

    private static final boolean zzc(Context context, Uri uri, zzad zzadVar, zzaa zzaaVar) {
        int i;
        try {
            i = com.google.android.gms.ads.internal.zzv.zzr().zzn(context, uri);
            if (zzadVar != null) {
                zzadVar.zzg();
            }
        } catch (ActivityNotFoundException e) {
            String message = e.getMessage();
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(message);
            i = 6;
        }
        if (zzaaVar != null) {
            zzaaVar.zzb(i);
        }
        return i == 5;
    }
}
