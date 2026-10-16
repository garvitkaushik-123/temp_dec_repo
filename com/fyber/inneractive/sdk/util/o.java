package com.fyber.inneractive.sdk.util;

import android.app.Application;
import android.content.Context;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.ironsource.C3040d4;
import com.vungle.ads.internal.protos.Sdk;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static Application f1770a;

    public static void a() {
    }

    public static boolean a(String str) {
        return f1770a.checkCallingOrSelfPermission(str) == 0;
    }

    public static String b(String str) {
        String str2 = (String) n.f1768a.get(str);
        if (!TextUtils.isEmpty(str2)) {
            IAlog.a("Assets cache: returning cached assets for %s", str);
            return str2;
        }
        IAlog.a("Assets cache: reading file: %s", str);
        try {
            InputStream open = f1770a.getAssets().open(str, 3);
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bArr = new byte[4096];
            for (int i = 0; i != -1; i = open.read(bArr)) {
                stringBuffer.append(new String(bArr, 0, i));
            }
            open.close();
            str2 = stringBuffer.toString();
            IAlog.a("Assets cache: success - %s", str);
        } catch (IOException e) {
            IAlog.a("Assets cache: Could not read response from file", new Object[0]);
            IAlog.e(t.b(e), new Object[0]);
        }
        if (!TextUtils.isEmpty(str2)) {
            n.f1768a.put(str, str2);
        }
        return str2;
    }

    public static int c() {
        Application application = f1770a;
        int i = (application == null || application.getResources() == null || application.getResources().getConfiguration() == null) ? 1 : application.getResources().getConfiguration().orientation;
        try {
            if (Settings.System.getInt(application.getContentResolver(), "accelerometer_rotation", 0) != 1) {
                i = 1;
            }
        } catch (Throwable th) {
            IAlog.a("failed getOrientation. returning portrait orientation", th, new Object[0]);
        }
        IAlog.a("The device orientation: %s", i == 1 ? C3040d4.h.D : C3040d4.h.C);
        return i;
    }

    public static int d() {
        int i;
        WindowManager windowManager;
        Display defaultDisplay;
        if (f1770a == null || (windowManager = (WindowManager) IAConfigManager.O.v.a().getSystemService("window")) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            i = -1;
        } else {
            Point point = new Point();
            defaultDisplay.getSize(point);
            i = point.y;
        }
        if (i != -1) {
            return i;
        }
        try {
            DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
            if (displayMetrics != null) {
                i = displayMetrics.heightPixels;
            }
        } catch (Throwable unused) {
        }
        if (i == -1) {
            return 480;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int e() {
        int i;
        WindowManager windowManager;
        Display defaultDisplay;
        if (f1770a != null && (windowManager = (WindowManager) IAConfigManager.O.v.a().getSystemService("window")) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            Point point = new Point();
            defaultDisplay.getSize(point);
            i = point.x;
            if (i == -1) {
                return i;
            }
            try {
                DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
                if (displayMetrics != null) {
                    i = displayMetrics.widthPixels;
                }
            } catch (Throwable unused) {
            }
            return i == -1 ? Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE : i;
        }
        i = -1;
        if (i == -1) {
        }
    }

    public static void f() {
    }

    public static void g() {
    }

    public static String h() {
        IAConfigManager iAConfigManager;
        int i = 0;
        while (true) {
            iAConfigManager = IAConfigManager.O;
            if (!iAConfigManager.y.f1776a.get() || iAConfigManager.y.d.compareAndSet(true, true) || i >= 25) {
                break;
            }
            IAlog.a("UserAgentProvider | waiting on user agent", new Object[0]);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException unused) {
            }
            i++;
        }
        return iAConfigManager.y.a();
    }

    public static void a(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static int a(int i) {
        return Math.round(((IAConfigManager.O.v.a().getResources().getConfiguration().densityDpi / 160.0f) * i) + 0.5f);
    }

    public static int a(float f) {
        return (int) (TypedValue.applyDimension(1, f, IAConfigManager.O.v.a().getResources().getDisplayMetrics()) + 0.5f);
    }

    public static String a(ArrayList arrayList) {
        return String.join(",", arrayList);
    }

    public static int c(int i) {
        try {
            return (int) ((i / (IAConfigManager.O.v.a().getResources().getConfiguration().densityDpi / 160.0f)) + 0.5f);
        } catch (Exception unused) {
            return -1;
        }
    }

    public static void a(Context context, byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = context.openFileOutput("session_details.json", 0);
        } catch (Throwable unused) {
            fileOutputStream = null;
        }
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
        } catch (Throwable unused2) {
            try {
                IAlog.a("writeFileWithContext failed writing %s", "session_details.json");
            } finally {
                t.a(fileOutputStream);
            }
        }
    }

    public static Drawable d(int i) {
        return IAConfigManager.O.v.a().getDrawable(i);
    }

    public static String a(Context context) {
        if (context != null) {
            try {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
                if (signatureArr.length > 0) {
                    Signature signature = signatureArr[0];
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    messageDigest.update(signature.toByteArray());
                    byte[] digest = messageDigest.digest();
                    StringBuilder sb = new StringBuilder();
                    for (byte b : digest) {
                        String hexString = Integer.toHexString(b & 255);
                        if (hexString.length() == 1) {
                            sb.append("0");
                        }
                        sb.append(hexString);
                    }
                    return sb.toString();
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return "";
    }

    public static int b(int i) {
        return (int) (((IAConfigManager.O.v.a().getResources().getConfiguration().densityDpi / 160.0f) * i) + 0.5f);
    }

    public static int b() {
        return ((WindowManager) IAConfigManager.O.v.a().getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public static void a(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
        } else if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).gravity = i;
        } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (i == 17) {
                layoutParams2.addRule(13);
            } else {
                int i2 = i & 7;
                if (i2 == 1) {
                    layoutParams2.addRule(14);
                } else if (i2 == 3) {
                    layoutParams2.addRule(9);
                } else if (i2 == 5) {
                    layoutParams2.addRule(11);
                }
                int i3 = i & 112;
                if (i3 == 16) {
                    layoutParams2.addRule(15);
                } else if (i3 == 48) {
                    layoutParams2.addRule(10);
                } else if (i3 == 80) {
                    layoutParams2.addRule(12);
                }
            }
        }
        view.setLayoutParams(layoutParams);
    }

    public static Context a(View view) {
        if (view != null) {
            return view.getContext();
        }
        return f1770a;
    }
}
