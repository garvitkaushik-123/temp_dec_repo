package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.webkit.WebViewFeature;
import com.ironsource.C3040d4;
import com.ironsource.Y1;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdrp implements zzcza, zzcxm, zzcwb, zzdep {
    private final zzdsd zza;
    private final zzdso zzb;
    private final int zzc;

    zzdrp(zzdsd zzdsdVar, zzdso zzdsoVar, int i) {
        this.zza = zzdsdVar;
        this.zzb = zzdsoVar;
        this.zzc = i;
    }

    private final void zzc(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            long j = bundle.getLong(str);
            if (j >= 0) {
                this.zza.zzd(str, String.valueOf(j));
            }
        }
    }

    private final void zzd(Bundle bundle, zzfyq zzfyqVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcq)).booleanValue() || bundle == null) {
            return;
        }
        bundle.putLong(zzdrr.PUBLIC_API_CALLBACK.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        zzdsd zzdsdVar = this.zza;
        zzdsdVar.zzc();
        if (bundle.containsKey("ls")) {
            zzdsdVar.zzd("ls", true != bundle.getBoolean("ls") ? "0" : "1");
        }
        int size = zzfyqVar.size();
        for (int i = 0; i < size; i++) {
            zzdrs zzdrsVar = (zzdrs) zzfyqVar.get(i);
            long j = bundle.getLong(zzdrsVar.zza().zza(), -1L);
            long j2 = bundle.getLong(zzdrsVar.zzb().zza(), -1L);
            if (j > 0 && j2 > 0) {
                zzdsdVar.zzd(zzdrsVar.zzc(), String.valueOf(j2 - j));
            }
        }
        zzc(bundle.getBundle("client_sig_latency_key"));
        zzc(bundle.getBundle("gms_sig_latency_key"));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhN)).booleanValue()) {
            if (bundle.containsKey("sod_h")) {
                zzdsdVar.zzd("sod_h", true == bundle.getBoolean("sod_h") ? "1" : "0");
            }
            if (bundle.containsKey("cmr")) {
                zzdsdVar.zzd("cmr", String.valueOf(bundle.getInt("cmr")));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzdD(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzdsd zzdsdVar = this.zza;
        zzdsdVar.zzb().put("action", "ftl");
        zzdsdVar.zzd("ftl", String.valueOf(zzeVar.zza));
        zzdsdVar.zzd("ed", zzeVar.zzc);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhv)).booleanValue()) {
            zzdsdVar.zzd("emsg", zzeVar.zzb);
        }
        this.zzb.zzg(zzdsdVar.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdn(zzbvq zzbvqVar) {
        this.zza.zzf(zzbvqVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzcza
    public final void zzdo(zzfcn zzfcnVar) {
        this.zza.zze(zzfcnVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00cd  */
    @Override // com.google.android.gms.internal.ads.zzdep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zze(com.google.android.gms.ads.nonagon.signalgeneration.zzbk zzbkVar) {
        String str;
        zzbvq zzbvqVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhg)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhN)).booleanValue()) {
                this.zza.zzb().put("sgw", String.valueOf(this.zzc));
            }
            if (zzbkVar == null) {
                zzdsd zzdsdVar = this.zza;
                zzdsdVar.zzb().put("action", "sgs");
                zzdsdVar.zzb().put("request_id", Y1.f);
                this.zzb.zzg(zzdsdVar.zzb());
                return;
            }
            zzbvq zzbvqVar2 = zzbkVar.zzd;
            Bundle bundle = zzbkVar.zze;
            if (zzbvqVar2 != null) {
                zzd(zzbvqVar2.zzm, zzdrs.zza);
            } else if (bundle != null && !bundle.isEmpty()) {
                zzd(bundle, zzdrs.zza);
            }
            try {
                JSONObject jSONObject = new JSONObject(TextUtils.isEmpty(zzbkVar.zzc) ? zzbkVar.zzb : zzbkVar.zzc);
                zzdsd zzdsdVar2 = this.zza;
                zzdsdVar2.zzb().put("action", "sgs");
                Map zzb = zzdsdVar2.zzb();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkd)).booleanValue()) {
                    try {
                        str = jSONObject.getJSONObject("extras").getBoolean("accept_3p_cookie") ? "1" : "0";
                    } catch (JSONException e) {
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Error retrieving JSONObject from the requestJson, ", e);
                    }
                    zzb.put("tpc", str);
                    zzbvqVar = zzbkVar.zzd;
                    if (zzbvqVar != null) {
                        this.zza.zzf(zzbvqVar.zza);
                    }
                    this.zzb.zzg(this.zza.zzb());
                }
                str = "na";
                zzb.put("tpc", str);
                zzbvqVar = zzbkVar.zzd;
                if (zzbvqVar != null) {
                }
                this.zzb.zzg(this.zza.zzb());
            } catch (JSONException unused) {
                zzdsd zzdsdVar3 = this.zza;
                zzdsdVar3.zzb().put("action", "sgf");
                zzdsdVar3.zzb().put("sgf_reason", "request_invalid");
                this.zzb.zzg(zzdsdVar3.zzb());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdep
    public final void zzf(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhg)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhN)).booleanValue()) {
                this.zza.zzb().put("sgw", String.valueOf(this.zzc));
            }
            zzdsd zzdsdVar = this.zza;
            zzdsdVar.zzb().put("action", "sgf");
            zzdsdVar.zzd("sgf_reason", str);
            this.zzb.zzg(zzdsdVar.zzb());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxm
    public final void zzu() {
        zzdsd zzdsdVar = this.zza;
        zzdsdVar.zzb().put("action", C3040d4.h.r);
        zzd(zzdsdVar.zza(), zzdrs.zzb);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmZ)).booleanValue()) {
            zzdsdVar.zzb().put("mafe", true != WebViewFeature.isFeatureSupported("MUTE_AUDIO") ? "0" : "1");
        }
        this.zzb.zzg(zzdsdVar.zzb());
    }
}
