package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzdvh;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzay {
    private zzdvi zzg;
    private final Object zzb = new Object();
    private String zzc = "";
    private String zzd = "";
    private boolean zze = false;
    private boolean zzf = false;
    protected String zza = "";

    /* JADX WARN: Multi-variable type inference failed */
    protected static final String zzo(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", com.google.android.gms.ads.internal.zzv.zzr().zzc(context, str2));
        ListenableFuture zzb = new zzbo(context).zzb(0, str, hashMap, null);
        try {
            return (String) zzb.get(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfl)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            String valueOf = String.valueOf(str);
            int i = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Interrupted while retrieving a response from: ".concat(valueOf), e);
            zzb.cancel(true);
            return null;
        } catch (TimeoutException e2) {
            String valueOf2 = String.valueOf(str);
            int i2 = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Timeout while retrieving a response from: ".concat(valueOf2), e2);
            zzb.cancel(true);
            return null;
        } catch (Exception e3) {
            String valueOf3 = String.valueOf(str);
            int i3 = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error retrieving a response from: ".concat(valueOf3), e3);
            return null;
        }
    }

    private final Uri zzp(Context context, String str, String str2, String str3) {
        String str4;
        String str5;
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        synchronized (this.zzb) {
            if (TextUtils.isEmpty(this.zzc)) {
                com.google.android.gms.ads.internal.zzv.zzr();
                try {
                    str5 = new String(IOUtils.readInputStreamFully(context.openFileInput("debug_signals_id.txt"), true), "UTF-8");
                } catch (IOException unused) {
                    int i = zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zze("Error reading from internal storage.");
                    str5 = "";
                }
                this.zzc = str5;
                if (TextUtils.isEmpty(str5)) {
                    com.google.android.gms.ads.internal.zzv.zzr();
                    this.zzc = UUID.randomUUID().toString();
                    com.google.android.gms.ads.internal.zzv.zzr();
                    String str6 = this.zzc;
                    try {
                        FileOutputStream openFileOutput = context.openFileOutput("debug_signals_id.txt", 0);
                        openFileOutput.write(str6.getBytes("UTF-8"));
                        openFileOutput.close();
                    } catch (Exception e) {
                        int i2 = zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Error writing to file in internal storage.", e);
                    }
                }
            }
            str4 = this.zzc;
        }
        buildUpon.appendQueryParameter("linkedDeviceId", str4);
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    public final zzdvi zza() {
        return this.zzg;
    }

    public final String zzb() {
        String str;
        synchronized (this.zzb) {
            str = this.zzd;
        }
        return str;
    }

    public final void zzc(Context context) {
        zzdvi zzdviVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjE)).booleanValue() || (zzdviVar = this.zzg) == null) {
            return;
        }
        zzdviVar.zzh(new zzav(this, context), zzdvh.DEBUG_MENU);
    }

    public final void zzd(Context context, String str, String str2) {
        com.google.android.gms.ads.internal.zzv.zzr();
        zzs.zzV(context, zzp(context, (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfh), str, str2));
    }

    public final void zze(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzp(context, (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfk), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        com.google.android.gms.ads.internal.zzv.zzr();
        zzs.zzM(context, str, buildUpon.build().toString());
    }

    public final void zzf(boolean z) {
        synchronized (this.zzb) {
            this.zzf = z;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjE)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zzp().zzi().zzx(z);
                zzdvi zzdviVar = this.zzg;
                if (zzdviVar != null) {
                    zzdviVar.zzl(z);
                }
            }
        }
    }

    public final void zzg(zzdvi zzdviVar) {
        this.zzg = zzdviVar;
    }

    public final void zzh(boolean z) {
        synchronized (this.zzb) {
            this.zze = z;
        }
    }

    protected final void zzi(Context context, String str, boolean z, boolean z2) {
        if (context instanceof Activity) {
            zzs.zza.post(new zzax(this, context, str, z, z2));
        } else {
            int i = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Can not create dialog without Activity Context");
        }
    }

    public final boolean zzj(Context context, String str, String str2) {
        String zzo = zzo(context, zzp(context, (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfj), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzo)) {
            int i = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(zzo.trim()).optString("debug_mode"));
            zzf(equals);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjE)).booleanValue()) {
                zzg zzi = com.google.android.gms.ads.internal.zzv.zzp().zzi();
                if (true != equals) {
                    str = "";
                }
                zzi.zzw(str);
            }
            return equals;
        } catch (JSONException e) {
            int i2 = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Fail to get debug mode response json.", e);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final boolean zzk(Context context, String str, String str2) {
        boolean z;
        String zzo = zzo(context, zzp(context, (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfi), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzo)) {
            int i = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(zzo.trim());
            String optString = jSONObject.optString("gct");
            this.zza = jSONObject.optString("status");
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjE)).booleanValue()) {
                if (!"0".equals(this.zza) && !"2".equals(this.zza)) {
                    z = false;
                    zzf(z);
                    zzg zzi = com.google.android.gms.ads.internal.zzv.zzp().zzi();
                    if (!z) {
                        str = "";
                    }
                    zzi.zzw(str);
                }
                z = true;
                zzf(z);
                zzg zzi2 = com.google.android.gms.ads.internal.zzv.zzp().zzi();
                if (!z) {
                }
                zzi2.zzw(str);
            }
            synchronized (this.zzb) {
                this.zzd = optString;
            }
            return true;
        } catch (JSONException e) {
            int i2 = zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Fail to get in app preview response json.", e);
            return false;
        }
    }

    public final boolean zzl() {
        boolean z;
        synchronized (this.zzb) {
            z = this.zzf;
        }
        return z;
    }

    public final boolean zzm() {
        boolean z;
        synchronized (this.zzb) {
            z = this.zze;
        }
        return z;
    }

    public final boolean zzn(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzm()) {
            return false;
        }
        int i = zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Sending troubleshooting signals to the server.");
        zze(context, str, str2, str3);
        return true;
    }
}
