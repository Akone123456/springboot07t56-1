package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @author lxw
 */
@Data
@TableName("face_data")
public class FaceDataEntity {

    /**
     * 用户id
     */
    private Long id;
    /**
     * 人脸特征值
     */
    private byte[] faceData;
}
