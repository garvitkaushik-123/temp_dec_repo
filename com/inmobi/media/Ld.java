package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Ld extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Ld f2355a = new Ld();

    public Ld() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new Handler(Looper.getMainLooper());
    }
}
