package com.inmobi.media;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class C2 {
    public static final Object a(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            Result.Companion companion = Result.INSTANCE;
            return Result.m10241constructorimpl(block.invoke());
        } catch (Error e) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(e));
        } catch (Exception e2) {
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(e2));
        }
    }
}
