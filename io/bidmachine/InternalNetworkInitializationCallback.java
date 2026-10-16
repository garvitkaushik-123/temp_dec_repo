package io.bidmachine;

/* loaded from: classes7.dex */
public interface InternalNetworkInitializationCallback {
    void onFail(NetworkAdapter networkAdapter, String error);

    void onSuccess(NetworkAdapter networkAdapter);
}
