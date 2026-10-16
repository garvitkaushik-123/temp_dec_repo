package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbtp;
import com.google.android.gms.internal.ads.zzded;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzac extends zzbtp implements zzazw {
    private final AdOverlayInfoParcel zza;
    private final Activity zzb;
    private final boolean zzf;
    private boolean zzc = false;
    private boolean zzd = false;
    private boolean zze = false;
    private boolean zzg = false;
    private boolean zzh = false;

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0046, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzfe)).booleanValue() != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzac(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        this.zza = adOverlayInfoParcel;
        this.zzb = activity;
        if (!((Boolean) zzbd.zzc().zzb(zzbde.zzeZ)).booleanValue()) {
            if (!((Boolean) zzbd.zzc().zzb(zzbde.zzfa)).booleanValue()) {
            }
        }
        zzc zzcVar = adOverlayInfoParcel.zza;
        if (zzcVar != null && zzcVar.zzj) {
            if (Build.MANUFACTURER.matches((String) zzbd.zzc().zzb(zzbde.zzfc))) {
                if (Build.MODEL.matches((String) zzbd.zzc().zzb(zzbde.zzfd))) {
                    z = true;
                }
            }
        }
        this.zzf = z;
    }

    public static /* synthetic */ void zzb(zzac zzacVar) {
        if (zzacVar.zzg) {
            zzacVar.zzb.finish();
        }
    }

    private final synchronized void zzc() {
        if (!this.zzd) {
            zzr zzrVar = this.zza.zzc;
            if (zzrVar != null) {
                zzrVar.zzdw(4);
            }
            this.zzd = true;
            if (this.zzf) {
                if (((Boolean) zzbd.zzc().zzb(zzbde.zzfe)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzv.zzb().zze(this);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final boolean zzH() throws RemoteException {
        return ((Boolean) zzbd.zzc().zzb(zzbde.zzfa)).booleanValue() && this.zzf && this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzazw
    public final void zza(boolean z) {
        if (!z) {
            this.zzh = true;
        } else if (this.zzh) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Foregrounded: finishing activity from LauncherOverlay");
            this.zzb.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzh(int i, int i2, Intent intent) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzi() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzl(Bundle bundle) {
        zzr zzrVar;
        if (((Boolean) zzbd.zzc().zzb(zzbde.zzjn)).booleanValue() && !this.zze) {
            this.zzb.requestWindowFeature(1);
        }
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zza;
        if (adOverlayInfoParcel == null) {
            this.zzb.finish();
            return;
        }
        if (z) {
            this.zzb.finish();
            return;
        }
        if (bundle == null) {
            com.google.android.gms.ads.internal.client.zza zzaVar = adOverlayInfoParcel.zzb;
            if (zzaVar != null) {
                zzaVar.onAdClicked();
            }
            zzded zzdedVar = adOverlayInfoParcel.zzu;
            if (zzdedVar != null) {
                zzdedVar.zzdf();
            }
            Activity activity = this.zzb;
            if (activity.getIntent() != null && activity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) && (zzrVar = adOverlayInfoParcel.zzc) != null) {
                zzrVar.zzdt();
            }
        }
        if (this.zzf) {
            if (((Boolean) zzbd.zzc().zzb(zzbde.zzfe)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zzb().zzc(this);
            }
        }
        Activity activity2 = this.zzb;
        zzc zzcVar = adOverlayInfoParcel.zza;
        zzad zzadVar = adOverlayInfoParcel.zzi;
        com.google.android.gms.ads.internal.zzv.zzi();
        if (zza.zzb(activity2, zzcVar, zzadVar, zzcVar.zzi, null, "")) {
            return;
        }
        activity2.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzm() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzo() throws RemoteException {
        this.zzg = false;
        zzr zzrVar = this.zza.zzc;
        if (zzrVar != null) {
            zzrVar.zzdk();
        }
        if (this.zzb.isFinishing()) {
            zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzp(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzq() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzr() throws RemoteException {
        if (this.zzc) {
            com.google.android.gms.ads.internal.util.zze.zza("LauncherOverlay finishing activity");
            this.zzb.finish();
            return;
        }
        this.zzc = true;
        this.zzg = true;
        zzr zzrVar = this.zza.zzc;
        if (zzrVar != null) {
            zzrVar.zzd();
        }
        if (this.zzf) {
            if (((Boolean) zzbd.zzc().zzb(zzbde.zzeZ)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzab
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzac.zzb(zzac.this);
                    }
                }, ((Integer) zzbd.zzc().zzb(zzbde.zzfb)).intValue());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzs(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzt() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzu() throws RemoteException {
        if (this.zzb.isFinishing()) {
            zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzv() throws RemoteException {
        zzr zzrVar = this.zza.zzc;
        if (zzrVar != null) {
            zzrVar.zzdv();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzx() throws RemoteException {
        this.zze = true;
    }
}
