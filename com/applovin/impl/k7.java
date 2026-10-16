package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import android.os.StrictMode;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Toast;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.ironsource.C3040d4;
import com.ironsource.D5;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class k7 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f517a = {60, 60, 24, 7, 4, 12};
    private static final String[] b = {" second", " minute", " hour", " day", " week", " month"};
    private static final String[] c = {"s", "m", "h", "d", "w", "mth"};
    private static final DecimalFormat d = new DecimalFormat();
    private static final Random e = new Random();
    private static Boolean f;
    private static Boolean g;
    private static String h;
    private static Boolean i;

    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareToIgnoreCase(str2);
        }
    }

    class b extends r4 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f518a;

        b(String str) {
            this.f518a = str;
        }

        @Override // com.applovin.impl.r4
        protected Map a() {
            return CollectionUtils.hashMap("name", "Utils:" + this.f518a);
        }
    }

    public static double a(long j) {
        return j / 1024.0d;
    }

    public static int a(int i2, int i3) {
        return (i2 < 0 || i2 > 100) ? i3 : i2;
    }

    public static String a(Map map, boolean z) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            TreeMap treeMap = new TreeMap(new a());
            treeMap.putAll(map);
            map = treeMap;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(C3040d4.i.c);
            }
            Object value = entry.getValue();
            if (value instanceof String) {
                String str = (String) value;
                if (str.contains(C3040d4.i.c)) {
                    value = str.replace(C3040d4.i.c, "%26");
                }
            }
            sb.append(entry.getKey()).append(D5.T).append(value);
        }
        return sb.toString();
    }

    public static void a() {
    }

    public static boolean a(long j, long j2) {
        return (j & j2) != 0;
    }

    public static float b(float f2) {
        return f2 * 1000.0f;
    }

    public static long b(long j) {
        return j * 8;
    }

    public static void b() {
    }

    public static int c(int i2) {
        return a(i2, 95);
    }

    public static void c() {
    }

    public static double d(long j) {
        return j / 1000.0d;
    }

    public static int d(int i2) {
        return i2 * 1024;
    }

    public static long e(String str) {
        if (!StringUtils.isValidString(str)) {
            return Long.MAX_VALUE;
        }
        try {
            return Color.parseColor(str);
        } catch (Throwable unused) {
            return Long.MAX_VALUE;
        }
    }

    public static String f(String str) {
        return (str == null || str.length() <= 4) ? "NOKEY" : str.substring(str.length() - 4);
    }

    public static boolean g() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        try {
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
        } catch (Throwable th) {
            com.applovin.impl.sdk.o.c("Utils", "Exception thrown while getting memory state.", th);
        }
        int i2 = runningAppProcessInfo.importance;
        return i2 == 100 || i2 == 200;
    }

    public static boolean h() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean i() {
        return !a("com.applovin.sdk.AppLovinSdk");
    }

    public static boolean j() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                String displayName = networkInterfaces.nextElement().getDisplayName();
                if (displayName.contains("tun") || displayName.contains("ppp") || displayName.contains("ipsec")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.applovin.impl.sdk.o.c("Utils", "Unable to check Network Interfaces", th);
            return false;
        }
    }

    public static boolean k() {
        Context o = com.applovin.impl.sdk.k.o();
        if (o != null) {
            return y.a(o).a("applovin.sdk.verbose_logging");
        }
        return false;
    }

    public static boolean l(Context context) {
        if (context == null) {
            return false;
        }
        try {
            context.getResources();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean m(Context context) {
        if (context == null) {
            context = com.applovin.impl.sdk.k.o();
        }
        if (context != null) {
            return y.a(context).a("applovin.sdk.verbose_logging", false);
        }
        return false;
    }

    public static void b(String str, String str2) {
        if (str == null || str.length() <= d(8)) {
            return;
        }
        com.applovin.impl.sdk.o.j(str2, "Provided custom data parameter longer than supported (" + str.length() + " bytes, " + d(8) + " maximum)");
    }

    public static long c(float f2) {
        return a(b(f2));
    }

    public static boolean h(Context context) {
        if (f == null) {
            f = Boolean.valueOf("com.applovin.apps.dspdemo".equals(context.getPackageName()));
        }
        return f.booleanValue();
    }

    public static Boolean i(Context context) {
        if (context == null) {
            return null;
        }
        Boolean bool = i;
        if (bool != null) {
            return bool;
        }
        try {
            String a2 = y.a(context).a();
            String c2 = c(context);
            if (c2 == null) {
                return null;
            }
            if (c2.equals(a2)) {
                Boolean bool2 = Boolean.TRUE;
                i = bool2;
                return bool2;
            }
            if (TextUtils.isEmpty(a2) && c2.equals(context.getPackageName())) {
                Boolean bool3 = Boolean.TRUE;
                i = bool3;
                return bool3;
            }
            Boolean bool4 = Boolean.FALSE;
            i = bool4;
            return bool4;
        } catch (Throwable th) {
            com.applovin.impl.sdk.o.b("Utils", "Unable to determine if the current process is the main process", th);
            return null;
        }
    }

    public static double c(long j) {
        return a(b(j));
    }

    public static int d(Context context) {
        WindowManager f2 = f(context);
        if (f2 == null) {
            return 0;
        }
        return f2.getDefaultDisplay().getRotation();
    }

    public static boolean c(com.applovin.impl.sdk.k kVar) {
        String str = kVar.o0().getExtraParameters().get("run_in_release_mode");
        return ((StringUtils.isValidString(str) && Boolean.parseBoolean(str)) || (com.applovin.impl.sdk.k.o().getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    public static boolean k(Context context) {
        String packageName = context.getPackageName();
        return "com.revolverolver.fliptrickster".equals(packageName) || "com.mindstormstudios.idlemakeover".equals(packageName);
    }

    public static String b(Class cls, String str) {
        try {
            Field a2 = a(cls, str);
            a2.setAccessible(true);
            return (String) a2.get(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String e() {
        try {
            for (Field field : Build.VERSION_CODES.class.getFields()) {
                if (field.getInt(null) == Build.VERSION.SDK_INT) {
                    return field.getName();
                }
            }
            return "";
        } catch (Throwable th) {
            com.applovin.impl.sdk.o.c("Utils", "Unable to get Android SDK codename", th);
            return "";
        }
    }

    public static long c(byte[] bArr) {
        return a(bArr, 0);
    }

    public static WindowManager f(Context context) {
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        StrictMode.setVmPolicy(vmPolicy);
        return windowManager;
    }

    public static String c(String str) {
        return str.replace("ALPlayableAnalytics.trackEvent = ", "ALPlayableAnalytics.trackEvent = function (eventName) {const SDK_URL = 'applovin://com.applovin.sdk/playable_event';if (!Object.values(ALPlayableEvent).includes(eventName)) {var aTag = document.createElement('a');aTag.setAttribute('href', SDK_URL + '?success=0&type=' + encodeURIComponent(eventName));aTag.innerHTML = 'empty';aTag.click();return;}var aTag = document.createElement('a');aTag.setAttribute('href', SDK_URL + '?success=1&type=' + encodeURIComponent(eventName));aTag.innerHTML = 'empty';aTag.click();}; ALPlayableAnalytics.trackEvent_ignore = ");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(AppLovinAd appLovinAd, com.applovin.impl.sdk.k kVar) {
        if (appLovinAd instanceof AppLovinAdBase) {
            AppLovinAdBase appLovinAdBase = (AppLovinAdBase) appLovinAd;
            String j0 = kVar.j0();
            String j02 = appLovinAdBase.getSdk().j0();
            if (j0.equals(j02)) {
                return;
            }
            String str = "Ad was loaded from sdk with key: " + j02 + ", but is being rendered from sdk with key: " + j0;
            com.applovin.impl.sdk.o.h("AppLovinAd", str);
            a(str, appLovinAdBase, "AppLovinAd", kVar);
        }
    }

    public static String d() {
        try {
            return Build.VERSION.RELEASE + " (" + e() + " - API " + Build.VERSION.SDK_INT + ")";
        } catch (Throwable th) {
            com.applovin.impl.sdk.o.c("Utils", "Unable to get Android OS info", th);
            return "";
        }
    }

    public static String c(Context context) {
        int myPid;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return null;
        }
        if (StringUtils.isValidString(h)) {
            return h;
        }
        try {
            myPid = Process.myPid();
            runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        } catch (Throwable th) {
            com.applovin.impl.sdk.o.b("Utils", "Unable to determine process name", th);
        }
        if (runningAppProcesses == null) {
            com.applovin.impl.sdk.o.c("Utils", "No running app processes. Unable to determine process name");
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (myPid == runningAppProcessInfo.pid) {
                String str = runningAppProcessInfo.processName;
                h = str;
                return str;
            }
        }
        return null;
    }

    public static int f() {
        if (o0.b()) {
            return WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout();
        }
        return 0;
    }

    public static int g(String str) {
        int i2 = 0;
        for (String str2 : str.replaceAll("-beta", ".").split("\\.")) {
            if (str2.length() > 2) {
                com.applovin.impl.sdk.o.h("Utils", "Version number components cannot be longer than two digits -> " + str);
                return i2;
            }
            i2 = (i2 * 100) + Integer.parseInt(str2);
        }
        return !str.contains("-beta") ? (i2 * 100) + 99 : i2;
    }

    public static boolean j(Context context) {
        if (g == null) {
            g = Boolean.valueOf("com.applovin.apps.playables".equals(context.getPackageName()));
        }
        return g.booleanValue();
    }

    public static byte[] d(byte[] bArr) {
        if (bArr == null || bArr.length == 0 || !b(bArr)) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read > 0) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static boolean e(com.applovin.impl.sdk.k kVar) {
        if (((Boolean) kVar.a(v4.b2)).booleanValue()) {
            return kVar.o0().isMuted();
        }
        return ((Boolean) kVar.a(v4.Z1)).booleanValue();
    }

    public static String b(Context context) {
        Point b2 = o0.b(context);
        int i2 = b2.x;
        int i3 = b2.y;
        int d2 = d(context);
        if ((i2 > i3 && (d2 == 0 || d2 == 2)) || (i3 > i2 && (d2 == 1 || d2 == 3))) {
            return a(d2);
        }
        return b(d2);
    }

    public static Context e(Context context) {
        return l(context) ? context : com.applovin.impl.sdk.k.o();
    }

    public static String d(String str) {
        return a(str, str.split("\\.").length);
    }

    public static boolean d(com.applovin.impl.sdk.k kVar) {
        String str = kVar.o0().getExtraParameters().get("user_agent_collection_enabled");
        if (StringUtils.isValidString(str)) {
            return Boolean.parseBoolean(str);
        }
        return true;
    }

    public static boolean g(Context context) {
        return y.a(context).a("applovin.sdk.is_test_environment");
    }

    private static String b(int i2) {
        if (i2 == 0) {
            return C3040d4.h.D;
        }
        if (i2 == 1) {
            return "landscape_right";
        }
        if (i2 == 2) {
            return "portrait_upside_down";
        }
        if (i2 != 3) {
            return "unknown";
        }
        return "landscape_left";
    }

    public static Map a(Map map) {
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                hashMap.put((String) entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        return hashMap;
    }

    private static long b(String str) {
        if (str == null) {
            return 0L;
        }
        return new File(str).length();
    }

    public static boolean b(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == 31 && bArr[1] == -117;
    }

    public static boolean b(com.applovin.impl.sdk.k kVar) {
        try {
            JSONObject.wrap(JSONObject.NULL);
            return true;
        } catch (Throwable th) {
            kVar.O();
            if (!com.applovin.impl.sdk.o.a()) {
                return false;
            }
            kVar.O().d("Utils", "Failed to wrap JSONObject with exception", th);
            return false;
        }
    }

    public static boolean a(String str, List list) {
        return StringUtils.startsWithAtLeastOnePrefix(str, list);
    }

    public static boolean b(List list) {
        Context o = com.applovin.impl.sdk.k.o();
        if (o == null) {
            com.applovin.impl.sdk.o.h("Utils", "Failed to check whether or not app is member of package names");
            return false;
        }
        return list.contains(o.getPackageName());
    }

    public static long a(com.applovin.impl.sdk.k kVar) {
        long longValue = ((Long) kVar.a(v4.w5)).longValue();
        long longValue2 = ((Long) kVar.a(v4.x5)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        return (longValue <= 0 || longValue2 <= 0) ? currentTimeMillis : currentTimeMillis + (longValue - longValue2);
    }

    public static void a(String str, String str2, Map map) {
        if (map.containsKey(str)) {
            map.put(str2, map.get(str));
            map.remove(str);
        }
    }

    public static WebView b(Context context, String str) {
        return a(context, str, false);
    }

    private static long a(float f2) {
        return Math.round(f2);
    }

    public static String a(long j, boolean z) {
        String str;
        String[] strArr = z ? b : c;
        long currentTimeMillis = (System.currentTimeMillis() - j) / 1000;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            long j2 = f517a[i2];
            if (currentTimeMillis < j2) {
                if (currentTimeMillis <= 0) {
                    return z ? "just now" : "now";
                }
                String str2 = "";
                if (!z || currentTimeMillis <= 1) {
                    str = "";
                } else {
                    str = "s";
                }
                if (z) {
                    str2 = " ago";
                }
                return String.format("%d%s%s%s", Long.valueOf(currentTimeMillis), strArr[i2], str, str2);
            }
            currentTimeMillis /= j2;
        }
        return z ? "just now" : "now";
    }

    public static double a(String str, double d2) {
        try {
            return Double.parseDouble(str);
        } catch (Throwable th) {
            com.applovin.impl.sdk.o.c("Utils", "Failed to parse double from String: " + str, th);
            return d2;
        }
    }

    public static String a(Uri uri, String str, com.applovin.impl.sdk.k kVar) {
        List c2 = kVar.c(v4.G0);
        String lastPathSegment = uri.getLastPathSegment();
        if (c2.contains(lastPathSegment)) {
            return lastPathSegment;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = uri.getQueryParameterNames().iterator();
        while (it.hasNext()) {
            String queryParameter = uri.getQueryParameter(it.next());
            if (StringUtils.isValidString(queryParameter)) {
                arrayList.add(queryParameter);
            }
        }
        arrayList.addAll(uri.getPathSegments());
        String encodeUriString = StringUtils.encodeUriString(TextUtils.join("_", arrayList));
        Integer num = (Integer) kVar.a(v4.H0);
        int length = StringUtils.emptyIfNull(encodeUriString).length() + StringUtils.emptyIfNull(str).length();
        if (length > num.intValue() && StringUtils.isValidString(encodeUriString)) {
            encodeUriString = encodeUriString.substring(length - num.intValue());
        }
        return (StringUtils.isValidString(encodeUriString) && StringUtils.isValidString(str)) ? str + encodeUriString : encodeUriString;
    }

    public static void a(String str, MaxAdFormat maxAdFormat, JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        if (jSONObject.has("no_fill_reason")) {
            String str2 = "\n**************************************************\nNO FILL received:\n..ID: \"" + str + "\"\n..FORMAT: \"" + (maxAdFormat != null ? maxAdFormat.getLabel() : "None") + "\"\n..SDK KEY: \"" + kVar.j0() + "\"\n..PACKAGE NAME: \"" + com.applovin.impl.sdk.k.o().getPackageName() + "\"\n..Reason: " + JsonUtils.getObject(jSONObject, "no_fill_reason", new Object()) + "\n**************************************************\n";
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().b("AppLovinSdk", str2);
            }
        }
    }

    public static AppLovinAd a(AppLovinAd appLovinAd, com.applovin.impl.sdk.k kVar) {
        if (!(appLovinAd instanceof com.applovin.impl.sdk.ad.c)) {
            return appLovinAd;
        }
        com.applovin.impl.sdk.ad.c cVar = (com.applovin.impl.sdk.ad.c) appLovinAd;
        AppLovinAd dequeueAd = kVar.k().dequeueAd(cVar.getAdZone());
        kVar.O();
        if (com.applovin.impl.sdk.o.a()) {
            kVar.O().a("Utils", "Dequeued ad for dummy ad: " + dequeueAd);
        }
        if (dequeueAd != null) {
            cVar.a(dequeueAd);
            ((AppLovinAdImpl) dequeueAd).setDummyAd(cVar);
            return dequeueAd;
        }
        return cVar.f();
    }

    public static u a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        return u.a(AppLovinAdSize.fromString(JsonUtils.getString(jSONObject, "ad_size", null)), AppLovinAdType.fromString(JsonUtils.getString(jSONObject, "ad_type", null)), JsonUtils.getString(jSONObject, "zone_id", null), true, JsonUtils.getBoolean(jSONObject, "is_direct_sold", Boolean.FALSE).booleanValue());
    }

    public static Field a(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Class superclass = cls.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return a(superclass, str);
        }
    }

    public static List a(JSONObject jSONObject, String str, String str2, com.applovin.impl.sdk.k kVar) {
        return a(jSONObject, str, null, str2, null, false, kVar);
    }

    public static List a(JSONObject jSONObject, String str, Map map, String str2, Map map2, boolean z, com.applovin.impl.sdk.k kVar) {
        if (map == null) {
            map = new HashMap(1);
        }
        Map map3 = map;
        map3.put("{CLCODE}", str);
        return a(jSONObject, map3, str2, map2, z, kVar);
    }

    public static List a(JSONObject jSONObject, Map map, String str, Map map2, boolean z, com.applovin.impl.sdk.k kVar) {
        ArrayList arrayList = new ArrayList(jSONObject.length() + 1);
        if (StringUtils.isValidString(str)) {
            arrayList.add(new e(str, null, map2, z));
        }
        if (jSONObject.length() > 0) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        String optString = jSONObject.optString(next);
                        String replace = StringUtils.replace(next, map);
                        if (AppLovinSdkUtils.isValidString(optString)) {
                            optString = StringUtils.replace(optString, map);
                        }
                        arrayList.add(new e(replace, optString, map2, z));
                    }
                } catch (Throwable th) {
                    kVar.O();
                    if (com.applovin.impl.sdk.o.a()) {
                        kVar.O().a("Utils", "Failed to create and add postback url.", th);
                    }
                }
            }
        }
        return arrayList;
    }

    public static void a(com.applovin.impl.sdk.k kVar, String str) {
        String j0 = kVar.j0();
        if (((Boolean) kVar.a(v4.y)).booleanValue()) {
            if (j0 == null || j0.length() != 86) {
                a(TextUtils.isEmpty(j0) ? "Empty SDK key" : "Invalid SDK key length", str, kVar);
            }
        }
    }

    private static void a(String str, String str2, com.applovin.impl.sdk.k kVar) {
        a(str, (AppLovinAdBase) null, str2, kVar);
    }

    private static void a(String str, AppLovinAdBase appLovinAdBase, String str2, com.applovin.impl.sdk.k kVar) {
        StringBuilder sb = new StringBuilder("sdkKey=");
        sb.append(kVar.j0());
        if (appLovinAdBase != null) {
            sb.append(",adSdkKey=").append(appLovinAdBase.getSdk().j0());
        }
        HashMap hashMap = new HashMap();
        CollectionUtils.putStringIfValid("details", sb.toString(), hashMap);
        CollectionUtils.putStringIfValid("error_message", str, hashMap);
        kVar.E().a(c2.E0, str2, hashMap);
    }

    public static Map a(Map map, com.applovin.impl.sdk.k kVar) {
        Map map2 = CollectionUtils.map(map);
        for (String str : map2.keySet()) {
            String str2 = (String) map2.get(str);
            if (str2 != null) {
                map2.put(str, StringUtils.encodeUriString(str2));
            }
        }
        return map2;
    }

    public static String a(Context context, String str, com.applovin.impl.sdk.k kVar) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setPackage(context.getPackageName());
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities.isEmpty()) {
                return null;
            }
            return queryIntentActivities.get(0).activityInfo.name;
        } catch (Throwable th) {
            kVar.E().a(str, th);
            return null;
        }
    }

    private static String a(int i2) {
        if (i2 == 0) {
            return "landscape_right";
        }
        if (i2 == 1) {
            return "portrait_upside_down";
        }
        if (i2 == 2) {
            return "landscape_left";
        }
        if (i2 != 3) {
            return "unknown";
        }
        return C3040d4.h.D;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (a((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void a(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(1);
        thread.start();
    }

    public static void a(Closeable closeable, com.applovin.impl.sdk.k kVar) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th) {
            if (kVar != null) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("Utils", "Unable to close stream: " + closeable, th);
                }
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection, com.applovin.impl.sdk.k kVar) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            if (kVar != null) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("Utils", "Unable to disconnect connection: " + httpURLConnection, th);
                }
            }
        }
    }

    public static void a(final String str, final Context context) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.k7$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                k7.a(context, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Context context, String str) {
        Toast makeText = Toast.makeText(context, str, 0);
        makeText.setMargin(0.0f, 0.1f);
        makeText.show();
    }

    public static void a(String str, MaxAd maxAd, Context context) {
        Toast.makeText(context, maxAd.getFormat().getLabel() + ": " + str, 1).show();
    }

    public static boolean a(AppLovinAdSize appLovinAdSize) {
        return appLovinAdSize == AppLovinAdSize.BANNER || appLovinAdSize == AppLovinAdSize.MREC || appLovinAdSize == AppLovinAdSize.LEADER;
    }

    public static String a(Object obj) {
        if (obj instanceof v2) {
            return ((v2) obj).P();
        }
        if (t3.a(obj)) {
            return ((com.applovin.impl.sdk.ad.b) obj).getMediationServeId();
        }
        return null;
    }

    public static List a(boolean z, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.k kVar, Context context) {
        boolean z2;
        if (bVar instanceof l7) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = new ArrayList(bVar.l()).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Uri uri = (Uri) it.next();
            boolean c2 = kVar.H().c(uri.getLastPathSegment(), context);
            z2 = ((Boolean) kVar.a(v4.I5)).booleanValue() && b(uri.getPath()) == 0;
            if (!c2 || z2) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().b("Utils", "Cached HTML asset missing: " + uri);
                }
                arrayList.add(uri);
            }
        }
        Uri v0 = bVar.v0();
        if (z && v0 != null) {
            boolean c3 = kVar.H().c(v0.getLastPathSegment(), context);
            z2 = ((Boolean) kVar.a(v4.I5)).booleanValue() && b(v0.getPath()) == 0;
            if (!c3 || z2) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().b("Utils", "Cached video missing: " + v0);
                }
                arrayList.add(v0);
            }
        }
        return arrayList;
    }

    public static void a(MaxError maxError, String str, Context context) {
        StringBuilder sb = new StringBuilder();
        if (maxError.getCode() == -5001) {
            for (MaxNetworkResponseInfo maxNetworkResponseInfo : maxError.getWaterfall().getNetworkResponses()) {
                MaxError error = maxNetworkResponseInfo.getError();
                String name = maxNetworkResponseInfo.getMediatedNetwork().getName();
                sb.append("\nFailed to load " + str + " from " + name + ":\n");
                sb.append("\nMAX Error " + error.getCode() + ": " + error.getMessage() + "\n");
                sb.append("\n" + name + " Error " + error.getMediatedNetworkErrorCode() + ": " + error.getMediatedNetworkErrorMessage() + "\n\n");
            }
        } else {
            sb.append("Failed to load " + str + " with error " + maxError.getCode() + ": " + maxError.getMessage());
        }
        a("", sb.toString(), context);
    }

    public static void a(String str, String str2, Context context) {
        new AlertDialog.Builder(context).setTitle(str).setMessage(str2).setNegativeButton(R.string.ok, (DialogInterface.OnClickListener) null).create().show();
    }

    public static boolean a(double d2) {
        if (d2 >= 100.0d) {
            return true;
        }
        return d2 > 0.0d && ((double) e.nextFloat()) < d2 / 100.0d;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static long a(byte[] bArr, int i2) {
        int i3 = i2 + 8;
        if (bArr.length < i3) {
            throw new IllegalArgumentException("byte array must be at least 8 bytes long");
        }
        long j = 0;
        while (i2 < i3) {
            j |= (bArr[i2] & 255) << (i2 * 8);
            i2++;
        }
        return j;
    }

    public static int a(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0);
    }

    public static String a(String str, int i2) {
        String[] split = StringUtils.toDigitsOnlyVersionString(str).split("\\.");
        if (split.length == i2) {
            return String.join(".", split);
        }
        if (split.length > i2) {
            return String.join(".", new ArrayList(Arrays.asList(split)).subList(0, i2));
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(split));
        arrayList.addAll(Collections.nCopies(i2 - arrayList.size(), "0"));
        return String.join(".", arrayList);
    }

    public static int a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        String digitsOnlyVersionString = StringUtils.toDigitsOnlyVersionString(str);
        String digitsOnlyVersionString2 = StringUtils.toDigitsOnlyVersionString(str2);
        try {
            String[] split = digitsOnlyVersionString.split("\\.");
            String[] split2 = digitsOnlyVersionString2.split("\\.");
            int max = Math.max(split.length, split2.length);
            int i2 = 0;
            while (i2 < max) {
                String str3 = i2 < split.length ? split[i2] : "0";
                String str4 = i2 < split2.length ? split2[i2] : "0";
                int parseInt = Integer.parseInt(str3);
                int parseInt2 = Integer.parseInt(str4);
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i2++;
            }
            return 0;
        } catch (Throwable th) {
            com.applovin.impl.sdk.o.c("Utils", "Failed to process version string.", th);
            return 0;
        }
    }

    public static WebView a(Context context, String str, boolean z) {
        try {
            WebView webView = new WebView(context);
            if (z) {
                webView.setWebViewClient(new b(str));
            }
            return webView;
        } catch (Throwable th) {
            com.applovin.impl.sdk.o.c("Utils", "Failed to initialize WebView for " + str + ".", th);
            return null;
        }
    }

    public static void a(Uri uri, Activity activity, com.applovin.impl.sdk.k kVar) {
        if (activity == null) {
            activity = kVar.v0();
        }
        Intent intent = new Intent(activity, (Class<?>) AppLovinWebViewActivity.class);
        intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, kVar.j0());
        intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_LOAD_URL, uri.toString());
        activity.startActivity(intent);
    }

    public static String a(int i2, Context context, com.applovin.impl.sdk.k kVar) {
        if (i2 == 0) {
            return "";
        }
        try {
            InputStream openRawResource = context.getResources().openRawResource(i2);
            try {
                byte[] bArr = new byte[openRawResource.available()];
                openRawResource.read(bArr);
                return new String(bArr);
            } catch (IOException e2) {
                if (kVar != null) {
                    kVar.O();
                    if (com.applovin.impl.sdk.o.a()) {
                        kVar.O().a("Utils", "Opening raw resource file threw exception", e2);
                    }
                }
                return "";
            } finally {
                a(openRawResource, kVar);
            }
        } catch (Throwable th) {
            if (kVar != null) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("Utils", "Failed to retrieve resource " + i2, th);
                }
            }
            return "";
        }
    }

    public static boolean a(MaxAdFormat maxAdFormat, MaxAdFormat maxAdFormat2) {
        if (maxAdFormat == null || maxAdFormat2 == null) {
            return false;
        }
        if (maxAdFormat == maxAdFormat2) {
            return true;
        }
        if (maxAdFormat.isAdViewAd() && maxAdFormat2.isAdViewAd()) {
            return true;
        }
        return maxAdFormat.isFullscreenAd() && maxAdFormat2.isFullscreenAd();
    }

    public static boolean a(String str, com.applovin.impl.sdk.k kVar) {
        if (str == null) {
            return false;
        }
        return StringUtils.containsAtLeastOneSubstring(str, kVar.c(v4.w0));
    }

    public static ActivityManager.MemoryInfo a(ActivityManager activityManager) {
        if (activityManager == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        try {
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo;
        } catch (Throwable th) {
            com.applovin.impl.sdk.o.b("Utils", "Unable to collect memory info.", th);
            return null;
        }
    }

    public static String a(AppLovinSdkSettings appLovinSdkSettings) {
        String emptyIfNull = StringUtils.emptyIfNull(appLovinSdkSettings.getExtraParameters().get("applovin_unity_metadata"));
        if (TextUtils.isEmpty(emptyIfNull)) {
            return null;
        }
        Map<String, String> tryToStringMap = JsonUtils.tryToStringMap(JsonUtils.jsonObjectFromJsonString(emptyIfNull, new JSONObject()));
        if (CollectionUtils.isEmpty(tryToStringMap)) {
            return null;
        }
        return tryToStringMap.get("UnityVersion");
    }

    public static void a(String str, int i2, int i3, q1 q1Var) {
        if (i2 > i3) {
            q1Var.a(c2.G0, str, CollectionUtils.hashMap("details", i2 + " Leaking Instances"));
        }
    }

    public static void a(float f2, long j, com.applovin.impl.sdk.o oVar) {
        Vibrator vibrator = (Vibrator) com.applovin.impl.sdk.k.o().getSystemService("vibrator");
        if (vibrator == null || !vibrator.hasVibrator()) {
            return;
        }
        try {
            if (com.applovin.impl.sdk.o.a()) {
                oVar.a("Utils", "Vibrating with intensity: " + f2 + " for duration: " + j + "ms");
            }
            if (o0.h()) {
                vibrator.vibrate(VibrationEffect.createOneShot(j, Math.max(1, Math.min(255, (int) (f2 * 255.0f)))));
            } else {
                vibrator.vibrate(j);
            }
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                oVar.a("Utils", "Failed to vibrate", th);
            }
        }
    }
}
