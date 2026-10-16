package com.bytedance.adsdk.DbA;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public final class eli<E> implements Collection<E>, Set<E> {
    private static int MGA;
    private static final int[] Os = new int[0];
    private static final Object[] aGH = new Object[0];
    private static Object[] kb;
    private static Object[] ui;
    private static int wC;
    int DbA;
    private int[] FC;
    private Dfc<E, E> aAs;
    Object[] eli;

    private int eli(Object obj, int i) {
        int i2 = this.DbA;
        if (i2 == 0) {
            return -1;
        }
        int eli = DbA.eli(this.FC, i2, i);
        if (eli < 0 || obj.equals(this.eli[eli])) {
            return eli;
        }
        int i3 = eli + 1;
        while (i3 < i2 && this.FC[i3] == i) {
            if (obj.equals(this.eli[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = eli - 1; i4 >= 0 && this.FC[i4] == i; i4--) {
            if (obj.equals(this.eli[i4])) {
                return i4;
            }
        }
        return ~i3;
    }

    private int eli() {
        int i = this.DbA;
        if (i == 0) {
            return -1;
        }
        int eli = DbA.eli(this.FC, i, 0);
        if (eli < 0 || this.eli[eli] == null) {
            return eli;
        }
        int i2 = eli + 1;
        while (i2 < i && this.FC[i2] == 0) {
            if (this.eli[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = eli - 1; i3 >= 0 && this.FC[i3] == 0; i3--) {
            if (this.eli[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    private void aGH(int i) {
        if (i == 8) {
            synchronized (eli.class) {
                Object[] objArr = kb;
                if (objArr != null) {
                    this.eli = objArr;
                    kb = (Object[]) objArr[0];
                    this.FC = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    wC--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (eli.class) {
                Object[] objArr2 = ui;
                if (objArr2 != null) {
                    this.eli = objArr2;
                    ui = (Object[]) objArr2[0];
                    this.FC = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    MGA--;
                    return;
                }
            }
        }
        this.FC = new int[i];
        this.eli = new Object[i];
    }

    private static void eli(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (eli.class) {
                if (wC < 10) {
                    objArr[0] = kb;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    kb = objArr;
                    wC++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (eli.class) {
                if (MGA < 10) {
                    objArr[0] = ui;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    ui = objArr;
                    MGA++;
                }
            }
        }
    }

    public eli() {
        this(0);
    }

    public eli(int i) {
        if (i == 0) {
            this.FC = Os;
            this.eli = aGH;
        } else {
            aGH(i);
        }
        this.DbA = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.DbA;
        if (i != 0) {
            eli(this.FC, this.eli, i);
            this.FC = Os;
            this.eli = aGH;
            this.DbA = 0;
        }
    }

    public void eli(int i) {
        int[] iArr = this.FC;
        if (iArr.length < i) {
            Object[] objArr = this.eli;
            aGH(i);
            int i2 = this.DbA;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.FC, 0, i2);
                System.arraycopy(objArr, 0, this.eli, 0, this.DbA);
            }
            eli(iArr, objArr, this.DbA);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return eli(obj) >= 0;
    }

    public int eli(Object obj) {
        return obj == null ? eli() : eli(obj, obj.hashCode());
    }

    public E DbA(int i) {
        return (E) this.eli[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.DbA <= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int eli;
        if (e == null) {
            eli = eli();
            i = 0;
        } else {
            int hashCode = e.hashCode();
            i = hashCode;
            eli = eli(e, hashCode);
        }
        if (eli >= 0) {
            return false;
        }
        int i2 = ~eli;
        int i3 = this.DbA;
        int[] iArr = this.FC;
        if (i3 >= iArr.length) {
            int i4 = 8;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i4 = 4;
            }
            Object[] objArr = this.eli;
            aGH(i4);
            int[] iArr2 = this.FC;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.eli, 0, objArr.length);
            }
            eli(iArr, objArr, this.DbA);
        }
        int i5 = this.DbA;
        if (i2 < i5) {
            int[] iArr3 = this.FC;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.eli;
            System.arraycopy(objArr2, i2, objArr2, i6, this.DbA - i2);
        }
        this.FC[i2] = i;
        this.eli[i2] = e;
        this.DbA++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int eli = eli(obj);
        if (eli < 0) {
            return false;
        }
        Os(eli);
        return true;
    }

    public E Os(int i) {
        Object[] objArr = this.eli;
        E e = (E) objArr[i];
        int i2 = this.DbA;
        if (i2 <= 1) {
            eli(this.FC, objArr, i2);
            this.FC = Os;
            this.eli = aGH;
            this.DbA = 0;
            return e;
        }
        int[] iArr = this.FC;
        if (iArr.length > 8 && i2 < iArr.length / 3) {
            aGH(i2 > 8 ? i2 + (i2 >> 1) : 8);
            this.DbA--;
            if (i > 0) {
                System.arraycopy(iArr, 0, this.FC, 0, i);
                System.arraycopy(objArr, 0, this.eli, 0, i);
            }
            int i3 = this.DbA;
            if (i < i3) {
                int i4 = i + 1;
                System.arraycopy(iArr, i4, this.FC, i, i3 - i);
                System.arraycopy(objArr, i4, this.eli, i, this.DbA - i);
            }
            return e;
        }
        int i5 = i2 - 1;
        this.DbA = i5;
        if (i < i5) {
            int i6 = i + 1;
            System.arraycopy(iArr, i6, iArr, i, i5 - i);
            Object[] objArr2 = this.eli;
            System.arraycopy(objArr2, i6, objArr2, i, this.DbA - i);
        }
        this.eli[this.DbA] = null;
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.DbA;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.DbA;
        Object[] objArr = new Object[i];
        System.arraycopy(this.eli, 0, objArr, 0, i);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.DbA) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.DbA));
        }
        System.arraycopy(this.eli, 0, tArr, 0, this.DbA);
        int length = tArr.length;
        int i = this.DbA;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.DbA; i++) {
                try {
                    if (!set.contains(DbA(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.FC;
        int i = this.DbA;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.DbA * 14);
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        for (int i = 0; i < this.DbA; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E DbA = DbA(i);
            if (DbA != this) {
                sb.append(DbA);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    private Dfc<E, E> DbA() {
        if (this.aAs == null) {
            this.aAs = new Dfc<E, E>() { // from class: com.bytedance.adsdk.DbA.eli.1
                @Override // com.bytedance.adsdk.DbA.Dfc
                protected int eli() {
                    return eli.this.DbA;
                }

                @Override // com.bytedance.adsdk.DbA.Dfc
                protected Object eli(int i, int i2) {
                    return eli.this.eli[i];
                }

                @Override // com.bytedance.adsdk.DbA.Dfc
                protected int eli(Object obj) {
                    return eli.this.eli(obj);
                }

                @Override // com.bytedance.adsdk.DbA.Dfc
                protected Map<E, E> DbA() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // com.bytedance.adsdk.DbA.Dfc
                protected void eli(int i) {
                    eli.this.Os(i);
                }

                @Override // com.bytedance.adsdk.DbA.Dfc
                protected void Os() {
                    eli.this.clear();
                }
            };
        }
        return this.aAs;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return DbA().aGH().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        eli(this.DbA + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= add(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.DbA - 1; i >= 0; i--) {
            if (!collection.contains(this.eli[i])) {
                Os(i);
                z = true;
            }
        }
        return z;
    }
}
