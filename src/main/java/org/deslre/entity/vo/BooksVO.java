package org.deslre.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ClassName: BooksVO
 * Description: TODO
 * Author: Deslrey
 * Date: 2024-12-14 22:40
 * Version: 1.0
 */
@Data
@Builder
public class BooksVO {


    /**
     * 主键
     */
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


}
