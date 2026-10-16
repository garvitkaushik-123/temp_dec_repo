package com.yasirkula.unity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

/* loaded from: classes7.dex */
public class NativeGalleryMediaPickerResultOperation {
    private boolean cancelled;
    private final Context context;
    private final Intent data;
    public boolean finished;
    private final NativeGalleryMediaReceiver mediaReceiver;
    public int progress;
    private final String savePathDirectory;
    private final String savePathFilename;
    private ArrayList<String> savedFiles;
    private final boolean selectMultiple;
    public boolean sentResult;
    private String unityResult;

    public NativeGalleryMediaPickerResultOperation(final Context context, final NativeGalleryMediaReceiver mediaReceiver, final Intent data, final boolean selectMultiple, final String savePathDirectory, final String savePathFilename) {
        this.context = context;
        this.mediaReceiver = mediaReceiver;
        this.data = data;
        this.selectMultiple = selectMultiple;
        this.savePathDirectory = savePathDirectory;
        this.savePathFilename = savePathFilename;
    }

    public void execute() {
        this.unityResult = "";
        this.progress = -1;
        try {
            if (this.selectMultiple && this.data.getClipData() != null) {
                int itemCount = this.data.getClipData().getItemCount();
                boolean z = true;
                for (int i = 0; i < itemCount && !this.cancelled; i++) {
                    String pathFromURI = getPathFromURI(this.data.getClipData().getItemAt(i).getUri());
                    if (pathFromURI != null && pathFromURI.length() > 0 && new File(pathFromURI).exists()) {
                        if (z) {
                            this.unityResult += pathFromURI;
                            z = false;
                        } else {
                            this.unityResult += ">" + pathFromURI;
                        }
                    }
                    Log.d("Unity", "NativeGalleryMediaPickerResultOperation: " + pathFromURI);
                }
            }
            String pathFromURI2 = getPathFromURI(this.data.getData());
            if (pathFromURI2 != null && pathFromURI2.length() > 0 && new File(pathFromURI2).exists()) {
                this.unityResult = pathFromURI2;
            }
            Log.d("Unity", "NativeGalleryMediaPickerResultOperation: " + pathFromURI2);
        } catch (Exception e) {
            Log.e("Unity", "Exception:", e);
        } finally {
            this.progress = 100;
            this.finished = true;
        }
    }

    public void cancel() {
        if (this.cancelled || this.finished) {
            return;
        }
        Log.d("Unity", "Cancelled NativeGalleryMediaPickerResultOperation!");
        this.cancelled = true;
        this.unityResult = "";
    }

