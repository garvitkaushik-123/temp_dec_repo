package com.mbridge.msdk.playercommon.exoplayer2.util;

import android.util.Pair;
import java.lang.Throwable;

/* loaded from: classes6.dex */
public interface ErrorMessageProvider<T extends Throwable> {
    Pair<Integer, String> getErrorMessage(T t);
}
