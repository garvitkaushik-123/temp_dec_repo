package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzavu;
import com.google.android.gms.internal.ads.zzavv;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbej;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzbuf;
import com.google.android.gms.internal.ads.zzbui;
import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.internal.ads.zzbyz;
import com.google.android.gms.internal.ads.zzbze;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzche;
import com.google.android.gms.internal.ads.zzcvf;
import com.google.android.gms.internal.ads.zzdbu;
import com.google.android.gms.internal.ads.zzdny;
import com.google.android.gms.internal.ads.zzdrr;
import com.google.android.gms.internal.ads.zzdso;
import com.google.android.gms.internal.ads.zzfcu;
import com.google.android.gms.internal.ads.zzfda;
import com.google.android.gms.internal.ads.zzfdv;
import com.google.android.gms.internal.ads.zzfhi;
import com.google.android.gms.internal.ads.zzfhj;
import com.google.android.gms.internal.ads.zzfhu;
import com.google.android.gms.internal.ads.zzfhx;
import com.google.android.gms.internal.ads.zzfjy;
import com.google.android.gms.internal.ads.zzfve;
import com.google.android.gms.internal.ads.zzfwg;
import com.google.android.gms.internal.ads.zzgct;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.android.gms.internal.ads.zzgde;
import com.google.android.gms.internal.ads.zzgdn;
import com.google.android.gms.internal.ads.zzgdy;
import com.google.common.util.concurrent.ListenableFuture;
import com.ironsource.C3040d4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes4.dex */
public final class zzau extends zzbyz {
    protected static final List zza = new ArrayList(Arrays.asList("/aclk", "/pcs/click", "/dbm/clk"));
    protected static final List zzb = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com"));
    protected static final List zzc = new ArrayList(Arrays.asList("/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"));
    protected static final List zzd = new ArrayList(Arrays.asList(".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"));
    public static final /* synthetic */ int zze = 0;
    private final List zzB;
    private final List zzC;
    private final List zzD;
    private final List zzE;
    private final zzbej zzI;
    private final zzo zzJ;
    private final zzf zzK;
    private final zzche zzf;
    private Context zzg;
    private final zzavu zzh;
    private final zzfda zzi;
    private final zzfdv zzj;
    private final zzgdy zzk;
    private final ScheduledExecutorService zzl;
    private zzbui zzm;
    private final zzdso zzp;
    private final zzfjy zzq;
    private final VersionInfoParcel zzy;
    private String zzz;
    private Point zzn = new Point();
    private Point zzo = new Point();
    private final AtomicInteger zzx = new AtomicInteger(0);
    private final AtomicBoolean zzF = new AtomicBoolean(false);
    private final AtomicBoolean zzG = new AtomicBoolean(false);
    private final AtomicInteger zzH = new AtomicInteger(0);
    private final boolean zzr = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhx)).booleanValue();
    private final boolean zzs = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhw)).booleanValue();
    private final boolean zzt = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhz)).booleanValue();
    private final boolean zzu = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhB)).booleanValue();
    private final String zzv = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhA);
    private final String zzw = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhC);
    private final String zzA = (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhD);

    zzau(zzche zzcheVar, Context context, zzavu zzavuVar, zzfdv zzfdvVar, zzgdy zzgdyVar, ScheduledExecutorService scheduledExecutorService, zzdso zzdsoVar, zzfjy zzfjyVar, VersionInfoParcel versionInfoParcel, zzbej zzbejVar, zzfda zzfdaVar, zzo zzoVar, zzf zzfVar) {
        List list;
        this.zzf = zzcheVar;
        this.zzg = context;
        this.zzh = zzavuVar;
        this.zzi = zzfdaVar;
        this.zzj = zzfdvVar;
        this.zzk = zzgdyVar;
        this.zzl = scheduledExecutorService;
        this.zzp = zzdsoVar;
        this.zzq = zzfjyVar;
        this.zzy = versionInfoParcel;
        this.zzI = zzbejVar;
        this.zzJ = zzoVar;
        this.zzK = zzfVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhE)).booleanValue()) {
            this.zzB = zzZ((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhF));
            this.zzC = zzZ((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhG));
            this.zzD = zzZ((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhH));
            list = zzZ((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhI));
        } else {
            this.zzB = zza;
            this.zzC = zzb;
            this.zzD = zzc;
            list = zzd;
        }
        this.zzE = list;
    }

    public static /* synthetic */ ArrayList zzC(zzau zzauVar, List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzauVar.zzQ(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zzaa(uri, "nas", str));
            }
        }
        return arrayList;
    }

    public static /* synthetic */ ArrayList zzD(zzau zzauVar, List list, IObjectWrapper iObjectWrapper) {
        zzavu zzavuVar = zzauVar.zzh;
        String zzh = zzavuVar.zzc() != null ? zzavuVar.zzc().zzh(zzauVar.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null) : "";
        if (TextUtils.isEmpty(zzh)) {
            throw new Exception("Failed to get view signals.");
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (zzauVar.zzQ(uri)) {
                arrayList.add(zzaa(uri, "ms", zzh));
            } else {
                String valueOf = String.valueOf(String.valueOf(uri));
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Not a Google URL: ".concat(valueOf));
                arrayList.add(uri);
            }
        }
        if (arrayList.isEmpty()) {
            throw new Exception("Empty impression URLs result.");
        }
        return arrayList;
    }

    public static /* synthetic */ void zzH(zzau zzauVar, zzdny[] zzdnyVarArr) {
        zzdny zzdnyVar = zzdnyVarArr[0];
        if (zzdnyVar != null) {
            zzauVar.zzj.zzb(zzgdn.zzh(zzdnyVar));
        }
    }

    static /* bridge */ /* synthetic */ void zzJ(zzau zzauVar, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (zzauVar.zzP((Uri) it.next())) {
                zzauVar.zzx.getAndIncrement();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final zzac zzR(Context context, String str, String str2, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, int i, String str3, Bundle bundle, zzbze zzbzeVar) {
        com.google.android.gms.ads.internal.client.zzr zzrVar2;
        char c;
        zzfcu zzfcuVar = new zzfcu();
        if ("REWARDED".equals(str2)) {
            zzfcuVar.zzq().zza(2);
        } else if ("REWARDED_INTERSTITIAL".equals(str2)) {
            zzfcuVar.zzq().zza(3);
        }
        zzab zzo = this.zzf.zzo();
        zzcvf zzcvfVar = new zzcvf();
        zzcvfVar.zzf(context);
        if (str == null) {
            str = "adUnitId";
        }
        zzfcuVar.zzu(str);
        zzfcuVar.zzJ(zzmVar == null ? new com.google.android.gms.ads.internal.client.zzn().zza() : zzmVar);
        if (zzrVar == null) {
            switch (str2.hashCode()) {
                case -1999289321:
                    if (str2.equals("NATIVE")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -428325382:
                    if (str2.equals("APP_OPEN_AD")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 543046670:
                    if (str2.equals("REWARDED")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1854800829:
                    if (str2.equals("REWARDED_INTERSTITIAL")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 1951953708:
                    if (str2.equals("BANNER")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            zzrVar2 = c != 0 ? (c == 1 || c == 2) ? com.google.android.gms.ads.internal.client.zzr.zzd() : c != 3 ? c != 4 ? new com.google.android.gms.ads.internal.client.zzr() : com.google.android.gms.ads.internal.client.zzr.zzb() : com.google.android.gms.ads.internal.client.zzr.zzc() : new com.google.android.gms.ads.internal.client.zzr(context, AdSize.BANNER);
        } else {
            zzrVar2 = zzrVar;
        }
        zzfcuVar.zzt(zzrVar2);
        zzfcuVar.zzA(true);
        zzfcuVar.zzB(bundle);
        zzcvfVar.zzk(zzfcuVar.zzL());
        zzcvfVar.zzi(i);
        zzo.zza(zzcvfVar.zzl());
        zzax zzaxVar = new zzax();
        zzaxVar.zzb(str2);
        zzaxVar.zzc(str3);
        zzaxVar.zzd(zzbzeVar);
        zzo.zzb(new zzaz(zzaxVar, null));
        new zzdbu();
        return zzo.zzc();
    }

    private final ListenableFuture zzS(final String str) {
        final zzdny[] zzdnyVarArr = new zzdny[1];
        ListenableFuture zza2 = this.zzj.zza();
        zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzaf
            @Override // com.google.android.gms.internal.ads.zzgcu
            public final ListenableFuture zza(Object obj) {
                return zzau.zzx(zzau.this, zzdnyVarArr, str, (zzdny) obj);
            }
        };
        zzgdy zzgdyVar = this.zzk;
        ListenableFuture zzn = zzgdn.zzn(zza2, zzgcuVar, zzgdyVar);
        zzn.addListener(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzag
            @Override // java.lang.Runnable
            public final void run() {
                zzau.zzH(zzau.this, zzdnyVarArr);
            }
        }, zzgdyVar);
        return (zzgde) zzgdn.zze((zzgde) zzgdn.zzm((zzgde) zzgdn.zzo(zzgde.zzw(zzn), ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhV)).intValue(), TimeUnit.MILLISECONDS, this.zzl), new zzfve() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzam
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                int i = zzau.zze;
                return ((JSONObject) obj).optString("nas");
            }
        }, zzgdyVar), Exception.class, new zzfve() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzan
            @Override // com.google.android.gms.internal.ads.zzfve
            public final Object apply(Object obj) {
                int i = zzau.zze;
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", (Exception) obj);
                return null;
            }
        }, zzgdyVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzT() {
        zzau zzauVar;
        ListenableFuture zzb2;
        if (((Boolean) zzbfj.zze.zze()).booleanValue()) {
            this.zzJ.zze();
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlz)).booleanValue()) {
            zzb2 = zzgdn.zzk(new zzgct() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzad
                @Override // com.google.android.gms.internal.ads.zzgct
                public final ListenableFuture zza() {
                    ListenableFuture zzb3;
                    zzb3 = r0.zzR(zzau.this.zzg, null, AdFormat.BANNER.name(), null, null, 0, null, new Bundle(), null).zzb();
                    return zzb3;
                }
            }, zzcaf.zza);
            zzauVar = this;
        } else {
            zzauVar = this;
            zzb2 = zzauVar.zzR(this.zzg, null, AdFormat.BANNER.name(), null, null, 0, null, new Bundle(), null).zzb();
        }
        zzgdn.zzr(zzb2, new zzat(this), zzauVar.zzf.zzA());
    }

    private final void zzU() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjY)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkb)).booleanValue()) {
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkf)).booleanValue() && this.zzF.getAndSet(true)) {
                return;
            }
            zzT();
        }
    }

    private final void zzV(List list, final IObjectWrapper iObjectWrapper, zzbuf zzbufVar, boolean z) {
        ListenableFuture zzb2;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhU)).booleanValue()) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("The updating URL feature is not enabled.");
            try {
                zzbufVar.zze("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
                return;
            }
        }
        Iterator it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (zzP((Uri) it.next())) {
                i2++;
            }
        }
        if (i2 > 1) {
            String valueOf = String.valueOf(String.valueOf(list));
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Multiple google urls found: ".concat(valueOf));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            final Uri uri = (Uri) it2.next();
            if (zzP(uri)) {
                zzgdy zzgdyVar = this.zzk;
                zzb2 = zzgdyVar.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzah
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return zzau.zzn(zzau.this, uri, iObjectWrapper);
                    }
                });
                if (zzY()) {
                    zzb2 = zzgdn.zzn(zzb2, new zzgcu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzai
                        @Override // com.google.android.gms.internal.ads.zzgcu
                        public final ListenableFuture zza(Object obj) {
                            ListenableFuture zzm;
                            zzm = zzgdn.zzm(r0.zzS("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzfve() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzaj
                                @Override // com.google.android.gms.internal.ads.zzfve
                                public final Object apply(Object obj2) {
                                    return zzau.zzd(zzau.this, r2, (String) obj2);
                                }
                            }, zzau.this.zzk);
                            return zzm;
                        }
                    }, zzgdyVar);
                } else {
                    int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Asset view map is empty.");
                }
            } else {
                String valueOf2 = String.valueOf(String.valueOf(uri));
                int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Not a Google URL: ".concat(valueOf2));
                zzb2 = zzgdn.zzh(uri);
            }
            arrayList.add(zzb2);
        }
        zzgdn.zzr(zzgdn.zzd(arrayList), new zzas(this, zzbufVar, z), this.zzf.zzA());
    }

    private final void zzW(final List list, final IObjectWrapper iObjectWrapper, zzbuf zzbufVar, boolean z) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhU)).booleanValue()) {
            try {
                zzbufVar.zze("The updating URL feature is not enabled.");
                return;
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
                return;
            }
        }
        zzgdy zzgdyVar = this.zzk;
        ListenableFuture zzb2 = zzgdyVar.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzao
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzau.zzD(zzau.this, list, iObjectWrapper);
            }
        });
        if (zzY()) {
            zzb2 = zzgdn.zzn(zzb2, new zzgcu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzap
                @Override // com.google.android.gms.internal.ads.zzgcu
                public final ListenableFuture zza(Object obj) {
                    ListenableFuture zzm;
                    zzm = zzgdn.zzm(r0.zzS("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzfve() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzae
                        @Override // com.google.android.gms.internal.ads.zzfve
                        public final Object apply(Object obj2) {
                            return zzau.zzC(zzau.this, r2, (String) obj2);
                        }
                    }, zzau.this.zzk);
                    return zzm;
                }
            }, zzgdyVar);
        } else {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Asset view map is empty.");
        }
        zzgdn.zzr(zzb2, new zzar(this, zzbufVar, z), this.zzf.zzA());
    }

    private static boolean zzX(Uri uri, List list, List list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (host != null && path != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.contains((String) it.next())) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (host.endsWith((String) it2.next())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private final boolean zzY() {
        Map map;
        zzbui zzbuiVar = this.zzm;
        return (zzbuiVar == null || (map = zzbuiVar.zzb) == null || map.isEmpty()) ? false : true;
    }

    private static final List zzZ(String str) {
        String[] split = TextUtils.split(str, ",");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (!zzfwg.zzd(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Uri zzaa(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = indexOf + 1;
        return Uri.parse(uri2.substring(0, i) + str + C3040d4.i.b + str2 + C3040d4.i.c + uri2.substring(i));
    }

    public static /* synthetic */ Uri zzd(zzau zzauVar, Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zzaa(uri, "nas", str) : uri;
    }

    public static /* synthetic */ Uri zzn(zzau zzauVar, Uri uri, IObjectWrapper iObjectWrapper) {
        zzfda zzfdaVar;
        try {
            uri = (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmu)).booleanValue() || (zzfdaVar = zzauVar.zzi) == null) ? zzauVar.zzh.zza(uri, zzauVar.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null) : zzfdaVar.zza(uri, zzauVar.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), null);
        } catch (zzavv e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("", e);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    static /* bridge */ /* synthetic */ zzfhu zzs(ListenableFuture listenableFuture, zzbze zzbzeVar) {
        if (!zzfhx.zza() || !((Boolean) zzbex.zze.zze()).booleanValue()) {
            return null;
        }
        try {
            zzfhu zza2 = ((zzac) zzgdn.zzp(listenableFuture)).zza();
            zza2.zzd(new ArrayList(Collections.singletonList(zzbzeVar.zzb)));
            com.google.android.gms.ads.internal.client.zzm zzmVar = zzbzeVar.zzd;
            zza2.zzb(zzmVar == null ? "" : zzmVar.zzp);
            zza2.zzf(zzmVar.zzm);
            return zza2;
        } catch (ExecutionException e) {
            com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "SignalGeneratorImpl.getConfiguredCriticalUserJourney");
            return null;
        }
    }

    public static /* synthetic */ ListenableFuture zzx(zzau zzauVar, zzdny[] zzdnyVarArr, String str, zzdny zzdnyVar) {
        zzdnyVarArr[0] = zzdnyVar;
        Context context = zzauVar.zzg;
        zzbui zzbuiVar = zzauVar.zzm;
        Map map = zzbuiVar.zzb;
        JSONObject zzd2 = zzbv.zzd(context, map, map, zzbuiVar.zza, null);
        JSONObject zzh = zzbv.zzh(zzauVar.zzg, zzauVar.zzm.zza);
        JSONObject zzg = zzbv.zzg(zzauVar.zzm.zza);
        JSONObject zze2 = zzbv.zze(zzauVar.zzg, zzauVar.zzm.zza);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zzd2);
        jSONObject.put("ad_view_signal", zzh);
        jSONObject.put("scroll_view_signal", zzg);
        jSONObject.put("lock_screen_signal", zze2);
        if ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals".equals(str)) {
            jSONObject.put("click_signal", zzbv.zzc(null, zzauVar.zzg, zzauVar.zzo, zzauVar.zzn));
        }
        return zzdnyVar.zzg(str, jSONObject);
    }

    final boolean zzP(Uri uri) {
        return zzX(uri, this.zzB, this.zzC);
    }

    final boolean zzQ(Uri uri) {
        return zzX(uri, this.zzD, this.zzE);
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkl)).booleanValue()) {
            return ObjectWrapper.wrap(null);
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        CustomTabsClient customTabsClient = (CustomTabsClient) ObjectWrapper.unwrap(iObjectWrapper2);
        CustomTabsCallback customTabsCallback = (CustomTabsCallback) ObjectWrapper.unwrap(iObjectWrapper3);
        zzbej zzbejVar = this.zzI;
        zzbejVar.zzg(context, customTabsClient, str, customTabsCallback);
        if (((Boolean) zzbfj.zze.zze()).booleanValue()) {
            this.zzJ.zze();
        }
        if (((Boolean) zzbfj.zzc.zze()).booleanValue()) {
            this.zzK.zzb(null);
        }
        return ObjectWrapper.wrap(zzbejVar.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzf(IObjectWrapper iObjectWrapper, final zzbze zzbzeVar, zzbyx zzbyxVar) {
        zzbze zzbzeVar2;
        ListenableFuture zzh;
        ListenableFuture zzb2;
        ListenableFuture zzn;
        ListenableFuture listenableFuture;
        final Bundle bundle = new Bundle();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzcq)).booleanValue()) {
            bundle.putLong(zzdrr.PUBLIC_API_CALL.zza(), zzbzeVar.zzd.zzz);
            bundle.putLong(zzdrr.DYNAMITE_ENTER.zza(), com.google.android.gms.ads.internal.zzv.zzD().currentTimeMillis());
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.zzg = context;
        zzfhj zza2 = zzfhi.zza(context, 22);
        zza2.zzi();
        int i = 0;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhN)).booleanValue()) {
            com.google.android.gms.ads.internal.client.zzm zzmVar = zzbzeVar.zzd;
            if (zzmVar.zzc.getBoolean("optimize_for_app_start", false) && Objects.equals(zzaa.zzc(zzmVar), "requester_type_8")) {
                i = 2;
                if (zzbzeVar.zze != 2) {
                    i = 1;
                }
            }
        }
        final int i2 = i;
        String str = zzbzeVar.zzb;
        if ("UNKNOWN".equals(str)) {
            List arrayList = new ArrayList();
            zzbcv zzbcvVar = zzbde.zzhM;
            if (!((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).isEmpty()) {
                arrayList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).split(","));
            }
            if (arrayList.contains(zzaa.zzc(zzbzeVar.zzd))) {
                zzh = zzgdn.zzg(new IllegalArgumentException("Unknown format is no longer supported."));
                zzb2 = zzgdn.zzg(new IllegalArgumentException("Unknown format is no longer supported."));
                zzbzeVar2 = zzbzeVar;
                listenableFuture = zzh;
                zzn = zzb2;
                zzgdn.zzr(zzn, new zzaq(this, listenableFuture, zzbzeVar2, zzbyxVar, zza2), this.zzf.zzA());
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlz)).booleanValue()) {
            zzgdy zzgdyVar = zzcaf.zza;
            ListenableFuture zzb3 = zzgdyVar.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzak
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzac zzR;
                    zzR = r0.zzR(zzau.this.zzg, r1.zza, r1.zzb, r1.zzc, r1.zzd, i2, r1.zzf, bundle, zzbzeVar);
                    return zzR;
                }
            });
            zzn = zzgdn.zzn(zzb3, new zzgcu() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzal
                @Override // com.google.android.gms.internal.ads.zzgcu
                public final ListenableFuture zza(Object obj) {
                    return ((zzac) obj).zzb();
                }
            }, zzgdyVar);
            zzbzeVar2 = zzbzeVar;
            listenableFuture = zzb3;
            zzgdn.zzr(zzn, new zzaq(this, listenableFuture, zzbzeVar2, zzbyxVar, zza2), this.zzf.zzA());
        }
        zzac zzR = zzR(this.zzg, zzbzeVar.zza, str, zzbzeVar.zzc, zzbzeVar.zzd, i2, zzbzeVar.zzf, bundle, zzbzeVar);
        zzbzeVar2 = zzbzeVar;
        zzh = zzgdn.zzh(zzR);
        zzb2 = zzR.zzb();
        listenableFuture = zzh;
        zzn = zzb2;
        zzgdn.zzr(zzn, new zzaq(this, listenableFuture, zzbzeVar2, zzbyxVar, zza2), this.zzf.zzA());
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzg(zzbui zzbuiVar) {
        this.zzm = zzbuiVar;
        this.zzj.zzc(1);
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) {
        zzV(list, iObjectWrapper, zzbufVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) {
        zzW(list, iObjectWrapper, zzbufVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzj(IObjectWrapper iObjectWrapper) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzjX)).booleanValue()) {
            zzbcv zzbcvVar = zzbde.zzhL;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
                zzU();
            }
            WebView webView = (WebView) ObjectWrapper.unwrap(iObjectWrapper);
            if (webView == null) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("The webView cannot be null.");
                return;
            }
            zzf zzfVar = this.zzK;
            final zzj zzjVar = new zzj(webView, zzfVar, zzcaf.zzf);
            webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.zzh, this.zzp, this.zzq, this.zzi, this.zzJ, zzfVar, zzjVar), "gmaSdk");
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkh)).booleanValue()) {
                com.google.android.gms.ads.internal.zzv.zzp().zzs();
            }
            if (((Boolean) zzbfj.zzc.zze()).booleanValue()) {
                zzfVar.zzb(webView);
                if (((Boolean) zzbfj.zzd.zze()).booleanValue()) {
                    zzcaf.zzd.scheduleWithFixedDelay(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzi
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzj.this.zzb();
                        }
                    }, 0L, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzki)).intValue(), TimeUnit.MILLISECONDS);
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbcvVar)).booleanValue()) {
                zzU();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzk(IObjectWrapper iObjectWrapper) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzhU)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzbui zzbuiVar = this.zzm;
            this.zzn = zzbv.zza(motionEvent, zzbuiVar == null ? null : zzbuiVar.zza);
            if (motionEvent.getAction() == 0) {
                this.zzo = this.zzn;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setLocation(this.zzn.x, this.zzn.y);
            this.zzh.zzd(obtain);
            obtain.recycle();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) {
        zzV(list, iObjectWrapper, zzbufVar, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbza
    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbuf zzbufVar) {
        zzW(list, iObjectWrapper, zzbufVar, false);
    }
}
