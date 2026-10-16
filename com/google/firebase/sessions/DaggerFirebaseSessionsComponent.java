package com.google.firebase.sessions;

import android.content.Context;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.DoubleCheck;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.InstanceFactory;
import com.google.firebase.sessions.dagger.internal.Preconditions;
import com.google.firebase.sessions.settings.SessionsSettings;
import com.google.firebase.sessions.settings.SessionsSettings_Factory;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes4.dex */
public final class DaggerFirebaseSessionsComponent {
    private DaggerFirebaseSessionsComponent() {
    }

    public static FirebaseSessionsComponent.Builder builder() {
        return new Builder();
    }

    private static final class Builder implements FirebaseSessionsComponent.Builder {
        private Context appContext;
        private CoroutineContext backgroundDispatcher;
        private CoroutineContext blockingDispatcher;
        private FirebaseApp firebaseApp;
        private FirebaseInstallationsApi firebaseInstallationsApi;
        private Provider<TransportFactory> transportFactoryProvider;

        private Builder() {
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public /* bridge */ /* synthetic */ FirebaseSessionsComponent.Builder transportFactoryProvider(Provider provider) {
            return transportFactoryProvider((Provider<TransportFactory>) provider);
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder appContext(Context context) {
            this.appContext = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder backgroundDispatcher(CoroutineContext coroutineContext) {
            this.backgroundDispatcher = (CoroutineContext) Preconditions.checkNotNull(coroutineContext);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder blockingDispatcher(CoroutineContext coroutineContext) {
            this.blockingDispatcher = (CoroutineContext) Preconditions.checkNotNull(coroutineContext);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder firebaseApp(FirebaseApp firebaseApp) {
            this.firebaseApp = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder firebaseInstallationsApi(FirebaseInstallationsApi firebaseInstallationsApi) {
            this.firebaseInstallationsApi = (FirebaseInstallationsApi) Preconditions.checkNotNull(firebaseInstallationsApi);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public Builder transportFactoryProvider(Provider<TransportFactory> provider) {
            this.transportFactoryProvider = (Provider) Preconditions.checkNotNull(provider);
            return this;
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent.Builder
        public FirebaseSessionsComponent build() {
            Preconditions.checkBuilderRequirement(this.appContext, Context.class);
            Preconditions.checkBuilderRequirement(this.backgroundDispatcher, CoroutineContext.class);
            Preconditions.checkBuilderRequirement(this.blockingDispatcher, CoroutineContext.class);
            Preconditions.checkBuilderRequirement(this.firebaseApp, FirebaseApp.class);
            Preconditions.checkBuilderRequirement(this.firebaseInstallationsApi, FirebaseInstallationsApi.class);
            Preconditions.checkBuilderRequirement(this.transportFactoryProvider, Provider.class);
            return new FirebaseSessionsComponentImpl(this.appContext, this.backgroundDispatcher, this.blockingDispatcher, this.firebaseApp, this.firebaseInstallationsApi, this.transportFactoryProvider);
        }
    }

    private static final class FirebaseSessionsComponentImpl implements FirebaseSessionsComponent {
        private javax.inject.Provider<Context> appContextProvider;
        private javax.inject.Provider<CoroutineContext> backgroundDispatcherProvider;
        private javax.inject.Provider<CoroutineContext> blockingDispatcherProvider;
        private javax.inject.Provider<EventGDTLogger> eventGDTLoggerProvider;
        private javax.inject.Provider<FirebaseApp> firebaseAppProvider;
        private javax.inject.Provider<FirebaseInstallationsApi> firebaseInstallationsApiProvider;
        private final FirebaseSessionsComponentImpl firebaseSessionsComponentImpl;
        private javax.inject.Provider<FirebaseSessions> firebaseSessionsProvider;
        private javax.inject.Provider<SessionDatastoreImpl> sessionDatastoreImplProvider;
        private javax.inject.Provider<SessionFirelogPublisherImpl> sessionFirelogPublisherImplProvider;
        private javax.inject.Provider<SessionGenerator> sessionGeneratorProvider;
        private javax.inject.Provider<SessionLifecycleServiceBinderImpl> sessionLifecycleServiceBinderImplProvider;
        private javax.inject.Provider<SessionsSettings> sessionsSettingsProvider;
        private javax.inject.Provider<Provider<TransportFactory>> transportFactoryProvider;

        private FirebaseSessionsComponentImpl(Context context, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Provider<TransportFactory> provider) {
            this.firebaseSessionsComponentImpl = this;
            initialize(context, coroutineContext, coroutineContext2, firebaseApp, firebaseInstallationsApi, provider);
        }

        private void initialize(Context context, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Provider<TransportFactory> provider) {
            this.firebaseAppProvider = InstanceFactory.create(firebaseApp);
            this.blockingDispatcherProvider = InstanceFactory.create(coroutineContext2);
            this.backgroundDispatcherProvider = InstanceFactory.create(coroutineContext);
            Factory create = InstanceFactory.create(firebaseInstallationsApi);
            this.firebaseInstallationsApiProvider = create;
            this.sessionsSettingsProvider = DoubleCheck.provider(SessionsSettings_Factory.create(this.firebaseAppProvider, this.blockingDispatcherProvider, this.backgroundDispatcherProvider, create));
            Factory create2 = InstanceFactory.create(context);
            this.appContextProvider = create2;
            javax.inject.Provider<SessionLifecycleServiceBinderImpl> provider2 = DoubleCheck.provider(SessionLifecycleServiceBinderImpl_Factory.create(create2));
            this.sessionLifecycleServiceBinderImplProvider = provider2;
            this.firebaseSessionsProvider = DoubleCheck.provider(FirebaseSessions_Factory.create(this.firebaseAppProvider, this.sessionsSettingsProvider, this.backgroundDispatcherProvider, provider2));
            this.sessionDatastoreImplProvider = DoubleCheck.provider(SessionDatastoreImpl_Factory.create(this.appContextProvider, this.backgroundDispatcherProvider));
            Factory create3 = InstanceFactory.create(provider);
            this.transportFactoryProvider = create3;
            javax.inject.Provider<EventGDTLogger> provider3 = DoubleCheck.provider(EventGDTLogger_Factory.create(create3));
            this.eventGDTLoggerProvider = provider3;
            this.sessionFirelogPublisherImplProvider = DoubleCheck.provider(SessionFirelogPublisherImpl_Factory.create(this.firebaseAppProvider, this.firebaseInstallationsApiProvider, this.sessionsSettingsProvider, provider3, this.backgroundDispatcherProvider));
            this.sessionGeneratorProvider = DoubleCheck.provider(FirebaseSessionsComponent_MainModule_Companion_SessionGeneratorFactory.create());
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public FirebaseSessions getFirebaseSessions() {
            return this.firebaseSessionsProvider.get();
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public SessionDatastore getSessionDatastore() {
            return this.sessionDatastoreImplProvider.get();
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public SessionFirelogPublisher getSessionFirelogPublisher() {
            return this.sessionFirelogPublisherImplProvider.get();
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public SessionGenerator getSessionGenerator() {
            return this.sessionGeneratorProvider.get();
        }

        @Override // com.google.firebase.sessions.FirebaseSessionsComponent
        public SessionsSettings getSessionsSettings() {
            return this.sessionsSettingsProvider.get();
        }
    }
}
