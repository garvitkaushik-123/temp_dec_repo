package io.bidmachine.rendering.internal.screenshot;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.view.PixelCopy;
import android.view.View;
import android.view.Window;
import com.mbridge.msdk.MBridgeConstans;
import io.bidmachine.util.ViewUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/bidmachine/rendering/internal/screenshot/a;", "", "<init>", "()V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Handler;", "handler", "Lio/bidmachine/rendering/internal/screenshot/b;", "screenshotListener", "", "a", "(Landroid/view/View;Landroid/os/Handler;Lio/bidmachine/rendering/internal/screenshot/b;)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f7093a = new a();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"io/bidmachine/rendering/internal/screenshot/a$a", "Landroid/view/PixelCopy$OnPixelCopyFinishedListener;", "", "copyResult", "", "onPixelCopyFinished", "(I)V", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: io.bidmachine.rendering.internal.screenshot.a$a, reason: collision with other inner class name */
    public static final class PixelCopyOnPixelCopyFinishedListenerC0628a implements PixelCopy.OnPixelCopyFinishedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f7094a;
        final /* synthetic */ Bitmap b;

        PixelCopyOnPixelCopyFinishedListenerC0628a(b bVar, Bitmap bitmap) {
            this.f7094a = bVar;
            this.b = bitmap;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int copyResult) {
            if (copyResult == 0) {
                this.f7094a.a(this.b);
            } else {
                this.f7094a.a();
            }
        }
    }

    private a() {
    }

    public final void a(View view, Handler handler, b screenshotListener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(screenshotListener, "screenshotListener");
        Window findWindow = ViewUtilsKt.findWindow(view);
        if (findWindow == null) {
            screenshotListener.a();
            return;
        }
        Rect locationInWindow = ViewUtilsKt.getLocationInWindow(view);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(locationInWindow.width(), locationInWindow.height(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "{\n            Bitmap.cre…nfig.ARGB_8888)\n        }");
            try {
                PixelCopy.request(findWindow, locationInWindow, createBitmap, new PixelCopyOnPixelCopyFinishedListenerC0628a(screenshotListener, createBitmap), handler);
            } catch (Throwable unused) {
                screenshotListener.a();
            }
        } catch (Throwable unused2) {
            screenshotListener.a();
        }
    }
}
