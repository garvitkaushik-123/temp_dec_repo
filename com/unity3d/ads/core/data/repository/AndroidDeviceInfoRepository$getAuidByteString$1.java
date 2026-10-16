package com.unity3d.ads.core.data.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AndroidDeviceInfoRepository.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidDeviceInfoRepository", f = "AndroidDeviceInfoRepository.kt", i = {}, l = {38}, m = "getAuidByteString", n = {}, s = {})
/* loaded from: classes7.dex */
final class AndroidDeviceInfoRepository$getAuidByteString$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidDeviceInfoRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidDeviceInfoRepository$getAuidByteString$1(AndroidDeviceInfoRepository androidDeviceInfoRepository, Continuation<? super AndroidDeviceInfoRepository$getAuidByteString$1> continuation) {
        super(continuation);
        this.this$0 = androidDeviceInfoRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAuidByteString(this);
    }
}
