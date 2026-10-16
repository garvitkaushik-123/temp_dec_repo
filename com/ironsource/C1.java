package com.ironsource;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.mediationsdk.logger.IronLog;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class C1 {
    public static int a(Activity activity) {
        return activity.getRequestedOrientation();
    }

    public static String b(Context context) {
        try {
            return a(context).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return "";
        }
    }

    public static String c(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            return cacheDir.getPath();
        }
        return null;
    }

    public static boolean d(Context context, String str) {
        boolean z = false;
        int i = 0;
        z = false;
        z = false;
        if (!TextUtils.isEmpty(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
                if (packageInfo.requestedPermissions != null) {
                    boolean z2 = false;
                    while (true) {
                        try {
                            String[] strArr = packageInfo.requestedPermissions;
                            if (i >= strArr.length || z2) {
                                break;
                            }
                            z2 = str.equals(strArr[i]);
                            i++;
                        } catch (Exception e) {
                            e = e;
                            z = z2;
                            C3260q4.d().a(e);
                            IronLog.INTERNAL.error(e.toString());
                            return z;
                        }
                    }
                    return z2;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return z;
    }

    public static String e(Context context) {
        String str;
        try {
            str = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        } catch (Throwable th) {
            C3260q4.d().a(th);
            str = null;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static long f(Context context) {
        try {
            return a(context).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return -1L;
        }
    }

    public static String g(Context context) {
        return context.getPackageName();
    }

    public static JSONObject a(Context context, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            int i = 0;
            if (jSONArray.length() == 0) {
                while (true) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (i >= strArr.length) {
                        break;
                    }
                    jSONObject.put(strArr[i], (packageInfo.requestedPermissionsFlags[i] & 2) != 0 ? "Granted" : "Rejected");
                    i++;
                }
            } else {
                List asList = Arrays.asList(packageInfo.requestedPermissions);
                while (i < jSONArray.length()) {
                    String string = jSONArray.getString(i);
                    int indexOf = asList.indexOf(string);
                    if (indexOf != -1) {
                        jSONObject.put(string, (packageInfo.requestedPermissionsFlags[indexOf] & 2) != 0 ? "Granted" : "Rejected");
                    } else {
                        jSONObject.put(string, "notFoundInManifest");
                    }
                    i++;
                }
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return jSONObject;
    }

    public static boolean c(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static String b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception e) {
            C3260q4.d().a(e);
            return "";
        }
    }

    public static long d(Context context) {
        try {
            return a(context).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return -1L;
        }
    }

    static PackageInfo a(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(g(context), 0);
    }

    public static String a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0)).toString();
        } catch (Exception e) {
            C3260q4.d().a(e);
            return null;
        }
    }

    public static boolean a() {
        try {
            Class.forName("kotlin.jvm.internal.Intrinsics");
            return true;
        } catch (Throwable th) {
            C3260q4.d().a(th);
            Log.d("ApplicationContext", "Kotlin Intrinsics not found");
            return false;
        }
    }
}
