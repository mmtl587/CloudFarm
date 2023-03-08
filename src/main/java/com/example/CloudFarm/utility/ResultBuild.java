package com.example.CloudFarm.utility;



import com.example.CloudFarm.enums.HttpStatus;

import java.util.HashMap;


public class ResultBuild extends HashMap<String, Object>{
	private static final long serialVersionUID = 1L;

    public static final String CODE_TAG = "code";

    public static final String MSG_TAG = "msg";

    public static final String DATA_TAG = "data";

    /**
     */
    public ResultBuild()
    {
    }


    public ResultBuild(int code, String msg)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
    }


    public ResultBuild(int code, String msg, Object data)
    {
        super.put(CODE_TAG, code);
        super.put(MSG_TAG, msg);
        if (StringUtils.isNotNull(data))
        {
            super.put(DATA_TAG, data);
        }
    }


    public static ResultBuild success()
    {
        return ResultBuild.success("操作成功");
    }

    public static ResultBuild success(Object data)
    {
        return ResultBuild.success("操作成功", data);
    }

    public static ResultBuild success(String msg)
    {
        return ResultBuild.success(msg, null);
    }

    public static ResultBuild success(String msg, Object data)
    {
        return new ResultBuild(HttpStatus.SUCCESS.getCode(), msg, data);
    }

    public static ResultBuild error()
    {
        return ResultBuild.error("操作失败");
    }

    public static ResultBuild error(String msg)
    {
        return ResultBuild.error(msg, null);
    }

    public static ResultBuild error(String msg, Object data)
    {
        return new ResultBuild(HttpStatus.ERROR.getCode(), msg, data);
    }


    public static ResultBuild error(int code, String msg, Object data)
    {
        return new ResultBuild(code, msg, data);
    }


    public static ResultBuild error(int code, String msg)
    {
        return new ResultBuild(code, msg, null);
    }


    @Override
    public ResultBuild put(String key, Object value)
    {
        super.put(key, value);
        return this;
    }
}
