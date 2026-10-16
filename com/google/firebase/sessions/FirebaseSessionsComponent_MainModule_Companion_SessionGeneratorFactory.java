package com.google.firebase.sessions;

import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.dagger.internal.Factory;
import com.google.firebase.sessions.dagger.internal.Preconditions;

/* loaded from: classes4.dex */
public final class FirebaseSessionsComponent_MainModule_Companion_SessionGeneratorFactory implements Factory<SessionGenerator> {
    @Override // javax.inject.Provider
    public SessionGenerator get() {
        return sessionGenerator();
    }

    public static FirebaseSessionsComponent_MainModule_Companion_SessionGeneratorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SessionGenerator sessionGenerator() {
        return (SessionGenerator) Preconditions.checkNotNullFromProvides(FirebaseSessionsComponent.MainModule.INSTANCE.sessionGenerator());
    }

    private static final class InstanceHolder {
        private static final FirebaseSessionsComponent_MainModule_Companion_SessionGeneratorFactory INSTANCE = new FirebaseSessionsComponent_MainModule_Companion_SessionGeneratorFactory();

        private InstanceHolder() {
        }
    }
}
