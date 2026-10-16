package io.bidmachine.util.network;

import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: StringResponseProcessor.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lio/bidmachine/util/network/StringResponseProcessor;", "Lio/bidmachine/util/network/ResponseProcessor;", "", "()V", "byteResponseProcessor", "Lio/bidmachine/util/network/ByteResponseProcessor;", "process", "urlConnection", "Ljava/net/URLConnection;", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class StringResponseProcessor implements ResponseProcessor<String> {
    private final ByteResponseProcessor byteResponseProcessor = new ByteResponseProcessor();

    @Override // io.bidmachine.util.network.ResponseProcessor
    public String process(URLConnection urlConnection) {
        Intrinsics.checkNotNullParameter(urlConnection, "urlConnection");
        return StringsKt.decodeToString(this.byteResponseProcessor.process(urlConnection));
    }
}
