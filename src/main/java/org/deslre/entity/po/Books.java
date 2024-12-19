package org.deslre.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Builder;
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
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("books")
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 分类
     */
    private String category;

    /**
     * 该单词书的描述
     */
    private String description;

    /**
     * 标签分类
     */
    private String tags;

    /**
     * 单词数量
     */
    private Integer wordSum;

    /**
     * 语言归属
     */
    private String language;

    /**
     * 语言分类
     */
    private String languageCategory;

    /**
     * 添加日期
     */
    private LocalDateTime createTime;

    /**
     * 更新日期
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除 (1: 存在, 0: 删除)
     */
    private Boolean exist;

}
