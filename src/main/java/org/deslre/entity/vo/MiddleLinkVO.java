package org.deslre.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ClassName: MiddleLinkVO
 * Description: TODO
 * Author: Deslrey
 * Date: 2024-12-14 22:42
 * Version: 1.0
 */
@Data
@Builder
public class MiddleLinkVO {


    /**
     * 主键
     */
    private Integer id;

    /**
     * 书的id
     */
    private Integer bookId;

    /**
     * 单词的id
     */
    private Integer wordId;

    /**
     * 添加日期
     */
    private LocalDateTime createTime;

    /**
     * 修改日期
     */
    private LocalDateTime updateTime;


}
