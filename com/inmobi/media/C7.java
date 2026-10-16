package com.inmobi.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class C7 extends BroadcastReceiver implements InterfaceC2841r7 {

    /* renamed from: a, reason: collision with root package name */
    public final String f2250a;
    public final /* synthetic */ F7 b;

    public C7(F7 f7, String jsCallbackNamespace) {
        Intrinsics.checkNotNullParameter(jsCallbackNamespace, "jsCallbackNamespace");
        this.b = f7;
        this.f2250a = jsCallbackNamespace;
    }

    @Override // com.inmobi.media.InterfaceC2841r7
    public final void a() {
        Context d = Uc.d();
        if (d == null) {
            return;
        }
        d.unregisterReceiver(this);
    }

    @Override // com.inmobi.media.InterfaceC2841r7
    public final void b() {
        Context d = Uc.d();
        if (d == null) {
            return;
        }
        B2.a(d, this, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual("android.media.RINGER_MODE_CHANGED", intent.getAction())) {
            int intExtra = intent.getIntExtra("android.media.EXTRA_RINGER_MODE", 2);
            InterfaceC2971z5 interfaceC2971z5 = this.b.b;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).a("MraidMediaProcessor", "Ringer mode action changed: " + intExtra);
            }
            F7 f7 = this.b;
            String str = this.f2250a;
            boolean z = 2 != intExtra;
            InterfaceC2971z5 interfaceC2971z52 = f7.b;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).c("MraidMediaProcessor", "fireDeviceMuteChangeEvent");
            }
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = f7.f2283a;
            if (gestureDetectorOnGestureListenerC2634ec != null) {
                gestureDetectorOnGestureListenerC2634ec.a(str, "fireDeviceMuteChangeEvent(" + z + ");");
            }
        }
    }
}
