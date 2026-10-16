package com.bytedance.sdk.component.kb.Os;

/* loaded from: classes3.dex */
public class Os {
    private DbA DbA;
    private eli eli;

    public interface DbA {
    }

    public enum eli {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    private Os() {
        this.eli = eli.OFF;
        this.DbA = new com.bytedance.sdk.component.kb.Os.DbA();
    }

    /* renamed from: com.bytedance.sdk.component.kb.Os.Os$Os, reason: collision with other inner class name */
    private static class C0145Os {
        private static final Os eli = new Os();
    }

    public static void eli(eli eliVar) {
        synchronized (Os.class) {
            C0145Os.eli.eli = eliVar;
        }
    }
}
