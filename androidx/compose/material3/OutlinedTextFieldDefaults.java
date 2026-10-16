package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: TextFieldDefaults.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b)\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JP\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u009c\u0002\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%2\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00180'¢\u0006\u0002\b(2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\b\b\u0002\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u0002042\u0013\b\u0002\u00105\u001a\r\u0012\u0004\u0012\u00020\u00180'¢\u0006\u0002\b(H\u0007¢\u0006\u0002\u00106J\r\u0010\u001e\u001a\u00020\u0013H\u0007¢\u0006\u0002\u00107JÂ\u0003\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u0002092\b\b\u0002\u0010;\u001a\u0002092\b\b\u0002\u0010<\u001a\u0002092\b\b\u0002\u0010=\u001a\u0002092\b\b\u0002\u0010>\u001a\u0002092\b\b\u0002\u0010?\u001a\u0002092\b\b\u0002\u0010@\u001a\u0002092\b\b\u0002\u0010A\u001a\u0002092\b\b\u0002\u0010B\u001a\u0002092\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\b\b\u0002\u0010E\u001a\u0002092\b\b\u0002\u0010F\u001a\u0002092\b\b\u0002\u0010G\u001a\u0002092\b\b\u0002\u0010H\u001a\u0002092\b\b\u0002\u0010I\u001a\u0002092\b\b\u0002\u0010J\u001a\u0002092\b\b\u0002\u0010K\u001a\u0002092\b\b\u0002\u0010L\u001a\u0002092\b\b\u0002\u0010M\u001a\u0002092\b\b\u0002\u0010N\u001a\u0002092\b\b\u0002\u0010O\u001a\u0002092\b\b\u0002\u0010P\u001a\u0002092\b\b\u0002\u0010Q\u001a\u0002092\b\b\u0002\u0010R\u001a\u0002092\b\b\u0002\u0010S\u001a\u0002092\b\b\u0002\u0010T\u001a\u0002092\b\b\u0002\u0010U\u001a\u0002092\b\b\u0002\u0010V\u001a\u0002092\b\b\u0002\u0010W\u001a\u0002092\b\b\u0002\u0010X\u001a\u0002092\b\b\u0002\u0010Y\u001a\u0002092\b\b\u0002\u0010Z\u001a\u0002092\b\b\u0002\u0010[\u001a\u0002092\b\b\u0002\u0010\\\u001a\u0002092\b\b\u0002\u0010]\u001a\u0002092\b\b\u0002\u0010^\u001a\u0002092\b\b\u0002\u0010_\u001a\u0002092\b\b\u0002\u0010`\u001a\u0002092\b\b\u0002\u0010a\u001a\u0002092\b\b\u0002\u0010b\u001a\u0002092\b\b\u0002\u0010c\u001a\u0002092\b\b\u0002\u0010d\u001a\u000209H\u0007ø\u0001\u0000¢\u0006\u0004\be\u0010fJ8\u00103\u001a\u0002042\b\b\u0002\u0010g\u001a\u00020\u00042\b\b\u0002\u0010h\u001a\u00020\u00042\b\b\u0002\u0010i\u001a\u00020\u00042\b\b\u0002\u0010j\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\bk\u0010lR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u00148AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006m"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldDefaults;", "", "()V", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultOutlinedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultOutlinedTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "ContainerBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "focusedBorderThickness", "unfocusedBorderThickness", "ContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "start", "top", "end", "bottom", "contentPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OutlinedTextFieldDefaults {
    public static final int $stable = 0;
    public static final OutlinedTextFieldDefaults INSTANCE = new OutlinedTextFieldDefaults();
    private static final float MinHeight = Dp.m6389constructorimpl(56);
    private static final float MinWidth = Dp.m6389constructorimpl(280);
    private static final float UnfocusedBorderThickness = Dp.m6389constructorimpl(1);
    private static final float FocusedBorderThickness = Dp.m6389constructorimpl(2);

    private OutlinedTextFieldDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(-1066756961);
        ComposerKt.sourceInformation(composer, "C1409@77141L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1066756961, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-shape> (TextFieldDefaults.kt:1409)");
        }
        Shape value = ShapesKt.getValue(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m2386getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m2387getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m2388getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m2385getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0130, code lost:
    
        if ((r27 & 64) != 0) goto L119;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x009a  */
    /* renamed from: ContainerBox-nbWgWpA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2382ContainerBoxnbWgWpA(final boolean z, final boolean z2, final InteractionSource interactionSource, final TextFieldColors textFieldColors, Shape shape, float f, float f2, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        boolean z4;
        InteractionSource interactionSource2;
        Shape shape2;
        float f3;
        float f4;
        OutlinedTextFieldDefaults outlinedTextFieldDefaults;
        State m2770animateBorderStrokeAsStateNuRrP5Q;
        final Shape shape3;
        final float f5;
        final float f6;
        ScopeUpdateScope endRestartGroup;
        int i4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1461761386);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContainerBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)1456@79023L5,1460@79190L203,1472@79535L51,1468@79402L216:TextFieldDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 6) == 0) {
                i3 = (startRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            z4 = z2;
            i3 |= startRestartGroup.changed(z4) ? 32 : 16;
            if ((i2 & 4) == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                interactionSource2 = interactionSource;
                i3 |= startRestartGroup.changed(interactionSource2) ? 256 : 128;
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changed(textFieldColors) ? 2048 : 1024;
                    if ((i & 24576) != 0) {
                        if ((i2 & 16) == 0) {
                            shape2 = shape;
                            if (startRestartGroup.changed(shape2)) {
                                i6 = 16384;
                                i3 |= i6;
                            }
                        } else {
                            shape2 = shape;
                        }
                        i6 = 8192;
                        i3 |= i6;
                    } else {
                        shape2 = shape;
                    }
                    if ((196608 & i) != 0) {
                        if ((i2 & 32) == 0) {
                            f3 = f;
                            if (startRestartGroup.changed(f3)) {
                                i5 = 131072;
                                i3 |= i5;
                            }
                        } else {
                            f3 = f;
                        }
                        i5 = 65536;
                        i3 |= i5;
                    } else {
                        f3 = f;
                    }
                    if ((1572864 & i) != 0) {
                        if ((i2 & 64) == 0) {
                            f4 = f2;
                            if (startRestartGroup.changed(f4)) {
                                i4 = 1048576;
                                i3 |= i4;
                            }
                        } else {
                            f4 = f2;
                        }
                        i4 = 524288;
                        i3 |= i4;
                    } else {
                        f4 = f2;
                    }
                    if ((i2 & 128) == 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        outlinedTextFieldDefaults = this;
                        i3 |= startRestartGroup.changed(outlinedTextFieldDefaults) ? 8388608 : 4194304;
                        if ((4793491 & i3) == 4793490 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if ((i2 & 16) != 0) {
                                    shape2 = ShapesKt.getValue(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), startRestartGroup, 6);
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    f3 = FocusedBorderThickness;
                                    i3 &= -458753;
                                }
                                if ((i2 & 64) != 0) {
                                    f4 = UnfocusedBorderThickness;
                                    i3 &= -3670017;
                                }
                                float f7 = f4;
                                Shape shape4 = shape2;
                                float f8 = f3;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1461761386, i3, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.ContainerBox (TextFieldDefaults.kt:1459)");
                                }
                                int i7 = i3 & 8190;
                                int i8 = i3 >> 3;
                                m2770animateBorderStrokeAsStateNuRrP5Q = TextFieldDefaultsKt.m2770animateBorderStrokeAsStateNuRrP5Q(z3, z4, interactionSource2, textFieldColors, f8, f7, startRestartGroup, (57344 & i8) | i7 | (i8 & 458752));
                                BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(BorderKt.border(Modifier.INSTANCE, (BorderStroke) m2770animateBorderStrokeAsStateNuRrP5Q.getValue(), shape4), textFieldColors.containerColor$material3_release(z, z2, interactionSource, startRestartGroup, i7).getValue().m4073unboximpl(), shape4), startRestartGroup, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                startRestartGroup = startRestartGroup;
                                shape3 = shape4;
                                f5 = f8;
                                f6 = f7;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i3 &= -458753;
                                }
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            shape3 = shape2;
                            f5 = f3;
                            f6 = f4;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final OutlinedTextFieldDefaults outlinedTextFieldDefaults2 = outlinedTextFieldDefaults;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$ContainerBox$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i9) {
                                    OutlinedTextFieldDefaults.this.m2382ContainerBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape3, f5, f6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    outlinedTextFieldDefaults = this;
                    if ((4793491 & i3) == 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if ((i2 & 16) != 0) {
                    }
                    if ((i2 & 32) != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    float f72 = f4;
                    Shape shape42 = shape2;
                    float f82 = f3;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i72 = i3 & 8190;
                    int i82 = i3 >> 3;
                    m2770animateBorderStrokeAsStateNuRrP5Q = TextFieldDefaultsKt.m2770animateBorderStrokeAsStateNuRrP5Q(z3, z4, interactionSource2, textFieldColors, f82, f72, startRestartGroup, (57344 & i82) | i72 | (i82 & 458752));
                    BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(BorderKt.border(Modifier.INSTANCE, (BorderStroke) m2770animateBorderStrokeAsStateNuRrP5Q.getValue(), shape42), textFieldColors.containerColor$material3_release(z, z2, interactionSource, startRestartGroup, i72).getValue().m4073unboximpl(), shape42), startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup = startRestartGroup;
                    shape3 = shape42;
                    f5 = f82;
                    f6 = f72;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                if ((i & 24576) != 0) {
                }
                if ((196608 & i) != 0) {
                }
                if ((1572864 & i) != 0) {
                }
                if ((i2 & 128) == 0) {
                }
                outlinedTextFieldDefaults = this;
                if ((4793491 & i3) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if ((i2 & 16) != 0) {
                }
                if ((i2 & 32) != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                float f722 = f4;
                Shape shape422 = shape2;
                float f822 = f3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i722 = i3 & 8190;
                int i822 = i3 >> 3;
                m2770animateBorderStrokeAsStateNuRrP5Q = TextFieldDefaultsKt.m2770animateBorderStrokeAsStateNuRrP5Q(z3, z4, interactionSource2, textFieldColors, f822, f722, startRestartGroup, (57344 & i822) | i722 | (i822 & 458752));
                BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(BorderKt.border(Modifier.INSTANCE, (BorderStroke) m2770animateBorderStrokeAsStateNuRrP5Q.getValue(), shape422), textFieldColors.containerColor$material3_release(z, z2, interactionSource, startRestartGroup, i722).getValue().m4073unboximpl(), shape422), startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup = startRestartGroup;
                shape3 = shape422;
                f5 = f822;
                f6 = f722;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            interactionSource2 = interactionSource;
            if ((i2 & 8) != 0) {
            }
            if ((i & 24576) != 0) {
            }
            if ((196608 & i) != 0) {
            }
            if ((1572864 & i) != 0) {
            }
            if ((i2 & 128) == 0) {
            }
            outlinedTextFieldDefaults = this;
            if ((4793491 & i3) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            if ((i2 & 32) != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            float f7222 = f4;
            Shape shape4222 = shape2;
            float f8222 = f3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i7222 = i3 & 8190;
            int i8222 = i3 >> 3;
            m2770animateBorderStrokeAsStateNuRrP5Q = TextFieldDefaultsKt.m2770animateBorderStrokeAsStateNuRrP5Q(z3, z4, interactionSource2, textFieldColors, f8222, f7222, startRestartGroup, (57344 & i8222) | i7222 | (i8222 & 458752));
            BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(BorderKt.border(Modifier.INSTANCE, (BorderStroke) m2770animateBorderStrokeAsStateNuRrP5Q.getValue(), shape4222), textFieldColors.containerColor$material3_release(z, z2, interactionSource, startRestartGroup, i7222).getValue().m4073unboximpl(), shape4222), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup = startRestartGroup;
            shape3 = shape4222;
            f5 = f8222;
            f6 = f7222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        z4 = z2;
        if ((i2 & 4) == 0) {
        }
        interactionSource2 = interactionSource;
        if ((i2 & 8) != 0) {
        }
        if ((i & 24576) != 0) {
        }
        if ((196608 & i) != 0) {
        }
        if ((1572864 & i) != 0) {
        }
        if ((i2 & 128) == 0) {
        }
        outlinedTextFieldDefaults = this;
        if ((4793491 & i3) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        if ((i2 & 32) != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        float f72222 = f4;
        Shape shape42222 = shape2;
        float f82222 = f3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i72222 = i3 & 8190;
        int i82222 = i3 >> 3;
        m2770animateBorderStrokeAsStateNuRrP5Q = TextFieldDefaultsKt.m2770animateBorderStrokeAsStateNuRrP5Q(z3, z4, interactionSource2, textFieldColors, f82222, f72222, startRestartGroup, (57344 & i82222) | i72222 | (i82222 & 458752));
        BoxKt.Box(BackgroundKt.m526backgroundbw27NRU(BorderKt.border(Modifier.INSTANCE, (BorderStroke) m2770animateBorderStrokeAsStateNuRrP5Q.getValue(), shape42222), textFieldColors.containerColor$material3_release(z, z2, interactionSource, startRestartGroup, i72222).getValue().m4073unboximpl(), shape42222), startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup = startRestartGroup;
        shape3 = shape42222;
        f5 = f82222;
        f6 = f72222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* renamed from: contentPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m2381contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults outlinedTextFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return outlinedTextFieldDefaults.m2384contentPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: contentPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m2384contentPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m875PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    public final TextFieldColors colors(Composer composer, int i) {
        composer.startReplaceableGroup(-471651810);
        ComposerKt.sourceInformation(composer, "C(colors)1492@80238L11,1492@80250L30:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-471651810, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1492)");
        }
        TextFieldColors defaultOutlinedTextFieldColors = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultOutlinedTextFieldColors;
    }

    /* renamed from: colors-0hiis_0, reason: not valid java name */
    public final TextFieldColors m2383colors0hiis_0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, Composer composer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        composer.startReplaceableGroup(1767617725);
        ComposerKt.sourceInformation(composer, "C(colors)P(30:c#ui.graphics.Color,41:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,23:c#ui.graphics.Color,34:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,0:c#ui.graphics.Color,13:c#ui.graphics.Color,32,22:c#ui.graphics.Color,33:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,25:c#ui.graphics.Color,36:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,31:c#ui.graphics.Color,42:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,24:c#ui.graphics.Color,35:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,26:c#ui.graphics.Color,37:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,29:c#ui.graphics.Color,40:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,27:c#ui.graphics.Color,38:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,28:c#ui.graphics.Color,39:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)1593@87042L11,1593@87054L30:TextFieldDefaults.kt#uh7d8r");
        long m4099getUnspecified0d7_KjU = (i6 & 1) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j;
        long m4099getUnspecified0d7_KjU2 = (i6 & 2) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j2;
        long m4099getUnspecified0d7_KjU3 = (i6 & 4) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j3;
        long m4099getUnspecified0d7_KjU4 = (i6 & 8) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j4;
        long m4099getUnspecified0d7_KjU5 = (i6 & 16) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j5;
        long m4099getUnspecified0d7_KjU6 = (i6 & 32) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j6;
        long m4099getUnspecified0d7_KjU7 = (i6 & 64) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j7;
        long m4099getUnspecified0d7_KjU8 = (i6 & 128) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j8;
        long m4099getUnspecified0d7_KjU9 = (i6 & 256) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j9;
        long m4099getUnspecified0d7_KjU10 = (i6 & 512) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j10;
        TextSelectionColors textSelectionColors2 = (i6 & 1024) != 0 ? null : textSelectionColors;
        long m4099getUnspecified0d7_KjU11 = (i6 & 2048) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j11;
        long m4099getUnspecified0d7_KjU12 = (i6 & 4096) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j12;
        long m4099getUnspecified0d7_KjU13 = (i6 & 8192) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j13;
        long m4099getUnspecified0d7_KjU14 = (i6 & 16384) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j14;
        long m4099getUnspecified0d7_KjU15 = (32768 & i6) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j15;
        long m4099getUnspecified0d7_KjU16 = (65536 & i6) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j16;
        long m4099getUnspecified0d7_KjU17 = (131072 & i6) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j17;
        long m4099getUnspecified0d7_KjU18 = (262144 & i6) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j18;
        long m4099getUnspecified0d7_KjU19 = (524288 & i6) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j19;
        long m4099getUnspecified0d7_KjU20 = (1048576 & i6) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j20;
        long m4099getUnspecified0d7_KjU21 = (2097152 & i6) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j21;
        long m4099getUnspecified0d7_KjU22 = (4194304 & i6) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j22;
        long m4099getUnspecified0d7_KjU23 = (8388608 & i6) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j23;
        long m4099getUnspecified0d7_KjU24 = (16777216 & i6) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j24;
        long m4099getUnspecified0d7_KjU25 = (33554432 & i6) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j25;
        long m4099getUnspecified0d7_KjU26 = (67108864 & i6) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j26;
        long m4099getUnspecified0d7_KjU27 = (134217728 & i6) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j27;
        long m4099getUnspecified0d7_KjU28 = (268435456 & i6) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j28;
        long m4099getUnspecified0d7_KjU29 = (536870912 & i6) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j29;
        long m4099getUnspecified0d7_KjU30 = (i6 & 1073741824) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j30;
        long m4099getUnspecified0d7_KjU31 = (i7 & 1) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j31;
        long m4099getUnspecified0d7_KjU32 = (i7 & 2) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j32;
        long m4099getUnspecified0d7_KjU33 = (i7 & 4) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j33;
        long m4099getUnspecified0d7_KjU34 = (i7 & 8) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j34;
        long m4099getUnspecified0d7_KjU35 = (i7 & 16) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j35;
        long m4099getUnspecified0d7_KjU36 = (i7 & 32) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j36;
        long m4099getUnspecified0d7_KjU37 = (i7 & 64) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j37;
        long m4099getUnspecified0d7_KjU38 = (i7 & 128) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j38;
        long m4099getUnspecified0d7_KjU39 = (i7 & 256) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j39;
        long m4099getUnspecified0d7_KjU40 = (i7 & 512) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j40;
        long m4099getUnspecified0d7_KjU41 = (i7 & 1024) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j41;
        long m4099getUnspecified0d7_KjU42 = (i7 & 2048) != 0 ? Color.INSTANCE.m4099getUnspecified0d7_KjU() : j42;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1767617725, i, i2, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1593)");
        }
        TextFieldColors m2698copyejIjP34 = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i5 >> 6) & 112).m2698copyejIjP34(m4099getUnspecified0d7_KjU, m4099getUnspecified0d7_KjU2, m4099getUnspecified0d7_KjU3, m4099getUnspecified0d7_KjU4, m4099getUnspecified0d7_KjU5, m4099getUnspecified0d7_KjU6, m4099getUnspecified0d7_KjU7, m4099getUnspecified0d7_KjU8, m4099getUnspecified0d7_KjU9, m4099getUnspecified0d7_KjU10, textSelectionColors2, m4099getUnspecified0d7_KjU11, m4099getUnspecified0d7_KjU12, m4099getUnspecified0d7_KjU13, m4099getUnspecified0d7_KjU14, m4099getUnspecified0d7_KjU15, m4099getUnspecified0d7_KjU16, m4099getUnspecified0d7_KjU17, m4099getUnspecified0d7_KjU18, m4099getUnspecified0d7_KjU19, m4099getUnspecified0d7_KjU20, m4099getUnspecified0d7_KjU21, m4099getUnspecified0d7_KjU22, m4099getUnspecified0d7_KjU23, m4099getUnspecified0d7_KjU24, m4099getUnspecified0d7_KjU25, m4099getUnspecified0d7_KjU26, m4099getUnspecified0d7_KjU27, m4099getUnspecified0d7_KjU28, m4099getUnspecified0d7_KjU29, m4099getUnspecified0d7_KjU30, m4099getUnspecified0d7_KjU31, m4099getUnspecified0d7_KjU32, m4099getUnspecified0d7_KjU33, m4099getUnspecified0d7_KjU34, m4099getUnspecified0d7_KjU35, m4099getUnspecified0d7_KjU36, m4099getUnspecified0d7_KjU37, m4099getUnspecified0d7_KjU38, m4099getUnspecified0d7_KjU39, m4099getUnspecified0d7_KjU40, m4099getUnspecified0d7_KjU41, m4099getUnspecified0d7_KjU42);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m2698copyejIjP34;
    }

    public final TextFieldColors getDefaultOutlinedTextFieldColors(ColorScheme colorScheme, Composer composer, int i) {
        composer.startReplaceableGroup(-292363577);
        ComposerKt.sourceInformation(composer, "C*1654@90670L7,1688@93420L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-292363577, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-defaultOutlinedTextFieldColors> (TextFieldDefaults.kt:1641)");
        }
        TextFieldColors defaultOutlinedTextFieldColorsCached = colorScheme.getDefaultOutlinedTextFieldColorsCached();
        if (defaultOutlinedTextFieldColorsCached == null) {
            long fromToken = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusInputColor());
            long fromToken2 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputColor());
            long m4062copywmQWz5c$default = Color.m4062copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null);
            long fromToken3 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorInputColor());
            long m4098getTransparent0d7_KjU = Color.INSTANCE.m4098getTransparent0d7_KjU();
            long m4098getTransparent0d7_KjU2 = Color.INSTANCE.m4098getTransparent0d7_KjU();
            long m4098getTransparent0d7_KjU3 = Color.INSTANCE.m4098getTransparent0d7_KjU();
            long m4098getTransparent0d7_KjU4 = Color.INSTANCE.m4098getTransparent0d7_KjU();
            long fromToken4 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getCaretColor());
            long fromToken5 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor());
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextFieldColors textFieldColors = new TextFieldColors(fromToken, fromToken2, m4062copywmQWz5c$default, fromToken3, m4098getTransparent0d7_KjU, m4098getTransparent0d7_KjU2, m4098getTransparent0d7_KjU3, m4098getTransparent0d7_KjU4, fromToken4, fromToken5, (TextSelectionColors) consume, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getOutlineColor()), Color.m4062copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor()), Color.m4062copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor()), Color.m4062copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getLabelColor()), Color.m4062copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), Color.m4062copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getSupportingColor()), Color.m4062copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), Color.m4062copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), Color.m4062copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), null);
            colorScheme.setDefaultOutlinedTextFieldColorsCached$material3_release(textFieldColors);
            defaultOutlinedTextFieldColorsCached = textFieldColors;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultOutlinedTextFieldColorsCached;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void DecorationBox(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function29, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function210;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        Function2<? super Composer, ? super Integer, Unit> function211;
        final TextFieldColors textFieldColors2;
        PaddingValues paddingValues2;
        boolean z6;
        PaddingValues paddingValues3;
        Function2<? super Composer, ? super Integer, Unit> function212;
        ComposableLambda composableLambda;
        Composer composer2;
        Function2<? super Composer, ? super Integer, Unit> function213;
        Function2<? super Composer, ? super Integer, Unit> function214;
        Function2<? super Composer, ? super Integer, Unit> function215;
        int i20;
        Function2<? super Composer, ? super Integer, Unit> function216;
        final TextFieldColors textFieldColors3;
        Function2<? super Composer, ? super Integer, Unit> function217;
        Function2<? super Composer, ? super Integer, Unit> function218;
        PaddingValues paddingValues4;
        Function2<? super Composer, ? super Integer, Unit> function219;
        Composer composer3;
        final Function2<? super Composer, ? super Integer, Unit> function220;
        final boolean z7;
        final Function2<? super Composer, ? super Integer, Unit> function221;
        final Function2<? super Composer, ? super Integer, Unit> function222;
        final Function2<? super Composer, ? super Integer, Unit> function223;
        final Function2<? super Composer, ? super Integer, Unit> function224;
        final Function2<? super Composer, ? super Integer, Unit> function225;
        final PaddingValues paddingValues5;
        final Function2<? super Composer, ? super Integer, Unit> function226;
        final Function2<? super Composer, ? super Integer, Unit> function227;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-350442135);
        ComposerKt.sourceInformation(startRestartGroup, "C(DecorationBox)P(15,4,3,11,16,5,6,7,9,8,14,10,12,13!1,2)1778@99554L8,1789@99842L709:TextFieldDefaults.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
            if ((i3 & 4) == 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                i4 |= startRestartGroup.changed(z) ? 256 : 128;
            }
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                z4 = z2;
                i4 |= startRestartGroup.changed(z4) ? 2048 : 1024;
                int i21 = 8192;
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                    if ((i3 & 32) == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= startRestartGroup.changed(interactionSource) ? 131072 : 65536;
                    }
                    i5 = i3 & 64;
                    if (i5 == 0) {
                        i4 |= 1572864;
                        z5 = z3;
                    } else {
                        z5 = z3;
                        if ((i & 1572864) == 0) {
                            i4 |= startRestartGroup.changed(z5) ? 1048576 : 524288;
                        }
                    }
                    i6 = i3 & 128;
                    if (i6 == 0) {
                        i4 |= 12582912;
                        function210 = function22;
                    } else {
                        function210 = function22;
                        if ((i & 12582912) == 0) {
                            i4 |= startRestartGroup.changedInstance(function210) ? 8388608 : 4194304;
                        }
                    }
                    i7 = i3 & 256;
                    if (i7 == 0) {
                        i4 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i4 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                    }
                    i8 = i3 & 512;
                    if (i8 == 0) {
                        i4 |= C.ENCODING_PCM_32BIT;
                    } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                        i9 = i8;
                        i4 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                        i10 = i3 & 1024;
                        if (i10 != 0) {
                            i12 = i2 | 6;
                            i11 = i10;
                        } else if ((i2 & 6) == 0) {
                            i11 = i10;
                            i12 = i2 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                        } else {
                            i11 = i10;
                            i12 = i2;
                        }
                        i13 = i3 & 2048;
                        if (i13 != 0) {
                            i12 |= 48;
                            i14 = i13;
                        } else if ((i2 & 48) == 0) {
                            i14 = i13;
                            i12 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                        } else {
                            i14 = i13;
                        }
                        int i22 = i12;
                        i15 = i3 & 4096;
                        if (i15 != 0) {
                            i16 = i22 | 384;
                        } else if ((i2 & 384) == 0) {
                            i16 = i22 | (startRestartGroup.changedInstance(function27) ? 256 : 128);
                        } else {
                            i16 = i22;
                        }
                        i17 = i3 & 8192;
                        if (i17 != 0) {
                            i18 = i16 | 3072;
                        } else {
                            i18 = i16;
                            if ((i2 & 3072) == 0) {
                                i18 |= startRestartGroup.changedInstance(function28) ? 2048 : 1024;
                                if ((i2 & 24576) == 0) {
                                    if ((i3 & 16384) == 0 && startRestartGroup.changed(textFieldColors)) {
                                        i21 = 16384;
                                    }
                                    i18 |= i21;
                                }
                                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                    i18 |= ((i3 & 32768) == 0 && startRestartGroup.changed(paddingValues)) ? 131072 : 65536;
                                }
                                i19 = i3 & 65536;
                                if (i19 == 0) {
                                    i18 |= 1572864;
                                } else if ((i2 & 1572864) == 0) {
                                    i18 |= startRestartGroup.changedInstance(function29) ? 1048576 : 524288;
                                }
                                if ((i3 & 131072) == 0) {
                                    i18 |= 12582912;
                                } else if ((i2 & 12582912) == 0) {
                                    i18 |= startRestartGroup.changed(this) ? 8388608 : 4194304;
                                }
                                if ((i4 & 306783379) == 306783378 || (i18 & 4793491) != 4793490 || !startRestartGroup.getSkipping()) {
                                    startRestartGroup.startDefaults();
                                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        final boolean z8 = i5 == 0 ? false : z5;
                                        if (i6 != 0) {
                                            function210 = null;
                                        }
                                        Function2<? super Composer, ? super Integer, Unit> function228 = i7 == 0 ? null : function23;
                                        Function2<? super Composer, ? super Integer, Unit> function229 = i9 == 0 ? null : function24;
                                        Function2<? super Composer, ? super Integer, Unit> function230 = i11 == 0 ? null : function25;
                                        function211 = i14 == 0 ? null : function26;
                                        Function2<? super Composer, ? super Integer, Unit> function231 = i15 == 0 ? null : function27;
                                        Function2<? super Composer, ? super Integer, Unit> function232 = i17 == 0 ? function28 : null;
                                        if ((i3 & 16384) == 0) {
                                            textFieldColors2 = colors(startRestartGroup, (i18 >> 21) & 14);
                                            i18 &= -57345;
                                        } else {
                                            textFieldColors2 = textFieldColors;
                                        }
                                        if ((i3 & 32768) == 0) {
                                            paddingValues2 = m2381contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                            i18 &= -458753;
                                        } else {
                                            paddingValues2 = paddingValues;
                                        }
                                        if (i19 == 0) {
                                            paddingValues3 = paddingValues2;
                                            z6 = z8;
                                            function212 = function232;
                                            composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -1448570018, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                    invoke(composer4, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i23) {
                                                    ComposerKt.sourceInformation(composer4, "C1781@99680L135:TextFieldDefaults.kt#uh7d8r");
                                                    if ((i23 & 3) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1448570018, i23, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox.<anonymous> (TextFieldDefaults.kt:1781)");
                                                        }
                                                        OutlinedTextFieldDefaults.INSTANCE.m2382ContainerBoxnbWgWpA(z, z8, interactionSource, textFieldColors2, null, 0.0f, 0.0f, composer4, 12582912, 112);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            });
                                        } else {
                                            z6 = z8;
                                            paddingValues3 = paddingValues2;
                                            function212 = function232;
                                            composableLambda = function29;
                                        }
                                        composer2 = startRestartGroup;
                                        function213 = function229;
                                        function214 = function210;
                                        function215 = function231;
                                        i20 = i18;
                                        function216 = function212;
                                        textFieldColors3 = textFieldColors2;
                                        function217 = function228;
                                        function218 = function230;
                                        paddingValues4 = paddingValues3;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i3 & 16384) != 0) {
                                            i18 &= -57345;
                                        }
                                        if ((32768 & i3) != 0) {
                                            i18 &= -458753;
                                        }
                                        function217 = function23;
                                        function213 = function24;
                                        function211 = function26;
                                        function215 = function27;
                                        function216 = function28;
                                        textFieldColors3 = textFieldColors;
                                        paddingValues4 = paddingValues;
                                        composableLambda = function29;
                                        composer2 = startRestartGroup;
                                        z6 = z5;
                                        function214 = function210;
                                        i20 = i18;
                                        function218 = function25;
                                    }
                                    composer2.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        function219 = composableLambda;
                                    } else {
                                        function219 = composableLambda;
                                        ComposerKt.traceEventStart(-350442135, i4, i20, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1788)");
                                    }
                                    int i23 = i4 << 3;
                                    int i24 = i4 >> 3;
                                    int i25 = i20;
                                    int i26 = (i24 & 7168) | (i23 & 112) | 6 | (i23 & 896);
                                    int i27 = i4 >> 9;
                                    int i28 = i25 << 21;
                                    int i29 = i26 | (i27 & 57344) | (i27 & 458752) | (i27 & 3670016) | (i28 & 29360128) | (i28 & 234881024) | (i28 & 1879048192);
                                    int i30 = (i24 & 57344) | ((i25 >> 9) & 14) | ((i4 >> 6) & 112) | (i4 & 896) | (i27 & 7168) | (i25 & 458752) | ((i25 << 6) & 3670016) | ((i25 << 3) & 29360128);
                                    boolean z9 = z4;
                                    boolean z10 = z6;
                                    Function2<? super Composer, ? super Integer, Unit> function233 = function211;
                                    Function2<? super Composer, ? super Integer, Unit> function234 = function219;
                                    Composer composer4 = composer2;
                                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function214, function217, function213, function218, function233, function215, function216, z9, z, z10, interactionSource, paddingValues4, textFieldColors3, function234, composer4, i29, i30, 0);
                                    composer3 = composer4;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    function220 = function233;
                                    z7 = z10;
                                    function221 = function213;
                                    function222 = function218;
                                    function223 = function215;
                                    function224 = function234;
                                    function225 = function214;
                                    paddingValues5 = paddingValues4;
                                    function226 = function216;
                                    function227 = function217;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    function227 = function23;
                                    function222 = function25;
                                    function220 = function26;
                                    function223 = function27;
                                    function226 = function28;
                                    textFieldColors3 = textFieldColors;
                                    paddingValues5 = paddingValues;
                                    function224 = function29;
                                    composer3 = startRestartGroup;
                                    z7 = z5;
                                    function225 = function210;
                                    function221 = function24;
                                }
                                endRestartGroup = composer3.endRestartGroup();
                                if (endRestartGroup == null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$2
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

                                        public final void invoke(Composer composer5, int i31) {
                                            OutlinedTextFieldDefaults.this.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z7, function225, function227, function221, function222, function220, function223, function226, textFieldColors3, paddingValues5, function224, composer5, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                        }
                        if ((i2 & 24576) == 0) {
                        }
                        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        }
                        i19 = i3 & 65536;
                        if (i19 == 0) {
                        }
                        if ((i3 & 131072) == 0) {
                        }
                        if ((i4 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        if (i11 == 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i15 == 0) {
                        }
                        if (i17 == 0) {
                        }
                        if ((i3 & 16384) == 0) {
                        }
                        if ((i3 & 32768) == 0) {
                        }
                        if (i19 == 0) {
                        }
                        composer2 = startRestartGroup;
                        function213 = function229;
                        function214 = function210;
                        function215 = function231;
                        i20 = i18;
                        function216 = function212;
                        textFieldColors3 = textFieldColors2;
                        function217 = function228;
                        function218 = function230;
                        paddingValues4 = paddingValues3;
                        composer2.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i232 = i4 << 3;
                        int i242 = i4 >> 3;
                        int i252 = i20;
                        int i262 = (i242 & 7168) | (i232 & 112) | 6 | (i232 & 896);
                        int i272 = i4 >> 9;
                        int i282 = i252 << 21;
                        int i292 = i262 | (i272 & 57344) | (i272 & 458752) | (i272 & 3670016) | (i282 & 29360128) | (i282 & 234881024) | (i282 & 1879048192);
                        int i302 = (i242 & 57344) | ((i252 >> 9) & 14) | ((i4 >> 6) & 112) | (i4 & 896) | (i272 & 7168) | (i252 & 458752) | ((i252 << 6) & 3670016) | ((i252 << 3) & 29360128);
                        boolean z92 = z4;
                        boolean z102 = z6;
                        Function2<? super Composer, ? super Integer, Unit> function2332 = function211;
                        Function2<? super Composer, ? super Integer, Unit> function2342 = function219;
                        Composer composer42 = composer2;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function214, function217, function213, function218, function2332, function215, function216, z92, z, z102, interactionSource, paddingValues4, textFieldColors3, function2342, composer42, i292, i302, 0);
                        composer3 = composer42;
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function220 = function2332;
                        z7 = z102;
                        function221 = function213;
                        function222 = function218;
                        function223 = function215;
                        function224 = function2342;
                        function225 = function214;
                        paddingValues5 = paddingValues4;
                        function226 = function216;
                        function227 = function217;
                        endRestartGroup = composer3.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i9 = i8;
                    i10 = i3 & 1024;
                    if (i10 != 0) {
                    }
                    i13 = i3 & 2048;
                    if (i13 != 0) {
                    }
                    int i222 = i12;
                    i15 = i3 & 4096;
                    if (i15 != 0) {
                    }
                    i17 = i3 & 8192;
                    if (i17 != 0) {
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    i19 = i3 & 65536;
                    if (i19 == 0) {
                    }
                    if ((i3 & 131072) == 0) {
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i5 == 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (i11 == 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i15 == 0) {
                    }
                    if (i17 == 0) {
                    }
                    if ((i3 & 16384) == 0) {
                    }
                    if ((i3 & 32768) == 0) {
                    }
                    if (i19 == 0) {
                    }
                    composer2 = startRestartGroup;
                    function213 = function229;
                    function214 = function210;
                    function215 = function231;
                    i20 = i18;
                    function216 = function212;
                    textFieldColors3 = textFieldColors2;
                    function217 = function228;
                    function218 = function230;
                    paddingValues4 = paddingValues3;
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i2322 = i4 << 3;
                    int i2422 = i4 >> 3;
                    int i2522 = i20;
                    int i2622 = (i2422 & 7168) | (i2322 & 112) | 6 | (i2322 & 896);
                    int i2722 = i4 >> 9;
                    int i2822 = i2522 << 21;
                    int i2922 = i2622 | (i2722 & 57344) | (i2722 & 458752) | (i2722 & 3670016) | (i2822 & 29360128) | (i2822 & 234881024) | (i2822 & 1879048192);
                    int i3022 = (i2422 & 57344) | ((i2522 >> 9) & 14) | ((i4 >> 6) & 112) | (i4 & 896) | (i2722 & 7168) | (i2522 & 458752) | ((i2522 << 6) & 3670016) | ((i2522 << 3) & 29360128);
                    boolean z922 = z4;
                    boolean z1022 = z6;
                    Function2<? super Composer, ? super Integer, Unit> function23322 = function211;
                    Function2<? super Composer, ? super Integer, Unit> function23422 = function219;
                    Composer composer422 = composer2;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function214, function217, function213, function218, function23322, function215, function216, z922, z, z1022, interactionSource, paddingValues4, textFieldColors3, function23422, composer422, i2922, i3022, 0);
                    composer3 = composer422;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function220 = function23322;
                    z7 = z1022;
                    function221 = function213;
                    function222 = function218;
                    function223 = function215;
                    function224 = function23422;
                    function225 = function214;
                    paddingValues5 = paddingValues4;
                    function226 = function216;
                    function227 = function217;
                    endRestartGroup = composer3.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                if ((i3 & 32) == 0) {
                }
                i5 = i3 & 64;
                if (i5 == 0) {
                }
                i6 = i3 & 128;
                if (i6 == 0) {
                }
                i7 = i3 & 256;
                if (i7 == 0) {
                }
                i8 = i3 & 512;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i3 & 1024;
                if (i10 != 0) {
                }
                i13 = i3 & 2048;
                if (i13 != 0) {
                }
                int i2222 = i12;
                i15 = i3 & 4096;
                if (i15 != 0) {
                }
                i17 = i3 & 8192;
                if (i17 != 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                i19 = i3 & 65536;
                if (i19 == 0) {
                }
                if ((i3 & 131072) == 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i5 == 0) {
                }
                if (i6 != 0) {
                }
                if (i7 == 0) {
                }
                if (i9 == 0) {
                }
                if (i11 == 0) {
                }
                if (i14 == 0) {
                }
                if (i15 == 0) {
                }
                if (i17 == 0) {
                }
                if ((i3 & 16384) == 0) {
                }
                if ((i3 & 32768) == 0) {
                }
                if (i19 == 0) {
                }
                composer2 = startRestartGroup;
                function213 = function229;
                function214 = function210;
                function215 = function231;
                i20 = i18;
                function216 = function212;
                textFieldColors3 = textFieldColors2;
                function217 = function228;
                function218 = function230;
                paddingValues4 = paddingValues3;
                composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i23222 = i4 << 3;
                int i24222 = i4 >> 3;
                int i25222 = i20;
                int i26222 = (i24222 & 7168) | (i23222 & 112) | 6 | (i23222 & 896);
                int i27222 = i4 >> 9;
                int i28222 = i25222 << 21;
                int i29222 = i26222 | (i27222 & 57344) | (i27222 & 458752) | (i27222 & 3670016) | (i28222 & 29360128) | (i28222 & 234881024) | (i28222 & 1879048192);
                int i30222 = (i24222 & 57344) | ((i25222 >> 9) & 14) | ((i4 >> 6) & 112) | (i4 & 896) | (i27222 & 7168) | (i25222 & 458752) | ((i25222 << 6) & 3670016) | ((i25222 << 3) & 29360128);
                boolean z9222 = z4;
                boolean z10222 = z6;
                Function2<? super Composer, ? super Integer, Unit> function233222 = function211;
                Function2<? super Composer, ? super Integer, Unit> function234222 = function219;
                Composer composer4222 = composer2;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function214, function217, function213, function218, function233222, function215, function216, z9222, z, z10222, interactionSource, paddingValues4, textFieldColors3, function234222, composer4222, i29222, i30222, 0);
                composer3 = composer4222;
                if (ComposerKt.isTraceInProgress()) {
                }
                function220 = function233222;
                z7 = z10222;
                function221 = function213;
                function222 = function218;
                function223 = function215;
                function224 = function234222;
                function225 = function214;
                paddingValues5 = paddingValues4;
                function226 = function216;
                function227 = function217;
                endRestartGroup = composer3.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            z4 = z2;
            int i212 = 8192;
            if ((i3 & 16) != 0) {
            }
            if ((i3 & 32) == 0) {
            }
            i5 = i3 & 64;
            if (i5 == 0) {
            }
            i6 = i3 & 128;
            if (i6 == 0) {
            }
            i7 = i3 & 256;
            if (i7 == 0) {
            }
            i8 = i3 & 512;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i3 & 1024;
            if (i10 != 0) {
            }
            i13 = i3 & 2048;
            if (i13 != 0) {
            }
            int i22222 = i12;
            i15 = i3 & 4096;
            if (i15 != 0) {
            }
            i17 = i3 & 8192;
            if (i17 != 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            i19 = i3 & 65536;
            if (i19 == 0) {
            }
            if ((i3 & 131072) == 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i5 == 0) {
            }
            if (i6 != 0) {
            }
            if (i7 == 0) {
            }
            if (i9 == 0) {
            }
            if (i11 == 0) {
            }
            if (i14 == 0) {
            }
            if (i15 == 0) {
            }
            if (i17 == 0) {
            }
            if ((i3 & 16384) == 0) {
            }
            if ((i3 & 32768) == 0) {
            }
            if (i19 == 0) {
            }
            composer2 = startRestartGroup;
            function213 = function229;
            function214 = function210;
            function215 = function231;
            i20 = i18;
            function216 = function212;
            textFieldColors3 = textFieldColors2;
            function217 = function228;
            function218 = function230;
            paddingValues4 = paddingValues3;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i232222 = i4 << 3;
            int i242222 = i4 >> 3;
            int i252222 = i20;
            int i262222 = (i242222 & 7168) | (i232222 & 112) | 6 | (i232222 & 896);
            int i272222 = i4 >> 9;
            int i282222 = i252222 << 21;
            int i292222 = i262222 | (i272222 & 57344) | (i272222 & 458752) | (i272222 & 3670016) | (i282222 & 29360128) | (i282222 & 234881024) | (i282222 & 1879048192);
            int i302222 = (i242222 & 57344) | ((i252222 >> 9) & 14) | ((i4 >> 6) & 112) | (i4 & 896) | (i272222 & 7168) | (i252222 & 458752) | ((i252222 << 6) & 3670016) | ((i252222 << 3) & 29360128);
            boolean z92222 = z4;
            boolean z102222 = z6;
            Function2<? super Composer, ? super Integer, Unit> function2332222 = function211;
            Function2<? super Composer, ? super Integer, Unit> function2342222 = function219;
            Composer composer42222 = composer2;
            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function214, function217, function213, function218, function2332222, function215, function216, z92222, z, z102222, interactionSource, paddingValues4, textFieldColors3, function2342222, composer42222, i292222, i302222, 0);
            composer3 = composer42222;
            if (ComposerKt.isTraceInProgress()) {
            }
            function220 = function2332222;
            z7 = z102222;
            function221 = function213;
            function222 = function218;
            function223 = function215;
            function224 = function2342222;
            function225 = function214;
            paddingValues5 = paddingValues4;
            function226 = function216;
            function227 = function217;
            endRestartGroup = composer3.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        if ((i3 & 8) == 0) {
        }
        z4 = z2;
        int i2122 = 8192;
        if ((i3 & 16) != 0) {
        }
        if ((i3 & 32) == 0) {
        }
        i5 = i3 & 64;
        if (i5 == 0) {
        }
        i6 = i3 & 128;
        if (i6 == 0) {
        }
        i7 = i3 & 256;
        if (i7 == 0) {
        }
        i8 = i3 & 512;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i3 & 1024;
        if (i10 != 0) {
        }
        i13 = i3 & 2048;
        if (i13 != 0) {
        }
        int i222222 = i12;
        i15 = i3 & 4096;
        if (i15 != 0) {
        }
        i17 = i3 & 8192;
        if (i17 != 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i19 = i3 & 65536;
        if (i19 == 0) {
        }
        if ((i3 & 131072) == 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 == 0) {
        }
        if (i6 != 0) {
        }
        if (i7 == 0) {
        }
        if (i9 == 0) {
        }
        if (i11 == 0) {
        }
        if (i14 == 0) {
        }
        if (i15 == 0) {
        }
        if (i17 == 0) {
        }
        if ((i3 & 16384) == 0) {
        }
        if ((i3 & 32768) == 0) {
        }
        if (i19 == 0) {
        }
        composer2 = startRestartGroup;
        function213 = function229;
        function214 = function210;
        function215 = function231;
        i20 = i18;
        function216 = function212;
        textFieldColors3 = textFieldColors2;
        function217 = function228;
        function218 = function230;
        paddingValues4 = paddingValues3;
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i2322222 = i4 << 3;
        int i2422222 = i4 >> 3;
        int i2522222 = i20;
        int i2622222 = (i2422222 & 7168) | (i2322222 & 112) | 6 | (i2322222 & 896);
        int i2722222 = i4 >> 9;
        int i2822222 = i2522222 << 21;
        int i2922222 = i2622222 | (i2722222 & 57344) | (i2722222 & 458752) | (i2722222 & 3670016) | (i2822222 & 29360128) | (i2822222 & 234881024) | (i2822222 & 1879048192);
        int i3022222 = (i2422222 & 57344) | ((i2522222 >> 9) & 14) | ((i4 >> 6) & 112) | (i4 & 896) | (i2722222 & 7168) | (i2522222 & 458752) | ((i2522222 << 6) & 3670016) | ((i2522222 << 3) & 29360128);
        boolean z922222 = z4;
        boolean z1022222 = z6;
        Function2<? super Composer, ? super Integer, Unit> function23322222 = function211;
        Function2<? super Composer, ? super Integer, Unit> function23422222 = function219;
        Composer composer422222 = composer2;
        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function214, function217, function213, function218, function23322222, function215, function216, z922222, z, z1022222, interactionSource, paddingValues4, textFieldColors3, function23422222, composer422222, i2922222, i3022222, 0);
        composer3 = composer422222;
        if (ComposerKt.isTraceInProgress()) {
        }
        function220 = function23322222;
        z7 = z1022222;
        function221 = function213;
        function222 = function218;
        function223 = function215;
        function224 = function23422222;
        function225 = function214;
        paddingValues5 = paddingValues4;
        function226 = function216;
        function227 = function217;
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
