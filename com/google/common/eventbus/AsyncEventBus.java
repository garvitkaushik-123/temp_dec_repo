package com.google.common.eventbus;

import com.google.common.eventbus.EventBus;
import io.bidmachine.rendering.model.EventTaskParams;
import java.util.concurrent.Executor;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class AsyncEventBus extends EventBus {
    public AsyncEventBus(String identifier, Executor executor) {
        super(identifier, executor, Dispatcher.legacyAsync(), EventBus.LoggingHandler.INSTANCE);
    }

    public AsyncEventBus(Executor executor, SubscriberExceptionHandler subscriberExceptionHandler) {
        super(EventTaskParams.STATE_GROUP_DEFAULT, executor, Dispatcher.legacyAsync(), subscriberExceptionHandler);
    }

    public AsyncEventBus(Executor executor) {
        super(EventTaskParams.STATE_GROUP_DEFAULT, executor, Dispatcher.legacyAsync(), EventBus.LoggingHandler.INSTANCE);
    }
}
