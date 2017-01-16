package com.alnton.myframe.util;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alnton.myFrameCore.util.FileUtil;
import com.alnton.myFrameCore.util.ImageUtil;
import com.alnton.myFrameCore.util.MyFrameCoreTools;
import com.alnton.myFrameResource.util.CustomBottomDialog;
import com.alnton.myFrameResource.util.CustomCenterDialog;
import com.alnton.myFrameResource.util.MyFrameResourceTools;
import com.alnton.myFrameResource.view.Button.ClickEffectButton;
import com.alnton.myFrameResource.view.Wheel.OnWheelScrollListener;
import com.alnton.myFrameResource.view.Wheel.WheelView;
import com.alnton.myframe.R;
import com.alnton.myframe.adapter.homePage.CityWheelAdapter;
import com.alnton.myframe.config.Config.SystemParamCfg;
import com.alnton.myframe.config.FusionCode;
import com.alnton.myframe.db.CityManager;
import com.alnton.myframe.entity.City;

/**
 * <用于存放所有公共的方法>
 * @author 王乾州
 */
public class MyframeTools
{
    private static MyframeTools tools;
    
    /**
     * 省份城市集合
     */
    private ArrayList<City> provinceList, cityList, townList;
    
    /**
     * 城市数据库管理类
     */
    public CityManager cityManager;
    
    public static MyframeTools getInstance()
    {
        if (null == tools)
        {
            tools = new MyframeTools();
        }
        return tools;
    }
    
