package adn.analytics;

import adn.analytics.Analytics;
import adn.analytics.LastClickKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LastClickKt.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"lastClick", "Ladn/analytics/Analytics$LastClick;", "block", "Lkotlin/Function1;", "Ladn/analytics/LastClickKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializelastClick", "copy", "adn-protos"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LastClickKtKt {
    /* renamed from: -initializelastClick, reason: not valid java name */
    public static final Analytics.LastClick m308initializelastClick(Function1<? super LastClickKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        LastClickKt.Dsl.Companion companion = LastClickKt.Dsl.INSTANCE;
        Analytics.LastClick.Builder newBuilder = Analytics.LastClick.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder(...)");
        LastClickKt.Dsl _create = companion._create(newBuilder);
        block.invoke(_create);
        return _create._build();
    }

    public static final Analytics.LastClick copy(Analytics.LastClick lastClick, Function1<? super LastClickKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(lastClick, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        LastClickKt.Dsl.Companion companion = LastClickKt.Dsl.INSTANCE;
        Analytics.LastClick.Builder builder = lastClick.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "toBuilder(...)");
        LastClickKt.Dsl _create = companion._create(builder);
        block.invoke(_create);
        return _create._build();
    }
}
