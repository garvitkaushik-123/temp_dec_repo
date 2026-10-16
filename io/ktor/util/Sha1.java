package io.ktor.util;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HashFunction.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J \u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lio/ktor/util/Sha1;", "Lio/ktor/util/HashFunction;", "()V", "h0", "", "h1", "h2", "h3", "h4", "messageLength", "", "unprocessed", "", "unprocessedLimit", "words", "", "digest", "processChunk", "", "input", "pos", "reset", "update", "offset", "length", "ktor-utils"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class Sha1 implements HashFunction {
    private long messageLength;
    private int unprocessedLimit;
    private final byte[] unprocessed = new byte[64];
    private final int[] words = new int[80];
    private int h0 = 1732584193;
    private int h1 = -271733879;
    private int h2 = -1732584194;
    private int h3 = 271733878;
    private int h4 = -1009589776;

    @Override // io.ktor.util.HashFunction
    public void update(byte[] input, int offset, int length) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.messageLength += length;
        int i = offset + length;
        byte[] bArr = this.unprocessed;
        int i2 = this.unprocessedLimit;
        if (i2 > 0) {
            int i3 = length + i2;
            if (i3 < 64) {
                ArraysKt.copyInto(input, bArr, i2, offset, i);
                this.unprocessedLimit = i3;
                return;
            } else {
                int i4 = (64 - i2) + offset;
                ArraysKt.copyInto(input, bArr, i2, offset, i4);
                processChunk(bArr, 0);
                this.unprocessedLimit = 0;
                offset = i4;
            }
        }
        while (offset < i) {
            int i5 = offset + 64;
            if (i5 > i) {
                ArraysKt.copyInto(input, bArr, 0, offset, i);
                this.unprocessedLimit = i - offset;
                return;
            } else {
                processChunk(input, offset);
                offset = i5;
            }
        }
    }

    private final void processChunk(byte[] input, int pos) {
        int i;
        int leftRotate;
        int i2;
        int i3;
        int leftRotate2;
        int leftRotate3;
        int leftRotate4;
        int leftRotate5;
        int leftRotate6;
        int[] iArr = this.words;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= 16) {
                break;
            }
            int i6 = pos + 3;
            int i7 = ((input[pos + 1] & 255) << 16) | ((input[pos] & 255) << 24) | ((input[pos + 2] & 255) << 8);
            pos += 4;
            iArr[i5] = i7 | (input[i6] & 255);
            i5++;
        }
        for (i = 16; i < 80; i++) {
            leftRotate6 = HashFunctionKt.leftRotate(((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16], 1);
            iArr[i] = leftRotate6;
        }
        int i8 = this.h0;
        int i9 = this.h1;
        int i10 = this.h2;
        int i11 = this.h3;
        int i12 = this.h4;
        while (i4 < 80) {
            if (i4 < 20) {
                leftRotate5 = HashFunctionKt.leftRotate(i8, 5);
                i2 = leftRotate5 + (((i10 ^ i11) & i9) ^ i11) + i12 + 1518500249;
                i3 = iArr[i4];
            } else if (i4 < 40) {
                leftRotate3 = HashFunctionKt.leftRotate(i8, 5);
                i2 = leftRotate3 + ((i9 ^ i10) ^ i11) + i12 + 1859775393;
                i3 = iArr[i4];
            } else if (i4 < 60) {
                leftRotate2 = HashFunctionKt.leftRotate(i8, 5);
                i2 = ((leftRotate2 + (((i10 | i11) & i9) | (i10 & i11))) + i12) - 1894007588;
                i3 = iArr[i4];
            } else {
                leftRotate = HashFunctionKt.leftRotate(i8, 5);
                i2 = ((leftRotate + ((i9 ^ i10) ^ i11)) + i12) - 899497514;
                i3 = iArr[i4];
            }
            int i13 = i2 + i3;
            leftRotate4 = HashFunctionKt.leftRotate(i9, 30);
            i4++;
            i12 = i11;
            i11 = i10;
            i10 = leftRotate4;
            i9 = i8;
            i8 = i13;
        }
        this.h0 += i8;
        this.h1 += i9;
        this.h2 += i10;
        this.h3 += i11;
        this.h4 += i12;
    }

    @Override // io.ktor.util.HashFunction
    public byte[] digest() {
        byte[] bArr = this.unprocessed;
        int i = this.unprocessedLimit;
        long j = this.messageLength * 8;
        int i2 = i + 1;
        bArr[i] = Byte.MIN_VALUE;
        if (i2 > 56) {
            ArraysKt.fill(bArr, (byte) 0, i2, 64);
            processChunk(bArr, 0);
            ArraysKt.fill(bArr, (byte) 0, 0, i2);
        } else {
            ArraysKt.fill(bArr, (byte) 0, i2, 56);
        }
        bArr[56] = (byte) (j >>> 56);
        bArr[57] = (byte) (j >>> 48);
        bArr[58] = (byte) (j >>> 40);
        bArr[59] = (byte) (j >>> 32);
        bArr[60] = (byte) (j >>> 24);
        bArr[61] = (byte) (j >>> 16);
        bArr[62] = (byte) (j >>> 8);
        bArr[63] = (byte) j;
        processChunk(bArr, 0);
        int i3 = this.h0;
        int i4 = this.h1;
        int i5 = this.h2;
        int i6 = this.h3;
        int i7 = this.h4;
        reset();
        return new byte[]{(byte) (i3 >> 24), (byte) (i3 >> 16), (byte) (i3 >> 8), (byte) i3, (byte) (i4 >> 24), (byte) (i4 >> 16), (byte) (i4 >> 8), (byte) i4, (byte) (i5 >> 24), (byte) (i5 >> 16), (byte) (i5 >> 8), (byte) i5, (byte) (i6 >> 24), (byte) (i6 >> 16), (byte) (i6 >> 8), (byte) i6, (byte) (i7 >> 24), (byte) (i7 >> 16), (byte) (i7 >> 8), (byte) i7};
    }

    private final void reset() {
        this.messageLength = 0L;
        ArraysKt.fill$default(this.unprocessed, (byte) 0, 0, 0, 6, (Object) null);
        this.unprocessedLimit = 0;
        ArraysKt.fill$default(this.words, 0, 0, 0, 6, (Object) null);
        this.h0 = 1732584193;
        this.h1 = -271733879;
        this.h2 = -1732584194;
        this.h3 = 271733878;
        this.h4 = -1009589776;
    }
}
