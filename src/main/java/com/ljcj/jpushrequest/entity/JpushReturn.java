package com.ljcj.jpushrequest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-11-06T05:54:42.280Z[GMT]")
@Getter
@Setter
@Accessors(chain = true)
@ToString
public class JpushReturn implements Serializable {
    @ApiModelProperty(example = "20000", value = "固定为20000，代表成功")
    @JsonProperty("sendno")
    private Integer sendno = null;

    @ApiModelProperty(example = "38280599346108719", value = "请求的id")
    @JsonProperty("msg_id")
    private String msg_id = null;
    /**
     * 成功的消息，以后台返回为准
     *
     * @return message
     **/
    @ApiModelProperty(value = "后台返回的消息")
    @JsonProperty("message")
    private String message = null;

    @ApiModelProperty(value = "错误的信息")
    @JsonProperty("error")
    private ErrorMessage error = null;



}
