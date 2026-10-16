package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.C3207n2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public interface a {

    /* renamed from: com.ironsource.mediationsdk.demandOnly.a$a, reason: collision with other inner class name */
    public static final class C0296a implements a {

        /* renamed from: a, reason: collision with root package name */
        private final List<C3207n2> f3508a;

        /* JADX WARN: Multi-variable type inference failed */
        public C0296a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Override // com.ironsource.mediationsdk.demandOnly.a
        public C3207n2 a(String instanceName) {
            Object obj;
            Intrinsics.checkNotNullParameter(instanceName, "instanceName");
            Iterator<T> it = this.f3508a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((C3207n2) obj).c(), instanceName)) {
                    break;
                }
            }
            return (C3207n2) obj;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.a
        public String b() {
            if (this.f3508a.isEmpty()) {
                return "";
            }
            return "1" + ((C3207n2) CollectionsKt.first((List) this.f3508a)).c();
        }

        @Override // com.ironsource.mediationsdk.demandOnly.a
        public C3207n2 get(int i) {
            if (i < 0 || i >= this.f3508a.size()) {
                return null;
            }
            return this.f3508a.get(i);
        }

        @Override // com.ironsource.mediationsdk.demandOnly.a
        public boolean isEmpty() {
            return this.f3508a.isEmpty();
        }

        public C0296a(List<C3207n2> waterfall) {
            Intrinsics.checkNotNullParameter(waterfall, "waterfall");
            this.f3508a = waterfall;
        }

        @Override // com.ironsource.mediationsdk.demandOnly.a
        public List<C3207n2> a() {
            return this.f3508a;
        }

        public /* synthetic */ C0296a(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ArrayList() : list);
        }
    }

    C3207n2 a(String str);

    List<C3207n2> a();

    String b();

    C3207n2 get(int i);

    boolean isEmpty();
}
