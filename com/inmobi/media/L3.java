package com.inmobi.media;

import android.app.NotificationManager;
import android.app.usage.StorageStatsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import androidx.autofill.HintConstants;
import com.ironsource.C3040d4;
import com.ironsource.C3251pc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public final class L3 {
    public static String d;
    public static final C2932x1 e;
    public static final C2932x1 f;
    public static final String g;
    public static final Pair h;
    public static final String i;
    public static final String j;
    public static final /* synthetic */ KProperty[] b = {Reflection.property1(new PropertyReference1Impl(L3.class, "maxDeviceVolume", "getMaxDeviceVolume()I", 0)), Reflection.property1(new PropertyReference1Impl(L3.class, "curDeviceVolume", "getCurDeviceVolume()I", 0))};

    /* renamed from: a, reason: collision with root package name */
    public static final L3 f2348a = new L3();
    public static long c = -1;

    static {
        int i2 = 15;
        e = new C2932x1((Integer) i2, (Function0) K3.f2334a, false, 12);
        f = new C2932x1((Integer) i2, (Function0) J3.f2322a, true, 8);
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        g = RELEASE;
        h = new Pair("d-api-lev", "" + Build.VERSION.SDK_INT);
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        i = MANUFACTURER;
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        j = MODEL;
    }

    @JvmStatic
    public static final boolean G() {
        return true;
    }

    @JvmStatic
    public static final boolean I() {
        return true;
    }

    public static void K() {
        Uc.a(new Runnable() { // from class: com.inmobi.media.L3$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                L3.L();
            }
        });
    }

    public static final void L() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            long availableBytes = statFs.getAvailableBytes();
            long availableBytes2 = statFs2.getAvailableBytes() + availableBytes;
            if (Environment.getExternalStorageState().equals("mounted")) {
                availableBytes = availableBytes2;
            }
            c = availableBytes / 1048576;
        } catch (Exception e2) {
            C2640f2 event = new C2640f2(e2);
            S5 s5 = S5.f2425a;
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
        }
    }

    public static void M() {
        Uc.a(new Runnable() { // from class: com.inmobi.media.L3$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                L3.N();
            }
        });
    }

    public static final void N() {
        UUID uuid;
        Context d2 = Uc.d();
        if (d2 == null) {
            return;
        }
        Object systemService = d2.getSystemService("storagestats");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.usage.StorageStatsManager");
        StorageStatsManager storageStatsManager = (StorageStatsManager) systemService;
        Object systemService2 = d2.getSystemService(C3040d4.a.k);
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.os.storage.StorageManager");
        List<StorageVolume> storageVolumes = ((StorageManager) systemService2).getStorageVolumes();
        Intrinsics.checkNotNullExpressionValue(storageVolumes, "getStorageVolumes(...)");
        long j2 = 0;
        for (StorageVolume storageVolume : storageVolumes) {
            String uuid2 = storageVolume.getUuid();
            if (uuid2 == null) {
                uuid = StorageManager.UUID_DEFAULT;
                Intrinsics.checkNotNull(uuid);
            } else {
                try {
                    uuid = UUID.fromString(uuid2);
                    Intrinsics.checkNotNull(uuid);
                } catch (Exception unused) {
                }
            }
            if (storageVolume.getState().equals("mounted")) {
                try {
                    j2 += storageStatsManager.getFreeBytes(uuid);
                } catch (Exception e2) {
                    C2640f2 event = new C2640f2(e2);
                    S5 s5 = S5.f2425a;
                    Intrinsics.checkNotNullParameter(event, "event");
                    S5.d.a(event);
                }
            }
        }
        c = j2 / 1048576;
    }

    public static void O() {
        Uc.a(new Runnable() { // from class: com.inmobi.media.L3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                L3.P();
            }
        });
    }

    public static final void P() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            float blockCountLong = statFs.getBlockCountLong() * statFs.getBlockSizeLong();
            float blockCountLong2 = (statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) + blockCountLong;
            if (Environment.getExternalStorageState().equals("mounted")) {
                blockCountLong = blockCountLong2;
            }
            d = "" + (blockCountLong / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        } catch (Exception e2) {
            C2640f2 event = new C2640f2(e2);
            S5 s5 = S5.f2425a;
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
        }
    }

    public static void Q() {
        Uc.a(new Runnable() { // from class: com.inmobi.media.L3$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                L3.R();
            }
        });
    }

    public static final void R() {
        UUID uuid;
        Context d2 = Uc.d();
        if (d2 == null) {
            return;
        }
        Object systemService = d2.getSystemService("storagestats");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.usage.StorageStatsManager");
        StorageStatsManager storageStatsManager = (StorageStatsManager) systemService;
        Object systemService2 = d2.getSystemService(C3040d4.a.k);
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.os.storage.StorageManager");
        List<StorageVolume> storageVolumes = ((StorageManager) systemService2).getStorageVolumes();
        Intrinsics.checkNotNullExpressionValue(storageVolumes, "getStorageVolumes(...)");
        long j2 = 0;
        for (StorageVolume storageVolume : storageVolumes) {
            String uuid2 = storageVolume.getUuid();
            if (uuid2 == null) {
                uuid = StorageManager.UUID_DEFAULT;
                Intrinsics.checkNotNull(uuid);
            } else {
                try {
                    uuid = UUID.fromString(uuid2);
                    Intrinsics.checkNotNull(uuid);
                } catch (Exception unused) {
                }
            }
            if (storageVolume.getState().equals("mounted")) {
                try {
                    j2 += storageStatsManager.getTotalBytes(uuid);
                } catch (Exception e2) {
                    C2640f2 event = new C2640f2(e2);
                    S5 s5 = S5.f2425a;
                    Intrinsics.checkNotNullParameter(event, "event");
                    S5.d.a(event);
                }
            }
        }
        d = "" + (j2 / 1048576);
    }

    public static String o() {
        NetworkCapabilities networkCapabilities;
        Context d2 = Uc.d();
        if (d2 == null || !AbstractC2925wa.a(d2, "android.permission.ACCESS_NETWORK_STATE")) {
            return "";
        }
        Object systemService = d2.getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            return "";
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception e2) {
            Intrinsics.checkNotNullExpressionValue("L3", "getSimpleName(...)");
            e2.toString();
        }
        if (networkInfo == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null) {
            return "";
        }
        return networkCapabilities.hasTransport(0) ? "0|" + networkInfo.getSubtype() : networkCapabilities.hasTransport(1) ? "1" : networkCapabilities.hasTransport(2) ? C3251pc.e : networkCapabilities.hasTransport(3) ? "9" : networkCapabilities.hasTransport(4) ? "17" : networkCapabilities.hasTransport(5) ? "10" : networkCapabilities.hasTransport(6) ? "11" : "8";
    }

    public static final String q() {
        int p = f2348a.p();
        return p != 0 ? p != 1 ? "NIL" : com.ironsource.Z3.b : com.ironsource.N6.P0;
    }

    @JvmStatic
    public static /* synthetic */ void r() {
    }

    public final boolean A() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public final boolean B() {
        return Build.VERSION.SDK_INT >= 33;
    }

    public final boolean C() {
        return Build.VERSION.SDK_INT >= 34;
    }

    public final boolean D() {
        return Build.VERSION.SDK_INT >= 35;
    }

    public final boolean E() {
        return true;
    }

    public final boolean F() {
        return true;
    }

    public final boolean H() {
        return true;
    }

    public final boolean J() {
        return true;
    }

    public final int a(Context context, boolean z) {
        if (context == null || z) {
            return 0;
        }
        int intValue = ((Number) f.getValue(this, b[1])).intValue();
        int m = m();
        if (m > 0) {
            return (intValue * 100) / m;
        }
        Intrinsics.checkNotNullExpressionValue("L3", "getSimpleName(...)");
        return 0;
    }

    public final Pair<String, String> b() {
        Context d2 = Uc.d();
        if (d2 == null) {
            return null;
        }
        return Settings.Global.getInt(d2.getContentResolver(), "airplane_mode_on", 0) != 0 ? new Pair<>("d-airplane-m", "1") : new Pair<>("d-airplane-m", "0");
    }

    public final Pair<String, String> c() {
        return h;
    }

    public final long e() {
        return c;
    }

    public final Pair<String, String> f() {
        Context d2 = Uc.d();
        if (d2 == null) {
            return null;
        }
        Intent a2 = B2.a(d2, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return new Pair<>("d-bat-chrg", (a2 != null ? a2.getIntExtra("status", -1) : -1) == 2 ? "1" : "0");
    }

    public final Pair<String, String> g() {
        Context d2 = Uc.d();
        Integer num = null;
        if (d2 == null) {
            return null;
        }
        if (B2.a(d2, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED")) != null) {
            num = Integer.valueOf((int) ((r0.getIntExtra("level", -1) * 100) / r0.getIntExtra("scale", -1)));
        }
        return new Pair<>("d-bat-lev", "" + num);
    }

    public final Pair<String, String> h() {
        Context d2 = Uc.d();
        if (d2 == null) {
            return null;
        }
        Object systemService = d2.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) systemService).isPowerSaveMode() ? new Pair<>("d-bat-sav", "1") : new Pair<>("d-bat-sav", "0");
    }

    public final Pair<String, String> i() {
        String str;
        int i2 = Resources.getSystem().getConfiguration().uiMode & 48;
        if (i2 == 16) {
            str = "0";
        } else {
            if (i2 != 32) {
                return null;
            }
            str = "1";
        }
        return new Pair<>("d-drk-m", str);
    }

    public final Pair<String, String> j() {
        Context d2 = Uc.d();
        if (d2 == null) {
            return null;
        }
        Object systemService = d2.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        try {
            int currentInterruptionFilter = ((NotificationManager) systemService).getCurrentInterruptionFilter();
            return new Pair<>("d-dnd", (currentInterruptionFilter == 2 || currentInterruptionFilter == 3 || currentInterruptionFilter == 4) ? "1" : "0");
        } catch (Exception unused) {
            return null;
        }
    }

    public final Pair<String, String> k() {
        ArrayList arrayList = new ArrayList();
        Context d2 = Uc.d();
        if (d2 == null) {
            return null;
        }
        Object systemService = d2.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        List<InputMethodInfo> enabledInputMethodList = inputMethodManager.getEnabledInputMethodList();
        Intrinsics.checkNotNullExpressionValue(enabledInputMethodList, "getEnabledInputMethodList(...)");
        Iterator<InputMethodInfo> it = enabledInputMethodList.iterator();
        while (it.hasNext()) {
            List<InputMethodSubtype> enabledInputMethodSubtypeList = inputMethodManager.getEnabledInputMethodSubtypeList(it.next(), true);
            Intrinsics.checkNotNullExpressionValue(enabledInputMethodSubtypeList, "getEnabledInputMethodSubtypeList(...)");
            for (InputMethodSubtype inputMethodSubtype : enabledInputMethodSubtypeList) {
                if (Intrinsics.areEqual(inputMethodSubtype.getMode(), "keyboard")) {
                    String languageTag = inputMethodSubtype.getLanguageTag();
                    Intrinsics.checkNotNullExpressionValue(languageTag, "getLanguageTag(...)");
                    String language = languageTag.length() > 0 ? Locale.forLanguageTag(inputMethodSubtype.getLanguageTag()).getLanguage() : new Locale(inputMethodSubtype.getLocale()).getLanguage();
                    Intrinsics.checkNotNull(language);
                    if (language.length() > 0) {
                        arrayList.add(language);
                    }
                }
            }
        }
        String jSONArray = new JSONArray((Collection) arrayList).toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "toString(...)");
        return new Pair<>("d-key-lang", jSONArray);
    }

    public final String l() {
        return i;
    }

    public final int m() {
        return ((Number) e.getValue(this, b[0])).intValue();
    }

    public final String n() {
        return j;
    }

    public final int p() {
        String o = o();
        if (StringsKt.startsWith$default(o, "0", false, 2, (Object) null)) {
            return 0;
        }
        return StringsKt.startsWith$default(o, "1", false, 2, (Object) null) ? 1 : 2;
    }

    public final String s() {
        return g;
    }

    public final Pair<String, String> u() {
        Context d2 = Uc.d();
        if (d2 == null) {
            return null;
        }
        Intent a2 = B2.a(d2, (BroadcastReceiver) null, new IntentFilter("android.intent.action.HEADSET_PLUG"));
        return (a2 == null || a2.getIntExtra("state", 0) != 1) ? new Pair<>("d-w-h", "0") : new Pair<>("d-w-h", "1");
    }

    public final void v() {
        d();
        t();
        m();
    }

    public final boolean w() {
        return true;
    }

    public final boolean x() {
        return true;
    }

    public final boolean y() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public final boolean z() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public final Pair<String, String> d() {
        M();
        if (c != -1) {
            return new Pair<>("d-av-disk", String.valueOf(c));
        }
        return null;
    }

    public final Pair<String, String> t() {
        Q();
        String str = d;
        if (str != null) {
            return new Pair<>("d-tot-disk", str);
        }
        return null;
    }

    public final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        String networkOperatorName = telephonyManager != null ? telephonyManager.getNetworkOperatorName() : null;
        return networkOperatorName == null ? "" : networkOperatorName;
    }

    public final Map<String, String> a(boolean z) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("os-v", g);
            String BRAND = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
            hashMap.put("d-brand-name", BRAND);
            hashMap.put("d-manufacturer-name", i);
            hashMap.put("d-model-name", j);
            hashMap.put("d-nettype-raw", o());
            String locale = Locale.getDefault().toString();
            Intrinsics.checkNotNullExpressionValue(locale, "toString(...)");
            hashMap.put("d-localization", locale);
            String language = Locale.getDefault().getLanguage();
            Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
            hashMap.put("d-language", language);
            hashMap.put("d-media-volume", String.valueOf(a(Uc.d(), z)));
            return hashMap;
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("L3", "getSimpleName(...)");
            return hashMap;
        }
    }

    public final I3 a() {
        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long freeMemory = runtime.freeMemory();
        return new I3(maxMemory, freeMemory, maxMemory - freeMemory);
    }
}
