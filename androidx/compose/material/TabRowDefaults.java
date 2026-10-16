package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.ItemTouchHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: TabRow.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J0\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0016J\u0012\u0010\u001a\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\bR\u0019\u0010\f\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\r\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d²\u0006\n\u0010\u001e\u001a\u00020\u0006X\u008a\u0084\u0002²\u0006\n\u0010\u001f\u001a\u00020\u0006X\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material/TabRowDefaults;", "", "()V", "DividerOpacity", "", "DividerThickness", "Landroidx/compose/ui/unit/Dp;", "getDividerThickness-D9Ej5fM", "()F", "F", "IndicatorHeight", "getIndicatorHeight-D9Ej5fM", "ScrollableTabRowPadding", "getScrollableTabRowPadding-D9Ej5fM", "Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "thickness", "color", "Landroidx/compose/ui/graphics/Color;", "Divider-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "Indicator", "height", "Indicator-9IZ8Weo", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material/TabPosition;", "material_release", "currentTabWidth", "indicatorOffset"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TabRowDefaults {
    public static final int $stable = 0;
    public static final float DividerOpacity = 0.12f;
    public static final TabRowDefaults INSTANCE = new TabRowDefaults();
    private static final float DividerThickness = Dp.m6389constructorimpl(1);
    private static final float IndicatorHeight = Dp.m6389constructorimpl(2);
    private static final float ScrollableTabRowPadding = Dp.m6389constructorimpl(52);

    private TabRowDefaults() {
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ba  */
    /* renamed from: Divider-9IZ8Weo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1806Divider9IZ8Weo(Modifier modifier, float f, long j, Composer composer, final int i, final int i2) {
        final Modifier modifier2;
        int i3;
        float f2;
        long j2;
        float f3;
        float f4;
        long j3;
        Modifier modifier3;
        final long j4;
        final float f5;
        ScopeUpdateScope endRestartGroup;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(910934799);
        ComposerKt.sourceInformation(startRestartGroup, "C(Divider)P(1,2:c#ui.unit.Dp,0:c#ui.graphics.Color)370@16453L7,372@16532L66:TabRow.kt#jmzs0o");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                f2 = f;
                if (startRestartGroup.changed(f2)) {
                    i4 = 32;
                    i3 |= i4;
                }
            } else {
                f2 = f;
            }
            i4 = 16;
            i3 |= i4;
        } else {
            f2 = f;
        }
        if ((i & 896) == 0) {
            j2 = j;
            i3 |= ((i2 & 4) == 0 && startRestartGroup.changed(j2)) ? 256 : 128;
        } else {
            j2 = j;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= startRestartGroup.changed(this) ? 2048 : 1024;
            if ((i3 & 5851) == 1170 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    Modifier.Companion companion = i5 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) == 0) {
                        f3 = DividerThickness;
                        i3 &= -113;
                    } else {
                        f3 = f2;
                    }
                    if ((i2 & 4) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(localContentColor);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        j2 = Color.m4062copywmQWz5c$default(((Color) consume).m4073unboximpl(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                        i3 &= -897;
                    }
                    f4 = f3;
                    j3 = j2;
                    modifier3 = companion;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    f4 = f2;
                    j3 = j2;
                    modifier3 = modifier2;
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(910934799, i3, -1, "androidx.compose.material.TabRowDefaults.Divider (TabRow.kt:371)");
                }
                DividerKt.m1644DivideroMI9zvI(modifier3, j3, f4, 0.0f, startRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | ((i3 << 3) & 896), 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j4 = j3;
                f5 = f4;
            } else {
                startRestartGroup.skipToGroupEnd();
                f5 = f2;
                j4 = j2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowDefaults$Divider$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        TabRowDefaults.this.m1806Divider9IZ8Weo(modifier2, f5, j4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        if ((i3 & 5851) == 1170) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 == 0) {
        }
        if ((i2 & 2) == 0) {
        }
        if ((i2 & 4) != 0) {
        }
        f4 = f3;
        j3 = j2;
        modifier3 = companion;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        DividerKt.m1644DivideroMI9zvI(modifier3, j3, f4, 0.0f, startRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | ((i3 << 3) & 896), 8);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = modifier3;
        j4 = j3;
        f5 = f4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bc  */
    /* renamed from: Indicator-9IZ8Weo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1807Indicator9IZ8Weo(Modifier modifier, float f, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        float f2;
        long j2;
        TabRowDefaults tabRowDefaults;
        final Modifier.Companion companion;
        final float f3;
        final long j3;
        ScopeUpdateScope endRestartGroup;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(1499002201);
        ComposerKt.sourceInformation(startRestartGroup, "C(Indicator)P(2,1:c#ui.unit.Dp,0:c#ui.graphics.Color)387@17041L7,389@17065L142:TabRow.kt#jmzs0o");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 14) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                f2 = f;
                if (startRestartGroup.changed(f2)) {
                    i5 = 32;
                    i3 |= i5;
                }
            } else {
                f2 = f;
            }
            i5 = 16;
            i3 |= i5;
        } else {
            f2 = f;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                j2 = j;
                if (startRestartGroup.changed(j2)) {
                    i4 = 256;
                    i3 |= i4;
                }
            } else {
                j2 = j;
            }
            i4 = 128;
            i3 |= i4;
        } else {
            j2 = j;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            tabRowDefaults = this;
            i3 |= startRestartGroup.changed(tabRowDefaults) ? 2048 : 1024;
            if ((i3 & 5851) == 1170 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    companion = i6 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) == 0) {
                        f3 = IndicatorHeight;
                        i3 &= -113;
                    } else {
                        f3 = f2;
                    }
                    if ((i2 & 4) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(localContentColor);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        j2 = ((Color) consume).m4073unboximpl();
                        i3 &= -897;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    companion = modifier2;
                    f3 = f2;
                }
                long j4 = j2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1499002201, i3, -1, "androidx.compose.material.TabRowDefaults.Indicator (TabRow.kt:388)");
                }
                BoxKt.Box(BackgroundKt.m527backgroundbw27NRU$default(SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), f3), j4, null, 2, null), startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = j4;
            } else {
                startRestartGroup.skipToGroupEnd();
                companion = modifier2;
                f3 = f2;
                j3 = j2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final TabRowDefaults tabRowDefaults2 = tabRowDefaults;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TabRowDefaults$Indicator$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i7) {
                        TabRowDefaults.this.m1807Indicator9IZ8Weo(companion, f3, j3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        tabRowDefaults = this;
        if ((i3 & 5851) == 1170) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i6 == 0) {
        }
        if ((i2 & 2) == 0) {
        }
        if ((i2 & 4) != 0) {
        }
        long j42 = j2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        BoxKt.Box(BackgroundKt.m527backgroundbw27NRU$default(SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), f3), j42, null, 2, null), startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        j3 = j42;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* renamed from: getDividerThickness-D9Ej5fM, reason: not valid java name */
    public final float m1808getDividerThicknessD9Ej5fM() {
        return DividerThickness;
    }

    /* renamed from: getIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m1809getIndicatorHeightD9Ej5fM() {
        return IndicatorHeight;
    }

    /* renamed from: getScrollableTabRowPadding-D9Ej5fM, reason: not valid java name */
    public final float m1810getScrollableTabRowPaddingD9Ej5fM() {
        return ScrollableTabRowPadding;
    }

    public final Modifier tabIndicatorOffset(Modifier modifier, final TabPosition tabPosition) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("tabIndicatorOffset");
                inspectorInfo.setValue(TabPosition.this);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.TabRowDefaults$tabIndicatorOffset$2
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                return invoke(modifier2, composer, num.intValue());
            }

            public final Modifier invoke(Modifier modifier2, Composer composer, int i) {
                composer.startReplaceableGroup(-398757863);
                ComposerKt.sourceInformation(composer, "C412@17893L165,416@18090L164:TabRow.kt#jmzs0o");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-398757863, i, -1, "androidx.compose.material.TabRowDefaults.tabIndicatorOffset.<anonymous> (TabRow.kt:412)");
                }
                State<Dp> m433animateDpAsStateAjpBEmI = AnimateAsStateKt.m433animateDpAsStateAjpBEmI(TabPosition.this.getWidth(), AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, null, composer, 0, 12);
                Modifier m933width3ABfNKs = SizeKt.m933width3ABfNKs(OffsetKt.m840offsetVpY3zN4$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, null), Alignment.INSTANCE.getBottomStart(), false, 2, null), invoke$lambda$1(AnimateAsStateKt.m433animateDpAsStateAjpBEmI(TabPosition.this.getLeft(), AnimationSpecKt.tween$default(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, null, composer, 0, 12)), 0.0f, 2, null), invoke$lambda$0(m433animateDpAsStateAjpBEmI));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return m933width3ABfNKs;
            }

            private static final float invoke$lambda$0(State<Dp> state) {
                return state.getValue().m6403unboximpl();
            }

            private static final float invoke$lambda$1(State<Dp> state) {
                return state.getValue().m6403unboximpl();
            }
        });
    }
}
