package com.ironsource;

import android.os.OutcomeReceiver;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.s1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3290s1 {

    /* renamed from: com.ironsource.s1$a */
    public static final class a implements OutcomeReceiver<Object, Exception> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Unit> f3689a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super Unit> continuation) {
            this.f3689a = continuation;
        }

        @Override // android.os.OutcomeReceiver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(Exception error) {
            Intrinsics.checkNotNullParameter(error, "error");
            Continuation<Unit> continuation = this.f3689a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m10241constructorimpl(ResultKt.createFailure(error)));
        }

        @Override // android.os.OutcomeReceiver
        public void onResult(Object obj) {
            Continuation<Unit> continuation = this.f3689a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m10241constructorimpl(Unit.INSTANCE));
        }
    }

    public static final OutcomeReceiver<Object, Exception> a(Continuation<? super Unit> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "<this>");
        return new a(continuation);
    }
}
