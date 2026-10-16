package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzdep;
import com.google.android.gms.internal.ads.zzdsd;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzw implements zzdep {
    private final zzdsd zza;
    private final zzv zzb;
    private final String zzc;
    private final int zzd;

    public zzw(zzdsd zzdsdVar, zzv zzvVar, String str, int i) {
        this.zza = zzdsdVar;
        this.zzb = zzvVar;
        this.zzc = str;
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.ads.zzdep
    public final void zze(zzbk zzbkVar) {
        String str;
        if (zzbkVar == null || this.zzd == 2) {
            return;
        }
        if (TextUtils.isEmpty(zzbkVar.zzc)) {
            this.zzb.zze(this.zzc, zzbkVar.zzb, this.zza);
            return;
        }
        try {
            str = new JSONObject(zzbkVar.zzc).optString("request_id");
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "RenderSignals.getRequestId");
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zzb.zze(str, zzbkVar.zzc, this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdep
    public final void zzf(String str) {
    }
}
