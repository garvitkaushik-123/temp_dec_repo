package com.sourcepoint.cmplibrary.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exceptions.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BC\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bR\u001c\u0010\f\u001a\u00020\rX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Lcom/sourcepoint/cmplibrary/exception/InvalidRequestException;", "Lcom/sourcepoint/cmplibrary/exception/ConsentLibExceptionK;", "cause", "", "description", "", "isConsumed", "", "apiRequestPostfix", "choice", "httpStatusCode", "(Ljava/lang/Throwable;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "code", "Lcom/sourcepoint/cmplibrary/exception/ExceptionCodes;", "getCode-vXYB1G0", "()Ljava/lang/String;", "Ljava/lang/String;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InvalidRequestException extends ConsentLibExceptionK {
    private final String code;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InvalidRequestException(String description) {
        this(null, description, false, null, null, null, 61, null);
        Intrinsics.checkNotNullParameter(description, "description");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InvalidRequestException(Throwable th, String description) {
        this(th, description, false, null, null, null, 60, null);
        Intrinsics.checkNotNullParameter(description, "description");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InvalidRequestException(Throwable th, String description, boolean z) {
        this(th, description, z, null, null, null, 56, null);
        Intrinsics.checkNotNullParameter(description, "description");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InvalidRequestException(Throwable th, String description, boolean z, String apiRequestPostfix) {
        this(th, description, z, apiRequestPostfix, null, null, 48, null);
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(apiRequestPostfix, "apiRequestPostfix");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InvalidRequestException(Throwable th, String description, boolean z, String apiRequestPostfix, String choice) {
        this(th, description, z, apiRequestPostfix, choice, null, 32, null);
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(apiRequestPostfix, "apiRequestPostfix");
        Intrinsics.checkNotNullParameter(choice, "choice");
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ InvalidRequestException(java.lang.Throwable r2, java.lang.String r3, boolean r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, int r8, kotlin.jvm.internal.DefaultConstructorMarker r9) {
        /*
            r1 = this;
            r9 = r8 & 1
            if (r9 == 0) goto L5
            r2 = 0
        L5:
            r9 = r8 & 4
            if (r9 == 0) goto La
            r4 = 0
        La:
            r9 = r8 & 8
            java.lang.String r0 = ""
            if (r9 == 0) goto L11
            r5 = r0
        L11:
            r9 = r8 & 16
            if (r9 == 0) goto L16
            r6 = r0
        L16:
            r8 = r8 & 32
            if (r8 == 0) goto L22
            r9 = r0
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L29
        L22:
            r9 = r7
            r8 = r6
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L29:
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sourcepoint.cmplibrary.exception.InvalidRequestException.<init>(java.lang.Throwable, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidRequestException(Throwable th, String description, boolean z, String apiRequestPostfix, String choice, String httpStatusCode) {
        super(z, description, th, null);
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(apiRequestPostfix, "apiRequestPostfix");
        Intrinsics.checkNotNullParameter(choice, "choice");
        Intrinsics.checkNotNullParameter(httpStatusCode, "httpStatusCode");
        this.code = ExceptionCodes.m9151constructorimpl(CodeList.INSTANCE.m9139getINVALID_REQUEST_ERRORvXYB1G0() + apiRequestPostfix + choice + httpStatusCode);
    }

    @Override // com.sourcepoint.cmplibrary.exception.ConsentLibExceptionK
    /* renamed from: getCode-vXYB1G0, reason: from getter */
    public String getCode() {
        return this.code;
    }
}
