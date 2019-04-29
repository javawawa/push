package com.ljcj.jpushrequest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.Objects;

/**
 * ErrorMessage
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2018-11-06T05:54:42.280Z[GMT]")

public class ErrorMessage  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("code")
  private Integer code = null;

  @JsonProperty("message")
  private String message = null;

  public ErrorMessage code(Integer code) {
    this.code = code;
    return this;
  }

  /**
   * 通用错误信息： <div>40400->请求的资源不存在</div> <div>40300->没有对应的资源的访问权限</div>
   * @return code
  **/
  @ApiModelProperty(example = "40400", value = "通用错误信息： <div>40400->请求的资源不存在</div> <div>40300->没有对应的资源的访问权限</div>")


  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public ErrorMessage message(String message) {
    this.message = message;
    return this;
  }

  /**
   * 错误消息，以后台返回的数据为准
   * @return message
  **/
  @ApiModelProperty(example = "请求的页面不存在", value = "错误消息，以后台返回的数据为准")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorMessage errorMessage = (ErrorMessage) o;
    return Objects.equals(this.code, errorMessage.code) &&
        Objects.equals(this.message, errorMessage.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorMessage {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

