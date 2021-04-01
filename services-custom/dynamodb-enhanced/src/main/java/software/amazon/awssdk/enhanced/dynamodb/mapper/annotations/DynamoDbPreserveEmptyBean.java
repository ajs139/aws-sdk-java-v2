/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.enhanced.dynamodb.mapper.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;
import software.amazon.awssdk.annotations.SdkPublicApi;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

/**
 * Class level annotation that specifies that when calling {@link TableSchema#mapToItem(Map)},
 * this class should be initialized as empty class if all fields in this class are null
 *
 * <p>
 * eg:
 * <pre>
 *     {@code
 * @DynamoDbBean
 * @DynamoDbPreserveEmptyBean
 * public class SimpleBean {
 *     private String id;
 *
 *     public String getId() {
 *         return this.id;
 *     }
 *     public void setId(String id) {
 *         this.id = id;
 *     }
 *
 *    @Override
 *     public boolean equals(Object o) {
 *         if (this == o) return true;
 *         if (o == null || getClass() != o.getClass()) return false;
 *         SimpleBean that = (SimpleBean) o;
 *         return Objects.equals(id, that.id);
 *     }
 *
 *     @Override
 *     public int hashCode() {
 *         return Objects.hash(id);
 *     }
 *  }
 *
 *  BeanTableSchema<SimpleBean> beanTableSchema =
 *         BeanTableSchema.create(SimpleBean.class);
 *  SimpleBean bean = new SimpleBean();
 *  assertEquals(bean, beanTableSchema.mapToItem(beanTableSchema.itemToMap(bean, true));
 * </pre>
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@SdkPublicApi
public @interface DynamoDbPreserveEmptyBean {
}
