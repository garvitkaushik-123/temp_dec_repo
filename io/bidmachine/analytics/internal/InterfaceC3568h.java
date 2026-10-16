package io.bidmachine.analytics.internal;

import io.bidmachine.analytics.ReaderConfig;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: io.bidmachine.analytics.internal.h, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public interface InterfaceC3568h {
    void a(List list);

    /* renamed from: io.bidmachine.analytics.internal.h$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final ReaderConfig.Rule f6699a;
        private final String b;
        private final q0 c;

        public a(ReaderConfig.Rule rule, String str, q0 q0Var) {
            this.f6699a = rule;
            this.b = str;
            this.c = q0Var;
        }

        public final String a() {
            return this.b;
        }

        public final q0 b() {
            return this.c;
        }

        public final ReaderConfig.Rule c() {
            return this.f6699a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.f6699a, aVar.f6699a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c);
        }

        public int hashCode() {
            int hashCode = this.f6699a.hashCode() * 31;
            String str = this.b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            q0 q0Var = this.c;
            return hashCode2 + (q0Var != null ? q0Var.hashCode() : 0);
        }

        public String toString() {
            return "Data(rule=" + this.f6699a + ", dataHash=" + this.b + ", error=" + this.c + ')';
        }

        public /* synthetic */ a(ReaderConfig.Rule rule, String str, q0 q0Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(rule, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : q0Var);
        }
    }
}
