package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final int f6190a = 0;

    public static final class a extends k {
        public static final int c = 8;
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.a b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.a companion) {
            super(null);
            Intrinsics.checkNotNullParameter(companion, "companion");
            this.b = companion;
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.a a() {
            return this.b;
        }
    }

    public static final class b extends k {
        public static final int c = 8;
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.a b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.a dec) {
            super(null);
            Intrinsics.checkNotNullParameter(dec, "dec");
            this.b = dec;
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.a a() {
            return this.b;
        }
    }

    public static final class c extends k {
        public static final int c = 8;
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c linear) {
            super(null);
            Intrinsics.checkNotNullParameter(linear, "linear");
            this.b = linear;
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.c a() {
            return this.b;
        }
    }

    public static final class d extends k {
        public static final int c = 8;
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j mraid) {
            super(null);
            Intrinsics.checkNotNullParameter(mraid, "mraid");
            this.b = mraid;
        }

        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.j a() {
            return this.b;
        }
    }

    public /* synthetic */ k(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public k() {
    }
}
