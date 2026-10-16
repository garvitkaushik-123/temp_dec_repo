package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdjs implements zzbgd {
    final /* synthetic */ zzdkr zza;
    final /* synthetic */ ViewGroup zzb;

    zzdjs(zzdkr zzdkrVar, ViewGroup viewGroup) {
        this.zza = zzdkrVar;
        this.zzb = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzbgd
    public final JSONObject zza() {
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzbgd
    public final JSONObject zzb() {
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzbgd
    public final void zzc() {
        zzfyq zzfyqVar = zzdjp.zza;
        zzdkr zzdkrVar = this.zza;
        Map zzm = zzdkrVar.zzm();
        if (zzm == null) {
            return;
        }
        int size = zzfyqVar.size();
        int i = 0;
        while (i < size) {
            Object obj = zzm.get((String) zzfyqVar.get(i));
            i++;
            if (obj != null) {
                zzdkrVar.onClick(this.zzb);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgd
    public final void zzd(MotionEvent motionEvent) {
        this.zza.onTouch(null, motionEvent);
    }
}
