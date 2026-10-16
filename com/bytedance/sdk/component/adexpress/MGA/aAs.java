package com.bytedance.sdk.component.adexpress.MGA;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class aAs extends com.bytedance.adsdk.DbA.MGA {
    private String DbA;
    private Map<String, Bitmap> eli;

    public void setAnimationsLoop(boolean z) {
    }

    public void setData(Map<String, String> map) {
    }

    public void setLottieAdDescMaxLength(int i) {
    }

    public void setLottieAdTitleMaxLength(int i) {
    }

    public void setLottieAppNameMaxLength(int i) {
    }

    public aAs(Context context) {
        super(context);
        this.eli = new HashMap();
    }

    public void setImageLottieTosPath(String str) {
        this.DbA = str;
    }

    public void wC() {
        if (TextUtils.isEmpty(this.DbA)) {
            return;
        }
        setProgress(0.0f);
        eli(true);
        setAnimationFromUrl(this.DbA);
        setImageAssetDelegate(new com.bytedance.adsdk.DbA.aGH() { // from class: com.bytedance.sdk.component.adexpress.MGA.aAs.1
            @Override // com.bytedance.adsdk.DbA.aGH
            public Bitmap eli(final com.bytedance.adsdk.DbA.aAs aas) {
                final String wC = aas.wC();
                String aAs = aas.aAs();
                String FC = aas.FC();
                if (TextUtils.equals(wC, "image_0") && TextUtils.equals(FC, "Lark20201123-180048_2.png")) {
                    FC = "hand.png";
                }
                Bitmap bitmap = (Bitmap) aAs.this.eli.get(wC);
                if (bitmap != null) {
                    return bitmap;
                }
                new Object[]{"dirName is : ", aAs, "fileName is : ", FC};
                if (TextUtils.isEmpty(aAs) || !TextUtils.isEmpty(FC)) {
                    if (!TextUtils.isEmpty(FC) && TextUtils.isEmpty(aAs)) {
                        aAs = FC;
                    } else if (!TextUtils.isEmpty(FC) && !TextUtils.isEmpty(aAs)) {
                        aAs = aAs + FC;
                    } else {
                        aAs = "";
                    }
                }
                if (TextUtils.isEmpty(aAs)) {
                    return null;
                }
                com.bytedance.sdk.component.ui.aAs eli2 = com.bytedance.sdk.component.adexpress.eli.eli.eli.eli().ui().eli(aAs).Os(2).eli(new com.bytedance.sdk.component.ui.wC() { // from class: com.bytedance.sdk.component.adexpress.MGA.aAs.1.1
                    @Override // com.bytedance.sdk.component.ui.wC
                    public Bitmap eli(Bitmap bitmap2) {
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap2, aas.eli(), aas.DbA(), false);
                        aAs.this.eli.put(wC, createScaledBitmap);
                        return createScaledBitmap;
                    }
                });
                aAs aas2 = aAs.this;
                eli2.eli(new eli(aas2, aas, wC, aas2.eli));
                return (Bitmap) aAs.this.eli.get(wC);
            }
        });
        eli();
    }

    private static class eli implements com.bytedance.sdk.component.ui.aqO {
        private final com.bytedance.adsdk.DbA.aAs DbA;
        private final String Os;
        private final Map<String, Bitmap> aGH;
        private final WeakReference<aAs> eli;

        @Override // com.bytedance.sdk.component.ui.aqO
        public void eli(int i, String str, Throwable th) {
        }

        public eli(aAs aas, com.bytedance.adsdk.DbA.aAs aas2, String str, Map<String, Bitmap> map) {
            this.eli = new WeakReference<>(aas);
            this.DbA = aas2;
            this.Os = str;
            this.aGH = map;
        }

        @Override // com.bytedance.sdk.component.ui.aqO
        public void eli(com.bytedance.sdk.component.ui.du duVar) {
            Object DbA = duVar.DbA();
            if (DbA instanceof Bitmap) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap((Bitmap) DbA, this.DbA.eli(), this.DbA.DbA(), false);
                this.aGH.put(this.Os, createScaledBitmap);
                aAs aas = this.eli.get();
                if (aas != null) {
                    aas.eli(this.DbA.wC(), createScaledBitmap);
                }
            }
        }
    }
}
