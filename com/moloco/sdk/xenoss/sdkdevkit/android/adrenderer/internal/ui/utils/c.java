package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils;

import android.content.res.Resources;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.unit.IntSize;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f6046a = new c();
    public static final int b = 0;

    public final float a(int i) {
        return i / Resources.getSystem().getDisplayMetrics().density;
    }

    public final a.AbstractC0571a.g b(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return new a.AbstractC0571a.g(a(IntSize.m6559getWidthimpl(layoutCoordinates.mo5340getSizeYbymL2g())), a(IntSize.m6558getHeightimpl(layoutCoordinates.mo5340getSizeYbymL2g())));
    }

    public final a.AbstractC0571a.f a(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return new a.AbstractC0571a.f(a((int) Offset.m3822getXimpl(LayoutCoordinatesKt.positionInRoot(layoutCoordinates))), a((int) Offset.m3823getYimpl(LayoutCoordinatesKt.positionInRoot(layoutCoordinates))));
    }

    public final a.AbstractC0571a.f a(long j) {
        return new a.AbstractC0571a.f(a((int) Offset.m3822getXimpl(j)), a((int) Offset.m3823getYimpl(j)));
    }

    public final a.AbstractC0571a.c a(LayoutCoordinates layoutCoordinates, a.AbstractC0571a.c.EnumC0573a buttonType) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        return new a.AbstractC0571a.c(buttonType, a(layoutCoordinates), b(layoutCoordinates));
    }

    public final boolean a(a.AbstractC0571a.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        return cVar.f().c() > 0.0f && cVar.f().d() > 0.0f;
    }
}
