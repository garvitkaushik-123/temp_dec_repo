package com.moloco.sdk.acm.http;

import io.ktor.http.HeadersBuilder;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {
    public final Function1<HeadersBuilder, Unit> a(final String str, final String str2, final String str3, final String str4, final String str5, final String str6) {
        return new Function1() { // from class: com.moloco.sdk.acm.http.a$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return a.a(str4, str5, str3, str, str6, str2, (HeadersBuilder) obj);
            }
        };
    }

    public static final Unit a(String str, String str2, String str3, String str4, String str5, String str6, HeadersBuilder headersBuilder) {
        Intrinsics.checkNotNullParameter(headersBuilder, "<this>");
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append("AppBundle/" + str + ';');
        }
        if (str2 != null) {
            sb.append("AppVersion/" + str2 + ';');
        }
        if (str3 != null) {
            sb.append("AppKey/" + str3 + ';');
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        StringBuilder sb3 = new StringBuilder();
        if (str4 != null) {
            sb3.append("SdkVersion/" + str4 + ';');
        }
        if (str5 != null) {
            sb3.append("Mediator/" + str5 + ';');
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "toString(...)");
        StringBuilder sb5 = new StringBuilder("OS/Android;");
        if (str6 != null) {
            sb5.append("osv/" + str6 + ';');
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "toString(...)");
        headersBuilder.append("X-Moloco-App-Info", sb2);
        headersBuilder.append("X-Moloco-Device-Info", sb6);
        headersBuilder.append("X-Moloco-SDK-Info", sb4);
        return Unit.INSTANCE;
    }
}
