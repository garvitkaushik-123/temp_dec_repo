package androidx.compose.material3;

import android.content.res.Configuration;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.shape.GenericShape;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SearchBar.android.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0087\u0002\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u00102\b\b\u0002\u00108\u001a\u00020\u00102\b\b\u0002\u00109\u001a\u00020:2\u001c\u0010;\u001a\u0018\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\"0&¢\u0006\u0002\b0¢\u0006\u0002\b=H\u0007ø\u0001\u0000¢\u0006\u0004\b>\u0010?\u001a\u0091\u0002\u0010@\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u00107\u001a\u00020\u00102\b\b\u0002\u00108\u001a\u00020\u00102\b\b\u0002\u0010A\u001a\u00020B2\b\b\u0002\u00109\u001a\u00020:2\u001c\u0010;\u001a\u0018\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\"0&¢\u0006\u0002\b0¢\u0006\u0002\b=H\u0007ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001aÆ\u0001\u0010E\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\"0&2\u0006\u0010(\u001a\u00020)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\"0&2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020)2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\"\u0018\u00010/¢\u0006\u0002\b02\b\b\u0002\u00105\u001a\u00020F2\b\b\u0002\u00109\u001a\u00020:H\u0003¢\u0006\u0002\u0010G\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u000f\u001a\u00020\u0010X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0018\u001a\u00020\u0010X\u0082\u0004¢\u0006\n\n\u0002\u0010\u0013\u0012\u0004\b\u0019\u0010\u001a\"\u0010\u0010\u001b\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013\"\u0010\u0010\u001c\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013\"\u0016\u0010\u001d\u001a\u00020\u0010X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001e\u0010\u0012\"\u0016\u0010\u001f\u001a\u00020\u0010X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b \u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006H²\u0006\n\u0010I\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010J\u001a\u00020)X\u008a\u0084\u0002"}, d2 = {"AnimationDelayMillis", "", "AnimationEnterDurationMillis", "AnimationEnterEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "AnimationEnterFloatSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "AnimationEnterSizeSpec", "Landroidx/compose/ui/unit/IntSize;", "AnimationExitDurationMillis", "AnimationExitEasing", "AnimationExitFloatSpec", "AnimationExitSizeSpec", "DockedActiveTableMaxHeightScreenRatio", "DockedActiveTableMinHeight", "Landroidx/compose/ui/unit/Dp;", "getDockedActiveTableMinHeight", "()F", "F", "DockedEnterTransition", "Landroidx/compose/animation/EnterTransition;", "DockedExitTransition", "Landroidx/compose/animation/ExitTransition;", "SearchBarCornerRadius", "getSearchBarCornerRadius$annotations", "()V", "SearchBarIconOffsetX", "SearchBarMaxWidth", "SearchBarMinWidth", "getSearchBarMinWidth", "SearchBarVerticalPadding", "getSearchBarVerticalPadding", "DockedSearchBar", "", "query", "", "onQueryChange", "Lkotlin/Function1;", "onSearch", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "", "onActiveChange", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "placeholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "leadingIcon", "trailingIcon", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/SearchBarColors;", "tonalElevation", "shadowElevation", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "DockedSearchBar-eWTbjVg", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBar", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "SearchBar-WuY5d9Q", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SearchBarColors;FFLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "SearchBarInputField", "Landroidx/compose/material3/TextFieldColors;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "material3_release", "useFullScreenShape", "showResults"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SearchBar_androidKt {
    private static final int AnimationDelayMillis = 100;
    private static final int AnimationEnterDurationMillis = 600;
    private static final CubicBezierEasing AnimationEnterEasing;
    private static final FiniteAnimationSpec<Float> AnimationEnterFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationEnterSizeSpec;
    private static final int AnimationExitDurationMillis = 350;
    private static final CubicBezierEasing AnimationExitEasing;
    private static final FiniteAnimationSpec<Float> AnimationExitFloatSpec;
    private static final FiniteAnimationSpec<IntSize> AnimationExitSizeSpec;
    private static final float DockedActiveTableMaxHeightScreenRatio = 0.6666667f;
    private static final EnterTransition DockedEnterTransition;
    private static final ExitTransition DockedExitTransition;
    private static final float SearchBarCornerRadius = Dp.m6389constructorimpl(SearchBarDefaults.INSTANCE.m2449getInputFieldHeightD9Ej5fM() / 2);
    private static final float DockedActiveTableMinHeight = Dp.m6389constructorimpl(240);
    private static final float SearchBarMinWidth = Dp.m6389constructorimpl(360);
    private static final float SearchBarMaxWidth = Dp.m6389constructorimpl(720);
    private static final float SearchBarVerticalPadding = Dp.m6389constructorimpl(8);
    private static final float SearchBarIconOffsetX = Dp.m6389constructorimpl(4);

    private static /* synthetic */ void getSearchBarCornerRadius$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04a5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x05b2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x060a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x025b  */
    /* renamed from: SearchBar-WuY5d9Q, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2455SearchBarWuY5d9Q(final String str, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, boolean z, Function1<? super Boolean, Unit> function13, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SearchBarColors searchBarColors, float f, float f2, WindowInsets windowInsets, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        final Modifier modifier2;
        int i6;
        boolean z3;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function25;
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
        Shape shape2;
        int i20;
        Modifier modifier3;
        int i21;
        SearchBarColors searchBarColors2;
        WindowInsets windowInsets2;
        MutableInteractionSource mutableInteractionSource2;
        SearchBarColors searchBarColors3;
        final WindowInsets windowInsets3;
        Shape shape3;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        int i22;
        boolean z4;
        float f3;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        Modifier modifier4;
        float f4;
        Function2<? super Composer, ? super Integer, Unit> function28;
        final State<Float> animateFloatAsState;
        final Density density;
        Shape inputFieldShape;
        Shape fullScreenShape;
        Object rememberedValue;
        State state;
        boolean changed;
        GenericShape rememberedValue2;
        Object rememberedValue3;
        boolean changed2;
        Object rememberedValue4;
        boolean z5;
        Object rememberedValue5;
        boolean changed3;
        Object rememberedValue6;
        boolean z6;
        boolean changed4;
        SearchBar_androidKt$SearchBar$5$1 rememberedValue7;
        boolean z7;
        Object rememberedValue8;
        final MutableInteractionSource mutableInteractionSource3;
        Composer composer2;
        final float f5;
        final float f6;
        final Shape shape4;
        final WindowInsets windowInsets4;
        final SearchBarColors searchBarColors4;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final boolean z8;
        ScopeUpdateScope endRestartGroup;
        int i23;
        int i24;
        final boolean z9 = z;
        final Function1<? super Boolean, Unit> function14 = function13;
        Composer startRestartGroup = composer.startRestartGroup(1001512593);
        ComposerKt.sourceInformation(startRestartGroup, "C(SearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,16,4)170@8780L15,171@8845L8,174@9026L12,175@9090L39,178@9226L160,183@9429L7,184@9468L7,186@9528L15,187@9595L15,188@9641L101,191@9767L578,211@10793L34,212@10849L179,222@11136L38,227@11355L112,231@11539L1082,219@11034L2762,284@13836L25,286@13943L292,286@13920L315,295@14271L37,295@14241L67:SearchBar.android.kt#uh7d8r");
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
            i4 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            if ((i3 & 4) == 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                i4 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
                if ((i3 & 8) != 0) {
                    i4 |= 3072;
                } else if ((i & 3072) == 0) {
                    i4 |= startRestartGroup.changed(z9) ? 2048 : 1024;
                }
                int i25 = 8192;
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= startRestartGroup.changedInstance(function14) ? 16384 : 8192;
                }
                i5 = i3 & 32;
                if (i5 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    modifier2 = modifier;
                } else {
                    modifier2 = modifier;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= startRestartGroup.changed(modifier2) ? 131072 : 65536;
                    }
                }
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                    z3 = z2;
                } else {
                    z3 = z2;
                    if ((i & 1572864) == 0) {
                        i4 |= startRestartGroup.changed(z3) ? 1048576 : 524288;
                    }
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                    function24 = function2;
                } else {
                    function24 = function2;
                    if ((i & 12582912) == 0) {
                        i4 |= startRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
                    }
                }
                i8 = i3 & 256;
                if (i8 != 0) {
                    i4 |= 100663296;
                    function25 = function22;
                } else {
                    function25 = function22;
                    if ((i & 100663296) == 0) {
                        i4 |= startRestartGroup.changedInstance(function25) ? 67108864 : 33554432;
                    }
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                    i4 |= C.ENCODING_PCM_32BIT;
                } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                    i10 = i9;
                    i4 |= startRestartGroup.changedInstance(function23) ? 536870912 : 268435456;
                    if ((i2 & 6) != 0) {
                        if ((i3 & 1024) == 0 && startRestartGroup.changed(shape)) {
                            i24 = 4;
                            i11 = i2 | i24;
                        }
                        i24 = 2;
                        i11 = i2 | i24;
                    } else {
                        i11 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if ((i3 & 2048) == 0 && startRestartGroup.changed(searchBarColors)) {
                            i23 = 32;
                            i11 |= i23;
                        }
                        i23 = 16;
                        i11 |= i23;
                    }
                    int i26 = i11;
                    i12 = i4;
                    i13 = i3 & 4096;
                    if (i13 == 0) {
                        i14 = i26 | 384;
                    } else {
                        int i27 = i26;
                        if ((i2 & 384) == 0) {
                            i27 |= startRestartGroup.changed(f) ? 256 : 128;
                        }
                        i14 = i27;
                    }
                    i15 = i3 & 8192;
                    if (i15 == 0) {
                        i16 = i14 | 3072;
                    } else {
                        int i28 = i14;
                        if ((i2 & 3072) == 0) {
                            i16 = i28 | (startRestartGroup.changed(f2) ? 2048 : 1024);
                        } else {
                            i16 = i28;
                        }
                    }
                    if ((i2 & 24576) == 0) {
                        if ((i3 & 16384) == 0 && startRestartGroup.changed(windowInsets)) {
                            i25 = 16384;
                        }
                        i16 |= i25;
                    }
                    i17 = i3 & 32768;
                    if (i17 == 0) {
                        i16 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i18 = i15;
                        i16 |= startRestartGroup.changed(mutableInteractionSource) ? 131072 : 65536;
                        if ((i3 & 65536) != 0) {
                            i16 |= 1572864;
                        } else if ((i2 & 1572864) == 0) {
                            i16 |= startRestartGroup.changedInstance(function3) ? 1048576 : 524288;
                        }
                        if ((i12 & 306783379) != 306783378 && (i16 & 599187) == 599186 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            shape4 = shape;
                            f5 = f;
                            windowInsets4 = windowInsets;
                            mutableInteractionSource3 = mutableInteractionSource;
                            z8 = z3;
                            function211 = function24;
                            composer2 = startRestartGroup;
                            function210 = function25;
                            function29 = function23;
                            searchBarColors4 = searchBarColors;
                            f6 = f2;
                        } else {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                                boolean z10 = i6 != 0 ? true : z2;
                                Function2<? super Composer, ? super Integer, Unit> function212 = i7 != 0 ? null : function24;
                                Function2<? super Composer, ? super Integer, Unit> function213 = i8 != 0 ? null : function25;
                                Function2<? super Composer, ? super Integer, Unit> function214 = i10 != 0 ? null : function23;
                                if ((i3 & 1024) != 0) {
                                    i19 = i16 & (-15);
                                    shape2 = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                                } else {
                                    i19 = i16;
                                    shape2 = shape;
                                }
                                if ((i3 & 2048) != 0) {
                                    i20 = i12;
                                    modifier3 = companion;
                                    i21 = 6;
                                    searchBarColors2 = SearchBarDefaults.INSTANCE.m2447colorsKlgxPg(0L, 0L, null, startRestartGroup, 3072, 7);
                                    i19 &= -113;
                                } else {
                                    i20 = i12;
                                    modifier3 = companion;
                                    i21 = 6;
                                    searchBarColors2 = searchBarColors;
                                }
                                float m2451getTonalElevationD9Ej5fM = i13 != 0 ? SearchBarDefaults.INSTANCE.m2451getTonalElevationD9Ej5fM() : f;
                                float m2450getShadowElevationD9Ej5fM = i18 != 0 ? SearchBarDefaults.INSTANCE.m2450getShadowElevationD9Ej5fM() : f2;
                                if ((i3 & 16384) != 0) {
                                    windowInsets2 = SearchBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, i21);
                                    i19 &= -57345;
                                } else {
                                    windowInsets2 = windowInsets;
                                }
                                if (i17 != 0) {
                                    startRestartGroup.startReplaceableGroup(851477946);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                                    Object rememberedValue9 = startRestartGroup.rememberedValue();
                                    if (rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue9 = InteractionSourceKt.MutableInteractionSource();
                                        startRestartGroup.updateRememberedValue(rememberedValue9);
                                    }
                                    startRestartGroup.endReplaceableGroup();
                                    searchBarColors3 = searchBarColors2;
                                    windowInsets3 = windowInsets2;
                                    mutableInteractionSource2 = (MutableInteractionSource) rememberedValue9;
                                } else {
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    searchBarColors3 = searchBarColors2;
                                    windowInsets3 = windowInsets2;
                                }
                                shape3 = shape2;
                                function26 = function214;
                                i22 = i19;
                                z4 = z10;
                                f3 = m2450getShadowElevationD9Ej5fM;
                                function27 = function213;
                                modifier4 = modifier3;
                                f4 = m2451getTonalElevationD9Ej5fM;
                                function28 = function212;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 1024) != 0) {
                                    i16 &= -15;
                                }
                                if ((i3 & 2048) != 0) {
                                    i16 &= -113;
                                }
                                if ((i3 & 16384) != 0) {
                                    i16 &= -57345;
                                }
                                function26 = function23;
                                searchBarColors3 = searchBarColors;
                                f4 = f;
                                f3 = f2;
                                windowInsets3 = windowInsets;
                                i20 = i12;
                                modifier4 = modifier2;
                                function28 = function24;
                                function27 = function25;
                                i22 = i16;
                                z4 = z2;
                                shape3 = shape;
                                mutableInteractionSource2 = mutableInteractionSource;
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1001512593, i20, i22, "androidx.compose.material3.SearchBar (SearchBar.android.kt:177)");
                            }
                            animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, z ? AnimationEnterFloatSpec : AnimationExitFloatSpec, 0.0f, null, null, startRestartGroup, 0, 28);
                            ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
                            final boolean z11 = z4;
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = startRestartGroup.consume(localFocusManager);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            FocusManager focusManager = (FocusManager) consume;
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume2 = startRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                            density = (Density) consume2;
                            inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                            final Function2<? super Composer, ? super Integer, Unit> function215 = function28;
                            fullScreenShape = SearchBarDefaults.INSTANCE.getFullScreenShape(startRestartGroup, 6);
                            startRestartGroup.startReplaceableGroup(851478497);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                rememberedValue = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$useFullScreenShape$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        return Boolean.valueOf(animateFloatAsState.getValue().floatValue() == 1.0f);
                                    }
                                });
                                startRestartGroup.updateRememberedValue(rememberedValue);
                            }
                            state = (State) rememberedValue;
                            startRestartGroup.endReplaceableGroup();
                            boolean SearchBar_WuY5d9Q$lambda$2 = SearchBar_WuY5d9Q$lambda$2(state);
                            startRestartGroup.startReplaceableGroup(851478623);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                            int i29 = i20;
                            changed = startRestartGroup.changed(SearchBar_WuY5d9Q$lambda$2) | ((((i22 & 14) ^ 6) <= 4 && startRestartGroup.changed(shape3)) || (i22 & 6) == 4);
                            rememberedValue2 = startRestartGroup.rememberedValue();
                            if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = Intrinsics.areEqual(shape3, inputFieldShape) ? new GenericShape(new Function3<Path, Size, LayoutDirection, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$animatedShape$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(Path path, Size size, LayoutDirection layoutDirection) {
                                        m2457invoke12SF9DM(path, size.getPackedValue(), layoutDirection);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-12SF9DM, reason: not valid java name */
                                    public final void m2457invoke12SF9DM(Path path, long j, LayoutDirection layoutDirection) {
                                        float f7;
                                        Density density2 = Density.this;
                                        State<Float> state2 = animateFloatAsState;
                                        f7 = SearchBar_androidKt.SearchBarCornerRadius;
                                        path.addRoundRect(RoundRectKt.m3877RoundRectsniSvfs(SizeKt.m3912toRectuvyYCjk(j), CornerRadiusKt.CornerRadius$default(density2.mo630toPx0680j_4(Dp.m6389constructorimpl(f7 * (1 - state2.getValue().floatValue()))), 0.0f, 2, null)));
                                    }
                                }) : SearchBar_WuY5d9Q$lambda$2(state) ? fullScreenShape : shape3;
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                            }
                            Shape shape5 = (Shape) rememberedValue2;
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(851479649);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                            rememberedValue3 = startRestartGroup.rememberedValue();
                            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = new MutableWindowInsets(null, 1, null);
                                startRestartGroup.updateRememberedValue(rememberedValue3);
                            }
                            final MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) rememberedValue3;
                            startRestartGroup.endReplaceableGroup();
                            startRestartGroup.startReplaceableGroup(851479705);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                            changed2 = startRestartGroup.changed(density);
                            rememberedValue4 = startRestartGroup.rememberedValue();
                            if (!changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$topPadding$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Dp invoke() {
                                        return Dp.m6387boximpl(m2458invokeD9Ej5fM());
                                    }

                                    /* renamed from: invoke-D9Ej5fM, reason: not valid java name */
                                    public final float m2458invokeD9Ej5fM() {
                                        return Dp.m6389constructorimpl(SearchBar_androidKt.getSearchBarVerticalPadding() + WindowInsetsKt.asPaddingValues(MutableWindowInsets.this, density).getTop());
                                    }
                                });
                                startRestartGroup.updateRememberedValue(rememberedValue4);
                            }
                            final State state2 = (State) rememberedValue4;
                            startRestartGroup.endReplaceableGroup();
                            long containerColor = searchBarColors3.getContainerColor();
                            long m2049contentColorForek8zF_U = ColorSchemeKt.m2049contentColorForek8zF_U(searchBarColors3.getContainerColor(), startRestartGroup, 0);
                            Modifier zIndex = ZIndexModifierKt.zIndex(modifier4, 1.0f);
                            startRestartGroup.startReplaceableGroup(851480211);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                            z5 = (((57344 & i22) ^ 24576) <= 16384 && startRestartGroup.changed(windowInsets3)) || (i22 & 24576) == 16384;
                            rememberedValue5 = startRestartGroup.rememberedValue();
                            if (!z5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue5 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets5) {
                                        invoke2(windowInsets5);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(WindowInsets windowInsets5) {
                                        MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets3, windowInsets5));
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue5);
                            }
                            startRestartGroup.endReplaceableGroup();
                            Modifier consumeWindowInsets = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(zIndex, (Function1) rememberedValue5), mutableWindowInsets);
                            startRestartGroup.startReplaceableGroup(851480395);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                            changed3 = startRestartGroup.changed(state2) | startRestartGroup.changed(animateFloatAsState);
                            rememberedValue6 = startRestartGroup.rememberedValue();
                            if (!changed3 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue6 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                                        return m2456invoke3p2s80s(measureScope, measurable, constraints.getValue());
                                    }

                                    /* renamed from: invoke-3p2s80s, reason: not valid java name */
                                    public final MeasureResult m2456invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                                        float f7;
                                        final int i30 = measureScope.mo624roundToPx0680j_4(DpKt.m6432lerpMdfbLM(state2.getValue().m6403unboximpl(), Dp.m6389constructorimpl(0), animateFloatAsState.getValue().floatValue()));
                                        int max = Math.max(Constraints.m6347getMinWidthimpl(j), measureScope.mo624roundToPx0680j_4(SearchBar_androidKt.getSearchBarMinWidth()));
                                        int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j);
                                        f7 = SearchBar_androidKt.SearchBarMaxWidth;
                                        int coerceAtMost = RangesKt.coerceAtMost(max, Math.min(m6345getMaxWidthimpl, measureScope.mo624roundToPx0680j_4(f7)));
                                        int coerceAtMost2 = RangesKt.coerceAtMost(Math.max(Constraints.m6346getMinHeightimpl(j), measureScope.mo624roundToPx0680j_4(SearchBarDefaults.INSTANCE.m2449getInputFieldHeightD9Ej5fM())), Constraints.m6344getMaxHeightimpl(j));
                                        int m6345getMaxWidthimpl2 = Constraints.m6345getMaxWidthimpl(j);
                                        int m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(j);
                                        int lerp = MathHelpersKt.lerp(coerceAtMost, m6345getMaxWidthimpl2, animateFloatAsState.getValue().floatValue());
                                        int lerp2 = MathHelpersKt.lerp(coerceAtMost2, m6344getMaxHeightimpl, animateFloatAsState.getValue().floatValue()) + i30;
                                        final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(ConstraintsKt.m6362offsetNN6EwU$default(Constraints.INSTANCE.m6353fixedJhjzzOo(lerp, lerp2), 0, -i30, 1, null));
                                        return MeasureScope.layout$default(measureScope, lerp, lerp2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                                invoke2(placementScope);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, i30, 0.0f, 4, null);
                                            }
                                        }, 4, null);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue6);
                            }
                            startRestartGroup.endReplaceableGroup();
                            Modifier layout = LayoutModifierKt.layout(consumeWindowInsets, (Function3) rememberedValue6);
                            int i30 = i22;
                            z9 = z;
                            function14 = function13;
                            Modifier modifier5 = modifier4;
                            Shape shape6 = shape3;
                            final SearchBarColors searchBarColors5 = searchBarColors3;
                            WindowInsets windowInsets5 = windowInsets3;
                            final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                            int i31 = i30 << 6;
                            SurfaceKt.m2633SurfaceT9BRK9s(layout, shape5, containerColor, m2049contentColorForek8zF_U, f4, f3, null, ComposableLambdaKt.composableLambda(startRestartGroup, 483163116, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4
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

                                public final void invoke(Composer composer3, int i32) {
                                    final State<Float> state3;
                                    ComposerKt.sourceInformation(composer3, "C253@12638L1152:SearchBar.android.kt#uh7d8r");
                                    if ((i32 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(483163116, i32, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:253)");
                                        }
                                        String str2 = str;
                                        Function1<String, Unit> function15 = function1;
                                        Function1<String, Unit> function16 = function12;
                                        boolean z12 = z9;
                                        Function1<Boolean, Unit> function17 = function14;
                                        boolean z13 = z11;
                                        Function2<Composer, Integer, Unit> function216 = function215;
                                        Function2<Composer, Integer, Unit> function217 = function27;
                                        Function2<Composer, Integer, Unit> function218 = function26;
                                        SearchBarColors searchBarColors6 = searchBarColors5;
                                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                                        State<Float> state4 = animateFloatAsState;
                                        State<Dp> state5 = state2;
                                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                        composer3.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                        Modifier.Companion companion2 = Modifier.INSTANCE;
                                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                                        Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, -685095315, "C254@12691L93,257@12797L590,272@13420L115:SearchBar.android.kt#uh7d8r");
                                        composer3.startReplaceableGroup(-685095283);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                        Object rememberedValue10 = composer3.rememberedValue();
                                        if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue10 = new AnimatedPaddingValues(state4, state5);
                                            composer3.updateRememberedValue(rememberedValue10);
                                        }
                                        composer3.endReplaceableGroup();
                                        SearchBar_androidKt.SearchBarInputField(str2, function15, function16, z12, function17, PaddingKt.padding(Modifier.INSTANCE, (AnimatedPaddingValues) rememberedValue10), z13, function216, function217, function218, searchBarColors6.getInputFieldColors(), mutableInteractionSource5, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 0);
                                        composer3.startReplaceableGroup(-685094554);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                        Object rememberedValue11 = composer3.rememberedValue();
                                        if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                            state3 = state4;
                                            rememberedValue11 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$showResults$2$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX WARN: Can't rename method to resolve collision */
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    return Boolean.valueOf(state3.getValue().floatValue() > 0.0f);
                                                }
                                            });
                                            composer3.updateRememberedValue(rememberedValue11);
                                        } else {
                                            state3 = state4;
                                        }
                                        composer3.endReplaceableGroup();
                                        composer3.startReplaceableGroup(551421253);
                                        ComposerKt.sourceInformation(composer3, "276@13613L35,276@13583L183");
                                        if (invoke$lambda$5$lambda$2((State) rememberedValue11)) {
                                            Modifier.Companion companion3 = Modifier.INSTANCE;
                                            composer3.startReplaceableGroup(-685094361);
                                            ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                            boolean changed5 = composer3.changed(state3);
                                            Object rememberedValue12 = composer3.rememberedValue();
                                            if (changed5 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue12 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                                        invoke2(graphicsLayerScope);
                                                        return Unit.INSTANCE;
                                                    }

                                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                    public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                                                        graphicsLayerScope.setAlpha(state3.getValue().floatValue());
                                                    }
                                                };
                                                composer3.updateRememberedValue(rememberedValue12);
                                            }
                                            composer3.endReplaceableGroup();
                                            Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion3, (Function1) rememberedValue12);
                                            composer3.startReplaceableGroup(-483455358);
                                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                            composer3.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(graphicsLayer);
                                            if (!(composer3.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            composer3.startReusableNode();
                                            if (composer3.getInserting()) {
                                                composer3.createNode(constructor2);
                                            } else {
                                                composer3.useNode();
                                            }
                                            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                            Updater.m3600setimpl(m3593constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                            }
                                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                            composer3.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer3, 1234675075, "C277@13672L46,278@13739L9:SearchBar.android.kt#uh7d8r");
                                            DividerKt.m2181HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors6.getDividerColor(), composer3, 0, 3);
                                            function32.invoke(columnScopeInstance2, composer3, 6);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            ComposerKt.sourceInformationMarkerEnd(composer3);
                                            composer3.endReplaceableGroup();
                                            composer3.endNode();
                                            composer3.endReplaceableGroup();
                                            composer3.endReplaceableGroup();
                                        }
                                        composer3.endReplaceableGroup();
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

                                private static final boolean invoke$lambda$5$lambda$2(State<Boolean> state3) {
                                    return state3.getValue().booleanValue();
                                }
                            }), startRestartGroup, (57344 & i31) | 12582912 | (i31 & 458752), 64);
                            z6 = z9 && FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource4, startRestartGroup, (i30 >> 15) & 14).getValue().booleanValue();
                            Boolean valueOf = Boolean.valueOf(z9);
                            startRestartGroup.startReplaceableGroup(851482799);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                            changed4 = startRestartGroup.changed(z6) | startRestartGroup.changedInstance(focusManager);
                            rememberedValue7 = startRestartGroup.rememberedValue();
                            if (!changed4 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue7 = new SearchBar_androidKt$SearchBar$5$1(z6, focusManager, null);
                                startRestartGroup.updateRememberedValue(rememberedValue7);
                            }
                            startRestartGroup.endReplaceableGroup();
                            int i32 = (i29 >> 9) & 14;
                            EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue7, startRestartGroup, i32);
                            startRestartGroup.startReplaceableGroup(851483127);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                            z7 = (i29 & 57344) == 16384;
                            rememberedValue8 = startRestartGroup.rememberedValue();
                            if (!z7 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue8 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$6$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        function14.invoke(false);
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue8);
                            }
                            startRestartGroup.endReplaceableGroup();
                            BackHandlerKt.BackHandler(z9, (Function0) rememberedValue8, startRestartGroup, i32, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource3 = mutableInteractionSource4;
                            composer2 = startRestartGroup;
                            f5 = f4;
                            f6 = f3;
                            shape4 = shape6;
                            windowInsets4 = windowInsets5;
                            searchBarColors4 = searchBarColors5;
                            function29 = function26;
                            function210 = function27;
                            function211 = function215;
                            z8 = z11;
                            modifier2 = modifier5;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$7
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

                                public final void invoke(Composer composer3, int i33) {
                                    SearchBar_androidKt.m2455SearchBarWuY5d9Q(str, function1, function12, z9, function14, modifier2, z8, function211, function210, function29, shape4, searchBarColors4, f5, f6, windowInsets4, mutableInteractionSource3, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    i18 = i15;
                    if ((i3 & 65536) != 0) {
                    }
                    if ((i12 & 306783379) != 306783378) {
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
                    if (i8 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i3 & 1024) != 0) {
                    }
                    if ((i3 & 2048) != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i18 != 0) {
                    }
                    if ((i3 & 16384) != 0) {
                    }
                    if (i17 != 0) {
                    }
                    shape3 = shape2;
                    function26 = function214;
                    i22 = i19;
                    z4 = z10;
                    f3 = m2450getShadowElevationD9Ej5fM;
                    function27 = function213;
                    modifier4 = modifier3;
                    f4 = m2451getTonalElevationD9Ej5fM;
                    function28 = function212;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, z ? AnimationEnterFloatSpec : AnimationExitFloatSpec, 0.0f, null, null, startRestartGroup, 0, 28);
                    ProvidableCompositionLocal<FocusManager> localFocusManager2 = CompositionLocalsKt.getLocalFocusManager();
                    final boolean z112 = z4;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume3 = startRestartGroup.consume(localFocusManager2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    FocusManager focusManager2 = (FocusManager) consume3;
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume22 = startRestartGroup.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    density = (Density) consume22;
                    inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                    final Function2<? super Composer, ? super Integer, Unit> function2152 = function28;
                    fullScreenShape = SearchBarDefaults.INSTANCE.getFullScreenShape(startRestartGroup, 6);
                    startRestartGroup.startReplaceableGroup(851478497);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    }
                    state = (State) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    boolean SearchBar_WuY5d9Q$lambda$22 = SearchBar_WuY5d9Q$lambda$2(state);
                    startRestartGroup.startReplaceableGroup(851478623);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                    int i292 = i20;
                    changed = startRestartGroup.changed(SearchBar_WuY5d9Q$lambda$22) | ((((i22 & 14) ^ 6) <= 4 && startRestartGroup.changed(shape3)) || (i22 & 6) == 4);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    if (Intrinsics.areEqual(shape3, inputFieldShape)) {
                    }
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    Shape shape52 = (Shape) rememberedValue2;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(851479649);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                    rememberedValue3 = startRestartGroup.rememberedValue();
                    if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    }
                    final MutableWindowInsets mutableWindowInsets2 = (MutableWindowInsets) rememberedValue3;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(851479705);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                    changed2 = startRestartGroup.changed(density);
                    rememberedValue4 = startRestartGroup.rememberedValue();
                    if (!changed2) {
                    }
                    rememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$topPadding$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Dp invoke() {
                            return Dp.m6387boximpl(m2458invokeD9Ej5fM());
                        }

                        /* renamed from: invoke-D9Ej5fM, reason: not valid java name */
                        public final float m2458invokeD9Ej5fM() {
                            return Dp.m6389constructorimpl(SearchBar_androidKt.getSearchBarVerticalPadding() + WindowInsetsKt.asPaddingValues(MutableWindowInsets.this, density).getTop());
                        }
                    });
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                    final State<Dp> state22 = (State) rememberedValue4;
                    startRestartGroup.endReplaceableGroup();
                    long containerColor2 = searchBarColors3.getContainerColor();
                    long m2049contentColorForek8zF_U2 = ColorSchemeKt.m2049contentColorForek8zF_U(searchBarColors3.getContainerColor(), startRestartGroup, 0);
                    Modifier zIndex2 = ZIndexModifierKt.zIndex(modifier4, 1.0f);
                    startRestartGroup.startReplaceableGroup(851480211);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                    if (((57344 & i22) ^ 24576) <= 16384) {
                    }
                    rememberedValue5 = startRestartGroup.rememberedValue();
                    if (!z5) {
                    }
                    rememberedValue5 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets52) {
                            invoke2(windowInsets52);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(WindowInsets windowInsets52) {
                            MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets3, windowInsets52));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                    startRestartGroup.endReplaceableGroup();
                    Modifier consumeWindowInsets2 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(zIndex2, (Function1) rememberedValue5), mutableWindowInsets2);
                    startRestartGroup.startReplaceableGroup(851480395);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                    changed3 = startRestartGroup.changed(state22) | startRestartGroup.changed(animateFloatAsState);
                    rememberedValue6 = startRestartGroup.rememberedValue();
                    if (!changed3) {
                    }
                    rememberedValue6 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                            return m2456invoke3p2s80s(measureScope, measurable, constraints.getValue());
                        }

                        /* renamed from: invoke-3p2s80s, reason: not valid java name */
                        public final MeasureResult m2456invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                            float f7;
                            final int i302 = measureScope.mo624roundToPx0680j_4(DpKt.m6432lerpMdfbLM(state22.getValue().m6403unboximpl(), Dp.m6389constructorimpl(0), animateFloatAsState.getValue().floatValue()));
                            int max = Math.max(Constraints.m6347getMinWidthimpl(j), measureScope.mo624roundToPx0680j_4(SearchBar_androidKt.getSearchBarMinWidth()));
                            int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j);
                            f7 = SearchBar_androidKt.SearchBarMaxWidth;
                            int coerceAtMost = RangesKt.coerceAtMost(max, Math.min(m6345getMaxWidthimpl, measureScope.mo624roundToPx0680j_4(f7)));
                            int coerceAtMost2 = RangesKt.coerceAtMost(Math.max(Constraints.m6346getMinHeightimpl(j), measureScope.mo624roundToPx0680j_4(SearchBarDefaults.INSTANCE.m2449getInputFieldHeightD9Ej5fM())), Constraints.m6344getMaxHeightimpl(j));
                            int m6345getMaxWidthimpl2 = Constraints.m6345getMaxWidthimpl(j);
                            int m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(j);
                            int lerp = MathHelpersKt.lerp(coerceAtMost, m6345getMaxWidthimpl2, animateFloatAsState.getValue().floatValue());
                            int lerp2 = MathHelpersKt.lerp(coerceAtMost2, m6344getMaxHeightimpl, animateFloatAsState.getValue().floatValue()) + i302;
                            final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(ConstraintsKt.m6362offsetNN6EwU$default(Constraints.INSTANCE.m6353fixedJhjzzOo(lerp, lerp2), 0, -i302, 1, null));
                            return MeasureScope.layout$default(measureScope, lerp, lerp2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                    invoke2(placementScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Placeable.PlacementScope placementScope) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, i302, 0.0f, 4, null);
                                }
                            }, 4, null);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                    startRestartGroup.endReplaceableGroup();
                    Modifier layout2 = LayoutModifierKt.layout(consumeWindowInsets2, (Function3) rememberedValue6);
                    int i302 = i22;
                    z9 = z;
                    function14 = function13;
                    Modifier modifier52 = modifier4;
                    Shape shape62 = shape3;
                    final SearchBarColors searchBarColors52 = searchBarColors3;
                    WindowInsets windowInsets52 = windowInsets3;
                    final MutableInteractionSource mutableInteractionSource42 = mutableInteractionSource2;
                    int i312 = i302 << 6;
                    SurfaceKt.m2633SurfaceT9BRK9s(layout2, shape52, containerColor2, m2049contentColorForek8zF_U2, f4, f3, null, ComposableLambdaKt.composableLambda(startRestartGroup, 483163116, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4
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

                        public final void invoke(Composer composer3, int i322) {
                            final State<Float> state3;
                            ComposerKt.sourceInformation(composer3, "C253@12638L1152:SearchBar.android.kt#uh7d8r");
                            if ((i322 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(483163116, i322, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:253)");
                                }
                                String str2 = str;
                                Function1<String, Unit> function15 = function1;
                                Function1<String, Unit> function16 = function12;
                                boolean z12 = z9;
                                Function1<Boolean, Unit> function17 = function14;
                                boolean z13 = z112;
                                Function2<Composer, Integer, Unit> function216 = function2152;
                                Function2<Composer, Integer, Unit> function217 = function27;
                                Function2<Composer, Integer, Unit> function218 = function26;
                                SearchBarColors searchBarColors6 = searchBarColors52;
                                MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource42;
                                State<Float> state4 = animateFloatAsState;
                                State<Dp> state5 = state22;
                                Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                composer3.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                                Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, -685095315, "C254@12691L93,257@12797L590,272@13420L115:SearchBar.android.kt#uh7d8r");
                                composer3.startReplaceableGroup(-685095283);
                                ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                Object rememberedValue10 = composer3.rememberedValue();
                                if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue10 = new AnimatedPaddingValues(state4, state5);
                                    composer3.updateRememberedValue(rememberedValue10);
                                }
                                composer3.endReplaceableGroup();
                                SearchBar_androidKt.SearchBarInputField(str2, function15, function16, z12, function17, PaddingKt.padding(Modifier.INSTANCE, (AnimatedPaddingValues) rememberedValue10), z13, function216, function217, function218, searchBarColors6.getInputFieldColors(), mutableInteractionSource5, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 0);
                                composer3.startReplaceableGroup(-685094554);
                                ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                Object rememberedValue11 = composer3.rememberedValue();
                                if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                    state3 = state4;
                                    rememberedValue11 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$showResults$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            return Boolean.valueOf(state3.getValue().floatValue() > 0.0f);
                                        }
                                    });
                                    composer3.updateRememberedValue(rememberedValue11);
                                } else {
                                    state3 = state4;
                                }
                                composer3.endReplaceableGroup();
                                composer3.startReplaceableGroup(551421253);
                                ComposerKt.sourceInformation(composer3, "276@13613L35,276@13583L183");
                                if (invoke$lambda$5$lambda$2((State) rememberedValue11)) {
                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                    composer3.startReplaceableGroup(-685094361);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                    boolean changed5 = composer3.changed(state3);
                                    Object rememberedValue12 = composer3.rememberedValue();
                                    if (changed5 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue12 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                                invoke2(graphicsLayerScope);
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                            public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                                                graphicsLayerScope.setAlpha(state3.getValue().floatValue());
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue12);
                                    }
                                    composer3.endReplaceableGroup();
                                    Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion3, (Function1) rememberedValue12);
                                    composer3.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(graphicsLayer);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                    Updater.m3600setimpl(m3593constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 1234675075, "C277@13672L46,278@13739L9:SearchBar.android.kt#uh7d8r");
                                    DividerKt.m2181HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors6.getDividerColor(), composer3, 0, 3);
                                    function32.invoke(columnScopeInstance2, composer3, 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                }
                                composer3.endReplaceableGroup();
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

                        private static final boolean invoke$lambda$5$lambda$2(State<Boolean> state3) {
                            return state3.getValue().booleanValue();
                        }
                    }), startRestartGroup, (57344 & i312) | 12582912 | (i312 & 458752), 64);
                    if (z9) {
                    }
                    Boolean valueOf2 = Boolean.valueOf(z9);
                    startRestartGroup.startReplaceableGroup(851482799);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                    changed4 = startRestartGroup.changed(z6) | startRestartGroup.changedInstance(focusManager2);
                    rememberedValue7 = startRestartGroup.rememberedValue();
                    if (!changed4) {
                    }
                    rememberedValue7 = new SearchBar_androidKt$SearchBar$5$1(z6, focusManager2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue7);
                    startRestartGroup.endReplaceableGroup();
                    int i322 = (i292 >> 9) & 14;
                    EffectsKt.LaunchedEffect(valueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue7, startRestartGroup, i322);
                    startRestartGroup.startReplaceableGroup(851483127);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                    if ((i292 & 57344) == 16384) {
                    }
                    rememberedValue8 = startRestartGroup.rememberedValue();
                    if (!z7) {
                    }
                    rememberedValue8 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$6$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function14.invoke(false);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue8);
                    startRestartGroup.endReplaceableGroup();
                    BackHandlerKt.BackHandler(z9, (Function0) rememberedValue8, startRestartGroup, i322, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    mutableInteractionSource3 = mutableInteractionSource42;
                    composer2 = startRestartGroup;
                    f5 = f4;
                    f6 = f3;
                    shape4 = shape62;
                    windowInsets4 = windowInsets52;
                    searchBarColors4 = searchBarColors52;
                    function29 = function26;
                    function210 = function27;
                    function211 = function2152;
                    z8 = z112;
                    modifier2 = modifier52;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i10 = i9;
                if ((i2 & 6) != 0) {
                }
                if ((i2 & 48) == 0) {
                }
                int i262 = i11;
                i12 = i4;
                i13 = i3 & 4096;
                if (i13 == 0) {
                }
                i15 = i3 & 8192;
                if (i15 == 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                i17 = i3 & 32768;
                if (i17 == 0) {
                }
                i18 = i15;
                if ((i3 & 65536) != 0) {
                }
                if ((i12 & 306783379) != 306783378) {
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
                if (i8 != 0) {
                }
                if (i10 != 0) {
                }
                if ((i3 & 1024) != 0) {
                }
                if ((i3 & 2048) != 0) {
                }
                if (i13 != 0) {
                }
                if (i18 != 0) {
                }
                if ((i3 & 16384) != 0) {
                }
                if (i17 != 0) {
                }
                shape3 = shape2;
                function26 = function214;
                i22 = i19;
                z4 = z10;
                f3 = m2450getShadowElevationD9Ej5fM;
                function27 = function213;
                modifier4 = modifier3;
                f4 = m2451getTonalElevationD9Ej5fM;
                function28 = function212;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, z ? AnimationEnterFloatSpec : AnimationExitFloatSpec, 0.0f, null, null, startRestartGroup, 0, 28);
                ProvidableCompositionLocal<FocusManager> localFocusManager22 = CompositionLocalsKt.getLocalFocusManager();
                final boolean z1122 = z4;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume32 = startRestartGroup.consume(localFocusManager22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                FocusManager focusManager22 = (FocusManager) consume32;
                ProvidableCompositionLocal<Density> localDensity22 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume222 = startRestartGroup.consume(localDensity22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                density = (Density) consume222;
                inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
                final Function2<? super Composer, ? super Integer, Unit> function21522 = function28;
                fullScreenShape = SearchBarDefaults.INSTANCE.getFullScreenShape(startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(851478497);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                state = (State) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                boolean SearchBar_WuY5d9Q$lambda$222 = SearchBar_WuY5d9Q$lambda$2(state);
                startRestartGroup.startReplaceableGroup(851478623);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                int i2922 = i20;
                changed = startRestartGroup.changed(SearchBar_WuY5d9Q$lambda$222) | ((((i22 & 14) ^ 6) <= 4 && startRestartGroup.changed(shape3)) || (i22 & 6) == 4);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                if (Intrinsics.areEqual(shape3, inputFieldShape)) {
                }
                startRestartGroup.updateRememberedValue(rememberedValue2);
                Shape shape522 = (Shape) rememberedValue2;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(851479649);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                }
                final MutableWindowInsets mutableWindowInsets22 = (MutableWindowInsets) rememberedValue3;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(851479705);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                changed2 = startRestartGroup.changed(density);
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                rememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$topPadding$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Dp invoke() {
                        return Dp.m6387boximpl(m2458invokeD9Ej5fM());
                    }

                    /* renamed from: invoke-D9Ej5fM, reason: not valid java name */
                    public final float m2458invokeD9Ej5fM() {
                        return Dp.m6389constructorimpl(SearchBar_androidKt.getSearchBarVerticalPadding() + WindowInsetsKt.asPaddingValues(MutableWindowInsets.this, density).getTop());
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue4);
                final State<Dp> state222 = (State) rememberedValue4;
                startRestartGroup.endReplaceableGroup();
                long containerColor22 = searchBarColors3.getContainerColor();
                long m2049contentColorForek8zF_U22 = ColorSchemeKt.m2049contentColorForek8zF_U(searchBarColors3.getContainerColor(), startRestartGroup, 0);
                Modifier zIndex22 = ZIndexModifierKt.zIndex(modifier4, 1.0f);
                startRestartGroup.startReplaceableGroup(851480211);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                if (((57344 & i22) ^ 24576) <= 16384) {
                }
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (!z5) {
                }
                rememberedValue5 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets522) {
                        invoke2(windowInsets522);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(WindowInsets windowInsets522) {
                        MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets3, windowInsets522));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue5);
                startRestartGroup.endReplaceableGroup();
                Modifier consumeWindowInsets22 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(zIndex22, (Function1) rememberedValue5), mutableWindowInsets22);
                startRestartGroup.startReplaceableGroup(851480395);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                changed3 = startRestartGroup.changed(state222) | startRestartGroup.changed(animateFloatAsState);
                rememberedValue6 = startRestartGroup.rememberedValue();
                if (!changed3) {
                }
                rememberedValue6 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                        return m2456invoke3p2s80s(measureScope, measurable, constraints.getValue());
                    }

                    /* renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m2456invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                        float f7;
                        final int i3022 = measureScope.mo624roundToPx0680j_4(DpKt.m6432lerpMdfbLM(state222.getValue().m6403unboximpl(), Dp.m6389constructorimpl(0), animateFloatAsState.getValue().floatValue()));
                        int max = Math.max(Constraints.m6347getMinWidthimpl(j), measureScope.mo624roundToPx0680j_4(SearchBar_androidKt.getSearchBarMinWidth()));
                        int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j);
                        f7 = SearchBar_androidKt.SearchBarMaxWidth;
                        int coerceAtMost = RangesKt.coerceAtMost(max, Math.min(m6345getMaxWidthimpl, measureScope.mo624roundToPx0680j_4(f7)));
                        int coerceAtMost2 = RangesKt.coerceAtMost(Math.max(Constraints.m6346getMinHeightimpl(j), measureScope.mo624roundToPx0680j_4(SearchBarDefaults.INSTANCE.m2449getInputFieldHeightD9Ej5fM())), Constraints.m6344getMaxHeightimpl(j));
                        int m6345getMaxWidthimpl2 = Constraints.m6345getMaxWidthimpl(j);
                        int m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(j);
                        int lerp = MathHelpersKt.lerp(coerceAtMost, m6345getMaxWidthimpl2, animateFloatAsState.getValue().floatValue());
                        int lerp2 = MathHelpersKt.lerp(coerceAtMost2, m6344getMaxHeightimpl, animateFloatAsState.getValue().floatValue()) + i3022;
                        final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(ConstraintsKt.m6362offsetNN6EwU$default(Constraints.INSTANCE.m6353fixedJhjzzOo(lerp, lerp2), 0, -i3022, 1, null));
                        return MeasureScope.layout$default(measureScope, lerp, lerp2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope placementScope) {
                                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, i3022, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue6);
                startRestartGroup.endReplaceableGroup();
                Modifier layout22 = LayoutModifierKt.layout(consumeWindowInsets22, (Function3) rememberedValue6);
                int i3022 = i22;
                z9 = z;
                function14 = function13;
                Modifier modifier522 = modifier4;
                Shape shape622 = shape3;
                final SearchBarColors searchBarColors522 = searchBarColors3;
                WindowInsets windowInsets522 = windowInsets3;
                final MutableInteractionSource mutableInteractionSource422 = mutableInteractionSource2;
                int i3122 = i3022 << 6;
                SurfaceKt.m2633SurfaceT9BRK9s(layout22, shape522, containerColor22, m2049contentColorForek8zF_U22, f4, f3, null, ComposableLambdaKt.composableLambda(startRestartGroup, 483163116, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4
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

                    public final void invoke(Composer composer3, int i3222) {
                        final State<Float> state3;
                        ComposerKt.sourceInformation(composer3, "C253@12638L1152:SearchBar.android.kt#uh7d8r");
                        if ((i3222 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(483163116, i3222, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:253)");
                            }
                            String str2 = str;
                            Function1<String, Unit> function15 = function1;
                            Function1<String, Unit> function16 = function12;
                            boolean z12 = z9;
                            Function1<Boolean, Unit> function17 = function14;
                            boolean z13 = z1122;
                            Function2<Composer, Integer, Unit> function216 = function21522;
                            Function2<Composer, Integer, Unit> function217 = function27;
                            Function2<Composer, Integer, Unit> function218 = function26;
                            SearchBarColors searchBarColors6 = searchBarColors522;
                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource422;
                            State<Float> state4 = animateFloatAsState;
                            State<Dp> state5 = state222;
                            Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                            composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                            Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, -685095315, "C254@12691L93,257@12797L590,272@13420L115:SearchBar.android.kt#uh7d8r");
                            composer3.startReplaceableGroup(-685095283);
                            ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                            Object rememberedValue10 = composer3.rememberedValue();
                            if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue10 = new AnimatedPaddingValues(state4, state5);
                                composer3.updateRememberedValue(rememberedValue10);
                            }
                            composer3.endReplaceableGroup();
                            SearchBar_androidKt.SearchBarInputField(str2, function15, function16, z12, function17, PaddingKt.padding(Modifier.INSTANCE, (AnimatedPaddingValues) rememberedValue10), z13, function216, function217, function218, searchBarColors6.getInputFieldColors(), mutableInteractionSource5, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 0);
                            composer3.startReplaceableGroup(-685094554);
                            ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                            Object rememberedValue11 = composer3.rememberedValue();
                            if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                state3 = state4;
                                rememberedValue11 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$showResults$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        return Boolean.valueOf(state3.getValue().floatValue() > 0.0f);
                                    }
                                });
                                composer3.updateRememberedValue(rememberedValue11);
                            } else {
                                state3 = state4;
                            }
                            composer3.endReplaceableGroup();
                            composer3.startReplaceableGroup(551421253);
                            ComposerKt.sourceInformation(composer3, "276@13613L35,276@13583L183");
                            if (invoke$lambda$5$lambda$2((State) rememberedValue11)) {
                                Modifier.Companion companion3 = Modifier.INSTANCE;
                                composer3.startReplaceableGroup(-685094361);
                                ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                boolean changed5 = composer3.changed(state3);
                                Object rememberedValue12 = composer3.rememberedValue();
                                if (changed5 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue12 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                            invoke2(graphicsLayerScope);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                                            graphicsLayerScope.setAlpha(state3.getValue().floatValue());
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue12);
                                }
                                composer3.endReplaceableGroup();
                                Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion3, (Function1) rememberedValue12);
                                composer3.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(graphicsLayer);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor2);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                Updater.m3600setimpl(m3593constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, 1234675075, "C277@13672L46,278@13739L9:SearchBar.android.kt#uh7d8r");
                                DividerKt.m2181HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors6.getDividerColor(), composer3, 0, 3);
                                function32.invoke(columnScopeInstance2, composer3, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                            }
                            composer3.endReplaceableGroup();
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

                    private static final boolean invoke$lambda$5$lambda$2(State<Boolean> state3) {
                        return state3.getValue().booleanValue();
                    }
                }), startRestartGroup, (57344 & i3122) | 12582912 | (i3122 & 458752), 64);
                if (z9) {
                }
                Boolean valueOf22 = Boolean.valueOf(z9);
                startRestartGroup.startReplaceableGroup(851482799);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                changed4 = startRestartGroup.changed(z6) | startRestartGroup.changedInstance(focusManager22);
                rememberedValue7 = startRestartGroup.rememberedValue();
                if (!changed4) {
                }
                rememberedValue7 = new SearchBar_androidKt$SearchBar$5$1(z6, focusManager22, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
                startRestartGroup.endReplaceableGroup();
                int i3222 = (i2922 >> 9) & 14;
                EffectsKt.LaunchedEffect(valueOf22, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue7, startRestartGroup, i3222);
                startRestartGroup.startReplaceableGroup(851483127);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                if ((i2922 & 57344) == 16384) {
                }
                rememberedValue8 = startRestartGroup.rememberedValue();
                if (!z7) {
                }
                rememberedValue8 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$6$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        function14.invoke(false);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
                startRestartGroup.endReplaceableGroup();
                BackHandlerKt.BackHandler(z9, (Function0) rememberedValue8, startRestartGroup, i3222, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                mutableInteractionSource3 = mutableInteractionSource422;
                composer2 = startRestartGroup;
                f5 = f4;
                f6 = f3;
                shape4 = shape622;
                windowInsets4 = windowInsets522;
                searchBarColors4 = searchBarColors522;
                function29 = function26;
                function210 = function27;
                function211 = function21522;
                z8 = z1122;
                modifier2 = modifier522;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i3 & 8) != 0) {
            }
            int i252 = 8192;
            if ((i3 & 16) != 0) {
            }
            i5 = i3 & 32;
            if (i5 != 0) {
            }
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i3 & 256;
            if (i8 != 0) {
            }
            i9 = i3 & 512;
            if (i9 != 0) {
            }
            i10 = i9;
            if ((i2 & 6) != 0) {
            }
            if ((i2 & 48) == 0) {
            }
            int i2622 = i11;
            i12 = i4;
            i13 = i3 & 4096;
            if (i13 == 0) {
            }
            i15 = i3 & 8192;
            if (i15 == 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            i17 = i3 & 32768;
            if (i17 == 0) {
            }
            i18 = i15;
            if ((i3 & 65536) != 0) {
            }
            if ((i12 & 306783379) != 306783378) {
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
            if (i8 != 0) {
            }
            if (i10 != 0) {
            }
            if ((i3 & 1024) != 0) {
            }
            if ((i3 & 2048) != 0) {
            }
            if (i13 != 0) {
            }
            if (i18 != 0) {
            }
            if ((i3 & 16384) != 0) {
            }
            if (i17 != 0) {
            }
            shape3 = shape2;
            function26 = function214;
            i22 = i19;
            z4 = z10;
            f3 = m2450getShadowElevationD9Ej5fM;
            function27 = function213;
            modifier4 = modifier3;
            f4 = m2451getTonalElevationD9Ej5fM;
            function28 = function212;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, z ? AnimationEnterFloatSpec : AnimationExitFloatSpec, 0.0f, null, null, startRestartGroup, 0, 28);
            ProvidableCompositionLocal<FocusManager> localFocusManager222 = CompositionLocalsKt.getLocalFocusManager();
            final boolean z11222 = z4;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume322 = startRestartGroup.consume(localFocusManager222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FocusManager focusManager222 = (FocusManager) consume322;
            ProvidableCompositionLocal<Density> localDensity222 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2222 = startRestartGroup.consume(localDensity222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            density = (Density) consume2222;
            inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
            final Function2<? super Composer, ? super Integer, Unit> function215222 = function28;
            fullScreenShape = SearchBarDefaults.INSTANCE.getFullScreenShape(startRestartGroup, 6);
            startRestartGroup.startReplaceableGroup(851478497);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            state = (State) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            boolean SearchBar_WuY5d9Q$lambda$2222 = SearchBar_WuY5d9Q$lambda$2(state);
            startRestartGroup.startReplaceableGroup(851478623);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
            int i29222 = i20;
            changed = startRestartGroup.changed(SearchBar_WuY5d9Q$lambda$2222) | ((((i22 & 14) ^ 6) <= 4 && startRestartGroup.changed(shape3)) || (i22 & 6) == 4);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            if (Intrinsics.areEqual(shape3, inputFieldShape)) {
            }
            startRestartGroup.updateRememberedValue(rememberedValue2);
            Shape shape5222 = (Shape) rememberedValue2;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(851479649);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            }
            final MutableWindowInsets mutableWindowInsets222 = (MutableWindowInsets) rememberedValue3;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(851479705);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
            changed2 = startRestartGroup.changed(density);
            rememberedValue4 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            rememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$topPadding$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Dp invoke() {
                    return Dp.m6387boximpl(m2458invokeD9Ej5fM());
                }

                /* renamed from: invoke-D9Ej5fM, reason: not valid java name */
                public final float m2458invokeD9Ej5fM() {
                    return Dp.m6389constructorimpl(SearchBar_androidKt.getSearchBarVerticalPadding() + WindowInsetsKt.asPaddingValues(MutableWindowInsets.this, density).getTop());
                }
            });
            startRestartGroup.updateRememberedValue(rememberedValue4);
            final State<Dp> state2222 = (State) rememberedValue4;
            startRestartGroup.endReplaceableGroup();
            long containerColor222 = searchBarColors3.getContainerColor();
            long m2049contentColorForek8zF_U222 = ColorSchemeKt.m2049contentColorForek8zF_U(searchBarColors3.getContainerColor(), startRestartGroup, 0);
            Modifier zIndex222 = ZIndexModifierKt.zIndex(modifier4, 1.0f);
            startRestartGroup.startReplaceableGroup(851480211);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
            if (((57344 & i22) ^ 24576) <= 16384) {
            }
            rememberedValue5 = startRestartGroup.rememberedValue();
            if (!z5) {
            }
            rememberedValue5 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets5222) {
                    invoke2(windowInsets5222);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(WindowInsets windowInsets5222) {
                    MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets3, windowInsets5222));
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue5);
            startRestartGroup.endReplaceableGroup();
            Modifier consumeWindowInsets222 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(zIndex222, (Function1) rememberedValue5), mutableWindowInsets222);
            startRestartGroup.startReplaceableGroup(851480395);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
            changed3 = startRestartGroup.changed(state2222) | startRestartGroup.changed(animateFloatAsState);
            rememberedValue6 = startRestartGroup.rememberedValue();
            if (!changed3) {
            }
            rememberedValue6 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                    return m2456invoke3p2s80s(measureScope, measurable, constraints.getValue());
                }

                /* renamed from: invoke-3p2s80s, reason: not valid java name */
                public final MeasureResult m2456invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                    float f7;
                    final int i30222 = measureScope.mo624roundToPx0680j_4(DpKt.m6432lerpMdfbLM(state2222.getValue().m6403unboximpl(), Dp.m6389constructorimpl(0), animateFloatAsState.getValue().floatValue()));
                    int max = Math.max(Constraints.m6347getMinWidthimpl(j), measureScope.mo624roundToPx0680j_4(SearchBar_androidKt.getSearchBarMinWidth()));
                    int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j);
                    f7 = SearchBar_androidKt.SearchBarMaxWidth;
                    int coerceAtMost = RangesKt.coerceAtMost(max, Math.min(m6345getMaxWidthimpl, measureScope.mo624roundToPx0680j_4(f7)));
                    int coerceAtMost2 = RangesKt.coerceAtMost(Math.max(Constraints.m6346getMinHeightimpl(j), measureScope.mo624roundToPx0680j_4(SearchBarDefaults.INSTANCE.m2449getInputFieldHeightD9Ej5fM())), Constraints.m6344getMaxHeightimpl(j));
                    int m6345getMaxWidthimpl2 = Constraints.m6345getMaxWidthimpl(j);
                    int m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(j);
                    int lerp = MathHelpersKt.lerp(coerceAtMost, m6345getMaxWidthimpl2, animateFloatAsState.getValue().floatValue());
                    int lerp2 = MathHelpersKt.lerp(coerceAtMost2, m6344getMaxHeightimpl, animateFloatAsState.getValue().floatValue()) + i30222;
                    final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(ConstraintsKt.m6362offsetNN6EwU$default(Constraints.INSTANCE.m6353fixedJhjzzOo(lerp, lerp2), 0, -i30222, 1, null));
                    return MeasureScope.layout$default(measureScope, lerp, lerp2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                            invoke2(placementScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Placeable.PlacementScope placementScope) {
                            Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, i30222, 0.0f, 4, null);
                        }
                    }, 4, null);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue6);
            startRestartGroup.endReplaceableGroup();
            Modifier layout222 = LayoutModifierKt.layout(consumeWindowInsets222, (Function3) rememberedValue6);
            int i30222 = i22;
            z9 = z;
            function14 = function13;
            Modifier modifier5222 = modifier4;
            Shape shape6222 = shape3;
            final SearchBarColors searchBarColors5222 = searchBarColors3;
            WindowInsets windowInsets5222 = windowInsets3;
            final MutableInteractionSource mutableInteractionSource4222 = mutableInteractionSource2;
            int i31222 = i30222 << 6;
            SurfaceKt.m2633SurfaceT9BRK9s(layout222, shape5222, containerColor222, m2049contentColorForek8zF_U222, f4, f3, null, ComposableLambdaKt.composableLambda(startRestartGroup, 483163116, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4
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

                public final void invoke(Composer composer3, int i32222) {
                    final State<Float> state3;
                    ComposerKt.sourceInformation(composer3, "C253@12638L1152:SearchBar.android.kt#uh7d8r");
                    if ((i32222 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(483163116, i32222, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:253)");
                        }
                        String str2 = str;
                        Function1<String, Unit> function15 = function1;
                        Function1<String, Unit> function16 = function12;
                        boolean z12 = z9;
                        Function1<Boolean, Unit> function17 = function14;
                        boolean z13 = z11222;
                        Function2<Composer, Integer, Unit> function216 = function215222;
                        Function2<Composer, Integer, Unit> function217 = function27;
                        Function2<Composer, Integer, Unit> function218 = function26;
                        SearchBarColors searchBarColors6 = searchBarColors5222;
                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4222;
                        State<Float> state4 = animateFloatAsState;
                        State<Dp> state5 = state2222;
                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                        Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, -685095315, "C254@12691L93,257@12797L590,272@13420L115:SearchBar.android.kt#uh7d8r");
                        composer3.startReplaceableGroup(-685095283);
                        ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                        Object rememberedValue10 = composer3.rememberedValue();
                        if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue10 = new AnimatedPaddingValues(state4, state5);
                            composer3.updateRememberedValue(rememberedValue10);
                        }
                        composer3.endReplaceableGroup();
                        SearchBar_androidKt.SearchBarInputField(str2, function15, function16, z12, function17, PaddingKt.padding(Modifier.INSTANCE, (AnimatedPaddingValues) rememberedValue10), z13, function216, function217, function218, searchBarColors6.getInputFieldColors(), mutableInteractionSource5, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 0);
                        composer3.startReplaceableGroup(-685094554);
                        ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                        Object rememberedValue11 = composer3.rememberedValue();
                        if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                            state3 = state4;
                            rememberedValue11 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$showResults$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return Boolean.valueOf(state3.getValue().floatValue() > 0.0f);
                                }
                            });
                            composer3.updateRememberedValue(rememberedValue11);
                        } else {
                            state3 = state4;
                        }
                        composer3.endReplaceableGroup();
                        composer3.startReplaceableGroup(551421253);
                        ComposerKt.sourceInformation(composer3, "276@13613L35,276@13583L183");
                        if (invoke$lambda$5$lambda$2((State) rememberedValue11)) {
                            Modifier.Companion companion3 = Modifier.INSTANCE;
                            composer3.startReplaceableGroup(-685094361);
                            ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                            boolean changed5 = composer3.changed(state3);
                            Object rememberedValue12 = composer3.rememberedValue();
                            if (changed5 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue12 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                        invoke2(graphicsLayerScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                                        graphicsLayerScope.setAlpha(state3.getValue().floatValue());
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue12);
                            }
                            composer3.endReplaceableGroup();
                            Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion3, (Function1) rememberedValue12);
                            composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(graphicsLayer);
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor2);
                            } else {
                                composer3.useNode();
                            }
                            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                            Updater.m3600setimpl(m3593constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 1234675075, "C277@13672L46,278@13739L9:SearchBar.android.kt#uh7d8r");
                            DividerKt.m2181HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors6.getDividerColor(), composer3, 0, 3);
                            function32.invoke(columnScopeInstance2, composer3, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                        }
                        composer3.endReplaceableGroup();
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

                private static final boolean invoke$lambda$5$lambda$2(State<Boolean> state3) {
                    return state3.getValue().booleanValue();
                }
            }), startRestartGroup, (57344 & i31222) | 12582912 | (i31222 & 458752), 64);
            if (z9) {
            }
            Boolean valueOf222 = Boolean.valueOf(z9);
            startRestartGroup.startReplaceableGroup(851482799);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
            changed4 = startRestartGroup.changed(z6) | startRestartGroup.changedInstance(focusManager222);
            rememberedValue7 = startRestartGroup.rememberedValue();
            if (!changed4) {
            }
            rememberedValue7 = new SearchBar_androidKt$SearchBar$5$1(z6, focusManager222, null);
            startRestartGroup.updateRememberedValue(rememberedValue7);
            startRestartGroup.endReplaceableGroup();
            int i32222 = (i29222 >> 9) & 14;
            EffectsKt.LaunchedEffect(valueOf222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue7, startRestartGroup, i32222);
            startRestartGroup.startReplaceableGroup(851483127);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
            if ((i29222 & 57344) == 16384) {
            }
            rememberedValue8 = startRestartGroup.rememberedValue();
            if (!z7) {
            }
            rememberedValue8 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$6$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    function14.invoke(false);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue8);
            startRestartGroup.endReplaceableGroup();
            BackHandlerKt.BackHandler(z9, (Function0) rememberedValue8, startRestartGroup, i32222, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            mutableInteractionSource3 = mutableInteractionSource4222;
            composer2 = startRestartGroup;
            f5 = f4;
            f6 = f3;
            shape4 = shape6222;
            windowInsets4 = windowInsets5222;
            searchBarColors4 = searchBarColors5222;
            function29 = function26;
            function210 = function27;
            function211 = function215222;
            z8 = z11222;
            modifier2 = modifier5222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        if ((i3 & 8) != 0) {
        }
        int i2522 = 8192;
        if ((i3 & 16) != 0) {
        }
        i5 = i3 & 32;
        if (i5 != 0) {
        }
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i3 & 256;
        if (i8 != 0) {
        }
        i9 = i3 & 512;
        if (i9 != 0) {
        }
        i10 = i9;
        if ((i2 & 6) != 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i26222 = i11;
        i12 = i4;
        i13 = i3 & 4096;
        if (i13 == 0) {
        }
        i15 = i3 & 8192;
        if (i15 == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        i17 = i3 & 32768;
        if (i17 == 0) {
        }
        i18 = i15;
        if ((i3 & 65536) != 0) {
        }
        if ((i12 & 306783379) != 306783378) {
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
        if (i8 != 0) {
        }
        if (i10 != 0) {
        }
        if ((i3 & 1024) != 0) {
        }
        if ((i3 & 2048) != 0) {
        }
        if (i13 != 0) {
        }
        if (i18 != 0) {
        }
        if ((i3 & 16384) != 0) {
        }
        if (i17 != 0) {
        }
        shape3 = shape2;
        function26 = function214;
        i22 = i19;
        z4 = z10;
        f3 = m2450getShadowElevationD9Ej5fM;
        function27 = function213;
        modifier4 = modifier3;
        f4 = m2451getTonalElevationD9Ej5fM;
        function28 = function212;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        animateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, z ? AnimationEnterFloatSpec : AnimationExitFloatSpec, 0.0f, null, null, startRestartGroup, 0, 28);
        ProvidableCompositionLocal<FocusManager> localFocusManager2222 = CompositionLocalsKt.getLocalFocusManager();
        final boolean z112222 = z4;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume3222 = startRestartGroup.consume(localFocusManager2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        FocusManager focusManager2222 = (FocusManager) consume3222;
        ProvidableCompositionLocal<Density> localDensity2222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22222 = startRestartGroup.consume(localDensity2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        density = (Density) consume22222;
        inputFieldShape = SearchBarDefaults.INSTANCE.getInputFieldShape(startRestartGroup, 6);
        final Function2<? super Composer, ? super Integer, Unit> function2152222 = function28;
        fullScreenShape = SearchBarDefaults.INSTANCE.getFullScreenShape(startRestartGroup, 6);
        startRestartGroup.startReplaceableGroup(851478497);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        state = (State) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        boolean SearchBar_WuY5d9Q$lambda$22222 = SearchBar_WuY5d9Q$lambda$2(state);
        startRestartGroup.startReplaceableGroup(851478623);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
        int i292222 = i20;
        changed = startRestartGroup.changed(SearchBar_WuY5d9Q$lambda$22222) | ((((i22 & 14) ^ 6) <= 4 && startRestartGroup.changed(shape3)) || (i22 & 6) == 4);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        if (Intrinsics.areEqual(shape3, inputFieldShape)) {
        }
        startRestartGroup.updateRememberedValue(rememberedValue2);
        Shape shape52222 = (Shape) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(851479649);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
        }
        final MutableWindowInsets mutableWindowInsets2222 = (MutableWindowInsets) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(851479705);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
        changed2 = startRestartGroup.changed(density);
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        rememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0<Dp>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$topPadding$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Dp invoke() {
                return Dp.m6387boximpl(m2458invokeD9Ej5fM());
            }

            /* renamed from: invoke-D9Ej5fM, reason: not valid java name */
            public final float m2458invokeD9Ej5fM() {
                return Dp.m6389constructorimpl(SearchBar_androidKt.getSearchBarVerticalPadding() + WindowInsetsKt.asPaddingValues(MutableWindowInsets.this, density).getTop());
            }
        });
        startRestartGroup.updateRememberedValue(rememberedValue4);
        final State<Dp> state22222 = (State) rememberedValue4;
        startRestartGroup.endReplaceableGroup();
        long containerColor2222 = searchBarColors3.getContainerColor();
        long m2049contentColorForek8zF_U2222 = ColorSchemeKt.m2049contentColorForek8zF_U(searchBarColors3.getContainerColor(), startRestartGroup, 0);
        Modifier zIndex2222 = ZIndexModifierKt.zIndex(modifier4, 1.0f);
        startRestartGroup.startReplaceableGroup(851480211);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
        if (((57344 & i22) ^ 24576) <= 16384) {
        }
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        rememberedValue5 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WindowInsets windowInsets52222) {
                invoke2(windowInsets52222);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WindowInsets windowInsets52222) {
                MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(windowInsets3, windowInsets52222));
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue5);
        startRestartGroup.endReplaceableGroup();
        Modifier consumeWindowInsets2222 = WindowInsetsPaddingKt.consumeWindowInsets(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(zIndex2222, (Function1) rememberedValue5), mutableWindowInsets2222);
        startRestartGroup.startReplaceableGroup(851480395);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
        changed3 = startRestartGroup.changed(state22222) | startRestartGroup.changed(animateFloatAsState);
        rememberedValue6 = startRestartGroup.rememberedValue();
        if (!changed3) {
        }
        rememberedValue6 = (Function3) new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ MeasureResult invoke(MeasureScope measureScope, Measurable measurable, Constraints constraints) {
                return m2456invoke3p2s80s(measureScope, measurable, constraints.getValue());
            }

            /* renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m2456invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                float f7;
                final int i302222 = measureScope.mo624roundToPx0680j_4(DpKt.m6432lerpMdfbLM(state22222.getValue().m6403unboximpl(), Dp.m6389constructorimpl(0), animateFloatAsState.getValue().floatValue()));
                int max = Math.max(Constraints.m6347getMinWidthimpl(j), measureScope.mo624roundToPx0680j_4(SearchBar_androidKt.getSearchBarMinWidth()));
                int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j);
                f7 = SearchBar_androidKt.SearchBarMaxWidth;
                int coerceAtMost = RangesKt.coerceAtMost(max, Math.min(m6345getMaxWidthimpl, measureScope.mo624roundToPx0680j_4(f7)));
                int coerceAtMost2 = RangesKt.coerceAtMost(Math.max(Constraints.m6346getMinHeightimpl(j), measureScope.mo624roundToPx0680j_4(SearchBarDefaults.INSTANCE.m2449getInputFieldHeightD9Ej5fM())), Constraints.m6344getMaxHeightimpl(j));
                int m6345getMaxWidthimpl2 = Constraints.m6345getMaxWidthimpl(j);
                int m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(j);
                int lerp = MathHelpersKt.lerp(coerceAtMost, m6345getMaxWidthimpl2, animateFloatAsState.getValue().floatValue());
                int lerp2 = MathHelpersKt.lerp(coerceAtMost2, m6344getMaxHeightimpl, animateFloatAsState.getValue().floatValue()) + i302222;
                final Placeable mo5333measureBRTryo0 = measurable.mo5333measureBRTryo0(ConstraintsKt.m6362offsetNN6EwU$default(Constraints.INSTANCE.m6353fixedJhjzzOo(lerp, lerp2), 0, -i302222, 1, null));
                return MeasureScope.layout$default(measureScope, lerp, lerp2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$3$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                        invoke2(placementScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope placementScope) {
                        Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, i302222, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue6);
        startRestartGroup.endReplaceableGroup();
        Modifier layout2222 = LayoutModifierKt.layout(consumeWindowInsets2222, (Function3) rememberedValue6);
        int i302222 = i22;
        z9 = z;
        function14 = function13;
        Modifier modifier52222 = modifier4;
        Shape shape62222 = shape3;
        final SearchBarColors searchBarColors52222 = searchBarColors3;
        WindowInsets windowInsets52222 = windowInsets3;
        final MutableInteractionSource mutableInteractionSource42222 = mutableInteractionSource2;
        int i312222 = i302222 << 6;
        SurfaceKt.m2633SurfaceT9BRK9s(layout2222, shape52222, containerColor2222, m2049contentColorForek8zF_U2222, f4, f3, null, ComposableLambdaKt.composableLambda(startRestartGroup, 483163116, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4
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

            public final void invoke(Composer composer3, int i322222) {
                final State<Float> state3;
                ComposerKt.sourceInformation(composer3, "C253@12638L1152:SearchBar.android.kt#uh7d8r");
                if ((i322222 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(483163116, i322222, -1, "androidx.compose.material3.SearchBar.<anonymous> (SearchBar.android.kt:253)");
                    }
                    String str2 = str;
                    Function1<String, Unit> function15 = function1;
                    Function1<String, Unit> function16 = function12;
                    boolean z12 = z9;
                    Function1<Boolean, Unit> function17 = function14;
                    boolean z13 = z112222;
                    Function2<Composer, Integer, Unit> function216 = function2152222;
                    Function2<Composer, Integer, Unit> function217 = function27;
                    Function2<Composer, Integer, Unit> function218 = function26;
                    SearchBarColors searchBarColors6 = searchBarColors52222;
                    MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource42222;
                    State<Float> state4 = animateFloatAsState;
                    State<Dp> state5 = state22222;
                    Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                    composer3.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                    composer3.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                    Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                    composer3.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer3, -685095315, "C254@12691L93,257@12797L590,272@13420L115:SearchBar.android.kt#uh7d8r");
                    composer3.startReplaceableGroup(-685095283);
                    ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                    Object rememberedValue10 = composer3.rememberedValue();
                    if (rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue10 = new AnimatedPaddingValues(state4, state5);
                        composer3.updateRememberedValue(rememberedValue10);
                    }
                    composer3.endReplaceableGroup();
                    SearchBar_androidKt.SearchBarInputField(str2, function15, function16, z12, function17, PaddingKt.padding(Modifier.INSTANCE, (AnimatedPaddingValues) rememberedValue10), z13, function216, function217, function218, searchBarColors6.getInputFieldColors(), mutableInteractionSource5, composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 0);
                    composer3.startReplaceableGroup(-685094554);
                    ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                    Object rememberedValue11 = composer3.rememberedValue();
                    if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                        state3 = state4;
                        rememberedValue11 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$showResults$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                return Boolean.valueOf(state3.getValue().floatValue() > 0.0f);
                            }
                        });
                        composer3.updateRememberedValue(rememberedValue11);
                    } else {
                        state3 = state4;
                    }
                    composer3.endReplaceableGroup();
                    composer3.startReplaceableGroup(551421253);
                    ComposerKt.sourceInformation(composer3, "276@13613L35,276@13583L183");
                    if (invoke$lambda$5$lambda$2((State) rememberedValue11)) {
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        composer3.startReplaceableGroup(-685094361);
                        ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                        boolean changed5 = composer3.changed(state3);
                        Object rememberedValue12 = composer3.rememberedValue();
                        if (changed5 || rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue12 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$4$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                                    invoke2(graphicsLayerScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                                    graphicsLayerScope.setAlpha(state3.getValue().floatValue());
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue12);
                        }
                        composer3.endReplaceableGroup();
                        Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(companion3, (Function1) rememberedValue12);
                        composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                        composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(graphicsLayer);
                        if (!(composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor2);
                        } else {
                            composer3.useNode();
                        }
                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                        Updater.m3600setimpl(m3593constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                        composer3.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer3, 1234675075, "C277@13672L46,278@13739L9:SearchBar.android.kt#uh7d8r");
                        DividerKt.m2181HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors6.getDividerColor(), composer3, 0, 3);
                        function32.invoke(columnScopeInstance2, composer3, 6);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceableGroup();
                        composer3.endNode();
                        composer3.endReplaceableGroup();
                        composer3.endReplaceableGroup();
                    }
                    composer3.endReplaceableGroup();
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

            private static final boolean invoke$lambda$5$lambda$2(State<Boolean> state3) {
                return state3.getValue().booleanValue();
            }
        }), startRestartGroup, (57344 & i312222) | 12582912 | (i312222 & 458752), 64);
        if (z9) {
        }
        Boolean valueOf2222 = Boolean.valueOf(z9);
        startRestartGroup.startReplaceableGroup(851482799);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
        changed4 = startRestartGroup.changed(z6) | startRestartGroup.changedInstance(focusManager2222);
        rememberedValue7 = startRestartGroup.rememberedValue();
        if (!changed4) {
        }
        rememberedValue7 = new SearchBar_androidKt$SearchBar$5$1(z6, focusManager2222, null);
        startRestartGroup.updateRememberedValue(rememberedValue7);
        startRestartGroup.endReplaceableGroup();
        int i322222 = (i292222 >> 9) & 14;
        EffectsKt.LaunchedEffect(valueOf2222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue7, startRestartGroup, i322222);
        startRestartGroup.startReplaceableGroup(851483127);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
        if ((i292222 & 57344) == 16384) {
        }
        rememberedValue8 = startRestartGroup.rememberedValue();
        if (!z7) {
        }
        rememberedValue8 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBar$6$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                function14.invoke(false);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue8);
        startRestartGroup.endReplaceableGroup();
        BackHandlerKt.BackHandler(z9, (Function0) rememberedValue8, startRestartGroup, i322222, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        mutableInteractionSource3 = mutableInteractionSource42222;
        composer2 = startRestartGroup;
        f5 = f4;
        f6 = f3;
        shape4 = shape62222;
        windowInsets4 = windowInsets52222;
        searchBarColors4 = searchBarColors52222;
        function29 = function26;
        function210 = function27;
        function211 = function2152222;
        z8 = z112222;
        modifier2 = modifier52222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03aa A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03cb  */
    /* renamed from: DockedSearchBar-eWTbjVg, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2454DockedSearchBareWTbjVg(final String str, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final boolean z, final Function1<? super Boolean, Unit> function13, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Shape shape, SearchBarColors searchBarColors, float f, float f2, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        final boolean z3;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function24;
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
        final Function2<? super Composer, ? super Integer, Unit> function25;
        Shape shape2;
        SearchBarColors searchBarColors2;
        String str2;
        final MutableInteractionSource mutableInteractionSource2;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        float f3;
        int i18;
        float f4;
        Modifier modifier2;
        Shape shape3;
        boolean z4;
        boolean changed;
        SearchBar_androidKt$DockedSearchBar$3$1 rememberedValue;
        boolean z5;
        Object rememberedValue2;
        final SearchBarColors searchBarColors3;
        final MutableInteractionSource mutableInteractionSource3;
        final Shape shape4;
        final float f5;
        final float f6;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        ScopeUpdateScope endRestartGroup;
        int i19;
        int i20;
        Composer startRestartGroup = composer.startRestartGroup(1299054533);
        ComposerKt.sourceInformation(startRestartGroup, "C(DockedSearchBar)P(11,8,9!1,7,6,3,10,5,15,13!1,14:c#ui.unit.Dp,12:c#ui.unit.Dp,4)358@17745L11,359@17806L8,362@17986L39,365@18121L7,370@18228L38,367@18134L1617,413@19791L25,415@19898L292,415@19875L315,424@20226L37,424@20196L67:SearchBar.android.kt#uh7d8r");
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
            i4 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            if ((i3 & 4) == 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                i4 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
                if ((i3 & 8) != 0) {
                    i4 |= 3072;
                } else if ((i & 3072) == 0) {
                    i4 |= startRestartGroup.changed(z) ? 2048 : 1024;
                }
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= startRestartGroup.changedInstance(function13) ? 16384 : 8192;
                }
                i5 = i3 & 32;
                if (i5 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= startRestartGroup.changed(modifier) ? 131072 : 65536;
                }
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                    z3 = z2;
                } else {
                    z3 = z2;
                    if ((i & 1572864) == 0) {
                        i4 |= startRestartGroup.changed(z3) ? 1048576 : 524288;
                    }
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                    function24 = function2;
                } else {
                    function24 = function2;
                    if ((i & 12582912) == 0) {
                        i4 |= startRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
                    }
                }
                i8 = i3 & 256;
                if (i8 != 0) {
                    i4 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                    i4 |= C.ENCODING_PCM_32BIT;
                } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                    i10 = i9;
                    i4 |= startRestartGroup.changedInstance(function23) ? 536870912 : 268435456;
                    if ((i2 & 6) != 0) {
                        if ((i3 & 1024) == 0 && startRestartGroup.changed(shape)) {
                            i20 = 4;
                            i11 = i2 | i20;
                        }
                        i20 = 2;
                        i11 = i2 | i20;
                    } else {
                        i11 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if ((i3 & 2048) == 0 && startRestartGroup.changed(searchBarColors)) {
                            i19 = 32;
                            i11 |= i19;
                        }
                        i19 = 16;
                        i11 |= i19;
                    }
                    int i21 = i11;
                    i12 = i3 & 4096;
                    if (i12 == 0) {
                        i13 = i21 | 384;
                    } else if ((i2 & 384) == 0) {
                        i13 = i21 | (startRestartGroup.changed(f) ? 256 : 128);
                    } else {
                        i13 = i21;
                    }
                    i14 = i3 & 8192;
                    if (i14 == 0) {
                        i15 = i13 | 3072;
                    } else {
                        int i22 = i13;
                        if ((i2 & 3072) == 0) {
                            i22 |= startRestartGroup.changed(f2) ? 2048 : 1024;
                        }
                        i15 = i22;
                    }
                    i16 = i3 & 16384;
                    if (i16 == 0) {
                        i17 = i15 | 24576;
                    } else {
                        i17 = i15;
                        if ((i2 & 24576) == 0) {
                            i17 |= startRestartGroup.changed(mutableInteractionSource) ? 16384 : 8192;
                            if ((i3 & 32768) != 0) {
                                i17 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                            } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                                i17 |= startRestartGroup.changedInstance(function3) ? 131072 : 65536;
                            }
                            if ((i4 & 306783379) != 306783378 && (i17 & 74899) == 74898 && startRestartGroup.getSkipping()) {
                                startRestartGroup.skipToGroupEnd();
                                function28 = function22;
                                shape4 = shape;
                                searchBarColors3 = searchBarColors;
                                f5 = f;
                                f6 = f2;
                                mutableInteractionSource3 = mutableInteractionSource;
                                function29 = function24;
                                function27 = function23;
                            } else {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier;
                                    if (i6 != 0) {
                                        z3 = true;
                                    }
                                    if (i7 != 0) {
                                        function24 = null;
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function210 = i8 != 0 ? null : function22;
                                    function25 = i10 != 0 ? null : function23;
                                    if ((i3 & 1024) != 0) {
                                        shape2 = SearchBarDefaults.INSTANCE.getDockedShape(startRestartGroup, 6);
                                        i17 &= -15;
                                    } else {
                                        shape2 = shape;
                                    }
                                    int i23 = i17;
                                    Modifier modifier3 = companion;
                                    if ((i3 & 2048) != 0) {
                                        searchBarColors2 = SearchBarDefaults.INSTANCE.m2447colorsKlgxPg(0L, 0L, null, startRestartGroup, 3072, 7);
                                        i23 &= -113;
                                    } else {
                                        searchBarColors2 = searchBarColors;
                                    }
                                    int i24 = i23;
                                    float m2451getTonalElevationD9Ej5fM = i12 != 0 ? SearchBarDefaults.INSTANCE.m2451getTonalElevationD9Ej5fM() : f;
                                    float m2450getShadowElevationD9Ej5fM = i14 != 0 ? SearchBarDefaults.INSTANCE.m2450getShadowElevationD9Ej5fM() : f2;
                                    SearchBarColors searchBarColors4 = searchBarColors2;
                                    if (i16 != 0) {
                                        startRestartGroup.startReplaceableGroup(-32072212);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SearchBar.android.kt#9igjgp");
                                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                                        str2 = "CC(remember):SearchBar.android.kt#9igjgp";
                                        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = InteractionSourceKt.MutableInteractionSource();
                                            startRestartGroup.updateRememberedValue(rememberedValue3);
                                        }
                                        startRestartGroup.endReplaceableGroup();
                                        mutableInteractionSource2 = (MutableInteractionSource) rememberedValue3;
                                        function26 = function210;
                                        f3 = m2451getTonalElevationD9Ej5fM;
                                        i18 = i24;
                                        f4 = m2450getShadowElevationD9Ej5fM;
                                        modifier2 = modifier3;
                                        searchBarColors2 = searchBarColors4;
                                    } else {
                                        str2 = "CC(remember):SearchBar.android.kt#9igjgp";
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        function26 = function210;
                                        f3 = m2451getTonalElevationD9Ej5fM;
                                        i18 = i24;
                                        f4 = m2450getShadowElevationD9Ej5fM;
                                        modifier2 = modifier3;
                                    }
                                    shape3 = shape2;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & 1024) != 0) {
                                        i17 &= -15;
                                    }
                                    if ((i3 & 2048) != 0) {
                                        i17 &= -113;
                                    }
                                    modifier2 = modifier;
                                    function26 = function22;
                                    function25 = function23;
                                    shape3 = shape;
                                    searchBarColors2 = searchBarColors;
                                    f3 = f;
                                    f4 = f2;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    str2 = "CC(remember):SearchBar.android.kt#9igjgp";
                                    i18 = i17;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1299054533, i4, i18, "androidx.compose.material3.DockedSearchBar (SearchBar.android.kt:364)");
                                }
                                ProvidableCompositionLocal<FocusManager> localFocusManager = CompositionLocalsKt.getLocalFocusManager();
                                final SearchBarColors searchBarColors5 = searchBarColors2;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(localFocusManager);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                FocusManager focusManager = (FocusManager) consume;
                                long containerColor = searchBarColors5.getContainerColor();
                                int i25 = i18;
                                long m2049contentColorForek8zF_U = ColorSchemeKt.m2049contentColorForek8zF_U(searchBarColors5.getContainerColor(), startRestartGroup, 0);
                                Modifier m933width3ABfNKs = androidx.compose.foundation.layout.SizeKt.m933width3ABfNKs(ZIndexModifierKt.zIndex(modifier2, 1.0f), SearchBarMinWidth);
                                String str3 = str2;
                                int i26 = i4;
                                final Function2<? super Composer, ? super Integer, Unit> function211 = function24;
                                modifier = modifier2;
                                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 1088676554, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2
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

                                    public final void invoke(Composer composer2, int i27) {
                                        EnterTransition enterTransition;
                                        ExitTransition exitTransition;
                                        ComposerKt.sourceInformation(composer2, "C377@18458L1287:SearchBar.android.kt#uh7d8r");
                                        if ((i27 & 3) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1088676554, i27, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:377)");
                                            }
                                            String str4 = str;
                                            Function1<String, Unit> function14 = function1;
                                            Function1<String, Unit> function15 = function12;
                                            boolean z6 = z;
                                            Function1<Boolean, Unit> function16 = function13;
                                            boolean z7 = z3;
                                            Function2<Composer, Integer, Unit> function212 = function211;
                                            Function2<Composer, Integer, Unit> function213 = function26;
                                            Function2<Composer, Integer, Unit> function214 = function25;
                                            final SearchBarColors searchBarColors6 = searchBarColors5;
                                            MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                            final Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                                            composer2.startReplaceableGroup(-483455358);
                                            ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                            Modifier.Companion companion2 = Modifier.INSTANCE;
                                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                                            composer2.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                                            Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                            composer2.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer2, 1253285019, "C378@18479L502,392@18995L740:SearchBar.android.kt#uh7d8r");
                                            SearchBar_androidKt.SearchBarInputField(str4, function14, function15, z6, function16, null, z7, function212, function213, function214, searchBarColors6.getInputFieldColors(), mutableInteractionSource4, composer2, 0, 0, 32);
                                            enterTransition = SearchBar_androidKt.DockedEnterTransition;
                                            exitTransition = SearchBar_androidKt.DockedExitTransition;
                                            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z6, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.composableLambda(composer2, 1804538904, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(3);
                                                }

                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                                    invoke(animatedVisibilityScope, composer3, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i28) {
                                                    ComposerKt.sourceInformation(composer3, "C*397@19211L7,398@19269L115,401@19417L110,405@19545L176:SearchBar.android.kt#uh7d8r");
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1804538904, i28, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:397)");
                                                    }
                                                    ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                                    Object consume2 = composer3.consume(localConfiguration);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    float m6389constructorimpl = Dp.m6389constructorimpl(((Configuration) consume2).screenHeightDp);
                                                    composer3.startReplaceableGroup(747855826);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                                    boolean changed2 = composer3.changed(m6389constructorimpl);
                                                    Object rememberedValue4 = composer3.rememberedValue();
                                                    if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue4 = Dp.m6387boximpl(Dp.m6389constructorimpl(m6389constructorimpl * 0.6666667f));
                                                        composer3.updateRememberedValue(rememberedValue4);
                                                    }
                                                    float m6403unboximpl = ((Dp) rememberedValue4).m6403unboximpl();
                                                    composer3.endReplaceableGroup();
                                                    composer3.startReplaceableGroup(747855974);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                                    boolean changed3 = composer3.changed(m6403unboximpl);
                                                    Object rememberedValue5 = composer3.rememberedValue();
                                                    if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue5 = Dp.m6387boximpl(((Dp) RangesKt.coerceAtMost(Dp.m6387boximpl(SearchBar_androidKt.getDockedActiveTableMinHeight()), Dp.m6387boximpl(m6403unboximpl))).m6403unboximpl());
                                                        composer3.updateRememberedValue(rememberedValue5);
                                                    }
                                                    float m6403unboximpl2 = ((Dp) rememberedValue5).m6403unboximpl();
                                                    composer3.endReplaceableGroup();
                                                    Modifier m915heightInVpY3zN4 = androidx.compose.foundation.layout.SizeKt.m915heightInVpY3zN4(Modifier.INSTANCE, m6403unboximpl2, m6403unboximpl);
                                                    SearchBarColors searchBarColors7 = SearchBarColors.this;
                                                    Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                                    composer3.startReplaceableGroup(-483455358);
                                                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                                    composer3.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m915heightInVpY3zN4);
                                                    if (!(composer3.getApplier() instanceof Applier)) {
                                                        ComposablesKt.invalidApplier();
                                                    }
                                                    composer3.startReusableNode();
                                                    if (composer3.getInserting()) {
                                                        composer3.createNode(constructor2);
                                                    } else {
                                                        composer3.useNode();
                                                    }
                                                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                                    Updater.m3600setimpl(m3593constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                                    }
                                                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                                    composer3.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer3, 1001846745, "C406@19627L46,407@19694L9:SearchBar.android.kt#uh7d8r");
                                                    DividerKt.m2181HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors7.getDividerColor(), composer3, 0, 3);
                                                    function33.invoke(columnScopeInstance2, composer3, 6);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                                    composer3.endReplaceableGroup();
                                                    composer3.endNode();
                                                    composer3.endReplaceableGroup();
                                                    composer3.endReplaceableGroup();
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }), composer2, 1600518, 18);
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
                                });
                                int i27 = i25 << 6;
                                SurfaceKt.m2633SurfaceT9BRK9s(m933width3ABfNKs, shape3, containerColor, m2049contentColorForek8zF_U, f3, f4, null, composableLambda, startRestartGroup, ((i25 << 3) & 112) | 12582912 | (57344 & i27) | (i27 & 458752), 64);
                                z4 = z && FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource2, startRestartGroup, (i25 >> 12) & 14).getValue().booleanValue();
                                Boolean valueOf = Boolean.valueOf(z);
                                startRestartGroup.startReplaceableGroup(-32070300);
                                ComposerKt.sourceInformation(startRestartGroup, str3);
                                changed = startRestartGroup.changed(z4) | startRestartGroup.changedInstance(focusManager);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new SearchBar_androidKt$DockedSearchBar$3$1(z4, focusManager, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                int i28 = (i26 >> 9) & 14;
                                EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, i28);
                                startRestartGroup.startReplaceableGroup(-32069972);
                                ComposerKt.sourceInformation(startRestartGroup, str3);
                                z5 = (i26 & 57344) == 16384;
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!z5 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            function13.invoke(false);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                startRestartGroup.endReplaceableGroup();
                                BackHandlerKt.BackHandler(z, (Function0) rememberedValue2, startRestartGroup, i28, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                searchBarColors3 = searchBarColors5;
                                mutableInteractionSource3 = mutableInteractionSource2;
                                startRestartGroup = startRestartGroup;
                                shape4 = shape3;
                                f5 = f3;
                                f6 = f4;
                                function27 = function25;
                                function28 = function26;
                                function29 = function211;
                            }
                            final boolean z6 = z3;
                            final Modifier modifier4 = modifier;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$5
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

                                    public final void invoke(Composer composer2, int i29) {
                                        SearchBar_androidKt.m2454DockedSearchBareWTbjVg(str, function1, function12, z, function13, modifier4, z6, function29, function28, function27, shape4, searchBarColors3, f5, f6, mutableInteractionSource3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                    }
                    if ((i3 & 32768) != 0) {
                    }
                    if ((i4 & 306783379) != 306783378) {
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
                    if (i8 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i3 & 1024) != 0) {
                    }
                    int i232 = i17;
                    Modifier modifier32 = companion;
                    if ((i3 & 2048) != 0) {
                    }
                    int i242 = i232;
                    if (i12 != 0) {
                    }
                    if (i14 != 0) {
                    }
                    SearchBarColors searchBarColors42 = searchBarColors2;
                    if (i16 != 0) {
                    }
                    shape3 = shape2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal<FocusManager> localFocusManager2 = CompositionLocalsKt.getLocalFocusManager();
                    final SearchBarColors searchBarColors52 = searchBarColors2;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2 = startRestartGroup.consume(localFocusManager2);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    FocusManager focusManager2 = (FocusManager) consume2;
                    long containerColor2 = searchBarColors52.getContainerColor();
                    int i252 = i18;
                    long m2049contentColorForek8zF_U2 = ColorSchemeKt.m2049contentColorForek8zF_U(searchBarColors52.getContainerColor(), startRestartGroup, 0);
                    Modifier m933width3ABfNKs2 = androidx.compose.foundation.layout.SizeKt.m933width3ABfNKs(ZIndexModifierKt.zIndex(modifier2, 1.0f), SearchBarMinWidth);
                    String str32 = str2;
                    int i262 = i4;
                    final Function2<? super Composer, ? super Integer, Unit> function2112 = function24;
                    modifier = modifier2;
                    ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(startRestartGroup, 1088676554, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2
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

                        public final void invoke(Composer composer2, int i272) {
                            EnterTransition enterTransition;
                            ExitTransition exitTransition;
                            ComposerKt.sourceInformation(composer2, "C377@18458L1287:SearchBar.android.kt#uh7d8r");
                            if ((i272 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1088676554, i272, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:377)");
                                }
                                String str4 = str;
                                Function1<String, Unit> function14 = function1;
                                Function1<String, Unit> function15 = function12;
                                boolean z62 = z;
                                Function1<Boolean, Unit> function16 = function13;
                                boolean z7 = z3;
                                Function2<Composer, Integer, Unit> function212 = function2112;
                                Function2<Composer, Integer, Unit> function213 = function26;
                                Function2<Composer, Integer, Unit> function214 = function25;
                                final SearchBarColors searchBarColors6 = searchBarColors52;
                                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                                composer2.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                                Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, 1253285019, "C378@18479L502,392@18995L740:SearchBar.android.kt#uh7d8r");
                                SearchBar_androidKt.SearchBarInputField(str4, function14, function15, z62, function16, null, z7, function212, function213, function214, searchBarColors6.getInputFieldColors(), mutableInteractionSource4, composer2, 0, 0, 32);
                                enterTransition = SearchBar_androidKt.DockedEnterTransition;
                                exitTransition = SearchBar_androidKt.DockedExitTransition;
                                AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z62, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.composableLambda(composer2, 1804538904, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                        invoke(animatedVisibilityScope, composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i282) {
                                        ComposerKt.sourceInformation(composer3, "C*397@19211L7,398@19269L115,401@19417L110,405@19545L176:SearchBar.android.kt#uh7d8r");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1804538904, i282, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:397)");
                                        }
                                        ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                                        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                        Object consume22 = composer3.consume(localConfiguration);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        float m6389constructorimpl = Dp.m6389constructorimpl(((Configuration) consume22).screenHeightDp);
                                        composer3.startReplaceableGroup(747855826);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                        boolean changed2 = composer3.changed(m6389constructorimpl);
                                        Object rememberedValue4 = composer3.rememberedValue();
                                        if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue4 = Dp.m6387boximpl(Dp.m6389constructorimpl(m6389constructorimpl * 0.6666667f));
                                            composer3.updateRememberedValue(rememberedValue4);
                                        }
                                        float m6403unboximpl = ((Dp) rememberedValue4).m6403unboximpl();
                                        composer3.endReplaceableGroup();
                                        composer3.startReplaceableGroup(747855974);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                        boolean changed3 = composer3.changed(m6403unboximpl);
                                        Object rememberedValue5 = composer3.rememberedValue();
                                        if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue5 = Dp.m6387boximpl(((Dp) RangesKt.coerceAtMost(Dp.m6387boximpl(SearchBar_androidKt.getDockedActiveTableMinHeight()), Dp.m6387boximpl(m6403unboximpl))).m6403unboximpl());
                                            composer3.updateRememberedValue(rememberedValue5);
                                        }
                                        float m6403unboximpl2 = ((Dp) rememberedValue5).m6403unboximpl();
                                        composer3.endReplaceableGroup();
                                        Modifier m915heightInVpY3zN4 = androidx.compose.foundation.layout.SizeKt.m915heightInVpY3zN4(Modifier.INSTANCE, m6403unboximpl2, m6403unboximpl);
                                        SearchBarColors searchBarColors7 = SearchBarColors.this;
                                        Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                        composer3.startReplaceableGroup(-483455358);
                                        ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                        composer3.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m915heightInVpY3zN4);
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor2);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                        Updater.m3600setimpl(m3593constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                        composer3.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 1001846745, "C406@19627L46,407@19694L9:SearchBar.android.kt#uh7d8r");
                                        DividerKt.m2181HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors7.getDividerColor(), composer3, 0, 3);
                                        function33.invoke(columnScopeInstance2, composer3, 6);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endReplaceableGroup();
                                        composer3.endNode();
                                        composer3.endReplaceableGroup();
                                        composer3.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }), composer2, 1600518, 18);
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
                    });
                    int i272 = i252 << 6;
                    SurfaceKt.m2633SurfaceT9BRK9s(m933width3ABfNKs2, shape3, containerColor2, m2049contentColorForek8zF_U2, f3, f4, null, composableLambda2, startRestartGroup, ((i252 << 3) & 112) | 12582912 | (57344 & i272) | (i272 & 458752), 64);
                    if (z) {
                    }
                    Boolean valueOf2 = Boolean.valueOf(z);
                    startRestartGroup.startReplaceableGroup(-32070300);
                    ComposerKt.sourceInformation(startRestartGroup, str32);
                    changed = startRestartGroup.changed(z4) | startRestartGroup.changedInstance(focusManager2);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = new SearchBar_androidKt$DockedSearchBar$3$1(z4, focusManager2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    int i282 = (i262 >> 9) & 14;
                    EffectsKt.LaunchedEffect(valueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, i282);
                    startRestartGroup.startReplaceableGroup(-32069972);
                    ComposerKt.sourceInformation(startRestartGroup, str32);
                    if ((i262 & 57344) == 16384) {
                    }
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!z5) {
                    }
                    rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function13.invoke(false);
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    startRestartGroup.endReplaceableGroup();
                    BackHandlerKt.BackHandler(z, (Function0) rememberedValue2, startRestartGroup, i282, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    searchBarColors3 = searchBarColors52;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    startRestartGroup = startRestartGroup;
                    shape4 = shape3;
                    f5 = f3;
                    f6 = f4;
                    function27 = function25;
                    function28 = function26;
                    function29 = function2112;
                    final boolean z62 = z3;
                    final Modifier modifier42 = modifier;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i10 = i9;
                if ((i2 & 6) != 0) {
                }
                if ((i2 & 48) == 0) {
                }
                int i212 = i11;
                i12 = i3 & 4096;
                if (i12 == 0) {
                }
                i14 = i3 & 8192;
                if (i14 == 0) {
                }
                i16 = i3 & 16384;
                if (i16 == 0) {
                }
                if ((i3 & 32768) != 0) {
                }
                if ((i4 & 306783379) != 306783378) {
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
                if (i8 != 0) {
                }
                if (i10 != 0) {
                }
                if ((i3 & 1024) != 0) {
                }
                int i2322 = i17;
                Modifier modifier322 = companion;
                if ((i3 & 2048) != 0) {
                }
                int i2422 = i2322;
                if (i12 != 0) {
                }
                if (i14 != 0) {
                }
                SearchBarColors searchBarColors422 = searchBarColors2;
                if (i16 != 0) {
                }
                shape3 = shape2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ProvidableCompositionLocal<FocusManager> localFocusManager22 = CompositionLocalsKt.getLocalFocusManager();
                final SearchBarColors searchBarColors522 = searchBarColors2;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume22 = startRestartGroup.consume(localFocusManager22);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                FocusManager focusManager22 = (FocusManager) consume22;
                long containerColor22 = searchBarColors522.getContainerColor();
                int i2522 = i18;
                long m2049contentColorForek8zF_U22 = ColorSchemeKt.m2049contentColorForek8zF_U(searchBarColors522.getContainerColor(), startRestartGroup, 0);
                Modifier m933width3ABfNKs22 = androidx.compose.foundation.layout.SizeKt.m933width3ABfNKs(ZIndexModifierKt.zIndex(modifier2, 1.0f), SearchBarMinWidth);
                String str322 = str2;
                int i2622 = i4;
                final Function2<? super Composer, ? super Integer, Unit> function21122 = function24;
                modifier = modifier2;
                ComposableLambda composableLambda22 = ComposableLambdaKt.composableLambda(startRestartGroup, 1088676554, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2
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

                    public final void invoke(Composer composer2, int i2722) {
                        EnterTransition enterTransition;
                        ExitTransition exitTransition;
                        ComposerKt.sourceInformation(composer2, "C377@18458L1287:SearchBar.android.kt#uh7d8r");
                        if ((i2722 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1088676554, i2722, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:377)");
                            }
                            String str4 = str;
                            Function1<String, Unit> function14 = function1;
                            Function1<String, Unit> function15 = function12;
                            boolean z622 = z;
                            Function1<Boolean, Unit> function16 = function13;
                            boolean z7 = z3;
                            Function2<Composer, Integer, Unit> function212 = function21122;
                            Function2<Composer, Integer, Unit> function213 = function26;
                            Function2<Composer, Integer, Unit> function214 = function25;
                            final SearchBarColors searchBarColors6 = searchBarColors522;
                            MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                            final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                            composer2.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            Modifier.Companion companion2 = Modifier.INSTANCE;
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                            Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 1253285019, "C378@18479L502,392@18995L740:SearchBar.android.kt#uh7d8r");
                            SearchBar_androidKt.SearchBarInputField(str4, function14, function15, z622, function16, null, z7, function212, function213, function214, searchBarColors6.getInputFieldColors(), mutableInteractionSource4, composer2, 0, 0, 32);
                            enterTransition = SearchBar_androidKt.DockedEnterTransition;
                            exitTransition = SearchBar_androidKt.DockedExitTransition;
                            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z622, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.composableLambda(composer2, 1804538904, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                    invoke(animatedVisibilityScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i2822) {
                                    ComposerKt.sourceInformation(composer3, "C*397@19211L7,398@19269L115,401@19417L110,405@19545L176:SearchBar.android.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1804538904, i2822, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:397)");
                                    }
                                    ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                    Object consume222 = composer3.consume(localConfiguration);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    float m6389constructorimpl = Dp.m6389constructorimpl(((Configuration) consume222).screenHeightDp);
                                    composer3.startReplaceableGroup(747855826);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                    boolean changed2 = composer3.changed(m6389constructorimpl);
                                    Object rememberedValue4 = composer3.rememberedValue();
                                    if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue4 = Dp.m6387boximpl(Dp.m6389constructorimpl(m6389constructorimpl * 0.6666667f));
                                        composer3.updateRememberedValue(rememberedValue4);
                                    }
                                    float m6403unboximpl = ((Dp) rememberedValue4).m6403unboximpl();
                                    composer3.endReplaceableGroup();
                                    composer3.startReplaceableGroup(747855974);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                    boolean changed3 = composer3.changed(m6403unboximpl);
                                    Object rememberedValue5 = composer3.rememberedValue();
                                    if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue5 = Dp.m6387boximpl(((Dp) RangesKt.coerceAtMost(Dp.m6387boximpl(SearchBar_androidKt.getDockedActiveTableMinHeight()), Dp.m6387boximpl(m6403unboximpl))).m6403unboximpl());
                                        composer3.updateRememberedValue(rememberedValue5);
                                    }
                                    float m6403unboximpl2 = ((Dp) rememberedValue5).m6403unboximpl();
                                    composer3.endReplaceableGroup();
                                    Modifier m915heightInVpY3zN4 = androidx.compose.foundation.layout.SizeKt.m915heightInVpY3zN4(Modifier.INSTANCE, m6403unboximpl2, m6403unboximpl);
                                    SearchBarColors searchBarColors7 = SearchBarColors.this;
                                    Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                    composer3.startReplaceableGroup(-483455358);
                                    ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                    composer3.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                    CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m915heightInVpY3zN4);
                                    if (!(composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer3.startReusableNode();
                                    if (composer3.getInserting()) {
                                        composer3.createNode(constructor2);
                                    } else {
                                        composer3.useNode();
                                    }
                                    Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                    Updater.m3600setimpl(m3593constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                    }
                                    modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                    composer3.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer3, 1001846745, "C406@19627L46,407@19694L9:SearchBar.android.kt#uh7d8r");
                                    DividerKt.m2181HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors7.getDividerColor(), composer3, 0, 3);
                                    function33.invoke(columnScopeInstance2, composer3, 6);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    ComposerKt.sourceInformationMarkerEnd(composer3);
                                    composer3.endReplaceableGroup();
                                    composer3.endNode();
                                    composer3.endReplaceableGroup();
                                    composer3.endReplaceableGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 1600518, 18);
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
                });
                int i2722 = i2522 << 6;
                SurfaceKt.m2633SurfaceT9BRK9s(m933width3ABfNKs22, shape3, containerColor22, m2049contentColorForek8zF_U22, f3, f4, null, composableLambda22, startRestartGroup, ((i2522 << 3) & 112) | 12582912 | (57344 & i2722) | (i2722 & 458752), 64);
                if (z) {
                }
                Boolean valueOf22 = Boolean.valueOf(z);
                startRestartGroup.startReplaceableGroup(-32070300);
                ComposerKt.sourceInformation(startRestartGroup, str322);
                changed = startRestartGroup.changed(z4) | startRestartGroup.changedInstance(focusManager22);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = new SearchBar_androidKt$DockedSearchBar$3$1(z4, focusManager22, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                int i2822 = (i2622 >> 9) & 14;
                EffectsKt.LaunchedEffect(valueOf22, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, i2822);
                startRestartGroup.startReplaceableGroup(-32069972);
                ComposerKt.sourceInformation(startRestartGroup, str322);
                if ((i2622 & 57344) == 16384) {
                }
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!z5) {
                }
                rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        function13.invoke(false);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                BackHandlerKt.BackHandler(z, (Function0) rememberedValue2, startRestartGroup, i2822, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                searchBarColors3 = searchBarColors522;
                mutableInteractionSource3 = mutableInteractionSource2;
                startRestartGroup = startRestartGroup;
                shape4 = shape3;
                f5 = f3;
                f6 = f4;
                function27 = function25;
                function28 = function26;
                function29 = function21122;
                final boolean z622 = z3;
                final Modifier modifier422 = modifier;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i3 & 8) != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            i5 = i3 & 32;
            if (i5 != 0) {
            }
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & 128;
            if (i7 != 0) {
            }
            i8 = i3 & 256;
            if (i8 != 0) {
            }
            i9 = i3 & 512;
            if (i9 != 0) {
            }
            i10 = i9;
            if ((i2 & 6) != 0) {
            }
            if ((i2 & 48) == 0) {
            }
            int i2122 = i11;
            i12 = i3 & 4096;
            if (i12 == 0) {
            }
            i14 = i3 & 8192;
            if (i14 == 0) {
            }
            i16 = i3 & 16384;
            if (i16 == 0) {
            }
            if ((i3 & 32768) != 0) {
            }
            if ((i4 & 306783379) != 306783378) {
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
            if (i8 != 0) {
            }
            if (i10 != 0) {
            }
            if ((i3 & 1024) != 0) {
            }
            int i23222 = i17;
            Modifier modifier3222 = companion;
            if ((i3 & 2048) != 0) {
            }
            int i24222 = i23222;
            if (i12 != 0) {
            }
            if (i14 != 0) {
            }
            SearchBarColors searchBarColors4222 = searchBarColors2;
            if (i16 != 0) {
            }
            shape3 = shape2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal<FocusManager> localFocusManager222 = CompositionLocalsKt.getLocalFocusManager();
            final SearchBarColors searchBarColors5222 = searchBarColors2;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume222 = startRestartGroup.consume(localFocusManager222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            FocusManager focusManager222 = (FocusManager) consume222;
            long containerColor222 = searchBarColors5222.getContainerColor();
            int i25222 = i18;
            long m2049contentColorForek8zF_U222 = ColorSchemeKt.m2049contentColorForek8zF_U(searchBarColors5222.getContainerColor(), startRestartGroup, 0);
            Modifier m933width3ABfNKs222 = androidx.compose.foundation.layout.SizeKt.m933width3ABfNKs(ZIndexModifierKt.zIndex(modifier2, 1.0f), SearchBarMinWidth);
            String str3222 = str2;
            int i26222 = i4;
            final Function2<? super Composer, ? super Integer, Unit> function211222 = function24;
            modifier = modifier2;
            ComposableLambda composableLambda222 = ComposableLambdaKt.composableLambda(startRestartGroup, 1088676554, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2
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

                public final void invoke(Composer composer2, int i27222) {
                    EnterTransition enterTransition;
                    ExitTransition exitTransition;
                    ComposerKt.sourceInformation(composer2, "C377@18458L1287:SearchBar.android.kt#uh7d8r");
                    if ((i27222 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1088676554, i27222, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:377)");
                        }
                        String str4 = str;
                        Function1<String, Unit> function14 = function1;
                        Function1<String, Unit> function15 = function12;
                        boolean z6222 = z;
                        Function1<Boolean, Unit> function16 = function13;
                        boolean z7 = z3;
                        Function2<Composer, Integer, Unit> function212 = function211222;
                        Function2<Composer, Integer, Unit> function213 = function26;
                        Function2<Composer, Integer, Unit> function214 = function25;
                        final SearchBarColors searchBarColors6 = searchBarColors5222;
                        MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                        composer2.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                        Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1253285019, "C378@18479L502,392@18995L740:SearchBar.android.kt#uh7d8r");
                        SearchBar_androidKt.SearchBarInputField(str4, function14, function15, z6222, function16, null, z7, function212, function213, function214, searchBarColors6.getInputFieldColors(), mutableInteractionSource4, composer2, 0, 0, 32);
                        enterTransition = SearchBar_androidKt.DockedEnterTransition;
                        exitTransition = SearchBar_androidKt.DockedExitTransition;
                        AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z6222, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.composableLambda(composer2, 1804538904, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                                invoke(animatedVisibilityScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i28222) {
                                ComposerKt.sourceInformation(composer3, "C*397@19211L7,398@19269L115,401@19417L110,405@19545L176:SearchBar.android.kt#uh7d8r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1804538904, i28222, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:397)");
                                }
                                ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                                ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume2222 = composer3.consume(localConfiguration);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                float m6389constructorimpl = Dp.m6389constructorimpl(((Configuration) consume2222).screenHeightDp);
                                composer3.startReplaceableGroup(747855826);
                                ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                boolean changed2 = composer3.changed(m6389constructorimpl);
                                Object rememberedValue4 = composer3.rememberedValue();
                                if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = Dp.m6387boximpl(Dp.m6389constructorimpl(m6389constructorimpl * 0.6666667f));
                                    composer3.updateRememberedValue(rememberedValue4);
                                }
                                float m6403unboximpl = ((Dp) rememberedValue4).m6403unboximpl();
                                composer3.endReplaceableGroup();
                                composer3.startReplaceableGroup(747855974);
                                ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                                boolean changed3 = composer3.changed(m6403unboximpl);
                                Object rememberedValue5 = composer3.rememberedValue();
                                if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue5 = Dp.m6387boximpl(((Dp) RangesKt.coerceAtMost(Dp.m6387boximpl(SearchBar_androidKt.getDockedActiveTableMinHeight()), Dp.m6387boximpl(m6403unboximpl))).m6403unboximpl());
                                    composer3.updateRememberedValue(rememberedValue5);
                                }
                                float m6403unboximpl2 = ((Dp) rememberedValue5).m6403unboximpl();
                                composer3.endReplaceableGroup();
                                Modifier m915heightInVpY3zN4 = androidx.compose.foundation.layout.SizeKt.m915heightInVpY3zN4(Modifier.INSTANCE, m6403unboximpl2, m6403unboximpl);
                                SearchBarColors searchBarColors7 = SearchBarColors.this;
                                Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                                composer3.startReplaceableGroup(-483455358);
                                ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                composer3.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m915heightInVpY3zN4);
                                if (!(composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(constructor2);
                                } else {
                                    composer3.useNode();
                                }
                                Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                                Updater.m3600setimpl(m3593constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                    m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                }
                                modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                                composer3.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer3, 1001846745, "C406@19627L46,407@19694L9:SearchBar.android.kt#uh7d8r");
                                DividerKt.m2181HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors7.getDividerColor(), composer3, 0, 3);
                                function33.invoke(columnScopeInstance2, composer3, 6);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceableGroup();
                                composer3.endNode();
                                composer3.endReplaceableGroup();
                                composer3.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), composer2, 1600518, 18);
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
            });
            int i27222 = i25222 << 6;
            SurfaceKt.m2633SurfaceT9BRK9s(m933width3ABfNKs222, shape3, containerColor222, m2049contentColorForek8zF_U222, f3, f4, null, composableLambda222, startRestartGroup, ((i25222 << 3) & 112) | 12582912 | (57344 & i27222) | (i27222 & 458752), 64);
            if (z) {
            }
            Boolean valueOf222 = Boolean.valueOf(z);
            startRestartGroup.startReplaceableGroup(-32070300);
            ComposerKt.sourceInformation(startRestartGroup, str3222);
            changed = startRestartGroup.changed(z4) | startRestartGroup.changedInstance(focusManager222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = new SearchBar_androidKt$DockedSearchBar$3$1(z4, focusManager222, null);
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            int i28222 = (i26222 >> 9) & 14;
            EffectsKt.LaunchedEffect(valueOf222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, i28222);
            startRestartGroup.startReplaceableGroup(-32069972);
            ComposerKt.sourceInformation(startRestartGroup, str3222);
            if ((i26222 & 57344) == 16384) {
            }
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!z5) {
            }
            rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    function13.invoke(false);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            BackHandlerKt.BackHandler(z, (Function0) rememberedValue2, startRestartGroup, i28222, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            searchBarColors3 = searchBarColors5222;
            mutableInteractionSource3 = mutableInteractionSource2;
            startRestartGroup = startRestartGroup;
            shape4 = shape3;
            f5 = f3;
            f6 = f4;
            function27 = function25;
            function28 = function26;
            function29 = function211222;
            final boolean z6222 = z3;
            final Modifier modifier4222 = modifier;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        i5 = i3 & 32;
        if (i5 != 0) {
        }
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & 128;
        if (i7 != 0) {
        }
        i8 = i3 & 256;
        if (i8 != 0) {
        }
        i9 = i3 & 512;
        if (i9 != 0) {
        }
        i10 = i9;
        if ((i2 & 6) != 0) {
        }
        if ((i2 & 48) == 0) {
        }
        int i21222 = i11;
        i12 = i3 & 4096;
        if (i12 == 0) {
        }
        i14 = i3 & 8192;
        if (i14 == 0) {
        }
        i16 = i3 & 16384;
        if (i16 == 0) {
        }
        if ((i3 & 32768) != 0) {
        }
        if ((i4 & 306783379) != 306783378) {
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
        if (i8 != 0) {
        }
        if (i10 != 0) {
        }
        if ((i3 & 1024) != 0) {
        }
        int i232222 = i17;
        Modifier modifier32222 = companion;
        if ((i3 & 2048) != 0) {
        }
        int i242222 = i232222;
        if (i12 != 0) {
        }
        if (i14 != 0) {
        }
        SearchBarColors searchBarColors42222 = searchBarColors2;
        if (i16 != 0) {
        }
        shape3 = shape2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal<FocusManager> localFocusManager2222 = CompositionLocalsKt.getLocalFocusManager();
        final SearchBarColors searchBarColors52222 = searchBarColors2;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume2222 = startRestartGroup.consume(localFocusManager2222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        FocusManager focusManager2222 = (FocusManager) consume2222;
        long containerColor2222 = searchBarColors52222.getContainerColor();
        int i252222 = i18;
        long m2049contentColorForek8zF_U2222 = ColorSchemeKt.m2049contentColorForek8zF_U(searchBarColors52222.getContainerColor(), startRestartGroup, 0);
        Modifier m933width3ABfNKs2222 = androidx.compose.foundation.layout.SizeKt.m933width3ABfNKs(ZIndexModifierKt.zIndex(modifier2, 1.0f), SearchBarMinWidth);
        String str32222 = str2;
        int i262222 = i4;
        final Function2<? super Composer, ? super Integer, Unit> function2112222 = function24;
        modifier = modifier2;
        ComposableLambda composableLambda2222 = ComposableLambdaKt.composableLambda(startRestartGroup, 1088676554, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2
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

            public final void invoke(Composer composer2, int i272222) {
                EnterTransition enterTransition;
                ExitTransition exitTransition;
                ComposerKt.sourceInformation(composer2, "C377@18458L1287:SearchBar.android.kt#uh7d8r");
                if ((i272222 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1088676554, i272222, -1, "androidx.compose.material3.DockedSearchBar.<anonymous> (SearchBar.android.kt:377)");
                    }
                    String str4 = str;
                    Function1<String, Unit> function14 = function1;
                    Function1<String, Unit> function15 = function12;
                    boolean z62222 = z;
                    Function1<Boolean, Unit> function16 = function13;
                    boolean z7 = z3;
                    Function2<Composer, Integer, Unit> function212 = function2112222;
                    Function2<Composer, Integer, Unit> function213 = function26;
                    Function2<Composer, Integer, Unit> function214 = function25;
                    final SearchBarColors searchBarColors6 = searchBarColors52222;
                    MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                    final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function32 = function3;
                    composer2.startReplaceableGroup(-483455358);
                    ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion2);
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
                    Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1253285019, "C378@18479L502,392@18995L740:SearchBar.android.kt#uh7d8r");
                    SearchBar_androidKt.SearchBarInputField(str4, function14, function15, z62222, function16, null, z7, function212, function213, function214, searchBarColors6.getInputFieldColors(), mutableInteractionSource4, composer2, 0, 0, 32);
                    enterTransition = SearchBar_androidKt.DockedEnterTransition;
                    exitTransition = SearchBar_androidKt.DockedExitTransition;
                    AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z62222, (Modifier) null, enterTransition, exitTransition, (String) null, ComposableLambdaKt.composableLambda(composer2, 1804538904, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, Integer num) {
                            invoke(animatedVisibilityScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer3, int i282222) {
                            ComposerKt.sourceInformation(composer3, "C*397@19211L7,398@19269L115,401@19417L110,405@19545L176:SearchBar.android.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1804538904, i282222, -1, "androidx.compose.material3.DockedSearchBar.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:397)");
                            }
                            ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume22222 = composer3.consume(localConfiguration);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            float m6389constructorimpl = Dp.m6389constructorimpl(((Configuration) consume22222).screenHeightDp);
                            composer3.startReplaceableGroup(747855826);
                            ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                            boolean changed2 = composer3.changed(m6389constructorimpl);
                            Object rememberedValue4 = composer3.rememberedValue();
                            if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = Dp.m6387boximpl(Dp.m6389constructorimpl(m6389constructorimpl * 0.6666667f));
                                composer3.updateRememberedValue(rememberedValue4);
                            }
                            float m6403unboximpl = ((Dp) rememberedValue4).m6403unboximpl();
                            composer3.endReplaceableGroup();
                            composer3.startReplaceableGroup(747855974);
                            ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                            boolean changed3 = composer3.changed(m6403unboximpl);
                            Object rememberedValue5 = composer3.rememberedValue();
                            if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue5 = Dp.m6387boximpl(((Dp) RangesKt.coerceAtMost(Dp.m6387boximpl(SearchBar_androidKt.getDockedActiveTableMinHeight()), Dp.m6387boximpl(m6403unboximpl))).m6403unboximpl());
                                composer3.updateRememberedValue(rememberedValue5);
                            }
                            float m6403unboximpl2 = ((Dp) rememberedValue5).m6403unboximpl();
                            composer3.endReplaceableGroup();
                            Modifier m915heightInVpY3zN4 = androidx.compose.foundation.layout.SizeKt.m915heightInVpY3zN4(Modifier.INSTANCE, m6403unboximpl2, m6403unboximpl);
                            SearchBarColors searchBarColors7 = SearchBarColors.this;
                            Function3<ColumnScope, Composer, Integer, Unit> function33 = function32;
                            composer3.startReplaceableGroup(-483455358);
                            ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                            composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m915heightInVpY3zN4);
                            if (!(composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer3.startReusableNode();
                            if (composer3.getInserting()) {
                                composer3.createNode(constructor2);
                            } else {
                                composer3.useNode();
                            }
                            Composer m3593constructorimpl2 = Updater.m3593constructorimpl(composer3);
                            Updater.m3600setimpl(m3593constructorimpl2, columnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl2.getInserting() || !Intrinsics.areEqual(m3593constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m3593constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m3593constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer3)), composer3, 0);
                            composer3.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer3, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer3, 1001846745, "C406@19627L46,407@19694L9:SearchBar.android.kt#uh7d8r");
                            DividerKt.m2181HorizontalDivider9IZ8Weo(null, 0.0f, searchBarColors7.getDividerColor(), composer3, 0, 3);
                            function33.invoke(columnScopeInstance2, composer3, 6);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceableGroup();
                            composer3.endNode();
                            composer3.endReplaceableGroup();
                            composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), composer2, 1600518, 18);
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
        });
        int i272222 = i252222 << 6;
        SurfaceKt.m2633SurfaceT9BRK9s(m933width3ABfNKs2222, shape3, containerColor2222, m2049contentColorForek8zF_U2222, f3, f4, null, composableLambda2222, startRestartGroup, ((i252222 << 3) & 112) | 12582912 | (57344 & i272222) | (i272222 & 458752), 64);
        if (z) {
        }
        Boolean valueOf2222 = Boolean.valueOf(z);
        startRestartGroup.startReplaceableGroup(-32070300);
        ComposerKt.sourceInformation(startRestartGroup, str32222);
        changed = startRestartGroup.changed(z4) | startRestartGroup.changedInstance(focusManager2222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = new SearchBar_androidKt$DockedSearchBar$3$1(z4, focusManager2222, null);
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        int i282222 = (i262222 >> 9) & 14;
        EffectsKt.LaunchedEffect(valueOf2222, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue, startRestartGroup, i282222);
        startRestartGroup.startReplaceableGroup(-32069972);
        ComposerKt.sourceInformation(startRestartGroup, str32222);
        if ((i262222 & 57344) == 16384) {
        }
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!z5) {
        }
        rememberedValue2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$DockedSearchBar$4$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                function13.invoke(false);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        BackHandlerKt.BackHandler(z, (Function0) rememberedValue2, startRestartGroup, i282222, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        searchBarColors3 = searchBarColors52222;
        mutableInteractionSource3 = mutableInteractionSource2;
        startRestartGroup = startRestartGroup;
        shape4 = shape3;
        f5 = f3;
        f6 = f4;
        function27 = function25;
        function28 = function26;
        function29 = function2112222;
        final boolean z62222 = z3;
        final Modifier modifier42222 = modifier;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x051f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0495  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SearchBarInputField(final String str, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final boolean z, final Function1<? super Boolean, Unit> function13, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, TextFieldColors textFieldColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z3;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        MutableInteractionSource mutableInteractionSource2;
        int i15;
        Function2<? super Composer, ? super Integer, Unit> function25;
        Function2<? super Composer, ? super Integer, Unit> function26;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Modifier modifier3;
        Composer composer2;
        int i16;
        int i17;
        TextFieldColors textFieldColors2;
        MutableInteractionSource mutableInteractionSource3;
        TextFieldColors textFieldColors3;
        int i18;
        Modifier modifier4;
        Object rememberedValue;
        long m5918getColor0d7_KjU;
        TextFieldColors textFieldColors4;
        boolean z4;
        Composer composer3;
        long m4073unboximpl;
        boolean z5;
        Object rememberedValue2;
        boolean changed;
        Object rememberedValue3;
        boolean z6;
        Object rememberedValue4;
        Composer composer4;
        final MutableInteractionSource mutableInteractionSource4;
        final TextFieldColors textFieldColors5;
        final Modifier modifier5;
        final boolean z7;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        ScopeUpdateScope endRestartGroup;
        int i19;
        Composer startRestartGroup = composer.startRestartGroup(496394889);
        ComposerKt.sourceInformation(startRestartGroup, "C(SearchBarInputField)P(10,7,8!1,6,5,2,9,4,11)442@20766L18,443@20836L39,445@20906L29,446@20962L34,447@21037L39,459@21490L42,460@21556L304,472@21951L7,473@22036L28,475@22199L19,452@21246L2004:SearchBar.android.kt#uh7d8r");
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
            i4 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            if ((i3 & 4) == 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                i4 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
            }
            if ((i3 & 8) == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(z) ? 2048 : 1024;
            }
            if ((i3 & 16) == 0) {
                i4 |= 24576;
            } else if ((i & 24576) == 0) {
                i4 |= startRestartGroup.changedInstance(function13) ? 16384 : 8192;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                modifier2 = modifier;
            } else {
                modifier2 = modifier;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    i4 |= startRestartGroup.changed(modifier2) ? 131072 : 65536;
                }
            }
            i6 = i3 & 64;
            if (i6 == 0) {
                i4 |= 1572864;
                z3 = z2;
            } else {
                z3 = z2;
                if ((i & 1572864) == 0) {
                    i4 |= startRestartGroup.changed(z3) ? 1048576 : 524288;
                }
            }
            i7 = i3 & 128;
            if (i7 == 0) {
                i4 |= 12582912;
                function24 = function2;
            } else {
                function24 = function2;
                if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
                }
            }
            i8 = i3 & 256;
            if (i8 == 0) {
                i4 |= 100663296;
            } else if ((i & 100663296) == 0) {
                i4 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
            }
            i9 = i3 & 512;
            if (i9 == 0) {
                i4 |= C.ENCODING_PCM_32BIT;
            } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                i10 = i9;
                i4 |= startRestartGroup.changedInstance(function23) ? 536870912 : 268435456;
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0 && startRestartGroup.changed(textFieldColors)) {
                        i19 = 4;
                        i11 = i2 | i19;
                    }
                    i19 = 2;
                    i11 = i2 | i19;
                } else {
                    i11 = i2;
                }
                i12 = i4;
                i13 = i3 & 2048;
                if (i13 != 0) {
                    i14 = i13;
                    i15 = i11 | 48;
                    mutableInteractionSource2 = mutableInteractionSource;
                } else {
                    if ((i2 & 48) == 0) {
                        i14 = i13;
                        mutableInteractionSource2 = mutableInteractionSource;
                        i11 |= startRestartGroup.changed(mutableInteractionSource2) ? 32 : 16;
                    } else {
                        i14 = i13;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    i15 = i11;
                }
                if ((i12 & 306783379) != 306783378 && (i15 & 19) == 18 && startRestartGroup.getSkipping()) {
                    startRestartGroup.skipToGroupEnd();
                    textFieldColors5 = textFieldColors;
                    composer4 = startRestartGroup;
                    mutableInteractionSource4 = mutableInteractionSource2;
                    modifier5 = modifier2;
                    z7 = z3;
                    function28 = function24;
                    function29 = function22;
                    function210 = function23;
                } else {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        Modifier.Companion companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                        boolean z8 = i6 != 0 ? true : z3;
                        function25 = i7 != 0 ? null : function24;
                        function26 = i8 != 0 ? null : function22;
                        function27 = i10 != 0 ? null : function23;
                        if ((i3 & 1024) != 0) {
                            i17 = i14;
                            modifier3 = companion;
                            i16 = i12;
                            textFieldColors2 = SearchBarDefaults.INSTANCE.m2453inputFieldColorsITpI4ow(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 0, 24576, 16383);
                            composer2 = startRestartGroup;
                            i15 &= -15;
                        } else {
                            modifier3 = companion;
                            composer2 = startRestartGroup;
                            i16 = i12;
                            i17 = i14;
                            textFieldColors2 = textFieldColors;
                        }
                        if (i17 != 0) {
                            composer2.startReplaceableGroup(462567468);
                            ComposerKt.sourceInformation(composer2, "CC(remember):SearchBar.android.kt#9igjgp");
                            Object rememberedValue5 = composer2.rememberedValue();
                            if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                                composer2.updateRememberedValue(rememberedValue5);
                            }
                            composer2.endReplaceableGroup();
                            mutableInteractionSource3 = (MutableInteractionSource) rememberedValue5;
                            i18 = i15;
                            z3 = z8;
                            textFieldColors3 = textFieldColors2;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                            textFieldColors3 = textFieldColors2;
                            i18 = i15;
                            z3 = z8;
                        }
                        modifier4 = modifier3;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i3 & 1024) != 0) {
                            i15 &= -15;
                        }
                        function26 = function22;
                        function27 = function23;
                        composer2 = startRestartGroup;
                        modifier4 = modifier2;
                        function25 = function24;
                        i16 = i12;
                        i18 = i15;
                        textFieldColors3 = textFieldColors;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(496394889, i16, i18, "androidx.compose.material3.SearchBarInputField (SearchBar.android.kt:444)");
                    }
                    composer2.startReplaceableGroup(462567538);
                    ComposerKt.sourceInformation(composer2, "CC(remember):SearchBar.android.kt#9igjgp");
                    rememberedValue = composer2.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = new FocusRequester();
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    final FocusRequester focusRequester = (FocusRequester) rememberedValue;
                    composer2.endReplaceableGroup();
                    Strings.Companion companion2 = Strings.INSTANCE;
                    final String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_search_bar_search), composer2, 0);
                    Strings.Companion companion3 = Strings.INSTANCE;
                    final String m2623getStringNWtq282 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_suggestions_available), composer2, 0);
                    composer2.startReplaceableGroup(462567758);
                    ComposerKt.sourceInformation(composer2, "*448@21112L7,449@21154L74");
                    ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
                    TextFieldColors textFieldColors6 = textFieldColors3;
                    boolean z9 = z3;
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume = composer2.consume(localTextStyle);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    m5918getColor0d7_KjU = ((TextStyle) consume).m5918getColor0d7_KjU();
                    if (m5918getColor0d7_KjU != Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                        z4 = z9;
                        m4073unboximpl = m5918getColor0d7_KjU;
                        textFieldColors4 = textFieldColors6;
                        composer3 = composer2;
                    } else {
                        Composer composer5 = composer2;
                        textFieldColors4 = textFieldColors6;
                        z4 = z9;
                        composer3 = composer5;
                        m4073unboximpl = textFieldColors6.textColor$material3_release(z9, false, mutableInteractionSource3, composer5, ((i16 >> 18) & 14) | 48 | ((i18 << 3) & 896) | ((i18 << 9) & 7168)).getValue().m4073unboximpl();
                    }
                    composer3.endReplaceableGroup();
                    Modifier modifier6 = modifier4;
                    int i20 = i18;
                    Modifier focusRequester2 = FocusRequesterModifierKt.focusRequester(androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(androidx.compose.foundation.layout.SizeKt.m914height3ABfNKs(modifier4, SearchBarDefaults.INSTANCE.m2449getInputFieldHeightD9Ej5fM()), 0.0f, 1, null), focusRequester);
                    composer3.startReplaceableGroup(462568122);
                    ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                    z5 = (57344 & i16) == 16384;
                    rememberedValue2 = composer3.rememberedValue();
                    if (!z5 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = (Function1) new Function1<FocusState, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                                invoke2(focusState);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(FocusState focusState) {
                                if (focusState.isFocused()) {
                                    function13.invoke(true);
                                }
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue2);
                    }
                    composer3.endReplaceableGroup();
                    Modifier onFocusChanged = FocusChangedModifierKt.onFocusChanged(focusRequester2, (Function1) rememberedValue2);
                    composer3.startReplaceableGroup(462568188);
                    ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                    changed = composer3.changed(m2623getStringNWtq28) | ((i16 & 7168) == 2048) | composer3.changed(m2623getStringNWtq282);
                    rememberedValue3 = composer3.rememberedValue();
                    if (!changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m2623getStringNWtq28);
                                if (z) {
                                    SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, m2623getStringNWtq282);
                                }
                                final FocusRequester focusRequester3 = focusRequester;
                                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$3$1.1
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        FocusRequester.this.requestFocus();
                                        return true;
                                    }
                                }, 1, null);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceableGroup();
                    Modifier semantics$default = SemanticsModifierKt.semantics$default(onFocusChanged, false, (Function1) rememberedValue3, 1, null);
                    ProvidableCompositionLocal<TextStyle> localTextStyle2 = TextKt.getLocalTextStyle();
                    ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume2 = composer3.consume(localTextStyle2);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    TextStyle merge = ((TextStyle) consume2).merge(new TextStyle(m4073unboximpl, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
                    SolidColor solidColor = new SolidColor(textFieldColors4.cursorColor$material3_release(false, composer3, ((i20 << 3) & 112) | 6).getValue().m4073unboximpl(), null);
                    KeyboardOptions keyboardOptions = new KeyboardOptions(0, false, 0, ImeAction.INSTANCE.m6070getSearcheUduSuo(), null, 23, null);
                    composer3.startReplaceableGroup(462568831);
                    ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
                    int i21 = i16 & 14;
                    z6 = ((i16 & 896) == 256) | (i21 == 4);
                    rememberedValue4 = composer3.rememberedValue();
                    if (!z6 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = (Function1) new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                                invoke2(keyboardActionScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(KeyboardActionScope keyboardActionScope) {
                                function12.invoke(str);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceableGroup();
                    final TextFieldColors textFieldColors7 = textFieldColors4;
                    final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                    final boolean z10 = z4;
                    final Function2<? super Composer, ? super Integer, Unit> function211 = function25;
                    final Function2<? super Composer, ? super Integer, Unit> function212 = function26;
                    final Function2<? super Composer, ? super Integer, Unit> function213 = function27;
                    composer4 = composer3;
                    BasicTextFieldKt.BasicTextField(str, function1, semantics$default, z4, false, merge, keyboardOptions, new KeyboardActions(null, null, null, null, (Function1) rememberedValue4, null, 47, null), true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, (Brush) solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer3, -951844929, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function214, Composer composer6, Integer num) {
                            invoke((Function2<? super Composer, ? super Integer, Unit>) function214, composer6, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Function2<? super Composer, ? super Integer, Unit> function214, Composer composer6, int i22) {
                            int i23;
                            ComposerKt.sourceInformation(composer6, "C492@23058L15,478@22354L880:SearchBar.android.kt#uh7d8r");
                            if ((i22 & 6) == 0) {
                                i23 = i22 | (composer6.changedInstance(function214) ? 4 : 2);
                            } else {
                                i23 = i22;
                            }
                            if ((i23 & 19) != 18 || !composer6.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-951844929, i23, -1, "androidx.compose.material3.SearchBarInputField.<anonymous> (SearchBar.android.kt:478)");
                                }
                                TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                                int i24 = i23;
                                String str2 = str;
                                boolean z11 = z10;
                                VisualTransformation none = VisualTransformation.INSTANCE.getNone();
                                MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource5;
                                Function2<Composer, Integer, Unit> function215 = function211;
                                final Function2<Composer, Integer, Unit> function216 = function212;
                                ComposableLambda composableLambda = function216 != null ? ComposableLambdaKt.composableLambda(composer6, -1030845367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$5$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                        invoke(composer7, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer7, int i25) {
                                        float f;
                                        ComposerKt.sourceInformation(composer7, "C487@22765L60:SearchBar.android.kt#uh7d8r");
                                        if ((i25 & 3) == 2 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1030845367, i25, -1, "androidx.compose.material3.SearchBarInputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:487)");
                                        }
                                        Modifier.Companion companion4 = Modifier.INSTANCE;
                                        f = SearchBar_androidKt.SearchBarIconOffsetX;
                                        Modifier m840offsetVpY3zN4$default = OffsetKt.m840offsetVpY3zN4$default(companion4, f, 0.0f, 2, null);
                                        Function2<Composer, Integer, Unit> function217 = function216;
                                        composer7.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer7, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer7, 0);
                                        composer7.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer7, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer7, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer7.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m840offsetVpY3zN4$default);
                                        if (!(composer7.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer7.startReusableNode();
                                        if (composer7.getInserting()) {
                                            composer7.createNode(constructor);
                                        } else {
                                            composer7.useNode();
                                        }
                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer7);
                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer7)), composer7, 0);
                                        composer7.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer7, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer7, 643342186, "C487@22814L9:SearchBar.android.kt#uh7d8r");
                                        function217.invoke(composer7, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer7);
                                        ComposerKt.sourceInformationMarkerEnd(composer7);
                                        composer7.endReplaceableGroup();
                                        composer7.endNode();
                                        composer7.endReplaceableGroup();
                                        composer7.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }) : null;
                                final Function2<Composer, Integer, Unit> function217 = function213;
                                textFieldDefaults.DecorationBox(str2, function214, z11, true, none, mutableInteractionSource6, false, null, function215, composableLambda, function217 != null ? ComposableLambdaKt.composableLambda(composer6, -1558904811, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$5$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                        invoke(composer7, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer7, int i25) {
                                        float f;
                                        ComposerKt.sourceInformation(composer7, "C490@22932L62:SearchBar.android.kt#uh7d8r");
                                        if ((i25 & 3) == 2 && composer7.getSkipping()) {
                                            composer7.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1558904811, i25, -1, "androidx.compose.material3.SearchBarInputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:490)");
                                        }
                                        Modifier.Companion companion4 = Modifier.INSTANCE;
                                        f = SearchBar_androidKt.SearchBarIconOffsetX;
                                        Modifier m840offsetVpY3zN4$default = OffsetKt.m840offsetVpY3zN4$default(companion4, Dp.m6389constructorimpl(-f), 0.0f, 2, null);
                                        Function2<Composer, Integer, Unit> function218 = function217;
                                        composer7.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer7, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer7, 0);
                                        composer7.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer7, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer7, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer7.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m840offsetVpY3zN4$default);
                                        if (!(composer7.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer7.startReusableNode();
                                        if (composer7.getInserting()) {
                                            composer7.createNode(constructor);
                                        } else {
                                            composer7.useNode();
                                        }
                                        Composer m3593constructorimpl = Updater.m3593constructorimpl(composer7);
                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer7)), composer7, 0);
                                        composer7.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer7, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer7, 643342354, "C490@22982L10:SearchBar.android.kt#uh7d8r");
                                        function218.invoke(composer7, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer7);
                                        ComposerKt.sourceInformationMarkerEnd(composer7);
                                        composer7.endReplaceableGroup();
                                        composer7.endNode();
                                        composer7.endReplaceableGroup();
                                        composer7.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }) : null, null, null, null, SearchBarDefaults.INSTANCE.getInputFieldShape(composer6, 6), textFieldColors7, TextFieldDefaults.m2742contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null), ComposableSingletons$SearchBar_androidKt.INSTANCE.m2088getLambda1$material3_release(), composer6, ((i24 << 3) & 112) | 27648, 113246208, 14528);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer6.skipToGroupEnd();
                        }
                    }), composer4, 102236160 | i21 | (i16 & 112) | ((i16 >> 9) & 7168), ((i20 << 6) & 7168) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 7696);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource4 = mutableInteractionSource3;
                    textFieldColors5 = textFieldColors7;
                    modifier5 = modifier6;
                    z7 = z4;
                    function28 = function25;
                    function29 = function26;
                    function210 = function27;
                }
                endRestartGroup = composer4.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$6
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

                        public final void invoke(Composer composer6, int i22) {
                            SearchBar_androidKt.SearchBarInputField(str, function1, function12, z, function13, modifier5, z7, function28, function29, function210, textFieldColors5, mutableInteractionSource4, composer6, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                        }
                    });
                    return;
                }
                return;
            }
            i10 = i9;
            if ((i2 & 6) == 0) {
            }
            i12 = i4;
            i13 = i3 & 2048;
            if (i13 != 0) {
            }
            if ((i12 & 306783379) != 306783378) {
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
            if (i8 != 0) {
            }
            if (i10 != 0) {
            }
            if ((i3 & 1024) != 0) {
            }
            if (i17 != 0) {
            }
            modifier4 = modifier3;
            composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2.startReplaceableGroup(462567538);
            ComposerKt.sourceInformation(composer2, "CC(remember):SearchBar.android.kt#9igjgp");
            rememberedValue = composer2.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            final FocusRequester focusRequester3 = (FocusRequester) rememberedValue;
            composer2.endReplaceableGroup();
            Strings.Companion companion22 = Strings.INSTANCE;
            final String m2623getStringNWtq283 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_search_bar_search), composer2, 0);
            Strings.Companion companion32 = Strings.INSTANCE;
            final String m2623getStringNWtq2822 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_suggestions_available), composer2, 0);
            composer2.startReplaceableGroup(462567758);
            ComposerKt.sourceInformation(composer2, "*448@21112L7,449@21154L74");
            ProvidableCompositionLocal<TextStyle> localTextStyle3 = TextKt.getLocalTextStyle();
            TextFieldColors textFieldColors62 = textFieldColors3;
            boolean z92 = z3;
            ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume3 = composer2.consume(localTextStyle3);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            m5918getColor0d7_KjU = ((TextStyle) consume3).m5918getColor0d7_KjU();
            if (m5918getColor0d7_KjU != Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
            }
            composer3.endReplaceableGroup();
            Modifier modifier62 = modifier4;
            int i202 = i18;
            Modifier focusRequester22 = FocusRequesterModifierKt.focusRequester(androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(androidx.compose.foundation.layout.SizeKt.m914height3ABfNKs(modifier4, SearchBarDefaults.INSTANCE.m2449getInputFieldHeightD9Ej5fM()), 0.0f, 1, null), focusRequester3);
            composer3.startReplaceableGroup(462568122);
            ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
            if ((57344 & i16) == 16384) {
            }
            rememberedValue2 = composer3.rememberedValue();
            if (!z5) {
            }
            rememberedValue2 = (Function1) new Function1<FocusState, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                    invoke2(focusState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FocusState focusState) {
                    if (focusState.isFocused()) {
                        function13.invoke(true);
                    }
                }
            };
            composer3.updateRememberedValue(rememberedValue2);
            composer3.endReplaceableGroup();
            Modifier onFocusChanged2 = FocusChangedModifierKt.onFocusChanged(focusRequester22, (Function1) rememberedValue2);
            composer3.startReplaceableGroup(462568188);
            ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
            changed = composer3.changed(m2623getStringNWtq283) | ((i16 & 7168) == 2048) | composer3.changed(m2623getStringNWtq2822);
            rememberedValue3 = composer3.rememberedValue();
            if (!changed) {
            }
            rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m2623getStringNWtq283);
                    if (z) {
                        SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, m2623getStringNWtq2822);
                    }
                    final FocusRequester focusRequester32 = focusRequester3;
                    SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$3$1.1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            FocusRequester.this.requestFocus();
                            return true;
                        }
                    }, 1, null);
                }
            };
            composer3.updateRememberedValue(rememberedValue3);
            composer3.endReplaceableGroup();
            Modifier semantics$default2 = SemanticsModifierKt.semantics$default(onFocusChanged2, false, (Function1) rememberedValue3, 1, null);
            ProvidableCompositionLocal<TextStyle> localTextStyle22 = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume22 = composer3.consume(localTextStyle22);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            TextStyle merge2 = ((TextStyle) consume22).merge(new TextStyle(m4073unboximpl, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
            SolidColor solidColor2 = new SolidColor(textFieldColors4.cursorColor$material3_release(false, composer3, ((i202 << 3) & 112) | 6).getValue().m4073unboximpl(), null);
            KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, false, 0, ImeAction.INSTANCE.m6070getSearcheUduSuo(), null, 23, null);
            composer3.startReplaceableGroup(462568831);
            ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
            int i212 = i16 & 14;
            z6 = ((i16 & 896) == 256) | (i212 == 4);
            rememberedValue4 = composer3.rememberedValue();
            if (!z6) {
            }
            rememberedValue4 = (Function1) new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$4$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                    invoke2(keyboardActionScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyboardActionScope keyboardActionScope) {
                    function12.invoke(str);
                }
            };
            composer3.updateRememberedValue(rememberedValue4);
            composer3.endReplaceableGroup();
            final TextFieldColors textFieldColors72 = textFieldColors4;
            final MutableInteractionSource mutableInteractionSource52 = mutableInteractionSource3;
            final boolean z102 = z4;
            final Function2<? super Composer, ? super Integer, Unit> function2112 = function25;
            final Function2<? super Composer, ? super Integer, Unit> function2122 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function2132 = function27;
            composer4 = composer3;
            BasicTextFieldKt.BasicTextField(str, function1, semantics$default2, z4, false, merge2, keyboardOptions2, new KeyboardActions(null, null, null, null, (Function1) rememberedValue4, null, 47, null), true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, (Brush) solidColor2, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer3, -951844929, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function214, Composer composer6, Integer num) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) function214, composer6, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Function2<? super Composer, ? super Integer, Unit> function214, Composer composer6, int i22) {
                    int i23;
                    ComposerKt.sourceInformation(composer6, "C492@23058L15,478@22354L880:SearchBar.android.kt#uh7d8r");
                    if ((i22 & 6) == 0) {
                        i23 = i22 | (composer6.changedInstance(function214) ? 4 : 2);
                    } else {
                        i23 = i22;
                    }
                    if ((i23 & 19) != 18 || !composer6.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-951844929, i23, -1, "androidx.compose.material3.SearchBarInputField.<anonymous> (SearchBar.android.kt:478)");
                        }
                        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                        int i24 = i23;
                        String str2 = str;
                        boolean z11 = z102;
                        VisualTransformation none = VisualTransformation.INSTANCE.getNone();
                        MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource52;
                        Function2<Composer, Integer, Unit> function215 = function2112;
                        final Function2<? super Composer, ? super Integer, Unit> function216 = function2122;
                        ComposableLambda composableLambda = function216 != null ? ComposableLambdaKt.composableLambda(composer6, -1030845367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$5$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                invoke(composer7, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer7, int i25) {
                                float f;
                                ComposerKt.sourceInformation(composer7, "C487@22765L60:SearchBar.android.kt#uh7d8r");
                                if ((i25 & 3) == 2 && composer7.getSkipping()) {
                                    composer7.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1030845367, i25, -1, "androidx.compose.material3.SearchBarInputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:487)");
                                }
                                Modifier.Companion companion4 = Modifier.INSTANCE;
                                f = SearchBar_androidKt.SearchBarIconOffsetX;
                                Modifier m840offsetVpY3zN4$default = OffsetKt.m840offsetVpY3zN4$default(companion4, f, 0.0f, 2, null);
                                Function2<Composer, Integer, Unit> function217 = function216;
                                composer7.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer7, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer7, 0);
                                composer7.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer7, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer7, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer7.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m840offsetVpY3zN4$default);
                                if (!(composer7.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer7.startReusableNode();
                                if (composer7.getInserting()) {
                                    composer7.createNode(constructor);
                                } else {
                                    composer7.useNode();
                                }
                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer7);
                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer7)), composer7, 0);
                                composer7.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer7, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer7, 643342186, "C487@22814L9:SearchBar.android.kt#uh7d8r");
                                function217.invoke(composer7, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer7);
                                ComposerKt.sourceInformationMarkerEnd(composer7);
                                composer7.endReplaceableGroup();
                                composer7.endNode();
                                composer7.endReplaceableGroup();
                                composer7.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }) : null;
                        final Function2<? super Composer, ? super Integer, Unit> function217 = function2132;
                        textFieldDefaults.DecorationBox(str2, function214, z11, true, none, mutableInteractionSource6, false, null, function215, composableLambda, function217 != null ? ComposableLambdaKt.composableLambda(composer6, -1558904811, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$5$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                                invoke(composer7, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer7, int i25) {
                                float f;
                                ComposerKt.sourceInformation(composer7, "C490@22932L62:SearchBar.android.kt#uh7d8r");
                                if ((i25 & 3) == 2 && composer7.getSkipping()) {
                                    composer7.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1558904811, i25, -1, "androidx.compose.material3.SearchBarInputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:490)");
                                }
                                Modifier.Companion companion4 = Modifier.INSTANCE;
                                f = SearchBar_androidKt.SearchBarIconOffsetX;
                                Modifier m840offsetVpY3zN4$default = OffsetKt.m840offsetVpY3zN4$default(companion4, Dp.m6389constructorimpl(-f), 0.0f, 2, null);
                                Function2<Composer, Integer, Unit> function218 = function217;
                                composer7.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer7, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer7, 0);
                                composer7.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer7, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer7, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer7.getCurrentCompositionLocalMap();
                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m840offsetVpY3zN4$default);
                                if (!(composer7.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer7.startReusableNode();
                                if (composer7.getInserting()) {
                                    composer7.createNode(constructor);
                                } else {
                                    composer7.useNode();
                                }
                                Composer m3593constructorimpl = Updater.m3593constructorimpl(composer7);
                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer7)), composer7, 0);
                                composer7.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer7, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer7, 643342354, "C490@22982L10:SearchBar.android.kt#uh7d8r");
                                function218.invoke(composer7, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer7);
                                ComposerKt.sourceInformationMarkerEnd(composer7);
                                composer7.endReplaceableGroup();
                                composer7.endNode();
                                composer7.endReplaceableGroup();
                                composer7.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }) : null, null, null, null, SearchBarDefaults.INSTANCE.getInputFieldShape(composer6, 6), textFieldColors72, TextFieldDefaults.m2742contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null), ComposableSingletons$SearchBar_androidKt.INSTANCE.m2088getLambda1$material3_release(), composer6, ((i24 << 3) & 112) | 27648, 113246208, 14528);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer6.skipToGroupEnd();
                }
            }), composer4, 102236160 | i212 | (i16 & 112) | ((i16 >> 9) & 7168), ((i202 << 6) & 7168) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 7696);
            if (ComposerKt.isTraceInProgress()) {
            }
            mutableInteractionSource4 = mutableInteractionSource3;
            textFieldColors5 = textFieldColors72;
            modifier5 = modifier62;
            z7 = z4;
            function28 = function25;
            function29 = function26;
            function210 = function27;
            endRestartGroup = composer4.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        if ((i3 & 8) == 0) {
        }
        if ((i3 & 16) == 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
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
        if ((i2 & 6) == 0) {
        }
        i12 = i4;
        i13 = i3 & 2048;
        if (i13 != 0) {
        }
        if ((i12 & 306783379) != 306783378) {
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
        if (i8 != 0) {
        }
        if (i10 != 0) {
        }
        if ((i3 & 1024) != 0) {
        }
        if (i17 != 0) {
        }
        modifier4 = modifier3;
        composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2.startReplaceableGroup(462567538);
        ComposerKt.sourceInformation(composer2, "CC(remember):SearchBar.android.kt#9igjgp");
        rememberedValue = composer2.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        final FocusRequester focusRequester32 = (FocusRequester) rememberedValue;
        composer2.endReplaceableGroup();
        Strings.Companion companion222 = Strings.INSTANCE;
        final String m2623getStringNWtq2832 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_search_bar_search), composer2, 0);
        Strings.Companion companion322 = Strings.INSTANCE;
        final String m2623getStringNWtq28222 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_suggestions_available), composer2, 0);
        composer2.startReplaceableGroup(462567758);
        ComposerKt.sourceInformation(composer2, "*448@21112L7,449@21154L74");
        ProvidableCompositionLocal<TextStyle> localTextStyle32 = TextKt.getLocalTextStyle();
        TextFieldColors textFieldColors622 = textFieldColors3;
        boolean z922 = z3;
        ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume32 = composer2.consume(localTextStyle32);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        m5918getColor0d7_KjU = ((TextStyle) consume32).m5918getColor0d7_KjU();
        if (m5918getColor0d7_KjU != Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
        }
        composer3.endReplaceableGroup();
        Modifier modifier622 = modifier4;
        int i2022 = i18;
        Modifier focusRequester222 = FocusRequesterModifierKt.focusRequester(androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(androidx.compose.foundation.layout.SizeKt.m914height3ABfNKs(modifier4, SearchBarDefaults.INSTANCE.m2449getInputFieldHeightD9Ej5fM()), 0.0f, 1, null), focusRequester32);
        composer3.startReplaceableGroup(462568122);
        ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
        if ((57344 & i16) == 16384) {
        }
        rememberedValue2 = composer3.rememberedValue();
        if (!z5) {
        }
        rememberedValue2 = (Function1) new Function1<FocusState, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                invoke2(focusState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(FocusState focusState) {
                if (focusState.isFocused()) {
                    function13.invoke(true);
                }
            }
        };
        composer3.updateRememberedValue(rememberedValue2);
        composer3.endReplaceableGroup();
        Modifier onFocusChanged22 = FocusChangedModifierKt.onFocusChanged(focusRequester222, (Function1) rememberedValue2);
        composer3.startReplaceableGroup(462568188);
        ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
        changed = composer3.changed(m2623getStringNWtq2832) | ((i16 & 7168) == 2048) | composer3.changed(m2623getStringNWtq28222);
        rememberedValue3 = composer3.rememberedValue();
        if (!changed) {
        }
        rememberedValue3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$3$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m2623getStringNWtq2832);
                if (z) {
                    SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, m2623getStringNWtq28222);
                }
                final FocusRequester focusRequester322 = focusRequester32;
                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$3$1.1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        FocusRequester.this.requestFocus();
                        return true;
                    }
                }, 1, null);
            }
        };
        composer3.updateRememberedValue(rememberedValue3);
        composer3.endReplaceableGroup();
        Modifier semantics$default22 = SemanticsModifierKt.semantics$default(onFocusChanged22, false, (Function1) rememberedValue3, 1, null);
        ProvidableCompositionLocal<TextStyle> localTextStyle222 = TextKt.getLocalTextStyle();
        ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume222 = composer3.consume(localTextStyle222);
        ComposerKt.sourceInformationMarkerEnd(composer3);
        TextStyle merge22 = ((TextStyle) consume222).merge(new TextStyle(m4073unboximpl, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null));
        SolidColor solidColor22 = new SolidColor(textFieldColors4.cursorColor$material3_release(false, composer3, ((i2022 << 3) & 112) | 6).getValue().m4073unboximpl(), null);
        KeyboardOptions keyboardOptions22 = new KeyboardOptions(0, false, 0, ImeAction.INSTANCE.m6070getSearcheUduSuo(), null, 23, null);
        composer3.startReplaceableGroup(462568831);
        ComposerKt.sourceInformation(composer3, "CC(remember):SearchBar.android.kt#9igjgp");
        int i2122 = i16 & 14;
        z6 = ((i16 & 896) == 256) | (i2122 == 4);
        rememberedValue4 = composer3.rememberedValue();
        if (!z6) {
        }
        rememberedValue4 = (Function1) new Function1<KeyboardActionScope, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$4$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                invoke2(keyboardActionScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KeyboardActionScope keyboardActionScope) {
                function12.invoke(str);
            }
        };
        composer3.updateRememberedValue(rememberedValue4);
        composer3.endReplaceableGroup();
        final TextFieldColors textFieldColors722 = textFieldColors4;
        final MutableInteractionSource mutableInteractionSource522 = mutableInteractionSource3;
        final boolean z1022 = z4;
        final Function2<? super Composer, ? super Integer, Unit> function21122 = function25;
        final Function2<? super Composer, ? super Integer, Unit> function21222 = function26;
        final Function2<? super Composer, ? super Integer, Unit> function21322 = function27;
        composer4 = composer3;
        BasicTextFieldKt.BasicTextField(str, function1, semantics$default22, z4, false, merge22, keyboardOptions22, new KeyboardActions(null, null, null, null, (Function1) rememberedValue4, null, 47, null), true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource3, (Brush) solidColor22, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer3, -951844929, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function214, Composer composer6, Integer num) {
                invoke((Function2<? super Composer, ? super Integer, Unit>) function214, composer6, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Function2<? super Composer, ? super Integer, Unit> function214, Composer composer6, int i22) {
                int i23;
                ComposerKt.sourceInformation(composer6, "C492@23058L15,478@22354L880:SearchBar.android.kt#uh7d8r");
                if ((i22 & 6) == 0) {
                    i23 = i22 | (composer6.changedInstance(function214) ? 4 : 2);
                } else {
                    i23 = i22;
                }
                if ((i23 & 19) != 18 || !composer6.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-951844929, i23, -1, "androidx.compose.material3.SearchBarInputField.<anonymous> (SearchBar.android.kt:478)");
                    }
                    TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
                    int i24 = i23;
                    String str2 = str;
                    boolean z11 = z1022;
                    VisualTransformation none = VisualTransformation.INSTANCE.getNone();
                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource522;
                    Function2<Composer, Integer, Unit> function215 = function21122;
                    final Function2<? super Composer, ? super Integer, Unit> function216 = function21222;
                    ComposableLambda composableLambda = function216 != null ? ComposableLambdaKt.composableLambda(composer6, -1030845367, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$5$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                            invoke(composer7, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer7, int i25) {
                            float f;
                            ComposerKt.sourceInformation(composer7, "C487@22765L60:SearchBar.android.kt#uh7d8r");
                            if ((i25 & 3) == 2 && composer7.getSkipping()) {
                                composer7.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1030845367, i25, -1, "androidx.compose.material3.SearchBarInputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:487)");
                            }
                            Modifier.Companion companion4 = Modifier.INSTANCE;
                            f = SearchBar_androidKt.SearchBarIconOffsetX;
                            Modifier m840offsetVpY3zN4$default = OffsetKt.m840offsetVpY3zN4$default(companion4, f, 0.0f, 2, null);
                            Function2<Composer, Integer, Unit> function217 = function216;
                            composer7.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer7, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer7, 0);
                            composer7.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer7, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer7, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer7.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m840offsetVpY3zN4$default);
                            if (!(composer7.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer7.startReusableNode();
                            if (composer7.getInserting()) {
                                composer7.createNode(constructor);
                            } else {
                                composer7.useNode();
                            }
                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer7);
                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer7)), composer7, 0);
                            composer7.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer7, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer7, 643342186, "C487@22814L9:SearchBar.android.kt#uh7d8r");
                            function217.invoke(composer7, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer7);
                            ComposerKt.sourceInformationMarkerEnd(composer7);
                            composer7.endReplaceableGroup();
                            composer7.endNode();
                            composer7.endReplaceableGroup();
                            composer7.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }) : null;
                    final Function2<? super Composer, ? super Integer, Unit> function217 = function21322;
                    textFieldDefaults.DecorationBox(str2, function214, z11, true, none, mutableInteractionSource6, false, null, function215, composableLambda, function217 != null ? ComposableLambdaKt.composableLambda(composer6, -1558904811, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SearchBar_androidKt$SearchBarInputField$5$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer7, Integer num) {
                            invoke(composer7, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer7, int i25) {
                            float f;
                            ComposerKt.sourceInformation(composer7, "C490@22932L62:SearchBar.android.kt#uh7d8r");
                            if ((i25 & 3) == 2 && composer7.getSkipping()) {
                                composer7.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1558904811, i25, -1, "androidx.compose.material3.SearchBarInputField.<anonymous>.<anonymous>.<anonymous> (SearchBar.android.kt:490)");
                            }
                            Modifier.Companion companion4 = Modifier.INSTANCE;
                            f = SearchBar_androidKt.SearchBarIconOffsetX;
                            Modifier m840offsetVpY3zN4$default = OffsetKt.m840offsetVpY3zN4$default(companion4, Dp.m6389constructorimpl(-f), 0.0f, 2, null);
                            Function2<Composer, Integer, Unit> function218 = function217;
                            composer7.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer7, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer7, 0);
                            composer7.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer7, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer7, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer7.getCurrentCompositionLocalMap();
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m840offsetVpY3zN4$default);
                            if (!(composer7.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer7.startReusableNode();
                            if (composer7.getInserting()) {
                                composer7.createNode(constructor);
                            } else {
                                composer7.useNode();
                            }
                            Composer m3593constructorimpl = Updater.m3593constructorimpl(composer7);
                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer7)), composer7, 0);
                            composer7.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer7, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer7, 643342354, "C490@22982L10:SearchBar.android.kt#uh7d8r");
                            function218.invoke(composer7, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer7);
                            ComposerKt.sourceInformationMarkerEnd(composer7);
                            composer7.endReplaceableGroup();
                            composer7.endNode();
                            composer7.endReplaceableGroup();
                            composer7.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }) : null, null, null, null, SearchBarDefaults.INSTANCE.getInputFieldShape(composer6, 6), textFieldColors722, TextFieldDefaults.m2742contentPaddingWithoutLabela9UjIt4$default(TextFieldDefaults.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 15, null), ComposableSingletons$SearchBar_androidKt.INSTANCE.m2088getLambda1$material3_release(), composer6, ((i24 << 3) & 112) | 27648, 113246208, 14528);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer6.skipToGroupEnd();
            }
        }), composer4, 102236160 | i2122 | (i16 & 112) | ((i16 >> 9) & 7168), ((i2022 << 6) & 7168) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 7696);
        if (ComposerKt.isTraceInProgress()) {
        }
        mutableInteractionSource4 = mutableInteractionSource3;
        textFieldColors5 = textFieldColors722;
        modifier5 = modifier622;
        z7 = z4;
        function28 = function25;
        function29 = function26;
        function210 = function27;
        endRestartGroup = composer4.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    static {
        CubicBezierEasing easingEmphasizedDecelerateCubicBezier = MotionTokens.INSTANCE.getEasingEmphasizedDecelerateCubicBezier();
        AnimationEnterEasing = easingEmphasizedDecelerateCubicBezier;
        CubicBezierEasing cubicBezierEasing = new CubicBezierEasing(0.0f, 1.0f, 0.0f, 1.0f);
        AnimationExitEasing = cubicBezierEasing;
        TweenSpec tween = AnimationSpecKt.tween(600, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterFloatSpec = tween;
        TweenSpec tween2 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitFloatSpec = tween2;
        TweenSpec tween3 = AnimationSpecKt.tween(600, 100, easingEmphasizedDecelerateCubicBezier);
        AnimationEnterSizeSpec = tween3;
        TweenSpec tween4 = AnimationSpecKt.tween(AnimationExitDurationMillis, 100, cubicBezierEasing);
        AnimationExitSizeSpec = tween4;
        DockedEnterTransition = EnterExitTransitionKt.fadeIn$default(tween, 0.0f, 2, null).plus(EnterExitTransitionKt.expandVertically$default(tween3, null, false, null, 14, null));
        DockedExitTransition = EnterExitTransitionKt.fadeOut$default(tween2, 0.0f, 2, null).plus(EnterExitTransitionKt.shrinkVertically$default(tween4, null, false, null, 14, null));
    }

    public static final float getDockedActiveTableMinHeight() {
        return DockedActiveTableMinHeight;
    }

    public static final float getSearchBarMinWidth() {
        return SearchBarMinWidth;
    }

    public static final float getSearchBarVerticalPadding() {
        return SearchBarVerticalPadding;
    }

    private static final boolean SearchBar_WuY5d9Q$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
