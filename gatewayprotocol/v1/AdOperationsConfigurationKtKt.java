package gatewayprotocol.v1;

import gatewayprotocol.v1.AdOperationsConfigurationKt;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdOperationsConfigurationKt.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"adOperationsConfiguration", "Lgatewayprotocol/v1/NativeConfigurationOuterClass$AdOperationsConfiguration;", "block", "Lkotlin/Function1;", "Lgatewayprotocol/v1/AdOperationsConfigurationKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeadOperationsConfiguration", "copy", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AdOperationsConfigurationKtKt {
    /* renamed from: -initializeadOperationsConfiguration, reason: not valid java name */
    public static final NativeConfigurationOuterClass.AdOperationsConfiguration m9413initializeadOperationsConfiguration(Function1<? super AdOperationsConfigurationKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        AdOperationsConfigurationKt.Dsl.Companion companion = AdOperationsConfigurationKt.Dsl.INSTANCE;
        NativeConfigurationOuterClass.AdOperationsConfiguration.Builder newBuilder = NativeConfigurationOuterClass.AdOperationsConfiguration.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        AdOperationsConfigurationKt.Dsl _create = companion._create(newBuilder);
        block.invoke(_create);
        return _create._build();
    }

    public static final NativeConfigurationOuterClass.AdOperationsConfiguration copy(NativeConfigurationOuterClass.AdOperationsConfiguration adOperationsConfiguration, Function1<? super AdOperationsConfigurationKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(adOperationsConfiguration, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        AdOperationsConfigurationKt.Dsl.Companion companion = AdOperationsConfigurationKt.Dsl.INSTANCE;
        NativeConfigurationOuterClass.AdOperationsConfiguration.Builder builder = adOperationsConfiguration.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        AdOperationsConfigurationKt.Dsl _create = companion._create(builder);
        block.invoke(_create);
        return _create._build();
    }
}
