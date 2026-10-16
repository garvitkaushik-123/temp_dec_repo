package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JN\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 Jl\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b(\u0010)JN\u0010*\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010 Jl\u0010,\u001a\u00020\"2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00192\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010$\u001a\u00020\u00192\b\b\u0002\u0010%\u001a\u00020\u00192\b\b\u0002\u0010&\u001a\u00020\u00192\b\b\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0019\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\tR\u0019\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/material/ChipDefaults;", "", "()V", "ContentOpacity", "", "LeadingIconOpacity", "LeadingIconSize", "Landroidx/compose/ui/unit/Dp;", "getLeadingIconSize-D9Ej5fM", "()F", "F", "MinHeight", "getMinHeight-D9Ej5fM", "OutlinedBorderOpacity", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "SelectedIconSize", "getSelectedIconSize-D9Ej5fM", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "chipColors", "Landroidx/compose/material/ChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconContentColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconContentColor", "chipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ChipColors;", "filterChipColors", "Landroidx/compose/material/SelectableChipColors;", "leadingIconColor", "disabledLeadingIconColor", "selectedBackgroundColor", "selectedContentColor", "selectedLeadingIconColor", "filterChipColors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/SelectableChipColors;", "outlinedChipColors", "outlinedChipColors-5tl4gsc", "outlinedFilterChipColors", "outlinedFilterChipColors-J08w3-E", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ChipDefaults {
    public static final int $stable = 0;
    public static final float ContentOpacity = 0.87f;
    public static final float LeadingIconOpacity = 0.54f;
    public static final float OutlinedBorderOpacity = 0.12f;
    public static final ChipDefaults INSTANCE = new ChipDefaults();
    private static final float MinHeight = Dp.m6389constructorimpl(32);
    private static final float OutlinedBorderSize = Dp.m6389constructorimpl(1);
    private static final float LeadingIconSize = Dp.m6389constructorimpl(20);
    private static final float SelectedIconSize = Dp.m6389constructorimpl(18);

    private ChipDefaults() {
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m1589getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: chipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m1586chipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1838505436);
        ComposerKt.sourceInformation(composer, "C(chipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)392@17235L6,393@17329L6,394@17390L6,397@17592L6,398@17652L8,399@17727L6,401@17834L8,404@17982L8:Chip.kt#jmzs0o");
        long m4108compositeOverOWjLjI = (i2 & 1) != 0 ? ColorKt.m4108compositeOverOWjLjI(Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m1607getSurface0d7_KjU()) : j;
        long m4062copywmQWz5c$default = (i2 & 2) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long m4062copywmQWz5c$default2 = (i2 & 4) != 0 ? Color.m4062copywmQWz5c$default(m4062copywmQWz5c$default, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long m4108compositeOverOWjLjI2 = (i2 & 8) != 0 ? ColorKt.m4108compositeOverOWjLjI(Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m1607getSurface0d7_KjU()) : j4;
        long m4062copywmQWz5c$default3 = (i2 & 16) != 0 ? Color.m4062copywmQWz5c$default(m4062copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long m4062copywmQWz5c$default4 = (i2 & 32) != 0 ? Color.m4062copywmQWz5c$default(m4062copywmQWz5c$default2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1838505436, i, -1, "androidx.compose.material.ChipDefaults.chipColors (Chip.kt:405)");
        }
        DefaultChipColors defaultChipColors = new DefaultChipColors(m4108compositeOverOWjLjI, m4062copywmQWz5c$default, m4062copywmQWz5c$default2, m4108compositeOverOWjLjI2, m4062copywmQWz5c$default3, m4062copywmQWz5c$default4, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultChipColors;
    }

    /* renamed from: outlinedChipColors-5tl4gsc, reason: not valid java name */
    public final ChipColors m1592outlinedChipColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1763922662);
        ComposerKt.sourceInformation(composer, "C(outlinedChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)428@19178L6,429@19238L6,433@19521L8,436@19669L8,437@19721L342:Chip.kt#jmzs0o");
        long m1607getSurface0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1607getSurface0d7_KjU() : j;
        long m4062copywmQWz5c$default = (i2 & 2) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long m4062copywmQWz5c$default2 = (i2 & 4) != 0 ? Color.m4062copywmQWz5c$default(m4062copywmQWz5c$default, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long j7 = (i2 & 8) != 0 ? m1607getSurface0d7_KjU : j4;
        long m4062copywmQWz5c$default3 = (i2 & 16) != 0 ? Color.m4062copywmQWz5c$default(m4062copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long m4062copywmQWz5c$default4 = (i2 & 32) != 0 ? Color.m4062copywmQWz5c$default(m4062copywmQWz5c$default2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1763922662, i, -1, "androidx.compose.material.ChipDefaults.outlinedChipColors (Chip.kt:437)");
        }
        ChipColors m1586chipColors5tl4gsc = m1586chipColors5tl4gsc(m1607getSurface0d7_KjU, m4062copywmQWz5c$default, m4062copywmQWz5c$default2, j7, m4062copywmQWz5c$default3, m4062copywmQWz5c$default4, composer, i & 4194302, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m1586chipColors5tl4gsc;
    }

    /* renamed from: filterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m1587filterChipColorsJ08w3E(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(830140629);
        ComposerKt.sourceInformation(composer, "C(filterChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color)462@21060L6,463@21154L6,464@21215L6,467@21402L6,468@21462L8,469@21537L6,471@21644L8,474@21779L8,476@21875L6,479@22034L6,482@22195L6:Chip.kt#jmzs0o");
        long m4108compositeOverOWjLjI = (i2 & 1) != 0 ? ColorKt.m4108compositeOverOWjLjI(Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m1607getSurface0d7_KjU()) : j;
        long m4062copywmQWz5c$default = (i2 & 2) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long m4062copywmQWz5c$default2 = (i2 & 4) != 0 ? Color.m4062copywmQWz5c$default(m4062copywmQWz5c$default, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long m4108compositeOverOWjLjI2 = (i2 & 8) != 0 ? ColorKt.m4108compositeOverOWjLjI(Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColors(composer, 6).m1607getSurface0d7_KjU()) : j4;
        long m4062copywmQWz5c$default3 = (i2 & 16) != 0 ? Color.m4062copywmQWz5c$default(m4062copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long m4062copywmQWz5c$default4 = (i2 & 32) != 0 ? Color.m4062copywmQWz5c$default(m4062copywmQWz5c$default2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long m4108compositeOverOWjLjI3 = (i2 & 64) != 0 ? ColorKt.m4108compositeOverOWjLjI(Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), m4108compositeOverOWjLjI) : j7;
        long m4108compositeOverOWjLjI4 = (i2 & 128) != 0 ? ColorKt.m4108compositeOverOWjLjI(Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), m4062copywmQWz5c$default) : j8;
        long m4108compositeOverOWjLjI5 = (i2 & 256) != 0 ? ColorKt.m4108compositeOverOWjLjI(Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), m4062copywmQWz5c$default2) : j9;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(830140629, i, -1, "androidx.compose.material.ChipDefaults.filterChipColors (Chip.kt:485)");
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(m4108compositeOverOWjLjI, m4062copywmQWz5c$default, m4062copywmQWz5c$default2, m4108compositeOverOWjLjI2, m4062copywmQWz5c$default3, m4062copywmQWz5c$default4, m4108compositeOverOWjLjI3, m4108compositeOverOWjLjI4, m4108compositeOverOWjLjI5, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }

    /* renamed from: outlinedFilterChipColors-J08w3-E, reason: not valid java name */
    public final SelectableChipColors m1593outlinedFilterChipColorsJ08w3E(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(346878099);
        ComposerKt.sourceInformation(composer, "C(outlinedFilterChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color)513@23845L6,514@23905L6,518@24165L8,521@24300L8,523@24396L6,526@24556L6,529@24717L6:Chip.kt#jmzs0o");
        long m1607getSurface0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1607getSurface0d7_KjU() : j;
        long m4062copywmQWz5c$default = (i2 & 2) != 0 ? Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long m4062copywmQWz5c$default2 = (i2 & 4) != 0 ? Color.m4062copywmQWz5c$default(m4062copywmQWz5c$default, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long j10 = (i2 & 8) != 0 ? m1607getSurface0d7_KjU : j4;
        long m4062copywmQWz5c$default3 = (i2 & 16) != 0 ? Color.m4062copywmQWz5c$default(m4062copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long m4062copywmQWz5c$default4 = (i2 & 32) != 0 ? Color.m4062copywmQWz5c$default(m4062copywmQWz5c$default2, ContentAlpha.INSTANCE.getDisabled(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long m4108compositeOverOWjLjI = (i2 & 64) != 0 ? ColorKt.m4108compositeOverOWjLjI(Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), m1607getSurface0d7_KjU) : j7;
        long m4108compositeOverOWjLjI2 = (i2 & 128) != 0 ? ColorKt.m4108compositeOverOWjLjI(Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), m4062copywmQWz5c$default) : j8;
        long m4108compositeOverOWjLjI3 = (i2 & 256) != 0 ? ColorKt.m4108compositeOverOWjLjI(Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), m4062copywmQWz5c$default2) : j9;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(346878099, i, -1, "androidx.compose.material.ChipDefaults.outlinedFilterChipColors (Chip.kt:532)");
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(m1607getSurface0d7_KjU, m4062copywmQWz5c$default, m4062copywmQWz5c$default2, j10, m4062copywmQWz5c$default3, m4062copywmQWz5c$default4, m4108compositeOverOWjLjI, m4108compositeOverOWjLjI2, m4108compositeOverOWjLjI3, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultSelectableChipColors;
    }

    public final BorderStroke getOutlinedBorder(Composer composer, int i) {
        composer.startReplaceableGroup(-1650225597);
        ComposerKt.sourceInformation(composer, "C550@25564L6:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1650225597, i, -1, "androidx.compose.material.ChipDefaults.<get-outlinedBorder> (Chip.kt:549)");
        }
        BorderStroke m554BorderStrokecXLIe8U = BorderStrokeKt.m554BorderStrokecXLIe8U(OutlinedBorderSize, Color.m4062copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1602getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m554BorderStrokecXLIe8U;
    }

    /* renamed from: getOutlinedBorderSize-D9Ej5fM, reason: not valid java name */
    public final float m1590getOutlinedBorderSizeD9Ej5fM() {
        return OutlinedBorderSize;
    }

    /* renamed from: getLeadingIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1588getLeadingIconSizeD9Ej5fM() {
        return LeadingIconSize;
    }

    /* renamed from: getSelectedIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1591getSelectedIconSizeD9Ej5fM() {
        return SelectedIconSize;
    }
}
