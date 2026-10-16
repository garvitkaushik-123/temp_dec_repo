package com.fyber.inneractive.sdk.external;

/* loaded from: classes4.dex */
public class InneractiveVideoError extends InneractiveError {

    /* renamed from: a, reason: collision with root package name */
    public final Error f1162a;
    public final Throwable b;

    public enum Error {
        ERROR_NO_MEDIA_FILES("ErrorNoMediaFiles", true),
        ERROR_FAILED_PLAYING_MEDIA_FILE("ErrorPlayingMediaFile", false),
        ERROR_FAILED_PLAYING_ALL_MEDIA_FILES("ErrorPlayingAllMediaFile", true),
        ERROR_PRE_BUFFER_TIMEOUT("ErrorPreBufferTimeout", false),
        ERROR_BUFFER_TIMEOUT("ErrorBufferTimeout", false);

        private String errorString;
        private boolean isFatal;

        Error(String str, boolean z) {
            this.errorString = str;
            this.isFatal = z;
        }

        public String getErrorString() {
            return this.errorString;
        }

        public boolean isFatal() {
            return this.isFatal;
        }
    }

    public InneractiveVideoError(Error error) {
        this.f1162a = error;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveError
    public String description() {
        return this.b != null ? this.f1162a.getErrorString() + ": " + this.b : this.f1162a.getErrorString();
    }

    public Throwable getCause() {
        return this.b;
    }

    public Error getPlayerError() {
        return this.f1162a;
    }

    public InneractiveVideoError(Error error, Throwable th) {
        this(error);
        this.b = th;
    }
}
