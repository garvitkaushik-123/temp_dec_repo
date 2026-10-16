package com.pgl.ssdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.input.InputManager;
import android.os.Build;
import android.text.TextUtils;
import android.view.InputDevice;
import android.view.MotionEvent;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private static int f6417a = 0;
    private static int b = 0;
    private static int c = 0;
    private static int d = 0;
    private static int e = 0;
    private static int f = 0;
    public static volatile boolean g = false;
    private static boolean h = false;
    private static InputManager i;

    static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6418a;
        final /* synthetic */ Context b;
        final /* synthetic */ int c;

        a(String str, Context context, int i) {
            this.f6418a = str;
            this.b = context;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (y.g) {
                com.pgl.ssdk.ces.a.meta(171, null, this.f6418a);
            }
            InputManager b = y.b(this.b);
            if (b == null) {
                return;
            }
            InputDevice inputDevice = b.getInputDevice(this.c);
            y.h();
            if (inputDevice == null) {
                y.b();
                y.c();
                y.c("nihc");
            } else if (inputDevice.isVirtual()) {
                y.d();
                y.e();
                y.c("vihc");
            } else {
                if (Build.VERSION.SDK_INT < 29 || !inputDevice.isExternal()) {
                    return;
                }
                y.f();
                y.g();
                y.c("eihc");
            }
        }
    }

    static /* synthetic */ int b() {
        int i2 = c;
        c = i2 + 1;
        return i2;
    }

    static /* synthetic */ int c() {
        int i2 = f;
        f = i2 + 1;
        return i2;
    }

    static /* synthetic */ int d() {
        int i2 = f6417a;
        f6417a = i2 + 1;
        return i2;
    }

    static /* synthetic */ int e() {
        int i2 = d;
        d = i2 + 1;
        return i2;
    }

    static /* synthetic */ int f() {
        int i2 = b;
        b = i2 + 1;
        return i2;
    }

    static /* synthetic */ int g() {
        int i2 = e;
        e = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h() {
        if (h) {
            return;
        }
        try {
            SharedPreferences a2 = x0.a(z.b());
            if (a2 != null) {
                f = a2.getInt("nihc", 0);
                e = a2.getInt("eihc", 0);
                d = a2.getInt("vihc", 0);
                h = true;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int b(String str) {
        char c2;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        h();
        str.hashCode();
        str.hashCode();
        switch (str.hashCode()) {
            case 100415:
                if (str.equals("eic")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 109064:
                if (str.equals("nic")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 116752:
                if (str.equals("vic")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 3113119:
                if (str.equals("eihc")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 3381238:
                if (str.equals("nihc")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 3619566:
                if (str.equals("vihc")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str) {
        try {
            SharedPreferences a2 = x0.a(z.b());
            if (a2 != null) {
                a2.edit().putInt(str, a2.getInt(str, 0) + 1).apply();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        if (r0.contains("android.view.ViewRootImpl$InputStage") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(MotionEvent motionEvent, Context context) {
        String str;
        if (motionEvent == null || context == null) {
            return;
        }
        if (g) {
            try {
                if (motionEvent.getToolType(0) == 0 || motionEvent.getSource() == 0 || motionEvent.getSource() == 2) {
                    str = Arrays.toString(new Exception().getStackTrace());
                    if (!str.contains("android.view.InputEventReceiver") && !str.contains("android.view.ViewRootImpl$WindowInputEventReceiver")) {
                    }
                }
            } catch (Throwable unused) {
            }
        }
        str = null;
        r0.b(new a(str, context, motionEvent.getDeviceId()));
    }

    public static void a(JSONObject jSONObject) {
        h();
        try {
            jSONObject.put("vihc", d);
            jSONObject.put("eihc", e);
            jSONObject.put("nihc", f);
            jSONObject.put("vic", f6417a);
            jSONObject.put("nic", c);
            jSONObject.put("eic", b);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputManager b(Context context) {
        if (i == null) {
            i = (InputManager) context.getSystemService("input");
        }
        return i;
    }
}
