package com.ironsource;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebSettings;
import androidx.autofill.HintConstants;
import com.ironsource.C3040d4;
import com.ironsource.InterfaceC3293s4;
import com.ironsource.InterfaceC3381x7;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.IronSourceSharedPreferencesUtilities;
import com.ironsource.mediationsdk.logger.IronLog;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

/* renamed from: com.ironsource.a5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C2987a5 implements InterfaceC3381x7, InterfaceC3381x7.a {
    private static final String A = "browser_user_agent";
    private static final String B = "browser_user_agent_time";
    private static final String C = "IABTCF_gdprApplies";
    private static final String D = "IABTCF_TCString";
    private static final String E = "IABTCF_AddtlConsent";
    private static final String j = "android";
    private static final String k = "com.google.android.gms.permission.AD_ID";
    private static final String l = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
    private static final String m = "com.google.android.gms.appset.AppSet";
    private static final String n = "com.google.android.gms.tasks.OnSuccessListener";
    private static final String o = "getAdvertisingIdInfo";
    private static final String p = "getClient";
    private static final String q = "getAppSetIdInfo";
    private static final String r = "addOnSuccessListener";
    private static final String s = "getId";
    private static final String t = "isLimitAdTrackingEnabled";
    private static final String u = "Mediation_Shared_Preferences";
    private static final String v = "supersonic_shared_preferen";
    private static final String w = "cachedUUID";
    private static final String x = "auid";
    private static final String y = "unityads-installinfo";
    private static final String z = "unityads-idfi";
    private String b = null;
    private String c = null;
    private String d = null;
    private String e = "";
    private boolean f = false;
    private String g = "";
    private volatile String h;
    private volatile String i;

    /* renamed from: com.ironsource.a5$a */
    class a implements InvocationHandler {
        a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2;
            if (objArr != null) {
                try {
                    if (objArr.length > 0 && (obj2 = objArr[0]) != null) {
                        String obj3 = obj2.getClass().getMethod(C2987a5.s, null).invoke(objArr[0], null).toString();
                        if (!TextUtils.isEmpty(obj3)) {
                            C2987a5.this.g = obj3;
                        }
                    }
                } catch (Exception e) {
                    C3260q4.d().a(e);
                }
            }
            return null;
        }
    }

    private String O(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object Q = Q(context);
        return Q.getClass().getMethod(s, null).invoke(Q, null).toString();
    }

    private void P(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> cls = Class.forName(m);
        Object invoke = cls.getMethod(p, Context.class).invoke(cls, context);
        Object invoke2 = invoke.getClass().getMethod(q, null).invoke(invoke, null);
        Class<?> cls2 = Class.forName(n);
        invoke2.getClass().getMethod(r, cls2).invoke(invoke2, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls2}, new a()));
    }

    private Object Q(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> cls = Class.forName(l);
        return cls.getMethod(o, Context.class).invoke(cls, context);
    }

    private String R(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object Q = Q(context);
        return String.valueOf(((Boolean) Q.getClass().getMethod("isLimitAdTrackingEnabled", null).invoke(Q, null)).booleanValue());
    }

    private String S(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, u, A, "");
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return "";
        }
    }

    private long T(Context context) {
        try {
            return Long.parseLong(IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, u, B, String.valueOf(-1L)));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return -1L;
        }
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String A(Context context) {
        return context.getResources().getConfiguration().locale.getCountry();
    }

    @Override // com.ironsource.InterfaceC3381x7
    public File B(Context context) {
        return context.getCacheDir();
    }

    @Override // com.ironsource.InterfaceC3381x7
    public boolean C(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("status", -1) : -1;
        return intExtra == 2 || intExtra == 5;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public int D(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return registerReceiver.getIntExtra("plugged", -1);
        }
        return -1;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public float E(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        try {
            return audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return -1.0f;
        }
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String F(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getStringFromDefaultSharedPrefs(context, E, null);
        } catch (Exception e) {
            C3260q4.d().a(e);
            return null;
        }
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String G(Context context) {
        TelephonyManager telephonyManager;
        return (context == null || (telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)) == null) ? "" : telephonyManager.getNetworkCountryIso();
    }

    @Override // com.ironsource.InterfaceC3381x7
    public List<ApplicationInfo> H(Context context) {
        return context.getPackageManager().getInstalledApplications(0);
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String I(Context context) {
        X4 x4 = X4.f3123a;
        if (x4.b()) {
            try {
                if (!x4.a()) {
                    return O(context);
                }
                if (this.i != null) {
                    return this.i;
                }
                String O = O(context);
                if (!TextUtils.isEmpty(O)) {
                    this.i = O;
                }
                return O;
            } catch (Exception e) {
                C3260q4.d().a(e);
            }
        }
        return null;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public int K(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String L(Context context) {
        try {
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME"), 65536);
            if (resolveActivity != null) {
                return resolveActivity.activityInfo.packageName;
            }
            return null;
        } catch (Throwable th) {
            C3260q4.d().a(th);
            return null;
        }
    }

    @Override // com.ironsource.InterfaceC3381x7
    public synchronized String M(Context context) {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        if (IronSourceSharedPreferencesUtilities.getBooleanFromSharedPrefs(context, u, InterfaceC3381x7.f3932a, true)) {
            String stringFromSharedPrefs = IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, u, w, "");
            if (TextUtils.isEmpty(stringFromSharedPrefs)) {
                String uuid = UUID.randomUUID().toString();
                this.b = uuid;
                IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, u, w, uuid);
            } else {
                this.b = stringFromSharedPrefs;
            }
        }
        return this.b;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public int N(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getRequestedOrientation();
        }
        return -1;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public long a() {
        return Calendar.getInstance(TimeZone.getDefault()).getTime().getTime();
    }

    @Override // com.ironsource.InterfaceC3381x7
    public Boolean b(ActivityManager.MemoryInfo memoryInfo) {
        if (memoryInfo == null) {
            return null;
        }
        return Boolean.valueOf(memoryInfo.lowMemory);
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String c(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage();
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String d() {
        String id = TimeZone.getDefault().getID();
        return id != null ? id : "";
    }

    @Override // com.ironsource.InterfaceC3381x7
    public boolean e(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return false;
        }
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String f() {
        return "android";
    }

    @Override // com.ironsource.InterfaceC3381x7
    public long g() {
        if (j()) {
            return a(Environment.getExternalStorageDirectory());
        }
        return 0L;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public boolean h(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "stay_on_while_plugged_in", 0) != 0;
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return false;
        }
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String i() {
        return Build.VERSION.RELEASE;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public boolean j() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return Environment.isExternalStorageRemovable();
            }
            return false;
        } catch (Exception e) {
            C3260q4.d().a(e);
            return false;
        }
    }

    @Override // com.ironsource.InterfaceC3381x7
    public int k() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String l() {
        return Build.MODEL;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public int m() {
        return -(TimeZone.getDefault().getOffset(a()) / 60000);
    }

    @Override // com.ironsource.InterfaceC3381x7
    public ActivityManager.MemoryInfo n(Context context) {
        if (context == null || !C3334ub.U().g().a()) {
            return null;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager == null) {
            return null;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public int o() {
        return k();
    }

    @Override // com.ironsource.InterfaceC3381x7
    public boolean p() {
        return b("su");
    }

    @Override // com.ironsource.InterfaceC3381x7
    public long q(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager == null) {
            return -1L;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public float r() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String s() {
        try {
            return this.e.isEmpty() ? S(ContextProvider.getInstance().getApplicationContext()) : this.e;
        } catch (Exception e) {
            C3260q4.d().a(e);
            return "";
        }
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String t() {
        try {
            return System.getProperty("os.arch");
        } catch (SecurityException e) {
            IronLog.INTERNAL.error(e.getMessage());
            return null;
        }
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String u(Context context) {
        TelephonyManager telephonyManager;
        return (context == null || (telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)) == null) ? "" : telephonyManager.getNetworkOperatorName();
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String v(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getStringFromDefaultSharedPrefs(context, "IABTCF_TCString", null);
        } catch (Exception e) {
            C3260q4.d().a(e);
            return null;
        }
    }

    @Override // com.ironsource.InterfaceC3381x7
    public boolean w(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) != 1;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String x(Context context) {
        return Locale.getDefault().toString();
    }

    @Override // com.ironsource.InterfaceC3381x7
    public int z(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    private boolean b(String str) {
        try {
            String[] strArr = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
            for (int i = 0; i < 8; i++) {
                if (new File(strArr[i] + str).exists()) {
                    return true;
                }
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
        }
        return false;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public boolean J(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isPowerSaveMode();
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return false;
        }
    }

    @Override // com.ironsource.InterfaceC3381x7
    public Long c(ActivityManager.MemoryInfo memoryInfo) {
        if (memoryInfo == null) {
            return null;
        }
        return Long.valueOf(memoryInfo.availMem);
    }

    @Override // com.ironsource.InterfaceC3381x7
    public File f(Context context) {
        return context.getExternalFilesDir(null);
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String i(Context context) {
        if (!TextUtils.isEmpty(this.d)) {
            return this.d;
        }
        if (context == null) {
            return null;
        }
        String stringFromSharedPrefs = IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, "unityads-installinfo", "unityads-idfi", null);
        this.d = stringFromSharedPrefs;
        return stringFromSharedPrefs;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public File l(Context context) {
        return context.getExternalCacheDir();
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String m(Context context) {
        if (context == null) {
            return "";
        }
        int N = N(context);
        if (N == 0) {
            return C3040d4.h.C;
        }
        if (N == 1) {
            return C3040d4.h.D;
        }
        if (N == 11) {
            return C3040d4.h.C;
        }
        if (N == 12) {
            return C3040d4.h.D;
        }
        switch (N) {
            case 6:
            case 8:
                return C3040d4.h.C;
            case 7:
            case 9:
                return C3040d4.h.D;
            default:
                return "none";
        }
    }

    @Override // com.ironsource.InterfaceC3381x7
    public int o(Context context) {
        int K = K(context);
        int z2 = z(context);
        return (((K == 0 || K == 2) && z2 == 2) || ((K == 1 || K == 3) && z2 == 1)) ? 2 : 1;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public boolean p(Context context) {
        return context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public int c() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public synchronized String d(Context context) {
        if (!TextUtils.isEmpty(this.c)) {
            return this.c;
        }
        if (context == null) {
            return "";
        }
        String stringFromSharedPrefs = IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, "supersonic_shared_preferen", "auid", "");
        this.c = stringFromSharedPrefs;
        if (TextUtils.isEmpty(stringFromSharedPrefs)) {
            String uuid = UUID.randomUUID().toString();
            this.c = uuid;
            IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, "supersonic_shared_preferen", "auid", uuid);
        }
        return this.c;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public int k(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = registerReceiver != null ? registerReceiver.getIntExtra("level", -1) : 0;
            int intExtra2 = registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : 0;
            if (intExtra != -1 && intExtra2 != -1) {
                return (int) ((intExtra / intExtra2) * 100.0f);
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return -1;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String r(Context context) {
        if (a(context)) {
            return "Tablet";
        }
        return "Phone";
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String y(Context context) {
        if (!X4.f3123a.c()) {
            return "";
        }
        try {
            P(context);
            return !TextUtils.isEmpty(this.g) ? this.g : "";
        } catch (Exception e) {
            C3260q4.d().a(e);
            return "";
        }
    }

    @Override // com.ironsource.InterfaceC3381x7
    public boolean g(Context context) {
        try {
            for (String str : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                if (str.equalsIgnoreCase(k)) {
                    return true;
                }
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
        }
        return false;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public int t(Context context) {
        if (context != null) {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
        }
        return -1;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public boolean a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            if (displayMetrics.widthPixels / displayMetrics.density >= 600.0f) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public int e() {
        return Build.VERSION.SDK_INT;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String q() {
        return Build.MANUFACTURER;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public boolean n() {
        return this.f;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public long h() {
        return a(Environment.getDataDirectory());
    }

    @Override // com.ironsource.InterfaceC3381x7
    public File j(Context context) {
        return context.getFilesDir();
    }

    @Override // com.ironsource.InterfaceC3381x7
    public int s(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getIntFromDefaultSharedPrefs(context, "IABTCF_gdprApplies", -1);
        } catch (Exception e) {
            C3260q4.d().a(e);
            return -1;
        }
    }

    private long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    @Override // com.ironsource.InterfaceC3381x7
    public Long a(ActivityManager.MemoryInfo memoryInfo) {
        if (memoryInfo == null) {
            return null;
        }
        return Long.valueOf(memoryInfo.threshold);
    }

    @Override // com.ironsource.InterfaceC3381x7
    public long a(String str) {
        return a(new File(str));
    }

    @Override // com.ironsource.InterfaceC3381x7
    public boolean a(Activity activity) {
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        return (systemUiVisibility | 4096) == systemUiVisibility || (systemUiVisibility | 2048) == systemUiVisibility;
    }

    @Override // com.ironsource.InterfaceC3381x7.a
    public void a(Context context, long j2) {
        if (context != null) {
            if (!new Rf(new InterfaceC3293s4.a()).a(T(context), j2)) {
                this.e = S(context);
                this.f = !r0.isEmpty();
            }
            if (this.e.isEmpty()) {
                try {
                    String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                    this.e = defaultUserAgent;
                    a(context, defaultUserAgent);
                    if (j2 > 0) {
                        b(context, System.currentTimeMillis());
                    }
                } catch (Exception e) {
                    C3260q4.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        }
    }

    @Override // com.ironsource.InterfaceC3381x7
    public int b() {
        return c();
    }

    @Override // com.ironsource.InterfaceC3381x7
    public String b(Context context) {
        try {
            if (X4.f3123a.a()) {
                if (this.h == null) {
                    String R = R(context);
                    if (!TextUtils.isEmpty(R)) {
                        this.h = R;
                    }
                    return R;
                }
                return this.h;
            }
            return R(context);
        } catch (Exception e) {
            C3260q4.d().a(e);
            return null;
        }
    }

    private void a(Context context, String str) {
        try {
            IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, u, A, str);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private void b(Context context, long j2) {
        try {
            IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, u, B, String.valueOf(j2));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }
}
