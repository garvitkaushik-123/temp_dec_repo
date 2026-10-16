package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.CryptoInfo;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.source.SampleMetadataQueue;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocation;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes6.dex */
public final class SampleQueue implements TrackOutput {
    public static final int ADVANCE_FAILED = -1;
    private static final int INITIAL_SCRATCH_SIZE = 32;
    private final int allocationLength;
    private final Allocator allocator;
    private Format downstreamFormat;
    private final SampleMetadataQueue.SampleExtrasHolder extrasHolder;
    private AllocationNode firstAllocationNode;
    private Format lastUnadjustedFormat;
    private final SampleMetadataQueue metadataQueue;
    private boolean pendingFormatAdjustment;
    private boolean pendingSplice;
    private AllocationNode readAllocationNode;
    private long sampleOffsetUs;
    private final ParsableByteArray scratch;
    private long totalBytesWritten;
    private UpstreamFormatChangedListener upstreamFormatChangeListener;
    private AllocationNode writeAllocationNode;

    private static final class AllocationNode {
        public Allocation allocation;
        public final long endPosition;
        public AllocationNode next;
        public final long startPosition;
        public boolean wasInitialized;

        public AllocationNode(long j, int i) {
            this.startPosition = j;
            this.endPosition = j + i;
        }

        public AllocationNode clear() {
            this.allocation = null;
            AllocationNode allocationNode = this.next;
            this.next = null;
            return allocationNode;
        }

        public void initialize(Allocation allocation, AllocationNode allocationNode) {
            this.allocation = allocation;
            this.next = allocationNode;
            this.wasInitialized = true;
        }

