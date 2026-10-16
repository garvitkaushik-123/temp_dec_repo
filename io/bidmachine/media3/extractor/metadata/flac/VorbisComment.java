package io.bidmachine.media3.extractor.metadata.flac;

import com.google.common.base.Ascii;
import com.google.common.primitives.Ints;
import com.ironsource.C3040d4;
import com.ironsource.mediationsdk.logger.IronSourceError;
import io.bidmachine.media3.common.MediaMetadata;
import io.bidmachine.media3.common.Metadata;

@Deprecated
/* loaded from: classes7.dex */
public class VorbisComment implements Metadata.Entry {
    public final String key;
    public final String value;

    public VorbisComment(String str, String str2) {
        this.key = Ascii.toUpperCase(str);
        this.value = str2;
    }

    @Override // io.bidmachine.media3.common.Metadata.Entry
    public void populateMediaMetadata(MediaMetadata.Builder builder) {
        String str = this.key;
        str.hashCode();
        switch (str) {
            case "TOTALTRACKS":
                Integer tryParse = Ints.tryParse(this.value);
                if (tryParse != null) {
                    builder.setTotalTrackCount(tryParse);
                    break;
                }
                break;
            case "TOTALDISCS":
                Integer tryParse2 = Ints.tryParse(this.value);
                if (tryParse2 != null) {
                    builder.setTotalDiscCount(tryParse2);
                    break;
                }
                break;
            case "TRACKNUMBER":
                Integer tryParse3 = Ints.tryParse(this.value);
                if (tryParse3 != null) {
                    builder.setTrackNumber(tryParse3);
                    break;
                }
                break;
            case "ALBUM":
                builder.setAlbumTitle(this.value);
                break;
            case "GENRE":
                builder.setGenre(this.value);
                break;
            case "TITLE":
                builder.setTitle(this.value);
                break;
            case "DESCRIPTION":
                builder.setDescription(this.value);
                break;
            case "DISCNUMBER":
                Integer tryParse4 = Ints.tryParse(this.value);
                if (tryParse4 != null) {
                    builder.setDiscNumber(tryParse4);
                    break;
                }
                break;
            case "ALBUMARTIST":
                builder.setAlbumArtist(this.value);
                break;
            case "ARTIST":
                builder.setArtist(this.value);
                break;
        }
    }

    public String toString() {
        return "VC: " + this.key + C3040d4.i.b + this.value;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            VorbisComment vorbisComment = (VorbisComment) obj;
            if (this.key.equals(vorbisComment.key) && this.value.equals(vorbisComment.value)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.key.hashCode()) * 31) + this.value.hashCode();
    }
}
