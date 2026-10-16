package com.moloco.sdk.internal.services.init;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5704a = 0;

    public static final class a extends j {
        public static final int c = 0;
        public final com.moloco.sdk.internal.services.init.b b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.moloco.sdk.internal.services.init.b type) {
            super(null);
            Intrinsics.checkNotNullParameter(type, "type");
            this.b = type;
        }

        public final com.moloco.sdk.internal.services.init.b a() {
            return this.b;
        }
    }

    public static final class b extends j {
        public static final int c = 0;
        public final int b;

        public b(int i) {
            super(null);
            this.b = i;
        }

        public final int a() {
            return this.b;
        }
    }

    public /* synthetic */ j(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public j() {
    }
}
