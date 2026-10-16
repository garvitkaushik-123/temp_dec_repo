package com.google.firebase.sessions;

import android.content.Context;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.dagger.Binds;
import com.google.firebase.sessions.dagger.BindsInstance;
import com.google.firebase.sessions.dagger.Component;
import com.google.firebase.sessions.dagger.Module;
import com.google.firebase.sessions.dagger.Provides;
import com.google.firebase.sessions.settings.SessionsSettings;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* compiled from: FirebaseSessionsComponent.kt */
@Component(modules = {MainModule.class})
@Singleton
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\ba\u0018\u00002\u00020\u0001:\u0002\u0016\u0017R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsComponent;", "", "firebaseSessions", "Lcom/google/firebase/sessions/FirebaseSessions;", "getFirebaseSessions", "()Lcom/google/firebase/sessions/FirebaseSessions;", "sessionDatastore", "Lcom/google/firebase/sessions/SessionDatastore;", "getSessionDatastore", "()Lcom/google/firebase/sessions/SessionDatastore;", "sessionFirelogPublisher", "Lcom/google/firebase/sessions/SessionFirelogPublisher;", "getSessionFirelogPublisher", "()Lcom/google/firebase/sessions/SessionFirelogPublisher;", "sessionGenerator", "Lcom/google/firebase/sessions/SessionGenerator;", "getSessionGenerator", "()Lcom/google/firebase/sessions/SessionGenerator;", "sessionsSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "getSessionsSettings", "()Lcom/google/firebase/sessions/settings/SessionsSettings;", "Builder", "MainModule", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface FirebaseSessionsComponent {

    /* compiled from: FirebaseSessionsComponent.kt */
    @Component.Builder
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H'J\u0012\u0010\u0004\u001a\u00020\u00002\b\b\u0001\u0010\u0004\u001a\u00020\u0005H'J\u0012\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0006\u001a\u00020\u0005H'J\b\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH'J\u0010\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fH'J\u0016\u0010\r\u001a\u00020\u00002\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH'¨\u0006\u0010"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsComponent$Builder;", "", "appContext", "Landroid/content/Context;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "blockingDispatcher", "build", "Lcom/google/firebase/sessions/FirebaseSessionsComponent;", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "transportFactoryProvider", "Lcom/google/firebase/inject/Provider;", "Lcom/google/android/datatransport/TransportFactory;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Builder {
        @BindsInstance
        Builder appContext(Context appContext);

        @BindsInstance
        Builder backgroundDispatcher(@Background CoroutineContext backgroundDispatcher);

        @BindsInstance
        Builder blockingDispatcher(@Blocking CoroutineContext blockingDispatcher);

        FirebaseSessionsComponent build();

        @BindsInstance
        Builder firebaseApp(FirebaseApp firebaseApp);

        @BindsInstance
        Builder firebaseInstallationsApi(FirebaseInstallationsApi firebaseInstallationsApi);

        @BindsInstance
        Builder transportFactoryProvider(Provider<TransportFactory> transportFactoryProvider);
    }

    FirebaseSessions getFirebaseSessions();

    SessionDatastore getSessionDatastore();

    SessionFirelogPublisher getSessionFirelogPublisher();

    SessionGenerator getSessionGenerator();

    SessionsSettings getSessionsSettings();

    /* compiled from: FirebaseSessionsComponent.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH'¨\u0006\u0010"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsComponent$MainModule;", "", "eventGDTLoggerInterface", "Lcom/google/firebase/sessions/EventGDTLoggerInterface;", "impl", "Lcom/google/firebase/sessions/EventGDTLogger;", "sessionDatastore", "Lcom/google/firebase/sessions/SessionDatastore;", "Lcom/google/firebase/sessions/SessionDatastoreImpl;", "sessionFirelogPublisher", "Lcom/google/firebase/sessions/SessionFirelogPublisher;", "Lcom/google/firebase/sessions/SessionFirelogPublisherImpl;", "sessionLifecycleServiceBinder", "Lcom/google/firebase/sessions/SessionLifecycleServiceBinder;", "Lcom/google/firebase/sessions/SessionLifecycleServiceBinderImpl;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Module
    public interface MainModule {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @Singleton
        @Binds
        EventGDTLoggerInterface eventGDTLoggerInterface(EventGDTLogger impl);

        @Singleton
        @Binds
        SessionDatastore sessionDatastore(SessionDatastoreImpl impl);

        @Singleton
        @Binds
        SessionFirelogPublisher sessionFirelogPublisher(SessionFirelogPublisherImpl impl);

        @Singleton
        @Binds
        SessionLifecycleServiceBinder sessionLifecycleServiceBinder(SessionLifecycleServiceBinderImpl impl);

        /* compiled from: FirebaseSessionsComponent.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsComponent$MainModule$Companion;", "", "()V", "sessionGenerator", "Lcom/google/firebase/sessions/SessionGenerator;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            @Singleton
            @Provides
            public final SessionGenerator sessionGenerator() {
                return new SessionGenerator(WallClock.INSTANCE, null, 2, null);
            }
        }
    }
}
