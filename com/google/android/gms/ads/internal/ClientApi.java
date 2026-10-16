package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzbx;
import com.google.android.gms.ads.internal.client.zzck;
import com.google.android.gms.ads.internal.client.zzcq;
import com.google.android.gms.ads.internal.client.zzdb;
import com.google.android.gms.ads.internal.client.zzdw;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzag;
import com.google.android.gms.ads.internal.overlay.zzai;
import com.google.android.gms.ads.internal.overlay.zzaj;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzble;
import com.google.android.gms.internal.ads.zzblh;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbtj;
import com.google.android.gms.internal.ads.zzbtq;
import com.google.android.gms.internal.ads.zzbwf;
import com.google.android.gms.internal.ads.zzbwv;
import com.google.android.gms.internal.ads.zzbza;
import com.google.android.gms.internal.ads.zzche;
import com.google.android.gms.internal.ads.zzdjn;
import com.google.android.gms.internal.ads.zzdjp;
import com.google.android.gms.internal.ads.zzdtt;
import com.google.android.gms.internal.ads.zzekb;
import com.google.android.gms.internal.ads.zzexa;
import com.google.android.gms.internal.ads.zzeyo;
import com.google.android.gms.internal.ads.zzfaf;
import com.google.android.gms.internal.ads.zzfbt;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public class ClientApi extends zzcq {
    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbt zzb(IObjectWrapper iObjectWrapper, String str, zzbpq zzbpqVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzekb(zzche.zza(context, zzbpqVar, i), context, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx zzc(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbpq zzbpqVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzexa zzs = zzche.zza(context, zzbpqVar, i).zzs();
        zzs.zza(str);
        zzs.zzb(context);
        return zzs.zzc().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx zzd(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbpq zzbpqVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzeyo zzt = zzche.zza(context, zzbpqVar, i).zzt();
        zzt.zzc(context);
        zzt.zza(zzrVar);
        zzt.zzb(str);
        return zzt.zzd().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx zze(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzbpq zzbpqVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfaf zzu = zzche.zza(context, zzbpqVar, i).zzu();
        zzu.zzc(context);
        zzu.zza(zzrVar);
        zzu.zzb(str);
        return zzu.zzd().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbx zzf(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, int i) {
        return new zzu((Context) ObjectWrapper.unwrap(iObjectWrapper), zzrVar, str, new VersionInfoParcel(ModuleDescriptor.MODULE_VERSION, i, true, false));
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzck zzg(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i) {
        return zzche.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbpqVar, i).zzz();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzdb zzh(IObjectWrapper iObjectWrapper, int i) {
        return zzche.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), null, i).zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzdw zzi(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i) {
        return zzche.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbpqVar, i).zzl();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbgt zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdjp((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbgz zzk(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdjn((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzblh zzl(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i, zzble zzbleVar) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdtt zzj = zzche.zza(context, zzbpqVar, i).zzj();
        zzj.zzb(context);
        zzj.zza(zzbleVar);
        return zzj.zzc().zzd();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbtj zzm(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i) {
        return zzche.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbpqVar, i).zzm();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbtq zzn(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (zza == null) {
            return new zzw(activity);
        }
        int i = zza.zzk;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? new zzw(activity) : new zzag(activity) : new zzac(activity, zza) : new zzaj(activity) : new zzai(activity) : new com.google.android.gms.ads.internal.overlay.zzv(activity);
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbwf zzo(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfbt zzv = zzche.zza(context, zzbpqVar, i).zzv();
        zzv.zzb(context);
        return zzv.zzc().zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbwv zzp(IObjectWrapper iObjectWrapper, String str, zzbpq zzbpqVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfbt zzv = zzche.zza(context, zzbpqVar, i).zzv();
        zzv.zzb(context);
        zzv.zza(str);
        return zzv.zzc().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzcr
    public final zzbza zzq(IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, int i) {
        return zzche.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbpqVar, i).zzp();
    }
}
