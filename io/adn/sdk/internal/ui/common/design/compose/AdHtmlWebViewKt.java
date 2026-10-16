package io.adn.sdk.internal.ui.common.design.compose;

import android.content.Context;
import android.view.View;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import io.adn.sdk.internal.domain.model.ad.RedirectionStrategy;
import io.adn.sdk.internal.ui.common.lifecycle.BindWithLifecycleKt;
import io.adn.sdk.internal.ui.common.model.ClickPosition;
import io.adn.sdk.internal.ui.common.mraid.MraidController;
import io.adn.sdk.internal.ui.common.mraid.MraidLayoutMetricsKt;
import io.adn.sdk.internal.ui.utils.ViewKt;
import io.adn.sdk.publisher.AdnClickElement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AdHtmlWebView.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0096\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\t2O\u0010\u000b\u001aK\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0013¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00010\fH\u0001¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"AdHtmlWebView", "", "controller", "Lio/adn/sdk/internal/ui/common/mraid/MraidController;", "redirectionStrategy", "Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;", "modifier", "Landroidx/compose/ui/Modifier;", "onDisplayed", "Lkotlin/Function0;", "onDismiss", "onClick", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "hasUserClicked", "Lio/adn/sdk/publisher/AdnClickElement;", "clickElement", "Lio/adn/sdk/internal/ui/common/model/ClickPosition;", "clickPosition", "(Lio/adn/sdk/internal/ui/common/mraid/MraidController;Lio/adn/sdk/internal/domain/model/ad/RedirectionStrategy;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdHtmlWebViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdHtmlWebView$lambda$0(MraidController mraidController, RedirectionStrategy redirectionStrategy, Modifier modifier, Function0 function0, Function0 function02, Function3 function3, int i, int i2, Composer composer, int i3) {
        AdHtmlWebView(mraidController, redirectionStrategy, modifier, function0, function02, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdHtmlWebView$lambda$14(MraidController mraidController, RedirectionStrategy redirectionStrategy, Modifier modifier, Function0 function0, Function0 function02, Function3 function3, int i, int i2, Composer composer, int i3) {
        AdHtmlWebView(mraidController, redirectionStrategy, modifier, function0, function02, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:132:0x0311, code lost:
    
        if (r3 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L198;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AdHtmlWebView(final MraidController controller, final RedirectionStrategy redirectionStrategy, Modifier modifier, final Function0<Unit> onDisplayed, final Function0<Unit> onDismiss, final Function3<? super Boolean, ? super AdnClickElement, ? super ClickPosition, Unit> onClick, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final View adContainer;
        RedirectionStrategy redirectionStrategy2;
        int i5;
        int i6;
        final MraidController mraidController;
        Object obj;
        Composer composer2;
        Intrinsics.checkNotNullParameter(controller, "controller");
        Intrinsics.checkNotNullParameter(onDisplayed, "onDisplayed");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer startRestartGroup = composer.startRestartGroup(-1427769731);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? startRestartGroup.changed(controller) : startRestartGroup.changedInstance(controller) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(redirectionStrategy) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changedInstance(onDisplayed) ? 2048 : 1024;
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                i3 |= startRestartGroup.changedInstance(onDismiss) ? 16384 : 8192;
            }
            if ((i2 & 32) == 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                i3 |= startRestartGroup.changedInstance(onClick) ? 131072 : 65536;
            }
            i4 = i3;
            if ((74899 & i4) == 74898 || !startRestartGroup.getSkipping()) {
                final Modifier.Companion companion = i7 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1427769731, i4, -1, "io.adn.sdk.internal.ui.common.design.compose.AdHtmlWebView (AdHtmlWebView.kt:28)");
                }
                adContainer = controller.getAdContainer();
                if (adContainer != null) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.design.compose.AdHtmlWebViewKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                Unit AdHtmlWebView$lambda$0;
                                AdHtmlWebView$lambda$0 = AdHtmlWebViewKt.AdHtmlWebView$lambda$0(MraidController.this, redirectionStrategy, companion, onDisplayed, onDismiss, onClick, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                return AdHtmlWebView$lambda$0;
                            }
                        });
                        return;
                    }
                    return;
                }
                redirectionStrategy2 = redirectionStrategy;
                modifier2 = companion;
                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final float density = ((Density) consume).getDensity();
                startRestartGroup.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                    startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    rememberedValue = compositionScopedCoroutineScopeCanceller;
                }
                startRestartGroup.endReplaceableGroup();
                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(1913091070);
                int i8 = i4 & 14;
                boolean changedInstance = startRestartGroup.changedInstance(coroutineScope) | (i8 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(controller))) | ((i4 & 7168) == 2048) | ((57344 & i4) == 16384) | ((458752 & i4) == 131072);
                AdHtmlWebViewKt$AdHtmlWebView$1$1 rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    i5 = i8;
                    i6 = 0;
                    AdHtmlWebViewKt$AdHtmlWebView$1$1 adHtmlWebViewKt$AdHtmlWebView$1$1 = new AdHtmlWebViewKt$AdHtmlWebView$1$1(coroutineScope, controller, onDisplayed, onDismiss, onClick, null);
                    mraidController = controller;
                    rememberedValue2 = adHtmlWebViewKt$AdHtmlWebView$1$1;
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                } else {
                    mraidController = controller;
                    i5 = i8;
                    i6 = 0;
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(mraidController, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, i5);
                Unit unit = Unit.INSTANCE;
                startRestartGroup.startReplaceableGroup(1913105050);
                int i9 = ((i4 & 112) == 32 ? 1 : i6) | ((i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(mraidController))) ? 1 : i6);
                AdHtmlWebViewKt$AdHtmlWebView$2$1 rememberedValue3 = startRestartGroup.rememberedValue();
                if (i9 != 0 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new AdHtmlWebViewKt$AdHtmlWebView$2$1(mraidController, redirectionStrategy2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(1913109572);
                int i10 = (i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(mraidController))) ? 1 : i6;
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (i10 != 0 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.AdHtmlWebViewKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit AdHtmlWebView$lambda$4$lambda$3;
                            AdHtmlWebView$lambda$4$lambda$3 = AdHtmlWebViewKt.AdHtmlWebView$lambda$4$lambda$3(MraidController.this);
                            return AdHtmlWebView$lambda$4$lambda$3;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                Function0 function0 = (Function0) rememberedValue4;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(1913111717);
                int i11 = (i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(mraidController))) ? 1 : i6;
                Object rememberedValue5 = startRestartGroup.rememberedValue();
                if (i11 != 0 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.AdHtmlWebViewKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit AdHtmlWebView$lambda$6$lambda$5;
                            AdHtmlWebView$lambda$6$lambda$5 = AdHtmlWebViewKt.AdHtmlWebView$lambda$6$lambda$5(MraidController.this);
                            return AdHtmlWebView$lambda$6$lambda$5;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                Function0 function02 = (Function0) rememberedValue5;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(1913113798);
                int i12 = (i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(mraidController))) ? 1 : i6;
                Object rememberedValue6 = startRestartGroup.rememberedValue();
                if (i12 != 0 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue6 = new Function0() { // from class: io.adn.sdk.internal.ui.common.design.compose.AdHtmlWebViewKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit AdHtmlWebView$lambda$8$lambda$7;
                            AdHtmlWebView$lambda$8$lambda$7 = AdHtmlWebViewKt.AdHtmlWebView$lambda$8$lambda$7(MraidController.this);
                            return AdHtmlWebView$lambda$8$lambda$7;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                startRestartGroup.endReplaceableGroup();
                BindWithLifecycleKt.ObserveLifecycle(function0, function02, (Function0) rememberedValue6, startRestartGroup, i6);
                Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null);
                startRestartGroup.startReplaceableGroup(1913118939);
                int i13 = (startRestartGroup.changed(density) ? 1 : 0) | ((i5 == 4 || ((i4 & 8) != 0 && startRestartGroup.changedInstance(mraidController))) ? 1 : i6);
                Object rememberedValue7 = startRestartGroup.rememberedValue();
                if (i13 != 0 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue7 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.AdHtmlWebViewKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit AdHtmlWebView$lambda$10$lambda$9;
                            AdHtmlWebView$lambda$10$lambda$9 = AdHtmlWebViewKt.AdHtmlWebView$lambda$10$lambda$9(MraidController.this, density, (LayoutCoordinates) obj2);
                            return AdHtmlWebView$lambda$10$lambda$9;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                }
                startRestartGroup.endReplaceableGroup();
                Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(fillMaxSize$default, (Function1) rememberedValue7);
                startRestartGroup.startReplaceableGroup(1913123638);
                boolean changedInstance2 = startRestartGroup.changedInstance(adContainer);
                Object rememberedValue8 = startRestartGroup.rememberedValue();
                if (!changedInstance2) {
                    obj = rememberedValue8;
                }
                Function1 function1 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.AdHtmlWebViewKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        View AdHtmlWebView$lambda$13$lambda$12;
                        AdHtmlWebView$lambda$13$lambda$12 = AdHtmlWebViewKt.AdHtmlWebView$lambda$13$lambda$12(adContainer, (Context) obj2);
                        return AdHtmlWebView$lambda$13$lambda$12;
                    }
                };
                startRestartGroup.updateRememberedValue(function1);
                obj = function1;
                startRestartGroup.endReplaceableGroup();
                composer2 = startRestartGroup;
                AndroidView_androidKt.AndroidView((Function1) obj, onGloballyPositioned, null, composer2, 0, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                startRestartGroup.skipToGroupEnd();
                redirectionStrategy2 = redirectionStrategy;
                composer2 = startRestartGroup;
            }
            final Modifier modifier3 = modifier2;
            ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
            if (endRestartGroup2 != null) {
                final RedirectionStrategy redirectionStrategy3 = redirectionStrategy2;
                endRestartGroup2.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.design.compose.AdHtmlWebViewKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        Unit AdHtmlWebView$lambda$14;
                        AdHtmlWebView$lambda$14 = AdHtmlWebViewKt.AdHtmlWebView$lambda$14(MraidController.this, redirectionStrategy3, modifier3, onDisplayed, onDismiss, onClick, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                        return AdHtmlWebView$lambda$14;
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if ((i2 & 32) == 0) {
        }
        i4 = i3;
        if ((74899 & i4) == 74898) {
        }
        if (i7 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        adContainer = controller.getAdContainer();
        if (adContainer != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdHtmlWebView$lambda$4$lambda$3(MraidController mraidController) {
        mraidController.updateForegroundState(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdHtmlWebView$lambda$6$lambda$5(MraidController mraidController) {
        mraidController.updateForegroundState(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdHtmlWebView$lambda$8$lambda$7(MraidController mraidController) {
        mraidController.destroy();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdHtmlWebView$lambda$10$lambda$9(MraidController mraidController, float f, LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
        mraidController.updateLayoutMetrics(MraidLayoutMetricsKt.toAdLayoutMetrics(layoutCoordinates, f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View AdHtmlWebView$lambda$13$lambda$12(View view, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ViewKt.detachFromParent(view);
        return view;
    }
}
