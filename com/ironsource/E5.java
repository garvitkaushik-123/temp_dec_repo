package com.ironsource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes6.dex */
public interface E5<T> {

    public static final class a<T> implements E5<T> {

        /* renamed from: a, reason: collision with root package name */
        private final ArrayList<T> f2838a;
        private final ArrayList<T> b;

        public a(ArrayList<T> a2, ArrayList<T> b) {
            Intrinsics.checkNotNullParameter(a2, "a");
            Intrinsics.checkNotNullParameter(b, "b");
            this.f2838a = a2;
            this.b = b;
        }

        @Override // com.ironsource.E5
        public boolean contains(T t) {
            return this.f2838a.contains(t) || this.b.contains(t);
        }

        @Override // com.ironsource.E5
        public int size() {
            return this.f2838a.size() + this.b.size();
        }

        @Override // com.ironsource.E5
        public List<T> value() {
            return CollectionsKt.plus((Collection) this.f2838a, (Iterable) this.b);
        }
    }

    public static final class b<T> implements E5<T> {

        /* renamed from: a, reason: collision with root package name */
        private final E5<T> f2839a;
        private final Comparator<T> b;

        public b(E5<T> collection, Comparator<T> comparator) {
            Intrinsics.checkNotNullParameter(collection, "collection");
            Intrinsics.checkNotNullParameter(comparator, "comparator");
            this.f2839a = collection;
            this.b = comparator;
        }

        @Override // com.ironsource.E5
        public boolean contains(T t) {
            return this.f2839a.contains(t);
        }

        @Override // com.ironsource.E5
        public int size() {
            return this.f2839a.size();
        }

        @Override // com.ironsource.E5
        public List<T> value() {
            return CollectionsKt.sortedWith(this.f2839a.value(), this.b);
        }
    }

    public static final class c<T> implements E5<T> {

        /* renamed from: a, reason: collision with root package name */
        private final int f2840a;
        private final List<T> b;

        public c(E5<T> collection, int i) {
            Intrinsics.checkNotNullParameter(collection, "collection");
            this.f2840a = i;
            this.b = collection.value();
        }

        public final List<T> a() {
            int size = this.b.size();
            int i = this.f2840a;
            if (size <= i) {
                return CollectionsKt.emptyList();
            }
            List<T> list = this.b;
            return list.subList(i, list.size());
        }

        public final List<T> b() {
            List<T> list = this.b;
            return list.subList(0, RangesKt.coerceAtMost(list.size(), this.f2840a));
        }

        @Override // com.ironsource.E5
        public boolean contains(T t) {
            return this.b.contains(t);
        }

        @Override // com.ironsource.E5
        public int size() {
            return this.b.size();
        }

        @Override // com.ironsource.E5
        public List<T> value() {
            return this.b;
        }
    }

    boolean contains(T t);

    int size();

    List<T> value();
}
