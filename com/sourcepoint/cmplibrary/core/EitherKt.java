package com.sourcepoint.cmplibrary.core;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.sourcepoint.cmplibrary.core.Either;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Either.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\f\u001a6\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0080\bø\u0001\u0000\u001a6\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\u0004H\u0080\bø\u0001\u0000\u001aB\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u00010\u0004H\u0080\bø\u0001\u0000\u001aO\u0010\u000b\u001a\u0002H\t\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\t0\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u0004H\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a \u0010\u000f\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0080\b¢\u0006\u0002\u0010\u0010\u001a<\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\t0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u0004H\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"executeOnLeft", "Lcom/sourcepoint/cmplibrary/core/Either;", "B", "block", "Lkotlin/Function1;", "", "", "executeOnRight", "flatMap", "C", InneractiveMediationDefs.GENDER_FEMALE, "fold", "ifLeft", "ifRight", "(Lcom/sourcepoint/cmplibrary/core/Either;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getOrNull", "(Lcom/sourcepoint/cmplibrary/core/Either;)Ljava/lang/Object;", "map", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EitherKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <B, C> Either<C> flatMap(Either<? extends B> either, Function1<? super B, ? extends Either<? extends C>> f) {
        Intrinsics.checkNotNullParameter(either, "<this>");
        Intrinsics.checkNotNullParameter(f, "f");
        if (either instanceof Either.Right) {
            return f.invoke((Object) ((Either.Right) either).getR());
        }
        if (either instanceof Either.Left) {
            return either;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <B> Either<B> executeOnLeft(Either<? extends B> either, Function1<? super Throwable, Unit> block) {
        Intrinsics.checkNotNullParameter(either, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!(either instanceof Either.Right) && (either instanceof Either.Left)) {
            block.invoke(((Either.Left) either).getT());
        }
        return either;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <B> Either<B> executeOnRight(Either<? extends B> either, Function1<? super B, Unit> block) {
        Intrinsics.checkNotNullParameter(either, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (either instanceof Either.Right) {
            block.invoke((Object) ((Either.Right) either).getR());
            return either;
        }
        boolean z = either instanceof Either.Left;
        return either;
    }

    public static final <B, C> C fold(Either<? extends B> either, Function1<? super Throwable, ? extends C> ifLeft, Function1<? super B, ? extends C> ifRight) {
        Intrinsics.checkNotNullParameter(either, "<this>");
        Intrinsics.checkNotNullParameter(ifLeft, "ifLeft");
        Intrinsics.checkNotNullParameter(ifRight, "ifRight");
        if (either instanceof Either.Right) {
            return ifRight.invoke((Object) ((Either.Right) either).getR());
        }
        if (either instanceof Either.Left) {
            return ifLeft.invoke(((Either.Left) either).getT());
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final <B> B getOrNull(Either<? extends B> either) {
        Intrinsics.checkNotNullParameter(either, "<this>");
        if (either instanceof Either.Right) {
            return (B) ((Either.Right) either).getR();
        }
        if (either instanceof Either.Left) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <B, C> Either<C> map(Either<? extends B> either, Function1<? super B, ? extends C> f) {
        Intrinsics.checkNotNullParameter(either, "<this>");
        Intrinsics.checkNotNullParameter(f, "f");
        if (either instanceof Either.Right) {
            return new Either.Right(f.invoke((Object) ((Either.Right) either).getR()));
        }
        if (either instanceof Either.Left) {
            return either;
        }
        throw new NoWhenBranchMatchedException();
    }
}
