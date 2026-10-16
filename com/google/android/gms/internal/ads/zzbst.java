package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import io.bidmachine.iab.mraid.MraidNativeFeature;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbst extends zzbsu implements zzbkf {
    DisplayMetrics zza;
    int zzb;
    int zzc;
    int zzd;
    int zze;
    int zzf;
    int zzg;
    private final zzcfg zzh;
    private final Context zzi;
    private final WindowManager zzj;
    private final zzbcm zzk;
    private float zzl;
    private int zzm;

    public zzbst(zzcfg zzcfgVar, Context context, zzbcm zzbcmVar) {
        super(zzcfgVar, "");
        this.zzb = -1;
        this.zzc = -1;
        this.zzd = -1;
        this.zze = -1;
        this.zzf = -1;
        this.zzg = -1;
        this.zzh = zzcfgVar;
        this.zzi = context;
        this.zzk = zzbcmVar;
        this.zzj = (WindowManager) context.getSystemService("window");
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* synthetic */ void zza(Object obj, Map map) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        JSONObject jSONObject;
        this.zza = new DisplayMetrics();
        Display defaultDisplay = this.zzj.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zza);
        this.zzl = this.zza.density;
        this.zzm = defaultDisplay.getRotation();
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        DisplayMetrics displayMetrics = this.zza;
        this.zzb = com.google.android.gms.ads.internal.util.client.zzf.zzA(displayMetrics, displayMetrics.widthPixels);
        com.google.android.gms.ads.internal.client.zzbb.zzb();
        DisplayMetrics displayMetrics2 = this.zza;
        this.zzc = com.google.android.gms.ads.internal.util.client.zzf.zzA(displayMetrics2, displayMetrics2.heightPixels);
        zzcfg zzcfgVar = this.zzh;
        Activity zzi = zzcfgVar.zzi();
        if (zzi == null || zzi.getWindow() == null) {
            this.zzd = this.zzb;
            this.zze = this.zzc;
        } else {
            com.google.android.gms.ads.internal.zzv.zzr();
            int[] zzR = com.google.android.gms.ads.internal.util.zzs.zzR(zzi);
            com.google.android.gms.ads.internal.client.zzbb.zzb();
            this.zzd = com.google.android.gms.ads.internal.util.client.zzf.zzA(this.zza, zzR[0]);
            com.google.android.gms.ads.internal.client.zzbb.zzb();
            this.zze = com.google.android.gms.ads.internal.util.client.zzf.zzA(this.zza, zzR[1]);
        }
        if (zzcfgVar.zzO().zzi()) {
            this.zzf = this.zzb;
            this.zzg = this.zzc;
        } else {
            zzcfgVar.measure(0, 0);
        }
        zzj(this.zzb, this.zzc, this.zzd, this.zze, this.zzl, this.zzm);
        zzbss zzbssVar = new zzbss();
        zzbcm zzbcmVar = this.zzk;
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        zzbssVar.zze(zzbcmVar.zza(intent));
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("sms:"));
        zzbssVar.zzc(zzbcmVar.zza(intent2));
        zzbssVar.zza(zzbcmVar.zzb());
        zzbssVar.zzd(zzbcmVar.zzc());
        zzbssVar.zzb(true);
        z = zzbssVar.zza;
        z2 = zzbssVar.zzb;
        z3 = zzbssVar.zzc;
        z4 = zzbssVar.zzd;
        z5 = zzbssVar.zze;
        try {
            jSONObject = new JSONObject().put("sms", z).put("tel", z2).put("calendar", z3).put("storePicture", z4).put(MraidNativeFeature.FEATURE_INLINE_VIDEO, z5);
        } catch (JSONException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error occurred while obtaining the MRAID capabilities.", e);
            jSONObject = null;
        }
        zzcfgVar.zze("onDeviceFeaturesReceived", jSONObject);
        int[] iArr = new int[2];
        zzcfgVar.getLocationOnScreen(iArr);
        Context context = this.zzi;
        zzb(com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, iArr[0]), com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, iArr[1]));
        if (com.google.android.gms.ads.internal.util.zze.zzm(2)) {
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Dispatching Ready Event.");
        }
        zzi(zzcfgVar.zzm().afmaVersion);
    }

    public final void zzb(int i, int i2) {
        int i3;
        Context context = this.zzi;
        int i4 = 0;
        if (context instanceof Activity) {
            com.google.android.gms.ads.internal.zzv.zzr();
            i3 = com.google.android.gms.ads.internal.util.zzs.zzS((Activity) context)[0];
        } else {
            i3 = 0;
        }
        zzcfg zzcfgVar = this.zzh;
        if (zzcfgVar.zzO() == null || !zzcfgVar.zzO().zzi()) {
            int width = zzcfgVar.getWidth();
            int height = zzcfgVar.getHeight();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzai)).booleanValue()) {
                if (width == 0) {
                    width = zzcfgVar.zzO() != null ? zzcfgVar.zzO().zzb : 0;
                }
                if (height == 0) {
                    if (zzcfgVar.zzO() != null) {
                        i4 = zzcfgVar.zzO().zza;
                    }
                    this.zzf = com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, width);
                    this.zzg = com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, i4);
                }
            }
            i4 = height;
            this.zzf = com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, width);
            this.zzg = com.google.android.gms.ads.internal.client.zzbb.zzb().zzb(context, i4);
        }
        zzg(i, i2 - i3, this.zzf, this.zzg);
        zzcfgVar.zzN().zzE(i, i2);
    }
}
