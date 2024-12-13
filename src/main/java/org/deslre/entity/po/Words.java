package org.deslre.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2024-12-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("words")
public class Words implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 单词
     */
    private String word;

    /**
     *  翻译
     */
    private String trans;

    /**
     * 美式发音
     */
    private String amerPronun;

    /**
     * 英式发音
     */
    private String britishPronun;

    /**
     * 词性变化
     */
    private String change;

    /**
     * 例句
     */
    private String examples;

    /**
     * 例句描述
     */
    private String exampleTrans;

    /**
     * 添加日期
     */
    private LocalDateTime createTime;

    /**
     * 修改日期
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    private Boolean exist;


}