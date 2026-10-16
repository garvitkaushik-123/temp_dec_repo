package com.mbridge.msdk.playercommon.exoplayer2.offline;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public abstract class SegmentDownloadAction<K extends Comparable<K>> extends DownloadAction {
    public final List<K> keys;

    protected static abstract class SegmentDownloadActionDeserializer<K> extends DownloadAction.Deserializer {
        public SegmentDownloadActionDeserializer(String str, int i) {
            super(str, i);
        }

        protected abstract DownloadAction createDownloadAction(Uri uri, boolean z, byte[] bArr, List<K> list);

        @Override // com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction.Deserializer
        public final DownloadAction readFromStream(int i, DataInputStream dataInputStream) throws IOException {
            Uri parse = Uri.parse(dataInputStream.readUTF());
            boolean readBoolean = dataInputStream.readBoolean();
            byte[] bArr = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(bArr);
            int readInt = dataInputStream.readInt();
            List<K> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(readKey(dataInputStream));
            }
            return createDownloadAction(parse, readBoolean, bArr, arrayList);
        }

        protected abstract K readKey(DataInputStream dataInputStream) throws IOException;
    }

    protected SegmentDownloadAction(String str, int i, Uri uri, boolean z, byte[] bArr, List<K> list) {
        super(str, i, uri, z, bArr);
        if (z) {
            Assertions.checkArgument(list.isEmpty());
            this.keys = Collections.emptyList();
        } else {
            ArrayList arrayList = new ArrayList(list);
            Collections.sort(arrayList);
            this.keys = Collections.unmodifiableList(arrayList);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj)) {
            return this.keys.equals(((SegmentDownloadAction) obj).keys);
        }
        return false;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction
    public int hashCode() {
        return (super.hashCode() * 31) + this.keys.hashCode();
    }

    protected abstract void writeKey(DataOutputStream dataOutputStream, K k) throws IOException;

    @Override // com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadAction
    public final void writeToStream(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeUTF(this.uri.toString());
        dataOutputStream.writeBoolean(this.isRemoveAction);
        dataOutputStream.writeInt(this.data.length);
        dataOutputStream.write(this.data);
        dataOutputStream.writeInt(this.keys.size());
        for (int i = 0; i < this.keys.size(); i++) {
            writeKey(dataOutputStream, this.keys.get(i));
        }
    }
}
