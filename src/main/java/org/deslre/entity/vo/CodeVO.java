package org.deslre.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ClassName: CodeVO
 * Description: TODO
 * Author: Deslrey
 * Date: 2024-12-25 14:02
 * Version: 1.0
 */
@Data
@Builder
public class CodeVO {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 单词书的id
     */
    private Integer bookId;

    /**
     * 单词
     */
    private String word;

    /**
     * 翻译
     */
    private String trans;


    /**
     * 美式发音
     */
    private String amerPronoun;

    /**
     * 英式发音
     */
    private String britishPronoun;


}
