package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DateRangePicker.kt */
@Metadata(d1 = {"\u0000¼\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ak\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0015\b\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012¢\u0006\u0002\b\u00132\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012¢\u0006\u0002\b\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a°\u0001\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\n0 2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\n0&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010.\u001a`\u0010/\u001a\u00020\f2\n\u00100\u001a\u000601j\u0002`22\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a½\u0001\u0010:\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010;\u001a\u0002072:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\n0 2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\n0&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a°\u0001\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020@2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\n0 2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\n0&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010A\u001a.\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C2\u0006\u0010\u000b\u001a\u00020@2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020HH\u0002\u001aT\u0010J\u001a\u00020\f2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u00106\u001a\u0002072\b\b\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0000¢\u0006\u0004\bK\u0010L\u001ae\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\u001c2\b\u0010O\u001a\u0004\u0018\u00010\u001c2\b\u0010P\u001a\u0004\u0018\u00010\u001c2:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\n0 H\u0002¢\u0006\u0002\u0010Q\u001a&\u0010R\u001a\u00020\n*\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0000ø\u0001\u0000¢\u0006\u0004\bX\u0010Y\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Z"}, d2 = {"CalendarMonthSubheadPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getCalendarMonthSubheadPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DateRangePickerHeadlinePadding", "DateRangePickerTitlePadding", "HeaderHeightOffset", "Landroidx/compose/ui/unit/Dp;", "F", "DateRangePicker", "", "state", "Landroidx/compose/material3/DateRangePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "showModeToggle", "", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerContent", "selectedStartDateMillis", "", "selectedEndDateMillis", "displayedMonthMillis", "onDatesSelectionChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startDateMillis", "endDateMillis", "onDisplayedMonthChange", "Lkotlin/Function1;", "monthInMillis", "calendarModel", "Landroidx/compose/material3/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "(Ljava/lang/Long;Ljava/lang/Long;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DateRangePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "initialSelectedStartDateMillis", "initialSelectedEndDateMillis", "initialDisplayedMonthMillis", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "DateRangePickerState-HVP43zI", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DateRangePickerState;", "SwitchableDateEntryContent", "displayMode", "SwitchableDateEntryContent-RN-2D1Q", "(Ljava/lang/Long;Ljava/lang/Long;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "VerticalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "", "scrollDownLabel", "rememberDateRangePickerState", "rememberDateRangePickerState-IlFM19s", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DateRangePickerState;", "updateDateSelection", "dateInMillis", "currentStartDateMillis", "currentEndDateMillis", "(JLjava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;)V", "drawRangeBackground", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "selectedRangeInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "color", "Landroidx/compose/ui/graphics/Color;", "drawRangeBackground-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;Landroidx/compose/material3/SelectedRangeInfo;J)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DateRangePickerKt {
    private static final PaddingValues DateRangePickerHeadlinePadding;
    private static final PaddingValues DateRangePickerTitlePadding;
    private static final PaddingValues CalendarMonthSubheadPadding = PaddingKt.m876PaddingValuesa9UjIt4$default(Dp.m6389constructorimpl(24), Dp.m6389constructorimpl(20), 0.0f, Dp.m6389constructorimpl(8), 4, null);
    private static final float HeaderHeightOffset = Dp.m6389constructorimpl(60);

    /* JADX WARN: Removed duplicated region for block: B:101:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0158  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DateRangePicker(final DateRangePickerState dateRangePickerState, Modifier modifier, DatePickerFormatter datePickerFormatter, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z, DatePickerColors datePickerColors, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function24;
        int i6;
        boolean z2;
        DatePickerColors datePickerColors2;
        final DatePickerFormatter datePickerFormatter2;
        int i7;
        boolean z3;
        final DatePickerColors colors;
        Function2<? super Composer, ? super Integer, Unit> function25;
        boolean changed;
        Object rememberedValue;
        Composer composer2;
        final DatePickerFormatter datePickerFormatter3;
        final boolean z4;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final DatePickerColors datePickerColors3;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(650830774);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateRangePicker)P(5,3,1,6,2,4)87@4101L47,104@4858L8,106@4895L15,107@4935L62,123@5551L10,108@5002L1936:DateRangePicker.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(dateRangePickerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    if ((i & 512) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter)) {
                        i9 = 256;
                        i3 |= i9;
                    }
                }
                i9 = 128;
                i3 |= i9;
            }
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                function23 = function2;
                i3 |= startRestartGroup.changedInstance(function23) ? 2048 : 1024;
                i5 = i2 & 16;
                if (i5 != 0) {
                    i3 |= 24576;
                } else if ((i & 24576) == 0) {
                    function24 = function22;
                    i3 |= startRestartGroup.changedInstance(function24) ? 16384 : 8192;
                    i6 = i2 & 32;
                    if (i6 == 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((196608 & i) == 0) {
                        z2 = z;
                        i3 |= startRestartGroup.changed(z2) ? 131072 : 65536;
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                datePickerColors2 = datePickerColors;
                                if (startRestartGroup.changed(datePickerColors2)) {
                                    i8 = 1048576;
                                    i3 |= i8;
                                }
                            } else {
                                datePickerColors2 = datePickerColors;
                            }
                            i8 = 524288;
                            i3 |= i8;
                        } else {
                            datePickerColors2 = datePickerColors;
                        }
                        if ((599187 & i3) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                if (i10 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i2 & 4) != 0) {
                                    startRestartGroup.startReplaceableGroup(-1155307541);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DateRangePicker.kt#9igjgp");
                                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    datePickerFormatter2 = (DatePickerFormatter) rememberedValue2;
                                    startRestartGroup.endReplaceableGroup();
                                    i3 &= -897;
                                } else {
                                    datePickerFormatter2 = datePickerFormatter;
                                }
                                if (i4 != 0) {
                                    function23 = ComposableLambdaKt.composableLambda(startRestartGroup, -162164694, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$2
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i11) {
                                            PaddingValues paddingValues;
                                            ComposerKt.sourceInformation(composer3, "C89@4223L145:DateRangePicker.kt#uh7d8r");
                                            if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-162164694, i11, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:89)");
                                                }
                                                DateRangePickerDefaults dateRangePickerDefaults = DateRangePickerDefaults.INSTANCE;
                                                int mo2160getDisplayModejFl4v0 = DateRangePickerState.this.mo2160getDisplayModejFl4v0();
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                paddingValues = DateRangePickerKt.DateRangePickerTitlePadding;
                                                dateRangePickerDefaults.m2151DateRangePickerTitlehOD91z4(mo2160getDisplayModejFl4v0, PaddingKt.padding(companion, paddingValues), composer3, 432, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    });
                                }
                                if (i5 != 0) {
                                    function24 = ComposableLambdaKt.composableLambda(startRestartGroup, -185279404, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i11) {
                                            PaddingValues paddingValues;
                                            ComposerKt.sourceInformation(composer3, "C95@4452L312:DateRangePicker.kt#uh7d8r");
                                            if ((i11 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-185279404, i11, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:95)");
                                                }
                                                DateRangePickerDefaults dateRangePickerDefaults = DateRangePickerDefaults.INSTANCE;
                                                Long selectedStartDateMillis = DateRangePickerState.this.getSelectedStartDateMillis();
                                                Long selectedEndDateMillis = DateRangePickerState.this.getSelectedEndDateMillis();
                                                int mo2160getDisplayModejFl4v0 = DateRangePickerState.this.mo2160getDisplayModejFl4v0();
                                                DatePickerFormatter datePickerFormatter4 = datePickerFormatter2;
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                paddingValues = DateRangePickerKt.DateRangePickerHeadlinePadding;
                                                dateRangePickerDefaults.m2150DateRangePickerHeadlinev84Udv0(selectedStartDateMillis, selectedEndDateMillis, mo2160getDisplayModejFl4v0, datePickerFormatter4, PaddingKt.padding(companion, paddingValues), composer3, 221184, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    });
                                }
                                if (i6 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 64) != 0) {
                                    i7 = i3 & (-3670017);
                                    z3 = z2;
                                    colors = DatePickerDefaults.INSTANCE.colors(startRestartGroup, 6);
                                    function25 = function23;
                                    Modifier modifier4 = modifier2;
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(650830774, i7, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:105)");
                                    }
                                    Locale defaultLocale = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
                                    startRestartGroup.startReplaceableGroup(-1155306707);
                                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DateRangePicker.kt#9igjgp");
                                    changed = startRestartGroup.changed(defaultLocale);
                                    rememberedValue = startRestartGroup.rememberedValue();
                                    if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = CalendarModel_androidKt.createCalendarModel(defaultLocale);
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    final CalendarModel calendarModel = (CalendarModel) rememberedValue;
                                    startRestartGroup.endReplaceableGroup();
                                    int i11 = ((i7 >> 3) & 14) | 14155776;
                                    int i12 = i7 >> 6;
                                    composer2 = startRestartGroup;
                                    DatePickerKt.m2135DateEntryContainerau3_HiA(modifier4, function25, function24, !z3 ? ComposableLambdaKt.composableLambda(startRestartGroup, -1490010652, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$4
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i13) {
                                            ComposerKt.sourceInformation(composer3, "C117@5380L50,114@5182L267:DateRangePicker.kt#uh7d8r");
                                            if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1490010652, i13, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:114)");
                                                }
                                                Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                                                int mo2160getDisplayModejFl4v0 = DateRangePickerState.this.mo2160getDisplayModejFl4v0();
                                                composer3.startReplaceableGroup(-1467496949);
                                                ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                                                boolean changed2 = composer3.changed(DateRangePickerState.this);
                                                final DateRangePickerState dateRangePickerState2 = DateRangePickerState.this;
                                                Object rememberedValue3 = composer3.rememberedValue();
                                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue3 = (Function1) new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$4$1$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode) {
                                                            m2158invokevCnGnXg(displayMode.getValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                                                        public final void m2158invokevCnGnXg(int i14) {
                                                            DateRangePickerState.this.mo2161setDisplayModevCnGnXg(i14);
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(rememberedValue3);
                                                }
                                                composer3.endReplaceableGroup();
                                                DatePickerKt.m2139DisplayModeToggleButtontER2X8s(padding, mo2160getDisplayModejFl4v0, (Function1) rememberedValue3, composer3, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }) : null, colors, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont()), Dp.m6389constructorimpl(DatePickerModalTokens.INSTANCE.m3106getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset), ComposableLambdaKt.composableLambda(startRestartGroup, -57534331, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                            invoke(composer3, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i13) {
                                            ComposerKt.sourceInformation(composer3, "C135@6116L467,146@6622L91,130@5809L1123:DateRangePicker.kt#uh7d8r");
                                            if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-57534331, i13, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:130)");
                                                }
                                                Long selectedStartDateMillis = DateRangePickerState.this.getSelectedStartDateMillis();
                                                Long selectedEndDateMillis = DateRangePickerState.this.getSelectedEndDateMillis();
                                                long displayedMonthMillis = DateRangePickerState.this.getDisplayedMonthMillis();
                                                int mo2160getDisplayModejFl4v0 = DateRangePickerState.this.mo2160getDisplayModejFl4v0();
                                                composer3.startReplaceableGroup(-1467496213);
                                                ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                                                boolean changed2 = composer3.changed(DateRangePickerState.this);
                                                final DateRangePickerState dateRangePickerState2 = DateRangePickerState.this;
                                                Object rememberedValue3 = composer3.rememberedValue();
                                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue3 = (Function2) new Function2<Long, Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$1$1
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
                                                            invoke2(l, l2);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(Long l, Long l2) {
                                                            try {
                                                                DateRangePickerState.this.setSelection(l, l2);
                                                            } catch (IllegalArgumentException unused) {
                                                            }
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(rememberedValue3);
                                                }
                                                Function2 function27 = (Function2) rememberedValue3;
                                                composer3.endReplaceableGroup();
                                                composer3.startReplaceableGroup(-1467495707);
                                                ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                                                boolean changed3 = composer3.changed(DateRangePickerState.this);
                                                final DateRangePickerState dateRangePickerState3 = DateRangePickerState.this;
                                                Object rememberedValue4 = composer3.rememberedValue();
                                                if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$2$1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                                            invoke(l.longValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(long j) {
                                                            DateRangePickerState.this.setDisplayedMonthMillis(j);
                                                        }
                                                    };
                                                    composer3.updateRememberedValue(rememberedValue4);
                                                }
                                                composer3.endReplaceableGroup();
                                                DateRangePickerKt.m2154SwitchableDateEntryContentRN2D1Q(selectedStartDateMillis, selectedEndDateMillis, displayedMonthMillis, mo2160getDisplayModejFl4v0, function27, (Function1) rememberedValue4, calendarModel, DateRangePickerState.this.getYearRange(), datePickerFormatter2, DateRangePickerState.this.getSelectableDates(), colors, composer3, 0, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), composer2, i11 | (i12 & 112) | (i12 & 896) | (i12 & 57344));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    datePickerFormatter3 = datePickerFormatter2;
                                    z4 = z3;
                                    modifier3 = modifier4;
                                    function26 = function25;
                                    datePickerColors3 = colors;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                datePickerFormatter2 = datePickerFormatter;
                            }
                            i7 = i3;
                            function25 = function23;
                            z3 = z2;
                            colors = datePickerColors2;
                            Modifier modifier42 = modifier2;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            Locale defaultLocale2 = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
                            startRestartGroup.startReplaceableGroup(-1155306707);
                            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DateRangePicker.kt#9igjgp");
                            changed = startRestartGroup.changed(defaultLocale2);
                            rememberedValue = startRestartGroup.rememberedValue();
                            if (!changed) {
                            }
                            rememberedValue = CalendarModel_androidKt.createCalendarModel(defaultLocale2);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                            final CalendarModel calendarModel2 = (CalendarModel) rememberedValue;
                            startRestartGroup.endReplaceableGroup();
                            if (!z3) {
                            }
                            int i112 = ((i7 >> 3) & 14) | 14155776;
                            int i122 = i7 >> 6;
                            composer2 = startRestartGroup;
                            DatePickerKt.m2135DateEntryContainerau3_HiA(modifier42, function25, function24, !z3 ? ComposableLambdaKt.composableLambda(startRestartGroup, -1490010652, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$4
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i13) {
                                    ComposerKt.sourceInformation(composer3, "C117@5380L50,114@5182L267:DateRangePicker.kt#uh7d8r");
                                    if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1490010652, i13, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:114)");
                                        }
                                        Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                                        int mo2160getDisplayModejFl4v0 = DateRangePickerState.this.mo2160getDisplayModejFl4v0();
                                        composer3.startReplaceableGroup(-1467496949);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                                        boolean changed2 = composer3.changed(DateRangePickerState.this);
                                        final DateRangePickerState dateRangePickerState2 = DateRangePickerState.this;
                                        Object rememberedValue3 = composer3.rememberedValue();
                                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = (Function1) new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$4$1$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode) {
                                                    m2158invokevCnGnXg(displayMode.getValue());
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                                                public final void m2158invokevCnGnXg(int i14) {
                                                    DateRangePickerState.this.mo2161setDisplayModevCnGnXg(i14);
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue3);
                                        }
                                        composer3.endReplaceableGroup();
                                        DatePickerKt.m2139DisplayModeToggleButtontER2X8s(padding, mo2160getDisplayModejFl4v0, (Function1) rememberedValue3, composer3, 6);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }) : null, colors, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont()), Dp.m6389constructorimpl(DatePickerModalTokens.INSTANCE.m3106getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset), ComposableLambdaKt.composableLambda(startRestartGroup, -57534331, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i13) {
                                    ComposerKt.sourceInformation(composer3, "C135@6116L467,146@6622L91,130@5809L1123:DateRangePicker.kt#uh7d8r");
                                    if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-57534331, i13, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:130)");
                                        }
                                        Long selectedStartDateMillis = DateRangePickerState.this.getSelectedStartDateMillis();
                                        Long selectedEndDateMillis = DateRangePickerState.this.getSelectedEndDateMillis();
                                        long displayedMonthMillis = DateRangePickerState.this.getDisplayedMonthMillis();
                                        int mo2160getDisplayModejFl4v0 = DateRangePickerState.this.mo2160getDisplayModejFl4v0();
                                        composer3.startReplaceableGroup(-1467496213);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                                        boolean changed2 = composer3.changed(DateRangePickerState.this);
                                        final DateRangePickerState dateRangePickerState2 = DateRangePickerState.this;
                                        Object rememberedValue3 = composer3.rememberedValue();
                                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue3 = (Function2) new Function2<Long, Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$1$1
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
                                                    invoke2(l, l2);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(Long l, Long l2) {
                                                    try {
                                                        DateRangePickerState.this.setSelection(l, l2);
                                                    } catch (IllegalArgumentException unused) {
                                                    }
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue3);
                                        }
                                        Function2 function27 = (Function2) rememberedValue3;
                                        composer3.endReplaceableGroup();
                                        composer3.startReplaceableGroup(-1467495707);
                                        ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                                        boolean changed3 = composer3.changed(DateRangePickerState.this);
                                        final DateRangePickerState dateRangePickerState3 = DateRangePickerState.this;
                                        Object rememberedValue4 = composer3.rememberedValue();
                                        if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$2$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                                    invoke(l.longValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(long j) {
                                                    DateRangePickerState.this.setDisplayedMonthMillis(j);
                                                }
                                            };
                                            composer3.updateRememberedValue(rememberedValue4);
                                        }
                                        composer3.endReplaceableGroup();
                                        DateRangePickerKt.m2154SwitchableDateEntryContentRN2D1Q(selectedStartDateMillis, selectedEndDateMillis, displayedMonthMillis, mo2160getDisplayModejFl4v0, function27, (Function1) rememberedValue4, calendarModel2, DateRangePickerState.this.getYearRange(), datePickerFormatter2, DateRangePickerState.this.getSelectableDates(), colors, composer3, 0, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), composer2, i112 | (i122 & 112) | (i122 & 896) | (i122 & 57344));
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            datePickerFormatter3 = datePickerFormatter2;
                            z4 = z3;
                            modifier3 = modifier42;
                            function26 = function25;
                            datePickerColors3 = colors;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            composer2 = startRestartGroup;
                            modifier3 = modifier2;
                            function26 = function23;
                            z4 = z2;
                            datePickerColors3 = datePickerColors2;
                            datePickerFormatter3 = datePickerFormatter;
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function27 = function24;
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$6
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
                                    DateRangePickerKt.DateRangePicker(DateRangePickerState.this, modifier3, datePickerFormatter3, function26, function27, z4, datePickerColors3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    z2 = z;
                    if ((1572864 & i) == 0) {
                    }
                    if ((599187 & i3) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i2 & 4) != 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if ((i2 & 64) != 0) {
                    }
                    i7 = i3;
                    function25 = function23;
                    z3 = z2;
                    colors = datePickerColors2;
                    Modifier modifier422 = modifier2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    Locale defaultLocale22 = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(-1155306707);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DateRangePicker.kt#9igjgp");
                    changed = startRestartGroup.changed(defaultLocale22);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue = CalendarModel_androidKt.createCalendarModel(defaultLocale22);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    final CalendarModel calendarModel22 = (CalendarModel) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    if (!z3) {
                    }
                    int i1122 = ((i7 >> 3) & 14) | 14155776;
                    int i1222 = i7 >> 6;
                    composer2 = startRestartGroup;
                    DatePickerKt.m2135DateEntryContainerau3_HiA(modifier422, function25, function24, !z3 ? ComposableLambdaKt.composableLambda(startRestartGroup, -1490010652, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$4
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ComposerKt.sourceInformation(composer3, "C117@5380L50,114@5182L267:DateRangePicker.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1490010652, i13, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:114)");
                                }
                                Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                                int mo2160getDisplayModejFl4v0 = DateRangePickerState.this.mo2160getDisplayModejFl4v0();
                                composer3.startReplaceableGroup(-1467496949);
                                ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                                boolean changed2 = composer3.changed(DateRangePickerState.this);
                                final DateRangePickerState dateRangePickerState2 = DateRangePickerState.this;
                                Object rememberedValue3 = composer3.rememberedValue();
                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = (Function1) new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$4$1$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode) {
                                            m2158invokevCnGnXg(displayMode.getValue());
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                                        public final void m2158invokevCnGnXg(int i14) {
                                            DateRangePickerState.this.mo2161setDisplayModevCnGnXg(i14);
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue3);
                                }
                                composer3.endReplaceableGroup();
                                DatePickerKt.m2139DisplayModeToggleButtontER2X8s(padding, mo2160getDisplayModejFl4v0, (Function1) rememberedValue3, composer3, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }) : null, colors, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont()), Dp.m6389constructorimpl(DatePickerModalTokens.INSTANCE.m3106getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset), ComposableLambdaKt.composableLambda(startRestartGroup, -57534331, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i13) {
                            ComposerKt.sourceInformation(composer3, "C135@6116L467,146@6622L91,130@5809L1123:DateRangePicker.kt#uh7d8r");
                            if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-57534331, i13, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:130)");
                                }
                                Long selectedStartDateMillis = DateRangePickerState.this.getSelectedStartDateMillis();
                                Long selectedEndDateMillis = DateRangePickerState.this.getSelectedEndDateMillis();
                                long displayedMonthMillis = DateRangePickerState.this.getDisplayedMonthMillis();
                                int mo2160getDisplayModejFl4v0 = DateRangePickerState.this.mo2160getDisplayModejFl4v0();
                                composer3.startReplaceableGroup(-1467496213);
                                ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                                boolean changed2 = composer3.changed(DateRangePickerState.this);
                                final DateRangePickerState dateRangePickerState2 = DateRangePickerState.this;
                                Object rememberedValue3 = composer3.rememberedValue();
                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = (Function2) new Function2<Long, Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$1$1
                                        {
                                            super(2);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
                                            invoke2(l, l2);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(Long l, Long l2) {
                                            try {
                                                DateRangePickerState.this.setSelection(l, l2);
                                            } catch (IllegalArgumentException unused) {
                                            }
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue3);
                                }
                                Function2 function272 = (Function2) rememberedValue3;
                                composer3.endReplaceableGroup();
                                composer3.startReplaceableGroup(-1467495707);
                                ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                                boolean changed3 = composer3.changed(DateRangePickerState.this);
                                final DateRangePickerState dateRangePickerState3 = DateRangePickerState.this;
                                Object rememberedValue4 = composer3.rememberedValue();
                                if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$2$1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                            invoke(l.longValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(long j) {
                                            DateRangePickerState.this.setDisplayedMonthMillis(j);
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue4);
                                }
                                composer3.endReplaceableGroup();
                                DateRangePickerKt.m2154SwitchableDateEntryContentRN2D1Q(selectedStartDateMillis, selectedEndDateMillis, displayedMonthMillis, mo2160getDisplayModejFl4v0, function272, (Function1) rememberedValue4, calendarModel22, DateRangePickerState.this.getYearRange(), datePickerFormatter2, DateRangePickerState.this.getSelectableDates(), colors, composer3, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), composer2, i1122 | (i1222 & 112) | (i1222 & 896) | (i1222 & 57344));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    datePickerFormatter3 = datePickerFormatter2;
                    z4 = z3;
                    modifier3 = modifier422;
                    function26 = function25;
                    datePickerColors3 = colors;
                    final Function2<? super Composer, ? super Integer, Unit> function272 = function24;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function24 = function22;
                i6 = i2 & 32;
                if (i6 == 0) {
                }
                z2 = z;
                if ((1572864 & i) == 0) {
                }
                if ((599187 & i3) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if ((i2 & 4) != 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & 64) != 0) {
                }
                i7 = i3;
                function25 = function23;
                z3 = z2;
                colors = datePickerColors2;
                Modifier modifier4222 = modifier2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                Locale defaultLocale222 = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1155306707);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DateRangePicker.kt#9igjgp");
                changed = startRestartGroup.changed(defaultLocale222);
                rememberedValue = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue = CalendarModel_androidKt.createCalendarModel(defaultLocale222);
                startRestartGroup.updateRememberedValue(rememberedValue);
                final CalendarModel calendarModel222 = (CalendarModel) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                if (!z3) {
                }
                int i11222 = ((i7 >> 3) & 14) | 14155776;
                int i12222 = i7 >> 6;
                composer2 = startRestartGroup;
                DatePickerKt.m2135DateEntryContainerau3_HiA(modifier4222, function25, function24, !z3 ? ComposableLambdaKt.composableLambda(startRestartGroup, -1490010652, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$4
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i13) {
                        ComposerKt.sourceInformation(composer3, "C117@5380L50,114@5182L267:DateRangePicker.kt#uh7d8r");
                        if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1490010652, i13, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:114)");
                            }
                            Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                            int mo2160getDisplayModejFl4v0 = DateRangePickerState.this.mo2160getDisplayModejFl4v0();
                            composer3.startReplaceableGroup(-1467496949);
                            ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                            boolean changed2 = composer3.changed(DateRangePickerState.this);
                            final DateRangePickerState dateRangePickerState2 = DateRangePickerState.this;
                            Object rememberedValue3 = composer3.rememberedValue();
                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = (Function1) new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$4$1$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode) {
                                        m2158invokevCnGnXg(displayMode.getValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                                    public final void m2158invokevCnGnXg(int i14) {
                                        DateRangePickerState.this.mo2161setDisplayModevCnGnXg(i14);
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue3);
                            }
                            composer3.endReplaceableGroup();
                            DatePickerKt.m2139DisplayModeToggleButtontER2X8s(padding, mo2160getDisplayModejFl4v0, (Function1) rememberedValue3, composer3, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }) : null, colors, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont()), Dp.m6389constructorimpl(DatePickerModalTokens.INSTANCE.m3106getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset), ComposableLambdaKt.composableLambda(startRestartGroup, -57534331, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                        invoke(composer3, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer3, int i13) {
                        ComposerKt.sourceInformation(composer3, "C135@6116L467,146@6622L91,130@5809L1123:DateRangePicker.kt#uh7d8r");
                        if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-57534331, i13, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:130)");
                            }
                            Long selectedStartDateMillis = DateRangePickerState.this.getSelectedStartDateMillis();
                            Long selectedEndDateMillis = DateRangePickerState.this.getSelectedEndDateMillis();
                            long displayedMonthMillis = DateRangePickerState.this.getDisplayedMonthMillis();
                            int mo2160getDisplayModejFl4v0 = DateRangePickerState.this.mo2160getDisplayModejFl4v0();
                            composer3.startReplaceableGroup(-1467496213);
                            ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                            boolean changed2 = composer3.changed(DateRangePickerState.this);
                            final DateRangePickerState dateRangePickerState2 = DateRangePickerState.this;
                            Object rememberedValue3 = composer3.rememberedValue();
                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = (Function2) new Function2<Long, Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$1$1
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
                                        invoke2(l, l2);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Long l, Long l2) {
                                        try {
                                            DateRangePickerState.this.setSelection(l, l2);
                                        } catch (IllegalArgumentException unused) {
                                        }
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue3);
                            }
                            Function2 function2722 = (Function2) rememberedValue3;
                            composer3.endReplaceableGroup();
                            composer3.startReplaceableGroup(-1467495707);
                            ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                            boolean changed3 = composer3.changed(DateRangePickerState.this);
                            final DateRangePickerState dateRangePickerState3 = DateRangePickerState.this;
                            Object rememberedValue4 = composer3.rememberedValue();
                            if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$2$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                        invoke(l.longValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(long j) {
                                        DateRangePickerState.this.setDisplayedMonthMillis(j);
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue4);
                            }
                            composer3.endReplaceableGroup();
                            DateRangePickerKt.m2154SwitchableDateEntryContentRN2D1Q(selectedStartDateMillis, selectedEndDateMillis, displayedMonthMillis, mo2160getDisplayModejFl4v0, function2722, (Function1) rememberedValue4, calendarModel222, DateRangePickerState.this.getYearRange(), datePickerFormatter2, DateRangePickerState.this.getSelectableDates(), colors, composer3, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer3.skipToGroupEnd();
                    }
                }), composer2, i11222 | (i12222 & 112) | (i12222 & 896) | (i12222 & 57344));
                if (ComposerKt.isTraceInProgress()) {
                }
                datePickerFormatter3 = datePickerFormatter2;
                z4 = z3;
                modifier3 = modifier4222;
                function26 = function25;
                datePickerColors3 = colors;
                final Function2<? super Composer, ? super Integer, Unit> function2722 = function24;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function23 = function2;
            i5 = i2 & 16;
            if (i5 != 0) {
            }
            function24 = function22;
            i6 = i2 & 32;
            if (i6 == 0) {
            }
            z2 = z;
            if ((1572864 & i) == 0) {
            }
            if ((599187 & i3) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if ((i2 & 4) != 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & 64) != 0) {
            }
            i7 = i3;
            function25 = function23;
            z3 = z2;
            colors = datePickerColors2;
            Modifier modifier42222 = modifier2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Locale defaultLocale2222 = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1155306707);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DateRangePicker.kt#9igjgp");
            changed = startRestartGroup.changed(defaultLocale2222);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = CalendarModel_androidKt.createCalendarModel(defaultLocale2222);
            startRestartGroup.updateRememberedValue(rememberedValue);
            final CalendarModel calendarModel2222 = (CalendarModel) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            if (!z3) {
            }
            int i112222 = ((i7 >> 3) & 14) | 14155776;
            int i122222 = i7 >> 6;
            composer2 = startRestartGroup;
            DatePickerKt.m2135DateEntryContainerau3_HiA(modifier42222, function25, function24, !z3 ? ComposableLambdaKt.composableLambda(startRestartGroup, -1490010652, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$4
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i13) {
                    ComposerKt.sourceInformation(composer3, "C117@5380L50,114@5182L267:DateRangePicker.kt#uh7d8r");
                    if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1490010652, i13, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:114)");
                        }
                        Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                        int mo2160getDisplayModejFl4v0 = DateRangePickerState.this.mo2160getDisplayModejFl4v0();
                        composer3.startReplaceableGroup(-1467496949);
                        ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                        boolean changed2 = composer3.changed(DateRangePickerState.this);
                        final DateRangePickerState dateRangePickerState2 = DateRangePickerState.this;
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = (Function1) new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$4$1$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode) {
                                    m2158invokevCnGnXg(displayMode.getValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                                public final void m2158invokevCnGnXg(int i14) {
                                    DateRangePickerState.this.mo2161setDisplayModevCnGnXg(i14);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        composer3.endReplaceableGroup();
                        DatePickerKt.m2139DisplayModeToggleButtontER2X8s(padding, mo2160getDisplayModejFl4v0, (Function1) rememberedValue3, composer3, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }) : null, colors, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont()), Dp.m6389constructorimpl(DatePickerModalTokens.INSTANCE.m3106getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset), ComposableLambdaKt.composableLambda(startRestartGroup, -57534331, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i13) {
                    ComposerKt.sourceInformation(composer3, "C135@6116L467,146@6622L91,130@5809L1123:DateRangePicker.kt#uh7d8r");
                    if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-57534331, i13, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:130)");
                        }
                        Long selectedStartDateMillis = DateRangePickerState.this.getSelectedStartDateMillis();
                        Long selectedEndDateMillis = DateRangePickerState.this.getSelectedEndDateMillis();
                        long displayedMonthMillis = DateRangePickerState.this.getDisplayedMonthMillis();
                        int mo2160getDisplayModejFl4v0 = DateRangePickerState.this.mo2160getDisplayModejFl4v0();
                        composer3.startReplaceableGroup(-1467496213);
                        ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                        boolean changed2 = composer3.changed(DateRangePickerState.this);
                        final DateRangePickerState dateRangePickerState2 = DateRangePickerState.this;
                        Object rememberedValue3 = composer3.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = (Function2) new Function2<Long, Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$1$1
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
                                    invoke2(l, l2);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Long l, Long l2) {
                                    try {
                                        DateRangePickerState.this.setSelection(l, l2);
                                    } catch (IllegalArgumentException unused) {
                                    }
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue3);
                        }
                        Function2 function27222 = (Function2) rememberedValue3;
                        composer3.endReplaceableGroup();
                        composer3.startReplaceableGroup(-1467495707);
                        ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                        boolean changed3 = composer3.changed(DateRangePickerState.this);
                        final DateRangePickerState dateRangePickerState3 = DateRangePickerState.this;
                        Object rememberedValue4 = composer3.rememberedValue();
                        if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$2$1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                    invoke(l.longValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(long j) {
                                    DateRangePickerState.this.setDisplayedMonthMillis(j);
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue4);
                        }
                        composer3.endReplaceableGroup();
                        DateRangePickerKt.m2154SwitchableDateEntryContentRN2D1Q(selectedStartDateMillis, selectedEndDateMillis, displayedMonthMillis, mo2160getDisplayModejFl4v0, function27222, (Function1) rememberedValue4, calendarModel2222, DateRangePickerState.this.getYearRange(), datePickerFormatter2, DateRangePickerState.this.getSelectableDates(), colors, composer3, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, i112222 | (i122222 & 112) | (i122222 & 896) | (i122222 & 57344));
            if (ComposerKt.isTraceInProgress()) {
            }
            datePickerFormatter3 = datePickerFormatter2;
            z4 = z3;
            modifier3 = modifier42222;
            function26 = function25;
            datePickerColors3 = colors;
            final Function2<? super Composer, ? super Integer, Unit> function27222 = function24;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        if ((i & 384) == 0) {
        }
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        function23 = function2;
        i5 = i2 & 16;
        if (i5 != 0) {
        }
        function24 = function22;
        i6 = i2 & 32;
        if (i6 == 0) {
        }
        z2 = z;
        if ((1572864 & i) == 0) {
        }
        if ((599187 & i3) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & 64) != 0) {
        }
        i7 = i3;
        function25 = function23;
        z3 = z2;
        colors = datePickerColors2;
        Modifier modifier422222 = modifier2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Locale defaultLocale22222 = ActualAndroid_androidKt.defaultLocale(startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(-1155306707);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DateRangePicker.kt#9igjgp");
        changed = startRestartGroup.changed(defaultLocale22222);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = CalendarModel_androidKt.createCalendarModel(defaultLocale22222);
        startRestartGroup.updateRememberedValue(rememberedValue);
        final CalendarModel calendarModel22222 = (CalendarModel) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        if (!z3) {
        }
        int i1122222 = ((i7 >> 3) & 14) | 14155776;
        int i1222222 = i7 >> 6;
        composer2 = startRestartGroup;
        DatePickerKt.m2135DateEntryContainerau3_HiA(modifier422222, function25, function24, !z3 ? ComposableLambdaKt.composableLambda(startRestartGroup, -1490010652, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$4
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i13) {
                ComposerKt.sourceInformation(composer3, "C117@5380L50,114@5182L267:DateRangePicker.kt#uh7d8r");
                if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1490010652, i13, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:114)");
                    }
                    Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                    int mo2160getDisplayModejFl4v0 = DateRangePickerState.this.mo2160getDisplayModejFl4v0();
                    composer3.startReplaceableGroup(-1467496949);
                    ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                    boolean changed2 = composer3.changed(DateRangePickerState.this);
                    final DateRangePickerState dateRangePickerState2 = DateRangePickerState.this;
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = (Function1) new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$4$1$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode) {
                                m2158invokevCnGnXg(displayMode.getValue());
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                            public final void m2158invokevCnGnXg(int i14) {
                                DateRangePickerState.this.mo2161setDisplayModevCnGnXg(i14);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    composer3.endReplaceableGroup();
                    DatePickerKt.m2139DisplayModeToggleButtontER2X8s(padding, mo2160getDisplayModejFl4v0, (Function1) rememberedValue3, composer3, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }) : null, colors, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont()), Dp.m6389constructorimpl(DatePickerModalTokens.INSTANCE.m3106getRangeSelectionHeaderContainerHeightD9Ej5fM() - HeaderHeightOffset), ComposableLambdaKt.composableLambda(startRestartGroup, -57534331, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i13) {
                ComposerKt.sourceInformation(composer3, "C135@6116L467,146@6622L91,130@5809L1123:DateRangePicker.kt#uh7d8r");
                if ((i13 & 3) != 2 || !composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-57534331, i13, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:130)");
                    }
                    Long selectedStartDateMillis = DateRangePickerState.this.getSelectedStartDateMillis();
                    Long selectedEndDateMillis = DateRangePickerState.this.getSelectedEndDateMillis();
                    long displayedMonthMillis = DateRangePickerState.this.getDisplayedMonthMillis();
                    int mo2160getDisplayModejFl4v0 = DateRangePickerState.this.mo2160getDisplayModejFl4v0();
                    composer3.startReplaceableGroup(-1467496213);
                    ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                    boolean changed2 = composer3.changed(DateRangePickerState.this);
                    final DateRangePickerState dateRangePickerState2 = DateRangePickerState.this;
                    Object rememberedValue3 = composer3.rememberedValue();
                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = (Function2) new Function2<Long, Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$1$1
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
                                invoke2(l, l2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Long l, Long l2) {
                                try {
                                    DateRangePickerState.this.setSelection(l, l2);
                                } catch (IllegalArgumentException unused) {
                                }
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue3);
                    }
                    Function2 function272222 = (Function2) rememberedValue3;
                    composer3.endReplaceableGroup();
                    composer3.startReplaceableGroup(-1467495707);
                    ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                    boolean changed3 = composer3.changed(DateRangePickerState.this);
                    final DateRangePickerState dateRangePickerState3 = DateRangePickerState.this;
                    Object rememberedValue4 = composer3.rememberedValue();
                    if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue4 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$2$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                                invoke(l.longValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(long j) {
                                DateRangePickerState.this.setDisplayedMonthMillis(j);
                            }
                        };
                        composer3.updateRememberedValue(rememberedValue4);
                    }
                    composer3.endReplaceableGroup();
                    DateRangePickerKt.m2154SwitchableDateEntryContentRN2D1Q(selectedStartDateMillis, selectedEndDateMillis, displayedMonthMillis, mo2160getDisplayModejFl4v0, function272222, (Function1) rememberedValue4, calendarModel22222, DateRangePickerState.this.getYearRange(), datePickerFormatter2, DateRangePickerState.this.getSelectableDates(), colors, composer3, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer3.skipToGroupEnd();
            }
        }), composer2, i1122222 | (i1222222 & 112) | (i1222222 & 896) | (i1222222 & 57344));
        if (ComposerKt.isTraceInProgress()) {
        }
        datePickerFormatter3 = datePickerFormatter2;
        z4 = z3;
        modifier3 = modifier422222;
        function26 = function25;
        datePickerColors3 = colors;
        final Function2<? super Composer, ? super Integer, Unit> function272222 = function24;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* renamed from: rememberDateRangePickerState-IlFM19s, reason: not valid java name */
    public static final DateRangePickerState m2157rememberDateRangePickerStateIlFM19s(Long l, Long l2, Long l3, IntRange intRange, int i, SelectableDates selectableDates, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(-2012087461);
        ComposerKt.sourceInformation(composer, "C(rememberDateRangePickerState)P(3,2,1,5,0:c#material3.DisplayMode)262@11461L15,265@11584L435,263@11488L531:DateRangePicker.kt#uh7d8r");
        final Long l4 = (i3 & 1) != 0 ? null : l;
        final Long l5 = (i3 & 2) != 0 ? null : l2;
        final Long l6 = (i3 & 4) != 0 ? l4 : l3;
        final IntRange yearRange = (i3 & 8) != 0 ? DatePickerDefaults.INSTANCE.getYearRange() : intRange;
        final int m2178getPickerjFl4v0 = (i3 & 16) != 0 ? DisplayMode.INSTANCE.m2178getPickerjFl4v0() : i;
        final SelectableDates allDates = (i3 & 32) != 0 ? DatePickerDefaults.INSTANCE.getAllDates() : selectableDates;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2012087461, i2, -1, "androidx.compose.material3.rememberDateRangePickerState (DateRangePicker.kt:261)");
        }
        final Locale defaultLocale = ActualAndroid_androidKt.defaultLocale(composer, 0);
        Object[] objArr = new Object[0];
        Saver<DateRangePickerStateImpl, Object> Saver = DateRangePickerStateImpl.INSTANCE.Saver(allDates, defaultLocale);
        composer.startReplaceableGroup(269010268);
        ComposerKt.sourceInformation(composer, "CC(remember):DateRangePicker.kt#9igjgp");
        boolean changedInstance = ((((i2 & 112) ^ 48) > 32 && composer.changed(l5)) || (i2 & 48) == 32) | ((((i2 & 14) ^ 6) > 4 && composer.changed(l4)) || (i2 & 6) == 4) | ((((i2 & 896) ^ 384) > 256 && composer.changed(l6)) || (i2 & 384) == 256) | composer.changedInstance(yearRange) | ((((57344 & i2) ^ 24576) > 16384 && composer.changed(m2178getPickerjFl4v0)) || (i2 & 24576) == 16384) | ((((458752 & i2) ^ ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) > 131072 && composer.changed(allDates)) || (i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 131072) | composer.changedInstance(defaultLocale);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = (Function0) new Function0<DateRangePickerStateImpl>() { // from class: androidx.compose.material3.DateRangePickerKt$rememberDateRangePickerState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DateRangePickerStateImpl invoke() {
                    return new DateRangePickerStateImpl(l4, l5, l6, yearRange, m2178getPickerjFl4v0, allDates, defaultLocale, null);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DateRangePickerStateImpl dateRangePickerStateImpl = (DateRangePickerStateImpl) RememberSaveableKt.m3680rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) rememberedValue, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return dateRangePickerStateImpl;
    }

    /* renamed from: DateRangePickerState-HVP43zI$default, reason: not valid java name */
    public static /* synthetic */ DateRangePickerState m2153DateRangePickerStateHVP43zI$default(Locale locale, Long l, Long l2, Long l3, IntRange intRange, int i, SelectableDates selectableDates, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l = null;
        }
        if ((i2 & 4) != 0) {
            l2 = null;
        }
        if ((i2 & 8) != 0) {
            l3 = l;
        }
        if ((i2 & 16) != 0) {
            intRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if ((i2 & 32) != 0) {
            i = DisplayMode.INSTANCE.m2178getPickerjFl4v0();
        }
        if ((i2 & 64) != 0) {
            selectableDates = DatePickerDefaults.INSTANCE.getAllDates();
        }
        return m2152DateRangePickerStateHVP43zI(locale, l, l2, l3, intRange, i, selectableDates);
    }

    /* renamed from: DateRangePickerState-HVP43zI, reason: not valid java name */
    public static final DateRangePickerState m2152DateRangePickerStateHVP43zI(Locale locale, Long l, Long l2, Long l3, IntRange intRange, int i, SelectableDates selectableDates) {
        return new DateRangePickerStateImpl(l, l2, l3, intRange, i, selectableDates, locale, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: SwitchableDateEntryContent-RN-2D1Q, reason: not valid java name */
    public static final void m2154SwitchableDateEntryContentRN2D1Q(final Long l, final Long l2, final long j, final int i, final Function2<? super Long, ? super Long, Unit> function2, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i2, final int i3) {
        int i4;
        Long l3;
        long j2;
        Function2<? super Long, ? super Long, Unit> function22;
        Function1<? super Long, Unit> function12;
        CalendarModel calendarModel2;
        IntRange intRange2;
        int i5;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-532789335);
        ComposerKt.sourceInformation(startRestartGroup, "C(SwitchableDateEntryContent)P(9,8,4,3:c#material3.DisplayMode,5,6!1,10,2,7)683@29429L1337:DateRangePicker.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(l) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            l3 = l2;
            i4 |= startRestartGroup.changed(l3) ? 32 : 16;
        } else {
            l3 = l2;
        }
        if ((i2 & 384) == 0) {
            j2 = j;
            i4 |= startRestartGroup.changed(j2) ? 256 : 128;
        } else {
            j2 = j;
        }
        if ((i2 & 3072) == 0) {
            i4 |= startRestartGroup.changed(i) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            function22 = function2;
            i4 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
        } else {
            function22 = function2;
        }
        if ((196608 & i2) == 0) {
            function12 = function1;
            i4 |= startRestartGroup.changedInstance(function12) ? 131072 : 65536;
        } else {
            function12 = function1;
        }
        if ((1572864 & i2) == 0) {
            calendarModel2 = calendarModel;
            i4 |= startRestartGroup.changedInstance(calendarModel2) ? 1048576 : 524288;
        } else {
            calendarModel2 = calendarModel;
        }
        if ((12582912 & i2) == 0) {
            intRange2 = intRange;
            i4 |= startRestartGroup.changedInstance(intRange2) ? 8388608 : 4194304;
        } else {
            intRange2 = intRange;
        }
        if ((i2 & 100663296) == 0) {
            i4 |= (i2 & 134217728) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? 67108864 : 33554432;
        }
        if ((i2 & C.ENCODING_PCM_32BIT) == 0) {
            i4 |= startRestartGroup.changed(selectableDates) ? 536870912 : 268435456;
        }
        if ((i3 & 6) == 0) {
            i5 = i3 | (startRestartGroup.changed(datePickerColors) ? 4 : 2);
        } else {
            i5 = i3;
        }
        if ((i4 & 306783379) != 306783378 || (i5 & 3) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-532789335, i4, i5, "androidx.compose.material3.SwitchableDateEntryContent (DateRangePicker.kt:680)");
            }
            final Long l4 = l3;
            final Function2<? super Long, ? super Long, Unit> function23 = function22;
            final IntRange intRange3 = intRange2;
            final long j3 = j2;
            final Function1<? super Long, Unit> function13 = function12;
            final CalendarModel calendarModel3 = calendarModel2;
            composer2 = startRestartGroup;
            CrossfadeKt.Crossfade(DisplayMode.m2170boximpl(i), SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.setContainer(semanticsPropertyReceiver, true);
                }
            }, 1, null), AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null), (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, -1026642619, true, new Function3<DisplayMode, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode, Composer composer3, Integer num) {
                    m2159invokeQujVXRc(displayMode.getValue(), composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-QujVXRc, reason: not valid java name */
                public final void m2159invokeQujVXRc(int i6, Composer composer3, int i7) {
                    int i8;
                    ComposerKt.sourceInformation(composer3, "CP(0:c#material3.DisplayMode):DateRangePicker.kt#uh7d8r");
                    if ((i7 & 6) == 0) {
                        i8 = i7 | (composer3.changed(i6) ? 4 : 2);
                    } else {
                        i8 = i7;
                    }
                    if ((i8 & 19) != 18 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1026642619, i8, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DateRangePicker.kt:690)");
                        }
                        if (DisplayMode.m2173equalsimpl0(i6, DisplayMode.INSTANCE.m2178getPickerjFl4v0())) {
                            composer3.startReplaceableGroup(-1168744807);
                            ComposerKt.sourceInformation(composer3, "691@29694L574");
                            DateRangePickerKt.DateRangePickerContent(l, l4, j3, function23, function13, calendarModel3, intRange3, datePickerFormatter, selectableDates, datePickerColors, composer3, 0);
                            composer3.endReplaceableGroup();
                        } else if (DisplayMode.m2173equalsimpl0(i6, DisplayMode.INSTANCE.m2177getInputjFl4v0())) {
                            composer3.startReplaceableGroup(-1168744198);
                            ComposerKt.sourceInformation(composer3, "704@30303L447");
                            DateRangeInputKt.DateRangeInputContent(l, l4, function23, calendarModel3, intRange3, datePickerFormatter, selectableDates, datePickerColors, composer3, 0);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(-1168743741);
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
            }), composer2, ((i4 >> 9) & 14) | 24960, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$3
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

                public final void invoke(Composer composer3, int i6) {
                    DateRangePickerKt.m2154SwitchableDateEntryContentRN2D1Q(l, l2, j, i, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DateRangePickerContent(final Long l, final Long l2, final long j, final Function2<? super Long, ? super Long, Unit> function2, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Long l3;
        Function2<? super Long, ? super Long, Unit> function22;
        Function1<? super Long, Unit> function12;
        SelectableDates selectableDates2;
        Composer startRestartGroup = composer.startRestartGroup(-787063721);
        ComposerKt.sourceInformation(startRestartGroup, "C(DateRangePickerContent)P(8,7,3,4,5!1,9,2,6)734@31377L87,735@31469L648:DateRangePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(l) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            l3 = l2;
            i2 |= startRestartGroup.changed(l3) ? 32 : 16;
        } else {
            l3 = l2;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function22 = function2;
            i2 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        } else {
            function22 = function2;
        }
        if ((i & 24576) == 0) {
            function12 = function1;
            i2 |= startRestartGroup.changedInstance(function12) ? 16384 : 8192;
        } else {
            function12 = function1;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(intRange) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= (16777216 & i) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            selectableDates2 = selectableDates;
            i2 |= startRestartGroup.changed(selectableDates2) ? 67108864 : 33554432;
        } else {
            selectableDates2 = selectableDates;
        }
        if ((i & C.ENCODING_PCM_32BIT) == 0) {
            i2 |= startRestartGroup.changed(datePickerColors) ? 536870912 : 268435456;
        }
        if ((i2 & 306783379) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-787063721, i2, -1, "androidx.compose.material3.DateRangePickerContent (DateRangePicker.kt:731)");
            }
            LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(calendarModel.getMonth(j).indexIn(intRange), 0, startRestartGroup, 0, 2);
            Modifier m881paddingVpY3zN4$default = PaddingKt.m881paddingVpY3zN4$default(Modifier.INSTANCE, DatePickerKt.getDatePickerHorizontalPadding(), 0.0f, 2, null);
            startRestartGroup.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m881paddingVpY3zN4$default);
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
            Updater.m3600setimpl(m3593constructorimpl, columnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3600setimpl(m3593constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (m3593constructorimpl.getInserting() || !Intrinsics.areEqual(m3593constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m3593constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m3593constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m3584boximpl(SkippableUpdater.m3585constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 276693656, "C79@3979L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1265380359, "C736@31557L31,737@31597L514:DateRangePicker.kt#uh7d8r");
            DatePickerKt.WeekDays(datePickerColors, calendarModel, startRestartGroup, ((i2 >> 27) & 14) | ((i2 >> 12) & 112));
            VerticalMonthsList(rememberLazyListState, l, l3, function22, function12, calendarModel, intRange, datePickerFormatter, selectableDates2, datePickerColors, startRestartGroup, ((i2 << 3) & 1008) | (i2 & 7168) | (57344 & i2) | (458752 & i2) | (3670016 & i2) | (29360128 & i2) | (234881024 & i2) | (1879048192 & i2));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePickerContent$2
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

                public final void invoke(Composer composer2, int i3) {
                    DateRangePickerKt.DateRangePickerContent(l, l2, j, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VerticalMonthsList(LazyListState lazyListState, final Long l, final Long l2, final Function2<? super Long, ? super Long, Unit> function2, final Function1<? super Long, Unit> function1, final CalendarModel calendarModel, final IntRange intRange, final DatePickerFormatter datePickerFormatter, final SelectableDates selectableDates, final DatePickerColors datePickerColors, Composer composer, final int i) {
        int i2;
        Long l3;
        Long l4;
        Function2<? super Long, ? super Long, Unit> function22;
        DateRangePickerKt$VerticalMonthsList$2$1 dateRangePickerKt$VerticalMonthsList$2$1;
        final LazyListState lazyListState2 = lazyListState;
        Composer startRestartGroup = composer.startRestartGroup(1257365001);
        ComposerKt.sourceInformation(startRestartGroup, "C(VerticalMonthsList)P(3,8,7,4,5!1,9,2,6)771@32837L138,778@33020L10,777@32980L4376,872@37391L228,872@37361L258:DateRangePicker.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(lazyListState2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            l3 = l;
            i2 |= startRestartGroup.changed(l3) ? 32 : 16;
        } else {
            l3 = l;
        }
        if ((i & 384) == 0) {
            l4 = l2;
            i2 |= startRestartGroup.changed(l4) ? 256 : 128;
        } else {
            l4 = l2;
        }
        if ((i & 3072) == 0) {
            function22 = function2;
            i2 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
        } else {
            function22 = function2;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(calendarModel) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(intRange) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= (16777216 & i) == 0 ? startRestartGroup.changed(datePickerFormatter) : startRestartGroup.changedInstance(datePickerFormatter) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= startRestartGroup.changed(selectableDates) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i2 |= startRestartGroup.changed(datePickerColors) ? 536870912 : 268435456;
        }
        if ((i2 & 306783379) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1257365001, i2, -1, "androidx.compose.material3.VerticalMonthsList (DateRangePicker.kt:769)");
            }
            final CalendarDate today = calendarModel.getToday();
            startRestartGroup.startReplaceableGroup(1454981403);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DateRangePicker.kt#9igjgp");
            boolean changed = startRestartGroup.changed(intRange);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = calendarModel.getMonth(intRange.getFirst(), 1);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final CalendarMonth calendarMonth = (CalendarMonth) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            final Long l5 = l3;
            final Function2<? super Long, ? super Long, Unit> function23 = function22;
            int i3 = i2;
            final Long l6 = l4;
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), DatePickerModalTokens.INSTANCE.getDateLabelTextFont()), ComposableLambdaKt.composableLambda(startRestartGroup, 1090773432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1
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

                public final void invoke(Composer composer2, int i4) {
                    final List customScrollActions;
                    ComposerKt.sourceInformation(composer2, "C780@33119L24,781@33185L59,782@33282L55,786@33518L317,810@34489L2861,803@34138L3212:DateRangePicker.kt#uh7d8r");
                    if ((i4 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1090773432, i4, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous> (DateRangePicker.kt:780)");
                        }
                        composer2.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composer2, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        composer2.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
                            composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            rememberedValue2 = compositionScopedCoroutineScopeCanceller;
                        }
                        composer2.endReplaceableGroup();
                        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
                        composer2.endReplaceableGroup();
                        Strings.Companion companion = Strings.INSTANCE;
                        String m2623getStringNWtq28 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_date_range_picker_scroll_to_previous_month), composer2, 0);
                        Strings.Companion companion2 = Strings.INSTANCE;
                        String m2623getStringNWtq282 = Strings_androidKt.m2623getStringNWtq28(Strings.m2554constructorimpl(R.string.m3c_date_range_picker_scroll_to_next_month), composer2, 0);
                        composer2.startReplaceableGroup(1645720805);
                        ComposerKt.sourceInformation(composer2, "CC(remember):DateRangePicker.kt#9igjgp");
                        boolean changed2 = composer2.changed(l5) | composer2.changed(l6) | composer2.changed(function23);
                        final Long l7 = l5;
                        final Long l8 = l6;
                        final Function2<Long, Long, Unit> function24 = function23;
                        Object rememberedValue3 = composer2.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$onDateSelectionChange$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Long l9) {
                                    invoke(l9.longValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(long j) {
                                    DateRangePickerKt.updateDateSelection(j, l7, l8, function24);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue3);
                        }
                        final Function1 function12 = (Function1) rememberedValue3;
                        composer2.endReplaceableGroup();
                        customScrollActions = DateRangePickerKt.customScrollActions(lazyListState2, coroutineScope, m2623getStringNWtq28, m2623getStringNWtq282);
                        Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setVerticalScrollAxisRange(semanticsPropertyReceiver, new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.1.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, new Function0<Float>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.1.2
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, false, 4, null));
                            }
                        }, 1, null);
                        LazyListState lazyListState3 = lazyListState2;
                        composer2.startReplaceableGroup(1645721776);
                        ComposerKt.sourceInformation(composer2, "CC(remember):DateRangePicker.kt#9igjgp");
                        boolean changedInstance = composer2.changedInstance(intRange) | composer2.changedInstance(calendarModel) | composer2.changed(calendarMonth) | composer2.changedInstance(datePickerFormatter) | composer2.changedInstance(customScrollActions) | composer2.changed(datePickerColors) | composer2.changed(l5) | composer2.changed(l6) | composer2.changed(function12) | composer2.changed(today) | composer2.changed(selectableDates);
                        final IntRange intRange2 = intRange;
                        final CalendarModel calendarModel2 = calendarModel;
                        final CalendarMonth calendarMonth2 = calendarMonth;
                        final Long l9 = l5;
                        final Long l10 = l6;
                        final CalendarDate calendarDate = today;
                        final DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
                        final SelectableDates selectableDates2 = selectableDates;
                        final DatePickerColors datePickerColors2 = datePickerColors;
                        Object rememberedValue4 = composer2.rememberedValue();
                        if (changedInstance || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue4 = (Function1) new Function1<LazyListScope, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                    invoke2(lazyListScope);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(LazyListScope lazyListScope) {
                                    int numberOfMonthsInRange = DatePickerKt.numberOfMonthsInRange(IntRange.this);
                                    final CalendarModel calendarModel3 = calendarModel2;
                                    final CalendarMonth calendarMonth3 = calendarMonth2;
                                    final Long l11 = l9;
                                    final Long l12 = l10;
                                    final Function1<Long, Unit> function13 = function12;
                                    final CalendarDate calendarDate2 = calendarDate;
                                    final DatePickerFormatter datePickerFormatter3 = datePickerFormatter2;
                                    final SelectableDates selectableDates3 = selectableDates2;
                                    final DatePickerColors datePickerColors3 = datePickerColors2;
                                    final List<CustomAccessibilityAction> list = customScrollActions;
                                    LazyListScope.items$default(lazyListScope, numberOfMonthsInRange, null, null, ComposableLambdaKt.composableLambdaInstance(-1413501381, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer3, Integer num2) {
                                            invoke(lazyItemScope, num.intValue(), composer3, num2.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer3, int i6) {
                                            int i7;
                                            SelectedRangeInfo selectedRangeInfo;
                                            ComposerKt.sourceInformation(composer3, "C817@34746L2580:DateRangePicker.kt#uh7d8r");
                                            if ((i6 & 6) == 0) {
                                                i7 = i6 | (composer3.changed(lazyItemScope) ? 4 : 2);
                                            } else {
                                                i7 = i6;
                                            }
                                            if ((i6 & 48) == 0) {
                                                i7 |= composer3.changed(i5) ? 32 : 16;
                                            }
                                            if ((i7 & 147) != 146 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1413501381, i7, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DateRangePicker.kt:812)");
                                                }
                                                final CalendarMonth plusMonths = CalendarModel.this.plusMonths(calendarMonth3, i5);
                                                Modifier fillParentMaxWidth$default = LazyItemScope.fillParentMaxWidth$default(lazyItemScope, Modifier.INSTANCE, 0.0f, 1, null);
                                                Long l13 = l11;
                                                Long l14 = l12;
                                                Function1<Long, Unit> function14 = function13;
                                                CalendarDate calendarDate3 = calendarDate2;
                                                final DatePickerFormatter datePickerFormatter4 = datePickerFormatter3;
                                                SelectableDates selectableDates4 = selectableDates3;
                                                final DatePickerColors datePickerColors4 = datePickerColors3;
                                                final List<CustomAccessibilityAction> list2 = list;
                                                CalendarModel calendarModel4 = CalendarModel.this;
                                                composer3.startReplaceableGroup(-483455358);
                                                ComposerKt.sourceInformation(composer3, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                                                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                                composer3.startReplaceableGroup(-1323940314);
                                                ComposerKt.sourceInformation(composer3, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                                CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                                                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillParentMaxWidth$default);
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
                                                ComposerKt.sourceInformationMarkerStart(composer3, -1455464542, "C821@34911L10,820@34855L947,857@36762L546:DateRangePicker.kt#uh7d8r");
                                                TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer3, 6), DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadFont()), ComposableLambdaKt.composableLambda(composer3, 1622100276, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1$1$1$1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                                        invoke(composer4, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer4, int i8) {
                                                        ComposerKt.sourceInformation(composer4, "C828@35250L15,833@35577L113,825@35088L692:DateRangePicker.kt#uh7d8r");
                                                        if ((i8 & 3) != 2 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(1622100276, i8, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DateRangePicker.kt:825)");
                                                            }
                                                            String formatMonthYear = DatePickerFormatter.this.formatMonthYear(Long.valueOf(plusMonths.getStartUtcTimeMillis()), ActualAndroid_androidKt.defaultLocale(composer4, 0));
                                                            if (formatMonthYear == null) {
                                                                formatMonthYear = "-";
                                                            }
                                                            Modifier m561clickableXHw0xAI$default = ClickableKt.m561clickableXHw0xAI$default(PaddingKt.padding(Modifier.INSTANCE, DateRangePickerKt.getCalendarMonthSubheadPadding()), false, null, null, new Function0<Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1$1$1$1.1
                                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                public final void invoke2() {
                                                                }

                                                                @Override // kotlin.jvm.functions.Function0
                                                                public /* bridge */ /* synthetic */ Unit invoke() {
                                                                    invoke2();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            }, 7, null);
                                                            composer4.startReplaceableGroup(413139989);
                                                            ComposerKt.sourceInformation(composer4, "CC(remember):DateRangePicker.kt#9igjgp");
                                                            boolean changedInstance2 = composer4.changedInstance(list2);
                                                            final List<CustomAccessibilityAction> list3 = list2;
                                                            Object rememberedValue5 = composer4.rememberedValue();
                                                            if (changedInstance2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                                                rememberedValue5 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1$1$1$1$2$1
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
                                                                        SemanticsPropertiesKt.setCustomActions(semanticsPropertyReceiver, list3);
                                                                    }
                                                                };
                                                                composer4.updateRememberedValue(rememberedValue5);
                                                            }
                                                            composer4.endReplaceableGroup();
                                                            TextKt.m2781Text4IGK_g(formatMonthYear, SemanticsModifierKt.semantics$default(m561clickableXHw0xAI$default, false, (Function1) rememberedValue5, 1, null), datePickerColors4.getSubheadContentColor(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer4, 0, 0, 131064);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }), composer3, 48);
                                                composer3.startReplaceableGroup(-1455463505);
                                                ComposerKt.sourceInformation(composer3, "843@36045L604");
                                                if (l13 == null || l14 == null) {
                                                    selectedRangeInfo = null;
                                                } else {
                                                    composer3.startReplaceableGroup(-1455463352);
                                                    ComposerKt.sourceInformation(composer3, "CC(remember):DateRangePicker.kt#9igjgp");
                                                    boolean changed3 = composer3.changed(l13) | composer3.changed(l14);
                                                    Object rememberedValue5 = composer3.rememberedValue();
                                                    if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue5 = SelectedRangeInfo.INSTANCE.calculateRangeInfo(plusMonths, calendarModel4.getCanonicalDate(l13.longValue()), calendarModel4.getCanonicalDate(l14.longValue()));
                                                        composer3.updateRememberedValue(rememberedValue5);
                                                    }
                                                    selectedRangeInfo = (SelectedRangeInfo) rememberedValue5;
                                                    composer3.endReplaceableGroup();
                                                }
                                                composer3.endReplaceableGroup();
                                                DatePickerKt.Month(plusMonths, function14, calendarDate3.getUtcTimeMillis(), l13, l14, selectedRangeInfo, datePickerFormatter4, selectableDates4, datePickerColors4, composer3, 0);
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
                                    }), 6, null);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue4);
                        }
                        composer2.endReplaceableGroup();
                        LazyDslKt.LazyColumn(semantics$default, lazyListState3, null, false, null, null, null, false, (Function1) rememberedValue4, composer2, 0, 252);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(1454985957);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):DateRangePicker.kt#9igjgp");
            int i4 = i3 & 14;
            boolean changedInstance = (i4 == 4) | ((57344 & i3) == 16384) | startRestartGroup.changedInstance(calendarModel) | startRestartGroup.changedInstance(intRange);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                lazyListState2 = lazyListState;
                dateRangePickerKt$VerticalMonthsList$2$1 = new DateRangePickerKt$VerticalMonthsList$2$1(lazyListState2, function1, calendarModel, intRange, null);
                startRestartGroup.updateRememberedValue(dateRangePickerKt$VerticalMonthsList$2$1);
            } else {
                dateRangePickerKt$VerticalMonthsList$2$1 = rememberedValue2;
                lazyListState2 = lazyListState;
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(lazyListState2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) dateRangePickerKt$VerticalMonthsList$2$1, startRestartGroup, i4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$3
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
                    DateRangePickerKt.VerticalMonthsList(LazyListState.this, l, l2, function2, function1, calendarModel, intRange, datePickerFormatter, selectableDates, datePickerColors, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDateSelection(long j, Long l, Long l2, Function2<? super Long, ? super Long, Unit> function2) {
        if ((l == null && l2 == null) || (l != null && l2 != null)) {
            function2.invoke(Long.valueOf(j), null);
        } else if (l != null && j >= l.longValue()) {
            function2.invoke(l, Long.valueOf(j));
        } else {
            function2.invoke(Long.valueOf(j), null);
        }
    }

    public static final PaddingValues getCalendarMonthSubheadPadding() {
        return CalendarMonthSubheadPadding;
    }

    /* renamed from: drawRangeBackground-mxwnekA, reason: not valid java name */
    public static final void m2156drawRangeBackgroundmxwnekA(ContentDrawScope contentDrawScope, SelectedRangeInfo selectedRangeInfo, long j) {
        float m3891getWidthimpl;
        float f = contentDrawScope.mo630toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float f2 = contentDrawScope.mo630toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float f3 = contentDrawScope.mo630toPx0680j_4(DatePickerModalTokens.INSTANCE.m3099getDateStateLayerHeightD9Ej5fM());
        float f4 = 2;
        float f5 = (f2 - f3) / f4;
        float f6 = 7;
        float m3891getWidthimpl2 = (Size.m3891getWidthimpl(contentDrawScope.mo4612getSizeNHjbRc()) - (f6 * f)) / f6;
        long gridStartCoordinates = selectedRangeInfo.getGridStartCoordinates();
        int m6509component1impl = IntOffset.m6509component1impl(gridStartCoordinates);
        int m6510component2impl = IntOffset.m6510component2impl(gridStartCoordinates);
        long gridEndCoordinates = selectedRangeInfo.getGridEndCoordinates();
        int m6509component1impl2 = IntOffset.m6509component1impl(gridEndCoordinates);
        int m6510component2impl2 = IntOffset.m6510component2impl(gridEndCoordinates);
        float f7 = f + m3891getWidthimpl2;
        float f8 = m3891getWidthimpl2 / f4;
        float f9 = (m6509component1impl * f7) + (selectedRangeInfo.getFirstIsSelectionStart() ? f / f4 : 0.0f) + f8;
        float f10 = (m6510component2impl * f2) + f5;
        float f11 = m6509component1impl2 * f7;
        if (selectedRangeInfo.getLastIsSelectionEnd()) {
            f /= f4;
        }
        float f12 = f11 + f + f8;
        float f13 = (m6510component2impl2 * f2) + f5;
        boolean z = contentDrawScope.getLayoutDirection() == LayoutDirection.Rtl;
        if (z) {
            f9 = Size.m3891getWidthimpl(contentDrawScope.mo4612getSizeNHjbRc()) - f9;
            f12 = Size.m3891getWidthimpl(contentDrawScope.mo4612getSizeNHjbRc()) - f12;
        }
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        long Offset = OffsetKt.Offset(f9, f10);
        if (m6510component2impl == m6510component2impl2) {
            m3891getWidthimpl = f12 - f9;
        } else {
            m3891getWidthimpl = z ? -f9 : Size.m3891getWidthimpl(contentDrawScope.mo4612getSizeNHjbRc()) - f9;
        }
        DrawScope.m4607drawRectnJ9OG0$default(contentDrawScope2, j, Offset, SizeKt.Size(m3891getWidthimpl, f3), 0.0f, null, null, 0, 120, null);
        if (m6510component2impl != m6510component2impl2) {
            for (int i = (m6510component2impl2 - m6510component2impl) - 1; i > 0; i--) {
                DrawScope.m4607drawRectnJ9OG0$default(contentDrawScope2, j, OffsetKt.Offset(0.0f, (i * f2) + f10), SizeKt.Size(Size.m3891getWidthimpl(contentDrawScope.mo4612getSizeNHjbRc()), f3), 0.0f, null, null, 0, 120, null);
            }
            long Offset2 = OffsetKt.Offset(contentDrawScope.getLayoutDirection() != LayoutDirection.Ltr ? Size.m3891getWidthimpl(contentDrawScope.mo4612getSizeNHjbRc()) : 0.0f, f13);
            if (z) {
                f12 -= Size.m3891getWidthimpl(contentDrawScope.mo4612getSizeNHjbRc());
            }
            DrawScope.m4607drawRectnJ9OG0$default(contentDrawScope2, j, Offset2, SizeKt.Size(f12, f3), 0.0f, null, null, 0, 120, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(final LazyListState lazyListState, final CoroutineScope coroutineScope, String str, String str2) {
        return CollectionsKt.listOf((Object[]) new CustomAccessibilityAction[]{new CustomAccessibilityAction(str, new Function0<Boolean>() { // from class: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                if (LazyListState.this.getCanScrollBackward()) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(LazyListState.this, null), 3, null);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            /* compiled from: DateRangePicker.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1$1", f = "DateRangePicker.kt", i = {}, l = {1064}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ LazyListState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LazyListState lazyListState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$state = lazyListState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        LazyListState lazyListState = this.$state;
                        this.label = 1;
                        if (LazyListState.scrollToItem$default(lazyListState, lazyListState.getFirstVisibleItemIndex() - 1, 0, this, 2, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        }), new CustomAccessibilityAction(str2, new Function0<Boolean>() { // from class: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                if (LazyListState.this.getCanScrollForward()) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(LazyListState.this, null), 3, null);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            /* compiled from: DateRangePicker.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1$1", f = "DateRangePicker.kt", i = {}, l = {1074}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ LazyListState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LazyListState lazyListState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$state = lazyListState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        LazyListState lazyListState = this.$state;
                        this.label = 1;
                        if (LazyListState.scrollToItem$default(lazyListState, lazyListState.getFirstVisibleItemIndex() + 1, 0, this, 2, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }
        })});
    }

    static {
        float f = 64;
        float f2 = 12;
        DateRangePickerTitlePadding = PaddingKt.m876PaddingValuesa9UjIt4$default(Dp.m6389constructorimpl(f), 0.0f, Dp.m6389constructorimpl(f2), 0.0f, 10, null);
        DateRangePickerHeadlinePadding = PaddingKt.m876PaddingValuesa9UjIt4$default(Dp.m6389constructorimpl(f), 0.0f, Dp.m6389constructorimpl(f2), Dp.m6389constructorimpl(f2), 2, null);
    }
}
