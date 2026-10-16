package com.inmobi.media;

import android.util.Log;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.InMobiNative;
import com.inmobi.ads.controllers.PublisherCallbacks;
import com.inmobi.commons.core.configs.CrashConfig;
import com.inmobi.sdk.InMobiSdk;
import com.inmobi.sdk.SdkInitializationListener;
import java.lang.reflect.Method;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class Ie {

    /* renamed from: a, reason: collision with root package name */
    public static final ScheduledExecutorService f2319a = Executors.newSingleThreadScheduledExecutor();

    public static final String a(Thread thread, Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", error.getClass().getSimpleName());
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, error.getMessage());
            jSONObject.put("stack", Log.getStackTraceString(error));
            if (thread != null) {
                jSONObject.put("thread", thread.getName());
            }
            long currentTimeMillis = System.currentTimeMillis();
            StackTraceElement[] stackTrace = error.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "getStackTrace(...)");
            boolean b = b(stackTrace);
            S5 s5 = S5.f2425a;
            S5.a(jSONObject, b, currentTimeMillis);
            CrashConfig crashConfig = AbstractC2632ea.f2562a;
            AbstractC2632ea.a(jSONObject, error instanceof OutOfMemoryError, b, currentTimeMillis);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
            return jSONObject2;
        } catch (JSONException e) {
            e.toString();
            return "";
        }
    }

    public static final boolean b(StackTraceElement[] stackTraceElementArr) {
        Intrinsics.checkNotNullParameter(stackTraceElementArr, "<this>");
        Regex regex = new Regex("com\\.inmobi\\.(media|ads|commons|unification|sdk|unifiedId|adquality|compliance)");
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length && !a(stackTraceElementArr[i], InMobiInterstitial.a.class.getSuperclass()) && !a(stackTraceElementArr[i], InMobiInterstitial.a.class) && !a(stackTraceElementArr[i], InMobiNative.NativeCallbacks.class) && !a(stackTraceElementArr[i], InMobiBanner.a.class) && !a(stackTraceElementArr[i], InMobiBanner.a.class.getSuperclass()) && (!Intrinsics.areEqual(stackTraceElementArr[i].getClassName(), InMobiSdk.class.getName()) || !Intrinsics.areEqual(stackTraceElementArr[i].getMethodName(), InMobiSdk.class.getDeclaredMethod("a", SdkInitializationListener.class, String.class).getName())); i++) {
            String className = stackTraceElementArr[i].getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "getClassName(...)");
            String name = C2741l3.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            if (StringsKt.contains$default((CharSequence) className, (CharSequence) name, false, 2, (Object) null)) {
                break;
            }
            String className2 = stackTraceElementArr[i].getClassName();
            Intrinsics.checkNotNullExpressionValue(className2, "getClassName(...)");
            if (regex.containsMatchIn(className2)) {
                return true;
            }
        }
        return false;
    }

    public static final String a(StackTraceElement[] stackTraceElementArr) {
        Intrinsics.checkNotNullParameter(stackTraceElementArr, "<this>");
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            StringBuilder append = sb.append(stackTraceElement.toString());
            Intrinsics.checkNotNullExpressionValue(append, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public static final boolean a(T5 t5) {
        Intrinsics.checkNotNullParameter(t5, "<this>");
        if (t5 instanceof C2757m3) {
            StackTraceElement[] stackTraceElementArr = ((C2757m3) t5).g;
            if (stackTraceElementArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stackTrace");
                stackTraceElementArr = null;
            }
            return b(stackTraceElementArr);
        }
        if (t5 instanceof C2606d1) {
            C2606d1 c2606d1 = (C2606d1) t5;
            if (c2606d1.g != 6) {
                return false;
            }
            return new Regex("com\\.inmobi\\.(media|ads|commons|unification|sdk|unifiedId|adquality|compliance)").containsMatchIn(c2606d1.h);
        }
        if (t5 instanceof mf) {
            return b(((mf) t5).g);
        }
        return false;
    }

    public static final boolean a(StackTraceElement stackTraceElement, Class cls) {
        Intrinsics.checkNotNullParameter(stackTraceElement, "<this>");
        if (cls != null && Intrinsics.areEqual(stackTraceElement.getClassName(), cls.getName())) {
            Method[] declaredMethods = PublisherCallbacks.class.getDeclaredMethods();
            Intrinsics.checkNotNullExpressionValue(declaredMethods, "getDeclaredMethods(...)");
            for (Method method : declaredMethods) {
                if (Intrinsics.areEqual(stackTraceElement.getMethodName(), method.getName())) {
                    return true;
                }
            }
        }
        return false;
    }
}
