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
@TableName("middle_link")
public class MiddleLink implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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

    /**
     * 是否删除
     */
    private Boolean exist;


}
