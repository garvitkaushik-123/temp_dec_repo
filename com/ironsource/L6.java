package com.ironsource;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.ironsource.C3040d4;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes6.dex */
public class L6 implements Runnable {
    public static final String M = "sdkVersion";
    public static final String N = "AdvIdOptOutReason";
    private static final int O = 15;
    private static final int P = 840;
    private static final int Q = -720;
    private Context K;

    /* renamed from: a, reason: collision with root package name */
    private final String f2940a = getClass().getSimpleName();
    private final String b = "bundleId";
    private final String c = "advertisingId";
    private final String d = C3040d4.i.M;
    private final String e = "appKey";
    private final String f = Ma.o;
    private final String g = "osVersion";
    private final String h = "connectionType";
    private final String i = "rawConnectionType";
    private final String j = "language";
    private final String k = "deviceOEM";
    private final String l = "deviceModel";
    private final String m = C3040d4.i.r;
    private final String n = Ma.r;
    private final String o = Ma.s;
    private final String p = BidTokenRepositoryKt.BATTERY;
    private final String q = "gmtMinutesOffset";
    private final String r = C3040d4.i.W;
    private final String s = JsonStorageKeyNames.SESSION_ID_KEY;
    private final String t = "pluginType";
    private final String u = "pluginVersion";
    private final String v = "plugin_fw_v";
    private final String w = Ma.u;
    private final String x = Ma.t;
    private final String y = N6.Z0;
    private final String z = Ma.w;
    private final String A = "mcc";
    private final String B = "mnc";
    private final String C = "icc";
    private final String D = "tz";
    private final String E = "auid";
    private final String F = "userLat";
    private final String G = "publisherAPI";
    private final String H = "missingDependencies";
    private final String I = "missingManifest";
    private final String J = "other";
    private final InterfaceC3381x7 L = C3334ub.U().i();

    private L6() {
    }

    private Map<String, Object> a() {
        boolean z;
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(JsonStorageKeyNames.SESSION_ID_KEY, IronSourceUtils.getSessionId());
        String e = e();
        if (!TextUtils.isEmpty(e)) {
            hashMap.put("bundleId", e);
            String b = C1.b(this.K, e);
            if (!TextUtils.isEmpty(b)) {
                hashMap.put(C3040d4.i.W, b);
            }
        }
        hashMap.put("appKey", c());
        String I = this.L.I(this.K);
        String b2 = this.L.b(this.K);
        boolean z2 = false;
        if (TextUtils.isEmpty(I)) {
            I = this.L.M(this.K);
            z = true;
            str = !TextUtils.isEmpty(I) ? IronSourceConstants.TYPE_UUID : "";
        } else {
            str = IronSourceConstants.TYPE_GAID;
            z = false;
        }
        if (!TextUtils.isEmpty(I)) {
            hashMap.put("advertisingId", I);
            hashMap.put(Ma.t, str);
        }
        if (!TextUtils.isEmpty(b2)) {
            z2 = Boolean.parseBoolean(b2);
            hashMap.put(C3040d4.i.M, Boolean.valueOf(z2));
        }
        if (z || z2) {
            hashMap.put(N, a(b2));
        }
        hashMap.put(Ma.o, h());
        if (!TextUtils.isEmpty(b())) {
            hashMap.put("osVersion", b());
        }
        String connectionType = IronSourceUtils.getConnectionType(this.K);
        if (!TextUtils.isEmpty(connectionType)) {
            hashMap.put("connectionType", connectionType);
        }
        String d = C2986a4.d(this.K);
        if (!TextUtils.isEmpty(d)) {
            hashMap.put("rawConnectionType", d);
        }
        hashMap.put("sdkVersion", r());
        String l = l();
        if (!TextUtils.isEmpty(l)) {
            hashMap.put("language", l);
        }
        String g = g();
        if (!TextUtils.isEmpty(g)) {
            hashMap.put("deviceOEM", g);
        }
        String f = f();
        if (!TextUtils.isEmpty(f)) {
            hashMap.put("deviceModel", f);
        }
        String n = n();
        if (!TextUtils.isEmpty(n)) {
            hashMap.put(C3040d4.i.r, n);
        }
        hashMap.put(Ma.s, Long.valueOf(k()));
        hashMap.put(Ma.r, Long.valueOf(i()));
        hashMap.put(BidTokenRepositoryKt.BATTERY, Integer.valueOf(d()));
        int j = j();
        if (a(j)) {
            hashMap.put("gmtMinutesOffset", Integer.valueOf(j));
        }
        String p = p();
        if (!TextUtils.isEmpty(p)) {
            hashMap.put("pluginType", p);
        }
        String q = q();
        if (!TextUtils.isEmpty(q)) {
            hashMap.put("pluginVersion", q);
        }
        String o = o();
        if (!TextUtils.isEmpty(o)) {
            hashMap.put("plugin_fw_v", o);
        }
        String valueOf = String.valueOf(this.L.p());
        if (!TextUtils.isEmpty(valueOf)) {
            hashMap.put(Ma.u, valueOf);
        }
        String m = m();
        if (!TextUtils.isEmpty(m)) {
            hashMap.put(N6.Z0, m);
        }
        String valueOf2 = String.valueOf(IronSourceUtils.getFirstSession(this.K));
        if (!TextUtils.isEmpty(valueOf2)) {
            hashMap.put(Ma.w, valueOf2);
        }
        String d2 = this.L.d(this.K);
        if (!TextUtils.isEmpty(d2)) {
            hashMap.put("auid", d2);
        }
        hashMap.put("mcc", Integer.valueOf(Z3.b(this.K)));
        hashMap.put("mnc", Integer.valueOf(Z3.c(this.K)));
        String G = this.L.G(this.K);
        if (!TextUtils.isEmpty(G)) {
            hashMap.put("icc", G);
        }
        String d3 = this.L.d();
        if (!TextUtils.isEmpty(d3)) {
            hashMap.put("tz", d3);
        }
        IronLog.INTERNAL.verbose("collecting data for events: " + hashMap);
        return hashMap;
    }

