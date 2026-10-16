package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.internal.services.I;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface v {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5660a = a.f5661a;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f5661a = new a();

        public final v a(com.moloco.sdk.internal.bidtoken.b bidTokenParser, I timeProviderService) {
            Intrinsics.checkNotNullParameter(bidTokenParser, "bidTokenParser");
            Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
            return new w(bidTokenParser, timeProviderService);
        }
    }

    k a();

    Object a(k kVar, Continuation<? super Unit> continuation);

    Object a(Continuation<? super B> continuation);

    void b();
}
