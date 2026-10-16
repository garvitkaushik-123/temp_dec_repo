package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.adjust.sdk.Constants;
import com.bytedance.sdk.component.FC.MGA;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.ironsource.C3114ha;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class dZ {
    private static String Dfc;
    private static final byte[] NU;
    private static final HashSet<String> du;
    public static Integer eli;
    private static final byte[] nlS;
    private static String nn;
    private static final ExecutorService DbA = Executors.newSingleThreadExecutor();
    private static volatile boolean Os = false;
    private static final AtomicInteger aGH = new AtomicInteger(0);
    private static volatile String ui = "";
    private static final ReentrantLock MGA = new ReentrantLock();
    private static String kb = null;
    private static String wC = null;
    private static String FC = null;
    private static final HashSet<String> aAs = new HashSet<>(Arrays.asList("Asia/Shanghai", "Asia/Urumqi", "Asia/Chongqing", "Asia/Harbin", "Asia/Kashgar"));

    public static boolean MGA(int i) {
        return i == 6;
    }

    public static boolean aGH(int i) {
        return i == 4;
    }

    public static boolean aGH(Context context) {
        return false;
    }

    public static void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, View view) {
    }

    public static int kb(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 4) {
            return 1;
        }
        if (i == 5) {
            return 4;
        }
        if (i != 6) {
            return i;
        }
        return 5;
    }

    public static boolean ui(int i) {
        return i == 5;
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        du = hashSet;
        hashSet.addAll(Arrays.asList("America/Eirunepe", "America/Rio_Branco", "America/Boa_Vista", "America/Campo_Grande", "America/Cuiaba", "America/Manaus", "America/Porto_Velho", "America/Araguaina", "America/Bahia", "America/Belem", "America/Fortaleza", "America/Maceio", "America/Recife", "America/Santarem", "America/Sao_Paulo", "America/Noronha"));
        eli = null;
        nlS = new byte[]{108, 111, 97, 100, 105, 110, 103};
        NU = new byte[]{97, 114, 98, 105, 116, 114, 97, 103, 101};
    }

    public static Intent eli(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static DbA eli(Context context, Intent intent) {
        return new DbA(null, 0);
    }

    public static class DbA {
        public final int DbA;
        public final ComponentName eli;

        public DbA(ComponentName componentName, int i) {
            this.eli = componentName;
            this.DbA = i;
        }
    }

    public static boolean eli() {
        return (com.bytedance.sdk.openadsdk.core.Dfc.eli() == null || com.bytedance.sdk.openadsdk.core.Dfc.eli().aGH()) ? false : true;
    }

    public static boolean DbA(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                com.bytedance.sdk.component.utils.DbA.eli(context, intent, null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static String eli(int i) {
        if (i == 1) {
            return "embeded_ad";
        }
        if (i == 2) {
            return "banner_ad";
        }
        if (i == 3) {
            return "interaction";
        }
        if (i == 4) {
            return "open_ad";
        }
        if (i == 5) {
            return "fullscreen_interstitial_ad";
        }
        if (i != 7) {
            return null;
        }
        return "rewarded_video";
    }

    public static String DbA(int i) {
        if (i == 1) {
            return "embeded_ad_landingpage";
        }
        if (i == 2) {
            return "banner_ad_landingpage";
        }
        if (i == 3) {
            return "interaction_landingpage";
        }
        if (i == 4) {
            return "splash_ad_landingpage";
        }
        if (i == 5) {
            return "fullscreen_interstitial_ad";
        }
        if (i == 7) {
            return "rewarded_video_landingpage";
        }
        return "unknow";
    }

    public static String eli(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        if (evVar == null) {
            return null;
        }
        try {
            return Os(evVar.cK());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int DbA(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        if (evVar == null) {
            return -1;
        }
        int cK = evVar.cK();
        int i = 1;
        if (cK == 1) {
            return 2;
        }
        if (cK == 3) {
            return 4;
        }
        if (cK != 5) {
            i = 7;
            if (cK != 7) {
                return cK != 8 ? -1 : 5;
            }
        }
        return i;
    }

    public static int eli(String str) {
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 2;
            case "rewarded_video":
                return 7;
            case "open_ad":
            case "cache_splash_ad":
                return 4;
            case "fullscreen_interstitial_ad":
                return 5;
            case "interaction":
                return 3;
            default:
                return 1;
        }
    }

    public static String Os(int i) {
        if (i == 1) {
            return "banner_ad";
        }
        if (i == 2) {
            return "interaction";
        }
        if (i == 3 || i == 4) {
            return "open_ad";
        }
        if (i == 7) {
            return "rewarded_video";
        }
        if (i == 8) {
            return "fullscreen_interstitial_ad";
        }
        return "embeded_ad";
    }

    public static String DbA() {
        String DbA2;
        String str = "unKnow";
        com.bytedance.sdk.openadsdk.multipro.Os.eli(com.bytedance.sdk.openadsdk.core.dV.eli());
        try {
            DbA2 = com.bytedance.sdk.openadsdk.multipro.DbA.Os() ? com.bytedance.sdk.openadsdk.multipro.aGH.eli.DbA("sp_multi_ua_data", "android_system_ua", "unKnow") : com.bytedance.sdk.openadsdk.core.Os.eli().DbA("android_system_ua", "unKnow");
        } catch (Exception unused) {
        }
        if (DbA2 != null && !"unKnow".equals(DbA2)) {
            return DbA2;
        }
        FutureTask futureTask = new FutureTask(new eli(2));
        DbA.execute(futureTask);
        str = (String) futureTask.get(500L, TimeUnit.MILLISECONDS);
        com.bytedance.sdk.component.utils.Xb.Os("getUA", " getAndroidSystemUA userAgent".concat(String.valueOf(str)));
        return str;
    }

    public static void Os() {
        com.bytedance.sdk.openadsdk.Dfc.Os.eli("recycle_version_not_valid", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.utils.dZ.1
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("method_exist", dZ.GB());
                return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("recycle_version_not_valid").DbA(jSONObject.toString());
            }
        });
    }

    public static String aGH() {
        if (!TextUtils.isEmpty(ui)) {
            return ui;
        }
        com.bytedance.sdk.openadsdk.multipro.Os.eli(com.bytedance.sdk.openadsdk.core.dV.eli());
        String eli2 = com.bytedance.sdk.openadsdk.core.FC.eli("sdk_local_web_ua", 86400000L);
        ui = eli2;
        if (TextUtils.isEmpty(eli2)) {
            ReentrantLock reentrantLock = MGA;
            try {
                if (reentrantLock.tryLock()) {
                    try {
                        if (TextUtils.isEmpty(ui)) {
                            ui = WebSettings.getDefaultUserAgent(com.bytedance.sdk.openadsdk.core.dV.eli());
                        }
                        com.bytedance.sdk.openadsdk.core.FC.eli("sdk_local_web_ua", ui);
                        reentrantLock.unlock();
                    } catch (Exception e) {
                        com.bytedance.sdk.component.utils.Xb.eli("TTAD.ToolUtils", "", e);
                        return ui;
                    } catch (NoClassDefFoundError e2) {
                        com.bytedance.sdk.component.utils.Xb.eli("TTAD.ToolUtils", "", e2);
                        return ui;
                    }
                }
            } finally {
                MGA.unlock();
            }
        }
        return ui;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.utils.dZ$2, reason: invalid class name */
    static class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (TextUtils.isEmpty(dZ.ui)) {
                    com.bytedance.sdk.component.FC.MGA mga = new com.bytedance.sdk.component.FC.MGA(com.bytedance.sdk.openadsdk.core.dV.eli());
                    mga.setWebViewClient(new MGA.eli());
                    String unused = dZ.ui = mga.getUserAgentString();
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.Xb.eli("TTAD.ToolUtils", "", e);
            } catch (NoClassDefFoundError e2) {
                com.bytedance.sdk.component.utils.Xb.eli("TTAD.ToolUtils", "", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Cp() {
        try {
            WebView webView = new WebView(com.bytedance.sdk.openadsdk.core.dV.eli());
            webView.setWebViewClient(new MGA.eli());
            String userAgentString = webView.getSettings().getUserAgentString();
            if (userAgentString != null && !"unKnow".equals(userAgentString)) {
                if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                    com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_ua_data", "webview_ua", userAgentString);
                    return userAgentString;
                }
                com.bytedance.sdk.openadsdk.core.Os.eli().eli("webview_ua", userAgentString);
            }
            return userAgentString;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("getUA", "e:" + th.getMessage());
            return "unKnow";
        }
    }

    public static class eli implements Callable<String> {
        private final int eli;

        eli(int i) {
            this.eli = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public synchronized String call() throws Exception {
            String str;
            str = "unKnow";
            int i = this.eli;
            if (i == 1) {
                str = Os();
            } else if (i == 2) {
                str = DbA();
            }
            return str;
        }

        private String DbA() {
            String str;
            Throwable th;
            try {
                str = System.getProperty("http.agent");
                if (str != null) {
                    try {
                        if (!"unKnow".equals(str)) {
                            if (com.bytedance.sdk.openadsdk.multipro.DbA.Os()) {
                                com.bytedance.sdk.openadsdk.multipro.aGH.eli.eli("sp_multi_ua_data", "android_system_ua", str);
                                return str;
                            }
                            com.bytedance.sdk.openadsdk.core.Os.eli().eli("android_system_ua", str);
                            return str;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.bytedance.sdk.component.utils.Xb.Os("getUA", "e:" + th.getMessage());
                        return str;
                    }
                }
                return str;
            } catch (Throwable th3) {
                str = "unKnow";
                th = th3;
            }
        }

        private synchronized String Os() {
            final String[] strArr;
            strArr = new String[]{"unKnow"};
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.dZ.eli.1
                @Override // java.lang.Runnable
                public void run() {
                    strArr[0] = dZ.Cp();
                    String str = strArr[0];
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(2L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                com.bytedance.sdk.component.utils.Xb.Os("TTAD.ToolUtils", e.getMessage());
            }
            return strArr[0];
        }
    }

    public static String ui() {
        return gG.eli();
    }

    public static synchronized String MGA() {
        String str;
        Context eli2;
        synchronized (dZ.class) {
            if (TextUtils.isEmpty(kb) && (eli2 = com.bytedance.sdk.openadsdk.core.dV.eli()) != null) {
                try {
                    kb = eli2.getPackageName();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.Xb.eli("TTAD.ToolUtils", "ToolUtils getPackageName throws exception :", th);
                }
            }
            str = kb;
        }
        return str;
    }

    public static synchronized String kb() {
        String str;
        synchronized (dZ.class) {
            if (TextUtils.isEmpty(wC) && com.bytedance.sdk.openadsdk.core.dV.eli() != null) {
                try {
                    PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.dV.eli().getPackageManager().getPackageInfo(MGA(), 0);
                    wC = String.valueOf(packageInfo.versionCode);
                    FC = packageInfo.versionName;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.Xb.eli("TTAD.ToolUtils", "ToolUtils getVersionCode throws exception :", th);
                }
            }
            str = wC;
        }
        return str;
    }

    public static synchronized String wC() {
        String str;
        synchronized (dZ.class) {
            if (TextUtils.isEmpty(FC) && com.bytedance.sdk.openadsdk.core.dV.eli() != null) {
                try {
                    PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.dV.eli().getPackageManager().getPackageInfo(MGA(), 0);
                    wC = String.valueOf(packageInfo.versionCode);
                    FC = packageInfo.versionName;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.Xb.eli("TTAD.ToolUtils", "ToolUtils getVersionName throws exception :", th);
                }
            }
            str = FC;
        }
        return str;
    }

    public static String eli(Context context) {
        String DbA2 = com.bytedance.sdk.openadsdk.core.Os.eli().DbA("total_memory", (String) null);
        if (DbA2 != null && DbA(DbA2) > 0) {
            return DbA2;
        }
        String Os2 = Os("MemTotal");
        if (DbA(Os2) <= 0) {
            Os2 = FC();
        }
        com.bytedance.sdk.openadsdk.core.Os.eli().eli("total_memory", Os2);
        return Os2;
    }

    public static long DbA(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String FC() {
        try {
            ActivityManager activityManager = (ActivityManager) com.bytedance.sdk.openadsdk.core.dV.eli().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            if (memoryInfo.totalMem > 0) {
                return String.valueOf(memoryInfo.totalMem / 1024);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String aAs() {
        return com.bytedance.sdk.openadsdk.core.Os.eli().DbA("total_memory", "0");
    }

    public static String du() {
        return Os("MemTotal");
    }

    public static String Os(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String readLine;
        try {
            fileReader = new FileReader(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MEM_INFO);
            try {
                bufferedReader = new BufferedReader(fileReader, 4096);
                do {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            com.bytedance.sdk.component.utils.Xb.Os("TTAD.ToolUtils", th.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            return null;
                        } finally {
                        }
                    }
                } while (!readLine.contains(str));
                if (readLine == null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused4) {
                    }
                    return null;
                }
                String str2 = readLine.split("\\s+")[1];
                try {
                    bufferedReader.close();
                } catch (Exception unused5) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused6) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static long DbA(Context context) {
        return com.bytedance.sdk.openadsdk.core.Os.eli().DbA("total_internal_storage", 0L).longValue();
    }

    public static long nlS() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long NU() {
        return com.bytedance.sdk.openadsdk.core.Os.eli().DbA("free_internal_storage", 0L).longValue();
    }

    public static long nn() {
        return com.bytedance.sdk.openadsdk.core.Os.eli().DbA("total_sdcard_storage", 0L).longValue();
    }

    public static long Dfc() {
        try {
            if (!cyF()) {
                return 0L;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.ToolUtils", th.getMessage());
            return 0L;
        }
    }

    private static boolean cyF() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int aqO() {
        return com.bytedance.sdk.openadsdk.core.Os.eli().DbA("is_root", -1);
    }

    public static boolean dV() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String aGH(String str) {
        return eli(str, false, false);
    }

    public static String eli(String str, boolean z, boolean z2) {
        String nGm;
        if (str != null && !str.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            str = RemoteSettings.FORWARD_SLASH_STRING.concat(String.valueOf(str));
        }
        if (z2) {
            nGm = Xb();
        } else {
            nGm = nGm();
        }
        if (TextUtils.isEmpty(nGm)) {
            nGm = "api16-access-ttp.tiktokpangle.us";
        }
        String str2 = "https://" + nGm + str;
        if (Cp.eli() && !z) {
            str2 = Cp.eli(str2);
        }
        return z ? nlS(str2) : str2;
    }

    public static String nGm() {
        String KM = com.bytedance.sdk.openadsdk.core.dV.aGH().KM();
        return TextUtils.isEmpty(KM) ? bf.eli() : KM;
    }

    public static String QX() {
        String PfW = com.bytedance.sdk.openadsdk.core.dV.aGH().PfW();
        if (!TextUtils.isEmpty(PfW)) {
            return PfW;
        }
        String eli2 = bf.eli();
        return !TextUtils.isEmpty(eli2) ? "https://" + eli2 + "/service/2/dual_events/" : PfW;
    }

    public static String Xb() {
        String QMZ = com.bytedance.sdk.openadsdk.core.settings.NU.QMZ();
        if (!TextUtils.isEmpty(QMZ)) {
            return QMZ;
        }
        String VM = com.bytedance.sdk.openadsdk.core.dV.aGH().VM();
        return TextUtils.isEmpty(VM) ? bf.eli() : VM;
    }

    private static String nlS(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter(C3114ha.b, "1371").appendQueryParameter("device_platform", "android").appendQueryParameter("version_code", kb()).toString();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.ToolUtils", e.getMessage());
            return str;
        }
    }

    public static String ui(String str) {
        if (TextUtils.isEmpty(str)) {
            str = com.bytedance.sdk.openadsdk.core.dV.aGH().GB();
        }
        if (TextUtils.isEmpty(str)) {
            return "https://api16-access-ttp.tiktokpangle.us/service/2/app_log/";
        }
        return !str.startsWith("http") ? "https://".concat(String.valueOf(str)) : str;
    }

    public static String bf() {
        return String.format(Constants.BASE_URL_NO_SUB_DOMAIN_FORMAT, "log.byteoversea.com/service/2/app_log_test/");
    }

    public static String CMM() {
        return "https://lf-static.tiktokpangle-cdn-us.com/obj/ad-pattern-tx/renderer/package_tx.json";
    }

    public static String ev() {
        try {
            return TimeZone.getDefault().getID();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.ToolUtils", e.toString());
            return "";
        }
    }

    public static int Vy() {
        try {
            String id = TimeZone.getDefault().getID();
            if (aAs.contains(id)) {
                return 2;
            }
            if (id != null && id.startsWith("Asia/")) {
                return 2;
            }
            if (id != null && id.startsWith("Europe/")) {
                return 4;
            }
            if (id == null || !id.startsWith("America/")) {
                return 3;
            }
            return !du.contains(id) ? 5 : 3;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.ToolUtils", th.toString());
            return 0;
        }
    }

    public static String Os(Context context) {
        try {
            return context.getResources().getConfiguration().getLocales().get(0).getLanguage();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.ToolUtils", e.toString());
            return "";
        }
    }

    public static int gG() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / Constants.ONE_HOUR;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static String ujq() {
        int i = -gG();
        if (i >= 0) {
            return "Etc/GMT+".concat(String.valueOf(i));
        }
        return "Etc/GMT".concat(String.valueOf(i));
    }

    public static JSONObject eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, long j, com.bykv.vk.openvk.eli.eli.eli.eli eliVar) {
        if (evVar == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CampaignEx.JSON_KEY_CREATIVE_ID, evVar.umh());
            jSONObject.put("buffers_time", j);
            com.bykv.vk.openvk.eli.eli.eli.Os.DbA nY = evVar.nY();
            if (nY != null) {
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_SIZE, nY.ui());
                jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, nY.FC());
            }
            eli(jSONObject, eliVar);
            return jSONObject;
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.Xb.eli("TTAD.ToolUtils", "getVideoAction json error", e);
            return jSONObject;
        }
    }

    private static void eli(JSONObject jSONObject, com.bykv.vk.openvk.eli.eli.eli.eli eliVar) {
        if (jSONObject.has(CampaignEx.JSON_KEY_VIDEO_RESOLUTION) || eliVar == null) {
            return;
        }
        try {
            jSONObject.put(CampaignEx.JSON_KEY_VIDEO_RESOLUTION, String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(eliVar.aGH()), Integer.valueOf(eliVar.ui())));
        } catch (Throwable unused) {
        }
    }

    public static boolean MGA(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, String str) {
        if (evVar != null) {
            try {
                String dM = evVar.dM();
                if (TextUtils.isEmpty(dM) && evVar.Eh() != null && evVar.Eh().Os() == 1 && !TextUtils.isEmpty(evVar.Eh().DbA())) {
                    dM = evVar.Eh().DbA();
                }
                String str2 = dM;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.Cp.eli(com.bytedance.sdk.openadsdk.core.dV.eli(), str2, evVar, eli(str), str, false);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean Os(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        if (evVar == null) {
            return true;
        }
        int DbA2 = com.bytedance.sdk.openadsdk.core.dV.aGH().DbA(evVar.RTg());
        int Os2 = com.bytedance.sdk.component.utils.nGm.Os(com.bytedance.sdk.openadsdk.core.dV.eli());
        if (DbA2 == 1) {
            return aGH(Os2);
        }
        if (DbA2 == 2) {
            return ui(Os2) || aGH(Os2) || MGA(Os2);
        }
        if (DbA2 != 3) {
            return DbA2 != 5 || aGH(Os2) || MGA(Os2);
        }
        return false;
    }

    public static String kb(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }

    public static void eli(String str, String str2, Context context) {
        int i;
        if (TextUtils.isEmpty(str2) || !ui(context)) {
            return;
        }
        int length = str2.length();
        int i2 = 1;
        if (length % 3572 == 0) {
            i = length / 3572;
        } else {
            i = (length / 3572) + 1;
        }
        int i3 = 3572;
        int i4 = 0;
        while (i2 <= i) {
            if (i3 < length) {
                Log.d(str, i + "-" + i2 + ":" + str2.substring(i4, i3));
                i2++;
                i4 = i3;
                i3 += 3572;
            } else {
                Log.d(str, i + "-" + i2 + ":" + str2.substring(i4));
                return;
            }
        }
    }

    public static boolean ui(Context context) {
        if (context == null) {
            return false;
        }
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static int MGA(Context context) {
        int i = -1;
        try {
            i = context.getApplicationInfo().targetSdkVersion;
            new Object[]{"targetSdkVersion = ", Integer.valueOf(i)};
            return i;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.ToolUtils", th.getMessage());
            return i;
        }
    }

    public static long kb(Context context) {
        int i = -1;
        try {
            i = context.getApplicationInfo().minSdkVersion;
            new Object[]{"minSdkVersion = ", Integer.valueOf(i)};
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.ToolUtils", th.getMessage());
        }
        return i;
    }

    public static void wC(final String str) {
        com.bytedance.sdk.openadsdk.Dfc.Os.eli();
        com.bytedance.sdk.openadsdk.Dfc.Os.eli("reportMultiLog", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.utils.dZ.3
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                if (dZ.Os || !com.bytedance.sdk.openadsdk.core.dV.aGH().tGZ()) {
                    return null;
                }
                boolean unused = dZ.Os = true;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error", str);
                return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("reportMultiLog").DbA(jSONObject.toString());
            }
        });
    }

    public static boolean FC(String str) {
        if (com.bytedance.sdk.openadsdk.core.nn.ui()) {
            return true;
        }
        com.bytedance.sdk.component.utils.Xb.Os("You must use method '" + str + "' after initialization, please check.", new Object[0]);
        return false;
    }

    public static void aAs(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return;
        }
        com.bytedance.sdk.component.utils.Xb.Os("You should use method '" + str + "' on the asynchronous thread,it may cause anr, please check.", new Object[0]);
    }

    public static int wC(Context context) {
        return kb(com.bytedance.sdk.component.utils.ujq.eli(context, 0L));
    }

    public static boolean Ue() {
        return aGH.get() == 1;
    }

    public static void FC(Context context) {
        try {
            AtomicInteger atomicInteger = aGH;
            if (atomicInteger.get() != 0) {
                return;
            }
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            boolean isEnabled = accessibilityManager.isEnabled();
            boolean isTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
            if (isEnabled && isTouchExplorationEnabled) {
                atomicInteger.set(1);
                com.bytedance.sdk.openadsdk.Dfc.Os.eli().Os();
            } else {
                atomicInteger.set(2);
            }
        } catch (Exception unused) {
            aGH.set(2);
        }
    }

    public static boolean wC(int i) {
        if (i <= 0) {
            return false;
        }
        return i >= 100 || new Random(System.currentTimeMillis()).nextInt(100) + 1 <= i;
    }

    public static void eli(StringBuilder sb, String str, String str2) {
        int indexOf;
        if (sb == null || TextUtils.isEmpty(str) || (indexOf = sb.indexOf(str)) <= 0) {
            return;
        }
        sb.replace(indexOf, str.length() + indexOf, str2);
    }

    public static int aAs(Context context) {
        List<ResolveInfo> queryIntentActivities;
        Integer num = eli;
        if (num != null) {
            return num.intValue();
        }
        if (context == null || (queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("https://www.example.com")), 0)) == null) {
            return 0;
        }
        Integer valueOf = Integer.valueOf(queryIntentActivities.size());
        eli = valueOf;
        return valueOf.intValue();
    }

    public static com.bytedance.sdk.openadsdk.common.aGH eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, com.bytedance.sdk.component.FC.MGA mga, Context context, String str) {
        int XlF = evVar.XlF();
        if (evVar == null || !evVar.OJ()) {
            return null;
        }
        if (XlF != 1 && XlF != 3) {
            return null;
        }
        mga.eli(true, (View) new com.bytedance.sdk.openadsdk.common.Os(context));
        return new com.bytedance.sdk.openadsdk.common.aGH(evVar, mga, str, false);
    }

    public static void eli(JSONObject jSONObject) {
        int intValue;
        try {
            Pair<String, Long> aGH2 = com.bytedance.sdk.openadsdk.core.FC.aGH("oem_store");
            int i = -1;
            if (aGH2 != null && ((intValue = Integer.valueOf((String) aGH2.first).intValue()) != -2 || System.currentTimeMillis() - ((Long) aGH2.second).longValue() < com.bytedance.sdk.openadsdk.bf.eli.eli("oem_store_state_time", 259200000))) {
                i = intValue;
            }
            jSONObject.put("oem_store", i);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.ToolUtils", th.getMessage());
        }
    }

    public static void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, com.bytedance.sdk.component.FC.MGA mga) {
        eli(evVar, mga, false);
    }

    public static void eli(com.bytedance.sdk.openadsdk.core.model.ev evVar, com.bytedance.sdk.component.FC.MGA mga, boolean z) {
        com.bytedance.sdk.component.FC.MGA mga2;
        com.bytedance.sdk.openadsdk.core.model.wC Xb;
        List<Integer> list;
        if (evVar == null || mga == null) {
            return;
        }
        int XlF = evVar.XlF();
        if (!evVar.OJ() || (!(XlF == 2 || XlF == 3 || XlF == 5) || (Xb = evVar.Xb()) == null)) {
            mga2 = mga;
        } else {
            List<Integer> ui2 = Xb.ui();
            ArrayList arrayList = new ArrayList();
            if (z) {
                for (int i = 0; i < ui2.size(); i++) {
                    arrayList.add(Integer.valueOf(ui2.get(i).intValue() - 1));
                }
                list = arrayList;
            } else {
                list = ui2;
            }
            mga2 = mga;
            mga2.eli(true, Xb.Os(), Xb.aGH(), list, Xb.MGA(), Xb.DbA());
        }
        int mWE = evVar.mWE();
        long aak = evVar.aak();
        if ((mWE == 1 || mWE == 2) && aak > 0) {
            mga2.eli(mWE, aak);
        }
    }

    public static boolean aGH(com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        return evVar != null && evVar.yw() == 3 && evVar.OJ() && (evVar.XlF() == 4 || evVar.XlF() == 5);
    }

    public static String KM() {
        String str = nn;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = new String(nlS);
        nn = str2;
        return str2;
    }

    public static String VM() {
        String str = Dfc;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = new String(NU);
        Dfc = str2;
        return str2;
    }

    public static int eli(WebView webView) {
        if (webView == null) {
            return -1;
        }
        try {
            WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
            int size = copyBackForwardList.getSize();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < size; i++) {
                WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(i);
                if (itemAtIndex != null) {
                    String url = itemAtIndex.getUrl();
                    if (!arrayList.contains(url)) {
                        arrayList.add(url);
                    }
                }
            }
            return arrayList.indexOf(webView.getUrl()) + 1;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.ToolUtils", th.toString());
            return -1;
        }
    }

    public static JSONObject eli(AdSlot adSlot) {
        JSONObject jSONObject = new JSONObject();
        if (adSlot != null) {
            try {
                jSONObject.put("is_sb", !TextUtils.isEmpty(adSlot.getBidAdm()));
            } catch (Throwable unused) {
            }
        }
        return jSONObject;
    }

    public static int GB() {
        return Os.eli;
    }

    private static class Os {
        private static final int eli;

        static {
            Class<?> cls;
            com.bytedance.sdk.component.utils.Xb.eli("TTAD.ToolUtils", "init hasBindingAdapterPositionMethod start status = 0");
            int i = 2;
            try {
                cls = Class.forName("androidx.recyclerview.widget.RecyclerView$ViewHolder");
            } catch (ClassNotFoundException unused) {
            } catch (NoSuchMethodException unused2) {
            }
            if (cls != null) {
                if (cls.getDeclaredMethod("getBindingAdapterPosition", new Class[0]) != null) {
                    i = 0;
                }
                eli = i;
                com.bytedance.sdk.component.utils.Xb.eli("TTAD.ToolUtils", "init hasBindingAdapterPositionMethod end status = ".concat(String.valueOf(i)));
            }
            i = 1;
            eli = i;
            com.bytedance.sdk.component.utils.Xb.eli("TTAD.ToolUtils", "init hasBindingAdapterPositionMethod end status = ".concat(String.valueOf(i)));
        }
    }
}
