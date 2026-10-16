package io.adn.sdk.internal.ui.common.design.compose;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.ironsource.C3061e8;
import io.adn.sdk.internal.domain.model.ad.AdCtaConfig;
import io.adn.sdk.internal.ui.fullscreen.model.FullscreenAdUiStateKt;
import io.adn.sdk.internal.ui.fullscreen.model.PromotedAppUiState;
import io.adn.sdk.internal.ui.utils.ComposeKt;
import io.adn.sdk.internal.ui.utils.UIConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CTAButton.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\u001aE\u0010\u0000\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0001¢\u0006\u0002\u0010\f\u001ae\u0010\r\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0001¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e²\u0006\n\u0010\u001f\u001a\u00020 X\u008a\u008e\u0002"}, d2 = {"ctaButton", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/runtime/Composable;", "config", "Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;", "promotedApp", "Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;", "onClick", "Lkotlin/Function0;", "(Lio/adn/sdk/internal/domain/model/ad/AdCtaConfig;Lio/adn/sdk/internal/ui/fullscreen/model/PromotedAppUiState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Lkotlin/jvm/functions/Function3;", "CtaButton", "modifier", "Landroidx/compose/ui/Modifier;", "buttonColor", "Landroidx/compose/ui/graphics/Color;", "text", "", "textColor", "textSize", "Landroidx/compose/ui/unit/TextUnit;", "backgroundColor", "slideDirection", "Lio/adn/sdk/internal/ui/common/design/compose/SlideDirection;", "icon", "", "CtaButton-B4ZhwkU", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLjava/lang/String;JJJLio/adn/sdk/internal/ui/common/design/compose/SlideDirection;Ljava/lang/Object;Landroidx/compose/runtime/Composer;II)V", "adn-sdk_release", C3061e8.k, ""}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class CTAButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CtaButton_B4ZhwkU$lambda$6(Function0 function0, Modifier modifier, long j, String str, long j2, long j3, long j4, SlideDirection slideDirection, Object obj, int i, int i2, Composer composer, int i3) {
        m9517CtaButtonB4ZhwkU(function0, modifier, j, str, j2, j3, j4, slideDirection, obj, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Function3<BoxScope, Composer, Integer, Unit> ctaButton(final AdCtaConfig config, final PromotedAppUiState promotedAppUiState, final Function0<Unit> onClick, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        composer.startReplaceableGroup(547338692);
        if ((i2 & 2) != 0) {
            promotedAppUiState = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(547338692, i, -1, "io.adn.sdk.internal.ui.common.design.compose.ctaButton (CTAButton.kt:48)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -733953442, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: io.adn.sdk.internal.ui.common.design.compose.CTAButtonKt$ctaButton$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer2, Integer num) {
                invoke(boxScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(BoxScope boxScope, Composer composer2, int i3) {
                Composer composer3;
                int i4;
                Intrinsics.checkNotNullParameter(boxScope, "<this>");
                if ((i3 & 6) == 0) {
                    composer3 = composer2;
                    i4 = i3 | (composer3.changed(boxScope) ? 4 : 2);
                } else {
                    composer3 = composer2;
                    i4 = i3;
                }
                if ((i4 & 19) != 18 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-733953442, i4, -1, "io.adn.sdk.internal.ui.common.design.compose.ctaButton.<anonymous> (CTAButton.kt:49)");
                    }
                    Modifier padding = PaddingKt.padding(boxScope.align(Modifier.INSTANCE, ComposeKt.toAlignment(AdCtaConfig.this.getPosition())), UIConstants.INSTANCE.getTEXT_BUTTON_PADDING$adn_sdk_release());
                    long color = ComposeKt.toColor(AdCtaConfig.this.getColor());
                    SlideDirection slideDirection = SlideDirectionKt.toSlideDirection(AdCtaConfig.this.getPosition());
                    long color2 = ComposeKt.toColor(AdCtaConfig.this.getTextColor());
                    String text = AdCtaConfig.this.getText();
                    PromotedAppUiState promotedAppUiState2 = promotedAppUiState;
                    CTAButtonKt.m9517CtaButtonB4ZhwkU(onClick, padding, color, text, color2, 0L, 0L, slideDirection, promotedAppUiState2 != null ? FullscreenAdUiStateKt.icon(promotedAppUiState2) : null, composer3, 0, 96);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        });
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00aa  */
    /* renamed from: CtaButton-B4ZhwkU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m9517CtaButtonB4ZhwkU(final Function0<Unit> onClick, final Modifier modifier, final long j, final String text, final long j2, long j3, long j4, SlideDirection slideDirection, final Object obj, Composer composer, final int i, final int i2) {
        int i3;
        long j5;
        int i4;
        long j6;
        int i5;
        long j7;
        int i6;
        final SlideDirection slideDirection2;
        Object rememberedValue;
        long j8;
        RoundedCornerShape m1150RoundedCornerShapea9UjIt4;
        CTAButtonKt$CtaButton$2$1 rememberedValue2;
        boolean z;
        Object rememberedValue3;
        Composer composer2;
        final long j9;
        final long j10;
        final SlideDirection slideDirection3;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(text, "text");
        Composer startRestartGroup = composer.startRestartGroup(-1316299109);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(j) ? 256 : 128;
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changed(text) ? 2048 : 1024;
            }
            if ((i2 & 16) == 0) {
                i3 |= 24576;
            } else if ((i & 24576) == 0) {
                j5 = j2;
                i3 |= startRestartGroup.changed(j5) ? 16384 : 8192;
                i4 = i2 & 32;
                if (i4 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    j6 = j3;
                } else {
                    j6 = j3;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i3 |= startRestartGroup.changed(j6) ? 131072 : 65536;
                    }
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                    j7 = j4;
                } else {
                    j7 = j4;
                    if ((1572864 & i) == 0) {
                        i3 |= startRestartGroup.changed(j7) ? 1048576 : 524288;
                    }
                }
                i6 = i2 & 128;
                if (i6 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i3 |= startRestartGroup.changed(slideDirection) ? 8388608 : 4194304;
                }
                if ((i2 & 256) != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i3 |= startRestartGroup.changedInstance(obj) ? 67108864 : 33554432;
                    if ((i3 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                        long m9601getTEXT_BUTTON_TEXT_SIZEXSAIIZE$adn_sdk_release = i4 == 0 ? UIConstants.INSTANCE.m9601getTEXT_BUTTON_TEXT_SIZEXSAIIZE$adn_sdk_release() : j6;
                        if (i5 != 0) {
                            j7 = UIConstants.INSTANCE.m9596getCTA_BACKGROUND_COLOR0d7_KjU$adn_sdk_release();
                        }
                        slideDirection2 = i6 == 0 ? SlideDirection.RightToLeft : slideDirection;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1316299109, i3, -1, "io.adn.sdk.internal.ui.common.design.compose.CtaButton (CTAButton.kt:73)");
                        }
                        startRestartGroup.startReplaceableGroup(1790533107);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        MutableState mutableState = (MutableState) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        if (slideDirection2 != SlideDirection.RightToLeft) {
                            float f = 4;
                            j8 = m9601getTEXT_BUTTON_TEXT_SIZEXSAIIZE$adn_sdk_release;
                            float f2 = 0;
                            m1150RoundedCornerShapea9UjIt4 = RoundedCornerShapeKt.m1150RoundedCornerShapea9UjIt4(Dp.m6389constructorimpl(f), Dp.m6389constructorimpl(f2), Dp.m6389constructorimpl(f2), Dp.m6389constructorimpl(f));
                        } else {
                            j8 = m9601getTEXT_BUTTON_TEXT_SIZEXSAIIZE$adn_sdk_release;
                            float f3 = 0;
                            float f4 = 4;
                            m1150RoundedCornerShapea9UjIt4 = RoundedCornerShapeKt.m1150RoundedCornerShapea9UjIt4(Dp.m6389constructorimpl(f3), Dp.m6389constructorimpl(f4), Dp.m6389constructorimpl(f4), Dp.m6389constructorimpl(f3));
                        }
                        RoundedCornerShape roundedCornerShape = m1150RoundedCornerShapea9UjIt4;
                        Unit unit = Unit.INSTANCE;
                        startRestartGroup.startReplaceableGroup(1790541285);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 != Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new CTAButtonKt$CtaButton$2$1(mutableState, null);
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceableGroup();
                        EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 6);
                        boolean CtaButton_B4ZhwkU$lambda$1 = CtaButton_B4ZhwkU$lambda$1(mutableState);
                        TweenSpec tween$default = AnimationSpecKt.tween$default(800, 0, null, 6, null);
                        startRestartGroup.startReplaceableGroup(1790546852);
                        z = (29360128 & i3) == 8388608;
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!z || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.CTAButtonKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    int CtaButton_B4ZhwkU$lambda$5$lambda$4;
                                    CtaButton_B4ZhwkU$lambda$5$lambda$4 = CTAButtonKt.CtaButton_B4ZhwkU$lambda$5$lambda$4(SlideDirection.this, ((Integer) obj2).intValue());
                                    return Integer.valueOf(CtaButton_B4ZhwkU$lambda$5$lambda$4);
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        startRestartGroup.endReplaceableGroup();
                        long j11 = j8;
                        long j12 = j7;
                        SlideDirection slideDirection4 = slideDirection2;
                        composer2 = startRestartGroup;
                        AnimatedVisibilityKt.AnimatedVisibility(CtaButton_B4ZhwkU$lambda$1, modifier, EnterExitTransitionKt.slideInHorizontally(tween$default, (Function1) rememberedValue3), (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, 672321395, true, new CTAButtonKt$CtaButton$4(roundedCornerShape, j12, onClick, obj, j, j5, text, j11)), composer2, (i3 & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 24);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j9 = j12;
                        j10 = j11;
                        slideDirection3 = slideDirection4;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        slideDirection3 = slideDirection;
                        j9 = j7;
                        j10 = j6;
                        composer2 = startRestartGroup;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2() { // from class: io.adn.sdk.internal.ui.common.design.compose.CTAButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj2, Object obj3) {
                                Unit CtaButton_B4ZhwkU$lambda$6;
                                CtaButton_B4ZhwkU$lambda$6 = CTAButtonKt.CtaButton_B4ZhwkU$lambda$6(Function0.this, modifier, j, text, j2, j10, j9, slideDirection3, obj, i, i2, (Composer) obj2, ((Integer) obj3).intValue());
                                return CtaButton_B4ZhwkU$lambda$6;
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i3 & 38347923) == 38347922) {
                }
                if (i4 == 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(1790533107);
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                MutableState mutableState2 = (MutableState) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                if (slideDirection2 != SlideDirection.RightToLeft) {
                }
                RoundedCornerShape roundedCornerShape2 = m1150RoundedCornerShapea9UjIt4;
                Unit unit2 = Unit.INSTANCE;
                startRestartGroup.startReplaceableGroup(1790541285);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 != Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 6);
                boolean CtaButton_B4ZhwkU$lambda$12 = CtaButton_B4ZhwkU$lambda$1(mutableState2);
                TweenSpec tween$default2 = AnimationSpecKt.tween$default(800, 0, null, 6, null);
                startRestartGroup.startReplaceableGroup(1790546852);
                if ((29360128 & i3) == 8388608) {
                }
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!z) {
                }
                rememberedValue3 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.CTAButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        int CtaButton_B4ZhwkU$lambda$5$lambda$4;
                        CtaButton_B4ZhwkU$lambda$5$lambda$4 = CTAButtonKt.CtaButton_B4ZhwkU$lambda$5$lambda$4(SlideDirection.this, ((Integer) obj2).intValue());
                        return Integer.valueOf(CtaButton_B4ZhwkU$lambda$5$lambda$4);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
                startRestartGroup.endReplaceableGroup();
                long j112 = j8;
                long j122 = j7;
                SlideDirection slideDirection42 = slideDirection2;
                composer2 = startRestartGroup;
                AnimatedVisibilityKt.AnimatedVisibility(CtaButton_B4ZhwkU$lambda$12, modifier, EnterExitTransitionKt.slideInHorizontally(tween$default2, (Function1) rememberedValue3), (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, 672321395, true, new CTAButtonKt$CtaButton$4(roundedCornerShape2, j122, onClick, obj, j, j5, text, j112)), composer2, (i3 & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 24);
                if (ComposerKt.isTraceInProgress()) {
                }
                j9 = j122;
                j10 = j112;
                slideDirection3 = slideDirection42;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            j5 = j2;
            i4 = i2 & 32;
            if (i4 != 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            i6 = i2 & 128;
            if (i6 != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            if ((i3 & 38347923) == 38347922) {
            }
            if (i4 == 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(1790533107);
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            MutableState mutableState22 = (MutableState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            if (slideDirection2 != SlideDirection.RightToLeft) {
            }
            RoundedCornerShape roundedCornerShape22 = m1150RoundedCornerShapea9UjIt4;
            Unit unit22 = Unit.INSTANCE;
            startRestartGroup.startReplaceableGroup(1790541285);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 != Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(unit22, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 6);
            boolean CtaButton_B4ZhwkU$lambda$122 = CtaButton_B4ZhwkU$lambda$1(mutableState22);
            TweenSpec tween$default22 = AnimationSpecKt.tween$default(800, 0, null, 6, null);
            startRestartGroup.startReplaceableGroup(1790546852);
            if ((29360128 & i3) == 8388608) {
            }
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!z) {
            }
            rememberedValue3 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.CTAButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    int CtaButton_B4ZhwkU$lambda$5$lambda$4;
                    CtaButton_B4ZhwkU$lambda$5$lambda$4 = CTAButtonKt.CtaButton_B4ZhwkU$lambda$5$lambda$4(SlideDirection.this, ((Integer) obj2).intValue());
                    return Integer.valueOf(CtaButton_B4ZhwkU$lambda$5$lambda$4);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
            startRestartGroup.endReplaceableGroup();
            long j1122 = j8;
            long j1222 = j7;
            SlideDirection slideDirection422 = slideDirection2;
            composer2 = startRestartGroup;
            AnimatedVisibilityKt.AnimatedVisibility(CtaButton_B4ZhwkU$lambda$122, modifier, EnterExitTransitionKt.slideInHorizontally(tween$default22, (Function1) rememberedValue3), (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, 672321395, true, new CTAButtonKt$CtaButton$4(roundedCornerShape22, j1222, onClick, obj, j, j5, text, j1122)), composer2, (i3 & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 24);
            if (ComposerKt.isTraceInProgress()) {
            }
            j9 = j1222;
            j10 = j1122;
            slideDirection3 = slideDirection422;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        j5 = j2;
        i4 = i2 & 32;
        if (i4 != 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        i6 = i2 & 128;
        if (i6 != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        if ((i3 & 38347923) == 38347922) {
        }
        if (i4 == 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(1790533107);
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        MutableState mutableState222 = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        if (slideDirection2 != SlideDirection.RightToLeft) {
        }
        RoundedCornerShape roundedCornerShape222 = m1150RoundedCornerShapea9UjIt4;
        Unit unit222 = Unit.INSTANCE;
        startRestartGroup.startReplaceableGroup(1790541285);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 != Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        EffectsKt.LaunchedEffect(unit222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 6);
        boolean CtaButton_B4ZhwkU$lambda$1222 = CtaButton_B4ZhwkU$lambda$1(mutableState222);
        TweenSpec tween$default222 = AnimationSpecKt.tween$default(800, 0, null, 6, null);
        startRestartGroup.startReplaceableGroup(1790546852);
        if ((29360128 & i3) == 8388608) {
        }
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!z) {
        }
        rememberedValue3 = new Function1() { // from class: io.adn.sdk.internal.ui.common.design.compose.CTAButtonKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                int CtaButton_B4ZhwkU$lambda$5$lambda$4;
                CtaButton_B4ZhwkU$lambda$5$lambda$4 = CTAButtonKt.CtaButton_B4ZhwkU$lambda$5$lambda$4(SlideDirection.this, ((Integer) obj2).intValue());
                return Integer.valueOf(CtaButton_B4ZhwkU$lambda$5$lambda$4);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue3);
        startRestartGroup.endReplaceableGroup();
        long j11222 = j8;
        long j12222 = j7;
        SlideDirection slideDirection4222 = slideDirection2;
        composer2 = startRestartGroup;
        AnimatedVisibilityKt.AnimatedVisibility(CtaButton_B4ZhwkU$lambda$1222, modifier, EnterExitTransitionKt.slideInHorizontally(tween$default222, (Function1) rememberedValue3), (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, 672321395, true, new CTAButtonKt$CtaButton$4(roundedCornerShape222, j12222, onClick, obj, j, j5, text, j11222)), composer2, (i3 & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 24);
        if (ComposerKt.isTraceInProgress()) {
        }
        j9 = j12222;
        j10 = j11222;
        slideDirection3 = slideDirection4222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final boolean CtaButton_B4ZhwkU$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CtaButton_B4ZhwkU$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int CtaButton_B4ZhwkU$lambda$5$lambda$4(SlideDirection slideDirection, int i) {
        return slideDirection == SlideDirection.RightToLeft ? i : -i;
    }
}
