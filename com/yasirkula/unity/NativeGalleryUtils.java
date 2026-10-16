package com.yasirkula.unity;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Size;
import com.adjust.sdk.Constants;
import com.ironsource.C3040d4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/* loaded from: classes7.dex */
public class NativeGalleryUtils {
    private static int isMeizu;
    private static int isXiaomiOrMIUI;
    private static String secondaryStoragePath;

    public static boolean IsXiaomiOrMIUI() {
        BufferedReader bufferedReader;
        int i = isXiaomiOrMIUI;
        if (i > 0) {
            return true;
        }
        if (i < 0) {
            return false;
        }
        if (Constants.REFERRER_API_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER)) {
            isXiaomiOrMIUI = 1;
            return true;
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.miui.ui.version.name").getInputStream()), 1024);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception unused) {
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.length() > 0) {
                isXiaomiOrMIUI = 1;
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                return true;
            }
            isXiaomiOrMIUI = -1;
            try {
                bufferedReader.close();
            } catch (Exception unused3) {
            }
            return false;
        } catch (Exception unused4) {
            bufferedReader2 = bufferedReader;
            isXiaomiOrMIUI = -1;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused5) {
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused6) {
                }
            }
            throw th;
        }
    }

    public static boolean IsMeizu() {
        if (isMeizu == 0) {
            isMeizu = Build.MANUFACTURER.equalsIgnoreCase("meizu") ? 1 : -1;
        }
        return isMeizu == 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0120, code lost:
    
        if (r8 != null) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f1 A[Catch: Exception -> 0x0146, TRY_LEAVE, TryCatch #3 {Exception -> 0x0146, blocks: (B:6:0x0006, B:8:0x0012, B:11:0x0022, B:13:0x0034, B:15:0x0052, B:17:0x005a, B:19:0x005d, B:21:0x0064, B:23:0x0070, B:25:0x007c, B:27:0x0082, B:29:0x008a, B:31:0x009a, B:33:0x00a6, B:35:0x00b8, B:36:0x00da, B:37:0x00e5, B:39:0x00f1, B:54:0x0119, B:44:0x0122, B:63:0x012b, B:64:0x012e, B:70:0x0133, B:72:0x0140, B:74:0x00bb, B:76:0x00c3, B:77:0x00c6, B:79:0x00ce, B:80:0x00d1, B:82:0x00d7), top: B:5:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0133 A[Catch: Exception -> 0x0146, TryCatch #3 {Exception -> 0x0146, blocks: (B:6:0x0006, B:8:0x0012, B:11:0x0022, B:13:0x0034, B:15:0x0052, B:17:0x005a, B:19:0x005d, B:21:0x0064, B:23:0x0070, B:25:0x007c, B:27:0x0082, B:29:0x008a, B:31:0x009a, B:33:0x00a6, B:35:0x00b8, B:36:0x00da, B:37:0x00e5, B:39:0x00f1, B:54:0x0119, B:44:0x0122, B:63:0x012b, B:64:0x012e, B:70:0x0133, B:72:0x0140, B:74:0x00bb, B:76:0x00c3, B:77:0x00c6, B:79:0x00ce, B:80:0x00d1, B:82:0x00d7), top: B:5:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String GetPathFromURI(Context context, Uri uri) {
        String str;
        String[] strArr;
        Throwable th;
        Cursor cursor;
        String string;
        if (uri == null) {
            return null;
        }
        try {
            if (DocumentsContract.isDocumentUri(context.getApplicationContext(), uri)) {
                if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                    String[] split = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(split[0])) {
                        return Environment.getExternalStorageDirectory() + File.separator + split[1];
                    }
                    if ("raw".equalsIgnoreCase(split[0])) {
                        return split[1];
                    }
                    return GetSecondaryStoragePathFor(split[1]);
                }
                if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                    String documentId = DocumentsContract.getDocumentId(uri);
                    if (documentId.startsWith("raw:")) {
                        return documentId.substring(4);
                    }
                    if (documentId.indexOf(58) >= 0) {
                        return null;
                    }
                    uri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId));
                } else if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                    String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                    String str2 = split2[0];
                    if ("image".equals(str2)) {
                        uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str2)) {
                        uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str2)) {
                        uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    } else if ("raw".equals(str2)) {
                        return split2[1];
                    }
                    str = "_id=?";
                    strArr = new String[]{split2[1]};
                    if (!"content".equalsIgnoreCase(uri.getScheme())) {
                        try {
                            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
                            if (cursor != null) {
                                try {
                                    int columnIndexOrThrow = cursor.getColumnIndexOrThrow("_data");
                                    if (cursor.moveToFirst() && (string = cursor.getString(columnIndexOrThrow)) != null) {
                                        if (string.length() > 0) {
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            return string;
                                        }
                                    }
                                } catch (Exception unused) {
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (cursor != null) {
                                        cursor.close();
                                        throw th;
                                    }
                                    throw th;
                                }
                            }
                        } catch (Exception unused2) {
                            cursor = null;
                        } catch (Throwable th3) {
                            th = th3;
                            cursor = null;
                        }
                    } else {
                        Uri uri2 = uri;
                        if (C3040d4.h.b.equalsIgnoreCase(uri2.getScheme())) {
                            return uri2.getPath();
                        }
                    }
                    return null;
                }
            }
            str = null;
            strArr = null;
            if (!"content".equalsIgnoreCase(uri.getScheme())) {
            }
            return null;
        } catch (Exception e) {
            Log.e("Unity", "Exception:", e);
            return null;
        }
    }

    private static String GetSecondaryStoragePathFor(String localPath) {
        String str = secondaryStoragePath;
        if (str == null) {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            String str2 = System.getenv("SECONDARY_STORAGE");
            if (str2 == null || str2.length() == 0) {
                str2 = System.getenv("EXTERNAL_SDCARD_STORAGE");
            }
            if (str2 != null && str2.length() > 0) {
                if (!str2.contains(":")) {
                    str2 = str2 + ":";
                }
                for (String str3 : str2.split(":")) {
                    if (str3 != null && str3.length() > 0) {
                        File file = new File(str3);
                        if (file.exists() && file.isDirectory() && file.canRead() && !file.getAbsolutePath().equalsIgnoreCase(absolutePath)) {
                            String str4 = file.getAbsolutePath() + File.separator + localPath;
                            if (new File(str4).exists()) {
                                secondaryStoragePath = file.getAbsolutePath();
                                return str4;
                            }
                        }
                    }
                }
            }
            String[] strArr = {"/storage", "/mnt", "/storage/removable", "/removable", "/data", "/mnt/media_rw", "/mnt/sdcard0"};
            for (int i = 0; i < 7; i++) {
                try {
                    for (File file2 : new File(strArr[i]).listFiles()) {
                        if (file2.exists() && file2.isDirectory() && file2.canRead() && !file2.getAbsolutePath().equalsIgnoreCase(absolutePath)) {
                            String str5 = file2.getAbsolutePath() + File.separator + localPath;
                            if (new File(str5).exists()) {
                                secondaryStoragePath = file2.getAbsolutePath();
                                return str5;
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            secondaryStoragePath = "_NulL_";
            return null;
        }
        if (str.equals("_NulL_")) {
            return null;
        }
        return secondaryStoragePath + File.separator + localPath;
    }

    public static boolean WriteFileToStream(File file, OutputStream out) {
        try {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            out.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (Exception e) {
                            }
                        }
                    }
                    try {
                        out.close();
                        return true;
                    } catch (Exception e2) {
                        Log.e("Unity", "Exception:", e2);
                        return true;
                    }
                } finally {
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                        Log.e("Unity", "Exception:", e3);
                    }
                }
            } finally {
                try {
                    out.close();
                } catch (Exception e4) {
                    Log.e("Unity", "Exception:", e4);
                }
            }
        } catch (Exception e5) {
            Log.e("Unity", "Exception:", e5);
            return false;
        }
    }

    private static BitmapFactory.Options GetImageMetadata(final String path) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, options);
            return options;
        } catch (Exception e) {
            Log.e("Unity", "Exception:", e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0063, code lost:
    
        if (r2 != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0073, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0070, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006e, code lost:
    
        if (r2 != null) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int GetImageOrientation(Context context, final String path) {
        try {
            int attributeInt = new ExifInterface(path).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 0);
            if (attributeInt != 0) {
                return attributeInt;
            }
        } catch (Exception unused) {
        }
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(Uri.fromFile(new File(path)), new String[]{"orientation"}, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                int i = cursor.getInt(cursor.getColumnIndex("orientation"));
                if (i == 90) {
                    if (cursor == null) {
                        return 6;
                    }
                    cursor.close();
                    return 6;
                }
                if (i == 180) {
                    if (cursor == null) {
                        return 3;
                    }
                    cursor.close();
                    return 3;
                }
                if (i != 270) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return 1;
                }
                if (cursor == null) {
                    return 8;
                }
                cursor.close();
                return 8;
            }
        } catch (Exception unused2) {
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
                throw th;
            }
            throw th;
        }
    }

    private static Matrix GetImageOrientationCorrectionMatrix(final int orientation, final float scale) {
        Matrix matrix = new Matrix();
        switch (orientation) {
            case 2:
                matrix.postScale(-scale, scale);
                break;
            case 3:
                matrix.postRotate(180.0f);
                matrix.postScale(scale, scale);
                break;
            case 4:
                matrix.postScale(scale, -scale);
                break;
            case 5:
                matrix.postRotate(90.0f);
                matrix.postScale(-scale, scale);
                break;
            case 6:
                matrix.postRotate(90.0f);
                matrix.postScale(scale, scale);
                break;
            case 7:
                matrix.postRotate(270.0f);
                matrix.postScale(-scale, scale);
                break;
            case 8:
                matrix.postRotate(270.0f);
                matrix.postScale(scale, scale);
                break;
            default:
                matrix.postScale(scale, scale);
                break;
        }
        return matrix;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:50|51|(6:56|(1:58)|59|60|61|62)|65|(0)|59|60|61|62) */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String LoadImageAtPath(Context context, String path, final String temporaryFilePath, final int maxSize) {
        FileOutputStream fileOutputStream;
        BitmapFactory.Options GetImageMetadata = GetImageMetadata(path);
        if (GetImageMetadata == null) {
            return path;
        }
        boolean z = GetImageMetadata.outWidth > maxSize || GetImageMetadata.outHeight > maxSize;
        if (GetImageMetadata.outMimeType != null && !GetImageMetadata.outMimeType.equals("image/jpeg") && !GetImageMetadata.outMimeType.equals("image/png")) {
            z = true;
        }
        int GetImageOrientation = GetImageOrientation(context, path);
        if (GetImageOrientation != 1 && GetImageOrientation != 0) {
            z = true;
        }
        if (!z) {
            return path;
        }
        Bitmap bitmap = null;
        try {
            int i = GetImageMetadata.outHeight / 2;
            int i2 = GetImageMetadata.outWidth / 2;
            int i3 = 1;
            while (true) {
                if (i / i3 < maxSize && i2 / i3 < maxSize) {
                    break;
                }
                i3 *= 2;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i3;
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(path, options);
            try {
                float width = decodeFile.getWidth() > maxSize ? maxSize / decodeFile.getWidth() : 1.0f;
                float height = decodeFile.getHeight() > maxSize ? maxSize / decodeFile.getHeight() : 1.0f;
                if (width >= height) {
                    width = height;
                }
                if (width < 1.0f || (GetImageOrientation != 1 && GetImageOrientation != 0)) {
                    Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), GetImageOrientationCorrectionMatrix(GetImageOrientation, width), true);
                    if (createBitmap != decodeFile) {
                        decodeFile.recycle();
                        decodeFile = createBitmap;
                    }
                }
                fileOutputStream = new FileOutputStream(temporaryFilePath);
                try {
                    if (GetImageMetadata.outMimeType != null && GetImageMetadata.outMimeType.equals("image/jpeg")) {
                        decodeFile.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                        if (decodeFile != null) {
                            decodeFile.recycle();
                        }
                        fileOutputStream.close();
                        return temporaryFilePath;
                    }
                    decodeFile.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    if (decodeFile != null) {
                    }
                    fileOutputStream.close();
                    return temporaryFilePath;
                } catch (Exception e) {
                    e = e;
                    bitmap = decodeFile;
                    try {
                        Log.e("Unity", "Exception:", e);
                        try {
                            File file = new File(temporaryFilePath);
                            if (file.exists()) {
                                file.delete();
                            }
                        } catch (Exception unused) {
                        }
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        if (fileOutputStream == null) {
                            return path;
                        }
                        try {
                            fileOutputStream.close();
                            return path;
                        } catch (Exception unused2) {
                            return path;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bitmap = decodeFile;
                    if (bitmap != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    public static String GetImageProperties(Context context, final String path) {
        BitmapFactory.Options GetImageMetadata = GetImageMetadata(path);
        if (GetImageMetadata == null) {
            return "";
        }
        int i = GetImageMetadata.outWidth;
        int i2 = GetImageMetadata.outHeight;
        String str = GetImageMetadata.outMimeType;
        String str2 = str != null ? str : "";
        int GetImageOrientation = GetImageOrientation(context, path);
        int i3 = -1;
        if (GetImageOrientation != 0) {
            int i4 = 1;
            if (GetImageOrientation == 1) {
                i3 = 0;
            } else {
                if (GetImageOrientation != 6) {
                    i4 = 2;
                    int i5 = 3;
                    if (GetImageOrientation != 3) {
                        if (GetImageOrientation != 8) {
                            i5 = 4;
                            if (GetImageOrientation != 2) {
                                if (GetImageOrientation == 5) {
                                    i3 = 5;
                                } else if (GetImageOrientation == 4) {
                                    i3 = 6;
                                } else if (GetImageOrientation == 7) {
                                    i3 = 7;
                                }
                            }
                        }
                        i3 = i5;
                    }
                }
                i3 = i4;
            }
        }
        if (GetImageOrientation == 6 || GetImageOrientation == 8 || GetImageOrientation == 5 || GetImageOrientation == 7) {
            i2 = i;
            i = i2;
        }
        return i + ">" + i2 + ">" + str2 + ">" + i3;
    }

    public static String GetVideoProperties(Context context, final String path) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(path);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
                String extractMetadata4 = mediaMetadataRetriever.extractMetadata(24);
                if (extractMetadata == null) {
                    extractMetadata = "0";
                }
                if (extractMetadata2 == null) {
                    extractMetadata2 = "0";
                }
                if (extractMetadata3 == null) {
                    extractMetadata3 = "0";
                }
                if (extractMetadata4 == null) {
                    extractMetadata4 = "0";
                }
                return extractMetadata + ">" + extractMetadata2 + ">" + extractMetadata3 + ">" + extractMetadata4;
            } catch (Exception e) {
                Log.e("Unity", "Exception:", e);
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception unused) {
                }
                return "";
            }
        } finally {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0097, code lost:
    
        if (r23 > r0) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00c3 A[Catch: all -> 0x00b3, Exception -> 0x00b7, TRY_ENTER, TRY_LEAVE, TryCatch #4 {Exception -> 0x00b7, blocks: (B:58:0x0055, B:92:0x00b2, B:19:0x00c3), top: B:57:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0055 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String GetVideoThumbnail(Context context, final String path, final String savePath, final boolean saveAsJpeg, int maxSize, double captureTime) {
        Bitmap bitmap;
        FileOutputStream fileOutputStream;
        Throwable th;
        Exception e;
        MediaMetadataRetriever mediaMetadataRetriever;
        int i;
        double d;
        Bitmap createVideoThumbnail;
        Bitmap bitmap2 = null;
        if (captureTime < 0.0d) {
            try {
                if (maxSize <= 1024) {
                    try {
                        if (Build.VERSION.SDK_INT < 29) {
                            createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(path, maxSize > 512 ? 2 : 1);
                        } else {
                            createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(new File(path), maxSize > 512 ? new Size(1024, 786) : new Size(512, 384), null);
                        }
                        bitmap = createVideoThumbnail;
                    } catch (Exception e2) {
                        try {
                            Log.e("Unity", "Exception:", e2);
                        } catch (Exception e3) {
                            e = e3;
                            fileOutputStream = null;
                            try {
                                Log.e("Unity", "Exception:", e);
                                if (bitmap2 != null) {
                                    bitmap2.recycle();
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception unused) {
                                    }
                                }
                                return "";
                            } catch (Throwable th2) {
                                th = th2;
                                if (bitmap2 != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                throw th;
                            }
                        }
                    }
                    if (bitmap == null) {
                        try {
                            try {
                                mediaMetadataRetriever = new MediaMetadataRetriever();
                                try {
                                    mediaMetadataRetriever.setDataSource(path);
                                    try {
                                        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                                        int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                                        if (maxSize <= parseInt || maxSize <= parseInt2) {
                                            parseInt = maxSize;
                                        } else if (parseInt <= parseInt2) {
                                            parseInt = parseInt2;
                                        }
                                        i = parseInt;
                                    } catch (Exception unused2) {
                                        i = maxSize;
                                    }
                                    if (captureTime < 0.0d) {
                                        d = 0.0d;
                                    } else {
                                        try {
                                            d = Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) / 1000.0d;
                                        } catch (Exception unused3) {
                                        }
                                    }
                                    bitmap = mediaMetadataRetriever.getScaledFrameAtTime((long) (d * 1000000.0d), 2, i, i);
                                } finally {
                                    try {
                                        mediaMetadataRetriever.release();
                                    } catch (Exception unused4) {
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                                fileOutputStream = null;
                                bitmap2 = bitmap;
                                Log.e("Unity", "Exception:", e);
                                if (bitmap2 != null) {
                                }
                                if (fileOutputStream != null) {
                                }
                                return "";
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                            bitmap2 = bitmap;
                            if (bitmap2 != null) {
                            }
                            if (fileOutputStream != null) {
                            }
                            throw th;
                        }
                    }
                    if (bitmap == null) {
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        return "";
                    }
                    fileOutputStream = new FileOutputStream(savePath);
                    try {
                        if (saveAsJpeg) {
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                        } else {
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        }
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Exception unused5) {
                        }
                        return savePath;
                    } catch (Exception e5) {
                        e = e5;
                        bitmap2 = bitmap;
                        Log.e("Unity", "Exception:", e);
                        if (bitmap2 != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        return "";
                    } catch (Throwable th4) {
                        th = th4;
                        bitmap2 = bitmap;
                        if (bitmap2 != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        throw th;
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused6) {
                    }
                }
                throw th;
            }
        }
        bitmap = null;
        if (bitmap == null) {
        }
        if (bitmap == null) {
        }
        d = captureTime;
        bitmap = mediaMetadataRetriever.getScaledFrameAtTime((long) (d * 1000000.0d), 2, i, i);
        if (bitmap == null) {
        }
    }
}
