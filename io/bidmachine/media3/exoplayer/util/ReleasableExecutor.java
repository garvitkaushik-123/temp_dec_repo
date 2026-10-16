package io.bidmachine.media3.exoplayer.util;

import io.bidmachine.media3.common.util.Consumer;
import java.util.concurrent.Executor;

/* loaded from: classes7.dex */
public interface ReleasableExecutor extends Executor {
    void release();

    static <T extends Executor> ReleasableExecutor from(final T t, final Consumer<T> consumer) {
        return new ReleasableExecutor() { // from class: io.bidmachine.media3.exoplayer.util.ReleasableExecutor.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                t.execute(runnable);
            }

            @Override // io.bidmachine.media3.exoplayer.util.ReleasableExecutor
            public void release() {
                consumer.accept(t);
            }
        };
    }
}
