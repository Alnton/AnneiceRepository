package com.alnton.myframe.util;

import java.util.regex.Pattern;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * 校验输入的字符是否合格 
 * @Author 詹海
 * @Date 2016-10-14 下午3:25:19
 * @Version V1.0
 */
public class ValidationUtil
{
    
    /**
     * 上下文
     */
    private Context context;
    
    /**
     * 标识这次的校验是否通过
     */
    private boolean isPass = true;
    
    /**
     * 是否是第一次显示提示框，（如果为false，则不显示提示框）
     */
    @SuppressWarnings("unused")
    private boolean isFirstShowToast = true;
    
    /**
     * 使用方式
     */
    private void testValidationUtil()
    {
        //手机号为11位数字
        String mobilePhone = "1563445";
        //姓名为字母或中文，并且在2到8位
        String name = "张三sss";
        //使用提示错误语
        new ValidationUtil(context).lengthNotZeroValidation(mobilePhone, "请输入手机号")
            .lengthValidation(mobilePhone, "请输入正确的手机号", 11, 11)
            .lengthNotZeroValidation(name, "请输入姓名")
            .lengthValidation(name, "请输入2到8位中文或字母", 2, 8)
            .includeCharChineseValidation(name, "请输入2到8位中文或字母")
            //通过正则校验
            .matcher(mobilePhone, "^((?!\\d+$).{5,16})+$", "请输入正确的手机号")
            .isPass();
    }
    
    /**
     * 显示错误提示
     * @param context
     */
    public ValidationUtil(Context context)
    {
        this.context = context;
    }
    
    /**
     * 不显示错误提示
     * @param context
     */
    public ValidationUtil()
    {
    }
    
    /**
     * @Description: 传入正则表达式，做校验 
     * @param content 内容
     * @param canonical 正则表达式
     * @param errorHint 错误的提示
     * @return
     */
    public ValidationUtil matcher(String content, String canonical, String errorHint)
    {
        //正则
        Pattern regular = Pattern.compile(canonical);
        //是否通过正则
        if (regular.matcher(content).matches())
        {
            this.isPass = true;
        }
        else
        {
            showErrorHint(errorHint);
        }
        return this;
    }
    
    /**
     * @Description: 长度校验（content去掉空格 并且 content==null ? "" : content）
     * @param content 内容 
     * @param errorHint 错误的提示语
     * @param isTrim 是否去掉空格
     * @param isNull 是否对null处理(false：content==null时，不做任何处理)
     * @return
     */
    public ValidationUtil lengthNotZeroValidation(String content, String errorHint, boolean isTrim, boolean isNull)
    {
        if (isNull)
        {//对null的处理
            content = content == null ? "" : content;
        }
        if (null != content && this.isPass)
        {//只要有一个校验不通过，后面的校验就不走了。
            if (isTrim)
            {//去掉空格
                content = content.replace(" ", "");
            }
            int contentLength = content.length();
            if (contentLength == 0)
            {
                showErrorHint(errorHint);
            }
            else
            {
                this.isPass = true;
            }
        }
        return this;
    }
    
    /**
     * @Description: 长度校验（content去掉空格 并且 content==null ? "" : content）
     * @param content 内容 
     * @param errorHint 错误的提示语
     * @param isTrim 是否去掉空格
     * @return
     */
    public ValidationUtil lengthNotZeroValidation(String content, String errorHint)
    {
        if (this.isPass)
        {//只要有一个校验不通过，后面的校验就不走了。
            content = content == null ? "" : content;
            content = content.replace(" ", "");
            int contentLength = content.length();
            if (contentLength == 0)
            {
                showErrorHint(errorHint);
            }
            else
            {
                this.isPass = true;
            }
        }
        return this;
    }
    
    /**
     * @Description: 长度校验 (content==null时，不做任何处理)
     * @param content 内容 
     * @param errorHint 错误的提示语
     * @param minLength 最小长度
     * @param maxLength 最大长度
     * @return
     */
    public ValidationUtil lengthValidation(String content, String errorHint, int minLength, int maxLength)
    {
        if (null != content && this.isPass)
        {//只要有一个校验不通过，后面的校验就不走了。
            int contentLength = content.length();
            if (contentLength >= minLength && contentLength <= maxLength)
            {
                this.isPass = true;
            }
            else
            {
                showErrorHint(errorHint);
            }
        }
        return this;
    }
    
