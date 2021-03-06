package com.alnton.myframecore.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * <图片工具类>
 *
 * @author 王乾州
 */
public class ImageUtil {
    /**
     * 图片工具类引用
     */
    private static ImageUtil imageUtil;

    /**
     * Glide加载图片的默认图片、失败图片
     */
    public int glideDefaultPic;

    /**
     * 当部分手机拍照旋转 需要将矫正的图片保存好后才返回Bitmap
     */
    private boolean isFinishCompress;

    /**
     * 拍照的File
     */
    public File cameraFile;

    /**
     * 相册的RequestCode
     */
    public static final int INTENT_REQUEST_CODE_ALBUM = 0;

    /**
     * 照相的RequestCode
     */
    public static final int INTENT_REQUEST_CODE_CAMERA = 1;

    /**
     * 单例获取构造函数
     *
     * @return
     */
    public static ImageUtil getInstance() {
        if (null == imageUtil) {
            imageUtil = new ImageUtil();
        }
        return imageUtil;
    }

    /**
     * 转换图片成圆形
     *
     * @param bitmap 传入Bitmap对象
     * @return
     */
    public Bitmap toRoundBitmap(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float roundPx;
        float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
        if (width <= height) {
            roundPx = width / 2;
            top = 0;
            bottom = width;
            left = 0;
            right = width;
            height = width;
            dst_left = 0;
            dst_top = 0;
            dst_right = width;
            dst_bottom = width;
        } else {
            roundPx = height / 2;
            float clip = (width - height) / 2;
            left = clip;
            right = width - clip;
            top = 0;
            bottom = height;
            width = height;
            dst_left = 0;
            dst_top = 0;
            dst_right = height;
            dst_bottom = height;
        }
        Bitmap output = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect src = new Rect((int) left, (int) top, (int) right, (int) bottom);
        final Rect dst = new Rect((int) dst_left, (int) dst_top, (int) dst_right, (int) dst_bottom);
        final RectF rectF = new RectF(dst);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, src, dst, paint);
        return output;
    }

    /**
     * 加载图片 （默认背景图展示、默认加载出错图展示、默认不圆角展示）
     * <p>
     * (加载网络图片)               imageUri = "http://img.daimg.com/uploads/allimg/161031/1-161031001458.jpg";
     * (加载SD card图片)           imageUri = "file:///storage/emulated/0/DCIM/Screenshots/test.png";
     * (加载content provider图片)  imageUri = "content://media/external/audio/albumart/1";
     * (加载assets中的图片)        imageUri = "file:///android_asset/image.png";
     *
     * @param mContxt     传调用页面的上下文 最好传Activity、Fragment、FragmentActivity 因为加载图片跟这三个生命周期绑定了 会提高效率 节省资源
     * @param imageUri    图片地址
     * @param myImageView 图片控件
     */
    public void showImageView(Context mContxt, String imageUri, ImageView myImageView) {
        Glide.with(mContxt)
                .load(imageUri)
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .dontAnimate()
                .placeholder(glideDefaultPic)
                .error(glideDefaultPic)
                .into(myImageView);
    }


    /**
     * 加载图片 （默认背景图展示、默认加载出错图展示、默认不圆角展示）
     * <p>
     * (加载drawable图片)  imageUri = R.mipmap.ic_launcher;
     *
     * @param mContxt     传调用页面的上下文 最好传Activity、Fragment、FragmentActivity 因为加载图片跟这三个生命周期绑定了 会提高效率 节省资源
     * @param resId       图片地址
     * @param myImageView 图片控件
     */
    public void showImageView(Context mContxt, int resId, ImageView myImageView) {
        Glide.with(mContxt)
                .load(resId)
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .dontAnimate()
                .placeholder(glideDefaultPic)
                .error(glideDefaultPic)
                .into(myImageView);
    }

    /**
     * 加载图片 （可设置默认背景图展示、可设置是否圆角展示以及圆角弧度）
     * <p>
     * (加载网络图片)               imageUri = "http://img.daimg.com/uploads/allimg/161031/1-161031001458.jpg";
     * (加载SD card图片)           imageUri = "file:///storage/emulated/0/DCIM/Screenshots/test.png";
     * (加载content provider图片)  imageUri = "content://media/external/audio/albumart/1";
     * (加载assets中的图片)        imageUri = "file:///android_asset/image.png";
     *
     * @param mContxt     传调用页面的上下文 最好传Activity、Fragment、FragmentActivity 因为加载图片跟这三个生命周期绑定了 会提高效率 节省资源
     * @param imageUri    图片地址
     * @param myImageView 图片控件
     * @param defaultPic  默认图片资源id
     * @param isRound     true:展示圆角  false:不展示圆角
     * @param roundPx     圆角弧度
     */
    public void showImageView(Context mContxt, String imageUri, ImageView myImageView, int defaultPic, boolean isRound, int roundPx) {
        if (isRound) {
            Glide.with(mContxt)
                    .load(imageUri)
                    .skipMemoryCache(false)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .transform(new GlideRoundTransform(mContxt, roundPx))
                    .placeholder(defaultPic)
                    .error(glideDefaultPic)
                    .into(myImageView);
        } else {
            Glide.with(mContxt)
                    .load(imageUri)
                    .skipMemoryCache(false)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeholder(defaultPic)
                    .error(glideDefaultPic)
                    .into(myImageView);
        }
    }

    /**
     * 加载图片 （可设置默认背景图展示、可设置加载失败的图片展示、可设置是否圆角展示以及圆角弧度）
     * <p>
     * (加载网络图片)               imageUri = "http://img.daimg.com/uploads/allimg/161031/1-161031001458.jpg";
     * (加载SD card图片)           imageUri = "file:///storage/emulated/0/DCIM/Screenshots/test.png";
     * (加载content provider图片)  imageUri = "content://media/external/audio/albumart/1";
     * (加载assets中的图片)        imageUri = "file:///android_asset/image.png";
     *
     * @param mContxt     传调用页面的上下文 最好传Activity、Fragment、FragmentActivity 因为加载图片跟这三个生命周期绑定了 会提高效率 节省资源
     * @param imageUri    图片地址
     * @param myImageView 图片控件
     * @param defaultPic  默认图片资源id
     * @param errorPic    加载失败显示图片资源id
     * @param isRound     true:展示圆角  false:不展示圆角
     * @param roundPx     圆角弧度
     */
    public void showImageView(Context mContxt, String imageUri, ImageView myImageView, int defaultPic, int errorPic, boolean isRound, int roundPx) {
        if (isRound) {
            Glide.with(mContxt)
                    .load(imageUri)
                    .skipMemoryCache(false)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .transform(new GlideRoundTransform(mContxt, roundPx))
                    .placeholder(defaultPic)
                    .error(errorPic)
                    .into(myImageView);
        } else {
            Glide.with(mContxt)
                    .load(imageUri)
                    .skipMemoryCache(false)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .placeholder(defaultPic)
                    .error(errorPic)
                    .into(myImageView);
        }
    }

    /**
     * 获取Bitmap图片
     * <p>
     * (加载网络图片)               imageUri = "http://img.daimg.com/uploads/allimg/161031/1-161031001458.jpg";
     * (加载SD card图片)           imageUri = "file:///storage/emulated/0/DCIM/Screenshots/test.png";
     * (加载content provider图片)  imageUri = "content://media/external/audio/albumart/1";
     * (加载assets中的图片)        imageUri = "file:///android_asset/image.png";
     * (加载drawable图片)          imageUri = R.mipmap.ic_launcher;
     *
     * @param mContxt             传调用页面的上下文 最好传Activity、Fragment、FragmentActivity 因为加载图片跟这三个生命周期绑定了 会提高效率 节省资源
     * @param imageUri            图片地址
     * @param onGetBitmapListener 获取bitmap接口
     */
    public void getBitmap(Context mContxt, String imageUri, final OnGetBitmapListener onGetBitmapListener) {
        isFinishCompress = false;
        final String newImageUri = imageUri;

        SimpleTarget target = new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {
                /**
                 * 矫正SD卡中的图片旋转角度
                 * 部分手机拍照或者从本地相册取图片会旋转 调用下面的方法可以解决
                 * android 4.0以上 对应的Activity必须添加android:configChanges="keyboardHidden|orientation|screenSize"
                 */
                if (!TextUtils.isEmpty(newImageUri) && newImageUri.startsWith("file://") && null != bitmap) {
                    Bitmap cacheHeadBitmap = correctPicture(newImageUri.replaceFirst("file://", ""), bitmap);
                    if (null != cacheHeadBitmap) {
                        bitmap = cacheHeadBitmap;

                        isFinishCompress = true;
                        try {
                            new CompressBitmapTask(bitmap, newImageUri.replaceFirst("file://", "")).execute();
                        } catch (Exception e) {
                            isFinishCompress = false;
                        }
                    }
                }
                while (isFinishCompress) {
                }
                if (onGetBitmapListener != null) {
                    onGetBitmapListener.onGetBitmapReady(bitmap);
                }
            }

            public void onLoadFailed(Exception e, Drawable errorDrawable) {
                if (onGetBitmapListener != null) {
                    onGetBitmapListener.onGetBitmapReady(null);
                }
            }
        };
        Glide.with(mContxt).load(imageUri).asBitmap().into(target);
    }

    /**
     * 获取bitmap的接口
     * bitmap 为null获取失败
     */
    public interface OnGetBitmapListener {
        void onGetBitmapReady(Bitmap bitmap);
    }

    /**
     * 暂停请求
     *
     * @param context
     */
    public void pauseRequests(Context context) {
        Glide.with(context).pauseRequests();
    }

    /**
     * 恢复请求
     *
     * @param context
     */
    public void resumeRequests(Context context) {
        Glide.with(context).resumeRequests();
    }

    /**
     * 取消指定ImageView上的图片加载请求
     *
     * @param imageView
     */
    public void clearRequests(ImageView imageView) {
        Glide.clear(imageView);
    }

    /**
     * 清除磁盘缓存
     */
    public void clearDiskCache(final Context context) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Glide.get(context).clearDiskCache();
            }
        }).start();
    }

    /**
     * 清除内存缓存
     *
     * @param context
     */
    public void clearMemoryCache(Context context) {
        Glide.get(context).clearMemory();
    }

    /**
     * 清除文件缓存和内存缓存
     */
    public void cleanCache(Context context) {
        clearMemoryCache(context);
        clearDiskCache(context);
    }

    /**
     * 将矫正后的图片保存到原文件中
     */
    private class CompressBitmapTask extends AsyncTask<Void, Void, Void> {
        /**
         * 矫正之后的图片
         */
        Bitmap bitmap;

        /**
         * 图片地址
         */
        String path;

        public CompressBitmapTask(Bitmap bitmap, String path) {
            this.bitmap = bitmap;
            this.path = path;
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                File oldFile = new File(path);
                if (oldFile.exists()) {
                    oldFile.delete();
                }
                File newFile = FileUtil.getInstance().createNewFile(path);
                FileOutputStream fOut = new FileOutputStream(newFile);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
                fOut.flush();
                fOut.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            isFinishCompress = false;

            this.cancel(true);

            return null;
        }
    }

    /**
     * <从相册或者拍照获取图片>
     */
    public void choiceImage(final Activity mContext, final String imagePath) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle(mContext.getResources().getIdentifier("choiceType", "string", mContext.getPackageName()))
                .setIcon(android.R.drawable.ic_dialog_info)
                .setItems(mContext.getResources().getIdentifier("choiceImageStyle", "array", mContext.getPackageName()),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        /**
                                         * 拍照
                                         */
                                        takePicture(mContext, imagePath);
                                        break;

                                    case 1:
                                        /**
                                         * 去相册
                                         */
                                        selectPhoto(mContext);
                                        break;

                                    case 2:
                                        /**
                                         *
                                         */
                                        break;

                                    default:
                                        break;
                                }
                            }
                        })
                .create()
                .show();
    }

    /**
     * 通过手机照相获取图片
     *
     * @param activity
     * @return 照相后图片的路径
     */
    public void takePicture(Activity activity, String imagePath) {
        try {
            /** 拍照第一步：首先判断SDCard是否存在 */
            String ROOT_PATH = TelephoneUtil.getInstance().getSDPath();

            if (null == ROOT_PATH) {
                /** 拍照第二步：如果sdcard不存在，就判断内存卡的容量（如果容量大于50MB就拍照） */
                long phoneMemory = TelephoneUtil.getInstance().getROMAvailableSize();
                if (phoneMemory > 52428800) // 50MB
                {
                    ROOT_PATH = Environment.getDataDirectory() + File.separator;
                } else {
                    Toast.makeText(activity,
                            activity.getResources().getIdentifier("memory_notfull", "string", activity.getPackageName()),
                            Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            // 创建图片Image文件夹目录
            File dir = FileUtil.getInstance().createDirectory(imagePath);
            cameraFile =
                    FileUtil.getInstance().createNewFile(dir.getAbsolutePath() + File.separator + UUID.randomUUID()
                            + ".png");
            /* 调用系统自带的照相意图 */
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            /* 将拍照的图片保存到sd卡中或者内存中 */
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(cameraFile));
            activity.startActivityForResult(intent, INTENT_REQUEST_CODE_CAMERA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过手机相册获取图片
     *
     * @param activity
     */
    public void selectPhoto(Activity activity) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        activity.startActivityForResult(intent, INTENT_REQUEST_CODE_ALBUM);
    }

    /**
     * <Bitmap 转化为 byte[]>
     *
     * @param bm
     * @return
     */
    public byte[] Bitmap2Bytes(Bitmap bm) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * <byte[] 转化为 Bitmap>
     *
     * @param b
     * @return
     */
    public Bitmap Bytes2Bimap(byte[] b) {
        if (null != b && b.length != 0) {
            try {
                return BitmapFactory.decodeByteArray(b, 0, b.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return null;
    }

    //    @Override
    //    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    //    {
    //        if (resultCode == RESULT_OK)
    //        {
    //            switch (requestCode)
    //            {
    //                case ImageUtil.INTENT_REQUEST_CODE_CAMERA:
    //                    /**
    //                     * 拍照回调
    //                     */
    //                    try
    //                    {
    //                        Bitmap headBitmap = ImageUtil.getInstance().readSDorResBitmap(mContext,
    //                            ImageUtil.getInstance().cameraFile.getAbsolutePath(),
    //                            0);
    //                        if (null != headBitmap && null != InDoorFragment.selfmainActivity)
    //                        {
    //                            //調用InDoorFragment裡邊的設置圖片方法
    //                            InDoorFragment.selfmainActivity.setHeadBitmap(headBitmap);
    //                            InDoorFragment.selfmainActivity.setImageView(headBitmap);
    //                        }
    //                        else
    //                        {
    //                            showToast(mContext, R.string.getHeadFailure);
    //                        }
    //                    }
    //                    catch (Exception e)
    //                    {
    //                        e.printStackTrace();
    //                    }
    //                    break;
    //                
    //                case ImageUtil.INTENT_REQUEST_CODE_ALBUM:
    //                    /**
    //                     * 从相册选取图片作为头像
    //                     */
    //                    finishActivity(2);
    //                    if (null != data)
    //                    {
    //                        try
    //                        {
    //                            String path = "";
    //                            Uri uri = data.getData();
    //                            
    //                            String[] proj = {MediaStore.Images.Media.DATA};
    //                            
    //                            //好像是android多媒体数据库的封装接口，具体的看Android文档
    //                            Cursor cursor = managedQuery(uri, proj, null, null, null);
    //                            if (null != cursor)
    //                            {
    //                                //按我个人理解 这个是获得用户选择的图片的索引值
    //                                int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
    //                                //将光标移至开头 ，这个很重要，不小心很容易引起越界
    //                                cursor.moveToFirst();
    //                                //最后根据索引值获取图片路径
    //                                path = cursor.getString(column_index);
    //                            }
    //                            else
    //                            {
    //                                path = uri.getPath();
    //                            }
    //                            
    //                            Bitmap headBitmap = ImageUtil.getInstance().readSDorResBitmap(mContext, path, 0);
    //                            
    //                            if (null != headBitmap && null != InDoorFragment.selfmainActivity)
    //                            {
    //                                InDoorFragment.selfmainActivity.setHeadBitmap(headBitmap);
    //                                InDoorFragment.selfmainActivity.setImageView(headBitmap);
    //                            }
    //                            else
    //                            {
    //                                showToast(mContext, R.string.getHeadFailure);
    //                            }
    //                        }
    //                        catch (Exception e)
    //                        {
    //                            e.printStackTrace();
    //                        }
    //                    }
    //                    break;
    //                
    //                default:
    //                    break;
    //            }
    //        }
    //        super.onActivityResult(requestCode, resultCode, data);
    //    }

    /**
     * 拍照或者从相册选取图片作为头像 有部分手机会旋转，此方法就是为了矫正图片的
     *
     * @param path   图片的路径
     * @param bitmap 图片的Bitmap类型
     * @return 返回矫正后的图片 Bitmap
     */
    public Bitmap correctPicture(String path, Bitmap bitmap) {
        try {
            // 首先得到图片的旋转角度
            int degree = getBitmapDegree(path);
            if (0 != degree) {
                // 其次根据图片的旋转角度，旋转对应角度
                return rotateBitmapByDegree(bitmap, degree);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 读取图片的旋转的角度
     *
     * @param path 图片绝对路径
     * @return 图片的旋转角度
     */
    private int getBitmapDegree(String path) {
        int degree = 0;
        try {
            // 从指定路径下读取图片，并获取其EXIF信息
            ExifInterface exifInterface = new ExifInterface(path);
            // 获取图片的旋转信息
            int orientation =
                    exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
                default:
                    degree = 0;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
            degree = 0;
        }
        return degree;
    }

    /**
     * 将图片按照某个角度进行旋转
     *
     * @param bm     需要旋转的图片
     * @param degree 旋转角度
     * @return 旋转后的图片
     */
    private Bitmap rotateBitmapByDegree(Bitmap bm, int degree) {
        Bitmap returnBm = null;

        // 根据旋转角度，生成旋转矩阵
        Matrix matrix = new Matrix();
        matrix.postRotate(degree - 90);
        try {
            // 将原始图片按照旋转矩阵进行旋转，并得到新的图片
            returnBm = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), matrix, true);
        } catch (OutOfMemoryError e) {
        }
        if (null == returnBm) {
            returnBm = bm;
        }
        if (bm != returnBm) {
            bm.recycle();
        }
        return returnBm;
    }

    /**
     * 获取图片的长度和宽度
     *
     * @param bitmap 图片bitmap对象
     * @return
     */
    public Bundle getBitmapWidthAndHeight(Bitmap bitmap) {
        Bundle bundle = null;
        if (bitmap != null) {
            bundle = new Bundle();
            bundle.putInt("width", bitmap.getWidth());
            bundle.putInt("height", bitmap.getHeight());
            return bundle;
        }
        return null;
    }

    /**
     * <截屏并保存图片>
     */
    public File screenShotsImage(Activity context, String path)
            throws Exception {
        //1.获取屏幕Bitmap 
        View decorview = context.getWindow().getDecorView();
        decorview.setDrawingCacheEnabled(true);
        decorview.buildDrawingCache();
        Bitmap Bmp = decorview.getDrawingCache();

        //2.去掉标题栏 构建Bitmap 
        Rect frame = new Rect();
        context.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
        Bmp =
                Bitmap.createBitmap(Bmp,
                        0,
                        statusBarHeight,
                        DensityUtil.getInstance().getDisplayWidth(context),
                        DensityUtil.getInstance().getDisplayHeight(context) - statusBarHeight);

        //3.保存Bitmap  
        File rootFile = FileUtil.getInstance().createDirectory(path);
        File pathFile =
                FileUtil.getInstance().createNewFile(rootFile.getAbsolutePath() + File.separator
                        + MyFrameCoreTools.getInstance().getUUID() + ".png");
        FileOutputStream fos = new FileOutputStream(pathFile);
        Bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
        fos.flush();
        fos.close();

        //4.销毁缓存信息
        decorview.destroyDrawingCache();
        if (null != Bmp && !Bmp.isRecycled()) {
            Bmp.recycle();
            Bmp = null;
        }
        return pathFile;
    }
}