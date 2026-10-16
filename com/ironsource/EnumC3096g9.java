package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.g9, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public enum EnumC3096g9 {
    NonBidder(1),
    Bidder(2),
    NotSupported(-1);

    public static final a b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f3314a;

    /* renamed from: com.ironsource.g9$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EnumC3096g9 a(int i) {
            EnumC3096g9 enumC3096g9;
            EnumC3096g9[] values = EnumC3096g9.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    enumC3096g9 = null;
                    break;
                }
                enumC3096g9 = values[i2];
                if (enumC3096g9.f3314a == i) {
                    break;
                }
                i2++;
            }
            return enumC3096g9 == null ? EnumC3096g9.NotSupported : enumC3096g9;
        }

        private a() {
        }
    }

    EnumC3096g9(int i) {
        this.f3314a = i;
    }

    public final int b() {
        return this.f3314a;
    }

    public final boolean b(EnumC3096g9 instanceType) {
        Intrinsics.checkNotNullParameter(instanceType, "instanceType");
        return instanceType.b() == this.f3314a;
    }
}
