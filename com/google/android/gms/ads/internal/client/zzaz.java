package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbil;
import com.google.android.gms.internal.ads.zzbim;
import com.google.android.gms.internal.ads.zzblh;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbtj;
import com.google.android.gms.internal.ads.zzbtn;
import com.google.android.gms.internal.ads.zzbtq;
import com.google.android.gms.internal.ads.zzbup;
import com.google.android.gms.internal.ads.zzbwv;
import com.google.android.gms.internal.ads.zzbxh;
import com.google.android.gms.internal.ads.zzbza;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzaz {
    private final zzk zza;
    private final zzi zzb;
    private final zzfg zzc;
    private final zzbil zzd;
    private final zzbtn zze;
    private final zzbim zzf;
    private zzbup zzg;
    private final zzl zzh;

    public zzaz(zzk zzkVar, zzi zziVar, zzfg zzfgVar, zzbil zzbilVar, zzbxh zzbxhVar, zzbtn zzbtnVar, zzbim zzbimVar, zzl zzlVar) {
        this.zza = zzkVar;
        this.zzb = zziVar;
        this.zzc = zzfgVar;
        this.zzd = zzbilVar;
        this.zze = zzbtnVar;
        this.zzf = zzbimVar;
        this.zzh = zzlVar;
    }

    static /* bridge */ /* synthetic */ void zzv(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzbb.zzb().zzs(context, zzbb.zzc().afmaVersion, "gmob-apps", bundle, true);
    }

    public final zzbt zzd(Context context, String str, zzbpq zzbpqVar) {
        return (zzbt) new zzaq(this, context, str, zzbpqVar).zzd(context, false);
    }

    public final zzbx zze(Context context, zzr zzrVar, String str, zzbpq zzbpqVar) {
        return (zzbx) new zzam(this, context, zzrVar, str, zzbpqVar).zzd(context, false);
    }

    public final zzbx zzf(Context context, zzr zzrVar, String str, zzbpq zzbpqVar) {
        return (zzbx) new zzao(this, context, zzrVar, str, zzbpqVar).zzd(context, false);
    }

    public final zzck zzg(Context context, zzbpq zzbpqVar) {
        return (zzck) new zzas(this, context, zzbpqVar).zzd(context, false);
    }

    public final zzdw zzh(Context context, zzbpq zzbpqVar) {
        return (zzdw) new zzae(this, context, zzbpqVar).zzd(context, false);
    }

    public final zzbgt zzj(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzbgt) new zzaw(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzbgz zzk(View view, HashMap hashMap, HashMap hashMap2) {
        return (zzbgz) new zzay(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzblh zzn(Context context, zzbpq zzbpqVar, OnH5AdsEventListener onH5AdsEventListener) {
        return (zzblh) new zzak(this, context, zzbpqVar, onH5AdsEventListener).zzd(context, false);
    }

    public final zzbtj zzo(Context context, zzbpq zzbpqVar) {
        return (zzbtj) new zzai(this, context, zzbpqVar).zzd(context, false);
    }

    public final zzbtq zzq(Activity activity) {
        zzac zzacVar = new zzac(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        } else {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("useClientJar flag not found in activity intent extras.");
        }
        return (zzbtq) zzacVar.zzd(activity, z);
    }

    public final zzbwv zzs(Context context, String str, zzbpq zzbpqVar) {
        return (zzbwv) new zzaa(this, context, str, zzbpqVar).zzd(context, false);
    }

    public final zzbza zzt(Context context, zzbpq zzbpqVar) {
        return (zzbza) new zzag(this, context, zzbpqVar).zzd(context, false);
    }
}
