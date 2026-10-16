package com.instagram.common.viewpoint.core;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import com.vungle.ads.internal.protos.Sdk;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX WARN: Unexpected interfaces in signature: [kotlin.jvm.internal.markers.KMappedMarker] */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH¦\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0015\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H\u0015¢\u0006\u0002\u0010\u0017J'\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0015\"\u0004\b\u0001\u0010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0015H\u0014¢\u0006\u0002\u0010\u001aR\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lkotlin/collections/AbstractCollection;", ExifInterface.LONGITUDE_EAST, "", "<init>", "()V", ContentDisposition.Parameters.Size, "", "getSize", "()I", "iterator", "", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "toString", "", "toArray", "", "", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: com.facebook.ads.redexgen.X.Ai, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0865Ai<E> implements Collection<E> {
    public static byte[] A00;

    static {
        A0B();
    }

    public static String A0A(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 23);
        }
        return new String(copyOfRange);
    }

    public static void A0B() {
        A00 = new byte[]{Ascii.RS, 66, 94, 95, 69, Ascii.SYN, 117, 89, 90, 90, 83, 85, 66, 95, 89, 88, Ascii.US, 10, 6, 5, 58, 47, 56, 43, 62, 35, 37, 36, 106, 35, 57, 106, 36, 37, 62, 106, 57, 63, 58, 58, 37, 56, 62, 47, 46, 106, 44, 37, 56, 106, 56, 47, 43, 46, 103, 37, 36, 38, 51, 106, 41, 37, 38, 38, 47, 41, 62, 35, 37, 36, 33, 69, 44, 63, 63, 44, 52, 8, 1, 8, 0, 8, 3, Ascii.EM, Ascii.RS};
    }

    public abstract int A0C();

    @Override // java.util.Collection
    public final boolean add(E e) {
        throw new UnsupportedOperationException(A0A(19, 51, 93));
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException(A0A(19, 51, 93));
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException(A0A(19, 51, 93));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // java.util.Collection, java.util.List
    public boolean contains(E element) {
        AbstractC0865Ai<E> abstractC0865Ai = this;
        if ((abstractC0865Ai instanceof Collection) && abstractC0865Ai.isEmpty()) {
            return false;
        }
        Iterator<E> it = abstractC0865Ai.iterator();
        while (it.hasNext()) {
            if (C2503qY.A0C(it.next(), element)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public final boolean containsAll(Collection<? extends Object> elements) {
        C2503qY.A09(elements, A0A(77, 8, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE));
        Collection<? extends Object> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public abstract Iterator<E> iterator();

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException(A0A(19, 51, 93));
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException(A0A(19, 51, 93));
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException(A0A(19, 51, 93));
    }

    public static final CharSequence A08(AbstractC0865Ai abstractC0865Ai, Object obj) {
        return obj == abstractC0865Ai ? A0A(0, 17, 33) : String.valueOf(obj);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return A0C();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return AbstractC2505qa.A02(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        C2503qY.A09(array, A0A(72, 5, 90));
        return (T[]) AbstractC2505qa.A03(this, array);
    }

    public final String toString() {
        return C0d.A03(this, A0A(17, 2, 49), A0A(70, 1, 109), A0A(71, 1, 15), 0, null, new AZ() { // from class: com.facebook.ads.redexgen.X.1t
            @Override // com.instagram.common.viewpoint.core.AZ
            public final Object AAK(Object obj) {
                CharSequence A08;
                A08 = AbstractC0865Ai.A08(AbstractC0865Ai.this, obj);
                return A08;
            }
        }, 24, null);
    }
}
