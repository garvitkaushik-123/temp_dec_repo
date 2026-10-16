package com.instagram.common.viewpoint.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class YL {
    public static String[] A00 = {"0dslaS9HQNor4584P2qJWDauGUJuCUyD", "hmu58uVtuBegxtguAmxWdcC", "RnpWwwftYVF7ZcI60v", "9ipL7H1AQ7hrzmKFvXE", "pZ3KzhX3bLT6KZ2Vo7aJYVVuuWb7wszV", "0AfAa8bIuU", "cY7ucT44sLUlO9uXsqd9BA7lLs0feoWz", "ELBhZY2lRpRyd6u07AMv4seAD2bUSLiq"};

    public static Bitmap A00(C1929gi c1929gi, Bitmap bitmap, int i) throws RSRuntimeException {
        RenderScript renderScript = null;
        Allocation allocation = null;
        Allocation output = null;
        ScriptIntrinsicBlur scriptIntrinsicBlur = null;
        try {
            renderScript = RenderScript.create(c1929gi);
            renderScript.setMessageHandler(new RenderScript.RSMessageHandler());
            allocation = Allocation.createFromBitmap(renderScript, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            output = Allocation.createTyped(renderScript, allocation.getType());
            scriptIntrinsicBlur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
            scriptIntrinsicBlur.setInput(allocation);
            scriptIntrinsicBlur.setRadius(i);
            scriptIntrinsicBlur.forEach(output);
            output.copyTo(bitmap);
            return bitmap;
        } finally {
            if (renderScript != null) {
                renderScript.destroy();
            }
            if (allocation != null) {
                allocation.destroy();
            }
            if (output != null) {
                output.destroy();
            }
            if (scriptIntrinsicBlur != null) {
                scriptIntrinsicBlur.destroy();
            }
        }
    }

    public static Bitmap A01(C1929gi c1929gi, Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth() / i2;
        int height = bitmap.getHeight() / i2;
        if (width != 0 && height != 0) {
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.scale(1.0f / i2, 1.0f / i2);
            Paint paint = new Paint();
            paint.setFlags(3);
            paint.setColorFilter(new PorterDuffColorFilter(0, PorterDuff.Mode.SRC_ATOP));
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            try {
                createBitmap = A00(c1929gi, createBitmap, i);
                if (i2 != 1) {
                    int height2 = bitmap.getWidth();
                    int width2 = bitmap.getHeight();
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, height2, width2, true);
                    if (A00[0].charAt(31) == 121) {
                        throw new RuntimeException();
                    }
                    A00[7] = "0rCXq5ZtodXnzNKgqAgAvAA6fcN2Rviw";
                    createBitmap.recycle();
                    return createScaledBitmap;
                }
                return createBitmap;
            } catch (RSRuntimeException unused) {
                return new Q5().A02(createBitmap, i);
            }
        }
        return null;
    }
}
