package com.inmobi.media;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class D7 extends ContentObserver implements InterfaceC2841r7 {

    /* renamed from: a, reason: collision with root package name */
    public final String f2261a;
    public final Context b;
    public int c;
    public final /* synthetic */ F7 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D7(F7 f7, String mJsCallbackNamespace, Context context, Handler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(mJsCallbackNamespace, "mJsCallbackNamespace");
        this.d = f7;
        this.f2261a = mJsCallbackNamespace;
        this.b = context;
        this.c = -1;
    }

    public static final void a(D7 this$0, F7 this$1, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this$1, "this$1");
        Context context = this$0.b;
        if (context != null) {
            Object systemService = context.getSystemService("audio");
            AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
            if (audioManager != null) {
                try {
                    int streamVolume = audioManager.getStreamVolume(3);
                    if (streamVolume != this$0.c) {
                        this$0.c = streamVolume;
                        InterfaceC2971z5 interfaceC2971z5 = this$1.b;
                        if (interfaceC2971z5 != null) {
                            ((A5) interfaceC2971z5).a("MraidMediaProcessor", "volume change detected - " + z);
                        }
                        String str = this$0.f2261a;
                        InterfaceC2971z5 interfaceC2971z52 = this$1.b;
                        if (interfaceC2971z52 != null) {
                            ((A5) interfaceC2971z52).c("MraidMediaProcessor", "fireDeviceVolumeChangeEvent");
                        }
                        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this$1.f2283a;
                        if (gestureDetectorOnGestureListenerC2634ec != null) {
                            gestureDetectorOnGestureListenerC2634ec.a(str, "fireDeviceVolumeChangeEvent(" + streamVolume + ");");
                        }
                    }
                } catch (Exception e) {
                    InterfaceC2971z5 interfaceC2971z53 = this$1.b;
                    if (interfaceC2971z53 != null) {
                        ((A5) interfaceC2971z53).a("MraidMediaProcessor", "Unexpected error in volume listener", e);
                    }
                }
            }
        }
    }

    @Override // com.inmobi.media.InterfaceC2841r7
    public final void b() {
        Context d = Uc.d();
        if (d == null) {
            return;
        }
        d.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    @Override // android.database.ContentObserver
    public final void onChange(final boolean z) {
        super.onChange(z);
        int i = AbstractC2970z4.f2771a;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) AbstractC2970z4.b.getValue();
        final F7 f7 = this.d;
        scheduledThreadPoolExecutor.execute(new Runnable() { // from class: com.inmobi.media.D7$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                D7.a(D7.this, f7, z);
            }
        });
    }

    @Override // com.inmobi.media.InterfaceC2841r7
    public final void a() {
        Context d = Uc.d();
        if (d == null) {
            return;
        }
        d.getContentResolver().unregisterContentObserver(this);
    }
}
