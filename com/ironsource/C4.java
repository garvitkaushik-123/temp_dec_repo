package com.ironsource;

import android.content.Context;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class C4 implements InterfaceC3364w7 {

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2810a;

        static {
            int[] iArr = new int[EnumC3395y4.values().length];
            try {
                iArr[EnumC3395y4.IADS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC3395y4.UADS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC3395y4.SHARED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC3395y4.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f2810a = iArr;
        }
    }

    @Override // com.ironsource.InterfaceC3364w7
    public E4 a(Context context, EnumC3395y4 source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        int i = a.f2810a[source.ordinal()];
        if (i == 1) {
            return new B4(context, "supersonic_shared_preferen");
        }
        if (i == 2) {
            return new B4(context, "unityads-installinfo");
        }
        if (i == 3) {
            return new B4(context, D4.c);
        }
        if (i == 4) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
