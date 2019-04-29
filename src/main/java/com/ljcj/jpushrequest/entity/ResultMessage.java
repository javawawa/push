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
public class ResultMessage<D> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 固定为20000，代表成功
     *
     * @return code
     **/
    @ApiModelProperty(example = "20000", value = "固定为20000，代表成功")
    @JsonProperty("code")
    private Integer code = null;
    /**
     * 成功的消息，以后台返回为准
     *
     * @return message
     **/
    @ApiModelProperty(value = "成功的消息，以后台返回为准")
    @JsonProperty("message")
    private String message = null;

    @JsonProperty("data")
    private D data = null;

    @JsonProperty("token")
    private String token ;
}

