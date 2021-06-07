package cn.exrick.xboot.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author chenfeixiang6@163.com
 * @date 2021/6/7
 * @desc
 */
@Data
public class BaseReqVO {
    @ApiModelProperty(value = "唯一标识")
    private String id ;
    @ApiModelProperty(value = "唯一标识")
    private List<String> ids ;
}
