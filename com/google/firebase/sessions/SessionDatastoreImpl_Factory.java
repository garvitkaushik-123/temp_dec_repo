package com.google.firebase.sessions;

import android.content.Context;
import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes4.dex */
public final class SessionDatastoreImpl_Factory implements Factory<SessionDatastoreImpl> {
    private final Provider<Context> appContextProvider;
    private final Provider<CoroutineContext> backgroundDispatcherProvider;

    public SessionDatastoreImpl_Factory(Provider<Context> provider, Provider<CoroutineContext> provider2) {
        this.appContextProvider = provider;
        this.backgroundDispatcherProvider = provider2;
    }

    @Override // javax.inject.Provider
    public SessionDatastoreImpl get() {
        return newInstance(this.appContextProvider.get(), this.backgroundDispatcherProvider.get());
    }

    public static SessionDatastoreImpl_Factory create(Provider<Context> provider, Provider<CoroutineContext> provider2) {
        return new SessionDatastoreImpl_Factory(provider, provider2);
    }

    public static SessionDatastoreImpl newInstance(Context context, CoroutineContext coroutineContext) {
        return new SessionDatastoreImpl(context, coroutineContext);
    }
}
