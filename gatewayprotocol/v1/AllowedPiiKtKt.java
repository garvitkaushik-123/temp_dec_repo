package gatewayprotocol.v1;

import gatewayprotocol.v1.AllowedPiiKt;
import gatewayprotocol.v1.AllowedPiiOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AllowedPiiKt.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"allowedPii", "Lgatewayprotocol/v1/AllowedPiiOuterClass$AllowedPii;", "block", "Lkotlin/Function1;", "Lgatewayprotocol/v1/AllowedPiiKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeallowedPii", "copy", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AllowedPiiKtKt {
    /* renamed from: -initializeallowedPii, reason: not valid java name */
    public static final AllowedPiiOuterClass.AllowedPii m9418initializeallowedPii(Function1<? super AllowedPiiKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        AllowedPiiKt.Dsl.Companion companion = AllowedPiiKt.Dsl.INSTANCE;
        AllowedPiiOuterClass.AllowedPii.Builder newBuilder = AllowedPiiOuterClass.AllowedPii.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        AllowedPiiKt.Dsl _create = companion._create(newBuilder);
        block.invoke(_create);
        return _create._build();
    }

    public static final AllowedPiiOuterClass.AllowedPii copy(AllowedPiiOuterClass.AllowedPii allowedPii, Function1<? super AllowedPiiKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(allowedPii, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        AllowedPiiKt.Dsl.Companion companion = AllowedPiiKt.Dsl.INSTANCE;
        AllowedPiiOuterClass.AllowedPii.Builder builder = allowedPii.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        AllowedPiiKt.Dsl _create = companion._create(builder);
        block.invoke(_create);
        return _create._build();
    }
}
