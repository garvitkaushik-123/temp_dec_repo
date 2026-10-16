package com.moloco.sdk.internal.services.events;

import com.moloco.sdk.UserIntent;
import com.moloco.sdk.internal.services.E;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5679a = "CustomUserEventBuilderServiceImpl";
    public static final String b = "user_ad_interaction_ext";

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5680a;

        static {
            int[] iArr = new int[a.AbstractC0571a.c.EnumC0573a.values().length];
            try {
                iArr[a.AbstractC0571a.c.EnumC0573a.f6356a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.AbstractC0571a.c.EnumC0573a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.AbstractC0571a.c.EnumC0573a.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[a.AbstractC0571a.c.EnumC0573a.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[a.AbstractC0571a.c.EnumC0573a.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[a.AbstractC0571a.c.EnumC0573a.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[a.AbstractC0571a.c.EnumC0573a.g.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[a.AbstractC0571a.c.EnumC0573a.h.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[a.AbstractC0571a.c.EnumC0573a.i.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f5680a = iArr;
        }
    }

    public static final UserIntent.UserAdInteractionExt.Button.Type a(a.AbstractC0571a.c.EnumC0573a enumC0573a) {
        Intrinsics.checkNotNullParameter(enumC0573a, "<this>");
        switch (a.f5680a[enumC0573a.ordinal()]) {
            case 1:
                return UserIntent.UserAdInteractionExt.Button.Type.NONE;
            case 2:
                return UserIntent.UserAdInteractionExt.Button.Type.CLOSE;
            case 3:
                return UserIntent.UserAdInteractionExt.Button.Type.SKIP;
            case 4:
                return UserIntent.UserAdInteractionExt.Button.Type.DEC_SKIP;
            case 5:
                return UserIntent.UserAdInteractionExt.Button.Type.MUTE;
            case 6:
                return UserIntent.UserAdInteractionExt.Button.Type.UNMUTE;
            case 7:
                return UserIntent.UserAdInteractionExt.Button.Type.CTA;
            case 8:
                return UserIntent.UserAdInteractionExt.Button.Type.REPLAY;
            case 9:
                return UserIntent.UserAdInteractionExt.Button.Type.AD_BADGE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final UserIntent.UserAdInteractionExt.Position a(a.AbstractC0571a.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        UserIntent.UserAdInteractionExt.Position.Builder newBuilder = UserIntent.UserAdInteractionExt.Position.newBuilder();
        newBuilder.setX(fVar.c());
        newBuilder.setY(fVar.d());
        UserIntent.UserAdInteractionExt.Position build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    public static final UserIntent.UserAdInteractionExt.Size a(a.AbstractC0571a.g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        UserIntent.UserAdInteractionExt.Size.Builder newBuilder = UserIntent.UserAdInteractionExt.Size.newBuilder();
        newBuilder.setW(gVar.d());
        newBuilder.setH(gVar.c());
        UserIntent.UserAdInteractionExt.Size build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    public static final UserIntent.UserAdInteractionExt.Size a(E e) {
        Intrinsics.checkNotNullParameter(e, "<this>");
        UserIntent.UserAdInteractionExt.Size.Builder newBuilder = UserIntent.UserAdInteractionExt.Size.newBuilder();
        newBuilder.setW(e.m());
        newBuilder.setH(e.k());
        UserIntent.UserAdInteractionExt.Size build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }
}
