package com.bytedance.adsdk.ugeno.kb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.TypedValue;

/* loaded from: classes3.dex */
public class wC {
    private static TypedValue Os;
    private static final Object DbA = new Object();
    public static Handler eli = new Handler(Looper.getMainLooper());

    public static float eli(Context context, String str) {
        float f;
        float f2 = context.getResources().getDisplayMetrics().density;
        try {
            f = Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            f = 0.0f;
        }
        return (f * f2) + 0.5f;
    }

    public static float eli(Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int DbA(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (int) ((f / f2) + 0.5f);
    }

    public static Bitmap eli(Context context, Bitmap bitmap, int i) {
        try {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.2f), Math.round(bitmap.getHeight() * 0.2f), false);
            Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
            RenderScript create = RenderScript.create(context);
            if (create == null) {
                return null;
            }
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(i);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            return createBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Drawable eli(Context context, int i) {
        return context.getDrawable(i);
    }

    public static boolean eli() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void eli(Runnable runnable) {
        if (eli()) {
            runnable.run();
        } else {
            eli.post(runnable);
        }
    }
}
