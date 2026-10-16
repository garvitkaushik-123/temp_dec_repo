package com.digitalturbine.ignite.authenticator.listeners.api;

import android.content.ComponentName;
import android.os.IBinder;

/* loaded from: classes3.dex */
public interface AuthenticationServiceListener {
    void onIgniteServiceAuthenticated(String str);

    void onIgniteServiceAuthenticationFailed(String str);

    void onIgniteServiceConnected(ComponentName componentName, IBinder iBinder);

    void onIgniteServiceConnectionFailed(String str);

    void onOdtUnsupported();
}
