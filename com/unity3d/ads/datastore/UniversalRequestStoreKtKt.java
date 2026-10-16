package com.unity3d.ads.datastore;

import com.unity3d.ads.datastore.UniversalRequestStoreKt;
import com.unity3d.ads.datastore.UniversalRequestStoreOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UniversalRequestStoreKt.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"universalRequestStore", "Lcom/unity3d/ads/datastore/UniversalRequestStoreOuterClass$UniversalRequestStore;", "block", "Lkotlin/Function1;", "Lcom/unity3d/ads/datastore/UniversalRequestStoreKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeuniversalRequestStore", "copy", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class UniversalRequestStoreKtKt {
    /* renamed from: -initializeuniversalRequestStore, reason: not valid java name */
    public static final UniversalRequestStoreOuterClass.UniversalRequestStore m9195initializeuniversalRequestStore(Function1<? super UniversalRequestStoreKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        UniversalRequestStoreKt.Dsl.Companion companion = UniversalRequestStoreKt.Dsl.INSTANCE;
        UniversalRequestStoreOuterClass.UniversalRequestStore.Builder newBuilder = UniversalRequestStoreOuterClass.UniversalRequestStore.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        UniversalRequestStoreKt.Dsl _create = companion._create(newBuilder);
        block.invoke(_create);
        return _create._build();
    }

    public static final UniversalRequestStoreOuterClass.UniversalRequestStore copy(UniversalRequestStoreOuterClass.UniversalRequestStore universalRequestStore, Function1<? super UniversalRequestStoreKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(universalRequestStore, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        UniversalRequestStoreKt.Dsl.Companion companion = UniversalRequestStoreKt.Dsl.INSTANCE;
        UniversalRequestStoreOuterClass.UniversalRequestStore.Builder builder = universalRequestStore.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        UniversalRequestStoreKt.Dsl _create = companion._create(builder);
        block.invoke(_create);
        return _create._build();
    }
}
