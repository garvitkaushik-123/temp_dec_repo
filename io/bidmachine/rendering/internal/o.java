package io.bidmachine.rendering.internal;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.C3040d4;
import java.net.UnknownHostException;

/* loaded from: classes8.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f7078a = false;

    public static void a(boolean isEnabled) {
        f7078a = isEnabled;
    }

    public static boolean b() {
        return f7078a;
    }

    public static void a(Object tag, String format, Object... params) {
        a(tag, format, true, params);
    }

    public static void b(Object tag, String message, Object... params) {
        a(tag, message, false, params);
    }

    public static void a(String format, Object... params) {
        a(null, format, true, params);
    }

    public static void b(Throwable throwable) {
        a(throwable);
    }

    private static void a(Object subTag, String message, boolean isError, Object... params) {
        if (a()) {
            if (params != null && params.length != 0) {
                try {
                    message = String.format(message, params);
                } catch (Throwable unused) {
                }
            }
            if (subTag != null) {
                String obj = subTag.toString();
                if (!TextUtils.isEmpty(obj)) {
                    message = C3040d4.i.d + obj + "] " + message;
                }
            }
            if (isError) {
                Log.e("AdaptiveRendering", message);
            } else {
                Log.d("AdaptiveRendering", message);
            }
        }
    }

    private static void a(Throwable throwable) {
        if (a()) {
            if (throwable instanceof UnknownHostException) {
                throwable.printStackTrace();
            } else {
                Log.w("AdaptiveRendering", throwable);
            }
        }
    }

    public static boolean a() {
        return b();
    }
}
