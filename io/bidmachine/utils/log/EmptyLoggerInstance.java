package io.bidmachine.utils.log;

import io.bidmachine.utils.lazy.LazyValue;

/* loaded from: classes8.dex */
public class EmptyLoggerInstance implements LoggerInstance {
    @Override // io.bidmachine.utils.log.LoggerInstance
    public void d(LazyValue<String> lazyMessage) {
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void d(Object subTag, LazyValue<String> lazyMessage) {
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void d(Object subTag, String message) {
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void d(String message) {
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void e(LazyValue<String> lazyMessage) {
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void e(Object subTag, LazyValue<String> lazyMessage) {
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void e(Object subTag, String message) {
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void e(String message) {
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void w(LazyValue<String> lazyMessage) {
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void w(Object subTag, LazyValue<String> lazyMessage) {
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void w(Object subTag, String message) {
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void w(String message) {
    }

    @Override // io.bidmachine.utils.log.LoggerInstance
    public void w(Throwable throwable) {
    }
}
