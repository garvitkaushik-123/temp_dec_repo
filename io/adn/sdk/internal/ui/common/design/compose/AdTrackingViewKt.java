package io.adn.sdk.internal.ui.common.design.compose;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdTrackingView.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0001¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"AdTrackingView", "", "uuid", "", "modifier", "Landroidx/compose/ui/Modifier;", "onViewAttached", "Lkotlin/Function1;", "Landroid/view/View;", "onViewDetached", "Lkotlin/Function0;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdTrackingViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final FrameLayout AdTrackingView$lambda$2$lambda$1(FrameLayout frameLayout, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdTrackingView$lambda$6(String str, Modifier modifier, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        AdTrackingView(str, modifier, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AdTrackingView(final String uuid, final Modifier modifier, final Function1<? super View, Unit> onViewAttached, final Function0<Unit> onViewDetached, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(onViewAttached, "onViewAttached");
        Intrinsics.checkNotNullParameter(onViewDetached, "onViewDetached");
        Composer startRestartGroup = composer.startRestartGroup(-617755098);
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(uuid) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(onViewAttached) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(onViewDetached) ? 2048 : 1024;
        }
        int i3 = i2;
        if ((i3 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-617755098, i3, -1, "io.adn.sdk.internal.ui.common.design.compose.AdTrackingView (AdTrackingView.kt:17)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            Context context = (Context) consume;
            startRestartGroup.startReplaceableGroup(-1740689533);
            int i4 = i3 & 14;
            boolean z = i4 == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new FrameLayout(context);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final FrameLayout frameLayout = (FrameLayout) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1740685856);
            boolean changedInstance = startRestartGroup.changedInstance(frameLayout);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.AdTrackingViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        FrameLayout AdTrackingView$lambda$2$lambda$1;
                        AdTrackingView$lambda$2$lambda$1 = AdTrackingViewKt.AdTrackingView$lambda$2$lambda$1(frameLayout, (Context) obj);
                        return AdTrackingView$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            AndroidView_androidKt.AndroidView((Function1) rememberedValue2, modifier, null, startRestartGroup, i3 & 112, 4);
            startRestartGroup.startReplaceableGroup(-1740684169);
            boolean changedInstance2 = ((i3 & 896) == 256) | startRestartGroup.changedInstance(frameLayout) | ((i3 & 7168) == 2048);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.AdTrackingViewKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        DisposableEffectResult AdTrackingView$lambda$5$lambda$4;
                        AdTrackingView$lambda$5$lambda$4 = AdTrackingViewKt.AdTrackingView$lambda$5$lambda$4(Function1.this, frameLayout, onViewDetached, (DisposableEffectScope) obj);
                        return AdTrackingView$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(uuid, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue3, startRestartGroup, i4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.design.compose.AdTrackingViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdTrackingView$lambda$6;
                    AdTrackingView$lambda$6 = AdTrackingViewKt.AdTrackingView$lambda$6(uuid, modifier, onViewAttached, onViewDetached, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AdTrackingView$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult AdTrackingView$lambda$5$lambda$4(Function1 function1, FrameLayout frameLayout, final Function0 function0, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        function1.invoke(frameLayout);
        return new DisposableEffectResult() { // from class: io.adn.sdk.internal.ui.common.design.compose.AdTrackingViewKt$AdTrackingView$lambda$5$lambda$4$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                Function0.this.invoke();
            }
        };
    }
}
