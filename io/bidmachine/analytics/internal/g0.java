package io.bidmachine.analytics.internal;

import com.explorestack.protobuf.BytesValue;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Timestamp;
import io.bidmachine.analytics.internal.h0;
import io.bidmachine.analytics.internal.q0;
import io.bidmachine.protobuf.sdk.Error;
import io.bidmachine.protobuf.sdk.Event;
import io.bidmachine.protobuf.sdk.Reader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes7.dex */
public final class g0 extends Y {
    private final String f;
    private final Struct g;
    private final List h;
    private final a i;

    public interface a {
        BytesValue a(h0.a aVar);
    }

    public /* synthetic */ g0(String str, String str2, Struct struct, List list, a aVar, p0 p0Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, struct, list, aVar, (i & 32) != 0 ? p0.g.a() : p0Var);
    }

    @Override // io.bidmachine.analytics.internal.Y
    public byte[] b() {
        Object next;
        Timestamp a2;
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Reader.Builder name = Reader.newBuilder().setName(this.f);
            List<h0> list = this.h;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (h0 h0Var : list) {
                Reader.Record.Builder rule = Reader.Record.newBuilder().setRule(Reader.Rule.newBuilder().setGeneralRule(Reader.Rule.GeneralRule.newBuilder().setTag(b0.a(h0Var.e().b())).setPath(b0.a(h0Var.e().a())).build()));
                q0 b = h0Var.b();
                if (b == null) {
                    try {
                        Result.Companion companion2 = Result.INSTANCE;
                        m10241constructorimpl = Result.m10241constructorimpl(rule.setRawData(this.i.a(h0Var.e())));
                    } catch (Throwable th) {
                        Result.Companion companion3 = Result.INSTANCE;
                        m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                    }
                    Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                    if (m10244exceptionOrNullimpl != null) {
                        b = new q0(this.f, m10244exceptionOrNullimpl instanceof FileNotFoundException ? q0.a.READER_NO_CONTENT : m10244exceptionOrNullimpl instanceof SecurityException ? q0.a.READER_NO_ACCESS : q0.a.READER_INVALID, s0.a(m10244exceptionOrNullimpl));
                    }
                }
                if (b != null) {
                    rule.setError(Error.newBuilder().setName(b.a()).setError(Error.Data.newBuilder().setCode(Z.a(b.c()).getNumber()).setDescription(b.b()).build()).build());
                }
                arrayList.add(rule.build());
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                name.addRecords((Reader.Record) it.next());
            }
            Iterator it2 = this.h.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    long f = ((h0) next).f();
                    do {
                        Object next2 = it2.next();
                        long f2 = ((h0) next2).f();
                        if (f < f2) {
                            next = next2;
                            f = f2;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next = null;
            }
            h0 h0Var2 = (h0) next;
            if (h0Var2 != null && (a2 = b0.a(h0Var2.f())) != null) {
                name.setTimestamp(a2);
            }
            return Event.newBuilder().setReader(name.build()).setExtrasPrivate(this.g).build().toByteArray();
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th2));
            return null;
        }
    }

    @Override // io.bidmachine.analytics.internal.Y
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public g0 a() {
        return this;
    }

    public g0(String str, String str2, Struct struct, List list, a aVar, p0 p0Var) {
        super(o0.Post, str, p0Var, null, 8, null);
        this.f = str2;
        this.g = struct;
        this.h = list;
        this.i = aVar;
    }
}
