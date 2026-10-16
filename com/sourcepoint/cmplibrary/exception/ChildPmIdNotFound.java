package com.sourcepoint.cmplibrary.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exceptions.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001c\u0010\t\u001a\u00020\nX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000e"}, d2 = {"Lcom/sourcepoint/cmplibrary/exception/ChildPmIdNotFound;", "Lcom/sourcepoint/cmplibrary/exception/ConsentLibExceptionK;", "cause", "", "description", "", "isConsumed", "", "(Ljava/lang/Throwable;Ljava/lang/String;Z)V", "code", "Lcom/sourcepoint/cmplibrary/exception/ExceptionCodes;", "getCode-vXYB1G0", "()Ljava/lang/String;", "Ljava/lang/String;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ChildPmIdNotFound extends ConsentLibExceptionK {
    private final String code;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChildPmIdNotFound(String description) {
        this(null, description, false, 5, null);
        Intrinsics.checkNotNullParameter(description, "description");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChildPmIdNotFound(Throwable th, String description) {
        this(th, description, false, 4, null);
        Intrinsics.checkNotNullParameter(description, "description");
    }

    public /* synthetic */ ChildPmIdNotFound(Throwable th, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : th, str, (i & 4) != 0 ? false : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChildPmIdNotFound(Throwable th, String description, boolean z) {
        super(z, description, th, null);
        Intrinsics.checkNotNullParameter(description, "description");
        this.code = CodeList.INSTANCE.m9134getCHILD_PM_ID_NOT_FOUNDvXYB1G0();
    }

    @Override // com.sourcepoint.cmplibrary.exception.ConsentLibExceptionK
    /* renamed from: getCode-vXYB1G0, reason: not valid java name and from getter */
    public String getCode() {
        return this.code;
    }
}
