package org.deslre.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ClassName: WordsVO
 * Description: TODO
 * Author: Deslrey
 * Date: 2024-12-14 22:57
 * Version: 1.0
 */
@Data
@Builder
public class WordsVO {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 书籍id
     */
    private Integer bookId;

    /**
     * 单词
     */
    private String word;

    /**
     * 符号
     */
    private String notation;

    /**
     * 翻译
     */
    private String trans;

    /**
     * 除英语以外的语言发音
     */
    private String pronounce;

    /**
     * 美式发音
     */
    private String amerPronoun;

    /**
     * 英式发音
     */
    private String britishPronoun;

    /**
     * 添加日期
     */
    private LocalDateTime createTime;

    /**
     * 修改日期
     */
    private LocalDateTime updateTime;


}
