package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzaxh extends zzayk {
    private final Activity zzh;
    private final View zzi;

    public zzaxh(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2, View view, Activity activity) {
        super(zzawxVar, "YX3pd3fZ/j0e82Z3yXv98nYqAI3nsN+d0YAKVHjoLLbjd+BRZ45hNatoujYNmZM/", "2IfMUy5zOuVT1ilWAqZrt9PNbHCY94WGDxwYlYOFZTM=", zzastVar, i, 62);
        this.zzi = view;
        this.zzh = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        View view = this.zzi;
        if (view == null) {
            return;
        }
        boolean booleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcS)).booleanValue();
        Object[] objArr = (Object[]) this.zze.invoke(null, view, this.zzh, Boolean.valueOf(booleanValue));
        zzast zzastVar = this.zzd;
        synchronized (zzastVar) {
            zzastVar.zzc(((Long) objArr[0]).longValue());
            zzastVar.zze(((Long) objArr[1]).longValue());
            if (booleanValue) {
                zzastVar.zzd((String) objArr[2]);
            }
        }
    }
}
