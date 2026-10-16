package gatewayprotocol.v1;

import gatewayprotocol.v1.NetworkCapabilityTransportsKt;
import gatewayprotocol.v1.NetworkCapabilityTransportsOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NetworkCapabilityTransportsKt.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"networkCapabilityTransports", "Lgatewayprotocol/v1/NetworkCapabilityTransportsOuterClass$NetworkCapabilityTransports;", "block", "Lkotlin/Function1;", "Lgatewayprotocol/v1/NetworkCapabilityTransportsKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializenetworkCapabilityTransports", "copy", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class NetworkCapabilityTransportsKtKt {
    /* renamed from: -initializenetworkCapabilityTransports, reason: not valid java name */
    public static final NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports m9446initializenetworkCapabilityTransports(Function1<? super NetworkCapabilityTransportsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        NetworkCapabilityTransportsKt.Dsl.Companion companion = NetworkCapabilityTransportsKt.Dsl.INSTANCE;
        NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports.Builder newBuilder = NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        NetworkCapabilityTransportsKt.Dsl _create = companion._create(newBuilder);
        block.invoke(_create);
        return _create._build();
    }

    public static final NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports copy(NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports networkCapabilityTransports, Function1<? super NetworkCapabilityTransportsKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(networkCapabilityTransports, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        NetworkCapabilityTransportsKt.Dsl.Companion companion = NetworkCapabilityTransportsKt.Dsl.INSTANCE;
        NetworkCapabilityTransportsOuterClass.NetworkCapabilityTransports.Builder builder = networkCapabilityTransports.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        NetworkCapabilityTransportsKt.Dsl _create = companion._create(builder);
        block.invoke(_create);
        return _create._build();
    }
}
