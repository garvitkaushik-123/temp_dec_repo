package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public final class RawResourceDataSource implements DataSource {
    public static final String RAW_RESOURCE_SCHEME = "rawresource";
    private AssetFileDescriptor assetFileDescriptor;
    private long bytesRemaining;
    private InputStream inputStream;
    private final TransferListener<? super RawResourceDataSource> listener;
    private boolean opened;
    private final Resources resources;
    private Uri uri;

    public static class RawResourceDataSourceException extends IOException {
        public RawResourceDataSourceException(String str) {
            super(str);
        }

        public RawResourceDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public RawResourceDataSource(Context context) {
        this(context, null);
    }

    public static Uri buildRawResourceUri(int i) {
        return Uri.parse("rawresource:///" + i);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource
    public void close() throws RawResourceDataSourceException {
        this.uri = null;
        try {
            try {
                InputStream inputStream = this.inputStream;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.inputStream = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.assetFileDescriptor;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e) {
                        throw new RawResourceDataSourceException(e);
                    }
                } finally {
                    this.assetFileDescriptor = null;
                    if (this.opened) {
                        this.opened = false;
                        TransferListener<? super RawResourceDataSource> transferListener = this.listener;
                        if (transferListener != null) {
                            transferListener.onTransferEnd(this);
                        }
                    }
                }
            } catch (IOException e2) {
                throw new RawResourceDataSourceException(e2);
            }
        } catch (Throwable th) {
            this.inputStream = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.assetFileDescriptor;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.assetFileDescriptor = null;
                    if (this.opened) {
                        this.opened = false;
                        TransferListener<? super RawResourceDataSource> transferListener2 = this.listener;
                        if (transferListener2 != null) {
                            transferListener2.onTransferEnd(this);
                        }
                    }
                    throw th;
                } catch (IOException e3) {
                    throw new RawResourceDataSourceException(e3);
                }
            } finally {
                this.assetFileDescriptor = null;
                if (this.opened) {
                    this.opened = false;
                    TransferListener<? super RawResourceDataSource> transferListener3 = this.listener;
                    if (transferListener3 != null) {
                        transferListener3.onTransferEnd(this);
                    }
                }
            }
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws RawResourceDataSourceException {
        try {
            Uri uri = dataSpec.uri;
            this.uri = uri;
            if (!TextUtils.equals("rawresource", uri.getScheme())) {
                throw new RawResourceDataSourceException("URI must use scheme rawresource");
            }
            try {
                this.assetFileDescriptor = this.resources.openRawResourceFd(Integer.parseInt(this.uri.getLastPathSegment()));
                FileInputStream fileInputStream = new FileInputStream(this.assetFileDescriptor.getFileDescriptor());
                this.inputStream = fileInputStream;
                fileInputStream.skip(this.assetFileDescriptor.getStartOffset());
                if (this.inputStream.skip(dataSpec.position) < dataSpec.position) {
                    throw new EOFException();
                }
                long j = dataSpec.length;
                long j2 = -1;
                if (j != -1) {
                    this.bytesRemaining = j;
                } else {
                    long length = this.assetFileDescriptor.getLength();
                    if (length != -1) {
                        j2 = length - dataSpec.position;
                    }
                    this.bytesRemaining = j2;
                }
                this.opened = true;
                TransferListener<? super RawResourceDataSource> transferListener = this.listener;
                if (transferListener != null) {
                    transferListener.onTransferStart(this, dataSpec);
                }
                return this.bytesRemaining;
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.");
            }
        } catch (IOException e) {
            throw new RawResourceDataSourceException(e);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) throws RawResourceDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.bytesRemaining;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new RawResourceDataSourceException(e);
            }
        }
        int read = this.inputStream.read(bArr, i, i2);
        if (read == -1) {
            if (this.bytesRemaining == -1) {
                return -1;
            }
            throw new RawResourceDataSourceException(new EOFException());
        }
        long j2 = this.bytesRemaining;
        if (j2 != -1) {
            this.bytesRemaining = j2 - read;
        }
        TransferListener<? super RawResourceDataSource> transferListener = this.listener;
        if (transferListener != null) {
            transferListener.onBytesTransferred(this, read);
        }
        return read;
    }

    public RawResourceDataSource(Context context, TransferListener<? super RawResourceDataSource> transferListener) {
        this.resources = context.getResources();
        this.listener = transferListener;
    }
}
