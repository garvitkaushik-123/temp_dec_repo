package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class UInt32Value extends z0 implements e2 {
    private static final UInt32Value DEFAULT_INSTANCE;
    private static volatile m2 PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int value_;

    static {
        UInt32Value uInt32Value = new UInt32Value();
        DEFAULT_INSTANCE = uInt32Value;
        z0.registerDefaultInstance(UInt32Value.class, uInt32Value);
    }

    private UInt32Value() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.value_ = 0;
    }

    public static UInt32Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static j3 newBuilder() {
        return (j3) DEFAULT_INSTANCE.createBuilder();
    }

    public static UInt32Value of(int i) {
        j3 newBuilder = newBuilder();
        newBuilder.c();
        ((UInt32Value) newBuilder.b).setValue(i);
        return (UInt32Value) newBuilder.a();
    }

    public static UInt32Value parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (UInt32Value) z0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UInt32Value parseFrom(ByteBuffer byteBuffer) throws n1 {
        return (UInt32Value) z0.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static m2 parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(int i) {
        this.value_ = i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.z0
    public final Object dynamicMethod(y0 y0Var, Object obj, Object obj2) {
        m2 m2Var;
        switch (i3.f1679a[y0Var.ordinal()]) {
            case 1:
                return new UInt32Value();
            case 2:
                return new j3();
            case 3:
                return z0.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                m2 m2Var2 = PARSER;
                if (m2Var2 != null) {
                    return m2Var2;
                }
                synchronized (UInt32Value.class) {
                    m2Var = PARSER;
                    if (m2Var == null) {
                        m2Var = new u0();
                        PARSER = m2Var;
                    }
                }
                return m2Var;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public int getValue() {
        return this.value_;
    }

    public static j3 newBuilder(UInt32Value uInt32Value) {
        return (j3) DEFAULT_INSTANCE.createBuilder(uInt32Value);
    }

    public static UInt32Value parseDelimitedFrom(InputStream inputStream, h0 h0Var) throws IOException {
        return (UInt32Value) z0.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, h0Var);
    }

    public static UInt32Value parseFrom(ByteBuffer byteBuffer, h0 h0Var) throws n1 {
        return (UInt32Value) z0.parseFrom(DEFAULT_INSTANCE, byteBuffer, h0Var);
    }

    public static UInt32Value parseFrom(s sVar) throws n1 {
        return (UInt32Value) z0.parseFrom(DEFAULT_INSTANCE, sVar);
    }

    public static UInt32Value parseFrom(s sVar, h0 h0Var) throws n1 {
        return (UInt32Value) z0.parseFrom(DEFAULT_INSTANCE, sVar, h0Var);
    }

    public static UInt32Value parseFrom(byte[] bArr) throws n1 {
        return (UInt32Value) z0.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static UInt32Value parseFrom(byte[] bArr, h0 h0Var) throws n1 {
        return (UInt32Value) z0.parseFrom(DEFAULT_INSTANCE, bArr, h0Var);
    }

    public static UInt32Value parseFrom(InputStream inputStream) throws IOException {
        return (UInt32Value) z0.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static UInt32Value parseFrom(InputStream inputStream, h0 h0Var) throws IOException {
        return (UInt32Value) z0.parseFrom(DEFAULT_INSTANCE, inputStream, h0Var);
    }

    public static UInt32Value parseFrom(w wVar) throws IOException {
        return (UInt32Value) z0.parseFrom(DEFAULT_INSTANCE, wVar);
    }

    public static UInt32Value parseFrom(w wVar, h0 h0Var) throws IOException {
        return (UInt32Value) z0.parseFrom(DEFAULT_INSTANCE, wVar, h0Var);
    }
}
