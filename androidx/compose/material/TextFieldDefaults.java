package androidx.compose.material;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: TextFieldDefaults.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JP\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00102\b\b\u0002\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%J×\u0001\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00103\u001a\u0002042\u0013\b\u0002\u00105\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+H\u0007¢\u0006\u0002\u00106JÂ\u0001\u00107\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00190*¢\u0006\u0002\b+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0018\u00010*¢\u0006\u0002\b+2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00103\u001a\u000204H\u0007¢\u0006\u0002\u00108Jä\u0001\u00109\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010@\u001a\u00020;2\b\b\u0002\u0010A\u001a\u00020;2\b\b\u0002\u0010B\u001a\u00020;2\b\b\u0002\u0010C\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007ø\u0001\u0000¢\u0006\u0004\bP\u0010QJ:\u0010R\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\bW\u0010XJä\u0001\u0010Y\u001a\u00020 2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020;2\b\b\u0002\u0010=\u001a\u00020;2\b\b\u0002\u0010>\u001a\u00020;2\b\b\u0002\u0010?\u001a\u00020;2\b\b\u0002\u0010Z\u001a\u00020;2\b\b\u0002\u0010[\u001a\u00020;2\b\b\u0002\u0010\\\u001a\u00020;2\b\b\u0002\u0010]\u001a\u00020;2\b\b\u0002\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020;2\b\b\u0002\u0010F\u001a\u00020;2\b\b\u0002\u0010G\u001a\u00020;2\b\b\u0002\u0010H\u001a\u00020;2\b\b\u0002\u0010I\u001a\u00020;2\b\b\u0002\u0010J\u001a\u00020;2\b\b\u0002\u0010K\u001a\u00020;2\b\b\u0002\u0010L\u001a\u00020;2\b\b\u0002\u0010M\u001a\u00020;2\b\b\u0002\u0010N\u001a\u00020;2\b\b\u0002\u0010O\u001a\u00020;H\u0007ø\u0001\u0000¢\u0006\u0004\b^\u0010QJ:\u0010_\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b`\u0010XJ:\u0010a\u001a\u0002042\b\b\u0002\u0010S\u001a\u00020\u00062\b\b\u0002\u0010T\u001a\u00020\u00062\b\b\u0002\u0010U\u001a\u00020\u00062\b\b\u0002\u0010V\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\bb\u0010XJJ\u0010c\u001a\u00020d*\u00020d2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010e\u001a\u00020\u00062\b\b\u0002\u0010f\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\bg\u0010hR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\f\u0010\bR\u0019\u0010\r\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0019\u0010\u0015\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0016\u0010\bR\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006i"}, d2 = {"Landroidx/compose/material/TextFieldDefaults;", "", "()V", "BackgroundOpacity", "", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "IconOpacity", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "OutlinedTextFieldShape", "Landroidx/compose/ui/graphics/Shape;", "getOutlinedTextFieldShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "TextFieldShape", "getTextFieldShape", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "UnfocusedIndicatorLineOpacity", "BorderBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material/TextFieldColors;", "shape", "focusedBorderThickness", "unfocusedBorderThickness", "BorderBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "OutlinedTextFieldDecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", OutlinedTextFieldKt.BorderId, "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "TextFieldDecorationBox", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;III)V", "outlinedTextFieldColors", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "backgroundColor", "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-dx8h9Zs", "(JJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "outlinedTextFieldPadding", "start", "top", "end", "bottom", "outlinedTextFieldPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-dx8h9Zs", "textFieldWithLabelPadding", "textFieldWithLabelPadding-a9UjIt4", "textFieldWithoutLabelPadding", "textFieldWithoutLabelPadding-a9UjIt4", "indicatorLine", "Landroidx/compose/ui/Modifier;", "focusedIndicatorLineThickness", "unfocusedIndicatorLineThickness", "indicatorLine-gv0btCI", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;FF)Landroidx/compose/ui/Modifier;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldDefaults {
    public static final int $stable = 0;
    public static final float BackgroundOpacity = 0.12f;
    public static final float IconOpacity = 0.54f;
    public static final float UnfocusedIndicatorLineOpacity = 0.42f;
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    private static final float MinHeight = Dp.m6389constructorimpl(56);
    private static final float MinWidth = Dp.m6389constructorimpl(280);
    private static final float UnfocusedBorderThickness = Dp.m6389constructorimpl(1);
    private static final float FocusedBorderThickness = Dp.m6389constructorimpl(2);

    private TextFieldDefaults() {
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1821getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m1822getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    public final Shape getTextFieldShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1117199624, "C233@8407L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1117199624, i, -1, "androidx.compose.material.TextFieldDefaults.<get-TextFieldShape> (TextFieldDefaults.kt:233)");
        }
        CornerBasedShape copy$default = CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall(), null, null, CornerSizeKt.getZeroCornerSize(), CornerSizeKt.getZeroCornerSize(), 3, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return copy$default;
    }

    public final Shape getOutlinedTextFieldShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1899109048, "C242@8709L6:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1899109048, i, -1, "androidx.compose.material.TextFieldDefaults.<get-OutlinedTextFieldShape> (TextFieldDefaults.kt:242)");
        }
        CornerBasedShape small = MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return small;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1823getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM, reason: not valid java name */
    public final float m1820getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* renamed from: indicatorLine-gv0btCI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m1815indicatorLinegv0btCI$default(TextFieldDefaults textFieldDefaults, Modifier modifier, boolean z, boolean z2, InteractionSource interactionSource, TextFieldColors textFieldColors, float f, float f2, int i, Object obj) {
        if ((i & 16) != 0) {
            f = FocusedBorderThickness;
        }
        return textFieldDefaults.m1824indicatorLinegv0btCI(modifier, z, z2, interactionSource, textFieldColors, f, (i & 32) != 0 ? UnfocusedBorderThickness : f2);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0151  */
    /* renamed from: BorderBox-nbWgWpA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1819BorderBoxnbWgWpA(final boolean z, final boolean z2, final InteractionSource interactionSource, final TextFieldColors textFieldColors, Shape shape, float f, float f2, Composer composer, final int i, final int i2) {
        boolean z3;
        int i3;
        boolean z4;
        InteractionSource interactionSource2;
        TextFieldColors textFieldColors2;
        final Shape shape2;
        float f3;
        float f4;
        float f5;
        float f6;
        State m1831animateBorderStrokeAsStateNuRrP5Q;
        final float f7;
        final float f8;
        ScopeUpdateScope endRestartGroup;
        int i4;
        int i5;
        int i6;
        int i7;
        Composer startRestartGroup = composer.startRestartGroup(943754022);
        ComposerKt.sourceInformation(startRestartGroup, "C(BorderBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)332@12465L22,336@12649L203,344@12861L47:TextFieldDefaults.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z3 = z;
        } else {
            z3 = z;
            if ((i & 14) == 0) {
                i3 = (startRestartGroup.changed(z3) ? 4 : 2) | i;
            } else {
                i3 = i;
            }
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
            z4 = z2;
        } else {
            z4 = z2;
            if ((i & 112) == 0) {
                i3 |= startRestartGroup.changed(z4) ? 32 : 16;
            }
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
            interactionSource2 = interactionSource;
        } else {
            interactionSource2 = interactionSource;
            if ((i & 896) == 0) {
                i3 |= startRestartGroup.changed(interactionSource2) ? 256 : 128;
            }
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
            textFieldColors2 = textFieldColors;
        } else {
            textFieldColors2 = textFieldColors;
            if ((i & 7168) == 0) {
                i3 |= startRestartGroup.changed(textFieldColors2) ? 2048 : 1024;
            }
        }
        if ((i & 57344) == 0) {
            if ((i2 & 16) == 0) {
                shape2 = shape;
                if (startRestartGroup.changed(shape2)) {
                    i7 = 16384;
                    i3 |= i7;
                }
            } else {
                shape2 = shape;
            }
            i7 = 8192;
            i3 |= i7;
        } else {
            shape2 = shape;
        }
        if ((i & 458752) == 0) {
            if ((i2 & 32) == 0) {
                f3 = f;
                if (startRestartGroup.changed(f3)) {
                    i6 = 131072;
                    i3 |= i6;
                }
            } else {
                f3 = f;
            }
            i6 = 65536;
            i3 |= i6;
        } else {
            f3 = f;
        }
        if ((3670016 & i) == 0) {
            if ((i2 & 64) == 0) {
                f4 = f2;
                if (startRestartGroup.changed(f4)) {
                    i5 = 1048576;
                    i3 |= i5;
                }
            } else {
                f4 = f2;
            }
            i5 = 524288;
            i3 |= i5;
        } else {
            f4 = f2;
        }
        if ((i2 & 128) == 0) {
            i4 = (29360128 & i) == 0 ? startRestartGroup.changed(this) ? 8388608 : 4194304 : 12582912;
            if ((23967451 & i3) == 4793490 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    if ((i2 & 16) != 0) {
                        Shape outlinedTextFieldShape = getOutlinedTextFieldShape(startRestartGroup, (i3 >> 21) & 14);
                        i3 &= -57345;
                        shape2 = outlinedTextFieldShape;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        f3 = FocusedBorderThickness;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        f5 = UnfocusedBorderThickness;
                        f6 = f3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(943754022, i3, -1, "androidx.compose.material.TextFieldDefaults.BorderBox (TextFieldDefaults.kt:335)");
                        }
                        int i8 = i3 & 8190;
                        int i9 = i3 >> 3;
                        m1831animateBorderStrokeAsStateNuRrP5Q = TextFieldDefaultsKt.m1831animateBorderStrokeAsStateNuRrP5Q(z3, z4, interactionSource2, textFieldColors2, f6, f5, startRestartGroup, i8 | (i9 & 57344) | (i9 & 458752));
                        BoxKt.Box(BorderKt.border(Modifier.INSTANCE, (BorderStroke) m1831animateBorderStrokeAsStateNuRrP5Q.getValue(), shape2), startRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f7 = f6;
                        f8 = f5;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                    }
                }
                f6 = f3;
                f5 = f4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i82 = i3 & 8190;
                int i92 = i3 >> 3;
                m1831animateBorderStrokeAsStateNuRrP5Q = TextFieldDefaultsKt.m1831animateBorderStrokeAsStateNuRrP5Q(z3, z4, interactionSource2, textFieldColors2, f6, f5, startRestartGroup, i82 | (i92 & 57344) | (i92 & 458752));
                BoxKt.Box(BorderKt.border(Modifier.INSTANCE, (BorderStroke) m1831animateBorderStrokeAsStateNuRrP5Q.getValue(), shape2), startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                f7 = f6;
                f8 = f5;
            } else {
                startRestartGroup.skipToGroupEnd();
                f7 = f3;
                f8 = f4;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$BorderBox$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i10) {
                        TextFieldDefaults.this.m1819BorderBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape2, f7, f8, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        i3 |= i4;
        if ((23967451 & i3) == 4793490) {
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
        f6 = f3;
        f5 = f4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i822 = i3 & 8190;
        int i922 = i3 >> 3;
        m1831animateBorderStrokeAsStateNuRrP5Q = TextFieldDefaultsKt.m1831animateBorderStrokeAsStateNuRrP5Q(z3, z4, interactionSource2, textFieldColors2, f6, f5, startRestartGroup, i822 | (i922 & 57344) | (i922 & 458752));
        BoxKt.Box(BorderKt.border(Modifier.INSTANCE, (BorderStroke) m1831animateBorderStrokeAsStateNuRrP5Q.getValue(), shape2), startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        f7 = f6;
        f8 = f5;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* renamed from: textFieldWithLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1817textFieldWithLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldKt.getFirstBaselineOffset();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldKt.getTextFieldBottomPadding();
        }
        return textFieldDefaults.m1828textFieldWithLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: textFieldWithLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1828textFieldWithLabelPaddinga9UjIt4(float start, float end, float top, float bottom) {
        return PaddingKt.m875PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1818textFieldWithoutLabelPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
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
        return textFieldDefaults.m1829textFieldWithoutLabelPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: textFieldWithoutLabelPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1829textFieldWithoutLabelPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m875PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: outlinedTextFieldPadding-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m1816outlinedTextFieldPaddinga9UjIt4$default(TextFieldDefaults textFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
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
        return textFieldDefaults.m1826outlinedTextFieldPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: outlinedTextFieldPadding-a9UjIt4, reason: not valid java name */
    public final PaddingValues m1826outlinedTextFieldPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m875PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    /* renamed from: textFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m1827textFieldColorsdx8h9Zs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, Composer composer, int i, int i2, int i3, int i4) {
        long j22;
        long j23;
        long j24;
        long j25;
        long j26;
        long j27;
        long j28;
        long j29;
        long j30;
        composer.startReplaceableGroup(231892599);
        ComposerKt.sourceInformation(composer, "C(textFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)395@14785L7,395@14816L7,396@14889L8,397@14947L6,398@15040L6,399@15104L6,401@15183L6,401@15224L4,403@15298L6,404@15450L8,405@15512L6,407@15586L6,408@15715L8,411@15844L6,412@15975L8,413@16040L6,415@16115L6,415@16156L4,416@16214L6,416@16249L6,417@16332L8,418@16390L6,419@16452L6,419@16487L6,420@16573L8:TextFieldDefaults.kt#jmzs0o");
        if ((i4 & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            long m4073unboximpl = ((Color) consume).m4073unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd(composer);
            j22 = Color.m4062copywmQWz5c$default(m4073unboximpl, ((Number) consume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j22 = j;
        }
        long m4062copywmQWz5c$default = (i4 & 2) != 0 ? Color.m4062copywmQWz5c$default(j22, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long m4062copywmQWz5c$default2 = (i4 & 4) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long m1603getPrimary0d7_KjU = (i4 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1603getPrimary0d7_KjU() : j4;
        long m1597getError0d7_KjU = (i4 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1597getError0d7_KjU() : j5;
        long m4062copywmQWz5c$default3 = (i4 & 32) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1603getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long m4062copywmQWz5c$default4 = (i4 & 64) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.42f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if ((i4 & 128) != 0) {
            long j31 = m4062copywmQWz5c$default4;
            j23 = j31;
            j24 = Color.m4062copywmQWz5c$default(j31, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j23 = m4062copywmQWz5c$default4;
            j24 = j8;
        }
        long m1597getError0d7_KjU2 = (i4 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1597getError0d7_KjU() : j9;
        long m4062copywmQWz5c$default5 = (i4 & 512) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        if ((i4 & 1024) != 0) {
            long j32 = m4062copywmQWz5c$default5;
            j26 = Color.m4062copywmQWz5c$default(j32, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j25 = j32;
        } else {
            j25 = m4062copywmQWz5c$default5;
            j26 = j11;
        }
        long j33 = (i4 & 2048) != 0 ? j25 : j12;
        long m4062copywmQWz5c$default6 = (i4 & 4096) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        if ((i4 & 8192) != 0) {
            long j34 = m4062copywmQWz5c$default6;
            j28 = Color.m4062copywmQWz5c$default(j34, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j27 = j34;
        } else {
            j27 = m4062copywmQWz5c$default6;
            j28 = j14;
        }
        long m1597getError0d7_KjU3 = (i4 & 16384) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1597getError0d7_KjU() : j15;
        long m4062copywmQWz5c$default7 = (32768 & i4) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1603getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long m4062copywmQWz5c$default8 = (65536 & i4) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        if ((131072 & i4) != 0) {
            long j35 = m4062copywmQWz5c$default8;
            j30 = Color.m4062copywmQWz5c$default(j35, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j29 = j35;
        } else {
            j29 = m4062copywmQWz5c$default8;
            j30 = j18;
        }
        long m1597getError0d7_KjU4 = (262144 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1597getError0d7_KjU() : j19;
        long m4062copywmQWz5c$default9 = (524288 & i4) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j20;
        long m4062copywmQWz5c$default10 = (i4 & 1048576) != 0 ? Color.m4062copywmQWz5c$default(m4062copywmQWz5c$default9, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(231892599, i, i2, "androidx.compose.material.TextFieldDefaults.textFieldColors (TextFieldDefaults.kt:422)");
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(j22, m4062copywmQWz5c$default, m1603getPrimary0d7_KjU, m1597getError0d7_KjU, m4062copywmQWz5c$default3, j23, m1597getError0d7_KjU2, j24, j25, j26, j33, j27, j28, m1597getError0d7_KjU3, m4062copywmQWz5c$default2, m4062copywmQWz5c$default7, j29, j30, m1597getError0d7_KjU4, m4062copywmQWz5c$default9, m4062copywmQWz5c$default10, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    /* renamed from: outlinedTextFieldColors-dx8h9Zs, reason: not valid java name */
    public final TextFieldColors m1825outlinedTextFieldColorsdx8h9Zs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, Composer composer, int i, int i2, int i3, int i4) {
        long j22;
        long j23;
        long j24;
        long j25;
        long j26;
        long j27;
        long j28;
        long j29;
        long j30;
        composer.startReplaceableGroup(1762667317);
        ComposerKt.sourceInformation(composer, "C(outlinedTextFieldColors)P(17:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,13:c#ui.graphics.Color,19:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,18:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,20:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,16:c#ui.graphics.Color,5:c#ui.graphics.Color)453@18101L7,453@18132L7,454@18205L8,456@18311L6,457@18375L6,459@18451L6,459@18492L4,461@18563L6,461@18606L8,462@18701L8,463@18760L6,465@18834L6,466@18963L8,469@19092L6,470@19223L8,471@19288L6,473@19363L6,473@19404L4,474@19462L6,474@19497L6,475@19580L8,476@19638L6,477@19700L6,477@19735L6,478@19821L8:TextFieldDefaults.kt#jmzs0o");
        if ((i4 & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            long m4073unboximpl = ((Color) consume).m4073unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd(composer);
            j22 = Color.m4062copywmQWz5c$default(m4073unboximpl, ((Number) consume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j22 = j;
        }
        long m4062copywmQWz5c$default = (i4 & 2) != 0 ? Color.m4062copywmQWz5c$default(j22, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long m4098getTransparent0d7_KjU = (i4 & 4) != 0 ? Color.INSTANCE.m4098getTransparent0d7_KjU() : j3;
        long m1603getPrimary0d7_KjU = (i4 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1603getPrimary0d7_KjU() : j4;
        long m1597getError0d7_KjU = (i4 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1597getError0d7_KjU() : j5;
        long m4062copywmQWz5c$default2 = (i4 & 32) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1603getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long m4062copywmQWz5c$default3 = (i4 & 64) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if ((i4 & 128) != 0) {
            long j31 = m4062copywmQWz5c$default3;
            j23 = j31;
            j24 = Color.m4062copywmQWz5c$default(j31, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            j23 = m4062copywmQWz5c$default3;
            j24 = j8;
        }
        long m1597getError0d7_KjU2 = (i4 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1597getError0d7_KjU() : j9;
        long m4062copywmQWz5c$default4 = (i4 & 512) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        if ((i4 & 1024) != 0) {
            long j32 = m4062copywmQWz5c$default4;
            j26 = Color.m4062copywmQWz5c$default(j32, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j25 = j32;
        } else {
            j25 = m4062copywmQWz5c$default4;
            j26 = j11;
        }
        long j33 = (i4 & 2048) != 0 ? j25 : j12;
        long m4062copywmQWz5c$default5 = (i4 & 4096) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        if ((i4 & 8192) != 0) {
            long j34 = m4062copywmQWz5c$default5;
            j28 = Color.m4062copywmQWz5c$default(j34, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j27 = j34;
        } else {
            j27 = m4062copywmQWz5c$default5;
            j28 = j14;
        }
        long m1597getError0d7_KjU3 = (i4 & 16384) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1597getError0d7_KjU() : j15;
        long m4062copywmQWz5c$default6 = (32768 & i4) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1603getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long m4062copywmQWz5c$default7 = (65536 & i4) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        if ((131072 & i4) != 0) {
            long j35 = m4062copywmQWz5c$default7;
            j30 = Color.m4062copywmQWz5c$default(j35, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j29 = j35;
        } else {
            j29 = m4062copywmQWz5c$default7;
            j30 = j18;
        }
        long m1597getError0d7_KjU4 = (262144 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1597getError0d7_KjU() : j19;
        long m4062copywmQWz5c$default8 = (524288 & i4) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j20;
        long m4062copywmQWz5c$default9 = (i4 & 1048576) != 0 ? Color.m4062copywmQWz5c$default(m4062copywmQWz5c$default8, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1762667317, i, i2, "androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors (TextFieldDefaults.kt:480)");
        }
        DefaultTextFieldColors defaultTextFieldColors = new DefaultTextFieldColors(j22, m4062copywmQWz5c$default, m1603getPrimary0d7_KjU, m1597getError0d7_KjU, m4062copywmQWz5c$default2, j23, m1597getError0d7_KjU2, j24, j25, j26, j33, j27, j28, m1597getError0d7_KjU3, m4098getTransparent0d7_KjU, m4062copywmQWz5c$default6, j29, j30, m1597getError0d7_KjU4, m4062copywmQWz5c$default8, m4062copywmQWz5c$default9, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultTextFieldColors;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0232  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void TextFieldDecorationBox(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, TextFieldColors textFieldColors, PaddingValues paddingValues, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function26;
        boolean z4;
        boolean z5;
        VisualTransformation visualTransformation2;
        InteractionSource interactionSource2;
        int i5;
        boolean z6;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        TextFieldDefaults textFieldDefaults;
        TextFieldColors textFieldColors2;
        PaddingValues paddingValues2;
        boolean z7;
        Function2<? super Composer, ? super Integer, Unit> function28;
        TextFieldColors textFieldColors3;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Function2<? super Composer, ? super Integer, Unit> function210;
        PaddingValues m1817textFieldWithLabelPaddinga9UjIt4$default;
        Function2<? super Composer, ? super Integer, Unit> function211;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final boolean z8;
        final PaddingValues paddingValues3;
        final TextFieldColors textFieldColors4;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(1171040065);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldDecorationBox)P(11,3,2,9,12,4,5,6,8,7,10)572@25710L17,580@25944L569:TextFieldDefaults.kt#jmzs0o");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            function26 = function2;
            i4 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
            if ((i3 & 4) == 0) {
                i4 |= 384;
            } else if ((i & 896) == 0) {
                z4 = z;
                i4 |= startRestartGroup.changed(z4) ? 256 : 128;
                if ((i3 & 8) != 0) {
                    i4 |= 3072;
                } else if ((i & 7168) == 0) {
                    z5 = z2;
                    i4 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                    if ((i3 & 16) == 0) {
                        i4 |= 24576;
                        visualTransformation2 = visualTransformation;
                    } else {
                        visualTransformation2 = visualTransformation;
                        if ((i & 57344) == 0) {
                            i4 |= startRestartGroup.changed(visualTransformation2) ? 16384 : 8192;
                        }
                    }
                    if ((i3 & 32) == 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        interactionSource2 = interactionSource;
                    } else {
                        interactionSource2 = interactionSource;
                        if ((i & 458752) == 0) {
                            i4 |= startRestartGroup.changed(interactionSource2) ? 131072 : 65536;
                        }
                    }
                    i5 = i3 & 64;
                    if (i5 == 0) {
                        i4 |= 1572864;
                        z6 = z3;
                    } else {
                        z6 = z3;
                        if ((i & 3670016) == 0) {
                            i4 |= startRestartGroup.changed(z6) ? 1048576 : 524288;
                        }
                    }
                    i6 = i3 & 128;
                    if (i6 == 0) {
                        i4 |= 12582912;
                        function27 = function22;
                    } else {
                        function27 = function22;
                        if ((i & 29360128) == 0) {
                            i4 |= startRestartGroup.changedInstance(function27) ? 8388608 : 4194304;
                        }
                    }
                    i7 = i3 & 256;
                    if (i7 == 0) {
                        i4 |= 100663296;
                    } else if ((i & 234881024) == 0) {
                        i4 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                    }
                    i8 = i3 & 512;
                    if (i8 == 0) {
                        i4 |= C.ENCODING_PCM_32BIT;
                    } else if ((i & 1879048192) == 0) {
                        i9 = i8;
                        i4 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                        i10 = i3 & 1024;
                        if (i10 != 0) {
                            i12 = i2 | 6;
                            i11 = i10;
                        } else if ((i2 & 14) == 0) {
                            i11 = i10;
                            i12 = i2 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                        } else {
                            i11 = i10;
                            i12 = i2;
                        }
                        if ((i2 & 112) == 0) {
                            if ((i3 & 2048) == 0 && startRestartGroup.changed(textFieldColors)) {
                                i14 = 32;
                                i12 |= i14;
                            }
                            i14 = 16;
                            i12 |= i14;
                        }
                        if ((i2 & 896) == 0) {
                            if ((i3 & 4096) == 0 && startRestartGroup.changed(paddingValues)) {
                                i13 = 256;
                                i12 |= i13;
                            }
                            i13 = 128;
                            i12 |= i13;
                        }
                        int i15 = i12;
                        if ((i3 & 8192) != 0) {
                            i15 |= 3072;
                        } else if ((i2 & 7168) == 0) {
                            textFieldDefaults = this;
                            i15 |= startRestartGroup.changed(textFieldDefaults) ? 2048 : 1024;
                            if ((i4 & 1533916891) == 306783378 || (i15 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    boolean z9 = i5 == 0 ? false : z6;
                                    if (i6 != 0) {
                                        function27 = null;
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function216 = i7 == 0 ? null : function23;
                                    Function2<? super Composer, ? super Integer, Unit> function217 = i9 == 0 ? null : function24;
                                    Function2<? super Composer, ? super Integer, Unit> function218 = i11 == 0 ? function25 : null;
                                    if ((i3 & 2048) == 0) {
                                        textFieldColors2 = textFieldDefaults.m1827textFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 0, 0, (i15 >> 6) & 112, 2097151);
                                        i15 &= -113;
                                    } else {
                                        textFieldColors2 = textFieldColors;
                                    }
                                    if ((i3 & 4096) == 0) {
                                        if (function27 == null) {
                                            m1817textFieldWithLabelPaddinga9UjIt4$default = m1818textFieldWithoutLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        } else {
                                            m1817textFieldWithLabelPaddinga9UjIt4$default = m1817textFieldWithLabelPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        }
                                        i15 &= -897;
                                        z7 = z9;
                                        function28 = function218;
                                        textFieldColors3 = textFieldColors2;
                                        function29 = function216;
                                        function210 = function217;
                                        function211 = function27;
                                        paddingValues2 = m1817textFieldWithLabelPaddinga9UjIt4$default;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1171040065, i4, i15, "androidx.compose.material.TextFieldDefaults.TextFieldDecorationBox (TextFieldDefaults.kt:579)");
                                        }
                                        int i16 = i4 << 3;
                                        int i17 = i4 >> 9;
                                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, function26, visualTransformation2, function211, function29, function210, function28, z5, z4, z7, interactionSource2, paddingValues2, textFieldColors3, null, startRestartGroup, (i16 & 896) | (i16 & 112) | 6 | ((i4 >> 3) & 7168) | (i17 & 57344) | (i17 & 458752) | (i17 & 3670016) | ((i15 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 18) & 14) | ((i4 >> 12) & 112) | (i15 & 896) | ((i15 << 6) & 7168), 16384);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        function212 = function211;
                                        function213 = function29;
                                        function214 = function210;
                                        function215 = function28;
                                        z8 = z7;
                                        paddingValues3 = paddingValues2;
                                        textFieldColors4 = textFieldColors3;
                                    } else {
                                        paddingValues2 = paddingValues;
                                        z7 = z9;
                                        function28 = function218;
                                        textFieldColors3 = textFieldColors2;
                                        function29 = function216;
                                        function210 = function217;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & 2048) != 0) {
                                        i15 &= -113;
                                    }
                                    if ((i3 & 4096) != 0) {
                                        i15 &= -897;
                                    }
                                    function29 = function23;
                                    function210 = function24;
                                    function28 = function25;
                                    textFieldColors3 = textFieldColors;
                                    paddingValues2 = paddingValues;
                                    z7 = z6;
                                }
                                function211 = function27;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i162 = i4 << 3;
                                int i172 = i4 >> 9;
                                TextFieldImplKt.CommonDecorationBox(TextFieldType.Filled, str, function26, visualTransformation2, function211, function29, function210, function28, z5, z4, z7, interactionSource2, paddingValues2, textFieldColors3, null, startRestartGroup, (i162 & 896) | (i162 & 112) | 6 | ((i4 >> 3) & 7168) | (i172 & 57344) | (i172 & 458752) | (i172 & 3670016) | ((i15 << 21) & 29360128) | ((i4 << 15) & 234881024) | ((i4 << 21) & 1879048192), ((i4 >> 18) & 14) | ((i4 >> 12) & 112) | (i15 & 896) | ((i15 << 6) & 7168), 16384);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                function212 = function211;
                                function213 = function29;
                                function214 = function210;
                                function215 = function28;
                                z8 = z7;
                                paddingValues3 = paddingValues2;
                                textFieldColors4 = textFieldColors3;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                function213 = function23;
                                function214 = function24;
                                textFieldColors4 = textFieldColors;
                                paddingValues3 = paddingValues;
                                z8 = z6;
                                function212 = function27;
                                function215 = function25;
                            }
                            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$TextFieldDecorationBox$1
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

                                    public final void invoke(Composer composer2, int i18) {
                                        TextFieldDefaults.this.TextFieldDecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z8, function212, function213, function214, function215, textFieldColors4, paddingValues3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        textFieldDefaults = this;
                        if ((i4 & 1533916891) == 306783378) {
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
                        if ((i3 & 2048) == 0) {
                        }
                        if ((i3 & 4096) == 0) {
                        }
                    }
                    i9 = i8;
                    i10 = i3 & 1024;
                    if (i10 != 0) {
                    }
                    if ((i2 & 112) == 0) {
                    }
                    if ((i2 & 896) == 0) {
                    }
                    int i152 = i12;
                    if ((i3 & 8192) != 0) {
                    }
                    textFieldDefaults = this;
                    if ((i4 & 1533916891) == 306783378) {
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
                    if ((i3 & 2048) == 0) {
                    }
                    if ((i3 & 4096) == 0) {
                    }
                }
                z5 = z2;
                if ((i3 & 16) == 0) {
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
                if ((i2 & 112) == 0) {
                }
                if ((i2 & 896) == 0) {
                }
                int i1522 = i12;
                if ((i3 & 8192) != 0) {
                }
                textFieldDefaults = this;
                if ((i4 & 1533916891) == 306783378) {
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
                if ((i3 & 2048) == 0) {
                }
                if ((i3 & 4096) == 0) {
                }
            }
            z4 = z;
            if ((i3 & 8) != 0) {
            }
            z5 = z2;
            if ((i3 & 16) == 0) {
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
            if ((i2 & 112) == 0) {
            }
            if ((i2 & 896) == 0) {
            }
            int i15222 = i12;
            if ((i3 & 8192) != 0) {
            }
            textFieldDefaults = this;
            if ((i4 & 1533916891) == 306783378) {
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
            if ((i3 & 2048) == 0) {
            }
            if ((i3 & 4096) == 0) {
            }
        }
        function26 = function2;
        if ((i3 & 4) == 0) {
        }
        z4 = z;
        if ((i3 & 8) != 0) {
        }
        z5 = z2;
        if ((i3 & 16) == 0) {
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
        if ((i2 & 112) == 0) {
        }
        if ((i2 & 896) == 0) {
        }
        int i152222 = i12;
        if ((i3 & 8192) != 0) {
        }
        textFieldDefaults = this;
        if ((i4 & 1533916891) == 306783378) {
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
        if ((i3 & 2048) == 0) {
        }
        if ((i3 & 4096) == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0258  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void OutlinedTextFieldDecorationBox(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function26, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        final boolean z4;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        Function2<? super Composer, ? super Integer, Unit> function29;
        int i18;
        final TextFieldColors textFieldColors2;
        int i19;
        PaddingValues paddingValues2;
        Function2<? super Composer, ? super Integer, Unit> function210;
        Function2<? super Composer, ? super Integer, Unit> function211;
        Function2<? super Composer, ? super Integer, Unit> function212;
        final TextFieldColors textFieldColors3;
        PaddingValues paddingValues3;
        Function2<? super Composer, ? super Integer, Unit> function213;
        Function2<? super Composer, ? super Integer, Unit> function214;
        boolean z5;
        int i20;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        final PaddingValues paddingValues4;
        final Function2<? super Composer, ? super Integer, Unit> function219;
        ScopeUpdateScope endRestartGroup;
        int i21;
        Composer startRestartGroup = composer.startRestartGroup(-1280721485);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedTextFieldDecorationBox)P(12,4,3,10,13,5,6,7,9,8,11,1,2)664@31043L25,670@31274L600:TextFieldDefaults.kt#jmzs0o");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
            int i22 = 128;
            if ((i3 & 4) == 0) {
                i4 |= 384;
            } else if ((i & 896) == 0) {
                i4 |= startRestartGroup.changed(z) ? 256 : 128;
            }
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 7168) == 0) {
                i4 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else if ((i & 57344) == 0) {
                    i4 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                }
                if ((i3 & 32) != 0) {
                    i5 = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else {
                    if ((i & 458752) == 0) {
                        i5 = startRestartGroup.changed(interactionSource) ? 131072 : 65536;
                    }
                    i6 = i3 & 64;
                    if (i6 == 0) {
                        i4 |= 1572864;
                        z4 = z3;
                    } else {
                        z4 = z3;
                        if ((i & 3670016) == 0) {
                            i4 |= startRestartGroup.changed(z4) ? 1048576 : 524288;
                        }
                    }
                    i7 = i3 & 128;
                    if (i7 == 0) {
                        i4 |= 12582912;
                        function27 = function22;
                    } else {
                        function27 = function22;
                        if ((i & 29360128) == 0) {
                            i4 |= startRestartGroup.changedInstance(function27) ? 8388608 : 4194304;
                        }
                    }
                    i8 = i3 & 256;
                    if (i8 == 0) {
                        i4 |= 100663296;
                        function28 = function23;
                    } else {
                        function28 = function23;
                        if ((i & 234881024) == 0) {
                            i4 |= startRestartGroup.changedInstance(function28) ? 67108864 : 33554432;
                        }
                    }
                    i9 = i3 & 512;
                    if (i9 == 0) {
                        i4 |= C.ENCODING_PCM_32BIT;
                    } else if ((i & 1879048192) == 0) {
                        i10 = i9;
                        i4 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                        i11 = i3 & 1024;
                        if (i11 != 0) {
                            i13 = i2 | 6;
                            i12 = i11;
                        } else if ((i2 & 14) == 0) {
                            i12 = i11;
                            i13 = i2 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                        } else {
                            i12 = i11;
                            i13 = i2;
                        }
                        if ((i2 & 112) == 0) {
                            if ((i3 & 2048) == 0 && startRestartGroup.changed(textFieldColors)) {
                                i21 = 32;
                                i13 |= i21;
                            }
                            i21 = 16;
                            i13 |= i21;
                        }
                        if ((i2 & 896) == 0) {
                            if ((i3 & 4096) == 0 && startRestartGroup.changed(paddingValues)) {
                                i22 = 256;
                            }
                            i13 |= i22;
                        }
                        int i23 = i13;
                        i14 = i4;
                        i15 = i3 & 8192;
                        if (i15 != 0) {
                            i16 = i23 | 3072;
                        } else {
                            int i24 = i23;
                            if ((i2 & 7168) == 0) {
                                i24 |= startRestartGroup.changedInstance(function26) ? 2048 : 1024;
                            }
                            i16 = i24;
                        }
                        if ((i3 & 16384) != 0) {
                            i16 |= 24576;
                        } else if ((i2 & 57344) == 0) {
                            i16 |= startRestartGroup.changed(this) ? 16384 : 8192;
                            int i25 = i16;
                            if ((i14 & 1533916891) == 306783378 || (i25 & 46811) != 9362 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    final boolean z6 = i6 == 0 ? false : z4;
                                    Function2<? super Composer, ? super Integer, Unit> function220 = i7 == 0 ? null : function27;
                                    if (i8 != 0) {
                                        function28 = null;
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function221 = i10 == 0 ? null : function24;
                                    Function2<? super Composer, ? super Integer, Unit> function222 = i12 == 0 ? function25 : null;
                                    if ((i3 & 2048) == 0) {
                                        Function2<? super Composer, ? super Integer, Unit> function223 = function222;
                                        i17 = i14;
                                        function29 = function223;
                                        i18 = i15;
                                        textFieldColors2 = m1825outlinedTextFieldColorsdx8h9Zs(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 0, 0, (i25 >> 9) & 112, 2097151);
                                        startRestartGroup = startRestartGroup;
                                        i19 = i25 & (-113);
                                    } else {
                                        Function2<? super Composer, ? super Integer, Unit> function224 = function222;
                                        i17 = i14;
                                        function29 = function224;
                                        i18 = i15;
                                        textFieldColors2 = textFieldColors;
                                        i19 = i25;
                                    }
                                    if ((i3 & 4096) == 0) {
                                        paddingValues2 = m1816outlinedTextFieldPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        i19 &= -897;
                                    } else {
                                        paddingValues2 = paddingValues;
                                    }
                                    if (i18 == 0) {
                                        function211 = function29;
                                        function212 = function28;
                                        textFieldColors3 = textFieldColors2;
                                        paddingValues3 = paddingValues2;
                                        function210 = ComposableLambdaKt.composableLambda(startRestartGroup, 1261916269, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$OutlinedTextFieldDecorationBox$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                invoke(composer3, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i26) {
                                                ComposerKt.sourceInformation(composer3, "C667@31193L54:TextFieldDefaults.kt#jmzs0o");
                                                if ((i26 & 11) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1261916269, i26, -1, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox.<anonymous> (TextFieldDefaults.kt:667)");
                                                }
                                                TextFieldDefaults.INSTANCE.m1819BorderBoxnbWgWpA(z, z6, interactionSource, textFieldColors2, null, 0.0f, 0.0f, composer3, 12582912, 112);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                    } else {
                                        function210 = function26;
                                        function211 = function29;
                                        function212 = function28;
                                        textFieldColors3 = textFieldColors2;
                                        paddingValues3 = paddingValues2;
                                    }
                                    function213 = function220;
                                    function214 = function221;
                                    z5 = z6;
                                    i20 = i19;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    i20 = (i3 & 2048) != 0 ? i25 & (-113) : i25;
                                    if ((i3 & 4096) != 0) {
                                        i20 &= -897;
                                    }
                                    function214 = function24;
                                    function211 = function25;
                                    textFieldColors3 = textFieldColors;
                                    function210 = function26;
                                    i17 = i14;
                                    function212 = function28;
                                    z5 = z4;
                                    function213 = function27;
                                    paddingValues3 = paddingValues;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1280721485, i17, i20, "androidx.compose.material.TextFieldDefaults.OutlinedTextFieldDecorationBox (TextFieldDefaults.kt:669)");
                                }
                                int i26 = i17 << 3;
                                int i27 = i17 >> 9;
                                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function213, function212, function214, function211, z2, z, z5, interactionSource, paddingValues3, textFieldColors3, function210, startRestartGroup, (i26 & 896) | (i26 & 112) | 6 | ((i17 >> 3) & 7168) | (i27 & 57344) | (458752 & i27) | (i27 & 3670016) | ((i20 << 21) & 29360128) | ((i17 << 15) & 234881024) | ((i17 << 21) & 1879048192), ((i17 >> 12) & 112) | ((i17 >> 18) & 14) | (i20 & 896) | ((i20 << 6) & 7168) | ((i20 << 3) & 57344), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function215 = function213;
                                function216 = function214;
                                z4 = z5;
                                composer2 = startRestartGroup;
                                function217 = function212;
                                function218 = function210;
                                paddingValues4 = paddingValues3;
                                function219 = function211;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                function216 = function24;
                                textFieldColors3 = textFieldColors;
                                paddingValues4 = paddingValues;
                                function217 = function28;
                                function215 = function27;
                                composer2 = startRestartGroup;
                                function219 = function25;
                                function218 = function26;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$OutlinedTextFieldDecorationBox$2
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

                                    public final void invoke(Composer composer3, int i28) {
                                        TextFieldDefaults.this.OutlinedTextFieldDecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z4, function215, function217, function216, function219, textFieldColors3, paddingValues4, function218, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        int i252 = i16;
                        if ((i14 & 1533916891) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if ((i3 & 2048) == 0) {
                        }
                        if ((i3 & 4096) == 0) {
                        }
                        if (i18 == 0) {
                        }
                        function213 = function220;
                        function214 = function221;
                        z5 = z6;
                        i20 = i19;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i262 = i17 << 3;
                        int i272 = i17 >> 9;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function213, function212, function214, function211, z2, z, z5, interactionSource, paddingValues3, textFieldColors3, function210, startRestartGroup, (i262 & 896) | (i262 & 112) | 6 | ((i17 >> 3) & 7168) | (i272 & 57344) | (458752 & i272) | (i272 & 3670016) | ((i20 << 21) & 29360128) | ((i17 << 15) & 234881024) | ((i17 << 21) & 1879048192), ((i17 >> 12) & 112) | ((i17 >> 18) & 14) | (i20 & 896) | ((i20 << 6) & 7168) | ((i20 << 3) & 57344), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function215 = function213;
                        function216 = function214;
                        z4 = z5;
                        composer2 = startRestartGroup;
                        function217 = function212;
                        function218 = function210;
                        paddingValues4 = paddingValues3;
                        function219 = function211;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i10 = i9;
                    i11 = i3 & 1024;
                    if (i11 != 0) {
                    }
                    if ((i2 & 112) == 0) {
                    }
                    if ((i2 & 896) == 0) {
                    }
                    int i232 = i13;
                    i14 = i4;
                    i15 = i3 & 8192;
                    if (i15 != 0) {
                    }
                    if ((i3 & 16384) != 0) {
                    }
                    int i2522 = i16;
                    if ((i14 & 1533916891) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i10 == 0) {
                    }
                    if (i12 == 0) {
                    }
                    if ((i3 & 2048) == 0) {
                    }
                    if ((i3 & 4096) == 0) {
                    }
                    if (i18 == 0) {
                    }
                    function213 = function220;
                    function214 = function221;
                    z5 = z6;
                    i20 = i19;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i2622 = i17 << 3;
                    int i2722 = i17 >> 9;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function213, function212, function214, function211, z2, z, z5, interactionSource, paddingValues3, textFieldColors3, function210, startRestartGroup, (i2622 & 896) | (i2622 & 112) | 6 | ((i17 >> 3) & 7168) | (i2722 & 57344) | (458752 & i2722) | (i2722 & 3670016) | ((i20 << 21) & 29360128) | ((i17 << 15) & 234881024) | ((i17 << 21) & 1879048192), ((i17 >> 12) & 112) | ((i17 >> 18) & 14) | (i20 & 896) | ((i20 << 6) & 7168) | ((i20 << 3) & 57344), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function215 = function213;
                    function216 = function214;
                    z4 = z5;
                    composer2 = startRestartGroup;
                    function217 = function212;
                    function218 = function210;
                    paddingValues4 = paddingValues3;
                    function219 = function211;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i4 |= i5;
                i6 = i3 & 64;
                if (i6 == 0) {
                }
                i7 = i3 & 128;
                if (i7 == 0) {
                }
                i8 = i3 & 256;
                if (i8 == 0) {
                }
                i9 = i3 & 512;
                if (i9 == 0) {
                }
                i10 = i9;
                i11 = i3 & 1024;
                if (i11 != 0) {
                }
                if ((i2 & 112) == 0) {
                }
                if ((i2 & 896) == 0) {
                }
                int i2322 = i13;
                i14 = i4;
                i15 = i3 & 8192;
                if (i15 != 0) {
                }
                if ((i3 & 16384) != 0) {
                }
                int i25222 = i16;
                if ((i14 & 1533916891) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if (i8 != 0) {
                }
                if (i10 == 0) {
                }
                if (i12 == 0) {
                }
                if ((i3 & 2048) == 0) {
                }
                if ((i3 & 4096) == 0) {
                }
                if (i18 == 0) {
                }
                function213 = function220;
                function214 = function221;
                z5 = z6;
                i20 = i19;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i26222 = i17 << 3;
                int i27222 = i17 >> 9;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function213, function212, function214, function211, z2, z, z5, interactionSource, paddingValues3, textFieldColors3, function210, startRestartGroup, (i26222 & 896) | (i26222 & 112) | 6 | ((i17 >> 3) & 7168) | (i27222 & 57344) | (458752 & i27222) | (i27222 & 3670016) | ((i20 << 21) & 29360128) | ((i17 << 15) & 234881024) | ((i17 << 21) & 1879048192), ((i17 >> 12) & 112) | ((i17 >> 18) & 14) | (i20 & 896) | ((i20 << 6) & 7168) | ((i20 << 3) & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function215 = function213;
                function216 = function214;
                z4 = z5;
                composer2 = startRestartGroup;
                function217 = function212;
                function218 = function210;
                paddingValues4 = paddingValues3;
                function219 = function211;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            if ((i3 & 16) != 0) {
            }
            if ((i3 & 32) != 0) {
            }
            i4 |= i5;
            i6 = i3 & 64;
            if (i6 == 0) {
            }
            i7 = i3 & 128;
            if (i7 == 0) {
            }
            i8 = i3 & 256;
            if (i8 == 0) {
            }
            i9 = i3 & 512;
            if (i9 == 0) {
            }
            i10 = i9;
            i11 = i3 & 1024;
            if (i11 != 0) {
            }
            if ((i2 & 112) == 0) {
            }
            if ((i2 & 896) == 0) {
            }
            int i23222 = i13;
            i14 = i4;
            i15 = i3 & 8192;
            if (i15 != 0) {
            }
            if ((i3 & 16384) != 0) {
            }
            int i252222 = i16;
            if ((i14 & 1533916891) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if (i8 != 0) {
            }
            if (i10 == 0) {
            }
            if (i12 == 0) {
            }
            if ((i3 & 2048) == 0) {
            }
            if ((i3 & 4096) == 0) {
            }
            if (i18 == 0) {
            }
            function213 = function220;
            function214 = function221;
            z5 = z6;
            i20 = i19;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i262222 = i17 << 3;
            int i272222 = i17 >> 9;
            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function213, function212, function214, function211, z2, z, z5, interactionSource, paddingValues3, textFieldColors3, function210, startRestartGroup, (i262222 & 896) | (i262222 & 112) | 6 | ((i17 >> 3) & 7168) | (i272222 & 57344) | (458752 & i272222) | (i272222 & 3670016) | ((i20 << 21) & 29360128) | ((i17 << 15) & 234881024) | ((i17 << 21) & 1879048192), ((i17 >> 12) & 112) | ((i17 >> 18) & 14) | (i20 & 896) | ((i20 << 6) & 7168) | ((i20 << 3) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function215 = function213;
            function216 = function214;
            z4 = z5;
            composer2 = startRestartGroup;
            function217 = function212;
            function218 = function210;
            paddingValues4 = paddingValues3;
            function219 = function211;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        int i222 = 128;
        if ((i3 & 4) == 0) {
        }
        if ((i3 & 8) == 0) {
        }
        if ((i3 & 16) != 0) {
        }
        if ((i3 & 32) != 0) {
        }
        i4 |= i5;
        i6 = i3 & 64;
        if (i6 == 0) {
        }
        i7 = i3 & 128;
        if (i7 == 0) {
        }
        i8 = i3 & 256;
        if (i8 == 0) {
        }
        i9 = i3 & 512;
        if (i9 == 0) {
        }
        i10 = i9;
        i11 = i3 & 1024;
        if (i11 != 0) {
        }
        if ((i2 & 112) == 0) {
        }
        if ((i2 & 896) == 0) {
        }
        int i232222 = i13;
        i14 = i4;
        i15 = i3 & 8192;
        if (i15 != 0) {
        }
        if ((i3 & 16384) != 0) {
        }
        int i2522222 = i16;
        if ((i14 & 1533916891) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 != 0) {
        }
        if (i10 == 0) {
        }
        if (i12 == 0) {
        }
        if ((i3 & 2048) == 0) {
        }
        if ((i3 & 4096) == 0) {
        }
        if (i18 == 0) {
        }
        function213 = function220;
        function214 = function221;
        z5 = z6;
        i20 = i19;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i2622222 = i17 << 3;
        int i2722222 = i17 >> 9;
        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function213, function212, function214, function211, z2, z, z5, interactionSource, paddingValues3, textFieldColors3, function210, startRestartGroup, (i2622222 & 896) | (i2622222 & 112) | 6 | ((i17 >> 3) & 7168) | (i2722222 & 57344) | (458752 & i2722222) | (i2722222 & 3670016) | ((i20 << 21) & 29360128) | ((i17 << 15) & 234881024) | ((i17 << 21) & 1879048192), ((i17 >> 12) & 112) | ((i17 >> 18) & 14) | (i20 & 896) | ((i20 << 6) & 7168) | ((i20 << 3) & 57344), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function215 = function213;
        function216 = function214;
        z4 = z5;
        composer2 = startRestartGroup;
        function217 = function212;
        function218 = function210;
        paddingValues4 = paddingValues3;
        function219 = function211;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* renamed from: indicatorLine-gv0btCI, reason: not valid java name */
    public final Modifier m1824indicatorLinegv0btCI(Modifier modifier, final boolean z, final boolean z2, final InteractionSource interactionSource, final TextFieldColors textFieldColors, final float f, final float f2) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.TextFieldDefaults$indicatorLine-gv0btCI$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("indicatorLine");
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("isError", Boolean.valueOf(z2));
                inspectorInfo.getProperties().set("interactionSource", interactionSource);
                inspectorInfo.getProperties().set("colors", textFieldColors);
                inspectorInfo.getProperties().set("focusedIndicatorLineThickness", Dp.m6387boximpl(f));
                inspectorInfo.getProperties().set("unfocusedIndicatorLineThickness", Dp.m6387boximpl(f2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.TextFieldDefaults$indicatorLine$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                State m1831animateBorderStrokeAsStateNuRrP5Q;
                composer.startReplaceableGroup(1398930845);
                ComposerKt.sourceInformation(composer, "C299@11111L217:TextFieldDefaults.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1398930845, i, -1, "androidx.compose.material.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:299)");
                }
                m1831animateBorderStrokeAsStateNuRrP5Q = TextFieldDefaultsKt.m1831animateBorderStrokeAsStateNuRrP5Q(z, z2, interactionSource, textFieldColors, f, f2, composer, 0);
                Modifier drawIndicatorLine = TextFieldKt.drawIndicatorLine(Modifier.INSTANCE, (BorderStroke) m1831animateBorderStrokeAsStateNuRrP5Q.getValue());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return drawIndicatorLine;
            }
        });
    }
}
