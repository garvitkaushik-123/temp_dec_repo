package com.bytedance.sdk.openadsdk.nGm.eli;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.aGH;

/* loaded from: classes3.dex */
public class DbA {
    private Drawable DbA;
    private byte[] Os;
    private Bitmap aGH;
    int eli;
    private Bitmap ui;

    public DbA(Drawable drawable, int i) {
        this.Os = null;
        this.aGH = null;
        this.ui = null;
        this.DbA = drawable;
        this.eli = i;
    }

    public DbA(byte[] bArr, int i) {
        this.DbA = null;
        this.aGH = null;
        this.ui = null;
        this.Os = bArr;
        this.eli = i;
    }

    public DbA(Bitmap bitmap, Bitmap bitmap2, int i) {
        this.DbA = null;
        this.Os = null;
        this.ui = bitmap2;
        this.aGH = bitmap;
        this.eli = i;
    }

    public Bitmap eli() {
        return this.aGH;
    }

    public Bitmap DbA() {
        return this.ui;
    }

    public byte[] Os() {
        try {
            if (this.Os == null) {
                this.Os = aGH.eli(this.aGH);
            }
        } catch (OutOfMemoryError e) {
            Xb.Os("GifRequestResult", e.getMessage());
        }
        return this.Os;
    }

    public Drawable aGH() {
        return this.DbA;
    }

    public boolean ui() {
        if (this.aGH != null || this.DbA != null) {
            return true;
        }
        byte[] bArr = this.Os;
        return bArr != null && bArr.length > 0;
    }
}
