package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfny extends zzfnt {
    public zzfny(zzfnm zzfnmVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfnmVar, hashSet, jSONObject, j);
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        zzfnm zzfnmVar = this.zzd;
        JSONObject jSONObject = this.zzb;
        if (zzfne.zzg(jSONObject, zzfnmVar.zza())) {
            return null;
        }
        zzfnmVar.zze(jSONObject);
        return jSONObject.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfnu, android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        onPostExecute((String) obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfnu
    /* renamed from: zza */
    public final void onPostExecute(String str) {
        zzfmi zza;
        if (!TextUtils.isEmpty(str) && (zza = zzfmi.zza()) != null) {
            for (zzflp zzflpVar : zza.zzc()) {
                if (this.zza.contains(zzflpVar.zzh())) {
                    zzflpVar.zzg().zzh(str, this.zzc);
                }
            }
        }
        super.onPostExecute(str);
    }
}
