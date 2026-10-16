package io.bidmachine.util;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.DisplayMetrics;
import com.ironsource.C3040d4;
import io.bidmachine.util.file.FileUtilsKt;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceUtils.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u0015\u001a\u00020\u0006H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\rH\u0007J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0007J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0007J\b\u0010\u001f\u001a\u00020\u0006H\u0007J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010!\u001a\u00020\u0006H\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH\u0007J\u0012\u0010#\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH\u0007J\u0017\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010%J\u0017\u0010&\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u0012J\u0010\u0010'\u001a\u00020(2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010*\u001a\u00020+2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0017\u0010,\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010-J\u0017\u0010.\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010-J\u0017\u0010/\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010-J\u0010\u00100\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0017\u00101\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010-J\u0010\u00102\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u00103\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0017\u00104\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010-J\u0010\u00105\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u00066"}, d2 = {"Lio/bidmachine/util/DeviceUtils;", "", "()V", "MIN_TABLET_DP", "", "hwv", "", "isDeviceRooted", "", "Ljava/lang/Boolean;", "getActiveNetworkCapabilities", "Landroid/net/NetworkCapabilities;", "context", "Landroid/content/Context;", "getActiveNetworkInfo", "Landroid/net/NetworkInfo;", "getBatteryLevel", "", "(Landroid/content/Context;)Ljava/lang/Double;", "getBluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getBuildId", "getConfiguration", "Landroid/content/res/Configuration;", "getDeviceName", "getDisplayMetrics", "Landroid/util/DisplayMetrics;", "getHWV", "getKernelVersionThroughProcVersion", "getKernelVersionThroughUName", "getManufacturer", "getModel", "getOrientation", "getOsVersion", "getPhoneMCCMNC", "getPhoneOperatorName", "getScreenBrightness", "(Landroid/content/Context;)Ljava/lang/Integer;", "getScreenBrightnessRatio", "getScreenDensity", "", "getScreenOrientation", "getScreenSize", "Landroid/graphics/Point;", "isAirplaneModeOn", "(Landroid/content/Context;)Ljava/lang/Boolean;", "isBatterySaverEnabled", C3040d4.i.k0, "isDarkModeEnabled", "isDoNotDisturbOn", "isLandscapeOrientation", "isNetworkAvailable", "isRingMuted", "isTablet", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class DeviceUtils {
    public static final DeviceUtils INSTANCE = new DeviceUtils();
    private static final int MIN_TABLET_DP = 600;
    private static String hwv;
    private static Boolean isDeviceRooted;

    private DeviceUtils() {
    }

    @JvmStatic
    public static final String getOsVersion() {
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        return RELEASE;
    }

    @JvmStatic
    public static final String getBuildId() {
        String ID = Build.ID;
        Intrinsics.checkNotNullExpressionValue(ID, "ID");
        return ID;
    }

    @JvmStatic
    public static final String getModel() {
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        return MODEL;
    }

    @JvmStatic
    public static final String getManufacturer() {
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        return MANUFACTURER;
    }

    @JvmStatic
    public static final DisplayMetrics getDisplayMetrics(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getDisplayMetrics(context);
    }

    @JvmStatic
    public static final Configuration getConfiguration(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getConfiguration(context);
    }

    @JvmStatic
    public static final boolean isNetworkAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.isNetworkAvailable(context);
    }

    @Deprecated(message = "Use getActiveNetworkCapabilities instead", replaceWith = @ReplaceWith(expression = "DeviceUtils.getActiveNetworkCapabilities(context)", imports = {}))
    @JvmStatic
    public static final NetworkInfo getActiveNetworkInfo(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getActiveNetworkInfo(context);
    }

    @JvmStatic
    public static final NetworkCapabilities getActiveNetworkCapabilities(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getActiveNetworkCapabilities(context);
    }

    @JvmStatic
    public static final int getOrientation(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getOrientation(context);
    }

    @JvmStatic
    public static final boolean isLandscapeOrientation(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.isLandscapeOrientation(context);
    }

    @JvmStatic
    public static final int getScreenOrientation(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getScreenOrientation(context);
    }

    @JvmStatic
    public static final float getScreenDensity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getScreenDensity(context);
    }

    @JvmStatic
    public static final Point getScreenSize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getScreenSize(context);
    }

    @JvmStatic
    public static final Boolean isRingMuted(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.isRingMuted(context);
    }

    @JvmStatic
    public static final Boolean isCharging(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.isCharging(context);
    }

    @JvmStatic
    public static final Double getBatteryLevel(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getBatteryLevel(context);
    }

    @JvmStatic
    public static final Boolean isBatterySaverEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.isBatterySaverEnabled(context);
    }

    @JvmStatic
    public static final boolean isDarkModeEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.isDarkModeEnabled(context);
    }

    @JvmStatic
    public static final Boolean isAirplaneModeOn(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.isAirplaneModeOn(context);
    }

    @JvmStatic
    public static final Boolean isDoNotDisturbOn(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.isDoNotDisturbOn(context);
    }

    @JvmStatic
    public static final String getDeviceName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getDeviceName(context);
    }

    @JvmStatic
    public static final BluetoothAdapter getBluetoothAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getBluetoothAdapter(context);
    }

    @JvmStatic
    public static final Integer getScreenBrightness(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getScreenBrightness(context);
    }

    @JvmStatic
    public static final Double getScreenBrightnessRatio(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getScreenBrightnessRatio(context);
    }

    @JvmStatic
    public static final String getPhoneMCCMNC(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getPhoneMCCMNC(context);
    }

    @JvmStatic
    public static final String getPhoneOperatorName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getPhoneOperatorName(context);
    }

    @JvmStatic
    public static final boolean isDeviceRooted() {
        Boolean bool = isDeviceRooted;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = true;
        try {
            String[] strArr = {"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
            for (int i = 0; i < 8; i++) {
                if (FileUtilsKt.existsSafely(new File(strArr[i]))) {
                    isDeviceRooted = true;
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
            if (new BufferedReader(new InputStreamReader(process.getInputStream())).readLine() == null) {
                z = false;
            }
            isDeviceRooted = Boolean.valueOf(z);
            if (process != null) {
                process.destroy();
            }
            return z;
        } catch (Exception unused2) {
            if (process != null) {
                process.destroy();
            }
            isDeviceRooted = false;
            return false;
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }

    @JvmStatic
    public static final String getHWV() {
        String str = hwv;
        if (str != null) {
            return str;
        }
        DeviceUtils deviceUtils = INSTANCE;
        String kernelVersionThroughProcVersion = deviceUtils.getKernelVersionThroughProcVersion();
        if (kernelVersionThroughProcVersion == null || kernelVersionThroughProcVersion.length() <= 0) {
            kernelVersionThroughProcVersion = deviceUtils.getKernelVersionThroughUName();
        }
        hwv = kernelVersionThroughProcVersion;
        return kernelVersionThroughProcVersion;
    }

    @JvmStatic
    public static final boolean isTablet(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return DeviceUtilsKt.getConfiguration(context).smallestScreenWidthDp >= 600;
    }

    private final String getKernelVersionThroughProcVersion() {
        RandomAccessFile randomAccessFile;
        Throwable th;
        String str = null;
        try {
            randomAccessFile = new RandomAccessFile("/proc/version", "r");
        } catch (Exception unused) {
            randomAccessFile = null;
        } catch (Throwable th2) {
            randomAccessFile = null;
            th = th2;
        }
        try {
            str = randomAccessFile.readLine();
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            th = th3;
            UtilsKt.closeSafely(randomAccessFile);
            throw th;
        }
        UtilsKt.closeSafely(randomAccessFile);
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getKernelVersionThroughUName() {
        InputStreamReader inputStreamReader;
        ?? r3;
        Throwable th;
        Process process;
        try {
            process = Runtime.getRuntime().exec("uname -a");
        } catch (Exception unused) {
            process = null;
            inputStreamReader = null;
        } catch (Throwable th2) {
            inputStreamReader = null;
            r3 = 0;
            th = th2;
            process = null;
        }
        try {
            inputStreamReader = new InputStreamReader(process.getInputStream());
            try {
                r3 = new BufferedReader(inputStreamReader);
                try {
                    String readLine = r3.readLine();
                    UtilsKt.closeSafely((Closeable) r3);
                    UtilsKt.closeSafely(inputStreamReader);
                    if (process != null) {
                        process.destroy();
                    }
                    return readLine;
                } catch (Exception unused2) {
                    UtilsKt.closeSafely((Closeable) r3);
                    UtilsKt.closeSafely(inputStreamReader);
                    if (process != null) {
                        process.destroy();
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    UtilsKt.closeSafely((Closeable) r3);
                    UtilsKt.closeSafely(inputStreamReader);
                    if (process != null) {
                        process.destroy();
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                r3 = 0;
            } catch (Throwable th4) {
                r3 = 0;
                th = th4;
            }
        } catch (Exception unused4) {
            inputStreamReader = null;
            r3 = inputStreamReader;
            UtilsKt.closeSafely((Closeable) r3);
            UtilsKt.closeSafely(inputStreamReader);
            if (process != null) {
            }
            return null;
        } catch (Throwable th5) {
            r3 = 0;
            th = th5;
            inputStreamReader = null;
        }
    }
}
