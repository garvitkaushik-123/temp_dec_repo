package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final BufferedReader f1426a;
    public final Queue b;
    public String c;

    public f(LinkedList linkedList, BufferedReader bufferedReader) {
        this.b = linkedList;
        this.f1426a = bufferedReader;
    }

    public final boolean a() {
        String trim;
        if (this.c != null) {
            return true;
        }
        if (!this.b.isEmpty()) {
            this.c = (String) this.b.poll();
            return true;
        }
        do {
            String readLine = this.f1426a.readLine();
            this.c = readLine;
            if (readLine == null) {
                return false;
            }
            trim = readLine.trim();
            this.c = trim;
        } while (trim.isEmpty());
        return true;
    }
}
