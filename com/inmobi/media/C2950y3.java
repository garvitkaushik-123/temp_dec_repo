package com.inmobi.media;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.inmobi.ads.R;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.y3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2950y3 extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    public final byte f2759a;
    public final InterfaceC2971z5 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:0|1|(3:(8:3|(2:5|(2:15|(2:17|(2:19|(1:21))))(6:23|24|25|26|27|(4:29|30|31|(2:33|34)(1:36))(2:38|(2:40|41)(1:42))))|52|24|25|26|27|(0)(0))|27|(0)(0))|53|24|25|26|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        if (r11 == 8) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008c, code lost:
    
        r3 = r9;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004d A[Catch: Exception -> 0x008b, TRY_LEAVE, TryCatch #0 {Exception -> 0x008b, blocks: (B:26:0x0047, B:29:0x004d), top: B:25:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C2950y3(Context context, byte b, InterfaceC2971z5 interfaceC2971z5) {
        super(context);
        int i;
        Integer a2;
        ?? r3 = "context";
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2759a = b;
        this.b = interfaceC2971z5;
        try {
            if (b != 0) {
                if (b != 1) {
                    if (b == 2 || b == 3 || b == 4 || b == 5 || b == 6) {
                        i = 30;
                        int i2 = i;
                        a2 = a(b);
                        if (a2 == null) {
                            if (interfaceC2971z5 != null) {
                                ((A5) interfaceC2971z5).b("CustomView", "null drawable id while creating button - " + ((int) b));
                                return;
                            }
                            return;
                        }
                        a(a2.intValue(), i2, i2, i2, i2);
                        if (interfaceC2971z5 != null) {
                            ((A5) interfaceC2971z5).c("CustomView", "new customView - " + ((int) b) + " created");
                            return;
                        }
                        return;
                    }
                    if (b != 9) {
                        if (b != 10) {
                            if (b != 7) {
                            }
                        }
                    }
                }
                i = 0;
                int i22 = i;
                a2 = a(b);
                if (a2 == null) {
                }
            }
            if (a2 == null) {
            }
        } catch (Exception e) {
            e = e;
            C2950y3 c2950y3 = r3;
            Exception exc = e;
            InterfaceC2971z5 interfaceC2971z52 = c2950y3.b;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).a("CustomView", "exception while building customView", exc);
            }
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(exc, "event"));
            return;
        }
        i = 15;
        int i222 = i;
        a2 = a(b);
    }

    public static Integer a(byte b) {
        if (b == 0) {
            return Integer.valueOf(R.drawable.im_close_button);
        }
        if (b == 1) {
            return Integer.valueOf(R.drawable.im_close_transparent);
        }
        if (b == 2) {
            return Integer.valueOf(R.drawable.im_close_icon);
        }
        if (b == 3) {
            return Integer.valueOf(R.drawable.im_refresh);
        }
        if (b == 4) {
            return Integer.valueOf(R.drawable.im_back);
        }
        if (b == 5) {
            return Integer.valueOf(R.drawable.im_forward_active);
        }
        if (b == 6) {
            return Integer.valueOf(R.drawable.im_forward_inactive);
        }
        if (b == 9) {
            return Integer.valueOf(R.drawable.im_mute);
        }
        if (b == 10) {
            return Integer.valueOf(R.drawable.im_unmute);
        }
        if (b == 7) {
            return Integer.valueOf(R.drawable.im_play);
        }
        if (b == 8) {
            return Integer.valueOf(R.drawable.im_pause);
        }
        return null;
    }

    public final void a(final int i, final int i2, final int i3, final int i4, final int i5) {
        if (L3.f2348a.H()) {
            Icon createWithResource = Icon.createWithResource(getContext(), i);
            Context context = getContext();
            Icon.OnDrawableLoadedListener onDrawableLoadedListener = new Icon.OnDrawableLoadedListener() { // from class: com.inmobi.media.y3$$ExternalSyntheticLambda1
                @Override // android.graphics.drawable.Icon.OnDrawableLoadedListener
                public final void onDrawableLoaded(Drawable drawable) {
                    C2950y3.a(C2950y3.this, i2, i3, i4, i5, drawable);
                }
            };
            int i6 = AbstractC2970z4.f2771a;
            createWithResource.loadDrawableAsync(context, onDrawableLoadedListener, ((ExecutorC2793o7) AbstractC2970z4.d.getValue()).f2659a);
            return;
        }
        int i7 = AbstractC2970z4.f2771a;
        ((ScheduledThreadPoolExecutor) AbstractC2970z4.c.getValue()).execute(new Runnable() { // from class: com.inmobi.media.y3$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                C2950y3.a(C2950y3.this, i, i2, i3, i4, i5);
            }
        });
    }

    public static final void a(C2950y3 this$0, int i, int i2, int i3, int i4, Drawable drawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (drawable == null) {
            InterfaceC2971z5 interfaceC2971z5 = this$0.b;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("CustomView", "drawable for " + ((int) this$0.f2759a) + " is null");
                return;
            }
            return;
        }
        this$0.setImageDrawable(drawable);
        this$0.setPadding(i, i2, i3, i4);
    }

    public static final void a(C2950y3 this$0, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Drawable drawable = ContextCompat.getDrawable(this$0.getContext(), i);
        if (drawable == null) {
            InterfaceC2971z5 interfaceC2971z5 = this$0.b;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("CustomView", "CustomView drawable for " + ((int) this$0.f2759a) + " cannot be created");
                return;
            }
            return;
        }
        this$0.a(drawable, i2, i3, i4, i5);
    }

    public final void a(final Drawable drawable, final int i, final int i2, final int i3, final int i4) {
        post(new Runnable() { // from class: com.inmobi.media.y3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2950y3.a(C2950y3.this, drawable, i, i2, i3, i4);
            }
        });
    }

    public static final void a(C2950y3 this$0, Drawable drawable, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(drawable, "$drawable");
        this$0.setImageDrawable(drawable);
        this$0.setPadding(i, i2, i3, i4);
    }
}