        public int translateOffset(long j) {
            return ((int) (j - this.startPosition)) + this.allocation.offset;
        }
    }

    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public SampleQueue(Allocator allocator) {
        this.allocator = allocator;
        int individualAllocationLength = allocator.getIndividualAllocationLength();
        this.allocationLength = individualAllocationLength;
        this.metadataQueue = new SampleMetadataQueue();
        this.extrasHolder = new SampleMetadataQueue.SampleExtrasHolder();
        this.scratch = new ParsableByteArray(32);
        AllocationNode allocationNode = new AllocationNode(0L, individualAllocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
    }

    private void advanceReadTo(long j) {
        while (true) {
            AllocationNode allocationNode = this.readAllocationNode;
            if (j < allocationNode.endPosition) {
                return;
            } else {
                this.readAllocationNode = allocationNode.next;
            }
        }
    }

    private void clearAllocationNodes(AllocationNode allocationNode) {
        if (allocationNode.wasInitialized) {
            AllocationNode allocationNode2 = this.writeAllocationNode;
            boolean z = allocationNode2.wasInitialized;
            int i = (z ? 1 : 0) + (((int) (allocationNode2.startPosition - allocationNode.startPosition)) / this.allocationLength);
            Allocation[] allocationArr = new Allocation[i];
            for (int i2 = 0; i2 < i; i2++) {
                allocationArr[i2] = allocationNode.allocation;
                allocationNode = allocationNode.clear();
            }
            this.allocator.release(allocationArr);
        }
    }

    private void discardDownstreamTo(long j) {
        AllocationNode allocationNode;
        if (j == -1) {
            return;
        }
        while (true) {
            allocationNode = this.firstAllocationNode;
            if (j < allocationNode.endPosition) {
                break;
            }
            this.allocator.release(allocationNode.allocation);
            this.firstAllocationNode = this.firstAllocationNode.clear();
        }
        if (this.readAllocationNode.startPosition < allocationNode.startPosition) {
            this.readAllocationNode = allocationNode;
        }
    }

    private static Format getAdjustedSampleFormat(Format format, long j) {
        if (format == null) {
            return null;
        }
        if (j == 0) {
            return format;
        }
        long j2 = format.subsampleOffsetUs;
        return j2 != Long.MAX_VALUE ? format.copyWithSubsampleOffsetUs(j2 + j) : format;
    }

    private void postAppend(int i) {
        long j = this.totalBytesWritten + i;
        this.totalBytesWritten = j;
        AllocationNode allocationNode = this.writeAllocationNode;
        if (j == allocationNode.endPosition) {
            this.writeAllocationNode = allocationNode.next;
        }
    }

    private int preAppend(int i) {
        AllocationNode allocationNode = this.writeAllocationNode;
        if (!allocationNode.wasInitialized) {
            allocationNode.initialize(this.allocator.allocate(), new AllocationNode(this.writeAllocationNode.endPosition, this.allocationLength));
        }
        return Math.min(i, (int) (this.writeAllocationNode.endPosition - this.totalBytesWritten));
    }

    private void readData(long j, ByteBuffer byteBuffer, int i) {
        advanceReadTo(j);
        while (i > 0) {
            int min = Math.min(i, (int) (this.readAllocationNode.endPosition - j));
            AllocationNode allocationNode = this.readAllocationNode;
            byteBuffer.put(allocationNode.allocation.data, allocationNode.translateOffset(j), min);
            i -= min;
            j += min;
            AllocationNode allocationNode2 = this.readAllocationNode;
            if (j == allocationNode2.endPosition) {
                this.readAllocationNode = allocationNode2.next;
            }
        }
    }

    private void readEncryptionData(DecoderInputBuffer decoderInputBuffer, SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder) {
        long j = sampleExtrasHolder.offset;
        int i = 1;
        this.scratch.reset(1);
        readData(j, this.scratch.data, 1);
        long j2 = j + 1;
        byte b = this.scratch.data[0];
        boolean z = (b & 128) != 0;
        int i2 = b & Byte.MAX_VALUE;
        CryptoInfo cryptoInfo = decoderInputBuffer.cryptoInfo;
        if (cryptoInfo.iv == null) {
            cryptoInfo.iv = new byte[16];
        }
        readData(j2, cryptoInfo.iv, i2);
        long j3 = j2 + i2;
        if (z) {
            this.scratch.reset(2);
            readData(j3, this.scratch.data, 2);
            j3 += 2;
            i = this.scratch.readUnsignedShort();
        }
        int i3 = i;
        CryptoInfo cryptoInfo2 = decoderInputBuffer.cryptoInfo;
        int[] iArr = cryptoInfo2.numBytesOfClearData;
        if (iArr == null || iArr.length < i3) {
            iArr = new int[i3];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cryptoInfo2.numBytesOfEncryptedData;
        if (iArr3 == null || iArr3.length < i3) {
            iArr3 = new int[i3];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i4 = i3 * 6;
            this.scratch.reset(i4);
            readData(j3, this.scratch.data, i4);
            j3 += i4;
            this.scratch.setPosition(0);
            for (int i5 = 0; i5 < i3; i5++) {
                iArr2[i5] = this.scratch.readUnsignedShort();
                iArr4[i5] = this.scratch.readUnsignedIntToInt();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = sampleExtrasHolder.size - ((int) (j3 - sampleExtrasHolder.offset));
        }
        TrackOutput.CryptoData cryptoData = sampleExtrasHolder.cryptoData;
        CryptoInfo cryptoInfo3 = decoderInputBuffer.cryptoInfo;
        cryptoInfo3.set(i3, iArr2, iArr4, cryptoData.encryptionKey, cryptoInfo3.iv, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
        long j4 = sampleExtrasHolder.offset;
        int i6 = (int) (j3 - j4);
        sampleExtrasHolder.offset = j4 + i6;
        sampleExtrasHolder.size -= i6;
    }

    public int advanceTo(long j, boolean z, boolean z2) {
        return this.metadataQueue.advanceTo(j, z, z2);
    }

    public int advanceToEnd() {
        return this.metadataQueue.advanceToEnd();
    }

    public void discardTo(long j, boolean z, boolean z2) {
        discardDownstreamTo(this.metadataQueue.discardTo(j, z, z2));
    }

    public void discardToEnd() {
        discardDownstreamTo(this.metadataQueue.discardToEnd());
    }

    public void discardToRead() {
        discardDownstreamTo(this.metadataQueue.discardToRead());
    }

    public void discardUpstreamSamples(int i) {
        long discardUpstreamSamples = this.metadataQueue.discardUpstreamSamples(i);
        this.totalBytesWritten = discardUpstreamSamples;
        if (discardUpstreamSamples != 0) {
            AllocationNode allocationNode = this.firstAllocationNode;
            if (discardUpstreamSamples != allocationNode.startPosition) {
                while (this.totalBytesWritten > allocationNode.endPosition) {
                    allocationNode = allocationNode.next;
                }
                AllocationNode allocationNode2 = allocationNode.next;
                clearAllocationNodes(allocationNode2);
                AllocationNode allocationNode3 = new AllocationNode(allocationNode.endPosition, this.allocationLength);
                allocationNode.next = allocationNode3;
                if (this.totalBytesWritten == allocationNode.endPosition) {
                    allocationNode = allocationNode3;
                }
                this.writeAllocationNode = allocationNode;
                if (this.readAllocationNode == allocationNode2) {
                    this.readAllocationNode = allocationNode3;
                    return;
                }
                return;
            }
        }
        clearAllocationNodes(this.firstAllocationNode);
        AllocationNode allocationNode4 = new AllocationNode(this.totalBytesWritten, this.allocationLength);
        this.firstAllocationNode = allocationNode4;
        this.readAllocationNode = allocationNode4;
        this.writeAllocationNode = allocationNode4;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput
    public void format(Format format) {
        Format adjustedSampleFormat = getAdjustedSampleFormat(format, this.sampleOffsetUs);
        boolean format2 = this.metadataQueue.format(adjustedSampleFormat);
        this.lastUnadjustedFormat = format;
        this.pendingFormatAdjustment = false;
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.upstreamFormatChangeListener;
        if (upstreamFormatChangedListener == null || !format2) {
            return;
        }
        upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedSampleFormat);
    }

    public int getFirstIndex() {
        return this.metadataQueue.getFirstIndex();
    }

    public long getFirstTimestampUs() {
        return this.metadataQueue.getFirstTimestampUs();
    }

    public long getLargestQueuedTimestampUs() {
        return this.metadataQueue.getLargestQueuedTimestampUs();
    }

    public int getReadIndex() {
        return this.metadataQueue.getReadIndex();
    }

    public Format getUpstreamFormat() {
        return this.metadataQueue.getUpstreamFormat();
    }

    public int getWriteIndex() {
        return this.metadataQueue.getWriteIndex();
    }

    public boolean hasNextSample() {
        return this.metadataQueue.hasNextSample();
    }

    public int peekSourceId() {
        return this.metadataQueue.peekSourceId();
    }

    public int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, long j) {
        int read = this.metadataQueue.read(formatHolder, decoderInputBuffer, z, z2, this.downstreamFormat, this.extrasHolder);
        if (read == -5) {
            this.downstreamFormat = formatHolder.format;
            return -5;
        }
        if (read != -4) {
            if (read == -3) {
                return -3;
            }
            throw new IllegalStateException();
        }
        if (!decoderInputBuffer.isEndOfStream()) {
            if (decoderInputBuffer.timeUs < j) {
                decoderInputBuffer.addFlag(Integer.MIN_VALUE);
            }
            if (decoderInputBuffer.isEncrypted()) {
                readEncryptionData(decoderInputBuffer, this.extrasHolder);
            }
            decoderInputBuffer.ensureSpaceForWrite(this.extrasHolder.size);
            SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder = this.extrasHolder;
            readData(sampleExtrasHolder.offset, decoderInputBuffer.data, sampleExtrasHolder.size);
        }
        return -4;
    }

    public void reset() {
        reset(false);
    }

    public void rewind() {
        this.metadataQueue.rewind();
        this.readAllocationNode = this.firstAllocationNode;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput
    public int sampleData(ExtractorInput extractorInput, int i, boolean z) throws IOException, InterruptedException {
        int preAppend = preAppend(i);
        AllocationNode allocationNode = this.writeAllocationNode;
        int read = extractorInput.read(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), preAppend);
        if (read != -1) {
            postAppend(read);
            return read;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput
    public void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
        if (this.pendingFormatAdjustment) {
            format(this.lastUnadjustedFormat);
        }
        if (this.pendingSplice) {
            if ((i & 1) == 0 || !this.metadataQueue.attemptSplice(j)) {
                return;
            } else {
                this.pendingSplice = false;
            }
        }
        this.metadataQueue.commitSample(j + this.sampleOffsetUs, i, (this.totalBytesWritten - i2) - i3, i2, cryptoData);
    }

    public boolean setReadPosition(int i) {
        return this.metadataQueue.setReadPosition(i);
    }

    public void setSampleOffsetUs(long j) {
        if (this.sampleOffsetUs != j) {
            this.sampleOffsetUs = j;
            this.pendingFormatAdjustment = true;
        }
    }

    public void setUpstreamFormatChangeListener(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.upstreamFormatChangeListener = upstreamFormatChangedListener;
    }

    public void sourceId(int i) {
        this.metadataQueue.sourceId(i);
    }

    public void splice() {
        this.pendingSplice = true;
    }

    public void reset(boolean z) {
        this.metadataQueue.reset(z);
        clearAllocationNodes(this.firstAllocationNode);
        AllocationNode allocationNode = new AllocationNode(0L, this.allocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
        this.totalBytesWritten = 0L;
        this.allocator.trim();
    }

    private void readData(long j, byte[] bArr, int i) {
        advanceReadTo(j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (this.readAllocationNode.endPosition - j));
            AllocationNode allocationNode = this.readAllocationNode;
            System.arraycopy(allocationNode.allocation.data, allocationNode.translateOffset(j), bArr, i - i2, min);
            i2 -= min;
            j += min;
            AllocationNode allocationNode2 = this.readAllocationNode;
            if (j == allocationNode2.endPosition) {
                this.readAllocationNode = allocationNode2.next;
            }
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray, int i) {
        while (i > 0) {
            int preAppend = preAppend(i);
            AllocationNode allocationNode = this.writeAllocationNode;
            parsableByteArray.readBytes(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), preAppend);
            i -= preAppend;
            postAppend(preAppend);
        }
    }
}
