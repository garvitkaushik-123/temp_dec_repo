package com.bykv.vk.openvk.preload.geckox.a;

import com.bykv.vk.openvk.preload.geckox.utils.f;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ChannelCleanHelper.java */
/* loaded from: classes3.dex */
public final class c {
    public static void a(final String str) {
        f.a().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.a.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    c.c(str);
                } catch (Throwable th) {
                    com.bykv.vk.openvk.preload.geckox.utils.a.a(new RuntimeException("delete old channel version failed，path：" + str, th));
                }
            }
        });
    }

    public static boolean b(String str) {
        try {
            com.bykv.vk.openvk.preload.geckox.g.a a2 = com.bykv.vk.openvk.preload.geckox.g.a.a(str + File.separator + "update.lock");
            if (a2 == null) {
                return true;
            }
            try {
                com.bykv.vk.openvk.preload.geckox.g.b a3 = com.bykv.vk.openvk.preload.geckox.g.b.a(str + File.separator + "select.lock");
                try {
                    com.bykv.vk.openvk.preload.geckox.utils.b.c(new File(str));
                } catch (Throwable unused) {
                }
                a3.a();
                return true;
            } finally {
                a2.a();
            }
        } catch (Throwable unused2) {
            return false;
        }
    }

    private static List<File> a(File[] fileArr) {
        long j;
        ArrayList<File> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        File file = null;
        long j2 = -1;
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (name.endsWith("--updating")) {
                arrayList.add(file2);
            } else if (name.endsWith("--pending-delete")) {
                a(file2);
            } else {
                try {
                    long parseLong = Long.parseLong(name);
                    if (parseLong > j2) {
                        if (file != null) {
                            try {
                                arrayList2.add(file);
                            } catch (Exception unused) {
                                j2 = parseLong;
                                a(file2);
                            }
                        }
                        file = file2;
                        j2 = parseLong;
                    } else {
                        arrayList2.add(file2);
                    }
                } catch (Exception unused2) {
                }
            }
        }
        for (File file3 : arrayList) {
            String name2 = file3.getName();
            int indexOf = name2.indexOf("--updating");
            if (indexOf == -1) {
                a(file3);
            } else {
                try {
                    j = Long.parseLong(name2.substring(0, indexOf));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    j = -1;
                }
                if (j <= j2) {
                    a(file3);
                }
            }
        }
        return arrayList2;
    }

    private static void a(final File file) {
        com.bykv.vk.openvk.preload.geckox.utils.c.a().execute(new Runnable() { // from class: com.bykv.vk.openvk.preload.geckox.a.c.3
            @Override // java.lang.Runnable
            public final void run() {
                com.bykv.vk.openvk.preload.geckox.utils.b.a(file);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006d A[Catch: all -> 0x00a2, LOOP:0: B:21:0x0067->B:23:0x006d, LOOP_END, TRY_LEAVE, TryCatch #0 {all -> 0x00a2, blocks: (B:8:0x003c, B:10:0x004c, B:12:0x004f, B:15:0x0054, B:17:0x005c, B:20:0x0063, B:21:0x0067, B:23:0x006d), top: B:7:0x003c, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ void c(String str) throws Exception {
        List<File> list;
        Iterator<File> it;
        com.bykv.vk.openvk.preload.geckox.g.a a2 = com.bykv.vk.openvk.preload.geckox.g.a.a(str + File.separator + "update.lock");
        if (a2 != null) {
            try {
                com.bykv.vk.openvk.preload.geckox.g.b a3 = com.bykv.vk.openvk.preload.geckox.g.b.a(str + File.separator + "select.lock");
                try {
                    File[] listFiles = new File(str).listFiles(new FileFilter() { // from class: com.bykv.vk.openvk.preload.geckox.a.c.2
                        @Override // java.io.FileFilter
                        public final boolean accept(File file) {
                            return file.isDirectory();
                        }
                    });
                    if (listFiles != null && listFiles.length != 0 && listFiles.length != 1) {
                        list = a(listFiles);
                        if (list != null && !list.isEmpty()) {
                            it = list.iterator();
                            while (it.hasNext()) {
                                com.bykv.vk.openvk.preload.geckox.g.c.c(it.next().getAbsolutePath() + File.separator + "using.lock");
                            }
                        }
                    }
                    list = null;
                    if (list != null) {
                        it = list.iterator();
                        while (it.hasNext()) {
                        }
                    }
                } finally {
                    a3.a();
                }
            } finally {
                a2.a();
            }
        }
    }

    public c(Field field) {
        com.bykv.vk.openvk.preload.falconx.a.a.a(field);
    }
}
