package com.tiktok.util;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.tiktok.BuildConfig;
import com.tiktok.TikTokBusinessSdk;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Locale;

/* loaded from: classes6.dex */
public class SystemInfoUtil {
    static Application application;
    static PackageInfo packageInfo;
    static PackageManager pm;
    private static String userAgent;

    static {
        try {
            Application applicationContext = TikTokBusinessSdk.getApplicationContext();
            application = applicationContext;
            PackageManager packageManager = applicationContext.getPackageManager();
            pm = packageManager;
            packageInfo = packageManager.getPackageInfo(TikTokBusinessSdk.getApplicationContext().getPackageName(), 0);
        } catch (Exception unused) {
        }
        userAgent = null;
    }

    public static String getPackageName() {
        return packageInfo.packageName;
    }

    public static String getAppName() {
        return application.getApplicationInfo().loadLabel(pm).toString();
    }

    public static String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static String getAppVersionName() {
        PackageInfo packageInfo2 = packageInfo;
        if (packageInfo2 == null) {
            return "";
        }
        return packageInfo2.versionName;
    }

    public static int getAppVersionCode() {
        if (packageInfo == null) {
            return 0;
        }
        return (int) packageInfo.getLongVersionCode();
    }

    public static String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getLocale() {
        return Locale.getDefault().getLanguage();
    }

    public static void initUserAgent() {
        if (userAgent != null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            TikTokBusinessSdk.getAppEventLogger().monitorMetric("ua_init", TTUtil.getMetaWithTS(Long.valueOf(currentTimeMillis)), null);
            TTKeyValueStore tTKeyValueStore = new TTKeyValueStore(TikTokBusinessSdk.getApplicationContext());
            String str = tTKeyValueStore.get(TTConst.TTSDK_USER_AGENT);
            userAgent = str;
            if (TextUtils.isEmpty(str)) {
                String defaultUserAgent = WebSettings.getDefaultUserAgent(TikTokBusinessSdk.getApplicationContext());
                userAgent = defaultUserAgent;
                tTKeyValueStore.set(TTConst.TTSDK_USER_AGENT, defaultUserAgent);
            }
            e = null;
        } catch (Exception e) {
            e = e;
            userAgent = System.getProperty("http.agent");
        }
        if (userAgent == null) {
            userAgent = "";
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        try {
            TikTokBusinessSdk.getAppEventLogger().monitorMetric("ua_end", TTUtil.getMetaException(e, Long.valueOf(currentTimeMillis2), 2).put("latency", currentTimeMillis2 - currentTimeMillis), null);
        } catch (Exception unused) {
        }
    }

    public static String getUserAgent() {
        if (userAgent == null) {
            initUserAgent();
        }
        return userAgent;
    }

    public static String getAndroidVersion() {
        return Build.VERSION.SDK_INT + "";
    }

    public static String getNetworkClass(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() == 0) {
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return "2G";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return "3G";
                    case 13:
                    case 18:
                    case 19:
                        return "4G";
                    case 20:
                        return "5G";
                    default:
                        return "?";
                }
            }
            return "?";
        }
        return "-";
    }
}
