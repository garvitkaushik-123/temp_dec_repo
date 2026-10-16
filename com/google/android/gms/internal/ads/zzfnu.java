package com.google.android.gms.internal.ads;

import android.os.AsyncTask;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public abstract class zzfnu extends AsyncTask {
    private zzfnv zza;
    protected final zzfnm zzd;

    public zzfnu(zzfnm zzfnmVar) {
        this.zzd = zzfnmVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        zzfnv zzfnvVar = this.zza;
        if (zzfnvVar != null) {
            zzfnvVar.zza(this);
        }
    }

    public final void zzb(zzfnv zzfnvVar) {
        this.zza = zzfnvVar;
    }
}
