package io.bidmachine.analytics.internal;

import com.explorestack.protobuf.BytesValue;
import io.bidmachine.analytics.internal.F;
import io.bidmachine.analytics.internal.g0;
import io.bidmachine.analytics.internal.h0;
import io.bidmachine.protobuf.sdk.OSLog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.text.Charsets;

/* loaded from: classes7.dex */
public final class E implements g0.a {

    /* renamed from: a, reason: collision with root package name */
    private final J f6654a;
    private final F b = new F();

    public E(J j) {
        this.f6654a = j;
    }

    @Override // io.bidmachine.analytics.internal.g0.a
    public BytesValue a(h0.a aVar) {
        ArrayList arrayList = new ArrayList();
        InputStream a2 = this.f6654a.a(aVar.a());
        if (a2 != null) {
            Reader inputStreamReader = new InputStreamReader(a2, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                Iterator<String> it = TextStreamsKt.lineSequence(bufferedReader).iterator();
                while (it.hasNext()) {
                    F.b a3 = this.b.a(it.next());
                    if (a3 != null) {
                        arrayList.add(OSLog.Record.newBuilder().setTimestamp(b0.a(a3.d())).setTag(a3.c()).setLevel(a3.a()).setMessage(a3.b()).setSource("").build());
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedReader, null);
            } finally {
            }
        }
        if (arrayList.isEmpty()) {
            throw new FileNotFoundException("No records found");
        }
        return BytesValue.newBuilder().setValue(OSLog.newBuilder().addAllRecords(arrayList).build().toByteString()).build();
    }
}
