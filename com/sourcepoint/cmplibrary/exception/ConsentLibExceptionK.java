package com.sourcepoint.cmplibrary.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Exceptions.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00060\u0001j\u0002`\u0002B%\b\u0004\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0018\u0010\n\u001a\u00020\u000bX¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0082\u0001\u0013\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Lcom/sourcepoint/cmplibrary/exception/ConsentLibExceptionK;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "isConsumed", "", "description", "", "cause", "", "(ZLjava/lang/String;Ljava/lang/Throwable;)V", "code", "Lcom/sourcepoint/cmplibrary/exception/ExceptionCodes;", "getCode-vXYB1G0", "()Ljava/lang/String;", "getDescription", "()Z", "setConsumed", "(Z)V", "Lcom/sourcepoint/cmplibrary/exception/ChildPmIdNotFound;", "Lcom/sourcepoint/cmplibrary/exception/ConnectionTimeoutException;", "Lcom/sourcepoint/cmplibrary/exception/ExecutionInTheWrongThreadException;", "Lcom/sourcepoint/cmplibrary/exception/GenericSDKException;", "Lcom/sourcepoint/cmplibrary/exception/InvalidApiResponseException;", "Lcom/sourcepoint/cmplibrary/exception/InvalidArgumentException;", "Lcom/sourcepoint/cmplibrary/exception/InvalidConsentResponse;", "Lcom/sourcepoint/cmplibrary/exception/InvalidRequestException;", "Lcom/sourcepoint/cmplibrary/exception/InvalidResponseNativeMessageException;", "Lcom/sourcepoint/cmplibrary/exception/InvalidResponseWebMessageException;", "Lcom/sourcepoint/cmplibrary/exception/MissingPropertyException;", "Lcom/sourcepoint/cmplibrary/exception/NoInternetConnectionException;", "Lcom/sourcepoint/cmplibrary/exception/RenderingAppConnectionTimeoutException;", "Lcom/sourcepoint/cmplibrary/exception/RenderingAppException;", "Lcom/sourcepoint/cmplibrary/exception/RequestFailedException;", "Lcom/sourcepoint/cmplibrary/exception/UnableToParseResponseException;", "Lcom/sourcepoint/cmplibrary/exception/UrlLoadingException;", "Lcom/sourcepoint/cmplibrary/exception/WebViewCreationException;", "Lcom/sourcepoint/cmplibrary/exception/WebViewException;", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ConsentLibExceptionK extends RuntimeException {
    private final String description;
    private boolean isConsumed;

    public /* synthetic */ ConsentLibExceptionK(boolean z, String str, Throwable th, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, th);
    }

    /* renamed from: getCode-vXYB1G0 */
    public abstract String mo9133getCodevXYB1G0();

    public /* synthetic */ ConsentLibExceptionK(boolean z, String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, str, (i & 4) != 0 ? null : th, null);
    }

    /* renamed from: isConsumed, reason: from getter */
    public final boolean getIsConsumed() {
        return this.isConsumed;
    }

    public final void setConsumed(boolean z) {
        this.isConsumed = z;
    }

    public final String getDescription() {
        return this.description;
    }

    private ConsentLibExceptionK(boolean z, String str, Throwable th) {
        super(str, th);
        this.isConsumed = z;
        this.description = str;
    }
}
