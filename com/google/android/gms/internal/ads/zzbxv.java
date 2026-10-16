package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes5.dex */
public final class zzbxv implements zzbya {
    public static final /* synthetic */ int zzb = 0;
    private static final List zzc = Collections.synchronizedList(new ArrayList());
    boolean zza;
    private final zzhdk zzd;
    private final LinkedHashMap zze;
    private final Context zzh;
    private final zzbxx zzi;
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private final Object zzj = new Object();
    private HashSet zzk = new HashSet();
    private boolean zzl = false;
    private boolean zzm = false;

    public zzbxv(Context context, VersionInfoParcel versionInfoParcel, zzbxx zzbxxVar, String str, zzbxw zzbxwVar) {
        Preconditions.checkNotNull(zzbxxVar, "SafeBrowsing config is not present.");
        this.zzh = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zze = new LinkedHashMap();
        this.zzi = zzbxxVar;
        Iterator it = zzbxxVar.zze.iterator();
        while (it.hasNext()) {
            this.zzk.add(((String) it.next()).toLowerCase(Locale.ENGLISH));
        }
        this.zzk.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzhdk zzc2 = zzhfm.zzc();
        zzc2.zzn(9);
        if (str != null) {
            zzc2.zzj(str);
            zzc2.zzh(str);
        }
        zzhdl zzc3 = zzhdm.zzc();
        String str2 = this.zzi.zza;
        if (str2 != null) {
            zzc3.zza(str2);
        }
        zzc2.zzg((zzhdm) zzc3.zzbr());
        zzhfa zzc4 = zzhfb.zzc();
        zzc4.zzc(Wrappers.packageManager(this.zzh).isCallerInstantApp());
        String str3 = versionInfoParcel.afmaVersion;
        if (str3 != null) {
            zzc4.zza(str3);
        }
        long apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzh);
        if (apkVersion > 0) {
            zzc4.zzb(apkVersion);
        }
        zzc2.zzf((zzhfb) zzc4.zzbr());
        this.zzd = zzc2;
    }

    public static /* synthetic */ ListenableFuture zzb(zzbxv zzbxvVar, Map map) {
        int length;
        zzhey zzheyVar;
        ListenableFuture zzm;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        Object obj = zzbxvVar.zzj;
                        synchronized (obj) {
                            length = optJSONArray.length();
                            synchronized (obj) {
                                zzheyVar = (zzhey) zzbxvVar.zze.get(str);
                            }
                        }
                        if (zzheyVar == null) {
                            zzbxz.zza("Cannot find the corresponding resource object for " + str);
                        } else {
                            for (int i = 0; i < length; i++) {
                                zzheyVar.zza(optJSONArray.getJSONObject(i).getString("threat_type"));
                            }
                            zzbxvVar.zza = (length > 0) | zzbxvVar.zza;
                        }
                    }
                }
            } catch (JSONException e) {
                if (((Boolean) zzbfm.zza.zze()).booleanValue()) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to get SafeBrowsing metadata", e);
                }
                return zzgdn.zzg(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (zzbxvVar.zza) {
            synchronized (zzbxvVar.zzj) {
                zzbxvVar.zzd.zzn(10);
            }
        }
        boolean z = zzbxvVar.zza;
        if (!(z && zzbxvVar.zzi.zzg) && (!(zzbxvVar.zzm && zzbxvVar.zzi.zzf) && (z || !zzbxvVar.zzi.zzd))) {
            return zzgdn.zzh(null);
        }
        synchronized (zzbxvVar.zzj) {
            Iterator it = zzbxvVar.zze.values().iterator();
            while (it.hasNext()) {
                zzbxvVar.zzd.zzc((zzhez) ((zzhey) it.next()).zzbr());
            }
            zzhdk zzhdkVar = zzbxvVar.zzd;
            zzhdkVar.zza(zzbxvVar.zzf);
            zzhdkVar.zzb(zzbxvVar.zzg);
            if (zzbxz.zzb()) {
                StringBuilder sb = new StringBuilder("Sending SB report\n  url: " + zzhdkVar.zzl() + "\n  clickUrl: " + zzhdkVar.zzk() + "\n  resources: \n");
                for (zzhez zzhezVar : zzhdkVar.zzm()) {
                    sb.append("    [");
                    sb.append(zzhezVar.zzc());
                    sb.append("] ");
                    sb.append(zzhezVar.zzg());
                }
                zzbxz.zza(sb.toString());
            }
            ListenableFuture zzb2 = new com.google.android.gms.ads.internal.util.zzbo(zzbxvVar.zzh).zzb(1, zzbxvVar.zzi.zzb, null, ((zzhfm) zzhdkVar.zzbr()).zzaV());
            if (zzbxz.zzb()) {
                zzb2.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbxs
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i3 = zzbxv.zzb;
                        zzbxz.zza("Pinged SB successfully.");
                    }
                }, zzcaf.zza);
            }
            zzm = zzgdn.zzm(zzb2, new zzfve() { // from class: com.google.android.gms.internal.ads.zzbxt
                @Override // com.google.android.gms.internal.ads.zzfve
                public final Object apply(Object obj2) {
                    int i3 = zzbxv.zzb;
                    return null;
                }
            }, zzcaf.zzg);
        }
        return zzm;
    }

    public static /* synthetic */ void zzd(zzbxv zzbxvVar, Bitmap bitmap) {
        zzgxx zzt = zzgxz.zzt();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzt);
        synchronized (zzbxvVar.zzj) {
            zzhdk zzhdkVar = zzbxvVar.zzd;
            zzhes zzc2 = zzheu.zzc();
            zzc2.zza(zzt.zzb());
            zzc2.zzb("image/png");
            zzc2.zzc(2);
            zzhdkVar.zzi((zzheu) zzc2.zzbr());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbya
    public final zzbxx zza() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzbya
    public final void zze(String str, Map map, int i) {
        synchronized (this.zzj) {
            if (i == 3) {
                this.zzm = true;
            }
            LinkedHashMap linkedHashMap = this.zze;
            if (linkedHashMap.containsKey(str)) {
                if (i == 3) {
                    ((zzhey) linkedHashMap.get(str)).zze(4);
                }
                return;
            }
            zzhey zzd = zzhez.zzd();
            int zza = zzhex.zza(i);
            if (zza != 0) {
                zzd.zze(zza);
            }
            zzd.zzb(linkedHashMap.size());
            zzd.zzd(str);
            zzhdx zzc2 = zzhea.zzc();
            if (!this.zzk.isEmpty() && map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = entry.getKey() != null ? (String) entry.getKey() : "";
                    String str3 = entry.getValue() != null ? (String) entry.getValue() : "";
                    if (this.zzk.contains(str2.toLowerCase(Locale.ENGLISH))) {
                        zzhdv zzc3 = zzhdw.zzc();
                        zzc3.zza(zzgxz.zzw(str2));
                        zzc3.zzb(zzgxz.zzw(str3));
                        zzc2.zza((zzhdw) zzc3.zzbr());
                    }
                }
            }
            zzd.zzc((zzhea) zzc2.zzbr());
            linkedHashMap.put(str, zzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbya
    public final void zzf() {
        synchronized (this.zzj) {
            this.zze.keySet();
            ListenableFuture zzh = zzgdn.zzh(Collections.emptyMap());
            zzgcu zzgcuVar = new zzgcu() { // from class: com.google.android.gms.internal.ads.zzbxq
                @Override // com.google.android.gms.internal.ads.zzgcu
                public final ListenableFuture zza(Object obj) {
                    return zzbxv.zzb(zzbxv.this, (Map) obj);
                }
            };
            zzgdy zzgdyVar = zzcaf.zzg;
            ListenableFuture zzn = zzgdn.zzn(zzh, zzgcuVar, zzgdyVar);
            ListenableFuture zzo = zzgdn.zzo(zzn, 10L, TimeUnit.SECONDS, zzcaf.zzd);
            zzgdn.zzr(zzn, new zzbxu(this, zzo), zzgdyVar);
            zzc.add(zzo);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b  */
    @Override // com.google.android.gms.internal.ads.zzbya
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzg(View view) {
        Bitmap bitmap;
        boolean isDrawingCacheEnabled;
        if (this.zzi.zzc && !this.zzl) {
            com.google.android.gms.ads.internal.zzv.zzr();
            final Bitmap bitmap2 = null;
            if (view != null) {
                try {
                    isDrawingCacheEnabled = view.isDrawingCacheEnabled();
                    view.setDrawingCacheEnabled(true);
                    Bitmap drawingCache = view.getDrawingCache();
                    bitmap = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
                } catch (RuntimeException e) {
                    e = e;
                    bitmap = null;
                }
                try {
                    view.setDrawingCacheEnabled(isDrawingCacheEnabled);
                } catch (RuntimeException e2) {
                    e = e2;
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzh("Fail to capture the web view", e);
                    if (bitmap != null) {
                    }
                    if (bitmap2 != null) {
                    }
                }
                if (bitmap != null) {
                    try {
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (width != 0 && height != 0) {
                            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                            Canvas canvas = new Canvas(createBitmap);
                            view.layout(0, 0, width, height);
                            view.draw(canvas);
                            bitmap2 = createBitmap;
                        }
                        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Width or height of view is zero");
                    } catch (RuntimeException e3) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Fail to capture the webview", e3);
                    }
                } else {
                    bitmap2 = bitmap;
                }
            }
            if (bitmap2 != null) {
                zzbxz.zza("Failed to capture the webview bitmap.");
            } else {
                this.zzl = true;
                com.google.android.gms.ads.internal.util.zzs.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbxr
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbxv.zzd(zzbxv.this, bitmap2);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbya
    public final void zzh(String str) {
        synchronized (this.zzj) {
            if (str == null) {
                this.zzd.zzd();
            } else {
                this.zzd.zze(str);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbya
    public final boolean zzi() {
        return PlatformVersion.isAtLeastKitKat() && this.zzi.zzc && !this.zzl;
    }
}
