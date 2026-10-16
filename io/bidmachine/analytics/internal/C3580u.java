package io.bidmachine.analytics.internal;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.BytesValue;
import io.bidmachine.analytics.internal.g0;
import io.bidmachine.analytics.internal.h0;
import java.io.FileInputStream;
import kotlin.io.CloseableKt;

/* renamed from: io.bidmachine.analytics.internal.u, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3580u implements g0.a {
    @Override // io.bidmachine.analytics.internal.g0.a
    public BytesValue a(h0.a aVar) {
        BytesValue.Builder newBuilder = BytesValue.newBuilder();
        FileInputStream fileInputStream = new FileInputStream(s0.b(aVar.a()));
        try {
            ByteString readFrom = ByteString.readFrom(fileInputStream);
            CloseableKt.closeFinally(fileInputStream, null);
            return newBuilder.setValue(readFrom).build();
        } finally {
        }
    }
}
