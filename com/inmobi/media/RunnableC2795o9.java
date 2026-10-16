package com.inmobi.media;

import android.content.Context;
import android.widget.ImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.o9, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC2795o9 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f2661a;
    public final WeakReference b;

    public RunnableC2795o9(Context context, ImageView imageView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        this.f2661a = new WeakReference(context);
        this.b = new WeakReference(imageView);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = (Context) this.f2661a.get();
        ImageView imageView = (ImageView) this.b.get();
        if (context == null || imageView == null) {
            return;
        }
        HashMap hashMap = D9.c;
        C2779n9.a(context, imageView);
    }
}
