package com.yasirkula.unity;

import android.app.Activity;
import android.app.RemoteAction;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes7.dex */
public class NativeGallery {
    public static final int MEDIA_TYPE_AUDIO = 4;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    public static boolean PermissionFreeMode = false;
    public static boolean mediaSaveOmitDCIM = false;
    public static boolean overwriteExistingMedia = false;

    public static boolean CanSelectMultipleMedia() {
        return true;
    }

    public static boolean CanSelectMultipleMediaTypes() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:166:0x0216, code lost:
    
        if (r6 == null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0230, code lost:
    
        r0 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0231, code lost:
    
        if (r0 != null) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0233, code lost:
    
        r0 = r31.getContentResolver().insert(r10, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x022d, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x022b, code lost:
    
        if (r6 == null) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0484, code lost:
    
        if (r6 == null) goto L248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0486, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x049a, code lost:
    
        if (r1 != null) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:251:0x049c, code lost:
    
        r31.getContentResolver().insert(r10, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x04a4, code lost:
    
        r31.getContentResolver().update(r1, r13, null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0497, code lost:
    
        if (r6 != null) goto L237;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x04de A[Catch: Exception -> 0x04e2, TryCatch #7 {Exception -> 0x04e2, blocks: (B:234:0x0424, B:236:0x042f, B:238:0x043c, B:239:0x04ac, B:249:0x0486, B:251:0x049c, B:252:0x04a4, B:270:0x04de, B:271:0x04e1), top: B:233:0x0424 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x037e A[LOOP:0: B:43:0x0130->B:64:0x037e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x04e8 A[EDGE_INSN: B:65:0x04e8->B:66:0x04e8 BREAK  A[LOOP:0: B:43:0x0130->B:64:0x037e], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String SaveMedia(Context context, int mediaType, String filePath, String directoryName) {
        Uri uri;
        String str;
        String str2;
        String str3;
        Cursor cursor;
        Uri uri2;
        Cursor cursor2;
        File file;
        String str4;
        String str5;
        Cursor cursor3;
        String str6;
        String str7;
        Cursor cursor4;
        Uri uri3;
        Uri uri4;
        String str8;
        File file2;
        String str9;
        String str10;
        Context context2;
        String GetPathFromURI;
        Intent intent;
        String str11;
        File file3 = new File(filePath);
        if (!file3.exists()) {
            Log.e("Unity", "Original media file is missing or inaccessible!");
            return "";
        }
        int lastIndexOf = filePath.lastIndexOf(47);
        int lastIndexOf2 = filePath.lastIndexOf(46);
        String substring = lastIndexOf >= 0 ? filePath.substring(lastIndexOf + 1) : filePath;
        String substring2 = lastIndexOf2 >= 0 ? filePath.substring(lastIndexOf2 + 1) : "";
        String mimeTypeFromExtension = substring2.length() > 0 ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(substring2.toLowerCase(Locale.ENGLISH)) : null;
        ContentValues contentValues = new ContentValues();
        String str12 = "title";
        contentValues.put("title", substring);
        String str13 = "_display_name";
        contentValues.put("_display_name", substring);
        contentValues.put("date_added", Long.valueOf(System.currentTimeMillis() / 1000));
        if (mimeTypeFromExtension != null && mimeTypeFromExtension.length() > 0) {
            contentValues.put("mime_type", mimeTypeFromExtension);
        }
        if (mediaType == 1) {
            int GetImageOrientation = NativeGalleryUtils.GetImageOrientation(context, filePath);
            if (GetImageOrientation == 3) {
                contentValues.put("orientation", (Integer) 180);
            } else if (GetImageOrientation == 5 || GetImageOrientation == 6) {
                contentValues.put("orientation", (Integer) 90);
            } else if (GetImageOrientation == 7 || GetImageOrientation == 8) {
                contentValues.put("orientation", (Integer) 270);
            }
        }
        if (mediaType == 1) {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (mediaType == 2) {
            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else {
            uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        }
        String str14 = "android.intent.action.MEDIA_SCANNER_SCAN_FILE";
        String str15 = "Saved media to: ";
        String str16 = "Exception:";
        if (Build.VERSION.SDK_INT >= 29) {
            if (mediaSaveOmitDCIM) {
                str4 = directoryName + RemoteSettings.FORWARD_SLASH_STRING;
                file = file3;
            } else {
                file = file3;
                str4 = (mediaType != 4 ? "DCIM/" : "Music/") + directoryName + RemoteSettings.FORWARD_SLASH_STRING;
            }
            String str17 = "relative_path";
            contentValues.put("relative_path", str4);
            contentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
            int i = 0;
            while (i < 2) {
                contentValues.put("is_pending", (Boolean) true);
                if (i == 1) {
                    str5 = substring;
                    String str18 = ((substring2.length() <= 0 || substring.length() <= substring2.length()) ? substring : substring.substring(0, (substring.length() - substring2.length()) - 1)) + " " + new SimpleDateFormat("yyyy-MM-dd'T'HH.mm.ss").format(new Date());
                    if (substring2.length() > 0) {
                        str18 = str18 + "." + substring2;
                    }
                    contentValues.put(str12, str18);
                    contentValues.put(str13, str18);
                } else {
                    str5 = substring;
                }
                if (!overwriteExistingMedia) {
                    uri4 = context.getContentResolver().insert(uri, contentValues);
                    str6 = str12;
                    str7 = str13;
                } else {
                    try {
                        try {
                            Uri uri5 = uri;
                            try {
                                cursor4 = context.getContentResolver().query(uri5, new String[]{"_id"}, "relative_path=? AND _display_name=?", new String[]{contentValues.getAsString(str17), contentValues.getAsString(str13)}, null);
                                if (cursor4 != null) {
                                    try {
                                        try {
                                            if (cursor4.moveToFirst()) {
                                                str6 = str12;
                                                str7 = str13;
                                                try {
                                                    uri3 = ContentUris.withAppendedId(uri, cursor4.getLong(cursor4.getColumnIndex("_id")));
                                                } catch (Exception e) {
                                                    e = e;
                                                    uri3 = null;
                                                    try {
                                                        Log.e("Unity", "Couldn't overwrite existing media's metadata:", e);
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        cursor3 = cursor4;
                                                        if (cursor3 != null) {
                                                        }
                                                        throw th;
                                                    }
                                                }
                                                try {
                                                    Log.d("Unity", "Overwriting existing media");
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    Log.e("Unity", "Couldn't overwrite existing media's metadata:", e);
                                                }
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            str6 = str12;
                                            str7 = str13;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        cursor3 = cursor4;
                                        if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                        throw th;
                                    }
                                }
                                str6 = str12;
                                str7 = str13;
                                uri3 = null;
                            } catch (Exception e4) {
                                e = e4;
                                str6 = str12;
                                uri = uri5;
                                str7 = str13;
                                cursor4 = null;
                                uri3 = null;
                                Log.e("Unity", "Couldn't overwrite existing media's metadata:", e);
                            }
                        } catch (Exception e5) {
                            e = e5;
                            str6 = str12;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor3 = null;
                    }
                }
                Uri uri6 = uri4;
                if (uri6 != null) {
                    try {
                        try {
                            try {
                                file2 = file;
                                try {
                                    if (NativeGalleryUtils.WriteFileToStream(file2, context.getContentResolver().openOutputStream(uri6, "rwt"))) {
                                        contentValues.put("is_pending", (Boolean) false);
                                        context.getContentResolver().update(uri6, contentValues, null, null);
                                        str9 = str15;
                                        try {
                                            Log.d("Unity", str9 + uri6.toString());
                                            try {
                                                str11 = str14;
                                                try {
                                                    intent = new Intent(str11);
                                                    intent.setData(uri6);
                                                    str8 = str17;
                                                    context2 = context;
                                                } catch (IllegalStateException e6) {
                                                    e = e6;
                                                    str8 = str17;
                                                } catch (Exception e7) {
                                                    e = e7;
                                                    str8 = str17;
                                                    context2 = context;
                                                }
                                            } catch (IllegalStateException e8) {
                                                e = e8;
                                                str8 = str17;
                                            } catch (Exception e9) {
                                                e = e9;
                                                str8 = str17;
                                                context2 = context;
                                            }
                                        } catch (IllegalStateException e10) {
                                            e = e10;
                                            str8 = str17;
                                            str10 = str16;
                                            if (i == 1) {
                                            }
                                            context.getContentResolver().delete(uri6, null, null);
                                            if (overwriteExistingMedia) {
                                            }
                                        }
                                        try {
                                            context2.sendBroadcast(intent);
                                            str14 = str11;
                                            str10 = str16;
                                        } catch (IllegalStateException e11) {
                                            e = e11;
                                            str14 = str11;
                                            str10 = str16;
                                            if (i == 1) {
                                            }
                                            context.getContentResolver().delete(uri6, null, null);
                                            if (overwriteExistingMedia) {
                                            }
                                        } catch (Exception e12) {
                                            e = e12;
                                            str14 = str11;
                                            str10 = str16;
                                            try {
                                                Log.e("Unity", str10, e);
                                                GetPathFromURI = NativeGalleryUtils.GetPathFromURI(context2, uri6);
                                                if (GetPathFromURI != null) {
                                                }
                                                GetPathFromURI = uri6.toString();
                                                return GetPathFromURI;
                                            } catch (IllegalStateException e13) {
                                                e = e13;
                                                if (i == 1) {
                                                }
                                                context.getContentResolver().delete(uri6, null, null);
                                                if (overwriteExistingMedia) {
                                                }
                                            } catch (Exception e14) {
                                                e = e14;
                                                Log.e("Unity", str10, e);
                                                if (overwriteExistingMedia && e.getClass().getName().equals("android.app.RecoverableSecurityException")) {
                                                    try {
                                                        context.startIntentSender(((RemoteAction) e.getClass().getMethod("getUserAction", new Class[0]).invoke(e, new Object[0])).getActionIntent().getIntentSender(), null, 0, 0, 0);
                                                        String GetPathFromURI2 = NativeGalleryUtils.GetPathFromURI(context, uri6);
                                                        return (GetPathFromURI2 == null || GetPathFromURI2.length() <= 0) ? uri6.toString() : GetPathFromURI2;
                                                    } catch (Exception e15) {
                                                        Log.e("Unity", "RecoverableSecurityException failure:", e15);
                                                        return "";
                                                    }
                                                }
                                                context2.getContentResolver().delete(uri6, null, null);
                                                return "";
                                            }
                                        }
                                        GetPathFromURI = NativeGalleryUtils.GetPathFromURI(context2, uri6);
                                        if (GetPathFromURI != null || GetPathFromURI.length() <= 0) {
                                            GetPathFromURI = uri6.toString();
                                        }
                                        return GetPathFromURI;
                                    }
                                    str8 = str17;
                                    str9 = str15;
                                    str10 = str16;
                                } catch (IllegalStateException e16) {
                                    e = e16;
                                    str8 = str17;
                                    str9 = str15;
                                    str10 = str16;
                                    if (i == 1) {
                                        Log.e("Unity", str10, e);
                                    }
                                    context.getContentResolver().delete(uri6, null, null);
                                    if (overwriteExistingMedia) {
                                    }
                                }
                            } catch (IllegalStateException e17) {
                                e = e17;
                                str8 = str17;
                                file2 = file;
                            }
                        } catch (Exception e18) {
                            e = e18;
                            context2 = context;
                            str10 = str16;
                        }
                    } catch (IllegalStateException e19) {
                        e = e19;
                        str8 = str17;
                        file2 = file;
                        str9 = str15;
                        str10 = str16;
                    }
                } else {
                    str8 = str17;
                    file2 = file;
                    str9 = str15;
                    str10 = str16;
                }
                if (overwriteExistingMedia) {
                    break;
                }
                i++;
                str17 = str8;
                str16 = str10;
                str12 = str6;
                str15 = str9;
                file = file2;
                str13 = str7;
                substring = str5;
            }
        } else {
            String str19 = substring;
            File file4 = new File(mediaSaveOmitDCIM ? Environment.getExternalStorageDirectory() : Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), directoryName);
            file4.mkdirs();
            if (substring2.length() <= 0 || str19.length() <= substring2.length()) {
                str = str16;
                str2 = str19;
                str3 = str2;
            } else {
                str = str16;
                str2 = str19;
                str3 = str2.substring(0, (str19.length() - substring2.length()) - 1);
            }
            String str20 = str2;
            int i2 = 1;
            while (true) {
                File file5 = new File(file4, str20);
                int i3 = i2 + 1;
                str20 = str3 + i2;
                if (substring2.length() > 0) {
                    str20 = str20 + "." + substring2;
                }
                if (!overwriteExistingMedia && file5.exists()) {
                    i2 = i3;
                } else {
                    try {
                        if (NativeGalleryUtils.WriteFileToStream(file3, new FileOutputStream(file5))) {
                            contentValues.put("_data", file5.getAbsolutePath());
                            if (!overwriteExistingMedia) {
                                context.getContentResolver().insert(uri, contentValues);
                            } else {
                                try {
                                    try {
                                        Uri uri7 = uri;
                                        try {
                                            cursor2 = context.getContentResolver().query(uri7, new String[]{"_id"}, "_data=?", new String[]{contentValues.getAsString("_data")}, null);
                                            if (cursor2 != null) {
                                                try {
                                                    try {
                                                        if (cursor2.moveToFirst()) {
                                                            uri2 = ContentUris.withAppendedId(uri, cursor2.getLong(cursor2.getColumnIndex("_id")));
                                                            try {
                                                                Log.d("Unity", "Overwriting existing media");
                                                            } catch (Exception e20) {
                                                                e = e20;
                                                                Log.e("Unity", "Couldn't overwrite existing media's metadata:", e);
                                                            }
                                                        }
                                                    } catch (Exception e21) {
                                                        e = e21;
                                                        uri2 = null;
                                                    }
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    cursor = cursor2;
                                                    if (cursor != null) {
                                                    }
                                                    throw th;
                                                }
                                            }
                                            uri2 = null;
                                        } catch (Exception e22) {
                                            e = e22;
                                            uri = uri7;
                                            uri2 = null;
                                            cursor2 = null;
                                            Log.e("Unity", "Couldn't overwrite existing media's metadata:", e);
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        cursor = null;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        throw th;
                                    }
                                } catch (Exception e23) {
                                    e = e23;
                                }
                            }
                            Log.d("Unity", str15 + file5.getPath());
                            Intent intent2 = new Intent(str14);
                            intent2.setData(Uri.fromFile(file5));
                            context.sendBroadcast(intent2);
                            return file5.getAbsolutePath();
                        }
                    } catch (Exception e24) {
                        Log.e("Unity", str, e24);
                    }
                }
            }
        }
        return "";
    }

    public static void MediaDeleteFile(Context context, String path, int mediaType) {
        if (mediaType == 1) {
            context.getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[]{path});
        } else if (mediaType == 2) {
            context.getContentResolver().delete(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[]{path});
        } else {
            context.getContentResolver().delete(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[]{path});
        }
    }

    public static void PickMedia(Context context, final NativeGalleryMediaReceiver mediaReceiver, int mediaType, boolean selectMultiple, String savePath, String mime, String title) {
        if (CheckPermission(context, true, mediaType) != 1) {
            if (!selectMultiple) {
                mediaReceiver.OnMediaReceived("");
                return;
            } else {
                mediaReceiver.OnMultipleMediaReceived("");
                return;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt(NativeGalleryMediaPickerFragment.MEDIA_TYPE_ID, mediaType);
        bundle.putBoolean(NativeGalleryMediaPickerFragment.SELECT_MULTIPLE_ID, selectMultiple);
        bundle.putString(NativeGalleryMediaPickerFragment.SAVE_PATH_ID, savePath);
        bundle.putString(NativeGalleryMediaPickerFragment.MIME_ID, mime);
        bundle.putString(NativeGalleryMediaPickerFragment.TITLE_ID, title);
        NativeGalleryMediaPickerFragment nativeGalleryMediaPickerFragment = new NativeGalleryMediaPickerFragment(mediaReceiver);
        nativeGalleryMediaPickerFragment.setArguments(bundle);
        ((Activity) context).getFragmentManager().beginTransaction().add(0, nativeGalleryMediaPickerFragment).commitAllowingStateLoss();
    }

    public static int CheckPermission(Context context, final boolean readPermission, final int mediaType) {
        if (PermissionFreeMode) {
            return 1;
        }
        if (!readPermission) {
            if (Build.VERSION.SDK_INT >= 29) {
                return 1;
            }
            if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                return 0;
            }
        }
        return ((Build.VERSION.SDK_INT < 33 || context.getApplicationInfo().targetSdkVersion < 33) && context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) ? 0 : 1;
    }

    public static void RequestPermission(Context context, final NativeGalleryPermissionReceiver permissionReceiver, final boolean readPermission, final int mediaType) {
        if (CheckPermission(context, readPermission, mediaType) == 1) {
            permissionReceiver.OnPermissionResult(1);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(NativeGalleryPermissionFragment.READ_PERMISSION_ONLY, readPermission);
        bundle.putInt(NativeGalleryPermissionFragment.MEDIA_TYPE_ID, mediaType);
        NativeGalleryPermissionFragment nativeGalleryPermissionFragment = new NativeGalleryPermissionFragment(permissionReceiver);
        nativeGalleryPermissionFragment.setArguments(bundle);
        ((Activity) context).getFragmentManager().beginTransaction().add(0, nativeGalleryPermissionFragment).commitAllowingStateLoss();
    }

    public static void OpenSettings(Context context) {
        Uri fromParts = Uri.fromParts("package", context.getPackageName(), null);
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        context.startActivity(intent);
    }

    public static String GetMimeTypeFromExtension(String extension) {
        String mimeTypeFromExtension;
        return (extension == null || extension.length() == 0 || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension.toLowerCase(Locale.ENGLISH))) == null) ? "" : mimeTypeFromExtension;
    }

    public static String LoadImageAtPath(Context context, String path, final String temporaryFilePath, final int maxSize) {
        return NativeGalleryUtils.LoadImageAtPath(context, path, temporaryFilePath, maxSize);
    }

    public static String GetImageProperties(Context context, final String path) {
        return NativeGalleryUtils.GetImageProperties(context, path);
    }

    public static String GetVideoProperties(Context context, final String path) {
        return NativeGalleryUtils.GetVideoProperties(context, path);
    }

    public static String GetVideoThumbnail(Context context, final String path, final String savePath, final boolean saveAsJpeg, int maxSize, double captureTime) {
        return NativeGalleryUtils.GetVideoThumbnail(context, path, savePath, saveAsJpeg, maxSize, captureTime);
    }
}
