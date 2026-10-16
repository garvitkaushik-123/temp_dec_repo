package com.ironsource;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class K3 {

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2922a;

        static {
            int[] iArr = new int[P3.values().length];
            try {
                iArr[P3.Pacing.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[P3.ShowCount.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[P3.Delivery.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f2922a = iArr;
        }
    }

    public final int a(P3 cappingType) {
        Intrinsics.checkNotNullParameter(cappingType, "cappingType");
        int i = a.f2922a[cappingType.ordinal()];
        if (i == 1 || i == 2) {
            return 3000;
        }
        if (i == 3) {
            return 3001;
        }
        throw new NoWhenBranchMatchedException();
    }
}
