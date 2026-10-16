package gatewayprotocol.v1;

import com.google.protobuf.Timestamp;
import gatewayprotocol.v1.TransactionDataKt;
import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TransactionDataKt.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\f\u001a)\u0010\r\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"timestampOrNull", "Lcom/google/protobuf/Timestamp;", "Lgatewayprotocol/v1/TransactionEventRequestOuterClass$TransactionDataOrBuilder;", "getTimestampOrNull", "(Lgatewayprotocol/v1/TransactionEventRequestOuterClass$TransactionDataOrBuilder;)Lcom/google/protobuf/Timestamp;", "transactionData", "Lgatewayprotocol/v1/TransactionEventRequestOuterClass$TransactionData;", "block", "Lkotlin/Function1;", "Lgatewayprotocol/v1/TransactionDataKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializetransactionData", "copy", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class TransactionDataKtKt {
    /* renamed from: -initializetransactionData, reason: not valid java name */
    public static final TransactionEventRequestOuterClass.TransactionData m9463initializetransactionData(Function1<? super TransactionDataKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        TransactionDataKt.Dsl.Companion companion = TransactionDataKt.Dsl.INSTANCE;
        TransactionEventRequestOuterClass.TransactionData.Builder newBuilder = TransactionEventRequestOuterClass.TransactionData.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        TransactionDataKt.Dsl _create = companion._create(newBuilder);
        block.invoke(_create);
        return _create._build();
    }

    public static final TransactionEventRequestOuterClass.TransactionData copy(TransactionEventRequestOuterClass.TransactionData transactionData, Function1<? super TransactionDataKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(transactionData, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        TransactionDataKt.Dsl.Companion companion = TransactionDataKt.Dsl.INSTANCE;
        TransactionEventRequestOuterClass.TransactionData.Builder builder = transactionData.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        TransactionDataKt.Dsl _create = companion._create(builder);
        block.invoke(_create);
        return _create._build();
    }

    public static final Timestamp getTimestampOrNull(TransactionEventRequestOuterClass.TransactionDataOrBuilder transactionDataOrBuilder) {
        Intrinsics.checkNotNullParameter(transactionDataOrBuilder, "<this>");
        if (transactionDataOrBuilder.hasTimestamp()) {
            return transactionDataOrBuilder.getTimestamp();
        }
        return null;
    }
}
