package com.mbridge.msdk.video.module.listener.impl;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;

/* compiled from: RoundedImageLoaderListener.java */
/* loaded from: classes6.dex */
public class j extends e {
    private int d;

    public j(ImageView imageView, int i) {
        super(imageView);
        this.d = i;
    }

    @Override // com.mbridge.msdk.video.module.listener.impl.e, com.mbridge.msdk.foundation.same.image.c
    public void onSuccessLoad(Bitmap bitmap, String str) {
        Bitmap a2;
        if (bitmap == null) {
            return;
        }
        try {
            if (this.f5149a == null || bitmap.isRecycled() || (a2 = o0.a(bitmap, 1, this.d)) == null) {
                return;
            }
            this.f5149a.setImageBitmap(a2);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }
}
