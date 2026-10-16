package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfnx extends zzfnt {
    public zzfnx(zzfnm zzfnmVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfnmVar, hashSet, jSONObject, j);
    }

    private final void zzc(String str) {
        zzfmi zza = zzfmi.zza();
        if (zza != null) {
            for (zzflp zzflpVar : zza.zzc()) {
                if (this.zza.contains(zzflpVar.zzh())) {
                    zzflpVar.zzg().zzd(str, this.zzc);
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfnu, android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.onPostExecute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfnu
    /* renamed from: zza */
    public final void onPostExecute(String str) {
        zzc(str);
        super.onPostExecute(str);
    }
}
