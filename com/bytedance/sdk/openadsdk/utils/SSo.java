package com.bytedance.sdk.openadsdk.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Picture;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SSo {
    private static int DbA = -1;
    private static int FC = -1;
    private static int MGA = -1;
    private static boolean NU = true;
    private static float Os = -1.0f;
    private static float aAs = -1.0f;
    private static int aGH = -1;
    private static Boolean du = null;
    private static float eli = -1.0f;
    private static WindowManager kb = null;
    private static final Object nlS = new Object();
    private static int ui = -1;
    private static ViewConfiguration wC;

    private static boolean eli(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    private static boolean Os() {
        return eli < 0.0f || DbA < 0 || Os < 0.0f || aGH < 0 || ui < 0;
    }

    public static void eli(Context context) {
        eli(context, false);
    }

    public static void eli(Context context, boolean z) {
        Context eli2 = context == null ? com.bytedance.sdk.openadsdk.core.dV.eli() : context;
        if (eli2 == null) {
            return;
        }
        kb = (WindowManager) eli2.getSystemService("window");
        if (Os() || z) {
            DisplayMetrics displayMetrics = eli2.getResources().getDisplayMetrics();
            eli = displayMetrics.density;
            DbA = displayMetrics.densityDpi;
            Os = displayMetrics.scaledDensity;
            aGH = displayMetrics.widthPixels;
            ui = displayMetrics.heightPixels;
        }
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration.orientation == 1) {
            int i = aGH;
            int i2 = ui;
            if (i > i2) {
                aGH = i2;
                ui = i;
            }
        } else {
            int i3 = aGH;
            int i4 = ui;
            if (i3 < i4) {
                aGH = i4;
                ui = i3;
            }
        }
        MGA = configuration.smallestScreenWidthDp;
    }

    public static float eli(Context context, float f) {
        eli(context);
        return f * FC(context);
    }

    public static int DbA(Context context, float f) {
        if (f == 0.0f) {
            return 0;
        }
        return Float.valueOf(eli(context, f, true)).intValue();
    }

    public static float eli(Context context, float f, boolean z) {
        eli(context);
        return (f * wC(context)) + (z ? 0.5f : 0.0f);
    }

    public static int Os(Context context, float f) {
        eli(context, true);
        float wC2 = wC(context);
        if (wC2 <= 0.0f) {
            wC2 = 1.0f;
        }
        return (int) ((f / wC2) + 0.5f);
    }

    public static int[] DbA(Context context) {
        if (context == null) {
            return null;
        }
        if (kb == null) {
            kb = (WindowManager) com.bytedance.sdk.openadsdk.core.dV.eli().getSystemService("window");
        }
        int[] iArr = new int[2];
        WindowManager windowManager = kb;
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            try {
                Point point = new Point();
                Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
                i = point.x;
                i2 = point.y;
            } catch (Exception unused) {
            }
            iArr[0] = i;
            iArr[1] = i2;
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int Os(Context context) {
        eli(context);
        return aGH;
    }

    public static int aGH(Context context) {
        eli(context);
        return Os(context, aGH);
    }

    public static int ui(Context context) {
        eli(context);
        return ui;
    }

    public static int MGA(Context context) {
        if (context == null) {
            com.bytedance.sdk.openadsdk.core.dV.eli();
        }
        if (context == null) {
            return MGA;
        }
        if (context.getResources() != null && context.getResources().getConfiguration() != null) {
            MGA = context.getResources().getConfiguration().smallestScreenWidthDp;
        }
        return MGA;
    }

    public static int kb(Context context) {
        eli(context);
        return Os(context, ui);
    }

    public static float wC(Context context) {
        eli(context, true);
        return eli;
    }

    public static float FC(Context context) {
        eli(context);
        return Os;
    }

    public static int aAs(Context context) {
        eli(context);
        return DbA;
    }

    public static int[] eli(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] DbA(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] Os(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    public static void eli(View view, int i) {
        if (view == null || view.getVisibility() == i || !eli(i)) {
            return;
        }
        view.setVisibility(i);
    }

    public static boolean aGH(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static void eli(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    public static void eli(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        eli(view, (ViewGroup.MarginLayoutParams) layoutParams, i, i2, i3, i4);
    }

    private static void eli(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i && marginLayoutParams.topMargin == i2 && marginLayoutParams.rightMargin == i3 && marginLayoutParams.bottomMargin == i4) {
            return;
        }
        if (i != -3) {
            marginLayoutParams.leftMargin = i;
        }
        if (i2 != -3) {
            marginLayoutParams.topMargin = i2;
        }
        if (i3 != -3) {
            marginLayoutParams.rightMargin = i3;
        }
        if (i4 != -3) {
            marginLayoutParams.bottomMargin = i4;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    private static Bitmap eli(WebView webView) {
        Bitmap bitmap = null;
        try {
            Picture capturePicture = webView.capturePicture();
            bitmap = Bitmap.createBitmap(capturePicture.getWidth(), capturePicture.getHeight(), Bitmap.Config.ARGB_8888);
            capturePicture.draw(new Canvas(bitmap));
            return bitmap;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("UIUtils", th.getMessage());
            return bitmap;
        }
    }

    public static void ui(View view) {
        if (view == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(view);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.SSo.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                View view2 = (View) weakReference.get();
                if (view2 != null) {
                    SSo.eli(view2, 8);
                    view2.setAlpha(1.0f);
                }
            }
        });
        ofFloat.setDuration(800L);
        ofFloat.start();
    }

    public static void MGA(View view) {
        if (view == null) {
            return;
        }
        eli(view, 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.SSo.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        ofFloat.setDuration(300L);
        ofFloat.start();
    }

    public static Pair<Integer, Integer> du(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.dV.eli();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return new Pair<>(Integer.valueOf(point.x), Integer.valueOf(point.y));
    }

    public static int nlS(Context context) {
        return ((Integer) du(context).second).intValue();
    }

    public static int NU(Context context) {
        return ((Integer) du(context).first).intValue();
    }

    public static float eli() {
        float f = aAs;
        if (f > 0.0f) {
            return f;
        }
        Resources resources = com.bytedance.sdk.openadsdk.core.dV.eli().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            return 0.0f;
        }
        float dimensionPixelSize = resources.getDimensionPixelSize(identifier);
        aAs = dimensionPixelSize;
        return dimensionPixelSize;
    }

    public static void eli(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(3846);
            activity.getWindow().addFlags(1792);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.Xb.Os("UIUtils", e.getMessage());
        }
    }

    public static void DbA(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(1792);
            activity.getWindow().clearFlags(1792);
        } catch (Exception unused) {
        }
    }

    public static boolean Os(Activity activity) {
        if (du == null) {
            synchronized (nlS) {
                if (du == null) {
                    String eli2 = com.bytedance.sdk.openadsdk.bf.eli.eli("cutout_devices", "");
                    String str = Build.MODEL;
                    if (!TextUtils.isEmpty(eli2) && !TextUtils.isEmpty(str)) {
                        try {
                            JSONArray jSONArray = new JSONArray(eli2);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                if (str.equals(jSONArray.getString(i))) {
                                    du = Boolean.TRUE;
                                    return true;
                                }
                            }
                        } catch (Exception e) {
                            com.bytedance.sdk.component.utils.Xb.Os("UIUtils", e.getMessage());
                        }
                    }
                    du = Boolean.valueOf(aGH(activity) || eli("ro.miui.notch", activity) == 1 || nn(activity) || nGm(activity) || Dfc(activity) || aqO(activity) || dV(activity));
                }
            }
        }
        return du.booleanValue();
    }

    public static boolean DbA() {
        return NU;
    }

    public static boolean aGH(Activity activity) {
        DisplayCutout displayCutout;
        try {
            WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            if (rootWindowInsets != null) {
                displayCutout = rootWindowInsets.getDisplayCutout();
                NU = false;
            } else {
                displayCutout = null;
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.Xb.Os("UIUtils", e.getMessage());
        }
        return displayCutout != null;
    }

    public static int eli(String str, Activity activity) {
        if (Ue.ui()) {
            try {
                Class<?> loadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
                return ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, new String(str), 0)).intValue();
            } catch (ClassNotFoundException e) {
                com.bytedance.sdk.component.utils.Xb.Os("UIUtils", e.getMessage());
            } catch (IllegalAccessException e2) {
                com.bytedance.sdk.component.utils.Xb.Os("UIUtils", e2.getMessage());
            } catch (IllegalArgumentException e3) {
                com.bytedance.sdk.component.utils.Xb.Os("UIUtils", e3.getMessage());
            } catch (NoSuchMethodException e4) {
                com.bytedance.sdk.component.utils.Xb.Os("UIUtils", e4.getMessage());
            } catch (InvocationTargetException e5) {
                com.bytedance.sdk.component.utils.Xb.Os("UIUtils", e5.getMessage());
            }
        }
        return 0;
    }

    public static boolean nn(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static boolean Dfc(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static boolean aqO(Context context) {
        return Build.MODEL.equals("IN2010") || Build.MODEL.equals("IN2020") || Build.MODEL.equals("KB2000") || Build.MODEL.startsWith("ONEPLUS");
    }

    public static boolean dV(Context context) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");
            String string = identifier > 0 ? resources.getString(identifier) : null;
            if (string != null) {
                if (!TextUtils.isEmpty(string)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean nGm(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static void eli(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.Xb.Os("OnclickListener ", str + " is null , can not set OnClickListener !!!");
        } else {
            view.setOnClickListener(onClickListener);
        }
    }

    public static void eli(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.Xb.Os("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
        } else {
            view.setOnTouchListener(onTouchListener);
        }
    }

    public static void eli(View view, float f) {
        if (view == null) {
            return;
        }
        view.setAlpha(f);
    }

    public static void eli(TextView textView, com.bytedance.sdk.openadsdk.core.widget.aqO aqo, com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        eli(textView, aqo, evVar, 14);
    }

    public static void eli(TextView textView, com.bytedance.sdk.openadsdk.core.widget.aqO aqo, com.bytedance.sdk.openadsdk.core.model.ev evVar, int i) {
        eli(textView, aqo, (evVar == null || evVar.pu() == null) ? -1.0d : evVar.pu().aGH(), i);
    }

    public static void eli(TextView textView, com.bytedance.sdk.openadsdk.core.widget.aqO aqo, double d, int i) {
        if (d == -1.0d) {
            if (textView != null) {
                textView.setVisibility(8);
            }
            aqo.setVisibility(8);
        } else {
            if (textView != null) {
                textView.setText(String.format(Locale.getDefault(), "%.1f", Double.valueOf(d)));
            }
            eli(aqo, d, i);
        }
    }

    public static void eli(com.bytedance.sdk.openadsdk.core.widget.aqO aqo, double d, int i) {
        if (d < 0.0d) {
            aqo.setVisibility(8);
        } else {
            aqo.setVisibility(0);
            aqo.eli(d, i);
        }
    }

    public static Bitmap eli(com.bytedance.sdk.component.FC.MGA mga) {
        WebView webView = mga.getWebView();
        int layerType = webView.getLayerType();
        webView.setLayerType(1, null);
        Bitmap DbA2 = DbA(mga);
        if (DbA2 == null) {
            DbA2 = eli(webView);
        }
        webView.setLayerType(layerType, null);
        if (DbA2 == null) {
            return null;
        }
        return com.bytedance.sdk.component.utils.aGH.eli(DbA2, DbA2.getWidth() / 6, DbA2.getHeight() / 6);
    }

    public static void eli(final com.bytedance.sdk.openadsdk.core.model.ev evVar, final String str, final String str2, final Bitmap bitmap, final String str3, final long j) {
        cyF.DbA(new com.bytedance.sdk.component.wC.wC("startCheckPlayableStatusPercentage") { // from class: com.bytedance.sdk.openadsdk.utils.SSo.3
            @Override // java.lang.Runnable
            public void run() {
                SSo.Os(evVar, str, str2, bitmap, str3, j);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Os(final com.bytedance.sdk.openadsdk.core.model.ev evVar, String str, String str2, final Bitmap bitmap, final String str3, final long j) {
        if (bitmap != null) {
            try {
                if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && !bitmap.isRecycled()) {
                    com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), evVar, str, str2, new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.utils.SSo.4
                        @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
                        public JSONObject eli() {
                            try {
                                int eli2 = SSo.eli(bitmap);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("url", str3);
                                long j2 = j;
                                if (j2 != -1) {
                                    jSONObject.put("page_id", j2);
                                }
                                jSONObject.put("render_type", "h5");
                                jSONObject.put("render_type_2", 0);
                                jSONObject.put("is_blank", eli2 == 100 ? 1 : 0);
                                jSONObject.put("is_playable", com.bytedance.sdk.openadsdk.core.model.KM.DbA(evVar) ? 1 : 0);
                                jSONObject.put("usecache", com.bytedance.sdk.openadsdk.core.nlS.Os.eli.eli().eli(evVar) ? 1 : 0);
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                                    return jSONObject2;
                                } catch (JSONException unused) {
                                    return jSONObject2;
                                }
                            } catch (JSONException unused2) {
                                return null;
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.Xb.Os("UIUtils", "(Developers can ignore this detection exception)checkWebViewIsTransparent->throwable ex>>>".concat(String.valueOf(th)));
            }
        }
    }

    private static Bitmap DbA(com.bytedance.sdk.component.FC.MGA mga) {
        if (mga == null) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(mga.getWidth(), mga.getHeight(), Bitmap.Config.RGB_565);
            mga.draw(new Canvas(createBitmap));
            return createBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int eli(Bitmap bitmap) {
        try {
            ArrayList<Integer> DbA2 = DbA(bitmap);
            if (DbA2 == null) {
                return -1;
            }
            HashMap hashMap = new HashMap();
            Iterator<Integer> it = DbA2.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hashMap.containsKey(next)) {
                    Integer valueOf = Integer.valueOf(((Integer) hashMap.get(next)).intValue() + 1);
                    hashMap.remove(next);
                    hashMap.put(next, valueOf);
                } else {
                    hashMap.put(next, 1);
                }
            }
            int i = 0;
            int i2 = 0;
            for (Map.Entry entry : hashMap.entrySet()) {
                int intValue = ((Integer) entry.getValue()).intValue();
                if (i2 < intValue) {
                    i = ((Integer) entry.getKey()).intValue();
                    i2 = intValue;
                }
            }
            if (i == 0) {
                return -1;
            }
            return (int) ((i2 / ((bitmap.getWidth() * bitmap.getHeight()) * 1.0f)) * 100.0f);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static ArrayList<Integer> DbA(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i = width * height;
            int[] iArr = new int[i];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = iArr[i2];
                arrayList.add(Integer.valueOf(Color.rgb((16711680 & i3) >> 16, (65280 & i3) >> 8, i3 & 255)));
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void DbA(View view, final float f) {
        if (view != null && f > 0.0f) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.utils.SSo.5
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f);
                }
            });
            view.setClipToOutline(true);
        }
    }

    public static void kb(View view) {
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public static boolean eli(float f, float f2, Context context) {
        new Object[]{Float.valueOf(f), Float.valueOf(f2)};
        if (f != -1.0f && f2 != -1.0f) {
            if (wC == null) {
                wC = ViewConfiguration.get(context);
            }
            if (FC == -1) {
                FC = wC.getScaledTouchSlop();
            }
            if (f - f2 > FC) {
                return true;
            }
        }
        return false;
    }

    public static void eli(boolean z) {
        du = Boolean.valueOf(z);
    }
}
