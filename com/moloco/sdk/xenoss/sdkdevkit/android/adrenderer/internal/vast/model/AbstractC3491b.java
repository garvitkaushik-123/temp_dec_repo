package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC3491b {

    /* renamed from: a, reason: collision with root package name */
    public static final int f6139a = 0;

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b$a */
    public static final class a extends AbstractC3491b {
        public static final int c = 8;
        public final o b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o inline) {
            super(null);
            Intrinsics.checkNotNullParameter(inline, "inline");
            this.b = inline;
        }

        public final o a() {
            return this.b;
        }
    }

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.b$b, reason: collision with other inner class name */
    public static final class C0532b extends AbstractC3491b {
        public static final int c = 8;
        public final B b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0532b(B wrapper) {
            super(null);
            Intrinsics.checkNotNullParameter(wrapper, "wrapper");
            this.b = wrapper;
        }

        public final B a() {
            return this.b;
        }
    }

    public /* synthetic */ AbstractC3491b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public AbstractC3491b() {
    }
}
