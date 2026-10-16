package io.bidmachine.analytics.internal;

import com.explorestack.protobuf.ByteString;
import com.explorestack.protobuf.BytesValue;
import io.bidmachine.analytics.internal.g0;
import io.bidmachine.analytics.internal.h0;
import java.io.File;
import java.io.FileInputStream;
import kotlin.io.CloseableKt;

/* renamed from: io.bidmachine.analytics.internal.y, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3584y implements g0.a {

    /* renamed from: a, reason: collision with root package name */
    private final File f6792a;

    public C3584y(File file) {
        this.f6792a = file;
    }

    @Override // io.bidmachine.analytics.internal.g0.a
    public BytesValue a(h0.a aVar) {
        BytesValue.Builder newBuilder = BytesValue.newBuilder();
        FileInputStream fileInputStream = new FileInputStream(new File(this.f6792a, s0.b(aVar.a())));
        try {
            ByteString readFrom = ByteString.readFrom(fileInputStream);
            CloseableKt.closeFinally(fileInputStream, null);
            return newBuilder.setValue(readFrom).build();
        } finally {
        }
    }
}
