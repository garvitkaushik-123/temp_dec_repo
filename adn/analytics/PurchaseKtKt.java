package adn.analytics;

import adn.analytics.Analytics;
import adn.analytics.PurchaseKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PurchaseKt.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {FirebaseAnalytics.Event.PURCHASE, "Ladn/analytics/Analytics$Purchase;", "block", "Lkotlin/Function1;", "Ladn/analytics/PurchaseKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializepurchase", "copy", "adn-protos"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PurchaseKtKt {
    /* renamed from: -initializepurchase, reason: not valid java name */
    public static final Analytics.Purchase m310initializepurchase(Function1<? super PurchaseKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        PurchaseKt.Dsl.Companion companion = PurchaseKt.Dsl.INSTANCE;
        Analytics.Purchase.Builder newBuilder = Analytics.Purchase.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder(...)");
        PurchaseKt.Dsl _create = companion._create(newBuilder);
        block.invoke(_create);
        return _create._build();
    }

    public static final Analytics.Purchase copy(Analytics.Purchase purchase, Function1<? super PurchaseKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(purchase, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        PurchaseKt.Dsl.Companion companion = PurchaseKt.Dsl.INSTANCE;
        Analytics.Purchase.Builder builder = purchase.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "toBuilder(...)");
        PurchaseKt.Dsl _create = companion._create(builder);
        block.invoke(_create);
        return _create._build();
    }
}
