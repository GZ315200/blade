package unistack.bean;

import java.io.Serializable;
import java.util.Objects;

public class ColumnInfo implements Serializable {
    private String tableName;           //表名
    private String tableSchem;          //数据库用户
    private String tableCat;            //数据库目录
    private String columnName;          //列名
    private Integer dataType;           //数据类型
    private String typeName;            //数据类型名称
    private Integer  columnSize;        //列长
    private String isNullable;         //yes 可为空 no 不为空
    private String remarks;             //备注
    private String columnDef;           //列默认值
    private String dbType;           //数据库类型
    private boolean isPrimaryKey;     //yes 自增 no 不自增 empty string 不能判断其是否自

    public ColumnInfo() {
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableSchem() {
        return tableSchem;
    }

    public void setTableSchem(String tableSchem) {
        this.tableSchem = tableSchem;
    }

    public String getTableCat() {
        return tableCat;
    }

    public void setTableCat(String tableCat) {
        this.tableCat = tableCat;
    }

    public String getColumnName() { return columnName; }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getColumnSize() {
        return columnSize;
    }

    public void setColumnSize(Integer columnSize) {
        this.columnSize = columnSize;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getColumnDef() {
        return columnDef;
    }

    public void setColumnDef(String columnDef) {
        this.columnDef = columnDef;
    }

    public String getDbType() { return dbType; }

    public void setDbType(String dbType) { this.dbType = dbType; }

    public boolean isPrimaryKey() { return isPrimaryKey; }

    public void setPrimaryKey(boolean primaryKey) { isPrimaryKey = primaryKey; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnInfo that = (ColumnInfo) o;
        return Objects.equals(tableName, that.tableName) &&
                Objects.equals(tableSchem, that.tableSchem) &&
                Objects.equals(tableCat, that.tableCat) &&
                Objects.equals(columnName, that.columnName) &&
                Objects.equals(dataType, that.dataType) &&
                Objects.equals(typeName, that.typeName) &&
                Objects.equals(columnSize, that.columnSize) &&
                Objects.equals(isNullable, that.isNullable) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(columnDef, that.columnDef) &&
                Objects.equals(isPrimaryKey, that.isPrimaryKey);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tableName, tableSchem, tableCat, columnName, dataType, typeName, columnSize, isNullable, remarks, columnDef, isPrimaryKey);
    }

    @Override
    public String toString() {
        return "ColumnMetadata{" +
                "tableName='" + tableName + '\'' +
                ", tableSchem='" + tableSchem + '\'' +
                ", tableCat='" + tableCat + '\'' +
                ", columnName='" + columnName + '\'' +
                ", dataType=" + dataType +
                ", typeName='" + typeName + '\'' +
                ", columnSize=" + columnSize +
                ", isNullable=" + isNullable +
                ", remarks='" + remarks + '\'' +
                ", columnDef='" + columnDef + '\'' +
                ", isPrimaryKey='" + isPrimaryKey + '\'' +
                ", dbType='" + dbType + '\'' +
                '}';
    }
}