    public void sendResultToUnity() {
        if (this.sentResult) {
            return;
        }
        this.sentResult = true;
        NativeGalleryMediaReceiver nativeGalleryMediaReceiver = this.mediaReceiver;
        if (nativeGalleryMediaReceiver == null) {
            Log.d("Unity", "NativeGalleryMediaPickerResultOperation.mediaReceiver became null in sendResultToUnity!");
        } else if (this.selectMultiple) {
            nativeGalleryMediaReceiver.OnMultipleMediaReceived(this.unityResult);
        } else {
            nativeGalleryMediaReceiver.OnMediaReceived(this.unityResult);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getPathFromURI(Uri uri) {
        FileInputStream fileInputStream;
        Exception e;
        FileInputStream fileInputStream2 = null;
        if (uri == null) {
            return null;
        }
        Log.d("Unity", "Selected media uri: " + uri.toString());
        String GetPathFromURI = NativeGalleryUtils.GetPathFromURI(this.context, uri);
        if (GetPathFromURI != null && GetPathFromURI.length() > 0) {
            try {
                fileInputStream = new FileInputStream(new File(GetPathFromURI));
                try {
                    try {
                        fileInputStream.read();
                        if (NativeGalleryMediaPickerFragment.ShouldGrantPersistableUriPermission(this.context)) {
                            this.context.getContentResolver().takePersistableUriPermission(uri, 1);
                        }
                        try {
                            fileInputStream.close();
                        } catch (Exception unused) {
                        }
                        return GetPathFromURI;
                    } catch (Exception e2) {
                        e = e2;
                        Log.e("Unity", "Media uri isn't accessible via File API: " + uri, e);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        return copyToTempFile(uri);
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (Exception unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e3) {
                fileInputStream = null;
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream2 != null) {
                }
                throw th;
            }
        }
        return copyToTempFile(uri);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x005b, code lost:
    
        if (r5.length() >= 3) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x005f, code lost:
    
        r0 = r5.lastIndexOf(46);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x00e1, code lost:
    
        r12 = r2.available();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0066, code lost:
    
        if (r0 <= 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00d1, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x00d2, code lost:
    
        r2 = "Exception:";
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0204, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0205, code lost:
    
        r17 = "Exception:";
        r16 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x00ab, code lost:
    
        if (r5.endsWith(r0) == false) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x00ad, code lost:
    
        r5 = r5.substring(0, r5.length() - r0.length());
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0074, code lost:
    
        r0 = r2.getType(r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0078, code lost:
    
        if (r0 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x007a, code lost:
    
        r0 = android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0082, code lost:
    
        if (r0 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0088, code lost:
    
        if (r0.length() <= 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x008a, code lost:
    
        r0 = "." + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x009a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x005d, code lost:
    
        r5 = "temp";
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006d, code lost:
    
        if (r0 >= (r5.length() - 1)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0051, code lost:
    
        if (r4 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006f, code lost:
    
        r0 = r5.substring(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x009b, code lost:
    
        if (r0 != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x009d, code lost:
    
        r0 = ".tmp";
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00a2, code lost:
    
        if (com.yasirkula.unity.NativeGalleryMediaPickerFragment.tryPreserveFilenames != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a4, code lost:
    
        r5 = r20.savePathFilename;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ba, code lost:
    
        r2 = r2.openInputStream(r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00be, code lost:
    
        if (r2 != null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c0, code lost:
    
        android.util.Log.w("Unity", "Couldn't open input stream: " + r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d0, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d7, code lost:
    
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00db, code lost:
    
        if (r12 >= 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0042, code lost:
    
        if (r4 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0044, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0054, code lost:
    
        if (r5 == null) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01fb A[Catch: Exception -> 0x0202, TryCatch #13 {Exception -> 0x0202, blocks: (B:72:0x01fb, B:73:0x01fe, B:74:0x0201, B:93:0x01da, B:94:0x01dd), top: B:43:0x0137 }] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v10 */
    /* JADX WARN: Type inference failed for: r17v11 */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARN: Type inference failed for: r17v8 */
    /* JADX WARN: Type inference failed for: r17v9, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String copyToTempFile(Uri uri) {
        Cursor cursor;
        String str;
        String str2;
        ?? r17;
        InputStream openInputStream;
        FileOutputStream fileOutputStream;
        String str3 = "Exception:";
        ContentResolver contentResolver = this.context.getContentResolver();
        Cursor cursor2 = null;
        long j = -1;
        try {
            cursor = contentResolver.query(uri, null, null, null, null);
            if (cursor != null) {
                try {
                    try {
                        if (cursor.moveToFirst()) {
                            str = cursor.getString(cursor.getColumnIndex("_display_name"));
                            try {
                                j = cursor.getLong(cursor.getColumnIndex("_size"));
                            } catch (Exception e) {
                                e = e;
                                Log.e("Unity", "Exception:", e);
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            str = null;
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            str = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
        if (j < 0) {
            j = 0;
        }
        String str4 = str + str2;
        ?? r16 = -1;
        if (this.savedFiles != null) {
            r17 = 1;
            int i = 0;
            while (i < this.savedFiles.size()) {
                if (this.savedFiles.get(i).equals(str4)) {
                    int i2 = r17 + 1;
                    str4 = str + i2 + str2;
                    r17 = i2;
                    i = -1;
                }
                i++;
                r17 = r17;
            }
        }
        try {
            File file = new File(this.savePathDirectory, str4);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
                int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                try {
                    this.progress = i3 > 0 ? 0 : -1;
                    byte[] bArr = new byte[4096];
                    fileOutputStream = null;
                    while (true) {
                        try {
                            int read = openInputStream.read(bArr);
                            if (read <= 0 || this.cancelled) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                            if (i3 > 0) {
                                String str5 = str3;
                                long j2 = j2 + read;
                                FileOutputStream fileOutputStream3 = fileOutputStream2;
                                int i4 = i3;
                                int i5 = (int) ((j2 / j) * 100.0d);
                                try {
                                    this.progress = i5;
                                    if (i5 > 100) {
                                        this.progress = 100;
                                    }
                                    fileOutputStream2 = fileOutputStream3;
                                    str3 = str5;
                                    i3 = i4;
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileOutputStream2 = fileOutputStream3;
                                    if (fileOutputStream2 != null) {
                                    }
                                    openInputStream.close();
                                    throw th;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                    FileOutputStream fileOutputStream4 = fileOutputStream2;
                    int i6 = i3;
                    if (this.cancelled) {
                        fileOutputStream4.close();
                        try {
                            file.delete();
                            fileOutputStream2 = null;
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream2 = fileOutputStream;
                            if (fileOutputStream2 != null) {
                            }
                            openInputStream.close();
                            throw th;
                        }
                    } else {
                        if (i6 > 0) {
                            this.progress = 100;
                        }
                        fileOutputStream2 = fileOutputStream4;
                    }
                    try {
                        if (this.selectMultiple) {
                            if (this.savedFiles == null) {
                                this.savedFiles = new ArrayList<>();
                            }
                            this.savedFiles.add(str4);
                        }
                        Log.d("Unity", "Copied media from " + uri + " to: " + file.getAbsolutePath());
                        String absolutePath = file.getAbsolutePath();
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        openInputStream.close();
                        return absolutePath;
                    } catch (Throwable th6) {
                        th = th6;
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        openInputStream.close();
                        throw th;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Throwable th8) {
                th = th8;
                fileOutputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            String str6 = r17;
            String str7 = r16;
            Log.e("Unity", str6, e);
            return str7;
        }
    }
}
