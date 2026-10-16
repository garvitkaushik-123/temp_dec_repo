package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: RadioButton.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006\u0018"}, d2 = {"RadioAnimationDuration", "", "RadioButtonDotSize", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonPadding", "RadioButtonRippleRadius", "RadioButtonSize", "RadioRadius", "RadioStrokeWidth", "RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/RadioButtonColors;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/RadioButtonColors;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RadioButtonKt {
    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize;
    private static final float RadioButtonPadding;
    private static final float RadioButtonRippleRadius = Dp.m6389constructorimpl(24);
    private static final float RadioButtonSize;
    private static final float RadioRadius;
    private static final float RadioStrokeWidth;

    /* JADX WARN: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0066  */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RadioButton(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, RadioButtonColors radioButtonColors, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        RadioButtonColors radioButtonColors2;
        boolean z4;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        MutableInteractionSource mutableInteractionSource4;
        int i6;
        RadioButtonColors radioButtonColors3;
        float m6389constructorimpl;
        ?? r9;
        int i7;
        final boolean z5;
        State<Dp> state;
        final State<Color> state2;
        Modifier.Companion companion;
        Modifier.Companion companion2;
        boolean changed;
        Object rememberedValue;
        final MutableInteractionSource mutableInteractionSource5;
        final Modifier modifier4;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(1314435585);
        ComposerKt.sourceInformation(startRestartGroup, "C(RadioButton)P(5,4,3,1,2)78@3687L39,79@3780L8,81@3813L164,85@4006L29,102@4551L792:RadioButton.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                z3 = z2;
                i3 |= startRestartGroup.changed(z3) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((57344 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 16384 : 8192;
                    if ((458752 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            radioButtonColors2 = radioButtonColors;
                            if (startRestartGroup.changed(radioButtonColors2)) {
                                i8 = 131072;
                                i3 |= i8;
                            }
                        } else {
                            radioButtonColors2 = radioButtonColors;
                        }
                        i8 = 65536;
                        i3 |= i8;
                    } else {
                        radioButtonColors2 = radioButtonColors;
                    }
                    if ((374491 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion3 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                            z4 = i4 == 0 ? true : z3;
                            if (i5 == 0) {
                                startRestartGroup.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                startRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue2;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource2;
                            }
                            if ((i2 & 32) == 0) {
                                RadioButtonColors m1746colorsRGew2ao = RadioButtonDefaults.INSTANCE.m1746colorsRGew2ao(0L, 0L, 0L, startRestartGroup, 3072, 7);
                                startRestartGroup = startRestartGroup;
                                modifier3 = companion3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                i6 = i3 & (-458753);
                                radioButtonColors3 = m1746colorsRGew2ao;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1314435585, i6, -1, "androidx.compose.material.RadioButton (RadioButton.kt:80)");
                                }
                                if (!z) {
                                    m6389constructorimpl = Dp.m6389constructorimpl(RadioButtonDotSize / 2);
                                } else {
                                    m6389constructorimpl = Dp.m6389constructorimpl(0);
                                }
                                State<Dp> m433animateDpAsStateAjpBEmI = AnimateAsStateKt.m433animateDpAsStateAjpBEmI(m6389constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, startRestartGroup, 48, 12);
                                int i10 = i6 >> 9;
                                State<Color> radioColor = radioButtonColors3.radioColor(z4, z, startRestartGroup, ((i6 << 3) & 112) | (i10 & 14) | (i10 & 896));
                                startRestartGroup.startReplaceableGroup(1941632354);
                                ComposerKt.sourceInformation(startRestartGroup, "94@4361L123");
                                if (function0 == null) {
                                    state = m433animateDpAsStateAjpBEmI;
                                    radioButtonColors2 = radioButtonColors3;
                                    i7 = 2;
                                    z5 = z4;
                                    state2 = radioColor;
                                    r9 = 0;
                                    companion = SelectableKt.m1120selectableO2vRcR0(Modifier.INSTANCE, z, mutableInteractionSource4, RippleKt.m1870rememberRipple9IZ8Weo(false, RadioButtonRippleRadius, 0L, startRestartGroup, 54, 4), z5, Role.m5709boximpl(Role.INSTANCE.m5720getRadioButtono7Vup1c()), function0);
                                } else {
                                    r9 = 0;
                                    radioButtonColors2 = radioButtonColors3;
                                    i7 = 2;
                                    z5 = z4;
                                    state = m433animateDpAsStateAjpBEmI;
                                    state2 = radioColor;
                                    companion = Modifier.INSTANCE;
                                }
                                startRestartGroup.endReplaceableGroup();
                                if (function0 == null) {
                                    companion2 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.INSTANCE);
                                } else {
                                    companion2 = Modifier.INSTANCE;
                                }
                                Modifier m920requiredSize3ABfNKs = SizeKt.m920requiredSize3ABfNKs(PaddingKt.m879padding3ABfNKs(SizeKt.wrapContentSize$default(modifier3.then(companion2).then(companion), Alignment.INSTANCE.getCenter(), r9, i7, null), RadioButtonPadding), RadioButtonSize);
                                startRestartGroup.startReplaceableGroup(-982011571);
                                final State<Dp> state3 = state;
                                changed = startRestartGroup.changed(state2) | startRestartGroup.changed(state3);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                            invoke2(drawScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(DrawScope drawScope) {
                                            float f;
                                            float f2;
                                            f = RadioButtonKt.RadioStrokeWidth;
                                            float f3 = drawScope.mo630toPx0680j_4(f);
                                            long m4073unboximpl = state2.getValue().m4073unboximpl();
                                            f2 = RadioButtonKt.RadioRadius;
                                            float f4 = f3 / 2;
                                            DrawScope.m4594drawCircleVaOC9Bg$default(drawScope, m4073unboximpl, drawScope.mo630toPx0680j_4(f2) - f4, 0L, 0.0f, new Stroke(f3, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                            if (Dp.m6388compareTo0680j_4(state3.getValue().m6403unboximpl(), Dp.m6389constructorimpl(0)) > 0) {
                                                DrawScope.m4594drawCircleVaOC9Bg$default(drawScope, state2.getValue().m4073unboximpl(), drawScope.mo630toPx0680j_4(state3.getValue().m6403unboximpl()) - f4, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                            }
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                CanvasKt.Canvas(m920requiredSize3ABfNKs, (Function1) rememberedValue, startRestartGroup, r9);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                mutableInteractionSource5 = mutableInteractionSource4;
                                modifier4 = modifier3;
                            } else {
                                modifier3 = companion3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                i6 = i3;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            i6 = i3;
                            modifier3 = modifier2;
                            z4 = z3;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        radioButtonColors3 = radioButtonColors2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        if (!z) {
                        }
                        State<Dp> m433animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m433animateDpAsStateAjpBEmI(m6389constructorimpl, AnimationSpecKt.tween$default(100, 0, null, 6, null), null, null, startRestartGroup, 48, 12);
                        int i102 = i6 >> 9;
                        State<Color> radioColor2 = radioButtonColors3.radioColor(z4, z, startRestartGroup, ((i6 << 3) & 112) | (i102 & 14) | (i102 & 896));
                        startRestartGroup.startReplaceableGroup(1941632354);
                        ComposerKt.sourceInformation(startRestartGroup, "94@4361L123");
                        if (function0 == null) {
                        }
                        startRestartGroup.endReplaceableGroup();
                        if (function0 == null) {
                        }
                        Modifier m920requiredSize3ABfNKs2 = SizeKt.m920requiredSize3ABfNKs(PaddingKt.m879padding3ABfNKs(SizeKt.wrapContentSize$default(modifier3.then(companion2).then(companion), Alignment.INSTANCE.getCenter(), r9, i7, null), RadioButtonPadding), RadioButtonSize);
                        startRestartGroup.startReplaceableGroup(-982011571);
                        final State<Dp> state32 = state;
                        changed = startRestartGroup.changed(state2) | startRestartGroup.changed(state32);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                                invoke2(drawScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(DrawScope drawScope) {
                                float f;
                                float f2;
                                f = RadioButtonKt.RadioStrokeWidth;
                                float f3 = drawScope.mo630toPx0680j_4(f);
                                long m4073unboximpl = state2.getValue().m4073unboximpl();
                                f2 = RadioButtonKt.RadioRadius;
                                float f4 = f3 / 2;
                                DrawScope.m4594drawCircleVaOC9Bg$default(drawScope, m4073unboximpl, drawScope.mo630toPx0680j_4(f2) - f4, 0L, 0.0f, new Stroke(f3, 0.0f, 0, 0, null, 30, null), null, 0, 108, null);
                                if (Dp.m6388compareTo0680j_4(state32.getValue().m6403unboximpl(), Dp.m6389constructorimpl(0)) > 0) {
                                    DrawScope.m4594drawCircleVaOC9Bg$default(drawScope, state2.getValue().m4073unboximpl(), drawScope.mo630toPx0680j_4(state32.getValue().m6403unboximpl()) - f4, 0L, 0.0f, Fill.INSTANCE, null, 0, 108, null);
                                }
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        startRestartGroup.endReplaceableGroup();
                        CanvasKt.Canvas(m920requiredSize3ABfNKs2, (Function1) rememberedValue, startRestartGroup, r9);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        mutableInteractionSource5 = mutableInteractionSource4;
                        modifier4 = modifier3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier4 = modifier2;
                        z5 = z3;
                        mutableInteractionSource5 = mutableInteractionSource2;
                    }
                    final RadioButtonColors radioButtonColors4 = radioButtonColors2;
                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.RadioButtonKt$RadioButton$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i11) {
                                RadioButtonKt.RadioButton(z, function0, modifier4, z5, mutableInteractionSource5, radioButtonColors4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((458752 & i) != 0) {
                }
                if ((374491 & i3) == 74898) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i9 == 0) {
                }
                if (i4 == 0) {
                }
                if (i5 == 0) {
                }
                if ((i2 & 32) == 0) {
                }
            }
            z3 = z2;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((458752 & i) != 0) {
            }
            if ((374491 & i3) == 74898) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i9 == 0) {
            }
            if (i4 == 0) {
            }
            if (i5 == 0) {
            }
            if ((i2 & 32) == 0) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        z3 = z2;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((458752 & i) != 0) {
        }
        if ((374491 & i3) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i9 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if ((i2 & 32) == 0) {
        }
    }

    static {
        float f = 2;
        RadioButtonPadding = Dp.m6389constructorimpl(f);
        float m6389constructorimpl = Dp.m6389constructorimpl(20);
        RadioButtonSize = m6389constructorimpl;
        RadioRadius = Dp.m6389constructorimpl(m6389constructorimpl / f);
        RadioButtonDotSize = Dp.m6389constructorimpl(12);
        RadioStrokeWidth = Dp.m6389constructorimpl(f);
    }
}
