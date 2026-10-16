package adn.analytics;

import adn.analytics.Analytics;
import adn.analytics.RevenueGenerationKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RevenueGenerationKt.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"revenueGeneration", "Ladn/analytics/Analytics$RevenueGeneration;", "block", "Lkotlin/Function1;", "Ladn/analytics/RevenueGenerationKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializerevenueGeneration", "copy", "adn-protos"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RevenueGenerationKtKt {
    /* renamed from: -initializerevenueGeneration, reason: not valid java name */
    public static final Analytics.RevenueGeneration m311initializerevenueGeneration(Function1<? super RevenueGenerationKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        RevenueGenerationKt.Dsl.Companion companion = RevenueGenerationKt.Dsl.INSTANCE;
        Analytics.RevenueGeneration.Builder newBuilder = Analytics.RevenueGeneration.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder(...)");
        RevenueGenerationKt.Dsl _create = companion._create(newBuilder);
        block.invoke(_create);
        return _create._build();
    }

    public static final Analytics.RevenueGeneration copy(Analytics.RevenueGeneration revenueGeneration, Function1<? super RevenueGenerationKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(revenueGeneration, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        RevenueGenerationKt.Dsl.Companion companion = RevenueGenerationKt.Dsl.INSTANCE;
        Analytics.RevenueGeneration.Builder builder = revenueGeneration.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "toBuilder(...)");
        RevenueGenerationKt.Dsl _create = companion._create(builder);
        block.invoke(_create);
        return _create._build();
    }
}