    private String b() {
        try {
            return "" + Build.VERSION.SDK_INT + "(" + Build.VERSION.RELEASE + ")";
        } catch (Exception e) {
            C3260q4.d().a(e);
            return "";
        }
    }

    private String c() {
        return com.ironsource.mediationsdk.p.j().k();
    }

    private int d() {
        try {
            Intent registerReceiver = this.K.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("level", -1) : 0;
            int intExtra2 = registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : 0;
            if (intExtra != -1 && intExtra2 != -1) {
                return (int) ((intExtra / intExtra2) * 100.0f);
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, this.f2940a + ":getBatteryLevel()", e);
        }
        return -1;
    }

    private String e() {
        try {
            return this.K.getPackageName();
        } catch (Exception e) {
            C3260q4.d().a(e);
            return "";
        }
    }

    private String f() {
        try {
            return Build.MODEL;
        } catch (Exception e) {
            C3260q4.d().a(e);
            return "";
        }
    }

    private String g() {
        try {
            return Build.MANUFACTURER;
        } catch (Exception e) {
            C3260q4.d().a(e);
            return "";
        }
    }

    private String h() {
        return C3040d4.d;
    }

    private long i() {
        if (!s()) {
            return -1L;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    private int j() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            return Math.round(((timeZone.getOffset(Calendar.getInstance(timeZone).getTimeInMillis()) / 1000) / 60) / 15) * 15;
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, this.f2940a + ":getGmtMinutesOffset()", e);
            return 0;
        }
    }

    private long k() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        } catch (Exception e) {
            C3260q4.d().a(e);
            return -1L;
        }
    }

    private String l() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception e) {
            C3260q4.d().a(e);
            return "";
        }
    }

    private String m() {
        return com.ironsource.mediationsdk.p.j().n();
    }

    private String n() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.K.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!networkOperatorName.equals("")) {
                    return networkOperatorName;
                }
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, this.f2940a + ":getMobileCarrier()", e);
        }
        return "";
    }

    private String r() {
        return LevelPlay.getSdkVersion();
    }

    private boolean s() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            C3260q4.d().a(e);
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            K6.a().a(a());
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "Thread name = " + getClass().getSimpleName(), e);
        }
    }

    private String o() {
        try {
            return ConfigFile.getConfigFile().getPluginFrameworkVersion();
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginFrameworkVersion()", e);
            return "";
        }
    }

    private String p() {
        try {
            return ConfigFile.getConfigFile().getPluginType();
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginType()", e);
            return "";
        }
    }

    private String q() {
        try {
            return ConfigFile.getConfigFile().getPluginVersion();
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginVersion()", e);
            return "";
        }
    }

    public L6(Context context) {
        this.K = context.getApplicationContext();
    }

    private boolean a(int i) {
        return i <= P && i >= Q && i % 15 == 0;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "missingDependencies";
        }
        if (!X4.f3123a.b()) {
            return "publisherAPI";
        }
        if (this.L.g(this.K)) {
            return Boolean.parseBoolean(str) ? "userLat" : "other";
        }
        return "missingManifest";
    }
}
