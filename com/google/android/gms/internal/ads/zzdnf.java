package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdnf implements zzbgd {
    final /* synthetic */ String zza = NativeCustomFormatAd.ASSET_NAME_VIDEO;
    final /* synthetic */ zzdng zzb;

    zzdnf(zzdng zzdngVar, String str) {
        Objects.requireNonNull(zzdngVar);
        this.zzb = zzdngVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgd
    public final JSONObject zza() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgd
    public final JSONObject zzb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgd
    public final void zzc() {
        zzdio zzdioVar;
        zzdio zzdioVar2;
        zzdng zzdngVar = this.zzb;
        zzdioVar = zzdngVar.zzd;
        if (zzdioVar != null) {
            String str = this.zza;
            zzdioVar2 = zzdngVar.zzd;
            zzdioVar2.zzG(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgd
    public final void zzd(MotionEvent motionEvent) {
    }
}
