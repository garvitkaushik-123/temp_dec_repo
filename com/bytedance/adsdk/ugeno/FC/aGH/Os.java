package com.bytedance.adsdk.ugeno.FC.aGH;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.core.MGA;
import com.bytedance.adsdk.ugeno.eli;
import com.bytedance.adsdk.ugeno.kb.aGH;
import com.bytedance.adsdk.ugeno.kb.wC;
import com.bytedance.adsdk.ugeno.ui;

/* loaded from: classes3.dex */
public class Os extends com.bytedance.adsdk.ugeno.DbA.Os<eli> {
    protected String Bnk;
    private int QW;
    protected String eli;
    protected boolean hg;
    private float kEI;
    private float nY;
    protected ImageView.ScaleType vb;

    public Os(Context context) {
        super(context);
        this.vb = ImageView.ScaleType.FIT_XY;
        this.QW = -1;
        this.nY = -1.0f;
        this.kEI = -1.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public void DbA() {
        super.DbA();
        FC();
        ((eli) this.ui).setScaleType(this.vb);
        ((eli) this.ui).setBorderColor(this.Yw);
        ((eli) this.ui).setCornerRadius(this.Za);
        ((eli) this.ui).setBorderWidth(this.rQ);
        if (this.QW != -1) {
            ((eli) this.ui).setColorFilter(this.QW);
        }
    }

    public void nlS(String str) {
        this.eli = str;
    }

    private void FC() {
        if (TextUtils.isEmpty(this.eli)) {
            return;
        }
        ((eli) this.ui).setImageDrawable(null);
        if (this.eli.startsWith("local://")) {
            try {
                String replace = this.eli.replace("local://", "");
                if (TextUtils.equals(Os(), "raw")) {
                    ((eli) this.ui).setImageResource(aGH.eli(this.DbA, replace));
                    return;
                } else {
                    ((eli) this.ui).setImageResource(aGH.DbA(this.DbA, replace));
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        if (this.eli.startsWith("@")) {
            ((eli) this.ui).setImageResource(Integer.parseInt(this.eli.substring(1)));
        } else {
            aAs();
        }
    }

    private void aAs() {
        if (this.nY > 0.0f) {
            ui.eli().DbA().eli(this.FC, this.eli, new eli.InterfaceC0124eli() { // from class: com.bytedance.adsdk.ugeno.FC.aGH.Os.1
                @Override // com.bytedance.adsdk.ugeno.eli.InterfaceC0124eli
                public void eli(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (Os.this.Hm != null) {
                            MGA unused = Os.this.Hm;
                            return;
                        }
                        return;
                    }
                    if (Os.this.Hm != null) {
                        MGA unused2 = Os.this.Hm;
                    }
                    final Bitmap eli = wC.eli(Os.this.DbA, bitmap, (int) Os.this.nY);
                    if (eli != null) {
                        wC.eli(new Runnable() { // from class: com.bytedance.adsdk.ugeno.FC.aGH.Os.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((eli) Os.this.ui).setImageBitmap(eli);
                            }
                        });
                    }
                    if (Os.this.hg || Os.this.kEI > 0.0f) {
                        Bitmap eli2 = wC.eli(Os.this.DbA, bitmap, Os.this.kEI > 0.0f ? (int) Os.this.kEI : 10);
                        if (eli2 != null) {
                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(Os.this.DbA.getResources(), eli2);
                            wC.eli(new Runnable() { // from class: com.bytedance.adsdk.ugeno.FC.aGH.Os.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((eli) Os.this.ui).setBackground(bitmapDrawable);
                                }
                            });
                        }
                    }
                }
            });
            return;
        }
        ui.eli().DbA().eli(this.FC, this.eli, (ImageView) this.ui, ((eli) this.ui).getWidth(), ((eli) this.ui).getHeight(), new eli.InterfaceC0124eli() { // from class: com.bytedance.adsdk.ugeno.FC.aGH.Os.2
            @Override // com.bytedance.adsdk.ugeno.eli.InterfaceC0124eli
            public void eli(Bitmap bitmap) {
                if (bitmap == null) {
                    if (Os.this.Hm != null) {
                        MGA unused = Os.this.Hm;
                    }
                } else if (Os.this.Hm != null) {
                    MGA unused2 = Os.this.Hm;
                }
            }
        });
        if (this.hg || this.kEI > 0.0f) {
            ui.eli().DbA().eli(this.FC, this.eli, new eli.InterfaceC0124eli() { // from class: com.bytedance.adsdk.ugeno.FC.aGH.Os.3
                @Override // com.bytedance.adsdk.ugeno.eli.InterfaceC0124eli
                public void eli(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap eli = wC.eli(Os.this.DbA, bitmap, Os.this.kEI > 0.0f ? (int) Os.this.kEI : 10);
                    wC.eli(new Runnable() { // from class: com.bytedance.adsdk.ugeno.FC.aGH.Os.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (eli != null) {
                                ((eli) Os.this.ui).setBackground(new BitmapDrawable(Os.this.DbA.getResources(), eli));
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    /* renamed from: aGH, reason: merged with bridge method [inline-methods] */
    public eli eli() {
        eli eliVar = new eli(this.DbA);
        eliVar.eli(this);
        return eliVar;
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public void eli(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.eli(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
            case "scaleType":
                this.vb = du(str2);
                break;
            case "imageBlur":
                this.nY = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, -1.0f);
                break;
            case "isBgGaussianBlur":
                this.hg = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, false);
                break;
            case "src":
                this.eli = str2;
                break;
            case "tintColor":
                this.QW = com.bytedance.adsdk.ugeno.kb.eli.eli(str2);
                break;
            case "imageBgBlur":
                this.kEI = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, -1.0f);
                break;
        }
    }

    private ImageView.ScaleType du(String str) {
        ImageView.ScaleType scaleType;
        scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fit":
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os, com.bytedance.adsdk.ugeno.aGH
    public void kb() {
        super.kb();
        ((eli) this.ui).post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.FC.aGH.Os.4
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = ((eli) Os.this.ui).getDrawable();
                if (drawable instanceof AnimatedImageDrawable) {
                    ((AnimatedImageDrawable) drawable).start();
                }
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os, com.bytedance.adsdk.ugeno.aGH
    public void wC() {
        super.wC();
        Drawable drawable = ((eli) this.ui).getDrawable();
        if (drawable instanceof AnimatedImageDrawable) {
            ((AnimatedImageDrawable) drawable).stop();
        }
    }

    protected String Os() {
        return this.Bnk;
    }
}
