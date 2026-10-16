package com.instagram.common.viewpoint.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* renamed from: com.facebook.ads.redexgen.X.p9, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2419p9 {
    public static byte[] A00;
    public static String[] A01 = {"K5wWXkn1kn3vTm5TWZRpAJ13TGij4Off", "na1woSjLgBJfLtqhSRSkwOGg", "PhLAgNdVWkw0DSh4SzNoPunxC5fhlr", "P2EphC6Qbo", "AgH7SjrpzHTBb", "6lZG", "iuGyz0SG3T5uD6f3liiVpcsGpl9NN6eU", "8JXy4no7J"};

    public static String A07(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 50);
        }
        return new String(copyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{-67, -65, -78, -79, -74, -80, -82, -63, -78};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static <T> boolean A0B(Iterator<T> iterator, InterfaceC2160kj<? super T> predicate) {
        return A00(iterator, predicate) != -1;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static boolean A0F(Iterator<?> iterator1, Iterator<?> iterator2) {
        while (iterator1.hasNext()) {
            if (!iterator2.hasNext() || !CB.A01(iterator1.next(), iterator2.next())) {
                return false;
            }
        }
        return !iterator2.hasNext();
    }

    static {
        A08();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kj != com.google.common.base.Predicate<? super T> */
    public static <T> int A00(Iterator<T> iterator, InterfaceC2160kj<? super T> predicate) {
        AbstractC2159ki.A05(predicate, A07(0, 9, 27));
        int i = 0;
        while (iterator.hasNext()) {
            if (predicate.A4C(iterator.next())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kj != com.google.common.base.Predicate<? super T> */
    public static <T> C4C<T> A01(final Iterator<T> unfiltered, final InterfaceC2160kj<? super T> retainIfTrue) {
        AbstractC2159ki.A04(unfiltered);
        AbstractC2159ki.A04(retainIfTrue);
        return new AbstractC0902Bv<T>() { // from class: com.facebook.ads.redexgen.X.2I
            @Override // com.instagram.common.viewpoint.core.AbstractC0902Bv
            @CheckForNull
            public final T A02() {
                while (unfiltered.hasNext()) {
                    T t = (T) unfiltered.next();
                    if (retainIfTrue.A4C(t)) {
                        return t;
                    }
                }
                return A01();
            }
        };
    }

    public static <T> Iterator<T> A02() {
        return EnumC2417p7.A03;
    }

    public static <T> C4C<T> A03(@ParametricNullness T value) {
        return new BN(value);
    }

    @CheckForNull
    public static <T> T A04(Iterator<T> iterator) {
        if (iterator.hasNext()) {
            T result = iterator.next();
            iterator.remove();
            return result;
        }
        return null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kj != com.google.common.base.Predicate<? super T> */
    @ParametricNullness
    public static <T> T A05(Iterator<T> iterator, InterfaceC2160kj<? super T> predicate) {
        AbstractC2159ki.A04(iterator);
        AbstractC2159ki.A04(predicate);
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (predicate.A4C(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    @ParametricNullness
    public static <T> T A06(@ParametricNullness Iterator<? extends T> iterator, T defaultValue) {
        if (!iterator.hasNext()) {
            return defaultValue;
        }
        T defaultValue2 = iterator.next();
        return defaultValue2;
    }

    public static void A09(Iterator<?> iterator) {
        AbstractC2159ki.A04(iterator);
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x000b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> boolean A0A(Collection<T> addTo, Iterator<? extends T> iterator) {
        AbstractC2159ki.A04(addTo);
        AbstractC2159ki.A04(iterator);
        boolean z = false;
        while (wasModified) {
            boolean wasModified = addTo.add(iterator.next());
            z |= wasModified;
        }
        return z;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.kj != com.google.common.base.Predicate<? super T> */
    /* JADX WARN: Incorrect condition in loop: B:3:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> boolean A0C(Iterator<T> removeFrom, InterfaceC2160kj<? super T> predicate) {
        AbstractC2159ki.A04(predicate);
        boolean z = false;
        while (modified) {
            boolean modified = predicate.A4C(removeFrom.next());
            if (modified) {
                removeFrom.remove();
                if (A01[5].length() != 4) {
                    throw new RuntimeException();
                }
                A01[7] = "wI9B4C2he";
                z = true;
            }
        }
        return z;
    }

    public static boolean A0D(@CheckForNull Iterator<?> iterator, Object element) {
        if (element == null) {
            while (iterator.hasNext()) {
                if (iterator.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (iterator.hasNext()) {
            if (element.equals(iterator.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A0E(Iterator<?> removeFrom, Collection<?> elementsToRemove) {
        AbstractC2159ki.A04(elementsToRemove);
        boolean z = false;
        while (result) {
            boolean result = elementsToRemove.contains(removeFrom.next());
            if (result) {
                removeFrom.remove();
                z = true;
            }
        }
        return z;
    }
}
