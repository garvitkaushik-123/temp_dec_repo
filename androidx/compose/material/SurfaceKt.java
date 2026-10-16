package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Surface.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a©\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001ac\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u008d\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00142\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u0093\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00142\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010'\u001a,\u0010(\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u000eH\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a8\u0010.\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "content", "Landroidx/compose/runtime/Composable;", "Surface-9VG74zQ", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Surface-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-Ny5ogXk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "absoluteElevation", "surfaceColorAtElevation-cq6XJ1M", "(JLandroidx/compose/material/ElevationOverlay;FLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SurfaceKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0087  */
    /* renamed from: Surface-F-jzlyU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1782SurfaceFjzlyU(Modifier modifier, Shape shape, long j, long j2, BorderStroke borderStroke, float f, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        long j3;
        long j4;
        int i4;
        BorderStroke borderStroke2;
        int i5;
        float f2;
        final float m6389constructorimpl;
        final long j5;
        final Shape shape3;
        final BorderStroke borderStroke3;
        final float f3;
        ScopeUpdateScope endRestartGroup;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(1412203386);
        ComposerKt.sourceInformation(startRestartGroup, "C(Surface)P(5,6,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp)107@5308L6,108@5350L22,*113@5525L7,114@5549L894:Surface.kt#jmzs0o");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            shape2 = shape;
            i3 |= startRestartGroup.changed(shape2) ? 32 : 16;
            if ((i & 896) != 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i7 = 256;
                        i3 |= i7;
                    }
                } else {
                    j3 = j;
                }
                i7 = 128;
                i3 |= i7;
            } else {
                j3 = j;
            }
            if ((i & 7168) != 0) {
                if ((i2 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i6 = 2048;
                        i3 |= i6;
                    }
                } else {
                    j4 = j2;
                }
                i6 = 1024;
                i3 |= i6;
            } else {
                j4 = j2;
            }
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 24576;
            } else if ((57344 & i) == 0) {
                borderStroke2 = borderStroke;
                i3 |= startRestartGroup.changed(borderStroke2) ? 16384 : 8192;
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    f2 = f;
                } else {
                    f2 = f;
                    if ((i & 458752) == 0) {
                        i3 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                    }
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 3670016) == 0) {
                    i3 |= startRestartGroup.changedInstance(function2) ? 1048576 : 524288;
                }
                if ((i3 & 2995931) == 599186 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i9 != 0) {
                            shape2 = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            j3 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            j4 = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            borderStroke2 = null;
                        }
                        if (i5 != 0) {
                            m6389constructorimpl = Dp.m6389constructorimpl(0);
                            final Modifier modifier3 = modifier2;
                            final Shape shape4 = shape2;
                            j5 = j3;
                            final BorderStroke borderStroke4 = borderStroke2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1412203386, i3, -1, "androidx.compose.material.Surface (Surface.kt:112)");
                            }
                            ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(localAbsoluteElevation);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final float m6389constructorimpl2 = Dp.m6389constructorimpl(((Dp) consume).m6403unboximpl() + m6389constructorimpl);
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl2))}, ComposableLambdaKt.composableLambda(startRestartGroup, -1822160838, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i10) {
                                    long m1789surfaceColorAtElevationcq6XJ1M;
                                    Modifier m1788surface8ww4TTg;
                                    ComposerKt.sourceInformation(composer2, "C124@5963L7,122@5834L221,118@5698L739:Surface.kt#jmzs0o");
                                    if ((i10 & 11) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1822160838, i10, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:118)");
                                        }
                                        Modifier modifier4 = Modifier.this;
                                        Shape shape5 = shape4;
                                        long j6 = j5;
                                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume2 = composer2.consume(localElevationOverlay);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j6, (ElevationOverlay) consume2, m6389constructorimpl2, composer2, 0);
                                        m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(modifier4, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke4, m6389constructorimpl);
                                        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(m1788surface8ww4TTg, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                invoke2(semanticsPropertyReceiver);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
                                            }
                                        }), Unit.INSTANCE, new AnonymousClass2(null));
                                        Function2<Composer, Integer, Unit> function22 = function2;
                                        composer2.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                                        composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(pointerInput);
                                        if (!(composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer2.startReusableNode();
                                        if (composer2.getInserting()) {
                                            composer2.createNode(constructor);
                                        } else {
                                            composer2.useNode();
                                        }
                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                        composer2.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer2, 1505970093, "C137@6418L9:Surface.kt#jmzs0o");
                                        function22.invoke(composer2, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endReplaceableGroup();
                                        composer2.endNode();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }

                                /* compiled from: Surface.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                @DebugMetadata(c = "androidx.compose.material.SurfaceKt$Surface$1$2", f = "Surface.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                                /* renamed from: androidx.compose.material.SurfaceKt$Surface$1$2, reason: invalid class name */
                                static final class AnonymousClass2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                                    int label;

                                    AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                                        super(2, continuation);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass2(continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        if (this.label != 0) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                        return Unit.INSTANCE;
                                    }
                                }
                            }), startRestartGroup, 56);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = modifier3;
                            shape3 = shape4;
                            borderStroke3 = borderStroke4;
                            f3 = m6389constructorimpl;
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
                    m6389constructorimpl = f2;
                    final Modifier modifier32 = modifier2;
                    final Shape shape42 = shape2;
                    j5 = j3;
                    final BorderStroke borderStroke42 = borderStroke2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation2 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2 = startRestartGroup.consume(localAbsoluteElevation2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final float m6389constructorimpl22 = Dp.m6389constructorimpl(((Dp) consume2).m6403unboximpl() + m6389constructorimpl);
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl22))}, ComposableLambdaKt.composableLambda(startRestartGroup, -1822160838, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i10) {
                            long m1789surfaceColorAtElevationcq6XJ1M;
                            Modifier m1788surface8ww4TTg;
                            ComposerKt.sourceInformation(composer2, "C124@5963L7,122@5834L221,118@5698L739:Surface.kt#jmzs0o");
                            if ((i10 & 11) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1822160838, i10, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:118)");
                                }
                                Modifier modifier4 = Modifier.this;
                                Shape shape5 = shape42;
                                long j6 = j5;
                                ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume22 = composer2.consume(localElevationOverlay);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j6, (ElevationOverlay) consume22, m6389constructorimpl22, composer2, 0);
                                m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(modifier4, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke42, m6389constructorimpl);
                                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(m1788surface8ww4TTg, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        invoke2(semanticsPropertyReceiver);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
                                    }
                                }), Unit.INSTANCE, new AnonymousClass2(null));
                                Function2<Composer, Integer, Unit> function22 = function2;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(pointerInput);
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, 1505970093, "C137@6418L9:Surface.kt#jmzs0o");
                                function22.invoke(composer2, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }

                        /* compiled from: Surface.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material.SurfaceKt$Surface$1$2", f = "Surface.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                        /* renamed from: androidx.compose.material.SurfaceKt$Surface$1$2, reason: invalid class name */
                        static final class AnonymousClass2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                            int label;

                            AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                                super(2, continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass2(continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                if (this.label != 0) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                        }
                    }), startRestartGroup, 56);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = modifier32;
                    shape3 = shape42;
                    borderStroke3 = borderStroke42;
                    f3 = m6389constructorimpl;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    shape3 = shape2;
                    j5 = j3;
                    borderStroke3 = borderStroke2;
                    f3 = f2;
                }
                final long j6 = j4;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier2;
                    final long j7 = j5;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i10) {
                            SurfaceKt.m1782SurfaceFjzlyU(Modifier.this, shape3, j7, j6, borderStroke3, f3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            borderStroke2 = borderStroke;
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            if ((i3 & 2995931) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            m6389constructorimpl = f2;
            final Modifier modifier322 = modifier2;
            final Shape shape422 = shape2;
            j5 = j3;
            final BorderStroke borderStroke422 = borderStroke2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Dp> localAbsoluteElevation22 = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume22 = startRestartGroup.consume(localAbsoluteElevation22);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final float m6389constructorimpl222 = Dp.m6389constructorimpl(((Dp) consume22).m6403unboximpl() + m6389constructorimpl);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl222))}, ComposableLambdaKt.composableLambda(startRestartGroup, -1822160838, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i10) {
                    long m1789surfaceColorAtElevationcq6XJ1M;
                    Modifier m1788surface8ww4TTg;
                    ComposerKt.sourceInformation(composer2, "C124@5963L7,122@5834L221,118@5698L739:Surface.kt#jmzs0o");
                    if ((i10 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1822160838, i10, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:118)");
                        }
                        Modifier modifier42 = Modifier.this;
                        Shape shape5 = shape422;
                        long j62 = j5;
                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume222 = composer2.consume(localElevationOverlay);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j62, (ElevationOverlay) consume222, m6389constructorimpl222, composer2, 0);
                        m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(modifier42, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke422, m6389constructorimpl);
                        Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(m1788surface8ww4TTg, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
                            }
                        }), Unit.INSTANCE, new AnonymousClass2(null));
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(pointerInput);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1505970093, "C137@6418L9:Surface.kt#jmzs0o");
                        function22.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }

                /* compiled from: Surface.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material.SurfaceKt$Surface$1$2", f = "Surface.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: androidx.compose.material.SurfaceKt$Surface$1$2, reason: invalid class name */
                static final class AnonymousClass2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                    int label;

                    AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass2(continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                }
            }), startRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier322;
            shape3 = shape422;
            borderStroke3 = borderStroke422;
            f3 = m6389constructorimpl;
            final long j62 = j4;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        shape2 = shape;
        if ((i & 896) != 0) {
        }
        if ((i & 7168) != 0) {
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        borderStroke2 = borderStroke;
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        if ((i3 & 2995931) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        m6389constructorimpl = f2;
        final Modifier modifier3222 = modifier2;
        final Shape shape4222 = shape2;
        j5 = j3;
        final BorderStroke borderStroke4222 = borderStroke2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Dp> localAbsoluteElevation222 = ElevationOverlayKt.getLocalAbsoluteElevation();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume222 = startRestartGroup.consume(localAbsoluteElevation222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final float m6389constructorimpl2222 = Dp.m6389constructorimpl(((Dp) consume222).m6403unboximpl() + m6389constructorimpl);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl2222))}, ComposableLambdaKt.composableLambda(startRestartGroup, -1822160838, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i10) {
                long m1789surfaceColorAtElevationcq6XJ1M;
                Modifier m1788surface8ww4TTg;
                ComposerKt.sourceInformation(composer2, "C124@5963L7,122@5834L221,118@5698L739:Surface.kt#jmzs0o");
                if ((i10 & 11) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1822160838, i10, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:118)");
                    }
                    Modifier modifier42 = Modifier.this;
                    Shape shape5 = shape4222;
                    long j622 = j5;
                    ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2222 = composer2.consume(localElevationOverlay);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j622, (ElevationOverlay) consume2222, m6389constructorimpl2222, composer2, 0);
                    m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(modifier42, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke4222, m6389constructorimpl);
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(m1788surface8ww4TTg, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
                        }
                    }), Unit.INSTANCE, new AnonymousClass2(null));
                    Function2<Composer, Integer, Unit> function22 = function2;
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(pointerInput);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1505970093, "C137@6418L9:Surface.kt#jmzs0o");
                    function22.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }

            /* compiled from: Surface.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material.SurfaceKt$Surface$1$2", f = "Surface.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material.SurfaceKt$Surface$1$2, reason: invalid class name */
            static final class AnonymousClass2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                int label;

                AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
            }
        }), startRestartGroup, 56);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier3222;
        shape3 = shape4222;
        borderStroke3 = borderStroke4222;
        f3 = m6389constructorimpl;
        final long j622 = j4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0216  */
    /* renamed from: Surface-LPr_se0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1783SurfaceLPr_se0(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        Shape shape2;
        long j3;
        int i6;
        long j4;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        final MutableInteractionSource mutableInteractionSource2;
        final BorderStroke borderStroke2;
        final float f2;
        final Modifier modifier3;
        final long j5;
        final Modifier modifier4;
        final Shape shape3;
        final long j6;
        final BorderStroke borderStroke3;
        final float f3;
        final MutableInteractionSource mutableInteractionSource3;
        final boolean z3;
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(1560876237);
        ComposerKt.sourceInformation(startRestartGroup, "C(Surface)P(8,7,5,9,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)216@10794L6,217@10836L22,220@10970L39,*223@11102L7,224@11126L982:Surface.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i15 = i2 & 2;
        if (i15 != 0) {
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
                    shape2 = shape;
                    i3 |= startRestartGroup.changed(shape2) ? 2048 : 1024;
                    if ((57344 & i) != 0) {
                        if ((i2 & 16) == 0) {
                            j3 = j;
                            if (startRestartGroup.changed(j3)) {
                                i14 = 16384;
                                i3 |= i14;
                            }
                        } else {
                            j3 = j;
                        }
                        i14 = 8192;
                        i3 |= i14;
                    } else {
                        j3 = j;
                    }
                    if ((458752 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            i12 = i3;
                            j4 = j2;
                            if (startRestartGroup.changed(j4)) {
                                i13 = 131072;
                                i6 = i12 | i13;
                            }
                        } else {
                            i12 = i3;
                            j4 = j2;
                        }
                        i13 = 65536;
                        i6 = i12 | i13;
                    } else {
                        i6 = i3;
                        j4 = j2;
                    }
                    i7 = i2 & 64;
                    if (i7 == 0) {
                        i6 |= 1572864;
                    } else if ((i & 3670016) == 0) {
                        i6 |= startRestartGroup.changed(borderStroke) ? 1048576 : 524288;
                    }
                    i8 = i2 & 128;
                    if (i8 == 0) {
                        i6 |= 12582912;
                    } else if ((i & 29360128) == 0) {
                        i9 = i8;
                        i6 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
                        i10 = i2 & 256;
                        if (i10 != 0) {
                            i6 |= 100663296;
                        } else if ((i & 234881024) == 0) {
                            i11 = i10;
                            i6 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                            if ((i2 & 512) == 0) {
                                i6 |= C.ENCODING_PCM_32BIT;
                            } else if ((1879048192 & i) == 0) {
                                i6 |= startRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                                if ((i6 & 1533916891) == 306783378 || !startRestartGroup.getSkipping()) {
                                    startRestartGroup.startDefaults();
                                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        if (i15 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i4 != 0) {
                                            z2 = true;
                                        }
                                        if (i5 != 0) {
                                            shape2 = RectangleShapeKt.getRectangleShape();
                                        }
                                        if ((i2 & 16) != 0) {
                                            j3 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                                            i6 &= -57345;
                                        }
                                        if ((i2 & 32) != 0) {
                                            j4 = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i6 >> 12) & 14);
                                            i6 &= -458753;
                                        }
                                        BorderStroke borderStroke4 = i7 != 0 ? null : borderStroke;
                                        float m6389constructorimpl = i9 != 0 ? Dp.m6389constructorimpl(0) : f;
                                        if (i11 != 0) {
                                            startRestartGroup.startReplaceableGroup(-492369756);
                                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                            Object rememberedValue = startRestartGroup.rememberedValue();
                                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            borderStroke2 = borderStroke4;
                                            f2 = m6389constructorimpl;
                                            modifier3 = modifier2;
                                            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                            final boolean z4 = z2;
                                            final Shape shape4 = shape2;
                                            final long j7 = j3;
                                            startRestartGroup.endDefaults();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1560876237, i6, -1, "androidx.compose.material.Surface (Surface.kt:222)");
                                            }
                                            ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                            Object consume = startRestartGroup.consume(localAbsoluteElevation);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            final float m6389constructorimpl2 = Dp.m6389constructorimpl(((Dp) consume).m6403unboximpl() + f2);
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl2))}, ComposableLambdaKt.composableLambda(startRestartGroup, 2031491085, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$4
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                                    invoke(composer2, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer2, int i16) {
                                                    long m1789surfaceColorAtElevationcq6XJ1M;
                                                    Modifier m1788surface8ww4TTg;
                                                    ComposerKt.sourceInformation(composer2, "C235@11591L7,233@11462L221,243@11902L16,228@11275L827:Surface.kt#jmzs0o");
                                                    if ((i16 & 11) != 2 || !composer2.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(2031491085, i16, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:228)");
                                                        }
                                                        Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                                                        Shape shape5 = shape4;
                                                        long j8 = j7;
                                                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                                                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                        Object consume2 = composer2.consume(localElevationOverlay);
                                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                                        m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j8, (ElevationOverlay) consume2, m6389constructorimpl2, composer2, 0);
                                                        m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke2, f2);
                                                        Modifier m559clickableO2vRcR0$default = ClickableKt.m559clickableO2vRcR0$default(m1788surface8ww4TTg, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z4, null, null, function0, 24, null);
                                                        Function2<Composer, Integer, Unit> function22 = function2;
                                                        composer2.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                                                        composer2.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m559clickableO2vRcR0$default);
                                                        if (!(composer2.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer2.startReusableNode();
                                                        if (composer2.getInserting()) {
                                                            composer2.createNode(constructor);
                                                        } else {
                                                            composer2.useNode();
                                                        }
                                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                        }
                                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                                        composer2.startReplaceableGroup(2058660585);
                                                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer2, 1505975758, "C249@12083L9:Surface.kt#jmzs0o");
                                                        function22.invoke(composer2, 0);
                                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                                        composer2.endReplaceableGroup();
                                                        composer2.endNode();
                                                        composer2.endReplaceableGroup();
                                                        composer2.endReplaceableGroup();
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer2.skipToGroupEnd();
                                                }
                                            }), startRestartGroup, 56);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            j5 = j4;
                                            modifier4 = modifier3;
                                            shape3 = shape4;
                                            j6 = j7;
                                            borderStroke3 = borderStroke2;
                                            f3 = f2;
                                            mutableInteractionSource3 = mutableInteractionSource2;
                                            z3 = z4;
                                        } else {
                                            mutableInteractionSource2 = mutableInteractionSource;
                                            borderStroke2 = borderStroke4;
                                            f2 = m6389constructorimpl;
                                        }
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i2 & 16) != 0) {
                                            i6 &= -57345;
                                        }
                                        if ((i2 & 32) != 0) {
                                            i6 &= -458753;
                                        }
                                        borderStroke2 = borderStroke;
                                        f2 = f;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                    }
                                    modifier3 = modifier2;
                                    final boolean z42 = z2;
                                    final Shape shape42 = shape2;
                                    final long j72 = j3;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    ProvidableCompositionLocal<Dp> localAbsoluteElevation2 = ElevationOverlayKt.getLocalAbsoluteElevation();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume2 = startRestartGroup.consume(localAbsoluteElevation2);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    final float m6389constructorimpl22 = Dp.m6389constructorimpl(((Dp) consume2).m6403unboximpl() + f2);
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4)), ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl22))}, ComposableLambdaKt.composableLambda(startRestartGroup, 2031491085, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                            invoke(composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i16) {
                                            long m1789surfaceColorAtElevationcq6XJ1M;
                                            Modifier m1788surface8ww4TTg;
                                            ComposerKt.sourceInformation(composer2, "C235@11591L7,233@11462L221,243@11902L16,228@11275L827:Surface.kt#jmzs0o");
                                            if ((i16 & 11) != 2 || !composer2.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(2031491085, i16, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:228)");
                                                }
                                                Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                                                Shape shape5 = shape42;
                                                long j8 = j72;
                                                ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                Object consume22 = composer2.consume(localElevationOverlay);
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j8, (ElevationOverlay) consume22, m6389constructorimpl22, composer2, 0);
                                                m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke2, f2);
                                                Modifier m559clickableO2vRcR0$default = ClickableKt.m559clickableO2vRcR0$default(m1788surface8ww4TTg, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z42, null, null, function0, 24, null);
                                                Function2<Composer, Integer, Unit> function22 = function2;
                                                composer2.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                                                composer2.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m559clickableO2vRcR0$default);
                                                if (!(composer2.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer2.startReusableNode();
                                                if (composer2.getInserting()) {
                                                    composer2.createNode(constructor);
                                                } else {
                                                    composer2.useNode();
                                                }
                                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                                composer2.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer2, 1505975758, "C249@12083L9:Surface.kt#jmzs0o");
                                                function22.invoke(composer2, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                composer2.endReplaceableGroup();
                                                composer2.endNode();
                                                composer2.endReplaceableGroup();
                                                composer2.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer2.skipToGroupEnd();
                                        }
                                    }), startRestartGroup, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                    }
                                    j5 = j4;
                                    modifier4 = modifier3;
                                    shape3 = shape42;
                                    j6 = j72;
                                    borderStroke3 = borderStroke2;
                                    f3 = f2;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    z3 = z42;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    long j8 = j4;
                                    z3 = z2;
                                    j5 = j8;
                                    borderStroke3 = borderStroke;
                                    modifier4 = modifier2;
                                    shape3 = shape2;
                                    j6 = j3;
                                    f3 = f;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$5
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                            invoke(composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i16) {
                                            SurfaceKt.m1783SurfaceLPr_se0(function0, modifier4, z3, shape3, j6, j5, borderStroke3, f3, mutableInteractionSource3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if ((i6 & 1533916891) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                            }
                            if (i15 != 0) {
                            }
                            if (i4 != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if ((i2 & 16) != 0) {
                            }
                            if ((i2 & 32) != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if (i11 != 0) {
                            }
                        }
                        i11 = i10;
                        if ((i2 & 512) == 0) {
                        }
                        if ((i6 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i15 != 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i2 & 16) != 0) {
                        }
                        if ((i2 & 32) != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i11 != 0) {
                        }
                    }
                    i9 = i8;
                    i10 = i2 & 256;
                    if (i10 != 0) {
                    }
                    i11 = i10;
                    if ((i2 & 512) == 0) {
                    }
                    if ((i6 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i11 != 0) {
                    }
                }
                shape2 = shape;
                if ((57344 & i) != 0) {
                }
                if ((458752 & i) != 0) {
                }
                i7 = i2 & 64;
                if (i7 == 0) {
                }
                i8 = i2 & 128;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i2 & 256;
                if (i10 != 0) {
                }
                i11 = i10;
                if ((i2 & 512) == 0) {
                }
                if ((i6 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i15 != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if (i7 != 0) {
                }
                if (i9 != 0) {
                }
                if (i11 != 0) {
                }
            }
            z2 = z;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            shape2 = shape;
            if ((57344 & i) != 0) {
            }
            if ((458752 & i) != 0) {
            }
            i7 = i2 & 64;
            if (i7 == 0) {
            }
            i8 = i2 & 128;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i2 & 256;
            if (i10 != 0) {
            }
            i11 = i10;
            if ((i2 & 512) == 0) {
            }
            if ((i6 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i15 != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if (i7 != 0) {
            }
            if (i9 != 0) {
            }
            if (i11 != 0) {
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
        shape2 = shape;
        if ((57344 & i) != 0) {
        }
        if ((458752 & i) != 0) {
        }
        i7 = i2 & 64;
        if (i7 == 0) {
        }
        i8 = i2 & 128;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i2 & 256;
        if (i10 != 0) {
        }
        i11 = i10;
        if ((i2 & 512) == 0) {
        }
        if ((i6 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i15 != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if (i7 != 0) {
        }
        if (i9 != 0) {
        }
        if (i11 != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0213  */
    /* JADX WARN: Type inference failed for: r28v3 */
    /* JADX WARN: Type inference failed for: r28v4 */
    /* JADX WARN: Type inference failed for: r28v5 */
    /* renamed from: Surface-Ny5ogXk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1784SurfaceNy5ogXk(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function0<Unit> function02;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        int i7;
        Shape shape2;
        int i8;
        BorderStroke borderStroke2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Modifier.Companion companion;
        long j3;
        long j4;
        char c;
        boolean z4;
        final MutableInteractionSource mutableInteractionSource2;
        final float f2;
        final Shape shape3;
        final long j5;
        final boolean z5;
        final BorderStroke borderStroke3;
        int i14;
        boolean z6;
        final long j6;
        final Modifier modifier3;
        final Shape shape4;
        final long j7;
        final BorderStroke borderStroke4;
        final float f3;
        final MutableInteractionSource mutableInteractionSource3;
        final boolean z7;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(262027249);
        ComposerKt.sourceInformation(startRestartGroup, "C(Surface)P(9,8,7,5,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)330@16547L6,331@16589L22,334@16723L39,*337@16855L7,338@16879L1024:Surface.kt#jmzs0o");
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
            function02 = function0;
            i4 |= startRestartGroup.changedInstance(function02) ? 32 : 16;
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
                    } else if ((57344 & i) == 0) {
                        shape2 = shape;
                        i4 |= startRestartGroup.changed(shape2) ? 16384 : 8192;
                        if ((458752 & i) == 0) {
                            i4 |= ((i3 & 32) == 0 && startRestartGroup.changed(j)) ? 131072 : 65536;
                        }
                        if ((i & 3670016) == 0) {
                            i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(j2)) ? 1048576 : 524288;
                        }
                        i8 = i3 & 128;
                        if (i8 != 0) {
                            i4 |= 12582912;
                            borderStroke2 = borderStroke;
                        } else {
                            borderStroke2 = borderStroke;
                            if ((i & 29360128) == 0) {
                                i4 |= startRestartGroup.changed(borderStroke2) ? 8388608 : 4194304;
                            }
                        }
                        i9 = i3 & 256;
                        if (i9 != 0) {
                            i4 |= 100663296;
                        } else if ((i & 234881024) == 0) {
                            i10 = i9;
                            i4 |= startRestartGroup.changed(f) ? 67108864 : 33554432;
                            i11 = i3 & 512;
                            if (i11 == 0) {
                                i4 |= C.ENCODING_PCM_32BIT;
                            } else if ((i & 1879048192) == 0) {
                                i12 = i11;
                                i4 |= startRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                                if ((i3 & 1024) != 0) {
                                    i13 = i2 | 6;
                                } else if ((i2 & 14) == 0) {
                                    i13 = i2 | (startRestartGroup.changedInstance(function2) ? 4 : 2);
                                } else {
                                    i13 = i2;
                                }
                                if ((i4 & 1533916891) == 306783378 || (i13 & 11) != 2 || !startRestartGroup.getSkipping()) {
                                    startRestartGroup.startDefaults();
                                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                                        if (i6 != 0) {
                                            z3 = true;
                                        }
                                        Shape rectangleShape = i7 != 0 ? RectangleShapeKt.getRectangleShape() : shape2;
                                        if ((i3 & 32) != 0) {
                                            j3 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                                            i4 &= -458753;
                                        } else {
                                            j3 = j;
                                        }
                                        if ((i3 & 64) != 0) {
                                            j4 = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i4 >> 15) & 14);
                                            i4 &= -3670017;
                                        } else {
                                            j4 = j2;
                                        }
                                        if (i8 != 0) {
                                            borderStroke2 = null;
                                        }
                                        float m6389constructorimpl = i10 != 0 ? Dp.m6389constructorimpl(0) : f;
                                        c = 0;
                                        if (i12 != 0) {
                                            startRestartGroup.startReplaceableGroup(-492369756);
                                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                            Object rememberedValue = startRestartGroup.rememberedValue();
                                            z4 = true;
                                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                        } else {
                                            z4 = true;
                                            mutableInteractionSource2 = mutableInteractionSource;
                                        }
                                        f2 = m6389constructorimpl;
                                        shape3 = rectangleShape;
                                        j5 = j3;
                                        z5 = z3;
                                        borderStroke3 = borderStroke2;
                                        i14 = 262027249;
                                        z6 = z4;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i3 & 32) != 0) {
                                            i4 &= -458753;
                                        }
                                        if ((i3 & 64) != 0) {
                                            i4 &= -3670017;
                                        }
                                        j5 = j;
                                        f2 = f;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        c = 0;
                                        companion = modifier2;
                                        z5 = z3;
                                        shape3 = shape2;
                                        borderStroke3 = borderStroke2;
                                        i14 = 262027249;
                                        z6 = 1;
                                        j4 = j2;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i14, i4, i13, "androidx.compose.material.Surface (Surface.kt:336)");
                                    }
                                    ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume = startRestartGroup.consume(localAbsoluteElevation);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    final float m6389constructorimpl2 = Dp.m6389constructorimpl(((Dp) consume).m6403unboximpl() + f2);
                                    ProvidedValue[] providedValueArr = new ProvidedValue[2];
                                    providedValueArr[c] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4));
                                    providedValueArr[z6] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl2));
                                    final Modifier modifier4 = companion;
                                    final Function0<Unit> function03 = function02;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(startRestartGroup, -1391199439, z6, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$7
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                            invoke(composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i15) {
                                            long m1789surfaceColorAtElevationcq6XJ1M;
                                            Modifier m1788surface8ww4TTg;
                                            ComposerKt.sourceInformation(composer2, "C349@17344L7,347@17215L221,358@17697L16,342@17028L869:Surface.kt#jmzs0o");
                                            if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1391199439, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:342)");
                                                }
                                                Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                                                Shape shape5 = shape3;
                                                long j8 = j5;
                                                ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                Object consume2 = composer2.consume(localElevationOverlay);
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j8, (ElevationOverlay) consume2, m6389constructorimpl2, composer2, 0);
                                                m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke3, f2);
                                                Modifier m1121selectableO2vRcR0$default = SelectableKt.m1121selectableO2vRcR0$default(m1788surface8ww4TTg, z, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z5, null, function03, 16, null);
                                                Function2<Composer, Integer, Unit> function22 = function2;
                                                composer2.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                                                composer2.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1121selectableO2vRcR0$default);
                                                if (!(composer2.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer2.startReusableNode();
                                                if (composer2.getInserting()) {
                                                    composer2.createNode(constructor);
                                                } else {
                                                    composer2.useNode();
                                                }
                                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                                composer2.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer2, 1505981553, "C364@17878L9:Surface.kt#jmzs0o");
                                                function22.invoke(composer2, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                composer2.endReplaceableGroup();
                                                composer2.endNode();
                                                composer2.endReplaceableGroup();
                                                composer2.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer2.skipToGroupEnd();
                                        }
                                    }), startRestartGroup, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    j6 = j4;
                                    modifier3 = modifier4;
                                    shape4 = shape3;
                                    j7 = j5;
                                    borderStroke4 = borderStroke3;
                                    f3 = f2;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    z7 = z5;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    j7 = j;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    modifier3 = modifier2;
                                    z7 = z3;
                                    shape4 = shape2;
                                    borderStroke4 = borderStroke2;
                                    j6 = j2;
                                    f3 = f;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$8
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                            invoke(composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i15) {
                                            SurfaceKt.m1784SurfaceNy5ogXk(z, function0, modifier3, z7, shape4, j7, j6, borderStroke4, f3, mutableInteractionSource3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i12 = i11;
                            if ((i3 & 1024) != 0) {
                            }
                            if ((i4 & 1533916891) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if ((i3 & 32) != 0) {
                            }
                            if ((i3 & 64) != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            c = 0;
                            if (i12 != 0) {
                            }
                            f2 = m6389constructorimpl;
                            shape3 = rectangleShape;
                            j5 = j3;
                            z5 = z3;
                            borderStroke3 = borderStroke2;
                            i14 = 262027249;
                            z6 = z4;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ProvidableCompositionLocal<Dp> localAbsoluteElevation2 = ElevationOverlayKt.getLocalAbsoluteElevation();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(localAbsoluteElevation2);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final float m6389constructorimpl22 = Dp.m6389constructorimpl(((Dp) consume2).m6403unboximpl() + f2);
                            ProvidedValue[] providedValueArr2 = new ProvidedValue[2];
                            providedValueArr2[c] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4));
                            providedValueArr2[z6] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl22));
                            final Modifier modifier42 = companion;
                            final Function0<Unit> function032 = function02;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr2, ComposableLambdaKt.composableLambda(startRestartGroup, -1391199439, z6, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$7
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i15) {
                                    long m1789surfaceColorAtElevationcq6XJ1M;
                                    Modifier m1788surface8ww4TTg;
                                    ComposerKt.sourceInformation(composer2, "C349@17344L7,347@17215L221,358@17697L16,342@17028L869:Surface.kt#jmzs0o");
                                    if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1391199439, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:342)");
                                        }
                                        Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                                        Shape shape5 = shape3;
                                        long j8 = j5;
                                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume22 = composer2.consume(localElevationOverlay);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j8, (ElevationOverlay) consume22, m6389constructorimpl22, composer2, 0);
                                        m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke3, f2);
                                        Modifier m1121selectableO2vRcR0$default = SelectableKt.m1121selectableO2vRcR0$default(m1788surface8ww4TTg, z, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z5, null, function032, 16, null);
                                        Function2<Composer, Integer, Unit> function22 = function2;
                                        composer2.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                                        composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1121selectableO2vRcR0$default);
                                        if (!(composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer2.startReusableNode();
                                        if (composer2.getInserting()) {
                                            composer2.createNode(constructor);
                                        } else {
                                            composer2.useNode();
                                        }
                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                        composer2.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer2, 1505981553, "C364@17878L9:Surface.kt#jmzs0o");
                                        function22.invoke(composer2, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endReplaceableGroup();
                                        composer2.endNode();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), startRestartGroup, 56);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            j6 = j4;
                            modifier3 = modifier42;
                            shape4 = shape3;
                            j7 = j5;
                            borderStroke4 = borderStroke3;
                            f3 = f2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            z7 = z5;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i10 = i9;
                        i11 = i3 & 512;
                        if (i11 == 0) {
                        }
                        i12 = i11;
                        if ((i3 & 1024) != 0) {
                        }
                        if ((i4 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if ((i3 & 32) != 0) {
                        }
                        if ((i3 & 64) != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        c = 0;
                        if (i12 != 0) {
                        }
                        f2 = m6389constructorimpl;
                        shape3 = rectangleShape;
                        j5 = j3;
                        z5 = z3;
                        borderStroke3 = borderStroke2;
                        i14 = 262027249;
                        z6 = z4;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation22 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume22 = startRestartGroup.consume(localAbsoluteElevation22);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final float m6389constructorimpl222 = Dp.m6389constructorimpl(((Dp) consume22).m6403unboximpl() + f2);
                        ProvidedValue[] providedValueArr22 = new ProvidedValue[2];
                        providedValueArr22[c] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4));
                        providedValueArr22[z6] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl222));
                        final Modifier modifier422 = companion;
                        final Function0<Unit> function0322 = function02;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr22, ComposableLambdaKt.composableLambda(startRestartGroup, -1391199439, z6, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                long m1789surfaceColorAtElevationcq6XJ1M;
                                Modifier m1788surface8ww4TTg;
                                ComposerKt.sourceInformation(composer2, "C349@17344L7,347@17215L221,358@17697L16,342@17028L869:Surface.kt#jmzs0o");
                                if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1391199439, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:342)");
                                    }
                                    Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                                    Shape shape5 = shape3;
                                    long j8 = j5;
                                    ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume222 = composer2.consume(localElevationOverlay);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j8, (ElevationOverlay) consume222, m6389constructorimpl222, composer2, 0);
                                    m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke3, f2);
                                    Modifier m1121selectableO2vRcR0$default = SelectableKt.m1121selectableO2vRcR0$default(m1788surface8ww4TTg, z, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z5, null, function0322, 16, null);
                                    Function2<Composer, Integer, Unit> function22 = function2;
                                    composer2.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                                    composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1121selectableO2vRcR0$default);
                                    if (!(composer2.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor);
                                    } else {
                                        composer2.useNode();
                                    }
                                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 1505981553, "C364@17878L9:Surface.kt#jmzs0o");
                                    function22.invoke(composer2, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    composer2.endReplaceableGroup();
                                    composer2.endNode();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), startRestartGroup, 56);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        j6 = j4;
                        modifier3 = modifier422;
                        shape4 = shape3;
                        j7 = j5;
                        borderStroke4 = borderStroke3;
                        f3 = f2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z7 = z5;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    shape2 = shape;
                    if ((458752 & i) == 0) {
                    }
                    if ((i & 3670016) == 0) {
                    }
                    i8 = i3 & 128;
                    if (i8 != 0) {
                    }
                    i9 = i3 & 256;
                    if (i9 != 0) {
                    }
                    i10 = i9;
                    i11 = i3 & 512;
                    if (i11 == 0) {
                    }
                    i12 = i11;
                    if ((i3 & 1024) != 0) {
                    }
                    if ((i4 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if ((i3 & 32) != 0) {
                    }
                    if ((i3 & 64) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    c = 0;
                    if (i12 != 0) {
                    }
                    f2 = m6389constructorimpl;
                    shape3 = rectangleShape;
                    j5 = j3;
                    z5 = z3;
                    borderStroke3 = borderStroke2;
                    i14 = 262027249;
                    z6 = z4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation222 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume222 = startRestartGroup.consume(localAbsoluteElevation222);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final float m6389constructorimpl2222 = Dp.m6389constructorimpl(((Dp) consume222).m6403unboximpl() + f2);
                    ProvidedValue[] providedValueArr222 = new ProvidedValue[2];
                    providedValueArr222[c] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4));
                    providedValueArr222[z6] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl2222));
                    final Modifier modifier4222 = companion;
                    final Function0<Unit> function03222 = function02;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr222, ComposableLambdaKt.composableLambda(startRestartGroup, -1391199439, z6, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            long m1789surfaceColorAtElevationcq6XJ1M;
                            Modifier m1788surface8ww4TTg;
                            ComposerKt.sourceInformation(composer2, "C349@17344L7,347@17215L221,358@17697L16,342@17028L869:Surface.kt#jmzs0o");
                            if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1391199439, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:342)");
                                }
                                Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                                Shape shape5 = shape3;
                                long j8 = j5;
                                ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume2222 = composer2.consume(localElevationOverlay);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j8, (ElevationOverlay) consume2222, m6389constructorimpl2222, composer2, 0);
                                m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke3, f2);
                                Modifier m1121selectableO2vRcR0$default = SelectableKt.m1121selectableO2vRcR0$default(m1788surface8ww4TTg, z, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z5, null, function03222, 16, null);
                                Function2<Composer, Integer, Unit> function22 = function2;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1121selectableO2vRcR0$default);
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, 1505981553, "C364@17878L9:Surface.kt#jmzs0o");
                                function22.invoke(composer2, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, 56);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    j6 = j4;
                    modifier3 = modifier4222;
                    shape4 = shape3;
                    j7 = j5;
                    borderStroke4 = borderStroke3;
                    f3 = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z7 = z5;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z3 = z2;
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                shape2 = shape;
                if ((458752 & i) == 0) {
                }
                if ((i & 3670016) == 0) {
                }
                i8 = i3 & 128;
                if (i8 != 0) {
                }
                i9 = i3 & 256;
                if (i9 != 0) {
                }
                i10 = i9;
                i11 = i3 & 512;
                if (i11 == 0) {
                }
                i12 = i11;
                if ((i3 & 1024) != 0) {
                }
                if ((i4 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if ((i3 & 32) != 0) {
                }
                if ((i3 & 64) != 0) {
                }
                if (i8 != 0) {
                }
                if (i10 != 0) {
                }
                c = 0;
                if (i12 != 0) {
                }
                f2 = m6389constructorimpl;
                shape3 = rectangleShape;
                j5 = j3;
                z5 = z3;
                borderStroke3 = borderStroke2;
                i14 = 262027249;
                z6 = z4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation2222 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2222 = startRestartGroup.consume(localAbsoluteElevation2222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final float m6389constructorimpl22222 = Dp.m6389constructorimpl(((Dp) consume2222).m6403unboximpl() + f2);
                ProvidedValue[] providedValueArr2222 = new ProvidedValue[2];
                providedValueArr2222[c] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4));
                providedValueArr2222[z6] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl22222));
                final Modifier modifier42222 = companion;
                final Function0<Unit> function032222 = function02;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr2222, ComposableLambdaKt.composableLambda(startRestartGroup, -1391199439, z6, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        long m1789surfaceColorAtElevationcq6XJ1M;
                        Modifier m1788surface8ww4TTg;
                        ComposerKt.sourceInformation(composer2, "C349@17344L7,347@17215L221,358@17697L16,342@17028L869:Surface.kt#jmzs0o");
                        if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1391199439, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:342)");
                            }
                            Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                            Shape shape5 = shape3;
                            long j8 = j5;
                            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume22222 = composer2.consume(localElevationOverlay);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j8, (ElevationOverlay) consume22222, m6389constructorimpl22222, composer2, 0);
                            m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke3, f2);
                            Modifier m1121selectableO2vRcR0$default = SelectableKt.m1121selectableO2vRcR0$default(m1788surface8ww4TTg, z, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z5, null, function032222, 16, null);
                            Function2<Composer, Integer, Unit> function22 = function2;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1121selectableO2vRcR0$default);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor);
                            } else {
                                composer2.useNode();
                            }
                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 1505981553, "C364@17878L9:Surface.kt#jmzs0o");
                            function22.invoke(composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, 56);
                if (ComposerKt.isTraceInProgress()) {
                }
                j6 = j4;
                modifier3 = modifier42222;
                shape4 = shape3;
                j7 = j5;
                borderStroke4 = borderStroke3;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
                z7 = z5;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
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
            shape2 = shape;
            if ((458752 & i) == 0) {
            }
            if ((i & 3670016) == 0) {
            }
            i8 = i3 & 128;
            if (i8 != 0) {
            }
            i9 = i3 & 256;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i3 & 512;
            if (i11 == 0) {
            }
            i12 = i11;
            if ((i3 & 1024) != 0) {
            }
            if ((i4 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if ((i3 & 32) != 0) {
            }
            if ((i3 & 64) != 0) {
            }
            if (i8 != 0) {
            }
            if (i10 != 0) {
            }
            c = 0;
            if (i12 != 0) {
            }
            f2 = m6389constructorimpl;
            shape3 = rectangleShape;
            j5 = j3;
            z5 = z3;
            borderStroke3 = borderStroke2;
            i14 = 262027249;
            z6 = z4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Dp> localAbsoluteElevation22222 = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume22222 = startRestartGroup.consume(localAbsoluteElevation22222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final float m6389constructorimpl222222 = Dp.m6389constructorimpl(((Dp) consume22222).m6403unboximpl() + f2);
            ProvidedValue[] providedValueArr22222 = new ProvidedValue[2];
            providedValueArr22222[c] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4));
            providedValueArr22222[z6] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl222222));
            final Modifier modifier422222 = companion;
            final Function0<Unit> function0322222 = function02;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr22222, ComposableLambdaKt.composableLambda(startRestartGroup, -1391199439, z6, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i15) {
                    long m1789surfaceColorAtElevationcq6XJ1M;
                    Modifier m1788surface8ww4TTg;
                    ComposerKt.sourceInformation(composer2, "C349@17344L7,347@17215L221,358@17697L16,342@17028L869:Surface.kt#jmzs0o");
                    if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1391199439, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:342)");
                        }
                        Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                        Shape shape5 = shape3;
                        long j8 = j5;
                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume222222 = composer2.consume(localElevationOverlay);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j8, (ElevationOverlay) consume222222, m6389constructorimpl222222, composer2, 0);
                        m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke3, f2);
                        Modifier m1121selectableO2vRcR0$default = SelectableKt.m1121selectableO2vRcR0$default(m1788surface8ww4TTg, z, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z5, null, function0322222, 16, null);
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1121selectableO2vRcR0$default);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1505981553, "C364@17878L9:Surface.kt#jmzs0o");
                        function22.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
            }
            j6 = j4;
            modifier3 = modifier422222;
            shape4 = shape3;
            j7 = j5;
            borderStroke4 = borderStroke3;
            f3 = f2;
            mutableInteractionSource3 = mutableInteractionSource2;
            z7 = z5;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function02 = function0;
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
        shape2 = shape;
        if ((458752 & i) == 0) {
        }
        if ((i & 3670016) == 0) {
        }
        i8 = i3 & 128;
        if (i8 != 0) {
        }
        i9 = i3 & 256;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i3 & 512;
        if (i11 == 0) {
        }
        i12 = i11;
        if ((i3 & 1024) != 0) {
        }
        if ((i4 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if ((i3 & 32) != 0) {
        }
        if ((i3 & 64) != 0) {
        }
        if (i8 != 0) {
        }
        if (i10 != 0) {
        }
        c = 0;
        if (i12 != 0) {
        }
        f2 = m6389constructorimpl;
        shape3 = rectangleShape;
        j5 = j3;
        z5 = z3;
        borderStroke3 = borderStroke2;
        i14 = 262027249;
        z6 = z4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Dp> localAbsoluteElevation222222 = ElevationOverlayKt.getLocalAbsoluteElevation();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume222222 = startRestartGroup.consume(localAbsoluteElevation222222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final float m6389constructorimpl2222222 = Dp.m6389constructorimpl(((Dp) consume222222).m6403unboximpl() + f2);
        ProvidedValue[] providedValueArr222222 = new ProvidedValue[2];
        providedValueArr222222[c] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4));
        providedValueArr222222[z6] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl2222222));
        final Modifier modifier4222222 = companion;
        final Function0<Unit> function03222222 = function02;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr222222, ComposableLambdaKt.composableLambda(startRestartGroup, -1391199439, z6, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i15) {
                long m1789surfaceColorAtElevationcq6XJ1M;
                Modifier m1788surface8ww4TTg;
                ComposerKt.sourceInformation(composer2, "C349@17344L7,347@17215L221,358@17697L16,342@17028L869:Surface.kt#jmzs0o");
                if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1391199439, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:342)");
                    }
                    Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                    Shape shape5 = shape3;
                    long j8 = j5;
                    ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2222222 = composer2.consume(localElevationOverlay);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j8, (ElevationOverlay) consume2222222, m6389constructorimpl2222222, composer2, 0);
                    m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke3, f2);
                    Modifier m1121selectableO2vRcR0$default = SelectableKt.m1121selectableO2vRcR0$default(m1788surface8ww4TTg, z, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z5, null, function03222222, 16, null);
                    Function2<Composer, Integer, Unit> function22 = function2;
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1121selectableO2vRcR0$default);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1505981553, "C364@17878L9:Surface.kt#jmzs0o");
                    function22.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, 56);
        if (ComposerKt.isTraceInProgress()) {
        }
        j6 = j4;
        modifier3 = modifier4222222;
        shape4 = shape3;
        j7 = j5;
        borderStroke4 = borderStroke3;
        f3 = f2;
        mutableInteractionSource3 = mutableInteractionSource2;
        z7 = z5;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0213  */
    /* JADX WARN: Type inference failed for: r28v3 */
    /* JADX WARN: Type inference failed for: r28v4 */
    /* JADX WARN: Type inference failed for: r28v5 */
    /* renamed from: Surface-Ny5ogXk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1785SurfaceNy5ogXk(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z2, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function1<? super Boolean, Unit> function12;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        int i7;
        Shape shape2;
        int i8;
        BorderStroke borderStroke2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Modifier.Companion companion;
        long j3;
        long j4;
        char c;
        boolean z4;
        final MutableInteractionSource mutableInteractionSource2;
        final float f2;
        final Shape shape3;
        final long j5;
        final boolean z5;
        final BorderStroke borderStroke3;
        int i14;
        boolean z6;
        final long j6;
        final Modifier modifier3;
        final Shape shape4;
        final long j7;
        final BorderStroke borderStroke4;
        final float f3;
        final MutableInteractionSource mutableInteractionSource3;
        final boolean z7;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1341569296);
        ComposerKt.sourceInformation(startRestartGroup, "C(Surface)P(1,9,8,6,10,2:c#ui.graphics.Color,4:c#ui.graphics.Color!1,5:c#ui.unit.Dp,7)445@22417L6,446@22459L22,449@22593L39,*452@22725L7,453@22749L1034:Surface.kt#jmzs0o");
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
            function12 = function1;
            i4 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
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
                    } else if ((57344 & i) == 0) {
                        shape2 = shape;
                        i4 |= startRestartGroup.changed(shape2) ? 16384 : 8192;
                        if ((458752 & i) == 0) {
                            i4 |= ((i3 & 32) == 0 && startRestartGroup.changed(j)) ? 131072 : 65536;
                        }
                        if ((i & 3670016) == 0) {
                            i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(j2)) ? 1048576 : 524288;
                        }
                        i8 = i3 & 128;
                        if (i8 != 0) {
                            i4 |= 12582912;
                            borderStroke2 = borderStroke;
                        } else {
                            borderStroke2 = borderStroke;
                            if ((i & 29360128) == 0) {
                                i4 |= startRestartGroup.changed(borderStroke2) ? 8388608 : 4194304;
                            }
                        }
                        i9 = i3 & 256;
                        if (i9 != 0) {
                            i4 |= 100663296;
                        } else if ((i & 234881024) == 0) {
                            i10 = i9;
                            i4 |= startRestartGroup.changed(f) ? 67108864 : 33554432;
                            i11 = i3 & 512;
                            if (i11 == 0) {
                                i4 |= C.ENCODING_PCM_32BIT;
                            } else if ((i & 1879048192) == 0) {
                                i12 = i11;
                                i4 |= startRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                                if ((i3 & 1024) != 0) {
                                    i13 = i2 | 6;
                                } else if ((i2 & 14) == 0) {
                                    i13 = i2 | (startRestartGroup.changedInstance(function2) ? 4 : 2);
                                } else {
                                    i13 = i2;
                                }
                                if ((i4 & 1533916891) == 306783378 || (i13 & 11) != 2 || !startRestartGroup.getSkipping()) {
                                    startRestartGroup.startDefaults();
                                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                                        if (i6 != 0) {
                                            z3 = true;
                                        }
                                        Shape rectangleShape = i7 != 0 ? RectangleShapeKt.getRectangleShape() : shape2;
                                        if ((i3 & 32) != 0) {
                                            j3 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                                            i4 &= -458753;
                                        } else {
                                            j3 = j;
                                        }
                                        if ((i3 & 64) != 0) {
                                            j4 = ColorsKt.m1621contentColorForek8zF_U(j3, startRestartGroup, (i4 >> 15) & 14);
                                            i4 &= -3670017;
                                        } else {
                                            j4 = j2;
                                        }
                                        if (i8 != 0) {
                                            borderStroke2 = null;
                                        }
                                        float m6389constructorimpl = i10 != 0 ? Dp.m6389constructorimpl(0) : f;
                                        c = 0;
                                        if (i12 != 0) {
                                            startRestartGroup.startReplaceableGroup(-492369756);
                                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                                            Object rememberedValue = startRestartGroup.rememberedValue();
                                            z4 = true;
                                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            startRestartGroup.endReplaceableGroup();
                                            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                        } else {
                                            z4 = true;
                                            mutableInteractionSource2 = mutableInteractionSource;
                                        }
                                        f2 = m6389constructorimpl;
                                        shape3 = rectangleShape;
                                        j5 = j3;
                                        z5 = z3;
                                        borderStroke3 = borderStroke2;
                                        i14 = 1341569296;
                                        z6 = z4;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i3 & 32) != 0) {
                                            i4 &= -458753;
                                        }
                                        if ((i3 & 64) != 0) {
                                            i4 &= -3670017;
                                        }
                                        j5 = j;
                                        f2 = f;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        c = 0;
                                        companion = modifier2;
                                        z5 = z3;
                                        shape3 = shape2;
                                        borderStroke3 = borderStroke2;
                                        i14 = 1341569296;
                                        z6 = 1;
                                        j4 = j2;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(i14, i4, i13, "androidx.compose.material.Surface (Surface.kt:451)");
                                    }
                                    ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume = startRestartGroup.consume(localAbsoluteElevation);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    final float m6389constructorimpl2 = Dp.m6389constructorimpl(((Dp) consume).m6403unboximpl() + f2);
                                    ProvidedValue[] providedValueArr = new ProvidedValue[2];
                                    providedValueArr[c] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4));
                                    providedValueArr[z6] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl2));
                                    final Modifier modifier4 = companion;
                                    final Function1<? super Boolean, Unit> function13 = function12;
                                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(startRestartGroup, -311657392, z6, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$10
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                            invoke(composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i15) {
                                            long m1789surfaceColorAtElevationcq6XJ1M;
                                            Modifier m1788surface8ww4TTg;
                                            ComposerKt.sourceInformation(composer2, "C464@23214L7,462@23085L221,473@23563L16,457@22898L879:Surface.kt#jmzs0o");
                                            if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-311657392, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:457)");
                                                }
                                                Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                                                Shape shape5 = shape3;
                                                long j8 = j5;
                                                ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                Object consume2 = composer2.consume(localElevationOverlay);
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j8, (ElevationOverlay) consume2, m6389constructorimpl2, composer2, 0);
                                                m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke3, f2);
                                                Modifier m1125toggleableO2vRcR0$default = ToggleableKt.m1125toggleableO2vRcR0$default(m1788surface8ww4TTg, z, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z5, null, function13, 16, null);
                                                Function2<Composer, Integer, Unit> function22 = function2;
                                                composer2.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                                                composer2.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1125toggleableO2vRcR0$default);
                                                if (!(composer2.getApplier() instanceof Applier)) {
                                                    ComposablesKt.invalidApplier();
                                                }
                                                composer2.startReusableNode();
                                                if (composer2.getInserting()) {
                                                    composer2.createNode(constructor);
                                                } else {
                                                    composer2.useNode();
                                                }
                                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                                composer2.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer2, 1505987433, "C479@23758L9:Surface.kt#jmzs0o");
                                                function22.invoke(composer2, 0);
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                                composer2.endReplaceableGroup();
                                                composer2.endNode();
                                                composer2.endReplaceableGroup();
                                                composer2.endReplaceableGroup();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer2.skipToGroupEnd();
                                        }
                                    }), startRestartGroup, 56);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    j6 = j4;
                                    modifier3 = modifier4;
                                    shape4 = shape3;
                                    j7 = j5;
                                    borderStroke4 = borderStroke3;
                                    f3 = f2;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    z7 = z5;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    j7 = j;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    modifier3 = modifier2;
                                    z7 = z3;
                                    shape4 = shape2;
                                    borderStroke4 = borderStroke2;
                                    j6 = j2;
                                    f3 = f;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$11
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                            invoke(composer2, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i15) {
                                            SurfaceKt.m1785SurfaceNy5ogXk(z, function1, modifier3, z7, shape4, j7, j6, borderStroke4, f3, mutableInteractionSource3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i12 = i11;
                            if ((i3 & 1024) != 0) {
                            }
                            if ((i4 & 1533916891) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if ((i3 & 32) != 0) {
                            }
                            if ((i3 & 64) != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            c = 0;
                            if (i12 != 0) {
                            }
                            f2 = m6389constructorimpl;
                            shape3 = rectangleShape;
                            j5 = j3;
                            z5 = z3;
                            borderStroke3 = borderStroke2;
                            i14 = 1341569296;
                            z6 = z4;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            ProvidableCompositionLocal<Dp> localAbsoluteElevation2 = ElevationOverlayKt.getLocalAbsoluteElevation();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(localAbsoluteElevation2);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final float m6389constructorimpl22 = Dp.m6389constructorimpl(((Dp) consume2).m6403unboximpl() + f2);
                            ProvidedValue[] providedValueArr2 = new ProvidedValue[2];
                            providedValueArr2[c] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4));
                            providedValueArr2[z6] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl22));
                            final Modifier modifier42 = companion;
                            final Function1<? super Boolean, Unit> function132 = function12;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr2, ComposableLambdaKt.composableLambda(startRestartGroup, -311657392, z6, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$10
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i15) {
                                    long m1789surfaceColorAtElevationcq6XJ1M;
                                    Modifier m1788surface8ww4TTg;
                                    ComposerKt.sourceInformation(composer2, "C464@23214L7,462@23085L221,473@23563L16,457@22898L879:Surface.kt#jmzs0o");
                                    if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-311657392, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:457)");
                                        }
                                        Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                                        Shape shape5 = shape3;
                                        long j8 = j5;
                                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume22 = composer2.consume(localElevationOverlay);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j8, (ElevationOverlay) consume22, m6389constructorimpl22, composer2, 0);
                                        m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke3, f2);
                                        Modifier m1125toggleableO2vRcR0$default = ToggleableKt.m1125toggleableO2vRcR0$default(m1788surface8ww4TTg, z, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z5, null, function132, 16, null);
                                        Function2<Composer, Integer, Unit> function22 = function2;
                                        composer2.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                                        composer2.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1125toggleableO2vRcR0$default);
                                        if (!(composer2.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer2.startReusableNode();
                                        if (composer2.getInserting()) {
                                            composer2.createNode(constructor);
                                        } else {
                                            composer2.useNode();
                                        }
                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                        composer2.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer2, 1505987433, "C479@23758L9:Surface.kt#jmzs0o");
                                        function22.invoke(composer2, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        ComposerKt.sourceInformationMarkerEnd(composer2);
                                        composer2.endReplaceableGroup();
                                        composer2.endNode();
                                        composer2.endReplaceableGroup();
                                        composer2.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), startRestartGroup, 56);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            j6 = j4;
                            modifier3 = modifier42;
                            shape4 = shape3;
                            j7 = j5;
                            borderStroke4 = borderStroke3;
                            f3 = f2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            z7 = z5;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i10 = i9;
                        i11 = i3 & 512;
                        if (i11 == 0) {
                        }
                        i12 = i11;
                        if ((i3 & 1024) != 0) {
                        }
                        if ((i4 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if ((i3 & 32) != 0) {
                        }
                        if ((i3 & 64) != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        c = 0;
                        if (i12 != 0) {
                        }
                        f2 = m6389constructorimpl;
                        shape3 = rectangleShape;
                        j5 = j3;
                        z5 = z3;
                        borderStroke3 = borderStroke2;
                        i14 = 1341569296;
                        z6 = z4;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ProvidableCompositionLocal<Dp> localAbsoluteElevation22 = ElevationOverlayKt.getLocalAbsoluteElevation();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume22 = startRestartGroup.consume(localAbsoluteElevation22);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final float m6389constructorimpl222 = Dp.m6389constructorimpl(((Dp) consume22).m6403unboximpl() + f2);
                        ProvidedValue[] providedValueArr22 = new ProvidedValue[2];
                        providedValueArr22[c] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4));
                        providedValueArr22[z6] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl222));
                        final Modifier modifier422 = companion;
                        final Function1<? super Boolean, Unit> function1322 = function12;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr22, ComposableLambdaKt.composableLambda(startRestartGroup, -311657392, z6, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$10
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                long m1789surfaceColorAtElevationcq6XJ1M;
                                Modifier m1788surface8ww4TTg;
                                ComposerKt.sourceInformation(composer2, "C464@23214L7,462@23085L221,473@23563L16,457@22898L879:Surface.kt#jmzs0o");
                                if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-311657392, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:457)");
                                    }
                                    Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                                    Shape shape5 = shape3;
                                    long j8 = j5;
                                    ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume222 = composer2.consume(localElevationOverlay);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j8, (ElevationOverlay) consume222, m6389constructorimpl222, composer2, 0);
                                    m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke3, f2);
                                    Modifier m1125toggleableO2vRcR0$default = ToggleableKt.m1125toggleableO2vRcR0$default(m1788surface8ww4TTg, z, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z5, null, function1322, 16, null);
                                    Function2<Composer, Integer, Unit> function22 = function2;
                                    composer2.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                                    composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1125toggleableO2vRcR0$default);
                                    if (!(composer2.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor);
                                    } else {
                                        composer2.useNode();
                                    }
                                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 1505987433, "C479@23758L9:Surface.kt#jmzs0o");
                                    function22.invoke(composer2, 0);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    ComposerKt.sourceInformationMarkerEnd(composer2);
                                    composer2.endReplaceableGroup();
                                    composer2.endNode();
                                    composer2.endReplaceableGroup();
                                    composer2.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), startRestartGroup, 56);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        j6 = j4;
                        modifier3 = modifier422;
                        shape4 = shape3;
                        j7 = j5;
                        borderStroke4 = borderStroke3;
                        f3 = f2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        z7 = z5;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    shape2 = shape;
                    if ((458752 & i) == 0) {
                    }
                    if ((i & 3670016) == 0) {
                    }
                    i8 = i3 & 128;
                    if (i8 != 0) {
                    }
                    i9 = i3 & 256;
                    if (i9 != 0) {
                    }
                    i10 = i9;
                    i11 = i3 & 512;
                    if (i11 == 0) {
                    }
                    i12 = i11;
                    if ((i3 & 1024) != 0) {
                    }
                    if ((i4 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if ((i3 & 32) != 0) {
                    }
                    if ((i3 & 64) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    c = 0;
                    if (i12 != 0) {
                    }
                    f2 = m6389constructorimpl;
                    shape3 = rectangleShape;
                    j5 = j3;
                    z5 = z3;
                    borderStroke3 = borderStroke2;
                    i14 = 1341569296;
                    z6 = z4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation222 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume222 = startRestartGroup.consume(localAbsoluteElevation222);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final float m6389constructorimpl2222 = Dp.m6389constructorimpl(((Dp) consume222).m6403unboximpl() + f2);
                    ProvidedValue[] providedValueArr222 = new ProvidedValue[2];
                    providedValueArr222[c] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4));
                    providedValueArr222[z6] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl2222));
                    final Modifier modifier4222 = companion;
                    final Function1<? super Boolean, Unit> function13222 = function12;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr222, ComposableLambdaKt.composableLambda(startRestartGroup, -311657392, z6, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$10
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            long m1789surfaceColorAtElevationcq6XJ1M;
                            Modifier m1788surface8ww4TTg;
                            ComposerKt.sourceInformation(composer2, "C464@23214L7,462@23085L221,473@23563L16,457@22898L879:Surface.kt#jmzs0o");
                            if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-311657392, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:457)");
                                }
                                Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                                Shape shape5 = shape3;
                                long j8 = j5;
                                ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                                ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume2222 = composer2.consume(localElevationOverlay);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j8, (ElevationOverlay) consume2222, m6389constructorimpl2222, composer2, 0);
                                m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke3, f2);
                                Modifier m1125toggleableO2vRcR0$default = ToggleableKt.m1125toggleableO2vRcR0$default(m1788surface8ww4TTg, z, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z5, null, function13222, 16, null);
                                Function2<Composer, Integer, Unit> function22 = function2;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1125toggleableO2vRcR0$default);
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, 1505987433, "C479@23758L9:Surface.kt#jmzs0o");
                                function22.invoke(composer2, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, 56);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    j6 = j4;
                    modifier3 = modifier4222;
                    shape4 = shape3;
                    j7 = j5;
                    borderStroke4 = borderStroke3;
                    f3 = f2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    z7 = z5;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                z3 = z2;
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                shape2 = shape;
                if ((458752 & i) == 0) {
                }
                if ((i & 3670016) == 0) {
                }
                i8 = i3 & 128;
                if (i8 != 0) {
                }
                i9 = i3 & 256;
                if (i9 != 0) {
                }
                i10 = i9;
                i11 = i3 & 512;
                if (i11 == 0) {
                }
                i12 = i11;
                if ((i3 & 1024) != 0) {
                }
                if ((i4 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if ((i3 & 32) != 0) {
                }
                if ((i3 & 64) != 0) {
                }
                if (i8 != 0) {
                }
                if (i10 != 0) {
                }
                c = 0;
                if (i12 != 0) {
                }
                f2 = m6389constructorimpl;
                shape3 = rectangleShape;
                j5 = j3;
                z5 = z3;
                borderStroke3 = borderStroke2;
                i14 = 1341569296;
                z6 = z4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation2222 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2222 = startRestartGroup.consume(localAbsoluteElevation2222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final float m6389constructorimpl22222 = Dp.m6389constructorimpl(((Dp) consume2222).m6403unboximpl() + f2);
                ProvidedValue[] providedValueArr2222 = new ProvidedValue[2];
                providedValueArr2222[c] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4));
                providedValueArr2222[z6] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl22222));
                final Modifier modifier42222 = companion;
                final Function1<? super Boolean, Unit> function132222 = function12;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr2222, ComposableLambdaKt.composableLambda(startRestartGroup, -311657392, z6, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        long m1789surfaceColorAtElevationcq6XJ1M;
                        Modifier m1788surface8ww4TTg;
                        ComposerKt.sourceInformation(composer2, "C464@23214L7,462@23085L221,473@23563L16,457@22898L879:Surface.kt#jmzs0o");
                        if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-311657392, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:457)");
                            }
                            Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                            Shape shape5 = shape3;
                            long j8 = j5;
                            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume22222 = composer2.consume(localElevationOverlay);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j8, (ElevationOverlay) consume22222, m6389constructorimpl22222, composer2, 0);
                            m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke3, f2);
                            Modifier m1125toggleableO2vRcR0$default = ToggleableKt.m1125toggleableO2vRcR0$default(m1788surface8ww4TTg, z, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z5, null, function132222, 16, null);
                            Function2<Composer, Integer, Unit> function22 = function2;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1125toggleableO2vRcR0$default);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor);
                            } else {
                                composer2.useNode();
                            }
                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 1505987433, "C479@23758L9:Surface.kt#jmzs0o");
                            function22.invoke(composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, 56);
                if (ComposerKt.isTraceInProgress()) {
                }
                j6 = j4;
                modifier3 = modifier42222;
                shape4 = shape3;
                j7 = j5;
                borderStroke4 = borderStroke3;
                f3 = f2;
                mutableInteractionSource3 = mutableInteractionSource2;
                z7 = z5;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
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
            shape2 = shape;
            if ((458752 & i) == 0) {
            }
            if ((i & 3670016) == 0) {
            }
            i8 = i3 & 128;
            if (i8 != 0) {
            }
            i9 = i3 & 256;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i3 & 512;
            if (i11 == 0) {
            }
            i12 = i11;
            if ((i3 & 1024) != 0) {
            }
            if ((i4 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if ((i3 & 32) != 0) {
            }
            if ((i3 & 64) != 0) {
            }
            if (i8 != 0) {
            }
            if (i10 != 0) {
            }
            c = 0;
            if (i12 != 0) {
            }
            f2 = m6389constructorimpl;
            shape3 = rectangleShape;
            j5 = j3;
            z5 = z3;
            borderStroke3 = borderStroke2;
            i14 = 1341569296;
            z6 = z4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Dp> localAbsoluteElevation22222 = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume22222 = startRestartGroup.consume(localAbsoluteElevation22222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final float m6389constructorimpl222222 = Dp.m6389constructorimpl(((Dp) consume22222).m6403unboximpl() + f2);
            ProvidedValue[] providedValueArr22222 = new ProvidedValue[2];
            providedValueArr22222[c] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4));
            providedValueArr22222[z6] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl222222));
            final Modifier modifier422222 = companion;
            final Function1<? super Boolean, Unit> function1322222 = function12;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr22222, ComposableLambdaKt.composableLambda(startRestartGroup, -311657392, z6, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$10
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i15) {
                    long m1789surfaceColorAtElevationcq6XJ1M;
                    Modifier m1788surface8ww4TTg;
                    ComposerKt.sourceInformation(composer2, "C464@23214L7,462@23085L221,473@23563L16,457@22898L879:Surface.kt#jmzs0o");
                    if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-311657392, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:457)");
                        }
                        Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                        Shape shape5 = shape3;
                        long j8 = j5;
                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume222222 = composer2.consume(localElevationOverlay);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j8, (ElevationOverlay) consume222222, m6389constructorimpl222222, composer2, 0);
                        m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke3, f2);
                        Modifier m1125toggleableO2vRcR0$default = ToggleableKt.m1125toggleableO2vRcR0$default(m1788surface8ww4TTg, z, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z5, null, function1322222, 16, null);
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1125toggleableO2vRcR0$default);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1505987433, "C479@23758L9:Surface.kt#jmzs0o");
                        function22.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
            }
            j6 = j4;
            modifier3 = modifier422222;
            shape4 = shape3;
            j7 = j5;
            borderStroke4 = borderStroke3;
            f3 = f2;
            mutableInteractionSource3 = mutableInteractionSource2;
            z7 = z5;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        function12 = function1;
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
        shape2 = shape;
        if ((458752 & i) == 0) {
        }
        if ((i & 3670016) == 0) {
        }
        i8 = i3 & 128;
        if (i8 != 0) {
        }
        i9 = i3 & 256;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i3 & 512;
        if (i11 == 0) {
        }
        i12 = i11;
        if ((i3 & 1024) != 0) {
        }
        if ((i4 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if ((i3 & 32) != 0) {
        }
        if ((i3 & 64) != 0) {
        }
        if (i8 != 0) {
        }
        if (i10 != 0) {
        }
        c = 0;
        if (i12 != 0) {
        }
        f2 = m6389constructorimpl;
        shape3 = rectangleShape;
        j5 = j3;
        z5 = z3;
        borderStroke3 = borderStroke2;
        i14 = 1341569296;
        z6 = z4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Dp> localAbsoluteElevation222222 = ElevationOverlayKt.getLocalAbsoluteElevation();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume222222 = startRestartGroup.consume(localAbsoluteElevation222222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final float m6389constructorimpl2222222 = Dp.m6389constructorimpl(((Dp) consume222222).m6403unboximpl() + f2);
        ProvidedValue[] providedValueArr222222 = new ProvidedValue[2];
        providedValueArr222222[c] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j4));
        providedValueArr222222[z6] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl2222222));
        final Modifier modifier4222222 = companion;
        final Function1<? super Boolean, Unit> function13222222 = function12;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr222222, ComposableLambdaKt.composableLambda(startRestartGroup, -311657392, z6, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i15) {
                long m1789surfaceColorAtElevationcq6XJ1M;
                Modifier m1788surface8ww4TTg;
                ComposerKt.sourceInformation(composer2, "C464@23214L7,462@23085L221,473@23563L16,457@22898L879:Surface.kt#jmzs0o");
                if ((i15 & 11) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-311657392, i15, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:457)");
                    }
                    Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                    Shape shape5 = shape3;
                    long j8 = j5;
                    ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2222222 = composer2.consume(localElevationOverlay);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j8, (ElevationOverlay) consume2222222, m6389constructorimpl2222222, composer2, 0);
                    m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke3, f2);
                    Modifier m1125toggleableO2vRcR0$default = ToggleableKt.m1125toggleableO2vRcR0$default(m1788surface8ww4TTg, z, mutableInteractionSource2, RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7), z5, null, function13222222, 16, null);
                    Function2<Composer, Integer, Unit> function22 = function2;
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1125toggleableO2vRcR0$default);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer2);
                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1505987433, "C479@23758L9:Surface.kt#jmzs0o");
                    function22.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, 56);
        if (ComposerKt.isTraceInProgress()) {
        }
        j6 = j4;
        modifier3 = modifier4222222;
        shape4 = shape3;
        j7 = j5;
        borderStroke4 = borderStroke3;
        f3 = f2;
        mutableInteractionSource3 = mutableInteractionSource2;
        z7 = z5;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0230  */
    /* JADX WARN: Type inference failed for: r25v12 */
    /* JADX WARN: Type inference failed for: r25v13 */
    /* JADX WARN: Type inference failed for: r25v17 */
    @Deprecated(level = DeprecationLevel.ERROR, message = "This API is deprecated with the introduction a newer Surface function overload that accepts an onClick().", replaceWith = @ReplaceWith(expression = "Surface(onClick, modifier, enabled, shape, color, contentColor, border, elevation, interactionSource, content)", imports = {}))
    /* renamed from: Surface-9VG74zQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1781Surface9VG74zQ(final Function0<Unit> function0, Modifier modifier, Shape shape, long j, long j2, BorderStroke borderStroke, float f, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, String str, Role role, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2, final int i3) {
        Function0<Unit> function02;
        int i4;
        int i5;
        Shape shape2;
        long j3;
        int i6;
        final BorderStroke borderStroke2;
        int i7;
        final float f2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        long j4;
        MutableInteractionSource mutableInteractionSource2;
        Modifier modifier2;
        boolean z2;
        Indication indication2;
        final Role role2;
        final Indication indication3;
        final boolean z3;
        final MutableInteractionSource mutableInteractionSource3;
        final String str2;
        final Modifier modifier3;
        final Shape shape3;
        final long j5;
        final long j6;
        boolean z4;
        Composer composer2;
        final Shape shape4;
        final long j7;
        final BorderStroke borderStroke3;
        final MutableInteractionSource mutableInteractionSource4;
        final Indication indication4;
        final boolean z5;
        final String str3;
        final Role role3;
        ScopeUpdateScope endRestartGroup;
        int i17;
        Composer startRestartGroup = composer.startRestartGroup(1585925488);
        ComposerKt.sourceInformation(startRestartGroup, "C(Surface)P(9,8,12,1:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,7,6,5,10,11:c#ui.semantics.Role)573@28985L6,574@29027L22,577@29161L39,578@29248L7,*584@29435L7,585@29459L1128:Surface.kt#jmzs0o");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
            function02 = function0;
        } else if ((i & 14) == 0) {
            function02 = function0;
            i4 = (startRestartGroup.changedInstance(function02) ? 4 : 2) | i;
        } else {
            function02 = function0;
            i4 = i;
        }
        int i18 = i3 & 2;
        if (i18 != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else if ((i & 896) == 0) {
                shape2 = shape;
                i4 |= startRestartGroup.changed(shape2) ? 256 : 128;
                if ((i & 7168) == 0) {
                    i4 |= ((i3 & 8) == 0 && startRestartGroup.changed(j)) ? 2048 : 1024;
                }
                if ((i & 57344) == 0) {
                    j3 = j2;
                    i4 |= ((i3 & 16) == 0 && startRestartGroup.changed(j3)) ? 16384 : 8192;
                } else {
                    j3 = j2;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((i & 458752) == 0) {
                        i4 |= startRestartGroup.changed(borderStroke2) ? 131072 : 65536;
                    }
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    i4 |= 1572864;
                    f2 = f;
                } else {
                    f2 = f;
                    if ((i & 3670016) == 0) {
                        i4 |= startRestartGroup.changed(f2) ? 1048576 : 524288;
                    }
                }
                i8 = i3 & 128;
                if (i8 != 0) {
                    i4 |= 12582912;
                } else if ((i & 29360128) == 0) {
                    i4 |= startRestartGroup.changed(mutableInteractionSource) ? 8388608 : 4194304;
                }
                if ((i & 234881024) == 0) {
                    if ((i3 & 256) == 0 && startRestartGroup.changed(indication)) {
                        i17 = 67108864;
                        i4 |= i17;
                    }
                    i17 = 33554432;
                    i4 |= i17;
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                    i4 |= C.ENCODING_PCM_32BIT;
                } else if ((i & 1879048192) == 0) {
                    i10 = i9;
                    i4 |= startRestartGroup.changed(z) ? 536870912 : 268435456;
                    i11 = i3 & 1024;
                    if (i11 == 0) {
                        i13 = i2 | 6;
                        i12 = i11;
                    } else if ((i2 & 14) == 0) {
                        i12 = i11;
                        i13 = i2 | (startRestartGroup.changed(str) ? 4 : 2);
                    } else {
                        i12 = i11;
                        i13 = i2;
                    }
                    i14 = i3 & 2048;
                    if (i14 == 0) {
                        i13 |= 48;
                        i15 = i14;
                    } else if ((i2 & 112) == 0) {
                        i15 = i14;
                        i13 |= startRestartGroup.changed(role) ? 32 : 16;
                    } else {
                        i15 = i14;
                    }
                    int i19 = i13;
                    if ((i3 & 4096) == 0) {
                        i19 |= 384;
                    } else if ((i2 & 896) == 0) {
                        i19 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
                        if ((i4 & 1533916891) == 306783378 || (i19 & 731) != 146 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i18 != 0 ? Modifier.INSTANCE : modifier;
                                if (i5 != 0) {
                                    shape2 = RectangleShapeKt.getRectangleShape();
                                }
                                if ((i3 & 8) != 0) {
                                    i16 = i4 & (-7169);
                                    j4 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1607getSurface0d7_KjU();
                                } else {
                                    i16 = i4;
                                    j4 = j;
                                }
                                if ((i3 & 16) != 0) {
                                    j3 = ColorsKt.m1621contentColorForek8zF_U(j4, startRestartGroup, (i16 >> 9) & 14);
                                    i16 &= -57345;
                                }
                                if (i6 != 0) {
                                    borderStroke2 = null;
                                }
                                if (i7 != 0) {
                                    f2 = Dp.m6389constructorimpl(0);
                                }
                                if (i8 != 0) {
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
                                if ((i3 & 256) != 0) {
                                    ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
                                    z2 = true;
                                    modifier2 = companion;
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume = startRestartGroup.consume(localIndication);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    indication2 = (Indication) consume;
                                    i16 &= -234881025;
                                } else {
                                    modifier2 = companion;
                                    z2 = true;
                                    indication2 = indication;
                                }
                                boolean z6 = i10 != 0 ? z2 ? 1 : 0 : z;
                                String str4 = i12 != 0 ? null : str;
                                if (i15 != 0) {
                                    z3 = z6;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    str2 = str4;
                                    role2 = null;
                                    indication3 = indication2;
                                } else {
                                    role2 = role;
                                    indication3 = indication2;
                                    z3 = z6;
                                    mutableInteractionSource3 = mutableInteractionSource2;
                                    str2 = str4;
                                }
                                long j8 = j4;
                                modifier3 = modifier2;
                                i4 = i16;
                                long j9 = j3;
                                shape3 = shape2;
                                j5 = j8;
                                j6 = j9;
                                z4 = z2;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                if ((i3 & 16) != 0) {
                                    i4 &= -57345;
                                }
                                if ((i3 & 256) != 0) {
                                    i4 &= -234881025;
                                }
                                long j10 = j3;
                                shape3 = shape2;
                                j6 = j10;
                                modifier3 = modifier;
                                j5 = j;
                                mutableInteractionSource3 = mutableInteractionSource;
                                indication3 = indication;
                                z3 = z;
                                str2 = str;
                                role2 = role;
                                z4 = 1;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1585925488, i4, i19, "androidx.compose.material.Surface (Surface.kt:583)");
                            }
                            ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(localAbsoluteElevation);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            final float m6389constructorimpl = Dp.m6389constructorimpl(((Dp) consume2).m6403unboximpl() + f2);
                            ProvidedValue[] providedValueArr = new ProvidedValue[2];
                            providedValueArr[0] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j6));
                            providedValueArr[z4] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl));
                            final Function0<Unit> function03 = function02;
                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda(startRestartGroup, 149594672, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$13
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

                                public final void invoke(Composer composer3, int i20) {
                                    long m1789surfaceColorAtElevationcq6XJ1M;
                                    Modifier m1788surface8ww4TTg;
                                    ComposerKt.sourceInformation(composer3, "C596@29913L7,594@29784L221,589@29608L973:Surface.kt#jmzs0o");
                                    if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(149594672, i20, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:589)");
                                        }
                                        Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                                        Shape shape5 = shape3;
                                        long j11 = j5;
                                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume3 = composer3.consume(localElevationOverlay);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j11, (ElevationOverlay) consume3, m6389constructorimpl, composer3, 0);
                                        m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke2, f2);
                                        Modifier then = m1788surface8ww4TTg.then(ClickableKt.m558clickableO2vRcR0(Modifier.INSTANCE, mutableInteractionSource3, indication3, z3, str2, role2, function03));
                                        Function2<Composer, Integer, Unit> function22 = function2;
                                        composer3.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer3, 48);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer3);
                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 1505994237, "C614@30562L9:Surface.kt#jmzs0o");
                                        function22.invoke(composer3, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), startRestartGroup, 56);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer2 = startRestartGroup;
                            shape4 = shape3;
                            j7 = j5;
                            borderStroke3 = borderStroke2;
                            mutableInteractionSource4 = mutableInteractionSource3;
                            indication4 = indication3;
                            z5 = z3;
                            str3 = str2;
                            role3 = role2;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            z5 = z;
                            str3 = str;
                            composer2 = startRestartGroup;
                            shape4 = shape2;
                            j6 = j3;
                            borderStroke3 = borderStroke2;
                            j7 = j;
                            mutableInteractionSource4 = mutableInteractionSource;
                            indication4 = indication;
                            role3 = role;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier4 = modifier3;
                            final float f3 = f2;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$14
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

                                public final void invoke(Composer composer3, int i20) {
                                    SurfaceKt.m1781Surface9VG74zQ(function0, modifier4, shape4, j7, j6, borderStroke3, f3, mutableInteractionSource4, indication4, z5, str3, role3, function2, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if ((i3 & 16) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if ((i3 & 256) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    long j82 = j4;
                    modifier3 = modifier2;
                    i4 = i16;
                    long j92 = j3;
                    shape3 = shape2;
                    j5 = j82;
                    j6 = j92;
                    z4 = z2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<Dp> localAbsoluteElevation2 = ElevationOverlayKt.getLocalAbsoluteElevation();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume22 = startRestartGroup.consume(localAbsoluteElevation2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final float m6389constructorimpl2 = Dp.m6389constructorimpl(((Dp) consume22).m6403unboximpl() + f2);
                    ProvidedValue[] providedValueArr2 = new ProvidedValue[2];
                    providedValueArr2[0] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j6));
                    providedValueArr2[z4] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl2));
                    final Function0<Unit> function032 = function02;
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr2, ComposableLambdaKt.composableLambda(startRestartGroup, 149594672, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$13
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

                        public final void invoke(Composer composer3, int i20) {
                            long m1789surfaceColorAtElevationcq6XJ1M;
                            Modifier m1788surface8ww4TTg;
                            ComposerKt.sourceInformation(composer3, "C596@29913L7,594@29784L221,589@29608L973:Surface.kt#jmzs0o");
                            if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(149594672, i20, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:589)");
                                }
                                Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                                Shape shape5 = shape3;
                                long j11 = j5;
                                ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume3 = composer3.consume(localElevationOverlay);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j11, (ElevationOverlay) consume3, m6389constructorimpl2, composer3, 0);
                                m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke2, f2);
                                Modifier then = m1788surface8ww4TTg.then(ClickableKt.m558clickableO2vRcR0(Modifier.INSTANCE, mutableInteractionSource3, indication3, z3, str2, role2, function032));
                                Function2<Composer, Integer, Unit> function22 = function2;
                                composer3.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer3, 48);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer3);
                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, 1505994237, "C614@30562L9:Surface.kt#jmzs0o");
                                function22.invoke(composer3, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), startRestartGroup, 56);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    shape4 = shape3;
                    j7 = j5;
                    borderStroke3 = borderStroke2;
                    mutableInteractionSource4 = mutableInteractionSource3;
                    indication4 = indication3;
                    z5 = z3;
                    str3 = str2;
                    role3 = role2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i10 = i9;
                i11 = i3 & 1024;
                if (i11 == 0) {
                }
                i14 = i3 & 2048;
                if (i14 == 0) {
                }
                int i192 = i13;
                if ((i3 & 4096) == 0) {
                }
                if ((i4 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i18 != 0) {
                }
                if (i5 != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if ((i3 & 16) != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if ((i3 & 256) != 0) {
                }
                if (i10 != 0) {
                }
                if (i12 != 0) {
                }
                if (i15 != 0) {
                }
                long j822 = j4;
                modifier3 = modifier2;
                i4 = i16;
                long j922 = j3;
                shape3 = shape2;
                j5 = j822;
                j6 = j922;
                z4 = z2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ProvidableCompositionLocal<Dp> localAbsoluteElevation22 = ElevationOverlayKt.getLocalAbsoluteElevation();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume222 = startRestartGroup.consume(localAbsoluteElevation22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final float m6389constructorimpl22 = Dp.m6389constructorimpl(((Dp) consume222).m6403unboximpl() + f2);
                ProvidedValue[] providedValueArr22 = new ProvidedValue[2];
                providedValueArr22[0] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j6));
                providedValueArr22[z4] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl22));
                final Function0<Unit> function0322 = function02;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr22, ComposableLambdaKt.composableLambda(startRestartGroup, 149594672, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$13
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

                    public final void invoke(Composer composer3, int i20) {
                        long m1789surfaceColorAtElevationcq6XJ1M;
                        Modifier m1788surface8ww4TTg;
                        ComposerKt.sourceInformation(composer3, "C596@29913L7,594@29784L221,589@29608L973:Surface.kt#jmzs0o");
                        if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(149594672, i20, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:589)");
                            }
                            Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                            Shape shape5 = shape3;
                            long j11 = j5;
                            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume3 = composer3.consume(localElevationOverlay);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j11, (ElevationOverlay) consume3, m6389constructorimpl22, composer3, 0);
                            m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke2, f2);
                            Modifier then = m1788surface8ww4TTg.then(ClickableKt.m558clickableO2vRcR0(Modifier.INSTANCE, mutableInteractionSource3, indication3, z3, str2, role2, function0322));
                            Function2<Composer, Integer, Unit> function22 = function2;
                            composer3.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer3, 48);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor);
                            } else {
                                composer3.useNode();
                            }
                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer3);
                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 1505994237, "C614@30562L9:Surface.kt#jmzs0o");
                            function22.invoke(composer3, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), startRestartGroup, 56);
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                shape4 = shape3;
                j7 = j5;
                borderStroke3 = borderStroke2;
                mutableInteractionSource4 = mutableInteractionSource3;
                indication4 = indication3;
                z5 = z3;
                str3 = str2;
                role3 = role2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            shape2 = shape;
            if ((i & 7168) == 0) {
            }
            if ((i & 57344) == 0) {
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            i7 = i3 & 64;
            if (i7 != 0) {
            }
            i8 = i3 & 128;
            if (i8 != 0) {
            }
            if ((i & 234881024) == 0) {
            }
            i9 = i3 & 512;
            if (i9 != 0) {
            }
            i10 = i9;
            i11 = i3 & 1024;
            if (i11 == 0) {
            }
            i14 = i3 & 2048;
            if (i14 == 0) {
            }
            int i1922 = i13;
            if ((i3 & 4096) == 0) {
            }
            if ((i4 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i18 != 0) {
            }
            if (i5 != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if ((i3 & 256) != 0) {
            }
            if (i10 != 0) {
            }
            if (i12 != 0) {
            }
            if (i15 != 0) {
            }
            long j8222 = j4;
            modifier3 = modifier2;
            i4 = i16;
            long j9222 = j3;
            shape3 = shape2;
            j5 = j8222;
            j6 = j9222;
            z4 = z2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<Dp> localAbsoluteElevation222 = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2222 = startRestartGroup.consume(localAbsoluteElevation222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final float m6389constructorimpl222 = Dp.m6389constructorimpl(((Dp) consume2222).m6403unboximpl() + f2);
            ProvidedValue[] providedValueArr222 = new ProvidedValue[2];
            providedValueArr222[0] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j6));
            providedValueArr222[z4] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl222));
            final Function0<Unit> function03222 = function02;
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr222, ComposableLambdaKt.composableLambda(startRestartGroup, 149594672, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$13
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

                public final void invoke(Composer composer3, int i20) {
                    long m1789surfaceColorAtElevationcq6XJ1M;
                    Modifier m1788surface8ww4TTg;
                    ComposerKt.sourceInformation(composer3, "C596@29913L7,594@29784L221,589@29608L973:Surface.kt#jmzs0o");
                    if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(149594672, i20, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:589)");
                        }
                        Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                        Shape shape5 = shape3;
                        long j11 = j5;
                        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume3 = composer3.consume(localElevationOverlay);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j11, (ElevationOverlay) consume3, m6389constructorimpl222, composer3, 0);
                        m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke2, f2);
                        Modifier then = m1788surface8ww4TTg.then(ClickableKt.m558clickableO2vRcR0(Modifier.INSTANCE, mutableInteractionSource3, indication3, z3, str2, role2, function03222));
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer3.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer3, 48);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor);
                        } else {
                            composer3.useNode();
                        }
                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer3);
                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 1505994237, "C614@30562L9:Surface.kt#jmzs0o");
                        function22.invoke(composer3, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), startRestartGroup, 56);
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            shape4 = shape3;
            j7 = j5;
            borderStroke3 = borderStroke2;
            mutableInteractionSource4 = mutableInteractionSource3;
            indication4 = indication3;
            z5 = z3;
            str3 = str2;
            role3 = role2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        shape2 = shape;
        if ((i & 7168) == 0) {
        }
        if ((i & 57344) == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        i7 = i3 & 64;
        if (i7 != 0) {
        }
        i8 = i3 & 128;
        if (i8 != 0) {
        }
        if ((i & 234881024) == 0) {
        }
        i9 = i3 & 512;
        if (i9 != 0) {
        }
        i10 = i9;
        i11 = i3 & 1024;
        if (i11 == 0) {
        }
        i14 = i3 & 2048;
        if (i14 == 0) {
        }
        int i19222 = i13;
        if ((i3 & 4096) == 0) {
        }
        if ((i4 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i18 != 0) {
        }
        if (i5 != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if ((i3 & 256) != 0) {
        }
        if (i10 != 0) {
        }
        if (i12 != 0) {
        }
        if (i15 != 0) {
        }
        long j82222 = j4;
        modifier3 = modifier2;
        i4 = i16;
        long j92222 = j3;
        shape3 = shape2;
        j5 = j82222;
        j6 = j92222;
        z4 = z2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<Dp> localAbsoluteElevation2222 = ElevationOverlayKt.getLocalAbsoluteElevation();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22222 = startRestartGroup.consume(localAbsoluteElevation2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final float m6389constructorimpl2222 = Dp.m6389constructorimpl(((Dp) consume22222).m6403unboximpl() + f2);
        ProvidedValue[] providedValueArr2222 = new ProvidedValue[2];
        providedValueArr2222[0] = ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j6));
        providedValueArr2222[z4] = ElevationOverlayKt.getLocalAbsoluteElevation().provides(Dp.m6387boximpl(m6389constructorimpl2222));
        final Function0<Unit> function032222 = function02;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr2222, ComposableLambdaKt.composableLambda(startRestartGroup, 149594672, z4, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SurfaceKt$Surface$13
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

            public final void invoke(Composer composer3, int i20) {
                long m1789surfaceColorAtElevationcq6XJ1M;
                Modifier m1788surface8ww4TTg;
                ComposerKt.sourceInformation(composer3, "C596@29913L7,594@29784L221,589@29608L973:Surface.kt#jmzs0o");
                if ((i20 & 11) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(149594672, i20, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:589)");
                    }
                    Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                    Shape shape5 = shape3;
                    long j11 = j5;
                    ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume3 = composer3.consume(localElevationOverlay);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    m1789surfaceColorAtElevationcq6XJ1M = SurfaceKt.m1789surfaceColorAtElevationcq6XJ1M(j11, (ElevationOverlay) consume3, m6389constructorimpl2222, composer3, 0);
                    m1788surface8ww4TTg = SurfaceKt.m1788surface8ww4TTg(minimumInteractiveComponentSize, shape5, m1789surfaceColorAtElevationcq6XJ1M, borderStroke2, f2);
                    Modifier then = m1788surface8ww4TTg.then(ClickableKt.m558clickableO2vRcR0(Modifier.INSTANCE, mutableInteractionSource3, indication3, z3, str2, role2, function032222));
                    Function2<Composer, Integer, Unit> function22 = function2;
                    composer3.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer3, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer3, 48);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)78@3182L23,80@3272L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
                    if (!(composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer m3593constructorimpl = Updater.m3593constructorimpl(composer3);
                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, 1505994237, "C614@30562L9:Surface.kt#jmzs0o");
                    function22.invoke(composer3, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceableGroup();
                    composer3.endNode();
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), startRestartGroup, 56);
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        shape4 = shape3;
        j7 = j5;
        borderStroke3 = borderStroke2;
        mutableInteractionSource4 = mutableInteractionSource3;
        indication4 = indication3;
        z5 = z3;
        str3 = str2;
        role3 = role2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: surface-8ww4TTg, reason: not valid java name */
    public static final Modifier m1788surface8ww4TTg(Modifier modifier, Shape shape, long j, BorderStroke borderStroke, float f) {
        Modifier m3735shadows4CzXII$default = ShadowKt.m3735shadows4CzXII$default(modifier, f, shape, false, 0L, 0L, 24, null);
        Modifier.Companion companion = Modifier.INSTANCE;
        if (borderStroke != null) {
            companion = BorderKt.border(companion, borderStroke, shape);
        }
        return ClipKt.clip(BackgroundKt.m526backgroundbw27NRU(m3735shadows4CzXII$default.then(companion), j, shape), shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: surfaceColorAtElevation-cq6XJ1M, reason: not valid java name */
    public static final long m1789surfaceColorAtElevationcq6XJ1M(long j, ElevationOverlay elevationOverlay, float f, Composer composer, int i) {
        Composer composer2;
        long j2;
        composer.startReplaceableGroup(1561611256);
        ComposerKt.sourceInformation(composer, "C(surfaceColorAtElevation)P(1:c#ui.graphics.Color,2,0:c#ui.unit.Dp)635@31093L6,636@31164L31:Surface.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1561611256, i, -1, "androidx.compose.material.surfaceColorAtElevation (Surface.kt:634)");
        }
        if (!Color.m4064equalsimpl0(j, MaterialTheme.INSTANCE.getColors(composer, 6).m1607getSurface0d7_KjU()) || elevationOverlay == null) {
            composer2 = composer;
            j2 = j;
        } else {
            composer2 = composer;
            j2 = elevationOverlay.mo1643apply7g2Lkgo(j, f, composer2, (i & 14) | ((i >> 3) & 112) | ((i << 3) & 896));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer2.endReplaceableGroup();
        return j2;
    }
}
