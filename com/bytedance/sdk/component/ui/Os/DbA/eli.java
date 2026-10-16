package com.bytedance.sdk.component.ui.Os.DbA;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class eli {
    private final int MGA;
    private final Bitmap.Config Os;
    private int aGH;
    private final int kb;
    private int ui;
    private final ImageView.ScaleType wC;
    public static final ImageView.ScaleType eli = ImageView.ScaleType.CENTER_INSIDE;
    public static final Bitmap.Config DbA = Bitmap.Config.ARGB_4444;
    private final int FC = 3840;
    private final int aAs = 104857600;

    public eli(int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, int i3, int i4) {
        this.Os = config;
        this.aGH = i;
        this.ui = i2;
        this.wC = scaleType;
        this.MGA = i3;
        this.kb = i4;
        eli(i, i2);
    }

    static int eli(int i, int i2, int i3, int i4, int i5, int i6) {
        double min = Math.min(i / i3, i2 / i4);
        if (i5 > 0 && i6 > 0) {
            min = Math.max(min, Math.min(Math.max(i, i2) / Math.max(i5, i6), Math.min(i, i2) / Math.min(i5, i6)));
        }
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > min) {
                return (int) f;
            }
            f = f2;
        }
    }

    private static int eli(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i != 0 || i2 != 0) {
            if (scaleType != ImageView.ScaleType.FIT_XY) {
                if (i == 0) {
                    return (int) (i3 * (i2 / i4));
                }
                if (i2 == 0) {
                    return i;
                }
                double d = i4 / i3;
                if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                    double d2 = i2;
                    return ((double) i) * d < d2 ? (int) (d2 / d) : i;
                }
                double d3 = i2;
                return ((double) i) * d > d3 ? (int) (d3 / d) : i;
            }
            if (i != 0) {
                return i;
            }
        }
        return i3;
    }

    public Bitmap eli(byte[] bArr) {
        Bitmap decodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.aGH == 0 && this.ui == 0) {
            options.inPreferredConfig = this.Os;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int eli2 = eli(this.aGH, this.ui, i, i2, this.wC);
            int eli3 = eli(this.ui, this.aGH, i2, i, this.wC);
            options.inJustDecodeBounds = false;
            options.inSampleSize = eli(i, i2, eli2, eli3, this.MGA, this.kb);
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null && (decodeByteArray.getWidth() > eli2 || decodeByteArray.getHeight() > eli3)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, eli2, eli3, true);
                if (createScaledBitmap != decodeByteArray) {
                    decodeByteArray.recycle();
                }
                decodeByteArray = createScaledBitmap;
            }
        }
        if (decodeByteArray != null && decodeByteArray.getByteCount() > 104857600) {
            int width = decodeByteArray.getWidth() / 2;
            int height = decodeByteArray.getHeight() / 2;
            if (width > 0 && height > 0) {
                Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(decodeByteArray, width, height, true);
                if (createScaledBitmap2 != decodeByteArray) {
                    decodeByteArray.recycle();
                }
                return createScaledBitmap2;
            }
        }
        return decodeByteArray;
    }

    private void eli(int i, int i2) {
        if (i > 3840 && i2 > 3840) {
            if (i > i2) {
                this.aGH = 3840;
                this.ui = (i2 * 3840) / i;
                return;
            } else {
                this.aGH = (i * 3840) / i2;
                this.ui = 3840;
                return;
            }
        }
        if (i > 3840) {
            this.aGH = 3840;
            this.ui = (i2 * 3840) / i;
        } else if (i2 > 3840) {
            this.aGH = (i * 3840) / i2;
            this.ui = 3840;
        }
    }
}
