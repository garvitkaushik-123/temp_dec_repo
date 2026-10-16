package io.bidmachine.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.location.Location;
import android.media.MediaMetadataRetriever;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import com.google.common.base.Ascii;
import com.google.common.net.HttpHeaders;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mbridge.msdk.foundation.tools.SameMD5;
import io.bidmachine.Executable;
import io.bidmachine.Function;
import io.bidmachine.SimpleContextProvider;
import io.bidmachine.UserAgentManager;
import io.bidmachine.util.ViewUtils;
import io.bidmachine.util.network.NetworkUtils;
import io.bidmachine.utils.DeviceUtils;
import io.bidmachine.utils.ThrowableRunnable;
import io.bidmachine.utils.lazy.LazyCachedValue;
import io.bidmachine.utils.lazy.LazyValue;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class Utils {
    private static final Handler BACKGROUND_HANDLER;
    private static final LazyCachedValue<Integer> CURRENT_YEAR;
    private static String appName;
    private static String appVersion;
    private static final Handler UI_HANDLER = new Handler(Looper.getMainLooper());
    private static final char[] HEX_ARRAY = "0123456789abcdef".toCharArray();
    private static final char[] UPPER_HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static float getOrDefault(float target, float targetDefault, float def) {
        return target == targetDefault ? def : target;
    }

    public static long getOrDefault(long target, long targetDefault, long def) {
        return target == targetDefault ? def : target;
    }

    public static <T> T oneOf(T primary, T secondary, T otherwise) {
        return primary != null ? primary : secondary != null ? secondary : otherwise;
    }

    static {
        HandlerThread handlerThread = new HandlerThread("BackgroundHandlerThread");
        handlerThread.start();
        BACKGROUND_HANDLER = new Handler(handlerThread.getLooper());
        CURRENT_YEAR = new LazyCachedValue<>(new LazyValue() { // from class: io.bidmachine.core.Utils$$ExternalSyntheticLambda3
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                Integer valueOf;
                valueOf = Integer.valueOf(Utils.safeCalendarGetInstance().get(1));
                return valueOf;
            }
        });
    }

    public static boolean isUiThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void onUiThread(Runnable runnable) {
        if (isUiThread()) {
            runnable.run();
        } else {
            UI_HANDLER.post(runnable);
        }
    }

    public static void onUiThread(Runnable runnable, long delayMillis) {
        UI_HANDLER.postDelayed(runnable, delayMillis);
    }

    public static void cancelUiThreadTask(Runnable runnable) {
        UI_HANDLER.removeCallbacks(runnable);
    }

    public static void onBackgroundThread(Runnable runnable) {
        Looper myLooper = Looper.myLooper();
        Handler handler = BACKGROUND_HANDLER;
        if (myLooper == handler.getLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public static void onBackgroundThread(Runnable runnable, long delay) {
        BACKGROUND_HANDLER.postDelayed(runnable, delay);
    }

    public static void cancelBackgroundThreadTask(Runnable runnable) {
        BACKGROUND_HANDLER.removeCallbacks(runnable);
    }

    public static Handler createHandlerWithMyOrMainLooper() {
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        return new Handler(myLooper);
    }

    public static String readFile(File file) {
        try {
            return streamToString(new FileInputStream(file));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String streamToString(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        String str = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                str = byteArrayOutputStream.toString("UTF-8");
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            byteArrayOutputStream = null;
        }
        flush(byteArrayOutputStream);
        close(byteArrayOutputStream);
        close(inputStream);
        return str;
    }

    public static ConnectivityManager getConnectivityManager(Context context) {
        if (!isPermissionGranted(context, "android.permission.ACCESS_NETWORK_STATE")) {
            Logger.e((LazyValue<String>) new LazyValue() { // from class: io.bidmachine.core.Utils$$ExternalSyntheticLambda2
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String format;
                    format = String.format("Manifest permission not found: %s. Check the integration.", "android.permission.ACCESS_NETWORK_STATE");
                    return format;
                }
            });
            return null;
        }
        try {
            return (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Throwable th) {
            Logger.w(th);
            return null;
        }
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        try {
            ConnectivityManager connectivityManager = getConnectivityManager(context);
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable th) {
            Logger.w(th);
            return null;
        }
    }

    public static NetworkCapabilities getActiveNetworkCapabilities(Context context) {
        ConnectivityManager connectivityManager = getConnectivityManager(context);
        if (connectivityManager == null) {
            return null;
        }
        try {
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null) {
                return null;
            }
            return connectivityManager.getNetworkCapabilities(activeNetwork);
        } catch (Throwable th) {
            Logger.w(th);
            return null;
        }
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static Location getBestLocation(Context context, Location first, Location second) {
        Location location = (Location) oneOf(first, second);
        Location location2 = io.bidmachine.util.Utils.getLocation(context);
        return (location2 == null || (location != null && location2.getTime() < location.getTime())) ? location : location2;
    }

    public static int getUtcOffsetMinutes() {
        return (int) TimeUnit.MILLISECONDS.toMinutes(TimeZone.getDefault().getOffset(System.currentTimeMillis()));
    }

    public static Point getScreenSize(Context context) {
        DisplayMetrics displayMetrics = DeviceUtils.getDisplayMetrics(context);
        return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static float getScreenDensity(Context context) {
        return DeviceUtils.getDisplayMetrics(context).density;
    }

    public static boolean canUseExternalFilesDir() {
        return isExternalMemoryAvailable();
    }

    public static boolean isPermissionGranted(Context context, String permission) {
        if (TextUtils.isEmpty(permission)) {
            return false;
        }
        return context.checkPermission(permission, Process.myPid(), Process.myUid()) == 0;
    }

    static boolean writePermissionGranted(Context context) {
        return isPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static boolean isExternalMemoryAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static byte[] getMD5(byte[] bytes) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(SameMD5.TAG);
            messageDigest.update(bytes);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            Logger.w(e);
            return null;
        }
    }

    public static File getCacheDir(Context context, String dirName) {
        File externalFilesDir = getExternalFilesDir(context);
        if (externalFilesDir == null) {
            return null;
        }
        File file = new File(externalFilesDir.getPath() + RemoteSettings.FORWARD_SLASH_STRING + dirName + RemoteSettings.FORWARD_SLASH_STRING);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static File getExternalFilesDir(Context context) {
        return context.getExternalFilesDir(null);
    }

    public static File getExternalFilesDirDirty(Context context) {
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory == null) {
                return null;
            }
            return new File(externalStorageDirectory, "/Android/data/" + context.getPackageName() + "/files");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isUrlValid(String url) {
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        try {
            new URL(url);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isHttpUrl(String url) {
        return url.startsWith("http://") || url.startsWith("https://");
    }

    public static String generateFileName(String url) {
        return new BigInteger(getMD5(url.getBytes())).abs().toString(36);
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                Logger.w(e);
            }
        }
    }

    public static void flush(Flushable flushable) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Exception e) {
                Logger.w(e);
            }
        }
    }

    public static Rect getViewRectangle(View adView) {
        int[] iArr = new int[2];
        adView.getLocationInWindow(iArr);
        return new Rect(iArr[0], iArr[1], adView.getWidth() + iArr[0], adView.getHeight() + iArr[1]);
    }

    public static boolean isViewTransparent(View view) {
        return view.getAlpha() == 0.0f;
    }

    public static void simpleTrackUrl(final String url, Executor executor) {
        if (TextUtils.isEmpty(url) || executor == null) {
            return;
        }
        try {
            executor.execute(new Runnable() { // from class: io.bidmachine.core.Utils$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Utils.lambda$simpleTrackUrl$2(url);
                }
            });
        } catch (Exception e) {
            Logger.w(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ void lambda$simpleTrackUrl$2(String str) {
        Throwable th;
        HttpURLConnection httpURLConnection;
        Exception e;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                try {
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, "close");
                    httpURLConnection.setRequestMethod("GET");
                    String userAgent = UserAgentManager.getUserAgent();
                    if (!TextUtils.isEmpty(userAgent)) {
                        httpURLConnection.setRequestProperty("User-Agent", userAgent);
                    }
                    httpURLConnection.getResponseCode();
                    if (httpURLConnection != null) {
                        try {
                            close(httpURLConnection.getInputStream());
                        } catch (Exception e2) {
                            e = e2;
                            Logger.w(e);
                            NetworkUtils.disconnectSafely(httpURLConnection);
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    Logger.w(e);
                    if (httpURLConnection != null) {
                        try {
                            close(httpURLConnection.getInputStream());
                        } catch (Exception e4) {
                            e = e4;
                            Logger.w(e);
                            NetworkUtils.disconnectSafely(httpURLConnection);
                        }
                    }
                    NetworkUtils.disconnectSafely(httpURLConnection);
                }
            } catch (Throwable th2) {
                th = th2;
                if (httpURLConnection != null) {
                    try {
                        close(httpURLConnection.getInputStream());
                    } catch (Exception e5) {
                        Logger.w(e5);
                    }
                }
                NetworkUtils.disconnectSafely(httpURLConnection);
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            httpURLConnection = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            if (httpURLConnection != null) {
            }
            NetworkUtils.disconnectSafely(httpURLConnection);
            throw th;
        }
        NetworkUtils.disconnectSafely(httpURLConnection);
    }

    public static boolean canAddWindowToActivity(Activity activity) {
        return (activity == null || activity.getWindow() == null || !activity.getWindow().isActive() || activity.getWindow().getDecorView().getWindowToken() == null) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable, java.io.Flushable] */
    public static String retrieveAndSaveFrame(Context context, Uri videoFileUri, String dirName) {
        FileOutputStream fileOutputStream;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(context, videoFileUri);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
        ?? r2 = 0;
        if (extractMetadata == null) {
            return null;
        }
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(Long.parseLong(extractMetadata), 2);
        try {
            if (frameAtTime != null) {
                try {
                    File file = new File(getCacheDir(context, dirName), generateFileName(videoFileUri.toString()));
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        frameAtTime.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                        String absolutePath = file.getAbsolutePath();
                        flush(fileOutputStream);
                        close(fileOutputStream);
                        return absolutePath;
                    } catch (Exception e) {
                        e = e;
                        Logger.w(e);
                        flush(fileOutputStream);
                        close(fileOutputStream);
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    flush(r2);
                    close(r2);
                    throw th;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            r2 = context;
        }
    }

    public static boolean isYearValid(int year) {
        return year >= 1900 && year <= CURRENT_YEAR.get().intValue();
    }

    @SafeVarargs
    public static Object invokeMethodByName(Object object, String methodName, Pair<Class<?>, Object>... parameterPairs) throws Exception {
        return invokeMethodByName(object, object.getClass(), methodName, parameterPairs);
    }

    @SafeVarargs
    public static Object invokeMethodByName(Object object, Class<?> clazz, String methodName, Pair<Class<?>, Object>... parameterPairs) throws Exception {
        Class<?>[] clsArr;
        Object[] objArr;
        if (parameterPairs != null) {
            clsArr = new Class[parameterPairs.length];
            objArr = new Object[parameterPairs.length];
            for (int i = 0; i < parameterPairs.length; i++) {
                clsArr[i] = (Class) parameterPairs[i].first;
                objArr[i] = parameterPairs[i].second;
            }
        } else {
            clsArr = null;
            objArr = null;
        }
        for (int i2 = 10; i2 > 0 && clazz != null; i2--) {
            try {
                Method declaredMethod = clazz.getDeclaredMethod(methodName, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(object, objArr);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            } catch (NoSuchMethodException unused2) {
                clazz = clazz.getSuperclass();
            }
        }
        return null;
    }

    public static <T> T oneOf(T t, T t2) {
        return (T) oneOf(t, t2, null);
    }

    public static String capitalize(String value) {
        return value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();
    }

    public static String getAppName(Context context) {
        if (appName == null) {
            appName = (String) context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
        }
        return appName;
    }

    public static String getAppVersion(Context context) {
        if (appVersion == null) {
            try {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                if (str != null) {
                    appVersion = str;
                }
            } catch (Exception e) {
                Logger.w(e);
            }
        }
        return appVersion;
    }

    public static boolean canUseCleartextTraffic() {
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
    }

    public static Map<String, String> toMap(JSONObject jsonObject) throws Exception {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jsonObject.opt(next);
            if (opt != null) {
                hashMap.put(next, opt.toString());
            }
        }
        return hashMap;
    }

    public static void startActivity(Context context, Intent intent) {
        try {
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Throwable th) {
            Logger.w(th);
        }
    }

    public static String generateTag(String name, Object object) {
        return name + " @" + Integer.toHexString(object.hashCode());
    }

    public static String toHexString(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        if (bytes.length == 0) {
            return "";
        }
        char[] cArr = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            int i2 = i * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i2] = cArr2[(b & 255) >>> 4];
            cArr[i2 + 1] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }

    public static String toSignatureHexString(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        if (bytes.length == 0) {
            return "";
        }
        char[] cArr = new char[(bytes.length * 3) - 1];
        int i = 0;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            byte b = bytes[i2];
            char[] cArr2 = UPPER_HEX_ARRAY;
            cArr[i] = cArr2[(b & 255) >>> 4];
            int i3 = i + 2;
            cArr[i + 1] = cArr2[b & Ascii.SI];
            if (i2 < bytes.length - 1) {
                i += 3;
                cArr[i3] = AbstractJsonLexerKt.COLON;
            } else {
                i = i3;
            }
        }
        return new String(cArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void sort(CopyOnWriteArrayList<T> list, Comparator<? super T> comparator) {
        Object[] array = list.toArray();
        Arrays.sort(array, comparator);
        for (int i = 0; i < array.length; i++) {
            list.set(i, array[i]);
        }
    }

    public static String checkIfEmpty(String value, String defaultValue) {
        return !TextUtils.isEmpty(value) ? value : defaultValue;
    }

    public static int parseIntOrDefault(String value, int fallback) {
        if (!TextUtils.isEmpty(value)) {
            try {
                return Integer.parseInt(value);
            } catch (Throwable unused) {
            }
        }
        return fallback;
    }

    public static Integer parseIntOrDefault(String value, Integer fallback) {
        if (!TextUtils.isEmpty(value)) {
            try {
                return Integer.valueOf(Integer.parseInt(value));
            } catch (Throwable unused) {
            }
        }
        return fallback;
    }

    public static Float parseFloatOrDefault(String value, Float fallback) {
        if (!TextUtils.isEmpty(value)) {
            try {
                return Float.valueOf(Float.parseFloat(value));
            } catch (Throwable unused) {
            }
        }
        return fallback;
    }

    public static Integer convertToIntOrDefault(Object obj, Integer fallback) {
        if (obj == null) {
            return fallback;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        return parseIntOrDefault(obj.toString(), fallback);
    }

    public static Float convertToFloatOrDefault(Object obj, Float fallback) {
        if (obj == null) {
            return fallback;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        return parseFloatOrDefault(obj.toString(), fallback);
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static <T> String join(List<T> list) {
        return join(list, ", ");
    }

    public static <T> String join(List<T> list, CharSequence delimiter) {
        return join(list, delimiter, new Function() { // from class: io.bidmachine.core.Utils$$ExternalSyntheticLambda1
            @Override // io.bidmachine.Function
            public final Object apply(Object obj) {
                String obj2;
                obj2 = obj.toString();
                return obj2;
            }
        });
    }

    public static <T> String join(List<T> list, CharSequence delimiter, Function<T, String> transformer) {
        String apply;
        if (isEmpty(list)) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder(list.size());
            for (T t : list) {
                if (t != null && (apply = transformer.apply(t)) != null) {
                    if (sb.length() > 0) {
                        sb.append(delimiter);
                    }
                    sb.append(apply);
                }
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Integer safeParseColor(String color) {
        if (TextUtils.isEmpty(color)) {
            return null;
        }
        try {
            return Integer.valueOf(Color.parseColor(color));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Integer parseHorizontalPosition(String horizontalPosition) {
        if (TextUtils.isEmpty(horizontalPosition)) {
            return null;
        }
        horizontalPosition.hashCode();
        switch (horizontalPosition) {
        }
        return null;
    }

    public static Integer parseVerticalPosition(String verticalPosition) {
        if (TextUtils.isEmpty(verticalPosition)) {
            return null;
        }
        verticalPosition.hashCode();
        switch (verticalPosition) {
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void putAll(Map<K, V> to, Map<K, V> from) {
        if (to == null || from == 0) {
            return;
        }
        to.putAll(from);
    }

    public static <T> void ifNotNull(T obj, Executable<T> action) {
        if (obj != null) {
            action.execute(obj);
        }
    }

    public static void ifNotEmpty(String str, Executable<String> action) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        action.execute(str);
    }

    public static void runCatching(ThrowableRunnable action) {
        try {
            action.run();
        } catch (Throwable unused) {
        }
    }

    private static Calendar safeCalendarGetInstance() {
        try {
            try {
                return Calendar.getInstance();
            } catch (Throwable unused) {
                return Calendar.getInstance(Locale.US);
            }
        } catch (Throwable unused2) {
            return Calendar.getInstance(TimeZone.getTimeZone("GMT"), Locale.US);
        }
    }

    public static Context findDialogContext(Context context) {
        return findDialogContext(context, null);
    }

    public static Context findDialogContext(Context context, View view) {
        Activity activity = new SimpleContextProvider(context).getActivity();
        if (activity != null) {
            return activity;
        }
        if (view == null) {
            return context;
        }
        View findContentOrRootView = ViewUtils.findContentOrRootView(view);
        if (findContentOrRootView != null) {
            return findContentOrRootView.getContext();
        }
        return view.getContext();
    }
}
