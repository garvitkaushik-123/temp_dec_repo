package androidx.compose.material3;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldImpl.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0002\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00032\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b42\u0006\u00105\u001a\u0002062\u0013\u00107\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u00108\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u00109\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010:\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010;\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010<\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\u0015\b\u0002\u0010=\u001a\u000f\u0012\u0004\u0012\u00020.\u0018\u000103¢\u0006\u0002\b42\b\b\u0002\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020?2\b\b\u0002\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0011\u0010H\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b4H\u0001¢\u0006\u0002\u0010I\u001a9\u0010J\u001a\u00020.2\u0006\u0010K\u001a\u00020L2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010N2\u0011\u0010O\u001a\r\u0012\u0004\u0012\u00020.03¢\u0006\u0002\b4H\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a\u0012\u0010R\u001a\u00020\u00012\b\u0010S\u001a\u0004\u0018\u00010TH\u0000\u001a\u0012\u0010U\u001a\u00020\u00012\b\u0010S\u001a\u0004\u0018\u00010TH\u0000\u001a\u001c\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010A\u001a\u00020?2\u0006\u0010W\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u000e\u0010\r\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u000f\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007\"\u0016\u0010\u0011\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007\"\u0016\u0010\u0013\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0014\u0010\u0007\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0019\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001a\u0010\u0007\"\u000e\u0010\u001b\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u001d\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u001e\u0010\u0007\"\u000e\u0010\u001f\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010 \u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b!\u0010\u0007\"\u000e\u0010\"\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010#\u001a\u00020$X\u0080\u0004¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&\"\u001a\u0010(\u001a\u0004\u0018\u00010)*\u00020*8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006X"}, d2 = {"AnimationDuration", "", "ContainerId", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "LeadingId", "MinFocusedLabelLineHeight", "getMinFocusedLabelLineHeight", "MinSupportingTextLineHeight", "getMinSupportingTextLineHeight", "MinTextLineHeight", "getMinTextLineHeight", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "PrefixId", "PrefixSuffixTextPadding", "getPrefixSuffixTextPadding", "SuffixId", "SupportingId", "SupportingTopPadding", "getSupportingTopPadding", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material3/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material3/TextFieldColors;", "container", "(Landroidx/compose/material3/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material3/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "content", "Decoration-KTwxG1Y", "(JLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "defaultErrorSemantics", "defaultErrorMessage", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    public static final String ContainerId = "Container";
    private static final Modifier IconDefaultSizeModifier;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final float MinFocusedLabelLineHeight;
    private static final float MinSupportingTextLineHeight;
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String PrefixId = "Prefix";
    public static final String SuffixId = "Suffix";
    public static final String SupportingId = "Supporting";
    public static final String TextFieldId = "TextField";
    private static final float TextFieldPadding;
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float HorizontalIconPadding = Dp.m6389constructorimpl(12);
    private static final float SupportingTopPadding = Dp.m6389constructorimpl(4);
    private static final float PrefixSuffixTextPadding = Dp.m6389constructorimpl(2);
    private static final float MinTextLineHeight = Dp.m6389constructorimpl(24);

    /* JADX WARN: Removed duplicated region for block: B:100:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CommonDecorationBox(final TextFieldType textFieldType, final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final VisualTransformation visualTransformation, final Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, boolean z, boolean z2, boolean z3, final InteractionSource interactionSource, final PaddingValues paddingValues, final TextFieldColors textFieldColors, final Function2<? super Composer, ? super Integer, Unit> function29, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        String str2;
        Function2<? super Composer, ? super Integer, Unit> function210;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function211;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function212;
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
        int i20;
        int i21;
        boolean z4;
        Object rememberedValue;
        InputPhase inputPhase;
        Function3<InputPhase, Composer, Integer, Color> function3;
        final boolean z5;
        long m5918getColor0d7_KjU;
        long m5918getColor0d7_KjU2;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function213;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final boolean z7;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        final Function2<? super Composer, ? super Integer, Unit> function217;
        final Function2<? super Composer, ? super Integer, Unit> function218;
        final boolean z8;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-947035500);
        ComposerKt.sourceInformation(startRestartGroup, "C(CommonDecorationBox)P(15,16,4,17,7,9,8,14,10,12,13,11,3,6,5,2)80@3145L105,84@3300L25,95@3684L10,102@4027L6900:TextFieldImpl.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(textFieldType) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            str2 = str;
            i4 |= startRestartGroup.changed(str2) ? 32 : 16;
            if ((i3 & 4) == 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                function210 = function2;
                i4 |= startRestartGroup.changedInstance(function210) ? 256 : 128;
                if ((i3 & 8) != 0) {
                    i4 |= 3072;
                } else if ((i & 3072) == 0) {
                    i4 |= startRestartGroup.changed(visualTransformation) ? 2048 : 1024;
                }
                if ((i3 & 16) != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
                }
                i5 = i3 & 32;
                if (i5 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function211 = function23;
                } else {
                    function211 = function23;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        i4 |= startRestartGroup.changedInstance(function211) ? 131072 : 65536;
                    }
                }
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                    function212 = function24;
                } else {
                    function212 = function24;
                    if ((i & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function212) ? 1048576 : 524288;
                    }
                }
                i7 = i3 & 128;
                if (i7 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    i4 |= startRestartGroup.changedInstance(function25) ? 8388608 : 4194304;
                }
                i8 = i3 & 256;
                if (i8 != 0) {
                    i4 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    i9 = i8;
                    i4 |= startRestartGroup.changedInstance(function26) ? 67108864 : 33554432;
                    i10 = i3 & 512;
                    if (i10 == 0) {
                        i4 |= C.ENCODING_PCM_32BIT;
                    } else if ((i & C.ENCODING_PCM_32BIT) == 0) {
                        i11 = i10;
                        i4 |= startRestartGroup.changedInstance(function27) ? 536870912 : 268435456;
                        i12 = i3 & 1024;
                        if (i12 != 0) {
                            i14 = i2 | 6;
                            i13 = i12;
                        } else if ((i2 & 6) == 0) {
                            i13 = i12;
                            i14 = i2 | (startRestartGroup.changedInstance(function28) ? 4 : 2);
                        } else {
                            i13 = i12;
                            i14 = i2;
                        }
                        i15 = i3 & 2048;
                        if (i15 != 0) {
                            i14 |= 48;
                            i16 = i15;
                        } else if ((i2 & 48) == 0) {
                            i16 = i15;
                            i14 |= startRestartGroup.changed(z) ? 32 : 16;
                        } else {
                            i16 = i15;
                        }
                        int i22 = i14;
                        i17 = i3 & 4096;
                        if (i17 != 0) {
                            i18 = i22 | 384;
                        } else if ((i2 & 384) == 0) {
                            i18 = i22 | (startRestartGroup.changed(z2) ? 256 : 128);
                        } else {
                            i18 = i22;
                        }
                        i19 = i3 & 8192;
                        if (i19 != 0) {
                            i20 = i18 | 3072;
                        } else {
                            int i23 = i18;
                            if ((i2 & 3072) == 0) {
                                i23 |= startRestartGroup.changed(z3) ? 2048 : 1024;
                            }
                            i20 = i23;
                        }
                        if ((i3 & 16384) != 0) {
                            i20 |= 24576;
                        } else if ((i2 & 24576) == 0) {
                            i20 |= startRestartGroup.changed(interactionSource) ? 16384 : 8192;
                        }
                        if ((32768 & i3) != 0) {
                            i20 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            i20 |= startRestartGroup.changed(paddingValues) ? 131072 : 65536;
                            if ((i3 & 65536) == 0) {
                                i20 |= 1572864;
                            } else if ((i2 & 1572864) == 0) {
                                i20 |= startRestartGroup.changed(textFieldColors) ? 1048576 : 524288;
                            }
                            if ((i3 & 131072) == 0) {
                                i21 = i20 | 12582912;
                            } else {
                                int i24 = i20;
                                if ((i2 & 12582912) == 0) {
                                    i21 = i24 | (startRestartGroup.changedInstance(function29) ? 8388608 : 4194304);
                                } else {
                                    i21 = i24;
                                }
                            }
                            if ((i4 & 306783379) == 306783378 || (4793491 & i21) != 4793490 || !startRestartGroup.getSkipping()) {
                                if (i5 != 0) {
                                    function211 = null;
                                }
                                if (i6 != 0) {
                                    function212 = null;
                                }
                                Function2<? super Composer, ? super Integer, Unit> function219 = i7 == 0 ? null : function25;
                                Function2<? super Composer, ? super Integer, Unit> function220 = i9 == 0 ? null : function26;
                                final Function2<? super Composer, ? super Integer, Unit> function221 = i11 == 0 ? null : function27;
                                Function2<? super Composer, ? super Integer, Unit> function222 = i13 == 0 ? function28 : null;
                                final boolean z9 = i16 == 0 ? false : z;
                                final Function2<? super Composer, ? super Integer, Unit> function223 = function222;
                                final boolean z10 = i17 == 0 ? true : z2;
                                final Function2<? super Composer, ? super Integer, Unit> function224 = function219;
                                final boolean z11 = i19 == 0 ? false : z3;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-947035500, i4, i21, "androidx.compose.material3.CommonDecorationBox (TextFieldImpl.kt:79)");
                                }
                                startRestartGroup.startReplaceableGroup(-646389284);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TextFieldImpl.kt#9igjgp");
                                z4 = ((i4 & 112) != 32) | ((i4 & 7168) != 2048);
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!z4 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = visualTransformation.filter(new AnnotatedString(str2, null, null, 6, null));
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                startRestartGroup.endReplaceableGroup();
                                final String text = ((TransformedText) rememberedValue).getText().getText();
                                if (!FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i21 >> 12) & 14).getValue().booleanValue()) {
                                    inputPhase = InputPhase.Focused;
                                } else {
                                    inputPhase = text.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
                                }
                                function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase2, Composer composer3, Integer num) {
                                        return Color.m4053boximpl(m2774invokeXeAY9LY(inputPhase2, composer3, num.intValue()));
                                    }

                                    /* renamed from: invoke-XeAY9LY, reason: not valid java name */
                                    public final long m2774invokeXeAY9LY(InputPhase inputPhase2, Composer composer3, int i25) {
                                        composer3.startReplaceableGroup(-502832279);
                                        ComposerKt.sourceInformation(composer3, "C92@3588L47:TextFieldImpl.kt#uh7d8r");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-502832279, i25, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:92)");
                                        }
                                        long m4073unboximpl = TextFieldColors.this.labelColor$material3_release(z10, z11, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        composer3.endReplaceableGroup();
                                        return m4073unboximpl;
                                    }
                                };
                                Typography typography = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                                final TextStyle bodyLarge = typography.getBodyLarge();
                                final TextStyle bodySmall = typography.getBodySmall();
                                final boolean z12 = z10;
                                final boolean z13 = z11;
                                z5 = !(Color.m4064equalsimpl0(bodyLarge.m5918getColor0d7_KjU(), Color.INSTANCE.m4099getUnspecified0d7_KjU()) || Color.m4064equalsimpl0(bodySmall.m5918getColor0d7_KjU(), Color.INSTANCE.m4099getUnspecified0d7_KjU())) || (!Color.m4064equalsimpl0(bodyLarge.m5918getColor0d7_KjU(), Color.INSTANCE.m4099getUnspecified0d7_KjU()) && Color.m4064equalsimpl0(bodySmall.m5918getColor0d7_KjU(), Color.INSTANCE.m4099getUnspecified0d7_KjU()));
                                TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
                                startRestartGroup.startReplaceableGroup(-646388325);
                                ComposerKt.sourceInformation(startRestartGroup, "*104@4123L10");
                                m5918getColor0d7_KjU = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall().m5918getColor0d7_KjU();
                                startRestartGroup.startReplaceableGroup(-646388264);
                                ComposerKt.sourceInformation(startRestartGroup, "*105@4217L22");
                                if (z5 && m5918getColor0d7_KjU == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                    m5918getColor0d7_KjU = function3.invoke(inputPhase, startRestartGroup, 0).m4073unboximpl();
                                }
                                long j = m5918getColor0d7_KjU;
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.startReplaceableGroup(-646388132);
                                ComposerKt.sourceInformation(startRestartGroup, "*107@4316L10");
                                m5918getColor0d7_KjU2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodyLarge().m5918getColor0d7_KjU();
                                startRestartGroup.startReplaceableGroup(-646388071);
                                ComposerKt.sourceInformation(startRestartGroup, "*108@4410L22");
                                if (z5 && m5918getColor0d7_KjU2 == Color.INSTANCE.m4099getUnspecified0d7_KjU()) {
                                    m5918getColor0d7_KjU2 = function3.invoke(inputPhase, startRestartGroup, 0).m4073unboximpl();
                                }
                                long j2 = m5918getColor0d7_KjU2;
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.endReplaceableGroup();
                                boolean z14 = function22 == null;
                                final Function2<? super Composer, ? super Integer, Unit> function225 = function211;
                                final Function2<? super Composer, ? super Integer, Unit> function226 = function220;
                                final Function2<? super Composer, ? super Integer, Unit> function227 = function210;
                                final Function2<? super Composer, ? super Integer, Unit> function228 = function212;
                                Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit> function7 = new Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3

                                    /* compiled from: TextFieldImpl.kt */
                                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                                    public /* synthetic */ class WhenMappings {
                                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                        static {
                                            int[] iArr = new int[TextFieldType.values().length];
                                            try {
                                                iArr[TextFieldType.Filled.ordinal()] = 1;
                                            } catch (NoSuchFieldError unused) {
                                            }
                                            try {
                                                iArr[TextFieldType.Outlined.ordinal()] = 2;
                                            } catch (NoSuchFieldError unused2) {
                                            }
                                            $EnumSwitchMapping$0 = iArr;
                                        }
                                    }

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(7);
                                    }

                                    @Override // kotlin.jvm.functions.Function7
                                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f2, Float f3, Composer composer3, Integer num) {
                                        m2772invokeeopBjH0(f.floatValue(), color.m4073unboximpl(), color2.m4073unboximpl(), f2.floatValue(), f3.floatValue(), composer3, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-eopBjH0, reason: not valid java name */
                                    public final void m2772invokeeopBjH0(final float f, final long j3, long j4, final float f2, final float f3, Composer composer3, int i25) {
                                        int i26;
                                        final long j5;
                                        boolean z15;
                                        final float f4;
                                        ComposableLambda composableLambda;
                                        ComposableLambda composableLambda2;
                                        ComposableLambda composableLambda3;
                                        Composer composer4;
                                        ComposableLambda composableLambda4;
                                        ComposableLambda composableLambda5;
                                        ComposableLambda composableLambda6;
                                        ComposerKt.sourceInformation(composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)131@5373L53,145@6062L48,159@6654L48,173@7251L53,180@7552L54,188@7871L56:TextFieldImpl.kt#uh7d8r");
                                        if ((i25 & 6) == 0) {
                                            i26 = (composer3.changed(f) ? 4 : 2) | i25;
                                        } else {
                                            i26 = i25;
                                        }
                                        if ((i25 & 48) == 0) {
                                            i26 |= composer3.changed(j3) ? 32 : 16;
                                        }
                                        if ((i25 & 384) == 0) {
                                            j5 = j4;
                                            i26 |= composer3.changed(j5) ? 256 : 128;
                                        } else {
                                            j5 = j4;
                                        }
                                        if ((i25 & 3072) == 0) {
                                            i26 |= composer3.changed(f2) ? 2048 : 1024;
                                        }
                                        if ((i25 & 24576) == 0) {
                                            i26 |= composer3.changed(f3) ? 16384 : 8192;
                                        }
                                        int i27 = i26;
                                        if ((74899 & i27) != 74898 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1290853831, i27, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:115)");
                                            }
                                            final Function2<Composer, Integer, Unit> function229 = function22;
                                            if (function229 != null) {
                                                final boolean z16 = z5;
                                                z15 = true;
                                                composableLambda = null;
                                                f4 = f;
                                                composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -382297919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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

                                                    public final void invoke(Composer composer5, int i28) {
                                                        ComposerKt.sourceInformation(composer5, "C*118@4824L10,119@4880L10,124@5093L49:TextFieldImpl.kt#uh7d8r");
                                                        if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-382297919, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:117)");
                                                            }
                                                            TextStyle lerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodyLarge(), MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodySmall(), f);
                                                            boolean z17 = z16;
                                                            long j6 = j3;
                                                            if (z17) {
                                                                lerp = TextStyle.m5901copyp1EtxEg$default(lerp, j6, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                                                            }
                                                            TextFieldImplKt.m2771DecorationKTwxG1Y(j5, lerp, function229, composer5, 0, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer5.skipToGroupEnd();
                                                    }
                                                });
                                            } else {
                                                z15 = true;
                                                f4 = f;
                                                composableLambda = null;
                                                composableLambda2 = null;
                                            }
                                            final long m4073unboximpl = textFieldColors.placeholderColor$material3_release(z12, z13, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                            if (function225 == null || text.length() != 0 || f2 <= 0.0f) {
                                                composableLambda3 = composableLambda;
                                            } else {
                                                final Function2<Composer, Integer, Unit> function230 = function225;
                                                composableLambda3 = ComposableLambdaKt.composableLambda(composer3, -524658155, z15, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(3);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function3
                                                    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer5, Integer num) {
                                                        invoke(modifier, composer5, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Modifier modifier, Composer composer5, int i28) {
                                                        ComposerKt.sourceInformation(composer5, "C135@5666L319:TextFieldImpl.kt#uh7d8r");
                                                        if ((i28 & 6) == 0) {
                                                            i28 |= composer5.changed(modifier) ? 4 : 2;
                                                        }
                                                        if ((i28 & 19) != 18 || !composer5.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-524658155, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:135)");
                                                            }
                                                            Modifier alpha = AlphaKt.alpha(modifier, f2);
                                                            long j6 = m4073unboximpl;
                                                            Function2<Composer, Integer, Unit> function231 = function230;
                                                            composer5.startReplaceableGroup(733328855);
                                                            ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                            }
                                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 1425713248, "C138@5866L10,136@5738L225:TextFieldImpl.kt#uh7d8r");
                                                            TextFieldImplKt.m2771DecorationKTwxG1Y(j6, MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodyLarge(), function231, composer5, 0, 0);
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
                                                });
                                            }
                                            final long m4073unboximpl2 = textFieldColors.prefixColor$material3_release(z12, z13, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                            if (function226 == null || f3 <= 0.0f) {
                                                composer4 = composer3;
                                                composableLambda4 = composableLambda;
                                            } else {
                                                final TextStyle textStyle = bodyLarge;
                                                final Function2<Composer, Integer, Unit> function231 = function226;
                                                composer4 = composer3;
                                                composableLambda4 = ComposableLambdaKt.composableLambda(composer4, 1824482619, z15, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1
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

                                                    public final void invoke(Composer composer5, int i28) {
                                                        ComposerKt.sourceInformation(composer5, "C149@6292L285:TextFieldImpl.kt#uh7d8r");
                                                        if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1824482619, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:149)");
                                                            }
                                                            Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                                            long j6 = m4073unboximpl2;
                                                            TextStyle textStyle2 = textStyle;
                                                            Function2<Composer, Integer, Unit> function232 = function231;
                                                            composer5.startReplaceableGroup(733328855);
                                                            ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                            }
                                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 1425713875, "C150@6365L190:TextFieldImpl.kt#uh7d8r");
                                                            TextFieldImplKt.m2771DecorationKTwxG1Y(j6, textStyle2, function232, composer5, 0, 0);
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
                                                });
                                            }
                                            final long m4073unboximpl3 = textFieldColors.suffixColor$material3_release(z12, z13, interactionSource, composer4, 0).getValue().m4073unboximpl();
                                            if (function221 == null || f3 <= 0.0f) {
                                                composableLambda5 = composableLambda;
                                            } else {
                                                final TextStyle textStyle2 = bodyLarge;
                                                final Function2<Composer, Integer, Unit> function232 = function221;
                                                composableLambda5 = ComposableLambdaKt.composableLambda(composer4, 907456412, z15, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1
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

                                                    public final void invoke(Composer composer5, int i28) {
                                                        ComposerKt.sourceInformation(composer5, "C163@6884L285:TextFieldImpl.kt#uh7d8r");
                                                        if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(907456412, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:163)");
                                                            }
                                                            Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                                            long j6 = m4073unboximpl3;
                                                            TextStyle textStyle3 = textStyle2;
                                                            Function2<Composer, Integer, Unit> function233 = function232;
                                                            composer5.startReplaceableGroup(733328855);
                                                            ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                            composer5.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                            }
                                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                            composer5.startReplaceableGroup(2058660585);
                                                            ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer5, 1425714467, "C164@6957L190:TextFieldImpl.kt#uh7d8r");
                                                            TextFieldImplKt.m2771DecorationKTwxG1Y(j6, textStyle3, function233, composer5, 0, 0);
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
                                                });
                                            }
                                            Composer composer5 = composer4;
                                            final long m4073unboximpl4 = textFieldColors.leadingIconColor$material3_release(z12, z13, interactionSource, composer5, 0).getValue().m4073unboximpl();
                                            final Function2<Composer, Integer, Unit> function233 = function228;
                                            ComposableLambda composableLambda7 = function233 != null ? ComposableLambdaKt.composableLambda(composer5, 90769583, z15, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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

                                                public final void invoke(Composer composer6, int i28) {
                                                    ComposerKt.sourceInformation(composer6, "C176@7430L57:TextFieldImpl.kt#uh7d8r");
                                                    if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                                        composer6.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(90769583, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:176)");
                                                    }
                                                    TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl4, null, function233, composer6, 0, 2);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }) : composableLambda;
                                            final long m4073unboximpl5 = textFieldColors.trailingIconColor$material3_release(z12, z13, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                            final Function2<Composer, Integer, Unit> function234 = function224;
                                            ComposableLambda composableLambda8 = function234 != null ? ComposableLambdaKt.composableLambda(composer3, 2077796155, z15, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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

                                                public final void invoke(Composer composer6, int i28) {
                                                    ComposerKt.sourceInformation(composer6, "C183@7734L58:TextFieldImpl.kt#uh7d8r");
                                                    if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                                        composer6.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(2077796155, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:183)");
                                                    }
                                                    TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl5, null, function234, composer6, 0, 2);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }) : composableLambda;
                                            final long m4073unboximpl6 = textFieldColors.supportingTextColor$material3_release(z12, z13, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                            final Function2<Composer, Integer, Unit> function235 = function223;
                                            if (function235 != null) {
                                                final TextStyle textStyle3 = bodySmall;
                                                composableLambda6 = ComposableLambdaKt.composableLambda(composer3, -1531019900, z15, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
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

                                                    public final void invoke(Composer composer6, int i28) {
                                                        ComposerKt.sourceInformation(composer6, "C191@8059L84:TextFieldImpl.kt#uh7d8r");
                                                        if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                                            composer6.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-1531019900, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:191)");
                                                        }
                                                        TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl6, textStyle3, function235, composer6, 0, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                });
                                            } else {
                                                composableLambda6 = null;
                                            }
                                            int i28 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                                            if (i28 == z15) {
                                                ComposableLambda composableLambda9 = composableLambda6;
                                                composer3.startReplaceableGroup(404042583);
                                                ComposerKt.sourceInformation(composer3, "204@8500L667");
                                                final Function2<Composer, Integer, Unit> function236 = function29;
                                                TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function227, composableLambda2, composableLambda3, composableLambda7, composableLambda8, composableLambda4, composableLambda5, z9, f, ComposableLambdaKt.composableLambda(composer3, -2124779163, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
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

                                                    public final void invoke(Composer composer6, int i29) {
                                                        ComposerKt.sourceInformation(composer6, "C198@8313L151:TextFieldImpl.kt#uh7d8r");
                                                        if ((i29 & 3) != 2 || !composer6.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-2124779163, i29, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:198)");
                                                            }
                                                            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId);
                                                            Function2<Composer, Integer, Unit> function237 = function236;
                                                            composer6.startReplaceableGroup(733328855);
                                                            ComposerKt.sourceInformation(composer6, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer6, 48);
                                                            composer6.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                                            CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(layoutId);
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
                                                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                            }
                                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                                            composer6.startReplaceableGroup(2058660585);
                                                            ComposerKt.sourceInformationMarkerStart(composer6, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer6, 1425715941, "C200@8431L11:TextFieldImpl.kt#uh7d8r");
                                                            function237.invoke(composer6, 0);
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
                                                }), composableLambda9, paddingValues, composer3, ((i27 << 27) & 1879048192) | 6, 6);
                                                composer3.endReplaceableGroup();
                                            } else if (i28 == 2) {
                                                composer3.startReplaceableGroup(404043576);
                                                ComposerKt.sourceInformation(composer3, "222@9289L38,245@10297L420,234@9756L1141");
                                                composer3.startReplaceableGroup(404043645);
                                                ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                                Object rememberedValue2 = composer3.rememberedValue();
                                                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m3879boximpl(Size.INSTANCE.m3900getZeroNHjbRc()), null, 2, null);
                                                    composer3.updateRememberedValue(rememberedValue2);
                                                }
                                                final MutableState mutableState = (MutableState) rememberedValue2;
                                                composer3.endReplaceableGroup();
                                                final PaddingValues paddingValues2 = paddingValues;
                                                final Function2<Composer, Integer, Unit> function237 = function29;
                                                ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composer3, 1902535592, z15, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
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

                                                    public final void invoke(Composer composer6, int i29) {
                                                        ComposerKt.sourceInformation(composer6, "C224@9418L302:TextFieldImpl.kt#uh7d8r");
                                                        if ((i29 & 3) != 2 || !composer6.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1902535592, i29, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:224)");
                                                            }
                                                            Modifier m2393outlineCutout12SF9DM = OutlinedTextFieldKt.m2393outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId), mutableState.getValue().getPackedValue(), paddingValues2);
                                                            Function2<Composer, Integer, Unit> function238 = function237;
                                                            composer6.startReplaceableGroup(733328855);
                                                            ComposerKt.sourceInformation(composer6, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer6, 48);
                                                            composer6.startReplaceableGroup(-1323940314);
                                                            ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                                            CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m2393outlineCutout12SF9DM);
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
                                                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                            }
                                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                                            composer6.startReplaceableGroup(2058660585);
                                                            ComposerKt.sourceInformationMarkerStart(composer6, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                            ComposerKt.sourceInformationMarkerStart(composer6, 1425717197, "C230@9687L11:TextFieldImpl.kt#uh7d8r");
                                                            function238.invoke(composer6, 0);
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
                                                });
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                ComposableLambda composableLambda11 = composableLambda2;
                                                ComposableLambda composableLambda12 = composableLambda5;
                                                ComposableLambda composableLambda13 = composableLambda6;
                                                Function2<Composer, Integer, Unit> function238 = function227;
                                                ComposableLambda composableLambda14 = composableLambda3;
                                                boolean z17 = z9;
                                                composer3.startReplaceableGroup(404044653);
                                                ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                                boolean z18 = (i27 & 14) == 4;
                                                Object rememberedValue3 = composer3.rememberedValue();
                                                if (z18 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                                            m2773invokeuvyYCjk(size.getPackedValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke-uvyYCjk, reason: not valid java name */
                                                        public final void m2773invokeuvyYCjk(long j6) {
                                                            float m3891getWidthimpl = Size.m3891getWidthimpl(j6) * f4;
                                                            float m3888getHeightimpl = Size.m3888getHeightimpl(j6) * f4;
                                                            if (Size.m3891getWidthimpl(mutableState.getValue().getPackedValue()) == m3891getWidthimpl && Size.m3888getHeightimpl(mutableState.getValue().getPackedValue()) == m3888getHeightimpl) {
                                                                return;
                                                            }
                                                            mutableState.setValue(Size.m3879boximpl(SizeKt.Size(m3891getWidthimpl, m3888getHeightimpl)));
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(rememberedValue3);
                                                }
                                                composer3.endReplaceableGroup();
                                                OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function238, composableLambda14, composableLambda11, composableLambda7, composableLambda8, composableLambda4, composableLambda12, z17, f, (Function1) rememberedValue3, composableLambda10, composableLambda13, paddingValues, composer3, ((i27 << 27) & 1879048192) | 6, 48);
                                                composer3.endReplaceableGroup();
                                            } else {
                                                composer3.startReplaceableGroup(404045277);
                                                composer3.endReplaceableGroup();
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                };
                                Function2<? super Composer, ? super Integer, Unit> function229 = function221;
                                boolean z15 = z9;
                                textFieldTransitionScope.m2779TransitionDTcfvLk(inputPhase, j, j2, function3, z14, ComposableLambdaKt.composableLambda(startRestartGroup, 1290853831, true, function7), startRestartGroup, 1769472);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer2 = startRestartGroup;
                                function213 = function225;
                                z6 = z12;
                                function214 = function228;
                                z7 = z13;
                                function215 = function224;
                                function216 = function226;
                                function217 = function229;
                                function218 = function223;
                                z8 = z15;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                function216 = function26;
                                function217 = function27;
                                function218 = function28;
                                z8 = z;
                                z7 = z3;
                                composer2 = startRestartGroup;
                                function214 = function212;
                                function213 = function211;
                                function215 = function25;
                                z6 = z2;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$4
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

                                    public final void invoke(Composer composer3, int i25) {
                                        TextFieldImplKt.CommonDecorationBox(TextFieldType.this, str, function2, visualTransformation, function22, function213, function214, function215, function216, function217, function218, z8, z6, z7, interactionSource, paddingValues, textFieldColors, function29, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i3 & 65536) == 0) {
                        }
                        if ((i3 & 131072) == 0) {
                        }
                        if ((i4 & 306783379) == 306783378) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        if (i11 == 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i16 == 0) {
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function2232 = function222;
                        if (i17 == 0) {
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function2242 = function219;
                        if (i19 == 0) {
                        }
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(-646389284);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TextFieldImpl.kt#9igjgp");
                        z4 = ((i4 & 112) != 32) | ((i4 & 7168) != 2048);
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z4) {
                        }
                        rememberedValue = visualTransformation.filter(new AnnotatedString(str2, null, null, 6, null));
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        startRestartGroup.endReplaceableGroup();
                        final String text2 = ((TransformedText) rememberedValue).getText().getText();
                        if (!FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i21 >> 12) & 14).getValue().booleanValue()) {
                        }
                        function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase2, Composer composer3, Integer num) {
                                return Color.m4053boximpl(m2774invokeXeAY9LY(inputPhase2, composer3, num.intValue()));
                            }

                            /* renamed from: invoke-XeAY9LY, reason: not valid java name */
                            public final long m2774invokeXeAY9LY(InputPhase inputPhase2, Composer composer3, int i25) {
                                composer3.startReplaceableGroup(-502832279);
                                ComposerKt.sourceInformation(composer3, "C92@3588L47:TextFieldImpl.kt#uh7d8r");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-502832279, i25, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:92)");
                                }
                                long m4073unboximpl = TextFieldColors.this.labelColor$material3_release(z10, z11, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                composer3.endReplaceableGroup();
                                return m4073unboximpl;
                            }
                        };
                        Typography typography2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                        final TextStyle bodyLarge2 = typography2.getBodyLarge();
                        final TextStyle bodySmall2 = typography2.getBodySmall();
                        final boolean z122 = z10;
                        final boolean z132 = z11;
                        if (Color.m4064equalsimpl0(bodyLarge2.m5918getColor0d7_KjU(), Color.INSTANCE.m4099getUnspecified0d7_KjU())) {
                        }
                        TextFieldTransitionScope textFieldTransitionScope2 = TextFieldTransitionScope.INSTANCE;
                        startRestartGroup.startReplaceableGroup(-646388325);
                        ComposerKt.sourceInformation(startRestartGroup, "*104@4123L10");
                        m5918getColor0d7_KjU = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall().m5918getColor0d7_KjU();
                        startRestartGroup.startReplaceableGroup(-646388264);
                        ComposerKt.sourceInformation(startRestartGroup, "*105@4217L22");
                        if (z5) {
                            m5918getColor0d7_KjU = function3.invoke(inputPhase, startRestartGroup, 0).m4073unboximpl();
                        }
                        long j3 = m5918getColor0d7_KjU;
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.startReplaceableGroup(-646388132);
                        ComposerKt.sourceInformation(startRestartGroup, "*107@4316L10");
                        m5918getColor0d7_KjU2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodyLarge().m5918getColor0d7_KjU();
                        startRestartGroup.startReplaceableGroup(-646388071);
                        ComposerKt.sourceInformation(startRestartGroup, "*108@4410L22");
                        if (z5) {
                            m5918getColor0d7_KjU2 = function3.invoke(inputPhase, startRestartGroup, 0).m4073unboximpl();
                        }
                        long j22 = m5918getColor0d7_KjU2;
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        if (function22 == null) {
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function2252 = function211;
                        final Function2<? super Composer, ? super Integer, Unit> function2262 = function220;
                        final Function2<? super Composer, ? super Integer, Unit> function2272 = function210;
                        final Function2<? super Composer, ? super Integer, Unit> function2282 = function212;
                        Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit> function72 = new Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3

                            /* compiled from: TextFieldImpl.kt */
                            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[TextFieldType.values().length];
                                    try {
                                        iArr[TextFieldType.Filled.ordinal()] = 1;
                                    } catch (NoSuchFieldError unused) {
                                    }
                                    try {
                                        iArr[TextFieldType.Outlined.ordinal()] = 2;
                                    } catch (NoSuchFieldError unused2) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(7);
                            }

                            @Override // kotlin.jvm.functions.Function7
                            public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f2, Float f3, Composer composer3, Integer num) {
                                m2772invokeeopBjH0(f.floatValue(), color.m4073unboximpl(), color2.m4073unboximpl(), f2.floatValue(), f3.floatValue(), composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke-eopBjH0, reason: not valid java name */
                            public final void m2772invokeeopBjH0(final float f, final long j32, long j4, final float f2, final float f3, Composer composer3, int i25) {
                                int i26;
                                final long j5;
                                boolean z152;
                                final float f4;
                                ComposableLambda composableLambda;
                                ComposableLambda composableLambda2;
                                ComposableLambda composableLambda3;
                                Composer composer4;
                                ComposableLambda composableLambda4;
                                ComposableLambda composableLambda5;
                                ComposableLambda composableLambda6;
                                ComposerKt.sourceInformation(composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)131@5373L53,145@6062L48,159@6654L48,173@7251L53,180@7552L54,188@7871L56:TextFieldImpl.kt#uh7d8r");
                                if ((i25 & 6) == 0) {
                                    i26 = (composer3.changed(f) ? 4 : 2) | i25;
                                } else {
                                    i26 = i25;
                                }
                                if ((i25 & 48) == 0) {
                                    i26 |= composer3.changed(j32) ? 32 : 16;
                                }
                                if ((i25 & 384) == 0) {
                                    j5 = j4;
                                    i26 |= composer3.changed(j5) ? 256 : 128;
                                } else {
                                    j5 = j4;
                                }
                                if ((i25 & 3072) == 0) {
                                    i26 |= composer3.changed(f2) ? 2048 : 1024;
                                }
                                if ((i25 & 24576) == 0) {
                                    i26 |= composer3.changed(f3) ? 16384 : 8192;
                                }
                                int i27 = i26;
                                if ((74899 & i27) != 74898 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1290853831, i27, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:115)");
                                    }
                                    final Function2<? super Composer, ? super Integer, Unit> function2292 = function22;
                                    if (function2292 != null) {
                                        final boolean z16 = z5;
                                        z152 = true;
                                        composableLambda = null;
                                        f4 = f;
                                        composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -382297919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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

                                            public final void invoke(Composer composer5, int i28) {
                                                ComposerKt.sourceInformation(composer5, "C*118@4824L10,119@4880L10,124@5093L49:TextFieldImpl.kt#uh7d8r");
                                                if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-382297919, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:117)");
                                                    }
                                                    TextStyle lerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodyLarge(), MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodySmall(), f);
                                                    boolean z17 = z16;
                                                    long j6 = j32;
                                                    if (z17) {
                                                        lerp = TextStyle.m5901copyp1EtxEg$default(lerp, j6, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                                                    }
                                                    TextFieldImplKt.m2771DecorationKTwxG1Y(j5, lerp, function2292, composer5, 0, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer5.skipToGroupEnd();
                                            }
                                        });
                                    } else {
                                        z152 = true;
                                        f4 = f;
                                        composableLambda = null;
                                        composableLambda2 = null;
                                    }
                                    final long m4073unboximpl = textFieldColors.placeholderColor$material3_release(z122, z132, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                    if (function2252 == null || text2.length() != 0 || f2 <= 0.0f) {
                                        composableLambda3 = composableLambda;
                                    } else {
                                        final Function2<? super Composer, ? super Integer, Unit> function230 = function2252;
                                        composableLambda3 = ComposableLambdaKt.composableLambda(composer3, -524658155, z152, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(3);
                                            }

                                            @Override // kotlin.jvm.functions.Function3
                                            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer5, Integer num) {
                                                invoke(modifier, composer5, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Modifier modifier, Composer composer5, int i28) {
                                                ComposerKt.sourceInformation(composer5, "C135@5666L319:TextFieldImpl.kt#uh7d8r");
                                                if ((i28 & 6) == 0) {
                                                    i28 |= composer5.changed(modifier) ? 4 : 2;
                                                }
                                                if ((i28 & 19) != 18 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-524658155, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:135)");
                                                    }
                                                    Modifier alpha = AlphaKt.alpha(modifier, f2);
                                                    long j6 = m4073unboximpl;
                                                    Function2<Composer, Integer, Unit> function231 = function230;
                                                    composer5.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 1425713248, "C138@5866L10,136@5738L225:TextFieldImpl.kt#uh7d8r");
                                                    TextFieldImplKt.m2771DecorationKTwxG1Y(j6, MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodyLarge(), function231, composer5, 0, 0);
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
                                        });
                                    }
                                    final long m4073unboximpl2 = textFieldColors.prefixColor$material3_release(z122, z132, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                    if (function2262 == null || f3 <= 0.0f) {
                                        composer4 = composer3;
                                        composableLambda4 = composableLambda;
                                    } else {
                                        final TextStyle textStyle = bodyLarge2;
                                        final Function2<? super Composer, ? super Integer, Unit> function231 = function2262;
                                        composer4 = composer3;
                                        composableLambda4 = ComposableLambdaKt.composableLambda(composer4, 1824482619, z152, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1
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

                                            public final void invoke(Composer composer5, int i28) {
                                                ComposerKt.sourceInformation(composer5, "C149@6292L285:TextFieldImpl.kt#uh7d8r");
                                                if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1824482619, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:149)");
                                                    }
                                                    Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                                    long j6 = m4073unboximpl2;
                                                    TextStyle textStyle2 = textStyle;
                                                    Function2<Composer, Integer, Unit> function232 = function231;
                                                    composer5.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 1425713875, "C150@6365L190:TextFieldImpl.kt#uh7d8r");
                                                    TextFieldImplKt.m2771DecorationKTwxG1Y(j6, textStyle2, function232, composer5, 0, 0);
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
                                        });
                                    }
                                    final long m4073unboximpl3 = textFieldColors.suffixColor$material3_release(z122, z132, interactionSource, composer4, 0).getValue().m4073unboximpl();
                                    if (function221 == null || f3 <= 0.0f) {
                                        composableLambda5 = composableLambda;
                                    } else {
                                        final TextStyle textStyle2 = bodyLarge2;
                                        final Function2<? super Composer, ? super Integer, Unit> function232 = function221;
                                        composableLambda5 = ComposableLambdaKt.composableLambda(composer4, 907456412, z152, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1
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

                                            public final void invoke(Composer composer5, int i28) {
                                                ComposerKt.sourceInformation(composer5, "C163@6884L285:TextFieldImpl.kt#uh7d8r");
                                                if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(907456412, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:163)");
                                                    }
                                                    Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                                    long j6 = m4073unboximpl3;
                                                    TextStyle textStyle3 = textStyle2;
                                                    Function2<Composer, Integer, Unit> function233 = function232;
                                                    composer5.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                    composer5.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                    composer5.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer5, 1425714467, "C164@6957L190:TextFieldImpl.kt#uh7d8r");
                                                    TextFieldImplKt.m2771DecorationKTwxG1Y(j6, textStyle3, function233, composer5, 0, 0);
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
                                        });
                                    }
                                    Composer composer5 = composer4;
                                    final long m4073unboximpl4 = textFieldColors.leadingIconColor$material3_release(z122, z132, interactionSource, composer5, 0).getValue().m4073unboximpl();
                                    final Function2<? super Composer, ? super Integer, Unit> function233 = function2282;
                                    ComposableLambda composableLambda7 = function233 != null ? ComposableLambdaKt.composableLambda(composer5, 90769583, z152, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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

                                        public final void invoke(Composer composer6, int i28) {
                                            ComposerKt.sourceInformation(composer6, "C176@7430L57:TextFieldImpl.kt#uh7d8r");
                                            if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(90769583, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:176)");
                                            }
                                            TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl4, null, function233, composer6, 0, 2);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }) : composableLambda;
                                    final long m4073unboximpl5 = textFieldColors.trailingIconColor$material3_release(z122, z132, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                    final Function2<? super Composer, ? super Integer, Unit> function234 = function2242;
                                    ComposableLambda composableLambda8 = function234 != null ? ComposableLambdaKt.composableLambda(composer3, 2077796155, z152, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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

                                        public final void invoke(Composer composer6, int i28) {
                                            ComposerKt.sourceInformation(composer6, "C183@7734L58:TextFieldImpl.kt#uh7d8r");
                                            if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(2077796155, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:183)");
                                            }
                                            TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl5, null, function234, composer6, 0, 2);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }) : composableLambda;
                                    final long m4073unboximpl6 = textFieldColors.supportingTextColor$material3_release(z122, z132, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                    final Function2<? super Composer, ? super Integer, Unit> function235 = function2232;
                                    if (function235 != null) {
                                        final TextStyle textStyle3 = bodySmall2;
                                        composableLambda6 = ComposableLambdaKt.composableLambda(composer3, -1531019900, z152, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
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

                                            public final void invoke(Composer composer6, int i28) {
                                                ComposerKt.sourceInformation(composer6, "C191@8059L84:TextFieldImpl.kt#uh7d8r");
                                                if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                                    composer6.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1531019900, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:191)");
                                                }
                                                TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl6, textStyle3, function235, composer6, 0, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        });
                                    } else {
                                        composableLambda6 = null;
                                    }
                                    int i28 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                                    if (i28 == z152) {
                                        ComposableLambda composableLambda9 = composableLambda6;
                                        composer3.startReplaceableGroup(404042583);
                                        ComposerKt.sourceInformation(composer3, "204@8500L667");
                                        final Function2<? super Composer, ? super Integer, Unit> function236 = function29;
                                        TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function2272, composableLambda2, composableLambda3, composableLambda7, composableLambda8, composableLambda4, composableLambda5, z9, f, ComposableLambdaKt.composableLambda(composer3, -2124779163, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
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

                                            public final void invoke(Composer composer6, int i29) {
                                                ComposerKt.sourceInformation(composer6, "C198@8313L151:TextFieldImpl.kt#uh7d8r");
                                                if ((i29 & 3) != 2 || !composer6.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-2124779163, i29, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:198)");
                                                    }
                                                    Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId);
                                                    Function2<Composer, Integer, Unit> function237 = function236;
                                                    composer6.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer6, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer6, 48);
                                                    composer6.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(layoutId);
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
                                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                                    composer6.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer6, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer6, 1425715941, "C200@8431L11:TextFieldImpl.kt#uh7d8r");
                                                    function237.invoke(composer6, 0);
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
                                        }), composableLambda9, paddingValues, composer3, ((i27 << 27) & 1879048192) | 6, 6);
                                        composer3.endReplaceableGroup();
                                    } else if (i28 == 2) {
                                        composer3.startReplaceableGroup(404043576);
                                        ComposerKt.sourceInformation(composer3, "222@9289L38,245@10297L420,234@9756L1141");
                                        composer3.startReplaceableGroup(404043645);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                        Object rememberedValue2 = composer3.rememberedValue();
                                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m3879boximpl(Size.INSTANCE.m3900getZeroNHjbRc()), null, 2, null);
                                            composer3.updateRememberedValue(rememberedValue2);
                                        }
                                        final MutableState<Size> mutableState = (MutableState) rememberedValue2;
                                        composer3.endReplaceableGroup();
                                        final PaddingValues paddingValues2 = paddingValues;
                                        final Function2<? super Composer, ? super Integer, Unit> function237 = function29;
                                        ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composer3, 1902535592, z152, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
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

                                            public final void invoke(Composer composer6, int i29) {
                                                ComposerKt.sourceInformation(composer6, "C224@9418L302:TextFieldImpl.kt#uh7d8r");
                                                if ((i29 & 3) != 2 || !composer6.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1902535592, i29, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:224)");
                                                    }
                                                    Modifier m2393outlineCutout12SF9DM = OutlinedTextFieldKt.m2393outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId), mutableState.getValue().getPackedValue(), paddingValues2);
                                                    Function2<Composer, Integer, Unit> function238 = function237;
                                                    composer6.startReplaceableGroup(733328855);
                                                    ComposerKt.sourceInformation(composer6, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer6, 48);
                                                    composer6.startReplaceableGroup(-1323940314);
                                                    ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                                    CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m2393outlineCutout12SF9DM);
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
                                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                    }
                                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                                    composer6.startReplaceableGroup(2058660585);
                                                    ComposerKt.sourceInformationMarkerStart(composer6, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(composer6, 1425717197, "C230@9687L11:TextFieldImpl.kt#uh7d8r");
                                                    function238.invoke(composer6, 0);
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
                                        });
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        ComposableLambda composableLambda11 = composableLambda2;
                                        ComposableLambda composableLambda12 = composableLambda5;
                                        ComposableLambda composableLambda13 = composableLambda6;
                                        Function2<Composer, Integer, Unit> function238 = function2272;
                                        ComposableLambda composableLambda14 = composableLambda3;
                                        boolean z17 = z9;
                                        composer3.startReplaceableGroup(404044653);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                        boolean z18 = (i27 & 14) == 4;
                                        Object rememberedValue3 = composer3.rememberedValue();
                                        if (z18 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                                    m2773invokeuvyYCjk(size.getPackedValue());
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke-uvyYCjk, reason: not valid java name */
                                                public final void m2773invokeuvyYCjk(long j6) {
                                                    float m3891getWidthimpl = Size.m3891getWidthimpl(j6) * f4;
                                                    float m3888getHeightimpl = Size.m3888getHeightimpl(j6) * f4;
                                                    if (Size.m3891getWidthimpl(mutableState.getValue().getPackedValue()) == m3891getWidthimpl && Size.m3888getHeightimpl(mutableState.getValue().getPackedValue()) == m3888getHeightimpl) {
                                                        return;
                                                    }
                                                    mutableState.setValue(Size.m3879boximpl(SizeKt.Size(m3891getWidthimpl, m3888getHeightimpl)));
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue3);
                                        }
                                        composer3.endReplaceableGroup();
                                        OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function238, composableLambda14, composableLambda11, composableLambda7, composableLambda8, composableLambda4, composableLambda12, z17, f, (Function1) rememberedValue3, composableLambda10, composableLambda13, paddingValues, composer3, ((i27 << 27) & 1879048192) | 6, 48);
                                        composer3.endReplaceableGroup();
                                    } else {
                                        composer3.startReplaceableGroup(404045277);
                                        composer3.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        };
                        Function2<? super Composer, ? super Integer, Unit> function2292 = function221;
                        boolean z152 = z9;
                        textFieldTransitionScope2.m2779TransitionDTcfvLk(inputPhase, j3, j22, function3, z14, ComposableLambdaKt.composableLambda(startRestartGroup, 1290853831, true, function72), startRestartGroup, 1769472);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        composer2 = startRestartGroup;
                        function213 = function2252;
                        z6 = z122;
                        function214 = function2282;
                        z7 = z132;
                        function215 = function2242;
                        function216 = function2262;
                        function217 = function2292;
                        function218 = function2232;
                        z8 = z152;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i11 = i10;
                    i12 = i3 & 1024;
                    if (i12 != 0) {
                    }
                    i15 = i3 & 2048;
                    if (i15 != 0) {
                    }
                    int i222 = i14;
                    i17 = i3 & 4096;
                    if (i17 != 0) {
                    }
                    i19 = i3 & 8192;
                    if (i19 != 0) {
                    }
                    if ((i3 & 16384) != 0) {
                    }
                    if ((32768 & i3) != 0) {
                    }
                    if ((i3 & 65536) == 0) {
                    }
                    if ((i3 & 131072) == 0) {
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (i11 == 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i16 == 0) {
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function22322 = function222;
                    if (i17 == 0) {
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function22422 = function219;
                    if (i19 == 0) {
                    }
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-646389284);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TextFieldImpl.kt#9igjgp");
                    z4 = ((i4 & 112) != 32) | ((i4 & 7168) != 2048);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z4) {
                    }
                    rememberedValue = visualTransformation.filter(new AnnotatedString(str2, null, null, 6, null));
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    startRestartGroup.endReplaceableGroup();
                    final String text22 = ((TransformedText) rememberedValue).getText().getText();
                    if (!FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i21 >> 12) & 14).getValue().booleanValue()) {
                    }
                    function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase2, Composer composer3, Integer num) {
                            return Color.m4053boximpl(m2774invokeXeAY9LY(inputPhase2, composer3, num.intValue()));
                        }

                        /* renamed from: invoke-XeAY9LY, reason: not valid java name */
                        public final long m2774invokeXeAY9LY(InputPhase inputPhase2, Composer composer3, int i25) {
                            composer3.startReplaceableGroup(-502832279);
                            ComposerKt.sourceInformation(composer3, "C92@3588L47:TextFieldImpl.kt#uh7d8r");
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-502832279, i25, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:92)");
                            }
                            long m4073unboximpl = TextFieldColors.this.labelColor$material3_release(z10, z11, interactionSource, composer3, 0).getValue().m4073unboximpl();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer3.endReplaceableGroup();
                            return m4073unboximpl;
                        }
                    };
                    Typography typography22 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                    final TextStyle bodyLarge22 = typography22.getBodyLarge();
                    final TextStyle bodySmall22 = typography22.getBodySmall();
                    final boolean z1222 = z10;
                    final boolean z1322 = z11;
                    if (Color.m4064equalsimpl0(bodyLarge22.m5918getColor0d7_KjU(), Color.INSTANCE.m4099getUnspecified0d7_KjU())) {
                    }
                    TextFieldTransitionScope textFieldTransitionScope22 = TextFieldTransitionScope.INSTANCE;
                    startRestartGroup.startReplaceableGroup(-646388325);
                    ComposerKt.sourceInformation(startRestartGroup, "*104@4123L10");
                    m5918getColor0d7_KjU = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall().m5918getColor0d7_KjU();
                    startRestartGroup.startReplaceableGroup(-646388264);
                    ComposerKt.sourceInformation(startRestartGroup, "*105@4217L22");
                    if (z5) {
                    }
                    long j32 = m5918getColor0d7_KjU;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-646388132);
                    ComposerKt.sourceInformation(startRestartGroup, "*107@4316L10");
                    m5918getColor0d7_KjU2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodyLarge().m5918getColor0d7_KjU();
                    startRestartGroup.startReplaceableGroup(-646388071);
                    ComposerKt.sourceInformation(startRestartGroup, "*108@4410L22");
                    if (z5) {
                    }
                    long j222 = m5918getColor0d7_KjU2;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.endReplaceableGroup();
                    if (function22 == null) {
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function22522 = function211;
                    final Function2<? super Composer, ? super Integer, Unit> function22622 = function220;
                    final Function2<? super Composer, ? super Integer, Unit> function22722 = function210;
                    final Function2<? super Composer, ? super Integer, Unit> function22822 = function212;
                    Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit> function722 = new Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3

                        /* compiled from: TextFieldImpl.kt */
                        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                        public /* synthetic */ class WhenMappings {
                            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                            static {
                                int[] iArr = new int[TextFieldType.values().length];
                                try {
                                    iArr[TextFieldType.Filled.ordinal()] = 1;
                                } catch (NoSuchFieldError unused) {
                                }
                                try {
                                    iArr[TextFieldType.Outlined.ordinal()] = 2;
                                } catch (NoSuchFieldError unused2) {
                                }
                                $EnumSwitchMapping$0 = iArr;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(7);
                        }

                        @Override // kotlin.jvm.functions.Function7
                        public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f2, Float f3, Composer composer3, Integer num) {
                            m2772invokeeopBjH0(f.floatValue(), color.m4073unboximpl(), color2.m4073unboximpl(), f2.floatValue(), f3.floatValue(), composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke-eopBjH0, reason: not valid java name */
                        public final void m2772invokeeopBjH0(final float f, final long j322, long j4, final float f2, final float f3, Composer composer3, int i25) {
                            int i26;
                            final long j5;
                            boolean z1522;
                            final float f4;
                            ComposableLambda composableLambda;
                            ComposableLambda composableLambda2;
                            ComposableLambda composableLambda3;
                            Composer composer4;
                            ComposableLambda composableLambda4;
                            ComposableLambda composableLambda5;
                            ComposableLambda composableLambda6;
                            ComposerKt.sourceInformation(composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)131@5373L53,145@6062L48,159@6654L48,173@7251L53,180@7552L54,188@7871L56:TextFieldImpl.kt#uh7d8r");
                            if ((i25 & 6) == 0) {
                                i26 = (composer3.changed(f) ? 4 : 2) | i25;
                            } else {
                                i26 = i25;
                            }
                            if ((i25 & 48) == 0) {
                                i26 |= composer3.changed(j322) ? 32 : 16;
                            }
                            if ((i25 & 384) == 0) {
                                j5 = j4;
                                i26 |= composer3.changed(j5) ? 256 : 128;
                            } else {
                                j5 = j4;
                            }
                            if ((i25 & 3072) == 0) {
                                i26 |= composer3.changed(f2) ? 2048 : 1024;
                            }
                            if ((i25 & 24576) == 0) {
                                i26 |= composer3.changed(f3) ? 16384 : 8192;
                            }
                            int i27 = i26;
                            if ((74899 & i27) != 74898 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1290853831, i27, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:115)");
                                }
                                final Function2<? super Composer, ? super Integer, Unit> function22922 = function22;
                                if (function22922 != null) {
                                    final boolean z16 = z5;
                                    z1522 = true;
                                    composableLambda = null;
                                    f4 = f;
                                    composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -382297919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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

                                        public final void invoke(Composer composer5, int i28) {
                                            ComposerKt.sourceInformation(composer5, "C*118@4824L10,119@4880L10,124@5093L49:TextFieldImpl.kt#uh7d8r");
                                            if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-382297919, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:117)");
                                                }
                                                TextStyle lerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodyLarge(), MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodySmall(), f);
                                                boolean z17 = z16;
                                                long j6 = j322;
                                                if (z17) {
                                                    lerp = TextStyle.m5901copyp1EtxEg$default(lerp, j6, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                                                }
                                                TextFieldImplKt.m2771DecorationKTwxG1Y(j5, lerp, function22922, composer5, 0, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer5.skipToGroupEnd();
                                        }
                                    });
                                } else {
                                    z1522 = true;
                                    f4 = f;
                                    composableLambda = null;
                                    composableLambda2 = null;
                                }
                                final long m4073unboximpl = textFieldColors.placeholderColor$material3_release(z1222, z1322, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                if (function22522 == null || text22.length() != 0 || f2 <= 0.0f) {
                                    composableLambda3 = composableLambda;
                                } else {
                                    final Function2<? super Composer, ? super Integer, Unit> function230 = function22522;
                                    composableLambda3 = ComposableLambdaKt.composableLambda(composer3, -524658155, z1522, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer5, Integer num) {
                                            invoke(modifier, composer5, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Modifier modifier, Composer composer5, int i28) {
                                            ComposerKt.sourceInformation(composer5, "C135@5666L319:TextFieldImpl.kt#uh7d8r");
                                            if ((i28 & 6) == 0) {
                                                i28 |= composer5.changed(modifier) ? 4 : 2;
                                            }
                                            if ((i28 & 19) != 18 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-524658155, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:135)");
                                                }
                                                Modifier alpha = AlphaKt.alpha(modifier, f2);
                                                long j6 = m4073unboximpl;
                                                Function2<Composer, Integer, Unit> function231 = function230;
                                                composer5.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                composer5.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer5, 1425713248, "C138@5866L10,136@5738L225:TextFieldImpl.kt#uh7d8r");
                                                TextFieldImplKt.m2771DecorationKTwxG1Y(j6, MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodyLarge(), function231, composer5, 0, 0);
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
                                    });
                                }
                                final long m4073unboximpl2 = textFieldColors.prefixColor$material3_release(z1222, z1322, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                if (function22622 == null || f3 <= 0.0f) {
                                    composer4 = composer3;
                                    composableLambda4 = composableLambda;
                                } else {
                                    final TextStyle textStyle = bodyLarge22;
                                    final Function2<? super Composer, ? super Integer, Unit> function231 = function22622;
                                    composer4 = composer3;
                                    composableLambda4 = ComposableLambdaKt.composableLambda(composer4, 1824482619, z1522, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1
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

                                        public final void invoke(Composer composer5, int i28) {
                                            ComposerKt.sourceInformation(composer5, "C149@6292L285:TextFieldImpl.kt#uh7d8r");
                                            if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1824482619, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:149)");
                                                }
                                                Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                                long j6 = m4073unboximpl2;
                                                TextStyle textStyle2 = textStyle;
                                                Function2<Composer, Integer, Unit> function232 = function231;
                                                composer5.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                composer5.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer5, 1425713875, "C150@6365L190:TextFieldImpl.kt#uh7d8r");
                                                TextFieldImplKt.m2771DecorationKTwxG1Y(j6, textStyle2, function232, composer5, 0, 0);
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
                                    });
                                }
                                final long m4073unboximpl3 = textFieldColors.suffixColor$material3_release(z1222, z1322, interactionSource, composer4, 0).getValue().m4073unboximpl();
                                if (function221 == null || f3 <= 0.0f) {
                                    composableLambda5 = composableLambda;
                                } else {
                                    final TextStyle textStyle2 = bodyLarge22;
                                    final Function2<? super Composer, ? super Integer, Unit> function232 = function221;
                                    composableLambda5 = ComposableLambdaKt.composableLambda(composer4, 907456412, z1522, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1
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

                                        public final void invoke(Composer composer5, int i28) {
                                            ComposerKt.sourceInformation(composer5, "C163@6884L285:TextFieldImpl.kt#uh7d8r");
                                            if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(907456412, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:163)");
                                                }
                                                Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                                long j6 = m4073unboximpl3;
                                                TextStyle textStyle3 = textStyle2;
                                                Function2<Composer, Integer, Unit> function233 = function232;
                                                composer5.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                                composer5.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                                composer5.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer5, 1425714467, "C164@6957L190:TextFieldImpl.kt#uh7d8r");
                                                TextFieldImplKt.m2771DecorationKTwxG1Y(j6, textStyle3, function233, composer5, 0, 0);
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
                                    });
                                }
                                Composer composer5 = composer4;
                                final long m4073unboximpl4 = textFieldColors.leadingIconColor$material3_release(z1222, z1322, interactionSource, composer5, 0).getValue().m4073unboximpl();
                                final Function2<? super Composer, ? super Integer, Unit> function233 = function22822;
                                ComposableLambda composableLambda7 = function233 != null ? ComposableLambdaKt.composableLambda(composer5, 90769583, z1522, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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

                                    public final void invoke(Composer composer6, int i28) {
                                        ComposerKt.sourceInformation(composer6, "C176@7430L57:TextFieldImpl.kt#uh7d8r");
                                        if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(90769583, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:176)");
                                        }
                                        TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl4, null, function233, composer6, 0, 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }) : composableLambda;
                                final long m4073unboximpl5 = textFieldColors.trailingIconColor$material3_release(z1222, z1322, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                final Function2<? super Composer, ? super Integer, Unit> function234 = function22422;
                                ComposableLambda composableLambda8 = function234 != null ? ComposableLambdaKt.composableLambda(composer3, 2077796155, z1522, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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

                                    public final void invoke(Composer composer6, int i28) {
                                        ComposerKt.sourceInformation(composer6, "C183@7734L58:TextFieldImpl.kt#uh7d8r");
                                        if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2077796155, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:183)");
                                        }
                                        TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl5, null, function234, composer6, 0, 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }) : composableLambda;
                                final long m4073unboximpl6 = textFieldColors.supportingTextColor$material3_release(z1222, z1322, interactionSource, composer3, 0).getValue().m4073unboximpl();
                                final Function2<? super Composer, ? super Integer, Unit> function235 = function22322;
                                if (function235 != null) {
                                    final TextStyle textStyle3 = bodySmall22;
                                    composableLambda6 = ComposableLambdaKt.composableLambda(composer3, -1531019900, z1522, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
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

                                        public final void invoke(Composer composer6, int i28) {
                                            ComposerKt.sourceInformation(composer6, "C191@8059L84:TextFieldImpl.kt#uh7d8r");
                                            if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                                composer6.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1531019900, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:191)");
                                            }
                                            TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl6, textStyle3, function235, composer6, 0, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                } else {
                                    composableLambda6 = null;
                                }
                                int i28 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                                if (i28 == z1522) {
                                    ComposableLambda composableLambda9 = composableLambda6;
                                    composer3.startReplaceableGroup(404042583);
                                    ComposerKt.sourceInformation(composer3, "204@8500L667");
                                    final Function2<? super Composer, ? super Integer, Unit> function236 = function29;
                                    TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function22722, composableLambda2, composableLambda3, composableLambda7, composableLambda8, composableLambda4, composableLambda5, z9, f, ComposableLambdaKt.composableLambda(composer3, -2124779163, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
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

                                        public final void invoke(Composer composer6, int i29) {
                                            ComposerKt.sourceInformation(composer6, "C198@8313L151:TextFieldImpl.kt#uh7d8r");
                                            if ((i29 & 3) != 2 || !composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-2124779163, i29, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:198)");
                                                }
                                                Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId);
                                                Function2<Composer, Integer, Unit> function237 = function236;
                                                composer6.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer6, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer6, 48);
                                                composer6.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(layoutId);
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
                                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                                composer6.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer6, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer6, 1425715941, "C200@8431L11:TextFieldImpl.kt#uh7d8r");
                                                function237.invoke(composer6, 0);
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
                                    }), composableLambda9, paddingValues, composer3, ((i27 << 27) & 1879048192) | 6, 6);
                                    composer3.endReplaceableGroup();
                                } else if (i28 == 2) {
                                    composer3.startReplaceableGroup(404043576);
                                    ComposerKt.sourceInformation(composer3, "222@9289L38,245@10297L420,234@9756L1141");
                                    composer3.startReplaceableGroup(404043645);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                    Object rememberedValue2 = composer3.rememberedValue();
                                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m3879boximpl(Size.INSTANCE.m3900getZeroNHjbRc()), null, 2, null);
                                        composer3.updateRememberedValue(rememberedValue2);
                                    }
                                    final MutableState<Size> mutableState = (MutableState) rememberedValue2;
                                    composer3.endReplaceableGroup();
                                    final PaddingValues paddingValues2 = paddingValues;
                                    final Function2<? super Composer, ? super Integer, Unit> function237 = function29;
                                    ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composer3, 1902535592, z1522, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
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

                                        public final void invoke(Composer composer6, int i29) {
                                            ComposerKt.sourceInformation(composer6, "C224@9418L302:TextFieldImpl.kt#uh7d8r");
                                            if ((i29 & 3) != 2 || !composer6.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1902535592, i29, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:224)");
                                                }
                                                Modifier m2393outlineCutout12SF9DM = OutlinedTextFieldKt.m2393outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId), mutableState.getValue().getPackedValue(), paddingValues2);
                                                Function2<Composer, Integer, Unit> function238 = function237;
                                                composer6.startReplaceableGroup(733328855);
                                                ComposerKt.sourceInformation(composer6, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer6, 48);
                                                composer6.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m2393outlineCutout12SF9DM);
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
                                                Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                                Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                                if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                    m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                    m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                                }
                                                modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                                composer6.startReplaceableGroup(2058660585);
                                                ComposerKt.sourceInformationMarkerStart(composer6, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer6, 1425717197, "C230@9687L11:TextFieldImpl.kt#uh7d8r");
                                                function238.invoke(composer6, 0);
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
                                    });
                                    Modifier.Companion companion = Modifier.INSTANCE;
                                    ComposableLambda composableLambda11 = composableLambda2;
                                    ComposableLambda composableLambda12 = composableLambda5;
                                    ComposableLambda composableLambda13 = composableLambda6;
                                    Function2<Composer, Integer, Unit> function238 = function22722;
                                    ComposableLambda composableLambda14 = composableLambda3;
                                    boolean z17 = z9;
                                    composer3.startReplaceableGroup(404044653);
                                    ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                    boolean z18 = (i27 & 14) == 4;
                                    Object rememberedValue3 = composer3.rememberedValue();
                                    if (z18 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                                m2773invokeuvyYCjk(size.getPackedValue());
                                                return Unit.INSTANCE;
                                            }

                                            /* renamed from: invoke-uvyYCjk, reason: not valid java name */
                                            public final void m2773invokeuvyYCjk(long j6) {
                                                float m3891getWidthimpl = Size.m3891getWidthimpl(j6) * f4;
                                                float m3888getHeightimpl = Size.m3888getHeightimpl(j6) * f4;
                                                if (Size.m3891getWidthimpl(mutableState.getValue().getPackedValue()) == m3891getWidthimpl && Size.m3888getHeightimpl(mutableState.getValue().getPackedValue()) == m3888getHeightimpl) {
                                                    return;
                                                }
                                                mutableState.setValue(Size.m3879boximpl(SizeKt.Size(m3891getWidthimpl, m3888getHeightimpl)));
                                            }
                                        };
                                        composer3.updateRememberedValue(rememberedValue3);
                                    }
                                    composer3.endReplaceableGroup();
                                    OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function238, composableLambda14, composableLambda11, composableLambda7, composableLambda8, composableLambda4, composableLambda12, z17, f, (Function1) rememberedValue3, composableLambda10, composableLambda13, paddingValues, composer3, ((i27 << 27) & 1879048192) | 6, 48);
                                    composer3.endReplaceableGroup();
                                } else {
                                    composer3.startReplaceableGroup(404045277);
                                    composer3.endReplaceableGroup();
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    };
                    Function2<? super Composer, ? super Integer, Unit> function22922 = function221;
                    boolean z1522 = z9;
                    textFieldTransitionScope22.m2779TransitionDTcfvLk(inputPhase, j32, j222, function3, z14, ComposableLambdaKt.composableLambda(startRestartGroup, 1290853831, true, function722), startRestartGroup, 1769472);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    composer2 = startRestartGroup;
                    function213 = function22522;
                    z6 = z1222;
                    function214 = function22822;
                    z7 = z1322;
                    function215 = function22422;
                    function216 = function22622;
                    function217 = function22922;
                    function218 = function22322;
                    z8 = z1522;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i9 = i8;
                i10 = i3 & 512;
                if (i10 == 0) {
                }
                i11 = i10;
                i12 = i3 & 1024;
                if (i12 != 0) {
                }
                i15 = i3 & 2048;
                if (i15 != 0) {
                }
                int i2222 = i14;
                i17 = i3 & 4096;
                if (i17 != 0) {
                }
                i19 = i3 & 8192;
                if (i19 != 0) {
                }
                if ((i3 & 16384) != 0) {
                }
                if ((32768 & i3) != 0) {
                }
                if ((i3 & 65536) == 0) {
                }
                if ((i3 & 131072) == 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 == 0) {
                }
                if (i9 == 0) {
                }
                if (i11 == 0) {
                }
                if (i13 == 0) {
                }
                if (i16 == 0) {
                }
                final Function2<? super Composer, ? super Integer, Unit> function223222 = function222;
                if (i17 == 0) {
                }
                final Function2<? super Composer, ? super Integer, Unit> function224222 = function219;
                if (i19 == 0) {
                }
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-646389284);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TextFieldImpl.kt#9igjgp");
                z4 = ((i4 & 112) != 32) | ((i4 & 7168) != 2048);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z4) {
                }
                rememberedValue = visualTransformation.filter(new AnnotatedString(str2, null, null, 6, null));
                startRestartGroup.updateRememberedValue(rememberedValue);
                startRestartGroup.endReplaceableGroup();
                final String text222 = ((TransformedText) rememberedValue).getText().getText();
                if (!FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i21 >> 12) & 14).getValue().booleanValue()) {
                }
                function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase2, Composer composer3, Integer num) {
                        return Color.m4053boximpl(m2774invokeXeAY9LY(inputPhase2, composer3, num.intValue()));
                    }

                    /* renamed from: invoke-XeAY9LY, reason: not valid java name */
                    public final long m2774invokeXeAY9LY(InputPhase inputPhase2, Composer composer3, int i25) {
                        composer3.startReplaceableGroup(-502832279);
                        ComposerKt.sourceInformation(composer3, "C92@3588L47:TextFieldImpl.kt#uh7d8r");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-502832279, i25, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:92)");
                        }
                        long m4073unboximpl = TextFieldColors.this.labelColor$material3_release(z10, z11, interactionSource, composer3, 0).getValue().m4073unboximpl();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        composer3.endReplaceableGroup();
                        return m4073unboximpl;
                    }
                };
                Typography typography222 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                final TextStyle bodyLarge222 = typography222.getBodyLarge();
                final TextStyle bodySmall222 = typography222.getBodySmall();
                final boolean z12222 = z10;
                final boolean z13222 = z11;
                if (Color.m4064equalsimpl0(bodyLarge222.m5918getColor0d7_KjU(), Color.INSTANCE.m4099getUnspecified0d7_KjU())) {
                }
                TextFieldTransitionScope textFieldTransitionScope222 = TextFieldTransitionScope.INSTANCE;
                startRestartGroup.startReplaceableGroup(-646388325);
                ComposerKt.sourceInformation(startRestartGroup, "*104@4123L10");
                m5918getColor0d7_KjU = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall().m5918getColor0d7_KjU();
                startRestartGroup.startReplaceableGroup(-646388264);
                ComposerKt.sourceInformation(startRestartGroup, "*105@4217L22");
                if (z5) {
                }
                long j322 = m5918getColor0d7_KjU;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-646388132);
                ComposerKt.sourceInformation(startRestartGroup, "*107@4316L10");
                m5918getColor0d7_KjU2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodyLarge().m5918getColor0d7_KjU();
                startRestartGroup.startReplaceableGroup(-646388071);
                ComposerKt.sourceInformation(startRestartGroup, "*108@4410L22");
                if (z5) {
                }
                long j2222 = m5918getColor0d7_KjU2;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                if (function22 == null) {
                }
                final Function2<? super Composer, ? super Integer, Unit> function225222 = function211;
                final Function2<? super Composer, ? super Integer, Unit> function226222 = function220;
                final Function2<? super Composer, ? super Integer, Unit> function227222 = function210;
                final Function2<? super Composer, ? super Integer, Unit> function228222 = function212;
                Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit> function7222 = new Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3

                    /* compiled from: TextFieldImpl.kt */
                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[TextFieldType.values().length];
                            try {
                                iArr[TextFieldType.Filled.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[TextFieldType.Outlined.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(7);
                    }

                    @Override // kotlin.jvm.functions.Function7
                    public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f2, Float f3, Composer composer3, Integer num) {
                        m2772invokeeopBjH0(f.floatValue(), color.m4073unboximpl(), color2.m4073unboximpl(), f2.floatValue(), f3.floatValue(), composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-eopBjH0, reason: not valid java name */
                    public final void m2772invokeeopBjH0(final float f, final long j3222, long j4, final float f2, final float f3, Composer composer3, int i25) {
                        int i26;
                        final long j5;
                        boolean z15222;
                        final float f4;
                        ComposableLambda composableLambda;
                        ComposableLambda composableLambda2;
                        ComposableLambda composableLambda3;
                        Composer composer4;
                        ComposableLambda composableLambda4;
                        ComposableLambda composableLambda5;
                        ComposableLambda composableLambda6;
                        ComposerKt.sourceInformation(composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)131@5373L53,145@6062L48,159@6654L48,173@7251L53,180@7552L54,188@7871L56:TextFieldImpl.kt#uh7d8r");
                        if ((i25 & 6) == 0) {
                            i26 = (composer3.changed(f) ? 4 : 2) | i25;
                        } else {
                            i26 = i25;
                        }
                        if ((i25 & 48) == 0) {
                            i26 |= composer3.changed(j3222) ? 32 : 16;
                        }
                        if ((i25 & 384) == 0) {
                            j5 = j4;
                            i26 |= composer3.changed(j5) ? 256 : 128;
                        } else {
                            j5 = j4;
                        }
                        if ((i25 & 3072) == 0) {
                            i26 |= composer3.changed(f2) ? 2048 : 1024;
                        }
                        if ((i25 & 24576) == 0) {
                            i26 |= composer3.changed(f3) ? 16384 : 8192;
                        }
                        int i27 = i26;
                        if ((74899 & i27) != 74898 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1290853831, i27, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:115)");
                            }
                            final Function2<? super Composer, ? super Integer, Unit> function229222 = function22;
                            if (function229222 != null) {
                                final boolean z16 = z5;
                                z15222 = true;
                                composableLambda = null;
                                f4 = f;
                                composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -382297919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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

                                    public final void invoke(Composer composer5, int i28) {
                                        ComposerKt.sourceInformation(composer5, "C*118@4824L10,119@4880L10,124@5093L49:TextFieldImpl.kt#uh7d8r");
                                        if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-382297919, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:117)");
                                            }
                                            TextStyle lerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodyLarge(), MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodySmall(), f);
                                            boolean z17 = z16;
                                            long j6 = j3222;
                                            if (z17) {
                                                lerp = TextStyle.m5901copyp1EtxEg$default(lerp, j6, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                                            }
                                            TextFieldImplKt.m2771DecorationKTwxG1Y(j5, lerp, function229222, composer5, 0, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer5.skipToGroupEnd();
                                    }
                                });
                            } else {
                                z15222 = true;
                                f4 = f;
                                composableLambda = null;
                                composableLambda2 = null;
                            }
                            final long m4073unboximpl = textFieldColors.placeholderColor$material3_release(z12222, z13222, interactionSource, composer3, 0).getValue().m4073unboximpl();
                            if (function225222 == null || text222.length() != 0 || f2 <= 0.0f) {
                                composableLambda3 = composableLambda;
                            } else {
                                final Function2<? super Composer, ? super Integer, Unit> function230 = function225222;
                                composableLambda3 = ComposableLambdaKt.composableLambda(composer3, -524658155, z15222, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer5, Integer num) {
                                        invoke(modifier, composer5, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Modifier modifier, Composer composer5, int i28) {
                                        ComposerKt.sourceInformation(composer5, "C135@5666L319:TextFieldImpl.kt#uh7d8r");
                                        if ((i28 & 6) == 0) {
                                            i28 |= composer5.changed(modifier) ? 4 : 2;
                                        }
                                        if ((i28 & 19) != 18 || !composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-524658155, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:135)");
                                            }
                                            Modifier alpha = AlphaKt.alpha(modifier, f2);
                                            long j6 = m4073unboximpl;
                                            Function2<Composer, Integer, Unit> function231 = function230;
                                            composer5.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                            composer5.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                            composer5.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer5, 1425713248, "C138@5866L10,136@5738L225:TextFieldImpl.kt#uh7d8r");
                                            TextFieldImplKt.m2771DecorationKTwxG1Y(j6, MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodyLarge(), function231, composer5, 0, 0);
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
                                });
                            }
                            final long m4073unboximpl2 = textFieldColors.prefixColor$material3_release(z12222, z13222, interactionSource, composer3, 0).getValue().m4073unboximpl();
                            if (function226222 == null || f3 <= 0.0f) {
                                composer4 = composer3;
                                composableLambda4 = composableLambda;
                            } else {
                                final TextStyle textStyle = bodyLarge222;
                                final Function2<? super Composer, ? super Integer, Unit> function231 = function226222;
                                composer4 = composer3;
                                composableLambda4 = ComposableLambdaKt.composableLambda(composer4, 1824482619, z15222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1
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

                                    public final void invoke(Composer composer5, int i28) {
                                        ComposerKt.sourceInformation(composer5, "C149@6292L285:TextFieldImpl.kt#uh7d8r");
                                        if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1824482619, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:149)");
                                            }
                                            Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                            long j6 = m4073unboximpl2;
                                            TextStyle textStyle2 = textStyle;
                                            Function2<Composer, Integer, Unit> function232 = function231;
                                            composer5.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                            composer5.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                            composer5.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer5, 1425713875, "C150@6365L190:TextFieldImpl.kt#uh7d8r");
                                            TextFieldImplKt.m2771DecorationKTwxG1Y(j6, textStyle2, function232, composer5, 0, 0);
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
                                });
                            }
                            final long m4073unboximpl3 = textFieldColors.suffixColor$material3_release(z12222, z13222, interactionSource, composer4, 0).getValue().m4073unboximpl();
                            if (function221 == null || f3 <= 0.0f) {
                                composableLambda5 = composableLambda;
                            } else {
                                final TextStyle textStyle2 = bodyLarge222;
                                final Function2<? super Composer, ? super Integer, Unit> function232 = function221;
                                composableLambda5 = ComposableLambdaKt.composableLambda(composer4, 907456412, z15222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1
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

                                    public final void invoke(Composer composer5, int i28) {
                                        ComposerKt.sourceInformation(composer5, "C163@6884L285:TextFieldImpl.kt#uh7d8r");
                                        if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(907456412, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:163)");
                                            }
                                            Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                            long j6 = m4073unboximpl3;
                                            TextStyle textStyle3 = textStyle2;
                                            Function2<Composer, Integer, Unit> function233 = function232;
                                            composer5.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                            composer5.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                            composer5.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer5, 1425714467, "C164@6957L190:TextFieldImpl.kt#uh7d8r");
                                            TextFieldImplKt.m2771DecorationKTwxG1Y(j6, textStyle3, function233, composer5, 0, 0);
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
                                });
                            }
                            Composer composer5 = composer4;
                            final long m4073unboximpl4 = textFieldColors.leadingIconColor$material3_release(z12222, z13222, interactionSource, composer5, 0).getValue().m4073unboximpl();
                            final Function2<? super Composer, ? super Integer, Unit> function233 = function228222;
                            ComposableLambda composableLambda7 = function233 != null ? ComposableLambdaKt.composableLambda(composer5, 90769583, z15222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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

                                public final void invoke(Composer composer6, int i28) {
                                    ComposerKt.sourceInformation(composer6, "C176@7430L57:TextFieldImpl.kt#uh7d8r");
                                    if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(90769583, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:176)");
                                    }
                                    TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl4, null, function233, composer6, 0, 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }) : composableLambda;
                            final long m4073unboximpl5 = textFieldColors.trailingIconColor$material3_release(z12222, z13222, interactionSource, composer3, 0).getValue().m4073unboximpl();
                            final Function2<? super Composer, ? super Integer, Unit> function234 = function224222;
                            ComposableLambda composableLambda8 = function234 != null ? ComposableLambdaKt.composableLambda(composer3, 2077796155, z15222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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

                                public final void invoke(Composer composer6, int i28) {
                                    ComposerKt.sourceInformation(composer6, "C183@7734L58:TextFieldImpl.kt#uh7d8r");
                                    if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2077796155, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:183)");
                                    }
                                    TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl5, null, function234, composer6, 0, 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }) : composableLambda;
                            final long m4073unboximpl6 = textFieldColors.supportingTextColor$material3_release(z12222, z13222, interactionSource, composer3, 0).getValue().m4073unboximpl();
                            final Function2<? super Composer, ? super Integer, Unit> function235 = function223222;
                            if (function235 != null) {
                                final TextStyle textStyle3 = bodySmall222;
                                composableLambda6 = ComposableLambdaKt.composableLambda(composer3, -1531019900, z15222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
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

                                    public final void invoke(Composer composer6, int i28) {
                                        ComposerKt.sourceInformation(composer6, "C191@8059L84:TextFieldImpl.kt#uh7d8r");
                                        if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                            composer6.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1531019900, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:191)");
                                        }
                                        TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl6, textStyle3, function235, composer6, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                            } else {
                                composableLambda6 = null;
                            }
                            int i28 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                            if (i28 == z15222) {
                                ComposableLambda composableLambda9 = composableLambda6;
                                composer3.startReplaceableGroup(404042583);
                                ComposerKt.sourceInformation(composer3, "204@8500L667");
                                final Function2<? super Composer, ? super Integer, Unit> function236 = function29;
                                TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function227222, composableLambda2, composableLambda3, composableLambda7, composableLambda8, composableLambda4, composableLambda5, z9, f, ComposableLambdaKt.composableLambda(composer3, -2124779163, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
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

                                    public final void invoke(Composer composer6, int i29) {
                                        ComposerKt.sourceInformation(composer6, "C198@8313L151:TextFieldImpl.kt#uh7d8r");
                                        if ((i29 & 3) != 2 || !composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2124779163, i29, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:198)");
                                            }
                                            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId);
                                            Function2<Composer, Integer, Unit> function237 = function236;
                                            composer6.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer6, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer6, 48);
                                            composer6.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(layoutId);
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
                                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                            composer6.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer6, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer6, 1425715941, "C200@8431L11:TextFieldImpl.kt#uh7d8r");
                                            function237.invoke(composer6, 0);
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
                                }), composableLambda9, paddingValues, composer3, ((i27 << 27) & 1879048192) | 6, 6);
                                composer3.endReplaceableGroup();
                            } else if (i28 == 2) {
                                composer3.startReplaceableGroup(404043576);
                                ComposerKt.sourceInformation(composer3, "222@9289L38,245@10297L420,234@9756L1141");
                                composer3.startReplaceableGroup(404043645);
                                ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                Object rememberedValue2 = composer3.rememberedValue();
                                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m3879boximpl(Size.INSTANCE.m3900getZeroNHjbRc()), null, 2, null);
                                    composer3.updateRememberedValue(rememberedValue2);
                                }
                                final MutableState<Size> mutableState = (MutableState) rememberedValue2;
                                composer3.endReplaceableGroup();
                                final PaddingValues paddingValues2 = paddingValues;
                                final Function2<? super Composer, ? super Integer, Unit> function237 = function29;
                                ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composer3, 1902535592, z15222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
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

                                    public final void invoke(Composer composer6, int i29) {
                                        ComposerKt.sourceInformation(composer6, "C224@9418L302:TextFieldImpl.kt#uh7d8r");
                                        if ((i29 & 3) != 2 || !composer6.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1902535592, i29, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:224)");
                                            }
                                            Modifier m2393outlineCutout12SF9DM = OutlinedTextFieldKt.m2393outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId), mutableState.getValue().getPackedValue(), paddingValues2);
                                            Function2<Composer, Integer, Unit> function238 = function237;
                                            composer6.startReplaceableGroup(733328855);
                                            ComposerKt.sourceInformation(composer6, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer6, 48);
                                            composer6.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                            CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m2393outlineCutout12SF9DM);
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
                                            Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                            }
                                            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                            composer6.startReplaceableGroup(2058660585);
                                            ComposerKt.sourceInformationMarkerStart(composer6, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(composer6, 1425717197, "C230@9687L11:TextFieldImpl.kt#uh7d8r");
                                            function238.invoke(composer6, 0);
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
                                });
                                Modifier.Companion companion = Modifier.INSTANCE;
                                ComposableLambda composableLambda11 = composableLambda2;
                                ComposableLambda composableLambda12 = composableLambda5;
                                ComposableLambda composableLambda13 = composableLambda6;
                                Function2<Composer, Integer, Unit> function238 = function227222;
                                ComposableLambda composableLambda14 = composableLambda3;
                                boolean z17 = z9;
                                composer3.startReplaceableGroup(404044653);
                                ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                                boolean z18 = (i27 & 14) == 4;
                                Object rememberedValue3 = composer3.rememberedValue();
                                if (z18 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                            m2773invokeuvyYCjk(size.getPackedValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke-uvyYCjk, reason: not valid java name */
                                        public final void m2773invokeuvyYCjk(long j6) {
                                            float m3891getWidthimpl = Size.m3891getWidthimpl(j6) * f4;
                                            float m3888getHeightimpl = Size.m3888getHeightimpl(j6) * f4;
                                            if (Size.m3891getWidthimpl(mutableState.getValue().getPackedValue()) == m3891getWidthimpl && Size.m3888getHeightimpl(mutableState.getValue().getPackedValue()) == m3888getHeightimpl) {
                                                return;
                                            }
                                            mutableState.setValue(Size.m3879boximpl(SizeKt.Size(m3891getWidthimpl, m3888getHeightimpl)));
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue3);
                                }
                                composer3.endReplaceableGroup();
                                OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function238, composableLambda14, composableLambda11, composableLambda7, composableLambda8, composableLambda4, composableLambda12, z17, f, (Function1) rememberedValue3, composableLambda10, composableLambda13, paddingValues, composer3, ((i27 << 27) & 1879048192) | 6, 48);
                                composer3.endReplaceableGroup();
                            } else {
                                composer3.startReplaceableGroup(404045277);
                                composer3.endReplaceableGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                };
                Function2<? super Composer, ? super Integer, Unit> function229222 = function221;
                boolean z15222 = z9;
                textFieldTransitionScope222.m2779TransitionDTcfvLk(inputPhase, j322, j2222, function3, z14, ComposableLambdaKt.composableLambda(startRestartGroup, 1290853831, true, function7222), startRestartGroup, 1769472);
                if (ComposerKt.isTraceInProgress()) {
                }
                composer2 = startRestartGroup;
                function213 = function225222;
                z6 = z12222;
                function214 = function228222;
                z7 = z13222;
                function215 = function224222;
                function216 = function226222;
                function217 = function229222;
                function218 = function223222;
                z8 = z15222;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function210 = function2;
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
            i9 = i8;
            i10 = i3 & 512;
            if (i10 == 0) {
            }
            i11 = i10;
            i12 = i3 & 1024;
            if (i12 != 0) {
            }
            i15 = i3 & 2048;
            if (i15 != 0) {
            }
            int i22222 = i14;
            i17 = i3 & 4096;
            if (i17 != 0) {
            }
            i19 = i3 & 8192;
            if (i19 != 0) {
            }
            if ((i3 & 16384) != 0) {
            }
            if ((32768 & i3) != 0) {
            }
            if ((i3 & 65536) == 0) {
            }
            if ((i3 & 131072) == 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 == 0) {
            }
            if (i9 == 0) {
            }
            if (i11 == 0) {
            }
            if (i13 == 0) {
            }
            if (i16 == 0) {
            }
            final Function2<? super Composer, ? super Integer, Unit> function2232222 = function222;
            if (i17 == 0) {
            }
            final Function2<? super Composer, ? super Integer, Unit> function2242222 = function219;
            if (i19 == 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-646389284);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TextFieldImpl.kt#9igjgp");
            z4 = ((i4 & 112) != 32) | ((i4 & 7168) != 2048);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z4) {
            }
            rememberedValue = visualTransformation.filter(new AnnotatedString(str2, null, null, 6, null));
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            final String text2222 = ((TransformedText) rememberedValue).getText().getText();
            if (!FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i21 >> 12) & 14).getValue().booleanValue()) {
            }
            function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase2, Composer composer3, Integer num) {
                    return Color.m4053boximpl(m2774invokeXeAY9LY(inputPhase2, composer3, num.intValue()));
                }

                /* renamed from: invoke-XeAY9LY, reason: not valid java name */
                public final long m2774invokeXeAY9LY(InputPhase inputPhase2, Composer composer3, int i25) {
                    composer3.startReplaceableGroup(-502832279);
                    ComposerKt.sourceInformation(composer3, "C92@3588L47:TextFieldImpl.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-502832279, i25, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:92)");
                    }
                    long m4073unboximpl = TextFieldColors.this.labelColor$material3_release(z10, z11, interactionSource, composer3, 0).getValue().m4073unboximpl();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceableGroup();
                    return m4073unboximpl;
                }
            };
            Typography typography2222 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
            final TextStyle bodyLarge2222 = typography2222.getBodyLarge();
            final TextStyle bodySmall2222 = typography2222.getBodySmall();
            final boolean z122222 = z10;
            final boolean z132222 = z11;
            if (Color.m4064equalsimpl0(bodyLarge2222.m5918getColor0d7_KjU(), Color.INSTANCE.m4099getUnspecified0d7_KjU())) {
            }
            TextFieldTransitionScope textFieldTransitionScope2222 = TextFieldTransitionScope.INSTANCE;
            startRestartGroup.startReplaceableGroup(-646388325);
            ComposerKt.sourceInformation(startRestartGroup, "*104@4123L10");
            m5918getColor0d7_KjU = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall().m5918getColor0d7_KjU();
            startRestartGroup.startReplaceableGroup(-646388264);
            ComposerKt.sourceInformation(startRestartGroup, "*105@4217L22");
            if (z5) {
            }
            long j3222 = m5918getColor0d7_KjU;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-646388132);
            ComposerKt.sourceInformation(startRestartGroup, "*107@4316L10");
            m5918getColor0d7_KjU2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodyLarge().m5918getColor0d7_KjU();
            startRestartGroup.startReplaceableGroup(-646388071);
            ComposerKt.sourceInformation(startRestartGroup, "*108@4410L22");
            if (z5) {
            }
            long j22222 = m5918getColor0d7_KjU2;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (function22 == null) {
            }
            final Function2<? super Composer, ? super Integer, Unit> function2252222 = function211;
            final Function2<? super Composer, ? super Integer, Unit> function2262222 = function220;
            final Function2<? super Composer, ? super Integer, Unit> function2272222 = function210;
            final Function2<? super Composer, ? super Integer, Unit> function2282222 = function212;
            Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit> function72222 = new Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3

                /* compiled from: TextFieldImpl.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[TextFieldType.values().length];
                        try {
                            iArr[TextFieldType.Filled.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[TextFieldType.Outlined.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(7);
                }

                @Override // kotlin.jvm.functions.Function7
                public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f2, Float f3, Composer composer3, Integer num) {
                    m2772invokeeopBjH0(f.floatValue(), color.m4073unboximpl(), color2.m4073unboximpl(), f2.floatValue(), f3.floatValue(), composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-eopBjH0, reason: not valid java name */
                public final void m2772invokeeopBjH0(final float f, final long j32222, long j4, final float f2, final float f3, Composer composer3, int i25) {
                    int i26;
                    final long j5;
                    boolean z152222;
                    final float f4;
                    ComposableLambda composableLambda;
                    ComposableLambda composableLambda2;
                    ComposableLambda composableLambda3;
                    Composer composer4;
                    ComposableLambda composableLambda4;
                    ComposableLambda composableLambda5;
                    ComposableLambda composableLambda6;
                    ComposerKt.sourceInformation(composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)131@5373L53,145@6062L48,159@6654L48,173@7251L53,180@7552L54,188@7871L56:TextFieldImpl.kt#uh7d8r");
                    if ((i25 & 6) == 0) {
                        i26 = (composer3.changed(f) ? 4 : 2) | i25;
                    } else {
                        i26 = i25;
                    }
                    if ((i25 & 48) == 0) {
                        i26 |= composer3.changed(j32222) ? 32 : 16;
                    }
                    if ((i25 & 384) == 0) {
                        j5 = j4;
                        i26 |= composer3.changed(j5) ? 256 : 128;
                    } else {
                        j5 = j4;
                    }
                    if ((i25 & 3072) == 0) {
                        i26 |= composer3.changed(f2) ? 2048 : 1024;
                    }
                    if ((i25 & 24576) == 0) {
                        i26 |= composer3.changed(f3) ? 16384 : 8192;
                    }
                    int i27 = i26;
                    if ((74899 & i27) != 74898 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1290853831, i27, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:115)");
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function2292222 = function22;
                        if (function2292222 != null) {
                            final boolean z16 = z5;
                            z152222 = true;
                            composableLambda = null;
                            f4 = f;
                            composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -382297919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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

                                public final void invoke(Composer composer5, int i28) {
                                    ComposerKt.sourceInformation(composer5, "C*118@4824L10,119@4880L10,124@5093L49:TextFieldImpl.kt#uh7d8r");
                                    if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-382297919, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:117)");
                                        }
                                        TextStyle lerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodyLarge(), MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodySmall(), f);
                                        boolean z17 = z16;
                                        long j6 = j32222;
                                        if (z17) {
                                            lerp = TextStyle.m5901copyp1EtxEg$default(lerp, j6, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                                        }
                                        TextFieldImplKt.m2771DecorationKTwxG1Y(j5, lerp, function2292222, composer5, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer5.skipToGroupEnd();
                                }
                            });
                        } else {
                            z152222 = true;
                            f4 = f;
                            composableLambda = null;
                            composableLambda2 = null;
                        }
                        final long m4073unboximpl = textFieldColors.placeholderColor$material3_release(z122222, z132222, interactionSource, composer3, 0).getValue().m4073unboximpl();
                        if (function2252222 == null || text2222.length() != 0 || f2 <= 0.0f) {
                            composableLambda3 = composableLambda;
                        } else {
                            final Function2<? super Composer, ? super Integer, Unit> function230 = function2252222;
                            composableLambda3 = ComposableLambdaKt.composableLambda(composer3, -524658155, z152222, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer5, Integer num) {
                                    invoke(modifier, composer5, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Modifier modifier, Composer composer5, int i28) {
                                    ComposerKt.sourceInformation(composer5, "C135@5666L319:TextFieldImpl.kt#uh7d8r");
                                    if ((i28 & 6) == 0) {
                                        i28 |= composer5.changed(modifier) ? 4 : 2;
                                    }
                                    if ((i28 & 19) != 18 || !composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-524658155, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:135)");
                                        }
                                        Modifier alpha = AlphaKt.alpha(modifier, f2);
                                        long j6 = m4073unboximpl;
                                        Function2<Composer, Integer, Unit> function231 = function230;
                                        composer5.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                        composer5.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                        composer5.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer5, 1425713248, "C138@5866L10,136@5738L225:TextFieldImpl.kt#uh7d8r");
                                        TextFieldImplKt.m2771DecorationKTwxG1Y(j6, MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodyLarge(), function231, composer5, 0, 0);
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
                            });
                        }
                        final long m4073unboximpl2 = textFieldColors.prefixColor$material3_release(z122222, z132222, interactionSource, composer3, 0).getValue().m4073unboximpl();
                        if (function2262222 == null || f3 <= 0.0f) {
                            composer4 = composer3;
                            composableLambda4 = composableLambda;
                        } else {
                            final TextStyle textStyle = bodyLarge2222;
                            final Function2<? super Composer, ? super Integer, Unit> function231 = function2262222;
                            composer4 = composer3;
                            composableLambda4 = ComposableLambdaKt.composableLambda(composer4, 1824482619, z152222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1
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

                                public final void invoke(Composer composer5, int i28) {
                                    ComposerKt.sourceInformation(composer5, "C149@6292L285:TextFieldImpl.kt#uh7d8r");
                                    if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1824482619, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:149)");
                                        }
                                        Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                        long j6 = m4073unboximpl2;
                                        TextStyle textStyle2 = textStyle;
                                        Function2<Composer, Integer, Unit> function232 = function231;
                                        composer5.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                        composer5.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                        composer5.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer5, 1425713875, "C150@6365L190:TextFieldImpl.kt#uh7d8r");
                                        TextFieldImplKt.m2771DecorationKTwxG1Y(j6, textStyle2, function232, composer5, 0, 0);
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
                            });
                        }
                        final long m4073unboximpl3 = textFieldColors.suffixColor$material3_release(z122222, z132222, interactionSource, composer4, 0).getValue().m4073unboximpl();
                        if (function221 == null || f3 <= 0.0f) {
                            composableLambda5 = composableLambda;
                        } else {
                            final TextStyle textStyle2 = bodyLarge2222;
                            final Function2<? super Composer, ? super Integer, Unit> function232 = function221;
                            composableLambda5 = ComposableLambdaKt.composableLambda(composer4, 907456412, z152222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1
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

                                public final void invoke(Composer composer5, int i28) {
                                    ComposerKt.sourceInformation(composer5, "C163@6884L285:TextFieldImpl.kt#uh7d8r");
                                    if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(907456412, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:163)");
                                        }
                                        Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                        long j6 = m4073unboximpl3;
                                        TextStyle textStyle3 = textStyle2;
                                        Function2<Composer, Integer, Unit> function233 = function232;
                                        composer5.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                        composer5.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                        composer5.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer5, 1425714467, "C164@6957L190:TextFieldImpl.kt#uh7d8r");
                                        TextFieldImplKt.m2771DecorationKTwxG1Y(j6, textStyle3, function233, composer5, 0, 0);
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
                            });
                        }
                        Composer composer5 = composer4;
                        final long m4073unboximpl4 = textFieldColors.leadingIconColor$material3_release(z122222, z132222, interactionSource, composer5, 0).getValue().m4073unboximpl();
                        final Function2<? super Composer, ? super Integer, Unit> function233 = function2282222;
                        ComposableLambda composableLambda7 = function233 != null ? ComposableLambdaKt.composableLambda(composer5, 90769583, z152222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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

                            public final void invoke(Composer composer6, int i28) {
                                ComposerKt.sourceInformation(composer6, "C176@7430L57:TextFieldImpl.kt#uh7d8r");
                                if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                    composer6.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(90769583, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:176)");
                                }
                                TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl4, null, function233, composer6, 0, 2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }) : composableLambda;
                        final long m4073unboximpl5 = textFieldColors.trailingIconColor$material3_release(z122222, z132222, interactionSource, composer3, 0).getValue().m4073unboximpl();
                        final Function2<? super Composer, ? super Integer, Unit> function234 = function2242222;
                        ComposableLambda composableLambda8 = function234 != null ? ComposableLambdaKt.composableLambda(composer3, 2077796155, z152222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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

                            public final void invoke(Composer composer6, int i28) {
                                ComposerKt.sourceInformation(composer6, "C183@7734L58:TextFieldImpl.kt#uh7d8r");
                                if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                    composer6.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(2077796155, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:183)");
                                }
                                TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl5, null, function234, composer6, 0, 2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }) : composableLambda;
                        final long m4073unboximpl6 = textFieldColors.supportingTextColor$material3_release(z122222, z132222, interactionSource, composer3, 0).getValue().m4073unboximpl();
                        final Function2<? super Composer, ? super Integer, Unit> function235 = function2232222;
                        if (function235 != null) {
                            final TextStyle textStyle3 = bodySmall2222;
                            composableLambda6 = ComposableLambdaKt.composableLambda(composer3, -1531019900, z152222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
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

                                public final void invoke(Composer composer6, int i28) {
                                    ComposerKt.sourceInformation(composer6, "C191@8059L84:TextFieldImpl.kt#uh7d8r");
                                    if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                        composer6.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1531019900, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:191)");
                                    }
                                    TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl6, textStyle3, function235, composer6, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            });
                        } else {
                            composableLambda6 = null;
                        }
                        int i28 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                        if (i28 == z152222) {
                            ComposableLambda composableLambda9 = composableLambda6;
                            composer3.startReplaceableGroup(404042583);
                            ComposerKt.sourceInformation(composer3, "204@8500L667");
                            final Function2<? super Composer, ? super Integer, Unit> function236 = function29;
                            TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function2272222, composableLambda2, composableLambda3, composableLambda7, composableLambda8, composableLambda4, composableLambda5, z9, f, ComposableLambdaKt.composableLambda(composer3, -2124779163, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
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

                                public final void invoke(Composer composer6, int i29) {
                                    ComposerKt.sourceInformation(composer6, "C198@8313L151:TextFieldImpl.kt#uh7d8r");
                                    if ((i29 & 3) != 2 || !composer6.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2124779163, i29, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:198)");
                                        }
                                        Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId);
                                        Function2<Composer, Integer, Unit> function237 = function236;
                                        composer6.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer6, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer6, 48);
                                        composer6.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(layoutId);
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
                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                        composer6.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer6, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer6, 1425715941, "C200@8431L11:TextFieldImpl.kt#uh7d8r");
                                        function237.invoke(composer6, 0);
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
                            }), composableLambda9, paddingValues, composer3, ((i27 << 27) & 1879048192) | 6, 6);
                            composer3.endReplaceableGroup();
                        } else if (i28 == 2) {
                            composer3.startReplaceableGroup(404043576);
                            ComposerKt.sourceInformation(composer3, "222@9289L38,245@10297L420,234@9756L1141");
                            composer3.startReplaceableGroup(404043645);
                            ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                            Object rememberedValue2 = composer3.rememberedValue();
                            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m3879boximpl(Size.INSTANCE.m3900getZeroNHjbRc()), null, 2, null);
                                composer3.updateRememberedValue(rememberedValue2);
                            }
                            final MutableState<Size> mutableState = (MutableState) rememberedValue2;
                            composer3.endReplaceableGroup();
                            final PaddingValues paddingValues2 = paddingValues;
                            final Function2<? super Composer, ? super Integer, Unit> function237 = function29;
                            ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composer3, 1902535592, z152222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
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

                                public final void invoke(Composer composer6, int i29) {
                                    ComposerKt.sourceInformation(composer6, "C224@9418L302:TextFieldImpl.kt#uh7d8r");
                                    if ((i29 & 3) != 2 || !composer6.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1902535592, i29, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:224)");
                                        }
                                        Modifier m2393outlineCutout12SF9DM = OutlinedTextFieldKt.m2393outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId), mutableState.getValue().getPackedValue(), paddingValues2);
                                        Function2<Composer, Integer, Unit> function238 = function237;
                                        composer6.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation(composer6, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer6, 48);
                                        composer6.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m2393outlineCutout12SF9DM);
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
                                        Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                        composer6.startReplaceableGroup(2058660585);
                                        ComposerKt.sourceInformationMarkerStart(composer6, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(composer6, 1425717197, "C230@9687L11:TextFieldImpl.kt#uh7d8r");
                                        function238.invoke(composer6, 0);
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
                            });
                            Modifier.Companion companion = Modifier.INSTANCE;
                            ComposableLambda composableLambda11 = composableLambda2;
                            ComposableLambda composableLambda12 = composableLambda5;
                            ComposableLambda composableLambda13 = composableLambda6;
                            Function2<Composer, Integer, Unit> function238 = function2272222;
                            ComposableLambda composableLambda14 = composableLambda3;
                            boolean z17 = z9;
                            composer3.startReplaceableGroup(404044653);
                            ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                            boolean z18 = (i27 & 14) == 4;
                            Object rememberedValue3 = composer3.rememberedValue();
                            if (z18 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                        m2773invokeuvyYCjk(size.getPackedValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-uvyYCjk, reason: not valid java name */
                                    public final void m2773invokeuvyYCjk(long j6) {
                                        float m3891getWidthimpl = Size.m3891getWidthimpl(j6) * f4;
                                        float m3888getHeightimpl = Size.m3888getHeightimpl(j6) * f4;
                                        if (Size.m3891getWidthimpl(mutableState.getValue().getPackedValue()) == m3891getWidthimpl && Size.m3888getHeightimpl(mutableState.getValue().getPackedValue()) == m3888getHeightimpl) {
                                            return;
                                        }
                                        mutableState.setValue(Size.m3879boximpl(SizeKt.Size(m3891getWidthimpl, m3888getHeightimpl)));
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue3);
                            }
                            composer3.endReplaceableGroup();
                            OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function238, composableLambda14, composableLambda11, composableLambda7, composableLambda8, composableLambda4, composableLambda12, z17, f, (Function1) rememberedValue3, composableLambda10, composableLambda13, paddingValues, composer3, ((i27 << 27) & 1879048192) | 6, 48);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(404045277);
                            composer3.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            };
            Function2<? super Composer, ? super Integer, Unit> function2292222 = function221;
            boolean z152222 = z9;
            textFieldTransitionScope2222.m2779TransitionDTcfvLk(inputPhase, j3222, j22222, function3, z14, ComposableLambdaKt.composableLambda(startRestartGroup, 1290853831, true, function72222), startRestartGroup, 1769472);
            if (ComposerKt.isTraceInProgress()) {
            }
            composer2 = startRestartGroup;
            function213 = function2252222;
            z6 = z122222;
            function214 = function2282222;
            z7 = z132222;
            function215 = function2242222;
            function216 = function2262222;
            function217 = function2292222;
            function218 = function2232222;
            z8 = z152222;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        str2 = str;
        if ((i3 & 4) == 0) {
        }
        function210 = function2;
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
        i9 = i8;
        i10 = i3 & 512;
        if (i10 == 0) {
        }
        i11 = i10;
        i12 = i3 & 1024;
        if (i12 != 0) {
        }
        i15 = i3 & 2048;
        if (i15 != 0) {
        }
        int i222222 = i14;
        i17 = i3 & 4096;
        if (i17 != 0) {
        }
        i19 = i3 & 8192;
        if (i19 != 0) {
        }
        if ((i3 & 16384) != 0) {
        }
        if ((32768 & i3) != 0) {
        }
        if ((i3 & 65536) == 0) {
        }
        if ((i3 & 131072) == 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 == 0) {
        }
        if (i9 == 0) {
        }
        if (i11 == 0) {
        }
        if (i13 == 0) {
        }
        if (i16 == 0) {
        }
        final Function2<? super Composer, ? super Integer, Unit> function22322222 = function222;
        if (i17 == 0) {
        }
        final Function2<? super Composer, ? super Integer, Unit> function22422222 = function219;
        if (i19 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-646389284);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):TextFieldImpl.kt#9igjgp");
        z4 = ((i4 & 112) != 32) | ((i4 & 7168) != 2048);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z4) {
        }
        rememberedValue = visualTransformation.filter(new AnnotatedString(str2, null, null, 6, null));
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        final String text22222 = ((TransformedText) rememberedValue).getText().getText();
        if (!FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i21 >> 12) & 14).getValue().booleanValue()) {
        }
        function3 = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$labelColor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase2, Composer composer3, Integer num) {
                return Color.m4053boximpl(m2774invokeXeAY9LY(inputPhase2, composer3, num.intValue()));
            }

            /* renamed from: invoke-XeAY9LY, reason: not valid java name */
            public final long m2774invokeXeAY9LY(InputPhase inputPhase2, Composer composer3, int i25) {
                composer3.startReplaceableGroup(-502832279);
                ComposerKt.sourceInformation(composer3, "C92@3588L47:TextFieldImpl.kt#uh7d8r");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-502832279, i25, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:92)");
                }
                long m4073unboximpl = TextFieldColors.this.labelColor$material3_release(z10, z11, interactionSource, composer3, 0).getValue().m4073unboximpl();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer3.endReplaceableGroup();
                return m4073unboximpl;
            }
        };
        Typography typography22222 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
        final TextStyle bodyLarge22222 = typography22222.getBodyLarge();
        final TextStyle bodySmall22222 = typography22222.getBodySmall();
        final boolean z1222222 = z10;
        final boolean z1322222 = z11;
        if (Color.m4064equalsimpl0(bodyLarge22222.m5918getColor0d7_KjU(), Color.INSTANCE.m4099getUnspecified0d7_KjU())) {
        }
        TextFieldTransitionScope textFieldTransitionScope22222 = TextFieldTransitionScope.INSTANCE;
        startRestartGroup.startReplaceableGroup(-646388325);
        ComposerKt.sourceInformation(startRestartGroup, "*104@4123L10");
        m5918getColor0d7_KjU = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodySmall().m5918getColor0d7_KjU();
        startRestartGroup.startReplaceableGroup(-646388264);
        ComposerKt.sourceInformation(startRestartGroup, "*105@4217L22");
        if (z5) {
        }
        long j32222 = m5918getColor0d7_KjU;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-646388132);
        ComposerKt.sourceInformation(startRestartGroup, "*107@4316L10");
        m5918getColor0d7_KjU2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6).getBodyLarge().m5918getColor0d7_KjU();
        startRestartGroup.startReplaceableGroup(-646388071);
        ComposerKt.sourceInformation(startRestartGroup, "*108@4410L22");
        if (z5) {
        }
        long j222222 = m5918getColor0d7_KjU2;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (function22 == null) {
        }
        final Function2<? super Composer, ? super Integer, Unit> function22522222 = function211;
        final Function2<? super Composer, ? super Integer, Unit> function22622222 = function220;
        final Function2<? super Composer, ? super Integer, Unit> function22722222 = function210;
        final Function2<? super Composer, ? super Integer, Unit> function22822222 = function212;
        Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit> function722222 = new Function7<Float, Color, Color, Float, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3

            /* compiled from: TextFieldImpl.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[TextFieldType.values().length];
                    try {
                        iArr[TextFieldType.Filled.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[TextFieldType.Outlined.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(7);
            }

            @Override // kotlin.jvm.functions.Function7
            public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f2, Float f3, Composer composer3, Integer num) {
                m2772invokeeopBjH0(f.floatValue(), color.m4073unboximpl(), color2.m4073unboximpl(), f2.floatValue(), f3.floatValue(), composer3, num.intValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-eopBjH0, reason: not valid java name */
            public final void m2772invokeeopBjH0(final float f, final long j322222, long j4, final float f2, final float f3, Composer composer3, int i25) {
                int i26;
                final long j5;
                boolean z1522222;
                final float f4;
                ComposableLambda composableLambda;
                ComposableLambda composableLambda2;
                ComposableLambda composableLambda3;
                Composer composer4;
                ComposableLambda composableLambda4;
                ComposableLambda composableLambda5;
                ComposableLambda composableLambda6;
                ComposerKt.sourceInformation(composer3, "CP(1,2:c#ui.graphics.Color,0:c#ui.graphics.Color)131@5373L53,145@6062L48,159@6654L48,173@7251L53,180@7552L54,188@7871L56:TextFieldImpl.kt#uh7d8r");
                if ((i25 & 6) == 0) {
                    i26 = (composer3.changed(f) ? 4 : 2) | i25;
                } else {
                    i26 = i25;
                }
                if ((i25 & 48) == 0) {
                    i26 |= composer3.changed(j322222) ? 32 : 16;
                }
                if ((i25 & 384) == 0) {
                    j5 = j4;
                    i26 |= composer3.changed(j5) ? 256 : 128;
                } else {
                    j5 = j4;
                }
                if ((i25 & 3072) == 0) {
                    i26 |= composer3.changed(f2) ? 2048 : 1024;
                }
                if ((i25 & 24576) == 0) {
                    i26 |= composer3.changed(f3) ? 16384 : 8192;
                }
                int i27 = i26;
                if ((74899 & i27) != 74898 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1290853831, i27, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:115)");
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function22922222 = function22;
                    if (function22922222 != null) {
                        final boolean z16 = z5;
                        z1522222 = true;
                        composableLambda = null;
                        f4 = f;
                        composableLambda2 = ComposableLambdaKt.composableLambda(composer3, -382297919, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
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

                            public final void invoke(Composer composer5, int i28) {
                                ComposerKt.sourceInformation(composer5, "C*118@4824L10,119@4880L10,124@5093L49:TextFieldImpl.kt#uh7d8r");
                                if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-382297919, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:117)");
                                    }
                                    TextStyle lerp = TextStyleKt.lerp(MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodyLarge(), MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodySmall(), f);
                                    boolean z17 = z16;
                                    long j6 = j322222;
                                    if (z17) {
                                        lerp = TextStyle.m5901copyp1EtxEg$default(lerp, j6, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
                                    }
                                    TextFieldImplKt.m2771DecorationKTwxG1Y(j5, lerp, function22922222, composer5, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer5.skipToGroupEnd();
                            }
                        });
                    } else {
                        z1522222 = true;
                        f4 = f;
                        composableLambda = null;
                        composableLambda2 = null;
                    }
                    final long m4073unboximpl = textFieldColors.placeholderColor$material3_release(z1222222, z1322222, interactionSource, composer3, 0).getValue().m4073unboximpl();
                    if (function22522222 == null || text22222.length() != 0 || f2 <= 0.0f) {
                        composableLambda3 = composableLambda;
                    } else {
                        final Function2<? super Composer, ? super Integer, Unit> function230 = function22522222;
                        composableLambda3 = ComposableLambdaKt.composableLambda(composer3, -524658155, z1522222, new Function3<Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer5, Integer num) {
                                invoke(modifier, composer5, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Modifier modifier, Composer composer5, int i28) {
                                ComposerKt.sourceInformation(composer5, "C135@5666L319:TextFieldImpl.kt#uh7d8r");
                                if ((i28 & 6) == 0) {
                                    i28 |= composer5.changed(modifier) ? 4 : 2;
                                }
                                if ((i28 & 19) != 18 || !composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-524658155, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:135)");
                                    }
                                    Modifier alpha = AlphaKt.alpha(modifier, f2);
                                    long j6 = m4073unboximpl;
                                    Function2<Composer, Integer, Unit> function231 = function230;
                                    composer5.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                    composer5.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                    composer5.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer5, 1425713248, "C138@5866L10,136@5738L225:TextFieldImpl.kt#uh7d8r");
                                    TextFieldImplKt.m2771DecorationKTwxG1Y(j6, MaterialTheme.INSTANCE.getTypography(composer5, 6).getBodyLarge(), function231, composer5, 0, 0);
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
                        });
                    }
                    final long m4073unboximpl2 = textFieldColors.prefixColor$material3_release(z1222222, z1322222, interactionSource, composer3, 0).getValue().m4073unboximpl();
                    if (function22622222 == null || f3 <= 0.0f) {
                        composer4 = composer3;
                        composableLambda4 = composableLambda;
                    } else {
                        final TextStyle textStyle = bodyLarge22222;
                        final Function2<? super Composer, ? super Integer, Unit> function231 = function22622222;
                        composer4 = composer3;
                        composableLambda4 = ComposableLambdaKt.composableLambda(composer4, 1824482619, z1522222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedPrefix$1
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

                            public final void invoke(Composer composer5, int i28) {
                                ComposerKt.sourceInformation(composer5, "C149@6292L285:TextFieldImpl.kt#uh7d8r");
                                if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1824482619, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:149)");
                                    }
                                    Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                    long j6 = m4073unboximpl2;
                                    TextStyle textStyle2 = textStyle;
                                    Function2<Composer, Integer, Unit> function232 = function231;
                                    composer5.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                    composer5.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                    composer5.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer5, 1425713875, "C150@6365L190:TextFieldImpl.kt#uh7d8r");
                                    TextFieldImplKt.m2771DecorationKTwxG1Y(j6, textStyle2, function232, composer5, 0, 0);
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
                        });
                    }
                    final long m4073unboximpl3 = textFieldColors.suffixColor$material3_release(z1222222, z1322222, interactionSource, composer4, 0).getValue().m4073unboximpl();
                    if (function221 == null || f3 <= 0.0f) {
                        composableLambda5 = composableLambda;
                    } else {
                        final TextStyle textStyle2 = bodyLarge22222;
                        final Function2<? super Composer, ? super Integer, Unit> function232 = function221;
                        composableLambda5 = ComposableLambdaKt.composableLambda(composer4, 907456412, z1522222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSuffix$1
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

                            public final void invoke(Composer composer5, int i28) {
                                ComposerKt.sourceInformation(composer5, "C163@6884L285:TextFieldImpl.kt#uh7d8r");
                                if ((i28 & 3) != 2 || !composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(907456412, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:163)");
                                    }
                                    Modifier alpha = AlphaKt.alpha(Modifier.INSTANCE, f3);
                                    long j6 = m4073unboximpl3;
                                    TextStyle textStyle3 = textStyle2;
                                    Function2<Composer, Integer, Unit> function233 = function232;
                                    composer5.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer5, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer5, 0);
                                    composer5.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer5, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer5, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer5.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
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
                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer5)), composer5, 0);
                                    composer5.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer5, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer5, 1425714467, "C164@6957L190:TextFieldImpl.kt#uh7d8r");
                                    TextFieldImplKt.m2771DecorationKTwxG1Y(j6, textStyle3, function233, composer5, 0, 0);
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
                        });
                    }
                    Composer composer5 = composer4;
                    final long m4073unboximpl4 = textFieldColors.leadingIconColor$material3_release(z1222222, z1322222, interactionSource, composer5, 0).getValue().m4073unboximpl();
                    final Function2<? super Composer, ? super Integer, Unit> function233 = function22822222;
                    ComposableLambda composableLambda7 = function233 != null ? ComposableLambdaKt.composableLambda(composer5, 90769583, z1522222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
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

                        public final void invoke(Composer composer6, int i28) {
                            ComposerKt.sourceInformation(composer6, "C176@7430L57:TextFieldImpl.kt#uh7d8r");
                            if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                composer6.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(90769583, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:176)");
                            }
                            TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl4, null, function233, composer6, 0, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }) : composableLambda;
                    final long m4073unboximpl5 = textFieldColors.trailingIconColor$material3_release(z1222222, z1322222, interactionSource, composer3, 0).getValue().m4073unboximpl();
                    final Function2<? super Composer, ? super Integer, Unit> function234 = function22422222;
                    ComposableLambda composableLambda8 = function234 != null ? ComposableLambdaKt.composableLambda(composer3, 2077796155, z1522222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
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

                        public final void invoke(Composer composer6, int i28) {
                            ComposerKt.sourceInformation(composer6, "C183@7734L58:TextFieldImpl.kt#uh7d8r");
                            if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                composer6.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2077796155, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:183)");
                            }
                            TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl5, null, function234, composer6, 0, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }) : composableLambda;
                    final long m4073unboximpl6 = textFieldColors.supportingTextColor$material3_release(z1222222, z1322222, interactionSource, composer3, 0).getValue().m4073unboximpl();
                    final Function2<? super Composer, ? super Integer, Unit> function235 = function22322222;
                    if (function235 != null) {
                        final TextStyle textStyle3 = bodySmall22222;
                        composableLambda6 = ComposableLambdaKt.composableLambda(composer3, -1531019900, z1522222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$decoratedSupporting$1$1
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

                            public final void invoke(Composer composer6, int i28) {
                                ComposerKt.sourceInformation(composer6, "C191@8059L84:TextFieldImpl.kt#uh7d8r");
                                if ((i28 & 3) == 2 && composer6.getSkipping()) {
                                    composer6.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1531019900, i28, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:191)");
                                }
                                TextFieldImplKt.m2771DecorationKTwxG1Y(m4073unboximpl6, textStyle3, function235, composer6, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                    } else {
                        composableLambda6 = null;
                    }
                    int i28 = WhenMappings.$EnumSwitchMapping$0[textFieldType.ordinal()];
                    if (i28 == z1522222) {
                        ComposableLambda composableLambda9 = composableLambda6;
                        composer3.startReplaceableGroup(404042583);
                        ComposerKt.sourceInformation(composer3, "204@8500L667");
                        final Function2<? super Composer, ? super Integer, Unit> function236 = function29;
                        TextFieldKt.TextFieldLayout(Modifier.INSTANCE, function22722222, composableLambda2, composableLambda3, composableLambda7, composableLambda8, composableLambda4, composableLambda5, z9, f, ComposableLambdaKt.composableLambda(composer3, -2124779163, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$containerWithId$1
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

                            public final void invoke(Composer composer6, int i29) {
                                ComposerKt.sourceInformation(composer6, "C198@8313L151:TextFieldImpl.kt#uh7d8r");
                                if ((i29 & 3) != 2 || !composer6.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2124779163, i29, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:198)");
                                    }
                                    Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId);
                                    Function2<Composer, Integer, Unit> function237 = function236;
                                    composer6.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer6, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer6, 48);
                                    composer6.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(layoutId);
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
                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                    composer6.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer6, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer6, 1425715941, "C200@8431L11:TextFieldImpl.kt#uh7d8r");
                                    function237.invoke(composer6, 0);
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
                        }), composableLambda9, paddingValues, composer3, ((i27 << 27) & 1879048192) | 6, 6);
                        composer3.endReplaceableGroup();
                    } else if (i28 == 2) {
                        composer3.startReplaceableGroup(404043576);
                        ComposerKt.sourceInformation(composer3, "222@9289L38,245@10297L420,234@9756L1141");
                        composer3.startReplaceableGroup(404043645);
                        ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m3879boximpl(Size.INSTANCE.m3900getZeroNHjbRc()), null, 2, null);
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        final MutableState<Size> mutableState = (MutableState) rememberedValue2;
                        composer3.endReplaceableGroup();
                        final PaddingValues paddingValues2 = paddingValues;
                        final Function2<? super Composer, ? super Integer, Unit> function237 = function29;
                        ComposableLambda composableLambda10 = ComposableLambdaKt.composableLambda(composer3, 1902535592, z1522222, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$borderContainerWithId$1
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

                            public final void invoke(Composer composer6, int i29) {
                                ComposerKt.sourceInformation(composer6, "C224@9418L302:TextFieldImpl.kt#uh7d8r");
                                if ((i29 & 3) != 2 || !composer6.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1902535592, i29, -1, "androidx.compose.material3.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:224)");
                                    }
                                    Modifier m2393outlineCutout12SF9DM = OutlinedTextFieldKt.m2393outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.INSTANCE, TextFieldImplKt.ContainerId), mutableState.getValue().getPackedValue(), paddingValues2);
                                    Function2<Composer, Integer, Unit> function238 = function237;
                                    composer6.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer6, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer6, 48);
                                    composer6.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer6, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer6, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer6.getCurrentCompositionLocalMap();
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m2393outlineCutout12SF9DM);
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
                                    Updater.m3600setimpl(m3593constructorimpl, rememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(composer6)), composer6, 0);
                                    composer6.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer6, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer6, 1425717197, "C230@9687L11:TextFieldImpl.kt#uh7d8r");
                                    function238.invoke(composer6, 0);
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
                        });
                        Modifier.Companion companion = Modifier.INSTANCE;
                        ComposableLambda composableLambda11 = composableLambda2;
                        ComposableLambda composableLambda12 = composableLambda5;
                        ComposableLambda composableLambda13 = composableLambda6;
                        Function2<Composer, Integer, Unit> function238 = function22722222;
                        ComposableLambda composableLambda14 = composableLambda3;
                        boolean z17 = z9;
                        composer3.startReplaceableGroup(404044653);
                        ComposerKt.sourceInformation(composer3, "CC(remember):TextFieldImpl.kt#9igjgp");
                        boolean z18 = (i27 & 14) == 4;
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (z18 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = (Function1) new Function1<Size, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$CommonDecorationBox$3$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                                    m2773invokeuvyYCjk(size.getPackedValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-uvyYCjk, reason: not valid java name */
                                public final void m2773invokeuvyYCjk(long j6) {
                                    float m3891getWidthimpl = Size.m3891getWidthimpl(j6) * f4;
                                    float m3888getHeightimpl = Size.m3888getHeightimpl(j6) * f4;
                                    if (Size.m3891getWidthimpl(mutableState.getValue().getPackedValue()) == m3891getWidthimpl && Size.m3888getHeightimpl(mutableState.getValue().getPackedValue()) == m3888getHeightimpl) {
                                        return;
                                    }
                                    mutableState.setValue(Size.m3879boximpl(SizeKt.Size(m3891getWidthimpl, m3888getHeightimpl)));
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        composer3.endReplaceableGroup();
                        OutlinedTextFieldKt.OutlinedTextFieldLayout(companion, function238, composableLambda14, composableLambda11, composableLambda7, composableLambda8, composableLambda4, composableLambda12, z17, f, (Function1) rememberedValue3, composableLambda10, composableLambda13, paddingValues, composer3, ((i27 << 27) & 1879048192) | 6, 48);
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(404045277);
                        composer3.endReplaceableGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        };
        Function2<? super Composer, ? super Integer, Unit> function22922222 = function221;
        boolean z1522222 = z9;
        textFieldTransitionScope22222.m2779TransitionDTcfvLk(inputPhase, j32222, j222222, function3, z14, ComposableLambdaKt.composableLambda(startRestartGroup, 1290853831, true, function722222), startRestartGroup, 1769472);
        if (ComposerKt.isTraceInProgress()) {
        }
        composer2 = startRestartGroup;
        function213 = function22522222;
        z6 = z1222222;
        function214 = function22822222;
        z7 = z1322222;
        function215 = function22422222;
        function216 = function22622222;
        function217 = function22922222;
        function218 = function22322222;
        z8 = z1522222;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* renamed from: Decoration-KTwxG1Y, reason: not valid java name */
    public static final void m2771DecorationKTwxG1Y(final long j, TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        long j2;
        final Function2<? super Composer, ? super Integer, Unit> function22;
        final TextStyle textStyle2;
        Composer startRestartGroup = composer.startRestartGroup(-1520066345);
        ComposerKt.sourceInformation(startRestartGroup, "C(Decoration)P(1:c#ui.graphics.Color,2):TextFieldImpl.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(textStyle) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i3 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (i4 != 0) {
                textStyle = null;
            }
            TextStyle textStyle3 = textStyle;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1520066345, i3, -1, "androidx.compose.material3.Decoration (TextFieldImpl.kt:271)");
            }
            ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, 1449369305, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$Decoration$contentWithColor$1
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

                public final void invoke(Composer composer2, int i5) {
                    ComposerKt.sourceInformation(composer2, "C273@11220L118:TextFieldImpl.kt#uh7d8r");
                    if ((i5 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1449369305, i5, -1, "androidx.compose.material3.Decoration.<anonymous> (TextFieldImpl.kt:273)");
                        }
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4053boximpl(j)), function2, composer2, ProvidedValue.$stable);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            });
            if (textStyle3 != null) {
                startRestartGroup.startReplaceableGroup(1830467586);
                ComposerKt.sourceInformation(startRestartGroup, "279@11381L63");
                j2 = j;
                ProvideContentColorTextStyleKt.m2420ProvideContentColorTextStyle3JVO9M(j2, textStyle3, function2, startRestartGroup, i3 & 1022);
                function22 = function2;
                startRestartGroup.endReplaceableGroup();
            } else {
                j2 = j;
                function22 = function2;
                startRestartGroup.startReplaceableGroup(1830467667);
                ComposerKt.sourceInformation(startRestartGroup, "281@11462L18");
                composableLambda.invoke(startRestartGroup, 6);
                startRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            textStyle2 = textStyle3;
        } else {
            startRestartGroup.skipToGroupEnd();
            j2 = j;
            function22 = function2;
            textStyle2 = textStyle;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final long j3 = j2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$Decoration$1
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

                public final void invoke(Composer composer2, int i5) {
                    TextFieldImplKt.m2771DecorationKTwxG1Y(j3, textStyle2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public static final Modifier defaultErrorSemantics(Modifier modifier, boolean z, final String str) {
        return z ? SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TextFieldImplKt$defaultErrorSemantics$1
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
                SemanticsPropertiesKt.error(semanticsPropertyReceiver, str);
            }
        }, 1, null) : modifier;
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final Object getLayoutId(IntrinsicMeasurable intrinsicMeasurable) {
        Object parentData = intrinsicMeasurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    static {
        float f = 16;
        TextFieldPadding = Dp.m6389constructorimpl(f);
        MinFocusedLabelLineHeight = Dp.m6389constructorimpl(f);
        MinSupportingTextLineHeight = Dp.m6389constructorimpl(f);
        float f2 = 48;
        IconDefaultSizeModifier = androidx.compose.foundation.layout.SizeKt.m912defaultMinSizeVpY3zN4(Modifier.INSTANCE, Dp.m6389constructorimpl(f2), Dp.m6389constructorimpl(f2));
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final float getSupportingTopPadding() {
        return SupportingTopPadding;
    }

    public static final float getPrefixSuffixTextPadding() {
        return PrefixSuffixTextPadding;
    }

    public static final float getMinTextLineHeight() {
        return MinTextLineHeight;
    }

    public static final float getMinFocusedLabelLineHeight() {
        return MinFocusedLabelLineHeight;
    }

    public static final float getMinSupportingTextLineHeight() {
        return MinSupportingTextLineHeight;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }
}
