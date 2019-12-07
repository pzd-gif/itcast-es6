package com.zs.lianxi.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 准驾车型表
 * </p>
 *
 * @author guanyu
 * @since 2019-11-23
 */
public class TDriverType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("code")
    private String code;

    /**
     * 准驾名称
     */
    @TableField("name")
    private String name;

    /**
     * 准驾其它车型
     */
    @TableField("include")
    private String include;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getInclude() {
        return include;
    }

    public void setInclude(String include) {
        this.include = include;
    }

    @Override
    public String toString() {
        return "TDriverType{" +
            "code=" + code +
            ", name=" + name +
            ", include=" + include +
        "}";
    }
}
