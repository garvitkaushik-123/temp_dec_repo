package io.adn.sdk.internal.ui.utils;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import coil.compose.AsyncImagePainter;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import io.adn.sdk.R;
import io.adn.sdk.internal.domain.model.ui.LayoutPosition;
import io.adn.sdk.publisher.AdnClickElement;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Compose.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¢\u0006\u0002\u0010\u0003\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a\u0011\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0000¢\u0006\u0002\u0010\u0003\u001a\u0011\u0010\t\u001a\u00020\n*\u00020\nH\u0001¢\u0006\u0002\u0010\u000b\u001a)\u0010\f\u001a\u00020\n*\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0001¢\u0006\u0002\u0010\u0012\u001aC\u0010\u0013\u001a\u00020\n*\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\r\u001a\u00020\u000e2\u001e\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0017H\u0001¢\u0006\u0002\u0010\u0018\u001a\f\u0010\u0019\u001a\u00020\n*\u00020\nH\u0000\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001cH\u0000¨\u0006\u001d"}, d2 = {"toColor", "Landroidx/compose/ui/graphics/Color;", "", "(I)J", "toAlignment", "Landroidx/compose/ui/Alignment;", "Lio/adn/sdk/internal/domain/model/ui/LayoutPosition;", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "defaultButtonBackground", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "noRippleClickable", "enabled", "", "onClick", "Lkotlin/Function0;", "", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "clickWithCoordinates", "clickElement", "Lio/adn/sdk/publisher/AdnClickElement;", "onClicked", "Lkotlin/Function3;", "(Landroidx/compose/ui/Modifier;Lio/adn/sdk/publisher/AdnClickElement;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "noClickable", PglCryptUtils.KEY_MESSAGE, "", "Lcoil/compose/AsyncImagePainter$State$Error;", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ComposeKt {

    /* compiled from: Compose.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutPosition.values().length];
            try {
                iArr[LayoutPosition.TopLeft.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutPosition.TopRight.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LayoutPosition.BottomLeft.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LayoutPosition.BottomRight.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final long toColor(int i) {
        return ColorKt.Color(i);
    }

    public static final Alignment toAlignment(LayoutPosition layoutPosition) {
        Intrinsics.checkNotNullParameter(layoutPosition, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[layoutPosition.ordinal()];
        if (i == 1) {
            return Alignment.INSTANCE.getTopStart();
        }
        if (i == 2) {
            return Alignment.INSTANCE.getTopEnd();
        }
        if (i == 3) {
            return Alignment.INSTANCE.getBottomStart();
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return Alignment.INSTANCE.getBottomEnd();
    }

    public static final Modifier defaultButtonBackground(Modifier modifier, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        composer.startReplaceableGroup(-80081584);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-80081584, i, -1, "io.adn.sdk.internal.ui.utils.defaultButtonBackground (Compose.kt:33)");
        }
        Modifier paint$default = PainterModifierKt.paint$default(modifier, PainterResources_androidKt.painterResource(R.drawable.adn_bgd_button, composer, 0), false, null, ContentScale.INSTANCE.getFit(), 0.0f, null, 54, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return paint$default;
    }

    public static final Modifier noRippleClickable(Modifier modifier, boolean z, Function0<Unit> onClick, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        composer.startReplaceableGroup(1662871028);
        boolean z2 = (i2 & 1) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1662871028, i, -1, "io.adn.sdk.internal.ui.utils.noRippleClickable (Compose.kt:42)");
        }
        composer.startReplaceableGroup(-1450246797);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        Modifier m559clickableO2vRcR0$default = ClickableKt.m559clickableO2vRcR0$default(modifier, (MutableInteractionSource) rememberedValue, null, z2, null, null, onClick, 24, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m559clickableO2vRcR0$default;
    }

    public static final Modifier clickWithCoordinates(Modifier modifier, AdnClickElement clickElement, boolean z, Function3<? super AdnClickElement, ? super Integer, ? super Integer, Unit> onClicked, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(clickElement, "clickElement");
        Intrinsics.checkNotNullParameter(onClicked, "onClicked");
        composer.startReplaceableGroup(1084408472);
        boolean z2 = true;
        if ((i2 & 2) != 0) {
            z = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1084408472, i, -1, "io.adn.sdk.internal.ui.utils.clickWithCoordinates (Compose.kt:54)");
        }
        if (!z) {
            Modifier noClickable = noClickable(modifier);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return noClickable;
        }
        composer.startReplaceableGroup(-1709436391);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = InteractionSourceKt.MutableInteractionSource();
            composer.updateRememberedValue(rememberedValue);
        }
        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) rememberedValue;
        composer.endReplaceableGroup();
        Unit unit = Unit.INSTANCE;
        composer.startReplaceableGroup(-1709433567);
        boolean z3 = (((i & 7168) ^ 3072) > 2048 && composer.changed(onClicked)) || (i & 3072) == 2048;
        if ((((i & 112) ^ 48) <= 32 || !composer.changed(clickElement)) && (i & 48) != 32) {
            z2 = false;
        }
        boolean z4 = z3 | z2;
        ComposeKt$clickWithCoordinates$1$1 rememberedValue2 = composer.rememberedValue();
        if (z4 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new ComposeKt$clickWithCoordinates$1$1(onClicked, clickElement, null);
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        Modifier hoverable = HoverableKt.hoverable(SuspendingPointerInputFilterKt.pointerInput(modifier, unit, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2), mutableInteractionSource, false);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return hoverable;
    }

    public static final Modifier noClickable(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ClickableKt.m561clickableXHw0xAI$default(modifier, false, null, null, new Function0() { // from class: io.adn.sdk.internal.ui.utils.ComposeKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, 6, null);
    }

    public static final String message(AsyncImagePainter.State.Error error) {
        Intrinsics.checkNotNullParameter(error, "<this>");
        String message = error.getResult().getThrowable().getMessage();
        return message == null ? "load Image error" : message;
    }

    public static final long toDpSize(int i) {
        float f = i;
        return DpKt.m6411DpSizeYgX7TsA(Dp.m6389constructorimpl(f), Dp.m6389constructorimpl(f));
    }
}
