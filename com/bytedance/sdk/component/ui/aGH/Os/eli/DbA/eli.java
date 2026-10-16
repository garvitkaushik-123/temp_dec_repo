package com.bytedance.sdk.component.ui.aGH.Os.eli.DbA;

import android.graphics.Bitmap;
import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.sdk.component.ui.dV;

/* loaded from: classes3.dex */
public class eli implements dV {
    private int DbA;
    private int Os;
    private com.bytedance.sdk.component.ui.aGH.Os.eli.Os<String, Bitmap> aGH;
    private long eli = PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;

    public eli(int i, int i2) {
        this.DbA = i2;
        this.Os = i;
        this.aGH = new com.bytedance.sdk.component.ui.aGH.Os.eli.Os<>(this.DbA);
    }

    @Override // com.bytedance.sdk.component.ui.eli
    public boolean eli(String str, Bitmap bitmap) {
        if (str != null && bitmap != null) {
            try {
                int eli = eli(bitmap);
                if (eli <= this.eli && eli != 0) {
                    this.aGH.eli(str, bitmap);
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.ui.eli
    public Bitmap eli(String str) {
        try {
            return this.aGH.eli((com.bytedance.sdk.component.ui.aGH.Os.eli.Os<String, Bitmap>) str);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.ui.eli
    public boolean DbA(String str) {
        return this.aGH.eli((com.bytedance.sdk.component.ui.aGH.Os.eli.Os<String, Bitmap>) str) != null;
    }

    public static int eli(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getAllocationByteCount();
    }
}
