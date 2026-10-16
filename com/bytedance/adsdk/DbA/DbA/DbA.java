package com.bytedance.adsdk.DbA.DbA;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.bytedance.adsdk.DbA.MGA.MGA;
import com.bytedance.adsdk.DbA.aAs;
import com.bytedance.adsdk.DbA.aGH;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes3.dex */
public class DbA {
    private static final Object eli = new Object();
    private final Context DbA;
    private final String Os;
    private aGH aGH;
    private final Map<String, aAs> ui;

    public DbA(Drawable.Callback callback, String str, aGH agh, Map<String, aAs> map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.Os = str + '/';
        } else {
            this.Os = str;
        }
        this.ui = map;
        eli(agh);
        if (!(callback instanceof View)) {
            this.DbA = null;
        } else {
            this.DbA = ((View) callback).getContext().getApplicationContext();
        }
    }

    public void eli(aGH agh) {
        this.aGH = agh;
    }

    public Bitmap eli(String str, Bitmap bitmap) {
        if (bitmap == null) {
            aAs aas = this.ui.get(str);
            Bitmap du = aas.du();
            aas.eli(null);
            return du;
        }
        Bitmap du2 = this.ui.get(str).du();
        DbA(str, bitmap);
        return du2;
    }

    public Bitmap eli(String str) {
        aAs aas = this.ui.get(str);
        if (aas == null) {
            return null;
        }
        Bitmap du = aas.du();
        if (du != null) {
            return du;
        }
        aGH agh = this.aGH;
        if (agh != null) {
            return agh.eli(aas);
        }
        Context context = this.DbA;
        if (context == null) {
            return null;
        }
        String FC = aas.FC();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (FC.startsWith("data:") && FC.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(FC.substring(FC.indexOf(44) + 1), 0);
                return DbA(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.Os)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.Os + FC), null, options);
                if (decodeStream == null) {
                    return null;
                }
                return DbA(str, MGA.eli(decodeStream, aas.eli(), aas.DbA()));
            } catch (IllegalArgumentException unused2) {
                return null;
            }
        } catch (IOException unused3) {
            return null;
        }
    }

    public boolean eli(Context context) {
        return (context == null && this.DbA == null) || this.DbA.equals(context);
    }

    private Bitmap DbA(String str, Bitmap bitmap) {
        synchronized (eli) {
            this.ui.get(str).eli(bitmap);
        }
        return bitmap;
    }
}
