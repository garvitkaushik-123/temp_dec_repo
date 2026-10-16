package com.inmobi.media;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.f8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2648f8 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2569a;
    public final C2747l9 b;
    public boolean c;
    public final Object d;
    public final AudioAttributes e;
    public AudioFocusRequest f;
    public AudioManager.OnAudioFocusChangeListener g;

    public C2648f8(Context context, C2747l9 audioFocusListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(audioFocusListener, "audioFocusListener");
        this.f2569a = context;
        this.b = audioFocusListener;
        this.d = new Object();
        AudioAttributes build = new AudioAttributes.Builder().setUsage(1).setContentType(2).setLegacyStreamType(3).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        this.e = build;
    }

    public final void a() {
        AudioFocusRequest audioFocusRequest;
        synchronized (this.d) {
            Object systemService = this.f2569a.getSystemService("audio");
            AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
            if (audioManager != null && (audioFocusRequest = this.f) != null) {
                audioManager.abandonAudioFocusRequest(audioFocusRequest);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final AudioManager.OnAudioFocusChangeListener b() {
        return new AudioManager.OnAudioFocusChangeListener() { // from class: com.inmobi.media.f8$$ExternalSyntheticLambda0
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public final void onAudioFocusChange(int i) {
                C2648f8.a(C2648f8.this, i);
            }
        };
    }

    public final void c() {
        int i;
        synchronized (this.d) {
            Object systemService = this.f2569a.getSystemService("audio");
            AudioManager audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
            if (audioManager != null) {
                if (this.g == null) {
                    this.g = b();
                }
                if (this.f == null) {
                    AudioFocusRequest.Builder audioAttributes = new AudioFocusRequest.Builder(2).setAudioAttributes(this.e);
                    AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.g;
                    Intrinsics.checkNotNull(onAudioFocusChangeListener);
                    AudioFocusRequest build = audioAttributes.setOnAudioFocusChangeListener(onAudioFocusChangeListener, new Handler(Looper.getMainLooper())).build();
                    Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                    this.f = build;
                }
                AudioFocusRequest audioFocusRequest = this.f;
                Intrinsics.checkNotNull(audioFocusRequest);
                i = audioManager.requestAudioFocus(audioFocusRequest);
            } else {
                i = 0;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (i == 1) {
            C2747l9 c2747l9 = this.b;
            c2747l9.i();
            C2631e9 c2631e9 = c2747l9.n;
            if (c2631e9 == null || c2631e9.d == null) {
                return;
            }
            c2631e9.j = false;
            c2631e9.i.removeView(c2631e9.g);
            c2631e9.i.removeView(c2631e9.f);
            c2631e9.a();
            return;
        }
        C2747l9 c2747l92 = this.b;
        c2747l92.h();
        C2631e9 c2631e92 = c2747l92.n;
        if (c2631e92 == null || c2631e92.d == null) {
            return;
        }
        c2631e92.j = true;
        c2631e92.i.removeView(c2631e92.f);
        c2631e92.i.removeView(c2631e92.g);
        c2631e92.b();
    }

    public static final void a(C2648f8 this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i == -2) {
            synchronized (this$0.d) {
                this$0.c = true;
                Unit unit = Unit.INSTANCE;
            }
            C2747l9 c2747l9 = this$0.b;
            c2747l9.h();
            C2631e9 c2631e9 = c2747l9.n;
            if (c2631e9 == null || c2631e9.d == null) {
                return;
            }
            c2631e9.j = true;
            c2631e9.i.removeView(c2631e9.f);
            c2631e9.i.removeView(c2631e9.g);
            c2631e9.b();
            return;
        }
        if (i == -1) {
            synchronized (this$0.d) {
                this$0.c = false;
                Unit unit2 = Unit.INSTANCE;
            }
            C2747l9 c2747l92 = this$0.b;
            c2747l92.h();
            C2631e9 c2631e92 = c2747l92.n;
            if (c2631e92 == null || c2631e92.d == null) {
                return;
            }
            c2631e92.j = true;
            c2631e92.i.removeView(c2631e92.f);
            c2631e92.i.removeView(c2631e92.g);
            c2631e92.b();
            return;
        }
        if (i != 1) {
            return;
        }
        synchronized (this$0.d) {
            if (this$0.c) {
                C2747l9 c2747l93 = this$0.b;
                if (c2747l93.isPlaying()) {
                    c2747l93.i();
                    C2631e9 c2631e93 = c2747l93.n;
                    if (c2631e93 != null && c2631e93.d != null) {
                        c2631e93.j = false;
                        c2631e93.i.removeView(c2631e93.g);
                        c2631e93.i.removeView(c2631e93.f);
                        c2631e93.a();
                    }
                }
            }
            this$0.c = false;
            Unit unit3 = Unit.INSTANCE;
        }
    }
}
