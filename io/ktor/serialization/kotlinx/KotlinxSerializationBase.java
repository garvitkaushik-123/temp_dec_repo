package io.ktor.serialization.kotlinx;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialFormat;

/* compiled from: KotlinxSerializationBase.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0080@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\bH @ø\u0001\u0000¢\u0006\u0004\b\f\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lio/ktor/serialization/kotlinx/KotlinxSerializationBase;", "T", "", "format", "Lkotlinx/serialization/SerialFormat;", "(Lkotlinx/serialization/SerialFormat;)V", "serialize", "parameters", "Lio/ktor/serialization/kotlinx/SerializationParameters;", "serialize$ktor_serialization_kotlinx", "(Lio/ktor/serialization/kotlinx/SerializationParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serializeContent", "serializeContent$ktor_serialization_kotlinx", "ktor-serialization-kotlinx"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public abstract class KotlinxSerializationBase<T> {
    private final SerialFormat format;

    public abstract Object serializeContent$ktor_serialization_kotlinx(SerializationParameters serializationParameters, Continuation<? super T> continuation);

    public KotlinxSerializationBase(SerialFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object serialize$ktor_serialization_kotlinx(SerializationParameters serializationParameters, Continuation<? super T> continuation) {
        KotlinxSerializationBase$serialize$1 kotlinxSerializationBase$serialize$1;
        Object obj;
        int i;
        KotlinxSerializationBase<T> kotlinxSerializationBase;
        if (continuation instanceof KotlinxSerializationBase$serialize$1) {
            kotlinxSerializationBase$serialize$1 = (KotlinxSerializationBase$serialize$1) continuation;
            if ((kotlinxSerializationBase$serialize$1.label & Integer.MIN_VALUE) != 0) {
                kotlinxSerializationBase$serialize$1.label -= Integer.MIN_VALUE;
                obj = kotlinxSerializationBase$serialize$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = kotlinxSerializationBase$serialize$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    serializationParameters.setSerializer(SerializerLookupKt.serializerFromTypeInfo(serializationParameters.getTypeInfo(), this.format.getSerializersModule()));
                    kotlinxSerializationBase$serialize$1.L$0 = this;
                    kotlinxSerializationBase$serialize$1.L$1 = serializationParameters;
                    kotlinxSerializationBase$serialize$1.label = 1;
                    obj = serializeContent$ktor_serialization_kotlinx(serializationParameters, kotlinxSerializationBase$serialize$1);
                    if (obj != coroutine_suspended) {
                        kotlinxSerializationBase = this;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                serializationParameters = (SerializationParameters) kotlinxSerializationBase$serialize$1.L$1;
                kotlinxSerializationBase = (KotlinxSerializationBase) kotlinxSerializationBase$serialize$1.L$0;
                ResultKt.throwOnFailure(obj);
                if (obj == null) {
                    return obj;
                }
                serializationParameters.setSerializer(SerializerLookupKt.guessSerializer(serializationParameters.getValue(), kotlinxSerializationBase.format.getSerializersModule()));
                kotlinxSerializationBase$serialize$1.L$0 = null;
                kotlinxSerializationBase$serialize$1.L$1 = null;
                kotlinxSerializationBase$serialize$1.label = 2;
                Object serializeContent$ktor_serialization_kotlinx = kotlinxSerializationBase.serializeContent$ktor_serialization_kotlinx(serializationParameters, kotlinxSerializationBase$serialize$1);
                return serializeContent$ktor_serialization_kotlinx == coroutine_suspended ? coroutine_suspended : serializeContent$ktor_serialization_kotlinx;
            }
        }
        kotlinxSerializationBase$serialize$1 = new KotlinxSerializationBase$serialize$1(this, continuation);
        obj = kotlinxSerializationBase$serialize$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = kotlinxSerializationBase$serialize$1.label;
        if (i != 0) {
        }
        if (obj == null) {
        }
    }
}
