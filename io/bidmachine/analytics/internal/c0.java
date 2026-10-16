package io.bidmachine.analytics.internal;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.BytesValue;
import io.bidmachine.analytics.internal.g0;
import io.bidmachine.analytics.internal.h0;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import kotlin.text.Charsets;

/* loaded from: classes7.dex */
public final class c0 implements g0.a {

    /* renamed from: a, reason: collision with root package name */
    private final e0 f6691a;

    public c0(e0 e0Var) {
        this.f6691a = e0Var;
    }

    @Override // io.bidmachine.analytics.internal.g0.a
    public BytesValue a(h0.a aVar) {
        C3574n a2 = this.f6691a.a();
        if (a2 == null) {
            throw new FileNotFoundException("No data received yet");
        }
        if (a2.f()) {
            throw new FileNotFoundException("Empty data");
        }
        return BytesValue.newBuilder().setValue(ByteString.readFrom(new ByteArrayInputStream(a2.toString().getBytes(Charsets.UTF_8)))).build();
    }
}
