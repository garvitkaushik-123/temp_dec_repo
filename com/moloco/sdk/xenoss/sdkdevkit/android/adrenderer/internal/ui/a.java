package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.moloco.sdk.R;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3463m;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5995a = "https://cdn-f.adsmoloco.com/moloco-cdn/privacy.html";

    public static final class b implements Function4<BoxScope, Function1<? super a.AbstractC0571a.c, ? extends Unit>, Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Modifier f5999a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function1<String, Unit> c;

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$b$a, reason: collision with other inner class name */
        public static final class C0512a implements Function3<Modifier, Composer, Integer, Unit> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Modifier f6000a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Function1<String, Unit> c;

            /* JADX WARN: Multi-variable type inference failed */
            public C0512a(Modifier modifier, String str, Function1<? super String, Unit> function1) {
                this.f6000a = modifier;
                this.b = str;
                this.c = function1;
            }

            public final void a(Modifier trackableModifier, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(trackableModifier, "trackableModifier");
                if ((i & 6) == 0) {
                    i |= composer.changed(trackableModifier) ? 4 : 2;
                }
                if ((i & 19) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(592042825, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultWebViewAdBadge.<anonymous>.<anonymous> (AdBadge.kt:136)");
                }
                a.a(this.f6000a.then(trackableModifier), this.b, this.c, composer, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                a(modifier, composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Modifier modifier, String str, Function1<? super String, Unit> function1) {
            this.f5999a = modifier;
            this.b = str;
            this.c = function1;
        }

        public final void a(BoxScope boxScope, Function1<? super a.AbstractC0571a.c, Unit> onButtonRendered, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(boxScope, "<this>");
            Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
            if ((i & 48) == 0) {
                i |= composer.changed(onButtonRendered) ? 32 : 16;
            }
            if ((i & 145) == 144 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-652534615, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultWebViewAdBadge.<anonymous> (AdBadge.kt:132)");
            }
            v.a(null, a.AbstractC0571a.c.EnumC0573a.i, onButtonRendered, ComposableLambdaKt.composableLambda(composer, 592042825, true, new C0512a(this.f5999a, this.b, this.c)), composer, ((i << 3) & 896) | 3120, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Function1<? super a.AbstractC0571a.c, ? extends Unit> function1, Composer composer, Integer num) {
            a(boxScope, function1, composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(Modifier modifier, String str, Function1 function1, int i, int i2, Composer composer, int i3) {
        a(modifier, str, function1, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    public static final Function5<BoxScope, Function1<? super a.AbstractC0571a.c, Unit>, StateFlow<? extends i.a>, Composer, Integer, Unit> b(Modifier modifier, final String str, final InterfaceC3463m interfaceC3463m, Function1<? super String, Unit> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1665380566);
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = f5995a;
        }
        if ((i2 & 4) != 0) {
            interfaceC3463m = a.h.f5756a.f();
        }
        if ((i2 & 8) != 0) {
            composer.startReplaceableGroup(-819746825);
            boolean changed = composer.changed(interfaceC3463m) | composer.changed(str);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return a.b(InterfaceC3463m.this, str, (String) obj);
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            function1 = (Function1) rememberedValue;
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1665380566, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultVastAdBadge (AdBadge.kt:80)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 781429248, true, new C0510a(modifier, str, function1));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    public static final Function4<BoxScope, Function1<? super a.AbstractC0571a.c, Unit>, Composer, Integer, Unit> c(Modifier modifier, final String str, final InterfaceC3463m interfaceC3463m, Function1<? super String, Unit> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1806921710);
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = f5995a;
        }
        if ((i2 & 4) != 0) {
            interfaceC3463m = a.h.f5756a.f();
        }
        if ((i2 & 8) != 0) {
            composer.startReplaceableGroup(-763782490);
            boolean changed = composer.changed(interfaceC3463m) | composer.changed(str);
            Object rememberedValue = composer.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return a.c(InterfaceC3463m.this, str, (String) obj);
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            function1 = (Function1) rememberedValue;
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1806921710, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultWebViewAdBadge (AdBadge.kt:131)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -652534615, true, new b(modifier, str, function1));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    public static final Unit a(int i, Composer composer, int i2) {
        a(composer, i | 1);
        return Unit.INSTANCE;
    }

    public static final Unit a(Modifier modifier, String str, InterfaceC3463m interfaceC3463m, Function1 function1, int i, int i2, Composer composer, int i3) {
        a(modifier, str, interfaceC3463m, (Function1<? super String, Unit>) function1, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    public static final void a(Modifier modifier, final String clickUrl, final Function1<? super String, Unit> onClick, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(clickUrl, "clickUrl");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(1037954372);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(clickUrl) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(onClick) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1037954372, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.AdBadge (AdBadge.kt:43)");
            }
            startRestartGroup.startReplaceableGroup(-363689698);
            final String str = "Ad Badge";
            boolean changed = startRestartGroup.changed("Ad Badge");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return a.a(str, (SemanticsPropertyReceiver) obj);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier m920requiredSize3ABfNKs = SizeKt.m920requiredSize3ABfNKs(SemanticsModifierKt.semantics$default(modifier3, false, (Function1) rememberedValue, 1, null), Dp.m6389constructorimpl(12));
            startRestartGroup.startReplaceableGroup(-363682862);
            boolean changed2 = startRestartGroup.changed(onClick) | startRestartGroup.changed(clickUrl);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return a.a(Function1.this, clickUrl);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            IconKt.m1692Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.info_badge, startRestartGroup, 0), "Ad Badge", ClickableKt.m561clickableXHw0xAI$default(m920requiredSize3ABfNKs, false, null, null, (Function0) rememberedValue2, 7, null), Color.INSTANCE.m4099getUnspecified0d7_KjU(), startRestartGroup, 3120, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return a.a(Modifier.this, clickUrl, onClick, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$a, reason: collision with other inner class name */
    public static final class C0510a implements Function5<BoxScope, Function1<? super a.AbstractC0571a.c, ? extends Unit>, StateFlow<? extends i.a>, Composer, Integer, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Modifier f5996a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function1<String, Unit> c;

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$a$a, reason: collision with other inner class name */
        public static final class C0511a implements Function3<Modifier, Composer, Integer, Unit> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Modifier f5997a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Function1<String, Unit> c;

            /* JADX WARN: Multi-variable type inference failed */
            public C0511a(Modifier modifier, String str, Function1<? super String, Unit> function1) {
                this.f5997a = modifier;
                this.b = str;
                this.c = function1;
            }

            public final void a(Modifier trackableModifier, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(trackableModifier, "trackableModifier");
                if ((i & 6) == 0) {
                    i |= composer.changed(trackableModifier) ? 4 : 2;
                }
                if ((i & 19) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1901554514, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultVastAdBadge.<anonymous>.<anonymous>.<anonymous> (AdBadge.kt:89)");
                }
                a.a(this.f5997a.then(trackableModifier), this.b, this.c, composer, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                a(modifier, composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        /* renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$a$b */
        public static final class b implements Function3<Modifier, Composer, Integer, Unit> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Modifier f5998a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Function1<String, Unit> c;

            /* JADX WARN: Multi-variable type inference failed */
            public b(Modifier modifier, String str, Function1<? super String, Unit> function1) {
                this.f5998a = modifier;
                this.b = str;
                this.c = function1;
            }

            public final void a(Modifier trackableModifier, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(trackableModifier, "trackableModifier");
                if ((i & 6) == 0) {
                    i |= composer.changed(trackableModifier) ? 4 : 2;
                }
                if ((i & 19) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1149096507, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultVastAdBadge.<anonymous>.<anonymous>.<anonymous> (AdBadge.kt:101)");
                }
                a.a(this.f5998a.then(trackableModifier), this.b, this.c, composer, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                a(modifier, composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0510a(Modifier modifier, String str, Function1<? super String, Unit> function1) {
            this.f5996a = modifier;
            this.b = str;
            this.c = function1;
        }

        public final void a(BoxScope boxScope, Function1<? super a.AbstractC0571a.c, Unit> onButtonRendered, StateFlow<? extends i.a> stateFlow, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(boxScope, "<this>");
            Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(781429248, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultVastAdBadge.<anonymous> (AdBadge.kt:81)");
            }
            if (stateFlow != null) {
                Modifier modifier = this.f5996a;
                String str = this.b;
                Function1<String, Unit> function1 = this.c;
                i.a a2 = a(SnapshotStateKt.collectAsState(stateFlow, null, composer, 0, 1));
                if (a2 instanceof i.a.c) {
                    composer.startReplaceableGroup(-784877573);
                    v.a(null, a.AbstractC0571a.c.EnumC0573a.i, onButtonRendered, ComposableLambdaKt.composableLambda(composer, 1901554514, true, new C0511a(modifier, str, function1)), composer, ((i << 3) & 896) | 3120, 1);
                    composer.endReplaceableGroup();
                } else if (a2 instanceof i.a.C0539a) {
                    composer.startReplaceableGroup(-784430181);
                    v.a(null, a.AbstractC0571a.c.EnumC0573a.i, onButtonRendered, ComposableLambdaKt.composableLambda(composer, 1149096507, true, new b(modifier, str, function1)), composer, ((i << 3) & 896) | 3120, 1);
                    composer.endReplaceableGroup();
                } else if (a2 instanceof i.a.b) {
                    composer.startReplaceableGroup(-784000800);
                    composer.endReplaceableGroup();
                } else if (a2 instanceof i.a.d) {
                    composer.startReplaceableGroup(-783943264);
                    composer.endReplaceableGroup();
                } else {
                    if (a2 != null) {
                        composer.startReplaceableGroup(-1687888084);
                        composer.endReplaceableGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer.startReplaceableGroup(-783908544);
                    composer.endReplaceableGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Function1<? super a.AbstractC0571a.c, ? extends Unit> function1, StateFlow<? extends i.a> stateFlow, Composer composer, Integer num) {
            a(boxScope, function1, stateFlow, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public static final i.a a(State<? extends i.a> state) {
            return state.getValue();
        }
    }

    public static final Unit c(InterfaceC3463m interfaceC3463m, String str, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        interfaceC3463m.a(str);
        return Unit.INSTANCE;
    }

    public static final Unit b(InterfaceC3463m interfaceC3463m, String str, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        interfaceC3463m.a(str);
        return Unit.INSTANCE;
    }

    public static final Unit a(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        SemanticsPropertiesKt.setTestTag(semantics, str);
        return Unit.INSTANCE;
    }

    public static final Unit a(Function1 function1, String str) {
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    public static final Unit a(InterfaceC3463m interfaceC3463m, String str, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        interfaceC3463m.a(str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(Modifier modifier, final String str, final InterfaceC3463m interfaceC3463m, Function1<? super String, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        String str2;
        Function1<? super String, Unit> function12;
        final Modifier modifier3;
        final String str3;
        final Function1<? super String, Unit> function13;
        Composer startRestartGroup = composer.startRestartGroup(-1950835232);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= ((i2 & 4) == 0 && startRestartGroup.changed(interfaceC3463m)) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= ((i2 & 8) == 0 && startRestartGroup.changed(function1)) ? 2048 : 1024;
        }
        if ((i3 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier;
            str3 = str;
            function13 = function1;
        } else {
            startRestartGroup.startDefaults();
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    str = f5995a;
                }
                if ((i2 & 4) != 0) {
                    interfaceC3463m = a.h.f5756a.f();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    startRestartGroup.startReplaceableGroup(1664240129);
                    boolean changed = startRestartGroup.changed(interfaceC3463m) | startRestartGroup.changed(str);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return a.a(InterfaceC3463m.this, str, (String) obj);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    i3 &= -7169;
                    modifier2 = modifier;
                    str2 = str;
                    function12 = (Function1) rememberedValue;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1950835232, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultNativeAdImageBadge (AdBadge.kt:155)");
                    }
                    a(modifier2, str2, function12, startRestartGroup, (i3 & 126) | ((i3 >> 3) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    str3 = str2;
                    function13 = function12;
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
            }
            modifier2 = modifier;
            str2 = str;
            function12 = function1;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            a(modifier2, str2, function12, startRestartGroup, (i3 & 126) | ((i3 >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            str3 = str2;
            function13 = function12;
        }
        final InterfaceC3463m interfaceC3463m2 = interfaceC3463m;
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return a.a(Modifier.this, str3, interfaceC3463m2, function13, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void a(Composer composer, final int i) {
        Composer startRestartGroup = composer.startRestartGroup(-1309369895);
        if (i == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1309369895, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.AdBadgePreview (AdBadge.kt:165)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, k.f6013a.a(), startRestartGroup, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return a.a(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
