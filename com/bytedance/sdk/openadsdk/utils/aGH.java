package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes3.dex */
public class aGH {
    public static void eli(ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        if (viewGroup == null || evVar == null || TextUtils.isEmpty(evVar.Vy())) {
            return;
        }
        try {
            if (viewGroup.getTag(aqO.oT) != null) {
                return;
            }
            int i = aqO.oT;
            viewGroup.setTag(i, Integer.valueOf(i));
            Drawable eli2 = eli(viewGroup.getResources(), evVar);
            if (eli2 == null) {
                return;
            }
            viewGroup.setForeground(eli2);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("add overlay fail", th.getMessage());
        }
    }

    public static void eli(Activity activity, com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        if (activity == null || evVar == null || TextUtils.isEmpty(evVar.Vy())) {
            return;
        }
        try {
            if (activity.getWindow().getDecorView().getTag(aqO.oT) != null) {
                return;
            }
            View decorView = activity.getWindow().getDecorView();
            int i = aqO.oT;
            decorView.setTag(i, Integer.valueOf(i));
            Drawable eli2 = eli(activity.getResources(), evVar);
            if (eli2 == null) {
                return;
            }
            activity.getWindow().getDecorView().setForeground(eli2);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.Xb.Os("add overlay fail", th.getMessage());
        }
    }

    private static Drawable eli(Resources resources, com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        try {
            String Vy = evVar.Vy();
            if (TextUtils.isEmpty(Vy)) {
                return null;
            }
            byte[] decode = Base64.decode(Vy, 0);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, BitmapFactory.decodeByteArray(decode, 0, decode.length));
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            bitmapDrawable.setTileModeXY(tileMode, tileMode);
            bitmapDrawable.setTargetDensity(resources.getDisplayMetrics());
            return bitmapDrawable;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static class eli implements View.OnLayoutChangeListener {
        private int DbA;
        private int Os;
        private final Drawable eli;

        public eli(Drawable drawable) {
            this.eli = drawable;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9 = i3 - i;
            int i10 = i4 - i2;
            if (i9 == this.DbA && i10 == this.Os) {
                return;
            }
            this.DbA = i9;
            this.Os = i10;
            this.eli.setBounds(0, 0, i9, i10);
        }
    }
}
