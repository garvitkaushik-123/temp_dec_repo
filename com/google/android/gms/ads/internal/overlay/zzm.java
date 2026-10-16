package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toolbar;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbcc;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbiv;
import com.google.android.gms.internal.ads.zzbix;
import com.google.android.gms.internal.ads.zzbsu;
import com.google.android.gms.internal.ads.zzbtj;
import com.google.android.gms.internal.ads.zzbtp;
import com.google.android.gms.internal.ads.zzcfg;
import com.google.android.gms.internal.ads.zzcft;
import com.google.android.gms.internal.ads.zzcgw;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzchd;
import com.google.android.gms.internal.ads.zzcwl;
import com.google.android.gms.internal.ads.zzded;
import com.google.android.gms.internal.ads.zzdsi;
import com.google.android.gms.internal.ads.zzdsj;
import com.google.android.gms.internal.ads.zzecm;
import com.google.android.gms.internal.ads.zzecn;
import com.google.android.gms.internal.ads.zzedf;
import com.google.android.gms.internal.ads.zzedh;
import com.google.android.gms.internal.ads.zzfrw;
import com.google.android.gms.internal.ads.zzfwg;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public class zzm extends zzbtp implements zzah {
    static final int zza = Color.argb(0, 0, 0, 0);
    protected final Activity zzb;
    AdOverlayInfoParcel zzc;
    zzcfg zzd;
    zzi zze;
    zzu zzf;
    FrameLayout zzh;
    WebChromeClient.CustomViewCallback zzi;
    zzh zzl;
    private Runnable zzq;
    private boolean zzr;
    private boolean zzs;
    private Toolbar zzw;
    boolean zzg = false;
    boolean zzj = false;
    boolean zzk = false;
    boolean zzm = false;
    int zzn = 1;
    private final Object zzo = new Object();
    private final View.OnClickListener zzp = new zzf(this);
    private boolean zzt = false;
    private boolean zzu = false;
    private boolean zzv = true;

    public zzm(Activity activity) {
        this.zzb = activity;
    }

    private final void zzJ(View view) {
        zzedh zzQ;
        zzedf zzP;
        zzcfg zzcfgVar = this.zzd;
        if (zzcfgVar == null) {
            return;
        }
        if (((Boolean) zzbd.zzc().zzb(zzbde.zzfC)).booleanValue() && (zzP = zzcfgVar.zzP()) != null) {
            zzP.zza(view);
        } else if (((Boolean) zzbd.zzc().zzb(zzbde.zzfB)).booleanValue() && (zzQ = zzcfgVar.zzQ()) != null && zzQ.zzb()) {
            com.google.android.gms.ads.internal.zzv.zzC().zzg(zzQ.zza(), view);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzaU)).booleanValue() != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0048, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0045, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzaT)).booleanValue() != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzK(Configuration configuration) {
        com.google.android.gms.ads.internal.zzl zzlVar;
        com.google.android.gms.ads.internal.zzl zzlVar2;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = (adOverlayInfoParcel == null || (zzlVar2 = adOverlayInfoParcel.zzo) == null || !zzlVar2.zzb) ? false : true;
        Activity activity = this.zzb;
        boolean zzd = com.google.android.gms.ads.internal.zzv.zzs().zzd(activity, configuration);
        if (this.zzk && !z3) {
        }
        if (zzd) {
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
        if (adOverlayInfoParcel2 != null && (zzlVar = adOverlayInfoParcel2.zzo) != null && zzlVar.zzg) {
            z2 = true;
        }
        Window window = activity.getWindow();
        if (((Boolean) zzbd.zzc().zzb(zzbde.zzbr)).booleanValue()) {
            window.getDecorView().setSystemUiVisibility(z ? z2 ? 5894 : 5380 : 256);
            return;
        }
        if (!z) {
            window.addFlags(2048);
            window.clearFlags(1024);
            return;
        }
        window.addFlags(1024);
        window.clearFlags(2048);
        if (z2) {
            window.getDecorView().setSystemUiVisibility(4098);
        }
    }

    private static final void zzL(zzedh zzedhVar, View view) {
        if (zzedhVar == null || view == null) {
            return;
        }
        if (((Boolean) zzbd.zzc().zzb(zzbde.zzfB)).booleanValue() && zzedhVar.zzb()) {
            return;
        }
        com.google.android.gms.ads.internal.zzv.zzC().zzj(zzedhVar.zza(), view);
    }

    public final void zzA(int i) {
        Activity activity = this.zzb;
        if (activity.getApplicationInfo().targetSdkVersion >= ((Integer) zzbd.zzc().zzb(zzbde.zzgk)).intValue()) {
            if (activity.getApplicationInfo().targetSdkVersion <= ((Integer) zzbd.zzc().zzb(zzbde.zzgl)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzbd.zzc().zzb(zzbde.zzgm)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzbd.zzc().zzb(zzbde.zzgn)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            activity.setRequestedOrientation(i);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzv.zzp().zzv(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zzB(boolean z) {
        if (z) {
            this.zzl.setBackgroundColor(0);
        } else {
            this.zzl.setBackgroundColor(-16777216);
        }
    }

    public final void zzC(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        Activity activity = this.zzb;
        FrameLayout frameLayout = new FrameLayout(activity);
        this.zzh = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        this.zzh.addView(view, -1, -1);
        activity.setContentView(this.zzh);
        this.zzs = true;
        this.zzi = customViewCallback;
        this.zzg = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void zzD(boolean z) throws zzg {
        boolean z2;
        Resources.Theme theme;
        ?? r2;
        zzcfg zzcfgVar;
        if (!this.zzs) {
            this.zzb.requestWindowFeature(1);
        }
        Activity activity = this.zzb;
        Window window = activity.getWindow();
        if (window == null) {
            throw new zzg("Invalid activity, no window available.");
        }
        zzcfg zzcfgVar2 = this.zzc.zzd;
        zzcgy zzN = zzcfgVar2 != null ? zzcfgVar2.zzN() : null;
        boolean z3 = zzN != null && zzN.zzV();
        this.zzm = false;
        if (z3) {
            int i = this.zzc.zzj;
            if (i == 6) {
                z2 = activity.getResources().getConfiguration().orientation == 1;
                this.zzm = z2;
            } else if (i == 7) {
                z2 = activity.getResources().getConfiguration().orientation == 2;
                this.zzm = z2;
            }
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Delay onShow to next orientation change: " + z2);
            zzA(this.zzc.zzj);
            window.setFlags(16777216, 16777216);
            com.google.android.gms.ads.internal.util.client.zzo.zze("Hardware acceleration on the AdActivity window enabled.");
            if (this.zzk) {
                this.zzl.setBackgroundColor(-16777216);
            } else {
                this.zzl.setBackgroundColor(zza);
            }
            activity.setContentView(this.zzl);
            this.zzs = true;
            if (z) {
                theme = null;
                r2 = 0;
                zzcfg zzcfgVar3 = this.zzc.zzd;
                this.zzd = zzcfgVar3;
                zzcfgVar3.zzan(this.zzb);
            } else {
                try {
                    com.google.android.gms.ads.internal.zzv.zzB();
                    zzcfg zzcfgVar4 = this.zzc.zzd;
                    zzchd zzO = zzcfgVar4 != null ? zzcfgVar4.zzO() : null;
                    zzcfg zzcfgVar5 = this.zzc.zzd;
                    String zzU = zzcfgVar5 != null ? zzcfgVar5.zzU() : null;
                    AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
                    VersionInfoParcel versionInfoParcel = adOverlayInfoParcel.zzm;
                    zzcfg zzcfgVar6 = adOverlayInfoParcel.zzd;
                    String str = zzU;
                    theme = null;
                    boolean z4 = false;
                    zzcfg zza2 = zzcft.zza(activity, zzO, str, true, z3, null, null, versionInfoParcel, null, null, zzcfgVar6 != null ? zzcfgVar6.zzj() : null, zzbcc.zza(), null, null, null, null, null);
                    this.zzd = zza2;
                    zzcgy zzN2 = zza2.zzN();
                    AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
                    zzbiv zzbivVar = adOverlayInfoParcel2.zzp;
                    zzbix zzbixVar = adOverlayInfoParcel2.zze;
                    zzad zzadVar = adOverlayInfoParcel2.zzi;
                    zzcfg zzcfgVar7 = adOverlayInfoParcel2.zzd;
                    zzN2.zzX(null, zzbivVar, null, zzbixVar, zzadVar, true, null, zzcfgVar7 != null ? zzcfgVar7.zzN().zzd() : null, null, null, null, null, null, null, null, null, null, null, null);
                    this.zzd.zzN().zzC(new zzcgw() { // from class: com.google.android.gms.ads.internal.overlay.zze
                        @Override // com.google.android.gms.internal.ads.zzcgw
                        public final void zza(boolean z5, int i3, String str2, String str3) {
                            zzcfg zzcfgVar8 = zzm.this.zzd;
                            if (zzcfgVar8 != null) {
                                zzcfgVar8.zzaa();
                            }
                        }
                    });
                    AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzc;
                    String str2 = adOverlayInfoParcel3.zzl;
                    if (str2 != null) {
                        this.zzd.loadUrl(str2);
                    } else {
                        String str3 = adOverlayInfoParcel3.zzh;
                        if (str3 == null) {
                            throw new zzg("No URL or HTML to display in ad overlay.");
                        }
                        this.zzd.loadDataWithBaseURL(adOverlayInfoParcel3.zzf, str3, "text/html", "UTF-8", null);
                    }
                    zzcfg zzcfgVar8 = this.zzc.zzd;
                    r2 = z4;
                    if (zzcfgVar8 != null) {
                        zzcfgVar8.zzaw(this);
                        r2 = z4;
                    }
                } catch (Exception e) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("Error obtaining webview.", e);
                    throw new zzg("Could not obtain webview for the overlay.", e);
                }
            }
            if (this.zzc.zzw) {
                CookieManager.getInstance().setAcceptThirdPartyCookies(this.zzd.zzG(), r2);
            }
            this.zzd.zzai(this);
            zzcfgVar = this.zzc.zzd;
            if (zzcfgVar != null) {
                zzL(zzcfgVar.zzQ(), this.zzl);
            }
            if (this.zzc.zzk != 5) {
                ViewParent parent = this.zzd.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.zzd.zzF());
                }
                if (this.zzk) {
                    this.zzd.zzam();
                }
                if (this.zzc.zzw) {
                    Toolbar toolbar = new Toolbar(this.zzb);
                    this.zzw = toolbar;
                    toolbar.setId(View.generateViewId());
                    this.zzd.zzF().setId(View.generateViewId());
                    this.zzw.setBackgroundColor(-12303292);
                    this.zzw.setVisibility(r2);
                    try {
                        this.zzw.setNavigationIcon(com.google.android.gms.ads.internal.zzv.zzp().zze().getDrawable(R.drawable.admob_close_button_white_cross, theme));
                    } catch (Resources.NotFoundException | NullPointerException e2) {
                        com.google.android.gms.ads.internal.util.zze.zzb("Error obtaining close icon.", e2);
                    }
                    this.zzw.setNavigationOnClickListener(this.zzp);
                    this.zzw.setTitleMarginStart(r2);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(10);
                    this.zzl.addView(this.zzw, layoutParams);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams2.addRule(3, this.zzw.getId());
                    layoutParams2.addRule(12);
                    this.zzl.addView(this.zzd.zzF(), layoutParams2);
                    zzJ(this.zzw);
                } else {
                    this.zzl.addView(this.zzd.zzF(), -1, -1);
                }
            }
            if (!z && !this.zzm) {
                zze();
            }
            if (this.zzc.zzk == 5) {
                zzw(z3);
                if (this.zzd.zzaB()) {
                    zzy(z3, true);
                    return;
                }
                return;
            }
            Activity activity2 = this.zzb;
            zzecm zze = zzecn.zze();
            zze.zza(activity2);
            zze.zzb(this);
            zze.zzc(this.zzc.zzq);
            zze.zzd(this.zzc.zzr);
            try {
                zzf(zze.zze());
                return;
            } catch (RemoteException | zzg e3) {
                throw new zzg(e3.getMessage(), e3);
            }
        }
        z2 = false;
        int i22 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Delay onShow to next orientation change: " + z2);
        zzA(this.zzc.zzj);
        window.setFlags(16777216, 16777216);
        com.google.android.gms.ads.internal.util.client.zzo.zze("Hardware acceleration on the AdActivity window enabled.");
        if (this.zzk) {
        }
        activity.setContentView(this.zzl);
        this.zzs = true;
        if (z) {
        }
        if (this.zzc.zzw) {
        }
        this.zzd.zzai(this);
        zzcfgVar = this.zzc.zzd;
        if (zzcfgVar != null) {
        }
        if (this.zzc.zzk != 5) {
        }
        if (!z) {
            zze();
        }
        if (this.zzc.zzk == 5) {
        }
    }

    public final void zzE() {
        synchronized (this.zzo) {
            this.zzr = true;
            if (this.zzq != null) {
                zzfrw zzfrwVar = com.google.android.gms.ads.internal.util.zzs.zza;
                zzfrwVar.removeCallbacks(this.zzq);
                zzfrwVar.post(this.zzq);
            }
        }
    }

    protected final void zzF() {
        AdOverlayInfoParcel adOverlayInfoParcel;
        zzr zzrVar;
        if (!this.zzb.isFinishing() || this.zzt) {
            return;
        }
        this.zzt = true;
        zzcfg zzcfgVar = this.zzd;
        if (zzcfgVar != null) {
            zzcfgVar.zzZ(this.zzn - 1);
            synchronized (this.zzo) {
                if (!this.zzr && this.zzd.zzaC()) {
                    if (((Boolean) zzbd.zzc().zzb(zzbde.zzfn)).booleanValue() && !this.zzu && (adOverlayInfoParcel = this.zzc) != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
                        zzrVar.zzds();
                    }
                    this.zzq = new Runnable() { // from class: com.google.android.gms.ads.internal.overlay.zzd
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzm.this.zzc();
                        }
                    };
                    com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(this.zzq, ((Long) zzbd.zzc().zzb(zzbde.zzbk)).longValue());
                    return;
                }
            }
        }
        zzc();
    }

    public final void zzG(String str) {
        Toolbar toolbar = this.zzw;
        if (toolbar != null) {
            toolbar.setSubtitle(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final boolean zzH() {
        this.zzn = 1;
        if (this.zzd == null) {
            return true;
        }
        if (((Boolean) zzbd.zzc().zzb(zzbde.zzjp)).booleanValue() && this.zzd.canGoBack()) {
            this.zzd.goBack();
            return false;
        }
        boolean zzaH = this.zzd.zzaH();
        if (!zzaH) {
            this.zzd.zzd("onbackblocked", Collections.emptyMap());
        }
        return zzaH;
    }

    public final void zzb() {
        this.zzn = 3;
        Activity activity = this.zzb;
        activity.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || adOverlayInfoParcel.zzk != 5) {
            return;
        }
        activity.overridePendingTransition(0, 0);
        zzcfg zzcfgVar = this.zzd;
        if (zzcfgVar != null) {
            zzcfgVar.zzai(null);
        }
    }

    final void zzc() {
        zzcfg zzcfgVar;
        zzr zzrVar;
        if (this.zzu) {
            return;
        }
        this.zzu = true;
        zzcfg zzcfgVar2 = this.zzd;
        if (zzcfgVar2 != null) {
            this.zzl.removeView(zzcfgVar2.zzF());
            zzi zziVar = this.zze;
            if (zziVar != null) {
                this.zzd.zzan(zziVar.zzd);
                this.zzd.zzaq(false);
                if (((Boolean) zzbd.zzc().zzb(zzbde.zznc)).booleanValue() && this.zzd.getParent() != null) {
                    ((ViewGroup) this.zzd.getParent()).removeView(this.zzd.zzF());
                }
                ViewGroup viewGroup = this.zze.zzc;
                View zzF = this.zzd.zzF();
                zzi zziVar2 = this.zze;
                viewGroup.addView(zzF, zziVar2.zza, zziVar2.zzb);
                this.zze = null;
            } else {
                Activity activity = this.zzb;
                if (activity.getApplicationContext() != null) {
                    this.zzd.zzan(activity.getApplicationContext());
                }
            }
            this.zzd = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
            zzrVar.zzdw(this.zzn);
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
        if (adOverlayInfoParcel2 == null || (zzcfgVar = adOverlayInfoParcel2.zzd) == null) {
            return;
        }
        zzL(zzcfgVar.zzQ(), this.zzc.zzd.zzF());
    }

    public final void zzd() {
        this.zzl.zzb = true;
    }

    protected final void zze() {
        this.zzd.zzaa();
    }

    public final void zzf(zzecn zzecnVar) throws zzg, RemoteException {
        zzbtj zzbtjVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzbtjVar = adOverlayInfoParcel.zzv) == null) {
            throw new zzg("noioou");
        }
        zzbtjVar.zzg(ObjectWrapper.wrap(zzecnVar));
    }

    public final void zzg() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && this.zzg) {
            zzA(adOverlayInfoParcel.zzj);
        }
        if (this.zzh != null) {
            this.zzb.setContentView(this.zzl);
            this.zzs = true;
            this.zzh.removeAllViews();
            this.zzh = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzi;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzi = null;
        }
        this.zzg = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzh(int i, int i2, Intent intent) {
        zzdsj zze;
        AdOverlayInfoParcel adOverlayInfoParcel;
        if (i == 236) {
            zzbcv zzbcvVar = zzbde.zzny;
            if (((Boolean) zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zze.zza("Callback from intent launch with requestCode: 236 and resultCode: " + i2);
                zzcfg zzcfgVar = this.zzd;
                if (zzcfgVar == null || zzcfgVar.zzN() == null || (zze = zzcfgVar.zzN().zze()) == null || (adOverlayInfoParcel = this.zzc) == null || !((Boolean) zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
                    return;
                }
                zzdsi zza2 = zze.zza();
                zza2.zzb("action", "hilca");
                zza2.zzb("gqi", zzfwg.zzc(adOverlayInfoParcel.zzq));
                StringBuilder sb = new StringBuilder();
                sb.append(i2);
                zza2.zzb("hilr", sb.toString());
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("callerPackage");
                    String stringExtra2 = intent.getStringExtra("loadingStage");
                    if (stringExtra != null) {
                        zza2.zzb("hilcp", stringExtra);
                    }
                    if (stringExtra2 != null) {
                        zza2.zzb("hills", stringExtra2);
                    }
                }
                zza2.zzi();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzi() {
        this.zzn = 1;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzah
    public final void zzj() {
        this.zzn = 2;
        this.zzb.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzk(IObjectWrapper iObjectWrapper) {
        zzK((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007a A[Catch: zzg -> 0x00fa, TryCatch #0 {zzg -> 0x00fa, blocks: (B:11:0x001b, B:13:0x0029, B:15:0x002d, B:16:0x0030, B:18:0x003b, B:19:0x003d, B:21:0x0043, B:22:0x004f, B:24:0x0056, B:27:0x0063, B:29:0x0067, B:31:0x006c, B:33:0x007a, B:35:0x007e, B:37:0x0084, B:38:0x0087, B:40:0x008d, B:41:0x0090, B:43:0x0096, B:45:0x009a, B:46:0x009d, B:48:0x00a3, B:49:0x00a6, B:56:0x00d1, B:59:0x00d5, B:60:0x00dc, B:61:0x00dd, B:63:0x00e1, B:65:0x00ee, B:67:0x005d, B:69:0x0061, B:70:0x0076, B:71:0x00f2, B:72:0x00f9), top: B:10:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ee A[Catch: zzg -> 0x00fa, TryCatch #0 {zzg -> 0x00fa, blocks: (B:11:0x001b, B:13:0x0029, B:15:0x002d, B:16:0x0030, B:18:0x003b, B:19:0x003d, B:21:0x0043, B:22:0x004f, B:24:0x0056, B:27:0x0063, B:29:0x0067, B:31:0x006c, B:33:0x007a, B:35:0x007e, B:37:0x0084, B:38:0x0087, B:40:0x008d, B:41:0x0090, B:43:0x0096, B:45:0x009a, B:46:0x009d, B:48:0x00a3, B:49:0x00a6, B:56:0x00d1, B:59:0x00d5, B:60:0x00dc, B:61:0x00dd, B:63:0x00e1, B:65:0x00ee, B:67:0x005d, B:69:0x0061, B:70:0x0076, B:71:0x00f2, B:72:0x00f9), top: B:10:0x001b }] */
    @Override // com.google.android.gms.internal.ads.zzbtq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void zzl(Bundle bundle) {
        int i;
        if (!this.zzs) {
            this.zzb.requestWindowFeature(1);
        }
        this.zzj = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            Activity activity = this.zzb;
            AdOverlayInfoParcel zza2 = AdOverlayInfoParcel.zza(activity.getIntent());
            this.zzc = zza2;
            if (zza2 == null) {
                throw new zzg("Could not get info for ad overlay.");
            }
            if (zza2.zzw) {
                activity.setShowWhenLocked(true);
            }
            if (this.zzc.zzm.clientJarVersion > 7500000) {
                this.zzn = 4;
            }
            if (activity.getIntent() != null) {
                this.zzv = activity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
            com.google.android.gms.ads.internal.zzl zzlVar = adOverlayInfoParcel.zzo;
            if (zzlVar != null) {
                boolean z = zzlVar.zza;
                this.zzk = z;
                if (z) {
                    if (adOverlayInfoParcel.zzk != 5 && zzlVar.zzf != -1) {
                        new zzk(this, null).zzb();
                    }
                }
                if (bundle == null) {
                    if (this.zzv) {
                        zzcwl zzcwlVar = this.zzc.zzt;
                        if (zzcwlVar != null) {
                            zzcwlVar.zzb();
                        }
                        zzr zzrVar = this.zzc.zzc;
                        if (zzrVar != null) {
                            zzrVar.zzdt();
                        }
                    }
                    AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzc;
                    if (adOverlayInfoParcel2.zzk != 1) {
                        com.google.android.gms.ads.internal.client.zza zzaVar = adOverlayInfoParcel2.zzb;
                        if (zzaVar != null) {
                            zzaVar.onAdClicked();
                        }
                        zzded zzdedVar = this.zzc.zzu;
                        if (zzdedVar != null) {
                            zzdedVar.zzdf();
                        }
                    }
                }
                AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzc;
                zzh zzhVar = new zzh(activity, adOverlayInfoParcel3.zzn, adOverlayInfoParcel3.zzm.afmaVersion, adOverlayInfoParcel3.zzs);
                this.zzl = zzhVar;
                zzhVar.setId(1000);
                com.google.android.gms.ads.internal.zzv.zzs().zzl(activity);
                AdOverlayInfoParcel adOverlayInfoParcel4 = this.zzc;
                i = adOverlayInfoParcel4.zzk;
                if (i == 1) {
                    zzD(false);
                    return;
                }
                if (i == 2) {
                    this.zze = new zzi(adOverlayInfoParcel4.zzd);
                    zzD(false);
                    return;
                } else if (i == 3) {
                    zzD(true);
                    return;
                } else {
                    if (i != 5) {
                        throw new zzg("Could not determine ad overlay type.");
                    }
                    zzD(false);
                    return;
                }
            }
            if (adOverlayInfoParcel.zzk == 5) {
                this.zzk = true;
                if (adOverlayInfoParcel.zzk != 5) {
                    new zzk(this, null).zzb();
                }
                if (bundle == null) {
                }
                AdOverlayInfoParcel adOverlayInfoParcel32 = this.zzc;
                zzh zzhVar2 = new zzh(activity, adOverlayInfoParcel32.zzn, adOverlayInfoParcel32.zzm.afmaVersion, adOverlayInfoParcel32.zzs);
                this.zzl = zzhVar2;
                zzhVar2.setId(1000);
                com.google.android.gms.ads.internal.zzv.zzs().zzl(activity);
                AdOverlayInfoParcel adOverlayInfoParcel42 = this.zzc;
                i = adOverlayInfoParcel42.zzk;
                if (i == 1) {
                }
            } else {
                this.zzk = false;
                if (bundle == null) {
                }
                AdOverlayInfoParcel adOverlayInfoParcel322 = this.zzc;
                zzh zzhVar22 = new zzh(activity, adOverlayInfoParcel322.zzn, adOverlayInfoParcel322.zzm.afmaVersion, adOverlayInfoParcel322.zzs);
                this.zzl = zzhVar22;
                zzhVar22.setId(1000);
                com.google.android.gms.ads.internal.zzv.zzs().zzl(activity);
                AdOverlayInfoParcel adOverlayInfoParcel422 = this.zzc;
                i = adOverlayInfoParcel422.zzk;
                if (i == 1) {
                }
            }
        } catch (zzg e) {
            String message = e.getMessage();
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(message);
            this.zzn = 4;
            this.zzb.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzm() {
        zzcfg zzcfgVar = this.zzd;
        if (zzcfgVar != null) {
            try {
                this.zzl.removeView(zzcfgVar.zzF());
            } catch (NullPointerException unused) {
            }
        }
        zzF();
    }

    public final void zzn() {
        if (this.zzm) {
            this.zzm = false;
            zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzo() {
        zzr zzrVar;
        zzg();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
            zzrVar.zzdk();
        }
        if (!((Boolean) zzbd.zzc().zzb(zzbde.zzfp)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzp(int i, String[] strArr, int[] iArr) {
        if (i == 12345) {
            Activity activity = this.zzb;
            zzecm zze = zzecn.zze();
            zze.zza(activity);
            zze.zzb(this.zzc.zzk == 5 ? this : null);
            try {
                this.zzc.zzv.zzf(strArr, iArr, ObjectWrapper.wrap(zze.zze()));
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzq() {
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzr() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (zzrVar = adOverlayInfoParcel.zzc) != null) {
            zzrVar.zzd();
        }
        zzK(this.zzb.getResources().getConfiguration());
        if (((Boolean) zzbd.zzc().zzb(zzbde.zzfp)).booleanValue()) {
            return;
        }
        zzcfg zzcfgVar = this.zzd;
        if (zzcfgVar != null && !zzcfgVar.zzaE()) {
            this.zzd.onResume();
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("The webview does not exist. Ignoring action.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzs(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzt() {
        if (((Boolean) zzbd.zzc().zzb(zzbde.zzfp)).booleanValue()) {
            zzcfg zzcfgVar = this.zzd;
            if (zzcfgVar != null && !zzcfgVar.zzaE()) {
                this.zzd.onResume();
            } else {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("The webview does not exist. Ignoring action.");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzu() {
        if (((Boolean) zzbd.zzc().zzb(zzbde.zzfp)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzv() {
        zzr zzrVar;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null || (zzrVar = adOverlayInfoParcel.zzc) == null) {
            return;
        }
        zzrVar.zzdv();
    }

    public final void zzw(boolean z) {
        if (this.zzc.zzw) {
            return;
        }
        int intValue = ((Integer) zzbd.zzc().zzb(zzbde.zzfs)).intValue();
        boolean z2 = ((Boolean) zzbd.zzc().zzb(zzbde.zzbn)).booleanValue() || z;
        zzt zztVar = new zzt();
        zztVar.zzd = 50;
        zztVar.zza = true != z2 ? 0 : intValue;
        zztVar.zzb = true != z2 ? intValue : 0;
        zztVar.zzc = intValue;
        this.zzf = new zzu(this.zzb, zztVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(true != z2 ? 9 : 11);
        zzy(z, this.zzc.zzg);
        this.zzl.addView(this.zzf, layoutParams);
        zzJ(this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzx() {
        this.zzs = true;
    }

    public final void zzy(boolean z, boolean z2) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        com.google.android.gms.ads.internal.zzl zzlVar;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        com.google.android.gms.ads.internal.zzl zzlVar2;
        boolean z3 = true;
        boolean z4 = ((Boolean) zzbd.zzc().zzb(zzbde.zzbl)).booleanValue() && (adOverlayInfoParcel2 = this.zzc) != null && (zzlVar2 = adOverlayInfoParcel2.zzo) != null && zzlVar2.zzh;
        boolean z5 = ((Boolean) zzbd.zzc().zzb(zzbde.zzbm)).booleanValue() && (adOverlayInfoParcel = this.zzc) != null && (zzlVar = adOverlayInfoParcel.zzo) != null && zzlVar.zzi;
        if (z && z2 && z4 && !z5) {
            new zzbsu(this.zzd, "useCustomClose").zzh("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzu zzuVar = this.zzf;
        if (zzuVar != null) {
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            zzuVar.zzb(z3);
        }
    }

    public final void zzz() {
        this.zzl.removeView(this.zzf);
        zzw(true);
    }
}
