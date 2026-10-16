package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzefb implements zzedm {
    private final Context zza;
    private final zzdgf zzb;
    private final Executor zzc;
    private final zzfbz zzd;
    private final zzdsj zze;

    public zzefb(Context context, Executor executor, zzdgf zzdgfVar, zzfbz zzfbzVar, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzb = zzdgfVar;
        this.zzc = executor;
        this.zzd = zzfbzVar;
        this.zze = zzdsjVar;
    }

    public static /* synthetic */ ListenableFuture zzd(zzefb zzefbVar, Uri uri, zzfcn zzfcnVar, zzfca zzfcaVar, zzfcd zzfcdVar, Object obj) {
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.intent.setData(uri);
            com.google.android.gms.ads.internal.overlay.zzc zzcVar = new com.google.android.gms.ads.internal.overlay.zzc(build.intent, null);
            zzcak zzcakVar = new zzcak();
            zzdfc zzd = zzefbVar.zzb.zzd(new zzcrq(zzfcnVar, zzfcaVar, null), new zzdff(new zzefa(zzefbVar, zzcakVar, zzfcaVar), null));
            zzcakVar.zzc(new AdOverlayInfoParcel(zzcVar, null, zzd.zza(), null, new VersionInfoParcel(0, 0, false), null, null, zzfcdVar.zzb));
            zzefbVar.zzd.zza();
            return zzgdn.zzh(zzd.zzg());
        } catch (Throwable th) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }

    private static String zze(zzfca zzfcaVar) {
        try {
            return zzfcaVar.zzv.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final ListenableFuture zza(final zzfcn zzfcnVar, final zzfca zzfcaVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznw)).booleanValue()) {
            zzdsi zza = this.zze.zza();
            zza.zzb("action", "cstm_tbs_rndr");
            zza.zzj();
        }
        String zze = zze(zzfcaVar);
        final Uri parse = zze != null ? Uri.parse(zze) : null;
        final zzfcd zzfcdVar = zzfcnVar.zzb.zzb;
        return zzgdn.zzn(zzgdn.zzh(null), new zzgcu() { // from class: com.google.android.gms.internal.ads.zzeez
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzefb.zzd(zzefb.this, parse, zzfcnVar, zzfcaVar, zzfcdVar, obj);
            }
        }, this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzedm
    public final boolean zzb(zzfcn zzfcnVar, zzfca zzfcaVar) {
        Context context = this.zza;
        return (context instanceof Activity) && zzbef.zzg(context) && !TextUtils.isEmpty(zze(zzfcaVar));
    }
}
