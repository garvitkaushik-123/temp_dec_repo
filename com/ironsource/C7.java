package com.ironsource;

import java.util.ArrayList;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public interface C7 {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final ArrayList<C3413z5> f2813a;
        private boolean b;
        private int c;
        private Exception d;

        public a(ArrayList<C3413z5> arrayList) {
            this.b = false;
            this.c = -1;
            this.f2813a = arrayList;
        }

        public a a(Exception exc) {
            return new a(this.f2813a, this.c, this.b, exc);
        }

        public ArrayList<C3413z5> b() {
            return this.f2813a;
        }

        public boolean c() {
            return this.b;
        }

        public String toString() {
            return "EventSendResult{success=" + this.b + ", responseCode=" + this.c + ", exception=" + this.d + AbstractJsonLexerKt.END_OBJ;
        }

        public a a(boolean z) {
            return new a(this.f2813a, this.c, z, this.d);
        }

        public a a(int i) {
            return new a(this.f2813a, i, this.b, this.d);
        }

        public String a() {
            return !this.b ? "rc=" + this.c + ", ex=" + this.d : "";
        }

        a(ArrayList<C3413z5> arrayList, int i, boolean z, Exception exc) {
            this.f2813a = arrayList;
            this.b = z;
            this.d = exc;
            this.c = i;
        }
    }

    void a(a aVar);
}
