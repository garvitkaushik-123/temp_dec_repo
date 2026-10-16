package io.bidmachine.ads.networks.gam_dynamic;

/* loaded from: classes7.dex */
public interface TaskExecutor {
    boolean execute(Runnable task);

    boolean execute(Runnable task, long delayMs);
}
