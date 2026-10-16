package com.unity3d.player.a;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* loaded from: classes7.dex */
public final class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ A f6540a;

    public z(A a2) {
        this.f6540a = a2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6540a.b.setBackground(new LayerDrawable(new Drawable[]{new ColorDrawable(-16777216), new BitmapDrawable(this.f6540a.b.getResources(), this.f6540a.b.f6510a)}));
    }
}
