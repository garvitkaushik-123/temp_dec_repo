package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.r8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2842r8 extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2693a;
    public final /* synthetic */ C2858s8 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2842r8(C2858s8 c2858s8, String str) {
        super(0);
        this.f2693a = str;
        this.b = c2858s8;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        C2705j b = Nc.a().b(this.f2693a);
        I4 i4 = null;
        if (b != null) {
            C2858s8 c2858s8 = this.b;
            try {
                String str = b.c;
                if (str != null) {
                    i4 = C2858s8.a(c2858s8, str);
                    Unit unit = Unit.INSTANCE;
                    return i4;
                }
            } catch (Exception e) {
                Intrinsics.checkNotNullExpressionValue(c2858s8.x, "access$getTAG$p(...)");
                S5 s5 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e, "event"));
                Unit unit2 = Unit.INSTANCE;
            }
        }
        return i4;
    }
}
