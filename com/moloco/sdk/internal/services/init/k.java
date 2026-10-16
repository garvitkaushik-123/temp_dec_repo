package com.moloco.sdk.internal.services.init;

import com.moloco.sdk.Init;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.publisher.MediationInfo;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: classes6.dex */
public interface k {
    Init.SDKInitResponse a();

    Object a(String str, MediationInfo mediationInfo, Continuation<? super v<Init.SDKInitResponse, j>> continuation);

    Object a(Continuation<? super Unit> continuation);
}
