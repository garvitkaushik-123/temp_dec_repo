package androidx.compose.material;

import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material.ripple.RippleThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: MaterialTheme.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"MaterialTheme", "", "colors", "Landroidx/compose/material/Colors;", "typography", "Landroidx/compose/material/Typography;", "shapes", "Landroidx/compose/material/Shapes;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material/Colors;Landroidx/compose/material/Typography;Landroidx/compose/material/Shapes;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MaterialThemeKt {
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00af, code lost:
    
        if ((r48 & 4) != 0) goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void MaterialTheme(Colors colors, Typography typography, Shapes shapes, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        final Colors colors2;
        int i3;
        Typography typography2;
        Shapes shapes2;
        final Typography typography3;
        final Shapes shapes3;
        int i4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-891417079);
        ComposerKt.sourceInformation(startRestartGroup, "C(MaterialTheme)P(!1,3,2)59@2947L6,60@2998L10,61@3045L6,*64@3120L184,69@3367L16,70@3410L45,73@3581L4,71@3460L492:MaterialTheme.kt#jmzs0o");
        if ((i & 14) == 0) {
            if ((i2 & 1) == 0) {
                colors2 = colors;
                if (startRestartGroup.changed(colors2)) {
                    i6 = 4;
                    i3 = i6 | i;
                }
            } else {
                colors2 = colors;
            }
            i6 = 2;
            i3 = i6 | i;
        } else {
            colors2 = colors;
            i3 = i;
        }
        if ((i & 112) == 0) {
            if ((i2 & 2) == 0) {
                typography2 = typography;
                if (startRestartGroup.changed(typography2)) {
                    i5 = 32;
                    i3 |= i5;
                }
            } else {
                typography2 = typography;
            }
            i5 = 16;
            i3 |= i5;
        } else {
            typography2 = typography;
        }
        if ((i & 896) == 0) {
            if ((i2 & 4) == 0) {
                shapes2 = shapes;
                if (startRestartGroup.changed(shapes2)) {
                    i4 = 256;
                    i3 |= i4;
                }
            } else {
                shapes2 = shapes;
            }
            i4 = 128;
            i3 |= i4;
        } else {
            shapes2 = shapes;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 7168) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i3 & 5851) != 1170 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
            } else {
                if ((i2 & 1) != 0) {
                    colors2 = MaterialTheme.INSTANCE.getColors(startRestartGroup, 6);
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    typography2 = MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    shapes2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6);
                    i3 &= -897;
                }
                Colors colors3 = colors2;
                final Typography typography4 = typography2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-891417079, i3, -1, "androidx.compose.material.MaterialTheme (MaterialTheme.kt:63)");
                }
                startRestartGroup.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = colors3.m1595copypvPzIIM((r45 & 1) != 0 ? colors3.m1603getPrimary0d7_KjU() : 0L, (r45 & 2) != 0 ? colors3.m1604getPrimaryVariant0d7_KjU() : 0L, (r45 & 4) != 0 ? colors3.m1605getSecondary0d7_KjU() : 0L, (r45 & 8) != 0 ? colors3.m1606getSecondaryVariant0d7_KjU() : 0L, (r45 & 16) != 0 ? colors3.m1596getBackground0d7_KjU() : 0L, (r45 & 32) != 0 ? colors3.m1607getSurface0d7_KjU() : 0L, (r45 & 64) != 0 ? colors3.m1597getError0d7_KjU() : 0L, (r45 & 128) != 0 ? colors3.m1600getOnPrimary0d7_KjU() : 0L, (r45 & 256) != 0 ? colors3.m1601getOnSecondary0d7_KjU() : 0L, (r45 & 512) != 0 ? colors3.m1598getOnBackground0d7_KjU() : 0L, (r45 & 1024) != 0 ? colors3.m1602getOnSurface0d7_KjU() : 0L, (r45 & 2048) != 0 ? colors3.m1599getOnError0d7_KjU() : 0L, (r45 & 4096) != 0 ? colors3.isLight() : false);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceableGroup();
                Colors colors4 = (Colors) rememberedValue;
                ColorsKt.updateColorsFrom(colors4, colors3);
                Shapes shapes4 = shapes2;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ColorsKt.getLocalColors().provides(colors4), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(ContentAlpha.INSTANCE.getHigh(startRestartGroup, 6))), IndicationKt.getLocalIndication().provides(RippleKt.m1870rememberRipple9IZ8Weo(false, 0.0f, 0L, startRestartGroup, 0, 7)), RippleThemeKt.getLocalRippleTheme().provides(MaterialRippleTheme.INSTANCE), ShapesKt.getLocalShapes().provides(shapes4), TextSelectionColorsKt.getLocalTextSelectionColors().provides(MaterialTextSelectionColorsKt.rememberTextSelectionColors(colors4, startRestartGroup, 0)), TypographyKt.getLocalTypography().provides(typography4)}, ComposableLambdaKt.composableLambda(startRestartGroup, -1740102967, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MaterialThemeKt$MaterialTheme$1
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

                    public final void invoke(Composer composer2, int i7) {
                        ComposerKt.sourceInformation(composer2, "C80@3849L97:MaterialTheme.kt#jmzs0o");
                        if ((i7 & 11) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1740102967, i7, -1, "androidx.compose.material.MaterialTheme.<anonymous> (MaterialTheme.kt:80)");
                            }
                            TextStyle body1 = Typography.this.getBody1();
                            final Function2<Composer, Integer, Unit> function22 = function2;
                            TextKt.ProvideTextStyle(body1, ComposableLambdaKt.composableLambda(composer2, 181426554, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MaterialThemeKt$MaterialTheme$1.1
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

                                public final void invoke(Composer composer3, int i8) {
                                    ComposerKt.sourceInformation(composer3, "C81@3906L30:MaterialTheme.kt#jmzs0o");
                                    if ((i8 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(181426554, i8, -1, "androidx.compose.material.MaterialTheme.<anonymous>.<anonymous> (MaterialTheme.kt:81)");
                                    }
                                    MaterialTheme_androidKt.PlatformMaterialTheme(function22, composer3, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), composer2, 48);
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
                typography3 = typography4;
                colors2 = colors3;
                shapes3 = shapes4;
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            typography3 = typography2;
            shapes3 = shapes2;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.MaterialThemeKt$MaterialTheme$2
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

                public final void invoke(Composer composer2, int i7) {
                    MaterialThemeKt.MaterialTheme(Colors.this, typography3, shapes3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
