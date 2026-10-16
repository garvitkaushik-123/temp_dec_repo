package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdxg implements zzhgr {
    private final zzhha zza;

    private zzdxg(zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzdxg zza(zzhha zzhhaVar) {
        return new zzdxg(zzhhaVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004e, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) != false) goto L13;
     */
    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ Object zzb() {
        String valueOf;
        zzfcw zzc = ((zzcvp) this.zza).zzc();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhy)).booleanValue()) {
            String str = zzc.zzd.zzx;
            if (!TextUtils.isEmpty(str)) {
                try {
                    valueOf = new JSONObject(str).getString("request_id");
                } catch (JSONException unused) {
                }
            }
            com.google.android.gms.ads.internal.client.zzc zzcVar = zzc.zzd.zzs;
            if (zzcVar != null) {
                try {
                    valueOf = new JSONObject(zzcVar.zza).getString("request_id");
                } catch (JSONException unused2) {
                }
            }
        }
        valueOf = String.valueOf(com.google.android.gms.ads.internal.client.zzbb.zze().nextInt() & Integer.MAX_VALUE);
        zzhgz.zzb(valueOf);
        return valueOf;
    }
}
