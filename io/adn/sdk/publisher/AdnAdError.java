package io.adn.sdk.publisher;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.ads.core.domain.AndroidInitializeBoldSDK;
import io.adn.sdk.internal.domain.error.AdError;
import kotlin.Metadata;

/* compiled from: AdnAdError.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0007\n\u000b\f\r\u000e\u000f\u0010R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0001\u0007\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lio/adn/sdk/publisher/AdnAdError;", "", IronSourceConstants.EVENTS_ERROR_CODE, "", "getErrorCode", "()I", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "SdkNotInitialized", "SdkInitFailure", AndroidInitializeBoldSDK.MSG_TIMEOUT, "BadRequest", "ServerError", "NoFill", "InternalError", "Lio/adn/sdk/publisher/AdnAdError$BadRequest;", "Lio/adn/sdk/publisher/AdnAdError$InternalError;", "Lio/adn/sdk/publisher/AdnAdError$NoFill;", "Lio/adn/sdk/publisher/AdnAdError$SdkInitFailure;", "Lio/adn/sdk/publisher/AdnAdError$SdkNotInitialized;", "Lio/adn/sdk/publisher/AdnAdError$ServerError;", "Lio/adn/sdk/publisher/AdnAdError$Timeout;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdnAdError {
    int getErrorCode();

    String getErrorMessage();

    /* compiled from: AdnAdError.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH×\u0003J\t\u0010\u0010\u001a\u00020\u0005H×\u0001J\t\u0010\u0011\u001a\u00020\tH×\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/publisher/AdnAdError$SdkNotInitialized;", "Lio/adn/sdk/publisher/AdnAdError;", "<init>", "()V", IronSourceConstants.EVENTS_ERROR_CODE, "", "getErrorCode", "()I", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class SdkNotInitialized implements AdnAdError {
        public static final int $stable = 0;
        public static final SdkNotInitialized INSTANCE = new SdkNotInitialized();
        private static final int errorCode = AdError.SdkNotInit.getCode();
        private static final String errorMessage = "Sdk Not Initialized";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SdkNotInitialized)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 627749432;
        }

        public String toString() {
            return "SdkNotInitialized";
        }

        private SdkNotInitialized() {
        }

        @Override // io.adn.sdk.publisher.AdnAdError
        public int getErrorCode() {
            return errorCode;
        }

        @Override // io.adn.sdk.publisher.AdnAdError
        public String getErrorMessage() {
            return errorMessage;
        }
    }

    /* compiled from: AdnAdError.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH×\u0003J\t\u0010\u0010\u001a\u00020\u0005H×\u0001J\t\u0010\u0011\u001a\u00020\tH×\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/publisher/AdnAdError$SdkInitFailure;", "Lio/adn/sdk/publisher/AdnAdError;", "<init>", "()V", IronSourceConstants.EVENTS_ERROR_CODE, "", "getErrorCode", "()I", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class SdkInitFailure implements AdnAdError {
        public static final int $stable = 0;
        public static final SdkInitFailure INSTANCE = new SdkInitFailure();
        private static final int errorCode = AdError.SdkInitError.getCode();
        private static final String errorMessage = "Sdk Init Failure";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SdkInitFailure)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1637198461;
        }

        public String toString() {
            return "SdkInitFailure";
        }

        private SdkInitFailure() {
        }

        @Override // io.adn.sdk.publisher.AdnAdError
        public int getErrorCode() {
            return errorCode;
        }

        @Override // io.adn.sdk.publisher.AdnAdError
        public String getErrorMessage() {
            return errorMessage;
        }
    }

    /* compiled from: AdnAdError.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH×\u0003J\t\u0010\u0010\u001a\u00020\u0005H×\u0001J\t\u0010\u0011\u001a\u00020\tH×\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/publisher/AdnAdError$Timeout;", "Lio/adn/sdk/publisher/AdnAdError;", "<init>", "()V", IronSourceConstants.EVENTS_ERROR_CODE, "", "getErrorCode", "()I", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Timeout implements AdnAdError {
        public static final int $stable = 0;
        public static final Timeout INSTANCE = new Timeout();
        private static final int errorCode = AdError.LoadTimeout.getCode();
        private static final String errorMessage = "Request Timed Out";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Timeout)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -582855938;
        }

        public String toString() {
            return AndroidInitializeBoldSDK.MSG_TIMEOUT;
        }

        private Timeout() {
        }

        @Override // io.adn.sdk.publisher.AdnAdError
        public int getErrorCode() {
            return errorCode;
        }

        @Override // io.adn.sdk.publisher.AdnAdError
        public String getErrorMessage() {
            return errorMessage;
        }
    }

    /* compiled from: AdnAdError.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH×\u0003J\t\u0010\u0010\u001a\u00020\u0005H×\u0001J\t\u0010\u0011\u001a\u00020\tH×\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/publisher/AdnAdError$BadRequest;", "Lio/adn/sdk/publisher/AdnAdError;", "<init>", "()V", IronSourceConstants.EVENTS_ERROR_CODE, "", "getErrorCode", "()I", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class BadRequest implements AdnAdError {
        public static final int $stable = 0;
        public static final BadRequest INSTANCE = new BadRequest();
        private static final int errorCode = AdError.BadRequest.getCode();
        private static final String errorMessage = "Bad Request";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BadRequest)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1264408563;
        }

        public String toString() {
            return "BadRequest";
        }

        private BadRequest() {
        }

        @Override // io.adn.sdk.publisher.AdnAdError
        public int getErrorCode() {
            return errorCode;
        }

        @Override // io.adn.sdk.publisher.AdnAdError
        public String getErrorMessage() {
            return errorMessage;
        }
    }

    /* compiled from: AdnAdError.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH×\u0003J\t\u0010\u0010\u001a\u00020\u0005H×\u0001J\t\u0010\u0011\u001a\u00020\tH×\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/publisher/AdnAdError$ServerError;", "Lio/adn/sdk/publisher/AdnAdError;", "<init>", "()V", IronSourceConstants.EVENTS_ERROR_CODE, "", "getErrorCode", "()I", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ServerError implements AdnAdError {
        public static final int $stable = 0;
        public static final ServerError INSTANCE = new ServerError();
        private static final int errorCode = AdError.HttpRequestError.getCode();
        private static final String errorMessage = "Server Error";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ServerError)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1250341794;
        }

        public String toString() {
            return "ServerError";
        }

        private ServerError() {
        }

        @Override // io.adn.sdk.publisher.AdnAdError
        public int getErrorCode() {
            return errorCode;
        }

        @Override // io.adn.sdk.publisher.AdnAdError
        public String getErrorMessage() {
            return errorMessage;
        }
    }

    /* compiled from: AdnAdError.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH×\u0003J\t\u0010\u0010\u001a\u00020\u0005H×\u0001J\t\u0010\u0011\u001a\u00020\tH×\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/publisher/AdnAdError$NoFill;", "Lio/adn/sdk/publisher/AdnAdError;", "<init>", "()V", IronSourceConstants.EVENTS_ERROR_CODE, "", "getErrorCode", "()I", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class NoFill implements AdnAdError {
        public static final int $stable = 0;
        public static final NoFill INSTANCE = new NoFill();
        private static final int errorCode = AdError.NoFillError.getCode();
        private static final String errorMessage = "No Fill";

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NoFill)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -2125856345;
        }

        public String toString() {
            return "NoFill";
        }

        private NoFill() {
        }

        @Override // io.adn.sdk.publisher.AdnAdError
        public int getErrorCode() {
            return errorCode;
        }

        @Override // io.adn.sdk.publisher.AdnAdError
        public String getErrorMessage() {
            return errorMessage;
        }
    }

    /* compiled from: AdnAdError.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H×\u0003J\t\u0010\u0013\u001a\u00020\u0003H×\u0001J\t\u0010\u0014\u001a\u00020\nH×\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/publisher/AdnAdError$InternalError;", "Lio/adn/sdk/publisher/AdnAdError;", "internalErrorCode", "", "<init>", "(I)V", IronSourceConstants.EVENTS_ERROR_CODE, "getErrorCode", "()I", "errorMessage", "", "getErrorMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class InternalError implements AdnAdError {
        public static final int $stable = 0;
        private final int errorCode;
        private final String errorMessage = "Internal Error";
        private final int internalErrorCode;

        /* renamed from: component1, reason: from getter */
        private final int getInternalErrorCode() {
            return this.internalErrorCode;
        }

        public static /* synthetic */ InternalError copy$default(InternalError internalError, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = internalError.internalErrorCode;
            }
            return internalError.copy(i);
        }

        public final InternalError copy(int internalErrorCode) {
            return new InternalError(internalErrorCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof InternalError) && this.internalErrorCode == ((InternalError) other).internalErrorCode;
        }

        public int hashCode() {
            return Integer.hashCode(this.internalErrorCode);
        }

        public String toString() {
            return "InternalError(internalErrorCode=" + this.internalErrorCode + ')';
        }

        public InternalError(int i) {
            this.internalErrorCode = i;
            this.errorCode = i;
        }

        @Override // io.adn.sdk.publisher.AdnAdError
        public int getErrorCode() {
            return this.errorCode;
        }

        @Override // io.adn.sdk.publisher.AdnAdError
        public String getErrorMessage() {
            return this.errorMessage;
        }
    }
}
