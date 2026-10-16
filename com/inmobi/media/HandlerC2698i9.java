package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.i9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class HandlerC2698i9 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f2599a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2698i9(C2747l9 videoView) {
        super(Looper.getMainLooper());
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        this.f2599a = new WeakReference(videoView);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) {
        InterfaceC2666g9 playbackEventListener;
        Intrinsics.checkNotNullParameter(msg, "msg");
        C2747l9 c2747l9 = (C2747l9) this.f2599a.get();
        if (c2747l9 != null && msg.what == 1) {
            int duration = c2747l9.getDuration();
            int currentPosition = c2747l9.getCurrentPosition();
            if (duration != -1 && currentPosition != 0) {
                Object tag = c2747l9.getTag();
                C2597c9 c2597c9 = tag instanceof C2597c9 ? (C2597c9) tag : null;
                if (c2597c9 != null) {
                    Object obj = c2597c9.t.get("didCompleteQ1");
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    if (!((Boolean) obj).booleanValue() && (currentPosition * 4) - duration >= 0) {
                        c2597c9.t.put("didCompleteQ1", Boolean.TRUE);
                        InterfaceC2682h9 quartileCompletedListener = c2747l9.getQuartileCompletedListener();
                        Intrinsics.checkNotNull(quartileCompletedListener);
                        ((C2974z8) quartileCompletedListener).a((byte) 0);
                    }
                    Object obj2 = c2597c9.t.get("didCompleteQ2");
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                    if (!((Boolean) obj2).booleanValue() && (currentPosition * 2) - duration >= 0) {
                        c2597c9.t.put("didCompleteQ2", Boolean.TRUE);
                        InterfaceC2682h9 quartileCompletedListener2 = c2747l9.getQuartileCompletedListener();
                        if (quartileCompletedListener2 != null) {
                            ((C2974z8) quartileCompletedListener2).a((byte) 1);
                        }
                    }
                    Object obj3 = c2597c9.t.get("didCompleteQ3");
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    if (!((Boolean) obj3).booleanValue() && (currentPosition * 4) - (duration * 3) >= 0) {
                        c2597c9.t.put("didCompleteQ3", Boolean.TRUE);
                        InterfaceC2682h9 quartileCompletedListener3 = c2747l9.getQuartileCompletedListener();
                        if (quartileCompletedListener3 != null) {
                            ((C2974z8) quartileCompletedListener3).a((byte) 2);
                        }
                    }
                    if ((currentPosition / duration) * 100 > c2597c9.D) {
                        Object obj4 = c2597c9.t.get("didQ4Fire");
                        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                        if (!((Boolean) obj4).booleanValue() && (playbackEventListener = c2747l9.getPlaybackEventListener()) != null) {
                            ((A8) playbackEventListener).a((byte) 5);
                        }
                    }
                }
            }
            sendEmptyMessageDelayed(1, 1000L);
        }
        super.handleMessage(msg);
    }
}
