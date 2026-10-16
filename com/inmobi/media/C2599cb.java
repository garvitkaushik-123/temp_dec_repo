package com.inmobi.media;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.cb, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2599cb extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public static final C2599cb f2536a = new C2599cb();

    public C2599cb() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        boolean z;
        try {
            Class.forName("com.android.billingclient.api.BillingClient");
            z = true;
        } catch (ClassNotFoundException | Exception unused) {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
