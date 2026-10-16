package androidx.compose.material;

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
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
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
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u001a\u008d\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001c²\u0006\n\u0010\u001d\u001a\u00020\u001eX\u008a\u0084\u0002"}, d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "elevation", "Landroidx/compose/material/ButtonElevation;", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ButtonColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/ButtonElevation;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ButtonColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedButton", "TextButton", "material_release", "contentColor", "Landroidx/compose/ui/graphics/Color;"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ae  */
    /* JADX WARN: Type inference failed for: r4v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Button(final Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        ButtonElevation buttonElevation2;
        int i6;
        int i7;
        int i8;
        PaddingValues paddingValues2;
        int i9;
        MutableInteractionSource mutableInteractionSource3;
        int i10;
        CornerBasedShape cornerBasedShape;
        boolean z3;
        int i11;
        ButtonColors buttonColors2;
        final PaddingValues contentPadding;
        Shape shape2;
        BorderStroke borderStroke2;
        boolean z4;
        MutableInteractionSource mutableInteractionSource4;
        int i12;
        ?? r4;
        final PaddingValues paddingValues3;
        final ButtonElevation buttonElevation3;
        final Modifier modifier3;
        final ButtonColors buttonColors3;
        Composer composer2;
        final boolean z5;
        final Shape shape3;
        final BorderStroke borderStroke3;
        final MutableInteractionSource mutableInteractionSource5;
        ScopeUpdateScope endRestartGroup;
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(-2116133464);
        ComposerKt.sourceInformation(startRestartGroup, "C(Button)P(8,7,5,6,4,9!2,3)96@4625L39,97@4715L11,98@4761L6,100@4851L14,104@5014L21,110@5211L24,105@5040L1119:Button.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i16 = i2 & 2;
        if (i16 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 896) == 0) {
                z2 = z;
                i3 |= startRestartGroup.changed(z2) ? 256 : 128;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 7168) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 2048 : 1024;
                    if ((57344 & i) != 0) {
                        if ((i2 & 16) == 0) {
                            buttonElevation2 = buttonElevation;
                            if (startRestartGroup.changed(buttonElevation2)) {
                                i15 = 16384;
                                i3 |= i15;
                            }
                        } else {
                            buttonElevation2 = buttonElevation;
                        }
                        i15 = 8192;
                        i3 |= i15;
                    } else {
                        buttonElevation2 = buttonElevation;
                    }
                    if ((458752 & i) == 0) {
                        if ((i2 & 32) == 0 && startRestartGroup.changed(shape)) {
                            i14 = 131072;
                            i3 |= i14;
                        }
                        i14 = 65536;
                        i3 |= i14;
                    }
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        i3 |= startRestartGroup.changed(borderStroke) ? 1048576 : 524288;
                    }
                    if ((i & 29360128) == 0) {
                        if ((i2 & 128) == 0 && startRestartGroup.changed(buttonColors)) {
                            i13 = 8388608;
                            i3 |= i13;
                        }
                        i13 = 4194304;
                        i3 |= i13;
                    }
                    i7 = i2 & 256;
                    if (i7 == 0) {
                        i3 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        i8 = i7;
                        paddingValues2 = paddingValues;
                        i3 |= startRestartGroup.changed(paddingValues2) ? 67108864 : 33554432;
                        if ((i2 & 512) != 0) {
                            i3 |= C.ENCODING_PCM_32BIT;
                        } else if ((1879048192 & i) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                        }
                        i9 = i3;
                        if ((1533916891 & i9) == 306783378 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i16 != 0 ? Modifier.INSTANCE : modifier2;
                                boolean z6 = i4 != 0 ? true : z2;
                                if (i5 != 0) {
                                    startRestartGroup.startReplaceableGroup(-492369756);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    i10 = i9 & (-57345);
                                    buttonElevation2 = ButtonDefaults.INSTANCE.m1569elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, startRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                } else {
                                    i10 = i9;
                                }
                                if ((i2 & 32) != 0) {
                                    cornerBasedShape = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getSmall();
                                    i10 &= -458753;
                                } else {
                                    cornerBasedShape = shape;
                                }
                                BorderStroke borderStroke4 = i6 != 0 ? null : borderStroke;
                                if ((i2 & 128) != 0) {
                                    z3 = true;
                                    i11 = i8;
                                    buttonColors2 = ButtonDefaults.INSTANCE.m1568buttonColorsro_MJ88(0L, 0L, 0L, 0L, startRestartGroup, 24576, 15);
                                    i10 &= -29360129;
                                } else {
                                    z3 = true;
                                    i11 = i8;
                                    buttonColors2 = buttonColors;
                                }
                                contentPadding = i11 != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
                                shape2 = cornerBasedShape;
                                borderStroke2 = borderStroke4;
                                z4 = z6;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                modifier2 = companion;
                                i12 = i10;
                                r4 = z3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                i12 = (i2 & 16) != 0 ? i9 & (-57345) : i9;
                                if ((i2 & 32) != 0) {
                                    i12 &= -458753;
                                }
                                if ((i2 & 128) != 0) {
                                    i12 &= -29360129;
                                }
                                shape2 = shape;
                                borderStroke2 = borderStroke;
                                buttonColors2 = buttonColors;
                                z4 = z2;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                r4 = 1;
                                contentPadding = paddingValues;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2116133464, i12, -1, "androidx.compose.material.Button (Button.kt:103)");
                            }
                            int i17 = i12 >> 6;
                            int i18 = (i17 & 14) | ((i12 >> 18) & 112);
                            final State<Color> contentColor = buttonColors2.contentColor(z4, startRestartGroup, i18);
                            Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                                }
                            }, r4, null);
                            long m4073unboximpl = buttonColors2.backgroundColor(z4, startRestartGroup, i18).getValue().m4073unboximpl();
                            long m4062copywmQWz5c$default = Color.m4062copywmQWz5c$default(Button$lambda$1(contentColor), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                            startRestartGroup.startReplaceableGroup(-423487151);
                            ComposerKt.sourceInformation(startRestartGroup, "113@5353L37");
                            State<Dp> elevation = buttonElevation2 != null ? buttonElevation2.elevation(z4, mutableInteractionSource4, startRestartGroup, i17 & 1022) : null;
                            startRestartGroup.endReplaceableGroup();
                            SurfaceKt.m1783SurfaceLPr_se0(function0, semantics$default, z4, shape2, m4073unboximpl, m4062copywmQWz5c$default, borderStroke2, elevation != null ? elevation.getValue().m6403unboximpl() : Dp.m6389constructorimpl(0), mutableInteractionSource4, ComposableLambdaKt.composableLambda(startRestartGroup, 7524271, r4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$3
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

                                public final void invoke(Composer composer3, int i19) {
                                    long Button$lambda$1;
                                    ComposerKt.sourceInformation(composer3, "C116@5470L683:Button.kt#jmzs0o");
                                    if ((i19 & 11) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(7524271, i19, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:116)");
                                        }
                                        ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                                        Button$lambda$1 = ButtonKt.Button$lambda$1(contentColor);
                                        ProvidedValue<Float> provides = localContentAlpha.provides(Float.valueOf(Color.m4065getAlphaimpl(Button$lambda$1)));
                                        final PaddingValues paddingValues4 = contentPadding;
                                        final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$3.1
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

                                            public final void invoke(Composer composer4, int i20) {
                                                ComposerKt.sourceInformation(composer4, "C118@5612L10,117@5556L587:Button.kt#jmzs0o");
                                                if ((i20 & 11) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1699085201, i20, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:117)");
                                                    }
                                                    TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                                    final PaddingValues paddingValues5 = PaddingValues.this;
                                                    final Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                    TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                            invoke(composer5, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer5, int i21) {
                                                            ComposerKt.sourceInformation(composer5, "C120@5662L467:Button.kt#jmzs0o");
                                                            if ((i21 & 11) != 2 || !composer5.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-630330208, i21, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:120)");
                                                                }
                                                                Modifier padding = PaddingKt.padding(SizeKt.m912defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1574getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1573getMinHeightD9Ej5fM()), PaddingValues.this);
                                                                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                                Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                                                composer5.startReplaceableGroup(693286680);
                                                                ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                                composer5.startReplaceableGroup(-1323940314);
                                                                ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                composer5.startReusableNode();
                                                                if (composer5.getInserting()) {
                                                                    composer5.createNode(constructor);
                                                                } else {
                                                                    composer5.useNode();
                                                                }
                                                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                                                Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                }
                                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                                composer5.startReplaceableGroup(2058660585);
                                                                ComposerKt.sourceInformationMarkerStart(composer5, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                                function34.invoke(RowScopeInstance.INSTANCE, composer5, 6);
                                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                composer5.endReplaceableGroup();
                                                                composer5.endNode();
                                                                composer5.endReplaceableGroup();
                                                                composer5.endReplaceableGroup();
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer5.skipToGroupEnd();
                                                        }
                                                    }), composer4, 48);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), composer3, ProvidedValue.$stable | 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), startRestartGroup, (i17 & 7168) | (i12 & 14) | C.ENCODING_PCM_32BIT | (i12 & 896) | (i12 & 3670016) | ((i12 << 15) & 234881024), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            ButtonElevation buttonElevation4 = buttonElevation2;
                            paddingValues3 = contentPadding;
                            buttonElevation3 = buttonElevation4;
                            modifier3 = modifier2;
                            buttonColors3 = buttonColors2;
                            composer2 = startRestartGroup;
                            z5 = z4;
                            shape3 = shape2;
                            borderStroke3 = borderStroke2;
                            mutableInteractionSource5 = mutableInteractionSource4;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            shape3 = shape;
                            modifier3 = modifier2;
                            z5 = z2;
                            composer2 = startRestartGroup;
                            mutableInteractionSource5 = mutableInteractionSource2;
                            buttonElevation3 = buttonElevation2;
                            paddingValues3 = paddingValues2;
                            borderStroke3 = borderStroke;
                            buttonColors3 = buttonColors;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$4
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

                                public final void invoke(Composer composer3, int i19) {
                                    ButtonKt.Button(function0, modifier3, z5, mutableInteractionSource5, buttonElevation3, shape3, borderStroke3, buttonColors3, paddingValues3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i8 = i7;
                    paddingValues2 = paddingValues;
                    if ((i2 & 512) != 0) {
                    }
                    i9 = i3;
                    if ((1533916891 & i9) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i16 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 128) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    shape2 = cornerBasedShape;
                    borderStroke2 = borderStroke4;
                    z4 = z6;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    modifier2 = companion;
                    i12 = i10;
                    r4 = z3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i172 = i12 >> 6;
                    int i182 = (i172 & 14) | ((i12 >> 18) & 112);
                    final State<Color> contentColor2 = buttonColors2.contentColor(z4, startRestartGroup, i182);
                    Modifier semantics$default2 = SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                        }
                    }, r4, null);
                    long m4073unboximpl2 = buttonColors2.backgroundColor(z4, startRestartGroup, i182).getValue().m4073unboximpl();
                    long m4062copywmQWz5c$default2 = Color.m4062copywmQWz5c$default(Button$lambda$1(contentColor2), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    startRestartGroup.startReplaceableGroup(-423487151);
                    ComposerKt.sourceInformation(startRestartGroup, "113@5353L37");
                    if (buttonElevation2 != null) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    SurfaceKt.m1783SurfaceLPr_se0(function0, semantics$default2, z4, shape2, m4073unboximpl2, m4062copywmQWz5c$default2, borderStroke2, elevation != null ? elevation.getValue().m6403unboximpl() : Dp.m6389constructorimpl(0), mutableInteractionSource4, ComposableLambdaKt.composableLambda(startRestartGroup, 7524271, r4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$3
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

                        public final void invoke(Composer composer3, int i19) {
                            long Button$lambda$1;
                            ComposerKt.sourceInformation(composer3, "C116@5470L683:Button.kt#jmzs0o");
                            if ((i19 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(7524271, i19, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:116)");
                                }
                                ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                                Button$lambda$1 = ButtonKt.Button$lambda$1(contentColor2);
                                ProvidedValue<Float> provides = localContentAlpha.provides(Float.valueOf(Color.m4065getAlphaimpl(Button$lambda$1)));
                                final PaddingValues paddingValues4 = contentPadding;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$3.1
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

                                    public final void invoke(Composer composer4, int i20) {
                                        ComposerKt.sourceInformation(composer4, "C118@5612L10,117@5556L587:Button.kt#jmzs0o");
                                        if ((i20 & 11) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1699085201, i20, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:117)");
                                            }
                                            TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                            final PaddingValues paddingValues5 = PaddingValues.this;
                                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                            TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                    invoke(composer5, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer5, int i21) {
                                                    ComposerKt.sourceInformation(composer5, "C120@5662L467:Button.kt#jmzs0o");
                                                    if ((i21 & 11) != 2 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-630330208, i21, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:120)");
                                                        }
                                                        Modifier padding = PaddingKt.padding(SizeKt.m912defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1574getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1573getMinHeightD9Ej5fM()), PaddingValues.this);
                                                        Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                                        composer5.startReplaceableGroup(693286680);
                                                        ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                                        Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                        function34.invoke(RowScopeInstance.INSTANCE, composer5, 6);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), startRestartGroup, (i172 & 7168) | (i12 & 14) | C.ENCODING_PCM_32BIT | (i12 & 896) | (i12 & 3670016) | ((i12 << 15) & 234881024), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ButtonElevation buttonElevation42 = buttonElevation2;
                    paddingValues3 = contentPadding;
                    buttonElevation3 = buttonElevation42;
                    modifier3 = modifier2;
                    buttonColors3 = buttonColors2;
                    composer2 = startRestartGroup;
                    z5 = z4;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((57344 & i) != 0) {
                }
                if ((458752 & i) == 0) {
                }
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if ((i & 29360128) == 0) {
                }
                i7 = i2 & 256;
                if (i7 == 0) {
                }
                i8 = i7;
                paddingValues2 = paddingValues;
                if ((i2 & 512) != 0) {
                }
                i9 = i3;
                if ((1533916891 & i9) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i16 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 128) != 0) {
                }
                if (i11 != 0) {
                }
                shape2 = cornerBasedShape;
                borderStroke2 = borderStroke4;
                z4 = z6;
                mutableInteractionSource4 = mutableInteractionSource3;
                modifier2 = companion;
                i12 = i10;
                r4 = z3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1722 = i12 >> 6;
                int i1822 = (i1722 & 14) | ((i12 >> 18) & 112);
                final State<Color> contentColor22 = buttonColors2.contentColor(z4, startRestartGroup, i1822);
                Modifier semantics$default22 = SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                    }
                }, r4, null);
                long m4073unboximpl22 = buttonColors2.backgroundColor(z4, startRestartGroup, i1822).getValue().m4073unboximpl();
                long m4062copywmQWz5c$default22 = Color.m4062copywmQWz5c$default(Button$lambda$1(contentColor22), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                startRestartGroup.startReplaceableGroup(-423487151);
                ComposerKt.sourceInformation(startRestartGroup, "113@5353L37");
                if (buttonElevation2 != null) {
                }
                startRestartGroup.endReplaceableGroup();
                SurfaceKt.m1783SurfaceLPr_se0(function0, semantics$default22, z4, shape2, m4073unboximpl22, m4062copywmQWz5c$default22, borderStroke2, elevation != null ? elevation.getValue().m6403unboximpl() : Dp.m6389constructorimpl(0), mutableInteractionSource4, ComposableLambdaKt.composableLambda(startRestartGroup, 7524271, r4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$3
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

                    public final void invoke(Composer composer3, int i19) {
                        long Button$lambda$1;
                        ComposerKt.sourceInformation(composer3, "C116@5470L683:Button.kt#jmzs0o");
                        if ((i19 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(7524271, i19, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:116)");
                            }
                            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                            Button$lambda$1 = ButtonKt.Button$lambda$1(contentColor22);
                            ProvidedValue<Float> provides = localContentAlpha.provides(Float.valueOf(Color.m4065getAlphaimpl(Button$lambda$1)));
                            final PaddingValues paddingValues4 = contentPadding;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$3.1
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

                                public final void invoke(Composer composer4, int i20) {
                                    ComposerKt.sourceInformation(composer4, "C118@5612L10,117@5556L587:Button.kt#jmzs0o");
                                    if ((i20 & 11) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1699085201, i20, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:117)");
                                        }
                                        TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                        final PaddingValues paddingValues5 = PaddingValues.this;
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                        TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                invoke(composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer5, int i21) {
                                                ComposerKt.sourceInformation(composer5, "C120@5662L467:Button.kt#jmzs0o");
                                                if ((i21 & 11) != 2 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-630330208, i21, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:120)");
                                                    }
                                                    Modifier padding = PaddingKt.padding(SizeKt.m912defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1574getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1573getMinHeightD9Ej5fM()), PaddingValues.this);
                                                    Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                                    composer5.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                                    Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                    function34.invoke(RowScopeInstance.INSTANCE, composer5, 6);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    composer5.endReplaceableGroup();
                                                    composer5.endNode();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        }), composer4, 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            }), composer3, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), startRestartGroup, (i1722 & 7168) | (i12 & 14) | C.ENCODING_PCM_32BIT | (i12 & 896) | (i12 & 3670016) | ((i12 << 15) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                ButtonElevation buttonElevation422 = buttonElevation2;
                paddingValues3 = contentPadding;
                buttonElevation3 = buttonElevation422;
                modifier3 = modifier2;
                buttonColors3 = buttonColors2;
                composer2 = startRestartGroup;
                z5 = z4;
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                mutableInteractionSource5 = mutableInteractionSource4;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            z2 = z;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((57344 & i) != 0) {
            }
            if ((458752 & i) == 0) {
            }
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if ((i & 29360128) == 0) {
            }
            i7 = i2 & 256;
            if (i7 == 0) {
            }
            i8 = i7;
            paddingValues2 = paddingValues;
            if ((i2 & 512) != 0) {
            }
            i9 = i3;
            if ((1533916891 & i9) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i16 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 128) != 0) {
            }
            if (i11 != 0) {
            }
            shape2 = cornerBasedShape;
            borderStroke2 = borderStroke4;
            z4 = z6;
            mutableInteractionSource4 = mutableInteractionSource3;
            modifier2 = companion;
            i12 = i10;
            r4 = z3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i17222 = i12 >> 6;
            int i18222 = (i17222 & 14) | ((i12 >> 18) & 112);
            final State<Color> contentColor222 = buttonColors2.contentColor(z4, startRestartGroup, i18222);
            Modifier semantics$default222 = SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                }
            }, r4, null);
            long m4073unboximpl222 = buttonColors2.backgroundColor(z4, startRestartGroup, i18222).getValue().m4073unboximpl();
            long m4062copywmQWz5c$default222 = Color.m4062copywmQWz5c$default(Button$lambda$1(contentColor222), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
            startRestartGroup.startReplaceableGroup(-423487151);
            ComposerKt.sourceInformation(startRestartGroup, "113@5353L37");
            if (buttonElevation2 != null) {
            }
            startRestartGroup.endReplaceableGroup();
            SurfaceKt.m1783SurfaceLPr_se0(function0, semantics$default222, z4, shape2, m4073unboximpl222, m4062copywmQWz5c$default222, borderStroke2, elevation != null ? elevation.getValue().m6403unboximpl() : Dp.m6389constructorimpl(0), mutableInteractionSource4, ComposableLambdaKt.composableLambda(startRestartGroup, 7524271, r4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$3
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

                public final void invoke(Composer composer3, int i19) {
                    long Button$lambda$1;
                    ComposerKt.sourceInformation(composer3, "C116@5470L683:Button.kt#jmzs0o");
                    if ((i19 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(7524271, i19, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:116)");
                        }
                        ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                        Button$lambda$1 = ButtonKt.Button$lambda$1(contentColor222);
                        ProvidedValue<Float> provides = localContentAlpha.provides(Float.valueOf(Color.m4065getAlphaimpl(Button$lambda$1)));
                        final PaddingValues paddingValues4 = contentPadding;
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$3.1
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

                            public final void invoke(Composer composer4, int i20) {
                                ComposerKt.sourceInformation(composer4, "C118@5612L10,117@5556L587:Button.kt#jmzs0o");
                                if ((i20 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1699085201, i20, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:117)");
                                    }
                                    TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                    final PaddingValues paddingValues5 = PaddingValues.this;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                    TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                            invoke(composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer5, int i21) {
                                            ComposerKt.sourceInformation(composer5, "C120@5662L467:Button.kt#jmzs0o");
                                            if ((i21 & 11) != 2 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-630330208, i21, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:120)");
                                                }
                                                Modifier padding = PaddingKt.padding(SizeKt.m912defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1574getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1573getMinHeightD9Ej5fM()), PaddingValues.this);
                                                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                                composer5.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                                composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer5.startReusableNode();
                                                if (composer5.getInserting()) {
                                                    composer5.createNode(constructor);
                                                } else {
                                                    composer5.useNode();
                                                }
                                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                                Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                composer5.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer5, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                function34.invoke(RowScopeInstance.INSTANCE, composer5, 6);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                composer5.endReplaceableGroup();
                                                composer5.endNode();
                                                composer5.endReplaceableGroup();
                                                composer5.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }), composer4, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer3, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, (i17222 & 7168) | (i12 & 14) | C.ENCODING_PCM_32BIT | (i12 & 896) | (i12 & 3670016) | ((i12 << 15) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            ButtonElevation buttonElevation4222 = buttonElevation2;
            paddingValues3 = contentPadding;
            buttonElevation3 = buttonElevation4222;
            modifier3 = modifier2;
            buttonColors3 = buttonColors2;
            composer2 = startRestartGroup;
            z5 = z4;
            shape3 = shape2;
            borderStroke3 = borderStroke2;
            mutableInteractionSource5 = mutableInteractionSource4;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        z2 = z;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        mutableInteractionSource2 = mutableInteractionSource;
        if ((57344 & i) != 0) {
        }
        if ((458752 & i) == 0) {
        }
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if ((i & 29360128) == 0) {
        }
        i7 = i2 & 256;
        if (i7 == 0) {
        }
        i8 = i7;
        paddingValues2 = paddingValues;
        if ((i2 & 512) != 0) {
        }
        i9 = i3;
        if ((1533916891 & i9) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i16 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 128) != 0) {
        }
        if (i11 != 0) {
        }
        shape2 = cornerBasedShape;
        borderStroke2 = borderStroke4;
        z4 = z6;
        mutableInteractionSource4 = mutableInteractionSource3;
        modifier2 = companion;
        i12 = i10;
        r4 = z3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i172222 = i12 >> 6;
        int i182222 = (i172222 & 14) | ((i12 >> 18) & 112);
        final State<Color> contentColor2222 = buttonColors2.contentColor(z4, startRestartGroup, i182222);
        Modifier semantics$default2222 = SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
            }
        }, r4, null);
        long m4073unboximpl2222 = buttonColors2.backgroundColor(z4, startRestartGroup, i182222).getValue().m4073unboximpl();
        long m4062copywmQWz5c$default2222 = Color.m4062copywmQWz5c$default(Button$lambda$1(contentColor2222), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
        startRestartGroup.startReplaceableGroup(-423487151);
        ComposerKt.sourceInformation(startRestartGroup, "113@5353L37");
        if (buttonElevation2 != null) {
        }
        startRestartGroup.endReplaceableGroup();
        SurfaceKt.m1783SurfaceLPr_se0(function0, semantics$default2222, z4, shape2, m4073unboximpl2222, m4062copywmQWz5c$default2222, borderStroke2, elevation != null ? elevation.getValue().m6403unboximpl() : Dp.m6389constructorimpl(0), mutableInteractionSource4, ComposableLambdaKt.composableLambda(startRestartGroup, 7524271, r4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$3
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

            public final void invoke(Composer composer3, int i19) {
                long Button$lambda$1;
                ComposerKt.sourceInformation(composer3, "C116@5470L683:Button.kt#jmzs0o");
                if ((i19 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(7524271, i19, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:116)");
                    }
                    ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                    Button$lambda$1 = ButtonKt.Button$lambda$1(contentColor2222);
                    ProvidedValue<Float> provides = localContentAlpha.provides(Float.valueOf(Color.m4065getAlphaimpl(Button$lambda$1)));
                    final PaddingValues paddingValues4 = contentPadding;
                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, -1699085201, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt$Button$3.1
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

                        public final void invoke(Composer composer4, int i20) {
                            ComposerKt.sourceInformation(composer4, "C118@5612L10,117@5556L587:Button.kt#jmzs0o");
                            if ((i20 & 11) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1699085201, i20, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:117)");
                                }
                                TextStyle button = MaterialTheme.INSTANCE.getTypography(composer4, 6).getButton();
                                final PaddingValues paddingValues5 = PaddingValues.this;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                TextKt.ProvideTextStyle(button, ComposableLambdaKt.composableLambda(composer4, -630330208, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ButtonKt.Button.3.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                        invoke(composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer5, int i21) {
                                        ComposerKt.sourceInformation(composer5, "C120@5662L467:Button.kt#jmzs0o");
                                        if ((i21 & 11) != 2 || !composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-630330208, i21, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:120)");
                                            }
                                            Modifier padding = PaddingKt.padding(SizeKt.m912defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1574getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m1573getMinHeightD9Ej5fM()), PaddingValues.this);
                                            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                            composer5.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer5, 54);
                                            composer5.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(padding);
                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer5.startReusableNode();
                                            if (composer5.getInserting()) {
                                                composer5.createNode(constructor);
                                            } else {
                                                composer5.useNode();
                                            }
                                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer5);
                                            Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                            composer5.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer5, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                            function34.invoke(RowScopeInstance.INSTANCE, composer5, 6);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            composer5.endReplaceableGroup();
                                            composer5.endNode();
                                            composer5.endReplaceableGroup();
                                            composer5.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer5.skipToGroupEnd();
                                    }
                                }), composer4, 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    }), composer3, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), startRestartGroup, (i172222 & 7168) | (i12 & 14) | C.ENCODING_PCM_32BIT | (i12 & 896) | (i12 & 3670016) | ((i12 << 15) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        ButtonElevation buttonElevation42222 = buttonElevation2;
        paddingValues3 = contentPadding;
        buttonElevation3 = buttonElevation42222;
        modifier3 = modifier2;
        buttonColors3 = buttonColors2;
        composer2 = startRestartGroup;
        z5 = z4;
        shape3 = shape2;
        borderStroke3 = borderStroke2;
        mutableInteractionSource5 = mutableInteractionSource4;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    public static final void OutlinedButton(Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        MutableInteractionSource mutableInteractionSource2;
        composer.startReplaceableGroup(-1776134358);
        ComposerKt.sourceInformation(composer, "C(OutlinedButton)P(8,7,5,6,4,9!2,3)170@8081L39,172@8195L6,173@8252L14,174@8310L22,177@8450L270:Button.kt#jmzs0o");
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        if ((i2 & 8) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        ButtonElevation buttonElevation2 = (i2 & 16) != 0 ? null : buttonElevation;
        Shape small = (i2 & 32) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall() : shape;
        BorderStroke outlinedBorder = (i2 & 64) != 0 ? ButtonDefaults.INSTANCE.getOutlinedBorder(composer, 6) : borderStroke;
        ButtonColors m1576outlinedButtonColorsRGew2ao = (i2 & 128) != 0 ? ButtonDefaults.INSTANCE.m1576outlinedButtonColorsRGew2ao(0L, 0L, 0L, composer, 3072, 7) : buttonColors;
        PaddingValues contentPadding = (i2 & 256) != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1776134358, i, -1, "androidx.compose.material.OutlinedButton (Button.kt:177)");
        }
        Button(function0, modifier2, z2, mutableInteractionSource2, buttonElevation2, small, outlinedBorder, m1576outlinedButtonColorsRGew2ao, contentPadding, function3, composer, i & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    public static final void TextButton(Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        MutableInteractionSource mutableInteractionSource2;
        composer.startReplaceableGroup(288797557);
        ComposerKt.sourceInformation(composer, "C(TextButton)P(8,7,5,6,4,9!2,3)224@10652L39,226@10766L6,228@10856L18,231@11002L270:Button.kt#jmzs0o");
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        if ((i2 & 8) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        ButtonElevation buttonElevation2 = (i2 & 16) != 0 ? null : buttonElevation;
        Shape small = (i2 & 32) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall() : shape;
        BorderStroke borderStroke2 = (i2 & 64) != 0 ? null : borderStroke;
        ButtonColors m1577textButtonColorsRGew2ao = (i2 & 128) != 0 ? ButtonDefaults.INSTANCE.m1577textButtonColorsRGew2ao(0L, 0L, 0L, composer, 3072, 7) : buttonColors;
        PaddingValues textButtonContentPadding = (i2 & 256) != 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(288797557, i, -1, "androidx.compose.material.TextButton (Button.kt:231)");
        }
        Button(function0, modifier2, z2, mutableInteractionSource2, buttonElevation2, small, borderStroke2, m1577textButtonColorsRGew2ao, textButtonContentPadding, function3, composer, i & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Button$lambda$1(State<Color> state) {
        return state.getValue().m4073unboximpl();
    }
}
