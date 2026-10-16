package com.bytedance.sdk.openadsdk.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class KM implements com.bytedance.sdk.component.ui.aqO {
    private final WeakReference<ImageView> eli;

    public KM(ImageView imageView) {
        this.eli = new WeakReference<>(imageView);
    }

    @Override // com.bytedance.sdk.component.ui.aqO
    public void eli(com.bytedance.sdk.component.ui.du duVar) {
        ImageView imageView = this.eli.get();
        if (imageView == null) {
            return;
        }
        try {
            Object DbA = duVar.DbA();
            if (DbA instanceof Bitmap) {
                imageView.setImageBitmap((Bitmap) DbA);
            } else {
                if (DbA instanceof Drawable) {
                    if (DbA instanceof AnimatedImageDrawable) {
                        ((AnimatedImageDrawable) DbA).start();
                    }
                    imageView.setImageDrawable((Drawable) DbA);
                    return;
                }
                imageView.setVisibility(8);
            }
        } catch (Throwable unused) {
            imageView.setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.ui.aqO
    public void eli(int i, String str, Throwable th) {
        ImageView imageView = this.eli.get();
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }
}
