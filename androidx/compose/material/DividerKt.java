package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: Divider.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a:\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"DividerAlpha", "", "Divider", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "thickness", "Landroidx/compose/ui/unit/Dp;", "startIndent", "Divider-oMI9zvI", "(Landroidx/compose/ui/Modifier;JFFLandroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DividerKt {
    private static final float DividerAlpha = 0.12f;

    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x006a  */
    /* renamed from: Divider-oMI9zvI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1644DivideroMI9zvI(Modifier modifier, long j, float f, float f2, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j2;
        float f3;
        int i4;
        float f4;
        Modifier.Companion companion;
        float m6389constructorimpl;
        Modifier.Companion m883paddingqDBjuR0$default;
        float f5;
        final float f6;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1249392198);
        ComposerKt.sourceInformation(startRestartGroup, "C(Divider)P(1,0:c#ui.graphics.Color,3:c#ui.unit.Dp,2:c#ui.unit.Dp)45@1819L6,59@2200L147:Divider.kt#jmzs0o");
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
            j2 = j;
            i3 |= ((i2 & 2) == 0 && startRestartGroup.changed(j2)) ? 32 : 16;
        } else {
            j2 = j;
        }
        int i6 = i2 & 4;
        if (i6 != 0) {
            i3 |= 384;
        } else if ((i & 896) == 0) {
            f3 = f;
            i3 |= startRestartGroup.changed(f3) ? 256 : 128;
            i4 = i2 & 8;
            if (i4 == 0) {
                i3 |= 3072;
            } else if ((i & 7168) == 0) {
                f4 = f2;
                i3 |= startRestartGroup.changed(f4) ? 2048 : 1024;
                if ((i3 & 5851) == 1170 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                        if ((i2 & 2) != 0) {
                            j2 = Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m1602getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -113;
                        }
                        if (i6 != 0) {
                            f3 = Dp.m6389constructorimpl(1);
                        }
                        if (i4 != 0) {
                            m6389constructorimpl = Dp.m6389constructorimpl(0);
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1249392198, i3, -1, "androidx.compose.material.Divider (Divider.kt:48)");
                            }
                            if (m6389constructorimpl == 0.0f) {
                                m883paddingqDBjuR0$default = PaddingKt.m883paddingqDBjuR0$default(Modifier.INSTANCE, m6389constructorimpl, 0.0f, 0.0f, 0.0f, 14, null);
                            } else {
                                m883paddingqDBjuR0$default = Modifier.INSTANCE;
                            }
                            startRestartGroup.startReplaceableGroup(1228914189);
                            ComposerKt.sourceInformation(startRestartGroup, "*55@2139L7");
                            if (Dp.m6394equalsimpl0(f3, Dp.INSTANCE.m6407getHairlineD9Ej5fM())) {
                                f5 = f3;
                            } else {
                                ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                f5 = Dp.m6389constructorimpl(1.0f / ((Density) consume).getDensity());
                            }
                            startRestartGroup.endReplaceableGroup();
                            BoxKt.Box(BackgroundKt.m527backgroundbw27NRU$default(SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(m883paddingqDBjuR0$default), 0.0f, 1, null), f5), j2, null, 2, null), startRestartGroup, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            f6 = m6389constructorimpl;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        companion = modifier2;
                    }
                    m6389constructorimpl = f4;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    if (m6389constructorimpl == 0.0f) {
                    }
                    startRestartGroup.startReplaceableGroup(1228914189);
                    ComposerKt.sourceInformation(startRestartGroup, "*55@2139L7");
                    if (Dp.m6394equalsimpl0(f3, Dp.INSTANCE.m6407getHairlineD9Ej5fM())) {
                    }
                    startRestartGroup.endReplaceableGroup();
                    BoxKt.Box(BackgroundKt.m527backgroundbw27NRU$default(SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(m883paddingqDBjuR0$default), 0.0f, 1, null), f5), j2, null, 2, null), startRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f6 = m6389constructorimpl;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                    f6 = f4;
                }
                final float f7 = f3;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = companion;
                    final long j3 = j2;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DividerKt$Divider$1
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
                            DividerKt.m1644DivideroMI9zvI(Modifier.this, j3, f7, f6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            f4 = f2;
            if ((i3 & 5851) == 1170) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i5 != 0) {
            }
            if ((i2 & 2) != 0) {
            }
            if (i6 != 0) {
            }
            if (i4 != 0) {
            }
            m6389constructorimpl = f4;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            if (m6389constructorimpl == 0.0f) {
            }
            startRestartGroup.startReplaceableGroup(1228914189);
            ComposerKt.sourceInformation(startRestartGroup, "*55@2139L7");
            if (Dp.m6394equalsimpl0(f3, Dp.INSTANCE.m6407getHairlineD9Ej5fM())) {
            }
            startRestartGroup.endReplaceableGroup();
            BoxKt.Box(BackgroundKt.m527backgroundbw27NRU$default(SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(m883paddingqDBjuR0$default), 0.0f, 1, null), f5), j2, null, 2, null), startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            f6 = m6389constructorimpl;
            final float f72 = f3;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        f3 = f;
        i4 = i2 & 8;
        if (i4 == 0) {
        }
        f4 = f2;
        if ((i3 & 5851) == 1170) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if (i6 != 0) {
        }
        if (i4 != 0) {
        }
        m6389constructorimpl = f4;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        if (m6389constructorimpl == 0.0f) {
        }
        startRestartGroup.startReplaceableGroup(1228914189);
        ComposerKt.sourceInformation(startRestartGroup, "*55@2139L7");
        if (Dp.m6394equalsimpl0(f3, Dp.INSTANCE.m6407getHairlineD9Ej5fM())) {
        }
        startRestartGroup.endReplaceableGroup();
        BoxKt.Box(BackgroundKt.m527backgroundbw27NRU$default(SizeKt.m914height3ABfNKs(SizeKt.fillMaxWidth$default(companion.then(m883paddingqDBjuR0$default), 0.0f, 1, null), f5), j2, null, 2, null), startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        f6 = m6389constructorimpl;
        final float f722 = f3;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
