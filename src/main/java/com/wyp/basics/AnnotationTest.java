package com.wyp.basics;

import com.sun.deploy.util.StringUtils;
import lombok.Data;
import org.checkerframework.checker.units.qual.C;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface Table{
    String value() default "";
}

@Inherited
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface Column{
    String value() default "";
}

@Table("Student")
@Data
class StudentDto{
    @Column("i_d")
    private String id;

    @Column("user_name")
    private String name;

    public StudentDto(String id, String name){
        super();
        this.id = id;
        this.name = name;
    }

}

public class AnnotationTest {
    public static void main(String[] args) {
        StudentDto studentDto1 = new StudentDto("1", "qiqi");
        StudentDto studentDto2 = new StudentDto("2", "yangyang, yp");
        String sql1 = assembleSqlFromObj(studentDto1);
        String sql2 = assembleSqlFromObj(studentDto2);
        System.out.println("sql1 = " + sql1);
        System.out.println("sql2 = " + sql2);        
    }

    private static String assembleSqlFromObj(Object object) {
        Table table = object.getClass().getAnnotation(Table.class);
        String tableName = table.value();
        StringBuilder sbSql = new StringBuilder();
        sbSql.append("select * from " + tableName + " where 1 = 1 ");
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field f : fields){
            String fieldName = f.getName();
            String methodName = "get" + fieldName.substring(0,1).toUpperCase()
                + fieldName.substring(1);
            try{
                Column column = f.getAnnotation(Column.class);
                if(column != null){
                    Method method = object.getClass().getMethod(methodName);
                    String value = (String)method.invoke(object);
                    System.out.println("value = " + value);
                    if(value != null && !"".equals(value)){
                        if(!isNum(value) && !isNum(column.value())){
                            if(value.contains(",")) {
                                sbSql.append(" and " + column.value() + " in (" + value + ") ");
                            } else {
                                sbSql.append(" and " + column.value() + " like '%" + value +"%' ");
                            }
                        } else {
                            sbSql.append(" and " + column.value() + " = " + value + " ");
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sbSql.toString();
    }

    private static boolean isNum(String target){
        boolean isNum = false;
        if(target.toLowerCase().contains("id")) {
            System.out.println("isNum id:" + target);
            isNum = true;
        }
        if(target.matches("\\d+")){
            System.out.println("isNum regex:" + target);
            isNum = true;
        }
        return isNum;
    }
}
