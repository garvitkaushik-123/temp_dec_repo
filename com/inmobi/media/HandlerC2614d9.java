package com.inmobi.media;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.d9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class HandlerC2614d9 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f2547a;

    public HandlerC2614d9(C2631e9 controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.f2547a = new WeakReference(controller);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) {
        C2747l9 c2747l9;
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (msg.what != 2) {
            super.handleMessage(msg);
            return;
        }
        C2631e9 c2631e9 = (C2631e9) this.f2547a.get();
        if (c2631e9 != null) {
            C2747l9 c2747l92 = c2631e9.d;
            if (c2747l92 != null) {
                int currentPosition = c2747l92.getCurrentPosition();
                int duration = c2747l92.getDuration();
                if (duration != 0) {
                    c2631e9.h.setProgress((currentPosition * 100) / duration);
                }
            }
            if (c2631e9.e && (c2747l9 = c2631e9.d) != null && c2747l9.isPlaying()) {
                Message obtainMessage = obtainMessage(2);
                Intrinsics.checkNotNullExpressionValue(obtainMessage, "obtainMessage(...)");
                sendMessageDelayed(obtainMessage, 200L);
            }
        }
    }
}