    /**
     * @Description: 长度校验 (content==null时，不做任何处理)
     * @param content 内容
     * @param errorHint 错误的提示语
     * @param minLength 最小长度
     * @return
     */
    public ValidationUtil lengthValidation(String content, String errorHint, int minLength)
    {
        if (null != content && this.isPass)
        {//只要有一个校验不通过，后面的校验就不走了。
            int contentLength = content.length();
            if (contentLength >= minLength)
            {
                this.isPass = true;
            }
            else
            {
                showErrorHint(errorHint);
            }
        }
        return this;
    }
    
    /**
     * @Description: 类型校验，只包含 数字、字母、中文 (content==null时，不做任何处理)
     * @param content 内容
     * @param errorHint 错误的提示语
     * @return
     */
    public ValidationUtil includeNumCharChineseValidation(String content, String errorHint)
    {
        if (null != content && this.isPass)
        {//只要有一个校验不通过，后面的校验就不走了。
            //数字
            content = Pattern.compile("[0-9]*").matcher(content).replaceAll("");
            //字母
            content = Pattern.compile("[a-zA-Z]").matcher(content).replaceAll("");
            //中文
            content = Pattern.compile("[\u4e00-\u9fa5]").matcher(content).replaceAll("");
            if (TextUtils.isEmpty(content))
            {
                this.isPass = true;
            }
            else
            {
                showErrorHint(errorHint);
            }
        }
        return this;
    }
    
    /**
     * @Description: 类型校验，只包含 字母、中文 (content==null时，不做任何处理)
     * @param content 内容
     * @param errorHint 错误的提示语
     * @return
     */
    public ValidationUtil includeCharChineseValidation(String content, String errorHint)
    {
        if (null != content && this.isPass)
        {//只要有一个校验不通过，后面的校验就不走了。
            //字母
            content = Pattern.compile("[a-zA-Z]").matcher(content).replaceAll("");
            //中文
            content = Pattern.compile("[\u4e00-\u9fa5]").matcher(content).replaceAll("");
            if (TextUtils.isEmpty(content))
            {
                this.isPass = true;
            }
            else
            {
                showErrorHint(errorHint);
            }
        }
        return this;
    }
    
    /**
     * @Description: 类型校验，只包含 中文 (content==null时，不做任何处理)
     * @param content 内容
     * @param errorHint 错误的提示语
     * @return
     */
    public ValidationUtil includeChineseValidation(String content, String errorHint)
    {
        if (null != content && this.isPass)
        {//只要有一个校验不通过，后面的校验就不走了。
            //中文
            content = Pattern.compile("[\u4e00-\u9fa5]").matcher(content).replaceAll("");
            if (TextUtils.isEmpty(content))
            {
                this.isPass = true;
            }
            else
            {
                showErrorHint(errorHint);
            }
        }
        return this;
    }
    
    /**
     * @Description: 类型校验，只包含 数字、字母 (content==null时，不做任何处理)
     * @param content 内容
     * @param errorHint 错误的提示语
     * @return
     */
    public ValidationUtil includeNumCharValidation(String content, String errorHint)
    {
        if (null != content && this.isPass)
        {//只要有一个校验不通过，后面的校验就不走了。
            //数字
            content = Pattern.compile("[0-9]*").matcher(content).replaceAll("");
            //字母
            content = Pattern.compile("[a-zA-Z]").matcher(content).replaceAll("");
            if (TextUtils.isEmpty(content))
            {
                this.isPass = true;
            }
            else
            {
                showErrorHint(errorHint);
            }
        }
        return this;
    }
    
    /**
     * @Description: 校验是否通过
     * @return
     */
    public boolean isPass()
    {
        return isPass;
    }
    
    /**
     * @Description: 显示提示 
     * @param errorHint 提示语
     */
    private void showErrorHint(String errorHint)
    {
        if (!TextUtils.isEmpty(errorHint) && null != context)
        {
            this.isFirstShowToast = false;
            this.isPass = false;
            Toast.makeText(context, errorHint, 0).show();
        }
    }
    
}
