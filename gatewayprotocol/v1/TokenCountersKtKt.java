package gatewayprotocol.v1;

import gatewayprotocol.v1.HeaderBiddingTokenOuterClass;
import gatewayprotocol.v1.TokenCountersKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TokenCountersKt.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"tokenCounters", "Lgatewayprotocol/v1/HeaderBiddingTokenOuterClass$TokenCounters;", "block", "Lkotlin/Function1;", "Lgatewayprotocol/v1/TokenCountersKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializetokenCounters", "copy", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class TokenCountersKtKt {
    /* renamed from: -initializetokenCounters, reason: not valid java name */
    public static final HeaderBiddingTokenOuterClass.TokenCounters m9462initializetokenCounters(Function1<? super TokenCountersKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        TokenCountersKt.Dsl.Companion companion = TokenCountersKt.Dsl.INSTANCE;
        HeaderBiddingTokenOuterClass.TokenCounters.Builder newBuilder = HeaderBiddingTokenOuterClass.TokenCounters.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        TokenCountersKt.Dsl _create = companion._create(newBuilder);
        block.invoke(_create);
        return _create._build();
    }

    public static final HeaderBiddingTokenOuterClass.TokenCounters copy(HeaderBiddingTokenOuterClass.TokenCounters tokenCounters, Function1<? super TokenCountersKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(tokenCounters, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        TokenCountersKt.Dsl.Companion companion = TokenCountersKt.Dsl.INSTANCE;
        HeaderBiddingTokenOuterClass.TokenCounters.Builder builder = tokenCounters.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        TokenCountersKt.Dsl _create = companion._create(builder);
        block.invoke(_create);
        return _create._build();
    }
}
