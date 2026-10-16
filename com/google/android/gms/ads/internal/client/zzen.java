package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzazr;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbfc;
import com.google.android.gms.internal.ads.zzbpm;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzen {
    final zzbc zza;
    private final zzbpm zzb;
    private final zzq zzc;
    private final AtomicBoolean zzd;
    private final VideoController zze;
    private zza zzf;
    private AdListener zzg;
    private AdSize[] zzh;
    private AppEventListener zzi;
    private zzbx zzj;
    private VideoOptions zzk;
    private String zzl;

    @NotOnlyInitialized
    private final ViewGroup zzm;
    private int zzn;
    private boolean zzo;
    private OnPaidEventListener zzp;
    private final AtomicLong zzq;

    public zzen(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, zzq.zza, null, i);
    }

    private static zzr zzF(Context context, AdSize[] adSizeArr, int i) {
        for (AdSize adSize : adSizeArr) {
            if (adSize.equals(AdSize.INVALID)) {
                return new zzr("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false, false);
            }
        }
        zzr zzrVar = new zzr(context, adSizeArr);
        zzrVar.zzj = zzG(i);
        return zzrVar;
    }

    private static boolean zzG(int i) {
        return i == 1;
    }

    public final boolean zzB(zzbx zzbxVar) {
        try {
            IObjectWrapper zzo = zzbxVar.zzo();
            if (zzo == null || ((View) ObjectWrapper.unwrap(zzo)).getParent() != null) {
                return false;
            }
            this.zzm.addView((View) ObjectWrapper.unwrap(zzo));
            this.zzj = zzbxVar;
            return true;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final boolean zzC() {
        try {
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                return zzbxVar.zzaa();
            }
            return false;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final boolean zzD() {
        try {
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                return zzbxVar.zzab();
            }
            return false;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final AdSize[] zzE() {
        return this.zzh;
    }

    public final long zza() {
        AtomicLong atomicLong = this.zzq;
        if (atomicLong.get() != 0) {
            return atomicLong.get();
        }
        try {
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                atomicLong.set(zzbxVar.zzc());
                return atomicLong.get();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
        return 0L;
    }

    public final AdListener zzb() {
        return this.zzg;
    }

    public final AdSize zzc() {
        zzr zzh;
        try {
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null && (zzh = zzbxVar.zzh()) != null) {
                return com.google.android.gms.ads.zzc.zzc(zzh.zze, zzh.zzb, zzh.zza);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = this.zzh;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final OnPaidEventListener zzd() {
        return this.zzp;
    }

    public final ResponseInfo zze() {
        zzea zzeaVar = null;
        try {
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                zzeaVar = zzbxVar.zzl();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzeaVar);
    }

    public final VideoController zzg() {
        return this.zze;
    }

    public final VideoOptions zzh() {
        return this.zzk;
    }

    public final AppEventListener zzi() {
        return this.zzi;
    }

    public final zzed zzj() {
        zzbx zzbxVar = this.zzj;
        if (zzbxVar != null) {
            try {
                return zzbxVar.zzm();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            }
        }
        return null;
    }

    public final String zzk() {
        zzbx zzbxVar;
        if (this.zzl == null && (zzbxVar = this.zzj) != null) {
            try {
                this.zzl = zzbxVar.zzs();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
            }
        }
        return this.zzl;
    }

    public final void zzm() {
        try {
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzy();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzn(zzek zzekVar) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.zzj == null) {
                if (this.zzh == null || this.zzl == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                ViewGroup viewGroup = this.zzm;
                Context context = viewGroup.getContext();
                zzr zzF = zzF(context, this.zzh, this.zzn);
                zzbx zzbxVar = "search_v2".equals(zzF.zza) ? (zzbx) new zzan(zzbb.zza(), context, zzF, this.zzl).zzd(context, false) : (zzbx) new zzal(zzbb.zza(), context, zzF, this.zzl, this.zzb).zzd(context, false);
                this.zzj = zzbxVar;
                zzbxVar.zzE(new zzg(this.zza));
                zza zzaVar = this.zzf;
                if (zzaVar != null) {
                    this.zzj.zzD(new zzb(zzaVar));
                }
                AppEventListener appEventListener = this.zzi;
                if (appEventListener != null) {
                    this.zzj.zzH(new zzazr(appEventListener));
                }
                if (this.zzk != null) {
                    this.zzj.zzW(new zzgc(this.zzk));
                }
                this.zzj.zzQ(new zzfu(this.zzp));
                this.zzj.zzO(this.zzo);
                zzbx zzbxVar2 = this.zzj;
                if (zzbxVar2 != null) {
                    try {
                        final IObjectWrapper zzo = zzbxVar2.zzo();
                        if (zzo != null) {
                            if (((Boolean) zzbfc.zzf.zze()).booleanValue()) {
                                if (((Boolean) zzbd.zzc().zzb(zzbde.zzlE)).booleanValue()) {
                                    com.google.android.gms.ads.internal.util.client.zzf.zza.post(new Runnable() { // from class: com.google.android.gms.ads.internal.client.zzel
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            zzen.this.zzm.addView((View) ObjectWrapper.unwrap(zzo));
                                        }
                                    });
                                }
                            }
                            viewGroup.addView((View) ObjectWrapper.unwrap(zzo));
                        }
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                    }
                }
            }
            zzekVar.zzp(currentTimeMillis);
            if (zzekVar.zzc() != 0) {
                this.zzq.set(zzekVar.zzc());
            }
            zzbx zzbxVar3 = this.zzj;
            if (zzbxVar3 == null) {
                throw null;
            }
            AtomicLong atomicLong = this.zzq;
            if (atomicLong.get() != 0) {
                zzbxVar3.zzR(atomicLong.get());
            }
            zzbxVar3.zzad(this.zzc.zza(this.zzm.getContext(), zzekVar));
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e2);
        }
    }

    public final void zzo() {
        try {
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzA();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzp() {
        if (this.zzd.getAndSet(true)) {
            return;
        }
        try {
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzB();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzq() {
        try {
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzC();
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzr(zza zzaVar) {
        try {
            this.zzf = zzaVar;
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzD(zzaVar != null ? new zzb(zzaVar) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzs(AdListener adListener) {
        this.zzg = adListener;
        this.zza.zza(adListener);
    }

    public final void zzt(AdSize... adSizeArr) {
        if (this.zzh != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        zzu(adSizeArr);
    }

    public final void zzu(AdSize... adSizeArr) {
        this.zzh = adSizeArr;
        try {
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzG(zzF(this.zzm.getContext(), this.zzh, this.zzn));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
        this.zzm.requestLayout();
    }

    public final void zzv(String str) {
        if (this.zzl != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.zzl = str;
    }

    public final void zzw(AppEventListener appEventListener) {
        try {
            this.zzi = appEventListener;
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzH(appEventListener != null ? new zzazr(appEventListener) : null);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzx(boolean z) {
        this.zzo = z;
        try {
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzO(z);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzy(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzp = onPaidEventListener;
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzQ(new zzfu(onPaidEventListener));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zzz(long j) {
        this.zzq.set(j);
        try {
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzR(j);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public zzen(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzq.zza, null, 0);
    }

    public final void zzA(VideoOptions videoOptions) {
        this.zzk = videoOptions;
        try {
            zzbx zzbxVar = this.zzj;
            if (zzbxVar != null) {
                zzbxVar.zzW(videoOptions == null ? null : new zzgc(videoOptions));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    public zzen(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, z, zzq.zza, null, i);
    }

    zzen(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzq zzqVar, zzbx zzbxVar, int i) {
        zzr zzrVar;
        this.zzb = new zzbpm();
        this.zze = new VideoController();
        this.zza = new zzem(this);
        this.zzq = new AtomicLong();
        this.zzm = viewGroup;
        this.zzc = zzqVar;
        this.zzj = null;
        this.zzd = new AtomicBoolean(false);
        this.zzn = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzz zzzVar = new zzz(context, attributeSet);
                this.zzh = zzzVar.zzb(z);
                this.zzl = zzzVar.zza();
                if (viewGroup.isInEditMode()) {
                    com.google.android.gms.ads.internal.util.client.zzf zzb = zzbb.zzb();
                    AdSize adSize = this.zzh[0];
                    int i2 = this.zzn;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzrVar = new zzr("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false, false);
                    } else {
                        zzrVar = new zzr(context, adSize);
                        zzrVar.zzj = zzG(i2);
                    }
                    zzb.zzr(viewGroup, zzrVar, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzbb.zzb().zzq(viewGroup, new zzr(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }
}
