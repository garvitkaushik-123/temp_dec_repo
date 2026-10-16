package io.ktor.http;

import androidx.autofill.HintConstants;
import com.ironsource.C3040d4;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: URLBuilder.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 G2\u00020\u0001:\u0001GBi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\b\u0010A\u001a\u00020BH\u0002J\u0006\u0010C\u001a\u00020DJ\u0006\u0010E\u001a\u00020\u0005J\b\u0010F\u001a\u00020\u0005H\u0016R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u0016R\u001e\u0010\f\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR(\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R0\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010#\"\u0004\b2\u0010%R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R(\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00058F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010\u0014\"\u0004\b@\u0010\u0016¨\u0006H"}, d2 = {"Lio/ktor/http/URLBuilder;", "", "protocol", "Lio/ktor/http/URLProtocol;", "host", "", "port", "", AnalyticsConstants.SOURCE_USER_TYPE, HintConstants.AUTOFILL_HINT_PASSWORD, "pathSegments", "", "parameters", "Lio/ktor/http/Parameters;", "fragment", "trailingQuery", "", "(Lio/ktor/http/URLProtocol;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lio/ktor/http/Parameters;Ljava/lang/String;Z)V", "encodedFragment", "getEncodedFragment", "()Ljava/lang/String;", "setEncodedFragment", "(Ljava/lang/String;)V", "value", "Lio/ktor/http/ParametersBuilder;", "encodedParameters", "getEncodedParameters", "()Lio/ktor/http/ParametersBuilder;", "setEncodedParameters", "(Lio/ktor/http/ParametersBuilder;)V", "encodedPassword", "getEncodedPassword", "setEncodedPassword", "encodedPathSegments", "getEncodedPathSegments", "()Ljava/util/List;", "setEncodedPathSegments", "(Ljava/util/List;)V", "encodedUser", "getEncodedUser", "setEncodedUser", "getFragment", "setFragment", "getHost", "setHost", "<set-?>", "getParameters", "getPassword", "setPassword", "getPathSegments", "setPathSegments", "getPort", "()I", "setPort", "(I)V", "getProtocol", "()Lio/ktor/http/URLProtocol;", "setProtocol", "(Lio/ktor/http/URLProtocol;)V", "getTrailingQuery", "()Z", "setTrailingQuery", "(Z)V", "getUser", "setUser", "applyOrigin", "", "build", "Lio/ktor/http/Url;", "buildString", "toString", "Companion", "ktor-http"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class URLBuilder {
    private static final Url originUrl;
    private String encodedFragment;
    private ParametersBuilder encodedParameters;
    private String encodedPassword;
    private List<String> encodedPathSegments;
    private String encodedUser;
    private String host;
    private ParametersBuilder parameters;
    private int port;
    private URLProtocol protocol;
    private boolean trailingQuery;

    public URLBuilder() {
        this(null, null, 0, null, null, null, null, null, false, 511, null);
    }

    public URLBuilder(URLProtocol protocol, String host, int i, String str, String str2, List<String> pathSegments, Parameters parameters, String fragment, boolean z) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.protocol = protocol;
        this.host = host;
        this.port = i;
        this.trailingQuery = z;
        this.encodedUser = str != null ? CodecsKt.encodeURLParameter$default(str, false, 1, null) : null;
        this.encodedPassword = str2 != null ? CodecsKt.encodeURLParameter$default(str2, false, 1, null) : null;
        this.encodedFragment = CodecsKt.encodeURLQueryComponent$default(fragment, false, false, null, 7, null);
        List<String> list = pathSegments;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CodecsKt.encodeURLPathPart((String) it.next()));
        }
        this.encodedPathSegments = arrayList;
        this.encodedParameters = UrlDecodedParametersBuilderKt.encodeParameters(parameters);
        this.parameters = new UrlDecodedParametersBuilder(this.encodedParameters);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ URLBuilder(io.ktor.http.URLProtocol r4, java.lang.String r5, int r6, java.lang.String r7, java.lang.String r8, java.util.List r9, io.ktor.http.Parameters r10, java.lang.String r11, boolean r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r3 = this;
            r14 = r13 & 1
            if (r14 == 0) goto La
            io.ktor.http.URLProtocol$Companion r4 = io.ktor.http.URLProtocol.INSTANCE
            io.ktor.http.URLProtocol r4 = r4.getHTTP()
        La:
            r14 = r13 & 2
            java.lang.String r0 = ""
            if (r14 == 0) goto L11
            r5 = r0
        L11:
            r14 = r13 & 4
            r1 = 0
            if (r14 == 0) goto L17
            r6 = r1
        L17:
            r14 = r13 & 8
            r2 = 0
            if (r14 == 0) goto L1d
            r7 = r2
        L1d:
            r14 = r13 & 16
            if (r14 == 0) goto L22
            r8 = r2
        L22:
            r14 = r13 & 32
            if (r14 == 0) goto L2a
            java.util.List r9 = kotlin.collections.CollectionsKt.emptyList()
        L2a:
            r14 = r13 & 64
            if (r14 == 0) goto L34
            io.ktor.http.Parameters$Companion r10 = io.ktor.http.Parameters.INSTANCE
            io.ktor.http.Parameters r10 = r10.getEmpty()
        L34:
            r14 = r13 & 128(0x80, float:1.8E-43)
            if (r14 == 0) goto L39
            r11 = r0
        L39:
            r13 = r13 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L48
            r14 = r1
            r12 = r10
            r13 = r11
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r5 = r3
            goto L52
        L48:
            r14 = r12
            r13 = r11
            r11 = r9
            r12 = r10
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
        L52:
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.URLBuilder.<init>(io.ktor.http.URLProtocol, java.lang.String, int, java.lang.String, java.lang.String, java.util.List, io.ktor.http.Parameters, java.lang.String, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final URLProtocol getProtocol() {
        return this.protocol;
    }

    public final void setProtocol(URLProtocol uRLProtocol) {
        Intrinsics.checkNotNullParameter(uRLProtocol, "<set-?>");
        this.protocol = uRLProtocol;
    }

    public final String getHost() {
        return this.host;
    }

    public final void setHost(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.host = str;
    }

    public final int getPort() {
        return this.port;
    }

    public final void setPort(int i) {
        this.port = i;
    }

    public final boolean getTrailingQuery() {
        return this.trailingQuery;
    }

    public final void setTrailingQuery(boolean z) {
        this.trailingQuery = z;
    }

    public final String getEncodedUser() {
        return this.encodedUser;
    }

    public final void setEncodedUser(String str) {
        this.encodedUser = str;
    }

    public final String getUser() {
        String str = this.encodedUser;
        if (str != null) {
            return CodecsKt.decodeURLPart$default(str, 0, 0, null, 7, null);
        }
        return null;
    }

    public final void setUser(String str) {
        this.encodedUser = str != null ? CodecsKt.encodeURLParameter$default(str, false, 1, null) : null;
    }

    public final String getEncodedPassword() {
        return this.encodedPassword;
    }

    public final void setEncodedPassword(String str) {
        this.encodedPassword = str;
    }

    public final String getPassword() {
        String str = this.encodedPassword;
        if (str != null) {
            return CodecsKt.decodeURLPart$default(str, 0, 0, null, 7, null);
        }
        return null;
    }

    public final void setPassword(String str) {
        this.encodedPassword = str != null ? CodecsKt.encodeURLParameter$default(str, false, 1, null) : null;
    }

    public final String getEncodedFragment() {
        return this.encodedFragment;
    }

    public final void setEncodedFragment(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.encodedFragment = str;
    }

    public final String getFragment() {
        return CodecsKt.decodeURLQueryComponent$default(this.encodedFragment, 0, 0, false, null, 15, null);
    }

    public final void setFragment(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.encodedFragment = CodecsKt.encodeURLQueryComponent$default(value, false, false, null, 7, null);
    }

    public final List<String> getEncodedPathSegments() {
        return this.encodedPathSegments;
    }

    public final void setEncodedPathSegments(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.encodedPathSegments = list;
    }

    public final List<String> getPathSegments() {
        List<String> list = this.encodedPathSegments;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CodecsKt.decodeURLPart$default((String) it.next(), 0, 0, null, 7, null));
        }
        return arrayList;
    }

    public final void setPathSegments(List<String> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        List<String> list = value;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CodecsKt.encodeURLPathPart((String) it.next()));
        }
        this.encodedPathSegments = arrayList;
    }

    public final ParametersBuilder getEncodedParameters() {
        return this.encodedParameters;
    }

    public final void setEncodedParameters(ParametersBuilder value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.encodedParameters = value;
        this.parameters = new UrlDecodedParametersBuilder(value);
    }

    public final ParametersBuilder getParameters() {
        return this.parameters;
    }

    public final String buildString() {
        Appendable appendTo;
        applyOrigin();
        appendTo = URLBuilderKt.appendTo(this, new StringBuilder(256));
        String sb = ((StringBuilder) appendTo).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "appendTo(StringBuilder(256)).toString()");
        return sb;
    }

    public String toString() {
        Appendable appendTo;
        appendTo = URLBuilderKt.appendTo(this, new StringBuilder(256));
        String sb = ((StringBuilder) appendTo).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "appendTo(StringBuilder(256)).toString()");
        return sb;
    }

    public final Url build() {
        applyOrigin();
        return new Url(this.protocol, this.host, this.port, getPathSegments(), this.parameters.build(), getFragment(), getUser(), getPassword(), this.trailingQuery, buildString());
    }

    private final void applyOrigin() {
        if (this.host.length() <= 0 && !Intrinsics.areEqual(this.protocol.getName(), C3040d4.h.b)) {
            Url url = originUrl;
            this.host = url.getHost();
            if (Intrinsics.areEqual(this.protocol, URLProtocol.INSTANCE.getHTTP())) {
                this.protocol = url.getProtocol();
            }
            if (this.port == 0) {
                this.port = url.getSpecifiedPort();
            }
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        originUrl = URLUtilsKt.Url(URLBuilderJvmKt.getOrigin(companion));
    }
}
