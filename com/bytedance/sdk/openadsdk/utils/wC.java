package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import com.adjust.sdk.Constants;
import com.ironsource.N6;
import com.ironsource.mediationsdk.metadata.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class wC {
    private static final AtomicReference<Boolean> eli = new AtomicReference<>(null);
    private static final AtomicReference<String> DbA = new AtomicReference<>(null);

    public static void eli(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (DbA()) {
                com.bytedance.sdk.openadsdk.core.Os eli2 = com.bytedance.sdk.openadsdk.core.Os.eli();
                eli2.eli("w_ver", ui(context));
                eli2.eli("bp", DbA(context));
                eli2.eli("is_fold", kb(context) ? 1 : 0);
                eli2.eli("abi", eli());
                eli2.eli("t_ver", Os(context));
                eli2.eli(CampaignEx.JSON_KEY_AAB, aGH(context));
            }
        } catch (Throwable unused) {
        }
    }

    public static int DbA(Context context) {
        if (wC(context)) {
            return 1;
        }
        if (FC(context)) {
            return 2;
        }
        return aAs(context) ? 3 : 4;
    }

    private static boolean wC(Context context) {
        try {
            return Class.forName("com.unity3d.player.UnityPlayerActivity") != null;
        } catch (ClassNotFoundException unused) {
            if (context == null) {
                return false;
            }
            try {
                return new File(context.getApplicationInfo().nativeLibraryDir + "/libunity.so").exists();
            } catch (Throwable unused2) {
                return false;
            }
        }
    }

    private static boolean FC(Context context) {
        try {
            return Class.forName("io.flutter.embedding.android.FlutterActivity") != null;
        } catch (ClassNotFoundException unused) {
            if (context == null) {
                return false;
            }
            try {
                return new File(context.getApplicationInfo().nativeLibraryDir + "/libflutter.so").exists();
            } catch (Throwable unused2) {
                return false;
            }
        }
    }

    private static boolean aAs(Context context) {
        try {
            return Class.forName("com.facebook.react.ReactActivity") != null;
        } catch (ClassNotFoundException unused) {
            if (context == null) {
                return false;
            }
            try {
                return new File(context.getApplicationInfo().nativeLibraryDir + "/libreactnativejni.so").exists();
            } catch (Throwable unused2) {
                return false;
            }
        }
    }

    public static String Os(Context context) {
        try {
            return String.valueOf(context.getApplicationInfo().targetSdkVersion);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int aGH(Context context) {
        try {
            return Class.forName("com.google.android.play.core.splitinstall.SplitInstallManager") != null ? 1 : 0;
        } catch (ClassNotFoundException unused) {
            return 0;
        }
    }

    public static String ui(Context context) {
        String str;
        try {
            AtomicReference<String> atomicReference = DbA;
            String str2 = atomicReference.get();
            if (str2 != null) {
                return str2;
            }
            PackageInfo MGA = MGA(context);
            if (MGA == null) {
                str = "";
            } else {
                str = MGA.versionName;
            }
            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, str);
            return str;
        } catch (Throwable unused) {
            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(DbA, null, "");
            return "";
        }
    }

    public static PackageInfo MGA(Context context) {
        try {
            return WebView.getCurrentWebViewPackage();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    private static PackageInfo du(Context context) {
        try {
            String str = (String) Class.forName("android.webkit.WebViewUpdateService").getMethod("getCurrentWebViewPackageName", new Class[0]).invoke(null, new Object[0]);
            if (str == null) {
                return null;
            }
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean kb(Context context) {
        boolean z;
        boolean z2;
        char c;
        try {
            AtomicReference<Boolean> atomicReference = eli;
            Boolean bool = atomicReference.get();
            if (bool != null) {
                return bool.booleanValue();
            }
            String str = Build.BRAND;
            if (!TextUtils.isEmpty(str)) {
                str = str.toLowerCase();
            }
            String str2 = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str2)) {
                str2 = str2.toLowerCase();
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, Boolean.FALSE);
                return false;
            }
            char c2 = 65535;
            if (TextUtils.isEmpty(str)) {
                z = false;
                z2 = false;
            } else {
                switch (str.hashCode()) {
                    case -759499589:
                        if (str.equals(Constants.REFERRER_API_XIAOMI)) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3418016:
                        if (str.equals("oppo")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    case 3620012:
                        if (str.equals(Constants.REFERRER_API_VIVO)) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case 1864941562:
                        if (str.equals(Constants.REFERRER_API_SAMSUNG)) {
                            c = 3;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
                if (c == 0) {
                    z = FC();
                } else if (c == 1) {
                    z = MGA();
                } else if (c == 2) {
                    z = ui();
                } else if (c != 3) {
                    z = false;
                    z2 = true;
                } else {
                    z = aGH();
                }
                z2 = false;
            }
            if (z2 && !TextUtils.isEmpty(str2)) {
                switch (str2.hashCode()) {
                    case -759499589:
                        if (str2.equals(Constants.REFERRER_API_XIAOMI)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 3418016:
                        if (str2.equals("oppo")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 3620012:
                        if (str2.equals(Constants.REFERRER_API_VIVO)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 1864941562:
                        if (str2.equals(Constants.REFERRER_API_SAMSUNG)) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    z = FC();
                } else if (c2 == 1) {
                    z = MGA();
                } else if (c2 == 2) {
                    z = ui();
                } else {
                    z = c2 != 3 ? false : aGH();
                }
            }
            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, Boolean.valueOf(z));
            return z;
        } catch (Throwable unused) {
            MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(eli, null, Boolean.FALSE);
            return false;
        }
    }

    private static boolean aGH() {
        String lowerCase;
        if (du()) {
            return true;
        }
        String[] strArr = {"sm-f9000", "sm-f9160", "sm-f9260", "sm-f9360", "sm-f9460", "sm-f9560", "sm-f7000", "sm-f7070", "sm-f7110", "sm-f7210", "sm-f7310", "sm-f7410"};
        String[] strArr2 = {"winner", "f2q", "q2q", "q4q", "q5q", "q6q", "bloomq", "bloomxq", "b2q", "b4q", "b5q", "b6q"};
        try {
            String lowerCase2 = Build.DEVICE.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase2)) {
                for (int i = 0; i < 12; i++) {
                    if (lowerCase2.contains(strArr2[i])) {
                        return true;
                    }
                }
            }
            lowerCase = Build.MODEL.toLowerCase();
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(lowerCase)) {
            return false;
        }
        for (int i2 = 0; i2 < 12; i2++) {
            if (lowerCase.contains(strArr[i2])) {
                return true;
            }
        }
        if (DbA()) {
            String eli2 = com.bytedance.sdk.openadsdk.bf.eli.eli("fold_config", "fold_samung", "");
            if (TextUtils.isEmpty(eli2)) {
                return false;
            }
            for (String str : eli2.split(",")) {
                if (lowerCase.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean ui() {
        if (wC()) {
            return true;
        }
        String[] strArr = {"M2011J18C", "22061218C", "2308CPXD0C", "24072PX77C", "2405CPX3DC", "2405CPX3DG"};
        try {
            String lowerCase = Build.MODEL.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i = 0; i < 6; i++) {
                    if (lowerCase.contains(strArr[i])) {
                        return true;
                    }
                }
                if (DbA()) {
                    String Os = Os();
                    if (TextUtils.isEmpty(Os)) {
                        return false;
                    }
                    for (String str : Os.split(",")) {
                        if (lowerCase.contains(str)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean MGA() {
        if (kb()) {
            return true;
        }
        String[] strArr = {"V2330", "V2178A", "V2229A", "V2303A", "V2337A", "V2256A", "V2266A"};
        try {
            String lowerCase = Build.MODEL.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i = 0; i < 7; i++) {
                    if (lowerCase.contains(strArr[i].toLowerCase())) {
                        return true;
                    }
                }
                if (DbA()) {
                    String Os = Os();
                    if (TextUtils.isEmpty(Os)) {
                        return false;
                    }
                    for (String str : Os.split(",")) {
                        if (lowerCase.contains(str.toLowerCase())) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean kb() {
        try {
            return "foldable".equals(Class.forName("android.util.FtDeviceInfo").getMethod("getDeviceType", new Class[0]).invoke(null, new Object[0]));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("BED", "isVIVOFoldDevice return false " + th.getMessage());
            return false;
        }
    }

    private static boolean wC() {
        try {
            return ((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, "persist.sys.muiltdisplay_type", 0)).intValue() == 2;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("BED", "isXiaomiFold return false " + th.getMessage());
            return false;
        }
    }

    private static boolean FC() {
        if (aAs()) {
            return true;
        }
        String[] strArr = {"CPH2439", "CPH2437", "CPH2499", "CPH2519", "PEUM00", "PGU110", "PGT110", "PHN110", "PHT110"};
        try {
            String lowerCase = Build.MODEL.toLowerCase();
            if (!TextUtils.isEmpty(lowerCase)) {
                for (int i = 0; i < 9; i++) {
                    if (lowerCase.contains(strArr[i].toLowerCase())) {
                        return true;
                    }
                }
                if (DbA()) {
                    String Os = Os();
                    if (TextUtils.isEmpty(Os)) {
                        return false;
                    }
                    for (String str : Os.split(",")) {
                        if (lowerCase.contains(str.toLowerCase())) {
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean aAs() {
        try {
            Class<?> cls = Class.forName("com.oplus.content.OplusFeatureConfigManager");
            Object invoke = cls.getDeclaredMethod("hasFeature", String.class).invoke(cls.getMethod(com.unity3d.services.core.fid.Constants.GET_INSTANCE, new Class[0]).invoke(null, new Object[0]), "oplus.hardware.type.fold");
            if (invoke instanceof Boolean) {
                return ((Boolean) invoke).booleanValue();
            }
        } catch (ClassNotFoundException e) {
            e = e;
            com.bytedance.sdk.component.utils.Xb.Os("BED", "get oppo fold properties error, msg: " + e.getMessage());
        } catch (IllegalAccessException e2) {
            e = e2;
            com.bytedance.sdk.component.utils.Xb.Os("BED", "get oppo fold properties error, msg: " + e.getMessage());
        } catch (NoSuchMethodException e3) {
            e = e3;
            com.bytedance.sdk.component.utils.Xb.Os("BED", "get oppo fold properties error, msg: " + e.getMessage());
        } catch (InvocationTargetException e4) {
            e = e4;
            com.bytedance.sdk.component.utils.Xb.Os("BED", "get oppo fold properties error, msg: " + e.getMessage());
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String eli() {
        try {
            return Build.SUPPORTED_ABIS[0];
        } catch (Exception unused) {
            return "";
        }
    }

    public static void eli(JSONObject jSONObject, Context context) {
        if (context == null) {
            return;
        }
        try {
            if (DbA()) {
                com.bytedance.sdk.openadsdk.core.Os eli2 = com.bytedance.sdk.openadsdk.core.Os.eli();
                String DbA2 = eli2.DbA(N6.u, com.bytedance.sdk.openadsdk.core.FC.DbA().kb());
                if (!TextUtils.isEmpty(DbA2)) {
                    jSONObject.put(N6.u, DbA2);
                }
                int DbA3 = eli2.DbA("bp", DbA(context));
                if (DbA3 != 4) {
                    jSONObject.put("bp", DbA3);
                }
                String DbA4 = eli2.DbA("t_ver", Os(context));
                if (!TextUtils.isEmpty(DbA4)) {
                    jSONObject.put("t_ver", DbA4);
                }
                jSONObject.put("is_fold", eli2.DbA("is_fold", kb(context) ? 1 : 0));
                jSONObject.put(CampaignEx.JSON_KEY_AAB, eli2.DbA(CampaignEx.JSON_KEY_AAB, aGH(context)));
                String DbA5 = eli2.DbA("w_ver", ui(context));
                if (!TextUtils.isEmpty(DbA5)) {
                    jSONObject.put("w_ver", DbA5);
                }
                String DbA6 = eli2.DbA("abi", eli());
                if (TextUtils.isEmpty(DbA6)) {
                    return;
                }
                jSONObject.put("abi", DbA6);
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean du() {
        try {
            Class<?> cls = Class.forName("com.samsung.android.feature.SemFloatingFeature");
            Object invoke = cls.getMethod(com.unity3d.services.core.fid.Constants.GET_INSTANCE, new Class[0]).invoke(null, new Object[0]);
            Method declaredMethod = cls.getDeclaredMethod("getString", String.class);
            if ("TRUE".equalsIgnoreCase((String) declaredMethod.invoke(invoke, "SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FOLD"))) {
                return true;
            }
            return "TRUE".equalsIgnoreCase((String) declaredMethod.invoke(invoke, "SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FLIP"));
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            com.bytedance.sdk.component.utils.Xb.Os("PAG_BANNER", "get ss fold device error: " + e.getMessage());
            return false;
        }
    }

    public static boolean DbA() {
        return com.bytedance.sdk.openadsdk.bf.eli.eli("fold_config", a.j, 0) == 1;
    }

    public static String Os() {
        return com.bytedance.sdk.openadsdk.bf.eli.eli("fold_config", "fold_default", "");
    }
}
