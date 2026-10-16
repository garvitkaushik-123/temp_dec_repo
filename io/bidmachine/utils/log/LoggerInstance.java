package io.bidmachine.utils.log;

import io.bidmachine.utils.lazy.LazyValue;

/* loaded from: classes8.dex */
public interface LoggerInstance {
    void d(LazyValue<String> lazyMessage);

    void d(Object subTag, LazyValue<String> lazyMessage);

    void d(Object subTag, String message);

    void d(String message);

    void e(LazyValue<String> lazyMessage);

    void e(Object subTag, LazyValue<String> lazyMessage);

    void e(Object subTag, String message);

    void e(String message);

    void w(LazyValue<String> lazyMessage);

    void w(Object subTag, LazyValue<String> lazyMessage);

    void w(Object subTag, String message);

    void w(String message);

    void w(Throwable throwable);
}
