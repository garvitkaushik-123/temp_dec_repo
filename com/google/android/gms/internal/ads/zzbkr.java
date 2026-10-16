package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.core.app.NotificationManagerCompat;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.mbridge.msdk.MBridgeConstans;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzbkr implements zzbkf {
    private final com.google.android.gms.ads.internal.zzb zza;
    private final zzdsj zzb;
    private final zzbso zzd;
    private final zzeca zze;
    private final zzcmq zzf;
    private com.google.android.gms.ads.internal.util.client.zzu zzc = null;
    private com.google.android.gms.ads.internal.overlay.zzaa zzg = null;
    private final zzgdy zzh = zzcaf.zzg;

    public zzbkr(com.google.android.gms.ads.internal.zzb zzbVar, zzbso zzbsoVar, zzeca zzecaVar, zzdsj zzdsjVar, zzcmq zzcmqVar) {
        this.zza = zzbVar;
        this.zzd = zzbsoVar;
        this.zze = zzecaVar;
        this.zzb = zzdsjVar;
        this.zzf = zzcmqVar;
    }

    public static int zzb(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if ("p".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        return "c".equalsIgnoreCase(str) ? 14 : -1;
    }

    static Uri zzc(Context context, zzavu zzavuVar, Uri uri, View view, Activity activity, zzfda zzfdaVar) {
        if (zzavuVar != null) {
            try {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmu)).booleanValue() || zzfdaVar == null) {
                    if (zzavuVar.zze(uri)) {
                        return zzavuVar.zza(uri, context, view, activity);
                    }
                } else if (zzavuVar.zze(uri)) {
                    return zzfdaVar.zza(uri, context, view, activity);
                }
            } catch (zzavv unused) {
            } catch (Exception e) {
                com.google.android.gms.ads.internal.zzv.zzp().zzw(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
            }
        }
        return uri;
    }

    static Uri zzd(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            String valueOf = String.valueOf(uri.toString());
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error adding click uptime parameter to url: ".concat(valueOf), e);
        }
        return uri;
    }

    public static boolean zzf(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzh(String str, com.google.android.gms.ads.internal.client.zza zzaVar, Map map, String str2) {
        String str3;
        boolean z;
        Object obj;
        boolean z2;
        Object obj2;
        Map map2 = map;
        zzcfg zzcfgVar = (zzcfg) zzaVar;
        zzfca zzD = zzcfgVar.zzD();
        zzfcd zzR = zzcfgVar.zzR();
        boolean z3 = false;
        if (zzD == null || zzR == null) {
            str3 = "";
            z = false;
        } else {
            str3 = zzR.zzb;
            z = zzD.zzb();
        }
        boolean z4 = (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlg)).booleanValue() && map2.containsKey("sc") && ((String) map2.get("sc")).equals("0")) ? false : true;
        boolean z5 = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzng)).booleanValue() && map2.containsKey("ig_cl") && ((String) map2.get("ig_cl")).equals("true");
        if (n.e.equalsIgnoreCase(str2)) {
            if (zzcfgVar.zzaF()) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot expand WebView that is already expanded.");
                return;
            } else {
                zzk(false);
                ((zzcgq) zzaVar).zzaL(zzf(map2), zzb(map2), z4);
                return;
            }
        }
        if ("webapp".equalsIgnoreCase(str2)) {
            zzk(false);
            boolean z6 = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzmq)).booleanValue() && Objects.equals(map2.get("is_allowed_for_lock_screen"), "1");
            if (str != null) {
                ((zzcgq) zzaVar).zzaN(zzf(map2), zzb(map2), str, z4, z6);
                return;
            } else {
                ((zzcgq) zzaVar).zzaM(zzf(map2), zzb(map2), (String) map2.get(AnalyticsConstants.CREATIVE_TYPE_HTML), (String) map2.get("baseurl"), z4);
                return;
            }
        }
        Intent intent = null;
        if ("chrome_custom_tab".equalsIgnoreCase(str2)) {
            Context context = zzcfgVar.getContext();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeY)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zze.zza("User opt out chrome custom tab.");
                zzm(10);
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeT)).booleanValue()) {
                    int i2 = zzbed.zza;
                    String packageName = CustomTabsClient.getPackageName(context, null);
                    if (packageName != null && !context.getPackageName().equals(packageName)) {
                        z3 = true;
                    }
                } else {
                    z3 = zzbef.zzg(context);
                }
                if (z3) {
                    zzk(true);
                    if (TextUtils.isEmpty(str)) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot open browser with null or empty url");
                        zzm(7);
                        return;
                    }
                    Uri zzd = zzd(zzc(zzcfgVar.getContext(), zzcfgVar.zzI(), Uri.parse(str), zzcfgVar.zzF(), zzcfgVar.zzi(), zzcfgVar.zzS()));
                    if (z && this.zze != null && zzl(zzaVar, zzcfgVar.getContext(), zzd.toString(), str3)) {
                        return;
                    }
                    this.zzg = new zzbko(this);
                    ((zzcgq) zzaVar).zzaJ(new com.google.android.gms.ads.internal.overlay.zzc(null, zzd.toString(), null, null, null, null, null, null, ObjectWrapper.wrap(this.zzg).asBinder(), true), z4, z5, str3);
                    return;
                }
                zzm(4);
            }
            map2.put("use_first_package", "true");
            map2.put("use_running_process", "true");
            zzj(zzaVar, map2, z, str3, z4, z5);
            return;
        }
        if (MBridgeConstans.DYNAMIC_VIEW_WX_APP.equalsIgnoreCase(str2) && "true".equalsIgnoreCase((String) map2.get("system_browser"))) {
            zzj(zzaVar, map2, z, str3, z4, z5);
            return;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar2 = zzaVar;
        String str4 = str3;
        boolean z7 = z5;
        boolean z8 = z;
        if ("open_app".equalsIgnoreCase(str2)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziE)).booleanValue()) {
                zzk(true);
                String str5 = (String) map2.get("p");
                if (str5 == null) {
                    int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Package name missing from open app action.");
                    return;
                }
                if (z8 && this.zze != null && zzl(zzaVar2, zzcfgVar.getContext(), str5, str4)) {
                    return;
                }
                PackageManager packageManager = zzcfgVar.getContext().getPackageManager();
                if (packageManager == null) {
                    int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot get package manager from open app action.");
                    return;
                } else {
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str5);
                    if (launchIntentForPackage != null) {
                        ((zzcgq) zzaVar2).zzaJ(new com.google.android.gms.ads.internal.overlay.zzc(launchIntentForPackage, this.zzg), z4, z7, str4);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        zzk(true);
        String str6 = (String) map2.get("intent_url");
        if (!TextUtils.isEmpty(str6)) {
            try {
                intent = Intent.parseUri(str6, 0);
            } catch (URISyntaxException e) {
                String valueOf = String.valueOf(str6);
                int i6 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Error parsing the url: ".concat(valueOf), e);
            }
        }
        if (intent != null && intent.getData() != null) {
            Uri data = intent.getData();
            if (!Uri.EMPTY.equals(data)) {
                Uri zzd2 = zzd(zzc(zzcfgVar.getContext(), zzcfgVar.zzI(), data, zzcfgVar.zzF(), zzcfgVar.zzi(), zzcfgVar.zzS()));
                if (!TextUtils.isEmpty(intent.getType())) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziF)).booleanValue()) {
                        intent.setDataAndType(zzd2, intent.getType());
                    }
                }
                intent.setData(zzd2);
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzja)).booleanValue() && "intent_async".equalsIgnoreCase(str2) && map2.containsKey("event_id")) {
            obj = "event_id";
            z2 = true;
        } else {
            obj = "event_id";
            z2 = false;
        }
        HashMap hashMap = new HashMap();
        if (z2) {
            boolean z9 = z4;
            obj2 = obj;
            zzbkp zzbkpVar = new zzbkp(this, z9, zzaVar2, hashMap, map2);
            zzaVar2 = zzaVar2;
            map2 = map2;
            this.zzg = zzbkpVar;
        } else {
            boolean z10 = z4;
            obj2 = obj;
            z3 = z10;
        }
        if (intent != null) {
            if (!z8 || this.zze == null || !zzl(zzaVar2, zzcfgVar.getContext(), intent.getData().toString(), str4)) {
                ((zzcgq) zzaVar2).zzaJ(new com.google.android.gms.ads.internal.overlay.zzc(intent, this.zzg), z3, z7, str4);
                return;
            } else {
                if (z2) {
                    hashMap.put((String) map2.get(obj2), true);
                    ((zzbna) zzaVar2).zzd("openIntentAsync", hashMap);
                    return;
                }
                return;
            }
        }
        String uri = !TextUtils.isEmpty(str) ? zzd(zzc(zzcfgVar.getContext(), zzcfgVar.zzI(), Uri.parse(str), zzcfgVar.zzF(), zzcfgVar.zzi(), zzcfgVar.zzS())).toString() : str;
        if (!z8 || this.zze == null || !zzl(zzaVar2, zzcfgVar.getContext(), uri, str4)) {
            ((zzcgq) zzaVar2).zzaJ(new com.google.android.gms.ads.internal.overlay.zzc((String) map2.get("i"), uri, (String) map2.get("m"), (String) map2.get("p"), (String) map2.get("c"), (String) map2.get(InneractiveMediationDefs.GENDER_FEMALE), (String) map2.get("e"), this.zzg), z3, z7, str4);
        } else if (z2) {
            hashMap.put((String) map2.get(obj2), true);
            ((zzbna) zzaVar2).zzd("openIntentAsync", hashMap);
        }
    }

    private final void zzi(Context context, String str, String str2) {
        zzeca zzecaVar = this.zze;
        zzecaVar.zzc(str);
        zzdsj zzdsjVar = this.zzb;
        if (zzdsjVar != null) {
            zzecl.zzp(context, zzdsjVar, zzecaVar, str, "dialog_not_shown", zzfyt.zze("dialog_not_shown_reason", str2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ff, code lost:
    
        if (com.google.android.gms.internal.ads.zzbkq.zzc(r13, r8, r9, r10, r11) == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x014c, code lost:
    
        r15 = r18;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzj(com.google.android.gms.ads.internal.client.zza zzaVar, Map map, boolean z, String str, boolean z2, boolean z3) {
        boolean z4;
        ResolveInfo zzd;
        zzcfg zzcfgVar;
        Intent zzb;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ResolveInfo zzc;
        zzk(true);
        zzcfg zzcfgVar2 = (zzcfg) zzaVar;
        Context context = zzcfgVar2.getContext();
        zzavu zzI = zzcfgVar2.zzI();
        View zzF = zzcfgVar2.zzF();
        zzfda zzS = zzcfgVar2.zzS();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String str2 = (String) map.get("u");
        if (TextUtils.isEmpty(str2)) {
            zzcfgVar = zzcfgVar2;
            zzb = null;
        } else {
            Uri zzd2 = zzd(zzc(context, zzI, Uri.parse(str2), zzF, null, zzS));
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("use_first_package"));
            boolean parseBoolean2 = Boolean.parseBoolean((String) map.get("use_running_process"));
            if (!Boolean.parseBoolean((String) map.get("use_custom_tabs"))) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeP)).booleanValue()) {
                    z4 = false;
                    Uri build = !"http".equalsIgnoreCase(zzd2.getScheme()) ? zzd2.buildUpon().scheme("https").build() : "https".equalsIgnoreCase(zzd2.getScheme()) ? zzd2.buildUpon().scheme("http").build() : null;
                    ArrayList arrayList = new ArrayList();
                    Intent zza = zzbkq.zza(zzd2, context, zzI, zzF, zzS);
                    Intent zza2 = zzbkq.zza(build, context, zzI, zzF, zzS);
                    if (z4) {
                        com.google.android.gms.ads.internal.zzv.zzr();
                        com.google.android.gms.ads.internal.util.zzs.zzp(context, zza);
                        com.google.android.gms.ads.internal.zzv.zzr();
                        com.google.android.gms.ads.internal.util.zzs.zzp(context, zza2);
                    }
                    zzd = zzbkq.zzd(zza, arrayList, context, zzI, zzF, zzS);
                    if (zzd == null) {
                        zzb = zzbkq.zzb(zza, zzd, context, zzI, zzF, zzS);
                    } else {
                        if (zza2 != null && (zzc = zzbkq.zzc(zza2, context, zzI, zzF, zzS)) != null) {
                            zzb = zzbkq.zzb(zza, zzc, context, zzI, zzF, zzS);
                        }
                        if (arrayList.isEmpty()) {
                            zzcfgVar = zzcfgVar2;
                        } else {
                            if (parseBoolean2 && activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                                int size = arrayList.size();
                                int i = 0;
                                loop0: while (i < size) {
                                    ResolveInfo resolveInfo = (ResolveInfo) arrayList.get(i);
                                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                                    while (true) {
                                        int i2 = i + 1;
                                        if (it.hasNext()) {
                                            zzcfgVar = zzcfgVar2;
                                            if (it.next().processName.equals(resolveInfo.activityInfo.packageName)) {
                                                zzb = zzbkq.zzb(zza, resolveInfo, context, zzI, zzF, zzS);
                                                break loop0;
                                            }
                                            zzcfgVar2 = zzcfgVar;
                                        }
                                    }
                                }
                            }
                            zzcfgVar = zzcfgVar2;
                            if (parseBoolean) {
                                zzb = zzbkq.zzb(zza, (ResolveInfo) arrayList.get(0), context, zzI, zzF, zzS);
                            }
                        }
                        zzb = zza;
                    }
                    zzcfgVar = zzcfgVar2;
                }
            }
            z4 = true;
            if (!"http".equalsIgnoreCase(zzd2.getScheme())) {
            }
            ArrayList arrayList2 = new ArrayList();
            Intent zza3 = zzbkq.zza(zzd2, context, zzI, zzF, zzS);
            Intent zza22 = zzbkq.zza(build, context, zzI, zzF, zzS);
            if (z4) {
            }
            zzd = zzbkq.zzd(zza3, arrayList2, context, zzI, zzF, zzS);
            if (zzd == null) {
            }
            zzcfgVar = zzcfgVar2;
        }
        if (!z || this.zze == null || zzb == null || !zzl(zzaVar, zzcfgVar.getContext(), zzb.getData().toString(), str)) {
            try {
                ((zzcgq) zzaVar).zzaJ(new com.google.android.gms.ads.internal.overlay.zzc(zzb, this.zzg), z2, z3, str);
            } catch (ActivityNotFoundException e) {
                String message = e.getMessage();
                int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj(message);
            }
        }
    }

    private final void zzk(boolean z) {
        zzbso zzbsoVar = this.zzd;
        if (zzbsoVar != null) {
            zzbsoVar.zzb(z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x006e, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zziU)).booleanValue() != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d8, code lost:
    
        if ((android.os.Build.VERSION.SDK_INT < 33 ? ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zziP)).booleanValue() : ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zziO)).booleanValue()) != false) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean zzl(com.google.android.gms.ads.internal.client.zza zzaVar, Context context, String str, String str2) {
        zzbtw zzbtwVar;
        com.google.android.gms.ads.internal.util.client.zzw zzwVar;
        zzdsj zzdsjVar = this.zzb;
        if (zzdsjVar != null) {
            zzecl.zzo(context, zzdsjVar, this.zze, str2, "offline_open");
        }
        if (com.google.android.gms.ads.internal.zzv.zzp().zzA(context)) {
            if (this.zzc == null) {
                this.zzc = new com.google.android.gms.ads.internal.util.client.zzu(context.getApplicationContext(), null);
            }
            this.zze.zzh(this.zzc, str2);
            return false;
        }
        zzcfg zzcfgVar = (zzcfg) zzaVar;
        zzfca zzD = zzcfgVar.zzD();
        boolean z = (zzD == null || (zzwVar = zzD.zzay) == null || zzwVar.zzc()) ? false : true;
        boolean z2 = (zzD == null || (zzbtwVar = zzD.zzad) == null || !zzbtwVar.zza || zzbtwVar.zzb == null || !zzbtwVar.zzc) ? false : true;
        if (!z) {
            if (z2) {
            }
            com.google.android.gms.ads.internal.zzv.zzr();
            com.google.android.gms.ads.internal.util.zzbr zzA = com.google.android.gms.ads.internal.util.zzs.zzA(context);
            com.google.android.gms.ads.internal.zzv.zzr();
            boolean areNotificationsEnabled = NotificationManagerCompat.from(context).areNotificationsEnabled();
            boolean zzi = com.google.android.gms.ads.internal.zzv.zzs().zzi(context, "offline_notification_channel");
            boolean z3 = zzcfgVar.zzO().zzi() && zzcfgVar.zzi() == null;
            if (!areNotificationsEnabled) {
                com.google.android.gms.ads.internal.zzv.zzr();
                if (!NotificationManagerCompat.from(context).areNotificationsEnabled()) {
                }
                zzi(context, str2, "notifications_disabled");
                return false;
            }
            if (zzi) {
                zzi(context, str2, "notification_channel_disabled");
                return false;
            }
            if (zzA == null) {
                zzi(context, str2, "work_manager_unavailable");
                return false;
            }
            if (z3) {
                zzi(context, str2, "ad_no_activity");
                return false;
            }
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zziM)).booleanValue()) {
                zzi(context, str2, "notification_flow_disabled");
                return false;
            }
            if (zzcfgVar.zzL() == null || zzcfgVar.zzi() == null) {
                ((zzcgq) zzaVar).zzaK(str2, str, 14);
            } else {
                zzecm zze = zzecn.zze();
                zze.zza(zzcfgVar.zzi());
                zze.zzb(null);
                zze.zzc(str2);
                zze.zzd(str);
                try {
                    zzcfgVar.zzL().zzf(zze.zze());
                } catch (Exception e) {
                    zzi(context, str2, e.getMessage());
                    return false;
                }
            }
            zzaVar.onAdClicked();
            return true;
        }
        zzdsj zzdsjVar2 = this.zzb;
        if (zzdsjVar2 != null) {
            zzecl.zzo(context, zzdsjVar2, this.zze, str2, "onfs");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzm(int i) {
        zzdsj zzdsjVar;
        String str;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzeS)).booleanValue() || (zzdsjVar = this.zzb) == null) {
            return;
        }
        zzdsi zza = zzdsjVar.zza();
        zza.zzb("action", "cct_action");
        switch (i) {
            case 2:
                str = "CONTEXT_NOT_AN_ACTIVITY";
                break;
            case 3:
                str = "CONTEXT_NULL";
                break;
            case 4:
                str = "CCT_NOT_SUPPORTED";
                break;
            case 5:
                str = "CCT_READY_TO_OPEN";
                break;
            case 6:
                str = "ACTIVITY_NOT_FOUND";
                break;
            case 7:
                str = "EMPTY_URL";
                break;
            case 8:
                str = "UNKNOWN";
                break;
            case 9:
                str = "WRONG_EXP_SETUP";
                break;
            default:
                str = "OPT_OUT";
                break;
        }
        zza.zzb("cct_open_status", str);
        zza.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbkf
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcmq zzcmqVar;
        com.google.android.gms.ads.internal.client.zza zzaVar = (com.google.android.gms.ads.internal.client.zza) obj;
        String str = (String) map.get("u");
        Map hashMap = new HashMap();
        zzcfg zzcfgVar = (zzcfg) zzaVar;
        if (zzcfgVar.zzD() != null) {
            hashMap = zzcfgVar.zzD().zzaw;
        }
        String zzc = zzbyq.zzc(str, zzcfgVar.getContext(), true, hashMap);
        String str2 = (String) map.get("a");
        if (str2 == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zzb zzbVar = this.zza;
        if (zzbVar == null || zzbVar.zzc()) {
            zzgdn.zzr((((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzkx)).booleanValue() && (zzcmqVar = this.zzf) != null && zzcmq.zzj(zzc)) ? zzcmqVar.zze(zzc, com.google.android.gms.ads.internal.client.zzbb.zze()) : zzgdn.zzh(zzc), new zzbkn(this, map, zzaVar, str2), this.zzh);
        } else {
            zzbVar.zzb(zzc);
        }
    }
}
