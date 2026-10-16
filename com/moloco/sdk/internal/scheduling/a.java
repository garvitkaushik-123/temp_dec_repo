package com.moloco.sdk.internal.scheduling;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* loaded from: classes6.dex */
public final class a implements DispatcherProvider {
    @Override // com.moloco.sdk.internal.scheduling.DispatcherProvider
    public CoroutineDispatcher getDefault() {
        return Dispatchers.getDefault();
    }

    @Override // com.moloco.sdk.internal.scheduling.DispatcherProvider
    public CoroutineDispatcher getIo() {
        return Dispatchers.getIO();
    }

    @Override // com.moloco.sdk.internal.scheduling.DispatcherProvider
    public CoroutineDispatcher getMain() {
        return Dispatchers.getMain();
    }

    @Override // com.moloco.sdk.internal.scheduling.DispatcherProvider
    public CoroutineDispatcher getMainImmediate() {
        return Dispatchers.getMain().getImmediate();
    }

    @Override // com.moloco.sdk.internal.scheduling.DispatcherProvider
    public CoroutineDispatcher getUnconfined() {
        return Dispatchers.getUnconfined();
    }
}
