package com.bytedance.sdk.openadsdk.FC;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.ui.aqO;
import com.bytedance.sdk.component.ui.du;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.utils.cyF;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class Os implements aqO {
    private final String DbA = "ImageLoaderToViewWrapper";
    private aqO Os;
    private final WeakReference<ImageView> eli;

    public static aqO eli(ev evVar, String str, ImageView imageView) {
        return new DbA(evVar, str, new Os(imageView));
    }

    public static aqO eli(ev evVar, String str, ImageView imageView, aqO aqo) {
        return new DbA(evVar, str, new Os(imageView, aqo));
    }

    private Os(ImageView imageView, aqO aqo) {
        this.eli = new WeakReference<>(imageView);
        this.Os = aqo;
    }

    private Os(ImageView imageView) {
        this.eli = new WeakReference<>(imageView);
    }

    @Override // com.bytedance.sdk.component.ui.aqO
    public void eli(du duVar) {
        final ImageView imageView = this.eli.get();
        if (imageView != null) {
            final Object DbA = duVar.DbA();
            if (DbA instanceof Bitmap) {
                if (cyF.MGA()) {
                    imageView.setImageBitmap((Bitmap) DbA);
                } else {
                    nn.Os().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.FC.Os.1
                        @Override // java.lang.Runnable
                        public void run() {
                            imageView.setImageBitmap((Bitmap) DbA);
                        }
                    });
                }
                aqO aqo = this.Os;
                if (aqo != null) {
                    aqo.eli(duVar);
                    return;
                }
                return;
            }
            if (DbA instanceof Drawable) {
                if (cyF.MGA()) {
                    eli(DbA, imageView);
                } else {
                    nn.Os().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.FC.Os.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Os.this.eli(DbA, imageView);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(Object obj, ImageView imageView) {
        if (obj instanceof AnimatedImageDrawable) {
            ((AnimatedImageDrawable) obj).start();
        }
        imageView.setImageDrawable((Drawable) obj);
    }

    @Override // com.bytedance.sdk.component.ui.aqO
    public void eli(int i, String str, Throwable th) {
        aqO aqo = this.Os;
        if (aqo != null) {
            aqo.eli(i, str, th);
        }
    }
}
