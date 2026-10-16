package io.bidmachine.analytics.internal;

import io.bidmachine.analytics.ReaderConfig;
import java.io.File;
import java.io.FileNotFoundException;
import kotlin.coroutines.Continuation;

/* renamed from: io.bidmachine.analytics.internal.d, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC3564d extends AbstractC3569i {
    public abstract File a(ReaderConfig.Rule rule);

    @Override // io.bidmachine.analytics.internal.AbstractC3569i
    public Object a(ReaderConfig.Rule rule, Continuation continuation) {
        return a(this, rule, continuation);
    }

    static /* synthetic */ Object a(AbstractC3564d abstractC3564d, ReaderConfig.Rule rule, Continuation continuation) {
        File a2 = abstractC3564d.a(rule);
        if (a2.exists()) {
            return new StringBuilder().append(a2.lastModified()).append('_').append(a2.length()).toString();
        }
        throw new FileNotFoundException();
    }
}
