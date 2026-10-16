package io.bidmachine.media3.exoplayer.source.chunk;

/* loaded from: classes7.dex */
public final class ChunkHolder {
    public Chunk chunk;
    public boolean endOfStream;

    public void clear() {
        this.chunk = null;
        this.endOfStream = false;
    }
}
