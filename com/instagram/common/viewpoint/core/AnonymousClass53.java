package com.instagram.common.viewpoint.core;

/* renamed from: com.facebook.ads.redexgen.X.53, reason: invalid class name */
/* loaded from: assets/audience_network/classes2.dex */
public final class AnonymousClass53 {
    public long A00;
    public long A01;
    public long A02;
    public final ThreadLocal<Long> A03 = new ThreadLocal<>();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 14 out of bounds for length 14
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:147)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final synchronized long A06(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.A01 != -9223372036854775807L) {
            long A01 = A01(this.A01);
            long j2 = (4294967296L + A01) / 8589934592L;
            long j3 = ((j2 - 1) * 8589934592L) + j;
            long j4 = (8589934592L * j2) + j;
            if (Math.abs(j3 - A01) >= Math.abs(j4 - A01)) {
                j3 = j4;
            }
            j = j3;
        }
        return A05(A00(j));
    }

    public AnonymousClass53(long j) {
        A07(j);
    }

    public static long A00(long j) {
        return (1000000 * j) / 90000;
    }

    public static long A01(long j) {
        return (90000 * j) / 1000000;
    }

    public final synchronized long A02() {
        long j;
        if (this.A00 != Long.MAX_VALUE && this.A00 != 9223372036854775806L) {
            j = this.A00;
        }
        j = -9223372036854775807L;
        return j;
    }

    public final synchronized long A03() {
        long A02;
        if (this.A01 != -9223372036854775807L) {
            A02 = this.A01 + this.A02;
        } else {
            A02 = A02();
        }
        return A02;
    }

    public final synchronized long A04() {
        return this.A02;
    }

    public final synchronized long A05(long j) {
        long desiredSampleTimestampUs;
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.A02 == -9223372036854775807L) {
            if (this.A00 == 9223372036854775806L) {
                desiredSampleTimestampUs = ((Long) AbstractC07133y.A01(this.A03.get())).longValue();
            } else {
                desiredSampleTimestampUs = this.A00;
            }
            this.A02 = desiredSampleTimestampUs - j;
            notifyAll();
        }
        this.A01 = j;
        return this.A02 + j;
    }

    public final synchronized void A07(long j) {
        this.A00 = j;
        this.A02 = j == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.A01 = -9223372036854775807L;
    }
}
