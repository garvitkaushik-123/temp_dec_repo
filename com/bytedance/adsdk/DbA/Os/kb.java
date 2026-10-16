package com.bytedance.adsdk.DbA.Os;

import android.util.Pair;

/* loaded from: classes3.dex */
public class kb<T> {
    T DbA;
    T eli;

    public void eli(T t, T t2) {
        this.eli = t;
        this.DbA = t2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return DbA(pair.first, this.eli) && DbA(pair.second, this.DbA);
    }

    private static boolean DbA(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public int hashCode() {
        T t = this.eli;
        int hashCode = t == null ? 0 : t.hashCode();
        T t2 = this.DbA;
        return hashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.eli + " " + this.DbA + "}";
    }
}
