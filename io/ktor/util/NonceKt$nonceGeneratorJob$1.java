package io.ktor.util;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: Nonce.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.NonceKt$nonceGeneratorJob$1", f = "Nonce.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {76}, m = "invokeSuspend", n = {"seedChannel", "previousRoundNonceList", "secureInstance", "weakRandom", "secureBytes", "weakBytes", "randomNonceList", "lastReseed", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "I$0"})
/* loaded from: classes8.dex */
final class NonceKt$nonceGeneratorJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    NonceKt$nonceGeneratorJob$1(Continuation<? super NonceKt$nonceGeneratorJob$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NonceKt$nonceGeneratorJob$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NonceKt$nonceGeneratorJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00de A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x002f, B:8:0x0102, B:10:0x00de, B:14:0x0104, B:16:0x0113, B:20:0x0073, B:22:0x007e, B:24:0x0087, B:26:0x0093, B:27:0x00a4, B:28:0x00a1), top: B:5:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0104 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x002f, B:8:0x0102, B:10:0x00de, B:14:0x0104, B:16:0x0113, B:20:0x0073, B:22:0x007e, B:24:0x0087, B:26:0x0093, B:27:0x00a4, B:28:0x00a1), top: B:5:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007e A[Catch: all -> 0x0040, LOOP:1: B:21:0x007c->B:22:0x007e, LOOP_END, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x002f, B:8:0x0102, B:10:0x00de, B:14:0x0104, B:16:0x0113, B:20:0x0073, B:22:0x007e, B:24:0x0087, B:26:0x0093, B:27:0x00a4, B:28:0x00a1), top: B:5:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0093 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x002f, B:8:0x0102, B:10:0x00de, B:14:0x0104, B:16:0x0113, B:20:0x0073, B:22:0x007e, B:24:0x0087, B:26:0x0093, B:27:0x00a4, B:28:0x00a1), top: B:5:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a1 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x002f, B:8:0x0102, B:10:0x00de, B:14:0x0104, B:16:0x0113, B:20:0x0073, B:22:0x007e, B:24:0x0087, B:26:0x0093, B:27:0x00a4, B:28:0x00a1), top: B:5:0x002f }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x00ff -> B:8:0x0102). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        SecureRandom lookupSecureRandom;
        SecureRandom weakRandom;
        byte[] bArr;
        byte[] bArr2;
        long j;
        Channel channel;
        int length;
        int i;
        long currentTimeMillis;
        int size;
        int i2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Channel<String> seedChannel = NonceKt.getSeedChannel();
            arrayList = new ArrayList();
            lookupSecureRandom = NonceKt.lookupSecureRandom();
            weakRandom = SecureRandom.getInstance("SHA1PRNG");
            bArr = new byte[128];
            bArr2 = new byte[512];
            weakRandom.setSeed(lookupSecureRandom.generateSeed(128));
            j = 0;
            channel = seedChannel;
            lookupSecureRandom.nextBytes(bArr);
            weakRandom.nextBytes(bArr2);
            length = bArr.length;
            while (i < length) {
            }
            currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j <= 30000) {
            }
            if (i2 >= size) {
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            size = this.I$1;
            i2 = this.I$0;
            long j2 = this.J$0;
            List list = (List) this.L$6;
            byte[] bArr3 = (byte[]) this.L$5;
            byte[] bArr4 = (byte[]) this.L$4;
            SecureRandom secureRandom = (SecureRandom) this.L$3;
            SecureRandom secureRandom2 = (SecureRandom) this.L$2;
            ArrayList arrayList2 = (ArrayList) this.L$1;
            channel = (Channel) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                List list2 = list;
                SecureRandom secureRandom3 = secureRandom;
                byte[] bArr5 = bArr3;
                SecureRandom secureRandom4 = secureRandom2;
                ArrayList arrayList3 = arrayList2;
                long j3 = j2;
                i2++;
                if (i2 >= size) {
                    this.L$0 = channel;
                    this.L$1 = arrayList3;
                    this.L$2 = secureRandom4;
                    this.L$3 = secureRandom3;
                    this.L$4 = bArr4;
                    this.L$5 = bArr5;
                    this.L$6 = list2;
                    this.J$0 = j3;
                    this.I$0 = i2;
                    this.I$1 = size;
                    this.label = 1;
                    if (channel.send(list2.get(i2), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i2++;
                    if (i2 >= size) {
                        arrayList3.clear();
                        int size2 = list2.size();
                        for (int size3 = list2.size() / 2; size3 < size2; size3++) {
                            arrayList3.add(list2.get(size3));
                        }
                        arrayList = arrayList3;
                        lookupSecureRandom = secureRandom4;
                        weakRandom = secureRandom3;
                        bArr = bArr4;
                        bArr2 = bArr5;
                        j = j3;
                        lookupSecureRandom.nextBytes(bArr);
                        weakRandom.nextBytes(bArr2);
                        length = bArr.length;
                        for (i = 0; i < length; i++) {
                            bArr2[i * 4] = bArr[i];
                        }
                        currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - j <= 30000) {
                            weakRandom.setSeed(j - currentTimeMillis);
                            weakRandom.setSeed(lookupSecureRandom.generateSeed(bArr.length));
                            List plus = kotlin.collections.CollectionsKt.plus((Collection) StringsKt.chunked(CryptoKt.hex(bArr2), 16), (Iterable) arrayList);
                            Intrinsics.checkNotNullExpressionValue(weakRandom, "weakRandom");
                            List shuffled = kotlin.collections.CollectionsKt.shuffled(plus, weakRandom);
                            byte[] bArr6 = bArr;
                            list2 = shuffled;
                            size = shuffled.size() / 2;
                            j3 = currentTimeMillis;
                            bArr5 = bArr2;
                            bArr4 = bArr6;
                            SecureRandom secureRandom5 = lookupSecureRandom;
                            arrayList3 = arrayList;
                            i2 = 0;
                            secureRandom3 = weakRandom;
                            secureRandom4 = secureRandom5;
                        } else {
                            weakRandom.setSeed(bArr);
                            List plus2 = kotlin.collections.CollectionsKt.plus((Collection) StringsKt.chunked(CryptoKt.hex(bArr2), 16), (Iterable) arrayList);
                            Intrinsics.checkNotNullExpressionValue(weakRandom, "weakRandom");
                            List shuffled2 = kotlin.collections.CollectionsKt.shuffled(plus2, weakRandom);
                            byte[] bArr7 = bArr;
                            list2 = shuffled2;
                            size = shuffled2.size() / 2;
                            j3 = j;
                            bArr5 = bArr2;
                            bArr4 = bArr7;
                            SecureRandom secureRandom6 = lookupSecureRandom;
                            arrayList3 = arrayList;
                            i2 = 0;
                            secureRandom3 = weakRandom;
                            secureRandom4 = secureRandom6;
                        }
                        if (i2 >= size) {
                        }
                    }
                }
            } catch (Throwable th) {
                try {
                    channel.close(th);
                    SendChannel.DefaultImpls.close$default(channel, null, 1, null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    SendChannel.DefaultImpls.close$default(channel, null, 1, null);
                    throw th2;
                }
            }
        }
    }
}
