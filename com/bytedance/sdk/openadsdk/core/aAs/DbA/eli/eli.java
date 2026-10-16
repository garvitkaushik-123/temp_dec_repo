package com.bytedance.sdk.openadsdk.core.aAs.DbA.eli;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.DbA.aAs;
import com.bytedance.adsdk.DbA.aGH;
import com.bytedance.adsdk.ugeno.DbA.Os;
import com.bytedance.adsdk.ugeno.eli;
import com.bytedance.adsdk.ugeno.kb.wC;
import com.bytedance.adsdk.ugeno.ui;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class eli extends Os<DbA> {
    protected ImageView.ScaleType Bnk;
    private boolean CH;
    private float OJ;
    private float QMZ;
    private String QW;
    private int Tju;
    protected String eli;
    protected ImageView.ScaleType hg;
    private boolean kEI;
    private boolean nY;
    protected HashMap<String, Bitmap> vb;
    private boolean yw;

    public eli(Context context) {
        super(context);
        this.QW = "images";
        this.CH = true;
        this.OJ = 1.0f;
        this.hg = ImageView.ScaleType.FIT_CENTER;
        this.Bnk = ImageView.ScaleType.FIT_XY;
        this.vb = new HashMap<>();
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    /* renamed from: Os, reason: merged with bridge method [inline-methods] */
    public DbA eli() {
        DbA dbA = new DbA(this.DbA);
        dbA.eli(this);
        return dbA;
    }

    @Override // com.bytedance.adsdk.ugeno.DbA.Os
    public void DbA() {
        super.DbA();
        ((DbA) this.ui).setProgress(this.QMZ);
        if (this.OJ <= 0.0f) {
            this.OJ = 1.0f;
        }
        ((DbA) this.ui).setSpeed(this.OJ);
        if (this.eli.startsWith("local")) {
            ((DbA) this.ui).setAnimation(du(this.eli));
            ((DbA) this.ui).setImageAssetsFolder(this.QW);
        } else {
            ((DbA) this.ui).setAnimationFromUrl(this.eli);
        }
        ((DbA) this.ui).setImageAssetDelegate(new AnonymousClass1());
        if (oWW()) {
            ((DbA) this.ui).setScaleType(this.Bnk);
        } else {
            ((DbA) this.ui).setScaleType(this.hg);
        }
        if (oWW()) {
            ((DbA) this.ui).setRepeatCount(this.Tju);
        } else {
            ((DbA) this.ui).eli(this.kEI);
        }
        if (oWW()) {
            if (this.ui == 0 || !this.CH) {
                return;
            }
            ((DbA) this.ui).eli();
            return;
        }
        if (this.ui != 0) {
            ((DbA) this.ui).eli();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.aAs.DbA.eli.eli$1, reason: invalid class name */
    class AnonymousClass1 implements aGH {
        AnonymousClass1() {
        }

        @Override // com.bytedance.adsdk.DbA.aGH
        public Bitmap eli(final aAs aas) {
            final String eli;
            if (aas == null) {
                return null;
            }
            String aAs = aas.aAs();
            String FC = aas.FC();
            if (!TextUtils.isEmpty(aAs) && TextUtils.isEmpty(FC)) {
                eli = com.bytedance.adsdk.ugeno.Os.DbA.eli(aAs, eli.this.aGH);
            } else {
                eli = (TextUtils.isEmpty(FC) || !TextUtils.isEmpty(aAs)) ? (TextUtils.isEmpty(FC) || TextUtils.isEmpty(aAs)) ? null : com.bytedance.adsdk.ugeno.Os.DbA.eli(aAs, eli.this.aGH) + com.bytedance.adsdk.ugeno.Os.DbA.eli(FC, eli.this.aGH) : com.bytedance.adsdk.ugeno.Os.DbA.eli(FC, eli.this.aGH);
            }
            if (TextUtils.isEmpty(eli)) {
                return null;
            }
            Bitmap bitmap = eli.this.vb.get(eli);
            if (bitmap != null) {
                return bitmap;
            }
            ui.eli().DbA().eli(eli.this.FC, eli, new eli.InterfaceC0124eli() { // from class: com.bytedance.sdk.openadsdk.core.aAs.DbA.eli.eli.1.1
                @Override // com.bytedance.adsdk.ugeno.eli.InterfaceC0124eli
                public void eli(Bitmap bitmap2) {
                    if (bitmap2 != null) {
                        final Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, aas.eli(), aas.DbA(), false);
                        eli.this.vb.put(eli, createScaledBitmap);
                        wC.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.aAs.DbA.eli.eli.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((DbA) eli.this.ui).eli(aas.wC(), createScaledBitmap);
                            }
                        });
                    }
                }
            });
            return eli.this.vb.get(eli);
        }
    }

    public void aGH() {
        if (this.ui != 0) {
            ((DbA) this.ui).eli();
        }
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
                this.Bnk = NU(str2);
                break;
            case "scaleType":
                this.hg = nlS(str2);
                break;
            case "progress":
                this.QMZ = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0.0f);
                break;
            case "imagePath":
                this.QW = str2;
                break;
            case "autoReverse":
                this.nY = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, false);
                break;
            case "src":
                this.eli = com.bytedance.sdk.openadsdk.core.aAs.Os.eli(str2);
                break;
            case "loop":
                if (oWW()) {
                    this.Tju = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 0);
                    break;
                } else {
                    this.kEI = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, false);
                    break;
                }
            case "speed":
                this.OJ = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, 1.0f);
                break;
            case "autoPlay":
                this.yw = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, false);
                break;
            case "autoplay":
                this.CH = com.bytedance.adsdk.ugeno.kb.Os.eli(str2, true);
                break;
        }
    }

    public void eli(AnimatorListenerAdapter animatorListenerAdapter) {
        ((DbA) this.ui).eli(animatorListenerAdapter);
    }

    private String du(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("local")) {
            return "";
        }
        if (str.contains("shake_phone")) {
            return "lottie_json/shake_phone.json";
        }
        return str.contains("swipe_right") ? "lottie_json/swipe_right.json" : "";
    }

    private ImageView.ScaleType nlS(String str) {
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
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    private ImageView.ScaleType NU(String str) {
        ImageView.ScaleType scaleType;
        scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
            case "none":
                return ImageView.ScaleType.CENTER;
            case "fit":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
                return ImageView.ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }
}
