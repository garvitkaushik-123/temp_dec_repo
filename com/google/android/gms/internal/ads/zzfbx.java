package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzfbx extends zzbwe {
    private final zzfbn zza;
    private final zzfbd zzb;
    private final zzfco zzc;
    private zzdon zzd;
    private boolean zze = false;

    public zzfbx(zzfbn zzfbnVar, zzfbd zzfbdVar, zzfco zzfcoVar) {
        this.zza = zzfbnVar;
        this.zzb = zzfbdVar;
        this.zzc = zzfcoVar;
    }

    private final synchronized boolean zzy() {
        zzdon zzdonVar = this.zzd;
        if (zzdonVar != null) {
            if (!zzdonVar.zze()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final Bundle zzb() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        zzdon zzdonVar = this.zzd;
        return zzdonVar != null ? zzdonVar.zza() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized com.google.android.gms.ads.internal.client.zzea zzc() throws RemoteException {
        zzdon zzdonVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgW)).booleanValue() && (zzdonVar = this.zzd) != null) {
            return zzdonVar.zzm();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized String zzd() throws RemoteException {
        zzdon zzdonVar = this.zzd;
        if (zzdonVar == null || zzdonVar.zzm() == null) {
            return null;
        }
        return zzdonVar.zzm().zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final void zze() throws RemoteException {
        zzf(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized void zzf(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        Context context = null;
        this.zzb.zzg(null);
        if (this.zzd != null) {
            if (iObjectWrapper != null) {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzd.zzn().zza(context);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0043, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0040, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzfN)).booleanValue() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
    
        if (java.util.regex.Pattern.matches(r1, r0) != false) goto L16;
     */
    @Override // com.google.android.gms.internal.ads.zzbwf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void zzg(zzbwj zzbwjVar) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        String str = zzbwjVar.zzb;
        String str2 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfL);
        if (str2 != null && str != null) {
            try {
            } catch (RuntimeException e) {
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "NonagonUtil.isPatternMatched");
            }
        }
        if (zzy()) {
        }
        zzfbf zzfbfVar = new zzfbf(null);
        this.zzd = null;
        zzfbn zzfbnVar = this.zza;
        zzfbnVar.zzj(1);
        zzfbnVar.zzb(zzbwjVar.zza, zzbwjVar.zzb, zzfbfVar, new zzfbv(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final void zzh() {
        zzi(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized void zzi(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzd != null) {
            this.zzd.zzn().zzb(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final void zzj() {
        zzk(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized void zzk(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzd != null) {
            this.zzd.zzn().zzc(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final void zzl(com.google.android.gms.ads.internal.client.zzcb zzcbVar) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        if (zzcbVar == null) {
            this.zzb.zzg(null);
        } else {
            this.zzb.zzg(new zzfbw(this, zzcbVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized void zzm(String str) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
        this.zzc.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized void zzn(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zze = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final void zzo(zzbwi zzbwiVar) throws RemoteException {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzb.zzm(zzbwiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized void zzp(String str) throws RemoteException {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.zzc.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized void zzq() throws RemoteException {
        zzr(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final synchronized void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("showAd must be called on the main UI thread.");
        if (this.zzd != null) {
            Activity activity = null;
            if (iObjectWrapper != null) {
                Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
                if (unwrap instanceof Activity) {
                    activity = (Activity) unwrap;
                }
            }
            this.zzd.zzh(this.zze, activity);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final boolean zzs() throws RemoteException {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final boolean zzt() {
        zzdon zzdonVar = this.zzd;
        return zzdonVar != null && zzdonVar.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzbwf
    public final void zzu(zzbwd zzbwdVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzb.zzn(zzbwdVar);
    }
}
