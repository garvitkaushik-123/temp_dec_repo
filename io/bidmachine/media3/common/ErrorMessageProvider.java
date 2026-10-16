package io.bidmachine.media3.common;

import android.util.Pair;
import java.lang.Throwable;

/* loaded from: classes7.dex */
public interface ErrorMessageProvider<T extends Throwable> {
    Pair<Integer, String> getErrorMessage(T t);
}
