package com.sourcepoint.cmplibrary.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exceptions.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B1\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tR\u001c\u0010\n\u001a\u00020\u000bX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Lcom/sourcepoint/cmplibrary/exception/ConnectionTimeoutException;", "Lcom/sourcepoint/cmplibrary/exception/ConsentLibExceptionK;", "cause", "", "description", "", "isConsumed", "", "networkCode", "(Ljava/lang/Throwable;Ljava/lang/String;ZLjava/lang/String;)V", "code", "Lcom/sourcepoint/cmplibrary/exception/ExceptionCodes;", "getCode-vXYB1G0", "()Ljava/lang/String;", "Ljava/lang/String;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ConnectionTimeoutException extends ConsentLibExceptionK {
    private final String code;

    public ConnectionTimeoutException() {
        this(null, null, false, null, 15, null);
    }

    public ConnectionTimeoutException(Throwable th) {
        this(th, null, false, null, 14, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionTimeoutException(Throwable th, String description) {
        this(th, description, false, null, 12, null);
        Intrinsics.checkNotNullParameter(description, "description");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionTimeoutException(Throwable th, String description, boolean z) {
        this(th, description, z, null, 8, null);
        Intrinsics.checkNotNullParameter(description, "description");
    }

    public /* synthetic */ ConnectionTimeoutException(Throwable th, String str, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : th, (i & 2) != 0 ? ExceptionsKt.getTIMEOUT_MESSAGE() : str, (i & 4) != 0 ? false : z, (i & 8) != 0 ? "" : str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectionTimeoutException(Throwable th, String description, boolean z, String networkCode) {
        super(z, description, th, null);
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(networkCode, "networkCode");
        this.code = ExceptionCodes.m9151constructorimpl(CodeList.INSTANCE.m9135getCONNECTION_TIMEOUTvXYB1G0() + networkCode);
    }

    @Override // com.sourcepoint.cmplibrary.exception.ConsentLibExceptionK
    /* renamed from: getCode-vXYB1G0, reason: from getter */
    public String getCode() {
        return this.code;
    }
}
