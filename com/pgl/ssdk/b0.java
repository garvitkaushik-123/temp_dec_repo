package com.pgl.ssdk;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes6.dex */
public class b0 {

    /* renamed from: a, reason: collision with root package name */
    private static int f6378a = -1;
    private static int b = -1;

    public static Application a() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c() {
        String str;
        try {
            str = Environment.getDataDirectory().getPath();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    public static String d() {
        String str;
        try {
            str = Environment.getExternalStorageDirectory().getAbsolutePath();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    public static String e(Context context) {
        String str;
        try {
            str = context.getFilesDir().getAbsolutePath();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    public static String f(Context context) {
        String str;
        try {
            str = context.getPackageName();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    public static String g(Context context) {
        String str;
        try {
            str = context.getPackageResourcePath();
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    public static int h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean j(Context context) {
        ResolveInfo resolveInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            if (queryIntentActivities == null || queryIntentActivities.isEmpty() || (resolveInfo = queryIntentActivities.get(0)) == null) {
                return false;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(activityInfo.packageName, activityInfo.name));
            return componentEnabledSetting == 0 || componentEnabledSetting == 1;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static int k(Context context) {
        int i;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent("android.net.VpnService");
        intent.setPackage(packageName);
        Iterator<ResolveInfo> it = packageManager.queryIntentServices(intent, 128).iterator();
        while (true) {
            if (!it.hasNext()) {
                i = 999999;
                break;
            }
            if (it.next().serviceInfo.packageName.equals(packageName)) {
                i = 1;
                break;
            }
        }
        if (i != 1) {
            return -1;
        }
        return i;
    }

    private static void l(Context context) {
        String a2 = x0.a(context, "hac_date", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            if (a2.equals(simpleDateFormat.format(new Date()))) {
                int a3 = x0.a(context, "hac", -1);
                int a4 = x0.a(context, "tac", -1);
                if (a3 != -1 && a4 != -1) {
                    f6378a = a3;
                    b = a4;
                    return;
                }
            }
        }
        f6378a = 0;
        b = 0;
    }

    private static void m(Context context) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        x0.b(context, "hac_date", simpleDateFormat.format(new Date()));
        x0.b(context, "hac", f6378a);
        x0.b(context, "tac", b);
    }

    public static String b() {
        return Application.getProcessName();
    }

    private static String a(Context context, int i, String str) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(new Locale(str));
        return context.createConfigurationContext(configuration).getResources().getString(i);
    }

    private static boolean a(Context context) {
        List<ActivityManager.AppTask> appTasks;
        if (context != null && (appTasks = ((ActivityManager) context.getSystemService("activity")).getAppTasks()) != null && !appTasks.isEmpty()) {
            for (ActivityManager.AppTask appTask : appTasks) {
                if (appTask.getTaskInfo() != null && a(appTask.getTaskInfo().baseIntent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String c(Context context) {
        String str;
        try {
            str = context.getApplicationInfo().sourceDir;
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    public static String d(Context context) {
        try {
            return a(context, context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).labelRes, "en");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void b(Context context) {
        try {
            if (f6378a == -1 || b == -1) {
                l(context);
            }
            if (a(context)) {
                f6378a++;
            }
            b++;
            if (f6378a != 0) {
                m(context);
                com.pgl.ssdk.ces.a.meta(160, null, new int[]{f6378a, b});
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean a(Intent intent) {
        return (intent == null || (intent.getFlags() & 8388608) == 0) ? false : true;
    }
}
