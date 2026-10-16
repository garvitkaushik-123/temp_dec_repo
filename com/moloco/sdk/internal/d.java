package com.moloco.sdk.internal;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.moloco.sdk.R;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.K;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f5383a = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.d$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return d.c();
        }
    });
    public static final long b = Color.INSTANCE.m4100getWhite0d7_KjU();
    public static final long c = u.a();
    public static final int d = 30;
    public static final long e;

    public static final class a implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0571a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.t f5384a;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.i b;

        public a(com.moloco.sdk.internal.ortb.model.t tVar, com.moloco.sdk.internal.ortb.model.i iVar) {
            this.f5384a = tVar;
            this.b = iVar;
        }

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(-1299178940);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1299178940, i, -1, "com.moloco.sdk.internal.determineSkipCloseBehaviorFromDec.<anonymous> (AggregatedOptions.kt:182)");
            }
            float m6389constructorimpl = Dp.m6389constructorimpl(this.f5384a.c());
            long m6411DpSizeYgX7TsA = DpKt.m6411DpSizeYgX7TsA(m6389constructorimpl, m6389constructorimpl);
            Alignment a2 = d.a(this.f5384a.i(), this.f5384a.m());
            PaddingValues m872PaddingValues0680j_4 = PaddingKt.m872PaddingValues0680j_4(Dp.m6389constructorimpl(this.f5384a.k()));
            long g = this.f5384a.g();
            long sp = TextUnitKt.getSp(this.f5384a.c());
            TextUnitKt.m6593checkArithmeticR2X_6o(sp);
            long pack = TextUnitKt.pack(TextUnit.m6578getRawTypeimpl(sp), TextUnit.m6580getValueimpl(sp) / 2);
            long m6492timesGh9hcWk = DpSize.m6492timesGh9hcWk(m6411DpSizeYgX7TsA, 0.4f);
            Color a3 = this.f5384a.a();
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a4 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.g.a(a2, m872PaddingValues0680j_4, g, m6411DpSizeYgX7TsA, pack, d.b(m6492timesGh9hcWk, a3 != null ? a3.m4073unboximpl() : d.b, composer, 0), null, this.b, composer, 0, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return a4;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0571a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class b implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0571a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5385a;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.t b;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.i c;

        public b(boolean z, com.moloco.sdk.internal.ortb.model.t tVar, com.moloco.sdk.internal.ortb.model.i iVar) {
            this.f5385a = z;
            this.b = tVar;
            this.c = iVar;
        }

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a2;
            composer.startReplaceableGroup(2061132145);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2061132145, i, -1, "com.moloco.sdk.internal.toCloseButton.<anonymous> (AggregatedOptions.kt:200)");
            }
            if (this.f5385a) {
                a2 = null;
            } else {
                float m6389constructorimpl = Dp.m6389constructorimpl(this.b.c());
                long m6411DpSizeYgX7TsA = DpKt.m6411DpSizeYgX7TsA(m6389constructorimpl, m6389constructorimpl);
                Alignment a3 = d.a(this.b.i(), this.b.m());
                PaddingValues m872PaddingValues0680j_4 = PaddingKt.m872PaddingValues0680j_4(Dp.m6389constructorimpl(this.b.k()));
                long g = this.b.g();
                long sp = TextUnitKt.getSp(this.b.c());
                TextUnitKt.m6593checkArithmeticR2X_6o(sp);
                long pack = TextUnitKt.pack(TextUnit.m6578getRawTypeimpl(sp), TextUnit.m6580getValueimpl(sp) / 2);
                Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.moloco_close, composer, 0);
                long m6492timesGh9hcWk = DpSize.m6492timesGh9hcWk(m6411DpSizeYgX7TsA, 0.45f);
                Color a4 = this.b.a();
                a2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.q.a(a3, m872PaddingValues0680j_4, g, m6411DpSizeYgX7TsA, pack, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.q.a(painterResource, m6492timesGh9hcWk, null, a4 != null ? a4.m4073unboximpl() : d.b, composer, 0, 4), null, this.c, composer, 0, 64);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return a2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0571a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class c implements Function2<Composer, Integer, Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, ? extends Unit>, ? super Function1<? super Boolean, ? extends Unit>, ? super Composer, ? super Integer, ? extends Unit>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.p f5386a;

        public c(com.moloco.sdk.internal.ortb.model.p pVar) {
            this.f5386a = pVar;
        }

        public final Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> a(Composer composer, int i) {
            long j;
            composer.startReplaceableGroup(1012987991);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1012987991, i, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:77)");
            }
            if (this.f5386a.k().c() != null) {
                float m6389constructorimpl = Dp.m6389constructorimpl(r1.getData());
                j = DpKt.m6411DpSizeYgX7TsA(m6389constructorimpl, m6389constructorimpl);
            } else {
                j = d.e;
            }
            Alignment a2 = d.a(this.f5386a.k().g(), this.f5386a.k().m());
            PaddingValues m872PaddingValues0680j_4 = PaddingKt.m872PaddingValues0680j_4(Dp.m6389constructorimpl(this.f5386a.k().k()));
            long m6492timesGh9hcWk = DpSize.m6492timesGh9hcWk(j, 0.6f);
            long e = this.f5386a.k().e();
            Color a3 = this.f5386a.k().a();
            Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> a4 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.a(j, m6492timesGh9hcWk, null, a3 != null ? a3.m4073unboximpl() : d.b, a2, m872PaddingValues0680j_4, e, PainterResources_androidKt.painterResource(R.drawable.moloco_volume_off, composer, 0), PainterResources_androidKt.painterResource(R.drawable.moloco_volume_on, composer, 0), null, composer, 0, 516);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return a4;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0571a.c, ? super a.AbstractC0571a.c.EnumC0573a, ? extends Unit>, ? super Function1<? super Boolean, ? extends Unit>, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    /* renamed from: com.moloco.sdk.internal.d$d, reason: collision with other inner class name */
    public static final class C0427d implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0571a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.p f5387a;

        public C0427d(com.moloco.sdk.internal.ortb.model.p pVar) {
            this.f5387a = pVar;
        }

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a2;
            composer.startReplaceableGroup(-168563086);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-168563086, i, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:92)");
            }
            com.moloco.sdk.internal.ortb.model.t o = this.f5387a.o();
            if (o == null) {
                a2 = null;
            } else {
                com.moloco.sdk.internal.ortb.model.p pVar = this.f5387a;
                float m6389constructorimpl = Dp.m6389constructorimpl(o.c());
                long m6411DpSizeYgX7TsA = DpKt.m6411DpSizeYgX7TsA(m6389constructorimpl, m6389constructorimpl);
                Alignment a3 = d.a(o.i(), o.m());
                PaddingValues m872PaddingValues0680j_4 = PaddingKt.m872PaddingValues0680j_4(Dp.m6389constructorimpl(o.k()));
                long g = o.g();
                long sp = TextUnitKt.getSp(o.c());
                TextUnitKt.m6593checkArithmeticR2X_6o(sp);
                long pack = TextUnitKt.pack(TextUnit.m6578getRawTypeimpl(sp), TextUnit.m6580getValueimpl(sp) / 2);
                long m6492timesGh9hcWk = DpSize.m6492timesGh9hcWk(m6411DpSizeYgX7TsA, 0.4f);
                Color a4 = o.a();
                a2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.g.a(a3, m872PaddingValues0680j_4, g, m6411DpSizeYgX7TsA, pack, d.b(m6492timesGh9hcWk, a4 != null ? a4.m4073unboximpl() : d.b, composer, 0), null, pVar.e(), composer, 0, 64);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return a2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0571a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class e implements Function2<Composer, Integer, Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0571a.c, ? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5388a;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.p b;

        public e(boolean z, com.moloco.sdk.internal.ortb.model.p pVar) {
            this.f5388a = z;
            this.b = pVar;
        }

        public final Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0571a.c, Unit>, Function0<Unit>, Composer, Integer, Unit> a(Composer composer, int i) {
            Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0571a.c, Unit>, Function0<Unit>, Composer, Integer, Unit> function7;
            Composer composer2;
            com.moloco.sdk.internal.ortb.model.g g;
            composer.startReplaceableGroup(616016756);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(616016756, i, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:110)");
            }
            if (this.f5388a || (g = this.b.g()) == null) {
                function7 = null;
                composer2 = composer;
            } else {
                Alignment a2 = d.a(g.e(), g.m());
                PaddingValues m872PaddingValues0680j_4 = PaddingKt.m872PaddingValues0680j_4(Dp.m6389constructorimpl(g.i()));
                String k = g.k();
                long c = g.c();
                Color a3 = g.a();
                composer2 = composer;
                function7 = u.a(a2, m872PaddingValues0680j_4, k, c, a3 != null ? a3.m4073unboximpl() : u.a(), g.g(), composer2, 0, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2.endReplaceableGroup();
            return function7;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0571a.c, ? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class f implements Function2<Composer, Integer, Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, ? extends Unit>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f5389a;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.p b;

        public f(boolean z, com.moloco.sdk.internal.ortb.model.p pVar) {
            this.f5389a = z;
            this.b = pVar;
        }

        public final Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> a(Composer composer, int i) {
            Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> function5;
            Composer composer2;
            com.moloco.sdk.internal.ortb.model.q m;
            composer.startReplaceableGroup(962638324);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(962638324, i, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:128)");
            }
            if (this.f5389a || (m = this.b.m()) == null) {
                function5 = null;
                composer2 = composer;
            } else {
                composer2 = composer;
                function5 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.a(d.a(m.c(), m.g()), PaddingKt.m872PaddingValues0680j_4(Dp.m6389constructorimpl(m.e())), m.a(), composer2, 0, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2.endReplaceableGroup();
            return function5;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class g implements Function2<Composer, Integer, Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.p f5390a;

        public g(com.moloco.sdk.internal.ortb.model.p pVar) {
            this.f5390a = pVar;
        }

        public final Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(524680050);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(524680050, i, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:142)");
            }
            com.moloco.sdk.internal.ortb.model.u q = this.f5390a.q();
            composer.startReplaceableGroup(-1135751215);
            Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit> a2 = q == null ? null : com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h.a(d.a(q.a(), q.e()), PaddingKt.m872PaddingValues0680j_4(Dp.m6389constructorimpl(q.c())), composer, 0, 0);
            composer.endReplaceableGroup();
            if (a2 == null) {
                a2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h.a(null, null, composer, 0, 3);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return a2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    static {
        float f2 = 30;
        e = DpKt.m6411DpSizeYgX7TsA(Dp.m6389constructorimpl(f2), Dp.m6389constructorimpl(f2));
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h b(com.moloco.sdk.internal.ortb.model.p pVar) {
        Intrinsics.checkNotNullParameter(pVar, "<this>");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f a2 = a(pVar, false);
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h(b(pVar, false), a2, a2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final com.moloco.sdk.internal.ortb.model.p c() {
        long j = c;
        int m10336constructorimpl = UInt.m10336constructorimpl(30);
        com.moloco.sdk.internal.ortb.model.l lVar = com.moloco.sdk.internal.ortb.model.l.d;
        com.moloco.sdk.internal.ortb.model.v vVar = com.moloco.sdk.internal.ortb.model.v.b;
        DefaultConstructorMarker defaultConstructorMarker = null;
        Color color = null;
        com.moloco.sdk.internal.ortb.model.t tVar = new com.moloco.sdk.internal.ortb.model.t(5, 10, m10336constructorimpl, lVar, vVar, j, color, 64, defaultConstructorMarker);
        com.moloco.sdk.internal.ortb.model.q qVar = new com.moloco.sdk.internal.ortb.model.q(0, com.moloco.sdk.internal.ortb.model.l.c, com.moloco.sdk.internal.ortb.model.v.d, j, null);
        Object[] objArr = 0 == true ? 1 : 0;
        return new com.moloco.sdk.internal.ortb.model.p(tVar, tVar, qVar, new com.moloco.sdk.internal.ortb.model.o((boolean) objArr, 10, com.moloco.sdk.internal.ortb.model.l.b, vVar, j, (UInt) null, color, 96, defaultConstructorMarker), (com.moloco.sdk.internal.ortb.model.g) null, true, new com.moloco.sdk.internal.ortb.model.a(false, false, (String) null, 6, (DefaultConstructorMarker) null), (com.moloco.sdk.internal.ortb.model.u) null, (com.moloco.sdk.internal.ortb.model.j) null, (com.moloco.sdk.internal.ortb.model.i) null, 384, (DefaultConstructorMarker) null);
    }

    public static final com.moloco.sdk.internal.ortb.model.p f() {
        return (com.moloco.sdk.internal.ortb.model.p) f5383a.getValue();
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h a(com.moloco.sdk.internal.ortb.model.p pVar) {
        Intrinsics.checkNotNullParameter(pVar, "<this>");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f a2 = a(pVar, true);
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h(b(pVar, true), a2, a2);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h b() {
        return b(f());
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h a() {
        return a(f());
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y b(com.moloco.sdk.internal.ortb.model.p pVar, boolean z) {
        com.moloco.sdk.internal.ortb.model.k e2;
        UInt a2;
        boolean i = pVar.k().i();
        Boolean bool = pVar.o() == null ? null : Boolean.TRUE;
        com.moloco.sdk.internal.ortb.model.t o = pVar.o();
        int i2 = 0;
        int e3 = o != null ? o.e() : 0;
        com.moloco.sdk.internal.ortb.model.a a3 = pVar.a();
        boolean z2 = a3 != null && a3.a() && pVar.a().e();
        com.moloco.sdk.internal.ortb.model.a a4 = pVar.a();
        boolean z3 = a4 != null && a4.a();
        int e4 = pVar.c().e();
        com.moloco.sdk.internal.ortb.model.j i3 = pVar.i();
        if (i3 != null && (e2 = i3.e()) != null && (a2 = e2.a()) != null) {
            i2 = a2.getData();
        }
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y(i, bool, e3, e4, i2, z2, z3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.a(0L, new c(pVar), a(pVar.c(), z, pVar.e()), new C0427d(pVar), new e(z, pVar), p.a(pVar.s()), new f(z, pVar), new g(pVar), (Function2) null, (K) null, 769, (Object) null));
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f a(com.moloco.sdk.internal.ortb.model.p pVar, boolean z) {
        com.moloco.sdk.internal.ortb.model.k e2;
        UInt a2;
        int e3 = pVar.c().e();
        Function9 a3 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b.a(0L, a(z, pVar.c(), pVar.i(), pVar.e()), 1, null);
        com.moloco.sdk.internal.ortb.model.j i = pVar.i();
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f(e3, a3, (i == null || (e2 = i.e()) == null || (a2 = e2.a()) == null) ? 0 : a2.getData(), a(pVar.c(), z, null, 2, null));
    }

    public static final Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> a(boolean z, com.moloco.sdk.internal.ortb.model.t close, com.moloco.sdk.internal.ortb.model.j jVar, com.moloco.sdk.internal.ortb.model.i iVar) {
        Intrinsics.checkNotNullParameter(close, "close");
        if (jVar == null) {
            return a(close, z, iVar);
        }
        return new a(close, iVar);
    }

    public static final Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0571a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> a(com.moloco.sdk.internal.ortb.model.t tVar, boolean z, com.moloco.sdk.internal.ortb.model.i iVar) {
        return new b(z, tVar, iVar);
    }

    public static /* synthetic */ Function2 a(com.moloco.sdk.internal.ortb.model.t tVar, boolean z, com.moloco.sdk.internal.ortb.model.i iVar, int i, Object obj) {
        if ((i & 2) != 0) {
            iVar = null;
        }
        return a(tVar, z, iVar);
    }

    public static final Alignment a(com.moloco.sdk.internal.ortb.model.l horizontalAlignment, com.moloco.sdk.internal.ortb.model.v verticalAlignment) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        com.moloco.sdk.internal.ortb.model.v vVar = com.moloco.sdk.internal.ortb.model.v.b;
        if (verticalAlignment == vVar && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.b || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.e)) {
            return Alignment.INSTANCE.getTopStart();
        }
        if (verticalAlignment == vVar && horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.c) {
            return Alignment.INSTANCE.getTopCenter();
        }
        if (verticalAlignment == vVar && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.d || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.f)) {
            return Alignment.INSTANCE.getTopEnd();
        }
        com.moloco.sdk.internal.ortb.model.v vVar2 = com.moloco.sdk.internal.ortb.model.v.c;
        if (verticalAlignment == vVar2 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.b || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.e)) {
            return Alignment.INSTANCE.getCenterStart();
        }
        if (verticalAlignment == vVar2 && horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.c) {
            return Alignment.INSTANCE.getCenter();
        }
        if (verticalAlignment == vVar2 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.d || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.f)) {
            return Alignment.INSTANCE.getCenterEnd();
        }
        com.moloco.sdk.internal.ortb.model.v vVar3 = com.moloco.sdk.internal.ortb.model.v.d;
        return (verticalAlignment == vVar3 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.b || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.e)) ? Alignment.INSTANCE.getBottomStart() : (verticalAlignment == vVar3 && horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.c) ? Alignment.INSTANCE.getBottomCenter() : (verticalAlignment == vVar3 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.d || horizontalAlignment == com.moloco.sdk.internal.ortb.model.l.f)) ? Alignment.INSTANCE.getBottomEnd() : Alignment.INSTANCE.getTopStart();
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o b(long j, long j2, Composer composer, int i) {
        composer.startReplaceableGroup(-868162195);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-868162195, i, -1, "com.moloco.sdk.internal.defaultMolocoSkipAfterCountdownButtonPart (AggregatedOptions.kt:159)");
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o a2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.g.a(PainterResources_androidKt.painterResource(R.drawable.moloco_skip, composer, 0), j, null, j2, composer, ((i << 3) & 112) | ((i << 6) & 7168), 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return a2;
    }
}
