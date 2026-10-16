package io.adn.sdk.internal.common.logger;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdLogEvent.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\f\r\u000eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t\u0082\u0001\u0003\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/adn/sdk/internal/common/logger/AdLogEvent;", "", "requestType", "", "getRequestType", "()Ljava/lang/String;", "requestStart", "", "getRequestStart", "()J", "duration", "getDuration", "Http", "Token", "LogMessage", "Lio/adn/sdk/internal/common/logger/AdLogEvent$Http;", "Lio/adn/sdk/internal/common/logger/AdLogEvent$LogMessage;", "Lio/adn/sdk/internal/common/logger/AdLogEvent$Token;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface AdLogEvent {
    long getDuration();

    long getRequestStart();

    String getRequestType();

    /* compiled from: AdLogEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÇ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H×\u0003J\t\u0010!\u001a\u00020\nH×\u0001J\t\u0010\"\u001a\u00020\u0003H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lio/adn/sdk/internal/common/logger/AdLogEvent$Http;", "Lio/adn/sdk/internal/common/logger/AdLogEvent;", "requestType", "", "requestStart", "", "duration", "url", "content", "statusCode", "", "<init>", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;I)V", "getRequestType", "()Ljava/lang/String;", "getRequestStart", "()J", "getDuration", "getUrl", "getContent", "getStatusCode", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Http implements AdLogEvent {
        public static final int $stable = 0;
        private final String content;
        private final long duration;
        private final long requestStart;
        private final String requestType;
        private final int statusCode;
        private final String url;

        public static /* synthetic */ Http copy$default(Http http, String str, long j, long j2, String str2, String str3, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = http.requestType;
            }
            if ((i2 & 2) != 0) {
                j = http.requestStart;
            }
            if ((i2 & 4) != 0) {
                j2 = http.duration;
            }
            if ((i2 & 8) != 0) {
                str2 = http.url;
            }
            if ((i2 & 16) != 0) {
                str3 = http.content;
            }
            if ((i2 & 32) != 0) {
                i = http.statusCode;
            }
            int i3 = i;
            String str4 = str2;
            long j3 = j2;
            return http.copy(str, j, j3, str4, str3, i3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getRequestType() {
            return this.requestType;
        }

        /* renamed from: component2, reason: from getter */
        public final long getRequestStart() {
            return this.requestStart;
        }

        /* renamed from: component3, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        /* renamed from: component4, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component5, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: component6, reason: from getter */
        public final int getStatusCode() {
            return this.statusCode;
        }

        public final Http copy(String requestType, long requestStart, long duration, String url, String content, int statusCode) {
            Intrinsics.checkNotNullParameter(requestType, "requestType");
            Intrinsics.checkNotNullParameter(url, "url");
            return new Http(requestType, requestStart, duration, url, content, statusCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Http)) {
                return false;
            }
            Http http = (Http) other;
            return Intrinsics.areEqual(this.requestType, http.requestType) && this.requestStart == http.requestStart && this.duration == http.duration && Intrinsics.areEqual(this.url, http.url) && Intrinsics.areEqual(this.content, http.content) && this.statusCode == http.statusCode;
        }

        public int hashCode() {
            int hashCode = ((((((this.requestType.hashCode() * 31) + Long.hashCode(this.requestStart)) * 31) + Long.hashCode(this.duration)) * 31) + this.url.hashCode()) * 31;
            String str = this.content;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.statusCode);
        }

        public String toString() {
            return "Http(requestType=" + this.requestType + ", requestStart=" + this.requestStart + ", duration=" + this.duration + ", url=" + this.url + ", content=" + this.content + ", statusCode=" + this.statusCode + ')';
        }

        public Http(String requestType, long j, long j2, String url, String str, int i) {
            Intrinsics.checkNotNullParameter(requestType, "requestType");
            Intrinsics.checkNotNullParameter(url, "url");
            this.requestType = requestType;
            this.requestStart = j;
            this.duration = j2;
            this.url = url;
            this.content = str;
            this.statusCode = i;
        }

        @Override // io.adn.sdk.internal.common.logger.AdLogEvent
        public String getRequestType() {
            return this.requestType;
        }

        @Override // io.adn.sdk.internal.common.logger.AdLogEvent
        public long getRequestStart() {
            return this.requestStart;
        }

        @Override // io.adn.sdk.internal.common.logger.AdLogEvent
        public long getDuration() {
            return this.duration;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getContent() {
            return this.content;
        }

        public final int getStatusCode() {
            return this.statusCode;
        }
    }

    /* compiled from: AdLogEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÇ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H×\u0003J\t\u0010\u0019\u001a\u00020\u001aH×\u0001J\t\u0010\u001b\u001a\u00020\u0006H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001c"}, d2 = {"Lio/adn/sdk/internal/common/logger/AdLogEvent$Token;", "Lio/adn/sdk/internal/common/logger/AdLogEvent;", "requestStart", "", "duration", "content", "", "requestType", "<init>", "(JJLjava/lang/String;Ljava/lang/String;)V", "getRequestStart", "()J", "getDuration", "getContent", "()Ljava/lang/String;", "getRequestType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Token implements AdLogEvent {
        public static final int $stable = 0;
        private final String content;
        private final long duration;
        private final long requestStart;
        private final String requestType;

        public static /* synthetic */ Token copy$default(Token token, long j, long j2, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = token.requestStart;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                j2 = token.duration;
            }
            long j4 = j2;
            if ((i & 4) != 0) {
                str = token.content;
            }
            String str3 = str;
            if ((i & 8) != 0) {
                str2 = token.requestType;
            }
            return token.copy(j3, j4, str3, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getRequestStart() {
            return this.requestStart;
        }

        /* renamed from: component2, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        /* renamed from: component3, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: component4, reason: from getter */
        public final String getRequestType() {
            return this.requestType;
        }

        public final Token copy(long requestStart, long duration, String content, String requestType) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(requestType, "requestType");
            return new Token(requestStart, duration, content, requestType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Token)) {
                return false;
            }
            Token token = (Token) other;
            return this.requestStart == token.requestStart && this.duration == token.duration && Intrinsics.areEqual(this.content, token.content) && Intrinsics.areEqual(this.requestType, token.requestType);
        }

        public int hashCode() {
            return (((((Long.hashCode(this.requestStart) * 31) + Long.hashCode(this.duration)) * 31) + this.content.hashCode()) * 31) + this.requestType.hashCode();
        }

        public String toString() {
            return "Token(requestStart=" + this.requestStart + ", duration=" + this.duration + ", content=" + this.content + ", requestType=" + this.requestType + ')';
        }

        public Token(long j, long j2, String content, String requestType) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(requestType, "requestType");
            this.requestStart = j;
            this.duration = j2;
            this.content = content;
            this.requestType = requestType;
        }

        @Override // io.adn.sdk.internal.common.logger.AdLogEvent
        public long getRequestStart() {
            return this.requestStart;
        }

        @Override // io.adn.sdk.internal.common.logger.AdLogEvent
        public long getDuration() {
            return this.duration;
        }

        public final String getContent() {
            return this.content;
        }

        public /* synthetic */ Token(long j, long j2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, str, (i & 8) != 0 ? "Token" : str2);
        }

        @Override // io.adn.sdk.internal.common.logger.AdLogEvent
        public String getRequestType() {
            return this.requestType;
        }
    }

    /* compiled from: AdLogEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÇ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H×\u0003J\t\u0010\u0019\u001a\u00020\u001aH×\u0001J\t\u0010\u001b\u001a\u00020\u0006H×\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001c"}, d2 = {"Lio/adn/sdk/internal/common/logger/AdLogEvent$LogMessage;", "Lio/adn/sdk/internal/common/logger/AdLogEvent;", "requestStart", "", "duration", PglCryptUtils.KEY_MESSAGE, "", "requestType", "<init>", "(JJLjava/lang/String;Ljava/lang/String;)V", "getRequestStart", "()J", "getDuration", "getMessage", "()Ljava/lang/String;", "getRequestType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class LogMessage implements AdLogEvent {
        public static final int $stable = 0;
        private final long duration;
        private final String message;
        private final long requestStart;
        private final String requestType;

        public static /* synthetic */ LogMessage copy$default(LogMessage logMessage, long j, long j2, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = logMessage.requestStart;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                j2 = logMessage.duration;
            }
            long j4 = j2;
            if ((i & 4) != 0) {
                str = logMessage.message;
            }
            String str3 = str;
            if ((i & 8) != 0) {
                str2 = logMessage.requestType;
            }
            return logMessage.copy(j3, j4, str3, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getRequestStart() {
            return this.requestStart;
        }

        /* renamed from: component2, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: component4, reason: from getter */
        public final String getRequestType() {
            return this.requestType;
        }

        public final LogMessage copy(long requestStart, long duration, String message, String requestType) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(requestType, "requestType");
            return new LogMessage(requestStart, duration, message, requestType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LogMessage)) {
                return false;
            }
            LogMessage logMessage = (LogMessage) other;
            return this.requestStart == logMessage.requestStart && this.duration == logMessage.duration && Intrinsics.areEqual(this.message, logMessage.message) && Intrinsics.areEqual(this.requestType, logMessage.requestType);
        }

        public int hashCode() {
            return (((((Long.hashCode(this.requestStart) * 31) + Long.hashCode(this.duration)) * 31) + this.message.hashCode()) * 31) + this.requestType.hashCode();
        }

        public String toString() {
            return "LogMessage(requestStart=" + this.requestStart + ", duration=" + this.duration + ", message=" + this.message + ", requestType=" + this.requestType + ')';
        }

        public LogMessage(long j, long j2, String message, String requestType) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(requestType, "requestType");
            this.requestStart = j;
            this.duration = j2;
            this.message = message;
            this.requestType = requestType;
        }

        public /* synthetic */ LogMessage(long j, long j2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? System.currentTimeMillis() : j, (i & 2) != 0 ? 0L : j2, str, (i & 8) != 0 ? "Log" : str2);
        }

        @Override // io.adn.sdk.internal.common.logger.AdLogEvent
        public long getRequestStart() {
            return this.requestStart;
        }

        @Override // io.adn.sdk.internal.common.logger.AdLogEvent
        public long getDuration() {
            return this.duration;
        }

        public final String getMessage() {
            return this.message;
        }

        @Override // io.adn.sdk.internal.common.logger.AdLogEvent
        public String getRequestType() {
            return this.requestType;
        }
    }
}
