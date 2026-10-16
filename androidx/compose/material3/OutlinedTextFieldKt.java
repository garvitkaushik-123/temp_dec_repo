package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.Strings;
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
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.google.firebase.messaging.Constants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: OutlinedTextField.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aÖ\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010-\u001a¨\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u0010.\u001aÖ\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020/2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00100\u001a¨\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020/2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u00070\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0015\b\u0002\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\b\b\u0002\u0010\u001c\u001a\u00020\u000f2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020%2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,H\u0007¢\u0006\u0002\u00101\u001a\u0080\u0002\u00102\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0019\u0010\u0016\u001a\u0015\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b¢\u0006\u0002\b\u00152\u0013\u0010\u0013\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u0010#\u001a\u00020\u000f2\u0006\u00106\u001a\u0002072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00070\u000b2\u0011\u0010:\u001a\r\u0012\u0004\u0012\u00020\u00070\u0014¢\u0006\u0002\b\u00152\u0013\u0010;\u001a\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0014¢\u0006\u0002\b\u00152\u0006\u0010<\u001a\u00020=H\u0001¢\u0006\u0002\u0010>\u001ar\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020%2\u0006\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020%2\u0006\u0010F\u001a\u00020%2\u0006\u0010G\u001a\u00020%2\u0006\u00106\u001a\u0002072\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001aj\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020%2\u0006\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020%2\u0006\u0010T\u001a\u00020%2\u0006\u00106\u001a\u0002072\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001a&\u0010W\u001a\u00020\r*\u00020\r2\u0006\u0010X\u001a\u0002092\u0006\u0010<\u001a\u00020=H\u0000ø\u0001\u0000¢\u0006\u0004\bY\u0010Z\u001a\u009a\u0001\u0010[\u001a\u00020\u0007*\u00020\\2\u0006\u0010]\u001a\u00020%2\u0006\u0010^\u001a\u00020%2\b\u0010_\u001a\u0004\u0018\u00010`2\b\u0010a\u001a\u0004\u0018\u00010`2\b\u0010b\u001a\u0004\u0018\u00010`2\b\u0010c\u001a\u0004\u0018\u00010`2\u0006\u0010d\u001a\u00020`2\b\u0010e\u001a\u0004\u0018\u00010`2\b\u0010f\u001a\u0004\u0018\u00010`2\u0006\u0010g\u001a\u00020`2\b\u0010h\u001a\u0004\u0018\u00010`2\u0006\u00106\u001a\u0002072\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010J\u001a\u0002072\u0006\u0010i\u001a\u00020j2\u0006\u0010<\u001a\u00020=H\u0002\u001a\u0014\u0010k\u001a\u00020%*\u00020%2\u0006\u0010l\u001a\u00020%H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006m"}, d2 = {"OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", "container", "supporting", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingHeight", "trailingHeight", "prefixHeight", "suffixHeight", "textFieldHeight", "labelHeight", "placeholderHeight", "supportingHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-mKXJcVc", "(IIIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "prefixPlaceableWidth", "suffixPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "calculateWidth-DHJA7U0", "(IIIIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "totalHeight", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "prefixPlaceable", "suffixPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "containerPlaceable", "supportingPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "substractConstraintSafely", Constants.MessagePayloadKeys.FROM, "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OutlinedTextFieldKt {
    private static final float OutlinedTextFieldInnerPadding = Dp.m6389constructorimpl(4);
    private static final float OutlinedTextFieldTopPadding = Dp.m6389constructorimpl(8);

    /* JADX INFO: Access modifiers changed from: private */
    public static final int substractConstraintSafely(int i, int i2) {
        return i == Integer.MAX_VALUE ? i : i - i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x05b9  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedTextField(final String str, final Function1<? super String, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5, final int i6) {
        final String str2;
        int i7;
        final Function1<? super String, Unit> function12;
        Modifier modifier2;
        int i8;
        boolean z5;
        int i9;
        boolean z6;
        TextStyle textStyle2;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i11;
        Function2<? super Composer, ? super Integer, Unit> function29;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        int i36;
        Shape shape2;
        int i37;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        int i38;
        final Shape shape3;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        TextStyle textStyle3;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final boolean z7;
        int i39;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        final KeyboardOptions keyboardOptions2;
        final KeyboardActions keyboardActions2;
        final boolean z8;
        final int i40;
        final int i41;
        final MutableInteractionSource mutableInteractionSource4;
        final TextFieldColors textFieldColors2;
        final VisualTransformation visualTransformation2;
        final boolean z9;
        final boolean z10;
        int i42;
        long m5918getColor0d7_KjU;
        final TextStyle textStyle4;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        final boolean z11;
        final boolean z12;
        final boolean z13;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean z14;
        final int i43;
        final int i44;
        final VisualTransformation visualTransformation3;
        final MutableInteractionSource mutableInteractionSource5;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        final Function2<? super Composer, ? super Integer, Unit> function219;
        final Function2<? super Composer, ? super Integer, Unit> function220;
        final Function2<? super Composer, ? super Integer, Unit> function221;
        final Shape shape4;
        final TextFieldColors textFieldColors3;
        final Function2<? super Composer, ? super Integer, Unit> function222;
        int i45;
        Composer startRestartGroup = composer.startRestartGroup(-1922450045);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)147@8277L7,162@9029L39,163@9115L5,164@9178L8,172@9540L15,172@9474L2524:OutlinedTextField.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i3 | 6;
            str2 = str;
        } else {
            str2 = str;
            if ((i3 & 6) == 0) {
                i7 = (startRestartGroup.changed(str2) ? 4 : 2) | i3;
            } else {
                i7 = i3;
            }
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i3 & 48) == 0) {
                i7 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i46 = i6 & 4;
        if (i46 != 0) {
            i7 |= 384;
        } else if ((i3 & 384) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i3 & 3072) == 0) {
                z5 = z;
                i7 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else if ((i3 & 24576) == 0) {
                    z6 = z2;
                    i7 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        textStyle2 = textStyle;
                        i7 |= ((i6 & 32) == 0 && startRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                        function28 = function2;
                    } else {
                        function28 = function2;
                        if ((i3 & 1572864) == 0) {
                            i7 |= startRestartGroup.changedInstance(function28) ? 1048576 : 524288;
                        }
                    }
                    i11 = i6 & 128;
                    if (i11 == 0) {
                        i7 |= 12582912;
                        function29 = function22;
                    } else {
                        function29 = function22;
                        if ((i3 & 12582912) == 0) {
                            i7 |= startRestartGroup.changedInstance(function29) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i6 & 256;
                    if (i12 == 0) {
                        i7 |= 100663296;
                    } else if ((i3 & 100663296) == 0) {
                        i13 = i12;
                        i7 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        i14 = i6 & 512;
                        if (i14 != 0) {
                            i7 |= C.ENCODING_PCM_32BIT;
                        } else if ((i3 & C.ENCODING_PCM_32BIT) == 0) {
                            i15 = i14;
                            i7 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                            i16 = i6 & 1024;
                            if (i16 == 0) {
                                i18 = i4 | 6;
                                i17 = i16;
                            } else if ((i4 & 6) == 0) {
                                i17 = i16;
                                i18 = i4 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                            } else {
                                i17 = i16;
                                i18 = i4;
                            }
                            i19 = i6 & 2048;
                            if (i19 == 0) {
                                i18 |= 48;
                                i20 = i19;
                            } else if ((i4 & 48) == 0) {
                                i20 = i19;
                                i18 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                            } else {
                                i20 = i19;
                            }
                            int i47 = i18;
                            i21 = i7;
                            i22 = i6 & 4096;
                            if (i22 == 0) {
                                i23 = i47 | 384;
                            } else {
                                int i48 = i47;
                                if ((i4 & 384) == 0) {
                                    i48 |= startRestartGroup.changedInstance(function27) ? 256 : 128;
                                }
                                i23 = i48;
                            }
                            i24 = i6 & 8192;
                            if (i24 == 0) {
                                i25 = i23 | 3072;
                            } else {
                                int i49 = i23;
                                if ((i4 & 3072) == 0) {
                                    i25 = i49 | (startRestartGroup.changed(z3) ? 2048 : 1024);
                                } else {
                                    i25 = i49;
                                }
                            }
                            i26 = i6 & 16384;
                            if (i26 == 0) {
                                i27 = i25 | 24576;
                            } else {
                                i27 = i25;
                                if ((i4 & 24576) == 0) {
                                    i27 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                                    i28 = i6 & 32768;
                                    if (i28 != 0) {
                                        i27 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                    } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                        i27 |= startRestartGroup.changed(keyboardOptions) ? 131072 : 65536;
                                    }
                                    i29 = i6 & 65536;
                                    if (i29 != 0) {
                                        i27 |= 1572864;
                                    } else if ((i4 & 1572864) == 0) {
                                        i27 |= startRestartGroup.changed(keyboardActions) ? 1048576 : 524288;
                                    }
                                    i30 = i6 & 131072;
                                    if (i30 != 0) {
                                        i27 |= 12582912;
                                    } else if ((i4 & 12582912) == 0) {
                                        i27 |= startRestartGroup.changed(z4) ? 8388608 : 4194304;
                                    }
                                    if ((i4 & 100663296) == 0) {
                                        i27 |= ((i6 & 262144) == 0 && startRestartGroup.changed(i)) ? 67108864 : 33554432;
                                    }
                                    i31 = i6 & 524288;
                                    if (i31 != 0) {
                                        i27 |= C.ENCODING_PCM_32BIT;
                                    } else if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                                        i27 |= startRestartGroup.changed(i2) ? 536870912 : 268435456;
                                    }
                                    i32 = i6 & 1048576;
                                    if (i32 != 0) {
                                        i33 = i5 | 6;
                                    } else if ((i5 & 6) == 0) {
                                        i33 = i5 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                                    } else {
                                        i33 = i5;
                                    }
                                    if ((i5 & 48) == 0) {
                                        i33 |= ((i6 & 2097152) == 0 && startRestartGroup.changed(shape)) ? 32 : 16;
                                    }
                                    if ((i5 & 384) == 0) {
                                        if ((i6 & 4194304) == 0 && startRestartGroup.changed(textFieldColors)) {
                                            i45 = 256;
                                            i33 |= i45;
                                        }
                                        i45 = 128;
                                        i33 |= i45;
                                    }
                                    int i50 = i33;
                                    if ((i21 & 306783379) == 306783378 || (i27 & 306783379) != 306783378 || (i50 & 147) != 146 || !startRestartGroup.getSkipping()) {
                                        startRestartGroup.startDefaults();
                                        if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            if (i46 != 0) {
                                                modifier2 = Modifier.INSTANCE;
                                            }
                                            if (i8 != 0) {
                                                z5 = true;
                                            }
                                            if (i9 != 0) {
                                                z6 = false;
                                            }
                                            if ((i6 & 32) != 0) {
                                                ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                Object consume = startRestartGroup.consume(localTextStyle);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                textStyle2 = (TextStyle) consume;
                                                i21 &= -458753;
                                            }
                                            if (i10 != 0) {
                                                function28 = null;
                                            }
                                            if (i11 != 0) {
                                                function29 = null;
                                            }
                                            Function2<? super Composer, ? super Integer, Unit> function223 = i13 != 0 ? null : function23;
                                            Function2<? super Composer, ? super Integer, Unit> function224 = i15 != 0 ? null : function24;
                                            Function2<? super Composer, ? super Integer, Unit> function225 = i17 != 0 ? null : function25;
                                            Function2<? super Composer, ? super Integer, Unit> function226 = i20 != 0 ? null : function26;
                                            Function2<? super Composer, ? super Integer, Unit> function227 = i22 == 0 ? function27 : null;
                                            boolean z15 = i24 != 0 ? false : z3;
                                            VisualTransformation none = i26 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                            KeyboardOptions keyboardOptions4 = i28 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                            KeyboardActions keyboardActions4 = i29 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                            boolean z16 = i30 != 0 ? false : z4;
                                            if ((i6 & 262144) != 0) {
                                                i34 = z16 ? 1 : Integer.MAX_VALUE;
                                                i27 &= -234881025;
                                            } else {
                                                i34 = i;
                                            }
                                            int i51 = i31 != 0 ? 1 : i2;
                                            if (i32 != 0) {
                                                startRestartGroup.startReplaceableGroup(1663535677);
                                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):OutlinedTextField.kt#9igjgp");
                                                Object rememberedValue = startRestartGroup.rememberedValue();
                                                i35 = i50;
                                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                                }
                                                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                                startRestartGroup.endReplaceableGroup();
                                            } else {
                                                i35 = i50;
                                                mutableInteractionSource2 = mutableInteractionSource;
                                            }
                                            if ((2097152 & i6) != 0) {
                                                mutableInteractionSource3 = mutableInteractionSource2;
                                                i36 = 6;
                                                shape2 = OutlinedTextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                                i37 = i35 & (-113);
                                            } else {
                                                mutableInteractionSource3 = mutableInteractionSource2;
                                                i36 = 6;
                                                shape2 = shape;
                                                i37 = i35;
                                            }
                                            Function2<? super Composer, ? super Integer, Unit> function228 = function227;
                                            if ((i6 & 4194304) != 0) {
                                                function210 = function228;
                                                shape3 = shape2;
                                                function211 = function223;
                                                function213 = function224;
                                                function214 = function29;
                                                function215 = function225;
                                                z7 = z15;
                                                i39 = i27;
                                                function216 = function226;
                                                keyboardOptions2 = keyboardOptions4;
                                                keyboardActions2 = keyboardActions4;
                                                z8 = z16;
                                                i40 = i34;
                                                i41 = i51;
                                                mutableInteractionSource4 = mutableInteractionSource3;
                                                textFieldColors2 = OutlinedTextFieldDefaults.INSTANCE.colors(startRestartGroup, i36);
                                                visualTransformation2 = none;
                                                z10 = z6;
                                                i42 = i21;
                                                i38 = i37 & (-897);
                                                textStyle3 = textStyle2;
                                                function212 = function28;
                                                modifier3 = modifier2;
                                            } else {
                                                function210 = function228;
                                                i38 = i37;
                                                shape3 = shape2;
                                                function211 = function223;
                                                textStyle3 = textStyle2;
                                                function212 = function28;
                                                function213 = function224;
                                                function214 = function29;
                                                modifier3 = modifier2;
                                                function215 = function225;
                                                z7 = z15;
                                                i39 = i27;
                                                function216 = function226;
                                                keyboardOptions2 = keyboardOptions4;
                                                keyboardActions2 = keyboardActions4;
                                                z8 = z16;
                                                i40 = i34;
                                                i41 = i51;
                                                mutableInteractionSource4 = mutableInteractionSource3;
                                                textFieldColors2 = textFieldColors;
                                                visualTransformation2 = none;
                                                z9 = z5;
                                                z10 = z6;
                                                i42 = i21;
                                                startRestartGroup.endDefaults();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1922450045, i42, i39, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:165)");
                                                }
                                                startRestartGroup.startReplaceableGroup(1663535958);
                                                ComposerKt.sourceInformation(startRestartGroup, "*168@9338L46");
                                                m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                                                if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                                    m5918getColor0d7_KjU = textFieldColors2.textColor$material3_release(z9, z7, mutableInteractionSource4, startRestartGroup, ((i39 >> 6) & 112) | ((i42 >> 9) & 14) | ((i38 << 6) & 896) | ((i38 << 3) & 7168)).getValue().m4073unboximpl();
                                                }
                                                startRestartGroup.endReplaceableGroup();
                                                final TextStyle merge = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                                CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getSelectionColors(startRestartGroup, (i38 >> 6) & 14)), ComposableLambdaKt.composableLambda(startRestartGroup, -1886965181, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$2
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

                                                    public final void invoke(Composer composer3, int i52) {
                                                        Modifier modifier4;
                                                        ComposerKt.sourceInformation(composer3, "C184@10067L38,193@10486L20,173@9567L2425:OutlinedTextField.kt#uh7d8r");
                                                        if ((i52 & 3) != 2 || !composer3.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1886965181, i52, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:173)");
                                                            }
                                                            if (function212 != null) {
                                                                modifier4 = PaddingKt.m883paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier3, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$2.1
                                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                                        invoke2(semanticsPropertyReceiver);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, null);
                                                            } else {
                                                                modifier4 = modifier3;
                                                            }
                                                            boolean z17 = z7;
                                                            Strings.Companion companion = Strings.INSTANCE;
                                                            Modifier m912defaultMinSizeVpY3zN4 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier4, z17, Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.default_error_message), composer3, 0)), OutlinedTextFieldDefaults.INSTANCE.m2387getMinWidthD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m2386getMinHeightD9Ej5fM());
                                                            SolidColor solidColor = new SolidColor(textFieldColors2.cursorColor$material3_release(z7, composer3, 0).getValue().m4073unboximpl(), null);
                                                            final String str3 = str2;
                                                            final boolean z18 = z9;
                                                            final boolean z19 = z8;
                                                            final VisualTransformation visualTransformation4 = visualTransformation2;
                                                            final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                                                            final boolean z20 = z7;
                                                            final Function2<Composer, Integer, Unit> function229 = function212;
                                                            final Function2<Composer, Integer, Unit> function230 = function214;
                                                            final Function2<Composer, Integer, Unit> function231 = function211;
                                                            final Function2<Composer, Integer, Unit> function232 = function213;
                                                            final Function2<Composer, Integer, Unit> function233 = function215;
                                                            final Function2<Composer, Integer, Unit> function234 = function216;
                                                            final Function2<Composer, Integer, Unit> function235 = function210;
                                                            final TextFieldColors textFieldColors4 = textFieldColors2;
                                                            final Shape shape5 = shape3;
                                                            BasicTextFieldKt.BasicTextField(str2, function12, m912defaultMinSizeVpY3zN4, z9, z10, merge, keyboardOptions2, keyboardActions2, z8, i40, i41, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource4, solidColor, ComposableLambdaKt.composableLambda(composer3, 1474611661, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$2.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function236, Composer composer4, Integer num) {
                                                                    invoke((Function2<? super Composer, ? super Integer, Unit>) function236, composer4, num.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function236, Composer composer4, int i53) {
                                                                    int i54;
                                                                    ComposerKt.sourceInformation(composer4, "C202@10922L1046:OutlinedTextField.kt#uh7d8r");
                                                                    if ((i53 & 6) == 0) {
                                                                        i54 = i53 | (composer4.changedInstance(function236) ? 4 : 2);
                                                                    } else {
                                                                        i54 = i53;
                                                                    }
                                                                    if ((i54 & 19) != 18 || !composer4.getSkipping()) {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(1474611661, i54, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:202)");
                                                                        }
                                                                        OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                                                                        int i55 = i54;
                                                                        String str4 = str3;
                                                                        boolean z21 = z18;
                                                                        boolean z22 = z19;
                                                                        VisualTransformation visualTransformation5 = visualTransformation4;
                                                                        MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource6;
                                                                        boolean z23 = z20;
                                                                        Function2<Composer, Integer, Unit> function237 = function229;
                                                                        Function2<Composer, Integer, Unit> function238 = function230;
                                                                        Function2<Composer, Integer, Unit> function239 = function231;
                                                                        Function2<Composer, Integer, Unit> function240 = function232;
                                                                        Function2<Composer, Integer, Unit> function241 = function233;
                                                                        Function2<Composer, Integer, Unit> function242 = function234;
                                                                        Function2<Composer, Integer, Unit> function243 = function235;
                                                                        TextFieldColors textFieldColors5 = textFieldColors4;
                                                                        final boolean z24 = z18;
                                                                        final boolean z25 = z20;
                                                                        final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource6;
                                                                        final TextFieldColors textFieldColors6 = textFieldColors4;
                                                                        final Shape shape6 = shape5;
                                                                        outlinedTextFieldDefaults.DecorationBox(str4, function236, z21, z22, visualTransformation5, mutableInteractionSource7, z23, function237, function238, function239, function240, function241, function242, function243, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer4, 2108828640, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(2);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function2
                                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                                invoke(composer5, num.intValue());
                                                                                return Unit.INSTANCE;
                                                                            }

                                                                            public final void invoke(Composer composer5, int i56) {
                                                                                ComposerKt.sourceInformation(composer5, "C219@11698L230:OutlinedTextField.kt#uh7d8r");
                                                                                if ((i56 & 3) != 2 || !composer5.getSkipping()) {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(2108828640, i56, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:219)");
                                                                                    }
                                                                                    OutlinedTextFieldDefaults.INSTANCE.m2382ContainerBoxnbWgWpA(z24, z25, mutableInteractionSource8, textFieldColors6, shape6, 0.0f, 0.0f, composer5, 12582912, 96);
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                composer5.skipToGroupEnd();
                                                                            }
                                                                        }), composer4, (i55 << 3) & 112, 14155776, 32768);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    composer4.skipToGroupEnd();
                                                                }
                                                            }), composer3, 0, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer3.skipToGroupEnd();
                                                    }
                                                }), startRestartGroup, ProvidedValue.$stable | 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                textStyle4 = textStyle3;
                                                composer2 = startRestartGroup;
                                                function217 = function212;
                                                z11 = z7;
                                                z12 = z9;
                                                z13 = z10;
                                                keyboardOptions3 = keyboardOptions2;
                                                keyboardActions3 = keyboardActions2;
                                                z14 = z8;
                                                i43 = i40;
                                                i44 = i41;
                                                visualTransformation3 = visualTransformation2;
                                                mutableInteractionSource5 = mutableInteractionSource4;
                                                function218 = function214;
                                                function219 = function211;
                                                function220 = function215;
                                                function221 = function210;
                                                shape4 = shape3;
                                                textFieldColors3 = textFieldColors2;
                                                function222 = function216;
                                            }
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            i42 = (i6 & 32) != 0 ? i21 & (-458753) : i21;
                                            if ((262144 & i6) != 0) {
                                                i27 &= -234881025;
                                            }
                                            if ((2097152 & i6) != 0) {
                                                i50 &= -113;
                                            }
                                            if ((i6 & 4194304) != 0) {
                                                i50 &= -897;
                                            }
                                            function211 = function23;
                                            function213 = function24;
                                            function215 = function25;
                                            function216 = function26;
                                            function210 = function27;
                                            z7 = z3;
                                            visualTransformation2 = visualTransformation;
                                            keyboardActions2 = keyboardActions;
                                            z8 = z4;
                                            i40 = i;
                                            i41 = i2;
                                            mutableInteractionSource4 = mutableInteractionSource;
                                            shape3 = shape;
                                            i38 = i50;
                                            z10 = z6;
                                            textStyle3 = textStyle2;
                                            function212 = function28;
                                            function214 = function29;
                                            modifier3 = modifier2;
                                            i39 = i27;
                                            keyboardOptions2 = keyboardOptions;
                                            textFieldColors2 = textFieldColors;
                                        }
                                        z9 = z5;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        startRestartGroup.startReplaceableGroup(1663535958);
                                        ComposerKt.sourceInformation(startRestartGroup, "*168@9338L46");
                                        m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                                        if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        final TextStyle merge2 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getSelectionColors(startRestartGroup, (i38 >> 6) & 14)), ComposableLambdaKt.composableLambda(startRestartGroup, -1886965181, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$2
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

                                            public final void invoke(Composer composer3, int i52) {
                                                Modifier modifier4;
                                                ComposerKt.sourceInformation(composer3, "C184@10067L38,193@10486L20,173@9567L2425:OutlinedTextField.kt#uh7d8r");
                                                if ((i52 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1886965181, i52, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:173)");
                                                    }
                                                    if (function212 != null) {
                                                        modifier4 = PaddingKt.m883paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier3, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$2.1
                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                                invoke2(semanticsPropertyReceiver);
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, null);
                                                    } else {
                                                        modifier4 = modifier3;
                                                    }
                                                    boolean z17 = z7;
                                                    Strings.Companion companion = Strings.INSTANCE;
                                                    Modifier m912defaultMinSizeVpY3zN4 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier4, z17, Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.default_error_message), composer3, 0)), OutlinedTextFieldDefaults.INSTANCE.m2387getMinWidthD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m2386getMinHeightD9Ej5fM());
                                                    SolidColor solidColor = new SolidColor(textFieldColors2.cursorColor$material3_release(z7, composer3, 0).getValue().m4073unboximpl(), null);
                                                    final String str3 = str2;
                                                    final boolean z18 = z9;
                                                    final boolean z19 = z8;
                                                    final VisualTransformation visualTransformation4 = visualTransformation2;
                                                    final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                                                    final boolean z20 = z7;
                                                    final Function2<? super Composer, ? super Integer, Unit> function229 = function212;
                                                    final Function2<? super Composer, ? super Integer, Unit> function230 = function214;
                                                    final Function2<? super Composer, ? super Integer, Unit> function231 = function211;
                                                    final Function2<? super Composer, ? super Integer, Unit> function232 = function213;
                                                    final Function2<? super Composer, ? super Integer, Unit> function233 = function215;
                                                    final Function2<? super Composer, ? super Integer, Unit> function234 = function216;
                                                    final Function2<? super Composer, ? super Integer, Unit> function235 = function210;
                                                    final TextFieldColors textFieldColors4 = textFieldColors2;
                                                    final Shape shape5 = shape3;
                                                    BasicTextFieldKt.BasicTextField(str2, function12, m912defaultMinSizeVpY3zN4, z9, z10, merge2, keyboardOptions2, keyboardActions2, z8, i40, i41, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource4, solidColor, ComposableLambdaKt.composableLambda(composer3, 1474611661, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$2.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function236, Composer composer4, Integer num) {
                                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function236, composer4, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function236, Composer composer4, int i53) {
                                                            int i54;
                                                            ComposerKt.sourceInformation(composer4, "C202@10922L1046:OutlinedTextField.kt#uh7d8r");
                                                            if ((i53 & 6) == 0) {
                                                                i54 = i53 | (composer4.changedInstance(function236) ? 4 : 2);
                                                            } else {
                                                                i54 = i53;
                                                            }
                                                            if ((i54 & 19) != 18 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1474611661, i54, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:202)");
                                                                }
                                                                OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                                                                int i55 = i54;
                                                                String str4 = str3;
                                                                boolean z21 = z18;
                                                                boolean z22 = z19;
                                                                VisualTransformation visualTransformation5 = visualTransformation4;
                                                                MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource6;
                                                                boolean z23 = z20;
                                                                Function2<Composer, Integer, Unit> function237 = function229;
                                                                Function2<Composer, Integer, Unit> function238 = function230;
                                                                Function2<Composer, Integer, Unit> function239 = function231;
                                                                Function2<Composer, Integer, Unit> function240 = function232;
                                                                Function2<Composer, Integer, Unit> function241 = function233;
                                                                Function2<Composer, Integer, Unit> function242 = function234;
                                                                Function2<Composer, Integer, Unit> function243 = function235;
                                                                TextFieldColors textFieldColors5 = textFieldColors4;
                                                                final boolean z24 = z18;
                                                                final boolean z25 = z20;
                                                                final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource6;
                                                                final TextFieldColors textFieldColors6 = textFieldColors4;
                                                                final Shape shape6 = shape5;
                                                                outlinedTextFieldDefaults.DecorationBox(str4, function236, z21, z22, visualTransformation5, mutableInteractionSource7, z23, function237, function238, function239, function240, function241, function242, function243, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer4, 2108828640, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.2.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(2);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                        invoke(composer5, num.intValue());
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    public final void invoke(Composer composer5, int i56) {
                                                                        ComposerKt.sourceInformation(composer5, "C219@11698L230:OutlinedTextField.kt#uh7d8r");
                                                                        if ((i56 & 3) != 2 || !composer5.getSkipping()) {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(2108828640, i56, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:219)");
                                                                            }
                                                                            OutlinedTextFieldDefaults.INSTANCE.m2382ContainerBoxnbWgWpA(z24, z25, mutableInteractionSource8, textFieldColors6, shape6, 0.0f, 0.0f, composer5, 12582912, 96);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        composer5.skipToGroupEnd();
                                                                    }
                                                                }), composer4, (i55 << 3) & 112, 14155776, 32768);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }), composer3, 0, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }), startRestartGroup, ProvidedValue.$stable | 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        textStyle4 = textStyle3;
                                        composer2 = startRestartGroup;
                                        function217 = function212;
                                        z11 = z7;
                                        z12 = z9;
                                        z13 = z10;
                                        keyboardOptions3 = keyboardOptions2;
                                        keyboardActions3 = keyboardActions2;
                                        z14 = z8;
                                        i43 = i40;
                                        i44 = i41;
                                        visualTransformation3 = visualTransformation2;
                                        mutableInteractionSource5 = mutableInteractionSource4;
                                        function218 = function214;
                                        function219 = function211;
                                        function220 = function215;
                                        function221 = function210;
                                        shape4 = shape3;
                                        textFieldColors3 = textFieldColors2;
                                        function222 = function216;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        function213 = function24;
                                        function220 = function25;
                                        function221 = function27;
                                        z11 = z3;
                                        keyboardOptions3 = keyboardOptions;
                                        keyboardActions3 = keyboardActions;
                                        z14 = z4;
                                        i43 = i;
                                        i44 = i2;
                                        mutableInteractionSource5 = mutableInteractionSource;
                                        shape4 = shape;
                                        textFieldColors3 = textFieldColors;
                                        composer2 = startRestartGroup;
                                        z12 = z5;
                                        z13 = z6;
                                        textStyle4 = textStyle2;
                                        function217 = function28;
                                        function218 = function29;
                                        modifier3 = modifier2;
                                        function219 = function23;
                                        function222 = function26;
                                        visualTransformation3 = visualTransformation;
                                    }
                                    ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        final Function2<? super Composer, ? super Integer, Unit> function229 = function213;
                                        final Modifier modifier4 = modifier3;
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$3
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

                                            public final void invoke(Composer composer3, int i52) {
                                                OutlinedTextFieldKt.OutlinedTextField(str, function1, modifier4, z12, z13, textStyle4, function217, function218, function219, function229, function220, function222, function221, z11, visualTransformation3, keyboardOptions3, keyboardActions3, z14, i43, i44, mutableInteractionSource5, shape4, textFieldColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                            i28 = i6 & 32768;
                            if (i28 != 0) {
                            }
                            i29 = i6 & 65536;
                            if (i29 != 0) {
                            }
                            i30 = i6 & 131072;
                            if (i30 != 0) {
                            }
                            if ((i4 & 100663296) == 0) {
                            }
                            i31 = i6 & 524288;
                            if (i31 != 0) {
                            }
                            i32 = i6 & 1048576;
                            if (i32 != 0) {
                            }
                            if ((i5 & 48) == 0) {
                            }
                            if ((i5 & 384) == 0) {
                            }
                            int i502 = i33;
                            if ((i21 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                            }
                            if (i46 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if ((i6 & 32) != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i15 != 0) {
                            }
                            if (i17 != 0) {
                            }
                            if (i20 != 0) {
                            }
                            if (i22 == 0) {
                            }
                            if (i24 != 0) {
                            }
                            if (i26 != 0) {
                            }
                            if (i28 != 0) {
                            }
                            if (i29 != 0) {
                            }
                            if (i30 != 0) {
                            }
                            if ((i6 & 262144) != 0) {
                            }
                            if (i31 != 0) {
                            }
                            if (i32 != 0) {
                            }
                            if ((2097152 & i6) != 0) {
                            }
                            Function2<? super Composer, ? super Integer, Unit> function2282 = function227;
                            if ((i6 & 4194304) != 0) {
                            }
                        }
                        i15 = i14;
                        i16 = i6 & 1024;
                        if (i16 == 0) {
                        }
                        i19 = i6 & 2048;
                        if (i19 == 0) {
                        }
                        int i472 = i18;
                        i21 = i7;
                        i22 = i6 & 4096;
                        if (i22 == 0) {
                        }
                        i24 = i6 & 8192;
                        if (i24 == 0) {
                        }
                        i26 = i6 & 16384;
                        if (i26 == 0) {
                        }
                        i28 = i6 & 32768;
                        if (i28 != 0) {
                        }
                        i29 = i6 & 65536;
                        if (i29 != 0) {
                        }
                        i30 = i6 & 131072;
                        if (i30 != 0) {
                        }
                        if ((i4 & 100663296) == 0) {
                        }
                        i31 = i6 & 524288;
                        if (i31 != 0) {
                        }
                        i32 = i6 & 1048576;
                        if (i32 != 0) {
                        }
                        if ((i5 & 48) == 0) {
                        }
                        if ((i5 & 384) == 0) {
                        }
                        int i5022 = i33;
                        if ((i21 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i46 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if ((i6 & 32) != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i15 != 0) {
                        }
                        if (i17 != 0) {
                        }
                        if (i20 != 0) {
                        }
                        if (i22 == 0) {
                        }
                        if (i24 != 0) {
                        }
                        if (i26 != 0) {
                        }
                        if (i28 != 0) {
                        }
                        if (i29 != 0) {
                        }
                        if (i30 != 0) {
                        }
                        if ((i6 & 262144) != 0) {
                        }
                        if (i31 != 0) {
                        }
                        if (i32 != 0) {
                        }
                        if ((2097152 & i6) != 0) {
                        }
                        Function2<? super Composer, ? super Integer, Unit> function22822 = function227;
                        if ((i6 & 4194304) != 0) {
                        }
                    }
                    i13 = i12;
                    i14 = i6 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i6 & 1024;
                    if (i16 == 0) {
                    }
                    i19 = i6 & 2048;
                    if (i19 == 0) {
                    }
                    int i4722 = i18;
                    i21 = i7;
                    i22 = i6 & 4096;
                    if (i22 == 0) {
                    }
                    i24 = i6 & 8192;
                    if (i24 == 0) {
                    }
                    i26 = i6 & 16384;
                    if (i26 == 0) {
                    }
                    i28 = i6 & 32768;
                    if (i28 != 0) {
                    }
                    i29 = i6 & 65536;
                    if (i29 != 0) {
                    }
                    i30 = i6 & 131072;
                    if (i30 != 0) {
                    }
                    if ((i4 & 100663296) == 0) {
                    }
                    i31 = i6 & 524288;
                    if (i31 != 0) {
                    }
                    i32 = i6 & 1048576;
                    if (i32 != 0) {
                    }
                    if ((i5 & 48) == 0) {
                    }
                    if ((i5 & 384) == 0) {
                    }
                    int i50222 = i33;
                    if ((i21 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i46 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i6 & 32) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    if (i22 == 0) {
                    }
                    if (i24 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if (i28 != 0) {
                    }
                    if (i29 != 0) {
                    }
                    if (i30 != 0) {
                    }
                    if ((i6 & 262144) != 0) {
                    }
                    if (i31 != 0) {
                    }
                    if (i32 != 0) {
                    }
                    if ((2097152 & i6) != 0) {
                    }
                    Function2<? super Composer, ? super Integer, Unit> function228222 = function227;
                    if ((i6 & 4194304) != 0) {
                    }
                }
                z6 = z2;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                i11 = i6 & 128;
                if (i11 == 0) {
                }
                i12 = i6 & 256;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i6 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i6 & 1024;
                if (i16 == 0) {
                }
                i19 = i6 & 2048;
                if (i19 == 0) {
                }
                int i47222 = i18;
                i21 = i7;
                i22 = i6 & 4096;
                if (i22 == 0) {
                }
                i24 = i6 & 8192;
                if (i24 == 0) {
                }
                i26 = i6 & 16384;
                if (i26 == 0) {
                }
                i28 = i6 & 32768;
                if (i28 != 0) {
                }
                i29 = i6 & 65536;
                if (i29 != 0) {
                }
                i30 = i6 & 131072;
                if (i30 != 0) {
                }
                if ((i4 & 100663296) == 0) {
                }
                i31 = i6 & 524288;
                if (i31 != 0) {
                }
                i32 = i6 & 1048576;
                if (i32 != 0) {
                }
                if ((i5 & 48) == 0) {
                }
                if ((i5 & 384) == 0) {
                }
                int i502222 = i33;
                if ((i21 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i46 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if ((i6 & 32) != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i13 != 0) {
                }
                if (i15 != 0) {
                }
                if (i17 != 0) {
                }
                if (i20 != 0) {
                }
                if (i22 == 0) {
                }
                if (i24 != 0) {
                }
                if (i26 != 0) {
                }
                if (i28 != 0) {
                }
                if (i29 != 0) {
                }
                if (i30 != 0) {
                }
                if ((i6 & 262144) != 0) {
                }
                if (i31 != 0) {
                }
                if (i32 != 0) {
                }
                if ((2097152 & i6) != 0) {
                }
                Function2<? super Composer, ? super Integer, Unit> function2282222 = function227;
                if ((i6 & 4194304) != 0) {
                }
            }
            z5 = z;
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            z6 = z2;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            i11 = i6 & 128;
            if (i11 == 0) {
            }
            i12 = i6 & 256;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i6 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i6 & 1024;
            if (i16 == 0) {
            }
            i19 = i6 & 2048;
            if (i19 == 0) {
            }
            int i472222 = i18;
            i21 = i7;
            i22 = i6 & 4096;
            if (i22 == 0) {
            }
            i24 = i6 & 8192;
            if (i24 == 0) {
            }
            i26 = i6 & 16384;
            if (i26 == 0) {
            }
            i28 = i6 & 32768;
            if (i28 != 0) {
            }
            i29 = i6 & 65536;
            if (i29 != 0) {
            }
            i30 = i6 & 131072;
            if (i30 != 0) {
            }
            if ((i4 & 100663296) == 0) {
            }
            i31 = i6 & 524288;
            if (i31 != 0) {
            }
            i32 = i6 & 1048576;
            if (i32 != 0) {
            }
            if ((i5 & 48) == 0) {
            }
            if ((i5 & 384) == 0) {
            }
            int i5022222 = i33;
            if ((i21 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i46 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i13 != 0) {
            }
            if (i15 != 0) {
            }
            if (i17 != 0) {
            }
            if (i20 != 0) {
            }
            if (i22 == 0) {
            }
            if (i24 != 0) {
            }
            if (i26 != 0) {
            }
            if (i28 != 0) {
            }
            if (i29 != 0) {
            }
            if (i30 != 0) {
            }
            if ((i6 & 262144) != 0) {
            }
            if (i31 != 0) {
            }
            if (i32 != 0) {
            }
            if ((2097152 & i6) != 0) {
            }
            Function2<? super Composer, ? super Integer, Unit> function22822222 = function227;
            if ((i6 & 4194304) != 0) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z5 = z;
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        z6 = z2;
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        i11 = i6 & 128;
        if (i11 == 0) {
        }
        i12 = i6 & 256;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i6 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i6 & 1024;
        if (i16 == 0) {
        }
        i19 = i6 & 2048;
        if (i19 == 0) {
        }
        int i4722222 = i18;
        i21 = i7;
        i22 = i6 & 4096;
        if (i22 == 0) {
        }
        i24 = i6 & 8192;
        if (i24 == 0) {
        }
        i26 = i6 & 16384;
        if (i26 == 0) {
        }
        i28 = i6 & 32768;
        if (i28 != 0) {
        }
        i29 = i6 & 65536;
        if (i29 != 0) {
        }
        i30 = i6 & 131072;
        if (i30 != 0) {
        }
        if ((i4 & 100663296) == 0) {
        }
        i31 = i6 & 524288;
        if (i31 != 0) {
        }
        i32 = i6 & 1048576;
        if (i32 != 0) {
        }
        if ((i5 & 48) == 0) {
        }
        if ((i5 & 384) == 0) {
        }
        int i50222222 = i33;
        if ((i21 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i46 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i13 != 0) {
        }
        if (i15 != 0) {
        }
        if (i17 != 0) {
        }
        if (i20 != 0) {
        }
        if (i22 == 0) {
        }
        if (i24 != 0) {
        }
        if (i26 != 0) {
        }
        if (i28 != 0) {
        }
        if (i29 != 0) {
        }
        if (i30 != 0) {
        }
        if ((i6 & 262144) != 0) {
        }
        if (i31 != 0) {
        }
        if (i32 != 0) {
        }
        if ((2097152 & i6) != 0) {
        }
        Function2<? super Composer, ? super Integer, Unit> function228222222 = function227;
        if ((i6 & 4194304) != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0519  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x05b9  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03d8  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OutlinedTextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5, final int i6) {
        final TextFieldValue textFieldValue2;
        int i7;
        final Function1<? super TextFieldValue, Unit> function12;
        Modifier modifier2;
        int i8;
        boolean z5;
        int i9;
        boolean z6;
        TextStyle textStyle2;
        int i10;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i11;
        Function2<? super Composer, ? super Integer, Unit> function29;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        int i36;
        Shape shape2;
        int i37;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        int i38;
        final Shape shape3;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        TextStyle textStyle3;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final boolean z7;
        int i39;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        final KeyboardOptions keyboardOptions2;
        final KeyboardActions keyboardActions2;
        final boolean z8;
        final int i40;
        final int i41;
        final MutableInteractionSource mutableInteractionSource4;
        final TextFieldColors textFieldColors2;
        final VisualTransformation visualTransformation2;
        final boolean z9;
        final boolean z10;
        int i42;
        long m5918getColor0d7_KjU;
        final TextStyle textStyle4;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        final boolean z11;
        final boolean z12;
        final boolean z13;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean z14;
        final int i43;
        final int i44;
        final VisualTransformation visualTransformation3;
        final MutableInteractionSource mutableInteractionSource5;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        final Function2<? super Composer, ? super Integer, Unit> function219;
        final Function2<? super Composer, ? super Integer, Unit> function220;
        final Function2<? super Composer, ? super Integer, Unit> function221;
        final Shape shape4;
        final TextFieldColors textFieldColors3;
        final Function2<? super Composer, ? super Integer, Unit> function222;
        int i45;
        Composer startRestartGroup = composer.startRestartGroup(-1570442800);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedTextField)P(21,11,10,1,14,19,6,12,7,20,13,17,18,3,22,5,4,16,8,9,2,15)307@17107L7,322@17859L39,323@17945L5,324@18008L8,332@18370L15,332@18304L2529:OutlinedTextField.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i3 | 6;
            textFieldValue2 = textFieldValue;
        } else {
            textFieldValue2 = textFieldValue;
            if ((i3 & 6) == 0) {
                i7 = (startRestartGroup.changed(textFieldValue2) ? 4 : 2) | i3;
            } else {
                i7 = i3;
            }
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
            function12 = function1;
        } else {
            function12 = function1;
            if ((i3 & 48) == 0) {
                i7 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
            }
        }
        int i46 = i6 & 4;
        if (i46 != 0) {
            i7 |= 384;
        } else if ((i3 & 384) == 0) {
            modifier2 = modifier;
            i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i3 & 3072) == 0) {
                z5 = z;
                i7 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else if ((i3 & 24576) == 0) {
                    z6 = z2;
                    i7 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                        textStyle2 = textStyle;
                        i7 |= ((i6 & 32) == 0 && startRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                    } else {
                        textStyle2 = textStyle;
                    }
                    i10 = i6 & 64;
                    if (i10 == 0) {
                        i7 |= 1572864;
                        function28 = function2;
                    } else {
                        function28 = function2;
                        if ((i3 & 1572864) == 0) {
                            i7 |= startRestartGroup.changedInstance(function28) ? 1048576 : 524288;
                        }
                    }
                    i11 = i6 & 128;
                    if (i11 == 0) {
                        i7 |= 12582912;
                        function29 = function22;
                    } else {
                        function29 = function22;
                        if ((i3 & 12582912) == 0) {
                            i7 |= startRestartGroup.changedInstance(function29) ? 8388608 : 4194304;
                        }
                    }
                    i12 = i6 & 256;
                    if (i12 == 0) {
                        i7 |= 100663296;
                    } else if ((i3 & 100663296) == 0) {
                        i13 = i12;
                        i7 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                        i14 = i6 & 512;
                        if (i14 != 0) {
                            i7 |= C.ENCODING_PCM_32BIT;
                        } else if ((i3 & C.ENCODING_PCM_32BIT) == 0) {
                            i15 = i14;
                            i7 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                            i16 = i6 & 1024;
                            if (i16 == 0) {
                                i18 = i4 | 6;
                                i17 = i16;
                            } else if ((i4 & 6) == 0) {
                                i17 = i16;
                                i18 = i4 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                            } else {
                                i17 = i16;
                                i18 = i4;
                            }
                            i19 = i6 & 2048;
                            if (i19 == 0) {
                                i18 |= 48;
                                i20 = i19;
                            } else if ((i4 & 48) == 0) {
                                i20 = i19;
                                i18 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                            } else {
                                i20 = i19;
                            }
                            int i47 = i18;
                            i21 = i7;
                            i22 = i6 & 4096;
                            if (i22 == 0) {
                                i23 = i47 | 384;
                            } else {
                                int i48 = i47;
                                if ((i4 & 384) == 0) {
                                    i48 |= startRestartGroup.changedInstance(function27) ? 256 : 128;
                                }
                                i23 = i48;
                            }
                            i24 = i6 & 8192;
                            if (i24 == 0) {
                                i25 = i23 | 3072;
                            } else {
                                int i49 = i23;
                                if ((i4 & 3072) == 0) {
                                    i25 = i49 | (startRestartGroup.changed(z3) ? 2048 : 1024);
                                } else {
                                    i25 = i49;
                                }
                            }
                            i26 = i6 & 16384;
                            if (i26 == 0) {
                                i27 = i25 | 24576;
                            } else {
                                i27 = i25;
                                if ((i4 & 24576) == 0) {
                                    i27 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                                    i28 = i6 & 32768;
                                    if (i28 != 0) {
                                        i27 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                    } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                        i27 |= startRestartGroup.changed(keyboardOptions) ? 131072 : 65536;
                                    }
                                    i29 = i6 & 65536;
                                    if (i29 != 0) {
                                        i27 |= 1572864;
                                    } else if ((i4 & 1572864) == 0) {
                                        i27 |= startRestartGroup.changed(keyboardActions) ? 1048576 : 524288;
                                    }
                                    i30 = i6 & 131072;
                                    if (i30 != 0) {
                                        i27 |= 12582912;
                                    } else if ((i4 & 12582912) == 0) {
                                        i27 |= startRestartGroup.changed(z4) ? 8388608 : 4194304;
                                    }
                                    if ((i4 & 100663296) == 0) {
                                        i27 |= ((i6 & 262144) == 0 && startRestartGroup.changed(i)) ? 67108864 : 33554432;
                                    }
                                    i31 = i6 & 524288;
                                    if (i31 != 0) {
                                        i27 |= C.ENCODING_PCM_32BIT;
                                    } else if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                                        i27 |= startRestartGroup.changed(i2) ? 536870912 : 268435456;
                                    }
                                    i32 = i6 & 1048576;
                                    if (i32 != 0) {
                                        i33 = i5 | 6;
                                    } else if ((i5 & 6) == 0) {
                                        i33 = i5 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                                    } else {
                                        i33 = i5;
                                    }
                                    if ((i5 & 48) == 0) {
                                        i33 |= ((i6 & 2097152) == 0 && startRestartGroup.changed(shape)) ? 32 : 16;
                                    }
                                    if ((i5 & 384) == 0) {
                                        if ((i6 & 4194304) == 0 && startRestartGroup.changed(textFieldColors)) {
                                            i45 = 256;
                                            i33 |= i45;
                                        }
                                        i45 = 128;
                                        i33 |= i45;
                                    }
                                    int i50 = i33;
                                    if ((i21 & 306783379) == 306783378 || (i27 & 306783379) != 306783378 || (i50 & 147) != 146 || !startRestartGroup.getSkipping()) {
                                        startRestartGroup.startDefaults();
                                        if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            if (i46 != 0) {
                                                modifier2 = Modifier.INSTANCE;
                                            }
                                            if (i8 != 0) {
                                                z5 = true;
                                            }
                                            if (i9 != 0) {
                                                z6 = false;
                                            }
                                            if ((i6 & 32) != 0) {
                                                ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                Object consume = startRestartGroup.consume(localTextStyle);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                textStyle2 = (TextStyle) consume;
                                                i21 &= -458753;
                                            }
                                            if (i10 != 0) {
                                                function28 = null;
                                            }
                                            if (i11 != 0) {
                                                function29 = null;
                                            }
                                            Function2<? super Composer, ? super Integer, Unit> function223 = i13 != 0 ? null : function23;
                                            Function2<? super Composer, ? super Integer, Unit> function224 = i15 != 0 ? null : function24;
                                            Function2<? super Composer, ? super Integer, Unit> function225 = i17 != 0 ? null : function25;
                                            Function2<? super Composer, ? super Integer, Unit> function226 = i20 != 0 ? null : function26;
                                            Function2<? super Composer, ? super Integer, Unit> function227 = i22 == 0 ? function27 : null;
                                            boolean z15 = i24 != 0 ? false : z3;
                                            VisualTransformation none = i26 != 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                            KeyboardOptions keyboardOptions4 = i28 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                            KeyboardActions keyboardActions4 = i29 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                            boolean z16 = i30 != 0 ? false : z4;
                                            if ((i6 & 262144) != 0) {
                                                i34 = z16 ? 1 : Integer.MAX_VALUE;
                                                i27 &= -234881025;
                                            } else {
                                                i34 = i;
                                            }
                                            int i51 = i31 != 0 ? 1 : i2;
                                            if (i32 != 0) {
                                                startRestartGroup.startReplaceableGroup(1663544507);
                                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):OutlinedTextField.kt#9igjgp");
                                                Object rememberedValue = startRestartGroup.rememberedValue();
                                                i35 = i50;
                                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                                }
                                                mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                                startRestartGroup.endReplaceableGroup();
                                            } else {
                                                i35 = i50;
                                                mutableInteractionSource2 = mutableInteractionSource;
                                            }
                                            if ((2097152 & i6) != 0) {
                                                mutableInteractionSource3 = mutableInteractionSource2;
                                                i36 = 6;
                                                shape2 = OutlinedTextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                                i37 = i35 & (-113);
                                            } else {
                                                mutableInteractionSource3 = mutableInteractionSource2;
                                                i36 = 6;
                                                shape2 = shape;
                                                i37 = i35;
                                            }
                                            Function2<? super Composer, ? super Integer, Unit> function228 = function227;
                                            if ((i6 & 4194304) != 0) {
                                                function210 = function228;
                                                shape3 = shape2;
                                                function211 = function223;
                                                function213 = function224;
                                                function214 = function29;
                                                function215 = function225;
                                                z7 = z15;
                                                i39 = i27;
                                                function216 = function226;
                                                keyboardOptions2 = keyboardOptions4;
                                                keyboardActions2 = keyboardActions4;
                                                z8 = z16;
                                                i40 = i34;
                                                i41 = i51;
                                                mutableInteractionSource4 = mutableInteractionSource3;
                                                textFieldColors2 = OutlinedTextFieldDefaults.INSTANCE.colors(startRestartGroup, i36);
                                                visualTransformation2 = none;
                                                z10 = z6;
                                                i42 = i21;
                                                i38 = i37 & (-897);
                                                textStyle3 = textStyle2;
                                                function212 = function28;
                                                modifier3 = modifier2;
                                            } else {
                                                function210 = function228;
                                                i38 = i37;
                                                shape3 = shape2;
                                                function211 = function223;
                                                textStyle3 = textStyle2;
                                                function212 = function28;
                                                function213 = function224;
                                                function214 = function29;
                                                modifier3 = modifier2;
                                                function215 = function225;
                                                z7 = z15;
                                                i39 = i27;
                                                function216 = function226;
                                                keyboardOptions2 = keyboardOptions4;
                                                keyboardActions2 = keyboardActions4;
                                                z8 = z16;
                                                i40 = i34;
                                                i41 = i51;
                                                mutableInteractionSource4 = mutableInteractionSource3;
                                                textFieldColors2 = textFieldColors;
                                                visualTransformation2 = none;
                                                z9 = z5;
                                                z10 = z6;
                                                i42 = i21;
                                                startRestartGroup.endDefaults();
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1570442800, i42, i39, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:325)");
                                                }
                                                startRestartGroup.startReplaceableGroup(1663544788);
                                                ComposerKt.sourceInformation(startRestartGroup, "*328@18168L46");
                                                m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                                                if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                                    m5918getColor0d7_KjU = textFieldColors2.textColor$material3_release(z9, z7, mutableInteractionSource4, startRestartGroup, ((i39 >> 6) & 112) | ((i42 >> 9) & 14) | ((i38 << 6) & 896) | ((i38 << 3) & 7168)).getValue().m4073unboximpl();
                                                }
                                                startRestartGroup.endReplaceableGroup();
                                                final TextStyle merge = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                                CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getSelectionColors(startRestartGroup, (i38 >> 6) & 14)), ComposableLambdaKt.composableLambda(startRestartGroup, 1830921872, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$5
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

                                                    public final void invoke(Composer composer3, int i52) {
                                                        Modifier modifier4;
                                                        ComposerKt.sourceInformation(composer3, "C344@18897L38,353@19316L20,333@18397L2430:OutlinedTextField.kt#uh7d8r");
                                                        if ((i52 & 3) != 2 || !composer3.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1830921872, i52, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:333)");
                                                            }
                                                            if (function212 != null) {
                                                                modifier4 = PaddingKt.m883paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier3, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$5.1
                                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                    public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                                        invoke2(semanticsPropertyReceiver);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                }), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, null);
                                                            } else {
                                                                modifier4 = modifier3;
                                                            }
                                                            boolean z17 = z7;
                                                            Strings.Companion companion = Strings.INSTANCE;
                                                            Modifier m912defaultMinSizeVpY3zN4 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier4, z17, Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.default_error_message), composer3, 0)), OutlinedTextFieldDefaults.INSTANCE.m2387getMinWidthD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m2386getMinHeightD9Ej5fM());
                                                            SolidColor solidColor = new SolidColor(textFieldColors2.cursorColor$material3_release(z7, composer3, 0).getValue().m4073unboximpl(), null);
                                                            final TextFieldValue textFieldValue3 = textFieldValue2;
                                                            final boolean z18 = z9;
                                                            final boolean z19 = z8;
                                                            final VisualTransformation visualTransformation4 = visualTransformation2;
                                                            final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                                                            final boolean z20 = z7;
                                                            final Function2<Composer, Integer, Unit> function229 = function212;
                                                            final Function2<Composer, Integer, Unit> function230 = function214;
                                                            final Function2<Composer, Integer, Unit> function231 = function211;
                                                            final Function2<Composer, Integer, Unit> function232 = function213;
                                                            final Function2<Composer, Integer, Unit> function233 = function215;
                                                            final Function2<Composer, Integer, Unit> function234 = function216;
                                                            final Function2<Composer, Integer, Unit> function235 = function210;
                                                            final TextFieldColors textFieldColors4 = textFieldColors2;
                                                            final Shape shape5 = shape3;
                                                            BasicTextFieldKt.BasicTextField(textFieldValue2, function12, m912defaultMinSizeVpY3zN4, z9, z10, merge, keyboardOptions2, keyboardActions2, z8, i40, i41, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource4, solidColor, ComposableLambdaKt.composableLambda(composer3, -757328870, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$5.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(3);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function3
                                                                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function236, Composer composer4, Integer num) {
                                                                    invoke((Function2<? super Composer, ? super Integer, Unit>) function236, composer4, num.intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function236, Composer composer4, int i53) {
                                                                    int i54;
                                                                    ComposerKt.sourceInformation(composer4, "C362@19752L1051:OutlinedTextField.kt#uh7d8r");
                                                                    if ((i53 & 6) == 0) {
                                                                        i54 = i53 | (composer4.changedInstance(function236) ? 4 : 2);
                                                                    } else {
                                                                        i54 = i53;
                                                                    }
                                                                    if ((i54 & 19) != 18 || !composer4.getSkipping()) {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-757328870, i54, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:362)");
                                                                        }
                                                                        OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                                                                        String text = TextFieldValue.this.getText();
                                                                        boolean z21 = z18;
                                                                        int i55 = i54;
                                                                        boolean z22 = z19;
                                                                        VisualTransformation visualTransformation5 = visualTransformation4;
                                                                        MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource6;
                                                                        boolean z23 = z20;
                                                                        Function2<Composer, Integer, Unit> function237 = function229;
                                                                        Function2<Composer, Integer, Unit> function238 = function230;
                                                                        Function2<Composer, Integer, Unit> function239 = function231;
                                                                        Function2<Composer, Integer, Unit> function240 = function232;
                                                                        Function2<Composer, Integer, Unit> function241 = function233;
                                                                        Function2<Composer, Integer, Unit> function242 = function234;
                                                                        Function2<Composer, Integer, Unit> function243 = function235;
                                                                        TextFieldColors textFieldColors5 = textFieldColors4;
                                                                        final boolean z24 = z18;
                                                                        final boolean z25 = z20;
                                                                        final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource6;
                                                                        final TextFieldColors textFieldColors6 = textFieldColors4;
                                                                        final Shape shape6 = shape5;
                                                                        outlinedTextFieldDefaults.DecorationBox(text, function236, z21, z22, visualTransformation5, mutableInteractionSource7, z23, function237, function238, function239, function240, function241, function242, function243, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer4, 255570733, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(2);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function2
                                                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                                invoke(composer5, num.intValue());
                                                                                return Unit.INSTANCE;
                                                                            }

                                                                            public final void invoke(Composer composer5, int i56) {
                                                                                ComposerKt.sourceInformation(composer5, "C379@20533L230:OutlinedTextField.kt#uh7d8r");
                                                                                if ((i56 & 3) != 2 || !composer5.getSkipping()) {
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventStart(255570733, i56, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:379)");
                                                                                    }
                                                                                    OutlinedTextFieldDefaults.INSTANCE.m2382ContainerBoxnbWgWpA(z24, z25, mutableInteractionSource8, textFieldColors6, shape6, 0.0f, 0.0f, composer5, 12582912, 96);
                                                                                    if (ComposerKt.isTraceInProgress()) {
                                                                                        ComposerKt.traceEventEnd();
                                                                                        return;
                                                                                    }
                                                                                    return;
                                                                                }
                                                                                composer5.skipToGroupEnd();
                                                                            }
                                                                        }), composer4, (i55 << 3) & 112, 14155776, 32768);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    composer4.skipToGroupEnd();
                                                                }
                                                            }), composer3, 0, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer3.skipToGroupEnd();
                                                    }
                                                }), startRestartGroup, ProvidedValue.$stable | 48);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                textStyle4 = textStyle3;
                                                composer2 = startRestartGroup;
                                                function217 = function212;
                                                z11 = z7;
                                                z12 = z9;
                                                z13 = z10;
                                                keyboardOptions3 = keyboardOptions2;
                                                keyboardActions3 = keyboardActions2;
                                                z14 = z8;
                                                i43 = i40;
                                                i44 = i41;
                                                visualTransformation3 = visualTransformation2;
                                                mutableInteractionSource5 = mutableInteractionSource4;
                                                function218 = function214;
                                                function219 = function211;
                                                function220 = function215;
                                                function221 = function210;
                                                shape4 = shape3;
                                                textFieldColors3 = textFieldColors2;
                                                function222 = function216;
                                            }
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            i42 = (i6 & 32) != 0 ? i21 & (-458753) : i21;
                                            if ((262144 & i6) != 0) {
                                                i27 &= -234881025;
                                            }
                                            if ((2097152 & i6) != 0) {
                                                i50 &= -113;
                                            }
                                            if ((i6 & 4194304) != 0) {
                                                i50 &= -897;
                                            }
                                            function211 = function23;
                                            function213 = function24;
                                            function215 = function25;
                                            function216 = function26;
                                            function210 = function27;
                                            z7 = z3;
                                            visualTransformation2 = visualTransformation;
                                            keyboardActions2 = keyboardActions;
                                            z8 = z4;
                                            i40 = i;
                                            i41 = i2;
                                            mutableInteractionSource4 = mutableInteractionSource;
                                            shape3 = shape;
                                            i38 = i50;
                                            z10 = z6;
                                            textStyle3 = textStyle2;
                                            function212 = function28;
                                            function214 = function29;
                                            modifier3 = modifier2;
                                            i39 = i27;
                                            keyboardOptions2 = keyboardOptions;
                                            textFieldColors2 = textFieldColors;
                                        }
                                        z9 = z5;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        startRestartGroup.startReplaceableGroup(1663544788);
                                        ComposerKt.sourceInformation(startRestartGroup, "*328@18168L46");
                                        m5918getColor0d7_KjU = textStyle3.m5918getColor0d7_KjU();
                                        if (m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        final TextStyle merge2 = textStyle3.merge(new TextStyle(m5918getColor0d7_KjU, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                                        CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(textFieldColors2.getSelectionColors(startRestartGroup, (i38 >> 6) & 14)), ComposableLambdaKt.composableLambda(startRestartGroup, 1830921872, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$5
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

                                            public final void invoke(Composer composer3, int i52) {
                                                Modifier modifier4;
                                                ComposerKt.sourceInformation(composer3, "C344@18897L38,353@19316L20,333@18397L2430:OutlinedTextField.kt#uh7d8r");
                                                if ((i52 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1830921872, i52, -1, "androidx.compose.material3.OutlinedTextField.<anonymous> (OutlinedTextField.kt:333)");
                                                    }
                                                    if (function212 != null) {
                                                        modifier4 = PaddingKt.m883paddingqDBjuR0$default(SemanticsModifierKt.semantics(modifier3, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$5.1
                                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                                invoke2(semanticsPropertyReceiver);
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), 0.0f, OutlinedTextFieldKt.getOutlinedTextFieldTopPadding(), 0.0f, 0.0f, 13, null);
                                                    } else {
                                                        modifier4 = modifier3;
                                                    }
                                                    boolean z17 = z7;
                                                    Strings.Companion companion = Strings.INSTANCE;
                                                    Modifier m912defaultMinSizeVpY3zN4 = SizeKt.m912defaultMinSizeVpY3zN4(TextFieldImplKt.defaultErrorSemantics(modifier4, z17, Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(androidx.compose.ui.R.string.default_error_message), composer3, 0)), OutlinedTextFieldDefaults.INSTANCE.m2387getMinWidthD9Ej5fM(), OutlinedTextFieldDefaults.INSTANCE.m2386getMinHeightD9Ej5fM());
                                                    SolidColor solidColor = new SolidColor(textFieldColors2.cursorColor$material3_release(z7, composer3, 0).getValue().m4073unboximpl(), null);
                                                    final TextFieldValue textFieldValue3 = textFieldValue2;
                                                    final boolean z18 = z9;
                                                    final boolean z19 = z8;
                                                    final VisualTransformation visualTransformation4 = visualTransformation2;
                                                    final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                                                    final boolean z20 = z7;
                                                    final Function2<? super Composer, ? super Integer, Unit> function229 = function212;
                                                    final Function2<? super Composer, ? super Integer, Unit> function230 = function214;
                                                    final Function2<? super Composer, ? super Integer, Unit> function231 = function211;
                                                    final Function2<? super Composer, ? super Integer, Unit> function232 = function213;
                                                    final Function2<? super Composer, ? super Integer, Unit> function233 = function215;
                                                    final Function2<? super Composer, ? super Integer, Unit> function234 = function216;
                                                    final Function2<? super Composer, ? super Integer, Unit> function235 = function210;
                                                    final TextFieldColors textFieldColors4 = textFieldColors2;
                                                    final Shape shape5 = shape3;
                                                    BasicTextFieldKt.BasicTextField(textFieldValue2, function12, m912defaultMinSizeVpY3zN4, z9, z10, merge2, keyboardOptions2, keyboardActions2, z8, i40, i41, visualTransformation2, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource4, solidColor, ComposableLambdaKt.composableLambda(composer3, -757328870, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$5.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(3);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function236, Composer composer4, Integer num) {
                                                            invoke((Function2<? super Composer, ? super Integer, Unit>) function236, composer4, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function236, Composer composer4, int i53) {
                                                            int i54;
                                                            ComposerKt.sourceInformation(composer4, "C362@19752L1051:OutlinedTextField.kt#uh7d8r");
                                                            if ((i53 & 6) == 0) {
                                                                i54 = i53 | (composer4.changedInstance(function236) ? 4 : 2);
                                                            } else {
                                                                i54 = i53;
                                                            }
                                                            if ((i54 & 19) != 18 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-757328870, i54, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous> (OutlinedTextField.kt:362)");
                                                                }
                                                                OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                                                                String text = TextFieldValue.this.getText();
                                                                boolean z21 = z18;
                                                                int i55 = i54;
                                                                boolean z22 = z19;
                                                                VisualTransformation visualTransformation5 = visualTransformation4;
                                                                MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource6;
                                                                boolean z23 = z20;
                                                                Function2<Composer, Integer, Unit> function237 = function229;
                                                                Function2<Composer, Integer, Unit> function238 = function230;
                                                                Function2<Composer, Integer, Unit> function239 = function231;
                                                                Function2<Composer, Integer, Unit> function240 = function232;
                                                                Function2<Composer, Integer, Unit> function241 = function233;
                                                                Function2<Composer, Integer, Unit> function242 = function234;
                                                                Function2<Composer, Integer, Unit> function243 = function235;
                                                                TextFieldColors textFieldColors5 = textFieldColors4;
                                                                final boolean z24 = z18;
                                                                final boolean z25 = z20;
                                                                final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource6;
                                                                final TextFieldColors textFieldColors6 = textFieldColors4;
                                                                final Shape shape6 = shape5;
                                                                outlinedTextFieldDefaults.DecorationBox(text, function236, z21, z22, visualTransformation5, mutableInteractionSource7, z23, function237, function238, function239, function240, function241, function242, function243, textFieldColors5, null, ComposableLambdaKt.composableLambda(composer4, 255570733, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt.OutlinedTextField.5.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(2);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function2
                                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer5, Integer num) {
                                                                        invoke(composer5, num.intValue());
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    public final void invoke(Composer composer5, int i56) {
                                                                        ComposerKt.sourceInformation(composer5, "C379@20533L230:OutlinedTextField.kt#uh7d8r");
                                                                        if ((i56 & 3) != 2 || !composer5.getSkipping()) {
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(255570733, i56, -1, "androidx.compose.material3.OutlinedTextField.<anonymous>.<anonymous>.<anonymous> (OutlinedTextField.kt:379)");
                                                                            }
                                                                            OutlinedTextFieldDefaults.INSTANCE.m2382ContainerBoxnbWgWpA(z24, z25, mutableInteractionSource8, textFieldColors6, shape6, 0.0f, 0.0f, composer5, 12582912, 96);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                                return;
                                                                            }
                                                                            return;
                                                                        }
                                                                        composer5.skipToGroupEnd();
                                                                    }
                                                                }), composer4, (i55 << 3) & 112, 14155776, 32768);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }), composer3, 0, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 4096);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }), startRestartGroup, ProvidedValue.$stable | 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        textStyle4 = textStyle3;
                                        composer2 = startRestartGroup;
                                        function217 = function212;
                                        z11 = z7;
                                        z12 = z9;
                                        z13 = z10;
                                        keyboardOptions3 = keyboardOptions2;
                                        keyboardActions3 = keyboardActions2;
                                        z14 = z8;
                                        i43 = i40;
                                        i44 = i41;
                                        visualTransformation3 = visualTransformation2;
                                        mutableInteractionSource5 = mutableInteractionSource4;
                                        function218 = function214;
                                        function219 = function211;
                                        function220 = function215;
                                        function221 = function210;
                                        shape4 = shape3;
                                        textFieldColors3 = textFieldColors2;
                                        function222 = function216;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        function213 = function24;
                                        function220 = function25;
                                        function221 = function27;
                                        z11 = z3;
                                        keyboardOptions3 = keyboardOptions;
                                        keyboardActions3 = keyboardActions;
                                        z14 = z4;
                                        i43 = i;
                                        i44 = i2;
                                        mutableInteractionSource5 = mutableInteractionSource;
                                        shape4 = shape;
                                        textFieldColors3 = textFieldColors;
                                        composer2 = startRestartGroup;
                                        z12 = z5;
                                        z13 = z6;
                                        textStyle4 = textStyle2;
                                        function217 = function28;
                                        function218 = function29;
                                        modifier3 = modifier2;
                                        function219 = function23;
                                        function222 = function26;
                                        visualTransformation3 = visualTransformation;
                                    }
                                    ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        final Function2<? super Composer, ? super Integer, Unit> function229 = function213;
                                        final Modifier modifier4 = modifier3;
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$6
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

                                            public final void invoke(Composer composer3, int i52) {
                                                OutlinedTextFieldKt.OutlinedTextField(TextFieldValue.this, function1, modifier4, z12, z13, textStyle4, function217, function218, function219, function229, function220, function222, function221, z11, visualTransformation3, keyboardOptions3, keyboardActions3, z14, i43, i44, mutableInteractionSource5, shape4, textFieldColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                            i28 = i6 & 32768;
                            if (i28 != 0) {
                            }
                            i29 = i6 & 65536;
                            if (i29 != 0) {
                            }
                            i30 = i6 & 131072;
                            if (i30 != 0) {
                            }
                            if ((i4 & 100663296) == 0) {
                            }
                            i31 = i6 & 524288;
                            if (i31 != 0) {
                            }
                            i32 = i6 & 1048576;
                            if (i32 != 0) {
                            }
                            if ((i5 & 48) == 0) {
                            }
                            if ((i5 & 384) == 0) {
                            }
                            int i502 = i33;
                            if ((i21 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                            }
                            if (i46 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if ((i6 & 32) != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i13 != 0) {
                            }
                            if (i15 != 0) {
                            }
                            if (i17 != 0) {
                            }
                            if (i20 != 0) {
                            }
                            if (i22 == 0) {
                            }
                            if (i24 != 0) {
                            }
                            if (i26 != 0) {
                            }
                            if (i28 != 0) {
                            }
                            if (i29 != 0) {
                            }
                            if (i30 != 0) {
                            }
                            if ((i6 & 262144) != 0) {
                            }
                            if (i31 != 0) {
                            }
                            if (i32 != 0) {
                            }
                            if ((2097152 & i6) != 0) {
                            }
                            Function2<? super Composer, ? super Integer, Unit> function2282 = function227;
                            if ((i6 & 4194304) != 0) {
                            }
                        }
                        i15 = i14;
                        i16 = i6 & 1024;
                        if (i16 == 0) {
                        }
                        i19 = i6 & 2048;
                        if (i19 == 0) {
                        }
                        int i472 = i18;
                        i21 = i7;
                        i22 = i6 & 4096;
                        if (i22 == 0) {
                        }
                        i24 = i6 & 8192;
                        if (i24 == 0) {
                        }
                        i26 = i6 & 16384;
                        if (i26 == 0) {
                        }
                        i28 = i6 & 32768;
                        if (i28 != 0) {
                        }
                        i29 = i6 & 65536;
                        if (i29 != 0) {
                        }
                        i30 = i6 & 131072;
                        if (i30 != 0) {
                        }
                        if ((i4 & 100663296) == 0) {
                        }
                        i31 = i6 & 524288;
                        if (i31 != 0) {
                        }
                        i32 = i6 & 1048576;
                        if (i32 != 0) {
                        }
                        if ((i5 & 48) == 0) {
                        }
                        if ((i5 & 384) == 0) {
                        }
                        int i5022 = i33;
                        if ((i21 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i46 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if ((i6 & 32) != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        if (i15 != 0) {
                        }
                        if (i17 != 0) {
                        }
                        if (i20 != 0) {
                        }
                        if (i22 == 0) {
                        }
                        if (i24 != 0) {
                        }
                        if (i26 != 0) {
                        }
                        if (i28 != 0) {
                        }
                        if (i29 != 0) {
                        }
                        if (i30 != 0) {
                        }
                        if ((i6 & 262144) != 0) {
                        }
                        if (i31 != 0) {
                        }
                        if (i32 != 0) {
                        }
                        if ((2097152 & i6) != 0) {
                        }
                        Function2<? super Composer, ? super Integer, Unit> function22822 = function227;
                        if ((i6 & 4194304) != 0) {
                        }
                    }
                    i13 = i12;
                    i14 = i6 & 512;
                    if (i14 != 0) {
                    }
                    i15 = i14;
                    i16 = i6 & 1024;
                    if (i16 == 0) {
                    }
                    i19 = i6 & 2048;
                    if (i19 == 0) {
                    }
                    int i4722 = i18;
                    i21 = i7;
                    i22 = i6 & 4096;
                    if (i22 == 0) {
                    }
                    i24 = i6 & 8192;
                    if (i24 == 0) {
                    }
                    i26 = i6 & 16384;
                    if (i26 == 0) {
                    }
                    i28 = i6 & 32768;
                    if (i28 != 0) {
                    }
                    i29 = i6 & 65536;
                    if (i29 != 0) {
                    }
                    i30 = i6 & 131072;
                    if (i30 != 0) {
                    }
                    if ((i4 & 100663296) == 0) {
                    }
                    i31 = i6 & 524288;
                    if (i31 != 0) {
                    }
                    i32 = i6 & 1048576;
                    if (i32 != 0) {
                    }
                    if ((i5 & 48) == 0) {
                    }
                    if ((i5 & 384) == 0) {
                    }
                    int i50222 = i33;
                    if ((i21 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i46 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i6 & 32) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    if (i22 == 0) {
                    }
                    if (i24 != 0) {
                    }
                    if (i26 != 0) {
                    }
                    if (i28 != 0) {
                    }
                    if (i29 != 0) {
                    }
                    if (i30 != 0) {
                    }
                    if ((i6 & 262144) != 0) {
                    }
                    if (i31 != 0) {
                    }
                    if (i32 != 0) {
                    }
                    if ((2097152 & i6) != 0) {
                    }
                    Function2<? super Composer, ? super Integer, Unit> function228222 = function227;
                    if ((i6 & 4194304) != 0) {
                    }
                }
                z6 = z2;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                }
                i10 = i6 & 64;
                if (i10 == 0) {
                }
                i11 = i6 & 128;
                if (i11 == 0) {
                }
                i12 = i6 & 256;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i6 & 512;
                if (i14 != 0) {
                }
                i15 = i14;
                i16 = i6 & 1024;
                if (i16 == 0) {
                }
                i19 = i6 & 2048;
                if (i19 == 0) {
                }
                int i47222 = i18;
                i21 = i7;
                i22 = i6 & 4096;
                if (i22 == 0) {
                }
                i24 = i6 & 8192;
                if (i24 == 0) {
                }
                i26 = i6 & 16384;
                if (i26 == 0) {
                }
                i28 = i6 & 32768;
                if (i28 != 0) {
                }
                i29 = i6 & 65536;
                if (i29 != 0) {
                }
                i30 = i6 & 131072;
                if (i30 != 0) {
                }
                if ((i4 & 100663296) == 0) {
                }
                i31 = i6 & 524288;
                if (i31 != 0) {
                }
                i32 = i6 & 1048576;
                if (i32 != 0) {
                }
                if ((i5 & 48) == 0) {
                }
                if ((i5 & 384) == 0) {
                }
                int i502222 = i33;
                if ((i21 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i46 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if ((i6 & 32) != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i13 != 0) {
                }
                if (i15 != 0) {
                }
                if (i17 != 0) {
                }
                if (i20 != 0) {
                }
                if (i22 == 0) {
                }
                if (i24 != 0) {
                }
                if (i26 != 0) {
                }
                if (i28 != 0) {
                }
                if (i29 != 0) {
                }
                if (i30 != 0) {
                }
                if ((i6 & 262144) != 0) {
                }
                if (i31 != 0) {
                }
                if (i32 != 0) {
                }
                if ((2097152 & i6) != 0) {
                }
                Function2<? super Composer, ? super Integer, Unit> function2282222 = function227;
                if ((i6 & 4194304) != 0) {
                }
            }
            z5 = z;
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            z6 = z2;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            }
            i10 = i6 & 64;
            if (i10 == 0) {
            }
            i11 = i6 & 128;
            if (i11 == 0) {
            }
            i12 = i6 & 256;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i6 & 512;
            if (i14 != 0) {
            }
            i15 = i14;
            i16 = i6 & 1024;
            if (i16 == 0) {
            }
            i19 = i6 & 2048;
            if (i19 == 0) {
            }
            int i472222 = i18;
            i21 = i7;
            i22 = i6 & 4096;
            if (i22 == 0) {
            }
            i24 = i6 & 8192;
            if (i24 == 0) {
            }
            i26 = i6 & 16384;
            if (i26 == 0) {
            }
            i28 = i6 & 32768;
            if (i28 != 0) {
            }
            i29 = i6 & 65536;
            if (i29 != 0) {
            }
            i30 = i6 & 131072;
            if (i30 != 0) {
            }
            if ((i4 & 100663296) == 0) {
            }
            i31 = i6 & 524288;
            if (i31 != 0) {
            }
            i32 = i6 & 1048576;
            if (i32 != 0) {
            }
            if ((i5 & 48) == 0) {
            }
            if ((i5 & 384) == 0) {
            }
            int i5022222 = i33;
            if ((i21 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i46 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i13 != 0) {
            }
            if (i15 != 0) {
            }
            if (i17 != 0) {
            }
            if (i20 != 0) {
            }
            if (i22 == 0) {
            }
            if (i24 != 0) {
            }
            if (i26 != 0) {
            }
            if (i28 != 0) {
            }
            if (i29 != 0) {
            }
            if (i30 != 0) {
            }
            if ((i6 & 262144) != 0) {
            }
            if (i31 != 0) {
            }
            if (i32 != 0) {
            }
            if ((2097152 & i6) != 0) {
            }
            Function2<? super Composer, ? super Integer, Unit> function22822222 = function227;
            if ((i6 & 4194304) != 0) {
            }
        }
        modifier2 = modifier;
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z5 = z;
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        z6 = z2;
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
        }
        i10 = i6 & 64;
        if (i10 == 0) {
        }
        i11 = i6 & 128;
        if (i11 == 0) {
        }
        i12 = i6 & 256;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i6 & 512;
        if (i14 != 0) {
        }
        i15 = i14;
        i16 = i6 & 1024;
        if (i16 == 0) {
        }
        i19 = i6 & 2048;
        if (i19 == 0) {
        }
        int i4722222 = i18;
        i21 = i7;
        i22 = i6 & 4096;
        if (i22 == 0) {
        }
        i24 = i6 & 8192;
        if (i24 == 0) {
        }
        i26 = i6 & 16384;
        if (i26 == 0) {
        }
        i28 = i6 & 32768;
        if (i28 != 0) {
        }
        i29 = i6 & 65536;
        if (i29 != 0) {
        }
        i30 = i6 & 131072;
        if (i30 != 0) {
        }
        if ((i4 & 100663296) == 0) {
        }
        i31 = i6 & 524288;
        if (i31 != 0) {
        }
        i32 = i6 & 1048576;
        if (i32 != 0) {
        }
        if ((i5 & 48) == 0) {
        }
        if ((i5 & 384) == 0) {
        }
        int i50222222 = i33;
        if ((i21 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i46 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i13 != 0) {
        }
        if (i15 != 0) {
        }
        if (i17 != 0) {
        }
        if (i20 != 0) {
        }
        if (i22 == 0) {
        }
        if (i24 != 0) {
        }
        if (i26 != 0) {
        }
        if (i28 != 0) {
        }
        if (i29 != 0) {
        }
        if (i30 != 0) {
        }
        if ((i6 & 262144) != 0) {
        }
        if (i31 != 0) {
        }
        if (i32 != 0) {
        }
        if ((2097152 & i6) != 0) {
        }
        Function2<? super Composer, ? super Integer, Unit> function228222222 = function227;
        if ((i6 & 4194304) != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02b9  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void OutlinedTextField(final String str, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        Modifier modifier2;
        int i9;
        boolean z5;
        int i10;
        boolean z6;
        TextStyle textStyle2;
        int i11;
        Function2 function26;
        int i12;
        Function2 function27;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        int i34;
        Shape shape2;
        MutableInteractionSource mutableInteractionSource4;
        Shape shape3;
        TextFieldColors textFieldColors2;
        int i35;
        boolean z7;
        TextStyle textStyle3;
        Function2 function28;
        Function2 function29;
        Function2 function210;
        int i36;
        boolean z8;
        boolean z9;
        VisualTransformation visualTransformation2;
        int i37;
        int i38;
        KeyboardActions keyboardActions2;
        boolean z10;
        KeyboardOptions keyboardOptions2;
        Function2 function211;
        Function2 function212;
        Modifier modifier3;
        Composer composer2;
        final Modifier modifier4;
        final boolean z11;
        final boolean z12;
        final TextStyle textStyle4;
        final Function2 function213;
        final Function2 function214;
        final Function2 function215;
        final Function2 function216;
        final Function2 function217;
        final boolean z13;
        final VisualTransformation visualTransformation3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean z14;
        final int i39;
        final int i40;
        final MutableInteractionSource mutableInteractionSource5;
        final Shape shape4;
        final TextFieldColors textFieldColors3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1575225237);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedTextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)402@21186L7,415@21846L39,416@21932L5,417@21995L8,419@22012L771:OutlinedTextField.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i7 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i7 = i3;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i3 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i3 & 384) == 0) {
                modifier2 = modifier;
                i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i3 & 3072) == 0) {
                    z5 = z;
                    i7 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else if ((i3 & 24576) == 0) {
                        z6 = z2;
                        i7 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            textStyle2 = textStyle;
                            i7 |= ((i6 & 32) == 0 && startRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                        } else {
                            textStyle2 = textStyle;
                        }
                        i11 = i6 & 64;
                        if (i11 != 0) {
                            i7 |= 1572864;
                            function26 = function2;
                        } else {
                            function26 = function2;
                            if ((i3 & 1572864) == 0) {
                                i7 |= startRestartGroup.changedInstance(function26) ? 1048576 : 524288;
                            }
                        }
                        i12 = i6 & 128;
                        if (i12 != 0) {
                            i7 |= 12582912;
                            function27 = function22;
                        } else {
                            function27 = function22;
                            if ((i3 & 12582912) == 0) {
                                i7 |= startRestartGroup.changedInstance(function27) ? 8388608 : 4194304;
                            }
                        }
                        i13 = i6 & 256;
                        if (i13 != 0) {
                            i7 |= 100663296;
                        } else if ((i3 & 100663296) == 0) {
                            i14 = i13;
                            i7 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                            i15 = i6 & 512;
                            if (i15 == 0) {
                                i7 |= C.ENCODING_PCM_32BIT;
                            } else if ((i3 & C.ENCODING_PCM_32BIT) == 0) {
                                i16 = i15;
                                i7 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                                i17 = i6 & 1024;
                                if (i17 != 0) {
                                    i19 = i4 | 6;
                                    i18 = i17;
                                } else if ((i4 & 6) == 0) {
                                    i18 = i17;
                                    i19 = i4 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                                } else {
                                    i18 = i17;
                                    i19 = i4;
                                }
                                i20 = i6 & 2048;
                                if (i20 != 0) {
                                    i19 |= 48;
                                    i21 = i20;
                                } else if ((i4 & 48) == 0) {
                                    i21 = i20;
                                    i19 |= startRestartGroup.changed(z3) ? 32 : 16;
                                } else {
                                    i21 = i20;
                                }
                                int i41 = i19;
                                i22 = i6 & 4096;
                                if (i22 != 0) {
                                    i23 = i41 | 384;
                                } else {
                                    int i42 = i41;
                                    if ((i4 & 384) == 0) {
                                        i42 |= startRestartGroup.changed(visualTransformation) ? 256 : 128;
                                    }
                                    i23 = i42;
                                }
                                i24 = i6 & 8192;
                                if (i24 != 0) {
                                    i25 = i23 | 3072;
                                } else {
                                    int i43 = i23;
                                    if ((i4 & 3072) == 0) {
                                        i25 = i43 | (startRestartGroup.changed(keyboardOptions) ? 2048 : 1024);
                                    } else {
                                        i25 = i43;
                                    }
                                }
                                i26 = i6 & 16384;
                                if (i26 != 0) {
                                    i27 = i25 | 24576;
                                } else {
                                    i27 = i25;
                                    if ((i4 & 24576) == 0) {
                                        i27 |= startRestartGroup.changed(keyboardActions) ? 16384 : 8192;
                                        i28 = i6 & 32768;
                                        if (i28 == 0) {
                                            i27 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                            i27 |= startRestartGroup.changed(z4) ? 131072 : 65536;
                                        }
                                        if ((i4 & 1572864) == 0) {
                                            i27 |= ((i6 & 65536) == 0 && startRestartGroup.changed(i)) ? 1048576 : 524288;
                                        }
                                        i29 = i6 & 131072;
                                        if (i29 == 0) {
                                            i27 |= 12582912;
                                        } else if ((i4 & 12582912) == 0) {
                                            i27 |= startRestartGroup.changed(i2) ? 8388608 : 4194304;
                                        }
                                        i30 = i6 & 262144;
                                        if (i30 == 0) {
                                            i27 |= 100663296;
                                        } else if ((i4 & 100663296) == 0) {
                                            i27 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                                        }
                                        if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                                            i27 |= ((i6 & 524288) == 0 && startRestartGroup.changed(shape)) ? 536870912 : 268435456;
                                        }
                                        if ((i5 & 6) != 0) {
                                            i31 = i5 | (((i6 & 1048576) == 0 && startRestartGroup.changed(textFieldColors)) ? 4 : 2);
                                        } else {
                                            i31 = i5;
                                        }
                                        if ((i7 & 306783379) == 306783378 || (i27 & 306783379) != 306783378 || (i31 & 3) != 2 || !startRestartGroup.getSkipping()) {
                                            startRestartGroup.startDefaults();
                                            if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                                if (i8 != 0) {
                                                    modifier2 = Modifier.INSTANCE;
                                                }
                                                if (i9 != 0) {
                                                    z5 = true;
                                                }
                                                if (i10 != 0) {
                                                    z6 = false;
                                                }
                                                if ((i6 & 32) != 0) {
                                                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                    Object consume = startRestartGroup.consume(localTextStyle);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    textStyle2 = (TextStyle) consume;
                                                    i7 &= -458753;
                                                }
                                                if (i11 != 0) {
                                                    function26 = null;
                                                }
                                                if (i12 != 0) {
                                                    function27 = null;
                                                }
                                                Function2 function218 = i14 == 0 ? null : function23;
                                                Function2 function219 = i16 == 0 ? null : function24;
                                                Function2 function220 = i18 == 0 ? function25 : null;
                                                boolean z15 = i21 == 0 ? false : z3;
                                                VisualTransformation none = i22 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                                KeyboardOptions keyboardOptions4 = i24 == 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                                KeyboardActions keyboardActions4 = i26 == 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                                boolean z16 = i28 == 0 ? false : z4;
                                                if ((i6 & 65536) == 0) {
                                                    i32 = z16 ? 1 : Integer.MAX_VALUE;
                                                    i27 &= -3670017;
                                                } else {
                                                    i32 = i;
                                                }
                                                int i44 = i29 == 0 ? i2 : 1;
                                                if (i30 == 0) {
                                                    startRestartGroup.startReplaceableGroup(1663548494);
                                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):OutlinedTextField.kt#9igjgp");
                                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                                    i33 = i44;
                                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                                    }
                                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                                    startRestartGroup.endReplaceableGroup();
                                                } else {
                                                    i33 = i44;
                                                    mutableInteractionSource2 = mutableInteractionSource;
                                                }
                                                if ((i6 & 524288) == 0) {
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                    i34 = 6;
                                                    shape2 = OutlinedTextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                                    i27 &= -1879048193;
                                                } else {
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                    i34 = 6;
                                                    shape2 = shape;
                                                }
                                                Shape shape5 = shape2;
                                                if ((i6 & 1048576) == 0) {
                                                    i31 &= -15;
                                                    mutableInteractionSource4 = mutableInteractionSource3;
                                                    shape3 = shape5;
                                                    textFieldColors2 = OutlinedTextFieldDefaults.INSTANCE.colors(startRestartGroup, i34);
                                                } else {
                                                    mutableInteractionSource4 = mutableInteractionSource3;
                                                    shape3 = shape5;
                                                    textFieldColors2 = textFieldColors;
                                                }
                                                i35 = i7;
                                                z7 = z6;
                                                textStyle3 = textStyle2;
                                                function28 = function26;
                                                function29 = function218;
                                                function210 = function219;
                                                i36 = i27;
                                                z8 = z15;
                                                z9 = z16;
                                                visualTransformation2 = none;
                                                i37 = i32;
                                                i38 = i33;
                                                keyboardActions2 = keyboardActions4;
                                                z10 = z5;
                                                keyboardOptions2 = keyboardOptions4;
                                                function211 = function220;
                                                function212 = function27;
                                                modifier3 = modifier2;
                                            } else {
                                                startRestartGroup.skipToGroupEnd();
                                                if ((i6 & 32) != 0) {
                                                    i7 &= -458753;
                                                }
                                                if ((i6 & 65536) != 0) {
                                                    i27 &= -3670017;
                                                }
                                                if ((i6 & 524288) != 0) {
                                                    i27 &= -1879048193;
                                                }
                                                if ((i6 & 1048576) != 0) {
                                                    i31 &= -15;
                                                }
                                                function210 = function24;
                                                function211 = function25;
                                                visualTransformation2 = visualTransformation;
                                                keyboardOptions2 = keyboardOptions;
                                                keyboardActions2 = keyboardActions;
                                                z9 = z4;
                                                i37 = i;
                                                i38 = i2;
                                                mutableInteractionSource4 = mutableInteractionSource;
                                                shape3 = shape;
                                                textFieldColors2 = textFieldColors;
                                                function212 = function27;
                                                i35 = i7;
                                                z7 = z6;
                                                textStyle3 = textStyle2;
                                                function28 = function26;
                                                modifier3 = modifier2;
                                                i36 = i27;
                                                function29 = function23;
                                                z8 = z3;
                                                z10 = z5;
                                            }
                                            startRestartGroup.endDefaults();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1575225237, i35, i36, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:418)");
                                            }
                                            int i45 = i35 & 2147483646;
                                            int i46 = i36 << 6;
                                            int i47 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                                            composer2 = startRestartGroup;
                                            OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i45, (i46 & 896) | 54 | (i46 & 7168) | (57344 & i46) | (458752 & i46) | (3670016 & i46) | (29360128 & i46) | (234881024 & i46) | (i46 & 1879048192), i47, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            modifier4 = modifier3;
                                            z11 = z10;
                                            z12 = z7;
                                            textStyle4 = textStyle3;
                                            function213 = function28;
                                            function214 = function212;
                                            function215 = function29;
                                            function216 = function210;
                                            function217 = function211;
                                            z13 = z8;
                                            visualTransformation3 = visualTransformation2;
                                            keyboardOptions3 = keyboardOptions2;
                                            keyboardActions3 = keyboardActions2;
                                            z14 = z9;
                                            i39 = i37;
                                            i40 = i38;
                                            mutableInteractionSource5 = mutableInteractionSource4;
                                            shape4 = shape3;
                                            textFieldColors3 = textFieldColors2;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            function217 = function25;
                                            visualTransformation3 = visualTransformation;
                                            keyboardActions3 = keyboardActions;
                                            z14 = z4;
                                            i39 = i;
                                            i40 = i2;
                                            mutableInteractionSource5 = mutableInteractionSource;
                                            shape4 = shape;
                                            textFieldColors3 = textFieldColors;
                                            composer2 = startRestartGroup;
                                            z11 = z5;
                                            function214 = function27;
                                            z12 = z6;
                                            textStyle4 = textStyle2;
                                            function213 = function26;
                                            modifier4 = modifier2;
                                            function215 = function23;
                                            function216 = function24;
                                            z13 = z3;
                                            keyboardOptions3 = keyboardOptions;
                                        }
                                        endRestartGroup = composer2.endRestartGroup();
                                        if (endRestartGroup == null) {
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$8
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

                                                public final void invoke(Composer composer3, int i48) {
                                                    OutlinedTextFieldKt.OutlinedTextField(str, function1, modifier4, z11, z12, textStyle4, function213, function214, function215, function216, function217, z13, visualTransformation3, keyboardOptions3, keyboardActions3, z14, i39, i40, mutableInteractionSource5, shape4, textFieldColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i28 = i6 & 32768;
                                if (i28 == 0) {
                                }
                                if ((i4 & 1572864) == 0) {
                                }
                                i29 = i6 & 131072;
                                if (i29 == 0) {
                                }
                                i30 = i6 & 262144;
                                if (i30 == 0) {
                                }
                                if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                                }
                                if ((i5 & 6) != 0) {
                                }
                                if ((i7 & 306783379) == 306783378) {
                                }
                                startRestartGroup.startDefaults();
                                if ((i3 & 1) != 0) {
                                }
                                if (i8 != 0) {
                                }
                                if (i9 != 0) {
                                }
                                if (i10 != 0) {
                                }
                                if ((i6 & 32) != 0) {
                                }
                                if (i11 != 0) {
                                }
                                if (i12 != 0) {
                                }
                                if (i14 == 0) {
                                }
                                if (i16 == 0) {
                                }
                                if (i18 == 0) {
                                }
                                if (i21 == 0) {
                                }
                                if (i22 == 0) {
                                }
                                if (i24 == 0) {
                                }
                                if (i26 == 0) {
                                }
                                if (i28 == 0) {
                                }
                                if ((i6 & 65536) == 0) {
                                }
                                if (i29 == 0) {
                                }
                                if (i30 == 0) {
                                }
                                if ((i6 & 524288) == 0) {
                                }
                                Shape shape52 = shape2;
                                if ((i6 & 1048576) == 0) {
                                }
                                i35 = i7;
                                z7 = z6;
                                textStyle3 = textStyle2;
                                function28 = function26;
                                function29 = function218;
                                function210 = function219;
                                i36 = i27;
                                z8 = z15;
                                z9 = z16;
                                visualTransformation2 = none;
                                i37 = i32;
                                i38 = i33;
                                keyboardActions2 = keyboardActions4;
                                z10 = z5;
                                keyboardOptions2 = keyboardOptions4;
                                function211 = function220;
                                function212 = function27;
                                modifier3 = modifier2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i452 = i35 & 2147483646;
                                int i462 = i36 << 6;
                                int i472 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                                composer2 = startRestartGroup;
                                OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i452, (i462 & 896) | 54 | (i462 & 7168) | (57344 & i462) | (458752 & i462) | (3670016 & i462) | (29360128 & i462) | (234881024 & i462) | (i462 & 1879048192), i472, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier4 = modifier3;
                                z11 = z10;
                                z12 = z7;
                                textStyle4 = textStyle3;
                                function213 = function28;
                                function214 = function212;
                                function215 = function29;
                                function216 = function210;
                                function217 = function211;
                                z13 = z8;
                                visualTransformation3 = visualTransformation2;
                                keyboardOptions3 = keyboardOptions2;
                                keyboardActions3 = keyboardActions2;
                                z14 = z9;
                                i39 = i37;
                                i40 = i38;
                                mutableInteractionSource5 = mutableInteractionSource4;
                                shape4 = shape3;
                                textFieldColors3 = textFieldColors2;
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i16 = i15;
                            i17 = i6 & 1024;
                            if (i17 != 0) {
                            }
                            i20 = i6 & 2048;
                            if (i20 != 0) {
                            }
                            int i412 = i19;
                            i22 = i6 & 4096;
                            if (i22 != 0) {
                            }
                            i24 = i6 & 8192;
                            if (i24 != 0) {
                            }
                            i26 = i6 & 16384;
                            if (i26 != 0) {
                            }
                            i28 = i6 & 32768;
                            if (i28 == 0) {
                            }
                            if ((i4 & 1572864) == 0) {
                            }
                            i29 = i6 & 131072;
                            if (i29 == 0) {
                            }
                            i30 = i6 & 262144;
                            if (i30 == 0) {
                            }
                            if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                            }
                            if ((i5 & 6) != 0) {
                            }
                            if ((i7 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if ((i6 & 32) != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i12 != 0) {
                            }
                            if (i14 == 0) {
                            }
                            if (i16 == 0) {
                            }
                            if (i18 == 0) {
                            }
                            if (i21 == 0) {
                            }
                            if (i22 == 0) {
                            }
                            if (i24 == 0) {
                            }
                            if (i26 == 0) {
                            }
                            if (i28 == 0) {
                            }
                            if ((i6 & 65536) == 0) {
                            }
                            if (i29 == 0) {
                            }
                            if (i30 == 0) {
                            }
                            if ((i6 & 524288) == 0) {
                            }
                            Shape shape522 = shape2;
                            if ((i6 & 1048576) == 0) {
                            }
                            i35 = i7;
                            z7 = z6;
                            textStyle3 = textStyle2;
                            function28 = function26;
                            function29 = function218;
                            function210 = function219;
                            i36 = i27;
                            z8 = z15;
                            z9 = z16;
                            visualTransformation2 = none;
                            i37 = i32;
                            i38 = i33;
                            keyboardActions2 = keyboardActions4;
                            z10 = z5;
                            keyboardOptions2 = keyboardOptions4;
                            function211 = function220;
                            function212 = function27;
                            modifier3 = modifier2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i4522 = i35 & 2147483646;
                            int i4622 = i36 << 6;
                            int i4722 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                            composer2 = startRestartGroup;
                            OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i4522, (i4622 & 896) | 54 | (i4622 & 7168) | (57344 & i4622) | (458752 & i4622) | (3670016 & i4622) | (29360128 & i4622) | (234881024 & i4622) | (i4622 & 1879048192), i4722, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier3;
                            z11 = z10;
                            z12 = z7;
                            textStyle4 = textStyle3;
                            function213 = function28;
                            function214 = function212;
                            function215 = function29;
                            function216 = function210;
                            function217 = function211;
                            z13 = z8;
                            visualTransformation3 = visualTransformation2;
                            keyboardOptions3 = keyboardOptions2;
                            keyboardActions3 = keyboardActions2;
                            z14 = z9;
                            i39 = i37;
                            i40 = i38;
                            mutableInteractionSource5 = mutableInteractionSource4;
                            shape4 = shape3;
                            textFieldColors3 = textFieldColors2;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i14 = i13;
                        i15 = i6 & 512;
                        if (i15 == 0) {
                        }
                        i16 = i15;
                        i17 = i6 & 1024;
                        if (i17 != 0) {
                        }
                        i20 = i6 & 2048;
                        if (i20 != 0) {
                        }
                        int i4122 = i19;
                        i22 = i6 & 4096;
                        if (i22 != 0) {
                        }
                        i24 = i6 & 8192;
                        if (i24 != 0) {
                        }
                        i26 = i6 & 16384;
                        if (i26 != 0) {
                        }
                        i28 = i6 & 32768;
                        if (i28 == 0) {
                        }
                        if ((i4 & 1572864) == 0) {
                        }
                        i29 = i6 & 131072;
                        if (i29 == 0) {
                        }
                        i30 = i6 & 262144;
                        if (i30 == 0) {
                        }
                        if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                        }
                        if ((i5 & 6) != 0) {
                        }
                        if ((i7 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if ((i6 & 32) != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i16 == 0) {
                        }
                        if (i18 == 0) {
                        }
                        if (i21 == 0) {
                        }
                        if (i22 == 0) {
                        }
                        if (i24 == 0) {
                        }
                        if (i26 == 0) {
                        }
                        if (i28 == 0) {
                        }
                        if ((i6 & 65536) == 0) {
                        }
                        if (i29 == 0) {
                        }
                        if (i30 == 0) {
                        }
                        if ((i6 & 524288) == 0) {
                        }
                        Shape shape5222 = shape2;
                        if ((i6 & 1048576) == 0) {
                        }
                        i35 = i7;
                        z7 = z6;
                        textStyle3 = textStyle2;
                        function28 = function26;
                        function29 = function218;
                        function210 = function219;
                        i36 = i27;
                        z8 = z15;
                        z9 = z16;
                        visualTransformation2 = none;
                        i37 = i32;
                        i38 = i33;
                        keyboardActions2 = keyboardActions4;
                        z10 = z5;
                        keyboardOptions2 = keyboardOptions4;
                        function211 = function220;
                        function212 = function27;
                        modifier3 = modifier2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i45222 = i35 & 2147483646;
                        int i46222 = i36 << 6;
                        int i47222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                        composer2 = startRestartGroup;
                        OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i45222, (i46222 & 896) | 54 | (i46222 & 7168) | (57344 & i46222) | (458752 & i46222) | (3670016 & i46222) | (29360128 & i46222) | (234881024 & i46222) | (i46222 & 1879048192), i47222, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        z11 = z10;
                        z12 = z7;
                        textStyle4 = textStyle3;
                        function213 = function28;
                        function214 = function212;
                        function215 = function29;
                        function216 = function210;
                        function217 = function211;
                        z13 = z8;
                        visualTransformation3 = visualTransformation2;
                        keyboardOptions3 = keyboardOptions2;
                        keyboardActions3 = keyboardActions2;
                        z14 = z9;
                        i39 = i37;
                        i40 = i38;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        shape4 = shape3;
                        textFieldColors3 = textFieldColors2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    z6 = z2;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    i11 = i6 & 64;
                    if (i11 != 0) {
                    }
                    i12 = i6 & 128;
                    if (i12 != 0) {
                    }
                    i13 = i6 & 256;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    i15 = i6 & 512;
                    if (i15 == 0) {
                    }
                    i16 = i15;
                    i17 = i6 & 1024;
                    if (i17 != 0) {
                    }
                    i20 = i6 & 2048;
                    if (i20 != 0) {
                    }
                    int i41222 = i19;
                    i22 = i6 & 4096;
                    if (i22 != 0) {
                    }
                    i24 = i6 & 8192;
                    if (i24 != 0) {
                    }
                    i26 = i6 & 16384;
                    if (i26 != 0) {
                    }
                    i28 = i6 & 32768;
                    if (i28 == 0) {
                    }
                    if ((i4 & 1572864) == 0) {
                    }
                    i29 = i6 & 131072;
                    if (i29 == 0) {
                    }
                    i30 = i6 & 262144;
                    if (i30 == 0) {
                    }
                    if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                    }
                    if ((i5 & 6) != 0) {
                    }
                    if ((i7 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i6 & 32) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (i21 == 0) {
                    }
                    if (i22 == 0) {
                    }
                    if (i24 == 0) {
                    }
                    if (i26 == 0) {
                    }
                    if (i28 == 0) {
                    }
                    if ((i6 & 65536) == 0) {
                    }
                    if (i29 == 0) {
                    }
                    if (i30 == 0) {
                    }
                    if ((i6 & 524288) == 0) {
                    }
                    Shape shape52222 = shape2;
                    if ((i6 & 1048576) == 0) {
                    }
                    i35 = i7;
                    z7 = z6;
                    textStyle3 = textStyle2;
                    function28 = function26;
                    function29 = function218;
                    function210 = function219;
                    i36 = i27;
                    z8 = z15;
                    z9 = z16;
                    visualTransformation2 = none;
                    i37 = i32;
                    i38 = i33;
                    keyboardActions2 = keyboardActions4;
                    z10 = z5;
                    keyboardOptions2 = keyboardOptions4;
                    function211 = function220;
                    function212 = function27;
                    modifier3 = modifier2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i452222 = i35 & 2147483646;
                    int i462222 = i36 << 6;
                    int i472222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                    composer2 = startRestartGroup;
                    OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i452222, (i462222 & 896) | 54 | (i462222 & 7168) | (57344 & i462222) | (458752 & i462222) | (3670016 & i462222) | (29360128 & i462222) | (234881024 & i462222) | (i462222 & 1879048192), i472222, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    z11 = z10;
                    z12 = z7;
                    textStyle4 = textStyle3;
                    function213 = function28;
                    function214 = function212;
                    function215 = function29;
                    function216 = function210;
                    function217 = function211;
                    z13 = z8;
                    visualTransformation3 = visualTransformation2;
                    keyboardOptions3 = keyboardOptions2;
                    keyboardActions3 = keyboardActions2;
                    z14 = z9;
                    i39 = i37;
                    i40 = i38;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    shape4 = shape3;
                    textFieldColors3 = textFieldColors2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z5 = z;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                z6 = z2;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                i11 = i6 & 64;
                if (i11 != 0) {
                }
                i12 = i6 & 128;
                if (i12 != 0) {
                }
                i13 = i6 & 256;
                if (i13 != 0) {
                }
                i14 = i13;
                i15 = i6 & 512;
                if (i15 == 0) {
                }
                i16 = i15;
                i17 = i6 & 1024;
                if (i17 != 0) {
                }
                i20 = i6 & 2048;
                if (i20 != 0) {
                }
                int i412222 = i19;
                i22 = i6 & 4096;
                if (i22 != 0) {
                }
                i24 = i6 & 8192;
                if (i24 != 0) {
                }
                i26 = i6 & 16384;
                if (i26 != 0) {
                }
                i28 = i6 & 32768;
                if (i28 == 0) {
                }
                if ((i4 & 1572864) == 0) {
                }
                i29 = i6 & 131072;
                if (i29 == 0) {
                }
                i30 = i6 & 262144;
                if (i30 == 0) {
                }
                if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                }
                if ((i5 & 6) != 0) {
                }
                if ((i7 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if ((i6 & 32) != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i14 == 0) {
                }
                if (i16 == 0) {
                }
                if (i18 == 0) {
                }
                if (i21 == 0) {
                }
                if (i22 == 0) {
                }
                if (i24 == 0) {
                }
                if (i26 == 0) {
                }
                if (i28 == 0) {
                }
                if ((i6 & 65536) == 0) {
                }
                if (i29 == 0) {
                }
                if (i30 == 0) {
                }
                if ((i6 & 524288) == 0) {
                }
                Shape shape522222 = shape2;
                if ((i6 & 1048576) == 0) {
                }
                i35 = i7;
                z7 = z6;
                textStyle3 = textStyle2;
                function28 = function26;
                function29 = function218;
                function210 = function219;
                i36 = i27;
                z8 = z15;
                z9 = z16;
                visualTransformation2 = none;
                i37 = i32;
                i38 = i33;
                keyboardActions2 = keyboardActions4;
                z10 = z5;
                keyboardOptions2 = keyboardOptions4;
                function211 = function220;
                function212 = function27;
                modifier3 = modifier2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i4522222 = i35 & 2147483646;
                int i4622222 = i36 << 6;
                int i4722222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                composer2 = startRestartGroup;
                OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i4522222, (i4622222 & 896) | 54 | (i4622222 & 7168) | (57344 & i4622222) | (458752 & i4622222) | (3670016 & i4622222) | (29360128 & i4622222) | (234881024 & i4622222) | (i4622222 & 1879048192), i4722222, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                z11 = z10;
                z12 = z7;
                textStyle4 = textStyle3;
                function213 = function28;
                function214 = function212;
                function215 = function29;
                function216 = function210;
                function217 = function211;
                z13 = z8;
                visualTransformation3 = visualTransformation2;
                keyboardOptions3 = keyboardOptions2;
                keyboardActions3 = keyboardActions2;
                z14 = z9;
                i39 = i37;
                i40 = i38;
                mutableInteractionSource5 = mutableInteractionSource4;
                shape4 = shape3;
                textFieldColors3 = textFieldColors2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            z5 = z;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            z6 = z2;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            i11 = i6 & 64;
            if (i11 != 0) {
            }
            i12 = i6 & 128;
            if (i12 != 0) {
            }
            i13 = i6 & 256;
            if (i13 != 0) {
            }
            i14 = i13;
            i15 = i6 & 512;
            if (i15 == 0) {
            }
            i16 = i15;
            i17 = i6 & 1024;
            if (i17 != 0) {
            }
            i20 = i6 & 2048;
            if (i20 != 0) {
            }
            int i4122222 = i19;
            i22 = i6 & 4096;
            if (i22 != 0) {
            }
            i24 = i6 & 8192;
            if (i24 != 0) {
            }
            i26 = i6 & 16384;
            if (i26 != 0) {
            }
            i28 = i6 & 32768;
            if (i28 == 0) {
            }
            if ((i4 & 1572864) == 0) {
            }
            i29 = i6 & 131072;
            if (i29 == 0) {
            }
            i30 = i6 & 262144;
            if (i30 == 0) {
            }
            if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
            }
            if ((i5 & 6) != 0) {
            }
            if ((i7 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i14 == 0) {
            }
            if (i16 == 0) {
            }
            if (i18 == 0) {
            }
            if (i21 == 0) {
            }
            if (i22 == 0) {
            }
            if (i24 == 0) {
            }
            if (i26 == 0) {
            }
            if (i28 == 0) {
            }
            if ((i6 & 65536) == 0) {
            }
            if (i29 == 0) {
            }
            if (i30 == 0) {
            }
            if ((i6 & 524288) == 0) {
            }
            Shape shape5222222 = shape2;
            if ((i6 & 1048576) == 0) {
            }
            i35 = i7;
            z7 = z6;
            textStyle3 = textStyle2;
            function28 = function26;
            function29 = function218;
            function210 = function219;
            i36 = i27;
            z8 = z15;
            z9 = z16;
            visualTransformation2 = none;
            i37 = i32;
            i38 = i33;
            keyboardActions2 = keyboardActions4;
            z10 = z5;
            keyboardOptions2 = keyboardOptions4;
            function211 = function220;
            function212 = function27;
            modifier3 = modifier2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i45222222 = i35 & 2147483646;
            int i46222222 = i36 << 6;
            int i47222222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
            composer2 = startRestartGroup;
            OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i45222222, (i46222222 & 896) | 54 | (i46222222 & 7168) | (57344 & i46222222) | (458752 & i46222222) | (3670016 & i46222222) | (29360128 & i46222222) | (234881024 & i46222222) | (i46222222 & 1879048192), i47222222, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            z11 = z10;
            z12 = z7;
            textStyle4 = textStyle3;
            function213 = function28;
            function214 = function212;
            function215 = function29;
            function216 = function210;
            function217 = function211;
            z13 = z8;
            visualTransformation3 = visualTransformation2;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions3 = keyboardActions2;
            z14 = z9;
            i39 = i37;
            i40 = i38;
            mutableInteractionSource5 = mutableInteractionSource4;
            shape4 = shape3;
            textFieldColors3 = textFieldColors2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        modifier2 = modifier;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        z5 = z;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        z6 = z2;
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i11 = i6 & 64;
        if (i11 != 0) {
        }
        i12 = i6 & 128;
        if (i12 != 0) {
        }
        i13 = i6 & 256;
        if (i13 != 0) {
        }
        i14 = i13;
        i15 = i6 & 512;
        if (i15 == 0) {
        }
        i16 = i15;
        i17 = i6 & 1024;
        if (i17 != 0) {
        }
        i20 = i6 & 2048;
        if (i20 != 0) {
        }
        int i41222222 = i19;
        i22 = i6 & 4096;
        if (i22 != 0) {
        }
        i24 = i6 & 8192;
        if (i24 != 0) {
        }
        i26 = i6 & 16384;
        if (i26 != 0) {
        }
        i28 = i6 & 32768;
        if (i28 == 0) {
        }
        if ((i4 & 1572864) == 0) {
        }
        i29 = i6 & 131072;
        if (i29 == 0) {
        }
        i30 = i6 & 262144;
        if (i30 == 0) {
        }
        if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
        }
        if ((i5 & 6) != 0) {
        }
        if ((i7 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i14 == 0) {
        }
        if (i16 == 0) {
        }
        if (i18 == 0) {
        }
        if (i21 == 0) {
        }
        if (i22 == 0) {
        }
        if (i24 == 0) {
        }
        if (i26 == 0) {
        }
        if (i28 == 0) {
        }
        if ((i6 & 65536) == 0) {
        }
        if (i29 == 0) {
        }
        if (i30 == 0) {
        }
        if ((i6 & 524288) == 0) {
        }
        Shape shape52222222 = shape2;
        if ((i6 & 1048576) == 0) {
        }
        i35 = i7;
        z7 = z6;
        textStyle3 = textStyle2;
        function28 = function26;
        function29 = function218;
        function210 = function219;
        i36 = i27;
        z8 = z15;
        z9 = z16;
        visualTransformation2 = none;
        i37 = i32;
        i38 = i33;
        keyboardActions2 = keyboardActions4;
        z10 = z5;
        keyboardOptions2 = keyboardOptions4;
        function211 = function220;
        function212 = function27;
        modifier3 = modifier2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i452222222 = i35 & 2147483646;
        int i462222222 = i36 << 6;
        int i472222222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
        composer2 = startRestartGroup;
        OutlinedTextField(str, (Function1<? super String, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i452222222, (i462222222 & 896) | 54 | (i462222222 & 7168) | (57344 & i462222222) | (458752 & i462222222) | (3670016 & i462222222) | (29360128 & i462222222) | (234881024 & i462222222) | (i462222222 & 1879048192), i472222222, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        z11 = z10;
        z12 = z7;
        textStyle4 = textStyle3;
        function213 = function28;
        function214 = function212;
        function215 = function29;
        function216 = function210;
        function217 = function211;
        z13 = z8;
        visualTransformation3 = visualTransformation2;
        keyboardOptions3 = keyboardOptions2;
        keyboardActions3 = keyboardActions2;
        z14 = z9;
        i39 = i37;
        i40 = i38;
        mutableInteractionSource5 = mutableInteractionSource4;
        shape4 = shape3;
        textFieldColors3 = textFieldColors2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02b9  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use overload with prefix and suffix parameters")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void OutlinedTextField(final TextFieldValue textFieldValue, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, Function2 function2, Function2 function22, Function2 function23, Function2 function24, Function2 function25, boolean z3, VisualTransformation visualTransformation, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z4, int i, int i2, MutableInteractionSource mutableInteractionSource, Shape shape, TextFieldColors textFieldColors, Composer composer, final int i3, final int i4, final int i5, final int i6) {
        int i7;
        int i8;
        Modifier modifier2;
        int i9;
        boolean z5;
        int i10;
        boolean z6;
        TextStyle textStyle2;
        int i11;
        Function2 function26;
        int i12;
        Function2 function27;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        MutableInteractionSource mutableInteractionSource2;
        MutableInteractionSource mutableInteractionSource3;
        int i34;
        Shape shape2;
        MutableInteractionSource mutableInteractionSource4;
        Shape shape3;
        TextFieldColors textFieldColors2;
        int i35;
        boolean z7;
        TextStyle textStyle3;
        Function2 function28;
        Function2 function29;
        Function2 function210;
        int i36;
        boolean z8;
        boolean z9;
        VisualTransformation visualTransformation2;
        int i37;
        int i38;
        KeyboardActions keyboardActions2;
        boolean z10;
        KeyboardOptions keyboardOptions2;
        Function2 function211;
        Function2 function212;
        Modifier modifier3;
        Composer composer2;
        final Modifier modifier4;
        final boolean z11;
        final boolean z12;
        final TextStyle textStyle4;
        final Function2 function213;
        final Function2 function214;
        final Function2 function215;
        final Function2 function216;
        final Function2 function217;
        final boolean z13;
        final VisualTransformation visualTransformation3;
        final KeyboardOptions keyboardOptions3;
        final KeyboardActions keyboardActions3;
        final boolean z14;
        final int i39;
        final int i40;
        final MutableInteractionSource mutableInteractionSource5;
        final Shape shape4;
        final TextFieldColors textFieldColors3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-989817544);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedTextField)P(19,11,10,1,13,17,6,12,7,18,16,3,20,5,4,15,8,9,2,14)455@23152L7,468@23812L39,469@23898L5,470@23961L8,472@23978L771:OutlinedTextField.kt#uh7d8r");
        if ((i6 & 1) != 0) {
            i7 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i7 = (startRestartGroup.changed(textFieldValue) ? 4 : 2) | i3;
        } else {
            i7 = i3;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i3 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i3 & 384) == 0) {
                modifier2 = modifier;
                i7 |= startRestartGroup.changed(modifier2) ? 256 : 128;
                i9 = i6 & 8;
                if (i9 != 0) {
                    i7 |= 3072;
                } else if ((i3 & 3072) == 0) {
                    z5 = z;
                    i7 |= startRestartGroup.changed(z5) ? 2048 : 1024;
                    i10 = i6 & 16;
                    if (i10 == 0) {
                        i7 |= 24576;
                    } else if ((i3 & 24576) == 0) {
                        z6 = z2;
                        i7 |= startRestartGroup.changed(z6) ? 16384 : 8192;
                        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            textStyle2 = textStyle;
                            i7 |= ((i6 & 32) == 0 && startRestartGroup.changed(textStyle2)) ? 131072 : 65536;
                        } else {
                            textStyle2 = textStyle;
                        }
                        i11 = i6 & 64;
                        if (i11 != 0) {
                            i7 |= 1572864;
                            function26 = function2;
                        } else {
                            function26 = function2;
                            if ((i3 & 1572864) == 0) {
                                i7 |= startRestartGroup.changedInstance(function26) ? 1048576 : 524288;
                            }
                        }
                        i12 = i6 & 128;
                        if (i12 != 0) {
                            i7 |= 12582912;
                            function27 = function22;
                        } else {
                            function27 = function22;
                            if ((i3 & 12582912) == 0) {
                                i7 |= startRestartGroup.changedInstance(function27) ? 8388608 : 4194304;
                            }
                        }
                        i13 = i6 & 256;
                        if (i13 != 0) {
                            i7 |= 100663296;
                        } else if ((i3 & 100663296) == 0) {
                            i14 = i13;
                            i7 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                            i15 = i6 & 512;
                            if (i15 == 0) {
                                i7 |= C.ENCODING_PCM_32BIT;
                            } else if ((i3 & C.ENCODING_PCM_32BIT) == 0) {
                                i16 = i15;
                                i7 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                                i17 = i6 & 1024;
                                if (i17 != 0) {
                                    i19 = i4 | 6;
                                    i18 = i17;
                                } else if ((i4 & 6) == 0) {
                                    i18 = i17;
                                    i19 = i4 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                                } else {
                                    i18 = i17;
                                    i19 = i4;
                                }
                                i20 = i6 & 2048;
                                if (i20 != 0) {
                                    i19 |= 48;
                                    i21 = i20;
                                } else if ((i4 & 48) == 0) {
                                    i21 = i20;
                                    i19 |= startRestartGroup.changed(z3) ? 32 : 16;
                                } else {
                                    i21 = i20;
                                }
                                int i41 = i19;
                                i22 = i6 & 4096;
                                if (i22 != 0) {
                                    i23 = i41 | 384;
                                } else {
                                    int i42 = i41;
                                    if ((i4 & 384) == 0) {
                                        i42 |= startRestartGroup.changed(visualTransformation) ? 256 : 128;
                                    }
                                    i23 = i42;
                                }
                                i24 = i6 & 8192;
                                if (i24 != 0) {
                                    i25 = i23 | 3072;
                                } else {
                                    int i43 = i23;
                                    if ((i4 & 3072) == 0) {
                                        i25 = i43 | (startRestartGroup.changed(keyboardOptions) ? 2048 : 1024);
                                    } else {
                                        i25 = i43;
                                    }
                                }
                                i26 = i6 & 16384;
                                if (i26 != 0) {
                                    i27 = i25 | 24576;
                                } else {
                                    i27 = i25;
                                    if ((i4 & 24576) == 0) {
                                        i27 |= startRestartGroup.changed(keyboardActions) ? 16384 : 8192;
                                        i28 = i6 & 32768;
                                        if (i28 == 0) {
                                            i27 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                                        } else if ((i4 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                            i27 |= startRestartGroup.changed(z4) ? 131072 : 65536;
                                        }
                                        if ((i4 & 1572864) == 0) {
                                            i27 |= ((i6 & 65536) == 0 && startRestartGroup.changed(i)) ? 1048576 : 524288;
                                        }
                                        i29 = i6 & 131072;
                                        if (i29 == 0) {
                                            i27 |= 12582912;
                                        } else if ((i4 & 12582912) == 0) {
                                            i27 |= startRestartGroup.changed(i2) ? 8388608 : 4194304;
                                        }
                                        i30 = i6 & 262144;
                                        if (i30 == 0) {
                                            i27 |= 100663296;
                                        } else if ((i4 & 100663296) == 0) {
                                            i27 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                                        }
                                        if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                                            i27 |= ((i6 & 524288) == 0 && startRestartGroup.changed(shape)) ? 536870912 : 268435456;
                                        }
                                        if ((i5 & 6) != 0) {
                                            i31 = i5 | (((i6 & 1048576) == 0 && startRestartGroup.changed(textFieldColors)) ? 4 : 2);
                                        } else {
                                            i31 = i5;
                                        }
                                        if ((i7 & 306783379) == 306783378 || (i27 & 306783379) != 306783378 || (i31 & 3) != 2 || !startRestartGroup.getSkipping()) {
                                            startRestartGroup.startDefaults();
                                            if ((i3 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                                if (i8 != 0) {
                                                    modifier2 = Modifier.INSTANCE;
                                                }
                                                if (i9 != 0) {
                                                    z5 = true;
                                                }
                                                if (i10 != 0) {
                                                    z6 = false;
                                                }
                                                if ((i6 & 32) != 0) {
                                                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                    Object consume = startRestartGroup.consume(localTextStyle);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    textStyle2 = (TextStyle) consume;
                                                    i7 &= -458753;
                                                }
                                                if (i11 != 0) {
                                                    function26 = null;
                                                }
                                                if (i12 != 0) {
                                                    function27 = null;
                                                }
                                                Function2 function218 = i14 == 0 ? null : function23;
                                                Function2 function219 = i16 == 0 ? null : function24;
                                                Function2 function220 = i18 == 0 ? function25 : null;
                                                boolean z15 = i21 == 0 ? false : z3;
                                                VisualTransformation none = i22 == 0 ? VisualTransformation.INSTANCE.getNone() : visualTransformation;
                                                KeyboardOptions keyboardOptions4 = i24 == 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                                KeyboardActions keyboardActions4 = i26 == 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                                boolean z16 = i28 == 0 ? false : z4;
                                                if ((i6 & 65536) == 0) {
                                                    i32 = z16 ? 1 : Integer.MAX_VALUE;
                                                    i27 &= -3670017;
                                                } else {
                                                    i32 = i;
                                                }
                                                int i44 = i29 == 0 ? i2 : 1;
                                                if (i30 == 0) {
                                                    startRestartGroup.startReplaceableGroup(1663550460);
                                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):OutlinedTextField.kt#9igjgp");
                                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                                    i33 = i44;
                                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                                    }
                                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
                                                    startRestartGroup.endReplaceableGroup();
                                                } else {
                                                    i33 = i44;
                                                    mutableInteractionSource2 = mutableInteractionSource;
                                                }
                                                if ((i6 & 524288) == 0) {
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                    i34 = 6;
                                                    shape2 = OutlinedTextFieldDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                                    i27 &= -1879048193;
                                                } else {
                                                    mutableInteractionSource3 = mutableInteractionSource2;
                                                    i34 = 6;
                                                    shape2 = shape;
                                                }
                                                Shape shape5 = shape2;
                                                if ((i6 & 1048576) == 0) {
                                                    i31 &= -15;
                                                    mutableInteractionSource4 = mutableInteractionSource3;
                                                    shape3 = shape5;
                                                    textFieldColors2 = OutlinedTextFieldDefaults.INSTANCE.colors(startRestartGroup, i34);
                                                } else {
                                                    mutableInteractionSource4 = mutableInteractionSource3;
                                                    shape3 = shape5;
                                                    textFieldColors2 = textFieldColors;
                                                }
                                                i35 = i7;
                                                z7 = z6;
                                                textStyle3 = textStyle2;
                                                function28 = function26;
                                                function29 = function218;
                                                function210 = function219;
                                                i36 = i27;
                                                z8 = z15;
                                                z9 = z16;
                                                visualTransformation2 = none;
                                                i37 = i32;
                                                i38 = i33;
                                                keyboardActions2 = keyboardActions4;
                                                z10 = z5;
                                                keyboardOptions2 = keyboardOptions4;
                                                function211 = function220;
                                                function212 = function27;
                                                modifier3 = modifier2;
                                            } else {
                                                startRestartGroup.skipToGroupEnd();
                                                if ((i6 & 32) != 0) {
                                                    i7 &= -458753;
                                                }
                                                if ((i6 & 65536) != 0) {
                                                    i27 &= -3670017;
                                                }
                                                if ((i6 & 524288) != 0) {
                                                    i27 &= -1879048193;
                                                }
                                                if ((i6 & 1048576) != 0) {
                                                    i31 &= -15;
                                                }
                                                function210 = function24;
                                                function211 = function25;
                                                visualTransformation2 = visualTransformation;
                                                keyboardOptions2 = keyboardOptions;
                                                keyboardActions2 = keyboardActions;
                                                z9 = z4;
                                                i37 = i;
                                                i38 = i2;
                                                mutableInteractionSource4 = mutableInteractionSource;
                                                shape3 = shape;
                                                textFieldColors2 = textFieldColors;
                                                function212 = function27;
                                                i35 = i7;
                                                z7 = z6;
                                                textStyle3 = textStyle2;
                                                function28 = function26;
                                                modifier3 = modifier2;
                                                i36 = i27;
                                                function29 = function23;
                                                z8 = z3;
                                                z10 = z5;
                                            }
                                            startRestartGroup.endDefaults();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-989817544, i35, i36, "androidx.compose.material3.OutlinedTextField (OutlinedTextField.kt:471)");
                                            }
                                            int i45 = i35 & 2147483646;
                                            int i46 = i36 << 6;
                                            int i47 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                                            composer2 = startRestartGroup;
                                            OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i45, (i46 & 896) | 54 | (i46 & 7168) | (57344 & i46) | (458752 & i46) | (3670016 & i46) | (29360128 & i46) | (234881024 & i46) | (i46 & 1879048192), i47, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                            modifier4 = modifier3;
                                            z11 = z10;
                                            z12 = z7;
                                            textStyle4 = textStyle3;
                                            function213 = function28;
                                            function214 = function212;
                                            function215 = function29;
                                            function216 = function210;
                                            function217 = function211;
                                            z13 = z8;
                                            visualTransformation3 = visualTransformation2;
                                            keyboardOptions3 = keyboardOptions2;
                                            keyboardActions3 = keyboardActions2;
                                            z14 = z9;
                                            i39 = i37;
                                            i40 = i38;
                                            mutableInteractionSource5 = mutableInteractionSource4;
                                            shape4 = shape3;
                                            textFieldColors3 = textFieldColors2;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            function217 = function25;
                                            visualTransformation3 = visualTransformation;
                                            keyboardActions3 = keyboardActions;
                                            z14 = z4;
                                            i39 = i;
                                            i40 = i2;
                                            mutableInteractionSource5 = mutableInteractionSource;
                                            shape4 = shape;
                                            textFieldColors3 = textFieldColors;
                                            composer2 = startRestartGroup;
                                            z11 = z5;
                                            function214 = function27;
                                            z12 = z6;
                                            textStyle4 = textStyle2;
                                            function213 = function26;
                                            modifier4 = modifier2;
                                            function215 = function23;
                                            function216 = function24;
                                            z13 = z3;
                                            keyboardOptions3 = keyboardOptions;
                                        }
                                        endRestartGroup = composer2.endRestartGroup();
                                        if (endRestartGroup == null) {
                                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextField$10
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

                                                public final void invoke(Composer composer3, int i48) {
                                                    OutlinedTextFieldKt.OutlinedTextField(TextFieldValue.this, function1, modifier4, z11, z12, textStyle4, function213, function214, function215, function216, function217, z13, visualTransformation3, keyboardOptions3, keyboardActions3, z14, i39, i40, mutableInteractionSource5, shape4, textFieldColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
                                                }
                                            });
                                            return;
                                        }
                                        return;
                                    }
                                }
                                i28 = i6 & 32768;
                                if (i28 == 0) {
                                }
                                if ((i4 & 1572864) == 0) {
                                }
                                i29 = i6 & 131072;
                                if (i29 == 0) {
                                }
                                i30 = i6 & 262144;
                                if (i30 == 0) {
                                }
                                if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                                }
                                if ((i5 & 6) != 0) {
                                }
                                if ((i7 & 306783379) == 306783378) {
                                }
                                startRestartGroup.startDefaults();
                                if ((i3 & 1) != 0) {
                                }
                                if (i8 != 0) {
                                }
                                if (i9 != 0) {
                                }
                                if (i10 != 0) {
                                }
                                if ((i6 & 32) != 0) {
                                }
                                if (i11 != 0) {
                                }
                                if (i12 != 0) {
                                }
                                if (i14 == 0) {
                                }
                                if (i16 == 0) {
                                }
                                if (i18 == 0) {
                                }
                                if (i21 == 0) {
                                }
                                if (i22 == 0) {
                                }
                                if (i24 == 0) {
                                }
                                if (i26 == 0) {
                                }
                                if (i28 == 0) {
                                }
                                if ((i6 & 65536) == 0) {
                                }
                                if (i29 == 0) {
                                }
                                if (i30 == 0) {
                                }
                                if ((i6 & 524288) == 0) {
                                }
                                Shape shape52 = shape2;
                                if ((i6 & 1048576) == 0) {
                                }
                                i35 = i7;
                                z7 = z6;
                                textStyle3 = textStyle2;
                                function28 = function26;
                                function29 = function218;
                                function210 = function219;
                                i36 = i27;
                                z8 = z15;
                                z9 = z16;
                                visualTransformation2 = none;
                                i37 = i32;
                                i38 = i33;
                                keyboardActions2 = keyboardActions4;
                                z10 = z5;
                                keyboardOptions2 = keyboardOptions4;
                                function211 = function220;
                                function212 = function27;
                                modifier3 = modifier2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                int i452 = i35 & 2147483646;
                                int i462 = i36 << 6;
                                int i472 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                                composer2 = startRestartGroup;
                                OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i452, (i462 & 896) | 54 | (i462 & 7168) | (57344 & i462) | (458752 & i462) | (3670016 & i462) | (29360128 & i462) | (234881024 & i462) | (i462 & 1879048192), i472, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                modifier4 = modifier3;
                                z11 = z10;
                                z12 = z7;
                                textStyle4 = textStyle3;
                                function213 = function28;
                                function214 = function212;
                                function215 = function29;
                                function216 = function210;
                                function217 = function211;
                                z13 = z8;
                                visualTransformation3 = visualTransformation2;
                                keyboardOptions3 = keyboardOptions2;
                                keyboardActions3 = keyboardActions2;
                                z14 = z9;
                                i39 = i37;
                                i40 = i38;
                                mutableInteractionSource5 = mutableInteractionSource4;
                                shape4 = shape3;
                                textFieldColors3 = textFieldColors2;
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i16 = i15;
                            i17 = i6 & 1024;
                            if (i17 != 0) {
                            }
                            i20 = i6 & 2048;
                            if (i20 != 0) {
                            }
                            int i412 = i19;
                            i22 = i6 & 4096;
                            if (i22 != 0) {
                            }
                            i24 = i6 & 8192;
                            if (i24 != 0) {
                            }
                            i26 = i6 & 16384;
                            if (i26 != 0) {
                            }
                            i28 = i6 & 32768;
                            if (i28 == 0) {
                            }
                            if ((i4 & 1572864) == 0) {
                            }
                            i29 = i6 & 131072;
                            if (i29 == 0) {
                            }
                            i30 = i6 & 262144;
                            if (i30 == 0) {
                            }
                            if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                            }
                            if ((i5 & 6) != 0) {
                            }
                            if ((i7 & 306783379) == 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i3 & 1) != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 != 0) {
                            }
                            if (i10 != 0) {
                            }
                            if ((i6 & 32) != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i12 != 0) {
                            }
                            if (i14 == 0) {
                            }
                            if (i16 == 0) {
                            }
                            if (i18 == 0) {
                            }
                            if (i21 == 0) {
                            }
                            if (i22 == 0) {
                            }
                            if (i24 == 0) {
                            }
                            if (i26 == 0) {
                            }
                            if (i28 == 0) {
                            }
                            if ((i6 & 65536) == 0) {
                            }
                            if (i29 == 0) {
                            }
                            if (i30 == 0) {
                            }
                            if ((i6 & 524288) == 0) {
                            }
                            Shape shape522 = shape2;
                            if ((i6 & 1048576) == 0) {
                            }
                            i35 = i7;
                            z7 = z6;
                            textStyle3 = textStyle2;
                            function28 = function26;
                            function29 = function218;
                            function210 = function219;
                            i36 = i27;
                            z8 = z15;
                            z9 = z16;
                            visualTransformation2 = none;
                            i37 = i32;
                            i38 = i33;
                            keyboardActions2 = keyboardActions4;
                            z10 = z5;
                            keyboardOptions2 = keyboardOptions4;
                            function211 = function220;
                            function212 = function27;
                            modifier3 = modifier2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i4522 = i35 & 2147483646;
                            int i4622 = i36 << 6;
                            int i4722 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                            composer2 = startRestartGroup;
                            OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i4522, (i4622 & 896) | 54 | (i4622 & 7168) | (57344 & i4622) | (458752 & i4622) | (3670016 & i4622) | (29360128 & i4622) | (234881024 & i4622) | (i4622 & 1879048192), i4722, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier4 = modifier3;
                            z11 = z10;
                            z12 = z7;
                            textStyle4 = textStyle3;
                            function213 = function28;
                            function214 = function212;
                            function215 = function29;
                            function216 = function210;
                            function217 = function211;
                            z13 = z8;
                            visualTransformation3 = visualTransformation2;
                            keyboardOptions3 = keyboardOptions2;
                            keyboardActions3 = keyboardActions2;
                            z14 = z9;
                            i39 = i37;
                            i40 = i38;
                            mutableInteractionSource5 = mutableInteractionSource4;
                            shape4 = shape3;
                            textFieldColors3 = textFieldColors2;
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i14 = i13;
                        i15 = i6 & 512;
                        if (i15 == 0) {
                        }
                        i16 = i15;
                        i17 = i6 & 1024;
                        if (i17 != 0) {
                        }
                        i20 = i6 & 2048;
                        if (i20 != 0) {
                        }
                        int i4122 = i19;
                        i22 = i6 & 4096;
                        if (i22 != 0) {
                        }
                        i24 = i6 & 8192;
                        if (i24 != 0) {
                        }
                        i26 = i6 & 16384;
                        if (i26 != 0) {
                        }
                        i28 = i6 & 32768;
                        if (i28 == 0) {
                        }
                        if ((i4 & 1572864) == 0) {
                        }
                        i29 = i6 & 131072;
                        if (i29 == 0) {
                        }
                        i30 = i6 & 262144;
                        if (i30 == 0) {
                        }
                        if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                        }
                        if ((i5 & 6) != 0) {
                        }
                        if ((i7 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i3 & 1) != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 != 0) {
                        }
                        if (i10 != 0) {
                        }
                        if ((i6 & 32) != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i16 == 0) {
                        }
                        if (i18 == 0) {
                        }
                        if (i21 == 0) {
                        }
                        if (i22 == 0) {
                        }
                        if (i24 == 0) {
                        }
                        if (i26 == 0) {
                        }
                        if (i28 == 0) {
                        }
                        if ((i6 & 65536) == 0) {
                        }
                        if (i29 == 0) {
                        }
                        if (i30 == 0) {
                        }
                        if ((i6 & 524288) == 0) {
                        }
                        Shape shape5222 = shape2;
                        if ((i6 & 1048576) == 0) {
                        }
                        i35 = i7;
                        z7 = z6;
                        textStyle3 = textStyle2;
                        function28 = function26;
                        function29 = function218;
                        function210 = function219;
                        i36 = i27;
                        z8 = z15;
                        z9 = z16;
                        visualTransformation2 = none;
                        i37 = i32;
                        i38 = i33;
                        keyboardActions2 = keyboardActions4;
                        z10 = z5;
                        keyboardOptions2 = keyboardOptions4;
                        function211 = function220;
                        function212 = function27;
                        modifier3 = modifier2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i45222 = i35 & 2147483646;
                        int i46222 = i36 << 6;
                        int i47222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                        composer2 = startRestartGroup;
                        OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i45222, (i46222 & 896) | 54 | (i46222 & 7168) | (57344 & i46222) | (458752 & i46222) | (3670016 & i46222) | (29360128 & i46222) | (234881024 & i46222) | (i46222 & 1879048192), i47222, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        modifier4 = modifier3;
                        z11 = z10;
                        z12 = z7;
                        textStyle4 = textStyle3;
                        function213 = function28;
                        function214 = function212;
                        function215 = function29;
                        function216 = function210;
                        function217 = function211;
                        z13 = z8;
                        visualTransformation3 = visualTransformation2;
                        keyboardOptions3 = keyboardOptions2;
                        keyboardActions3 = keyboardActions2;
                        z14 = z9;
                        i39 = i37;
                        i40 = i38;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        shape4 = shape3;
                        textFieldColors3 = textFieldColors2;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    z6 = z2;
                    if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    }
                    i11 = i6 & 64;
                    if (i11 != 0) {
                    }
                    i12 = i6 & 128;
                    if (i12 != 0) {
                    }
                    i13 = i6 & 256;
                    if (i13 != 0) {
                    }
                    i14 = i13;
                    i15 = i6 & 512;
                    if (i15 == 0) {
                    }
                    i16 = i15;
                    i17 = i6 & 1024;
                    if (i17 != 0) {
                    }
                    i20 = i6 & 2048;
                    if (i20 != 0) {
                    }
                    int i41222 = i19;
                    i22 = i6 & 4096;
                    if (i22 != 0) {
                    }
                    i24 = i6 & 8192;
                    if (i24 != 0) {
                    }
                    i26 = i6 & 16384;
                    if (i26 != 0) {
                    }
                    i28 = i6 & 32768;
                    if (i28 == 0) {
                    }
                    if ((i4 & 1572864) == 0) {
                    }
                    i29 = i6 & 131072;
                    if (i29 == 0) {
                    }
                    i30 = i6 & 262144;
                    if (i30 == 0) {
                    }
                    if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                    }
                    if ((i5 & 6) != 0) {
                    }
                    if ((i7 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i3 & 1) != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i6 & 32) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    if (i18 == 0) {
                    }
                    if (i21 == 0) {
                    }
                    if (i22 == 0) {
                    }
                    if (i24 == 0) {
                    }
                    if (i26 == 0) {
                    }
                    if (i28 == 0) {
                    }
                    if ((i6 & 65536) == 0) {
                    }
                    if (i29 == 0) {
                    }
                    if (i30 == 0) {
                    }
                    if ((i6 & 524288) == 0) {
                    }
                    Shape shape52222 = shape2;
                    if ((i6 & 1048576) == 0) {
                    }
                    i35 = i7;
                    z7 = z6;
                    textStyle3 = textStyle2;
                    function28 = function26;
                    function29 = function218;
                    function210 = function219;
                    i36 = i27;
                    z8 = z15;
                    z9 = z16;
                    visualTransformation2 = none;
                    i37 = i32;
                    i38 = i33;
                    keyboardActions2 = keyboardActions4;
                    z10 = z5;
                    keyboardOptions2 = keyboardOptions4;
                    function211 = function220;
                    function212 = function27;
                    modifier3 = modifier2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i452222 = i35 & 2147483646;
                    int i462222 = i36 << 6;
                    int i472222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                    composer2 = startRestartGroup;
                    OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i452222, (i462222 & 896) | 54 | (i462222 & 7168) | (57344 & i462222) | (458752 & i462222) | (3670016 & i462222) | (29360128 & i462222) | (234881024 & i462222) | (i462222 & 1879048192), i472222, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier4 = modifier3;
                    z11 = z10;
                    z12 = z7;
                    textStyle4 = textStyle3;
                    function213 = function28;
                    function214 = function212;
                    function215 = function29;
                    function216 = function210;
                    function217 = function211;
                    z13 = z8;
                    visualTransformation3 = visualTransformation2;
                    keyboardOptions3 = keyboardOptions2;
                    keyboardActions3 = keyboardActions2;
                    z14 = z9;
                    i39 = i37;
                    i40 = i38;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    shape4 = shape3;
                    textFieldColors3 = textFieldColors2;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                z5 = z;
                i10 = i6 & 16;
                if (i10 == 0) {
                }
                z6 = z2;
                if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                }
                i11 = i6 & 64;
                if (i11 != 0) {
                }
                i12 = i6 & 128;
                if (i12 != 0) {
                }
                i13 = i6 & 256;
                if (i13 != 0) {
                }
                i14 = i13;
                i15 = i6 & 512;
                if (i15 == 0) {
                }
                i16 = i15;
                i17 = i6 & 1024;
                if (i17 != 0) {
                }
                i20 = i6 & 2048;
                if (i20 != 0) {
                }
                int i412222 = i19;
                i22 = i6 & 4096;
                if (i22 != 0) {
                }
                i24 = i6 & 8192;
                if (i24 != 0) {
                }
                i26 = i6 & 16384;
                if (i26 != 0) {
                }
                i28 = i6 & 32768;
                if (i28 == 0) {
                }
                if ((i4 & 1572864) == 0) {
                }
                i29 = i6 & 131072;
                if (i29 == 0) {
                }
                i30 = i6 & 262144;
                if (i30 == 0) {
                }
                if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
                }
                if ((i5 & 6) != 0) {
                }
                if ((i7 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i3 & 1) != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if ((i6 & 32) != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i14 == 0) {
                }
                if (i16 == 0) {
                }
                if (i18 == 0) {
                }
                if (i21 == 0) {
                }
                if (i22 == 0) {
                }
                if (i24 == 0) {
                }
                if (i26 == 0) {
                }
                if (i28 == 0) {
                }
                if ((i6 & 65536) == 0) {
                }
                if (i29 == 0) {
                }
                if (i30 == 0) {
                }
                if ((i6 & 524288) == 0) {
                }
                Shape shape522222 = shape2;
                if ((i6 & 1048576) == 0) {
                }
                i35 = i7;
                z7 = z6;
                textStyle3 = textStyle2;
                function28 = function26;
                function29 = function218;
                function210 = function219;
                i36 = i27;
                z8 = z15;
                z9 = z16;
                visualTransformation2 = none;
                i37 = i32;
                i38 = i33;
                keyboardActions2 = keyboardActions4;
                z10 = z5;
                keyboardOptions2 = keyboardOptions4;
                function211 = function220;
                function212 = function27;
                modifier3 = modifier2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i4522222 = i35 & 2147483646;
                int i4622222 = i36 << 6;
                int i4722222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
                composer2 = startRestartGroup;
                OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i4522222, (i4622222 & 896) | 54 | (i4622222 & 7168) | (57344 & i4622222) | (458752 & i4622222) | (3670016 & i4622222) | (29360128 & i4622222) | (234881024 & i4622222) | (i4622222 & 1879048192), i4722222, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier4 = modifier3;
                z11 = z10;
                z12 = z7;
                textStyle4 = textStyle3;
                function213 = function28;
                function214 = function212;
                function215 = function29;
                function216 = function210;
                function217 = function211;
                z13 = z8;
                visualTransformation3 = visualTransformation2;
                keyboardOptions3 = keyboardOptions2;
                keyboardActions3 = keyboardActions2;
                z14 = z9;
                i39 = i37;
                i40 = i38;
                mutableInteractionSource5 = mutableInteractionSource4;
                shape4 = shape3;
                textFieldColors3 = textFieldColors2;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            i9 = i6 & 8;
            if (i9 != 0) {
            }
            z5 = z;
            i10 = i6 & 16;
            if (i10 == 0) {
            }
            z6 = z2;
            if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            }
            i11 = i6 & 64;
            if (i11 != 0) {
            }
            i12 = i6 & 128;
            if (i12 != 0) {
            }
            i13 = i6 & 256;
            if (i13 != 0) {
            }
            i14 = i13;
            i15 = i6 & 512;
            if (i15 == 0) {
            }
            i16 = i15;
            i17 = i6 & 1024;
            if (i17 != 0) {
            }
            i20 = i6 & 2048;
            if (i20 != 0) {
            }
            int i4122222 = i19;
            i22 = i6 & 4096;
            if (i22 != 0) {
            }
            i24 = i6 & 8192;
            if (i24 != 0) {
            }
            i26 = i6 & 16384;
            if (i26 != 0) {
            }
            i28 = i6 & 32768;
            if (i28 == 0) {
            }
            if ((i4 & 1572864) == 0) {
            }
            i29 = i6 & 131072;
            if (i29 == 0) {
            }
            i30 = i6 & 262144;
            if (i30 == 0) {
            }
            if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
            }
            if ((i5 & 6) != 0) {
            }
            if ((i7 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i3 & 1) != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i14 == 0) {
            }
            if (i16 == 0) {
            }
            if (i18 == 0) {
            }
            if (i21 == 0) {
            }
            if (i22 == 0) {
            }
            if (i24 == 0) {
            }
            if (i26 == 0) {
            }
            if (i28 == 0) {
            }
            if ((i6 & 65536) == 0) {
            }
            if (i29 == 0) {
            }
            if (i30 == 0) {
            }
            if ((i6 & 524288) == 0) {
            }
            Shape shape5222222 = shape2;
            if ((i6 & 1048576) == 0) {
            }
            i35 = i7;
            z7 = z6;
            textStyle3 = textStyle2;
            function28 = function26;
            function29 = function218;
            function210 = function219;
            i36 = i27;
            z8 = z15;
            z9 = z16;
            visualTransformation2 = none;
            i37 = i32;
            i38 = i33;
            keyboardActions2 = keyboardActions4;
            z10 = z5;
            keyboardOptions2 = keyboardOptions4;
            function211 = function220;
            function212 = function27;
            modifier3 = modifier2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i45222222 = i35 & 2147483646;
            int i46222222 = i36 << 6;
            int i47222222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
            composer2 = startRestartGroup;
            OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i45222222, (i46222222 & 896) | 54 | (i46222222 & 7168) | (57344 & i46222222) | (458752 & i46222222) | (3670016 & i46222222) | (29360128 & i46222222) | (234881024 & i46222222) | (i46222222 & 1879048192), i47222222, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier4 = modifier3;
            z11 = z10;
            z12 = z7;
            textStyle4 = textStyle3;
            function213 = function28;
            function214 = function212;
            function215 = function29;
            function216 = function210;
            function217 = function211;
            z13 = z8;
            visualTransformation3 = visualTransformation2;
            keyboardOptions3 = keyboardOptions2;
            keyboardActions3 = keyboardActions2;
            z14 = z9;
            i39 = i37;
            i40 = i38;
            mutableInteractionSource5 = mutableInteractionSource4;
            shape4 = shape3;
            textFieldColors3 = textFieldColors2;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        modifier2 = modifier;
        i9 = i6 & 8;
        if (i9 != 0) {
        }
        z5 = z;
        i10 = i6 & 16;
        if (i10 == 0) {
        }
        z6 = z2;
        if ((i3 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
        }
        i11 = i6 & 64;
        if (i11 != 0) {
        }
        i12 = i6 & 128;
        if (i12 != 0) {
        }
        i13 = i6 & 256;
        if (i13 != 0) {
        }
        i14 = i13;
        i15 = i6 & 512;
        if (i15 == 0) {
        }
        i16 = i15;
        i17 = i6 & 1024;
        if (i17 != 0) {
        }
        i20 = i6 & 2048;
        if (i20 != 0) {
        }
        int i41222222 = i19;
        i22 = i6 & 4096;
        if (i22 != 0) {
        }
        i24 = i6 & 8192;
        if (i24 != 0) {
        }
        i26 = i6 & 16384;
        if (i26 != 0) {
        }
        i28 = i6 & 32768;
        if (i28 == 0) {
        }
        if ((i4 & 1572864) == 0) {
        }
        i29 = i6 & 131072;
        if (i29 == 0) {
        }
        i30 = i6 & 262144;
        if (i30 == 0) {
        }
        if ((i4 & C.ENCODING_PCM_32BIT) == 0) {
        }
        if ((i5 & 6) != 0) {
        }
        if ((i7 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i3 & 1) != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i14 == 0) {
        }
        if (i16 == 0) {
        }
        if (i18 == 0) {
        }
        if (i21 == 0) {
        }
        if (i22 == 0) {
        }
        if (i24 == 0) {
        }
        if (i26 == 0) {
        }
        if (i28 == 0) {
        }
        if ((i6 & 65536) == 0) {
        }
        if (i29 == 0) {
        }
        if (i30 == 0) {
        }
        if ((i6 & 524288) == 0) {
        }
        Shape shape52222222 = shape2;
        if ((i6 & 1048576) == 0) {
        }
        i35 = i7;
        z7 = z6;
        textStyle3 = textStyle2;
        function28 = function26;
        function29 = function218;
        function210 = function219;
        i36 = i27;
        z8 = z15;
        z9 = z16;
        visualTransformation2 = none;
        i37 = i32;
        i38 = i33;
        keyboardActions2 = keyboardActions4;
        z10 = z5;
        keyboardOptions2 = keyboardOptions4;
        function211 = function220;
        function212 = function27;
        modifier3 = modifier2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i452222222 = i35 & 2147483646;
        int i462222222 = i36 << 6;
        int i472222222 = ((i36 >> 24) & 126) | ((i31 << 6) & 896);
        composer2 = startRestartGroup;
        OutlinedTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier3, z10, z7, textStyle3, (Function2<? super Composer, ? super Integer, Unit>) function28, (Function2<? super Composer, ? super Integer, Unit>) function212, (Function2<? super Composer, ? super Integer, Unit>) function29, (Function2<? super Composer, ? super Integer, Unit>) function210, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function211, z8, visualTransformation2, keyboardOptions2, keyboardActions2, z9, i37, i38, mutableInteractionSource4, shape3, textFieldColors2, composer2, i452222222, (i462222222 & 896) | 54 | (i462222222 & 7168) | (57344 & i462222222) | (458752 & i462222222) | (3670016 & i462222222) | (29360128 & i462222222) | (234881024 & i462222222) | (i462222222 & 1879048192), i472222222, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier4 = modifier3;
        z11 = z10;
        z12 = z7;
        textStyle4 = textStyle3;
        function213 = function28;
        function214 = function212;
        function215 = function29;
        function216 = function210;
        function217 = function211;
        z13 = z8;
        visualTransformation3 = visualTransformation2;
        keyboardOptions3 = keyboardOptions2;
        keyboardActions3 = keyboardActions2;
        z14 = z9;
        i39 = i37;
        i40 = i38;
        mutableInteractionSource5 = mutableInteractionSource4;
        shape4 = shape3;
        textFieldColors3 = textFieldColors2;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final void OutlinedTextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, final Function2<? super Composer, ? super Integer, Unit> function26, final boolean z, float f, final Function1<? super Size, Unit> function1, final Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        PaddingValues paddingValues2;
        int i5;
        float f2;
        Function2<? super Composer, ? super Integer, Unit> function29;
        float f3;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        Composer startRestartGroup = composer.startRestartGroup(1408290209);
        ComposerKt.sourceInformation(startRestartGroup, "C(OutlinedTextFieldLayout)P(4,12,7,2,3,13,8,10,9!1,5!1,11)522@25593L239,530@25880L7,531@25892L3534:OutlinedTextField.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = i | (startRestartGroup.changed(modifier) ? 4 : 2);
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function25) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= startRestartGroup.changedInstance(function26) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= startRestartGroup.changed(f) ? 536870912 : 268435456;
        }
        int i6 = i3;
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function27) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= startRestartGroup.changedInstance(function28) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            paddingValues2 = paddingValues;
            i4 |= startRestartGroup.changed(paddingValues2) ? 2048 : 1024;
        } else {
            paddingValues2 = paddingValues;
        }
        int i7 = i4;
        if ((i6 & 306783379) != 306783378 || (i7 & 1171) != 1170 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1408290209, i6, i7, "androidx.compose.material3.OutlinedTextFieldLayout (OutlinedTextField.kt:521)");
            }
            startRestartGroup.startReplaceableGroup(-2058767641);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):OutlinedTextField.kt#9igjgp");
            boolean z2 = ((234881024 & i6) == 67108864) | ((i7 & 14) == 4) | ((i6 & 1879048192) == 536870912) | ((i7 & 7168) == 2048);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new OutlinedTextFieldMeasurePolicy(function1, z, f, paddingValues2);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) consume;
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3593constructorimpl = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl, outlinedTextFieldMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1116455288, "C534@25961L11,604@28446L228:OutlinedTextField.kt#uh7d8r");
            function27.invoke(startRestartGroup, Integer.valueOf((i7 >> 3) & 14));
            startRestartGroup.startReplaceableGroup(1116455313);
            ComposerKt.sourceInformation(startRestartGroup, "537@26025L219");
            if (function23 != null) {
                Modifier then = LayoutIdKt.layoutId(Modifier.INSTANCE, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center = Alignment.INSTANCE.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(then);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl2, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828313575, "C541@26217L9:OutlinedTextField.kt#uh7d8r");
                function23.invoke(startRestartGroup, Integer.valueOf((i6 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1116455598);
            ComposerKt.sourceInformation(startRestartGroup, "545@26311L221");
            if (function24 != null) {
                Modifier then2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center2 = Alignment.INSTANCE.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(then2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3593constructorimpl3 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl3, rememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl3.getInserting() || !Intrinsics.areEqual(m3593constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m3593constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m3593constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                modifierMaterializerOf3.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828313288, "C549@26504L10:OutlinedTextField.kt#uh7d8r");
                function24.invoke(startRestartGroup, Integer.valueOf((i6 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            float calculateStartPadding = PaddingKt.calculateStartPadding(paddingValues2, layoutDirection);
            float calculateEndPadding = PaddingKt.calculateEndPadding(paddingValues2, layoutDirection);
            if (function23 != null) {
                i5 = 0;
                calculateStartPadding = Dp.m6389constructorimpl(RangesKt.coerceAtLeast(Dp.m6389constructorimpl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m6389constructorimpl(0)));
            } else {
                i5 = 0;
            }
            float f4 = calculateStartPadding;
            if (function24 != null) {
                calculateEndPadding = Dp.m6389constructorimpl(RangesKt.coerceAtLeast(Dp.m6389constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m6389constructorimpl(i5)));
            }
            startRestartGroup.startReplaceableGroup(1116456488);
            ComposerKt.sourceInformation(startRestartGroup, "568@27199L334");
            if (function25 != null) {
                Modifier m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m916heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.PrefixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), f4, 0.0f, TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, 10, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor4);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3593constructorimpl4 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl4, rememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl4.getInserting() || !Intrinsics.areEqual(m3593constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    m3593constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    m3593constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                modifierMaterializerOf4.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828312285, "C575@27507L8:OutlinedTextField.kt#uh7d8r");
                function25.invoke(startRestartGroup, Integer.valueOf((i6 >> 18) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1116456887);
            ComposerKt.sourceInformation(startRestartGroup, "579@27598L332");
            if (function26 != null) {
                f2 = calculateEndPadding;
                Modifier m883paddingqDBjuR0$default2 = PaddingKt.m883paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(SizeKt.m916heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.SuffixId), TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldImplKt.getPrefixSuffixTextPadding(), 0.0f, f2, 0.0f, 10, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(m883paddingqDBjuR0$default2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor5);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3593constructorimpl5 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl5, rememberBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl5.getInserting() || !Intrinsics.areEqual(m3593constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    m3593constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                    m3593constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                }
                modifierMaterializerOf5.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828311888, "C586@27904L8:OutlinedTextField.kt#uh7d8r");
                function26.invoke(startRestartGroup, Integer.valueOf((i6 >> 21) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                f2 = calculateEndPadding;
            }
            startRestartGroup.endReplaceableGroup();
            Modifier wrapContentHeight$default = SizeKt.wrapContentHeight$default(SizeKt.m916heightInVpY3zN4$default(Modifier.INSTANCE, TextFieldImplKt.getMinTextLineHeight(), 0.0f, 2, null), null, false, 3, null);
            if (function25 != null) {
                f4 = Dp.m6389constructorimpl(0);
            }
            Modifier m883paddingqDBjuR0$default3 = PaddingKt.m883paddingqDBjuR0$default(wrapContentHeight$default, f4, 0.0f, function26 == null ? f2 : Dp.m6389constructorimpl(0), 0.0f, 10, null);
            startRestartGroup.startReplaceableGroup(1116457597);
            ComposerKt.sourceInformation(startRestartGroup, "599@28313L105");
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, "Hint").then(m883paddingqDBjuR0$default3), startRestartGroup, Integer.valueOf((i6 >> 3) & 112));
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "TextField").then(m883paddingqDBjuR0$default3);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy5 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap6 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf6 = LayoutKt.modifierMaterializerOf(then3);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor6);
            } else {
                startRestartGroup.useNode();
            }
            Composer m3593constructorimpl6 = Updater.m3593constructorimpl(startRestartGroup);
            Updater.m3600setimpl(m3593constructorimpl6, rememberBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl6.getInserting() || !Intrinsics.areEqual(m3593constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                m3593constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                m3593constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
            }
            modifierMaterializerOf6.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828311143, "C610@28649L11:OutlinedTextField.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf((i6 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1116458015);
            ComposerKt.sourceInformation(startRestartGroup, "614@28725L237");
            if (function22 != null) {
                f3 = f;
                Modifier layoutId = LayoutIdKt.layoutId(SizeKt.wrapContentHeight$default(SizeKt.m916heightInVpY3zN4$default(Modifier.INSTANCE, DpKt.m6432lerpMdfbLM(TextFieldImplKt.getMinTextLineHeight(), TextFieldImplKt.getMinFocusedLabelLineHeight(), f3), 0.0f, 2, null), null, false, 3, null), "Label");
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy6 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap7 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf7 = LayoutKt.modifierMaterializerOf(layoutId);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor7);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3593constructorimpl7 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl7, rememberBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl7.getInserting() || !Intrinsics.areEqual(m3593constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
                    m3593constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
                    m3593constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
                }
                modifierMaterializerOf7.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828310839, "C618@28953L7:OutlinedTextField.kt#uh7d8r");
                Integer valueOf = Integer.valueOf((i6 >> 9) & 14);
                function29 = function22;
                function29.invoke(startRestartGroup, valueOf);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                function29 = function22;
                f3 = f;
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-2058764244);
            ComposerKt.sourceInformation(startRestartGroup, "623@29088L269");
            if (function28 != null) {
                Modifier padding = PaddingKt.padding(SizeKt.wrapContentHeight$default(SizeKt.m916heightInVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.SupportingId), TextFieldImplKt.getMinSupportingTextLineHeight(), 0.0f, 2, null), null, false, 3, null), TextFieldDefaults.m2747supportingTextPaddinga9UjIt4$material3_release$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null));
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy7 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash8 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor8 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf8 = LayoutKt.modifierMaterializerOf(padding);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor8);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m3593constructorimpl8 = Updater.m3593constructorimpl(startRestartGroup);
                Updater.m3600setimpl(m3593constructorimpl8, rememberBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3600setimpl(m3593constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (m3593constructorimpl8.getInserting() || !Intrinsics.areEqual(m3593constructorimpl8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash8))) {
                    m3593constructorimpl8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash8));
                    m3593constructorimpl8.apply(Integer.valueOf(currentCompositeKeyHash8), setCompositeKeyHash8);
                }
                modifierMaterializerOf8.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1828310449, "C628@29343L12:OutlinedTextField.kt#uh7d8r");
                function210 = function28;
                function210.invoke(startRestartGroup, Integer.valueOf((i7 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            } else {
                function210 = function28;
            }
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            function29 = function22;
            function210 = function28;
            f3 = f;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Function2<? super Composer, ? super Integer, Unit> function211 = function29;
            final float f5 = f3;
            final PaddingValues paddingValues3 = paddingValues2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$OutlinedTextFieldLayout$2
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

                public final void invoke(Composer composer2, int i8) {
                    OutlinedTextFieldKt.OutlinedTextFieldLayout(Modifier.this, function2, function3, function211, function23, function24, function25, function26, z, f5, function1, function27, function210, paddingValues3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-DHJA7U0, reason: not valid java name */
    public static final int m2392calculateWidthDHJA7U0(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, float f2, PaddingValues paddingValues) {
        int i8 = i3 + i4;
        return Math.max(i + Math.max(i5 + i8, Math.max(i7 + i8, MathHelpersKt.lerp(i6, 0, f))) + i2, Math.max(MathKt.roundToInt((i6 + (Dp.m6389constructorimpl(paddingValues.mo830calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr) + paddingValues.mo831calculateRightPaddingu2uoSUM(LayoutDirection.Ltr)) * f2)) * f), Constraints.m6347getMinWidthimpl(j)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-mKXJcVc, reason: not valid java name */
    public static final int m2391calculateHeightmKXJcVc(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, long j, float f2, PaddingValues paddingValues) {
        int maxOf = ComparisonsKt.maxOf(i5, i7, i3, i4, MathHelpersKt.lerp(i6, 0, f));
        float top = paddingValues.getTop() * f2;
        return Math.max(Constraints.m6346getMinHeightimpl(j), Math.max(i, Math.max(i2, MathKt.roundToInt(MathHelpersKt.lerp(top, Math.max(top, i6 / 2.0f), f) + maxOf + (paddingValues.getBottom() * f2)))) + i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, Placeable placeable7, Placeable placeable8, Placeable placeable9, float f, boolean z, float f2, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        Placeable placeable10;
        boolean z2;
        int i3;
        int i4;
        Placeable.PlacementScope.m5384place70tqf50$default(placementScope, placeable8, IntOffset.INSTANCE.m6527getZeronOccac(), 0.0f, 2, null);
        int heightOrZero = i - TextFieldImplKt.heightOrZero(placeable9);
        int roundToInt = MathKt.roundToInt(paddingValues.getTop() * f2);
        int roundToInt2 = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * f2);
        float horizontalIconPadding = TextFieldImplKt.getHorizontalIconPadding() * f2;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2 - placeable2.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), heightOrZero), 0.0f, 4, null);
        }
        if (placeable6 != null) {
            placeable10 = placeable6;
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable10, MathKt.roundToInt(placeable == null ? 0.0f : (TextFieldImplKt.widthOrZero(placeable) - horizontalIconPadding) * (1 - f)) + roundToInt2, MathHelpersKt.lerp(z ? Alignment.INSTANCE.getCenterVertically().align(placeable6.getHeight(), heightOrZero) : roundToInt, -(placeable6.getHeight() / 2), f), 0.0f, 4, null);
        } else {
            placeable10 = placeable6;
        }
        if (placeable3 != null) {
            i4 = roundToInt;
            i3 = heightOrZero;
            z2 = z;
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable), place$calculateVerticalPosition(z, heightOrZero, roundToInt, placeable10, placeable3), 0.0f, 4, null);
        } else {
            z2 = z;
            i3 = heightOrZero;
            i4 = roundToInt;
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, (i2 - TextFieldImplKt.widthOrZero(placeable2)) - placeable4.getWidth(), place$calculateVerticalPosition(z2, i3, i4, placeable10, placeable4), 0.0f, 4, null);
        }
        int widthOrZero = TextFieldImplKt.widthOrZero(placeable) + TextFieldImplKt.widthOrZero(placeable3);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, widthOrZero, place$calculateVerticalPosition(z2, i3, i4, placeable10, placeable5), 0.0f, 4, null);
        if (placeable7 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, widthOrZero, place$calculateVerticalPosition(z2, i3, i4, placeable10, placeable7), 0.0f, 4, null);
        }
        if (placeable9 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, 0, i3, 0.0f, 4, null);
        }
    }

    private static final int place$calculateVerticalPosition(boolean z, int i, int i2, Placeable placeable, Placeable placeable2) {
        if (z) {
            i2 = Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i);
        }
        return Math.max(i2, TextFieldImplKt.heightOrZero(placeable) / 2);
    }

    /* renamed from: outlineCutout-12SF9DM, reason: not valid java name */
    public static final Modifier m2393outlineCutout12SF9DM(Modifier modifier, final long j, final PaddingValues paddingValues) {
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldKt$outlineCutout$1

            /* compiled from: OutlinedTextField.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    try {
                        iArr[LayoutDirection.Rtl.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope contentDrawScope) {
                float f;
                float coerceAtLeast;
                float m3891getWidthimpl = Size.m3891getWidthimpl(j);
                if (m3891getWidthimpl > 0.0f) {
                    f = OutlinedTextFieldKt.OutlinedTextFieldInnerPadding;
                    float f2 = contentDrawScope.mo630toPx0680j_4(f);
                    float f3 = contentDrawScope.mo630toPx0680j_4(paddingValues.mo830calculateLeftPaddingu2uoSUM(contentDrawScope.getLayoutDirection())) - f2;
                    float f4 = 2;
                    float f5 = m3891getWidthimpl + f3 + (f2 * f4);
                    if (WhenMappings.$EnumSwitchMapping$0[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
                        coerceAtLeast = Size.m3891getWidthimpl(contentDrawScope.mo4612getSizeNHjbRc()) - f5;
                    } else {
                        coerceAtLeast = RangesKt.coerceAtLeast(f3, 0.0f);
                    }
                    float f6 = coerceAtLeast;
                    if (WhenMappings.$EnumSwitchMapping$0[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
                        f5 = Size.m3891getWidthimpl(contentDrawScope.mo4612getSizeNHjbRc()) - RangesKt.coerceAtLeast(f3, 0.0f);
                    }
                    float f7 = f5;
                    float m3888getHeightimpl = Size.m3888getHeightimpl(j);
                    float f8 = (-m3888getHeightimpl) / f4;
                    float f9 = m3888getHeightimpl / f4;
                    int m4051getDifferencertfAjoo = ClipOp.INSTANCE.m4051getDifferencertfAjoo();
                    DrawContext drawContext = contentDrawScope.getDrawContext();
                    long mo4537getSizeNHjbRc = drawContext.mo4537getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    drawContext.getTransform().mo4540clipRectN_I0leg(f6, f8, f7, f9, m4051getDifferencertfAjoo);
                    contentDrawScope.drawContent();
                    drawContext.getCanvas().restore();
                    drawContext.mo4538setSizeuvyYCjk(mo4537getSizeNHjbRc);
                    return;
                }
                contentDrawScope.drawContent();
            }
        });
    }

    public static final float getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }
}
