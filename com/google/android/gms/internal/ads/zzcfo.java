package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.common.net.HttpHeaders;
import com.ironsource.C3040d4;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes5.dex */
public class zzcfo extends WebViewClient implements zzcgy {
    public static final /* synthetic */ int zzb = 0;
    private zzdsj zzA;
    private boolean zzB;
    private boolean zzC;
    private int zzD;
    private boolean zzE;
    private final zzecl zzG;
    private View.OnAttachStateChangeListener zzH;
    protected zzbya zza;
    private final zzcfg zzc;
    private final zzbcc zzd;
    private com.google.android.gms.ads.internal.client.zza zzg;
    private com.google.android.gms.ads.internal.overlay.zzr zzh;
    private zzcgw zzi;
    private zzcgx zzj;
    private zzbiv zzk;
    private zzbix zzl;
    private zzded zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private com.google.android.gms.ads.internal.overlay.zzad zzw;
    private zzbst zzx;
    private com.google.android.gms.ads.internal.zzb zzy;
    private final HashMap zze = new HashMap();
    private final Object zzf = new Object();
    private int zzp = 0;
    private String zzq = "";
    private String zzr = "";
    private zzbso zzz = null;
    private final HashSet zzF = new HashSet(Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfW)).split(",")));

    public zzcfo(zzcfg zzcfgVar, zzbcc zzbccVar, boolean z, zzbst zzbstVar, zzbso zzbsoVar, zzecl zzeclVar) {
        this.zzd = zzbccVar;
        this.zzc = zzcfgVar;
        this.zzs = z;
        this.zzx = zzbstVar;
        this.zzG = zzeclVar;
    }

    private static WebResourceResponse zzY() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaY)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zzZ(String str, Map map) throws IOException {
        HttpURLConnection httpURLConnection;
        WebResourceResponse webResourceResponse;
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = 0;
            while (true) {
                i++;
                if (i > 20) {
                    TrafficStats.clearThreadStatsTag();
                    throw new IOException("Too many redirects (20)");
                }
                int i2 = zzfra.zzb;
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Map.Entry entry : map.entrySet()) {
                    openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (!(openConnection instanceof HttpURLConnection)) {
                    throw new IOException("Invalid protocol.");
                }
                httpURLConnection = (HttpURLConnection) openConnection;
                com.google.android.gms.ads.internal.util.zzs zzr = com.google.android.gms.ads.internal.zzv.zzr();
                try {
                    zzcfg zzcfgVar = this.zzc;
                    zzr.zzg(zzcfgVar.getContext(), zzcfgVar.zzm().afmaVersion, false, httpURLConnection, false, 60000);
                    webResourceResponse = null;
                    com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
                    zzlVar.zzc(httpURLConnection, null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzlVar.zze(httpURLConnection, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        break;
                    }
                    String headerField = httpURLConnection.getHeaderField("Location");
                    if (headerField == null) {
                        throw new IOException("Missing Location header in redirect");
                    }
                    if (headerField.startsWith("tel:")) {
                        break;
                    }
                    URL url2 = new URL(url, headerField);
                    String protocol = url2.getProtocol();
                    if (protocol == null) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Protocol is null");
                        webResourceResponse = zzY();
                        break;
                    }
                    if (!protocol.equals("http") && !protocol.equals("https")) {
                        int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Unsupported scheme: " + protocol);
                        webResourceResponse = zzY();
                        break;
                    }
                    String str2 = "Redirecting to " + headerField;
                    int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zze(str2);
                    httpURLConnection.disconnect();
                    url = url2;
                } catch (Throwable th) {
                    th = th;
                    TrafficStats.clearThreadStatsTag();
                    throw th;
                }
            }
            com.google.android.gms.ads.internal.zzv.zzr();
            com.google.android.gms.ads.internal.zzv.zzr();
            String contentType = httpURLConnection.getContentType();
            String str3 = "";
            String trim = TextUtils.isEmpty(contentType) ? "" : contentType.split(";")[0].trim();
            com.google.android.gms.ads.internal.zzv.zzr();
            String contentType2 = httpURLConnection.getContentType();
            if (!TextUtils.isEmpty(contentType2)) {
                String[] split = contentType2.split(";");
                if (split.length != 1) {
                    int i6 = 1;
                    while (true) {
                        if (i6 >= split.length) {
                            break;
                        }
                        if (split[i6].trim().startsWith("charset")) {
                            String[] split2 = split[i6].trim().split(C3040d4.i.b);
                            if (split2.length > 1) {
                                str3 = split2[1].trim();
                                break;
                            }
                        }
                        i6++;
                    }
                }
            }
            String str4 = str3;
            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
            HashMap hashMap = new HashMap(headerFields.size());
            for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                if (entry2.getKey() != null && entry2.getValue() != null && !entry2.getValue().isEmpty()) {
                    hashMap.put(entry2.getKey(), entry2.getValue().get(0));
                }
            }
            webResourceResponse = com.google.android.gms.ads.internal.zzv.zzs().zzb(trim, str4, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
            TrafficStats.clearThreadStatsTag();
            return webResourceResponse;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaa(Map map, List list, String str) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Received GMSG: ".concat(str));
            for (String str2 : map.keySet()) {
                com.google.android.gms.ads.internal.util.zze.zza("  " + str2 + ": " + ((String) map.get(str2)));
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzbkf) it.next()).zza(this.zzc, map);
        }
    }

    private final void zzab() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzH;
        if (onAttachStateChangeListener == null) {
            return;
        }
        ((View) this.zzc).removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzac(final View view, final zzbya zzbyaVar, final int i) {
        if (!zzbyaVar.zzi() || i <= 0) {
            return;
        }
        zzbyaVar.zzg(view);
        if (zzbyaVar.zzi()) {
            com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfh
                @Override // java.lang.Runnable
                public final void run() {
                    zzcfo.this.zzac(view, zzbyaVar, i - 1);
                }
            }, 100L);
        }
    }

    private static final boolean zzad(zzcfg zzcfgVar) {
        return zzcfgVar.zzD() != null && zzcfgVar.zzD().zzb();
    }

    private static final boolean zzae(boolean z, zzcfg zzcfgVar) {
        return (!z || zzcfgVar.zzO().zzi() || zzcfgVar.zzU().equals("interstitial_mb")) ? false : true;
    }

    public static /* synthetic */ void zzh(zzcfo zzcfoVar) {
        zzcfg zzcfgVar = zzcfoVar.zzc;
        zzcfgVar.zzad();
        com.google.android.gms.ads.internal.overlay.zzm zzL = zzcfgVar.zzL();
        if (zzL != null) {
            zzL.zzz();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
        if (zzaVar != null) {
            zzaVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.zze.zza("Loading resource: ".concat(String.valueOf(str)));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzn(parse);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.zzf) {
            zzcfg zzcfgVar = this.zzc;
            if (zzcfgVar.zzaE()) {
                com.google.android.gms.ads.internal.util.zze.zza("Blank page loaded, 1...");
                zzcfgVar.zzX();
                return;
            }
            this.zzB = true;
            zzcgx zzcgxVar = this.zzj;
            if (zzcgxVar != null) {
                zzcgxVar.zza();
                this.zzj = null;
            }
            zzk();
            zzcfg zzcfgVar2 = this.zzc;
            if (zzcfgVar2.zzL() != null) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmq)).booleanValue()) {
                    zzcfgVar2.zzL().zzG(str);
                }
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.zzo = true;
        this.zzp = i;
        this.zzq = str;
        this.zzr = str2;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzc.zzaD(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzc(str, Collections.emptyMap());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.zze.zza("AdWebView shouldOverrideUrlLoading: ".concat(String.valueOf(str)));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzn(parse);
        } else {
            if (this.zzn && webView == this.zzc.zzG()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
                    if (zzaVar != null) {
                        zzaVar.onAdClicked();
                        zzbya zzbyaVar = this.zza;
                        if (zzbyaVar != null) {
                            zzbyaVar.zzh(str);
                        }
                        this.zzg = null;
                    }
                    zzded zzdedVar = this.zzm;
                    if (zzdedVar != null) {
                        zzdedVar.zzdf();
                        this.zzm = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            zzcfg zzcfgVar = this.zzc;
            if (zzcfgVar.zzG().willNotDraw()) {
                com.google.android.gms.ads.internal.util.client.zzo.zzj("AdWebView unable to handle URL: ".concat(String.valueOf(str)));
            } else {
                try {
                    zzavu zzI = zzcfgVar.zzI();
                    zzfda zzS = zzcfgVar.zzS();
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmu)).booleanValue() || zzS == null) {
                        if (zzI != null && zzI.zzf(parse)) {
                            parse = zzI.zza(parse, zzcfgVar.getContext(), (View) zzcfgVar, zzcfgVar.zzi());
                        }
                    } else if (zzI != null && zzI.zzf(parse)) {
                        parse = zzS.zza(parse, zzcfgVar.getContext(), (View) zzcfgVar, zzcfgVar.zzi());
                    }
                } catch (zzavv unused) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Unable to append parameter to URL: ".concat(String.valueOf(str)));
                }
                com.google.android.gms.ads.internal.zzb zzbVar = this.zzy;
                if (zzbVar == null || zzbVar.zzc()) {
                    com.google.android.gms.ads.internal.overlay.zzc zzcVar = new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", parse.toString(), null, null, null, null, null, null);
                    zzcfg zzcfgVar2 = this.zzc;
                    zzv(zzcVar, true, false, zzcfgVar2 != null ? zzcfgVar2.zzr() : "");
                } else {
                    zzbVar.zzb(str);
                }
            }
        }
        return true;
    }

    public final void zzA(boolean z, int i, String str, boolean z2, boolean z3) {
        zzcfg zzcfgVar = this.zzc;
        boolean zzaF = zzcfgVar.zzaF();
        boolean zzae = zzae(zzaF, zzcfgVar);
        boolean z4 = true;
        if (!zzae && z2) {
            z4 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zzae ? null : this.zzg;
        zzcfn zzcfnVar = zzaF ? null : new zzcfn(zzcfgVar, this.zzh);
        zzbiv zzbivVar = this.zzk;
        zzecl zzeclVar = null;
        zzbix zzbixVar = this.zzl;
        boolean z5 = z4;
        zzcfn zzcfnVar2 = zzcfnVar;
        com.google.android.gms.ads.internal.overlay.zzad zzadVar = this.zzw;
        VersionInfoParcel zzm = zzcfgVar.zzm();
        zzded zzdedVar = z5 ? null : this.zzm;
        if (zzad(zzcfgVar)) {
            zzeclVar = this.zzG;
        }
        zzy(new AdOverlayInfoParcel(zzaVar, zzcfnVar2, zzbivVar, zzbixVar, zzadVar, zzcfgVar, z, i, str, zzm, zzdedVar, zzeclVar, z3));
    }

    public final void zzB(String str, zzbkf zzbkfVar) {
        synchronized (this.zzf) {
            HashMap hashMap = this.zze;
            List list = (List) hashMap.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                hashMap.put(str, list);
            }
            list.add(zzbkfVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzC(zzcgw zzcgwVar) {
        this.zzi = zzcgwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzD(com.google.android.gms.ads.internal.zzb zzbVar) {
        this.zzy = zzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzE(int i, int i2) {
        zzbso zzbsoVar = this.zzz;
        if (zzbsoVar != null) {
            zzbsoVar.zze(i, i2);
        }
    }

    public final void zzF(boolean z) {
        this.zzn = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzG(boolean z) {
        synchronized (this.zzf) {
            this.zzu = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzH(boolean z) {
        synchronized (this.zzf) {
            this.zzv = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzI() {
        synchronized (this.zzf) {
            this.zzn = false;
            this.zzs = true;
            zzcaf.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfi
                @Override // java.lang.Runnable
                public final void run() {
                    zzcfo.zzh(zzcfo.this);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzJ(boolean z) {
        synchronized (this.zzf) {
            this.zzt = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzK(zzcgx zzcgxVar) {
        this.zzj = zzcgxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzL(zzbya zzbyaVar) {
        this.zza = zzbyaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzM(zzcmq zzcmqVar, zzeca zzecaVar, zzfjy zzfjyVar) {
        zzQ("/click");
        if (zzecaVar != null && zzfjyVar != null) {
            zzB("/click", new zzfde(this.zzm, zzcmqVar, zzfjyVar, zzecaVar));
            return;
        }
        zzded zzdedVar = this.zzm;
        zzbkf zzbkfVar = zzbke.zza;
        zzB("/click", new zzbjd(zzdedVar, zzcmqVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzN(zzcmq zzcmqVar) {
        zzQ("/click");
        zzded zzdedVar = this.zzm;
        zzbkf zzbkfVar = zzbke.zza;
        zzB("/click", new zzbjd(zzdedVar, zzcmqVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzO(zzcmq zzcmqVar, zzeca zzecaVar, zzdsj zzdsjVar) {
        zzQ("/open");
        zzB("/open", new zzbkr(this.zzy, this.zzz, zzecaVar, zzdsjVar, zzcmqVar));
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzP(zzfca zzfcaVar) {
        zzcfg zzcfgVar = this.zzc;
        if (com.google.android.gms.ads.internal.zzv.zzo().zzp(zzcfgVar.getContext())) {
            zzQ("/logScionEvent");
            new HashMap();
            zzB("/logScionEvent", new zzbkl(zzcfgVar.getContext(), zzfcaVar.zzaw));
        }
    }

    public final void zzQ(String str) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            list.clear();
        }
    }

    public final void zzR(String str, zzbkf zzbkfVar) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzbkfVar);
        }
    }

    public final void zzS(String str, Predicate predicate) {
        synchronized (this.zzf) {
            List<zzbkf> list = (List) this.zze.get(str);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (zzbkf zzbkfVar : list) {
                if (predicate.apply(zzbkfVar)) {
                    arrayList.add(zzbkfVar);
                }
            }
            list.removeAll(arrayList);
        }
    }

    public final boolean zzT() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzu;
        }
        return z;
    }

    public final boolean zzU() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzv;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final boolean zzV() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzs;
        }
        return z;
    }

    public final boolean zzW() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzt;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzX(com.google.android.gms.ads.internal.client.zza zzaVar, zzbiv zzbivVar, com.google.android.gms.ads.internal.overlay.zzr zzrVar, zzbix zzbixVar, com.google.android.gms.ads.internal.overlay.zzad zzadVar, boolean z, zzbki zzbkiVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbsv zzbsvVar, zzbya zzbyaVar, final zzeca zzecaVar, final zzfjy zzfjyVar, zzdsj zzdsjVar, zzbkz zzbkzVar, zzded zzdedVar, zzbky zzbkyVar, zzbks zzbksVar, zzbkg zzbkgVar, zzcmq zzcmqVar) {
        com.google.android.gms.ads.internal.zzb zzbVar2 = zzbVar == null ? new com.google.android.gms.ads.internal.zzb(this.zzc.getContext(), zzbyaVar, null) : zzbVar;
        zzcfg zzcfgVar = this.zzc;
        this.zzz = new zzbso(zzcfgVar, zzbsvVar);
        this.zza = zzbyaVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbf)).booleanValue()) {
            zzB("/adMetadata", new zzbiu(zzbivVar));
        }
        if (zzbixVar != null) {
            zzB("/appEvent", new zzbiw(zzbixVar));
        }
        zzB("/backButton", zzbke.zzj);
        zzB("/refresh", zzbke.zzk);
        zzB("/canOpenApp", zzbke.zzb);
        zzB("/canOpenURLs", zzbke.zza);
        zzB("/canOpenIntents", zzbke.zzc);
        zzB("/close", zzbke.zzd);
        zzB("/customClose", zzbke.zze);
        zzB("/instrument", zzbke.zzn);
        zzB("/delayPageLoaded", zzbke.zzp);
        zzB("/delayPageClosed", zzbke.zzq);
        zzB("/getLocationInfo", zzbke.zzr);
        zzB("/log", zzbke.zzg);
        zzB("/mraid", new zzbkm(zzbVar2, this.zzz, zzbsvVar));
        zzbst zzbstVar = this.zzx;
        if (zzbstVar != null) {
            zzB("/mraidLoaded", zzbstVar);
        }
        com.google.android.gms.ads.internal.zzb zzbVar3 = zzbVar2;
        zzB("/open", new zzbkr(zzbVar3, this.zzz, zzecaVar, zzdsjVar, zzcmqVar));
        zzB("/precache", new zzcdo());
        zzB("/touch", zzbke.zzi);
        zzB("/video", zzbke.zzl);
        zzB("/videoMeta", zzbke.zzm);
        if (zzecaVar == null || zzfjyVar == null) {
            zzB("/click", new zzbjd(zzdedVar, zzcmqVar));
            zzB("/httpTrack", zzbke.zzf);
        } else {
            zzB("/click", new zzfde(zzdedVar, zzcmqVar, zzfjyVar, zzecaVar));
            zzB("/httpTrack", new zzbkf() { // from class: com.google.android.gms.internal.ads.zzfdf
                @Override // com.google.android.gms.internal.ads.zzbkf
                public final void zza(Object obj, Map map) {
                    zzcex zzcexVar = (zzcex) obj;
                    String str = (String) map.get("u");
                    if (str == null) {
                        int i = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("URL missing from httpTrack GMSG.");
                        return;
                    }
                    zzfca zzD = zzcexVar.zzD();
                    if (zzD != null && !zzD.zzai) {
                        zzfjy.this.zzd(str, zzD.zzax, null, null);
                        return;
                    }
                    zzfcd zzR = ((zzcgj) zzcexVar).zzR();
                    if (zzR != null) {
                        zzecaVar.zzd(new zzecc(com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis(), zzR.zzb, str, 2));
                    } else {
                        com.google.android.gms.ads.internal.zzv.zzp().zzw(new IllegalArgumentException("Common configuration cannot be null"), "BufferingGmsgHandlers.getBufferingHttpTrackGmsgHandler");
                    }
                }
            });
        }
        if (com.google.android.gms.ads.internal.zzv.zzo().zzp(zzcfgVar.getContext())) {
            Map hashMap = new HashMap();
            if (zzcfgVar.zzD() != null) {
                hashMap = zzcfgVar.zzD().zzaw;
            }
            zzB("/logScionEvent", new zzbkl(zzcfgVar.getContext(), hashMap));
        }
        if (zzbkiVar != null) {
            zzB("/setInterstitialProperties", new zzbkh(zzbkiVar));
        }
        if (zzbkzVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjp)).booleanValue()) {
                zzB("/inspectorNetworkExtras", zzbkzVar);
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjI)).booleanValue() && zzbkyVar != null) {
            zzB("/shareSheet", zzbkyVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjN)).booleanValue() && zzbksVar != null) {
            zzB("/inspectorOutOfContextTest", zzbksVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjS)).booleanValue() && zzbkgVar != null) {
            zzB("/inspectorStorage", zzbkgVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlV)).booleanValue()) {
            zzB("/bindPlayStoreOverlay", zzbke.zzu);
            zzB("/presentPlayStoreOverlay", zzbke.zzv);
            zzB("/expandPlayStoreOverlay", zzbke.zzw);
            zzB("/collapsePlayStoreOverlay", zzbke.zzx);
            zzB("/closePlayStoreOverlay", zzbke.zzy);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdB)).booleanValue()) {
            zzB("/setPAIDPersonalizationEnabled", zzbke.zzA);
            zzB("/resetPAID", zzbke.zzz);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmp)).booleanValue() && zzcfgVar.zzD() != null && zzcfgVar.zzD().zzar) {
            zzB("/writeToLocalStorage", zzbke.zzB);
            zzB("/clearLocalStorageKeys", zzbke.zzC);
        }
        this.zzg = zzaVar;
        this.zzh = zzrVar;
        this.zzk = zzbivVar;
        this.zzl = zzbixVar;
        this.zzw = zzadVar;
        this.zzy = zzbVar3;
        this.zzm = zzdedVar;
        this.zzA = zzdsjVar;
        this.zzn = z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zza() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzb() {
        synchronized (this.zzf) {
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b2 A[Catch: NoClassDefFoundError -> 0x02b1, Exception | NoClassDefFoundError -> 0x02b3, TRY_ENTER, TryCatch #11 {Exception | NoClassDefFoundError -> 0x02b3, blocks: (B:3:0x000c, B:5:0x0019, B:6:0x001f, B:8:0x002f, B:11:0x0036, B:13:0x0044, B:15:0x0060, B:17:0x0079, B:19:0x0090, B:20:0x0093, B:21:0x0096, B:24:0x00b2, B:26:0x00c6, B:28:0x00df, B:45:0x01a3, B:46:0x0162, B:49:0x0287, B:51:0x0297, B:53:0x029d, B:55:0x02ab, B:70:0x0211, B:71:0x0237, B:64:0x01ec, B:66:0x013e, B:86:0x00d3, B:87:0x0238, B:89:0x0242, B:91:0x0248, B:93:0x027b), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0287 A[Catch: NoClassDefFoundError -> 0x02b1, Exception | NoClassDefFoundError -> 0x02b3, TryCatch #11 {Exception | NoClassDefFoundError -> 0x02b3, blocks: (B:3:0x000c, B:5:0x0019, B:6:0x001f, B:8:0x002f, B:11:0x0036, B:13:0x0044, B:15:0x0060, B:17:0x0079, B:19:0x0090, B:20:0x0093, B:21:0x0096, B:24:0x00b2, B:26:0x00c6, B:28:0x00df, B:45:0x01a3, B:46:0x0162, B:49:0x0287, B:51:0x0297, B:53:0x029d, B:55:0x02ab, B:70:0x0211, B:71:0x0237, B:64:0x01ec, B:66:0x013e, B:86:0x00d3, B:87:0x0238, B:89:0x0242, B:91:0x0248, B:93:0x027b), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x029d A[Catch: NoClassDefFoundError -> 0x02b1, Exception | NoClassDefFoundError -> 0x02b3, TryCatch #11 {Exception | NoClassDefFoundError -> 0x02b3, blocks: (B:3:0x000c, B:5:0x0019, B:6:0x001f, B:8:0x002f, B:11:0x0036, B:13:0x0044, B:15:0x0060, B:17:0x0079, B:19:0x0090, B:20:0x0093, B:21:0x0096, B:24:0x00b2, B:26:0x00c6, B:28:0x00df, B:45:0x01a3, B:46:0x0162, B:49:0x0287, B:51:0x0297, B:53:0x029d, B:55:0x02ab, B:70:0x0211, B:71:0x0237, B:64:0x01ec, B:66:0x013e, B:86:0x00d3, B:87:0x0238, B:89:0x0242, B:91:0x0248, B:93:0x027b), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01e1 A[Catch: all -> 0x01c7, TryCatch #2 {all -> 0x01c7, blocks: (B:41:0x017f, B:43:0x0191, B:44:0x0198, B:60:0x01cf, B:62:0x01e1, B:63:0x01e8), top: B:27:0x00df }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0238 A[Catch: NoClassDefFoundError -> 0x02b1, Exception | NoClassDefFoundError -> 0x02b3, TryCatch #11 {Exception | NoClassDefFoundError -> 0x02b3, blocks: (B:3:0x000c, B:5:0x0019, B:6:0x001f, B:8:0x002f, B:11:0x0036, B:13:0x0044, B:15:0x0060, B:17:0x0079, B:19:0x0090, B:20:0x0093, B:21:0x0096, B:24:0x00b2, B:26:0x00c6, B:28:0x00df, B:45:0x01a3, B:46:0x0162, B:49:0x0287, B:51:0x0297, B:53:0x029d, B:55:0x02ab, B:70:0x0211, B:71:0x0237, B:64:0x01ec, B:66:0x013e, B:86:0x00d3, B:87:0x0238, B:89:0x0242, B:91:0x0248, B:93:0x027b), top: B:2:0x000c }] */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final WebResourceResponse zzc(String str, Map map) {
        WebResourceResponse webResourceResponse;
        int i;
        InputStream inputStream;
        InputStream zzc;
        final boolean z;
        final boolean z2;
        String str2;
        try {
            Map hashMap = new HashMap();
            zzcfg zzcfgVar = this.zzc;
            if (zzcfgVar.zzD() != null) {
                hashMap = zzcfgVar.zzD().zzaw;
            }
            String zzc2 = zzbyq.zzc(str, zzcfgVar.getContext(), this.zzE, hashMap);
            if (!zzc2.equals(str)) {
                return zzZ(zzc2, map);
            }
            Parcelable.Creator<zzbbo> creator = zzbbo.CREATOR;
            zzbbo zza = zzbbo.zza(Uri.parse(str));
            if (zza != null) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
                Uri parse = Uri.parse(str);
                if (parse.getQueryParameterNames().contains("range")) {
                    List zzf = zzfwe.zzb(zzfva.zzc('-')).zzf(parse.getQueryParameter("range"));
                    if (zzf.size() == 2) {
                        int parseInt = Integer.parseInt((String) zzf.get(0));
                        int parseInt2 = Integer.parseInt((String) zzf.get(1)) + 1;
                        if (parseInt > 0) {
                            zza.zzh = parseInt;
                        }
                        i = parseInt2 - parseInt;
                        final boolean z3 = "X-Afma-Gcache-CachedBytes";
                        webResourceResponse = null;
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeD)).booleanValue()) {
                            zzbbl zzb2 = com.google.android.gms.ads.internal.zzv.zzc().zzb(zza);
                            if (zzb2 == null || !zzb2.zze()) {
                                inputStream = null;
                                if (inputStream != null) {
                                    return new WebResourceResponse("", "", 200, "OK", hashMap2, inputStream);
                                }
                            } else {
                                hashMap2.put("X-Afma-Gcache-HasAdditionalMetadataFromReadV2", Boolean.toString(zzb2.zzd()));
                                hashMap2.put("X-Afma-Gcache-IsGcacheHit", Boolean.toString(zzb2.zzg()));
                                hashMap2.put("X-Afma-Gcache-IsDownloaded", Boolean.toString(zzb2.zzf()));
                                hashMap2.put("X-Afma-Gcache-CachedBytes", Long.toString(zzb2.zza()));
                                zzc = zzb2.zzc();
                                if (i != -1) {
                                    zzc = zzgbg.zza(zzc, i);
                                }
                            }
                        } else {
                            zza.zzi = zzfwg.zzc(zzcfgVar.zzr());
                            zza.zzj = zzcfgVar.zzf();
                            try {
                                long longValue = (zza.zzg ? (Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeF) : (Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeE)).longValue();
                                long elapsedRealtime = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime();
                                com.google.android.gms.ads.internal.zzv.zzd();
                                Future zza2 = zzbbz.zza(zzcfgVar.getContext(), zza);
                                try {
                                    zzbca zzbcaVar = (zzbca) zza2.get(longValue, TimeUnit.MILLISECONDS);
                                    try {
                                        try {
                                            hashMap2.put("X-Afma-Gcache-HasAdditionalMetadataFromReadV2", Boolean.toString(zzbcaVar.zzd()));
                                            hashMap2.put("X-Afma-Gcache-IsGcacheHit", Boolean.toString(zzbcaVar.zzf()));
                                            hashMap2.put("X-Afma-Gcache-IsDownloaded", Boolean.toString(zzbcaVar.zze()));
                                            hashMap2.put("X-Afma-Gcache-CachedBytes", Long.toString(zzbcaVar.zza()));
                                            zzc = zzbcaVar.zzc();
                                            if (i != -1) {
                                                try {
                                                    zzc = zzgbg.zza(zzc, i);
                                                } catch (InterruptedException e) {
                                                    e = e;
                                                    z2 = true;
                                                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeI)).booleanValue()) {
                                                        com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AdWebViewClient.interceptRequest.gcache");
                                                    }
                                                    zza2.cancel(true);
                                                    Thread.currentThread().interrupt();
                                                    final long elapsedRealtime2 = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - elapsedRealtime;
                                                    com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            zzcfo.this.zzc.zzv(z2, elapsedRealtime2);
                                                        }
                                                    });
                                                    str2 = "Cache connection took " + elapsedRealtime2 + "ms";
                                                    com.google.android.gms.ads.internal.util.zze.zza(str2);
                                                    inputStream = zzc;
                                                    if (inputStream != null) {
                                                    }
                                                    if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
                                                    }
                                                } catch (ExecutionException e2) {
                                                    e = e2;
                                                    z = true;
                                                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeI)).booleanValue()) {
                                                        com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "AdWebViewClient.interceptRequest.gcache");
                                                    }
                                                    zza2.cancel(true);
                                                    final long elapsedRealtime3 = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - elapsedRealtime;
                                                    com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            zzcfo.this.zzc.zzv(z, elapsedRealtime3);
                                                        }
                                                    });
                                                    str2 = "Cache connection took " + elapsedRealtime3 + "ms";
                                                    com.google.android.gms.ads.internal.util.zze.zza(str2);
                                                    inputStream = zzc;
                                                    if (inputStream != null) {
                                                    }
                                                    if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
                                                    }
                                                } catch (TimeoutException e3) {
                                                    e = e3;
                                                    z = true;
                                                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeI)).booleanValue()) {
                                                    }
                                                    zza2.cancel(true);
                                                    final long elapsedRealtime32 = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - elapsedRealtime;
                                                    com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                                        @Override // java.lang.Runnable
                                                        public final void run() {
                                                            zzcfo.this.zzc.zzv(z, elapsedRealtime32);
                                                        }
                                                    });
                                                    str2 = "Cache connection took " + elapsedRealtime32 + "ms";
                                                    com.google.android.gms.ads.internal.util.zze.zza(str2);
                                                    inputStream = zzc;
                                                    if (inputStream != null) {
                                                    }
                                                    if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
                                                    }
                                                }
                                            }
                                            final long elapsedRealtime4 = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - elapsedRealtime;
                                            final boolean z4 = true;
                                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    zzcfo.this.zzc.zzv(z4, elapsedRealtime4);
                                                }
                                            });
                                            str2 = "Cache connection took " + elapsedRealtime4 + "ms";
                                        } catch (Throwable th) {
                                            th = th;
                                            z3 = 1;
                                            final long elapsedRealtime5 = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - elapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    zzcfo.this.zzc.zzv(z3, elapsedRealtime5);
                                                }
                                            });
                                            com.google.android.gms.ads.internal.util.zze.zza("Cache connection took " + elapsedRealtime5 + "ms");
                                            throw th;
                                        }
                                    } catch (InterruptedException e4) {
                                        e = e4;
                                        zzc = null;
                                    } catch (ExecutionException e5) {
                                        e = e5;
                                        zzc = null;
                                        z = true;
                                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeI)).booleanValue()) {
                                        }
                                        zza2.cancel(true);
                                        final long elapsedRealtime322 = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - elapsedRealtime;
                                        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                zzcfo.this.zzc.zzv(z, elapsedRealtime322);
                                            }
                                        });
                                        str2 = "Cache connection took " + elapsedRealtime322 + "ms";
                                        com.google.android.gms.ads.internal.util.zze.zza(str2);
                                        inputStream = zzc;
                                        if (inputStream != null) {
                                        }
                                        if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
                                        }
                                    } catch (TimeoutException e6) {
                                        e = e6;
                                        zzc = null;
                                        z = true;
                                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeI)).booleanValue()) {
                                        }
                                        zza2.cancel(true);
                                        final long elapsedRealtime3222 = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - elapsedRealtime;
                                        com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                            @Override // java.lang.Runnable
                                            public final void run() {
                                                zzcfo.this.zzc.zzv(z, elapsedRealtime3222);
                                            }
                                        });
                                        str2 = "Cache connection took " + elapsedRealtime3222 + "ms";
                                        com.google.android.gms.ads.internal.util.zze.zza(str2);
                                        inputStream = zzc;
                                        if (inputStream != null) {
                                        }
                                        if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
                                        }
                                    }
                                } catch (InterruptedException e7) {
                                    e = e7;
                                    zzc = null;
                                    z2 = false;
                                } catch (ExecutionException e8) {
                                    e = e8;
                                    zzc = null;
                                    z = false;
                                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeI)).booleanValue()) {
                                    }
                                    zza2.cancel(true);
                                    final long elapsedRealtime32222 = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - elapsedRealtime;
                                    com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            zzcfo.this.zzc.zzv(z, elapsedRealtime32222);
                                        }
                                    });
                                    str2 = "Cache connection took " + elapsedRealtime32222 + "ms";
                                    com.google.android.gms.ads.internal.util.zze.zza(str2);
                                    inputStream = zzc;
                                    if (inputStream != null) {
                                    }
                                    if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
                                    }
                                } catch (TimeoutException e9) {
                                    e = e9;
                                    zzc = null;
                                    z = false;
                                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeI)).booleanValue()) {
                                    }
                                    zza2.cancel(true);
                                    final long elapsedRealtime322222 = com.google.android.gms.ads.internal.zzv.zzD().elapsedRealtime() - elapsedRealtime;
                                    com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfk
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            zzcfo.this.zzc.zzv(z, elapsedRealtime322222);
                                        }
                                    });
                                    str2 = "Cache connection took " + elapsedRealtime322222 + "ms";
                                    com.google.android.gms.ads.internal.util.zze.zza(str2);
                                    inputStream = zzc;
                                    if (inputStream != null) {
                                    }
                                    if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    z3 = 0;
                                }
                                com.google.android.gms.ads.internal.util.zze.zza(str2);
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        inputStream = zzc;
                        if (inputStream != null) {
                        }
                    }
                }
                i = -1;
                final boolean z32 = "X-Afma-Gcache-CachedBytes";
                webResourceResponse = null;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeD)).booleanValue()) {
                }
                inputStream = zzc;
                if (inputStream != null) {
                }
            } else {
                webResourceResponse = null;
            }
            return (com.google.android.gms.ads.internal.util.client.zzl.zzk() || !((Boolean) zzbfa.zzb.zze()).booleanValue()) ? webResourceResponse : zzZ(str, map);
        } catch (Exception | NoClassDefFoundError e10) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e10, "AdWebViewClient.interceptRequest");
            return zzY();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final com.google.android.gms.ads.internal.zzb zzd() {
        return this.zzy;
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdH() {
        zzded zzdedVar = this.zzm;
        if (zzdedVar != null) {
            zzdedVar.zzdH();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzded
    public final void zzdf() {
        zzded zzdedVar = this.zzm;
        if (zzdedVar != null) {
            zzdedVar.zzdf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final zzdsj zze() {
        return this.zzA;
    }

    public final void zzk() {
        if (this.zzi != null && ((this.zzB && this.zzD <= 0) || this.zzC || this.zzo)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcc)).booleanValue()) {
                zzcfg zzcfgVar = this.zzc;
                if (zzcfgVar.zzl() != null) {
                    zzbdl.zza(zzcfgVar.zzl().zza(), zzcfgVar.zzk(), "awfllc");
                }
            }
            this.zzi.zza((this.zzC || this.zzo) ? false : true, this.zzp, this.zzq, this.zzr);
            this.zzi = null;
        }
        this.zzc.zzaf();
    }

    public final void zzl() {
        zzbya zzbyaVar = this.zza;
        if (zzbyaVar != null) {
            zzbyaVar.zzf();
            this.zza = null;
        }
        zzab();
        synchronized (this.zzf) {
            this.zze.clear();
            this.zzg = null;
            this.zzh = null;
            this.zzi = null;
            this.zzj = null;
            this.zzk = null;
            this.zzl = null;
            this.zzn = false;
            this.zzs = false;
            this.zzt = false;
            this.zzu = false;
            this.zzw = null;
            this.zzy = null;
            this.zzx = null;
            zzbso zzbsoVar = this.zzz;
            if (zzbsoVar != null) {
                zzbsoVar.zzb(true);
                this.zzz = null;
            }
        }
    }

    public final void zzm(boolean z) {
        this.zzE = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzn(Uri uri) {
        com.google.android.gms.ads.internal.util.zze.zza("Received GMSG: ".concat(String.valueOf(String.valueOf(uri))));
        HashMap hashMap = this.zze;
        String path = uri.getPath();
        List list = (List) hashMap.get(path);
        if (path == null || list == null) {
            com.google.android.gms.ads.internal.util.zze.zza("No GMSG handler found for GMSG: ".concat(String.valueOf(String.valueOf(uri))));
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgV)).booleanValue() || com.google.android.gms.ads.internal.zzv.zzp().zzg() == null) {
                return;
            }
            final String substring = (path == null || path.length() < 2) ? "null" : path.substring(1);
            zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcfj
                @Override // java.lang.Runnable
                public final void run() {
                    int i = zzcfo.zzb;
                    com.google.android.gms.ads.internal.zzv.zzp().zzg().zze(substring);
                }
            });
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfV)).booleanValue() && this.zzF.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzfX)).intValue()) {
                com.google.android.gms.ads.internal.util.zze.zza("Parsing gmsg query params on BG thread: ".concat(path));
                zzgdn.zzr(com.google.android.gms.ads.internal.zzv.zzr().zzb(uri), new zzcfm(this, list, path, uri), zzcaf.zzf);
                return;
            }
        }
        com.google.android.gms.ads.internal.zzv.zzr();
        zzaa(com.google.android.gms.ads.internal.util.zzs.zzQ(uri), list, path);
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzo() {
        zzbcc zzbccVar = this.zzd;
        if (zzbccVar != null) {
            zzbccVar.zzc(10005);
        }
        this.zzC = true;
        this.zzp = GamesActivityResultCodes.RESULT_APP_MISCONFIGURED;
        this.zzq = "Page loaded delay cancel.";
        zzk();
        this.zzc.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzp() {
        synchronized (this.zzf) {
        }
        this.zzD++;
        zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzq() {
        this.zzD--;
        zzk();
    }

    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzr(int i, int i2, boolean z) {
        zzbst zzbstVar = this.zzx;
        if (zzbstVar != null) {
            zzbstVar.zzb(i, i2);
        }
        zzbso zzbsoVar = this.zzz;
        if (zzbsoVar != null) {
            zzbsoVar.zzd(i, i2, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzcgy
    public final void zzs() {
        zzbya zzbyaVar = this.zza;
        if (zzbyaVar != null) {
            zzcfg zzcfgVar = this.zzc;
            WebView zzG = zzcfgVar.zzG();
            if (ViewCompat.isAttachedToWindow(zzG)) {
                zzac(zzG, zzbyaVar, 10);
                return;
            }
            zzab();
            zzcfl zzcflVar = new zzcfl(this, zzbyaVar);
            this.zzH = zzcflVar;
            ((View) zzcfgVar).addOnAttachStateChangeListener(zzcflVar);
        }
    }

    public final void zzv(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z, boolean z2, String str) {
        boolean z3;
        zzcfg zzcfgVar = this.zzc;
        boolean zzaF = zzcfgVar.zzaF();
        boolean z4 = false;
        boolean z5 = zzae(zzaF, zzcfgVar) || z2;
        if (z5 || !z) {
            z3 = zzaF;
            z4 = true;
        } else {
            z3 = zzaF;
        }
        zzy(new AdOverlayInfoParcel(zzcVar, z5 ? null : this.zzg, z3 ? null : this.zzh, this.zzw, zzcfgVar.zzm(), zzcfgVar, z4 ? null : this.zzm, str));
    }

    public final void zzw(String str, String str2, int i) {
        zzecl zzeclVar = this.zzG;
        zzcfg zzcfgVar = this.zzc;
        zzy(new AdOverlayInfoParcel(zzcfgVar, zzcfgVar.zzm(), str, str2, 14, zzeclVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.google.android.gms.internal.ads.zzbtj] */
    /* JADX WARN: Type inference failed for: r9v2 */
    public final void zzx(boolean z, int i, boolean z2) {
        com.google.android.gms.ads.internal.client.zza zzaVar;
        zzded zzdedVar;
        ?? r9;
        int i2;
        com.google.android.gms.ads.internal.client.zza zzaVar2;
        boolean z3;
        zzcfg zzcfgVar = this.zzc;
        boolean zzae = zzae(zzcfgVar.zzaF(), zzcfgVar);
        boolean z4 = true;
        if (!zzae && z2) {
            z4 = false;
        }
        if (zzae) {
            zzaVar = null;
            zzdedVar = null;
        } else {
            zzaVar = this.zzg;
            zzdedVar = null;
        }
        com.google.android.gms.ads.internal.overlay.zzr zzrVar = this.zzh;
        zzded zzdedVar2 = zzdedVar;
        com.google.android.gms.ads.internal.overlay.zzad zzadVar = this.zzw;
        VersionInfoParcel zzm = zzcfgVar.zzm();
        zzded zzdedVar3 = z4 ? zzdedVar2 : this.zzm;
        if (zzad(zzcfgVar)) {
            r9 = this.zzG;
            z3 = z;
            i2 = i;
            zzaVar2 = zzaVar;
        } else {
            r9 = zzdedVar2;
            i2 = i;
            zzaVar2 = zzaVar;
            z3 = z;
        }
        zzy(new AdOverlayInfoParcel(zzaVar2, zzrVar, zzadVar, zzcfgVar, z3, i2, zzm, zzdedVar3, r9));
    }

    public final void zzy(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.overlay.zzc zzcVar;
        zzbso zzbsoVar = this.zzz;
        boolean zzf = zzbsoVar != null ? zzbsoVar.zzf() : false;
        com.google.android.gms.ads.internal.zzv.zzj();
        com.google.android.gms.ads.internal.overlay.zzn.zza(this.zzc.getContext(), adOverlayInfoParcel, !zzf, this.zzA);
        zzbya zzbyaVar = this.zza;
        if (zzbyaVar != null) {
            String str = adOverlayInfoParcel.zzl;
            if (str == null && (zzcVar = adOverlayInfoParcel.zza) != null) {
                str = zzcVar.zzb;
            }
            zzbyaVar.zzh(str);
        }
    }

    public final void zzz(boolean z, int i, String str, String str2, boolean z2) {
        zzcfg zzcfgVar = this.zzc;
        boolean zzaF = zzcfgVar.zzaF();
        boolean zzae = zzae(zzaF, zzcfgVar);
        boolean z3 = true;
        if (!zzae && z2) {
            z3 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zzae ? null : this.zzg;
        zzcfn zzcfnVar = zzaF ? null : new zzcfn(zzcfgVar, this.zzh);
        zzbiv zzbivVar = this.zzk;
        zzecl zzeclVar = null;
        zzbix zzbixVar = this.zzl;
        boolean z4 = z3;
        zzcfn zzcfnVar2 = zzcfnVar;
        com.google.android.gms.ads.internal.overlay.zzad zzadVar = this.zzw;
        VersionInfoParcel zzm = zzcfgVar.zzm();
        zzded zzdedVar = z4 ? null : this.zzm;
        if (zzad(zzcfgVar)) {
            zzeclVar = this.zzG;
        }
        zzy(new AdOverlayInfoParcel(zzaVar, zzcfnVar2, zzbivVar, zzbixVar, zzadVar, zzcfgVar, z, i, str, str2, zzm, zzdedVar, zzeclVar));
    }
}
