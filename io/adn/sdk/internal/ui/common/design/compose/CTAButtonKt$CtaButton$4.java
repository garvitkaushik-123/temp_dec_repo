package io.adn.sdk.internal.ui.common.design.compose;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import coil.compose.SingletonAsyncImageKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CTAButton.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
final class CTAButtonKt$CtaButton$4 implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ long $buttonColor;
    final /* synthetic */ RoundedCornerShape $cornerShape;
    final /* synthetic */ Object $icon;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ String $text;
    final /* synthetic */ long $textColor;
    final /* synthetic */ long $textSize;

    CTAButtonKt$CtaButton$4(RoundedCornerShape roundedCornerShape, long j, Function0<Unit> function0, Object obj, long j2, long j3, String str, long j4) {
        this.$cornerShape = roundedCornerShape;
        this.$backgroundColor = j;
        this.$onClick = function0;
        this.$icon = obj;
        this.$buttonColor = j2;
        this.$textColor = j3;
        this.$text = str;
        this.$textSize = j4;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
        invoke(animatedVisibilityScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        float f;
        long j;
        long j2;
        long j3;
        Function0<Unit> function0;
        String str;
        Object obj;
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(672321395, i, -1, "io.adn.sdk.internal.ui.common.design.compose.CtaButton.<anonymous> (CTAButton.kt:93)");
        }
        float f2 = 8;
        Modifier m879padding3ABfNKs = PaddingKt.m879padding3ABfNKs(BackgroundKt.m527backgroundbw27NRU$default(ClipKt.clip(SizeKt.m914height3ABfNKs(SizeKt.wrapContentWidth$default(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally(), false, 2, null), Dp.m6389constructorimpl(59)), this.$cornerShape), Color.m4062copywmQWz5c$default(this.$backgroundColor, 0.8f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), Dp.m6389constructorimpl(f2));
        composer.startReplaceableGroup(-1501896579);
        boolean changed = composer.changed(this.$onClick);
        final Function0<Unit> function02 = this.$onClick;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.CTAButtonKt$CtaButton$4$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = CTAButtonKt$CtaButton$4.invoke$lambda$1$lambda$0(Function0.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier m561clickableXHw0xAI$default = ClickableKt.m561clickableXHw0xAI$default(m879padding3ABfNKs, false, null, null, (Function0) rememberedValue, 7, null);
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        Object obj2 = this.$icon;
        long j4 = this.$buttonColor;
        long j5 = this.$textColor;
        Function0<Unit> function03 = this.$onClick;
        String str2 = this.$text;
        long j6 = this.$textSize;
        composer.startReplaceableGroup(693286680);
        ComposerKt.sourceInformation(composer, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m561clickableXHw0xAI$default);
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer);
        Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(composer, -326681643, "C92@4661L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        composer.startReplaceableGroup(-870041532);
        if (obj2 != null) {
            j = j6;
            j2 = j4;
            j3 = j5;
            function0 = function03;
            str = str2;
            f = f2;
            obj = null;
            SingletonAsyncImageKt.m6742AsyncImagegl8XCv8(obj2, null, ClipKt.clip(SizeKt.m928size3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(43)), RoundedCornerShapeKt.m1149RoundedCornerShape0680j_4(Dp.m6389constructorimpl(f2))), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, null, composer, 1572912, 0, 4024);
            SpacerKt.Spacer(SizeKt.m933width3ABfNKs(Modifier.INSTANCE, Dp.m6389constructorimpl(16)), composer, 6);
        } else {
            f = f2;
            j = j6;
            j2 = j4;
            j3 = j5;
            function0 = function03;
            str = str2;
            obj = null;
        }
        composer.endReplaceableGroup();
        final long j7 = j;
        final long j8 = j3;
        final String str3 = str;
        ButtonKt.Button(function0, SizeKt.m914height3ABfNKs(SizeKt.m935widthInVpY3zN4$default(Modifier.INSTANCE, Dp.m6389constructorimpl(87), 0.0f, 2, obj), Dp.m6389constructorimpl(43)), false, RoundedCornerShapeKt.m1149RoundedCornerShape0680j_4(Dp.m6389constructorimpl(f)), ButtonDefaults.INSTANCE.m1923buttonColorsro_MJ88(j2, j3, 0L, 0L, composer, ButtonDefaults.$stable << 12, 12), null, null, null, null, ComposableLambdaKt.composableLambda(composer, 615814087, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: io.adn.sdk.internal.ui.common.design.compose.CTAButtonKt$CtaButton$4$2$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                invoke(rowScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope Button, Composer composer2, int i2) {
                Intrinsics.checkNotNullParameter(Button, "$this$Button");
                if ((i2 & 17) != 16 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(615814087, i2, -1, "io.adn.sdk.internal.ui.common.design.compose.CtaButton.<anonymous>.<anonymous>.<anonymous> (CTAButton.kt:128)");
                    }
                    TextKt.m2781Text4IGK_g(str3, (Modifier) null, j8, j7, (FontStyle) null, (FontWeight) null, (FontFamily) null, TextUnitKt.getSp(0), (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 12582912, 3072, 122738);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), composer, 805306416, 484);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }
}
