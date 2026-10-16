package io.ktor.client.engine.okhttp;

import io.ktor.client.request.HttpRequestData;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import java.io.Closeable;
import java.nio.ByteBuffer;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.JobKt;
import okio.BufferedSource;

/* compiled from: OkHttpEngine.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1", f = "OkHttpEngine.kt", i = {0, 0, 0, 0}, l = {166}, m = "invokeSuspend", n = {"$this$writer", "$this$use$iv", "source", "lastRead"}, s = {"L$0", "L$1", "L$4", "L$5"})
/* loaded from: classes8.dex */
final class OkHttpEngineKt$toChannel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ HttpRequestData $requestData;
    final /* synthetic */ BufferedSource $this_toChannel;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OkHttpEngineKt$toChannel$1(BufferedSource bufferedSource, CoroutineContext coroutineContext, HttpRequestData httpRequestData, Continuation<? super OkHttpEngineKt$toChannel$1> continuation) {
        super(2, continuation);
        this.$this_toChannel = bufferedSource;
        this.$context = coroutineContext;
        this.$requestData = httpRequestData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OkHttpEngineKt$toChannel$1 okHttpEngineKt$toChannel$1 = new OkHttpEngineKt$toChannel$1(this.$this_toChannel, this.$context, this.$requestData, continuation);
        okHttpEngineKt$toChannel$1.L$0 = obj;
        return okHttpEngineKt$toChannel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((OkHttpEngineKt$toChannel$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005f A[Catch: all -> 0x0094, TryCatch #1 {all -> 0x0094, blocks: (B:10:0x0059, B:12:0x005f, B:14:0x0065, B:16:0x0069, B:20:0x0090), top: B:9:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x008a -> B:8:0x008d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Closeable closeable;
        Throwable th;
        final Ref.IntRef intRef;
        WriterScope writerScope;
        Unit unit;
        CoroutineContext coroutineContext;
        final HttpRequestData httpRequestData;
        final BufferedSource bufferedSource;
        OkHttpEngineKt$toChannel$1 okHttpEngineKt$toChannel$1 = this;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = okHttpEngineKt$toChannel$1.label;
        Unit unit2 = null;
        try {
        } catch (Throwable th2) {
            th = th2;
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WriterScope writerScope2 = (WriterScope) okHttpEngineKt$toChannel$1.L$0;
            BufferedSource bufferedSource2 = okHttpEngineKt$toChannel$1.$this_toChannel;
            CoroutineContext coroutineContext2 = okHttpEngineKt$toChannel$1.$context;
            HttpRequestData httpRequestData2 = okHttpEngineKt$toChannel$1.$requestData;
            BufferedSource bufferedSource3 = bufferedSource2;
            intRef = new Ref.IntRef();
            writerScope = writerScope2;
            unit = null;
            coroutineContext = coroutineContext2;
            httpRequestData = httpRequestData2;
            bufferedSource = bufferedSource3;
            closeable = bufferedSource2;
            th = null;
            if (!bufferedSource.isOpen()) {
            }
            unit2 = Unit.INSTANCE;
            if (closeable != null) {
            }
            if (th == null) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.IntRef intRef2 = (Ref.IntRef) okHttpEngineKt$toChannel$1.L$5;
            BufferedSource bufferedSource4 = (BufferedSource) okHttpEngineKt$toChannel$1.L$4;
            HttpRequestData httpRequestData3 = (HttpRequestData) okHttpEngineKt$toChannel$1.L$3;
            CoroutineContext coroutineContext3 = (CoroutineContext) okHttpEngineKt$toChannel$1.L$2;
            Closeable closeable2 = (Closeable) okHttpEngineKt$toChannel$1.L$1;
            WriterScope writerScope3 = (WriterScope) okHttpEngineKt$toChannel$1.L$0;
            ResultKt.throwOnFailure(obj);
            unit = null;
            bufferedSource = bufferedSource4;
            httpRequestData = httpRequestData3;
            coroutineContext = coroutineContext3;
            closeable = closeable2;
            writerScope = writerScope3;
            intRef = intRef2;
            th = null;
            okHttpEngineKt$toChannel$1 = this;
            try {
            } catch (Throwable th3) {
                th = th3;
                unit2 = unit;
                Closeable closeable3 = closeable;
                closeable = closeable3;
                th = th;
                if (closeable != null) {
                }
                if (th == null) {
                }
            }
            if (!bufferedSource.isOpen() && JobKt.isActive(coroutineContext) && intRef.element >= 0) {
                ByteWriteChannel channel = writerScope.getChannel();
                Function1<ByteBuffer, Unit> function1 = new Function1<ByteBuffer, Unit>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
                        invoke2(byteBuffer);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ByteBuffer buffer) {
                        Throwable mapExceptions;
                        Intrinsics.checkNotNullParameter(buffer, "buffer");
                        try {
                            Ref.IntRef.this.element = bufferedSource.read(buffer);
                        } catch (Throwable th4) {
                            mapExceptions = OkHttpEngineKt.mapExceptions(th4, httpRequestData);
                            throw mapExceptions;
                        }
                    }
                };
                okHttpEngineKt$toChannel$1.L$0 = writerScope;
                okHttpEngineKt$toChannel$1.L$1 = closeable;
                okHttpEngineKt$toChannel$1.L$2 = coroutineContext;
                okHttpEngineKt$toChannel$1.L$3 = httpRequestData;
                okHttpEngineKt$toChannel$1.L$4 = bufferedSource;
                okHttpEngineKt$toChannel$1.L$5 = intRef;
                okHttpEngineKt$toChannel$1.label = 1;
                if (ByteWriteChannel.DefaultImpls.write$default(channel, 0, function1, okHttpEngineKt$toChannel$1, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                okHttpEngineKt$toChannel$1 = this;
                if (!bufferedSource.isOpen()) {
                }
                unit2 = Unit.INSTANCE;
                if (closeable != null) {
                }
                if (th == null) {
                }
            } else {
                unit2 = Unit.INSTANCE;
                if (closeable != null) {
                    try {
                        closeable.close();
                    } catch (Throwable th4) {
                        if (th == null) {
                            th = th4;
                        } else {
                            ExceptionsKt.addSuppressed(th, th4);
                        }
                    }
                }
                if (th == null) {
                    throw th;
                }
                Intrinsics.checkNotNull(unit2);
                return Unit.INSTANCE;
            }
        }
    }
}