    /**
     * <选择省份城市区域>
     * @param province 界面上显示的老的省份传递过来
     * @param city     界面上显示的老的城市传递过来
     * @param town     界面上显示的老的区县传递过来
     * @param handler  用于接收新选择的省份、城市、区域 字符串用","间隔
     */
    public void choiceProvinceCity(final Context context, String province, String city, String town,
        final Handler handler)
    {
        final WheelView provinceWheelview, cityWheelview, townWheelview;
        
        if (null == cityManager)
        {
            cityManager = new CityManager(context);
            cityManager.insertDb();
        }
        
        provinceList = cityManager.queryProvinces();
        
        View view = MyFrameResourceTools.getInstance().showDialogFromBottom(context, R.layout.provincecitydialog);
        final CustomBottomDialog dialog = (CustomBottomDialog)view.getTag();
        
        provinceWheelview = (WheelView)view.findViewById(R.id.provinceWheelview);
        cityWheelview = (WheelView)view.findViewById(R.id.cityWheelview);
        townWheelview = (WheelView)view.findViewById(R.id.townWheelview);
        provinceWheelview.setVisibleItems(7);
        cityWheelview.setVisibleItems(7);
        townWheelview.setVisibleItems(7);
        
        provinceWheelview.addScrollingListener(new OnWheelScrollListener()
        {
            
            @Override
            public void onScrollingStarted(WheelView wheel)
            {
            }
            
            @Override
            public void onScrollingFinished(WheelView wheel)
            {
                cityList = cityManager.queryCitysTowns(provinceList.get(wheel.getCurrentItem()).getCityCode());
                cityWheelview.setAdapter(new CityWheelAdapter(cityList));
                cityWheelview.setCurrentItem(0);
                
                if (null != cityList && cityList.size() > 0)
                {
                    townList = cityManager.queryCitysTowns(cityList.get(cityWheelview.getCurrentItem()).getCityCode());
                }
                else
                {
                    townList = new ArrayList<City>();
                }
                townWheelview.setAdapter(new CityWheelAdapter(townList));
                townWheelview.setCurrentItem(0);
                
            }
        });
        
        cityWheelview.addScrollingListener(new OnWheelScrollListener()
        {
            
            @Override
            public void onScrollingStarted(WheelView wheel)
            {
            }
            
            @Override
            public void onScrollingFinished(WheelView wheel)
            {
                if (null != cityList && cityList.size() > 0)
                {
                    townList = cityManager.queryCitysTowns(cityList.get(wheel.getCurrentItem()).getCityCode());
                }
                else
                {
                    townList = new ArrayList<City>();
                }
                townWheelview.setAdapter(new CityWheelAdapter(townList));
                townWheelview.setCurrentItem(0);
                
            }
        });
        
        /**
         * 填充省份数据
         */
        provinceWheelview.setAdapter(new CityWheelAdapter(provinceList, 11));
        if (!TextUtils.isEmpty(province))
        {
            for (int i = 0; i < provinceList.size(); i++)
            {
                if (province.equals(provinceList.get(i).getCityName()))
                {
                    provinceWheelview.setCurrentItem(i);
                    break;
                }
            }
        }
        else
        {
            provinceWheelview.setCurrentItem(0);
        }
        
        cityList = cityManager.queryCitysTowns(provinceList.get(provinceWheelview.getCurrentItem()).getCityCode());
        
        /**
         * 填充城市数据
         */
        if (null != cityList && cityList.size() > 0)
        {
            cityWheelview.setAdapter(new CityWheelAdapter(cityList, 11));
            if (!TextUtils.isEmpty(city))
            {
                for (int i = 0; i < cityList.size(); i++)
                {
                    if (city.equals(cityList.get(i).getCityName()))
                    {
                        cityWheelview.setCurrentItem(i);
                        break;
                    }
                }
            }
            else
            {
                cityWheelview.setCurrentItem(0);
            }
        }
        
        if (null != cityList && cityList.size() > 0)
        {
            townList = cityManager.queryCitysTowns(cityList.get(cityWheelview.getCurrentItem()).getCityCode());
        }
        
        /**
         * 填充区县数据
         */
        if (null != townList && townList.size() > 0)
        {
            townWheelview.setAdapter(new CityWheelAdapter(townList, 11));
            if (!TextUtils.isEmpty(town))
            {
                for (int i = 0; i < townList.size(); i++)
                {
                    if (town.equals(townList.get(i).getCityName()))
                    {
                        townWheelview.setCurrentItem(i);
                        break;
                    }
                }
            }
            else
            {
                townWheelview.setCurrentItem(0);
            }
        }
        
        TextView cancelTextView = (TextView)view.findViewById(R.id.cancelTextView);
        TextView confirmTextView = (TextView)view.findViewById(R.id.confirmTextView);
        
        cancelTextView.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
            }
        });
        
        confirmTextView.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
                
                /**
                 * 确定
                 */
                String pro = " ", ci = " ", town = " ", proCode = " ", ciCode = " ", townCode = " ";
                if (null != provinceList && provinceList.size() > 0)
                {
                    pro = provinceList.get(provinceWheelview.getCurrentItem()).getCityName();
                    proCode = provinceList.get(provinceWheelview.getCurrentItem()).getCityCode();
                }
                
                if (null != cityList && cityList.size() > 0)
                {
                    ci = cityList.get(cityWheelview.getCurrentItem()).getCityName();
                    ciCode = cityList.get(cityWheelview.getCurrentItem()).getCityCode();
                }
                
                if (null != townList && townList.size() > 0)
                {
                    town = townList.get(townWheelview.getCurrentItem()).getCityName();
                    townCode = townList.get(townWheelview.getCurrentItem()).getCityCode();
                }
                
                handler.obtainMessage(FusionCode.getInstance().HANDLER_CHANGE_CITY,
                    pro + "," + ci + "," + town + "," + proCode + "," + ciCode + "," + townCode).sendToTarget();
            }
        });
    }
    
    /**
     * <选择省份城市>
     * @param province 界面上显示的老的省份传递过来
     * @param city     界面上显示的老的城市传递过来
     * @param handler  用于接收新选择的省份、城市 字符串用","间隔
     */
    public void choiceProvinceCity(final Context context, String province, String city, final Handler handler)
    {
        final WheelView provinceWheelview, cityWheelview;
        
        if (null == cityManager)
        {
            cityManager = new CityManager(context);
            cityManager.insertDb();
        }
        
        provinceList = cityManager.queryProvinces();
        
        View view = MyFrameResourceTools.getInstance().showDialogFromBottom(context, R.layout.provincecitydialog);
        final CustomBottomDialog dialog = (CustomBottomDialog)view.getTag();
        
        provinceWheelview = (WheelView)view.findViewById(R.id.provinceWheelview);
        cityWheelview = (WheelView)view.findViewById(R.id.cityWheelview);
        WheelView townWheelview = (WheelView)view.findViewById(R.id.townWheelview);
        townWheelview.setVisibility(View.GONE);
        provinceWheelview.setVisibleItems(7);
        cityWheelview.setVisibleItems(7);
        
        provinceWheelview.addScrollingListener(new OnWheelScrollListener()
        {
            
            @Override
            public void onScrollingStarted(WheelView wheel)
            {
            }
            
            @Override
            public void onScrollingFinished(WheelView wheel)
            {
                cityList = cityManager.queryCitysTowns(provinceList.get(wheel.getCurrentItem()).getCityCode());
                cityWheelview.setAdapter(new CityWheelAdapter(cityList));
                cityWheelview.setCurrentItem(0);
            }
        });
        
        /**
         * 填充省份数据
         */
        provinceWheelview.setAdapter(new CityWheelAdapter(provinceList, 11));
        if (!TextUtils.isEmpty(province))
        {
            for (int i = 0; i < provinceList.size(); i++)
            {
                if (province.equals(provinceList.get(i).getCityName()))
                {
                    provinceWheelview.setCurrentItem(i);
                    break;
                }
            }
        }
        else
        {
            provinceWheelview.setCurrentItem(0);
        }
        
        cityList = cityManager.queryCitysTowns(provinceList.get(provinceWheelview.getCurrentItem()).getCityCode());
        
        /**
         * 填充城市数据
         */
        if (null != cityList && cityList.size() > 0)
        {
            cityWheelview.setAdapter(new CityWheelAdapter(cityList, 11));
            if (!TextUtils.isEmpty(city))
            {
                for (int i = 0; i < cityList.size(); i++)
                {
                    if (city.equals(cityList.get(i).getCityName()))
                    {
                        cityWheelview.setCurrentItem(i);
                        break;
                    }
                }
            }
            else
            {
                cityWheelview.setCurrentItem(0);
            }
        }
        
        TextView cancelTextView = (TextView)view.findViewById(R.id.cancelTextView);
        TextView confirmTextView = (TextView)view.findViewById(R.id.confirmTextView);
        
        cancelTextView.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
            }
        });
        
        confirmTextView.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialog.dismiss();
                
                /**
                 * 确定
                 */
                String pro = " ", ci = " ", town = " ", proCode = " ", ciCode = " ", townCode = " ";
                if (null != provinceList && provinceList.size() > 0)
                {
                    pro = provinceList.get(provinceWheelview.getCurrentItem()).getCityName();
                    proCode = provinceList.get(provinceWheelview.getCurrentItem()).getCityCode();
                }
                
                if (null != cityList && cityList.size() > 0)
                {
                    ci = cityList.get(cityWheelview.getCurrentItem()).getCityName();
                    ciCode = cityList.get(cityWheelview.getCurrentItem()).getCityCode();
                }
                
                handler.obtainMessage(FusionCode.getInstance().HANDLER_CHANGE_CITY,
                    pro + "," + ci + "," + town + "," + proCode + "," + ciCode + "," + townCode).sendToTarget();
            }
        });
    }
    
    /**
     * <从相册或者拍照获取图片 从底部弹出的选择方式>
     */
    public void choiceImageFromBottom(final Activity mContext, final String imagePath)
    {
        View headPhotoView =
            MyFrameResourceTools.getInstance().showDialogFromBottom(mContext, R.layout.photo_choose_dialog);
        final CustomBottomDialog buttonDialog = (CustomBottomDialog)headPhotoView.getTag();
        Button cameraButton = (Button)headPhotoView.findViewById(R.id.cameraButton);
        Button albumButton = (Button)headPhotoView.findViewById(R.id.albumButton);
        Button cancelButton = (Button)headPhotoView.findViewById(R.id.cancelButton);
        
        cameraButton.setOnClickListener(new View.OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                /**
                 * 拍照
                 */
                buttonDialog.dismiss();
                ImageUtil.getInstance().takePicture(mContext, imagePath);
            }
        });
        
        albumButton.setOnClickListener(new View.OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                /**
                 * 去相册
                 */
                buttonDialog.dismiss();
                ImageUtil.getInstance().selectPhoto(mContext);
            }
        });
        
        cancelButton.setOnClickListener(new View.OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                /**
                 * 取消
                 */
                buttonDialog.dismiss();
            }
        });
    }
    
    /**
     * @Title: showDialogCenter 
     * @Description: TODO(是否需要放弃本次编辑的dialog) 
     * @param @param context
     * @param @param layoutId
     * @param @param activity
     * @param @return    设定文件 
     * @return View    返回类型 
     * @throws
     */
    public View showDialogCenter(Context context, int layoutId, final Activity activity, String content)
    {
        final Dialog exitDialog = new CustomCenterDialog(context, R.style.transparentFrameWindowStyle, layoutId);
        exitDialog.show();
        View view = exitDialog.getWindow().getDecorView();
        view.setTag(exitDialog);
        TextView dialog_content = (TextView)view.findViewById(R.id.dialog_content);
        dialog_content.setText(content);
        ClickEffectButton cancel = (ClickEffectButton)view.findViewById(R.id.dialog_cancel);
        cancel.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                exitDialog.dismiss();
            }
        });
        ClickEffectButton confim = (ClickEffectButton)view.findViewById(R.id.dialog_confim);
        confim.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                exitDialog.dismiss();
                activity.finish();
            }
        });
        return view;
    }
    
    /**
     * @Title: 显示一个按钮的中间对话框 
     * @param @param context
     * @param @param layoutId
     * @param @param activity
     * @param @return    设定文件 
     * @return View    返回类型 
     * @throws
     */
    public View showDialogCenterOneButton(Context context, final Activity activity, String content)
    {
        final Dialog exitDialog =
            new CustomCenterDialog(context, R.style.transparentFrameWindowStyle, R.layout.dialog_button_one);
        exitDialog.show();
        View view = exitDialog.getWindow().getDecorView();
        view.setTag(exitDialog);
        TextView dialog_content = (TextView)view.findViewById(R.id.dialog_content);
        dialog_content.setText(content);
        ClickEffectButton confim = (ClickEffectButton)view.findViewById(R.id.dialog_confim);
        confim.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                exitDialog.dismiss();
            }
        });
        return view;
        
    }
    
    /**
     * @Title: showDialogCenter 
     * @Description: TODO(是否需要放弃本次操作的dialog) 
     * @param activity
     * @param layoutId -1（默认 R.layout.dialog_xml）
     * @param content （默认 是否放弃本次编辑?）
     * @param onAffirmClickListener ==null，关闭Dialog&&关闭Activity。
     * @return View    返回类型 
     * @throws
     */
    public View showDialogCenter(final Context context, int layoutId, String content,
        final OnAffirmClickListener onAffirmClickListener)
    {
        if (layoutId == -1)
        {
            layoutId = R.layout.dialog_xml;
        }
        final Dialog exitDialog =
            new CustomCenterDialog((Activity)context, R.style.transparentFrameWindowStyle, layoutId);
        exitDialog.show();
        View view = exitDialog.getWindow().getDecorView();
        view.setTag(exitDialog);
        TextView dialog_content = (TextView)view.findViewById(R.id.dialog_content);
        dialog_content.setText(content);
        ClickEffectButton cancel = (ClickEffectButton)view.findViewById(R.id.dialog_cancel);
        cancel.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                exitDialog.dismiss();
            }
        });
        ClickEffectButton confim = (ClickEffectButton)view.findViewById(R.id.dialog_confim);
        confim.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                if (onAffirmClickListener == null)
                {
                    exitDialog.dismiss();
                    ((Activity)context).finish();
                }
                else
                {
                    onAffirmClickListener.onClick(v, exitDialog);
                }
            }
        });
        return view;
    }
    
    /**
     * @Title: showDialogCenter 
     * @Description: TODO(是否需要放弃本次操作的dialog) 
     * @param activity
     * @param layoutId -1（默认 R.layout.dialog_xml）
     * @param content （默认 是否放弃本次编辑?）
     * @param onAffirmClickListener ==null，关闭Dialog&&关闭Activity。
     * @return View    返回类型 
     * @throws
     */
    public View showDialogCenter(final Context context, String content, String content2,
        final OnAffirmClickListener onAffirmClickListener)
    {
        final Dialog exitDialog =
            new CustomCenterDialog((Activity)context, R.style.transparentFrameWindowStyle, R.layout.dialog_xml);
        exitDialog.show();
        View view = exitDialog.getWindow().getDecorView();
        view.setTag(exitDialog);
        TextView dialog_content = (TextView)view.findViewById(R.id.dialog_content);
        TextView dialog_content2 = (TextView)view.findViewById(R.id.dialog_content_2);
        dialog_content.setText(content);
        dialog_content2.setText(content2);
        ClickEffectButton cancel = (ClickEffectButton)view.findViewById(R.id.dialog_cancel);
        cancel.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                exitDialog.dismiss();
            }
        });
        ClickEffectButton confim = (ClickEffectButton)view.findViewById(R.id.dialog_confim);
        confim.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                if (onAffirmClickListener == null)
                {
                    exitDialog.dismiss();
                    ((Activity)context).finish();
                }
                else
                {
                    onAffirmClickListener.onClick(v, exitDialog);
                }
            }
        });
        return view;
    }
    
    /**
     * @Title: showDialogCenter 
     * @Description: TODO(是否需要放弃本次操作的dialog) 
     * @param activity
     * @param layoutId -1（默认 R.layout.dialog_xml）
     * @param onAffirmClickListener ==null，关闭Dialog&&关闭Activity。
     * @param rightCharacter 修改右边的显示文字
     * @return View    返回类型 
     * @throws
     */
    public View showDialogCenter(final Context context, int layoutId, String content, String rightCharacter,
        final OnAffirmClickListener onAffirmClickListener)
    {
        if (layoutId == -1)
        {
            layoutId = R.layout.dialog_xml;
        }
        final Dialog exitDialog =
            new CustomCenterDialog((Activity)context, R.style.transparentFrameWindowStyle, layoutId);
        exitDialog.show();
        View view = exitDialog.getWindow().getDecorView();
        view.setTag(exitDialog);
        TextView dialog_content = (TextView)view.findViewById(R.id.dialog_content);
        if (!TextUtils.isEmpty(rightCharacter))
        {
            dialog_content.setText(content);
        }
        ClickEffectButton cancel = (ClickEffectButton)view.findViewById(R.id.dialog_cancel);
        cancel.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                exitDialog.dismiss();
            }
        });
        ClickEffectButton confim = (ClickEffectButton)view.findViewById(R.id.dialog_confim);
        confim.setText(rightCharacter);
        confim.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                if (onAffirmClickListener == null)
                {
                    exitDialog.dismiss();
                    ((Activity)context).finish();
                }
                else
                {
                    onAffirmClickListener.onClick(v, exitDialog);
                }
            }
        });
        return view;
    }
    
    /**
     * @Title: showEditDialogCenter 
     * @Description: TODO(弹出输入文字的Dialog) 
     * @param activity
     * @param layoutId -1（默认 dialog_center.xml）
     * @param inputType 输入的类型
     * @param content 标题
     * @param onAffirmClickListener ==null，关闭Dialog&&关闭Activity。
     * @return View    返回类型 
     * @throws
     */
    public View showEditDialogCenter(final Context context, int layoutId, int inputType, String title,
        final OnAffirmClickListener onAffirmClickListener)
    {
        if (layoutId == -1)
        {
            layoutId = R.layout.dialog_xml;
        }
        final Dialog exitDialog =
            new CustomCenterDialog((Activity)context, R.style.transparentFrameWindowStyle, layoutId);
        exitDialog.show();
        View view = exitDialog.getWindow().getDecorView();
        view.setTag(exitDialog);
        TextView dialog_content = (TextView)view.findViewById(R.id.tv_content);
        dialog_content.setText(title);
        final EditText tv_text = (EditText)view.findViewById(R.id.tv_text);
        tv_text.setInputType(inputType);
        Button cancel = (Button)view.findViewById(R.id.btn_no);
        cancel.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                exitDialog.dismiss();
            }
        });
        Button confim = (Button)view.findViewById(R.id.btn_ok);
        
        confim.setOnClickListener(new OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                v.setTag(tv_text.getText().toString());
                if (onAffirmClickListener == null)
                {
                    exitDialog.dismiss();
                    ((Activity)context).finish();
                }
                else
                {
                    onAffirmClickListener.onClick(v, exitDialog);
                }
            }
        });
        return view;
    }
    
    /**
     * 点击确定的回调
     * @FileName com.alnton.myframe.util.OnAffirmClickListener.java  
     * @Author 詹海
     * @Date 2016-8-20 下午2:26:34
     * @UpdateVersion V1.0
     */
    public interface OnAffirmClickListener
    {
        public void onClick(View v, Dialog dialog);
    }
    
    /**
     * 判断选择的时间是否大于等于当前时间7天
     * 7天：604800000 毫秒
     * @param selectDate: 选择的时间 
     * @return
     */
    public boolean isSevenDays(String selectDate)
    {
        long selectTime = MyFrameCoreTools.getInstance().formatTimeByYMD(selectDate);
        
        if (selectTime - System.currentTimeMillis() >= 604800000)
        {
            return true;
        }
        return false;
    }
    
    /**
     * 
    * @Title: isCorrectImageFormat 
    * @Description: TODO(判断上传图片是否大于5M，是否是   jpg ,png,jpeg格式) 
    * @param contextType            上下文的类型（FusionCode.BASEACTIVITY，FusionCode.BASEFRAGMENTACTIVITY）
    * @param @param path
    * @param @return    设定文件 
    * @return boolean    返回类型 
    * @throws
     */
    public boolean isCorrectImageFormat(Context mContext, int contextType, String path)
    {
        //  jpg ,png,jpeg
        double fileSize = FileUtil.getInstance().getFileOrFilesSize(path, 3);
        if (fileSize < FusionCode.getInstance().PIC_MAXSIZE)
        {
            String format = path.substring(path.lastIndexOf("."), path.length());
            if (format.equals(".jpg") || format.equals(".png") || format.equals(".jpeg"))
            {
                return true;
            }
            else
            {
                ToastUtil.instance.showToast(mContext, "请上传就jpg,png,jpeg格式的图片");
                return false;
            }
        }
        else
        {
            ToastUtil.instance.showToast(mContext, "上传图片不能大于" + FusionCode.getInstance().PIC_MAXSIZE + "M");
            return false;
        }
    }
    
    /**
     * 手机号中间四位用*加密
     * @param phoneNumber
     * @return
     */
    public String phoneEncode(String phoneNum)
    {
        if (!TextUtils.isEmpty(phoneNum) && phoneNum.length() == 11)
        {
            return phoneNum.substring(0, 3) + "****" + phoneNum.substring(7);
        }
        return SystemParamCfg.DEFAULT_EMPTY_VALUE;
    }
    
    /**
     * 银行卡后四位明文 其他用*加密
     * @param bankAccount
     * @return
     */
    public String bankAccountEncode(String bankAccount)
    {
        if (!TextUtils.isEmpty(bankAccount) && bankAccount.length() >= 4)
        {
            return "****" + "   " + "****" + "   " + "****" + "   " + bankAccount.substring(bankAccount.length() - 4);
        }
        return SystemParamCfg.DEFAULT_EMPTY_VALUE;
    }
}