package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Looper;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.internal.ads.zzbcj;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzfrw;
import com.google.common.util.concurrent.ListenableFuture;
import com.ironsource.C3061e8;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.rendering.model.EventTaskParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes5.dex */
final class zzcgf extends WebView implements DownloadListener, ViewTreeObserver.OnGlobalLayoutListener, zzcfg {
    public static final /* synthetic */ int zza = 0;
    private final String zzA;
    private zzcgi zzB;
    private boolean zzC;
    private boolean zzD;
    private zzbgd zzE;
    private zzbgb zzF;
    private zzbaq zzG;
    private int zzH;
    private int zzI;
    private zzbdq zzJ;
    private final zzbdq zzK;
    private zzbdq zzL;
    private final zzbdr zzM;
    private int zzN;
    private com.google.android.gms.ads.internal.overlay.zzm zzO;
    private boolean zzP;
    private final com.google.android.gms.ads.internal.util.zzck zzQ;
    private int zzR;
    private int zzS;
    private int zzT;
    private int zzU;
    private int zzV;
    private Map zzW;
    private final WindowManager zzX;
    private final zzbcc zzY;
    private boolean zzZ;
    private final zzchc zzb;
    private final zzavu zzc;
    private final zzfda zzd;
    private final zzbel zze;
    private final VersionInfoParcel zzf;
    private com.google.android.gms.ads.internal.zzn zzg;
    private final com.google.android.gms.ads.internal.zza zzh;
    private final DisplayMetrics zzi;
    private final float zzj;
    private zzfca zzk;
    private zzfcd zzl;
    private boolean zzm;
    private boolean zzn;
    private zzcfo zzo;
    private com.google.android.gms.ads.internal.overlay.zzm zzp;
    private zzedh zzq;
    private zzedf zzr;
    private zzchd zzs;
    private final String zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private Boolean zzy;
    private boolean zzz;

