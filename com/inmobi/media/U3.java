package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.hardware.display.DisplayManager;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.view.WindowInsetsCompat;
import com.ironsource.C3040d4;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class U3 {
    public static String c;
    public static JSONObject f;
    public static Integer g;
    public static Float h;

    /* renamed from: a, reason: collision with root package name */
    public static final V3 f2447a = new V3(0, 2.0f, 0);
    public static final T3 b = new T3(0, 0);
    public static float d = -1.0f;
    public static boolean e = true;
    public static final boolean i = L3.f2348a.F();

    public static String a() {
        Display a2;
        Context d2 = Uc.d();
        if (d2 == null || (a2 = a(d2)) == null) {
            return "0x0";
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        a2.getMetrics(displayMetrics);
        return new StringBuilder().append(displayMetrics.widthPixels).append('x').append(displayMetrics.heightPixels).toString();
    }

    public static float b() {
        Display a2;
        if (d == -1.0f) {
            Context d2 = Uc.d();
            if (d2 == null || (a2 = a(d2)) == null) {
                return 2.0f;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            a2.getMetrics(displayMetrics);
            float f2 = displayMetrics.density;
            if (f2 == 0.0f) {
                return 2.0f;
            }
            d = f2;
        }
        return d;
    }

    public static HashMap c() {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("d-device-screen-density", String.valueOf(b()));
            V3 d2 = d();
            hashMap.put("d-device-screen-size", new StringBuilder().append(d2.f2459a).append('X').append(d2.b).toString());
            hashMap.put("d-density-dependent-screen-size", a());
            hashMap.put("d-orientation", String.valueOf((int) g()));
            Float f2 = h;
            hashMap.put("d-textsize", String.valueOf(f2 != null ? f2.floatValue() : 37.0f));
            return hashMap;
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("U3", "TAG");
            return hashMap;
        }
    }

    public static V3 d() {
        Display a2;
        Context d2 = Uc.d();
        if (d2 != null && (a2 = a(d2)) != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            a2.getMetrics(displayMetrics);
            float f2 = displayMetrics.density;
            return new V3((int) (displayMetrics.widthPixels / f2), f2, (int) (displayMetrics.heightPixels / f2));
        }
        return f2447a;
    }

    public static String e() {
        String str = null;
        if (e) {
            return null;
        }
        String str2 = c;
        if (str2 != null) {
            return str2;
        }
        Context d2 = Uc.d();
        if (d2 != null) {
            ConcurrentHashMap concurrentHashMap = C6.b;
            C6 a2 = B6.a(d2, "display_info_store");
            Intrinsics.checkNotNullParameter("gesture_margin", C3040d4.h.W);
            str = a2.f2249a.getString("gesture_margin", null);
        }
        c = str;
        return str;
    }

    public static Integer f() {
        Context d2 = Uc.d();
        if (d2 == null) {
            return null;
        }
        int i2 = Settings.Secure.getInt(d2.getContentResolver(), "navigation_mode", -1);
        if (i2 == 0 || i2 == 1) {
            return 0;
        }
        return i2 != 2 ? null : 1;
    }

    public static byte g() {
        Display a2;
        int rotation;
        Context d2 = Uc.d();
        if (d2 == null || (a2 = a(d2)) == null || (rotation = a2.getRotation()) == 0) {
            return (byte) 1;
        }
        if (rotation == 1) {
            return (byte) 3;
        }
        if (rotation == 2) {
            return (byte) 2;
        }
        if (rotation == 3) {
            return (byte) 4;
        }
        Intrinsics.checkNotNullExpressionValue("U3", "TAG");
        return (byte) 1;
    }

    public static V3 h() {
        Display a2;
        Context d2 = Uc.d();
        if (d2 != null && (a2 = a(d2)) != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            a2.getRealMetrics(displayMetrics);
            float f2 = displayMetrics.density;
            return new V3((int) (displayMetrics.widthPixels / f2), f2, (int) (displayMetrics.heightPixels / f2));
        }
        return f2447a;
    }

    public static void a(final WindowInsets insets, final Context context) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (e) {
            return;
        }
        Uc.a(new Runnable() { // from class: com.inmobi.media.U3$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                U3.b(insets, context);
            }
        });
    }

    public static Display a(Context context) {
        if (L3.f2348a.E()) {
            Object systemService = context.getSystemService("display");
            DisplayManager displayManager = systemService instanceof DisplayManager ? (DisplayManager) systemService : null;
            if (displayManager != null) {
                return displayManager.getDisplay(0);
            }
        } else {
            Object systemService2 = context.getSystemService("window");
            WindowManager windowManager = systemService2 instanceof WindowManager ? (WindowManager) systemService2 : null;
            if (windowManager != null) {
                return windowManager.getDefaultDisplay();
            }
        }
        return null;
    }

    public static final void b(Context context) {
        Window window;
        WindowInsets rootWindowInsets;
        if (e || !(context instanceof Activity) || (window = ((Activity) context).getWindow()) == null || (rootWindowInsets = window.getDecorView().getRootWindowInsets()) == null) {
            return;
        }
        a(rootWindowInsets, context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        if (r3.bottom == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
    
        if (r3.bottom == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
    
        if (r3.right == 0) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(WindowInsets insets) {
        int i2;
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (L3.f2348a.z()) {
            EnumC2813pa a2 = AbstractC2829qa.a(g());
            Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemGestures());
            Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
            int ordinal = a2.ordinal();
            i2 = 1;
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal != 3) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (insets2.right == 0) {
                        }
                    }
                } else if (insets2.left == 0) {
                }
                Intrinsics.checkNotNullExpressionValue("U3", "TAG");
                return i2;
            }
            if (insets2.left == 0) {
            }
            Intrinsics.checkNotNullExpressionValue("U3", "TAG");
            return i2;
        }
        i2 = 0;
        Intrinsics.checkNotNullExpressionValue("U3", "TAG");
        return i2;
    }

    public static final void b(WindowInsets insets, Context context) {
        Intrinsics.checkNotNullParameter(insets, "$insets");
        try {
            String insets2 = insets.getSystemGestureInsets().toString();
            Intrinsics.checkNotNullExpressionValue(insets2, "toString(...)");
            String[] strArr = (String[]) new Regex("Insets").split(insets2, 0).toArray(new String[0]);
            StringBuffer stringBuffer = new StringBuffer();
            if (strArr.length > 1) {
                String[] strArr2 = (String[]) new Regex(",").split(new Regex("[^0-9,=a-zA-Z]*").replace(strArr[1], ""), 0).toArray(new String[0]);
                stringBuffer.append("{");
                int length = strArr2.length;
                for (int i2 = 0; i2 < length; i2++) {
                    String[] strArr3 = (String[]) new Regex(C3040d4.i.b).split(strArr2[i2], 0).toArray(new String[0]);
                    if (strArr3.length == 2) {
                        stringBuffer.append('\"' + strArr3[0] + '\"');
                        stringBuffer.append(":");
                        stringBuffer.append(B2.b(Integer.parseInt(strArr3[1]) / b()));
                        if (i2 < strArr2.length - 1) {
                            stringBuffer.append(", ");
                        }
                    }
                }
                stringBuffer.append("}");
            }
            if (stringBuffer.length() > 0) {
                c = stringBuffer.toString();
                ConcurrentHashMap concurrentHashMap = C6.b;
                Intrinsics.checkNotNull(context);
                C6.a(B6.a(context, "display_info_store"), "gesture_margin", stringBuffer.toString(), false, 4, (Object) null);
            }
        } catch (Exception unused) {
            Intrinsics.checkNotNullExpressionValue("U3", "TAG");
        }
    }

    public static void a(final LinkedHashMap value) {
        Intrinsics.checkNotNullParameter(value, "value");
        final Context d2 = Uc.d();
        if (d2 == null) {
            return;
        }
        Uc.a(new Runnable() { // from class: com.inmobi.media.U3$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                U3.a(value, d2);
            }
        });
    }

    public static final void a(Map value, Context context) {
        Intrinsics.checkNotNullParameter(value, "$value");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullExpressionValue("U3", "TAG");
        Objects.toString(value);
        if (f == null) {
            f = new JSONObject();
        }
        Iterator it = value.keySet().iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            JSONObject jSONObject = f;
            if (jSONObject != null) {
                jSONObject.put(String.valueOf(intValue), value.get(Integer.valueOf(intValue)));
            }
        }
        ConcurrentHashMap concurrentHashMap = C6.b;
        C6 a2 = B6.a(context, "display_info_store");
        JSONObject jSONObject2 = f;
        C6.a(a2, "safe_area", jSONObject2 != null ? jSONObject2.toString() : null, false, 4, (Object) null);
    }

    public static void a(final Integer num) {
        final Context d2 = Uc.d();
        if (d2 == null) {
            return;
        }
        Uc.a(new Runnable() { // from class: com.inmobi.media.U3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                U3.a(num, d2);
            }
        });
    }

    public static final void a(Integer num, Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullExpressionValue("U3", "TAG");
        g = num;
        ConcurrentHashMap concurrentHashMap = C6.b;
        C6.a(B6.a(context, "display_info_store"), "nav_bar_type", num != null ? num.intValue() : -1, false, 4, (Object) null);
    }
}
