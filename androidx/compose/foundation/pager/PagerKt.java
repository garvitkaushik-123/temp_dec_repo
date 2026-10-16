package androidx.compose.foundation.pager;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.FinalSnappingItem;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayoutKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.C;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C3040d4;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Pager.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u001aØ\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00012%\b\u0002\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001f21\u0010 \u001a-\u0012\u0004\u0012\u00020\"\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b$¢\u0006\u0002\b%H\u0007ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a.\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u00020/H\u0002\u001aØ\u0001\u00101\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00012%\b\u0002\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001f21\u0010 \u001a-\u0012\u0004\u0012\u00020\"\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00060!¢\u0006\u0002\b$¢\u0006\u0002\b%H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a\u0017\u00106\u001a\u00020\u00062\f\u00107\u001a\b\u0012\u0004\u0012\u00020908H\u0082\b\u001a\f\u0010:\u001a\u00020/*\u00020\bH\u0002\u001a\f\u0010;\u001a\u00020\u0001*\u00020\bH\u0002\u001a!\u0010<\u001a\u00020\n*\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010=\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010>\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006?"}, d2 = {"DEBUG", "", "LowVelocityAnimationDefaultDuration", "", "PagerDebugEnable", "HorizontalPager", "", "state", "Landroidx/compose/foundation/pager/PagerState;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "pageSize", "Landroidx/compose/foundation/pager/PageSize;", "beyondBoundsPageCount", "pageSpacing", "Landroidx/compose/ui/unit/Dp;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;", "userScrollEnabled", "reverseLayout", C3040d4.h.W, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", FirebaseAnalytics.Param.INDEX, "", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "pageContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "page", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "HorizontalPager-xYaah8o", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "SnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "pagerState", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapPositionalThreshold", "VerticalPager", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "VerticalPager-xYaah8o", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/pager/PageSize;IFLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/snapping/SnapFlingBehavior;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;III)V", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "dragGestureDelta", "isScrollingForward", "pagerSemantics", "isVertical", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerKt {
    private static final boolean DEBUG = false;
    private static final int LowVelocityAnimationDefaultDuration = 500;
    public static final boolean PagerDebugEnable = false;

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0275  */
    /* renamed from: HorizontalPager-xYaah8o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1107HorizontalPagerxYaah8o(final PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Vertical vertical, SnapFlingBehavior snapFlingBehavior, boolean z, boolean z2, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection nestedScrollConnection, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        PaddingValues paddingValues2;
        int i7;
        PageSize pageSize2;
        int i8;
        int i9;
        int i10;
        float f2;
        int i11;
        Alignment.Vertical vertical2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        boolean z3;
        Composer composer2;
        PagerState pagerState2;
        int i21;
        SnapFlingBehavior snapFlingBehavior2;
        NestedScrollConnection nestedScrollConnection2;
        SnapFlingBehavior snapFlingBehavior3;
        boolean z4;
        final Function1<? super Integer, ? extends Object> function12;
        PageSize pageSize3;
        Modifier modifier3;
        PaddingValues paddingValues3;
        boolean z5;
        int i22;
        Composer composer3;
        final PageSize pageSize4;
        final NestedScrollConnection nestedScrollConnection3;
        final boolean z6;
        final boolean z7;
        final float f3;
        final PaddingValues paddingValues4;
        final SnapFlingBehavior snapFlingBehavior4;
        final int i23;
        final Modifier modifier4;
        ScopeUpdateScope endRestartGroup;
        int i24;
        Composer startRestartGroup = composer.startRestartGroup(1491175841);
        ComposerKt.sourceInformation(startRestartGroup, "C(HorizontalPager)P(10,4,1,7!1,8:c#ui.unit.Dp,12!1,11,9!1,6)116@6471L28,120@6673L103,125@6846L620:Pager.kt#g6yjnt");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (startRestartGroup.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i25 = i4 & 2;
        if (i25 != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i2 & 896) == 0) {
                paddingValues2 = paddingValues;
                i5 |= startRestartGroup.changed(paddingValues2) ? 256 : 128;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 7168) == 0) {
                    pageSize2 = pageSize;
                    i5 |= startRestartGroup.changed(pageSize2) ? 2048 : 1024;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                        i9 = i;
                    } else {
                        i9 = i;
                        if ((i2 & 57344) == 0) {
                            i5 |= startRestartGroup.changed(i9) ? 16384 : 8192;
                        }
                    }
                    i10 = i4 & 32;
                    if (i10 == 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        f2 = f;
                    } else {
                        f2 = f;
                        if ((i2 & 458752) == 0) {
                            i5 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                        }
                    }
                    i11 = i4 & 64;
                    if (i11 == 0) {
                        i5 |= 1572864;
                        vertical2 = vertical;
                    } else {
                        vertical2 = vertical;
                        if ((i2 & 3670016) == 0) {
                            i5 |= startRestartGroup.changed(vertical2) ? 1048576 : 524288;
                        }
                    }
                    if ((i2 & 29360128) == 0) {
                        if ((i4 & 128) == 0 && startRestartGroup.changed(snapFlingBehavior)) {
                            i24 = 8388608;
                            i5 |= i24;
                        }
                        i24 = 4194304;
                        i5 |= i24;
                    }
                    i12 = i4 & 256;
                    if (i12 == 0) {
                        i5 |= 100663296;
                    } else if ((i2 & 234881024) == 0) {
                        i13 = i12;
                        i5 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
                        i14 = i4 & 512;
                        if (i14 != 0) {
                            i16 = i5 | C.ENCODING_PCM_32BIT;
                            i15 = i14;
                        } else {
                            if ((i2 & 1879048192) == 0) {
                                i15 = i14;
                                i5 |= startRestartGroup.changed(z2) ? 536870912 : 268435456;
                            } else {
                                i15 = i14;
                            }
                            i16 = i5;
                        }
                        i17 = i4 & 1024;
                        if (i17 != 0) {
                            i18 = i3 | 6;
                        } else if ((i3 & 14) == 0) {
                            i18 = i3 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i18 = i3;
                        }
                        i19 = i4 & 2048;
                        if (i19 != 0) {
                            i18 |= 16;
                        }
                        int i26 = i18;
                        if ((i4 & 4096) != 0) {
                            i26 |= 384;
                        } else if ((i3 & 896) == 0) {
                            i26 |= startRestartGroup.changedInstance(function4) ? 256 : 128;
                        }
                        if (i19 == 2048) {
                            i20 = i19;
                            if ((i16 & 1533916891) == 306783378 && (i26 & 731) == 146 && startRestartGroup.getSkipping()) {
                                startRestartGroup.skipToGroupEnd();
                                z6 = z2;
                                function12 = function1;
                                nestedScrollConnection3 = nestedScrollConnection;
                                pageSize4 = pageSize2;
                                modifier4 = modifier2;
                                i23 = i9;
                                f3 = f2;
                                paddingValues4 = paddingValues2;
                                snapFlingBehavior4 = snapFlingBehavior;
                                z7 = z;
                                final Alignment.Vertical vertical3 = vertical2;
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup == null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$HorizontalPager$2
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

                                        public final void invoke(Composer composer4, int i27) {
                                            PagerKt.m1107HorizontalPagerxYaah8o(PagerState.this, modifier4, paddingValues4, pageSize4, i23, f3, vertical3, snapFlingBehavior4, z7, z6, function12, nestedScrollConnection3, function4, composer4, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                        } else {
                            i20 = i19;
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier5 = i25 != 0 ? Modifier.INSTANCE : modifier2;
                            PaddingValues m872PaddingValues0680j_4 = i6 != 0 ? PaddingKt.m872PaddingValues0680j_4(Dp.m6389constructorimpl(0)) : paddingValues2;
                            PageSize pageSize5 = i7 != 0 ? PageSize.Fill.INSTANCE : pageSize2;
                            int i27 = i8 != 0 ? 0 : i9;
                            float m6389constructorimpl = i10 != 0 ? Dp.m6389constructorimpl(0) : f2;
                            if (i11 != 0) {
                                vertical2 = Alignment.INSTANCE.getCenterVertically();
                            }
                            if ((i4 & 128) != 0) {
                                i21 = i26;
                                composer2 = startRestartGroup;
                                z3 = false;
                                pagerState2 = pagerState;
                                snapFlingBehavior2 = PagerDefaults.INSTANCE.flingBehavior(pagerState2, null, null, null, null, 0.0f, composer2, (i16 & 14) | 2097152, 62);
                                i16 &= -29360129;
                            } else {
                                z3 = false;
                                composer2 = startRestartGroup;
                                pagerState2 = pagerState;
                                i21 = i26;
                                snapFlingBehavior2 = snapFlingBehavior;
                            }
                            boolean z8 = i13 != 0 ? true : z;
                            if (i15 == 0) {
                                z3 = z2;
                            }
                            Function1<? super Integer, ? extends Object> function13 = i17 != 0 ? null : function1;
                            if (i20 != 0) {
                                composer2.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation(composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                                boolean changed = composer2.changed(pagerState2);
                                Object rememberedValue = composer2.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState2, Orientation.Horizontal);
                                    composer2.updateRememberedValue(rememberedValue);
                                }
                                composer2.endReplaceableGroup();
                                z4 = z8;
                                function12 = function13;
                                i21 &= -113;
                                nestedScrollConnection2 = (NestedScrollConnection) rememberedValue;
                                pageSize3 = pageSize5;
                                f2 = m6389constructorimpl;
                                paddingValues3 = m872PaddingValues0680j_4;
                                z5 = z3;
                                i22 = i16;
                                snapFlingBehavior3 = snapFlingBehavior2;
                                composer3 = composer2;
                                i9 = i27;
                                modifier3 = modifier5;
                            } else {
                                nestedScrollConnection2 = nestedScrollConnection;
                                snapFlingBehavior3 = snapFlingBehavior2;
                                z4 = z8;
                                function12 = function13;
                                pageSize3 = pageSize5;
                                modifier3 = modifier5;
                                f2 = m6389constructorimpl;
                                paddingValues3 = m872PaddingValues0680j_4;
                                z5 = z3;
                                i22 = i16;
                                composer3 = composer2;
                                i9 = i27;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i4 & 128) != 0) {
                                i16 &= -29360129;
                            }
                            if (i20 != 0) {
                                i26 &= -113;
                            }
                            z4 = z;
                            function12 = function1;
                            nestedScrollConnection2 = nestedScrollConnection;
                            paddingValues3 = paddingValues2;
                            composer3 = startRestartGroup;
                            i22 = i16;
                            i21 = i26;
                            pageSize3 = pageSize2;
                            modifier3 = modifier2;
                            snapFlingBehavior3 = snapFlingBehavior;
                            z5 = z2;
                        }
                        composer3.endDefaults();
                        Modifier modifier6 = modifier3;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1491175841, i22, i21, "androidx.compose.foundation.pager.HorizontalPager (Pager.kt:124)");
                        }
                        int i28 = i22 >> 6;
                        int i29 = ((i22 >> 3) & 14) | 24576 | ((i22 << 3) & 112) | (i22 & 896) | ((i22 >> 18) & 7168) | (i28 & 458752) | (i28 & 3670016);
                        int i30 = i22 << 9;
                        int i31 = ((i21 << 3) & 112) | 392 | ((i22 >> 9) & 7168) | ((i21 << 6) & 57344);
                        Composer composer4 = composer3;
                        LazyLayoutPagerKt.m1102Pagerfs30GE4(modifier6, pagerState, paddingValues3, z5, Orientation.Horizontal, snapFlingBehavior3, z4, i9, f2, pageSize3, nestedScrollConnection2, function12, Alignment.INSTANCE.getCenterHorizontally(), vertical2, function4, composer4, i29 | (i30 & 29360128) | (i30 & 234881024) | ((i22 << 18) & 1879048192), i31, 0);
                        int i32 = i9;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        startRestartGroup = composer4;
                        pageSize4 = pageSize3;
                        nestedScrollConnection3 = nestedScrollConnection2;
                        z6 = z5;
                        z7 = z4;
                        f3 = f2;
                        paddingValues4 = paddingValues3;
                        snapFlingBehavior4 = snapFlingBehavior3;
                        i23 = i32;
                        modifier4 = modifier6;
                        final Alignment.Vertical vertical32 = vertical2;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i13 = i12;
                    i14 = i4 & 512;
                    if (i14 != 0) {
                    }
                    i17 = i4 & 1024;
                    if (i17 != 0) {
                    }
                    i19 = i4 & 2048;
                    if (i19 != 0) {
                    }
                    int i262 = i18;
                    if ((i4 & 4096) != 0) {
                    }
                    if (i19 == 2048) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i25 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if ((i4 & 128) != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i15 == 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    composer3.endDefaults();
                    Modifier modifier62 = modifier3;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i282 = i22 >> 6;
                    int i292 = ((i22 >> 3) & 14) | 24576 | ((i22 << 3) & 112) | (i22 & 896) | ((i22 >> 18) & 7168) | (i282 & 458752) | (i282 & 3670016);
                    int i302 = i22 << 9;
                    int i312 = ((i21 << 3) & 112) | 392 | ((i22 >> 9) & 7168) | ((i21 << 6) & 57344);
                    Composer composer42 = composer3;
                    LazyLayoutPagerKt.m1102Pagerfs30GE4(modifier62, pagerState, paddingValues3, z5, Orientation.Horizontal, snapFlingBehavior3, z4, i9, f2, pageSize3, nestedScrollConnection2, function12, Alignment.INSTANCE.getCenterHorizontally(), vertical2, function4, composer42, i292 | (i302 & 29360128) | (i302 & 234881024) | ((i22 << 18) & 1879048192), i312, 0);
                    int i322 = i9;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup = composer42;
                    pageSize4 = pageSize3;
                    nestedScrollConnection3 = nestedScrollConnection2;
                    z6 = z5;
                    z7 = z4;
                    f3 = f2;
                    paddingValues4 = paddingValues3;
                    snapFlingBehavior4 = snapFlingBehavior3;
                    i23 = i322;
                    modifier4 = modifier62;
                    final Alignment.Vertical vertical322 = vertical2;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                pageSize2 = pageSize;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i10 = i4 & 32;
                if (i10 == 0) {
                }
                i11 = i4 & 64;
                if (i11 == 0) {
                }
                if ((i2 & 29360128) == 0) {
                }
                i12 = i4 & 256;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i4 & 512;
                if (i14 != 0) {
                }
                i17 = i4 & 1024;
                if (i17 != 0) {
                }
                i19 = i4 & 2048;
                if (i19 != 0) {
                }
                int i2622 = i18;
                if ((i4 & 4096) != 0) {
                }
                if (i19 == 2048) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i25 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if ((i4 & 128) != 0) {
                }
                if (i13 != 0) {
                }
                if (i15 == 0) {
                }
                if (i17 != 0) {
                }
                if (i20 != 0) {
                }
                composer3.endDefaults();
                Modifier modifier622 = modifier3;
                if (ComposerKt.isTraceInProgress()) {
                }
                int i2822 = i22 >> 6;
                int i2922 = ((i22 >> 3) & 14) | 24576 | ((i22 << 3) & 112) | (i22 & 896) | ((i22 >> 18) & 7168) | (i2822 & 458752) | (i2822 & 3670016);
                int i3022 = i22 << 9;
                int i3122 = ((i21 << 3) & 112) | 392 | ((i22 >> 9) & 7168) | ((i21 << 6) & 57344);
                Composer composer422 = composer3;
                LazyLayoutPagerKt.m1102Pagerfs30GE4(modifier622, pagerState, paddingValues3, z5, Orientation.Horizontal, snapFlingBehavior3, z4, i9, f2, pageSize3, nestedScrollConnection2, function12, Alignment.INSTANCE.getCenterHorizontally(), vertical2, function4, composer422, i2922 | (i3022 & 29360128) | (i3022 & 234881024) | ((i22 << 18) & 1879048192), i3122, 0);
                int i3222 = i9;
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup = composer422;
                pageSize4 = pageSize3;
                nestedScrollConnection3 = nestedScrollConnection2;
                z6 = z5;
                z7 = z4;
                f3 = f2;
                paddingValues4 = paddingValues3;
                snapFlingBehavior4 = snapFlingBehavior3;
                i23 = i3222;
                modifier4 = modifier622;
                final Alignment.Vertical vertical3222 = vertical2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            paddingValues2 = paddingValues;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            pageSize2 = pageSize;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i10 = i4 & 32;
            if (i10 == 0) {
            }
            i11 = i4 & 64;
            if (i11 == 0) {
            }
            if ((i2 & 29360128) == 0) {
            }
            i12 = i4 & 256;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i4 & 512;
            if (i14 != 0) {
            }
            i17 = i4 & 1024;
            if (i17 != 0) {
            }
            i19 = i4 & 2048;
            if (i19 != 0) {
            }
            int i26222 = i18;
            if ((i4 & 4096) != 0) {
            }
            if (i19 == 2048) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i25 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if ((i4 & 128) != 0) {
            }
            if (i13 != 0) {
            }
            if (i15 == 0) {
            }
            if (i17 != 0) {
            }
            if (i20 != 0) {
            }
            composer3.endDefaults();
            Modifier modifier6222 = modifier3;
            if (ComposerKt.isTraceInProgress()) {
            }
            int i28222 = i22 >> 6;
            int i29222 = ((i22 >> 3) & 14) | 24576 | ((i22 << 3) & 112) | (i22 & 896) | ((i22 >> 18) & 7168) | (i28222 & 458752) | (i28222 & 3670016);
            int i30222 = i22 << 9;
            int i31222 = ((i21 << 3) & 112) | 392 | ((i22 >> 9) & 7168) | ((i21 << 6) & 57344);
            Composer composer4222 = composer3;
            LazyLayoutPagerKt.m1102Pagerfs30GE4(modifier6222, pagerState, paddingValues3, z5, Orientation.Horizontal, snapFlingBehavior3, z4, i9, f2, pageSize3, nestedScrollConnection2, function12, Alignment.INSTANCE.getCenterHorizontally(), vertical2, function4, composer4222, i29222 | (i30222 & 29360128) | (i30222 & 234881024) | ((i22 << 18) & 1879048192), i31222, 0);
            int i32222 = i9;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup = composer4222;
            pageSize4 = pageSize3;
            nestedScrollConnection3 = nestedScrollConnection2;
            z6 = z5;
            z7 = z4;
            f3 = f2;
            paddingValues4 = paddingValues3;
            snapFlingBehavior4 = snapFlingBehavior3;
            i23 = i32222;
            modifier4 = modifier6222;
            final Alignment.Vertical vertical32222 = vertical2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        paddingValues2 = paddingValues;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        pageSize2 = pageSize;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i10 = i4 & 32;
        if (i10 == 0) {
        }
        i11 = i4 & 64;
        if (i11 == 0) {
        }
        if ((i2 & 29360128) == 0) {
        }
        i12 = i4 & 256;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i4 & 512;
        if (i14 != 0) {
        }
        i17 = i4 & 1024;
        if (i17 != 0) {
        }
        i19 = i4 & 2048;
        if (i19 != 0) {
        }
        int i262222 = i18;
        if ((i4 & 4096) != 0) {
        }
        if (i19 == 2048) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i25 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if ((i4 & 128) != 0) {
        }
        if (i13 != 0) {
        }
        if (i15 == 0) {
        }
        if (i17 != 0) {
        }
        if (i20 != 0) {
        }
        composer3.endDefaults();
        Modifier modifier62222 = modifier3;
        if (ComposerKt.isTraceInProgress()) {
        }
        int i282222 = i22 >> 6;
        int i292222 = ((i22 >> 3) & 14) | 24576 | ((i22 << 3) & 112) | (i22 & 896) | ((i22 >> 18) & 7168) | (i282222 & 458752) | (i282222 & 3670016);
        int i302222 = i22 << 9;
        int i312222 = ((i21 << 3) & 112) | 392 | ((i22 >> 9) & 7168) | ((i21 << 6) & 57344);
        Composer composer42222 = composer3;
        LazyLayoutPagerKt.m1102Pagerfs30GE4(modifier62222, pagerState, paddingValues3, z5, Orientation.Horizontal, snapFlingBehavior3, z4, i9, f2, pageSize3, nestedScrollConnection2, function12, Alignment.INSTANCE.getCenterHorizontally(), vertical2, function4, composer42222, i292222 | (i302222 & 29360128) | (i302222 & 234881024) | ((i22 << 18) & 1879048192), i312222, 0);
        int i322222 = i9;
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup = composer42222;
        pageSize4 = pageSize3;
        nestedScrollConnection3 = nestedScrollConnection2;
        z6 = z5;
        z7 = z4;
        f3 = f2;
        paddingValues4 = paddingValues3;
        snapFlingBehavior4 = snapFlingBehavior3;
        i23 = i322222;
        modifier4 = modifier62222;
        final Alignment.Vertical vertical322222 = vertical2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0276  */
    /* renamed from: VerticalPager-xYaah8o, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1108VerticalPagerxYaah8o(final PagerState pagerState, Modifier modifier, PaddingValues paddingValues, PageSize pageSize, int i, float f, Alignment.Horizontal horizontal, SnapFlingBehavior snapFlingBehavior, boolean z, boolean z2, Function1<? super Integer, ? extends Object> function1, NestedScrollConnection nestedScrollConnection, final Function4<? super PagerScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i2, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        int i6;
        PaddingValues paddingValues2;
        int i7;
        PageSize pageSize2;
        int i8;
        int i9;
        int i10;
        float f2;
        int i11;
        Alignment.Horizontal horizontal2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        boolean z3;
        Composer composer2;
        PagerState pagerState2;
        int i21;
        SnapFlingBehavior snapFlingBehavior2;
        NestedScrollConnection nestedScrollConnection2;
        SnapFlingBehavior snapFlingBehavior3;
        boolean z4;
        final Function1<? super Integer, ? extends Object> function12;
        Alignment.Horizontal horizontal3;
        PageSize pageSize3;
        Modifier modifier3;
        PaddingValues paddingValues3;
        boolean z5;
        int i22;
        Composer composer3;
        Modifier modifier4;
        final PageSize pageSize4;
        final Alignment.Horizontal horizontal4;
        final boolean z6;
        final float f3;
        final NestedScrollConnection nestedScrollConnection3;
        final boolean z7;
        final SnapFlingBehavior snapFlingBehavior4;
        final int i23;
        final PaddingValues paddingValues4;
        final Modifier modifier5;
        ScopeUpdateScope endRestartGroup;
        int i24;
        Composer startRestartGroup = composer.startRestartGroup(-1457068767);
        ComposerKt.sourceInformation(startRestartGroup, "C(VerticalPager)P(11,5,1,8!1,9:c#ui.unit.Dp,3!1,12,10!1,7)196@10975L28,200@11177L101,205@11348L618:Pager.kt#g6yjnt");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = (startRestartGroup.changed(pagerState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i25 = i4 & 2;
        if (i25 != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            modifier2 = modifier;
            i5 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i2 & 896) == 0) {
                paddingValues2 = paddingValues;
                i5 |= startRestartGroup.changed(paddingValues2) ? 256 : 128;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 7168) == 0) {
                    pageSize2 = pageSize;
                    i5 |= startRestartGroup.changed(pageSize2) ? 2048 : 1024;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                        i9 = i;
                    } else {
                        i9 = i;
                        if ((i2 & 57344) == 0) {
                            i5 |= startRestartGroup.changed(i9) ? 16384 : 8192;
                        }
                    }
                    i10 = i4 & 32;
                    if (i10 == 0) {
                        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        f2 = f;
                    } else {
                        f2 = f;
                        if ((i2 & 458752) == 0) {
                            i5 |= startRestartGroup.changed(f2) ? 131072 : 65536;
                        }
                    }
                    i11 = i4 & 64;
                    if (i11 == 0) {
                        i5 |= 1572864;
                        horizontal2 = horizontal;
                    } else {
                        horizontal2 = horizontal;
                        if ((i2 & 3670016) == 0) {
                            i5 |= startRestartGroup.changed(horizontal2) ? 1048576 : 524288;
                        }
                    }
                    if ((i2 & 29360128) == 0) {
                        if ((i4 & 128) == 0 && startRestartGroup.changed(snapFlingBehavior)) {
                            i24 = 8388608;
                            i5 |= i24;
                        }
                        i24 = 4194304;
                        i5 |= i24;
                    }
                    i12 = i4 & 256;
                    if (i12 == 0) {
                        i5 |= 100663296;
                    } else if ((i2 & 234881024) == 0) {
                        i13 = i12;
                        i5 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
                        i14 = i4 & 512;
                        if (i14 != 0) {
                            i16 = i5 | C.ENCODING_PCM_32BIT;
                            i15 = i14;
                        } else {
                            if ((i2 & 1879048192) == 0) {
                                i15 = i14;
                                i5 |= startRestartGroup.changed(z2) ? 536870912 : 268435456;
                            } else {
                                i15 = i14;
                            }
                            i16 = i5;
                        }
                        i17 = i4 & 1024;
                        if (i17 != 0) {
                            i18 = i3 | 6;
                        } else if ((i3 & 14) == 0) {
                            i18 = i3 | (startRestartGroup.changedInstance(function1) ? 4 : 2);
                        } else {
                            i18 = i3;
                        }
                        i19 = i4 & 2048;
                        if (i19 != 0) {
                            i18 |= 16;
                        }
                        int i26 = i18;
                        if ((i4 & 4096) != 0) {
                            i26 |= 384;
                        } else if ((i3 & 896) == 0) {
                            i26 |= startRestartGroup.changedInstance(function4) ? 256 : 128;
                        }
                        if (i19 == 2048) {
                            i20 = i19;
                            if ((i16 & 1533916891) == 306783378 && (i26 & 731) == 146 && startRestartGroup.getSkipping()) {
                                startRestartGroup.skipToGroupEnd();
                                z7 = z2;
                                function12 = function1;
                                nestedScrollConnection3 = nestedScrollConnection;
                                pageSize4 = pageSize2;
                                modifier5 = modifier2;
                                i23 = i9;
                                f3 = f2;
                                paddingValues4 = paddingValues2;
                                horizontal4 = horizontal2;
                                snapFlingBehavior4 = snapFlingBehavior;
                                z6 = z;
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup == null) {
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$VerticalPager$2
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

                                        public final void invoke(Composer composer4, int i27) {
                                            PagerKt.m1108VerticalPagerxYaah8o(PagerState.this, modifier5, paddingValues4, pageSize4, i23, f3, horizontal4, snapFlingBehavior4, z6, z7, function12, nestedScrollConnection3, function4, composer4, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                        } else {
                            i20 = i19;
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier modifier6 = i25 != 0 ? Modifier.INSTANCE : modifier2;
                            PaddingValues m872PaddingValues0680j_4 = i6 != 0 ? PaddingKt.m872PaddingValues0680j_4(Dp.m6389constructorimpl(0)) : paddingValues2;
                            PageSize pageSize5 = i7 != 0 ? PageSize.Fill.INSTANCE : pageSize2;
                            int i27 = i8 != 0 ? 0 : i9;
                            float m6389constructorimpl = i10 != 0 ? Dp.m6389constructorimpl(0) : f2;
                            if (i11 != 0) {
                                horizontal2 = Alignment.INSTANCE.getCenterHorizontally();
                            }
                            if ((i4 & 128) != 0) {
                                i21 = i26;
                                composer2 = startRestartGroup;
                                z3 = false;
                                pagerState2 = pagerState;
                                snapFlingBehavior2 = PagerDefaults.INSTANCE.flingBehavior(pagerState2, null, null, null, null, 0.0f, composer2, (i16 & 14) | 2097152, 62);
                                i16 &= -29360129;
                            } else {
                                z3 = false;
                                composer2 = startRestartGroup;
                                pagerState2 = pagerState;
                                i21 = i26;
                                snapFlingBehavior2 = snapFlingBehavior;
                            }
                            boolean z8 = i13 != 0 ? true : z;
                            if (i15 == 0) {
                                z3 = z2;
                            }
                            Function1<? super Integer, ? extends Object> function13 = i17 != 0 ? null : function1;
                            if (i20 != 0) {
                                composer2.startReplaceableGroup(1157296644);
                                ComposerKt.sourceInformation(composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                                boolean changed = composer2.changed(pagerState2);
                                Object rememberedValue = composer2.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = PagerDefaults.INSTANCE.pageNestedScrollConnection(pagerState2, Orientation.Vertical);
                                    composer2.updateRememberedValue(rememberedValue);
                                }
                                composer2.endReplaceableGroup();
                                z4 = z8;
                                function12 = function13;
                                i21 &= -113;
                                nestedScrollConnection2 = (NestedScrollConnection) rememberedValue;
                                horizontal3 = horizontal2;
                                pageSize3 = pageSize5;
                                f2 = m6389constructorimpl;
                                paddingValues3 = m872PaddingValues0680j_4;
                                z5 = z3;
                                i22 = i16;
                                snapFlingBehavior3 = snapFlingBehavior2;
                                composer3 = composer2;
                                i9 = i27;
                                modifier3 = modifier6;
                            } else {
                                nestedScrollConnection2 = nestedScrollConnection;
                                snapFlingBehavior3 = snapFlingBehavior2;
                                z4 = z8;
                                function12 = function13;
                                horizontal3 = horizontal2;
                                pageSize3 = pageSize5;
                                modifier3 = modifier6;
                                f2 = m6389constructorimpl;
                                paddingValues3 = m872PaddingValues0680j_4;
                                z5 = z3;
                                i22 = i16;
                                composer3 = composer2;
                                i9 = i27;
                            }
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i4 & 128) != 0) {
                                i16 &= -29360129;
                            }
                            if (i20 != 0) {
                                i26 &= -113;
                            }
                            pagerState2 = pagerState;
                            z4 = z;
                            function12 = function1;
                            nestedScrollConnection2 = nestedScrollConnection;
                            paddingValues3 = paddingValues2;
                            horizontal3 = horizontal2;
                            composer3 = startRestartGroup;
                            i22 = i16;
                            i21 = i26;
                            pageSize3 = pageSize2;
                            modifier3 = modifier2;
                            snapFlingBehavior3 = snapFlingBehavior;
                            z5 = z2;
                        }
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            modifier4 = modifier3;
                            ComposerKt.traceEventStart(-1457068767, i22, i21, "androidx.compose.foundation.pager.VerticalPager (Pager.kt:204)");
                        } else {
                            modifier4 = modifier3;
                        }
                        int i28 = i22 >> 6;
                        int i29 = ((i22 >> 3) & 14) | 24576 | ((i22 << 3) & 112) | (i22 & 896) | ((i22 >> 18) & 7168) | (i28 & 458752) | (i28 & 3670016);
                        int i30 = i22 << 9;
                        int i31 = i29 | (i30 & 29360128) | (i30 & 234881024) | ((i22 << 18) & 1879048192);
                        int i32 = ((i21 << 3) & 112) | 3080 | ((i22 >> 12) & 896) | ((i21 << 6) & 57344);
                        Modifier modifier7 = modifier4;
                        Composer composer4 = composer3;
                        LazyLayoutPagerKt.m1102Pagerfs30GE4(modifier7, pagerState2, paddingValues3, z5, Orientation.Vertical, snapFlingBehavior3, z4, i9, f2, pageSize3, nestedScrollConnection2, function12, horizontal3, Alignment.INSTANCE.getCenterVertically(), function4, composer4, i31, i32, 0);
                        int i33 = i9;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        startRestartGroup = composer4;
                        pageSize4 = pageSize3;
                        horizontal4 = horizontal3;
                        z6 = z4;
                        f3 = f2;
                        nestedScrollConnection3 = nestedScrollConnection2;
                        z7 = z5;
                        snapFlingBehavior4 = snapFlingBehavior3;
                        i23 = i33;
                        paddingValues4 = paddingValues3;
                        modifier5 = modifier7;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i13 = i12;
                    i14 = i4 & 512;
                    if (i14 != 0) {
                    }
                    i17 = i4 & 1024;
                    if (i17 != 0) {
                    }
                    i19 = i4 & 2048;
                    if (i19 != 0) {
                    }
                    int i262 = i18;
                    if ((i4 & 4096) != 0) {
                    }
                    if (i19 == 2048) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i25 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if ((i4 & 128) != 0) {
                    }
                    if (i13 != 0) {
                    }
                    if (i15 == 0) {
                    }
                    if (i17 != 0) {
                    }
                    if (i20 != 0) {
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i282 = i22 >> 6;
                    int i292 = ((i22 >> 3) & 14) | 24576 | ((i22 << 3) & 112) | (i22 & 896) | ((i22 >> 18) & 7168) | (i282 & 458752) | (i282 & 3670016);
                    int i302 = i22 << 9;
                    int i312 = i292 | (i302 & 29360128) | (i302 & 234881024) | ((i22 << 18) & 1879048192);
                    int i322 = ((i21 << 3) & 112) | 3080 | ((i22 >> 12) & 896) | ((i21 << 6) & 57344);
                    Modifier modifier72 = modifier4;
                    Composer composer42 = composer3;
                    LazyLayoutPagerKt.m1102Pagerfs30GE4(modifier72, pagerState2, paddingValues3, z5, Orientation.Vertical, snapFlingBehavior3, z4, i9, f2, pageSize3, nestedScrollConnection2, function12, horizontal3, Alignment.INSTANCE.getCenterVertically(), function4, composer42, i312, i322, 0);
                    int i332 = i9;
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup = composer42;
                    pageSize4 = pageSize3;
                    horizontal4 = horizontal3;
                    z6 = z4;
                    f3 = f2;
                    nestedScrollConnection3 = nestedScrollConnection2;
                    z7 = z5;
                    snapFlingBehavior4 = snapFlingBehavior3;
                    i23 = i332;
                    paddingValues4 = paddingValues3;
                    modifier5 = modifier72;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                pageSize2 = pageSize;
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i10 = i4 & 32;
                if (i10 == 0) {
                }
                i11 = i4 & 64;
                if (i11 == 0) {
                }
                if ((i2 & 29360128) == 0) {
                }
                i12 = i4 & 256;
                if (i12 == 0) {
                }
                i13 = i12;
                i14 = i4 & 512;
                if (i14 != 0) {
                }
                i17 = i4 & 1024;
                if (i17 != 0) {
                }
                i19 = i4 & 2048;
                if (i19 != 0) {
                }
                int i2622 = i18;
                if ((i4 & 4096) != 0) {
                }
                if (i19 == 2048) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i25 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if ((i4 & 128) != 0) {
                }
                if (i13 != 0) {
                }
                if (i15 == 0) {
                }
                if (i17 != 0) {
                }
                if (i20 != 0) {
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i2822 = i22 >> 6;
                int i2922 = ((i22 >> 3) & 14) | 24576 | ((i22 << 3) & 112) | (i22 & 896) | ((i22 >> 18) & 7168) | (i2822 & 458752) | (i2822 & 3670016);
                int i3022 = i22 << 9;
                int i3122 = i2922 | (i3022 & 29360128) | (i3022 & 234881024) | ((i22 << 18) & 1879048192);
                int i3222 = ((i21 << 3) & 112) | 3080 | ((i22 >> 12) & 896) | ((i21 << 6) & 57344);
                Modifier modifier722 = modifier4;
                Composer composer422 = composer3;
                LazyLayoutPagerKt.m1102Pagerfs30GE4(modifier722, pagerState2, paddingValues3, z5, Orientation.Vertical, snapFlingBehavior3, z4, i9, f2, pageSize3, nestedScrollConnection2, function12, horizontal3, Alignment.INSTANCE.getCenterVertically(), function4, composer422, i3122, i3222, 0);
                int i3322 = i9;
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup = composer422;
                pageSize4 = pageSize3;
                horizontal4 = horizontal3;
                z6 = z4;
                f3 = f2;
                nestedScrollConnection3 = nestedScrollConnection2;
                z7 = z5;
                snapFlingBehavior4 = snapFlingBehavior3;
                i23 = i3322;
                paddingValues4 = paddingValues3;
                modifier5 = modifier722;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            paddingValues2 = paddingValues;
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            pageSize2 = pageSize;
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i10 = i4 & 32;
            if (i10 == 0) {
            }
            i11 = i4 & 64;
            if (i11 == 0) {
            }
            if ((i2 & 29360128) == 0) {
            }
            i12 = i4 & 256;
            if (i12 == 0) {
            }
            i13 = i12;
            i14 = i4 & 512;
            if (i14 != 0) {
            }
            i17 = i4 & 1024;
            if (i17 != 0) {
            }
            i19 = i4 & 2048;
            if (i19 != 0) {
            }
            int i26222 = i18;
            if ((i4 & 4096) != 0) {
            }
            if (i19 == 2048) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i25 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if ((i4 & 128) != 0) {
            }
            if (i13 != 0) {
            }
            if (i15 == 0) {
            }
            if (i17 != 0) {
            }
            if (i20 != 0) {
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i28222 = i22 >> 6;
            int i29222 = ((i22 >> 3) & 14) | 24576 | ((i22 << 3) & 112) | (i22 & 896) | ((i22 >> 18) & 7168) | (i28222 & 458752) | (i28222 & 3670016);
            int i30222 = i22 << 9;
            int i31222 = i29222 | (i30222 & 29360128) | (i30222 & 234881024) | ((i22 << 18) & 1879048192);
            int i32222 = ((i21 << 3) & 112) | 3080 | ((i22 >> 12) & 896) | ((i21 << 6) & 57344);
            Modifier modifier7222 = modifier4;
            Composer composer4222 = composer3;
            LazyLayoutPagerKt.m1102Pagerfs30GE4(modifier7222, pagerState2, paddingValues3, z5, Orientation.Vertical, snapFlingBehavior3, z4, i9, f2, pageSize3, nestedScrollConnection2, function12, horizontal3, Alignment.INSTANCE.getCenterVertically(), function4, composer4222, i31222, i32222, 0);
            int i33222 = i9;
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup = composer4222;
            pageSize4 = pageSize3;
            horizontal4 = horizontal3;
            z6 = z4;
            f3 = f2;
            nestedScrollConnection3 = nestedScrollConnection2;
            z7 = z5;
            snapFlingBehavior4 = snapFlingBehavior3;
            i23 = i33222;
            paddingValues4 = paddingValues3;
            modifier5 = modifier7222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        modifier2 = modifier;
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        paddingValues2 = paddingValues;
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        pageSize2 = pageSize;
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i10 = i4 & 32;
        if (i10 == 0) {
        }
        i11 = i4 & 64;
        if (i11 == 0) {
        }
        if ((i2 & 29360128) == 0) {
        }
        i12 = i4 & 256;
        if (i12 == 0) {
        }
        i13 = i12;
        i14 = i4 & 512;
        if (i14 != 0) {
        }
        i17 = i4 & 1024;
        if (i17 != 0) {
        }
        i19 = i4 & 2048;
        if (i19 != 0) {
        }
        int i262222 = i18;
        if ((i4 & 4096) != 0) {
        }
        if (i19 == 2048) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i25 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if ((i4 & 128) != 0) {
        }
        if (i13 != 0) {
        }
        if (i15 == 0) {
        }
        if (i17 != 0) {
        }
        if (i20 != 0) {
        }
        composer3.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i282222 = i22 >> 6;
        int i292222 = ((i22 >> 3) & 14) | 24576 | ((i22 << 3) & 112) | (i22 & 896) | ((i22 >> 18) & 7168) | (i282222 & 458752) | (i282222 & 3670016);
        int i302222 = i22 << 9;
        int i312222 = i292222 | (i302222 & 29360128) | (i302222 & 234881024) | ((i22 << 18) & 1879048192);
        int i322222 = ((i21 << 3) & 112) | 3080 | ((i22 >> 12) & 896) | ((i21 << 6) & 57344);
        Modifier modifier72222 = modifier4;
        Composer composer42222 = composer3;
        LazyLayoutPagerKt.m1102Pagerfs30GE4(modifier72222, pagerState2, paddingValues3, z5, Orientation.Vertical, snapFlingBehavior3, z4, i9, f2, pageSize3, nestedScrollConnection2, function12, horizontal3, Alignment.INSTANCE.getCenterVertically(), function4, composer42222, i312222, i322222, 0);
        int i332222 = i9;
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup = composer42222;
        pageSize4 = pageSize3;
        horizontal4 = horizontal3;
        z6 = z4;
        f3 = f2;
        nestedScrollConnection3 = nestedScrollConnection2;
        z7 = z5;
        snapFlingBehavior4 = snapFlingBehavior3;
        i23 = i332222;
        paddingValues4 = paddingValues3;
        modifier5 = modifier72222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SnapLayoutInfoProvider SnapLayoutInfoProvider(final PagerState pagerState, final PagerSnapDistance pagerSnapDistance, final DecayAnimationSpec<Float> decayAnimationSpec, final float f) {
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.pager.PagerKt$SnapLayoutInfoProvider$1
            public final boolean isValidDistance(float f2) {
                return (f2 == Float.POSITIVE_INFINITY || f2 == Float.NEGATIVE_INFINITY) ? false : true;
            }

            public final PagerLayoutInfo getLayoutInfo() {
                return PagerState.this.getLayoutInfo();
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnappingOffset(float currentVelocity) {
                boolean isScrollingForward;
                float dragGestureDelta;
                Pair<Float, Float> searchForSnappingBounds = searchForSnappingBounds();
                float floatValue = searchForSnappingBounds.component1().floatValue();
                float floatValue2 = searchForSnappingBounds.component2().floatValue();
                isScrollingForward = PagerKt.isScrollingForward(PagerState.this);
                dragGestureDelta = PagerKt.dragGestureDelta(PagerState.this);
                float pageSize = (dragGestureDelta / getLayoutInfo().getPageSize()) - ((int) r3);
                int calculateFinalSnappingItem = LazyListSnapLayoutInfoProviderKt.calculateFinalSnappingItem(PagerState.this.getDensity(), currentVelocity);
                if (FinalSnappingItem.m747equalsimpl0(calculateFinalSnappingItem, FinalSnappingItem.INSTANCE.m751getClosestItembbeMdSM())) {
                    floatValue = Math.abs(pageSize) > f ? floatValue2 : floatValue2;
                } else {
                    if (!FinalSnappingItem.m747equalsimpl0(calculateFinalSnappingItem, FinalSnappingItem.INSTANCE.m752getNextItembbeMdSM())) {
                        if (!FinalSnappingItem.m747equalsimpl0(calculateFinalSnappingItem, FinalSnappingItem.INSTANCE.m753getPreviousItembbeMdSM())) {
                            floatValue = 0.0f;
                        }
                    }
                }
                if (isValidDistance(floatValue)) {
                    return floatValue;
                }
                return 0.0f;
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateApproachOffset(float initialVelocity) {
                int firstVisiblePage;
                int pageSize$foundation_release = PagerState.this.getPageSize$foundation_release() + PagerState.this.getPageSpacing$foundation_release();
                float calculateTargetValue = DecayAnimationSpecKt.calculateTargetValue(decayAnimationSpec, 0.0f, initialVelocity);
                if (initialVelocity < 0.0f) {
                    firstVisiblePage = PagerState.this.getFirstVisiblePage() + 1;
                } else {
                    firstVisiblePage = PagerState.this.getFirstVisiblePage();
                }
                int i = firstVisiblePage;
                int coerceAtLeast = RangesKt.coerceAtLeast(Math.abs((RangesKt.coerceIn(pagerSnapDistance.calculateTargetPage(i, RangesKt.coerceIn(((int) (calculateTargetValue / pageSize$foundation_release)) + i, 0, PagerState.this.getPageCount()), initialVelocity, PagerState.this.getPageSize$foundation_release(), PagerState.this.getPageSpacing$foundation_release()), 0, PagerState.this.getPageCount()) - i) * pageSize$foundation_release) - pageSize$foundation_release, 0);
                return coerceAtLeast == 0 ? coerceAtLeast : coerceAtLeast * Math.signum(initialVelocity);
            }

            private final Pair<Float, Float> searchForSnappingBounds() {
                int pageSize$foundation_release = PagerState.this.getPageSize$foundation_release() + PagerState.this.getPageSpacing$foundation_release();
                int currentPage = PagerState.this.getCurrentPage();
                int calculateCurrentPageLayoutOffset = PagerMeasurePolicyKt.calculateCurrentPageLayoutOffset(PagerState.this, pageSize$foundation_release);
                int size = getLayoutInfo().getVisiblePagesInfo().size() / 2;
                int i = calculateCurrentPageLayoutOffset;
                float f2 = Float.NEGATIVE_INFINITY;
                float f3 = Float.POSITIVE_INFINITY;
                for (int i2 = currentPage; i2 >= RangesKt.coerceAtLeast(currentPage - size, 0); i2--) {
                    float calculateDistanceToDesiredSnapPosition = SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(PagerLayoutInfoKt.getMainAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), getLayoutInfo().getPageSize(), i, i2, PagerStateKt.getSnapAlignmentStartToStart());
                    if (calculateDistanceToDesiredSnapPosition <= 0.0f && calculateDistanceToDesiredSnapPosition > f2) {
                        f2 = calculateDistanceToDesiredSnapPosition;
                    }
                    if (calculateDistanceToDesiredSnapPosition >= 0.0f && calculateDistanceToDesiredSnapPosition < f3) {
                        f3 = calculateDistanceToDesiredSnapPosition;
                    }
                    i -= pageSize$foundation_release;
                }
                int i3 = currentPage + 1;
                int i4 = calculateCurrentPageLayoutOffset + pageSize$foundation_release;
                while (i3 <= RangesKt.coerceAtMost(currentPage + size, PagerState.this.getPageCount() - 1)) {
                    int i5 = i3;
                    float calculateDistanceToDesiredSnapPosition2 = SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(PagerLayoutInfoKt.getMainAxisViewportSize(getLayoutInfo()), getLayoutInfo().getBeforeContentPadding(), getLayoutInfo().getAfterContentPadding(), getLayoutInfo().getPageSize(), i4, i5, PagerStateKt.getSnapAlignmentStartToStart());
                    if (calculateDistanceToDesiredSnapPosition2 >= 0.0f && calculateDistanceToDesiredSnapPosition2 < f3) {
                        f3 = calculateDistanceToDesiredSnapPosition2;
                    }
                    if (calculateDistanceToDesiredSnapPosition2 <= 0.0f && calculateDistanceToDesiredSnapPosition2 > f2) {
                        f2 = calculateDistanceToDesiredSnapPosition2;
                    }
                    i4 += pageSize$foundation_release;
                    i3 = i5 + 1;
                }
                if (f2 == Float.NEGATIVE_INFINITY) {
                    f2 = f3;
                }
                if (f3 == Float.POSITIVE_INFINITY) {
                    f3 = f2;
                }
                return TuplesKt.to(Float.valueOf(f2), Float.valueOf(f3));
            }
        };
    }

    public static final Modifier pagerSemantics(Modifier modifier, final PagerState pagerState, final boolean z, Composer composer, int i) {
        composer.startReplaceableGroup(1509835088);
        ComposerKt.sourceInformation(composer, "C(pagerSemantics)P(1)915@43355L24:Pager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1509835088, i, -1, "androidx.compose.foundation.pager.pagerSemantics (Pager.kt:914)");
        }
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        Modifier then = modifier.then(SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1
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
                if (z) {
                    final PagerState pagerState2 = pagerState;
                    final CoroutineScope coroutineScope2 = coroutineScope;
                    SemanticsPropertiesKt.pageUp$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            boolean pagerSemantics$performBackwardPaging;
                            pagerSemantics$performBackwardPaging = PagerKt.pagerSemantics$performBackwardPaging(PagerState.this, coroutineScope2);
                            return Boolean.valueOf(pagerSemantics$performBackwardPaging);
                        }
                    }, 1, null);
                    final PagerState pagerState3 = pagerState;
                    final CoroutineScope coroutineScope3 = coroutineScope;
                    SemanticsPropertiesKt.pageDown$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            boolean pagerSemantics$performForwardPaging;
                            pagerSemantics$performForwardPaging = PagerKt.pagerSemantics$performForwardPaging(PagerState.this, coroutineScope3);
                            return Boolean.valueOf(pagerSemantics$performForwardPaging);
                        }
                    }, 1, null);
                    return;
                }
                final PagerState pagerState4 = pagerState;
                final CoroutineScope coroutineScope4 = coroutineScope;
                SemanticsPropertiesKt.pageLeft$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        boolean pagerSemantics$performBackwardPaging;
                        pagerSemantics$performBackwardPaging = PagerKt.pagerSemantics$performBackwardPaging(PagerState.this, coroutineScope4);
                        return Boolean.valueOf(pagerSemantics$performBackwardPaging);
                    }
                }, 1, null);
                final PagerState pagerState5 = pagerState;
                final CoroutineScope coroutineScope5 = coroutineScope;
                SemanticsPropertiesKt.pageRight$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.foundation.pager.PagerKt$pagerSemantics$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        boolean pagerSemantics$performForwardPaging;
                        pagerSemantics$performForwardPaging = PagerKt.pagerSemantics$performForwardPaging(PagerState.this, coroutineScope5);
                        return Boolean.valueOf(pagerSemantics$performForwardPaging);
                    }
                }, 1, null);
            }
        }, 1, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return then;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performForwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollForward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PagerKt$pagerSemantics$performForwardPaging$1(pagerState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean pagerSemantics$performBackwardPaging(PagerState pagerState, CoroutineScope coroutineScope) {
        if (!pagerState.getCanScrollBackward()) {
            return false;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new PagerKt$pagerSemantics$performBackwardPaging$1(pagerState, null), 3, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isScrollingForward(PagerState pagerState) {
        return dragGestureDelta(pagerState) < 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float dragGestureDelta(PagerState pagerState) {
        if (pagerState.getLayoutInfo().getOrientation() == Orientation.Horizontal) {
            return Offset.m3822getXimpl(pagerState.m1117getUpDownDifferenceF1C5BW0$foundation_release());
        }
        return Offset.m3823getYimpl(pagerState.m1117getUpDownDifferenceF1C5BW0$foundation_release());
    }
}
