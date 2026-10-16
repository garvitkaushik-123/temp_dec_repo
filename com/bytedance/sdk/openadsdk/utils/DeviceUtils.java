package com.bytedance.sdk.openadsdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.sdk.openadsdk.core.settings.nlS;
import com.bytedance.sdk.openadsdk.utils.kb;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.ironsource.N6;
import com.pgl.ssdk.ces.out.PglSSConfig;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import io.bidmachine.Framework;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DeviceUtils {
    private static int Dfc = 0;
    private static int FC = 0;
    private static int NU = 0;
    private static int aqO = 0;
    public static String eli = "";
    private static int nn;
    private static int wC;
    private static volatile long DbA = System.currentTimeMillis();
    private static volatile boolean Os = false;
    private static volatile boolean aGH = false;
    private static volatile boolean ui = false;
    private static volatile boolean MGA = true;
    private static long kb = 0;
    private static String aAs = "";
    private static int du = 0;
    private static final AtomicBoolean nlS = new AtomicBoolean(false);
    private static AtomicBoolean dV = new AtomicBoolean(false);

    public static void eli(Context context) {
        if (Os) {
            return;
        }
        try {
            DbA dbA = new DbA();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            context.getApplicationContext().registerReceiver(dbA, intentFilter);
            Os = true;
        } catch (Throwable unused) {
        }
    }

    public static long eli() {
        return DbA;
    }

    public static boolean DbA() {
        if (SystemClock.elapsedRealtime() - kb >= 20000) {
            kb = SystemClock.elapsedRealtime();
            try {
                PowerManager powerManager = (PowerManager) com.bytedance.sdk.openadsdk.core.dV.eli().getSystemService("power");
                if (powerManager != null) {
                    MGA = powerManager.isInteractive();
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.Xb.Os("TTAD.DeviceUtils", th.getMessage());
            }
        }
        return MGA;
    }

    public static boolean DbA(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static boolean Os(Context context) {
        return (context.getResources().getConfiguration().uiMode & 15) == 4;
    }

    public static int aGH(Context context) {
        if (Os(context)) {
            return 3;
        }
        return DbA(context) ? 2 : 1;
    }

    private static void eli(JSONObject jSONObject) throws JSONException {
        DbA(jSONObject);
    }

    private static void DbA(JSONObject jSONObject) throws JSONException {
        jSONObject.put(N6.B, Build.MODEL);
        com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().eli(jSONObject);
    }

    public static String ui(Context context) {
        if (!nlS.get()) {
            Dfc(context);
        }
        return aAs;
    }

    public static int MGA(Context context) {
        if (!nlS.get()) {
            Dfc(context);
        }
        return du;
    }

    private static void Dfc(Context context) {
        if (context == null || !nlS.compareAndSet(false, true)) {
            return;
        }
        try {
            if (com.bytedance.sdk.openadsdk.bf.eli.eli("gp_v_enable", 0) == 1) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.android.vending", 0);
                aAs = packageInfo.versionName;
                du = packageInfo.versionCode;
            }
        } catch (Throwable unused) {
        }
    }

    public static JSONObject eli(Context context, boolean z) {
        String aAs2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sys_adb_status", wC(context));
            eli(jSONObject);
            jSONObject.put("type", aGH(context));
            jSONObject.put(N6.F, 1);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put(VastAttributes.VENDOR, Build.MANUFACTURER);
            jSONObject.put("conn_type", dZ.wC(context));
            jSONObject.put("app_set_id", com.bytedance.sdk.openadsdk.core.settings.aGH.Os());
            jSONObject.put("app_set_id_scope", com.bytedance.sdk.openadsdk.core.settings.aGH.DbA());
            jSONObject.put("installed_source", com.bytedance.sdk.openadsdk.core.settings.aGH.aGH());
            jSONObject.put("screen_scale", SSo.MGA(context));
            jSONObject.put("density", SSo.wC(context));
            jSONObject.put("screen_width", SSo.Os(context));
            jSONObject.put("screen_height", SSo.ui(context));
            jSONObject.put("sec_did", com.bytedance.sdk.openadsdk.core.FC.Os.MGA());
            com.bytedance.sdk.openadsdk.core.settings.MGA aGH2 = com.bytedance.sdk.openadsdk.core.dV.aGH();
            if (aGH2.ujq("boot")) {
                jSONObject.put("boot", String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
                jSONObject.put("power_on_time", String.valueOf(SystemClock.elapsedRealtime()));
            }
            jSONObject.put("uuid", com.bytedance.sdk.openadsdk.core.nlS.Os(context));
            jSONObject.put("rom_version", Ue.eli());
            jSONObject.put("sys_compiling_time", com.bytedance.sdk.openadsdk.core.nlS.DbA(context));
            jSONObject.put("timezone", dZ.ujq());
            jSONObject.put("language", com.bytedance.sdk.openadsdk.core.nlS.DbA());
            jSONObject.put("carrier_name", VM.eli());
            if (z) {
                aAs2 = dZ.eli(context);
            } else {
                aAs2 = dZ.aAs();
            }
            jSONObject.put("total_mem", String.valueOf(Long.parseLong(aAs2) * 1024));
            jSONObject.put("locale_language", aGH());
            jSONObject.put("screen_bright", Math.ceil(ui() * 10.0f) / 10.0d);
            jSONObject.put("is_screen_off", 1 ^ (DbA() ? 1 : 0));
            jSONObject.put("cpu_num", aAs.DbA());
            jSONObject.put("cpu_max_freq", aAs.Os());
            jSONObject.put("cpu_min_freq", aAs.aGH());
            kb.eli eli2 = kb.eli();
            jSONObject.put("battery_remaining_pct", (int) eli2.DbA);
            jSONObject.put("is_charging", eli2.eli);
            jSONObject.put("total_space", String.valueOf(dZ.DbA(context)));
            jSONObject.put("free_space_in", String.valueOf(dZ.NU()));
            jSONObject.put("sdcard_size", String.valueOf(dZ.nn()));
            jSONObject.put("rooted", dZ.aqO());
            jSONObject.put("enable_assisted_clicking", MGA());
            jSONObject.put("force_language", com.bytedance.sdk.component.utils.ev.eli(context, "tt_choose_language"));
            jSONObject.put("airplane", FC(context));
            jSONObject.put("darkmode", aqO(context));
            jSONObject.put(BidTokenRepositoryKt.HEADSET, dV(context));
            jSONObject.put("ringmute", aAs(context));
            jSONObject.put("screenscale", nGm(context));
            jSONObject.put("volume", wC());
            jSONObject.put("low_power_mode", QX(context));
            jSONObject.put("enable_draw_feed", dZ.GB());
            if (z) {
                wC.eli(jSONObject, context);
                jSONObject.put("gp_v_name", ui(context));
                jSONObject.put("gp_v_code", MGA(context));
            }
            if (aGH2.ujq("mnc")) {
                jSONObject.put("mnc", VM.Os());
            }
            if (aGH2.ujq("mcc")) {
                jSONObject.put("mcc", VM.DbA());
            }
            jSONObject.put("act", com.bytedance.sdk.openadsdk.core.act.eli.DbA(context));
            jSONObject.put("act_event", com.bytedance.sdk.openadsdk.core.act.eli.eli());
            String Os2 = com.bytedance.sdk.openadsdk.core.FC.Os.Os();
            new Object[]{"getEnvcodeForBidding:", Long.valueOf(com.bytedance.sdk.openadsdk.core.FC.Os.aGH())};
            if (!TextUtils.isEmpty(Os2)) {
                jSONObject.put("sof_chara", Os2);
            }
            String DbA2 = com.bytedance.sdk.openadsdk.multipro.aGH.aGH.DbA("ttopenadsdk", PglSSConfig.CUSTOMINFO_KEY_IPV6, "");
            if (!DbA2.isEmpty()) {
                jSONObject.put("ipv6", DbA2);
            }
            jSONObject.put("is_multi", com.bytedance.sdk.openadsdk.multipro.DbA.Os());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static JSONObject kb(Context context) {
        return eli(context, false);
    }

    public static int Os() {
        return com.bytedance.sdk.openadsdk.core.Os.eli().DbA("limit_ad_track", -1);
    }

    public static String aGH() {
        String languageTag = Locale.getDefault().toLanguageTag();
        return !TextUtils.isEmpty(languageTag) ? languageTag : "";
    }

    public static float ui() {
        int i = -1;
        try {
            Context eli2 = com.bytedance.sdk.openadsdk.core.dV.eli();
            if (eli2 != null) {
                i = Settings.System.getInt(eli2.getContentResolver(), "screen_brightness", -1);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.DeviceUtils", th.getMessage());
        }
        if (i < 0) {
            return -1.0f;
        }
        return Math.round((i / 255.0f) * 10.0f) / 10.0f;
    }

    public static int MGA() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) com.bytedance.sdk.openadsdk.core.dV.eli().getSystemService("accessibility");
        if (accessibilityManager == null) {
            return -1;
        }
        return accessibilityManager.isEnabled() ? 1 : 0;
    }

    public static int wC(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", -1);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("TTAD.DeviceUtils", th.getMessage());
            return -1;
        }
    }

    public static int FC(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0 ? 1 : 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static int aqO(Context context) {
        int i;
        try {
            i = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        } catch (Throwable unused) {
        }
        if (i == 32) {
            return 1;
        }
        return i == 16 ? 0 : -1;
    }

    private static int dV(Context context) {
        return Dfc;
    }

    public static int aAs(Context context) {
        return wC;
    }

    private static float nGm(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int kb() {
        return NU;
    }

    public static int wC() {
        return nn;
    }

    public static int FC() {
        return FC;
    }

    private static int QX(Context context) {
        return aqO;
    }

    public static String aAs() {
        if (TextUtils.isEmpty(eli)) {
            eli = com.bytedance.sdk.openadsdk.core.Os.eli().DbA("framework_name", "");
        }
        return eli;
    }

    public static void du() {
        com.bytedance.sdk.openadsdk.core.settings.NU.eli(new nlS.eli() { // from class: com.bytedance.sdk.openadsdk.utils.DeviceUtils.1
            @Override // com.bytedance.sdk.openadsdk.core.settings.nlS.eli
            public void eli() {
                com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().eli(true);
            }

            @Override // com.bytedance.sdk.openadsdk.core.settings.nlS.eli
            public void DbA() {
                com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().eli(true);
            }
        });
        Context eli2 = com.bytedance.sdk.openadsdk.core.dV.eli();
        if (eli2 != null) {
            com.bytedance.sdk.openadsdk.core.Os.eli().eli("cpu_count", aAs.eli());
            com.bytedance.sdk.openadsdk.core.Os.eli().eli("cpu_max_frequency", aAs.eli(aAs.eli()));
            com.bytedance.sdk.openadsdk.core.Os.eli().eli("cpu_min_frequency", aAs.DbA(aAs.eli()));
            String du2 = dZ.du();
            if (du2 != null) {
                com.bytedance.sdk.openadsdk.core.Os.eli().eli("total_memory", du2);
            }
            com.bytedance.sdk.openadsdk.core.Os.eli().eli("total_internal_storage", dZ.nlS());
            com.bytedance.sdk.openadsdk.core.Os.eli().eli("free_internal_storage", com.bytedance.sdk.component.utils.dV.eli());
            com.bytedance.sdk.openadsdk.core.Os.eli().eli("total_sdcard_storage", dZ.Dfc());
            com.bytedance.sdk.openadsdk.core.Os.eli().eli("is_root", dZ.dV() ? 1 : 0);
            if (TextUtils.isEmpty(aAs())) {
                try {
                    Class.forName(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME);
                    eli = Framework.UNITY;
                } catch (ClassNotFoundException unused) {
                    eli = "native";
                }
                com.bytedance.sdk.openadsdk.core.Os.eli().eli("framework_name", eli);
            }
            nlS();
            Xb(eli2);
            aqO = CMM(eli2);
            wC.eli(eli2);
        }
    }

    public static void nlS() {
        try {
            int ringerMode = ((AudioManager) com.bytedance.sdk.openadsdk.core.dV.eli().getSystemService("audio")).getRingerMode();
            if (ringerMode == 2) {
                wC = 1;
            } else if (ringerMode == 1) {
                wC = 2;
            } else {
                wC = 0;
            }
        } catch (Throwable unused) {
        }
    }

    private static void Xb(Context context) {
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            FC = audioManager.getStreamMaxVolume(3);
            int streamVolume = audioManager.getStreamVolume(3);
            NU = streamVolume;
            nn = (int) ((streamVolume / FC) * 100.0d);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bf(Context context) {
        if (context == null) {
            return;
        }
        final Context applicationContext = context.getApplicationContext();
        cyF.DbA(new com.bytedance.sdk.component.wC.wC("DeviceUtils_get_low_power_mode") { // from class: com.bytedance.sdk.openadsdk.utils.DeviceUtils.2
            @Override // java.lang.Runnable
            public void run() {
                int unused = DeviceUtils.aqO = DeviceUtils.CMM(applicationContext);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int CMM(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") && !Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
                return ((PowerManager) context.getSystemService("power")).isPowerSaveMode() ? 1 : 0;
            }
            return ev(context);
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static int ev(Context context) {
        try {
            return Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") ? Settings.System.getInt(context.getContentResolver(), "POWER_SAVE_MODE_OPEN") == 1 ? 1 : 0 : (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") && Settings.System.getInt(context.getContentResolver(), "SmartModeStatus") == 4) ? 1 : 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static void du(Context context) {
        AudioInfoReceiver.DbA(context);
    }

    public static void nlS(Context context) {
        Context applicationContext;
        if (ui || context == null || (applicationContext = context.getApplicationContext()) == null) {
            return;
        }
        try {
            if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
                Vy(applicationContext);
            } else {
                eli.DbA(applicationContext);
            }
            ui = true;
        } catch (Throwable unused) {
        }
    }

    private static void Vy(Context context) {
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        context.getContentResolver().registerContentObserver(Uri.parse("content://settings/system/POWER_SAVE_MODE_OPEN"), false, new ContentObserver(null) { // from class: com.bytedance.sdk.openadsdk.utils.DeviceUtils.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                super.onChange(z);
                DeviceUtils.bf(applicationContext);
            }
        });
    }

    static class DbA extends BroadcastReceiver {
        DbA() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                boolean unused = DeviceUtils.MGA = true;
            } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                boolean unused2 = DeviceUtils.MGA = false;
            } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                long unused3 = DeviceUtils.DbA = System.currentTimeMillis();
            }
        }
    }

    public static class Os extends com.bytedance.sdk.component.wC.wC {
        public Os() {
            super("gaid_task");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.sdk.openadsdk.core.Os] */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1, types: [int] */
        /* JADX WARN: Type inference failed for: r4v3 */
        @Override // java.lang.Runnable
        public void run() {
            ?? r4;
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(com.bytedance.sdk.openadsdk.core.dV.eli());
                if (advertisingIdInfo != null) {
                    boolean isLimitAdTrackingEnabled = advertisingIdInfo.isLimitAdTrackingEnabled();
                    if (isLimitAdTrackingEnabled) {
                        com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().eli(1);
                    }
                    DeviceUtils.DbA(advertisingIdInfo, isLimitAdTrackingEnabled);
                    r4 = isLimitAdTrackingEnabled;
                } else {
                    r4 = -1;
                }
                if (r4 != -1) {
                    com.bytedance.sdk.openadsdk.core.Os.eli().eli("limit_ad_track", r4);
                }
            } catch (IOException e) {
                com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().eli(2);
                com.bytedance.sdk.component.utils.Xb.eli("TTAD.DeviceUtils", "getLmtTask error : signaling connection to Google Play Services failed.", e);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().eli(2);
                com.bytedance.sdk.component.utils.Xb.Os("TTAD.DeviceUtils", th.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void DbA(AdvertisingIdClient.Info info, boolean z) {
        if (z || !com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().Os()) {
            return;
        }
        String id = info.getId();
        String DbA2 = com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().DbA();
        if (!TextUtils.isEmpty(id)) {
            com.bytedance.sdk.openadsdk.QX.eli.DbA.eli.eli().eli(id);
            com.bytedance.sdk.openadsdk.core.FC.Os.eli(id);
        }
        if (DbA2.equals(id)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.nlS.eli();
    }

    public static class AudioInfoReceiver extends BroadcastReceiver {
        static final CopyOnWriteArrayList<com.bytedance.sdk.openadsdk.nlS.wC> eli = new CopyOnWriteArrayList<>();

        /* JADX INFO: Access modifiers changed from: private */
        public static void DbA(Context context) {
            if (DeviceUtils.aGH || context == null) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                context.registerReceiver(new AudioInfoReceiver(), intentFilter, null, com.bytedance.sdk.component.utils.FC.eli());
                boolean unused = DeviceUtils.aGH = true;
            } catch (Throwable unused2) {
            }
        }

        public static void eli(com.bytedance.sdk.openadsdk.nlS.wC wCVar) {
            if (wCVar != null) {
                CopyOnWriteArrayList<com.bytedance.sdk.openadsdk.nlS.wC> copyOnWriteArrayList = eli;
                if (copyOnWriteArrayList.contains(wCVar)) {
                    return;
                }
                copyOnWriteArrayList.add(wCVar);
            }
        }

        public static void DbA(com.bytedance.sdk.openadsdk.nlS.wC wCVar) {
            if (wCVar == null) {
                return;
            }
            eli.remove(wCVar);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            try {
                if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
                    if (intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3) {
                        int unused = DeviceUtils.NU = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
                        if (!eli.isEmpty()) {
                            cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.DeviceUtils.AudioInfoReceiver.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    Iterator<com.bytedance.sdk.openadsdk.nlS.wC> it = AudioInfoReceiver.eli.iterator();
                                    while (it.hasNext()) {
                                        it.next().DbA(DeviceUtils.NU);
                                    }
                                }
                            });
                        }
                        if (DeviceUtils.FC != 0) {
                            int unused2 = DeviceUtils.nn = (int) ((DeviceUtils.NU / DeviceUtils.FC) * 100.0d);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                    int unused3 = DeviceUtils.Dfc = intent.getIntExtra("state", 0);
                }
            } catch (Exception unused4) {
            }
        }
    }

    private static class eli extends BroadcastReceiver {
        private eli() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void DbA(Context context) {
            if (context != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                intentFilter.addAction("huawei.intent.action.POWER_MODE_CHANGED_ACTION");
                if (Build.VERSION.SDK_INT >= 33) {
                    context.registerReceiver(new eli(), intentFilter, 2);
                } else {
                    context.registerReceiver(new eli(), intentFilter);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || context == null) {
                return;
            }
            if ("android.os.action.POWER_SAVE_MODE_CHANGED".equals(intent.getAction())) {
                DeviceUtils.bf(context);
            } else if ("huawei.intent.action.POWER_MODE_CHANGED_ACTION".equals(intent.getAction())) {
                int unused = DeviceUtils.aqO = intent.getIntExtra("state", 0) == 1 ? 1 : 0;
            }
        }
    }
}
