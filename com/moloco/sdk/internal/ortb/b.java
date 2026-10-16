package com.moloco.sdk.internal.ortb;

import com.moloco.sdk.internal.ortb.model.e;
import com.moloco.sdk.internal.scheduling.DispatcherProvider;
import com.moloco.sdk.internal.v;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* loaded from: classes6.dex */
public final class b implements com.moloco.sdk.internal.ortb.a {

    /* renamed from: a, reason: collision with root package name */
    public final Json f5437a;
    public final DispatcherProvider b;

    @DebugMetadata(c = "com.moloco.sdk.internal.ortb.BidResponseParserImpl$invoke$2", f = "BidResponseParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super v<e, Exception>>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5438a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super v<e, Exception>> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new a(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5438a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                Json json = b.this.f5437a;
                String str = this.c;
                KSerializer<Object> serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(e.class));
                Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                return new v.b(d.a((e) json.decodeFromString(serializer, str)));
            } catch (Exception e) {
                return new v.a(e);
            }
        }
    }

    public b(Json json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.f5437a = json;
        this.b = com.moloco.sdk.internal.scheduling.b.a();
    }

    @Override // com.moloco.sdk.internal.ortb.a
    public Object a(String str, Continuation<? super v<e, Exception>> continuation) {
        return BuildersKt.withContext(this.b.getIo(), new a(str, null), continuation);
    }
}
