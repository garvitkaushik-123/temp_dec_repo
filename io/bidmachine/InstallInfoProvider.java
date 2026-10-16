package io.bidmachine;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import io.bidmachine.InstallInfoProvider;
import io.bidmachine.core.Logger;
import io.bidmachine.internal.utils.LogSafeRunnable;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes7.dex */
class InstallInfoProvider {
    private static final AtomicLong INSTALL_TIME_MS = new AtomicLong(0);

    InstallInfoProvider() {
    }

    static void initialize(final Context context) {
        new Thread(new LogSafeRunnable() { // from class: io.bidmachine.InstallInfoProvider$$ExternalSyntheticLambda0
            @Override // io.bidmachine.utils.SafeRunnable
            public final void onRun() {
                new InstallInfoProvider.Retriever(context).retrieve();
            }
        }).start();
    }

    static long getInstallTimeMs() {
        return INSTALL_TIME_MS.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class Retriever {
        private final InstallReferrerClient client;

        Retriever(Context context) {
            this.client = InstallReferrerClient.newBuilder(context).build();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void retrieve() {
            try {
                this.client.startConnection(new StateListener());
            } catch (Throwable th) {
                Logger.w(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getInstallTimeMs(InstallReferrerClient client) {
            try {
                long installBeginTimestampSeconds = client.getInstallReferrer().getInstallBeginTimestampSeconds();
                if (installBeginTimestampSeconds != 0) {
                    return installBeginTimestampSeconds * 1000;
                }
            } catch (Exception e) {
                Logger.w(e);
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        class StateListener implements InstallReferrerStateListener {
            @Override // com.android.installreferrer.api.InstallReferrerStateListener
            public void onInstallReferrerServiceDisconnected() {
            }

            private StateListener() {
            }

            @Override // com.android.installreferrer.api.InstallReferrerStateListener
            public void onInstallReferrerSetupFinished(final int responseCode) {
                new Thread(new LogSafeRunnable() { // from class: io.bidmachine.InstallInfoProvider$Retriever$StateListener$$ExternalSyntheticLambda0
                    @Override // io.bidmachine.utils.SafeRunnable
                    public final void onRun() {
                        InstallInfoProvider.Retriever.StateListener.this.m9634xa43c908a(responseCode);
                    }
                }).start();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: onInstallReferrerSetupFinishedSync, reason: merged with bridge method [inline-methods] */
            public void m9634xa43c908a(int responseCode) {
                if (responseCode == 0) {
                    AtomicLong atomicLong = InstallInfoProvider.INSTALL_TIME_MS;
                    Retriever retriever = Retriever.this;
                    atomicLong.set(retriever.getInstallTimeMs(retriever.client));
                }
                Retriever.this.client.endConnection();
            }
        }
    }
}
