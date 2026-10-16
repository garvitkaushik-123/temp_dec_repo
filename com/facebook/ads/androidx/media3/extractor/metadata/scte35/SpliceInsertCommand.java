package com.facebook.ads.androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.instagram.common.viewpoint.core.AnonymousClass53;
import com.instagram.common.viewpoint.core.C07364v;
import com.instagram.common.viewpoint.core.IW;
import com.instagram.common.viewpoint.core.IX;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: assets/audience_network/classes2.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static String[] A0D = {"2fVUWVW5Hj7LHoGITBtqA0sUitS4PTb4", "Q8qvKmypWvqXriKcaeBTncTBfq8seygK", "PB3TBbluvnbAoPy", "V5r7AKyrTxu4nkwu31wVya7iCL5S2t7X", "ptiIvLXZk7optwegrSJTcSLpf9JtKnje", "Im1w1jT", "8VlbtMqcAJkMoCkUmgZltZaiEM6o3", "PsL5EDhhHapqBInAVo5dkvRq7GvOLwYr"};
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new IW();
    public final int A00;
    public final int A01;
    public final int A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final List<IX> A07;
    public final boolean A08;
    public final boolean A09;
    public final boolean A0A;
    public final boolean A0B;
    public final boolean A0C;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 27 out of bounds for length 20
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public SpliceInsertCommand(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List<IX> list, boolean z5, long j4, int i, int i2, int i3) {
        this.A06 = j;
        this.A0B = z;
        this.A09 = z2;
        this.A0A = z3;
        this.A0C = z4;
        this.A05 = j2;
        this.A04 = j3;
        this.A07 = Collections.unmodifiableList(list);
        this.A08 = z5;
        this.A03 = j4;
        this.A02 = i;
        this.A00 = i2;
        this.A01 = i3;
    }

    public SpliceInsertCommand(Parcel parcel) {
        this.A06 = parcel.readLong();
        this.A0B = parcel.readByte() == 1;
        this.A09 = parcel.readByte() == 1;
        this.A0A = parcel.readByte() == 1;
        this.A0C = parcel.readByte() == 1;
        this.A05 = parcel.readLong();
        this.A04 = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(IX.A00(parcel));
        }
        this.A07 = Collections.unmodifiableList(arrayList);
        int componentSpliceListSize = parcel.readByte();
        this.A08 = componentSpliceListSize == 1;
        this.A03 = parcel.readLong();
        int componentSpliceListSize2 = parcel.readInt();
        this.A02 = componentSpliceListSize2;
        int componentSpliceListSize3 = parcel.readInt();
        this.A00 = componentSpliceListSize3;
        int componentSpliceListSize4 = parcel.readInt();
        this.A01 = componentSpliceListSize4;
    }

    public /* synthetic */ SpliceInsertCommand(Parcel parcel, IW iw) {
        this(parcel);
    }

    public static SpliceInsertCommand A00(C07364v c07364v, long j, AnonymousClass53 anonymousClass53) {
        long A0Q = c07364v.A0Q();
        boolean z = (c07364v.A0I() & 128) != 0;
        boolean z2 = false;
        boolean outOfNetworkIndicator = false;
        boolean z3 = false;
        long j2 = -9223372036854775807L;
        List emptyList = Collections.emptyList();
        if (A0D[6].length() == 19) {
            throw new RuntimeException();
        }
        A0D[4] = "mssbEGkdhdKHHgY1hMK2RaJspuJCG0bt";
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z4 = false;
        long j3 = -9223372036854775807L;
        if (!z) {
            int A0I = c07364v.A0I();
            z2 = (A0I & 128) != 0;
            outOfNetworkIndicator = (A0I & 64) != 0;
            boolean autoReturn = (A0I & 32) != 0;
            z3 = (A0I & 16) != 0;
            if (outOfNetworkIndicator && !z3) {
                j2 = TimeSignalCommand.A00(c07364v, j);
            }
            if (!outOfNetworkIndicator) {
                int componentCount = c07364v.A0I();
                emptyList = new ArrayList(componentCount);
                for (int i4 = 0; i4 < componentCount; i4++) {
                    int componentTag = c07364v.A0I();
                    long j4 = -9223372036854775807L;
                    if (!z3) {
                        j4 = TimeSignalCommand.A00(c07364v, j);
                    }
                    emptyList.add(new IX(componentTag, j4, anonymousClass53.A06(j4), null));
                }
            }
            if (autoReturn) {
                long A0I2 = c07364v.A0I();
                z4 = (A0I2 & 128) != 0;
                j3 = (1000 * (((A0I2 & 1) << 32) | c07364v.A0Q())) / 90;
            }
            i = c07364v.A0M();
            i2 = c07364v.A0I();
            i3 = c07364v.A0I();
        }
        return new SpliceInsertCommand(A0Q, z, z2, outOfNetworkIndicator, z3, j2, anonymousClass53.A06(j2), emptyList, z4, j3, i, i2, i3);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.A06);
        parcel.writeByte(this.A0B ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A09 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A0A ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A0C ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.A05);
        parcel.writeLong(this.A04);
        int size = this.A07.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.A07.get(i2).A01(parcel);
            String[] strArr = A0D;
            if (strArr[1].length() == strArr[2].length()) {
                throw new RuntimeException();
            }
            A0D[5] = "b82jUGYrdOItwNOnrxCotui81UmrwpK";
        }
        parcel.writeByte(this.A08 ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.A03);
        parcel.writeInt(this.A02);
        parcel.writeInt(this.A00);
        parcel.writeInt(this.A01);
    }
}
