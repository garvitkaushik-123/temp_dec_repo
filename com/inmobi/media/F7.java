package com.inmobi.media;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.inmobi.commons.core.configs.AdConfig;
import com.ironsource.C3040d4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class F7 {

    /* renamed from: a, reason: collision with root package name */
    public final GestureDetectorOnGestureListenerC2634ec f2283a;
    public final InterfaceC2971z5 b;
    public C2906v7 c;
    public C2857s7 d;
    public C2857s7 e;
    public C2857s7 f;

    public F7(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec, InterfaceC2971z5 interfaceC2971z5) {
        this.f2283a = gestureDetectorOnGestureListenerC2634ec;
        this.b = interfaceC2971z5;
    }

    public static final boolean a(View view, MotionEvent motionEvent) {
        return true;
    }

    public static boolean b() {
        Context d = Uc.d();
        if (d == null) {
            return false;
        }
        Object systemService = d.getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        return audioManager != null && audioManager.isWiredHeadsetOn();
    }

    public final void a(String url, Activity activity) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(activity, "activity");
        InterfaceC2971z5 interfaceC2971z5 = this.b;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("MraidMediaProcessor", "doPlayMedia");
        }
        C2906v7 c2906v7 = new C2906v7(activity, this.b);
        this.c = c2906v7;
        c2906v7.setPlaybackData(url);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        C2906v7 c2906v72 = this.c;
        if (c2906v72 != null) {
            c2906v72.setLayoutParams(layoutParams);
        }
        C2922w7 c2922w7 = new C2922w7(activity);
        c2922w7.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.media.F7$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return F7.a(view, motionEvent);
            }
        });
        c2922w7.setBackgroundColor(-16777216);
        c2922w7.addView(this.c);
        InterfaceC2971z5 interfaceC2971z52 = this.b;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).a("MraidMediaProcessor", "adding media view on top");
        }
        viewGroup.addView(c2922w7, new ViewGroup.LayoutParams(-1, -1));
        C2906v7 c2906v73 = this.c;
        if (c2906v73 != null) {
            c2906v73.setViewContainer(c2922w7);
        }
        C2906v7 c2906v74 = this.c;
        if (c2906v74 != null) {
            c2906v74.requestFocus();
        }
        C2906v7 c2906v75 = this.c;
        if (c2906v75 != null) {
            c2906v75.setOnKeyListener(new View.OnKeyListener() { // from class: com.inmobi.media.F7$$ExternalSyntheticLambda1
                @Override // android.view.View.OnKeyListener
                public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                    return F7.a(F7.this, view, i, keyEvent);
                }
            });
        }
        C2906v7 c2906v76 = this.c;
        if (c2906v76 != null) {
            c2906v76.setListener(new E7(this));
        }
        C2906v7 c2906v77 = this.c;
        if (c2906v77 != null) {
            c2906v77.a();
        }
    }

    public static final boolean a(F7 this$0, View view, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (4 != i || keyEvent.getAction() != 0) {
            return false;
        }
        C2906v7 c2906v7 = this$0.c;
        if (c2906v7 == null) {
            return true;
        }
        c2906v7.b();
        return true;
    }

    public final int a() {
        AdConfig.RenderingConfig renderingConfig;
        InterfaceC2971z5 interfaceC2971z5 = this.b;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("MraidMediaProcessor", C3040d4.i.P);
        }
        Context d = Uc.d();
        if (d == null) {
            return -1;
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.f2283a;
        if (((gestureDetectorOnGestureListenerC2634ec == null || (renderingConfig = gestureDetectorOnGestureListenerC2634ec.getRenderingConfig()) == null) ? false : renderingConfig.getEnablePubMuteControl()) && Uc.o()) {
            return 0;
        }
        Object systemService = d.getSystemService("audio");
        AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return -1;
    }
}
