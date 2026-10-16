package adn.analytics;

import adn.analytics.Analytics;
import adn.analytics.AttributionKt;
import com.ironsource.C3057e4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AttributionKt.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {C3057e4.c, "Ladn/analytics/Analytics$Attribution;", "block", "Lkotlin/Function1;", "Ladn/analytics/AttributionKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeattribution", "copy", "adn-protos"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AttributionKtKt {
    /* renamed from: -initializeattribution, reason: not valid java name */
    public static final Analytics.Attribution m306initializeattribution(Function1<? super AttributionKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        AttributionKt.Dsl.Companion companion = AttributionKt.Dsl.INSTANCE;
        Analytics.Attribution.Builder newBuilder = Analytics.Attribution.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder(...)");
        AttributionKt.Dsl _create = companion._create(newBuilder);
        block.invoke(_create);
        return _create._build();
    }

    public static final Analytics.Attribution copy(Analytics.Attribution attribution, Function1<? super AttributionKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(attribution, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        AttributionKt.Dsl.Companion companion = AttributionKt.Dsl.INSTANCE;
        Analytics.Attribution.Builder builder = attribution.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "toBuilder(...)");
        AttributionKt.Dsl _create = companion._create(builder);
        block.invoke(_create);
        return _create._build();
    }
}