    protected zzcgf(zzchc zzchcVar, zzchd zzchdVar, String str, boolean z, boolean z2, zzavu zzavuVar, zzbel zzbelVar, VersionInfoParcel versionInfoParcel, zzbdt zzbdtVar, com.google.android.gms.ads.internal.zzn zznVar, com.google.android.gms.ads.internal.zza zzaVar, zzbcc zzbccVar, zzfca zzfcaVar, zzfcd zzfcdVar, zzfda zzfdaVar) {
        super(zzchcVar);
        zzfcd zzfcdVar2;
        this.zzm = false;
        this.zzn = false;
        this.zzz = true;
        this.zzA = "";
        this.zzR = -1;
        this.zzS = -1;
        this.zzT = -1;
        this.zzU = -1;
        this.zzV = -1;
        this.zzb = zzchcVar;
        this.zzs = zzchdVar;
        this.zzt = str;
        this.zzw = z;
        this.zzc = zzavuVar;
        this.zzd = zzfdaVar;
        this.zze = zzbelVar;
        this.zzf = versionInfoParcel;
        this.zzg = zznVar;
        this.zzh = zzaVar;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.zzX = windowManager;
        com.google.android.gms.ads.internal.zzv.zzr();
        DisplayMetrics zzu = com.google.android.gms.ads.internal.util.zzs.zzu(windowManager);
        this.zzi = zzu;
        this.zzj = zzu.density;
        this.zzY = zzbccVar;
        this.zzk = zzfcaVar;
        this.zzl = zzfcdVar;
        this.zzQ = new com.google.android.gms.ads.internal.util.zzck(zzchcVar.zza(), this, this, null);
        this.zzZ = false;
        setBackgroundColor(0);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlZ)).booleanValue()) {
            setSoundEffectsEnabled(false);
        }
        final WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlY)).booleanValue()) {
            settings.setMixedContentMode(1);
        } else {
            settings.setMixedContentMode(2);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznB)).booleanValue()) {
            settings.setGeolocationEnabled(false);
        }
        settings.setUserAgentString(com.google.android.gms.ads.internal.zzv.zzr().zzc(zzchcVar, versionInfoParcel.afmaVersion));
        com.google.android.gms.ads.internal.zzv.zzr();
        final Context context = getContext();
        com.google.android.gms.ads.internal.util.zzcd.zza(context, new Callable() { // from class: com.google.android.gms.ads.internal.util.zzk
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzfrw zzfrwVar = zzs.zza;
                String absolutePath = context.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath();
                WebSettings webSettings = settings;
                webSettings.setDatabasePath(absolutePath);
                webSettings.setDatabaseEnabled(true);
                webSettings.setDomStorageEnabled(true);
                webSettings.setDisplayZoomControls(false);
                webSettings.setBuiltInZoomControls(true);
                webSettings.setSupportZoom(true);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaZ)).booleanValue()) {
                    webSettings.setTextZoom(100);
                }
                webSettings.setAllowContentAccess(false);
                return true;
            }
        });
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        setDownloadListener(this);
        zzba();
        addJavascriptInterface(new zzcgm(this, new zzcgl(this)), "googleAdsJsInterface");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        zzbi();
        zzbdr zzbdrVar = new zzbdr(new zzbdt(true, "make_wv", this.zzt));
        this.zzM = zzbdrVar;
        zzbdrVar.zza().zzc(null);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcc)).booleanValue() && (zzfcdVar2 = this.zzl) != null && zzfcdVar2.zzb != null) {
            zzbdrVar.zza().zzd("gqi", this.zzl.zzb);
        }
        zzbdrVar.zza();
        zzbdq zzf = zzbdt.zzf();
        this.zzK = zzf;
        zzbdrVar.zzb("native:view_create", zzf);
        this.zzL = null;
        this.zzJ = null;
        com.google.android.gms.ads.internal.util.zzcg.zza().zzb(zzchcVar);
        com.google.android.gms.ads.internal.zzv.zzp().zzt();
    }

    private final synchronized void zzba() {
        zzfca zzfcaVar = this.zzk;
        if (zzfcaVar != null && zzfcaVar.zzam) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Disabling hardware acceleration on an overlay.");
            zzbc();
            return;
        }
        if (!this.zzw && !this.zzs.zzi()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Enabling hardware acceleration on an AdView.");
            zzbe();
            return;
        }
        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Enabling hardware acceleration on an overlay.");
        zzbe();
    }

    private final synchronized void zzbb() {
        if (this.zzP) {
            return;
        }
        this.zzP = true;
        com.google.android.gms.ads.internal.zzv.zzp().zzr();
    }

    private final synchronized void zzbc() {
        if (!this.zzx) {
            setLayerType(1, null);
        }
        this.zzx = true;
    }

    private final void zzbd(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(C3061e8.k, true != z ? "0" : "1");
        zzd("onAdVisibilityChanged", hashMap);
    }

    private final synchronized void zzbe() {
        if (this.zzx) {
            setLayerType(0, null);
        }
        this.zzx = false;
    }

    private final synchronized void zzbf(String str) {
        final String str2 = AndroidWebViewClient.BLANK_PAGE;
        try {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable(str2) { // from class: com.google.android.gms.internal.ads.zzcga
                public final /* synthetic */ String zzb = AndroidWebViewClient.BLANK_PAGE;

                @Override // java.lang.Runnable
                public final void run() {
                    zzcgf zzcgfVar = zzcgf.this;
                    String str3 = this.zzb;
                    super/*android.webkit.WebView*/.loadUrl(AndroidWebViewClient.BLANK_PAGE);
                }
            });
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "AdWebViewImpl.loadUrlUnsafe");
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Could not call loadUrl in destroy(). ", th);
        }
    }

    private final void zzbg() {
        zzbdl.zza(this.zzM.zza(), this.zzK, "aeh2");
    }

    private final synchronized void zzbh() {
        Map map = this.zzW;
        if (map != null) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                ((zzcdn) it.next()).release();
            }
        }
        this.zzW = null;
    }

    private final void zzbi() {
        zzbdr zzbdrVar = this.zzM;
        if (zzbdrVar == null) {
            return;
        }
        zzbdt zza2 = zzbdrVar.zza();
        zzbdj zzg = com.google.android.gms.ads.internal.zzv.zzp().zzg();
        if (zzg != null) {
            zzg.zzf(zza2);
        }
    }

    private final synchronized void zzbj() {
        Boolean zzl = com.google.android.gms.ads.internal.zzv.zzp().zzl();
        this.zzy = zzl;
        if (zzl == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                zzaY(true);
            } catch (IllegalStateException unused) {
                zzaY(false);
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcfg
    public final synchronized void destroy() {
        zzbi();
        this.zzQ.zza();
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzb();
            this.zzp.zzm();
            this.zzp = null;
        }
        this.zzq = null;
        this.zzr = null;
        this.zzo.zzl();
        this.zzG = null;
        this.zzg = null;
        setOnClickListener(null);
        setOnTouchListener(null);
        if (this.zzv) {
            return;
        }
        com.google.android.gms.ads.internal.zzv.zzA().zzd(this);
        zzbh();
        this.zzv = true;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlj)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zza("Destroying the WebView immediately...");
            zzX();
            return;
        }
        Activity zza2 = this.zzb.zza();
        if (zza2 != null && zza2.isDestroyed()) {
            com.google.android.gms.ads.internal.util.zze.zza("Destroying the WebView immediately...");
            zzX();
        } else {
            com.google.android.gms.ads.internal.util.zze.zza("Initiating WebView self destruct sequence in 3...");
            com.google.android.gms.ads.internal.util.zze.zza("Loading blank page in WebView, 2...");
            zzbf(AndroidWebViewClient.BLANK_PAGE);
        }
    }

    @Override // android.webkit.WebView
    public final synchronized void evaluateJavascript(final String str, final ValueCallback valueCallback) {
        if (zzaE()) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#004 The webview is destroyed. Ignoring action.", null);
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
                return;
            }
            return;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlk)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
            super.evaluateJavascript(str, valueCallback);
        } else {
            zzcaf.zzf.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfz
                @Override // java.lang.Runnable
                public final void run() {
                    super/*android.webkit.WebView*/.evaluateJavascript(str, valueCallback);
                }
            });
        }
    }

    protected final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.zzv) {
                    this.zzo.zzl();
                    com.google.android.gms.ads.internal.zzv.zzA().zzd(this);
                    zzbh();
                    zzbb();
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcfg
    public final synchronized void loadData(String str, String str2, String str3) {
        if (!zzaE()) {
            super.loadData(str, str2, str3);
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcfg
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        try {
            try {
                if (!zzaE()) {
                    super.loadDataWithBaseURL(str, str2, str3, str4, str5);
                } else {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("#004 The webview is destroyed. Ignoring action.");
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcfg
    public final synchronized void loadUrl(final String str) {
        if (zzaE()) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("#004 The webview is destroyed. Ignoring action.");
            return;
        }
        try {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgc
                @Override // java.lang.Runnable
                public final void run() {
                    super/*android.webkit.WebView*/.loadUrl(str);
                }
            });
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(th, "AdWebViewImpl.loadUrl");
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Could not call loadUrl. ", th);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzcfo zzcfoVar = this.zzo;
        if (zzcfoVar != null) {
            zzcfoVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!zzaE()) {
            this.zzQ.zzc();
        }
        if (this.zzZ) {
            onResume();
            this.zzZ = false;
        }
        boolean z = this.zzC;
        zzcfo zzcfoVar = this.zzo;
        if (zzcfoVar != null && zzcfoVar.zzW()) {
            if (!this.zzD) {
                this.zzo.zza();
                this.zzo.zzb();
                this.zzD = true;
            }
            zzaZ();
            z = true;
        }
        zzbd(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        zzcfo zzcfoVar;
        synchronized (this) {
            if (!zzaE()) {
                this.zzQ.zzd();
            }
            super.onDetachedFromWindow();
            if (this.zzD && (zzcfoVar = this.zzo) != null && zzcfoVar.zzW() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzo.zza();
                this.zzo.zzb();
                this.zzD = false;
            }
        }
        zzbd(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzly)).booleanValue() && getContext() != null) {
                intent.setPackage(getContext().getPackageName());
            }
            com.google.android.gms.ads.internal.zzv.zzr();
            com.google.android.gms.ads.internal.util.zzs.zzU(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            String str5 = "Couldn't find an Activity to view url/mimetype: " + str + " / " + str4;
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze(str5);
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AdWebViewImpl.onDownloadStart: ".concat(String.valueOf(str)));
        }
    }

    @Override // android.webkit.WebView, android.view.View
    protected final void onDraw(Canvas canvas) {
        if (zzaE()) {
            return;
        }
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zzaZ = zzaZ();
        com.google.android.gms.ads.internal.overlay.zzm zzL = zzL();
        if (zzL == null || !zzaZ) {
            return;
        }
        zzL.zzn();
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01b9 A[Catch: all -> 0x01df, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:10:0x000f, B:12:0x0015, B:14:0x0019, B:17:0x0023, B:19:0x002b, B:22:0x0030, B:24:0x0038, B:26:0x004a, B:29:0x004f, B:31:0x0056, B:34:0x0060, B:37:0x0065, B:40:0x0076, B:41:0x008c, B:45:0x007d, B:48:0x0082, B:52:0x0099, B:54:0x00a1, B:56:0x00b3, B:59:0x00b8, B:61:0x00d4, B:62:0x00dc, B:65:0x00d8, B:66:0x00e1, B:68:0x00e9, B:71:0x00f4, B:78:0x0118, B:80:0x011f, B:84:0x0127, B:86:0x0139, B:88:0x0147, B:91:0x0154, B:95:0x0159, B:97:0x01a1, B:98:0x01a5, B:100:0x01ac, B:105:0x01b9, B:107:0x01bf, B:108:0x01c2, B:110:0x01c6, B:111:0x01cf, B:117:0x01da), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0139 A[Catch: all -> 0x01df, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:10:0x000f, B:12:0x0015, B:14:0x0019, B:17:0x0023, B:19:0x002b, B:22:0x0030, B:24:0x0038, B:26:0x004a, B:29:0x004f, B:31:0x0056, B:34:0x0060, B:37:0x0065, B:40:0x0076, B:41:0x008c, B:45:0x007d, B:48:0x0082, B:52:0x0099, B:54:0x00a1, B:56:0x00b3, B:59:0x00b8, B:61:0x00d4, B:62:0x00dc, B:65:0x00d8, B:66:0x00e1, B:68:0x00e9, B:71:0x00f4, B:78:0x0118, B:80:0x011f, B:84:0x0127, B:86:0x0139, B:88:0x0147, B:91:0x0154, B:95:0x0159, B:97:0x01a1, B:98:0x01a5, B:100:0x01ac, B:105:0x01b9, B:107:0x01bf, B:108:0x01c2, B:110:0x01c6, B:111:0x01cf, B:117:0x01da), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0159 A[Catch: all -> 0x01df, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:10:0x000f, B:12:0x0015, B:14:0x0019, B:17:0x0023, B:19:0x002b, B:22:0x0030, B:24:0x0038, B:26:0x004a, B:29:0x004f, B:31:0x0056, B:34:0x0060, B:37:0x0065, B:40:0x0076, B:41:0x008c, B:45:0x007d, B:48:0x0082, B:52:0x0099, B:54:0x00a1, B:56:0x00b3, B:59:0x00b8, B:61:0x00d4, B:62:0x00dc, B:65:0x00d8, B:66:0x00e1, B:68:0x00e9, B:71:0x00f4, B:78:0x0118, B:80:0x011f, B:84:0x0127, B:86:0x0139, B:88:0x0147, B:91:0x0154, B:95:0x0159, B:97:0x01a1, B:98:0x01a5, B:100:0x01ac, B:105:0x01b9, B:107:0x01bf, B:108:0x01c2, B:110:0x01c6, B:111:0x01cf, B:117:0x01da), top: B:3:0x0003 }] */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final synchronized void onMeasure(int i, int i2) {
        int i3;
        zzchd zzchdVar;
        boolean z;
        int i4;
        int i5;
        int i6 = 0;
        if (zzaE()) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (!isInEditMode() && !this.zzw && !this.zzs.zzf()) {
            if (this.zzs.zzh()) {
                super.onMeasure(i, i2);
                return;
            }
            if (this.zzs.zzj()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzef)).booleanValue()) {
                    super.onMeasure(i, i2);
                    return;
                }
                zzcgi zzq = zzq();
                float zze = zzq != null ? zzq.zze() : 0.0f;
                if (zze == 0.0f) {
                    super.onMeasure(i, i2);
                    return;
                }
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                float f = size2 * zze;
                int i7 = (int) (size / zze);
                if (size2 == 0) {
                    if (i7 != 0) {
                        i5 = (int) (i7 * zze);
                        i6 = size;
                        i4 = i7;
                        setMeasuredDimension(Math.min(i5, i6), Math.min(i7, i4));
                        return;
                    }
                    size2 = 0;
                }
                int i8 = (int) f;
                if (size != 0) {
                    i6 = size;
                } else if (i8 != 0) {
                    i7 = (int) (i8 / zze);
                    i4 = size2;
                    i5 = i8;
                    i6 = i5;
                    setMeasuredDimension(Math.min(i5, i6), Math.min(i7, i4));
                    return;
                }
                i4 = size2;
                i5 = i8;
                setMeasuredDimension(Math.min(i5, i6), Math.min(i7, i4));
                return;
            }
            if (this.zzs.zzg()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzen)).booleanValue()) {
                    super.onMeasure(i, i2);
                    return;
                }
                zzag("/contentHeight", new zzcgd(this));
                zzaW("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
                float f2 = this.zzi.density;
                int size3 = View.MeasureSpec.getSize(i);
                int i9 = this.zzI;
                setMeasuredDimension(size3, i9 != -1 ? (int) (i9 * f2) : View.MeasureSpec.getSize(i2));
                return;
            }
            if (this.zzs.zzi()) {
                DisplayMetrics displayMetrics = this.zzi;
                setMeasuredDimension(displayMetrics.widthPixels, displayMetrics.heightPixels);
                return;
            }
            int mode = View.MeasureSpec.getMode(i);
            int size4 = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size5 = View.MeasureSpec.getSize(i2);
            if (mode != Integer.MIN_VALUE && mode != 1073741824) {
                i3 = Integer.MAX_VALUE;
                int i10 = (mode2 != Integer.MIN_VALUE || mode2 == 1073741824) ? size5 : Integer.MAX_VALUE;
                zzchdVar = this.zzs;
                if (zzchdVar.zzb <= i3 && zzchdVar.zza <= i10) {
                    z = false;
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfM)).booleanValue()) {
                        zzchd zzchdVar2 = this.zzs;
                        float f3 = zzchdVar2.zzb;
                        float f4 = this.zzj;
                        z &= f3 / f4 <= ((float) i3) / f4 && ((float) zzchdVar2.zza) / f4 <= ((float) i10) / f4;
                    }
                    if (z) {
                        if (getVisibility() != 8) {
                            setVisibility(0);
                        }
                        if (!this.zzn) {
                            this.zzY.zzc(10002);
                            this.zzn = true;
                        }
                        zzchd zzchdVar3 = this.zzs;
                        setMeasuredDimension(zzchdVar3.zzb, zzchdVar3.zza);
                        return;
                    }
                    zzchd zzchdVar4 = this.zzs;
                    float f5 = zzchdVar4.zzb;
                    float f6 = this.zzj;
                    String str = "Not enough space to show ad. Needs " + ((int) (f5 / f6)) + VastAttributes.HORIZONTAL_POSITION + ((int) (zzchdVar4.zza / f6)) + " dp, but only has " + ((int) (size4 / f6)) + VastAttributes.HORIZONTAL_POSITION + ((int) (size5 / f6)) + " dp.";
                    int i11 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj(str);
                    if (getVisibility() != 8) {
                        setVisibility(4);
                    }
                    setMeasuredDimension(0, 0);
                    if (this.zzm) {
                        return;
                    }
                    this.zzY.zzc(10001);
                    this.zzm = true;
                    return;
                }
                z = true;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfM)).booleanValue()) {
                }
                if (z) {
                }
            }
            i3 = size4;
            if (mode2 != Integer.MIN_VALUE) {
            }
            zzchdVar = this.zzs;
            if (zzchdVar.zzb <= i3) {
                z = false;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfM)).booleanValue()) {
                }
                if (z) {
                }
            }
            z = true;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfM)).booleanValue()) {
            }
            if (z) {
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcfg
    public final void onPause() {
        if (zzaE()) {
            return;
        }
        try {
            super.onPause();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmX)).booleanValue() && WebViewFeature.isFeatureSupported("MUTE_AUDIO")) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Muting webview");
                WebViewCompat.setAudioMuted(this, true);
            }
        } catch (Exception e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Could not pause webview.", e);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzna)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AdWebViewImpl.onPause");
            }
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcfg
    public final void onResume() {
        if (zzaE()) {
            return;
        }
        try {
            super.onResume();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmX)).booleanValue() && WebViewFeature.isFeatureSupported("MUTE_AUDIO")) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zze("Unmuting webview");
                WebViewCompat.setAudioMuted(this, false);
            }
        } catch (Exception e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Could not resume webview.", e);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzna)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AdWebViewImpl.onResume");
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdN)).booleanValue() && this.zzo.zzT();
        if ((!this.zzo.zzW() || this.zzo.zzU()) && !z) {
            zzavu zzavuVar = this.zzc;
            if (zzavuVar != null) {
                zzavuVar.zzd(motionEvent);
            }
            zzbel zzbelVar = this.zze;
            if (zzbelVar != null) {
                zzbelVar.zzb(motionEvent);
            }
        } else {
            synchronized (this) {
                zzbgd zzbgdVar = this.zzE;
                if (zzbgdVar != null) {
                    zzbgdVar.zzd(motionEvent);
                }
            }
        }
        if (zzaE()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzcfg
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzcfo) {
            this.zzo = (zzcfo) webViewClient;
        }
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        if (zzaE()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Could not stop loading webview.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final synchronized void zzA(int i) {
        this.zzN = i;
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzB(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzccb
    public final synchronized void zzC(zzcgi zzcgiVar) {
        if (this.zzB == null) {
            this.zzB = zzcgiVar;
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Attempt to create multiple AdWebViewVideoControllers.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcex
    public final zzfca zzD() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final Context zzE() {
        return this.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgv
    public final View zzF() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final WebView zzG() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final WebViewClient zzH() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgt
    public final zzavu zzI() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized zzbaq zzJ() {
        return this.zzG;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized zzbgd zzK() {
        return this.zzE;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized com.google.android.gms.ads.internal.overlay.zzm zzL() {
        return this.zzp;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized com.google.android.gms.ads.internal.overlay.zzm zzM() {
        return this.zzO;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final /* synthetic */ zzcgy zzN() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgs
    public final synchronized zzchd zzO() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized zzedf zzP() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized zzedh zzQ() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgj
    public final zzfcd zzR() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final zzfda zzS() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final ListenableFuture zzT() {
        zzbel zzbelVar = this.zze;
        return zzbelVar == null ? zzgdn.zzh(null) : zzbelVar.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized String zzU() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final List zzV() {
        return new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzW(zzfca zzfcaVar, zzfcd zzfcdVar) {
        this.zzk = zzfcaVar;
        this.zzl = zzfcdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzX() {
        com.google.android.gms.ads.internal.util.zze.zza("Destroying WebView!");
        zzbb();
        com.google.android.gms.ads.internal.util.zzs.zza.post(new zzcge(this));
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzY() {
        zzbg();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzf.afmaVersion);
        zzd("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzZ(int i) {
        if (i == 0) {
            zzbdr zzbdrVar = this.zzM;
            zzbdl.zza(zzbdrVar.zza(), this.zzK, "aebb2");
        }
        zzbg();
        zzbdr zzbdrVar2 = this.zzM;
        zzbdrVar2.zza();
        zzbdrVar2.zza().zzd("close_type", String.valueOf(i));
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzf.afmaVersion);
        zzd("onhide", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzbnm
    public final void zza(String str) {
        zzaW(str);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzaA(String str, Predicate predicate) {
        zzcfo zzcfoVar = this.zzo;
        if (zzcfoVar != null) {
            zzcfoVar.zzS(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized boolean zzaB() {
        return this.zzu;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized boolean zzaC() {
        return this.zzH > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final boolean zzaD(final boolean z, final int i) {
        destroy();
        zzbcb zzbcbVar = new zzbcb() { // from class: com.google.android.gms.internal.ads.zzcgb
            @Override // com.google.android.gms.internal.ads.zzbcb
            public final void zza(zzbcj.zzt.zza zzaVar) {
                int i2 = zzcgf.zza;
                zzbcj.zzbl.zza zzb = zzbcj.zzbl.zzb();
                boolean zzf = zzb.zzf();
                boolean z2 = z;
                if (zzf != z2) {
                    zzb.zzd(z2);
                }
                zzb.zze(i);
                zzaVar.zzab(zzb.zzbr());
            }
        };
        zzbcc zzbccVar = this.zzY;
        zzbccVar.zzb(zzbcbVar);
        zzbccVar.zzc(GamesActivityResultCodes.RESULT_LICENSE_FAILED);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized boolean zzaE() {
        return this.zzv;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized boolean zzaF() {
        return this.zzw;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final boolean zzaG() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized boolean zzaH() {
        return this.zzz;
    }

    @Override // com.google.android.gms.internal.ads.zzcgq
    public final void zzaJ(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z, boolean z2, String str) {
        this.zzo.zzv(zzcVar, z, z2, str);
    }

    @Override // com.google.android.gms.internal.ads.zzcgq
    public final void zzaK(String str, String str2, int i) {
        this.zzo.zzw(str, str2, 14);
    }

    @Override // com.google.android.gms.internal.ads.zzcgq
    public final void zzaL(boolean z, int i, boolean z2) {
        this.zzo.zzx(z, i, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcgq
    public final void zzaM(boolean z, int i, String str, String str2, boolean z2) {
        this.zzo.zzz(z, i, str, str2, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzcgq
    public final void zzaN(boolean z, int i, String str, boolean z2, boolean z3) {
        this.zzo.zzA(z, i, str, z2, z3);
    }

    public final zzcfo zzaO() {
        return this.zzo;
    }

    final synchronized Boolean zzaP() {
        return this.zzy;
    }

    protected final synchronized void zzaV(String str, ValueCallback valueCallback) {
        if (!zzaE()) {
            evaluateJavascript(str, null);
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    protected final void zzaW(String str) {
        if (!PlatformVersion.isAtLeastKitKat()) {
            zzaX("javascript:".concat(str));
            return;
        }
        if (zzaP() == null) {
            zzbj();
        }
        if (zzaP().booleanValue()) {
            zzaV(str, null);
        } else {
            zzaX("javascript:".concat(str));
        }
    }

    protected final synchronized void zzaX(String str) {
        if (!zzaE()) {
            loadUrl(str);
        } else {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    final void zzaY(Boolean bool) {
        synchronized (this) {
            this.zzy = bool;
        }
        com.google.android.gms.ads.internal.zzv.zzp().zzy(bool);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0083, code lost:
    
        if (r10.zzV != r9) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a3, code lost:
    
        if (r10.zzV != r9) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zzaZ() {
        int i;
        int i2;
        boolean z = false;
        if (this.zzo.zzV() || this.zzo.zzW()) {
            com.google.android.gms.ads.internal.client.zzbb.zzb();
            DisplayMetrics displayMetrics = this.zzi;
            int zzA = com.google.android.gms.ads.internal.util.client.zzf.zzA(displayMetrics, displayMetrics.widthPixels);
            com.google.android.gms.ads.internal.client.zzbb.zzb();
            int zzA2 = com.google.android.gms.ads.internal.util.client.zzf.zzA(displayMetrics, displayMetrics.heightPixels);
            Activity zza2 = this.zzb.zza();
            if (zza2 == null || zza2.getWindow() == null) {
                i = zzA;
                i2 = zzA2;
            } else {
                com.google.android.gms.ads.internal.zzv.zzr();
                int[] zzR = com.google.android.gms.ads.internal.util.zzs.zzR(zza2);
                com.google.android.gms.ads.internal.client.zzbb.zzb();
                i = com.google.android.gms.ads.internal.util.client.zzf.zzA(displayMetrics, zzR[0]);
                com.google.android.gms.ads.internal.client.zzbb.zzb();
                i2 = com.google.android.gms.ads.internal.util.client.zzf.zzA(displayMetrics, zzR[1]);
            }
            com.google.android.gms.ads.internal.zzv.zzr();
            int rotation = this.zzX.getDefaultDisplay().getRotation();
            if (this.zzS == zzA && this.zzR == zzA2 && this.zzT == i && this.zzU == i2) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaj)).booleanValue()) {
                }
            }
            if (this.zzS == zzA && this.zzR == zzA2) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaj)).booleanValue()) {
                }
                this.zzS = zzA;
                this.zzR = zzA2;
                this.zzT = i;
                this.zzU = i2;
                this.zzV = rotation;
                new zzbsu(this, "").zzj(zzA, zzA2, i, i2, displayMetrics.density, rotation);
                return z;
            }
            z = true;
            this.zzS = zzA;
            this.zzR = zzA2;
            this.zzT = i;
            this.zzU = i2;
            this.zzV = rotation;
            new zzbsu(this, "").zzj(zzA, zzA2, i, i2, displayMetrics.density, rotation);
            return z;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzaa() {
        if (this.zzJ == null) {
            zzbdr zzbdrVar = this.zzM;
            zzbdl.zza(zzbdrVar.zza(), this.zzK, "aes2");
            zzbdrVar.zza();
            zzbdq zzf = zzbdt.zzf();
            this.zzJ = zzf;
            zzbdrVar.zzb("native:view_show", zzf);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzf.afmaVersion);
        zzd("onshow", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzab() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(com.google.android.gms.ads.internal.zzv.zzt().zze()));
        hashMap.put("app_volume", String.valueOf(com.google.android.gms.ads.internal.zzv.zzt().zza()));
        hashMap.put("device_volume", String.valueOf(com.google.android.gms.ads.internal.util.zzab.zzb(getContext())));
        zzd("volume", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzac(boolean z) {
        this.zzo.zzm(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzad() {
        this.zzQ.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzae(String str, String str2, String str3) {
        Throwable th;
        String str4;
        try {
            try {
                if (zzaE()) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("#004 The webview is destroyed. Ignoring action.");
                    return;
                }
                String[] strArr = new String[1];
                String str5 = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzag);
                JSONObject jSONObject = new JSONObject();
                try {
                    try {
                        jSONObject.put("version", str5);
                        jSONObject.put("sdk", "Google Mobile Ads");
                        jSONObject.put("sdkVersion", "12.4.51-000");
                        str4 = "<script>Object.defineProperty(window,'MRAID_ENV',{get:function(){return " + jSONObject.toString() + "}});</script>";
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } catch (JSONException e) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzk("Unable to build MRAID_ENV", e);
                    str4 = null;
                }
                strArr[0] = str4;
                super.loadDataWithBaseURL(str, zzcgr.zzb(str2, strArr), "text/html", "UTF-8", null);
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzaf() {
        if (this.zzL == null) {
            zzbdr zzbdrVar = this.zzM;
            zzbdrVar.zza();
            zzbdq zzf = zzbdt.zzf();
            this.zzL = zzf;
            zzbdrVar.zzb("native:view_load", zzf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzag(String str, zzbkf zzbkfVar) {
        zzcfo zzcfoVar = this.zzo;
        if (zzcfoVar != null) {
            zzcfoVar.zzB(str, zzbkfVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzah() {
        com.google.android.gms.ads.internal.util.zze.zza("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzai(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzp = zzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzaj(zzchd zzchdVar) {
        this.zzs = zzchdVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzak(zzbaq zzbaqVar) {
        this.zzG = zzbaqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzal(boolean z) {
        this.zzz = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzam() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzan(Context context) {
        zzchc zzchcVar = this.zzb;
        zzchcVar.setBaseContext(context);
        this.zzQ.zze(zzchcVar.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzao(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzy(this.zzo.zzV(), z);
        } else {
            this.zzu = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzap(zzbgb zzbgbVar) {
        this.zzF = zzbgbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzaq(boolean z) {
        boolean z2 = this.zzw;
        this.zzw = z;
        zzba();
        if (z != z2) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzah)).booleanValue() || !this.zzs.zzi()) {
                new zzbsu(this, "").zzl(true != z ? EventTaskParams.STATE_GROUP_DEFAULT : "expanded");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzar(zzbgd zzbgdVar) {
        this.zzE = zzbgdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzas(zzedf zzedfVar) {
        this.zzr = zzedfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzat(zzedh zzedhVar) {
        this.zzq = zzedhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzau(int i) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzA(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzav(boolean z) {
        this.zzZ = true;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzaw(com.google.android.gms.ads.internal.overlay.zzm zzmVar) {
        this.zzO = zzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzax(boolean z) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVar;
        int i = this.zzH + (true != z ? -1 : 1);
        this.zzH = i;
        if (i > 0 || (zzmVar = this.zzp) == null) {
            return;
        }
        zzmVar.zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final synchronized void zzay(boolean z) {
        if (z) {
            setBackgroundColor(0);
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVar = this.zzp;
        if (zzmVar != null) {
            zzmVar.zzB(z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfg
    public final void zzaz(String str, zzbkf zzbkfVar) {
        zzcfo zzcfoVar = this.zzo;
        if (zzcfoVar != null) {
            zzcfoVar.zzR(str, zzbkfVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbnm
    public final void zzb(String str, String str2) {
        zzaW(str + "(" + str2 + ");");
    }

    @Override // com.google.android.gms.internal.ads.zzbna
    public final void zzd(String str, Map map) {
        try {
            zze(str, com.google.android.gms.ads.internal.client.zzbb.zzb().zzo(map));
        } catch (JSONException unused) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdH() {
        zzcfo zzcfoVar = this.zzo;
        if (zzcfoVar != null) {
            zzcfoVar.zzdH();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdf() {
        zzcfo zzcfoVar = this.zzo;
        if (zzcfoVar != null) {
            zzcfoVar.zzdf();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final synchronized void zzdg() {
        com.google.android.gms.ads.internal.zzn zznVar = this.zzg;
        if (zznVar != null) {
            zznVar.zzdg();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final synchronized void zzdh() {
        com.google.android.gms.ads.internal.zzn zznVar = this.zzg;
        if (zznVar != null) {
            zznVar.zzdh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzdi() {
        com.google.android.gms.ads.internal.overlay.zzm zzL = zzL();
        if (zzL != null) {
            zzL.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzazd
    public final void zzdr(zzazc zzazcVar) {
        synchronized (this) {
            this.zzC = zzazcVar.zzj;
        }
        zzbd(zzazcVar.zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzbna
    public final void zze(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(jSONObject2);
        sb.append(");");
        String sb2 = sb.toString();
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zze("Dispatching AFMA event: ".concat(sb2));
        zzaW(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final synchronized int zzf() {
        return this.zzN;
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final int zzg() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final int zzh() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgn, com.google.android.gms.internal.ads.zzccb
    public final Activity zzi() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzccb
    public final com.google.android.gms.ads.internal.zza zzj() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final zzbdq zzk() {
        return this.zzK;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzccb
    public final zzbdr zzl() {
        return this.zzM;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzcgu, com.google.android.gms.internal.ads.zzccb
    public final VersionInfoParcel zzm() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final zzcbq zzn() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final synchronized zzcdn zzo(String str) {
        Map map = this.zzW;
        if (map == null) {
            return null;
        }
        return (zzcdn) map.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbnm
    public final void zzp(String str, JSONObject jSONObject) {
        zzb(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzccb
    public final synchronized zzcgi zzq() {
        return this.zzB;
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final synchronized String zzr() {
        zzfcd zzfcdVar = this.zzl;
        if (zzfcdVar == null) {
            return null;
        }
        return zzfcdVar.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final synchronized String zzs() {
        return this.zzA;
    }

    @Override // com.google.android.gms.internal.ads.zzcfg, com.google.android.gms.internal.ads.zzccb
    public final synchronized void zzt(String str, zzcdn zzcdnVar) {
        if (this.zzW == null) {
            this.zzW = new HashMap();
        }
        this.zzW.put(str, zzcdnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzv(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("success", true != z ? "0" : "1");
        hashMap.put("duration", Long.toString(j));
        zzd("onCacheAccessComplete", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final synchronized void zzw() {
        zzbgb zzbgbVar = this.zzF;
        if (zzbgbVar != null) {
            final zzdmz zzdmzVar = (zzdmz) zzbgbVar;
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdmx
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        zzdmz.this.zzd();
                    } catch (RemoteException e) {
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzx(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzy(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzccb
    public final void zzz(boolean z) {
        this.zzo.zzF(false);
    }
}
