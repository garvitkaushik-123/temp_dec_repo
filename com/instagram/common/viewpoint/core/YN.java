package com.instagram.common.viewpoint.core;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;

/* loaded from: assets/audience_network/classes2.dex */
public abstract class YN {
    public static Bitmap A00(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.setScale(-1.0f, 1.0f);
        matrix.postTranslate(bitmap.getWidth(), 0.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap A01(YM ym) {
        byte[] decode = Base64.decode(ym.A01(XX.A02), 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static Bitmap A02(YM ym) {
        byte[] decode = Base64.decode(ym.A01(XX.A02), 0);
        return A00(BitmapFactory.decodeByteArray(decode, 0, decode.length));
    }

    public static Drawable A03(C1929gi c1929gi, YM ym) {
        return new BitmapDrawable(c1929gi.getResources(), A01(ym));
    }
}
