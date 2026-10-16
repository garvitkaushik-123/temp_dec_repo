package com.inmobi.media;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.k8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2730k8 extends M8 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2730k8(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String borderStrokeStyle, String borderCornerStyle, String borderColor, String backgroundColor, int i9, String textColor, ArrayList textStyles, P8 nativeAnimationTimer) {
        super(i, i2, i3, i4, i5, i6, i7, i8, borderStrokeStyle, borderCornerStyle, borderColor, backgroundColor, 12, (byte) 0, "#ff000000", CollectionsKt.mutableListOf("none"), nativeAnimationTimer);
        Intrinsics.checkNotNullParameter(borderStrokeStyle, "borderStrokeStyle");
        Intrinsics.checkNotNullParameter(borderCornerStyle, "borderCornerStyle");
        Intrinsics.checkNotNullParameter(borderColor, "borderColor");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(textColor, "textColor");
        Intrinsics.checkNotNullParameter(textStyles, "textStyles");
        Intrinsics.checkNotNullParameter(nativeAnimationTimer, "nativeAnimationTimer");
        this.l = i9;
        String str = textColor.length() == 0 ? "#ff000000" : textColor;
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.n = str;
        int min = Math.min(textStyles.size(), 1);
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.o = arrayList;
        if (min < 0) {
            return;
        }
        int i10 = 0;
        while (true) {
            this.o.add(textStyles.get(i10));
            if (i10 == min) {
                return;
            } else {
                i10++;
            }
        }
    }
}
