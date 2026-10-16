package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzded;
import com.google.android.gms.internal.ads.zzdsj;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzn {
    public static final void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z, zzdsj zzdsjVar) {
        if (adOverlayInfoParcel.zzk == 4 && adOverlayInfoParcel.zzc == null) {
            com.google.android.gms.ads.internal.client.zza zzaVar = adOverlayInfoParcel.zzb;
            if (zzaVar != null) {
                zzaVar.onAdClicked();
            }
            zzded zzdedVar = adOverlayInfoParcel.zzu;
            if (zzdedVar != null) {
                zzdedVar.zzdf();
            }
            Activity zzi = adOverlayInfoParcel.zzd.zzi();
            zzc zzcVar = adOverlayInfoParcel.zza;
            Context context2 = (zzcVar == null || !zzcVar.zzj || zzi == null) ? context : zzi;
            com.google.android.gms.ads.internal.zzv.zzi();
            zza.zzb(context2, zzcVar, adOverlayInfoParcel.zzi, zzcVar != null ? zzcVar.zzi : null, zzdsjVar, adOverlayInfoParcel.zzq);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzm.isClientJar);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
        if (!PlatformVersion.isAtLeastLollipop()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        if (((Boolean) zzbd.zzc().zzb(zzbde.zznx)).booleanValue()) {
            com.google.android.gms.ads.internal.zzv.zzr();
            com.google.android.gms.ads.internal.util.zzs.zzY(context, intent, zzdsjVar, adOverlayInfoParcel.zzq);
        } else {
            com.google.android.gms.ads.internal.zzv.zzr();
            com.google.android.gms.ads.internal.util.zzs.zzU(context, intent);
        }
    }
}
