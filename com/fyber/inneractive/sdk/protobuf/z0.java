package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public abstract class z0 extends b {
    private static Map<Object, z0> defaultInstanceMap = new ConcurrentHashMap();
    protected n3 unknownFields = n3.f;
    protected int memoizedSerializedSize = -1;

    public static z0 a(z0 z0Var) {
        if (z0Var == null || z0Var.isInitialized()) {
            return z0Var;
        }
        m3 newUninitializedMessageException = z0Var.newUninitializedMessageException();
        newUninitializedMessageException.getClass();
        throw new n1(newUninitializedMessageException.getMessage());
    }

    public static x0 access$000(e0 e0Var) {
        e0Var.getClass();
        return (x0) e0Var;
    }

    public static b1 emptyBooleanList() {
        return j.d;
    }

    public static c1 emptyDoubleList() {
        return d0.d;
    }

    public static f1 emptyFloatList() {
        return q0.d;
    }

    public static g1 emptyIntList() {
        return a1.d;
    }

    public static j1 emptyLongList() {
        return u1.d;
    }

    public static <E> k1 emptyProtobufList() {
        return q2.d;
    }

    public static <T extends z0> T getDefaultInstance(Class<T> cls) {
        T t = (T) defaultInstanceMap.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        try {
            T t2 = (T) ((z0) x3.f1711a.allocateInstance(cls)).getDefaultInstanceForType();
            if (t2 == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, t2);
            return t2;
        } catch (Throwable th) {
            throw new IllegalStateException(th);
        }
    }

    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static g1 mutableCopy(g1 g1Var) {
        a1 a1Var = (a1) g1Var;
        int i = a1Var.c;
        return a1Var.b(i == 0 ? 10 : i * 2);
    }

    public static Object newMessageInfo(d2 d2Var, String str, Object[] objArr) {
        return new r2(d2Var, str, objArr);
    }

    public static <ContainingType extends d2, Type> x0 newRepeatedGeneratedExtension(ContainingType containingtype, d2 d2Var, e1 e1Var, int i, j4 j4Var, boolean z, Class cls) {
        return new x0(containingtype, Collections.emptyList(), d2Var, new w0(e1Var, i, j4Var, true, z));
    }

    public static <ContainingType extends d2, Type> x0 newSingularGeneratedExtension(ContainingType containingtype, Type type, d2 d2Var, e1 e1Var, int i, j4 j4Var, Class cls) {
        return new x0(containingtype, type, d2Var, new w0(e1Var, i, j4Var, false, false));
    }

    public static <T extends z0> T parseDelimitedFrom(T t, InputStream inputStream) throws n1 {
        return (T) a(a(t, inputStream, h0.a()));
    }

    public static <T extends z0> T parseFrom(T t, InputStream inputStream) throws n1 {
        w uVar;
        if (inputStream == null) {
            byte[] bArr = l1.b;
            int length = bArr.length;
            uVar = new t(bArr, 0, length, false);
            try {
                uVar.d(length);
            } catch (n1 e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            uVar = new u(inputStream);
        }
        return (T) a(parsePartialFrom(t, uVar, h0.a()));
    }

    public static <T extends z0> T parsePartialFrom(T t, w wVar, h0 h0Var) throws n1 {
        T t2 = (T) t.dynamicMethod(y0.NEW_MUTABLE_INSTANCE);
        try {
            p2 p2Var = p2.c;
            p2Var.getClass();
            t2 a2 = p2Var.a(t2.getClass());
            x xVar = wVar.d;
            if (xVar == null) {
                xVar = new x(wVar);
            }
            a2.a(t2, xVar, h0Var);
            a2.c(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof n1) {
                throw ((n1) e.getCause());
            }
            throw new n1(e.getMessage());
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof n1) {
                throw ((n1) e2.getCause());
            }
            throw e2;
        }
    }

    public static <T extends z0> void registerDefaultInstance(Class<T> cls, T t) {
        defaultInstanceMap.put(cls, t);
    }

    public Object buildMessageInfo() throws Exception {
        return dynamicMethod(y0.BUILD_MESSAGE_INFO);
    }

    public final <MessageType extends z0, BuilderType extends t0> BuilderType createBuilder() {
        return (BuilderType) dynamicMethod(y0.NEW_BUILDER);
    }

    public Object dynamicMethod(y0 y0Var, Object obj) {
        return dynamicMethod(y0Var, obj, null);
    }

    public abstract Object dynamicMethod(y0 y0Var, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p2 p2Var = p2.c;
        p2Var.getClass();
        return p2Var.a(getClass()).b(this, (z0) obj);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b
    public int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize;
    }

    public final m2 getParserForType() {
        return (m2) dynamicMethod(y0.GET_PARSER);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d2
    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            p2 p2Var = p2.c;
            p2Var.getClass();
            this.memoizedSerializedSize = p2Var.a(getClass()).b(this);
        }
        return this.memoizedSerializedSize;
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        p2 p2Var = p2.c;
        p2Var.getClass();
        int d = p2Var.a(getClass()).d(this);
        this.memoizedHashCode = d;
        return d;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.e2
    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    public void makeImmutable() {
        p2 p2Var = p2.c;
        p2Var.getClass();
        p2Var.a(getClass()).c(this);
    }

    public void mergeLengthDelimitedField(int i, s sVar) {
        if (this.unknownFields == n3.f) {
            this.unknownFields = new n3();
        }
        n3 n3Var = this.unknownFields;
        if (!n3Var.e) {
            throw new UnsupportedOperationException();
        }
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        n3Var.a((i << 3) | 2, sVar);
    }

    public final void mergeUnknownFields(n3 n3Var) {
        this.unknownFields = n3.a(this.unknownFields, n3Var);
    }

    public void mergeVarintField(int i, int i2) {
        if (this.unknownFields == n3.f) {
            this.unknownFields = new n3();
        }
        n3 n3Var = this.unknownFields;
        if (!n3Var.e) {
            throw new UnsupportedOperationException();
        }
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        n3Var.a(i << 3, Long.valueOf(i2));
    }

    public boolean parseUnknownField(int i, w wVar) throws IOException {
        if ((i & 7) == 4) {
            return false;
        }
        if (this.unknownFields == n3.f) {
            this.unknownFields = new n3();
        }
        return this.unknownFields.a(i, wVar);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b
    public void setMemoizedSerializedSize(int i) {
        this.memoizedSerializedSize = i;
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ").append(obj);
        f2.a(this, sb, 0);
        return sb.toString();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d2
    public void writeTo(b0 b0Var) throws IOException {
        p2 p2Var = p2.c;
        p2Var.getClass();
        t2 a2 = p2Var.a(getClass());
        c0 c0Var = b0Var.f1659a;
        if (c0Var == null) {
            c0Var = new c0(b0Var);
        }
        a2.a((Object) this, c0Var);
    }

    public static final <T extends z0> boolean isInitialized(T t, boolean z) {
        byte byteValue = ((Byte) t.dynamicMethod(y0.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        p2 p2Var = p2.c;
        p2Var.getClass();
        boolean a2 = p2Var.a(t.getClass()).a(t);
        if (z) {
            t.dynamicMethod(y0.SET_MEMOIZED_IS_INITIALIZED, a2 ? t : null);
        }
        return a2;
    }

    public final <MessageType extends z0, BuilderType extends t0> BuilderType createBuilder(MessageType messagetype) {
        BuilderType buildertype = (BuilderType) createBuilder();
        buildertype.c();
        t0.a(buildertype.b, messagetype);
        return buildertype;
    }

    public Object dynamicMethod(y0 y0Var) {
        return dynamicMethod(y0Var, null, null);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.e2
    public final z0 getDefaultInstanceForType() {
        return (z0) dynamicMethod(y0.GET_DEFAULT_INSTANCE);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d2
    public final t0 newBuilderForType() {
        return (t0) dynamicMethod(y0.NEW_BUILDER);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d2
    public final t0 toBuilder() {
        t0 t0Var = (t0) dynamicMethod(y0.NEW_BUILDER);
        t0Var.c();
        t0.a(t0Var.b, this);
        return t0Var;
    }

    public static j1 mutableCopy(j1 j1Var) {
        u1 u1Var = (u1) j1Var;
        int i = u1Var.c;
        return u1Var.b(i == 0 ? 10 : i * 2);
    }

    public static <T extends z0> T parseDelimitedFrom(T t, InputStream inputStream, h0 h0Var) throws n1 {
        return (T) a(a(t, inputStream, h0Var));
    }

    public static z0 a(z0 z0Var, InputStream inputStream, h0 h0Var) {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            if ((read & 128) != 0) {
                read &= 127;
                int i = 7;
                while (true) {
                    if (i < 32) {
                        int read2 = inputStream.read();
                        if (read2 == -1) {
                            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                        }
                        read |= (read2 & 127) << i;
                        if ((read2 & 128) == 0) {
                            break;
                        }
                        i += 7;
                    } else {
                        while (i < 64) {
                            int read3 = inputStream.read();
                            if (read3 == -1) {
                                throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                            }
                            if ((read3 & 128) != 0) {
                                i += 7;
                            }
                        }
                        throw new n1("CodedInputStream encountered a malformed varint.");
                    }
                }
            }
            u uVar = new u(new a(inputStream, read));
            z0 parsePartialFrom = parsePartialFrom(z0Var, uVar, h0Var);
            uVar.a(0);
            return parsePartialFrom;
        } catch (IOException e) {
            throw new n1(e.getMessage());
        }
    }

    public static f1 mutableCopy(f1 f1Var) {
        q0 q0Var = (q0) f1Var;
        int i = q0Var.c;
        return q0Var.b(i == 0 ? 10 : i * 2);
    }

    public static c1 mutableCopy(c1 c1Var) {
        d0 d0Var = (d0) c1Var;
        int i = d0Var.c;
        return d0Var.b(i == 0 ? 10 : i * 2);
    }

    public static b1 mutableCopy(b1 b1Var) {
        j jVar = (j) b1Var;
        int i = jVar.c;
        return jVar.b(i == 0 ? 10 : i * 2);
    }

    public static <E> k1 mutableCopy(k1 k1Var) {
        int size = k1Var.size();
        return k1Var.b(size == 0 ? 10 : size * 2);
    }

    public static <T extends z0> T parseFrom(T t, InputStream inputStream, h0 h0Var) throws n1 {
        w uVar;
        if (inputStream == null) {
            byte[] bArr = l1.b;
            int length = bArr.length;
            uVar = new t(bArr, 0, length, false);
            try {
                uVar.d(length);
            } catch (n1 e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            uVar = new u(inputStream);
        }
        return (T) a(parsePartialFrom(t, uVar, h0Var));
    }

    public static <T extends z0> T parsePartialFrom(T t, byte[] bArr, int i, int i2, h0 h0Var) throws n1 {
        T t2 = (T) t.dynamicMethod(y0.NEW_MUTABLE_INSTANCE);
        try {
            p2 p2Var = p2.c;
            p2Var.getClass();
            t2 a2 = p2Var.a(t2.getClass());
            a2.a(t2, bArr, i, i + i2, new f(h0Var));
            a2.c(t2);
            if (t2.memoizedHashCode == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof n1) {
                throw ((n1) e.getCause());
            }
            throw new n1(e.getMessage());
        } catch (IndexOutOfBoundsException unused) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    public static <T extends z0> T parsePartialFrom(T t, w wVar) throws n1 {
        return (T) parsePartialFrom(t, wVar, h0.a());
    }

    public static <T extends z0> T parseFrom(T t, ByteBuffer byteBuffer, h0 h0Var) throws n1 {
        t tVar;
        w vVar;
        if (byteBuffer.hasArray()) {
            byte[] array = byteBuffer.array();
            int position = byteBuffer.position() + byteBuffer.arrayOffset();
            int remaining = byteBuffer.remaining();
            tVar = new t(array, position, remaining, false);
            try {
                tVar.d(remaining);
            } catch (n1 e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            if (byteBuffer.isDirect() && x3.d) {
                vVar = new v(byteBuffer, false);
                return (T) a(parseFrom(t, vVar, h0Var));
            }
            int remaining2 = byteBuffer.remaining();
            byte[] bArr = new byte[remaining2];
            byteBuffer.duplicate().get(bArr);
            t tVar2 = new t(bArr, 0, remaining2, true);
            try {
                tVar2.d(remaining2);
                tVar = tVar2;
            } catch (n1 e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        vVar = tVar;
        return (T) a(parseFrom(t, vVar, h0Var));
    }

    public static <T extends z0> T parseFrom(T t, ByteBuffer byteBuffer) throws n1 {
        return (T) parseFrom(t, byteBuffer, h0.a());
    }

    public static <T extends z0> T parseFrom(T t, s sVar) throws n1 {
        return (T) a(parseFrom(t, sVar, h0.a()));
    }

    public static <T extends z0> T parseFrom(T t, s sVar, h0 h0Var) throws n1 {
        w d = sVar.d();
        z0 parsePartialFrom = parsePartialFrom(t, d, h0Var);
        d.a(0);
        return (T) a(parsePartialFrom);
    }

    public static <T extends z0> T parseFrom(T t, byte[] bArr) throws n1 {
        return (T) a(parsePartialFrom(t, bArr, 0, bArr.length, h0.a()));
    }

    public static <T extends z0> T parseFrom(T t, byte[] bArr, h0 h0Var) throws n1 {
        return (T) a(parsePartialFrom(t, bArr, 0, bArr.length, h0Var));
    }

    public static <T extends z0> T parseFrom(T t, w wVar) throws n1 {
        return (T) parseFrom(t, wVar, h0.a());
    }

    public static <T extends z0> T parseFrom(T t, w wVar, h0 h0Var) throws n1 {
        return (T) a(parsePartialFrom(t, wVar, h0Var));
    }
}
