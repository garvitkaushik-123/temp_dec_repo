package com.inmobi.media;

import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class X0 implements I4 {

    /* renamed from: a, reason: collision with root package name */
    public final AnimatedImageDrawable f2475a;

    public X0(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Drawable decodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(new File(filePath)));
        Intrinsics.checkNotNull(decodeDrawable, "null cannot be cast to non-null type android.graphics.drawable.AnimatedImageDrawable");
        this.f2475a = (AnimatedImageDrawable) decodeDrawable;
    }

    @Override // com.inmobi.media.I4
    public final void a(K4 k4) {
    }

    @Override // com.inmobi.media.I4
    public final void a(boolean z) {
    }

    @Override // com.inmobi.media.I4
    public final boolean b() {
        return this.f2475a.isRunning();
    }

    @Override // com.inmobi.media.I4
    public final int c() {
        return this.f2475a.getIntrinsicWidth();
    }

    @Override // com.inmobi.media.I4
    public final void d() {
    }

    public final void e() {
        this.f2475a.start();
    }

    @Override // com.inmobi.media.I4
    public final void start() {
        this.f2475a.registerAnimationCallback(new W0(this));
        this.f2475a.start();
    }

    @Override // com.inmobi.media.I4
    public final int a() {
        return this.f2475a.getIntrinsicHeight();
    }

    @Override // com.inmobi.media.I4
    public final void a(Canvas canvas, float f, float f2) {
        Intrinsics.checkNotNull(canvas);
        canvas.translate(f, f2);
        this.f2475a.draw(canvas);
    }
}
