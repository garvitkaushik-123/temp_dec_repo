package com.sourcepoint.cmplibrary.exception;

import kotlin.Metadata;

/* compiled from: Exceptions.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"TIMEOUT_MESSAGE", "", "getTIMEOUT_MESSAGE", "()Ljava/lang/String;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExceptionsKt {
    private static final String TIMEOUT_MESSAGE = "A timeout has occurred when requesting the message data. Please check your internet connection. You can extend the timeout using the messageTimeout config parameter.";

    public static final String getTIMEOUT_MESSAGE() {
        return TIMEOUT_MESSAGE;
    }
}
