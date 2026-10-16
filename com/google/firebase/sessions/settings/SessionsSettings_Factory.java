package com.google.firebase.sessions.settings;

import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.dagger.internal.Factory;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes4.dex */
public final class SessionsSettings_Factory implements Factory<SessionsSettings> {
    private final Provider<CoroutineContext> backgroundDispatcherProvider;
    private final Provider<CoroutineContext> blockingDispatcherProvider;
    private final Provider<FirebaseApp> firebaseAppProvider;
    private final Provider<FirebaseInstallationsApi> firebaseInstallationsApiProvider;

    public SessionsSettings_Factory(Provider<FirebaseApp> provider, Provider<CoroutineContext> provider2, Provider<CoroutineContext> provider3, Provider<FirebaseInstallationsApi> provider4) {
        this.firebaseAppProvider = provider;
        this.blockingDispatcherProvider = provider2;
        this.backgroundDispatcherProvider = provider3;
        this.firebaseInstallationsApiProvider = provider4;
    }

    @Override // javax.inject.Provider
    public SessionsSettings get() {
        return newInstance(this.firebaseAppProvider.get(), this.blockingDispatcherProvider.get(), this.backgroundDispatcherProvider.get(), this.firebaseInstallationsApiProvider.get());
    }

    public static SessionsSettings_Factory create(Provider<FirebaseApp> provider, Provider<CoroutineContext> provider2, Provider<CoroutineContext> provider3, Provider<FirebaseInstallationsApi> provider4) {
        return new SessionsSettings_Factory(provider, provider2, provider3, provider4);
    }

    public static SessionsSettings newInstance(FirebaseApp firebaseApp, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, FirebaseInstallationsApi firebaseInstallationsApi) {
        return new SessionsSettings(firebaseApp, coroutineContext, coroutineContext2, firebaseInstallationsApi);
    }
}
