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
     * 单词数量
     */
    private Integer wordSum;

    /**
     * 添加日期
     */
    private LocalDateTime createTime;

    /**
     * 更新日期
     */
    private LocalDateTime updateTime;

    /**
     * 该单词书的描述
     */
    private String description;



}
