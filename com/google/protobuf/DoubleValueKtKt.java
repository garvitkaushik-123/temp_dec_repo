package com.google.protobuf;

import com.google.protobuf.DoubleValue;
import com.google.protobuf.DoubleValueKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DoubleValueKt.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0007\u001a)\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2 = {"doubleValue", "Lcom/google/protobuf/DoubleValue;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/DoubleValueKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializedoubleValue", "copy", "java_kotlin-lite-well_known_protos_kotlin_lite"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DoubleValueKtKt {
    /* renamed from: -initializedoubleValue, reason: not valid java name */
    public static final DoubleValue m7352initializedoubleValue(Function1<? super DoubleValueKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        DoubleValueKt.Dsl.Companion companion = DoubleValueKt.Dsl.INSTANCE;
        DoubleValue.Builder newBuilder = DoubleValue.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        DoubleValueKt.Dsl _create = companion._create(newBuilder);
        block.invoke(_create);
        return _create._build();
    }

    public static final DoubleValue copy(DoubleValue doubleValue, Function1<? super DoubleValueKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(doubleValue, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        DoubleValueKt.Dsl.Companion companion = DoubleValueKt.Dsl.INSTANCE;
        DoubleValue.Builder builder = doubleValue.toBuilder();
        Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
        DoubleValueKt.Dsl _create = companion._create(builder);
        block.invoke(_create);
        return _create._build();
    }
}
