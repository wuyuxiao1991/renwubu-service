//package com;
//
//
//import org.springframework.util.StringUtils;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import static java.util.regex.Pattern.compile;
//import static org.apache.logging.log4j.util.Strings.isBlank;
//
///**
// * @author wuyuxiao
// */
//public class SQlToEntityTool {
//    private String packageOutPath = "com.persistence.entity";//指定实体生成所在包的路径
//    private String authorName = "wuyuxiao";//作者名字
//    private String[] colnames; // 列名数组
//    private String[] original_colnames; // 列名数组
//    private String[] colTypes; //列名类型数组
//    private int[] colSizes; //列名大小数组
//    private Map comment;     //字段注释
//    private boolean f_util = true; // 是否需要导入包java.util.*
//    private boolean f_sql = true; // 是否需要导入包java.sql.*
//
//    //数据库连接
//    private static final String URL = "jdbc:mysql://localhost:3306/new_schema_1?serverTimezone=Asia/Shanghai&characterEncoding=utf8&autoReconnect=true";
//    private static final String NAME = "wuyuxiao";
//    private static final String PASS = "mysql";
//    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//
//    /*
//     * 构造函数
//     */
//    public SQlToEntityTool(String tablename) {
//
//        //创建连接
//        Connection con = null;
//        //查要生成实体类的表
//        String sql = "select * from " + tablename;
//        PreparedStatement pStemt = null;
//        PreparedStatement pStemt2 = null;
//        try {
//            try {
//                Class.forName(DRIVER);
//            } catch (ClassNotFoundException e1) {
//                e1.printStackTrace();
//            }
//            con = DriverManager.getConnection(URL, NAME, PASS);
//            pStemt = con.prepareStatement(sql);
//            ResultSetMetaData rsmd = pStemt.getMetaData();
//            int size = rsmd.getColumnCount();    //统计列
//            colnames = new String[size];
//            original_colnames = new String[size];
//            colTypes = new String[size];
//            colSizes = new int[size];
//            for (int i = 0; i < size; i++) {
//                original_colnames[i] = rsmd.getColumnName(i + 1);
//                colnames[i] = camelize(rsmd.getColumnName(i + 1));
//                colTypes[i] = rsmd.getColumnTypeName(i + 1);
//
//                if (colTypes[i].equalsIgnoreCase("datetime")) {
//                    f_util = true;
//                }
//                if (colTypes[i].equalsIgnoreCase("image") || colTypes[i].equalsIgnoreCase("text")) {
//                    f_sql = true;
//                }
//                colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
//            }
//
//            //获取数据库字段注释
//            String commentSql = " show full fields from " + tablename;
//            comment = new HashMap();
//            pStemt2 = con.prepareStatement(commentSql);
//            ResultSet rs2 = pStemt2.executeQuery();
//            while (rs2.next()) {
//                String comm = rs2.getString("Comment");
//                if (null != comm && !comm.equals("")) {
//                    System.out.println(comm);
//                    comment.put(rs2.getString("Field"), camelize(comm));
//                } else {
//                    comment.put(rs2.getString("Field"), camelize(rs2.getString("Field")));
//                }
//            }
//            System.out.println(comment);
//            String content = parse(colnames, colTypes, colSizes, tablename);
//
//            try {
//                File directory = new File("");
//                //自定义的实体类的目录domain/pojo/entity都行
//                String outputPath = directory.getAbsolutePath() + "\\src\\main\\java\\" + this.packageOutPath.replace(".", "\\") + "\\";
//                File file = new File(outputPath);
//                file.mkdirs();
//                FileWriter fw = new FileWriter(outputPath + StringUtils.capitalize(camelize(tablename)) + ".java");
//                PrintWriter pw = new PrintWriter(fw);
//                pw.println(content);
//                pw.flush();
//                pw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * 功能：生成实体类主体代码
//     *
//     * @param colnames
//     * @param colTypes
//     * @param colSizes
//     * @return
//     */
//    private String parse(String[] colnames, String[] colTypes, int[] colSizes, String tablename) {
//        StringBuffer sb = new StringBuffer();
//        sb.append("package " + this.packageOutPath + ";\r\n");
//        sb.append("\r\n");
//        //判断是否导入工具包
//        if (f_util) {
//            sb.append("import java.util.Date;\r\n");
//        }
//        if (f_sql) {
//            sb.append("import java.sql.*;\r\n");
//            sb.append("import lombok.Data;\r\n");
//            sb.append("import lombok.AllArgsConstructor;\r\n");
//            sb.append("import lombok.NoArgsConstructor;\r\n");
//            sb.append("import lombok.AllArgsConstructor;\r\n");
//            sb.append("import com.baomidou.mybatisplus.annotation.TableField;\r\n");
//            sb.append("import com.baomidou.mybatisplus.annotation.TableName;\r\n");
//
//        }
//        //注释部分
//        sb.append("\r\n");
//        sb.append("/**\r\n");
//        sb.append(" * " + tablename + " 实体类\r\n");
//        sb.append(" * " + getSysdate() + " " + this.authorName + "\r\n");
//        sb.append(" */ \r\n");
//        //实体部分
//        sb.append("\r\n");
//        sb.append("@Data\n");
//        sb.append("@NoArgsConstructor\n");
//        sb.append("@AllArgsConstructor\n");
//        sb.append("@TableName(\"" + tablename + "\")" + "\n");
//        sb.append("public class " + StringUtils.capitalize(camelize(tablename)) + " {\r\n");
//        processAllAttrs(sb);//属性
//        sb.append("}\r\n");
//
//        return sb.toString();
//    }
//
//    /**
//     * 功能：生成所有属性
//     *
//     * @param sb
//     */
//    private void processAllAttrs(StringBuffer sb) {
//
//        for (int i = 0; i < colnames.length; i++) {
//            sb.append("\r\n");
//            sb.append("\t@TableField(value = \"" + original_colnames[i] + "\")" + "\r\n");
//            sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " " + colnames[i] + ";" + " \r\n");
//        }
//
//    }
//
//
//    /**
//     * 功能：获得列的数据类型
//     *
//     * @param sqlType
//     * @return
//     */
//    private String sqlType2JavaType(String sqlType) {
//
//        if (sqlType.equalsIgnoreCase("bit")) {
//            return "boolean";
//        } else if (sqlType.equalsIgnoreCase("tinyint")) {
//            return "byte";
//        } else if (sqlType.equalsIgnoreCase("smallint")) {
//            return "short";
//        } else if (sqlType.equalsIgnoreCase("int")) {
//            return "int";
//        } else if (sqlType.equalsIgnoreCase("bigint")) {
//            return "long";
//        } else if (sqlType.equalsIgnoreCase("float")) {
//            return "float";
//        } else if (sqlType.equalsIgnoreCase("decimal") || sqlType.equalsIgnoreCase("numeric")
//                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
//                || sqlType.equalsIgnoreCase("smallmoney") || sqlType.equalsIgnoreCase("double")) {
//            return "double";
//        } else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
//                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
//                || sqlType.equalsIgnoreCase("text") || sqlType.equalsIgnoreCase("longtext")) {
//            return "String";
//        } else if (sqlType.equalsIgnoreCase("datetime") || sqlType.equalsIgnoreCase("timestamp")) {
//            return "Date";
//        } else if (sqlType.equalsIgnoreCase("image")) {
//            return "Blod";
//        }
//
//        return null;
//    }
//
//    /**
//     * 获取系统当前时间
//     *
//     * @param
//     * @return
//     * @explain 使用Date实现
//     */
//    public static String getSysdate() {
//        Date date = new Date(System.currentTimeMillis());
//        return date.toString();
//    }
//
//
//    /**
//     * 数据表字段名转换为驼峰式名字的实体类属性名
//     *
//     * @param tabAttr 数据表字段名
//     * @return 转换后的驼峰式命名
//     */
//    public static String camelize(String tabAttr) {
//        if (isBlank(tabAttr)) {
//            return tabAttr;
//        }
//        Pattern pattern = compile("(.*)_(\\w)(.*)");
//        Matcher matcher = pattern.matcher(tabAttr);
//        if (matcher.find()) {
//            return camelize(matcher.group(1) + matcher.group(2).toUpperCase() + matcher.group(3));
//        } else {
//            return tabAttr;
//        }
//    }
//
//    /**
//     * 执行方法
//     * /* @param args
//     */
//    public static void main(String[] args) {
//
//        //tabesNames的数据是通过准备工作的第4步得来的
//        String tableNames[] = {
//                "arms_equipment_registration",
//                "base_armed_institution_registration",
//                "emergency_equipment_registration",
//                "military_and_civilian_equipment_registration",
//                "military_service_registration",
//                "military_strength_guarantee",
//                "military_strength_plan",
//                "military_strength_registration",
//                "minbing_leader_registration",
//                "people_detail",
//                "pre_built_party_organization",
//                "team_detail",
//                "training_mission_details",
//                "yearly_plan_details",
//                "zhuanwu_leader_registration"
//        };
//
//        for (String t : tableNames) {
//            new SQlToEntityTool(t);//for循环批量去产生java实体类
//        }
//    }
//}