package com.ironsource.sdk.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Environment;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import com.ironsource.C3040d4;
import com.ironsource.C3230o8;
import com.ironsource.C3260q4;
import com.ironsource.C3334ub;
import com.ironsource.InterfaceC3381x7;
import com.ironsource.Nd;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.controller.ControllerActivity;
import com.ironsource.sdk.controller.OpenUrlActivity;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;

/* loaded from: classes6.dex */
public class SDKUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3829a = "SDKUtils";
    private static String b = null;
    private static String c = null;
    private static String d = null;
    private static String e = null;
    private static int f = 0;
    private static String g = null;
    private static Map<String, String> h = null;
    private static String i = "";
    private static final AtomicInteger j = new AtomicInteger(1);

    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    private static int a() {
        AtomicInteger atomicInteger;
        int i2;
        int i3;
        do {
            atomicInteger = j;
            i2 = atomicInteger.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!atomicInteger.compareAndSet(i2, i3));
        return i2;
    }

    public static int convertDpToPx(int i2) {
        return (int) TypedValue.applyDimension(0, i2, Resources.getSystem().getDisplayMetrics());
    }

    public static int convertPxToDp(int i2) {
        return (int) TypedValue.applyDimension(1, i2, Resources.getSystem().getDisplayMetrics());
    }

    public static int dpToPx(long j2) {
        return (int) ((j2 * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] encrypt(String str) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance(AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1);
            try {
                messageDigest.reset();
                messageDigest.update(str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
                if (messageDigest != null) {
                }
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
                if (messageDigest != null) {
                }
            }
        } catch (UnsupportedEncodingException e4) {
            e = e4;
            messageDigest = null;
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            messageDigest = null;
        }
        if (messageDigest != null) {
            return messageDigest.digest();
        }
        return null;
    }

    public static String fetchDemandSourceId(Nd nd) {
        return fetchDemandSourceId(nd.a());
    }

    public static String flatMapToJsonAsString(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                try {
                    jSONObject.putOpt(next.getKey(), encodeString(next.getValue()));
                } catch (JSONException e2) {
                    C3260q4.d().a(e2);
                    Logger.i(f3829a, "flatMapToJsonAsStringfailed " + e2.toString());
                }
                it.remove();
            }
        }
        return jSONObject.toString();
    }

    public static int generateViewId() {
        return View.generateViewId();
    }

    public static int getActivityUIFlags(boolean z) {
        return z ? 5894 : 1798;
    }

    public static String getAdvertiserId() {
        return b;
    }

    public static String getControllerConfig() {
        return g;
    }

    public static JSONObject getControllerConfigAsJSONObject() {
        try {
            return new JSONObject(getControllerConfig());
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            return new JSONObject();
        }
    }

    public static String getControllerUrl() {
        return !TextUtils.isEmpty(e) ? e : !TextUtils.isEmpty(d) ? d : "";
    }

    public static int getDebugMode() {
        return f;
    }

    public static String getFileName(String str) {
        try {
            return URLEncoder.encode(str.split(File.separator)[r1.length - 1].split("\\?")[0], "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            return null;
        }
    }

    public static Map<String, String> getInitSDKParams() {
        return h;
    }

    public static String getLimitAdTracking() {
        return c;
    }

    public static String getMD5(String str) {
        try {
            String bigInteger = new BigInteger(1, MessageDigest.getInstance(SameMD5.TAG).digest(str.getBytes())).toString(16);
            while (bigInteger.length() < 32) {
                bigInteger = "0" + bigInteger;
            }
            return bigInteger;
        } catch (NoSuchAlgorithmException e2) {
            C3260q4.d().a(e2);
            throw new RuntimeException(e2);
        }
    }

    public static int getMinOSVersionSupport() {
        return getControllerConfigAsJSONObject().optInt(C3040d4.d.b);
    }

    public static JSONObject getNetworkConfiguration() {
        JSONObject jSONObject = new JSONObject();
        try {
            return getControllerConfigAsJSONObject().getJSONObject(C3040d4.a.b);
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            return jSONObject;
        }
    }

    public static JSONObject getOrientation(Context context) {
        InterfaceC3381x7 i2 = C3334ub.U().i();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orientation", translateOrientation(i2.z(context)));
            return jSONObject;
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            return jSONObject;
        }
    }

    public static C3230o8.e getProductType(String str) {
        C3230o8.e eVar = C3230o8.e.RewardedVideo;
        if (str.equalsIgnoreCase(eVar.toString())) {
            return eVar;
        }
        C3230o8.e eVar2 = C3230o8.e.Interstitial;
        if (str.equalsIgnoreCase(eVar2.toString())) {
            return eVar2;
        }
        return null;
    }

    public static String getSDKVersion() {
        return "8.11.1";
    }

    public static String getTesterParameters() {
        return i;
    }

    public static String getValueFromJsonObject(String str, String str2) {
        try {
            return new JSONObject(str).getString(str2);
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            return null;
        }
    }

    public static boolean isApplicationVisible(Context context) {
        String packageName = context.getPackageName();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.equalsIgnoreCase(packageName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public static boolean isExternalStorageAvailable() {
        try {
            String externalStorageState = Environment.getExternalStorageState();
            if ("mounted".equals(externalStorageState)) {
                return true;
            }
            return "mounted_ro".equals(externalStorageState);
        } catch (Exception e2) {
            C3260q4.d().a(e2);
            return false;
        }
    }

    public static boolean isIronSourceActivity(Activity activity) {
        return (activity instanceof ControllerActivity) || (activity instanceof OpenUrlActivity);
    }

    public static void loadGoogleAdvertiserInfo(Context context) {
        InterfaceC3381x7 i2 = C3334ub.U().i();
        String I = i2.I(context);
        String b2 = i2.b(context);
        if (!TextUtils.isEmpty(I)) {
            b = I;
        }
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        c = b2;
    }

    public static Map<String, String> mergeHashMaps(Map<String, String>[] mapArr) {
        HashMap hashMap = new HashMap();
        if (mapArr != null) {
            for (Map<String, String> map : mapArr) {
                if (map != null) {
                    hashMap.putAll(map);
                }
            }
        }
        return hashMap;
    }

    public static JSONObject mergeJSONObjects(JSONObject jSONObject, JSONObject jSONObject2) throws Exception {
        JSONObject jSONObject3 = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        if (jSONObject != null) {
            jSONObject3 = new JSONObject(jSONObject.toString());
        }
        if (jSONObject2 != null) {
            jSONArray = jSONObject2.names();
        }
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                jSONObject3.putOpt(string, jSONObject2.opt(string));
            }
        }
        return jSONObject3;
    }

    public static int pxToDp(long j2) {
        return (int) ((j2 / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static String requireNonEmptyOrNull(String str, String str2) {
        if (str != null) {
            return str;
        }
        throw new NullPointerException(str2);
    }

    public static <T> T requireNonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static void setControllerConfig(String str) {
        g = str;
        C3334ub.O().y().a(getControllerConfigAsJSONObject());
    }

    public static void setControllerUrl(String str) {
        d = str;
    }

    public static void setCustomControllerUrl(String str) {
        e = str;
    }

    public static void setDebugMode(int i2) {
        f = i2;
    }

    public static void setInitSDKParams(Map<String, String> map) {
        h = map;
    }

    public static void setTesterParameters(String str) {
        i = str;
    }

    public static void showNoInternetDialog(Context context) {
        new AlertDialog.Builder(context).setMessage("No Internet Connection").setPositiveButton("Ok", new a()).show();
    }

    public static void updateControllerConfig(String str, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(g);
            jSONObject2.put(str, jSONObject);
            g = jSONObject2.toString();
        } catch (JSONException e2) {
            C3260q4.d().a(e2);
            Logger.i(f3829a, "Unable to update controllerConfigs: " + e2.toString());
        }
    }

    public static String fetchDemandSourceId(JSONObject jSONObject) {
        String optString = jSONObject.optString("demandSourceId");
        return !TextUtils.isEmpty(optString) ? optString : jSONObject.optString("demandSourceName");
    }

    public static String decodeString(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            C3260q4.d().a(e2);
            Logger.d(f3829a, "Failed decoding string " + e2.getMessage());
            return "";
        }
    }

    public static String encodeString(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replace(Marker.ANY_NON_NULL_MARKER, "%20");
        } catch (UnsupportedEncodingException e2) {
            C3260q4.d().a(e2);
            return "";
        }
    }

    public static String translateDeviceOrientation(int i2) {
        if (i2 == 1) {
            return C3040d4.h.D;
        }
        if (i2 == 2) {
            return C3040d4.h.C;
        }
        return "none";
    }

    public static String translateOrientation(int i2) {
        if (i2 == 1) {
            return C3040d4.h.D;
        }
        if (i2 == 2) {
            return C3040d4.h.C;
        }
        return "none";
    }

    public static String translateRequestedOrientation(int i2) {
        if (i2 == 0) {
            return C3040d4.h.C;
        }
        if (i2 == 1) {
            return C3040d4.h.D;
        }
        if (i2 == 11) {
            return C3040d4.h.C;
        }
        if (i2 == 12) {
            return C3040d4.h.D;
        }
        switch (i2) {
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
}
