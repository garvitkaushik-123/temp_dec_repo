package io.ktor.util;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* compiled from: ByteChannels.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\u001a\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006\u001a\u001e\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t*\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b\u001a\u0015\u0010\f\u001a\u00020\r*\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"CHUNK_BUFFER_SIZE", "", "copyToBoth", "", "Lio/ktor/utils/io/ByteReadChannel;", "first", "Lio/ktor/utils/io/ByteWriteChannel;", "second", "split", "Lkotlin/Pair;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "toByteArray", "", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ByteChannelsKt {
    private static final long CHUNK_BUFFER_SIZE = 4096;

    public static final Pair<ByteReadChannel, ByteReadChannel> split(ByteReadChannel byteReadChannel, CoroutineScope coroutineScope) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        final ByteChannel ByteChannel = ByteChannelKt.ByteChannel(true);
        final ByteChannel ByteChannel2 = ByteChannelKt.ByteChannel(true);
        launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new ByteChannelsKt$split$1(byteReadChannel, ByteChannel, ByteChannel2, null), 3, null);
        launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.util.ByteChannelsKt$split$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                if (th == null) {
                    return;
                }
                ByteChannel.this.cancel(th);
                ByteChannel2.cancel(th);
            }
        });
        return TuplesKt.to(ByteChannel, ByteChannel2);
    }

    public static final void copyToBoth(ByteReadChannel byteReadChannel, final ByteWriteChannel first, final ByteWriteChannel second) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        launch$default = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getUnconfined(), null, new ByteChannelsKt$copyToBoth$1(byteReadChannel, first, second, null), 2, null);
        launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.util.ByteChannelsKt$copyToBoth$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                if (th == null) {
                    return;
                }
                ByteWriteChannel.this.close(th);
                second.close(th);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object toByteArray(ByteReadChannel byteReadChannel, Continuation<? super byte[]> continuation) {
        ByteChannelsKt$toByteArray$1 byteChannelsKt$toByteArray$1;
        int i;
        if (continuation instanceof ByteChannelsKt$toByteArray$1) {
            byteChannelsKt$toByteArray$1 = (ByteChannelsKt$toByteArray$1) continuation;
            if ((byteChannelsKt$toByteArray$1.label & Integer.MIN_VALUE) != 0) {
                byteChannelsKt$toByteArray$1.label -= Integer.MIN_VALUE;
                ByteChannelsKt$toByteArray$1 byteChannelsKt$toByteArray$12 = byteChannelsKt$toByteArray$1;
                Object obj = byteChannelsKt$toByteArray$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = byteChannelsKt$toByteArray$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    byteChannelsKt$toByteArray$12.label = 1;
                    obj = ByteReadChannel.DefaultImpls.readRemaining$default(byteReadChannel, 0L, byteChannelsKt$toByteArray$12, 1, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return StringsKt.readBytes$default((ByteReadPacket) obj, 0, 1, null);
            }
        }
        byteChannelsKt$toByteArray$1 = new ByteChannelsKt$toByteArray$1(continuation);
        ByteChannelsKt$toByteArray$1 byteChannelsKt$toByteArray$122 = byteChannelsKt$toByteArray$1;
        Object obj2 = byteChannelsKt$toByteArray$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = byteChannelsKt$toByteArray$122.label;
        if (i != 0) {
        }
        return StringsKt.readBytes$default((ByteReadPacket) obj2, 0, 1, null);
    }
}
