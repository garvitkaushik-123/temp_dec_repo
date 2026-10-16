package com.inmobi.media;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.inmobi.commons.core.configs.AdConfig;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Qc extends V1 {
    public final WeakReference b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Qc(View adView, AdConfig.AdQualityConfig adQualityConfig) {
        super(adQualityConfig);
        Intrinsics.checkNotNullParameter(adView, "adView");
        Intrinsics.checkNotNullParameter(adQualityConfig, "adQualityConfig");
        this.b = new WeakReference(adView);
    }

    @Override // com.inmobi.media.InterfaceC2803p0
    public final Object a() {
        long currentTimeMillis = System.currentTimeMillis();
        View adView = (View) this.b.get();
        if (adView == null) {
            Intrinsics.checkNotNullParameter("ScreenShotProcess", "tag");
            Intrinsics.checkNotNullParameter("view reference lost. aborting...", PglCryptUtils.KEY_MESSAGE);
            Log.i("ScreenShotProcess", "view reference lost. aborting...");
            String message = "fail - time taken - " + (System.currentTimeMillis() - currentTimeMillis);
            Intrinsics.checkNotNullParameter("ScreenShotProcess", "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            Log.i("ScreenShotProcess", message);
            return null;
        }
        Intrinsics.checkNotNullParameter(adView, "adView");
        Bitmap createBitmap = Bitmap.createBitmap(adView.getMeasuredWidth(), adView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        Drawable background = adView.getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        adView.draw(canvas);
        if (createBitmap == null) {
            return null;
        }
        String message2 = "success - time taken - " + (System.currentTimeMillis() - currentTimeMillis);
        Intrinsics.checkNotNullParameter("ScreenShotProcess", "tag");
        Intrinsics.checkNotNullParameter(message2, "message");
        Log.i("ScreenShotProcess", message2);
        return a(createBitmap);
    }
}
