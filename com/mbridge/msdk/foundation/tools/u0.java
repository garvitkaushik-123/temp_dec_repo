package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import com.ironsource.C3040d4;
import com.ironsource.D5;
import com.ironsource.Y1;
import com.ironsource.Z3;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.MBDownloadConfig;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper;
import com.mbridge.msdk.foundation.download.resource.ResourceConfig;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SameTool.java */
/* loaded from: classes6.dex */
public class u0 extends x {

    /* renamed from: a, reason: collision with root package name */
    private static int f4382a = 1;
    private static volatile Boolean b;
    private static final Pattern c = Pattern.compile("[一-龥]");
    private static Map<String, String> d;
    private static Map<String, String> e;

    /* compiled from: SameTool.java */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f4383a;
        final /* synthetic */ CampaignEx b;
        final /* synthetic */ com.mbridge.msdk.foundation.feedback.a c;
        final /* synthetic */ int d;

        a(ImageView imageView, CampaignEx campaignEx, com.mbridge.msdk.foundation.feedback.a aVar, int i) {
            this.f4383a = imageView;
            this.b = campaignEx;
            this.c = aVar;
            this.d = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                u0.a(this.b, this.c, this.d, (String) this.f4383a.getTag());
            } catch (Exception e) {
                p0.b("SameTools", e.getMessage());
            }
        }
    }

    /* compiled from: SameTool.java */
    class b implements IDatabaseOpenHelper {
        b() {
        }

        @Override // com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper
        public SQLiteDatabase getReadableDatabase() {
            return com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()).c();
        }

        @Override // com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            return com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()).d();
        }
    }

    /* compiled from: SameTool.java */
    class c implements ILogger {
        c() {
        }

        @Override // com.mbridge.msdk.foundation.download.utils.ILogger
        public void log(String str, String str2) {
            p0.a(str, str2);
        }

        @Override // com.mbridge.msdk.foundation.download.utils.ILogger
        public void log(String str, Exception exc) {
            p0.a(str, exc.getMessage());
        }
    }

    public static int a(int i) {
        if ((i > 100 && i < 199) || i == 2) {
            return 1;
        }
        if ((i <= 200 || i >= 299) && i != 4) {
            return (i <= 500 || i >= 599) ? -1 : 5;
        }
        return 2;
    }

    public static String a(String str, String str2, String str3) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                HashMap hashMap = new HashMap();
                hashMap.put(str2, str3);
                return a(str, hashMap);
            }
            return str;
        } catch (Exception e2) {
            p0.b("SameTools", e2.getMessage());
            return str;
        }
    }

    public static int c(Context context) {
        if (context != null) {
            return 0;
        }
        try {
            if (context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") != 0) {
                return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return 0;
    }

    public static float d(Context context) {
        if (context != null) {
            try {
                float f = context.getResources().getDisplayMetrics().density;
                if (f == 0.0f) {
                    return 2.5f;
                }
                return f;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 2.5f;
    }

    public static DisplayMetrics e(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics;
        } catch (Throwable th) {
            th.printStackTrace();
            return context.getResources().getDisplayMetrics();
        }
    }

    public static int f(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return e(context).heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int g(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return e(context).widthPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int h(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int i(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static float j(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int k(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean l(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean m(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                p0.b("SameTools", "isNetworkAvailable", e2);
            }
            return false;
        }
    }

    public static boolean n(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return Z3.b.equals(activeNetworkInfo.getTypeName().toLowerCase(Locale.US));
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static int b(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            PackageInfo currentWebViewPackage = WebView.getCurrentWebViewPackage();
            com.mbridge.msdk.setting.g d2 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d2 == null) {
                d2 = com.mbridge.msdk.setting.h.b().a();
            }
            if (currentWebViewPackage == null || TextUtils.isEmpty(currentWebViewPackage.versionName) || !currentWebViewPackage.versionName.equals("77.0.3865.92")) {
                return d2.z0();
            }
            return 5;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static <T extends String> boolean j(T t) {
        return t != null && t.length() > 0;
    }

    public static boolean j() {
        try {
            if (com.mbridge.msdk.foundation.controller.c.m().d() == null) {
                return false;
            }
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = Y1.f;
            }
            int parseInt = Integer.parseInt(property2);
            p0.a("address = ", property + "~");
            p0.a("port = ", parseInt + "~");
            return (TextUtils.isEmpty(property) || parseInt == -1) ? false : true;
        } catch (Throwable th) {
            p0.b("SameTools", th.getMessage());
            return false;
        }
    }

    public static int f(String str) {
        try {
            return ((Integer) Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("getWXAppSupportAPI", new Class[0]).invoke(l0.d(str), new Object[0])).intValue();
        } catch (Throwable th) {
            p0.b("SameTools", th.getMessage());
            return 0;
        }
    }

    public static Object g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory").getMethod("createWXAPI", Context.class, String.class).invoke(null, com.mbridge.msdk.foundation.controller.c.m().d(), str);
        } catch (ClassNotFoundException e2) {
            p0.b("SameTools", e2.getMessage());
            return null;
        } catch (IllegalAccessException e3) {
            p0.b("SameTools", e3.getMessage());
            return null;
        } catch (NoSuchMethodException e4) {
            p0.b("SameTools", e4.getMessage());
            return null;
        } catch (InvocationTargetException e5) {
            p0.b("SameTools", e5.getMessage());
            return null;
        }
    }

    public static boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_CAN_ANIM);
                if (!TextUtils.isEmpty(queryParameter)) {
                    return queryParameter.equals("1");
                }
            }
            return false;
        } catch (Exception e2) {
            p0.b("SameTools", e2.getMessage());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean i(String str) {
        int i;
        boolean z;
        boolean isEmpty = TextUtils.isEmpty(str);
        try {
            if (isEmpty) {
                return false;
            }
            try {
                try {
                    Uri parse = Uri.parse(str);
                    if (parse == null) {
                        return false;
                    }
                    String queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW);
                    try {
                        if (!TextUtils.isEmpty(queryParameter)) {
                            try {
                                i = Integer.parseInt(queryParameter);
                            } catch (Exception unused) {
                                i = -1;
                            }
                            if (i % 2 == 0) {
                                z = true;
                                if (TextUtils.isEmpty(parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_NATMP))) {
                                    return true;
                                }
                                return z;
                            }
                        }
                        if (TextUtils.isEmpty(parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_NATMP))) {
                        }
                    } catch (Exception e2) {
                        e = e2;
                        p0.b("SameTools", e.getMessage());
                        return false;
                    }
                    z = false;
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable unused2) {
                return false;
            }
        } catch (Throwable unused3) {
            return isEmpty;
        }
    }

    public static boolean l(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(MBridgeConstans.ENDCARD_URL_IS_PLAYABLE);
                if (!TextUtils.isEmpty(queryParameter)) {
                    return queryParameter.equals("0");
                }
            }
            return false;
        } catch (Exception e2) {
            p0.b("SameTools", e2.getMessage());
            return false;
        }
    }

    public static double m(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0.0d;
            }
            return Double.parseDouble(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0d;
        }
    }

    public static synchronized String d(String str) {
        synchronized (u0.class) {
            String str2 = com.mbridge.msdk.foundation.controller.c.m().b() + "_" + str;
            Map<String, String> map = e;
            if (map == null || !map.containsKey(str2)) {
                return null;
            }
            return e.get(str2);
        }
    }

    public static <T extends String> boolean k(T t) {
        return t == null || t.length() == 0;
    }

    public static String a(String str, Map<String, String> map) {
        try {
            if (!TextUtils.isEmpty(str) && map != null) {
                StringBuilder sb = new StringBuilder(str);
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null && !TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        String value = entry.getValue();
                        if (str.contains(entry.getKey())) {
                            if (value.equals("0")) {
                                sb = new StringBuilder(str.replaceAll("(" + entry.getKey() + "[^&]*)", ""));
                            } else {
                                sb = new StringBuilder(str.replaceAll("(" + entry.getKey() + "[^&]*)", entry.getKey() + entry.getValue()));
                            }
                        } else if (!value.equals("0")) {
                            sb.append(entry.getKey() + entry.getValue());
                        }
                    }
                }
                return sb.toString();
            }
            return str;
        } catch (Exception e2) {
            p0.b("SameTools", e2.getMessage());
            return str;
        }
    }

    public static String c(String str) {
        ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> c2;
        List<String> c3;
        if (TextUtils.isEmpty(str) || (c2 = com.mbridge.msdk.foundation.same.buffer.b.c(str)) == null || c2.size() <= 0) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (com.mbridge.msdk.foundation.entity.c cVar : c2.values()) {
            if (cVar != null && a(cVar.e(), cVar.f()) && (c3 = cVar.c()) != null && c3.size() > 0) {
                arrayList.addAll(c3);
            }
        }
        if (arrayList.size() <= 0) {
            return "";
        }
        HashSet hashSet = new HashSet(arrayList);
        arrayList.clear();
        arrayList.addAll(hashSet);
        return arrayList.toString();
    }

    public static BitmapDrawable n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            if (decodeByteArray != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(decodeByteArray);
                Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                bitmapDrawable.setTileModeXY(tileMode, tileMode);
                return bitmapDrawable;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static String d() {
        String str;
        try {
            str = UUID.randomUUID().toString() + System.currentTimeMillis();
        } catch (Throwable th) {
            th.printStackTrace();
            str = "";
        }
        return z0.a(str) ? System.currentTimeMillis() + "" : str;
    }

    public static void f() {
        try {
            HandlerThread handlerThread = new HandlerThread("mb_db_thread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            MBDownloadConfig.Builder builder = new MBDownloadConfig.Builder();
            builder.setDatabaseHandler(handler);
            builder.setDatabaseOpenHelper(new b());
            builder.setLogger(new c());
            MBDownloadManager.getInstance().initialize(com.mbridge.msdk.foundation.controller.c.m().d(), builder.build(), new ResourceConfig.Builder().setMaxStorageSpace(100L).setMaxStorageTime(259200000L).build());
        } catch (Throwable th) {
            p0.b("SameTools", th.getMessage());
        }
    }

    public static final synchronized String e(String str) {
        String str2;
        int i;
        boolean z;
        int i2;
        boolean z2;
        JSONObject jSONObject;
        Map<String, String> map;
        synchronized (u0.class) {
            try {
                str2 = com.mbridge.msdk.foundation.controller.c.m().b() + "_" + str;
                com.mbridge.msdk.setting.g d2 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                if (d2 != null) {
                    z = d2.A0();
                    z2 = d2.H0();
                    i2 = Math.max(0, d2.b0());
                } else {
                    z = true;
                    i2 = 3;
                    z2 = false;
                }
            } catch (Exception e2) {
                p0.b("SameTools", e2.getMessage());
            }
            if (z2 && i2 != 0) {
                if (z && (map = d) != null && map.containsKey(str2)) {
                    return d.get(str2);
                }
                StringBuilder sb = new StringBuilder("");
                StackTraceElement[] stackTrace = new Exception().getStackTrace();
                if (stackTrace != null && stackTrace.length > 0) {
                    List<String> a2 = a(stackTrace);
                    Collections.reverse(a2);
                    ArrayList arrayList = new ArrayList();
                    for (String str3 : a2) {
                        if (!str3.startsWith(MBridgeConstans.APPLICATION_STACK_COM_ANDROID) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_OS) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_APP) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_REFLECT_METHOD) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_VIEW) && !arrayList.contains(str3)) {
                            arrayList.add(str3);
                        }
                    }
                    int min = Math.min(arrayList.size(), i2);
                    if (min > 0) {
                        for (i = 0; i < min; i++) {
                            sb.append((String) arrayList.get(i));
                            if (i < min - 1) {
                                sb.append("|");
                            }
                        }
                    }
                    if (TextUtils.isEmpty(sb.toString())) {
                        jSONObject = null;
                    } else {
                        jSONObject = new JSONObject();
                        jSONObject.put("1", sb.toString());
                    }
                    if (jSONObject != null && jSONObject.length() > 0) {
                        String b2 = com.mbridge.msdk.foundation.tools.a.b(jSONObject.toString());
                        if (z && !TextUtils.isEmpty(b2)) {
                            if (d == null) {
                                d = new HashMap();
                            }
                            d.put(str2, b2);
                        }
                        return b2;
                    }
                    return "";
                }
                return "";
            }
            return "";
        }
    }

    public static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW);
                if (TextUtils.isEmpty(queryParameter)) {
                    queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
                }
                if (!TextUtils.isEmpty(queryParameter)) {
                    try {
                        return Integer.parseInt(queryParameter);
                    } catch (Exception unused) {
                    }
                }
            }
            return -1;
        } catch (Exception e2) {
            p0.b("SameTools", e2.getMessage());
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized int d(Context context, String str) {
        int i;
        synchronized (u0.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        i = a(str, context);
                    } catch (Exception unused) {
                        i = 3;
                    }
                }
            }
            if (context == null) {
                i = 5;
            } else {
                i = TextUtils.isEmpty(str) ? 2 : 4;
            }
        }
        return i;
    }

    public static boolean h() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean g() {
        if (TextUtils.isEmpty(com.mbridge.msdk.foundation.controller.c.m().i())) {
            return false;
        }
        try {
            Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
            Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram");
            return true;
        } catch (ClassNotFoundException e2) {
            p0.b("SameTools", e2.getMessage());
            return false;
        }
    }

    public static final String c() {
        return MIMManager.b().d();
    }

    public static synchronized boolean c(Context context, String str) {
        synchronized (u0.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    return a(str, context);
                }
            }
            return false;
        }
    }

    public static boolean c(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                return campaignEx.getRetarget_offer() == 1;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static boolean i() {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager a2 = g0.a();
            if (a2 == null || (networkInfo = a2.getNetworkInfo(17)) == null) {
                return false;
            }
            return networkInfo.isConnected();
        } catch (Exception e2) {
            p0.b("SameTools", e2.getMessage());
            return false;
        }
    }

    public static String a(String str) {
        try {
            if (z0.b(str)) {
                return URLEncoder.encode(str, D5.N);
            }
            return "";
        } catch (Throwable th) {
            p0.b("SameTools", th.getMessage(), th);
            return "";
        }
    }

    public static int c(String str, String str2) {
        return a(str, str2, 0);
    }

    public static void a(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        try {
            imageView.setImageResource(0);
            imageView.setImageDrawable(null);
            imageView.setImageURI(null);
            imageView.setImageBitmap(null);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[Catch: Exception -> 0x0051, LOOP:0: B:17:0x003c->B:18:0x003e, LOOP_END, TryCatch #0 {Exception -> 0x0051, blocks: (B:2:0x0000, B:4:0x0012, B:5:0x001a, B:7:0x0021, B:9:0x0028, B:11:0x0032, B:15:0x0038, B:18:0x003e, B:21:0x0046, B:23:0x004c), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(int i) {
        String[] a2;
        int i2;
        try {
            com.mbridge.msdk.setting.g d2 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d2 == null) {
                d2 = com.mbridge.msdk.setting.h.b().a();
            }
            JSONArray jSONArray = new JSONArray();
            if (d2 != null && d2.m() == 1 && (a2 = com.mbridge.msdk.foundation.db.middle.a.b().a()) != null) {
                int length = a2.length;
                if (length > i && i != 0) {
                    i2 = length - i;
                    while (i2 < length) {
                        jSONArray.put(a2[i2]);
                        i2++;
                    }
                }
                i2 = 0;
                while (i2 < length) {
                }
            }
            return jSONArray.length() > 0 ? a(jSONArray) : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static final void a(int i, ImageView imageView, CampaignEx campaignEx, Context context, boolean z, com.mbridge.msdk.foundation.feedback.a aVar) {
        if (imageView == null || campaignEx == null) {
            return;
        }
        p0.a("configPrivacyButton", "configPrivacyButton");
        boolean z2 = campaignEx.getPrivacyButtonTemplateVisibility() == 0;
        p0.a("configPrivacyButton", "privacyButtonVisibilityGone: " + z2 + " isIgnoreCampaignPrivacyConfig: " + z);
        if (!z && z2) {
            try {
                imageView.setVisibility(8);
                return;
            } catch (Exception e2) {
                p0.b("SameTools", e2.getMessage());
                return;
            }
        }
        if (TextUtils.isEmpty(a(campaignEx))) {
            try {
                imageView.setVisibility(8);
                return;
            } catch (Exception e3) {
                p0.b("SameTools", e3.getMessage());
                return;
            }
        }
        try {
            imageView.setVisibility(0);
        } catch (Exception e4) {
            p0.b("SameTools", e4.getMessage());
        }
        imageView.setOnClickListener(new a(imageView, campaignEx, aVar, i));
    }

    public static JSONArray b(Context context, String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            com.mbridge.msdk.setting.g d2 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d2 == null) {
                d2 = com.mbridge.msdk.setting.h.b().a();
            }
            if (d2 != null && d2.m() == 1) {
                p0.c("SameTools", "fqci cfc:" + d2.m());
                String[] a2 = com.mbridge.msdk.foundation.db.middle.a.b().a();
                if (a2 != null) {
                    for (String str2 : a2) {
                        p0.c("SameTools", "cfc campaignIds:" + a2);
                        jSONArray.put(str2);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONArray;
    }

    public static String a(CampaignEx campaignEx) {
        com.mbridge.msdk.setting.g d2;
        CampaignEx.a adchoice;
        String str = "";
        if (campaignEx != null) {
            try {
                str = campaignEx.getPrivacyUrl();
            } catch (Exception e2) {
                p0.b("SameTools", e2.getMessage());
                return str;
            }
        }
        if (TextUtils.isEmpty(str) && campaignEx != null && (adchoice = campaignEx.getAdchoice()) != null) {
            str = adchoice.c();
        }
        if (TextUtils.isEmpty(str) && (d2 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b())) != null) {
            str = d2.c();
        }
        return TextUtils.isEmpty(str) ? com.mbridge.msdk.foundation.same.net.utils.d.h().g : str;
    }

    public static int b() {
        int i = f4382a;
        f4382a = i + 1;
        return i;
    }

    public static boolean b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            return !TextUtils.isEmpty(campaignEx.getDeepLinkURL());
        }
        return false;
    }

    public static boolean b(String str, Context context) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static List<String> b(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String optString = jSONArray.optString(i);
                        if (z0.b(optString)) {
                            arrayList.add(optString);
                        }
                    }
                    return arrayList;
                }
            } catch (Throwable th) {
                p0.b("SameTools", th.getMessage(), th);
            }
        }
        return null;
    }

    public static void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.feedback.a aVar, int i, String str) {
        if (campaignEx == null) {
            return;
        }
        try {
            String str2 = campaignEx.getCampaignUnitId() + "_" + i;
            com.mbridge.msdk.foundation.feedback.b.b().d(str2);
            com.mbridge.msdk.foundation.feedback.b.b().a(str2, campaignEx);
            com.mbridge.msdk.foundation.feedback.b.b().a(str2, aVar);
            com.mbridge.msdk.foundation.feedback.b.b().a(str2, i);
            com.mbridge.msdk.foundation.feedback.b.b().a(str2, str);
            com.mbridge.msdk.foundation.feedback.b.b().b(str2).p();
        } catch (Throwable th) {
            p0.b("SameTools", "feedback error", th);
        }
    }

    public static synchronized void b(String str, String str2) {
        synchronized (u0.class) {
            if (e == null) {
                e = new HashMap();
            }
            e.put(com.mbridge.msdk.foundation.controller.c.m().b() + "_" + str, str2);
        }
    }

    public static int b(Context context, float f) {
        float f2 = 2.5f;
        if (context != null) {
            try {
                float f3 = context.getResources().getDisplayMetrics().density;
                if (f3 != 0.0f) {
                    f2 = f3;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return (int) ((f / f2) + 0.5f);
    }

    public static String b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject(C3040d4.h.G);
                if (jSONObject2 != null) {
                    if (jSONObject2.has(str2)) {
                        if (str3.equals("0")) {
                            jSONObject2.remove(str2);
                        } else {
                            jSONObject2.put(str2, str3);
                        }
                    } else if (!str3.equals("0")) {
                        jSONObject2.put(str2, str3);
                    }
                    return jSONObject.toString();
                }
            } catch (Exception e2) {
                p0.b("SameTools", e2.getMessage());
            }
        }
        return str;
    }

    public static int e() {
        try {
            return ((Integer) Class.forName("com.tencent.mm.opensdk.constants.Build").getField("SDK_INT").get(null)).intValue();
        } catch (Throwable th) {
            p0.b("SameTools", th.getMessage());
            return 0;
        }
    }

    public static int a(Context context, float f) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static double a(Double d2) {
        try {
            String format = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US)).format(d2);
            if (z0.b(format)) {
                return Double.parseDouble(format);
            }
            return 0.0d;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0d;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0028, code lost:
    
        if (r2 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a(File file) throws Exception {
        long j = 0;
        FileInputStream fileInputStream = null;
        try {
            if (file.exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    j = fileInputStream2.available();
                    fileInputStream = fileInputStream2;
                } catch (Exception unused) {
                    fileInputStream = fileInputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } else {
                file.createNewFile();
            }
            if (fileInputStream == null) {
                return j;
            }
        } catch (Exception unused3) {
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            fileInputStream.close();
        } catch (Exception unused4) {
        }
        return j;
    }

    public static String a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return "";
        }
        com.mbridge.msdk.setting.g d2 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d2 == null) {
            d2 = com.mbridge.msdk.setting.h.b().a();
        }
        int W = d2.W();
        if (jSONArray.length() > W) {
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < W; i++) {
                try {
                    jSONArray2.put(jSONArray.get(i));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return jSONArray2.toString();
        }
        return jSONArray.toString();
    }

    public static String a(Context context, String str) {
        String str2 = "";
        try {
            JSONArray b2 = b(context, str);
            if (b2.length() > 0) {
                str2 = a(b2);
            }
            p0.c("SameTools", "get excludes:" + str2);
            return str2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    private static boolean a(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (j > 0) {
            return j2 + (j * 1000) >= currentTimeMillis;
        }
        com.mbridge.msdk.setting.g d2 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d2 == null) {
            d2 = com.mbridge.msdk.setting.h.b().a();
        }
        return j2 + (d2.a0() * 1000) >= currentTimeMillis;
    }

    public static final int a() {
        if (b == null) {
            try {
                b = MIMManager.b().e();
            } catch (Exception e2) {
                p0.b("SameTools", e2.getMessage());
            }
        }
        if (b != null) {
            return b.booleanValue() ? 1 : 0;
        }
        return -1;
    }

    public static synchronized String a(Context context, String str, String str2) {
        String sb;
        synchronized (u0.class) {
            StringBuilder sb2 = new StringBuilder(str2);
            try {
                sb2.append(a(str2, context, str));
            } catch (Exception unused) {
            }
            sb = sb2.toString();
        }
        return sb;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:13:0x0025
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r3v3, types: [boolean] */
    private static synchronized java.lang.String a(java.lang.String r2, android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.Class<com.mbridge.msdk.foundation.tools.u0> r0 = com.mbridge.msdk.foundation.tools.u0.class
            monitor-enter(r0)
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            java.util.Set r2 = r2.getQueryParameterNames()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            if (r2 == 0) goto L1b
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            if (r2 <= 0) goto L1b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            java.lang.String r1 = "&rtins_type="
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            goto L2c
        L1b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            java.lang.String r1 = "?rtins_type="
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L25
            goto L2c
        L23:
            r2 = move-exception
            goto L46
        L25:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L23
            java.lang.String r1 = "&rtins_type="
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L23
        L2c:
            boolean r3 = a(r4, r3)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L3c
            if (r3 == 0) goto L37
            r3 = 1
            r2.append(r3)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L3c
            goto L40
        L37:
            r3 = 2
            r2.append(r3)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L3c
            goto L40
        L3c:
            r3 = 0
            r2.append(r3)     // Catch: java.lang.Throwable -> L23
        L40:
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L23
            monitor-exit(r0)
            return r2
        L46:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L23
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.u0.a(java.lang.String, android.content.Context, java.lang.String):java.lang.String");
    }

    static boolean a(String str, Context context) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    return false;
                }
                if (packageManager.getPackageInfo(str, 1) != null) {
                    return true;
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    p0.a("SameTools", th.getMessage());
                }
            }
        }
        return false;
    }

    public static List<String> a(StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                arrayList.add(stackTraceElement.getClassName());
            }
        }
        return arrayList;
    }

    public static ImageView a(ImageView imageView, BitmapDrawable bitmapDrawable, DisplayMetrics displayMetrics) {
        try {
            bitmapDrawable.setTargetDensity(displayMetrics);
            imageView.setBackground(bitmapDrawable);
            imageView.setClickable(false);
            imageView.setFocusable(false);
            return imageView;
        } catch (Exception e2) {
            e2.printStackTrace();
            return imageView;
        }
    }

    public static void a(View view) {
        if (view == null) {
            return;
        }
        try {
            view.setSystemUiVisibility(4102);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, CampaignEx campaignEx, int i) {
        try {
            if (TextUtils.isEmpty(str) || campaignEx == null || com.mbridge.msdk.foundation.controller.c.m().d() == null) {
                return;
            }
            com.mbridge.msdk.foundation.db.i a2 = com.mbridge.msdk.foundation.db.i.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
            com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
            fVar.a(System.currentTimeMillis());
            fVar.b(str);
            fVar.a(campaignEx.getId());
            fVar.a(i);
            a2.a(fVar);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                p0.b("SameTools", e2.getMessage());
            }
        }
    }

    public static boolean a(JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0 || jSONObject.optInt("v", -1) != -1) ? false : true;
    }

    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                try {
                    Uri parse = Uri.parse(str2);
                    if (parse != null) {
                        if (!TextUtils.isEmpty(parse.getQueryParameter(str))) {
                            return true;
                        }
                    }
                } catch (Exception e2) {
                    p0.b("SameTools", e2.getMessage());
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        try {
            if (obj instanceof String) {
                return Integer.parseInt((String) obj);
            }
            return 0;
        } catch (Throwable th) {
            p0.b("SameTools", th.getMessage(), th);
            return 0;
        }
    }

    public static int a(String str, String str2, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Uri parse = Uri.parse(str);
                if (parse != null) {
                    String queryParameter = parse.getQueryParameter(str2);
                    if (!TextUtils.isEmpty(queryParameter)) {
                        return (int) Math.round(Double.valueOf(String.valueOf(queryParameter)).doubleValue());
                    }
                }
            } catch (Exception e2) {
                p0.b("SameTools", e2.getMessage());
            }
        }
        return i;
    }
}
