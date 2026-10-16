package io.bidmachine.iab.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.google.common.net.HttpHeaders;
import io.bidmachine.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import io.bidmachine.rendering.Rendering;
import io.bidmachine.util.network.NetworkUtils;
import java.io.Closeable;
import java.io.Flushable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes7.dex */
public class Utils {

    /* renamed from: a, reason: collision with root package name */
    private static final Handler f6860a = new Handler(Looper.getMainLooper());

    class a implements View.OnApplyWindowInsetsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6861a;

        a(final int val$typeInsets) {
            this.f6861a = val$typeInsets;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            Insets insets = windowInsets.getInsets(this.f6861a);
            view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
            return windowInsets;
        }
    }

    private static float a(final float pixels, final float density) {
        return pixels / density;
    }

    private static float a(int horizontalGravity) {
        if (horizontalGravity == 1) {
            return 0.5f;
        }
        if (horizontalGravity != 3) {
            return horizontalGravity != 17 ? 1.0f : 0.5f;
        }
        return 0.0f;
    }

    public static void applyFullscreenActivityFlags(Activity activity) {
        applyFullscreenActivityFlags(activity, true);
    }

    public static void applyWindowInsets(Activity activity) {
        if (Build.VERSION.SDK_INT >= 34) {
            Window window = activity.getWindow();
            if (window != null) {
                applyWindowInsets(window.getDecorView());
            } else {
                applyWindowInsets(activity.findViewById(R.id.content));
            }
        }
    }

    private static float b(int verticalGravity) {
        if (verticalGravity == 16 || verticalGravity == 17) {
            return 0.5f;
        }
        return verticalGravity != 80 ? 0.0f : 1.0f;
    }

    public static void cancelOnUiThread(Runnable runnable) {
        f6860a.removeCallbacks(runnable);
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                CommonLog.e("Utils", th);
            }
        }
    }

    public static Float convertCssSizeToPx(String value) {
        return Float.valueOf(value.replace("px", ""));
    }

    public static int dpToPx(Context context, float size) {
        return (int) TypedValue.applyDimension(1, size, context.getResources().getDisplayMetrics());
    }

    public static void flush(Flushable flushable) {
        if (flushable != null) {
            try {
                flushable.flush();
            } catch (Throwable th) {
                CommonLog.e("Utils", th);
            }
        }
    }

    public static int generateViewId() {
        return View.generateViewId();
    }

    public static Point getClickPoint(Rect rect, int horizontalGravity, int verticalGravity) {
        return getClickPoint(rect.width(), rect.height(), horizontalGravity, verticalGravity);
    }

    public static Point getDefaultClickPoint(Rect rect) {
        return getDefaultClickPoint(rect.width(), rect.height());
    }

    public static int getScreenOrientation(Context context) {
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        int i = context.getResources().getConfiguration().orientation;
        if (i == 1) {
            return (rotation == 2 || rotation == 3) ? 9 : 1;
        }
        if (i == 2) {
            return (rotation == 2 || rotation == 3) ? 8 : 0;
        }
        return 9;
    }

    public static boolean isLandscapeOrientation(Context context) {
        int screenOrientation = getScreenOrientation(context);
        return screenOrientation == 0 || screenOrientation == 8 || screenOrientation == 6 || screenOrientation == 11;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        CommonLog.d("Utils", "Testing connectivity:", new Object[0]);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            CommonLog.d("Utils", "No Internet connection", new Object[0]);
            return false;
        }
        CommonLog.d("Utils", "Connected to Internet", new Object[0]);
        return true;
    }

    public static boolean isTablet(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        double d = displayMetrics.widthPixels / displayMetrics.xdpi;
        double d2 = displayMetrics.heightPixels / displayMetrics.ydpi;
        return Math.sqrt((d * d) + (d2 * d2)) >= 6.6d;
    }

    public static boolean isViewTransparent(View view) {
        return view.getAlpha() == 0.0f;
    }

    public static Float max(Float first, Float second) {
        return first == null ? second : second == null ? first : Float.valueOf(Math.max(first.floatValue(), second.floatValue()));
    }

    public static Float min(Float first, Float second) {
        return first == null ? second : second == null ? first : Float.valueOf(Math.min(first.floatValue(), second.floatValue()));
    }

    public static MotionEvent obtainMotionEvent(int action, int x, int y) {
        return MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), action, x, y, 0);
    }

    public static void onUiThread(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            f6860a.post(runnable);
        }
    }

    public static int orientationBySize(int width, int height) {
        return width > height ? 2 : 1;
    }

    public static String orientationToString(int orientation) {
        return orientation != 0 ? orientation != 1 ? orientation != 2 ? "UNKNOWN" : "LANDSCAPE" : "PORTRAIT" : "UNDEFINED";
    }

    public static int pixelsToIntDips(final float pixels, final float density) {
        return (int) (a(pixels, density) + 0.5f);
    }

    public static void postOnUiThread(Runnable runnable) {
        f6860a.post(runnable);
    }

    public static void removeFromParent(View view) {
        if (view == null || view.getParent() == null || !(view.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) view.getParent()).removeView(view);
    }

    public static void simpleTrackUrl(final String url) {
        simpleTrackUrl(url, Executors.newSingleThreadExecutor());
    }

    public static String stringifyRect(Rect rect) {
        return rect.left + "," + rect.top + "," + rect.width() + "," + rect.height();
    }

    public static String stringifySize(Rect rect) {
        return rect.width() + "," + rect.height();
    }

    public static void applyFullscreenActivityFlags(Activity activity, boolean isNoStatusBar) {
        activity.requestWindowFeature(1);
        Window window = activity.getWindow();
        if (window != null) {
            window.addFlags(128);
            a(window, isNoStatusBar);
        }
        a(activity);
    }

    public static Point getClickPoint(int width, int height, int horizontalGravity, int verticalGravity) {
        Random random = new Random();
        return new Point((int) (width * a(random, 0.1f, a(horizontalGravity))), (int) (height * a(random, 0.1f, b(verticalGravity))));
    }

    public static Point getDefaultClickPoint(int width, int height) {
        return new Point(Math.round(width * 0.5f), Math.round(height * 0.7f));
    }

    public static void simpleTrackUrl(final String url, final Executor executor) {
        if (TextUtils.isEmpty(url)) {
            CommonLog.d("Utils", "url is null or empty", new Object[0]);
            return;
        }
        try {
            executor.execute(new Runnable() { // from class: io.bidmachine.iab.utils.Utils$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    Utils.a(url);
                }
            });
        } catch (Exception e) {
            CommonLog.e("Utils", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str) {
        HttpURLConnection httpURLConnection;
        Exception e;
        HttpURLConnection httpURLConnection2 = null;
        try {
            CommonLog.d("Utils", "Connection to URL: %s", str);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                try {
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, "close");
                    httpURLConnection.setRequestMethod("GET");
                    String userAgent = Rendering.getUserAgent();
                    if (!TextUtils.isEmpty(userAgent)) {
                        httpURLConnection.setRequestProperty("User-Agent", userAgent);
                    }
                    CommonLog.d("Utils", "Response code: %d, for URL: %s", Integer.valueOf(httpURLConnection.getResponseCode()), str);
                } catch (Exception e2) {
                    e = e2;
                    CommonLog.e("Utils", "%s: %s: %s", str, e.getMessage(), e.toString());
                    NetworkUtils.disconnectSafely(httpURLConnection);
                }
            } catch (Throwable th) {
                th = th;
                httpURLConnection2 = httpURLConnection;
                NetworkUtils.disconnectSafely(httpURLConnection2);
                throw th;
            }
        } catch (Exception e3) {
            httpURLConnection = null;
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            NetworkUtils.disconnectSafely(httpURLConnection2);
            throw th;
        }
        NetworkUtils.disconnectSafely(httpURLConnection);
    }

    public static void onUiThread(Runnable runnable, long delayMillis) {
        f6860a.postDelayed(runnable, delayMillis);
    }

    public static void applyWindowInsets(View view) {
        applyWindowInsets(view, WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout());
    }

    public static void applyWindowInsets(View view, int typeInsets) {
        view.setOnApplyWindowInsetsListener(new a(typeInsets));
        view.requestApplyInsets();
    }

    private static void a(Window window, boolean isNoStatusBar) {
        int i;
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController windowInsetsController = window.getDecorView().getWindowInsetsController();
            if (windowInsetsController == null) {
                return;
            }
            windowInsetsController.setSystemBarsBehavior(2);
            if (isNoStatusBar) {
                windowInsetsController.hide(WindowInsets.Type.statusBars());
                return;
            }
            return;
        }
        if (isNoStatusBar) {
            window.setFlags(1024, 1024);
            i = 4;
        } else {
            i = 0;
        }
        if (i > 0) {
            window.getDecorView().setSystemUiVisibility(i);
        }
    }

    private static void a(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null) {
            currentFocus = new View(activity);
        }
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    private static double a(Random random, float sigma, float average) {
        double sqrt = Math.sqrt(Math.log(Math.abs(((random.nextLong() % SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) + 1) / 100000.0d)) * (-2.0d)) * Math.sin(Math.abs(((random.nextLong() % SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US) + 1) / 100000.0d) * 6.283185307179586d);
        double d = average;
        return Math.min(1.0d, Math.max(0.0d, (d < 0.4d || d > 0.6d) ? d < 0.4d ? d + (sigma / (sqrt * sqrt)) : d - (sigma / (sqrt * sqrt)) : (sqrt * sigma) + d));
    }
}
