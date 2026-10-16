package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Button.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u008d\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001d\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001e"}, d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ButtonColors;", "elevation", "Landroidx/compose/material3/ButtonElevation;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ButtonColors;Landroidx/compose/material3/ButtonElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedButton", "FilledTonalButton", "OutlinedButton", "TextButton", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ButtonKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a5  */
    /* JADX WARN: Type inference failed for: r11v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Button(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape2;
        ButtonColors buttonColors2;
        ButtonElevation buttonElevation2;
        int i5;
        Object obj;
        int i6;
        int i7;
        int i8;
        int i9;
        Shape shape3;
        ButtonColors buttonColors3;
        Modifier modifier3;
        boolean z3;
        State<Dp> state;
        final PaddingValues contentPadding;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape4;
        int i10;
        BorderStroke borderStroke2;
        boolean z4;
        ?? r11;
        Composer composer2;
        final ButtonColors buttonColors4;
        final ButtonElevation buttonElevation3;
        final Shape shape5;
        final BorderStroke borderStroke3;
        final MutableInteractionSource mutableInteractionSource3;
        final PaddingValues paddingValues2;
        final Modifier modifier4;
        final boolean z5;
        ScopeUpdateScope endRestartGroup;
        int i11;
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(650121315);
        ComposerKt.sourceInformation(startRestartGroup, "C(Button)P(8,7,5,9,1,4!1,3,6)107@5444L5,108@5493L14,109@5558L17,112@5728L39,119@6094L977:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i14 = i2 & 2;
        if (i14 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i13 = 2048;
                            i3 |= i13;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i13 = 1024;
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        if (startRestartGroup.changed(buttonColors2)) {
                            i12 = 16384;
                            i3 |= i12;
                        }
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i12 = 8192;
                    i3 |= i12;
                } else {
                    buttonColors2 = buttonColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        buttonElevation2 = buttonElevation;
                        if (startRestartGroup.changed(buttonElevation2)) {
                            i11 = 131072;
                            i3 |= i11;
                        }
                    } else {
                        buttonElevation2 = buttonElevation;
                    }
                    i11 = 65536;
                    i3 |= i11;
                } else {
                    buttonElevation2 = buttonElevation;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((1572864 & i) == 0) {
                    obj = borderStroke;
                    i3 |= startRestartGroup.changed(obj) ? 1048576 : 524288;
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                        i7 = i14;
                    } else {
                        i7 = i14;
                        if ((i & 12582912) == 0) {
                            i3 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i2 & 256;
                    if (i8 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i9 = i8;
                        i3 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        if ((i2 & 512) != 0) {
                            i3 |= C.ENCODING_PCM_32BIT;
                        } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                        }
                        if ((306783379 & i3) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                                boolean z6 = i4 != 0 ? true : z2;
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    shape3 = ButtonDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                } else {
                                    shape3 = shape2;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                    buttonColors3 = ButtonDefaults.INSTANCE.buttonColors(startRestartGroup, 6);
                                } else {
                                    buttonColors3 = buttonColors2;
                                }
                                int i15 = i3;
                                if ((i2 & 32) != 0) {
                                    modifier3 = companion;
                                    z3 = true;
                                    state = null;
                                    buttonElevation2 = ButtonDefaults.INSTANCE.m1924buttonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                    i3 = i15 & (-458753);
                                } else {
                                    modifier3 = companion;
                                    z3 = true;
                                    state = null;
                                    i3 = i15;
                                }
                                if (i5 != 0) {
                                    obj = state;
                                }
                                contentPadding = i6 != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                if (i9 != 0) {
                                    startRestartGroup.startReplaceableGroup(823568939);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Button.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                    buttonColors2 = buttonColors3;
                                    shape4 = shape3;
                                    i10 = 650121315;
                                    modifier2 = modifier3;
                                } else {
                                    modifier2 = modifier3;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    buttonColors2 = buttonColors3;
                                    shape4 = shape3;
                                    i10 = 650121315;
                                }
                                borderStroke2 = obj;
                                z4 = z6;
                                r11 = z3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                                mutableInteractionSource2 = mutableInteractionSource;
                                r11 = 1;
                                shape4 = shape2;
                                borderStroke2 = obj;
                                state = null;
                                i10 = 650121315;
                                contentPadding = paddingValues;
                                z4 = z2;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i10, i3, -1, "androidx.compose.material3.Button (Button.kt:114)");
                            }
                            long m1916containerColorvNxB06k$material3_release = buttonColors2.m1916containerColorvNxB06k$material3_release(z4);
                            final long m1917contentColorvNxB06k$material3_release = buttonColors2.m1917contentColorvNxB06k$material3_release(z4);
                            startRestartGroup.startReplaceableGroup(823569174);
                            ComposerKt.sourceInformation(startRestartGroup, "117@5963L43");
                            if (buttonElevation2 != null) {
                                state = buttonElevation2.shadowElevation$material3_release(z4, mutableInteractionSource2, startRestartGroup, ((i3 >> 9) & 896) | ((i3 >> 6) & 14) | ((i3 >> 21) & 112));
                            }
                            startRestartGroup.endReplaceableGroup();
                            SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                                }
                            }, r11, null), z4, shape4, m1916containerColorvNxB06k$material3_release, m1917contentColorvNxB06k$material3_release, buttonElevation2 != null ? buttonElevation2.m1935tonalElevationu2uoSUM$material3_release(z4) : Dp.m6389constructorimpl(0), state != null ? state.getValue().m6403unboximpl() : Dp.m6389constructorimpl(0), borderStroke2, mutableInteractionSource2, ComposableLambdaKt.composableLambda(startRestartGroup, 956488494, r11, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i16) {
                                    ComposerKt.sourceInformation(composer3, "C133@6591L10,131@6482L583:Button.kt#uh7d8r");
                                    if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(956488494, i16, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:131)");
                                        }
                                        long j = m1917contentColorvNxB06k$material3_release;
                                        TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                                        final PaddingValues paddingValues3 = contentPadding;
                                        final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                        ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j, labelLarge, ComposableLambdaKt.composableLambda(composer3, 1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                invoke(composer4, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i17) {
                                                ComposerKt.sourceInformation(composer4, "C134@6628L427:Button.kt#uh7d8r");
                                                if ((i17 & 3) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1327513942, i17, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:134)");
                                                    }
                                                    Modifier padding = PaddingKt.padding(SizeKt.m912defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1932getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1931getMinHeightD9Ej5fM()), PaddingValues.this);
                                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                    composer4.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                                                    composer4.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                                                    if (!(composer4.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer4.startReusableNode();
                                                    if (composer4.getInserting()) {
                                                        composer4.createNode(constructor);
                                                    } else {
                                                        composer4.useNode();
                                                    }
                                                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                                                    Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                                    composer4.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                    function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
                                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                                    composer4.endReplaceableGroup();
                                                    composer4.endNode();
                                                    composer4.endReplaceableGroup();
                                                    composer4.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), composer3, 384);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), startRestartGroup, (i3 & 8078) | ((i3 << 6) & 234881024) | ((i3 << 3) & 1879048192), 6, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = startRestartGroup;
                            buttonColors4 = buttonColors2;
                            buttonElevation3 = buttonElevation2;
                            shape5 = shape4;
                            borderStroke3 = borderStroke2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            paddingValues2 = contentPadding;
                            modifier4 = modifier2;
                            z5 = z4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier4 = modifier2;
                            z5 = z2;
                            shape5 = shape2;
                            composer2 = startRestartGroup;
                            buttonColors4 = buttonColors2;
                            buttonElevation3 = buttonElevation2;
                            borderStroke3 = obj;
                            paddingValues2 = paddingValues;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i16) {
                                    ButtonKt.Button(function0, modifier4, z5, shape5, buttonColors4, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i9 = i8;
                    if ((i2 & 512) != 0) {
                    }
                    if ((306783379 & i3) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    int i152 = i3;
                    if ((i2 & 32) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    borderStroke2 = obj;
                    z4 = z6;
                    r11 = z3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    long m1916containerColorvNxB06k$material3_release2 = buttonColors2.m1916containerColorvNxB06k$material3_release(z4);
                    final long m1917contentColorvNxB06k$material3_release2 = buttonColors2.m1917contentColorvNxB06k$material3_release(z4);
                    startRestartGroup.startReplaceableGroup(823569174);
                    ComposerKt.sourceInformation(startRestartGroup, "117@5963L43");
                    if (buttonElevation2 != null) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    if (buttonElevation2 != null) {
                    }
                    SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                        }
                    }, r11, null), z4, shape4, m1916containerColorvNxB06k$material3_release2, m1917contentColorvNxB06k$material3_release2, buttonElevation2 != null ? buttonElevation2.m1935tonalElevationu2uoSUM$material3_release(z4) : Dp.m6389constructorimpl(0), state != null ? state.getValue().m6403unboximpl() : Dp.m6389constructorimpl(0), borderStroke2, mutableInteractionSource2, ComposableLambdaKt.composableLambda(startRestartGroup, 956488494, r11, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i16) {
                            ComposerKt.sourceInformation(composer3, "C133@6591L10,131@6482L583:Button.kt#uh7d8r");
                            if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(956488494, i16, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:131)");
                                }
                                long j = m1917contentColorvNxB06k$material3_release2;
                                TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                                final PaddingValues paddingValues3 = contentPadding;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j, labelLarge, ComposableLambdaKt.composableLambda(composer3, 1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                        invoke(composer4, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i17) {
                                        ComposerKt.sourceInformation(composer4, "C134@6628L427:Button.kt#uh7d8r");
                                        if ((i17 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1327513942, i17, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:134)");
                                            }
                                            Modifier padding = PaddingKt.padding(SizeKt.m912defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1932getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1931getMinHeightD9Ej5fM()), PaddingValues.this);
                                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                            composer4.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                                            composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                                            if (!(composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer4.startReusableNode();
                                            if (composer4.getInserting()) {
                                                composer4.createNode(constructor);
                                            } else {
                                                composer4.useNode();
                                            }
                                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                                            Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                            composer4.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                            function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
                                            ComposerKt.sourceInformationMarkerEnd(composer4);
                                            composer4.endReplaceableGroup();
                                            composer4.endNode();
                                            composer4.endReplaceableGroup();
                                            composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 384);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), startRestartGroup, (i3 & 8078) | ((i3 << 6) & 234881024) | ((i3 << 3) & 1879048192), 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    buttonColors4 = buttonColors2;
                    buttonElevation3 = buttonElevation2;
                    shape5 = shape4;
                    borderStroke3 = borderStroke2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    paddingValues2 = contentPadding;
                    modifier4 = modifier2;
                    z5 = z4;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                obj = borderStroke;
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                i8 = i2 & 256;
                if (i8 == 0) {
                }
                i9 = i8;
                if ((i2 & 512) != 0) {
                }
                if ((306783379 & i3) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i7 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                int i1522 = i3;
                if ((i2 & 32) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i9 != 0) {
                }
                borderStroke2 = obj;
                z4 = z6;
                r11 = z3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                long m1916containerColorvNxB06k$material3_release22 = buttonColors2.m1916containerColorvNxB06k$material3_release(z4);
                final long m1917contentColorvNxB06k$material3_release22 = buttonColors2.m1917contentColorvNxB06k$material3_release(z4);
                startRestartGroup.startReplaceableGroup(823569174);
                ComposerKt.sourceInformation(startRestartGroup, "117@5963L43");
                if (buttonElevation2 != null) {
                }
                startRestartGroup.endReplaceableGroup();
                if (buttonElevation2 != null) {
                }
                SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                    }
                }, r11, null), z4, shape4, m1916containerColorvNxB06k$material3_release22, m1917contentColorvNxB06k$material3_release22, buttonElevation2 != null ? buttonElevation2.m1935tonalElevationu2uoSUM$material3_release(z4) : Dp.m6389constructorimpl(0), state != null ? state.getValue().m6403unboximpl() : Dp.m6389constructorimpl(0), borderStroke2, mutableInteractionSource2, ComposableLambdaKt.composableLambda(startRestartGroup, 956488494, r11, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i16) {
                        ComposerKt.sourceInformation(composer3, "C133@6591L10,131@6482L583:Button.kt#uh7d8r");
                        if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(956488494, i16, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:131)");
                            }
                            long j = m1917contentColorvNxB06k$material3_release22;
                            TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                            final PaddingValues paddingValues3 = contentPadding;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                            ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j, labelLarge, ComposableLambdaKt.composableLambda(composer3, 1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i17) {
                                    ComposerKt.sourceInformation(composer4, "C134@6628L427:Button.kt#uh7d8r");
                                    if ((i17 & 3) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1327513942, i17, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:134)");
                                        }
                                        Modifier padding = PaddingKt.padding(SizeKt.m912defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1932getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1931getMinHeightD9Ej5fM()), PaddingValues.this);
                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                        composer4.startReplaceableGroup(693286680);
                                        ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                                        composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                                        Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                        composer4.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                        function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
                                        ComposerKt.sourceInformationMarkerEnd(composer4);
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), composer3, 384);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), startRestartGroup, (i3 & 8078) | ((i3 << 6) & 234881024) | ((i3 << 3) & 1879048192), 6, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                buttonColors4 = buttonColors2;
                buttonElevation3 = buttonElevation2;
                shape5 = shape4;
                borderStroke3 = borderStroke2;
                mutableInteractionSource3 = mutableInteractionSource2;
                paddingValues2 = contentPadding;
                modifier4 = modifier2;
                z5 = z4;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            obj = borderStroke;
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            i8 = i2 & 256;
            if (i8 == 0) {
            }
            i9 = i8;
            if ((i2 & 512) != 0) {
            }
            if ((306783379 & i3) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            int i15222 = i3;
            if ((i2 & 32) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i9 != 0) {
            }
            borderStroke2 = obj;
            z4 = z6;
            r11 = z3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            long m1916containerColorvNxB06k$material3_release222 = buttonColors2.m1916containerColorvNxB06k$material3_release(z4);
            final long m1917contentColorvNxB06k$material3_release222 = buttonColors2.m1917contentColorvNxB06k$material3_release(z4);
            startRestartGroup.startReplaceableGroup(823569174);
            ComposerKt.sourceInformation(startRestartGroup, "117@5963L43");
            if (buttonElevation2 != null) {
            }
            startRestartGroup.endReplaceableGroup();
            if (buttonElevation2 != null) {
            }
            SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                }
            }, r11, null), z4, shape4, m1916containerColorvNxB06k$material3_release222, m1917contentColorvNxB06k$material3_release222, buttonElevation2 != null ? buttonElevation2.m1935tonalElevationu2uoSUM$material3_release(z4) : Dp.m6389constructorimpl(0), state != null ? state.getValue().m6403unboximpl() : Dp.m6389constructorimpl(0), borderStroke2, mutableInteractionSource2, ComposableLambdaKt.composableLambda(startRestartGroup, 956488494, r11, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i16) {
                    ComposerKt.sourceInformation(composer3, "C133@6591L10,131@6482L583:Button.kt#uh7d8r");
                    if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(956488494, i16, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:131)");
                        }
                        long j = m1917contentColorvNxB06k$material3_release222;
                        TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                        final PaddingValues paddingValues3 = contentPadding;
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j, labelLarge, ComposableLambdaKt.composableLambda(composer3, 1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                invoke(composer4, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i17) {
                                ComposerKt.sourceInformation(composer4, "C134@6628L427:Button.kt#uh7d8r");
                                if ((i17 & 3) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1327513942, i17, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:134)");
                                    }
                                    Modifier padding = PaddingKt.padding(SizeKt.m912defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1932getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1931getMinHeightD9Ej5fM()), PaddingValues.this);
                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                    composer4.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                                    composer4.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                                    if (!(composer4.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer4.startReusableNode();
                                    if (composer4.getInserting()) {
                                        composer4.createNode(constructor);
                                    } else {
                                        composer4.useNode();
                                    }
                                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                                    Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                    composer4.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                    function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer4);
                                    composer4.endReplaceableGroup();
                                    composer4.endNode();
                                    composer4.endReplaceableGroup();
                                    composer4.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer3, 384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, (i3 & 8078) | ((i3 << 6) & 234881024) | ((i3 << 3) & 1879048192), 6, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            buttonColors4 = buttonColors2;
            buttonElevation3 = buttonElevation2;
            shape5 = shape4;
            borderStroke3 = borderStroke2;
            mutableInteractionSource3 = mutableInteractionSource2;
            paddingValues2 = contentPadding;
            modifier4 = modifier2;
            z5 = z4;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        obj = borderStroke;
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        i8 = i2 & 256;
        if (i8 == 0) {
        }
        i9 = i8;
        if ((i2 & 512) != 0) {
        }
        if ((306783379 & i3) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        int i152222 = i3;
        if ((i2 & 32) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i9 != 0) {
        }
        borderStroke2 = obj;
        z4 = z6;
        r11 = z3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        long m1916containerColorvNxB06k$material3_release2222 = buttonColors2.m1916containerColorvNxB06k$material3_release(z4);
        final long m1917contentColorvNxB06k$material3_release2222 = buttonColors2.m1917contentColorvNxB06k$material3_release(z4);
        startRestartGroup.startReplaceableGroup(823569174);
        ComposerKt.sourceInformation(startRestartGroup, "117@5963L43");
        if (buttonElevation2 != null) {
        }
        startRestartGroup.endReplaceableGroup();
        if (buttonElevation2 != null) {
        }
        SurfaceKt.m2636Surfaceo_FOJdg(function02, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
            }
        }, r11, null), z4, shape4, m1916containerColorvNxB06k$material3_release2222, m1917contentColorvNxB06k$material3_release2222, buttonElevation2 != null ? buttonElevation2.m1935tonalElevationu2uoSUM$material3_release(z4) : Dp.m6389constructorimpl(0), state != null ? state.getValue().m6403unboximpl() : Dp.m6389constructorimpl(0), borderStroke2, mutableInteractionSource2, ComposableLambdaKt.composableLambda(startRestartGroup, 956488494, r11, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i16) {
                ComposerKt.sourceInformation(composer3, "C133@6591L10,131@6482L583:Button.kt#uh7d8r");
                if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(956488494, i16, -1, "androidx.compose.material3.Button.<anonymous> (Button.kt:131)");
                    }
                    long j = m1917contentColorvNxB06k$material3_release2222;
                    TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography(composer3, 6).getLabelLarge();
                    final PaddingValues paddingValues3 = contentPadding;
                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j, labelLarge, ComposableLambdaKt.composableLambda(composer3, 1327513942, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$Button$3.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                            invoke(composer4, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer4, int i17) {
                            ComposerKt.sourceInformation(composer4, "C134@6628L427:Button.kt#uh7d8r");
                            if ((i17 & 3) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1327513942, i17, -1, "androidx.compose.material3.Button.<anonymous>.<anonymous> (Button.kt:134)");
                                }
                                Modifier padding = PaddingKt.padding(SizeKt.m912defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1932getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1931getMinHeightD9Ej5fM()), PaddingValues.this);
                                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                composer4.startReplaceableGroup(693286680);
                                ComposerKt.sourceInformation(composer4, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer4, 54);
                                composer4.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer4, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                                if (!(composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer4.startReusableNode();
                                if (composer4.getInserting()) {
                                    composer4.createNode(constructor);
                                } else {
                                    composer4.useNode();
                                }
                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer4);
                                Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer4)), composer4, 0);
                                composer4.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer4, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                function33.invoke(RowScopeInstance.INSTANCE, composer4, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer4);
                                composer4.endReplaceableGroup();
                                composer4.endNode();
                                composer4.endReplaceableGroup();
                                composer4.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    }), composer3, 384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), startRestartGroup, (i3 & 8078) | ((i3 << 6) & 234881024) | ((i3 << 3) & 1879048192), 6, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        buttonColors4 = buttonColors2;
        buttonElevation3 = buttonElevation2;
        shape5 = shape4;
        borderStroke3 = borderStroke2;
        mutableInteractionSource3 = mutableInteractionSource2;
        paddingValues2 = contentPadding;
        modifier4 = modifier2;
        z5 = z4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ElevatedButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape2;
        ButtonColors buttonColors2;
        ButtonElevation buttonElevation2;
        int i5;
        BorderStroke borderStroke2;
        int i6;
        int i7;
        int i8;
        Shape shape3;
        ButtonColors buttonColors3;
        ButtonElevation buttonElevation3;
        boolean z3;
        Shape shape4;
        ButtonColors buttonColors4;
        MutableInteractionSource mutableInteractionSource2;
        PaddingValues paddingValues2;
        BorderStroke borderStroke3;
        Modifier modifier3;
        int i9;
        Composer composer2;
        final Modifier modifier4;
        final boolean z4;
        final Shape shape5;
        final ButtonColors buttonColors5;
        final ButtonElevation buttonElevation4;
        final BorderStroke borderStroke4;
        final PaddingValues paddingValues3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(1466887385);
        ComposerKt.sourceInformation(startRestartGroup, "C(ElevatedButton)P(8,7,5,9,1,4!1,3,6)198@9938L13,199@9995L22,200@10068L25,203@10246L39,206@10340L314:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i12 = 2048;
                            i3 |= i12;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i12 = 1024;
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        if (startRestartGroup.changed(buttonColors2)) {
                            i11 = 16384;
                            i3 |= i11;
                        }
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i11 = 8192;
                    i3 |= i11;
                } else {
                    buttonColors2 = buttonColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        buttonElevation2 = buttonElevation;
                        if (startRestartGroup.changed(buttonElevation2)) {
                            i10 = 131072;
                            i3 |= i10;
                        }
                    } else {
                        buttonElevation2 = buttonElevation;
                    }
                    i10 = 65536;
                    i3 |= i10;
                } else {
                    buttonElevation2 = buttonElevation;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((1572864 & i) == 0) {
                    borderStroke2 = borderStroke;
                    i3 |= startRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i8 = i7;
                        i3 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        if ((i2 & 512) != 0) {
                            i3 |= C.ENCODING_PCM_32BIT;
                        } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                            if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i13 == 0 ? Modifier.INSTANCE : modifier2;
                                    boolean z5 = i4 == 0 ? true : z2;
                                    if ((i2 & 8) == 0) {
                                        i3 &= -7169;
                                        shape3 = ButtonDefaults.INSTANCE.getElevatedShape(startRestartGroup, 6);
                                    } else {
                                        shape3 = shape2;
                                    }
                                    if ((i2 & 16) == 0) {
                                        i3 &= -57345;
                                        buttonColors3 = ButtonDefaults.INSTANCE.elevatedButtonColors(startRestartGroup, 6);
                                    } else {
                                        buttonColors3 = buttonColors2;
                                    }
                                    int i14 = i3;
                                    if ((i2 & 32) == 0) {
                                        buttonElevation2 = ButtonDefaults.INSTANCE.m1926elevatedButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                        i3 = i14 & (-458753);
                                    } else {
                                        i3 = i14;
                                    }
                                    if (i5 != 0) {
                                        borderStroke2 = null;
                                    }
                                    PaddingValues contentPadding = i6 == 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                    if (i8 == 0) {
                                        startRestartGroup.startReplaceableGroup(-446997561);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Button.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        buttonElevation3 = buttonElevation2;
                                        z3 = z5;
                                        shape4 = shape3;
                                        buttonColors4 = buttonColors3;
                                        paddingValues2 = contentPadding;
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                    } else {
                                        buttonElevation3 = buttonElevation2;
                                        z3 = z5;
                                        shape4 = shape3;
                                        buttonColors4 = buttonColors3;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        paddingValues2 = contentPadding;
                                    }
                                    borderStroke3 = borderStroke2;
                                    modifier3 = companion;
                                    i9 = 1466887385;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i3 &= -458753;
                                    }
                                    paddingValues2 = paddingValues;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    z3 = z2;
                                    shape4 = shape2;
                                    buttonColors4 = buttonColors2;
                                    buttonElevation3 = buttonElevation2;
                                    borderStroke3 = borderStroke2;
                                    i9 = 1466887385;
                                    modifier3 = modifier2;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.material3.ElevatedButton (Button.kt:206)");
                                }
                                Button(function02, modifier3, z3, shape4, buttonColors4, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2 = startRestartGroup;
                                modifier4 = modifier3;
                                z4 = z3;
                                shape5 = shape4;
                                buttonColors5 = buttonColors4;
                                buttonElevation4 = buttonElevation3;
                                borderStroke4 = borderStroke3;
                                paddingValues3 = paddingValues2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier4 = modifier2;
                                z4 = z2;
                                shape5 = shape2;
                                composer2 = startRestartGroup;
                                buttonColors5 = buttonColors2;
                                buttonElevation4 = buttonElevation2;
                                borderStroke4 = borderStroke2;
                                paddingValues3 = paddingValues;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$ElevatedButton$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i15) {
                                        ButtonKt.ElevatedButton(function0, modifier4, z4, shape5, buttonColors5, buttonElevation4, borderStroke4, paddingValues3, mutableInteractionSource3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i3 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 8) == 0) {
                        }
                        if ((i2 & 16) == 0) {
                        }
                        int i142 = i3;
                        if ((i2 & 32) == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        borderStroke3 = borderStroke2;
                        modifier3 = companion;
                        i9 = 1466887385;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Button(function02, modifier3, z3, shape4, buttonColors4, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        modifier4 = modifier3;
                        z4 = z3;
                        shape5 = shape4;
                        buttonColors5 = buttonColors4;
                        buttonElevation4 = buttonElevation3;
                        borderStroke4 = borderStroke3;
                        paddingValues3 = paddingValues2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i8 = i7;
                    if ((i2 & 512) != 0) {
                    }
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 8) == 0) {
                    }
                    if ((i2 & 16) == 0) {
                    }
                    int i1422 = i3;
                    if ((i2 & 32) == 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    borderStroke3 = borderStroke2;
                    modifier3 = companion;
                    i9 = 1466887385;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Button(function02, modifier3, z3, shape4, buttonColors4, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    modifier4 = modifier3;
                    z4 = z3;
                    shape5 = shape4;
                    buttonColors5 = buttonColors4;
                    buttonElevation4 = buttonElevation3;
                    borderStroke4 = borderStroke3;
                    paddingValues3 = paddingValues2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                borderStroke2 = borderStroke;
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i7;
                if ((i2 & 512) != 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i13 == 0) {
                }
                if (i4 == 0) {
                }
                if ((i2 & 8) == 0) {
                }
                if ((i2 & 16) == 0) {
                }
                int i14222 = i3;
                if ((i2 & 32) == 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if (i8 == 0) {
                }
                borderStroke3 = borderStroke2;
                modifier3 = companion;
                i9 = 1466887385;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                Button(function02, modifier3, z3, shape4, buttonColors4, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                modifier4 = modifier3;
                z4 = z3;
                shape5 = shape4;
                buttonColors5 = buttonColors4;
                buttonElevation4 = buttonElevation3;
                borderStroke4 = borderStroke3;
                paddingValues3 = paddingValues2;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            borderStroke2 = borderStroke;
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i7;
            if ((i2 & 512) != 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i13 == 0) {
            }
            if (i4 == 0) {
            }
            if ((i2 & 8) == 0) {
            }
            if ((i2 & 16) == 0) {
            }
            int i142222 = i3;
            if ((i2 & 32) == 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if (i8 == 0) {
            }
            borderStroke3 = borderStroke2;
            modifier3 = companion;
            i9 = 1466887385;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Button(function02, modifier3, z3, shape4, buttonColors4, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            modifier4 = modifier3;
            z4 = z3;
            shape5 = shape4;
            buttonColors5 = buttonColors4;
            buttonElevation4 = buttonElevation3;
            borderStroke4 = borderStroke3;
            paddingValues3 = paddingValues2;
            mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        borderStroke2 = borderStroke;
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        if ((i2 & 512) != 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i13 == 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        int i1422222 = i3;
        if ((i2 & 32) == 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if (i8 == 0) {
        }
        borderStroke3 = borderStroke2;
        modifier3 = companion;
        i9 = 1466887385;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Button(function02, modifier3, z3, shape4, buttonColors4, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        modifier4 = modifier3;
        z4 = z3;
        shape5 = shape4;
        buttonColors5 = buttonColors4;
        buttonElevation4 = buttonElevation3;
        borderStroke4 = borderStroke3;
        paddingValues3 = paddingValues2;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilledTonalButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape2;
        ButtonColors buttonColors2;
        ButtonElevation buttonElevation2;
        int i5;
        BorderStroke borderStroke2;
        int i6;
        int i7;
        int i8;
        Shape shape3;
        ButtonColors buttonColors3;
        ButtonElevation buttonElevation3;
        boolean z3;
        Shape shape4;
        ButtonColors buttonColors4;
        MutableInteractionSource mutableInteractionSource2;
        PaddingValues paddingValues2;
        BorderStroke borderStroke3;
        Modifier modifier3;
        int i9;
        Composer composer2;
        final Modifier modifier4;
        final boolean z4;
        final Shape shape5;
        final ButtonColors buttonColors5;
        final ButtonElevation buttonElevation4;
        final BorderStroke borderStroke4;
        final PaddingValues paddingValues3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i10;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-1717924381);
        ComposerKt.sourceInformation(startRestartGroup, "C(FilledTonalButton)P(8,7,5,9,1,4!1,3,6)268@13576L16,269@13636L25,270@13712L28,273@13893L39,276@13987L314:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i12 = 2048;
                            i3 |= i12;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i12 = 1024;
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        if (startRestartGroup.changed(buttonColors2)) {
                            i11 = 16384;
                            i3 |= i11;
                        }
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i11 = 8192;
                    i3 |= i11;
                } else {
                    buttonColors2 = buttonColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        buttonElevation2 = buttonElevation;
                        if (startRestartGroup.changed(buttonElevation2)) {
                            i10 = 131072;
                            i3 |= i10;
                        }
                    } else {
                        buttonElevation2 = buttonElevation;
                    }
                    i10 = 65536;
                    i3 |= i10;
                } else {
                    buttonElevation2 = buttonElevation;
                }
                i5 = i2 & 64;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((1572864 & i) == 0) {
                    borderStroke2 = borderStroke;
                    i3 |= startRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i8 = i7;
                        i3 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        if ((i2 & 512) != 0) {
                            i3 |= C.ENCODING_PCM_32BIT;
                        } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                            if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i13 == 0 ? Modifier.INSTANCE : modifier2;
                                    boolean z5 = i4 == 0 ? true : z2;
                                    if ((i2 & 8) == 0) {
                                        i3 &= -7169;
                                        shape3 = ButtonDefaults.INSTANCE.getFilledTonalShape(startRestartGroup, 6);
                                    } else {
                                        shape3 = shape2;
                                    }
                                    if ((i2 & 16) == 0) {
                                        i3 &= -57345;
                                        buttonColors3 = ButtonDefaults.INSTANCE.filledTonalButtonColors(startRestartGroup, 6);
                                    } else {
                                        buttonColors3 = buttonColors2;
                                    }
                                    int i14 = i3;
                                    if ((i2 & 32) == 0) {
                                        buttonElevation2 = ButtonDefaults.INSTANCE.m1928filledTonalButtonElevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                        i3 = i14 & (-458753);
                                    } else {
                                        i3 = i14;
                                    }
                                    if (i5 != 0) {
                                        borderStroke2 = null;
                                    }
                                    PaddingValues contentPadding = i6 == 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                    if (i8 == 0) {
                                        startRestartGroup.startReplaceableGroup(1269258330);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Button.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        buttonElevation3 = buttonElevation2;
                                        z3 = z5;
                                        shape4 = shape3;
                                        buttonColors4 = buttonColors3;
                                        paddingValues2 = contentPadding;
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                    } else {
                                        buttonElevation3 = buttonElevation2;
                                        z3 = z5;
                                        shape4 = shape3;
                                        buttonColors4 = buttonColors3;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        paddingValues2 = contentPadding;
                                    }
                                    borderStroke3 = borderStroke2;
                                    modifier3 = companion;
                                    i9 = -1717924381;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    if ((i2 & 32) != 0) {
                                        i3 &= -458753;
                                    }
                                    paddingValues2 = paddingValues;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    z3 = z2;
                                    shape4 = shape2;
                                    buttonColors4 = buttonColors2;
                                    buttonElevation3 = buttonElevation2;
                                    borderStroke3 = borderStroke2;
                                    i9 = -1717924381;
                                    modifier3 = modifier2;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i9, i3, -1, "androidx.compose.material3.FilledTonalButton (Button.kt:276)");
                                }
                                Button(function02, modifier3, z3, shape4, buttonColors4, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2 = startRestartGroup;
                                modifier4 = modifier3;
                                z4 = z3;
                                shape5 = shape4;
                                buttonColors5 = buttonColors4;
                                buttonElevation4 = buttonElevation3;
                                borderStroke4 = borderStroke3;
                                paddingValues3 = paddingValues2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier4 = modifier2;
                                z4 = z2;
                                shape5 = shape2;
                                composer2 = startRestartGroup;
                                buttonColors5 = buttonColors2;
                                buttonElevation4 = buttonElevation2;
                                borderStroke4 = borderStroke2;
                                paddingValues3 = paddingValues;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$FilledTonalButton$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i15) {
                                        ButtonKt.FilledTonalButton(function0, modifier4, z4, shape5, buttonColors5, buttonElevation4, borderStroke4, paddingValues3, mutableInteractionSource3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i3 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i4 == 0) {
                        }
                        if ((i2 & 8) == 0) {
                        }
                        if ((i2 & 16) == 0) {
                        }
                        int i142 = i3;
                        if ((i2 & 32) == 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        borderStroke3 = borderStroke2;
                        modifier3 = companion;
                        i9 = -1717924381;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        Button(function02, modifier3, z3, shape4, buttonColors4, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        modifier4 = modifier3;
                        z4 = z3;
                        shape5 = shape4;
                        buttonColors5 = buttonColors4;
                        buttonElevation4 = buttonElevation3;
                        borderStroke4 = borderStroke3;
                        paddingValues3 = paddingValues2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i8 = i7;
                    if ((i2 & 512) != 0) {
                    }
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 8) == 0) {
                    }
                    if ((i2 & 16) == 0) {
                    }
                    int i1422 = i3;
                    if ((i2 & 32) == 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    borderStroke3 = borderStroke2;
                    modifier3 = companion;
                    i9 = -1717924381;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Button(function02, modifier3, z3, shape4, buttonColors4, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    modifier4 = modifier3;
                    z4 = z3;
                    shape5 = shape4;
                    buttonColors5 = buttonColors4;
                    buttonElevation4 = buttonElevation3;
                    borderStroke4 = borderStroke3;
                    paddingValues3 = paddingValues2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                borderStroke2 = borderStroke;
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i7;
                if ((i2 & 512) != 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i13 == 0) {
                }
                if (i4 == 0) {
                }
                if ((i2 & 8) == 0) {
                }
                if ((i2 & 16) == 0) {
                }
                int i14222 = i3;
                if ((i2 & 32) == 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if (i8 == 0) {
                }
                borderStroke3 = borderStroke2;
                modifier3 = companion;
                i9 = -1717924381;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                Button(function02, modifier3, z3, shape4, buttonColors4, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                modifier4 = modifier3;
                z4 = z3;
                shape5 = shape4;
                buttonColors5 = buttonColors4;
                buttonElevation4 = buttonElevation3;
                borderStroke4 = borderStroke3;
                paddingValues3 = paddingValues2;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((196608 & i) == 0) {
            }
            i5 = i2 & 64;
            if (i5 != 0) {
            }
            borderStroke2 = borderStroke;
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i7;
            if ((i2 & 512) != 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i13 == 0) {
            }
            if (i4 == 0) {
            }
            if ((i2 & 8) == 0) {
            }
            if ((i2 & 16) == 0) {
            }
            int i142222 = i3;
            if ((i2 & 32) == 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if (i8 == 0) {
            }
            borderStroke3 = borderStroke2;
            modifier3 = companion;
            i9 = -1717924381;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Button(function02, modifier3, z3, shape4, buttonColors4, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            modifier4 = modifier3;
            z4 = z3;
            shape5 = shape4;
            buttonColors5 = buttonColors4;
            buttonElevation4 = buttonElevation3;
            borderStroke4 = borderStroke3;
            paddingValues3 = paddingValues2;
            mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((196608 & i) == 0) {
        }
        i5 = i2 & 64;
        if (i5 != 0) {
        }
        borderStroke2 = borderStroke;
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        if ((i2 & 512) != 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i13 == 0) {
        }
        if (i4 == 0) {
        }
        if ((i2 & 8) == 0) {
        }
        if ((i2 & 16) == 0) {
        }
        int i1422222 = i3;
        if ((i2 & 32) == 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if (i8 == 0) {
        }
        borderStroke3 = borderStroke2;
        modifier3 = companion;
        i9 = -1717924381;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Button(function02, modifier3, z3, shape4, buttonColors4, buttonElevation3, borderStroke3, paddingValues2, mutableInteractionSource2, function3, startRestartGroup, i3 & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        modifier4 = modifier3;
        z4 = z3;
        shape5 = shape4;
        buttonColors5 = buttonColors4;
        buttonElevation4 = buttonElevation3;
        borderStroke4 = borderStroke3;
        paddingValues3 = paddingValues2;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape2;
        ButtonColors buttonColors2;
        int i5;
        ButtonElevation buttonElevation2;
        BorderStroke borderStroke2;
        int i6;
        int i7;
        int i8;
        MutableInteractionSource mutableInteractionSource2;
        PaddingValues paddingValues2;
        Composer composer2;
        final Modifier modifier3;
        final boolean z3;
        final Shape shape3;
        final ButtonColors buttonColors3;
        final ButtonElevation buttonElevation3;
        final BorderStroke borderStroke3;
        final PaddingValues paddingValues3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i9;
        int i10;
        int i11;
        Composer startRestartGroup = composer.startRestartGroup(-1694808287);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedButton)P(8,7,5,9,1,4!1,3,6)337@17120L13,338@17177L22,340@17284L20,342@17423L39,345@17517L314:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i12 = i2 & 2;
        if (i12 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i11 = 2048;
                            i3 |= i11;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i11 = 1024;
                    i3 |= i11;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        if (startRestartGroup.changed(buttonColors2)) {
                            i10 = 16384;
                            i3 |= i10;
                        }
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i10 = 8192;
                    i3 |= i10;
                } else {
                    buttonColors2 = buttonColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    buttonElevation2 = buttonElevation;
                    i3 |= startRestartGroup.changed(buttonElevation2) ? 131072 : 65536;
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            borderStroke2 = borderStroke;
                            if (startRestartGroup.changed(borderStroke2)) {
                                i9 = 1048576;
                                i3 |= i9;
                            }
                        } else {
                            borderStroke2 = borderStroke;
                        }
                        i9 = 524288;
                        i3 |= i9;
                    } else {
                        borderStroke2 = borderStroke;
                    }
                    i6 = i2 & 128;
                    if (i6 == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i3 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i8 = i7;
                        i3 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        if ((i2 & 512) != 0) {
                            i3 |= C.ENCODING_PCM_32BIT;
                        } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                            if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i12 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                        shape2 = ButtonDefaults.INSTANCE.getOutlinedShape(startRestartGroup, 6);
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                        buttonColors2 = ButtonDefaults.INSTANCE.outlinedButtonColors(startRestartGroup, 6);
                                    }
                                    if (i5 != 0) {
                                        buttonElevation2 = null;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                        borderStroke2 = ButtonDefaults.INSTANCE.getOutlinedButtonBorder(startRestartGroup, 6);
                                    }
                                    PaddingValues contentPadding = i6 == 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                    if (i8 == 0) {
                                        startRestartGroup.startReplaceableGroup(-219967464);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Button.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        paddingValues2 = contentPadding;
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                    } else {
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        paddingValues2 = contentPadding;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 8) != 0) {
                                        i3 &= -7169;
                                    }
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                    }
                                    paddingValues2 = paddingValues;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                }
                                boolean z4 = z2;
                                Shape shape4 = shape2;
                                ButtonColors buttonColors4 = buttonColors2;
                                ButtonElevation buttonElevation4 = buttonElevation2;
                                BorderStroke borderStroke4 = borderStroke2;
                                Modifier modifier4 = modifier2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1694808287, i3, -1, "androidx.compose.material3.OutlinedButton (Button.kt:345)");
                                }
                                composer2 = startRestartGroup;
                                Button(function02, modifier4, z4, shape4, buttonColors4, buttonElevation4, borderStroke4, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                                z3 = z4;
                                shape3 = shape4;
                                buttonColors3 = buttonColors4;
                                buttonElevation3 = buttonElevation4;
                                borderStroke3 = borderStroke4;
                                paddingValues3 = paddingValues2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                mutableInteractionSource3 = mutableInteractionSource;
                                composer2 = startRestartGroup;
                                modifier3 = modifier2;
                                z3 = z2;
                                shape3 = shape2;
                                buttonColors3 = buttonColors2;
                                buttonElevation3 = buttonElevation2;
                                borderStroke3 = borderStroke2;
                                paddingValues3 = paddingValues;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$OutlinedButton$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                        invoke(composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i13) {
                                        ButtonKt.OutlinedButton(function0, modifier3, z3, shape3, buttonColors3, buttonElevation3, borderStroke3, paddingValues3, mutableInteractionSource3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i3 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if ((i2 & 8) != 0) {
                        }
                        if ((i2 & 16) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i2 & 64) != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        boolean z42 = z2;
                        Shape shape42 = shape2;
                        ButtonColors buttonColors42 = buttonColors2;
                        ButtonElevation buttonElevation42 = buttonElevation2;
                        BorderStroke borderStroke42 = borderStroke2;
                        Modifier modifier42 = modifier2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        Button(function02, modifier42, z42, shape42, buttonColors42, buttonElevation42, borderStroke42, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier42;
                        z3 = z42;
                        shape3 = shape42;
                        buttonColors3 = buttonColors42;
                        buttonElevation3 = buttonElevation42;
                        borderStroke3 = borderStroke42;
                        paddingValues3 = paddingValues2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i8 = i7;
                    if ((i2 & 512) != 0) {
                    }
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    boolean z422 = z2;
                    Shape shape422 = shape2;
                    ButtonColors buttonColors422 = buttonColors2;
                    ButtonElevation buttonElevation422 = buttonElevation2;
                    BorderStroke borderStroke422 = borderStroke2;
                    Modifier modifier422 = modifier2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    Button(function02, modifier422, z422, shape422, buttonColors422, buttonElevation422, borderStroke422, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier422;
                    z3 = z422;
                    shape3 = shape422;
                    buttonColors3 = buttonColors422;
                    buttonElevation3 = buttonElevation422;
                    borderStroke3 = borderStroke422;
                    paddingValues3 = paddingValues2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                buttonElevation2 = buttonElevation;
                if ((1572864 & i) != 0) {
                }
                i6 = i2 & 128;
                if (i6 == 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i7;
                if ((i2 & 512) != 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i12 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                if (i6 == 0) {
                }
                if (i8 == 0) {
                }
                boolean z4222 = z2;
                Shape shape4222 = shape2;
                ButtonColors buttonColors4222 = buttonColors2;
                ButtonElevation buttonElevation4222 = buttonElevation2;
                BorderStroke borderStroke4222 = borderStroke2;
                Modifier modifier4222 = modifier2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                Button(function02, modifier4222, z4222, shape4222, buttonColors4222, buttonElevation4222, borderStroke4222, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier4222;
                z3 = z4222;
                shape3 = shape4222;
                buttonColors3 = buttonColors4222;
                buttonElevation3 = buttonElevation4222;
                borderStroke3 = borderStroke4222;
                paddingValues3 = paddingValues2;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            buttonElevation2 = buttonElevation;
            if ((1572864 & i) != 0) {
            }
            i6 = i2 & 128;
            if (i6 == 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i7;
            if ((i2 & 512) != 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i12 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if (i6 == 0) {
            }
            if (i8 == 0) {
            }
            boolean z42222 = z2;
            Shape shape42222 = shape2;
            ButtonColors buttonColors42222 = buttonColors2;
            ButtonElevation buttonElevation42222 = buttonElevation2;
            BorderStroke borderStroke42222 = borderStroke2;
            Modifier modifier42222 = modifier2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            Button(function02, modifier42222, z42222, shape42222, buttonColors42222, buttonElevation42222, borderStroke42222, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier42222;
            z3 = z42222;
            shape3 = shape42222;
            buttonColors3 = buttonColors42222;
            buttonElevation3 = buttonElevation42222;
            borderStroke3 = borderStroke42222;
            paddingValues3 = paddingValues2;
            mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        buttonElevation2 = buttonElevation;
        if ((1572864 & i) != 0) {
        }
        i6 = i2 & 128;
        if (i6 == 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        if ((i2 & 512) != 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i12 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if (i6 == 0) {
        }
        if (i8 == 0) {
        }
        boolean z422222 = z2;
        Shape shape422222 = shape2;
        ButtonColors buttonColors422222 = buttonColors2;
        ButtonElevation buttonElevation422222 = buttonElevation2;
        BorderStroke borderStroke422222 = borderStroke2;
        Modifier modifier422222 = modifier2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        Button(function02, modifier422222, z422222, shape422222, buttonColors422222, buttonElevation422222, borderStroke422222, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier422222;
        z3 = z422222;
        shape3 = shape422222;
        buttonColors3 = buttonColors422222;
        buttonElevation3 = buttonElevation422222;
        borderStroke3 = borderStroke422222;
        paddingValues3 = paddingValues2;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextButton(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function02;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape2;
        ButtonColors buttonColors2;
        int i5;
        ButtonElevation buttonElevation2;
        int i6;
        BorderStroke borderStroke2;
        int i7;
        int i8;
        int i9;
        int i10;
        MutableInteractionSource mutableInteractionSource2;
        PaddingValues paddingValues2;
        Composer composer2;
        final Modifier modifier3;
        final boolean z3;
        final Shape shape3;
        final ButtonColors buttonColors3;
        final ButtonElevation buttonElevation3;
        final BorderStroke borderStroke3;
        final PaddingValues paddingValues3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope endRestartGroup;
        int i11;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-2106428362);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextButton)P(8,7,5,9,1,4!1,3,6)408@20786L9,409@20839L18,413@21060L39,416@21154L314:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            function02 = function0;
        } else {
            function02 = function0;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        int i13 = i2 & 2;
        if (i13 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i12 = 2048;
                            i3 |= i12;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i12 = 1024;
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonColors2 = buttonColors;
                        if (startRestartGroup.changed(buttonColors2)) {
                            i11 = 16384;
                            i3 |= i11;
                        }
                    } else {
                        buttonColors2 = buttonColors;
                    }
                    i11 = 8192;
                    i3 |= i11;
                } else {
                    buttonColors2 = buttonColors;
                }
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((196608 & i) == 0) {
                    buttonElevation2 = buttonElevation;
                    i3 |= startRestartGroup.changed(buttonElevation2) ? 131072 : 65536;
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((1572864 & i) == 0) {
                        borderStroke2 = borderStroke;
                        i3 |= startRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                        i7 = i2 & 128;
                        if (i7 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i8 = i7;
                            i3 |= startRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
                            i9 = i2 & 256;
                            if (i9 == 0) {
                                i3 |= 100663296;
                            } else if ((i & 100663296) == 0) {
                                i10 = i9;
                                i3 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                                if ((i2 & 512) != 0) {
                                    i3 |= C.ENCODING_PCM_32BIT;
                                } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                                    i3 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                                    if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                        startRestartGroup.startDefaults();
                                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            if (i13 != 0) {
                                                modifier2 = Modifier.INSTANCE;
                                            }
                                            if (i4 != 0) {
                                                z2 = true;
                                            }
                                            if ((i2 & 8) != 0) {
                                                i3 &= -7169;
                                                shape2 = ButtonDefaults.INSTANCE.getTextShape(startRestartGroup, 6);
                                            }
                                            if ((i2 & 16) != 0) {
                                                i3 &= -57345;
                                                buttonColors2 = ButtonDefaults.INSTANCE.textButtonColors(startRestartGroup, 6);
                                            }
                                            if (i5 != 0) {
                                                buttonElevation2 = null;
                                            }
                                            if (i6 != 0) {
                                                borderStroke2 = null;
                                            }
                                            PaddingValues textButtonContentPadding = i8 == 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : paddingValues;
                                            if (i10 == 0) {
                                                startRestartGroup.startReplaceableGroup(593745314);
                                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Button.kt#9igjgp");
                                                Object rememberedValue = startRestartGroup.rememberedValue();
                                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                                }
                                                startRestartGroup.endReplaceableGroup();
                                                paddingValues2 = textButtonContentPadding;
                                                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                            } else {
                                                mutableInteractionSource2 = mutableInteractionSource;
                                                paddingValues2 = textButtonContentPadding;
                                            }
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i2 & 8) != 0) {
                                                i3 &= -7169;
                                            }
                                            if ((i2 & 16) != 0) {
                                                i3 &= -57345;
                                            }
                                            paddingValues2 = paddingValues;
                                            mutableInteractionSource2 = mutableInteractionSource;
                                        }
                                        Modifier modifier4 = modifier2;
                                        Shape shape4 = shape2;
                                        ButtonColors buttonColors4 = buttonColors2;
                                        ButtonElevation buttonElevation4 = buttonElevation2;
                                        BorderStroke borderStroke4 = borderStroke2;
                                        boolean z4 = z2;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2106428362, i3, -1, "androidx.compose.material3.TextButton (Button.kt:416)");
                                        }
                                        composer2 = startRestartGroup;
                                        Button(function02, modifier4, z4, shape4, buttonColors4, buttonElevation4, borderStroke4, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        modifier3 = modifier4;
                                        z3 = z4;
                                        shape3 = shape4;
                                        buttonColors3 = buttonColors4;
                                        buttonElevation3 = buttonElevation4;
                                        borderStroke3 = borderStroke4;
                                        paddingValues3 = paddingValues2;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        composer2 = startRestartGroup;
                                        modifier3 = modifier2;
                                        z3 = z2;
                                        shape3 = shape2;
                                        buttonColors3 = buttonColors2;
                                        buttonElevation3 = buttonElevation2;
                                        borderStroke3 = borderStroke2;
                                        paddingValues3 = paddingValues;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup == null) {
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ButtonKt$TextButton$2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i14) {
                                                ButtonKt.TextButton(function0, modifier3, z3, shape3, buttonColors3, buttonElevation3, borderStroke3, paddingValues3, mutableInteractionSource3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                if ((i3 & 306783379) == 306783378) {
                                }
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0) {
                                }
                                if (i13 != 0) {
                                }
                                if (i4 != 0) {
                                }
                                if ((i2 & 8) != 0) {
                                }
                                if ((i2 & 16) != 0) {
                                }
                                if (i5 != 0) {
                                }
                                if (i6 != 0) {
                                }
                                if (i8 == 0) {
                                }
                                if (i10 == 0) {
                                }
                                Modifier modifier42 = modifier2;
                                Shape shape42 = shape2;
                                ButtonColors buttonColors42 = buttonColors2;
                                ButtonElevation buttonElevation42 = buttonElevation2;
                                BorderStroke borderStroke42 = borderStroke2;
                                boolean z42 = z2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                composer2 = startRestartGroup;
                                Button(function02, modifier42, z42, shape42, buttonColors42, buttonElevation42, borderStroke42, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier3 = modifier42;
                                z3 = z42;
                                shape3 = shape42;
                                buttonColors3 = buttonColors42;
                                buttonElevation3 = buttonElevation42;
                                borderStroke3 = borderStroke42;
                                paddingValues3 = paddingValues2;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i10 = i9;
                            if ((i2 & 512) != 0) {
                            }
                            if ((i3 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i4 != 0) {
                            }
                            if ((i2 & 8) != 0) {
                            }
                            if ((i2 & 16) != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i8 == 0) {
                            }
                            if (i10 == 0) {
                            }
                            Modifier modifier422 = modifier2;
                            Shape shape422 = shape2;
                            ButtonColors buttonColors422 = buttonColors2;
                            ButtonElevation buttonElevation422 = buttonElevation2;
                            BorderStroke borderStroke422 = borderStroke2;
                            boolean z422 = z2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            composer2 = startRestartGroup;
                            Button(function02, modifier422, z422, shape422, buttonColors422, buttonElevation422, borderStroke422, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier3 = modifier422;
                            z3 = z422;
                            shape3 = shape422;
                            buttonColors3 = buttonColors422;
                            buttonElevation3 = buttonElevation422;
                            borderStroke3 = borderStroke422;
                            paddingValues3 = paddingValues2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i8 = i7;
                        i9 = i2 & 256;
                        if (i9 == 0) {
                        }
                        i10 = i9;
                        if ((i2 & 512) != 0) {
                        }
                        if ((i3 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if ((i2 & 8) != 0) {
                        }
                        if ((i2 & 16) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i10 == 0) {
                        }
                        Modifier modifier4222 = modifier2;
                        Shape shape4222 = shape2;
                        ButtonColors buttonColors4222 = buttonColors2;
                        ButtonElevation buttonElevation4222 = buttonElevation2;
                        BorderStroke borderStroke4222 = borderStroke2;
                        boolean z4222 = z2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        Button(function02, modifier4222, z4222, shape4222, buttonColors4222, buttonElevation4222, borderStroke4222, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier3 = modifier4222;
                        z3 = z4222;
                        shape3 = shape4222;
                        buttonColors3 = buttonColors4222;
                        buttonElevation3 = buttonElevation4222;
                        borderStroke3 = borderStroke4222;
                        paddingValues3 = paddingValues2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    borderStroke2 = borderStroke;
                    i7 = i2 & 128;
                    if (i7 != 0) {
                    }
                    i8 = i7;
                    i9 = i2 & 256;
                    if (i9 == 0) {
                    }
                    i10 = i9;
                    if ((i2 & 512) != 0) {
                    }
                    if ((i3 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if ((i2 & 8) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i10 == 0) {
                    }
                    Modifier modifier42222 = modifier2;
                    Shape shape42222 = shape2;
                    ButtonColors buttonColors42222 = buttonColors2;
                    ButtonElevation buttonElevation42222 = buttonElevation2;
                    BorderStroke borderStroke42222 = borderStroke2;
                    boolean z42222 = z2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    Button(function02, modifier42222, z42222, shape42222, buttonColors42222, buttonElevation42222, borderStroke42222, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier42222;
                    z3 = z42222;
                    shape3 = shape42222;
                    buttonColors3 = buttonColors42222;
                    buttonElevation3 = buttonElevation42222;
                    borderStroke3 = borderStroke42222;
                    paddingValues3 = paddingValues2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                buttonElevation2 = buttonElevation;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                borderStroke2 = borderStroke;
                i7 = i2 & 128;
                if (i7 != 0) {
                }
                i8 = i7;
                i9 = i2 & 256;
                if (i9 == 0) {
                }
                i10 = i9;
                if ((i2 & 512) != 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i13 != 0) {
                }
                if (i4 != 0) {
                }
                if ((i2 & 8) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i8 == 0) {
                }
                if (i10 == 0) {
                }
                Modifier modifier422222 = modifier2;
                Shape shape422222 = shape2;
                ButtonColors buttonColors422222 = buttonColors2;
                ButtonElevation buttonElevation422222 = buttonElevation2;
                BorderStroke borderStroke422222 = borderStroke2;
                boolean z422222 = z2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                Button(function02, modifier422222, z422222, shape422222, buttonColors422222, buttonElevation422222, borderStroke422222, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier422222;
                z3 = z422222;
                shape3 = shape422222;
                buttonColors3 = buttonColors422222;
                buttonElevation3 = buttonElevation422222;
                borderStroke3 = borderStroke422222;
                paddingValues3 = paddingValues2;
                mutableInteractionSource3 = mutableInteractionSource2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            buttonElevation2 = buttonElevation;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            borderStroke2 = borderStroke;
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            i8 = i7;
            i9 = i2 & 256;
            if (i9 == 0) {
            }
            i10 = i9;
            if ((i2 & 512) != 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i13 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i8 == 0) {
            }
            if (i10 == 0) {
            }
            Modifier modifier4222222 = modifier2;
            Shape shape4222222 = shape2;
            ButtonColors buttonColors4222222 = buttonColors2;
            ButtonElevation buttonElevation4222222 = buttonElevation2;
            BorderStroke borderStroke4222222 = borderStroke2;
            boolean z4222222 = z2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            Button(function02, modifier4222222, z4222222, shape4222222, buttonColors4222222, buttonElevation4222222, borderStroke4222222, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier4222222;
            z3 = z4222222;
            shape3 = shape4222222;
            buttonColors3 = buttonColors4222222;
            buttonElevation3 = buttonElevation4222222;
            borderStroke3 = borderStroke4222222;
            paddingValues3 = paddingValues2;
            mutableInteractionSource3 = mutableInteractionSource2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        buttonElevation2 = buttonElevation;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        borderStroke2 = borderStroke;
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        i8 = i7;
        i9 = i2 & 256;
        if (i9 == 0) {
        }
        i10 = i9;
        if ((i2 & 512) != 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i13 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i8 == 0) {
        }
        if (i10 == 0) {
        }
        Modifier modifier42222222 = modifier2;
        Shape shape42222222 = shape2;
        ButtonColors buttonColors42222222 = buttonColors2;
        ButtonElevation buttonElevation42222222 = buttonElevation2;
        BorderStroke borderStroke42222222 = borderStroke2;
        boolean z42222222 = z2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        Button(function02, modifier42222222, z42222222, shape42222222, buttonColors42222222, buttonElevation42222222, borderStroke42222222, paddingValues2, mutableInteractionSource2, function3, composer2, i3 & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier42222222;
        z3 = z42222222;
        shape3 = shape42222222;
        buttonColors3 = buttonColors42222222;
        buttonElevation3 = buttonElevation42222222;
        borderStroke3 = borderStroke42222222;
        paddingValues3 = paddingValues2;
        mutableInteractionSource3 = mutableInteractionSource2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
