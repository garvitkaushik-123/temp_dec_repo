package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.GeneratedMessageLite$ExtendableMessage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class GeneratedMessageLite$ExtendableMessage<MessageType extends GeneratedMessageLite$ExtendableMessage<MessageType, BuilderType>, BuilderType> extends z0 implements e2 {
    protected n0 extensions = n0.d;

    private void eagerlyMergeMessageSetExtension(w wVar, x0 x0Var, h0 h0Var, int i) throws IOException {
        parseExtension(wVar, h0Var, x0Var, (i << 3) | 2, i);
    }

    private void mergeMessageSetExtensionFromBytes(s sVar, h0 h0Var, x0 x0Var) throws IOException {
        d2 d2Var = (d2) this.extensions.f1687a.get(x0Var.d);
        c2 builder = d2Var != null ? d2Var.toBuilder() : null;
        if (builder == null) {
            builder = x0Var.c.newBuilderForType();
        }
        t0 t0Var = (t0) builder;
        t0Var.getClass();
        try {
            w d = sVar.d();
            t0Var.a(d, h0Var);
            d.a(0);
            Object a2 = t0Var.a();
            n0 ensureExtensionsAreMutable = ensureExtensionsAreMutable();
            w0 w0Var = x0Var.d;
            if (w0Var.c.a() == k4.ENUM) {
                a2 = Integer.valueOf(((d1) a2).a());
            }
            ensureExtensionsAreMutable.c(w0Var, a2);
        } catch (n1 e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading " + t0Var.getClass().getName() + " from a ByteString threw an IOException (should never happen).", e2);
        }
    }

    private <MessageType extends d2> void mergeMessageSetExtensionFromCodedStream(MessageType messagetype, w wVar, h0 h0Var) throws IOException {
        int i = 0;
        q qVar = null;
        x0 x0Var = null;
        while (true) {
            int t = wVar.t();
            if (t == 0) {
                break;
            }
            if (t == 16) {
                i = wVar.u();
                if (i != 0) {
                    x0Var = h0Var.a(i, messagetype);
                }
            } else if (t == 26) {
                if (i == 0 || x0Var == null) {
                    qVar = wVar.e();
                } else {
                    eagerlyMergeMessageSetExtension(wVar, x0Var, h0Var, i);
                    qVar = null;
                }
            } else if (!wVar.e(t)) {
                break;
            }
        }
        wVar.a(12);
        if (qVar == null || i == 0) {
            return;
        }
        if (x0Var != null) {
            mergeMessageSetExtensionFromBytes(qVar, h0Var, x0Var);
        } else {
            mergeLengthDelimitedField(i, qVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0030  */
    /* JADX WARN: Type inference failed for: r10v27, types: [com.fyber.inneractive.sdk.protobuf.d1] */
    /* JADX WARN: Type inference failed for: r10v30, types: [java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean parseExtension(w wVar, h0 h0Var, x0 x0Var, int i, int i2) throws IOException {
        boolean z;
        Object a2;
        d2 d2Var;
        int i3 = i & 7;
        boolean z2 = false;
        if (x0Var != null) {
            j4 j4Var = x0Var.d.c;
            n0 n0Var = n0.d;
            if (i3 == j4Var.b()) {
                z = false;
            } else {
                w0 w0Var = x0Var.d;
                if (w0Var.d && w0Var.c.c()) {
                    j4 j4Var2 = x0Var.d.c;
                    if (i3 == 2) {
                        z = true;
                    }
                }
            }
            if (!z2) {
                return parseUnknownField(i, wVar);
            }
            ensureExtensionsAreMutable();
            if (z) {
                int d = wVar.d(wVar.m());
                if (x0Var.d.c == j4.ENUM) {
                    while (wVar.a() > 0) {
                        Object a3 = x0Var.d.f1704a.a(wVar.g());
                        if (a3 == 0) {
                            return true;
                        }
                        n0 n0Var2 = this.extensions;
                        w0 w0Var2 = x0Var.d;
                        if (w0Var2.c.a() == k4.ENUM) {
                            a3 = Integer.valueOf(a3.a());
                        }
                        n0Var2.a(w0Var2, a3);
                    }
                } else {
                    while (wVar.a() > 0) {
                        j4 j4Var3 = x0Var.d.c;
                        n0 n0Var3 = n0.d;
                        this.extensions.a(x0Var.d, p4.a(wVar, j4Var3, o4.LOOSE));
                    }
                }
                wVar.c(d);
            } else {
                int i4 = s0.f1699a[x0Var.d.c.a().ordinal()];
                if (i4 == 1) {
                    w0 w0Var3 = x0Var.d;
                    c2 builder = (w0Var3.d || (d2Var = (d2) this.extensions.f1687a.get(w0Var3)) == null) ? null : d2Var.toBuilder();
                    if (builder == null) {
                        builder = x0Var.c.newBuilderForType();
                    }
                    w0 w0Var4 = x0Var.d;
                    if (w0Var4.c == j4.GROUP) {
                        wVar.a(w0Var4.b, builder, h0Var);
                    } else {
                        wVar.a(builder, h0Var);
                    }
                    a2 = ((t0) builder).a();
                } else if (i4 != 2) {
                    j4 j4Var4 = x0Var.d.c;
                    n0 n0Var4 = n0.d;
                    a2 = p4.a(wVar, j4Var4, o4.LOOSE);
                } else {
                    int g = wVar.g();
                    d1 a4 = x0Var.d.f1704a.a(g);
                    if (a4 == null) {
                        mergeVarintField(i2, g);
                        return true;
                    }
                    a2 = a4;
                }
                w0 w0Var5 = x0Var.d;
                if (w0Var5.d) {
                    n0 n0Var5 = this.extensions;
                    if (w0Var5.c.a() == k4.ENUM) {
                        a2 = Integer.valueOf(((d1) a2).a());
                    }
                    n0Var5.a(w0Var5, a2);
                } else {
                    n0 n0Var6 = this.extensions;
                    if (w0Var5.c.a() == k4.ENUM) {
                        a2 = Integer.valueOf(((d1) a2).a());
                    }
                    n0Var6.c(w0Var5, a2);
                }
            }
            return true;
        }
        z = false;
        z2 = true;
        if (!z2) {
        }
    }

    private void verifyExtensionContainingType(x0 x0Var) {
        if (x0Var.f1709a != getDefaultInstanceForType()) {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    public n0 ensureExtensionsAreMutable() {
        n0 n0Var = this.extensions;
        if (n0Var.b) {
            this.extensions = n0Var.m7076clone();
        }
        return this.extensions;
    }

    public boolean extensionsAreInitialized() {
        return this.extensions.c();
    }

    public int extensionsSerializedSize() {
        return this.extensions.b();
    }

    public int extensionsSerializedSizeAsMessageSet() {
        return this.extensions.a();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.z0, com.fyber.inneractive.sdk.protobuf.e2
    public /* bridge */ /* synthetic */ d2 getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [Type, java.util.ArrayList] */
    public final <Type> Type getExtension(e0 e0Var) {
        x0 access$000 = z0.access$000(e0Var);
        verifyExtensionContainingType(access$000);
        n0 n0Var = this.extensions;
        Type type = (Type) n0Var.f1687a.get(access$000.d);
        if (type == 0) {
            return (Type) access$000.b;
        }
        w0 w0Var = access$000.d;
        if (w0Var.d) {
            if (w0Var.c.a() == k4.ENUM) {
                ?? r1 = (Type) new ArrayList();
                for (Object obj : (List) type) {
                    if (access$000.d.c.a() == k4.ENUM) {
                        obj = access$000.d.f1704a.a(((Integer) obj).intValue());
                    }
                    r1.add(obj);
                }
                return r1;
            }
        } else if (w0Var.c.a() == k4.ENUM) {
            return (Type) access$000.d.f1704a.a(((Integer) type).intValue());
        }
        return type;
    }

    public final <Type> int getExtensionCount(e0 e0Var) {
        x0 access$000 = z0.access$000(e0Var);
        verifyExtensionContainingType(access$000);
        n0 n0Var = this.extensions;
        w0 w0Var = access$000.d;
        n0Var.getClass();
        if (!w0Var.d) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object obj = n0Var.f1687a.get(w0Var);
        if (obj == null) {
            return 0;
        }
        return ((List) obj).size();
    }

    public final <Type> boolean hasExtension(e0 e0Var) {
        x0 access$000 = z0.access$000(e0Var);
        verifyExtensionContainingType(access$000);
        n0 n0Var = this.extensions;
        w0 w0Var = access$000.d;
        n0Var.getClass();
        if (w0Var.d) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return n0Var.f1687a.get(w0Var) != null;
    }

    public final void mergeExtensionFields(MessageType messagetype) {
        n0 n0Var = this.extensions;
        if (n0Var.b) {
            this.extensions = n0Var.m7076clone();
        }
        this.extensions.a(messagetype.extensions);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.z0, com.fyber.inneractive.sdk.protobuf.d2
    public /* bridge */ /* synthetic */ c2 newBuilderForType() {
        return newBuilderForType();
    }

    public v0 newExtensionWriter() {
        return new v0(this);
    }

    public v0 newMessageSetExtensionWriter() {
        return new v0(this);
    }

    public <MessageType extends d2> boolean parseUnknownField(MessageType messagetype, w wVar, h0 h0Var, int i) throws IOException {
        int i2 = i >>> 3;
        return parseExtension(wVar, h0Var, h0Var.a(i2, messagetype), i, i2);
    }

    public <MessageType extends d2> boolean parseUnknownFieldAsMessageSet(MessageType messagetype, w wVar, h0 h0Var, int i) throws IOException {
        if (i != 11) {
            return (i & 7) == 2 ? parseUnknownField(messagetype, wVar, h0Var, i) : wVar.e(i);
        }
        mergeMessageSetExtensionFromCodedStream(messagetype, wVar, h0Var);
        return true;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.z0, com.fyber.inneractive.sdk.protobuf.d2
    public /* bridge */ /* synthetic */ c2 toBuilder() {
        return toBuilder();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <Type> Type getExtension(e0 e0Var, int i) {
        x0 access$000 = z0.access$000(e0Var);
        verifyExtensionContainingType(access$000);
        n0 n0Var = this.extensions;
        w0 w0Var = access$000.d;
        n0Var.getClass();
        if (w0Var.d) {
            Object obj = n0Var.f1687a.get(w0Var);
            if (obj != null) {
                Type type = (Type) ((List) obj).get(i);
                return access$000.d.c.a() == k4.ENUM ? (Type) access$000.d.f1704a.a(((Integer) type).intValue()) : type;
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }
}
