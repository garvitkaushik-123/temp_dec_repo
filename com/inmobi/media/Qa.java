package com.inmobi.media;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.PixelCopy;
import android.view.Window;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes4.dex */
public final class Qa extends V1 {
    public final Window b;
    public final AtomicBoolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Qa(Window window, AdConfig.AdQualityConfig config) {
        super(config);
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(config, "config");
        this.b = window;
        this.c = new AtomicBoolean(false);
    }

    @Override // com.inmobi.media.InterfaceC2803p0
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Bitmap a() {
        long currentTimeMillis = System.currentTimeMillis();
        int width = this.b.getDecorView().getWidth();
        int height = this.b.getDecorView().getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Rect rect = new Rect(0, 0, width, height);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        int layerType = this.b.getDecorView().getLayerType();
        this.b.getDecorView().setLayerType(0, null);
        PixelCopy.request(this.b, rect, createBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.inmobi.media.Qa$$ExternalSyntheticLambda0
            @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
            public final void onPixelCopyFinished(int i) {
                Qa.a(Ref.BooleanRef.this, this, i);
            }
        }, new Handler(Looper.getMainLooper()));
        while (!this.c.get()) {
            Thread.sleep(500L);
        }
        String message = "success - " + booleanRef.element + " - time - " + (System.currentTimeMillis() - currentTimeMillis);
        Intrinsics.checkNotNullParameter("PixelCopyScreenShotProcess", "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Log.i("PixelCopyScreenShotProcess", message);
        this.b.getDecorView().setLayerType(layerType, null);
        if (!booleanRef.element) {
            return null;
        }
        Intrinsics.checkNotNullParameter("PixelCopyScreenShotProcess", "tag");
        Intrinsics.checkNotNullParameter("success", PglCryptUtils.KEY_MESSAGE);
        Log.i("PixelCopyScreenShotProcess", "success");
        return a(createBitmap);
    }

    public static final void a(Ref.BooleanRef isSuccess, Qa this$0, int i) {
        Intrinsics.checkNotNullParameter(isSuccess, "$isSuccess");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i == 0) {
            isSuccess.element = true;
        }
        String message = "capture result - success - " + isSuccess.element;
        Intrinsics.checkNotNullParameter("PixelCopyScreenShotProcess", "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Log.i("PixelCopyScreenShotProcess", message);
        this$0.c.set(true);
    }
}
