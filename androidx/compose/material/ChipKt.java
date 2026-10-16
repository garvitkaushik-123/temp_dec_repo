package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.ClipKt;
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

/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u008e\u0001\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010 \u001aÄ\u0001\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020#2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010%\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010&\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006'²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020)X\u008a\u0084\u0002"}, d2 = {"HorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LeadingIconEndSpacing", "LeadingIconStartSpacing", "SelectedIconContainerSize", "SelectedOverlayOpacity", "", "SurfaceOverlayOpacity", "TrailingIconSpacing", "Chip", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ChipColors;", "leadingIcon", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "selected", "Landroidx/compose/material/SelectableChipColors;", "selectedIcon", "trailingIcon", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/SelectableChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "material_release", "contentColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconContentColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ChipKt {
    private static final float LeadingIconEndSpacing;
    private static final float SelectedOverlayOpacity = 0.16f;
    private static final float SurfaceOverlayOpacity = 0.12f;
    private static final float TrailingIconSpacing;
    private static final float HorizontalPadding = Dp.m6389constructorimpl(12);
    private static final float LeadingIconStartSpacing = Dp.m6389constructorimpl(4);
    private static final float SelectedIconContainerSize = Dp.m6389constructorimpl(24);

    /* JADX WARN: Removed duplicated region for block: B:103:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Chip(final Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, ChipColors chipColors, Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        MutableInteractionSource mutableInteractionSource2;
        Shape shape2;
        int i6;
        BorderStroke borderStroke2;
        ChipColors chipColors2;
        int i7;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function22;
        CornerBasedShape cornerBasedShape;
        Composer composer2;
        Shape shape3;
        ChipColors chipColors3;
        BorderStroke borderStroke3;
        boolean z3;
        MutableInteractionSource mutableInteractionSource3;
        final ChipColors chipColors4;
        final Modifier modifier3;
        Composer composer3;
        final boolean z4;
        final Shape shape4;
        final BorderStroke borderStroke4;
        final MutableInteractionSource mutableInteractionSource4;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        ScopeUpdateScope endRestartGroup;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-368396408);
        ComposerKt.sourceInformation(startRestartGroup, "C(Chip)P(7,6,3,4,8!2,5)92@4249L39,93@4323L6,95@4440L12,99@4585L21,105@4782L24,100@4611L1787:Chip.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 != 0) {
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
                            shape2 = shape;
                            if (startRestartGroup.changed(shape2)) {
                                i10 = 16384;
                                i3 |= i10;
                            }
                        } else {
                            shape2 = shape;
                        }
                        i10 = 8192;
                        i3 |= i10;
                    } else {
                        shape2 = shape;
                    }
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((458752 & i) == 0) {
                        borderStroke2 = borderStroke;
                        i3 |= startRestartGroup.changed(borderStroke2) ? 131072 : 65536;
                        if ((i & 3670016) == 0) {
                            if ((i2 & 64) == 0) {
                                chipColors2 = chipColors;
                                if (startRestartGroup.changed(chipColors2)) {
                                    i9 = 1048576;
                                    i3 |= i9;
                                }
                            } else {
                                chipColors2 = chipColors;
                            }
                            i9 = 524288;
                            i3 |= i9;
                        } else {
                            chipColors2 = chipColors;
                        }
                        i7 = i2 & 128;
                        if (i7 != 0) {
                            i3 |= 12582912;
                            i8 = i6;
                            function22 = function2;
                        } else {
                            i8 = i6;
                            function22 = function2;
                            if ((i & 29360128) == 0) {
                                i3 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                            }
                        }
                        if ((i2 & 256) != 0) {
                            i3 |= 100663296;
                        } else if ((i & 234881024) == 0) {
                            i3 |= startRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
                            if ((i3 & 191739611) == 38347922 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i11 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        z2 = true;
                                    }
                                    if (i5 != 0) {
                                        startRestartGroup.startReplaceableGroup(-492369756);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                    }
                                    if ((i2 & 16) == 0) {
                                        cornerBasedShape = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                        i3 &= -57345;
                                    } else {
                                        cornerBasedShape = shape2;
                                    }
                                    BorderStroke borderStroke5 = i8 == 0 ? null : borderStroke2;
                                    if ((i2 & 64) == 0) {
                                        composer2 = startRestartGroup;
                                        i3 &= -3670017;
                                        chipColors2 = ChipDefaults.INSTANCE.m1586chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 1572864, 63);
                                    } else {
                                        composer2 = startRestartGroup;
                                    }
                                    ChipColors chipColors5 = chipColors2;
                                    shape3 = cornerBasedShape;
                                    chipColors3 = chipColors5;
                                    if (i7 == 0) {
                                        borderStroke3 = borderStroke5;
                                        z3 = z2;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        function22 = null;
                                    } else {
                                        function22 = function2;
                                        borderStroke3 = borderStroke5;
                                        z3 = z2;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i2 & 16) != 0) {
                                        i3 &= -57345;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i3 &= -3670017;
                                    }
                                    composer2 = startRestartGroup;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    borderStroke3 = borderStroke2;
                                    chipColors3 = chipColors2;
                                    z3 = z2;
                                    shape3 = shape2;
                                }
                                composer2.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-368396408, i3, -1, "androidx.compose.material.Chip (Chip.kt:98)");
                                }
                                int i12 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                                final State<Color> contentColor = chipColors3.contentColor(z3, composer2, i12);
                                final ChipColors chipColors6 = chipColors3;
                                final Function2<? super Composer, ? super Integer, Unit> function24 = function22;
                                final boolean z5 = z3;
                                SurfaceKt.m1783SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$2
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                                    }
                                }, 1, null), z3, shape3, chipColors3.backgroundColor(z3, composer2, i12).getValue().m4073unboximpl(), Color.m4062copywmQWz5c$default(Chip$lambda$1(contentColor), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke3, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, 139076687, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$3
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

                                    public final void invoke(Composer composer4, int i13) {
                                        long Chip$lambda$1;
                                        ComposerKt.sourceInformation(composer4, "C110@4950L1442:Chip.kt#jmzs0o");
                                        if ((i13 & 11) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(139076687, i13, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:110)");
                                            }
                                            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                                            Chip$lambda$1 = ChipKt.Chip$lambda$1(contentColor);
                                            ProvidedValue<Float> provides = localContentAlpha.provides(Float.valueOf(Color.m4065getAlphaimpl(Chip$lambda$1)));
                                            final Function2<Composer, Integer, Unit> function25 = function24;
                                            final ChipColors chipColors7 = chipColors6;
                                            final boolean z6 = z5;
                                            final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer4, 667535631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$3.1
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

                                                public final void invoke(Composer composer5, int i14) {
                                                    ComposerKt.sourceInformation(composer5, "C112@5092L10,111@5036L1346:Chip.kt#jmzs0o");
                                                    if ((i14 & 11) != 2 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(667535631, i14, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:111)");
                                                        }
                                                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer5, 6).getBody2();
                                                        final Function2<Composer, Integer, Unit> function26 = function25;
                                                        final ChipColors chipColors8 = chipColors7;
                                                        final boolean z7 = z6;
                                                        final Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer5, -1131213696, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.3.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                                invoke(composer6, num.intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(Composer composer6, int i15) {
                                                                float m6389constructorimpl;
                                                                float f;
                                                                float f2;
                                                                float f3;
                                                                ComposerKt.sourceInformation(composer6, "C114@5141L1227:Chip.kt#jmzs0o");
                                                                if ((i15 & 11) != 2 || !composer6.getSkipping()) {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1131213696, i15, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:114)");
                                                                    }
                                                                    Modifier m913defaultMinSizeVpY3zN4$default = SizeKt.m913defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, ChipDefaults.INSTANCE.m1589getMinHeightD9Ej5fM(), 1, null);
                                                                    if (function26 == null) {
                                                                        m6389constructorimpl = ChipKt.HorizontalPadding;
                                                                    } else {
                                                                        m6389constructorimpl = Dp.m6389constructorimpl(0);
                                                                    }
                                                                    f = ChipKt.HorizontalPadding;
                                                                    Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(m913defaultMinSizeVpY3zN4$default, m6389constructorimpl, 0.0f, f, 0.0f, 10, null);
                                                                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                                    Function2<Composer, Integer, Unit> function27 = function26;
                                                                    ChipColors chipColors9 = chipColors8;
                                                                    boolean z8 = z7;
                                                                    Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                                                    composer6.startReplaceableGroup(693286680);
                                                                    ComposerKt.sourceInformation(composer6, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer6, 54);
                                                                    composer6.startReplaceableGroup(-1323940314);
                                                                    ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                                                    CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                                                                    if (!(composer6.getApplier() instanceof Applier)) {
                                                                        ComposablesKt.invalidApplier();
                                                                    }
                                                                    composer6.startReusableNode();
                                                                    if (composer6.getInserting()) {
                                                                        composer6.createNode(constructor);
                                                                    } else {
                                                                        composer6.useNode();
                                                                    }
                                                                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer6);
                                                                    Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                                    }
                                                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                                                    composer6.startReplaceableGroup(2058660585);
                                                                    ComposerKt.sourceInformationMarkerStart(composer6, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                                    ComposerKt.sourceInformationMarkerStart(composer6, 2084788993, "C138@6341L9:Chip.kt#jmzs0o");
                                                                    composer6.startReplaceableGroup(2084788993);
                                                                    ComposerKt.sourceInformation(composer6, "129@5794L47,130@5904L32,131@5961L267,136@6253L45");
                                                                    if (function27 != null) {
                                                                        Modifier.Companion companion = Modifier.INSTANCE;
                                                                        f2 = ChipKt.LeadingIconStartSpacing;
                                                                        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion, f2), composer6, 6);
                                                                        State<Color> leadingIconContentColor = chipColors9.leadingIconContentColor(z8, composer6, 0);
                                                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(invoke$lambda$1$lambda$0(leadingIconContentColor))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(invoke$lambda$1$lambda$0(leadingIconContentColor))))}, function27, composer6, 8);
                                                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                                                        f3 = ChipKt.LeadingIconEndSpacing;
                                                                        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f3), composer6, 6);
                                                                    }
                                                                    composer6.endReplaceableGroup();
                                                                    function34.invoke(rowScopeInstance, composer6, 6);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer6);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer6);
                                                                    composer6.endReplaceableGroup();
                                                                    composer6.endNode();
                                                                    composer6.endReplaceableGroup();
                                                                    composer6.endReplaceableGroup();
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventEnd();
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                composer6.skipToGroupEnd();
                                                            }

                                                            private static final long invoke$lambda$1$lambda$0(State<Color> state) {
                                                                return state.getValue().m4073unboximpl();
                                                            }
                                                        }), composer5, 48);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer5.skipToGroupEnd();
                                                }
                                            }), composer4, ProvidedValue.$stable | 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                chipColors4 = chipColors6;
                                modifier3 = modifier2;
                                composer3 = composer2;
                                z4 = z3;
                                shape4 = shape3;
                                borderStroke4 = borderStroke3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                function23 = function24;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                composer3 = startRestartGroup;
                                modifier3 = modifier2;
                                z4 = z2;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                shape4 = shape2;
                                function23 = function22;
                                borderStroke4 = borderStroke2;
                                chipColors4 = chipColors2;
                            }
                            endRestartGroup = composer3.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$4
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

                                    public final void invoke(Composer composer4, int i13) {
                                        ChipKt.Chip(function0, modifier3, z4, mutableInteractionSource4, shape4, borderStroke4, chipColors4, function23, function3, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i3 & 191739611) == 38347922) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i2 & 16) == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if ((i2 & 64) == 0) {
                        }
                        ChipColors chipColors52 = chipColors2;
                        shape3 = cornerBasedShape;
                        chipColors3 = chipColors52;
                        if (i7 == 0) {
                        }
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i122 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        final State<Color> contentColor2 = chipColors3.contentColor(z3, composer2, i122);
                        final ChipColors chipColors62 = chipColors3;
                        final Function2<? super Composer, ? super Integer, Unit> function242 = function22;
                        final boolean z52 = z3;
                        SurfaceKt.m1783SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                            }
                        }, 1, null), z3, shape3, chipColors3.backgroundColor(z3, composer2, i122).getValue().m4073unboximpl(), Color.m4062copywmQWz5c$default(Chip$lambda$1(contentColor2), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke3, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, 139076687, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$3
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

                            public final void invoke(Composer composer4, int i13) {
                                long Chip$lambda$1;
                                ComposerKt.sourceInformation(composer4, "C110@4950L1442:Chip.kt#jmzs0o");
                                if ((i13 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(139076687, i13, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:110)");
                                    }
                                    ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                                    Chip$lambda$1 = ChipKt.Chip$lambda$1(contentColor2);
                                    ProvidedValue<Float> provides = localContentAlpha.provides(Float.valueOf(Color.m4065getAlphaimpl(Chip$lambda$1)));
                                    final Function2<? super Composer, ? super Integer, Unit> function25 = function242;
                                    final ChipColors chipColors7 = chipColors62;
                                    final boolean z6 = z52;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer4, 667535631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$3.1
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

                                        public final void invoke(Composer composer5, int i14) {
                                            ComposerKt.sourceInformation(composer5, "C112@5092L10,111@5036L1346:Chip.kt#jmzs0o");
                                            if ((i14 & 11) != 2 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(667535631, i14, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:111)");
                                                }
                                                TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer5, 6).getBody2();
                                                final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
                                                final ChipColors chipColors8 = chipColors7;
                                                final boolean z7 = z6;
                                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                                TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer5, -1131213696, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.3.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                        invoke(composer6, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer6, int i15) {
                                                        float m6389constructorimpl;
                                                        float f;
                                                        float f2;
                                                        float f3;
                                                        ComposerKt.sourceInformation(composer6, "C114@5141L1227:Chip.kt#jmzs0o");
                                                        if ((i15 & 11) != 2 || !composer6.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1131213696, i15, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:114)");
                                                            }
                                                            Modifier m913defaultMinSizeVpY3zN4$default = SizeKt.m913defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, ChipDefaults.INSTANCE.m1589getMinHeightD9Ej5fM(), 1, null);
                                                            if (function26 == null) {
                                                                m6389constructorimpl = ChipKt.HorizontalPadding;
                                                            } else {
                                                                m6389constructorimpl = Dp.m6389constructorimpl(0);
                                                            }
                                                            f = ChipKt.HorizontalPadding;
                                                            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(m913defaultMinSizeVpY3zN4$default, m6389constructorimpl, 0.0f, f, 0.0f, 10, null);
                                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                            Function2<Composer, Integer, Unit> function27 = function26;
                                                            ChipColors chipColors9 = chipColors8;
                                                            boolean z8 = z7;
                                                            Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                                            composer6.startReplaceableGroup(693286680);
                                                            ComposerKt.sourceInformation(composer6, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer6, 54);
                                                            composer6.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                                            CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                                                            if (!(composer6.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer6.startReusableNode();
                                                            if (composer6.getInserting()) {
                                                                composer6.createNode(constructor);
                                                            } else {
                                                                composer6.useNode();
                                                            }
                                                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer6);
                                                            Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                            }
                                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                                            composer6.startReplaceableGroup(2058660585);
                                                            ComposerKt.sourceInformationMarkerStart(composer6, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer6, 2084788993, "C138@6341L9:Chip.kt#jmzs0o");
                                                            composer6.startReplaceableGroup(2084788993);
                                                            ComposerKt.sourceInformation(composer6, "129@5794L47,130@5904L32,131@5961L267,136@6253L45");
                                                            if (function27 != null) {
                                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                                f2 = ChipKt.LeadingIconStartSpacing;
                                                                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion, f2), composer6, 6);
                                                                State<Color> leadingIconContentColor = chipColors9.leadingIconContentColor(z8, composer6, 0);
                                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(invoke$lambda$1$lambda$0(leadingIconContentColor))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(invoke$lambda$1$lambda$0(leadingIconContentColor))))}, function27, composer6, 8);
                                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                                f3 = ChipKt.LeadingIconEndSpacing;
                                                                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f3), composer6, 6);
                                                            }
                                                            composer6.endReplaceableGroup();
                                                            function34.invoke(rowScopeInstance, composer6, 6);
                                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                                            composer6.endReplaceableGroup();
                                                            composer6.endNode();
                                                            composer6.endReplaceableGroup();
                                                            composer6.endReplaceableGroup();
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer6.skipToGroupEnd();
                                                    }

                                                    private static final long invoke$lambda$1$lambda$0(State<Color> state) {
                                                        return state.getValue().m4073unboximpl();
                                                    }
                                                }), composer5, 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    }), composer4, ProvidedValue.$stable | 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer4.skipToGroupEnd();
                            }
                        }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        chipColors4 = chipColors62;
                        modifier3 = modifier2;
                        composer3 = composer2;
                        z4 = z3;
                        shape4 = shape3;
                        borderStroke4 = borderStroke3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        function23 = function242;
                        endRestartGroup = composer3.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    borderStroke2 = borderStroke;
                    if ((i & 3670016) == 0) {
                    }
                    i7 = i2 & 128;
                    if (i7 != 0) {
                    }
                    if ((i2 & 256) != 0) {
                    }
                    if ((i3 & 191739611) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if ((i2 & 64) == 0) {
                    }
                    ChipColors chipColors522 = chipColors2;
                    shape3 = cornerBasedShape;
                    chipColors3 = chipColors522;
                    if (i7 == 0) {
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i1222 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    final State<Color> contentColor22 = chipColors3.contentColor(z3, composer2, i1222);
                    final ChipColors chipColors622 = chipColors3;
                    final Function2<? super Composer, ? super Integer, Unit> function2422 = function22;
                    final boolean z522 = z3;
                    SurfaceKt.m1783SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                        }
                    }, 1, null), z3, shape3, chipColors3.backgroundColor(z3, composer2, i1222).getValue().m4073unboximpl(), Color.m4062copywmQWz5c$default(Chip$lambda$1(contentColor22), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke3, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, 139076687, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$3
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

                        public final void invoke(Composer composer4, int i13) {
                            long Chip$lambda$1;
                            ComposerKt.sourceInformation(composer4, "C110@4950L1442:Chip.kt#jmzs0o");
                            if ((i13 & 11) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(139076687, i13, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:110)");
                                }
                                ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                                Chip$lambda$1 = ChipKt.Chip$lambda$1(contentColor22);
                                ProvidedValue<Float> provides = localContentAlpha.provides(Float.valueOf(Color.m4065getAlphaimpl(Chip$lambda$1)));
                                final Function2<? super Composer, ? super Integer, Unit> function25 = function2422;
                                final ChipColors chipColors7 = chipColors622;
                                final boolean z6 = z522;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer4, 667535631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$3.1
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

                                    public final void invoke(Composer composer5, int i14) {
                                        ComposerKt.sourceInformation(composer5, "C112@5092L10,111@5036L1346:Chip.kt#jmzs0o");
                                        if ((i14 & 11) != 2 || !composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(667535631, i14, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:111)");
                                            }
                                            TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer5, 6).getBody2();
                                            final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
                                            final ChipColors chipColors8 = chipColors7;
                                            final boolean z7 = z6;
                                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                            TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer5, -1131213696, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.3.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                    invoke(composer6, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer6, int i15) {
                                                    float m6389constructorimpl;
                                                    float f;
                                                    float f2;
                                                    float f3;
                                                    ComposerKt.sourceInformation(composer6, "C114@5141L1227:Chip.kt#jmzs0o");
                                                    if ((i15 & 11) != 2 || !composer6.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1131213696, i15, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:114)");
                                                        }
                                                        Modifier m913defaultMinSizeVpY3zN4$default = SizeKt.m913defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, ChipDefaults.INSTANCE.m1589getMinHeightD9Ej5fM(), 1, null);
                                                        if (function26 == null) {
                                                            m6389constructorimpl = ChipKt.HorizontalPadding;
                                                        } else {
                                                            m6389constructorimpl = Dp.m6389constructorimpl(0);
                                                        }
                                                        f = ChipKt.HorizontalPadding;
                                                        Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(m913defaultMinSizeVpY3zN4$default, m6389constructorimpl, 0.0f, f, 0.0f, 10, null);
                                                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function2<Composer, Integer, Unit> function27 = function26;
                                                        ChipColors chipColors9 = chipColors8;
                                                        boolean z8 = z7;
                                                        Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                                        composer6.startReplaceableGroup(693286680);
                                                        ComposerKt.sourceInformation(composer6, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer6, 54);
                                                        composer6.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                                                        if (!(composer6.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer6.startReusableNode();
                                                        if (composer6.getInserting()) {
                                                            composer6.createNode(constructor);
                                                        } else {
                                                            composer6.useNode();
                                                        }
                                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer6);
                                                        Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                                        composer6.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer6, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer6, 2084788993, "C138@6341L9:Chip.kt#jmzs0o");
                                                        composer6.startReplaceableGroup(2084788993);
                                                        ComposerKt.sourceInformation(composer6, "129@5794L47,130@5904L32,131@5961L267,136@6253L45");
                                                        if (function27 != null) {
                                                            Modifier.Companion companion = Modifier.INSTANCE;
                                                            f2 = ChipKt.LeadingIconStartSpacing;
                                                            SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion, f2), composer6, 6);
                                                            State<Color> leadingIconContentColor = chipColors9.leadingIconContentColor(z8, composer6, 0);
                                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(invoke$lambda$1$lambda$0(leadingIconContentColor))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(invoke$lambda$1$lambda$0(leadingIconContentColor))))}, function27, composer6, 8);
                                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                                            f3 = ChipKt.LeadingIconEndSpacing;
                                                            SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f3), composer6, 6);
                                                        }
                                                        composer6.endReplaceableGroup();
                                                        function34.invoke(rowScopeInstance, composer6, 6);
                                                        ComposerKt.sourceInformationMarkerEnd(composer6);
                                                        ComposerKt.sourceInformationMarkerEnd(composer6);
                                                        composer6.endReplaceableGroup();
                                                        composer6.endNode();
                                                        composer6.endReplaceableGroup();
                                                        composer6.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer6.skipToGroupEnd();
                                                }

                                                private static final long invoke$lambda$1$lambda$0(State<Color> state) {
                                                    return state.getValue().m4073unboximpl();
                                                }
                                            }), composer5, 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer5.skipToGroupEnd();
                                    }
                                }), composer4, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer4.skipToGroupEnd();
                        }
                    }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    chipColors4 = chipColors622;
                    modifier3 = modifier2;
                    composer3 = composer2;
                    z4 = z3;
                    shape4 = shape3;
                    borderStroke4 = borderStroke3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    function23 = function2422;
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                mutableInteractionSource2 = mutableInteractionSource;
                if ((57344 & i) != 0) {
                }
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                borderStroke2 = borderStroke;
                if ((i & 3670016) == 0) {
                }
                i7 = i2 & 128;
                if (i7 != 0) {
                }
                if ((i2 & 256) != 0) {
                }
                if ((i3 & 191739611) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i11 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) == 0) {
                }
                if (i8 == 0) {
                }
                if ((i2 & 64) == 0) {
                }
                ChipColors chipColors5222 = chipColors2;
                shape3 = cornerBasedShape;
                chipColors3 = chipColors5222;
                if (i7 == 0) {
                }
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i12222 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                final State<Color> contentColor222 = chipColors3.contentColor(z3, composer2, i12222);
                final ChipColors chipColors6222 = chipColors3;
                final Function2<? super Composer, ? super Integer, Unit> function24222 = function22;
                final boolean z5222 = z3;
                SurfaceKt.m1783SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                    }
                }, 1, null), z3, shape3, chipColors3.backgroundColor(z3, composer2, i12222).getValue().m4073unboximpl(), Color.m4062copywmQWz5c$default(Chip$lambda$1(contentColor222), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke3, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, 139076687, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$3
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

                    public final void invoke(Composer composer4, int i13) {
                        long Chip$lambda$1;
                        ComposerKt.sourceInformation(composer4, "C110@4950L1442:Chip.kt#jmzs0o");
                        if ((i13 & 11) != 2 || !composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(139076687, i13, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:110)");
                            }
                            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                            Chip$lambda$1 = ChipKt.Chip$lambda$1(contentColor222);
                            ProvidedValue<Float> provides = localContentAlpha.provides(Float.valueOf(Color.m4065getAlphaimpl(Chip$lambda$1)));
                            final Function2<? super Composer, ? super Integer, Unit> function25 = function24222;
                            final ChipColors chipColors7 = chipColors6222;
                            final boolean z6 = z5222;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer4, 667535631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$3.1
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

                                public final void invoke(Composer composer5, int i14) {
                                    ComposerKt.sourceInformation(composer5, "C112@5092L10,111@5036L1346:Chip.kt#jmzs0o");
                                    if ((i14 & 11) != 2 || !composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(667535631, i14, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:111)");
                                        }
                                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer5, 6).getBody2();
                                        final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
                                        final ChipColors chipColors8 = chipColors7;
                                        final boolean z7 = z6;
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer5, -1131213696, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.3.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                                invoke(composer6, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer6, int i15) {
                                                float m6389constructorimpl;
                                                float f;
                                                float f2;
                                                float f3;
                                                ComposerKt.sourceInformation(composer6, "C114@5141L1227:Chip.kt#jmzs0o");
                                                if ((i15 & 11) != 2 || !composer6.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1131213696, i15, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:114)");
                                                    }
                                                    Modifier m913defaultMinSizeVpY3zN4$default = SizeKt.m913defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, ChipDefaults.INSTANCE.m1589getMinHeightD9Ej5fM(), 1, null);
                                                    if (function26 == null) {
                                                        m6389constructorimpl = ChipKt.HorizontalPadding;
                                                    } else {
                                                        m6389constructorimpl = Dp.m6389constructorimpl(0);
                                                    }
                                                    f = ChipKt.HorizontalPadding;
                                                    Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(m913defaultMinSizeVpY3zN4$default, m6389constructorimpl, 0.0f, f, 0.0f, 10, null);
                                                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function2<Composer, Integer, Unit> function27 = function26;
                                                    ChipColors chipColors9 = chipColors8;
                                                    boolean z8 = z7;
                                                    Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                                    composer6.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer6, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer6, 54);
                                                    composer6.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                                                    if (!(composer6.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer6.startReusableNode();
                                                    if (composer6.getInserting()) {
                                                        composer6.createNode(constructor);
                                                    } else {
                                                        composer6.useNode();
                                                    }
                                                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer6);
                                                    Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                                    composer6.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer6, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer6, 2084788993, "C138@6341L9:Chip.kt#jmzs0o");
                                                    composer6.startReplaceableGroup(2084788993);
                                                    ComposerKt.sourceInformation(composer6, "129@5794L47,130@5904L32,131@5961L267,136@6253L45");
                                                    if (function27 != null) {
                                                        Modifier.Companion companion = Modifier.INSTANCE;
                                                        f2 = ChipKt.LeadingIconStartSpacing;
                                                        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion, f2), composer6, 6);
                                                        State<Color> leadingIconContentColor = chipColors9.leadingIconContentColor(z8, composer6, 0);
                                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(invoke$lambda$1$lambda$0(leadingIconContentColor))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(invoke$lambda$1$lambda$0(leadingIconContentColor))))}, function27, composer6, 8);
                                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                                        f3 = ChipKt.LeadingIconEndSpacing;
                                                        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f3), composer6, 6);
                                                    }
                                                    composer6.endReplaceableGroup();
                                                    function34.invoke(rowScopeInstance, composer6, 6);
                                                    ComposerKt.sourceInformationMarkerEnd(composer6);
                                                    ComposerKt.sourceInformationMarkerEnd(composer6);
                                                    composer6.endReplaceableGroup();
                                                    composer6.endNode();
                                                    composer6.endReplaceableGroup();
                                                    composer6.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer6.skipToGroupEnd();
                                            }

                                            private static final long invoke$lambda$1$lambda$0(State<Color> state) {
                                                return state.getValue().m4073unboximpl();
                                            }
                                        }), composer5, 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer5.skipToGroupEnd();
                                }
                            }), composer4, ProvidedValue.$stable | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer4.skipToGroupEnd();
                    }
                }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                }
                chipColors4 = chipColors6222;
                modifier3 = modifier2;
                composer3 = composer2;
                z4 = z3;
                shape4 = shape3;
                borderStroke4 = borderStroke3;
                mutableInteractionSource4 = mutableInteractionSource3;
                function23 = function24222;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z2 = z;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            mutableInteractionSource2 = mutableInteractionSource;
            if ((57344 & i) != 0) {
            }
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            borderStroke2 = borderStroke;
            if ((i & 3670016) == 0) {
            }
            i7 = i2 & 128;
            if (i7 != 0) {
            }
            if ((i2 & 256) != 0) {
            }
            if ((i3 & 191739611) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i11 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) == 0) {
            }
            if (i8 == 0) {
            }
            if ((i2 & 64) == 0) {
            }
            ChipColors chipColors52222 = chipColors2;
            shape3 = cornerBasedShape;
            chipColors3 = chipColors52222;
            if (i7 == 0) {
            }
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i122222 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
            final State<Color> contentColor2222 = chipColors3.contentColor(z3, composer2, i122222);
            final ChipColors chipColors62222 = chipColors3;
            final Function2<? super Composer, ? super Integer, Unit> function242222 = function22;
            final boolean z52222 = z3;
            SurfaceKt.m1783SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
                }
            }, 1, null), z3, shape3, chipColors3.backgroundColor(z3, composer2, i122222).getValue().m4073unboximpl(), Color.m4062copywmQWz5c$default(Chip$lambda$1(contentColor2222), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke3, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, 139076687, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$3
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

                public final void invoke(Composer composer4, int i13) {
                    long Chip$lambda$1;
                    ComposerKt.sourceInformation(composer4, "C110@4950L1442:Chip.kt#jmzs0o");
                    if ((i13 & 11) != 2 || !composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(139076687, i13, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:110)");
                        }
                        ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                        Chip$lambda$1 = ChipKt.Chip$lambda$1(contentColor2222);
                        ProvidedValue<Float> provides = localContentAlpha.provides(Float.valueOf(Color.m4065getAlphaimpl(Chip$lambda$1)));
                        final Function2<? super Composer, ? super Integer, Unit> function25 = function242222;
                        final ChipColors chipColors7 = chipColors62222;
                        final boolean z6 = z52222;
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer4, 667535631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$3.1
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

                            public final void invoke(Composer composer5, int i14) {
                                ComposerKt.sourceInformation(composer5, "C112@5092L10,111@5036L1346:Chip.kt#jmzs0o");
                                if ((i14 & 11) != 2 || !composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(667535631, i14, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:111)");
                                    }
                                    TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer5, 6).getBody2();
                                    final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
                                    final ChipColors chipColors8 = chipColors7;
                                    final boolean z7 = z6;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                    TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer5, -1131213696, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.3.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                            invoke(composer6, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer6, int i15) {
                                            float m6389constructorimpl;
                                            float f;
                                            float f2;
                                            float f3;
                                            ComposerKt.sourceInformation(composer6, "C114@5141L1227:Chip.kt#jmzs0o");
                                            if ((i15 & 11) != 2 || !composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1131213696, i15, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:114)");
                                                }
                                                Modifier m913defaultMinSizeVpY3zN4$default = SizeKt.m913defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, ChipDefaults.INSTANCE.m1589getMinHeightD9Ej5fM(), 1, null);
                                                if (function26 == null) {
                                                    m6389constructorimpl = ChipKt.HorizontalPadding;
                                                } else {
                                                    m6389constructorimpl = Dp.m6389constructorimpl(0);
                                                }
                                                f = ChipKt.HorizontalPadding;
                                                Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(m913defaultMinSizeVpY3zN4$default, m6389constructorimpl, 0.0f, f, 0.0f, 10, null);
                                                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                Function2<Composer, Integer, Unit> function27 = function26;
                                                ChipColors chipColors9 = chipColors8;
                                                boolean z8 = z7;
                                                Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                                composer6.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer6, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer6, 54);
                                                composer6.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                                                if (!(composer6.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer6.startReusableNode();
                                                if (composer6.getInserting()) {
                                                    composer6.createNode(constructor);
                                                } else {
                                                    composer6.useNode();
                                                }
                                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer6);
                                                Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                                composer6.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer6, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer6, 2084788993, "C138@6341L9:Chip.kt#jmzs0o");
                                                composer6.startReplaceableGroup(2084788993);
                                                ComposerKt.sourceInformation(composer6, "129@5794L47,130@5904L32,131@5961L267,136@6253L45");
                                                if (function27 != null) {
                                                    Modifier.Companion companion = Modifier.INSTANCE;
                                                    f2 = ChipKt.LeadingIconStartSpacing;
                                                    SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion, f2), composer6, 6);
                                                    State<Color> leadingIconContentColor = chipColors9.leadingIconContentColor(z8, composer6, 0);
                                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(invoke$lambda$1$lambda$0(leadingIconContentColor))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(invoke$lambda$1$lambda$0(leadingIconContentColor))))}, function27, composer6, 8);
                                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                                    f3 = ChipKt.LeadingIconEndSpacing;
                                                    SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f3), composer6, 6);
                                                }
                                                composer6.endReplaceableGroup();
                                                function34.invoke(rowScopeInstance, composer6, 6);
                                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                                ComposerKt.sourceInformationMarkerEnd(composer6);
                                                composer6.endReplaceableGroup();
                                                composer6.endNode();
                                                composer6.endReplaceableGroup();
                                                composer6.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer6.skipToGroupEnd();
                                        }

                                        private static final long invoke$lambda$1$lambda$0(State<Color> state) {
                                            return state.getValue().m4073unboximpl();
                                        }
                                    }), composer5, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer5.skipToGroupEnd();
                            }
                        }), composer4, ProvidedValue.$stable | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer4.skipToGroupEnd();
                }
            }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
            if (ComposerKt.isTraceInProgress()) {
            }
            chipColors4 = chipColors62222;
            modifier3 = modifier2;
            composer3 = composer2;
            z4 = z3;
            shape4 = shape3;
            borderStroke4 = borderStroke3;
            mutableInteractionSource4 = mutableInteractionSource3;
            function23 = function242222;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
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
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        borderStroke2 = borderStroke;
        if ((i & 3670016) == 0) {
        }
        i7 = i2 & 128;
        if (i7 != 0) {
        }
        if ((i2 & 256) != 0) {
        }
        if ((i3 & 191739611) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i11 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) == 0) {
        }
        if (i8 == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        ChipColors chipColors522222 = chipColors2;
        shape3 = cornerBasedShape;
        chipColors3 = chipColors522222;
        if (i7 == 0) {
        }
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1222222 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
        final State<Color> contentColor22222 = chipColors3.contentColor(z3, composer2, i1222222);
        final ChipColors chipColors622222 = chipColors3;
        final Function2<? super Composer, ? super Integer, Unit> function2422222 = function22;
        final boolean z522222 = z3;
        SurfaceKt.m1783SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5716getButtono7Vup1c());
            }
        }, 1, null), z3, shape3, chipColors3.backgroundColor(z3, composer2, i1222222).getValue().m4073unboximpl(), Color.m4062copywmQWz5c$default(Chip$lambda$1(contentColor22222), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke3, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(composer2, 139076687, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$3
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

            public final void invoke(Composer composer4, int i13) {
                long Chip$lambda$1;
                ComposerKt.sourceInformation(composer4, "C110@4950L1442:Chip.kt#jmzs0o");
                if ((i13 & 11) != 2 || !composer4.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(139076687, i13, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:110)");
                    }
                    ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
                    Chip$lambda$1 = ChipKt.Chip$lambda$1(contentColor22222);
                    ProvidedValue<Float> provides = localContentAlpha.provides(Float.valueOf(Color.m4065getAlphaimpl(Chip$lambda$1)));
                    final Function2<? super Composer, ? super Integer, Unit> function25 = function2422222;
                    final ChipColors chipColors7 = chipColors622222;
                    final boolean z6 = z522222;
                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer4, 667535631, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$Chip$3.1
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

                        public final void invoke(Composer composer5, int i14) {
                            ComposerKt.sourceInformation(composer5, "C112@5092L10,111@5036L1346:Chip.kt#jmzs0o");
                            if ((i14 & 11) != 2 || !composer5.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(667535631, i14, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:111)");
                                }
                                TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer5, 6).getBody2();
                                final Function2<? super Composer, ? super Integer, Unit> function26 = function25;
                                final ChipColors chipColors8 = chipColors7;
                                final boolean z7 = z6;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer5, -1131213696, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.Chip.3.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer6, Integer num) {
                                        invoke(composer6, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer6, int i15) {
                                        float m6389constructorimpl;
                                        float f;
                                        float f2;
                                        float f3;
                                        ComposerKt.sourceInformation(composer6, "C114@5141L1227:Chip.kt#jmzs0o");
                                        if ((i15 & 11) != 2 || !composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1131213696, i15, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:114)");
                                            }
                                            Modifier m913defaultMinSizeVpY3zN4$default = SizeKt.m913defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, ChipDefaults.INSTANCE.m1589getMinHeightD9Ej5fM(), 1, null);
                                            if (function26 == null) {
                                                m6389constructorimpl = ChipKt.HorizontalPadding;
                                            } else {
                                                m6389constructorimpl = Dp.m6389constructorimpl(0);
                                            }
                                            f = ChipKt.HorizontalPadding;
                                            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(m913defaultMinSizeVpY3zN4$default, m6389constructorimpl, 0.0f, f, 0.0f, 10, null);
                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function2<Composer, Integer, Unit> function27 = function26;
                                            ChipColors chipColors9 = chipColors8;
                                            boolean z8 = z7;
                                            Function3<RowScope, Composer, Integer, Unit> function34 = function33;
                                            composer6.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer6, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer6, 54);
                                            composer6.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                                            if (!(composer6.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer6.startReusableNode();
                                            if (composer6.getInserting()) {
                                                composer6.createNode(constructor);
                                            } else {
                                                composer6.useNode();
                                            }
                                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer6);
                                            Updater.m3600setimpl(m3593constructorimpl, rowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                            composer6.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer6, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer6, 2084788993, "C138@6341L9:Chip.kt#jmzs0o");
                                            composer6.startReplaceableGroup(2084788993);
                                            ComposerKt.sourceInformation(composer6, "129@5794L47,130@5904L32,131@5961L267,136@6253L45");
                                            if (function27 != null) {
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                f2 = ChipKt.LeadingIconStartSpacing;
                                                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion, f2), composer6, 6);
                                                State<Color> leadingIconContentColor = chipColors9.leadingIconContentColor(z8, composer6, 0);
                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(invoke$lambda$1$lambda$0(leadingIconContentColor))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(invoke$lambda$1$lambda$0(leadingIconContentColor))))}, function27, composer6, 8);
                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                f3 = ChipKt.LeadingIconEndSpacing;
                                                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f3), composer6, 6);
                                            }
                                            composer6.endReplaceableGroup();
                                            function34.invoke(rowScopeInstance, composer6, 6);
                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                            ComposerKt.sourceInformationMarkerEnd(composer6);
                                            composer6.endReplaceableGroup();
                                            composer6.endNode();
                                            composer6.endReplaceableGroup();
                                            composer6.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer6.skipToGroupEnd();
                                    }

                                    private static final long invoke$lambda$1$lambda$0(State<Color> state) {
                                        return state.getValue().m4073unboximpl();
                                    }
                                }), composer5, 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer5.skipToGroupEnd();
                        }
                    }), composer4, ProvidedValue.$stable | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer4.skipToGroupEnd();
            }
        }), composer2, (i3 & 14) | C.ENCODING_PCM_32BIT | (i3 & 896) | ((i3 >> 3) & 7168) | ((i3 << 3) & 3670016) | ((i3 << 15) & 234881024), 128);
        if (ComposerKt.isTraceInProgress()) {
        }
        chipColors4 = chipColors622222;
        modifier3 = modifier2;
        composer3 = composer2;
        z4 = z3;
        shape4 = shape3;
        borderStroke4 = borderStroke3;
        mutableInteractionSource4 = mutableInteractionSource3;
        function23 = function2422222;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x023e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FilterChip(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, SelectableChipColors selectableChipColors, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        int i7;
        final CornerBasedShape cornerBasedShape;
        int i8;
        BorderStroke borderStroke2;
        SelectableChipColors selectableChipColors2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        Modifier.Companion companion;
        MutableInteractionSource mutableInteractionSource2;
        int i15;
        int i16;
        int i17;
        SelectableChipColors selectableChipColors3;
        Function2<? super Composer, ? super Integer, Unit> function24;
        Function2<? super Composer, ? super Integer, Unit> function25;
        MutableInteractionSource mutableInteractionSource3;
        int i18;
        BorderStroke borderStroke3;
        Function2<? super Composer, ? super Integer, Unit> function26;
        SelectableChipColors selectableChipColors4;
        Shape shape2;
        Composer composer2;
        final BorderStroke borderStroke4;
        final MutableInteractionSource mutableInteractionSource4;
        final SelectableChipColors selectableChipColors5;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final boolean z4;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i19;
        Composer startRestartGroup = composer.startRestartGroup(-1259208246);
        ComposerKt.sourceInformation(startRestartGroup, "C(FilterChip)P(8,7,6,3,4,10!2,5,9,11)189@8789L39,190@8863L6,192@8990L18,199@9321L31,206@9559L34,200@9357L4342:Chip.kt#jmzs0o");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= startRestartGroup.changedInstance(function0) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else if ((i & 896) == 0) {
                modifier2 = modifier;
                i4 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i6 = i3 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else if ((i & 7168) == 0) {
                    z3 = z2;
                    i4 |= startRestartGroup.changed(z3) ? 2048 : 1024;
                    i7 = i3 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else if ((i & 57344) == 0) {
                        i4 |= startRestartGroup.changed(mutableInteractionSource) ? 16384 : 8192;
                    }
                    if ((i & 458752) != 0) {
                        cornerBasedShape = shape;
                        i4 |= ((i3 & 32) == 0 && startRestartGroup.changed(cornerBasedShape)) ? 131072 : 65536;
                    } else {
                        cornerBasedShape = shape;
                    }
                    i8 = i3 & 64;
                    if (i8 == 0) {
                        i4 |= 1572864;
                        borderStroke2 = borderStroke;
                    } else {
                        borderStroke2 = borderStroke;
                        if ((i & 3670016) == 0) {
                            i4 |= startRestartGroup.changed(borderStroke2) ? 1048576 : 524288;
                        }
                    }
                    if ((i & 29360128) != 0) {
                        if ((i3 & 128) == 0) {
                            selectableChipColors2 = selectableChipColors;
                            if (startRestartGroup.changed(selectableChipColors2)) {
                                i19 = 8388608;
                                i4 |= i19;
                            }
                        } else {
                            selectableChipColors2 = selectableChipColors;
                        }
                        i19 = 4194304;
                        i4 |= i19;
                    } else {
                        selectableChipColors2 = selectableChipColors;
                    }
                    i9 = i3 & 256;
                    if (i9 == 0) {
                        i4 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        i4 |= startRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
                    }
                    i10 = i3 & 512;
                    if (i10 == 0) {
                        i4 |= C.ENCODING_PCM_32BIT;
                    } else if ((i & 1879048192) == 0) {
                        i11 = i10;
                        i4 |= startRestartGroup.changedInstance(function22) ? 536870912 : 268435456;
                        i12 = i3 & 1024;
                        if (i12 != 0) {
                            i14 = i2 | 6;
                            i13 = i12;
                        } else if ((i2 & 14) == 0) {
                            i13 = i12;
                            i14 = i2 | (startRestartGroup.changedInstance(function23) ? 4 : 2);
                        } else {
                            i13 = i12;
                            i14 = i2;
                        }
                        if ((i3 & 2048) != 0) {
                            i14 |= 48;
                        } else if ((i2 & 112) == 0) {
                            i14 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
                            int i20 = i14;
                            if ((i4 & 1533916891) == 306783378 || (i20 & 91) != 18 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                                    boolean z5 = i6 == 0 ? true : z3;
                                    if (i7 == 0) {
                                        startRestartGroup.startReplaceableGroup(-492369756);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                        Object rememberedValue = startRestartGroup.rememberedValue();
                                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                    } else {
                                        mutableInteractionSource2 = mutableInteractionSource;
                                    }
                                    if ((i3 & 32) != 0) {
                                        cornerBasedShape = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                        i4 &= -458753;
                                    }
                                    int i21 = i4;
                                    Shape shape3 = cornerBasedShape;
                                    BorderStroke borderStroke5 = i8 == 0 ? null : borderStroke2;
                                    if ((i3 & 128) == 0) {
                                        i17 = i13;
                                        i16 = i11;
                                        i15 = i20;
                                        selectableChipColors3 = ChipDefaults.INSTANCE.m1587filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, C.ENCODING_PCM_32BIT, 511);
                                        startRestartGroup = startRestartGroup;
                                        i21 &= -29360129;
                                    } else {
                                        i15 = i20;
                                        i16 = i11;
                                        i17 = i13;
                                        selectableChipColors3 = selectableChipColors2;
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function210 = i9 == 0 ? null : function2;
                                    Function2<? super Composer, ? super Integer, Unit> function211 = i16 == 0 ? null : function22;
                                    if (i17 == 0) {
                                        function25 = function211;
                                        z3 = z5;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        i18 = i21;
                                        borderStroke3 = borderStroke5;
                                        function24 = null;
                                    } else {
                                        function24 = function23;
                                        function25 = function211;
                                        z3 = z5;
                                        mutableInteractionSource3 = mutableInteractionSource2;
                                        i18 = i21;
                                        borderStroke3 = borderStroke5;
                                    }
                                    function26 = function210;
                                    selectableChipColors4 = selectableChipColors3;
                                    shape2 = shape3;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & 32) != 0) {
                                        i4 &= -458753;
                                    }
                                    if ((i3 & 128) != 0) {
                                        i4 &= -29360129;
                                    }
                                    function25 = function22;
                                    i18 = i4;
                                    i15 = i20;
                                    shape2 = cornerBasedShape;
                                    selectableChipColors4 = selectableChipColors2;
                                    companion = modifier2;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    function26 = function2;
                                    borderStroke3 = borderStroke2;
                                    function24 = function23;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1259208246, i18, i15, "androidx.compose.material.FilterChip (Chip.kt:197)");
                                }
                                int i22 = i18 << 3;
                                int i23 = ((i18 >> 9) & 14) | (i22 & 112) | ((i18 >> 15) & 896);
                                final State<Color> contentColor = selectableChipColors4.contentColor(z3, z, startRestartGroup, i23);
                                Shape shape4 = shape2;
                                final Function2<? super Composer, ? super Integer, Unit> function212 = function26;
                                final Function2<? super Composer, ? super Integer, Unit> function213 = function25;
                                final SelectableChipColors selectableChipColors6 = selectableChipColors4;
                                final Function2<? super Composer, ? super Integer, Unit> function214 = function24;
                                final boolean z6 = z3;
                                Modifier modifier4 = companion;
                                SurfaceKt.m1784SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$2
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
                                    }
                                }, 1, null), z6, shape4, selectableChipColors4.backgroundColor(z3, z, startRestartGroup, i23).getValue().m4073unboximpl(), Color.m4062copywmQWz5c$default(contentColor.getValue().m4073unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke3, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 722126431, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$3
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

                                    public final void invoke(Composer composer3, int i24) {
                                        ComposerKt.sourceInformation(composer3, "C211@9743L3950:Chip.kt#jmzs0o");
                                        if ((i24 & 11) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(722126431, i24, -1, "androidx.compose.material.FilterChip.<anonymous> (Chip.kt:211)");
                                            }
                                            ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(contentColor.getValue().m4073unboximpl())));
                                            final Function2<Composer, Integer, Unit> function215 = function212;
                                            final boolean z7 = z;
                                            final Function2<Composer, Integer, Unit> function216 = function213;
                                            final Function2<Composer, Integer, Unit> function217 = function214;
                                            final Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                            final SelectableChipColors selectableChipColors7 = selectableChipColors6;
                                            final boolean z8 = z6;
                                            final State<Color> state = contentColor;
                                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 1582291359, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$3.1
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

                                                public final void invoke(Composer composer4, int i25) {
                                                    ComposerKt.sourceInformation(composer4, "C213@9891L10,212@9835L3848:Chip.kt#jmzs0o");
                                                    if ((i25 & 11) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1582291359, i25, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous> (Chip.kt:212)");
                                                        }
                                                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2();
                                                        final Function2<Composer, Integer, Unit> function218 = function215;
                                                        final boolean z9 = z7;
                                                        final Function2<Composer, Integer, Unit> function219 = function216;
                                                        final Function2<Composer, Integer, Unit> function220 = function217;
                                                        final Function3<RowScope, Composer, Integer, Unit> function33 = function32;
                                                        final SelectableChipColors selectableChipColors8 = selectableChipColors7;
                                                        final boolean z10 = z8;
                                                        final State<Color> state2 = state;
                                                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer4, -1543702066, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.3.1.1
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

                                                            /* JADX WARN: Type inference failed for: r5v26 */
                                                            /* JADX WARN: Type inference failed for: r5v27, types: [boolean, int] */
                                                            /* JADX WARN: Type inference failed for: r5v40 */
                                                            public final void invoke(Composer composer5, int i26) {
                                                                float m6389constructorimpl;
                                                                float m6389constructorimpl2;
                                                                float f;
                                                                Function2<Composer, Integer, Unit> function221;
                                                                Function3<RowScope, Composer, Integer, Unit> function34;
                                                                float f2;
                                                                ?? r5;
                                                                float f3;
                                                                float f4;
                                                                float f5;
                                                                ComposerKt.sourceInformation(composer5, "C215@9940L3729:Chip.kt#jmzs0o");
                                                                if ((i26 & 11) != 2 || !composer5.getSkipping()) {
                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                        ComposerKt.traceEventStart(-1543702066, i26, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:215)");
                                                                    }
                                                                    Modifier m913defaultMinSizeVpY3zN4$default = SizeKt.m913defaultMinSizeVpY3zN4$default(IntrinsicKt.width(Modifier.INSTANCE, IntrinsicSize.Max), 0.0f, ChipDefaults.INSTANCE.m1589getMinHeightD9Ej5fM(), 1, null);
                                                                    if (function218 == null && (!z9 || function219 == null)) {
                                                                        m6389constructorimpl = ChipKt.HorizontalPadding;
                                                                    } else {
                                                                        m6389constructorimpl = Dp.m6389constructorimpl(0);
                                                                    }
                                                                    float f6 = m6389constructorimpl;
                                                                    if (function220 == null) {
                                                                        m6389constructorimpl2 = ChipKt.HorizontalPadding;
                                                                    } else {
                                                                        m6389constructorimpl2 = Dp.m6389constructorimpl(0);
                                                                    }
                                                                    Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(m913defaultMinSizeVpY3zN4$default, f6, 0.0f, m6389constructorimpl2, 0.0f, 10, null);
                                                                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                                    Function2<Composer, Integer, Unit> function222 = function218;
                                                                    boolean z11 = z9;
                                                                    Function2<Composer, Integer, Unit> function223 = function219;
                                                                    Function3<RowScope, Composer, Integer, Unit> function35 = function33;
                                                                    Function2<Composer, Integer, Unit> function224 = function220;
                                                                    SelectableChipColors selectableChipColors9 = selectableChipColors8;
                                                                    boolean z12 = z10;
                                                                    State<Color> state3 = state2;
                                                                    composer5.startReplaceableGroup(693286680);
                                                                    ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer5, 54);
                                                                    composer5.startReplaceableGroup(-1323940314);
                                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                                                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1943411941, "C278@13142L264:Chip.kt#jmzs0o");
                                                                    composer5.startReplaceableGroup(-1943411941);
                                                                    ComposerKt.sourceInformation(composer5, "239@11002L47,240@11074L1955,276@13054L45");
                                                                    if (function222 != null || (z11 && function223 != null)) {
                                                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                                                        f = ChipKt.LeadingIconStartSpacing;
                                                                        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f), composer5, 6);
                                                                        composer5.startReplaceableGroup(733328855);
                                                                        ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                                        Modifier.Companion companion3 = Modifier.INSTANCE;
                                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                                        composer5.startReplaceableGroup(-1323940314);
                                                                        ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                        CompositionLocalMap currentCompositionLocalMap2 = composer5.getCurrentCompositionLocalMap();
                                                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion3);
                                                                        function221 = function224;
                                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                                            ComposablesKt.invalidApplier();
                                                                        }
                                                                        composer5.startReusableNode();
                                                                        if (composer5.getInserting()) {
                                                                            composer5.createNode(constructor2);
                                                                        } else {
                                                                            composer5.useNode();
                                                                        }
                                                                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer5);
                                                                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                                        }
                                                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                                        composer5.startReplaceableGroup(2058660585);
                                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                        ComposerKt.sourceInformationMarkerStart(composer5, 649985791, "C:Chip.kt#jmzs0o");
                                                                        composer5.startReplaceableGroup(649985791);
                                                                        ComposerKt.sourceInformation(composer5, "242@11197L141,246@11371L297");
                                                                        if (function222 != null) {
                                                                            State<Color> leadingIconColor = selectableChipColors9.leadingIconColor(z12, z11, composer5, 0);
                                                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(leadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(leadingIconColor.getValue().m4073unboximpl())))}, function222, composer5, 8);
                                                                        }
                                                                        composer5.endReplaceableGroup();
                                                                        composer5.startReplaceableGroup(-1943411127);
                                                                        ComposerKt.sourceInformation(composer5, "265@12522L451");
                                                                        if (!z11 || function223 == null) {
                                                                            function34 = function35;
                                                                        } else {
                                                                            Modifier.Companion companion4 = Modifier.INSTANCE;
                                                                            long m4073unboximpl = state3.getValue().m4073unboximpl();
                                                                            composer5.startReplaceableGroup(649986622);
                                                                            ComposerKt.sourceInformation(composer5, "263@12415L34");
                                                                            if (function222 != null) {
                                                                                Modifier.Companion companion5 = Modifier.INSTANCE;
                                                                                f3 = ChipKt.SelectedIconContainerSize;
                                                                                function34 = function35;
                                                                                companion4 = ClipKt.clip(BackgroundKt.m526backgroundbw27NRU(SizeKt.m920requiredSize3ABfNKs(companion5, f3), state3.getValue().m4073unboximpl(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                                                                                r5 = 0;
                                                                                m4073unboximpl = selectableChipColors9.backgroundColor(z12, z11, composer5, 0).getValue().m4073unboximpl();
                                                                            } else {
                                                                                function34 = function35;
                                                                                r5 = 0;
                                                                            }
                                                                            composer5.endReplaceableGroup();
                                                                            Alignment center = Alignment.INSTANCE.getCenter();
                                                                            composer5.startReplaceableGroup(733328855);
                                                                            ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                                            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, r5, composer5, 6);
                                                                            composer5.startReplaceableGroup(-1323940314);
                                                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer5, r5);
                                                                            CompositionLocalMap currentCompositionLocalMap3 = composer5.getCurrentCompositionLocalMap();
                                                                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion4);
                                                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                                                ComposablesKt.invalidApplier();
                                                                            }
                                                                            composer5.startReusableNode();
                                                                            if (composer5.getInserting()) {
                                                                                composer5.createNode(constructor3);
                                                                            } else {
                                                                                composer5.useNode();
                                                                            }
                                                                            Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer5);
                                                                            Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                            Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                            if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                                                m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                                                m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                                                            }
                                                                            modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                                            composer5.startReplaceableGroup(2058660585);
                                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                                                            ComposerKt.sourceInformationMarkerStart(composer5, 333805307, "C269@12735L204:Chip.kt#jmzs0o");
                                                                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(m4073unboximpl)), function223, composer5, ProvidedValue.$stable);
                                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                            composer5.endReplaceableGroup();
                                                                            composer5.endNode();
                                                                            composer5.endReplaceableGroup();
                                                                            composer5.endReplaceableGroup();
                                                                        }
                                                                        composer5.endReplaceableGroup();
                                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                        composer5.endReplaceableGroup();
                                                                        composer5.endNode();
                                                                        composer5.endReplaceableGroup();
                                                                        composer5.endReplaceableGroup();
                                                                        Modifier.Companion companion6 = Modifier.INSTANCE;
                                                                        f2 = ChipKt.LeadingIconEndSpacing;
                                                                        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion6, f2), composer5, 6);
                                                                    } else {
                                                                        function34 = function35;
                                                                        function221 = function224;
                                                                    }
                                                                    composer5.endReplaceableGroup();
                                                                    Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                                    Arrangement.Horizontal start2 = Arrangement.INSTANCE.getStart();
                                                                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                                                    composer5.startReplaceableGroup(693286680);
                                                                    ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(start2, centerVertically2, composer5, 54);
                                                                    composer5.startReplaceableGroup(-1323940314);
                                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                    CompositionLocalMap currentCompositionLocalMap4 = composer5.getCurrentCompositionLocalMap();
                                                                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(weight$default);
                                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                                        ComposablesKt.invalidApplier();
                                                                    }
                                                                    composer5.startReusableNode();
                                                                    if (composer5.getInserting()) {
                                                                        composer5.createNode(constructor4);
                                                                    } else {
                                                                        composer5.useNode();
                                                                    }
                                                                    Composer m3593constructorimpl4 = Updater.m3593constructorimpl(composer5);
                                                                    Updater.m3600setimpl(m3593constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                    Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                    if (m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                                                        m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                                                        m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                                                    }
                                                                    modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                                    composer5.startReplaceableGroup(2058660585);
                                                                    ComposerKt.sourceInformationMarkerStart(composer5, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                                    function34.invoke(RowScopeInstance.INSTANCE, composer5, 6);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                    composer5.endReplaceableGroup();
                                                                    composer5.endNode();
                                                                    composer5.endReplaceableGroup();
                                                                    composer5.endReplaceableGroup();
                                                                    composer5.startReplaceableGroup(-1181292468);
                                                                    ComposerKt.sourceInformation(composer5, "285@13479L43,286@13547L14,287@13586L43");
                                                                    if (function221 != null) {
                                                                        Modifier.Companion companion7 = Modifier.INSTANCE;
                                                                        f4 = ChipKt.TrailingIconSpacing;
                                                                        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion7, f4), composer5, 6);
                                                                        function221.invoke(composer5, 0);
                                                                        Modifier.Companion companion8 = Modifier.INSTANCE;
                                                                        f5 = ChipKt.TrailingIconSpacing;
                                                                        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion8, f5), composer5, 6);
                                                                    }
                                                                    composer5.endReplaceableGroup();
                                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
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
                                }), startRestartGroup, (i18 & 7294) | ((i18 >> 3) & 57344) | (i22 & 29360128) | ((i18 << 15) & 1879048192), 6, 256);
                                composer2 = startRestartGroup;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                cornerBasedShape = shape4;
                                borderStroke4 = borderStroke3;
                                mutableInteractionSource4 = mutableInteractionSource3;
                                selectableChipColors5 = selectableChipColors6;
                                function27 = function212;
                                function28 = function213;
                                function29 = function214;
                                z4 = z6;
                                modifier3 = modifier4;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                mutableInteractionSource4 = mutableInteractionSource;
                                function28 = function22;
                                borderStroke4 = borderStroke2;
                                selectableChipColors5 = selectableChipColors2;
                                modifier3 = modifier2;
                                composer2 = startRestartGroup;
                                z4 = z3;
                                function27 = function2;
                                function29 = function23;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$4
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

                                    public final void invoke(Composer composer3, int i24) {
                                        ChipKt.FilterChip(z, function0, modifier3, z4, mutableInteractionSource4, cornerBasedShape, borderStroke4, selectableChipColors5, function27, function28, function29, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        int i202 = i14;
                        if ((i4 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if ((i3 & 32) != 0) {
                        }
                        int i212 = i4;
                        Shape shape32 = cornerBasedShape;
                        if (i8 == 0) {
                        }
                        if ((i3 & 128) == 0) {
                        }
                        if (i9 == 0) {
                        }
                        if (i16 == 0) {
                        }
                        if (i17 == 0) {
                        }
                        function26 = function210;
                        selectableChipColors4 = selectableChipColors3;
                        shape2 = shape32;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i222 = i18 << 3;
                        int i232 = ((i18 >> 9) & 14) | (i222 & 112) | ((i18 >> 15) & 896);
                        final State<Color> contentColor2 = selectableChipColors4.contentColor(z3, z, startRestartGroup, i232);
                        Shape shape42 = shape2;
                        final Function2<? super Composer, ? super Integer, Unit> function2122 = function26;
                        final Function2<? super Composer, ? super Integer, Unit> function2132 = function25;
                        final SelectableChipColors selectableChipColors62 = selectableChipColors4;
                        final Function2<? super Composer, ? super Integer, Unit> function2142 = function24;
                        final boolean z62 = z3;
                        Modifier modifier42 = companion;
                        SurfaceKt.m1784SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
                            }
                        }, 1, null), z62, shape42, selectableChipColors4.backgroundColor(z3, z, startRestartGroup, i232).getValue().m4073unboximpl(), Color.m4062copywmQWz5c$default(contentColor2.getValue().m4073unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke3, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 722126431, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$3
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

                            public final void invoke(Composer composer3, int i24) {
                                ComposerKt.sourceInformation(composer3, "C211@9743L3950:Chip.kt#jmzs0o");
                                if ((i24 & 11) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(722126431, i24, -1, "androidx.compose.material.FilterChip.<anonymous> (Chip.kt:211)");
                                    }
                                    ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(contentColor2.getValue().m4073unboximpl())));
                                    final Function2<? super Composer, ? super Integer, Unit> function215 = function2122;
                                    final boolean z7 = z;
                                    final Function2<? super Composer, ? super Integer, Unit> function216 = function2132;
                                    final Function2<? super Composer, ? super Integer, Unit> function217 = function2142;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                    final SelectableChipColors selectableChipColors7 = selectableChipColors62;
                                    final boolean z8 = z62;
                                    final State<Color> state = contentColor2;
                                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 1582291359, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$3.1
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

                                        public final void invoke(Composer composer4, int i25) {
                                            ComposerKt.sourceInformation(composer4, "C213@9891L10,212@9835L3848:Chip.kt#jmzs0o");
                                            if ((i25 & 11) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1582291359, i25, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous> (Chip.kt:212)");
                                                }
                                                TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2();
                                                final Function2<? super Composer, ? super Integer, Unit> function218 = function215;
                                                final boolean z9 = z7;
                                                final Function2<? super Composer, ? super Integer, Unit> function219 = function216;
                                                final Function2<? super Composer, ? super Integer, Unit> function220 = function217;
                                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                                final SelectableChipColors selectableChipColors8 = selectableChipColors7;
                                                final boolean z10 = z8;
                                                final State<Color> state2 = state;
                                                TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer4, -1543702066, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.3.1.1
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

                                                    /* JADX WARN: Type inference failed for: r5v26 */
                                                    /* JADX WARN: Type inference failed for: r5v27, types: [boolean, int] */
                                                    /* JADX WARN: Type inference failed for: r5v40 */
                                                    public final void invoke(Composer composer5, int i26) {
                                                        float m6389constructorimpl;
                                                        float m6389constructorimpl2;
                                                        float f;
                                                        Function2<Composer, Integer, Unit> function221;
                                                        Function3<RowScope, Composer, Integer, Unit> function34;
                                                        float f2;
                                                        ?? r5;
                                                        float f3;
                                                        float f4;
                                                        float f5;
                                                        ComposerKt.sourceInformation(composer5, "C215@9940L3729:Chip.kt#jmzs0o");
                                                        if ((i26 & 11) != 2 || !composer5.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1543702066, i26, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:215)");
                                                            }
                                                            Modifier m913defaultMinSizeVpY3zN4$default = SizeKt.m913defaultMinSizeVpY3zN4$default(IntrinsicKt.width(Modifier.INSTANCE, IntrinsicSize.Max), 0.0f, ChipDefaults.INSTANCE.m1589getMinHeightD9Ej5fM(), 1, null);
                                                            if (function218 == null && (!z9 || function219 == null)) {
                                                                m6389constructorimpl = ChipKt.HorizontalPadding;
                                                            } else {
                                                                m6389constructorimpl = Dp.m6389constructorimpl(0);
                                                            }
                                                            float f6 = m6389constructorimpl;
                                                            if (function220 == null) {
                                                                m6389constructorimpl2 = ChipKt.HorizontalPadding;
                                                            } else {
                                                                m6389constructorimpl2 = Dp.m6389constructorimpl(0);
                                                            }
                                                            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(m913defaultMinSizeVpY3zN4$default, f6, 0.0f, m6389constructorimpl2, 0.0f, 10, null);
                                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                            Function2<Composer, Integer, Unit> function222 = function218;
                                                            boolean z11 = z9;
                                                            Function2<Composer, Integer, Unit> function223 = function219;
                                                            Function3<RowScope, Composer, Integer, Unit> function35 = function33;
                                                            Function2<Composer, Integer, Unit> function224 = function220;
                                                            SelectableChipColors selectableChipColors9 = selectableChipColors8;
                                                            boolean z12 = z10;
                                                            State<Color> state3 = state2;
                                                            composer5.startReplaceableGroup(693286680);
                                                            ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer5, 54);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                                                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1943411941, "C278@13142L264:Chip.kt#jmzs0o");
                                                            composer5.startReplaceableGroup(-1943411941);
                                                            ComposerKt.sourceInformation(composer5, "239@11002L47,240@11074L1955,276@13054L45");
                                                            if (function222 != null || (z11 && function223 != null)) {
                                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                                f = ChipKt.LeadingIconStartSpacing;
                                                                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f), composer5, 6);
                                                                composer5.startReplaceableGroup(733328855);
                                                                ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                                composer5.startReplaceableGroup(-1323940314);
                                                                ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                                CompositionLocalMap currentCompositionLocalMap2 = composer5.getCurrentCompositionLocalMap();
                                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion3);
                                                                function221 = function224;
                                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                composer5.startReusableNode();
                                                                if (composer5.getInserting()) {
                                                                    composer5.createNode(constructor2);
                                                                } else {
                                                                    composer5.useNode();
                                                                }
                                                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer5);
                                                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                                }
                                                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                                composer5.startReplaceableGroup(2058660585);
                                                                ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart(composer5, 649985791, "C:Chip.kt#jmzs0o");
                                                                composer5.startReplaceableGroup(649985791);
                                                                ComposerKt.sourceInformation(composer5, "242@11197L141,246@11371L297");
                                                                if (function222 != null) {
                                                                    State<Color> leadingIconColor = selectableChipColors9.leadingIconColor(z12, z11, composer5, 0);
                                                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(leadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(leadingIconColor.getValue().m4073unboximpl())))}, function222, composer5, 8);
                                                                }
                                                                composer5.endReplaceableGroup();
                                                                composer5.startReplaceableGroup(-1943411127);
                                                                ComposerKt.sourceInformation(composer5, "265@12522L451");
                                                                if (!z11 || function223 == null) {
                                                                    function34 = function35;
                                                                } else {
                                                                    Modifier.Companion companion4 = Modifier.INSTANCE;
                                                                    long m4073unboximpl = state3.getValue().m4073unboximpl();
                                                                    composer5.startReplaceableGroup(649986622);
                                                                    ComposerKt.sourceInformation(composer5, "263@12415L34");
                                                                    if (function222 != null) {
                                                                        Modifier.Companion companion5 = Modifier.INSTANCE;
                                                                        f3 = ChipKt.SelectedIconContainerSize;
                                                                        function34 = function35;
                                                                        companion4 = ClipKt.clip(BackgroundKt.m526backgroundbw27NRU(SizeKt.m920requiredSize3ABfNKs(companion5, f3), state3.getValue().m4073unboximpl(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                                                                        r5 = 0;
                                                                        m4073unboximpl = selectableChipColors9.backgroundColor(z12, z11, composer5, 0).getValue().m4073unboximpl();
                                                                    } else {
                                                                        function34 = function35;
                                                                        r5 = 0;
                                                                    }
                                                                    composer5.endReplaceableGroup();
                                                                    Alignment center = Alignment.INSTANCE.getCenter();
                                                                    composer5.startReplaceableGroup(733328855);
                                                                    ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, r5, composer5, 6);
                                                                    composer5.startReplaceableGroup(-1323940314);
                                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer5, r5);
                                                                    CompositionLocalMap currentCompositionLocalMap3 = composer5.getCurrentCompositionLocalMap();
                                                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion4);
                                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                                        ComposablesKt.invalidApplier();
                                                                    }
                                                                    composer5.startReusableNode();
                                                                    if (composer5.getInserting()) {
                                                                        composer5.createNode(constructor3);
                                                                    } else {
                                                                        composer5.useNode();
                                                                    }
                                                                    Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer5);
                                                                    Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                    Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                    if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                                        m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                                        m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                                                    }
                                                                    modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                                    composer5.startReplaceableGroup(2058660585);
                                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                                                    ComposerKt.sourceInformationMarkerStart(composer5, 333805307, "C269@12735L204:Chip.kt#jmzs0o");
                                                                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(m4073unboximpl)), function223, composer5, ProvidedValue.$stable);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                    composer5.endReplaceableGroup();
                                                                    composer5.endNode();
                                                                    composer5.endReplaceableGroup();
                                                                    composer5.endReplaceableGroup();
                                                                }
                                                                composer5.endReplaceableGroup();
                                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                composer5.endReplaceableGroup();
                                                                composer5.endNode();
                                                                composer5.endReplaceableGroup();
                                                                composer5.endReplaceableGroup();
                                                                Modifier.Companion companion6 = Modifier.INSTANCE;
                                                                f2 = ChipKt.LeadingIconEndSpacing;
                                                                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion6, f2), composer5, 6);
                                                            } else {
                                                                function34 = function35;
                                                                function221 = function224;
                                                            }
                                                            composer5.endReplaceableGroup();
                                                            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                            Arrangement.Horizontal start2 = Arrangement.INSTANCE.getStart();
                                                            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                                            composer5.startReplaceableGroup(693286680);
                                                            ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(start2, centerVertically2, composer5, 54);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                            CompositionLocalMap currentCompositionLocalMap4 = composer5.getCurrentCompositionLocalMap();
                                                            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(weight$default);
                                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer5.startReusableNode();
                                                            if (composer5.getInserting()) {
                                                                composer5.createNode(constructor4);
                                                            } else {
                                                                composer5.useNode();
                                                            }
                                                            Composer m3593constructorimpl4 = Updater.m3593constructorimpl(composer5);
                                                            Updater.m3600setimpl(m3593constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                            if (m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                                                m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                                                m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                                            }
                                                            modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                            function34.invoke(RowScopeInstance.INSTANCE, composer5, 6);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            composer5.endReplaceableGroup();
                                                            composer5.endNode();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            composer5.startReplaceableGroup(-1181292468);
                                                            ComposerKt.sourceInformation(composer5, "285@13479L43,286@13547L14,287@13586L43");
                                                            if (function221 != null) {
                                                                Modifier.Companion companion7 = Modifier.INSTANCE;
                                                                f4 = ChipKt.TrailingIconSpacing;
                                                                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion7, f4), composer5, 6);
                                                                function221.invoke(composer5, 0);
                                                                Modifier.Companion companion8 = Modifier.INSTANCE;
                                                                f5 = ChipKt.TrailingIconSpacing;
                                                                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion8, f5), composer5, 6);
                                                            }
                                                            composer5.endReplaceableGroup();
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
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
                        }), startRestartGroup, (i18 & 7294) | ((i18 >> 3) & 57344) | (i222 & 29360128) | ((i18 << 15) & 1879048192), 6, 256);
                        composer2 = startRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        cornerBasedShape = shape42;
                        borderStroke4 = borderStroke3;
                        mutableInteractionSource4 = mutableInteractionSource3;
                        selectableChipColors5 = selectableChipColors62;
                        function27 = function2122;
                        function28 = function2132;
                        function29 = function2142;
                        z4 = z62;
                        modifier3 = modifier42;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i11 = i10;
                    i12 = i3 & 1024;
                    if (i12 != 0) {
                    }
                    if ((i3 & 2048) != 0) {
                    }
                    int i2022 = i14;
                    if ((i4 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i5 == 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i7 == 0) {
                    }
                    if ((i3 & 32) != 0) {
                    }
                    int i2122 = i4;
                    Shape shape322 = cornerBasedShape;
                    if (i8 == 0) {
                    }
                    if ((i3 & 128) == 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    if (i17 == 0) {
                    }
                    function26 = function210;
                    selectableChipColors4 = selectableChipColors3;
                    shape2 = shape322;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i2222 = i18 << 3;
                    int i2322 = ((i18 >> 9) & 14) | (i2222 & 112) | ((i18 >> 15) & 896);
                    final State<Color> contentColor22 = selectableChipColors4.contentColor(z3, z, startRestartGroup, i2322);
                    Shape shape422 = shape2;
                    final Function2<? super Composer, ? super Integer, Unit> function21222 = function26;
                    final Function2<? super Composer, ? super Integer, Unit> function21322 = function25;
                    final SelectableChipColors selectableChipColors622 = selectableChipColors4;
                    final Function2<? super Composer, ? super Integer, Unit> function21422 = function24;
                    final boolean z622 = z3;
                    Modifier modifier422 = companion;
                    SurfaceKt.m1784SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
                        }
                    }, 1, null), z622, shape422, selectableChipColors4.backgroundColor(z3, z, startRestartGroup, i2322).getValue().m4073unboximpl(), Color.m4062copywmQWz5c$default(contentColor22.getValue().m4073unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke3, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 722126431, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$3
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

                        public final void invoke(Composer composer3, int i24) {
                            ComposerKt.sourceInformation(composer3, "C211@9743L3950:Chip.kt#jmzs0o");
                            if ((i24 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(722126431, i24, -1, "androidx.compose.material.FilterChip.<anonymous> (Chip.kt:211)");
                                }
                                ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(contentColor22.getValue().m4073unboximpl())));
                                final Function2<? super Composer, ? super Integer, Unit> function215 = function21222;
                                final boolean z7 = z;
                                final Function2<? super Composer, ? super Integer, Unit> function216 = function21322;
                                final Function2<? super Composer, ? super Integer, Unit> function217 = function21422;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                final SelectableChipColors selectableChipColors7 = selectableChipColors622;
                                final boolean z8 = z622;
                                final State<Color> state = contentColor22;
                                CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 1582291359, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$3.1
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

                                    public final void invoke(Composer composer4, int i25) {
                                        ComposerKt.sourceInformation(composer4, "C213@9891L10,212@9835L3848:Chip.kt#jmzs0o");
                                        if ((i25 & 11) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1582291359, i25, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous> (Chip.kt:212)");
                                            }
                                            TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2();
                                            final Function2<? super Composer, ? super Integer, Unit> function218 = function215;
                                            final boolean z9 = z7;
                                            final Function2<? super Composer, ? super Integer, Unit> function219 = function216;
                                            final Function2<? super Composer, ? super Integer, Unit> function220 = function217;
                                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                            final SelectableChipColors selectableChipColors8 = selectableChipColors7;
                                            final boolean z10 = z8;
                                            final State<Color> state2 = state;
                                            TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer4, -1543702066, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.3.1.1
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

                                                /* JADX WARN: Type inference failed for: r5v26 */
                                                /* JADX WARN: Type inference failed for: r5v27, types: [boolean, int] */
                                                /* JADX WARN: Type inference failed for: r5v40 */
                                                public final void invoke(Composer composer5, int i26) {
                                                    float m6389constructorimpl;
                                                    float m6389constructorimpl2;
                                                    float f;
                                                    Function2<Composer, Integer, Unit> function221;
                                                    Function3<RowScope, Composer, Integer, Unit> function34;
                                                    float f2;
                                                    ?? r5;
                                                    float f3;
                                                    float f4;
                                                    float f5;
                                                    ComposerKt.sourceInformation(composer5, "C215@9940L3729:Chip.kt#jmzs0o");
                                                    if ((i26 & 11) != 2 || !composer5.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1543702066, i26, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:215)");
                                                        }
                                                        Modifier m913defaultMinSizeVpY3zN4$default = SizeKt.m913defaultMinSizeVpY3zN4$default(IntrinsicKt.width(Modifier.INSTANCE, IntrinsicSize.Max), 0.0f, ChipDefaults.INSTANCE.m1589getMinHeightD9Ej5fM(), 1, null);
                                                        if (function218 == null && (!z9 || function219 == null)) {
                                                            m6389constructorimpl = ChipKt.HorizontalPadding;
                                                        } else {
                                                            m6389constructorimpl = Dp.m6389constructorimpl(0);
                                                        }
                                                        float f6 = m6389constructorimpl;
                                                        if (function220 == null) {
                                                            m6389constructorimpl2 = ChipKt.HorizontalPadding;
                                                        } else {
                                                            m6389constructorimpl2 = Dp.m6389constructorimpl(0);
                                                        }
                                                        Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(m913defaultMinSizeVpY3zN4$default, f6, 0.0f, m6389constructorimpl2, 0.0f, 10, null);
                                                        Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                        Function2<Composer, Integer, Unit> function222 = function218;
                                                        boolean z11 = z9;
                                                        Function2<Composer, Integer, Unit> function223 = function219;
                                                        Function3<RowScope, Composer, Integer, Unit> function35 = function33;
                                                        Function2<Composer, Integer, Unit> function224 = function220;
                                                        SelectableChipColors selectableChipColors9 = selectableChipColors8;
                                                        boolean z12 = z10;
                                                        State<Color> state3 = state2;
                                                        composer5.startReplaceableGroup(693286680);
                                                        ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer5, 54);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                                                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1943411941, "C278@13142L264:Chip.kt#jmzs0o");
                                                        composer5.startReplaceableGroup(-1943411941);
                                                        ComposerKt.sourceInformation(composer5, "239@11002L47,240@11074L1955,276@13054L45");
                                                        if (function222 != null || (z11 && function223 != null)) {
                                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                                            f = ChipKt.LeadingIconStartSpacing;
                                                            SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f), composer5, 6);
                                                            composer5.startReplaceableGroup(733328855);
                                                            ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                            Modifier.Companion companion3 = Modifier.INSTANCE;
                                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                            CompositionLocalMap currentCompositionLocalMap2 = composer5.getCurrentCompositionLocalMap();
                                                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion3);
                                                            function221 = function224;
                                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer5.startReusableNode();
                                                            if (composer5.getInserting()) {
                                                                composer5.createNode(constructor2);
                                                            } else {
                                                                composer5.useNode();
                                                            }
                                                            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer5);
                                                            Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                            }
                                                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 649985791, "C:Chip.kt#jmzs0o");
                                                            composer5.startReplaceableGroup(649985791);
                                                            ComposerKt.sourceInformation(composer5, "242@11197L141,246@11371L297");
                                                            if (function222 != null) {
                                                                State<Color> leadingIconColor = selectableChipColors9.leadingIconColor(z12, z11, composer5, 0);
                                                                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(leadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(leadingIconColor.getValue().m4073unboximpl())))}, function222, composer5, 8);
                                                            }
                                                            composer5.endReplaceableGroup();
                                                            composer5.startReplaceableGroup(-1943411127);
                                                            ComposerKt.sourceInformation(composer5, "265@12522L451");
                                                            if (!z11 || function223 == null) {
                                                                function34 = function35;
                                                            } else {
                                                                Modifier.Companion companion4 = Modifier.INSTANCE;
                                                                long m4073unboximpl = state3.getValue().m4073unboximpl();
                                                                composer5.startReplaceableGroup(649986622);
                                                                ComposerKt.sourceInformation(composer5, "263@12415L34");
                                                                if (function222 != null) {
                                                                    Modifier.Companion companion5 = Modifier.INSTANCE;
                                                                    f3 = ChipKt.SelectedIconContainerSize;
                                                                    function34 = function35;
                                                                    companion4 = ClipKt.clip(BackgroundKt.m526backgroundbw27NRU(SizeKt.m920requiredSize3ABfNKs(companion5, f3), state3.getValue().m4073unboximpl(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                                                                    r5 = 0;
                                                                    m4073unboximpl = selectableChipColors9.backgroundColor(z12, z11, composer5, 0).getValue().m4073unboximpl();
                                                                } else {
                                                                    function34 = function35;
                                                                    r5 = 0;
                                                                }
                                                                composer5.endReplaceableGroup();
                                                                Alignment center = Alignment.INSTANCE.getCenter();
                                                                composer5.startReplaceableGroup(733328855);
                                                                ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, r5, composer5, 6);
                                                                composer5.startReplaceableGroup(-1323940314);
                                                                ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer5, r5);
                                                                CompositionLocalMap currentCompositionLocalMap3 = composer5.getCurrentCompositionLocalMap();
                                                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion4);
                                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                                    ComposablesKt.invalidApplier();
                                                                }
                                                                composer5.startReusableNode();
                                                                if (composer5.getInserting()) {
                                                                    composer5.createNode(constructor3);
                                                                } else {
                                                                    composer5.useNode();
                                                                }
                                                                Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer5);
                                                                Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                                Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                                if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                                    m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                                    m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                                                }
                                                                modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                                composer5.startReplaceableGroup(2058660585);
                                                                ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart(composer5, 333805307, "C269@12735L204:Chip.kt#jmzs0o");
                                                                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(m4073unboximpl)), function223, composer5, ProvidedValue.$stable);
                                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                                composer5.endReplaceableGroup();
                                                                composer5.endNode();
                                                                composer5.endReplaceableGroup();
                                                                composer5.endReplaceableGroup();
                                                            }
                                                            composer5.endReplaceableGroup();
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            composer5.endReplaceableGroup();
                                                            composer5.endNode();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                            Modifier.Companion companion6 = Modifier.INSTANCE;
                                                            f2 = ChipKt.LeadingIconEndSpacing;
                                                            SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion6, f2), composer5, 6);
                                                        } else {
                                                            function34 = function35;
                                                            function221 = function224;
                                                        }
                                                        composer5.endReplaceableGroup();
                                                        Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                        Arrangement.Horizontal start2 = Arrangement.INSTANCE.getStart();
                                                        Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                                        composer5.startReplaceableGroup(693286680);
                                                        ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(start2, centerVertically2, composer5, 54);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                        CompositionLocalMap currentCompositionLocalMap4 = composer5.getCurrentCompositionLocalMap();
                                                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(weight$default);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor4);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        Composer m3593constructorimpl4 = Updater.m3593constructorimpl(composer5);
                                                        Updater.m3600setimpl(m3593constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                                            m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                                            m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                                        }
                                                        modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                        function34.invoke(RowScopeInstance.INSTANCE, composer5, 6);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        composer5.startReplaceableGroup(-1181292468);
                                                        ComposerKt.sourceInformation(composer5, "285@13479L43,286@13547L14,287@13586L43");
                                                        if (function221 != null) {
                                                            Modifier.Companion companion7 = Modifier.INSTANCE;
                                                            f4 = ChipKt.TrailingIconSpacing;
                                                            SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion7, f4), composer5, 6);
                                                            function221.invoke(composer5, 0);
                                                            Modifier.Companion companion8 = Modifier.INSTANCE;
                                                            f5 = ChipKt.TrailingIconSpacing;
                                                            SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion8, f5), composer5, 6);
                                                        }
                                                        composer5.endReplaceableGroup();
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
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
                    }), startRestartGroup, (i18 & 7294) | ((i18 >> 3) & 57344) | (i2222 & 29360128) | ((i18 << 15) & 1879048192), 6, 256);
                    composer2 = startRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    cornerBasedShape = shape422;
                    borderStroke4 = borderStroke3;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    selectableChipColors5 = selectableChipColors622;
                    function27 = function21222;
                    function28 = function21322;
                    function29 = function21422;
                    z4 = z622;
                    modifier3 = modifier422;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z3 = z2;
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                if ((i & 458752) != 0) {
                }
                i8 = i3 & 64;
                if (i8 == 0) {
                }
                if ((i & 29360128) != 0) {
                }
                i9 = i3 & 256;
                if (i9 == 0) {
                }
                i10 = i3 & 512;
                if (i10 == 0) {
                }
                i11 = i10;
                i12 = i3 & 1024;
                if (i12 != 0) {
                }
                if ((i3 & 2048) != 0) {
                }
                int i20222 = i14;
                if ((i4 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i5 == 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if ((i3 & 32) != 0) {
                }
                int i21222 = i4;
                Shape shape3222 = cornerBasedShape;
                if (i8 == 0) {
                }
                if ((i3 & 128) == 0) {
                }
                if (i9 == 0) {
                }
                if (i16 == 0) {
                }
                if (i17 == 0) {
                }
                function26 = function210;
                selectableChipColors4 = selectableChipColors3;
                shape2 = shape3222;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i22222 = i18 << 3;
                int i23222 = ((i18 >> 9) & 14) | (i22222 & 112) | ((i18 >> 15) & 896);
                final State<Color> contentColor222 = selectableChipColors4.contentColor(z3, z, startRestartGroup, i23222);
                Shape shape4222 = shape2;
                final Function2<? super Composer, ? super Integer, Unit> function212222 = function26;
                final Function2<? super Composer, ? super Integer, Unit> function213222 = function25;
                final SelectableChipColors selectableChipColors6222 = selectableChipColors4;
                final Function2<? super Composer, ? super Integer, Unit> function214222 = function24;
                final boolean z6222 = z3;
                Modifier modifier4222 = companion;
                SurfaceKt.m1784SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
                    }
                }, 1, null), z6222, shape4222, selectableChipColors4.backgroundColor(z3, z, startRestartGroup, i23222).getValue().m4073unboximpl(), Color.m4062copywmQWz5c$default(contentColor222.getValue().m4073unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke3, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 722126431, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$3
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

                    public final void invoke(Composer composer3, int i24) {
                        ComposerKt.sourceInformation(composer3, "C211@9743L3950:Chip.kt#jmzs0o");
                        if ((i24 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(722126431, i24, -1, "androidx.compose.material.FilterChip.<anonymous> (Chip.kt:211)");
                            }
                            ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(contentColor222.getValue().m4073unboximpl())));
                            final Function2<? super Composer, ? super Integer, Unit> function215 = function212222;
                            final boolean z7 = z;
                            final Function2<? super Composer, ? super Integer, Unit> function216 = function213222;
                            final Function2<? super Composer, ? super Integer, Unit> function217 = function214222;
                            final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                            final SelectableChipColors selectableChipColors7 = selectableChipColors6222;
                            final boolean z8 = z6222;
                            final State<Color> state = contentColor222;
                            CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 1582291359, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$3.1
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

                                public final void invoke(Composer composer4, int i25) {
                                    ComposerKt.sourceInformation(composer4, "C213@9891L10,212@9835L3848:Chip.kt#jmzs0o");
                                    if ((i25 & 11) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1582291359, i25, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous> (Chip.kt:212)");
                                        }
                                        TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2();
                                        final Function2<? super Composer, ? super Integer, Unit> function218 = function215;
                                        final boolean z9 = z7;
                                        final Function2<? super Composer, ? super Integer, Unit> function219 = function216;
                                        final Function2<? super Composer, ? super Integer, Unit> function220 = function217;
                                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                        final SelectableChipColors selectableChipColors8 = selectableChipColors7;
                                        final boolean z10 = z8;
                                        final State<Color> state2 = state;
                                        TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer4, -1543702066, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.3.1.1
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

                                            /* JADX WARN: Type inference failed for: r5v26 */
                                            /* JADX WARN: Type inference failed for: r5v27, types: [boolean, int] */
                                            /* JADX WARN: Type inference failed for: r5v40 */
                                            public final void invoke(Composer composer5, int i26) {
                                                float m6389constructorimpl;
                                                float m6389constructorimpl2;
                                                float f;
                                                Function2<Composer, Integer, Unit> function221;
                                                Function3<RowScope, Composer, Integer, Unit> function34;
                                                float f2;
                                                ?? r5;
                                                float f3;
                                                float f4;
                                                float f5;
                                                ComposerKt.sourceInformation(composer5, "C215@9940L3729:Chip.kt#jmzs0o");
                                                if ((i26 & 11) != 2 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1543702066, i26, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:215)");
                                                    }
                                                    Modifier m913defaultMinSizeVpY3zN4$default = SizeKt.m913defaultMinSizeVpY3zN4$default(IntrinsicKt.width(Modifier.INSTANCE, IntrinsicSize.Max), 0.0f, ChipDefaults.INSTANCE.m1589getMinHeightD9Ej5fM(), 1, null);
                                                    if (function218 == null && (!z9 || function219 == null)) {
                                                        m6389constructorimpl = ChipKt.HorizontalPadding;
                                                    } else {
                                                        m6389constructorimpl = Dp.m6389constructorimpl(0);
                                                    }
                                                    float f6 = m6389constructorimpl;
                                                    if (function220 == null) {
                                                        m6389constructorimpl2 = ChipKt.HorizontalPadding;
                                                    } else {
                                                        m6389constructorimpl2 = Dp.m6389constructorimpl(0);
                                                    }
                                                    Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(m913defaultMinSizeVpY3zN4$default, f6, 0.0f, m6389constructorimpl2, 0.0f, 10, null);
                                                    Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                    Function2<Composer, Integer, Unit> function222 = function218;
                                                    boolean z11 = z9;
                                                    Function2<Composer, Integer, Unit> function223 = function219;
                                                    Function3<RowScope, Composer, Integer, Unit> function35 = function33;
                                                    Function2<Composer, Integer, Unit> function224 = function220;
                                                    SelectableChipColors selectableChipColors9 = selectableChipColors8;
                                                    boolean z12 = z10;
                                                    State<Color> state3 = state2;
                                                    composer5.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer5, 54);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1943411941, "C278@13142L264:Chip.kt#jmzs0o");
                                                    composer5.startReplaceableGroup(-1943411941);
                                                    ComposerKt.sourceInformation(composer5, "239@11002L47,240@11074L1955,276@13054L45");
                                                    if (function222 != null || (z11 && function223 != null)) {
                                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                                        f = ChipKt.LeadingIconStartSpacing;
                                                        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f), composer5, 6);
                                                        composer5.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        Modifier.Companion companion3 = Modifier.INSTANCE;
                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                        CompositionLocalMap currentCompositionLocalMap2 = composer5.getCurrentCompositionLocalMap();
                                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion3);
                                                        function221 = function224;
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor2);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer5);
                                                        Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                        }
                                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 649985791, "C:Chip.kt#jmzs0o");
                                                        composer5.startReplaceableGroup(649985791);
                                                        ComposerKt.sourceInformation(composer5, "242@11197L141,246@11371L297");
                                                        if (function222 != null) {
                                                            State<Color> leadingIconColor = selectableChipColors9.leadingIconColor(z12, z11, composer5, 0);
                                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(leadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(leadingIconColor.getValue().m4073unboximpl())))}, function222, composer5, 8);
                                                        }
                                                        composer5.endReplaceableGroup();
                                                        composer5.startReplaceableGroup(-1943411127);
                                                        ComposerKt.sourceInformation(composer5, "265@12522L451");
                                                        if (!z11 || function223 == null) {
                                                            function34 = function35;
                                                        } else {
                                                            Modifier.Companion companion4 = Modifier.INSTANCE;
                                                            long m4073unboximpl = state3.getValue().m4073unboximpl();
                                                            composer5.startReplaceableGroup(649986622);
                                                            ComposerKt.sourceInformation(composer5, "263@12415L34");
                                                            if (function222 != null) {
                                                                Modifier.Companion companion5 = Modifier.INSTANCE;
                                                                f3 = ChipKt.SelectedIconContainerSize;
                                                                function34 = function35;
                                                                companion4 = ClipKt.clip(BackgroundKt.m526backgroundbw27NRU(SizeKt.m920requiredSize3ABfNKs(companion5, f3), state3.getValue().m4073unboximpl(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                                                                r5 = 0;
                                                                m4073unboximpl = selectableChipColors9.backgroundColor(z12, z11, composer5, 0).getValue().m4073unboximpl();
                                                            } else {
                                                                function34 = function35;
                                                                r5 = 0;
                                                            }
                                                            composer5.endReplaceableGroup();
                                                            Alignment center = Alignment.INSTANCE.getCenter();
                                                            composer5.startReplaceableGroup(733328855);
                                                            ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, r5, composer5, 6);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer5, r5);
                                                            CompositionLocalMap currentCompositionLocalMap3 = composer5.getCurrentCompositionLocalMap();
                                                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion4);
                                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                                ComposablesKt.invalidApplier();
                                                            }
                                                            composer5.startReusableNode();
                                                            if (composer5.getInserting()) {
                                                                composer5.createNode(constructor3);
                                                            } else {
                                                                composer5.useNode();
                                                            }
                                                            Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer5);
                                                            Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                            if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                                m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                                m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                                            }
                                                            modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 333805307, "C269@12735L204:Chip.kt#jmzs0o");
                                                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(m4073unboximpl)), function223, composer5, ProvidedValue.$stable);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                                            composer5.endReplaceableGroup();
                                                            composer5.endNode();
                                                            composer5.endReplaceableGroup();
                                                            composer5.endReplaceableGroup();
                                                        }
                                                        composer5.endReplaceableGroup();
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                        Modifier.Companion companion6 = Modifier.INSTANCE;
                                                        f2 = ChipKt.LeadingIconEndSpacing;
                                                        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion6, f2), composer5, 6);
                                                    } else {
                                                        function34 = function35;
                                                        function221 = function224;
                                                    }
                                                    composer5.endReplaceableGroup();
                                                    Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                    Arrangement.Horizontal start2 = Arrangement.INSTANCE.getStart();
                                                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                                    composer5.startReplaceableGroup(693286680);
                                                    ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(start2, centerVertically2, composer5, 54);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap4 = composer5.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(weight$default);
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor4);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    Composer m3593constructorimpl4 = Updater.m3593constructorimpl(composer5);
                                                    Updater.m3600setimpl(m3593constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                                        m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                                        m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                                    }
                                                    modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                    function34.invoke(RowScopeInstance.INSTANCE, composer5, 6);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    composer5.endReplaceableGroup();
                                                    composer5.endNode();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    composer5.startReplaceableGroup(-1181292468);
                                                    ComposerKt.sourceInformation(composer5, "285@13479L43,286@13547L14,287@13586L43");
                                                    if (function221 != null) {
                                                        Modifier.Companion companion7 = Modifier.INSTANCE;
                                                        f4 = ChipKt.TrailingIconSpacing;
                                                        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion7, f4), composer5, 6);
                                                        function221.invoke(composer5, 0);
                                                        Modifier.Companion companion8 = Modifier.INSTANCE;
                                                        f5 = ChipKt.TrailingIconSpacing;
                                                        SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion8, f5), composer5, 6);
                                                    }
                                                    composer5.endReplaceableGroup();
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
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
                }), startRestartGroup, (i18 & 7294) | ((i18 >> 3) & 57344) | (i22222 & 29360128) | ((i18 << 15) & 1879048192), 6, 256);
                composer2 = startRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                }
                cornerBasedShape = shape4222;
                borderStroke4 = borderStroke3;
                mutableInteractionSource4 = mutableInteractionSource3;
                selectableChipColors5 = selectableChipColors6222;
                function27 = function212222;
                function28 = function213222;
                function29 = function214222;
                z4 = z6222;
                modifier3 = modifier4222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            z3 = z2;
            i7 = i3 & 16;
            if (i7 == 0) {
            }
            if ((i & 458752) != 0) {
            }
            i8 = i3 & 64;
            if (i8 == 0) {
            }
            if ((i & 29360128) != 0) {
            }
            i9 = i3 & 256;
            if (i9 == 0) {
            }
            i10 = i3 & 512;
            if (i10 == 0) {
            }
            i11 = i10;
            i12 = i3 & 1024;
            if (i12 != 0) {
            }
            if ((i3 & 2048) != 0) {
            }
            int i202222 = i14;
            if ((i4 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i5 == 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if ((i3 & 32) != 0) {
            }
            int i212222 = i4;
            Shape shape32222 = cornerBasedShape;
            if (i8 == 0) {
            }
            if ((i3 & 128) == 0) {
            }
            if (i9 == 0) {
            }
            if (i16 == 0) {
            }
            if (i17 == 0) {
            }
            function26 = function210;
            selectableChipColors4 = selectableChipColors3;
            shape2 = shape32222;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i222222 = i18 << 3;
            int i232222 = ((i18 >> 9) & 14) | (i222222 & 112) | ((i18 >> 15) & 896);
            final State<Color> contentColor2222 = selectableChipColors4.contentColor(z3, z, startRestartGroup, i232222);
            Shape shape42222 = shape2;
            final Function2<? super Composer, ? super Integer, Unit> function2122222 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function2132222 = function25;
            final SelectableChipColors selectableChipColors62222 = selectableChipColors4;
            final Function2<? super Composer, ? super Integer, Unit> function2142222 = function24;
            final boolean z62222 = z3;
            Modifier modifier42222 = companion;
            SurfaceKt.m1784SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
                }
            }, 1, null), z62222, shape42222, selectableChipColors4.backgroundColor(z3, z, startRestartGroup, i232222).getValue().m4073unboximpl(), Color.m4062copywmQWz5c$default(contentColor2222.getValue().m4073unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke3, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 722126431, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$3
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

                public final void invoke(Composer composer3, int i24) {
                    ComposerKt.sourceInformation(composer3, "C211@9743L3950:Chip.kt#jmzs0o");
                    if ((i24 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(722126431, i24, -1, "androidx.compose.material.FilterChip.<anonymous> (Chip.kt:211)");
                        }
                        ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(contentColor2222.getValue().m4073unboximpl())));
                        final Function2<? super Composer, ? super Integer, Unit> function215 = function2122222;
                        final boolean z7 = z;
                        final Function2<? super Composer, ? super Integer, Unit> function216 = function2132222;
                        final Function2<? super Composer, ? super Integer, Unit> function217 = function2142222;
                        final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        final SelectableChipColors selectableChipColors7 = selectableChipColors62222;
                        final boolean z8 = z62222;
                        final State<Color> state = contentColor2222;
                        CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 1582291359, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$3.1
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

                            public final void invoke(Composer composer4, int i25) {
                                ComposerKt.sourceInformation(composer4, "C213@9891L10,212@9835L3848:Chip.kt#jmzs0o");
                                if ((i25 & 11) != 2 || !composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1582291359, i25, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous> (Chip.kt:212)");
                                    }
                                    TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2();
                                    final Function2<? super Composer, ? super Integer, Unit> function218 = function215;
                                    final boolean z9 = z7;
                                    final Function2<? super Composer, ? super Integer, Unit> function219 = function216;
                                    final Function2<? super Composer, ? super Integer, Unit> function220 = function217;
                                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                    final SelectableChipColors selectableChipColors8 = selectableChipColors7;
                                    final boolean z10 = z8;
                                    final State<Color> state2 = state;
                                    TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer4, -1543702066, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.3.1.1
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

                                        /* JADX WARN: Type inference failed for: r5v26 */
                                        /* JADX WARN: Type inference failed for: r5v27, types: [boolean, int] */
                                        /* JADX WARN: Type inference failed for: r5v40 */
                                        public final void invoke(Composer composer5, int i26) {
                                            float m6389constructorimpl;
                                            float m6389constructorimpl2;
                                            float f;
                                            Function2<Composer, Integer, Unit> function221;
                                            Function3<RowScope, Composer, Integer, Unit> function34;
                                            float f2;
                                            ?? r5;
                                            float f3;
                                            float f4;
                                            float f5;
                                            ComposerKt.sourceInformation(composer5, "C215@9940L3729:Chip.kt#jmzs0o");
                                            if ((i26 & 11) != 2 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1543702066, i26, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:215)");
                                                }
                                                Modifier m913defaultMinSizeVpY3zN4$default = SizeKt.m913defaultMinSizeVpY3zN4$default(IntrinsicKt.width(Modifier.INSTANCE, IntrinsicSize.Max), 0.0f, ChipDefaults.INSTANCE.m1589getMinHeightD9Ej5fM(), 1, null);
                                                if (function218 == null && (!z9 || function219 == null)) {
                                                    m6389constructorimpl = ChipKt.HorizontalPadding;
                                                } else {
                                                    m6389constructorimpl = Dp.m6389constructorimpl(0);
                                                }
                                                float f6 = m6389constructorimpl;
                                                if (function220 == null) {
                                                    m6389constructorimpl2 = ChipKt.HorizontalPadding;
                                                } else {
                                                    m6389constructorimpl2 = Dp.m6389constructorimpl(0);
                                                }
                                                Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(m913defaultMinSizeVpY3zN4$default, f6, 0.0f, m6389constructorimpl2, 0.0f, 10, null);
                                                Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                                Function2<Composer, Integer, Unit> function222 = function218;
                                                boolean z11 = z9;
                                                Function2<Composer, Integer, Unit> function223 = function219;
                                                Function3<RowScope, Composer, Integer, Unit> function35 = function33;
                                                Function2<Composer, Integer, Unit> function224 = function220;
                                                SelectableChipColors selectableChipColors9 = selectableChipColors8;
                                                boolean z12 = z10;
                                                State<Color> state3 = state2;
                                                composer5.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer5, 54);
                                                composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                                                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer5, -1943411941, "C278@13142L264:Chip.kt#jmzs0o");
                                                composer5.startReplaceableGroup(-1943411941);
                                                ComposerKt.sourceInformation(composer5, "239@11002L47,240@11074L1955,276@13054L45");
                                                if (function222 != null || (z11 && function223 != null)) {
                                                    Modifier.Companion companion2 = Modifier.INSTANCE;
                                                    f = ChipKt.LeadingIconStartSpacing;
                                                    SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f), composer5, 6);
                                                    composer5.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap2 = composer5.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion3);
                                                    function221 = function224;
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor2);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer5);
                                                    Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                    }
                                                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 649985791, "C:Chip.kt#jmzs0o");
                                                    composer5.startReplaceableGroup(649985791);
                                                    ComposerKt.sourceInformation(composer5, "242@11197L141,246@11371L297");
                                                    if (function222 != null) {
                                                        State<Color> leadingIconColor = selectableChipColors9.leadingIconColor(z12, z11, composer5, 0);
                                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(leadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(leadingIconColor.getValue().m4073unboximpl())))}, function222, composer5, 8);
                                                    }
                                                    composer5.endReplaceableGroup();
                                                    composer5.startReplaceableGroup(-1943411127);
                                                    ComposerKt.sourceInformation(composer5, "265@12522L451");
                                                    if (!z11 || function223 == null) {
                                                        function34 = function35;
                                                    } else {
                                                        Modifier.Companion companion4 = Modifier.INSTANCE;
                                                        long m4073unboximpl = state3.getValue().m4073unboximpl();
                                                        composer5.startReplaceableGroup(649986622);
                                                        ComposerKt.sourceInformation(composer5, "263@12415L34");
                                                        if (function222 != null) {
                                                            Modifier.Companion companion5 = Modifier.INSTANCE;
                                                            f3 = ChipKt.SelectedIconContainerSize;
                                                            function34 = function35;
                                                            companion4 = ClipKt.clip(BackgroundKt.m526backgroundbw27NRU(SizeKt.m920requiredSize3ABfNKs(companion5, f3), state3.getValue().m4073unboximpl(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                                                            r5 = 0;
                                                            m4073unboximpl = selectableChipColors9.backgroundColor(z12, z11, composer5, 0).getValue().m4073unboximpl();
                                                        } else {
                                                            function34 = function35;
                                                            r5 = 0;
                                                        }
                                                        composer5.endReplaceableGroup();
                                                        Alignment center = Alignment.INSTANCE.getCenter();
                                                        composer5.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, r5, composer5, 6);
                                                        composer5.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer5, r5);
                                                        CompositionLocalMap currentCompositionLocalMap3 = composer5.getCurrentCompositionLocalMap();
                                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion4);
                                                        if (!(composer5.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer5.startReusableNode();
                                                        if (composer5.getInserting()) {
                                                            composer5.createNode(constructor3);
                                                        } else {
                                                            composer5.useNode();
                                                        }
                                                        Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer5);
                                                        Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                            m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                            m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                                        }
                                                        modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                        composer5.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer5, 333805307, "C269@12735L204:Chip.kt#jmzs0o");
                                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(m4073unboximpl)), function223, composer5, ProvidedValue.$stable);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        ComposerKt.sourceInformationMarkerEnd(composer5);
                                                        composer5.endReplaceableGroup();
                                                        composer5.endNode();
                                                        composer5.endReplaceableGroup();
                                                        composer5.endReplaceableGroup();
                                                    }
                                                    composer5.endReplaceableGroup();
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    composer5.endReplaceableGroup();
                                                    composer5.endNode();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                    Modifier.Companion companion6 = Modifier.INSTANCE;
                                                    f2 = ChipKt.LeadingIconEndSpacing;
                                                    SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion6, f2), composer5, 6);
                                                } else {
                                                    function34 = function35;
                                                    function221 = function224;
                                                }
                                                composer5.endReplaceableGroup();
                                                Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                                Arrangement.Horizontal start2 = Arrangement.INSTANCE.getStart();
                                                Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                                composer5.startReplaceableGroup(693286680);
                                                ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(start2, centerVertically2, composer5, 54);
                                                composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                CompositionLocalMap currentCompositionLocalMap4 = composer5.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(weight$default);
                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer5.startReusableNode();
                                                if (composer5.getInserting()) {
                                                    composer5.createNode(constructor4);
                                                } else {
                                                    composer5.useNode();
                                                }
                                                Composer m3593constructorimpl4 = Updater.m3593constructorimpl(composer5);
                                                Updater.m3600setimpl(m3593constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                                    m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                                    m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                                }
                                                modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                composer5.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer5, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                                function34.invoke(RowScopeInstance.INSTANCE, composer5, 6);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                composer5.endReplaceableGroup();
                                                composer5.endNode();
                                                composer5.endReplaceableGroup();
                                                composer5.endReplaceableGroup();
                                                composer5.startReplaceableGroup(-1181292468);
                                                ComposerKt.sourceInformation(composer5, "285@13479L43,286@13547L14,287@13586L43");
                                                if (function221 != null) {
                                                    Modifier.Companion companion7 = Modifier.INSTANCE;
                                                    f4 = ChipKt.TrailingIconSpacing;
                                                    SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion7, f4), composer5, 6);
                                                    function221.invoke(composer5, 0);
                                                    Modifier.Companion companion8 = Modifier.INSTANCE;
                                                    f5 = ChipKt.TrailingIconSpacing;
                                                    SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion8, f5), composer5, 6);
                                                }
                                                composer5.endReplaceableGroup();
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
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
            }), startRestartGroup, (i18 & 7294) | ((i18 >> 3) & 57344) | (i222222 & 29360128) | ((i18 << 15) & 1879048192), 6, 256);
            composer2 = startRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
            }
            cornerBasedShape = shape42222;
            borderStroke4 = borderStroke3;
            mutableInteractionSource4 = mutableInteractionSource3;
            selectableChipColors5 = selectableChipColors62222;
            function27 = function2122222;
            function28 = function2132222;
            function29 = function2142222;
            z4 = z62222;
            modifier3 = modifier42222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 8;
        if (i6 != 0) {
        }
        z3 = z2;
        i7 = i3 & 16;
        if (i7 == 0) {
        }
        if ((i & 458752) != 0) {
        }
        i8 = i3 & 64;
        if (i8 == 0) {
        }
        if ((i & 29360128) != 0) {
        }
        i9 = i3 & 256;
        if (i9 == 0) {
        }
        i10 = i3 & 512;
        if (i10 == 0) {
        }
        i11 = i10;
        i12 = i3 & 1024;
        if (i12 != 0) {
        }
        if ((i3 & 2048) != 0) {
        }
        int i2022222 = i14;
        if ((i4 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if ((i3 & 32) != 0) {
        }
        int i2122222 = i4;
        Shape shape322222 = cornerBasedShape;
        if (i8 == 0) {
        }
        if ((i3 & 128) == 0) {
        }
        if (i9 == 0) {
        }
        if (i16 == 0) {
        }
        if (i17 == 0) {
        }
        function26 = function210;
        selectableChipColors4 = selectableChipColors3;
        shape2 = shape322222;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i2222222 = i18 << 3;
        int i2322222 = ((i18 >> 9) & 14) | (i2222222 & 112) | ((i18 >> 15) & 896);
        final State<Color> contentColor22222 = selectableChipColors4.contentColor(z3, z, startRestartGroup, i2322222);
        Shape shape422222 = shape2;
        final Function2<? super Composer, ? super Integer, Unit> function21222222 = function26;
        final Function2<? super Composer, ? super Integer, Unit> function21322222 = function25;
        final SelectableChipColors selectableChipColors622222 = selectableChipColors4;
        final Function2<? super Composer, ? super Integer, Unit> function21422222 = function24;
        final boolean z622222 = z3;
        Modifier modifier422222 = companion;
        SurfaceKt.m1784SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.m5732setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m5717getCheckboxo7Vup1c());
            }
        }, 1, null), z622222, shape422222, selectableChipColors4.backgroundColor(z3, z, startRestartGroup, i2322222).getValue().m4073unboximpl(), Color.m4062copywmQWz5c$default(contentColor22222.getValue().m4073unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke3, 0.0f, mutableInteractionSource3, ComposableLambdaKt.composableLambda(startRestartGroup, 722126431, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$3
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

            public final void invoke(Composer composer3, int i24) {
                ComposerKt.sourceInformation(composer3, "C211@9743L3950:Chip.kt#jmzs0o");
                if ((i24 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(722126431, i24, -1, "androidx.compose.material.FilterChip.<anonymous> (Chip.kt:211)");
                    }
                    ProvidedValue<Float> provides = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(contentColor22222.getValue().m4073unboximpl())));
                    final Function2<? super Composer, ? super Integer, Unit> function215 = function21222222;
                    final boolean z7 = z;
                    final Function2<? super Composer, ? super Integer, Unit> function216 = function21322222;
                    final Function2<? super Composer, ? super Integer, Unit> function217 = function21422222;
                    final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    final SelectableChipColors selectableChipColors7 = selectableChipColors622222;
                    final boolean z8 = z622222;
                    final State<Color> state = contentColor22222;
                    CompositionLocalKt.CompositionLocalProvider(provides, ComposableLambdaKt.composableLambda(composer3, 1582291359, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt$FilterChip$3.1
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

                        public final void invoke(Composer composer4, int i25) {
                            ComposerKt.sourceInformation(composer4, "C213@9891L10,212@9835L3848:Chip.kt#jmzs0o");
                            if ((i25 & 11) != 2 || !composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1582291359, i25, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous> (Chip.kt:212)");
                                }
                                TextStyle body2 = MaterialTheme.INSTANCE.getTypography(composer4, 6).getBody2();
                                final Function2<? super Composer, ? super Integer, Unit> function218 = function215;
                                final boolean z9 = z7;
                                final Function2<? super Composer, ? super Integer, Unit> function219 = function216;
                                final Function2<? super Composer, ? super Integer, Unit> function220 = function217;
                                final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                                final SelectableChipColors selectableChipColors8 = selectableChipColors7;
                                final boolean z10 = z8;
                                final State<Color> state2 = state;
                                TextKt.ProvideTextStyle(body2, ComposableLambdaKt.composableLambda(composer4, -1543702066, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ChipKt.FilterChip.3.1.1
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

                                    /* JADX WARN: Type inference failed for: r5v26 */
                                    /* JADX WARN: Type inference failed for: r5v27, types: [boolean, int] */
                                    /* JADX WARN: Type inference failed for: r5v40 */
                                    public final void invoke(Composer composer5, int i26) {
                                        float m6389constructorimpl;
                                        float m6389constructorimpl2;
                                        float f;
                                        Function2<Composer, Integer, Unit> function221;
                                        Function3<RowScope, Composer, Integer, Unit> function34;
                                        float f2;
                                        ?? r5;
                                        float f3;
                                        float f4;
                                        float f5;
                                        ComposerKt.sourceInformation(composer5, "C215@9940L3729:Chip.kt#jmzs0o");
                                        if ((i26 & 11) != 2 || !composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1543702066, i26, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:215)");
                                            }
                                            Modifier m913defaultMinSizeVpY3zN4$default = SizeKt.m913defaultMinSizeVpY3zN4$default(IntrinsicKt.width(Modifier.INSTANCE, IntrinsicSize.Max), 0.0f, ChipDefaults.INSTANCE.m1589getMinHeightD9Ej5fM(), 1, null);
                                            if (function218 == null && (!z9 || function219 == null)) {
                                                m6389constructorimpl = ChipKt.HorizontalPadding;
                                            } else {
                                                m6389constructorimpl = Dp.m6389constructorimpl(0);
                                            }
                                            float f6 = m6389constructorimpl;
                                            if (function220 == null) {
                                                m6389constructorimpl2 = ChipKt.HorizontalPadding;
                                            } else {
                                                m6389constructorimpl2 = Dp.m6389constructorimpl(0);
                                            }
                                            Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(m913defaultMinSizeVpY3zN4$default, f6, 0.0f, m6389constructorimpl2, 0.0f, 10, null);
                                            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                            Function2<Composer, Integer, Unit> function222 = function218;
                                            boolean z11 = z9;
                                            Function2<Composer, Integer, Unit> function223 = function219;
                                            Function3<RowScope, Composer, Integer, Unit> function35 = function33;
                                            Function2<Composer, Integer, Unit> function224 = function220;
                                            SelectableChipColors selectableChipColors9 = selectableChipColors8;
                                            boolean z12 = z10;
                                            State<Color> state3 = state2;
                                            composer5.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer5, 54);
                                            composer5.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
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
                                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer5, -1943411941, "C278@13142L264:Chip.kt#jmzs0o");
                                            composer5.startReplaceableGroup(-1943411941);
                                            ComposerKt.sourceInformation(composer5, "239@11002L47,240@11074L1955,276@13054L45");
                                            if (function222 != null || (z11 && function223 != null)) {
                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                f = ChipKt.LeadingIconStartSpacing;
                                                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion2, f), composer5, 6);
                                                composer5.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                CompositionLocalMap currentCompositionLocalMap2 = composer5.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion3);
                                                function221 = function224;
                                                if (!(composer5.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer5.startReusableNode();
                                                if (composer5.getInserting()) {
                                                    composer5.createNode(constructor2);
                                                } else {
                                                    composer5.useNode();
                                                }
                                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer5);
                                                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                }
                                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                composer5.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer5, 649985791, "C:Chip.kt#jmzs0o");
                                                composer5.startReplaceableGroup(649985791);
                                                ComposerKt.sourceInformation(composer5, "242@11197L141,246@11371L297");
                                                if (function222 != null) {
                                                    State<Color> leadingIconColor = selectableChipColors9.leadingIconColor(z12, z11, composer5, 0);
                                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(leadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4065getAlphaimpl(leadingIconColor.getValue().m4073unboximpl())))}, function222, composer5, 8);
                                                }
                                                composer5.endReplaceableGroup();
                                                composer5.startReplaceableGroup(-1943411127);
                                                ComposerKt.sourceInformation(composer5, "265@12522L451");
                                                if (!z11 || function223 == null) {
                                                    function34 = function35;
                                                } else {
                                                    Modifier.Companion companion4 = Modifier.INSTANCE;
                                                    long m4073unboximpl = state3.getValue().m4073unboximpl();
                                                    composer5.startReplaceableGroup(649986622);
                                                    ComposerKt.sourceInformation(composer5, "263@12415L34");
                                                    if (function222 != null) {
                                                        Modifier.Companion companion5 = Modifier.INSTANCE;
                                                        f3 = ChipKt.SelectedIconContainerSize;
                                                        function34 = function35;
                                                        companion4 = ClipKt.clip(BackgroundKt.m526backgroundbw27NRU(SizeKt.m920requiredSize3ABfNKs(companion5, f3), state3.getValue().m4073unboximpl(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                                                        r5 = 0;
                                                        m4073unboximpl = selectableChipColors9.backgroundColor(z12, z11, composer5, 0).getValue().m4073unboximpl();
                                                    } else {
                                                        function34 = function35;
                                                        r5 = 0;
                                                    }
                                                    composer5.endReplaceableGroup();
                                                    Alignment center = Alignment.INSTANCE.getCenter();
                                                    composer5.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, r5, composer5, 6);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer5, r5);
                                                    CompositionLocalMap currentCompositionLocalMap3 = composer5.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion4);
                                                    if (!(composer5.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer5.startReusableNode();
                                                    if (composer5.getInserting()) {
                                                        composer5.createNode(constructor3);
                                                    } else {
                                                        composer5.useNode();
                                                    }
                                                    Composer m3593constructorimpl3 = Updater.m3593constructorimpl(composer5);
                                                    Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                                        m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                                        m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                                    }
                                                    modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 333805307, "C269@12735L204:Chip.kt#jmzs0o");
                                                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(m4073unboximpl)), function223, composer5, ProvidedValue.$stable);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    ComposerKt.sourceInformationMarkerEnd(composer5);
                                                    composer5.endReplaceableGroup();
                                                    composer5.endNode();
                                                    composer5.endReplaceableGroup();
                                                    composer5.endReplaceableGroup();
                                                }
                                                composer5.endReplaceableGroup();
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                ComposerKt.sourceInformationMarkerEnd(composer5);
                                                composer5.endReplaceableGroup();
                                                composer5.endNode();
                                                composer5.endReplaceableGroup();
                                                composer5.endReplaceableGroup();
                                                Modifier.Companion companion6 = Modifier.INSTANCE;
                                                f2 = ChipKt.LeadingIconEndSpacing;
                                                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion6, f2), composer5, 6);
                                            } else {
                                                function34 = function35;
                                                function221 = function224;
                                            }
                                            composer5.endReplaceableGroup();
                                            Modifier weight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                                            Arrangement.Horizontal start2 = Arrangement.INSTANCE.getStart();
                                            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                                            composer5.startReplaceableGroup(693286680);
                                            ComposerKt.sourceInformation(composer5, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(start2, centerVertically2, composer5, 54);
                                            composer5.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                            CompositionLocalMap currentCompositionLocalMap4 = composer5.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(weight$default);
                                            if (!(composer5.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer5.startReusableNode();
                                            if (composer5.getInserting()) {
                                                composer5.createNode(constructor4);
                                            } else {
                                                composer5.useNode();
                                            }
                                            Composer m3593constructorimpl4 = Updater.m3593constructorimpl(composer5);
                                            Updater.m3600setimpl(m3593constructorimpl4, rowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                                                m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                                                m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                                            }
                                            modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                            composer5.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer5, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                            function34.invoke(RowScopeInstance.INSTANCE, composer5, 6);
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
                                            composer5.endReplaceableGroup();
                                            composer5.endNode();
                                            composer5.endReplaceableGroup();
                                            composer5.endReplaceableGroup();
                                            composer5.startReplaceableGroup(-1181292468);
                                            ComposerKt.sourceInformation(composer5, "285@13479L43,286@13547L14,287@13586L43");
                                            if (function221 != null) {
                                                Modifier.Companion companion7 = Modifier.INSTANCE;
                                                f4 = ChipKt.TrailingIconSpacing;
                                                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion7, f4), composer5, 6);
                                                function221.invoke(composer5, 0);
                                                Modifier.Companion companion8 = Modifier.INSTANCE;
                                                f5 = ChipKt.TrailingIconSpacing;
                                                SpacerKt.Spacer(SizeKt.m933width3ABfNKs(companion8, f5), composer5, 6);
                                            }
                                            composer5.endReplaceableGroup();
                                            ComposerKt.sourceInformationMarkerEnd(composer5);
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
        }), startRestartGroup, (i18 & 7294) | ((i18 >> 3) & 57344) | (i2222222 & 29360128) | ((i18 << 15) & 1879048192), 6, 256);
        composer2 = startRestartGroup;
        if (ComposerKt.isTraceInProgress()) {
        }
        cornerBasedShape = shape422222;
        borderStroke4 = borderStroke3;
        mutableInteractionSource4 = mutableInteractionSource3;
        selectableChipColors5 = selectableChipColors622222;
        function27 = function21222222;
        function28 = function21322222;
        function29 = function21422222;
        z4 = z622222;
        modifier3 = modifier422222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Chip$lambda$1(State<Color> state) {
        return state.getValue().m4073unboximpl();
    }

    static {
        float f = 8;
        LeadingIconEndSpacing = Dp.m6389constructorimpl(f);
        TrailingIconSpacing = Dp.m6389constructorimpl(f);
    }
}
