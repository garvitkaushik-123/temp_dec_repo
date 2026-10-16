package io.ktor.http;

import androidx.autofill.HintConstants;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: Url.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b,\u0018\u0000 ;2\u00020\u0001:\u0001;Ba\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012J\u0013\u00107\u001a\u00020\u00102\b\u00108\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00109\u001a\u00020\u0007H\u0016J\b\u0010:\u001a\u00020\u0005H\u0016R\u001b\u0010\u0013\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u0019\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001c\u0010\u0015R\u001b\u0010\u001e\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0017\u001a\u0004\b\u001f\u0010\u0015R\u001b\u0010!\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b\"\u0010\u0015R\u001d\u0010$\u001a\u0004\u0018\u00010\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0017\u001a\u0004\b%\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0015R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010.\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u00100R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0015¨\u0006<"}, d2 = {"Lio/ktor/http/Url;", "", "protocol", "Lio/ktor/http/URLProtocol;", "host", "", "specifiedPort", "", "pathSegments", "", "parameters", "Lio/ktor/http/Parameters;", "fragment", AnalyticsConstants.SOURCE_USER_TYPE, HintConstants.AUTOFILL_HINT_PASSWORD, "trailingQuery", "", "urlString", "(Lio/ktor/http/URLProtocol;Ljava/lang/String;ILjava/util/List;Lio/ktor/http/Parameters;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "encodedFragment", "getEncodedFragment", "()Ljava/lang/String;", "encodedFragment$delegate", "Lkotlin/Lazy;", "encodedPassword", "getEncodedPassword", "encodedPassword$delegate", "encodedPath", "getEncodedPath", "encodedPath$delegate", "encodedPathAndQuery", "getEncodedPathAndQuery", "encodedPathAndQuery$delegate", "encodedQuery", "getEncodedQuery", "encodedQuery$delegate", "encodedUser", "getEncodedUser", "encodedUser$delegate", "getFragment", "getHost", "getParameters", "()Lio/ktor/http/Parameters;", "getPassword", "getPathSegments", "()Ljava/util/List;", "port", "getPort", "()I", "getProtocol", "()Lio/ktor/http/URLProtocol;", "getSpecifiedPort", "getTrailingQuery", "()Z", "getUser", "equals", "other", "hashCode", "toString", "Companion", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class Url {

    /* renamed from: encodedFragment$delegate, reason: from kotlin metadata */
    private final Lazy encodedFragment;

    /* renamed from: encodedPassword$delegate, reason: from kotlin metadata */
    private final Lazy encodedPassword;

    /* renamed from: encodedPath$delegate, reason: from kotlin metadata */
    private final Lazy encodedPath;

    /* renamed from: encodedPathAndQuery$delegate, reason: from kotlin metadata */
    private final Lazy encodedPathAndQuery;

    /* renamed from: encodedQuery$delegate, reason: from kotlin metadata */
    private final Lazy encodedQuery;

    /* renamed from: encodedUser$delegate, reason: from kotlin metadata */
    private final Lazy encodedUser;
    private final String fragment;
    private final String host;
    private final Parameters parameters;
    private final String password;
    private final List<String> pathSegments;
    private final URLProtocol protocol;
    private final int specifiedPort;
    private final boolean trailingQuery;
    private final String urlString;
    private final String user;

    public Url(URLProtocol protocol, String host, int i, List<String> pathSegments, Parameters parameters, String fragment, String str, String str2, boolean z, String urlString) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(urlString, "urlString");
        this.protocol = protocol;
        this.host = host;
        this.specifiedPort = i;
        this.pathSegments = pathSegments;
        this.parameters = parameters;
        this.fragment = fragment;
        this.user = str;
        this.password = str2;
        this.trailingQuery = z;
        this.urlString = urlString;
        if ((i < 0 || i >= 65536) && i != 0) {
            throw new IllegalArgumentException("port must be between 0 and 65535, or 0 if not set".toString());
        }
        this.encodedPath = LazyKt.lazy(new Function0<String>() { // from class: io.ktor.http.Url$encodedPath$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str3;
                String str4;
                String str5;
                String str6;
                if (Url.this.getPathSegments().isEmpty()) {
                    return "";
                }
                str3 = Url.this.urlString;
                int indexOf$default = StringsKt.indexOf$default((CharSequence) str3, '/', Url.this.getProtocol().getName().length() + 3, false, 4, (Object) null);
                if (indexOf$default == -1) {
                    return "";
                }
                str4 = Url.this.urlString;
                int indexOfAny$default = StringsKt.indexOfAny$default((CharSequence) str4, new char[]{'?', '#'}, indexOf$default, false, 4, (Object) null);
                if (indexOfAny$default == -1) {
                    str6 = Url.this.urlString;
                    String substring = str6.substring(indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    return substring;
                }
                str5 = Url.this.urlString;
                String substring2 = str5.substring(indexOf$default, indexOfAny$default);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                return substring2;
            }
        });
        this.encodedQuery = LazyKt.lazy(new Function0<String>() { // from class: io.ktor.http.Url$encodedQuery$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str3;
                String str4;
                String str5;
                String str6;
                str3 = Url.this.urlString;
                int indexOf$default = StringsKt.indexOf$default((CharSequence) str3, '?', 0, false, 6, (Object) null) + 1;
                if (indexOf$default != 0) {
                    str4 = Url.this.urlString;
                    int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str4, '#', indexOf$default, false, 4, (Object) null);
                    if (indexOf$default2 == -1) {
                        str6 = Url.this.urlString;
                        String substring = str6.substring(indexOf$default);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        return substring;
                    }
                    str5 = Url.this.urlString;
                    String substring2 = str5.substring(indexOf$default, indexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    return substring2;
                }
                return "";
            }
        });
        this.encodedPathAndQuery = LazyKt.lazy(new Function0<String>() { // from class: io.ktor.http.Url$encodedPathAndQuery$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str3;
                String str4;
                String str5;
                String str6;
                str3 = Url.this.urlString;
                int indexOf$default = StringsKt.indexOf$default((CharSequence) str3, '/', Url.this.getProtocol().getName().length() + 3, false, 4, (Object) null);
                if (indexOf$default != -1) {
                    str4 = Url.this.urlString;
                    int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str4, '#', indexOf$default, false, 4, (Object) null);
                    if (indexOf$default2 == -1) {
                        str6 = Url.this.urlString;
                        String substring = str6.substring(indexOf$default);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        return substring;
                    }
                    str5 = Url.this.urlString;
                    String substring2 = str5.substring(indexOf$default, indexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    return substring2;
                }
                return "";
            }
        });
        this.encodedUser = LazyKt.lazy(new Function0<String>() { // from class: io.ktor.http.Url$encodedUser$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str3;
                String str4;
                if (Url.this.getUser() == null) {
                    return null;
                }
                if (Url.this.getUser().length() == 0) {
                    return "";
                }
                int length = Url.this.getProtocol().getName().length() + 3;
                str3 = Url.this.urlString;
                int indexOfAny$default = StringsKt.indexOfAny$default((CharSequence) str3, new char[]{AbstractJsonLexerKt.COLON, '@'}, length, false, 4, (Object) null);
                str4 = Url.this.urlString;
                String substring = str4.substring(length, indexOfAny$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                return substring;
            }
        });
        this.encodedPassword = LazyKt.lazy(new Function0<String>() { // from class: io.ktor.http.Url$encodedPassword$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str3;
                String str4;
                String str5;
                if (Url.this.getPassword() == null) {
                    return null;
                }
                if (Url.this.getPassword().length() == 0) {
                    return "";
                }
                str3 = Url.this.urlString;
                int indexOf$default = StringsKt.indexOf$default((CharSequence) str3, AbstractJsonLexerKt.COLON, Url.this.getProtocol().getName().length() + 3, false, 4, (Object) null) + 1;
                str4 = Url.this.urlString;
                int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str4, '@', 0, false, 6, (Object) null);
                str5 = Url.this.urlString;
                String substring = str5.substring(indexOf$default, indexOf$default2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                return substring;
            }
        });
        this.encodedFragment = LazyKt.lazy(new Function0<String>() { // from class: io.ktor.http.Url$encodedFragment$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String str3;
                String str4;
                str3 = Url.this.urlString;
                int indexOf$default = StringsKt.indexOf$default((CharSequence) str3, '#', 0, false, 6, (Object) null) + 1;
                if (indexOf$default != 0) {
                    str4 = Url.this.urlString;
                    String substring = str4.substring(indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    return substring;
                }
                return "";
            }
        });
    }

    public final URLProtocol getProtocol() {
        return this.protocol;
    }

    public final String getHost() {
        return this.host;
    }

    public final int getSpecifiedPort() {
        return this.specifiedPort;
    }

    public final List<String> getPathSegments() {
        return this.pathSegments;
    }

    public final Parameters getParameters() {
        return this.parameters;
    }

    public final String getFragment() {
        return this.fragment;
    }

    public final String getUser() {
        return this.user;
    }

    public final String getPassword() {
        return this.password;
    }

    public final boolean getTrailingQuery() {
        return this.trailingQuery;
    }

    public final int getPort() {
        Integer valueOf = Integer.valueOf(this.specifiedPort);
        if (valueOf.intValue() == 0) {
            valueOf = null;
        }
        return valueOf != null ? valueOf.intValue() : this.protocol.getDefaultPort();
    }

    public final String getEncodedPath() {
        return (String) this.encodedPath.getValue();
    }

    public final String getEncodedQuery() {
        return (String) this.encodedQuery.getValue();
    }

    public final String getEncodedPathAndQuery() {
        return (String) this.encodedPathAndQuery.getValue();
    }

    public final String getEncodedUser() {
        return (String) this.encodedUser.getValue();
    }

    public final String getEncodedPassword() {
        return (String) this.encodedPassword.getValue();
    }

    public final String getEncodedFragment() {
        return (String) this.encodedFragment.getValue();
    }

    /* renamed from: toString, reason: from getter */
    public String getUrlString() {
        return this.urlString;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return other != null && getClass() == other.getClass() && Intrinsics.areEqual(this.urlString, ((Url) other).urlString);
    }

    public int hashCode() {
        return this.urlString.hashCode();
    }
}
