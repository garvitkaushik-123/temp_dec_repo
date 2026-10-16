package com.bytedance.sdk.component.DbA.eli;

/* loaded from: classes3.dex */
public class NU {
    public eli MGA;
    public FC Os;
    public String aGH;
    public byte[] ui;

    public enum eli {
        STRING_TYPE,
        BYTE_ARRAY_TYPE
    }

    public NU() {
    }

    public NU(FC fc, String str, eli eliVar) {
        this.Os = fc;
        this.aGH = str;
        this.MGA = eliVar;
    }

    public NU(FC fc, byte[] bArr, eli eliVar) {
        this.Os = fc;
        this.ui = bArr;
        this.MGA = eliVar;
    }

    public static NU eli(FC fc, String str) {
        return new NU(fc, str, eli.STRING_TYPE);
    }

    public static NU eli(FC fc, byte[] bArr) {
        return new NU(fc, bArr, eli.BYTE_ARRAY_TYPE);
    }
}
